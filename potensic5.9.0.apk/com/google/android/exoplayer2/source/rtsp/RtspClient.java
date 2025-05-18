package com.google.android.exoplayer2.source.rtsp;

import android.net.Uri;
import android.os.Handler;
import android.util.SparseArray;
import com.google.android.exoplayer2.C0858C;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.source.rtsp.RtspClient;
import com.google.android.exoplayer2.source.rtsp.RtspHeaders;
import com.google.android.exoplayer2.source.rtsp.RtspMediaPeriod;
import com.google.android.exoplayer2.source.rtsp.RtspMediaSource;
import com.google.android.exoplayer2.source.rtsp.RtspMessageChannel;
import com.google.android.exoplayer2.source.rtsp.RtspMessageUtil;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableListMultimap;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Iterables;
import java.io.Closeable;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.net.SocketFactory;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes.dex */
final class RtspClient implements Closeable {
    private static final long DEFAULT_RTSP_KEEP_ALIVE_INTERVAL_MS = 30000;
    private boolean hasUpdatedTimelineAndTracks;
    private KeepAliveMonitor keepAliveMonitor;
    private final PlaybackEventListener playbackEventListener;
    private boolean receivedAuthorizationRequest;
    private final RtspMessageUtil.RtspAuthUserInfo rtspAuthUserInfo;
    private RtspAuthenticationInfo rtspAuthenticationInfo;
    private String sessionId;
    private final SessionInfoListener sessionInfoListener;
    private final Uri uri;
    private final String userAgent;
    private final ArrayDeque<RtspMediaPeriod.RtpLoadInfo> pendingSetupRtpLoadInfos = new ArrayDeque<>();
    private final SparseArray<RtspRequest> pendingRequests = new SparseArray<>();
    private final MessageSender messageSender = new MessageSender();
    private long pendingSeekPositionUs = C0858C.TIME_UNSET;
    private RtspMessageChannel messageChannel = new RtspMessageChannel(new MessageListener());

    public interface PlaybackEventListener {
        void onPlaybackError(RtspMediaSource.RtspPlaybackException rtspPlaybackException);

        void onPlaybackStarted(long j, ImmutableList<RtspTrackTiming> immutableList);

        void onRtspSetupCompleted();
    }

    public interface SessionInfoListener {
        void onSessionTimelineRequestFailed(String str, Throwable th);

        void onSessionTimelineUpdated(RtspSessionTiming rtspSessionTiming, ImmutableList<RtspMediaTrack> immutableList);
    }

    public RtspClient(SessionInfoListener sessionInfoListener, PlaybackEventListener playbackEventListener, String str, Uri uri) {
        this.sessionInfoListener = sessionInfoListener;
        this.playbackEventListener = playbackEventListener;
        this.uri = RtspMessageUtil.removeUserInfo(uri);
        this.rtspAuthUserInfo = RtspMessageUtil.parseUserInfo(uri);
        this.userAgent = str;
    }

    public void start() throws IOException {
        try {
            this.messageChannel.open(getSocket(this.uri));
            this.messageSender.sendOptionsRequest(this.uri, this.sessionId);
        } catch (IOException e) {
            Util.closeQuietly(this.messageChannel);
            throw e;
        }
    }

    public void setupSelectedTracks(List<RtspMediaPeriod.RtpLoadInfo> list) {
        this.pendingSetupRtpLoadInfos.addAll(list);
        continueSetupRtspTrack();
    }

    public void startPlayback(long j) {
        this.messageSender.sendPlayRequest(this.uri, j, (String) Assertions.checkNotNull(this.sessionId));
    }

    public void seekToUs(long j) {
        this.messageSender.sendPauseRequest(this.uri, (String) Assertions.checkNotNull(this.sessionId));
        this.pendingSeekPositionUs = j;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        KeepAliveMonitor keepAliveMonitor = this.keepAliveMonitor;
        if (keepAliveMonitor != null) {
            keepAliveMonitor.close();
            this.keepAliveMonitor = null;
            this.messageSender.sendTeardownRequest(this.uri, (String) Assertions.checkNotNull(this.sessionId));
        }
        this.messageChannel.close();
    }

    public void retryWithRtpTcp() {
        try {
            close();
            RtspMessageChannel rtspMessageChannel = new RtspMessageChannel(new MessageListener());
            this.messageChannel = rtspMessageChannel;
            rtspMessageChannel.open(getSocket(this.uri));
            this.sessionId = null;
            this.receivedAuthorizationRequest = false;
            this.rtspAuthenticationInfo = null;
        } catch (IOException e) {
            this.playbackEventListener.onPlaybackError(new RtspMediaSource.RtspPlaybackException(e));
        }
    }

    public void registerInterleavedDataChannel(int i, RtspMessageChannel.InterleavedBinaryDataListener interleavedBinaryDataListener) {
        this.messageChannel.registerInterleavedBinaryDataListener(i, interleavedBinaryDataListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void continueSetupRtspTrack() {
        RtspMediaPeriod.RtpLoadInfo pollFirst = this.pendingSetupRtpLoadInfos.pollFirst();
        if (pollFirst == null) {
            this.playbackEventListener.onRtspSetupCompleted();
        } else {
            this.messageSender.sendSetupRequest(pollFirst.getTrackUri(), pollFirst.getTransport(), this.sessionId);
        }
    }

    private static Socket getSocket(Uri uri) throws IOException {
        Assertions.checkArgument(uri.getHost() != null);
        return SocketFactory.getDefault().createSocket((String) Assertions.checkNotNull(uri.getHost()), uri.getPort() > 0 ? uri.getPort() : 554);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchRtspError(Throwable th) {
        RtspMediaSource.RtspPlaybackException rtspPlaybackException;
        if (th instanceof RtspMediaSource.RtspPlaybackException) {
            rtspPlaybackException = (RtspMediaSource.RtspPlaybackException) th;
        } else {
            rtspPlaybackException = new RtspMediaSource.RtspPlaybackException(th);
        }
        if (this.hasUpdatedTimelineAndTracks) {
            this.playbackEventListener.onPlaybackError(rtspPlaybackException);
        } else {
            this.sessionInfoListener.onSessionTimelineRequestFailed(Strings.nullToEmpty(th.getMessage()), th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean serverSupportsDescribe(List<Integer> list) {
        return list.isEmpty() || list.contains(2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ImmutableList<RtspMediaTrack> buildTrackList(SessionDescription sessionDescription, Uri uri) {
        ImmutableList.Builder builder = new ImmutableList.Builder();
        for (int i = 0; i < sessionDescription.mediaDescriptionList.size(); i++) {
            MediaDescription mediaDescription = sessionDescription.mediaDescriptionList.get(i);
            if (RtpPayloadFormat.isFormatSupported(mediaDescription)) {
                builder.add((ImmutableList.Builder) new RtspMediaTrack(mediaDescription, uri));
            }
        }
        return builder.build();
    }

    private final class MessageSender {
        private int cSeq;
        private RtspRequest lastRequest;

        private MessageSender() {
        }

        public void sendOptionsRequest(Uri uri, String str) {
            sendRequest(getRequestWithCommonHeaders(4, str, ImmutableMap.m1560of(), uri));
        }

        public void sendDescribeRequest(Uri uri, String str) {
            sendRequest(getRequestWithCommonHeaders(2, str, ImmutableMap.m1560of(), uri));
        }

        public void sendSetupRequest(Uri uri, String str, String str2) {
            sendRequest(getRequestWithCommonHeaders(10, str2, ImmutableMap.m1561of("transport", str), uri));
        }

        public void sendPlayRequest(Uri uri, long j, String str) {
            sendRequest(getRequestWithCommonHeaders(6, str, ImmutableMap.m1561of("range", RtspSessionTiming.getOffsetStartTimeTiming(j)), uri));
        }

        public void sendTeardownRequest(Uri uri, String str) {
            sendRequest(getRequestWithCommonHeaders(12, str, ImmutableMap.m1560of(), uri));
        }

        public void sendPauseRequest(Uri uri, String str) {
            sendRequest(getRequestWithCommonHeaders(5, str, ImmutableMap.m1560of(), uri));
        }

        public void retryLastRequest() {
            Assertions.checkStateNotNull(this.lastRequest);
            ImmutableListMultimap<String, String> asMultiMap = this.lastRequest.headers.asMultiMap();
            HashMap hashMap = new HashMap();
            for (String str : asMultiMap.keySet()) {
                if (!str.equals(RtspHeaders.CSEQ) && !str.equals(RtspHeaders.USER_AGENT) && !str.equals(RtspHeaders.SESSION) && !str.equals(RtspHeaders.AUTHORIZATION)) {
                    hashMap.put(str, (String) Iterables.getLast(asMultiMap.get((ImmutableListMultimap<String, String>) str)));
                }
            }
            sendRequest(getRequestWithCommonHeaders(this.lastRequest.method, RtspClient.this.sessionId, hashMap, this.lastRequest.uri));
        }

        private RtspRequest getRequestWithCommonHeaders(int i, String str, Map<String, String> map, Uri uri) {
            RtspHeaders.Builder builder = new RtspHeaders.Builder();
            int i2 = this.cSeq;
            this.cSeq = i2 + 1;
            builder.add(RtspHeaders.CSEQ, String.valueOf(i2));
            builder.add(RtspHeaders.USER_AGENT, RtspClient.this.userAgent);
            if (str != null) {
                builder.add(RtspHeaders.SESSION, str);
            }
            if (RtspClient.this.rtspAuthenticationInfo != null) {
                Assertions.checkStateNotNull(RtspClient.this.rtspAuthUserInfo);
                try {
                    builder.add(RtspHeaders.AUTHORIZATION, RtspClient.this.rtspAuthenticationInfo.getAuthorizationHeaderValue(RtspClient.this.rtspAuthUserInfo, uri, i));
                } catch (ParserException e) {
                    RtspClient.this.dispatchRtspError(new RtspMediaSource.RtspPlaybackException(e));
                }
            }
            builder.addAll(map);
            return new RtspRequest(uri, i, builder.build(), "");
        }

        private void sendRequest(RtspRequest rtspRequest) {
            int parseInt = Integer.parseInt((String) Assertions.checkNotNull(rtspRequest.headers.get(RtspHeaders.CSEQ)));
            Assertions.checkState(RtspClient.this.pendingRequests.get(parseInt) == null);
            RtspClient.this.pendingRequests.append(parseInt, rtspRequest);
            RtspClient.this.messageChannel.send(RtspMessageUtil.serializeRequest(rtspRequest));
            this.lastRequest = rtspRequest;
        }
    }

    private final class MessageListener implements RtspMessageChannel.MessageListener {
        private final Handler messageHandler = Util.createHandlerForCurrentLooper();

        public MessageListener() {
        }

        @Override // com.google.android.exoplayer2.source.rtsp.RtspMessageChannel.MessageListener
        public void onRtspMessageReceived(final List<String> list) {
            this.messageHandler.post(new Runnable() { // from class: com.google.android.exoplayer2.source.rtsp.-$$Lambda$RtspClient$MessageListener$dJPB0r-FyeWq7xUwLx0FyxTnUk0
                @Override // java.lang.Runnable
                public final void run() {
                    RtspClient.MessageListener.this.lambda$onRtspMessageReceived$0$RtspClient$MessageListener(list);
                }
            });
        }

        /* renamed from: handleRtspMessage, reason: merged with bridge method [inline-methods] */
        private void lambda$onRtspMessageReceived$0$RtspClient$MessageListener(List<String> list) {
            RtspSessionTiming parseTiming;
            ImmutableList<RtspTrackTiming> parseTrackTiming;
            RtspResponse parseResponse = RtspMessageUtil.parseResponse(list);
            int parseInt = Integer.parseInt((String) Assertions.checkNotNull(parseResponse.headers.get(RtspHeaders.CSEQ)));
            RtspRequest rtspRequest = (RtspRequest) RtspClient.this.pendingRequests.get(parseInt);
            if (rtspRequest == null) {
                return;
            }
            RtspClient.this.pendingRequests.remove(parseInt);
            int i = rtspRequest.method;
            try {
                int i2 = parseResponse.status;
                if (i2 != 200) {
                    if (i2 == 401 && RtspClient.this.rtspAuthUserInfo != null && !RtspClient.this.receivedAuthorizationRequest) {
                        String str = parseResponse.headers.get(RtspHeaders.WWW_AUTHENTICATE);
                        if (str == null) {
                            throw new ParserException("Missing WWW-Authenticate header in a 401 response.");
                        }
                        RtspClient.this.rtspAuthenticationInfo = RtspMessageUtil.parseWwwAuthenticateHeader(str);
                        RtspClient.this.messageSender.retryLastRequest();
                        RtspClient.this.receivedAuthorizationRequest = true;
                        return;
                    }
                    RtspClient rtspClient = RtspClient.this;
                    String methodString = RtspMessageUtil.toMethodString(i);
                    rtspClient.dispatchRtspError(new RtspMediaSource.RtspPlaybackException(new StringBuilder(String.valueOf(methodString).length() + 12).append(methodString).append(StringUtils.SPACE).append(parseResponse.status).toString()));
                    return;
                }
                switch (i) {
                    case 1:
                    case 3:
                    case 7:
                    case 8:
                    case 9:
                    case 11:
                    case 12:
                        return;
                    case 2:
                        onDescribeResponseReceived(new RtspDescribeResponse(parseResponse.status, SessionDescriptionParser.parse(parseResponse.messageBody)));
                        return;
                    case 4:
                        onOptionsResponseReceived(new RtspOptionsResponse(parseResponse.status, RtspMessageUtil.parsePublicHeader(parseResponse.headers.get("public"))));
                        return;
                    case 5:
                        onPauseResponseReceived();
                        return;
                    case 6:
                        String str2 = parseResponse.headers.get("range");
                        if (str2 == null) {
                            parseTiming = RtspSessionTiming.DEFAULT;
                        } else {
                            parseTiming = RtspSessionTiming.parseTiming(str2);
                        }
                        String str3 = parseResponse.headers.get(RtspHeaders.RTP_INFO);
                        if (str3 == null) {
                            parseTrackTiming = ImmutableList.m1541of();
                        } else {
                            parseTrackTiming = RtspTrackTiming.parseTrackTiming(str3);
                        }
                        onPlayResponseReceived(new RtspPlayResponse(parseResponse.status, parseTiming, parseTrackTiming));
                        return;
                    case 10:
                        String str4 = parseResponse.headers.get(RtspHeaders.SESSION);
                        String str5 = parseResponse.headers.get("transport");
                        if (str4 == null || str5 == null) {
                            throw new ParserException();
                        }
                        onSetupResponseReceived(new RtspSetupResponse(parseResponse.status, RtspMessageUtil.parseSessionHeader(str4), str5));
                        return;
                    default:
                        throw new IllegalStateException();
                }
            } catch (ParserException e) {
                RtspClient.this.dispatchRtspError(new RtspMediaSource.RtspPlaybackException(e));
            }
        }

        private void onOptionsResponseReceived(RtspOptionsResponse rtspOptionsResponse) {
            if (RtspClient.this.keepAliveMonitor != null) {
                return;
            }
            if (RtspClient.serverSupportsDescribe(rtspOptionsResponse.supportedMethods)) {
                RtspClient.this.messageSender.sendDescribeRequest(RtspClient.this.uri, RtspClient.this.sessionId);
            } else {
                RtspClient.this.sessionInfoListener.onSessionTimelineRequestFailed("DESCRIBE not supported.", null);
            }
        }

        private void onDescribeResponseReceived(RtspDescribeResponse rtspDescribeResponse) {
            RtspSessionTiming rtspSessionTiming;
            String str = rtspDescribeResponse.sessionDescription.attributes.get("range");
            try {
                SessionInfoListener sessionInfoListener = RtspClient.this.sessionInfoListener;
                if (str != null) {
                    rtspSessionTiming = RtspSessionTiming.parseTiming(str);
                } else {
                    rtspSessionTiming = RtspSessionTiming.DEFAULT;
                }
                sessionInfoListener.onSessionTimelineUpdated(rtspSessionTiming, RtspClient.buildTrackList(rtspDescribeResponse.sessionDescription, RtspClient.this.uri));
                RtspClient.this.hasUpdatedTimelineAndTracks = true;
            } catch (ParserException e) {
                RtspClient.this.sessionInfoListener.onSessionTimelineRequestFailed("SDP format error.", e);
            }
        }

        private void onSetupResponseReceived(RtspSetupResponse rtspSetupResponse) {
            RtspClient.this.sessionId = rtspSetupResponse.sessionHeader.sessionId;
            RtspClient.this.continueSetupRtspTrack();
        }

        private void onPlayResponseReceived(RtspPlayResponse rtspPlayResponse) {
            if (RtspClient.this.keepAliveMonitor == null) {
                RtspClient.this.keepAliveMonitor = RtspClient.this.new KeepAliveMonitor(30000L);
                RtspClient.this.keepAliveMonitor.start();
            }
            RtspClient.this.playbackEventListener.onPlaybackStarted(C0858C.msToUs(rtspPlayResponse.sessionTiming.startTimeMs), rtspPlayResponse.trackTimingList);
            RtspClient.this.pendingSeekPositionUs = C0858C.TIME_UNSET;
        }

        private void onPauseResponseReceived() {
            if (RtspClient.this.pendingSeekPositionUs != C0858C.TIME_UNSET) {
                RtspClient rtspClient = RtspClient.this;
                rtspClient.startPlayback(C0858C.usToMs(rtspClient.pendingSeekPositionUs));
            }
        }
    }

    private final class KeepAliveMonitor implements Runnable, Closeable {
        private final long intervalMs;
        private boolean isStarted;
        private final Handler keepAliveHandler = Util.createHandlerForCurrentLooper();

        public KeepAliveMonitor(long j) {
            this.intervalMs = j;
        }

        public void start() {
            if (this.isStarted) {
                return;
            }
            this.isStarted = true;
            this.keepAliveHandler.postDelayed(this, this.intervalMs);
        }

        @Override // java.lang.Runnable
        public void run() {
            RtspClient.this.messageSender.sendOptionsRequest(RtspClient.this.uri, RtspClient.this.sessionId);
            this.keepAliveHandler.postDelayed(this, this.intervalMs);
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.isStarted = false;
            this.keepAliveHandler.removeCallbacks(this);
        }
    }
}