package com.google.android.exoplayer2.source.rtsp;

import android.net.Uri;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.ExoPlayerLibraryInfo;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.drm.DrmSessionManagerProvider;
import com.google.android.exoplayer2.source.BaseMediaSource;
import com.google.android.exoplayer2.source.ForwardingTimeline;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.MediaSourceFactory;
import com.google.android.exoplayer2.source.SinglePeriodTimeline;
import com.google.android.exoplayer2.source.rtsp.RtpDataChannel;
import com.google.android.exoplayer2.source.rtsp.RtspMediaPeriod;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.HttpDataSource;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Assertions;
import java.io.IOException;

/* loaded from: classes.dex */
public final class RtspMediaSource extends BaseMediaSource {
    public static final long DEFAULT_TIMEOUT_MS = 8000;
    private final MediaItem mediaItem;
    private final RtpDataChannel.Factory rtpDataChannelFactory;
    private long timelineDurationUs;
    private boolean timelineIsLive;
    private boolean timelineIsPlaceholder;
    private boolean timelineIsSeekable;
    private final Uri uri;
    private final String userAgent;

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void maybeThrowSourceInfoRefreshError() {
    }

    @Override // com.google.android.exoplayer2.source.BaseMediaSource
    protected void releaseSourceInternal() {
    }

    static {
        ExoPlayerLibraryInfo.registerModule("goog.exo.rtsp");
    }

    public static final class Factory implements MediaSourceFactory {
        private boolean forceUseRtpTcp;
        private long timeoutMs = RtspMediaSource.DEFAULT_TIMEOUT_MS;
        private String userAgent = ExoPlayerLibraryInfo.VERSION_SLASHY;

        @Override // com.google.android.exoplayer2.source.MediaSourceFactory
        public int[] getSupportedTypes() {
            return new int[]{3};
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceFactory
        @Deprecated
        public Factory setDrmHttpDataSourceFactory(HttpDataSource.Factory factory) {
            return this;
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceFactory
        @Deprecated
        public Factory setDrmSessionManager(DrmSessionManager drmSessionManager) {
            return this;
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceFactory
        public Factory setDrmSessionManagerProvider(DrmSessionManagerProvider drmSessionManagerProvider) {
            return this;
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceFactory
        @Deprecated
        public Factory setDrmUserAgent(String str) {
            return this;
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceFactory
        public Factory setLoadErrorHandlingPolicy(LoadErrorHandlingPolicy loadErrorHandlingPolicy) {
            return this;
        }

        public Factory setForceUseRtpTcp(boolean z) {
            this.forceUseRtpTcp = z;
            return this;
        }

        public Factory setUserAgent(String str) {
            this.userAgent = str;
            return this;
        }

        public Factory setTimeoutMs(long j) {
            Assertions.checkArgument(j > 0);
            this.timeoutMs = j;
            return this;
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceFactory
        public RtspMediaSource createMediaSource(MediaItem mediaItem) {
            RtpDataChannel.Factory udpDataSourceRtpDataChannelFactory;
            Assertions.checkNotNull(mediaItem.playbackProperties);
            if (this.forceUseRtpTcp) {
                udpDataSourceRtpDataChannelFactory = new TransferRtpDataChannelFactory(this.timeoutMs);
            } else {
                udpDataSourceRtpDataChannelFactory = new UdpDataSourceRtpDataChannelFactory(this.timeoutMs);
            }
            return new RtspMediaSource(mediaItem, udpDataSourceRtpDataChannelFactory, this.userAgent);
        }
    }

    public static final class RtspPlaybackException extends IOException {
        public RtspPlaybackException(String str) {
            super(str);
        }

        public RtspPlaybackException(Throwable th) {
            super(th);
        }

        public RtspPlaybackException(String str, Throwable th) {
            super(str, th);
        }
    }

    private RtspMediaSource(MediaItem mediaItem, RtpDataChannel.Factory factory, String str) {
        this.mediaItem = mediaItem;
        this.rtpDataChannelFactory = factory;
        this.userAgent = str;
        this.uri = ((MediaItem.PlaybackProperties) Assertions.checkNotNull(mediaItem.playbackProperties)).uri;
        this.timelineDurationUs = C.TIME_UNSET;
        this.timelineIsPlaceholder = true;
    }

    @Override // com.google.android.exoplayer2.source.BaseMediaSource
    protected void prepareSourceInternal(TransferListener transferListener) {
        notifySourceInfoRefreshed();
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public MediaItem getMediaItem() {
        return this.mediaItem;
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public MediaPeriod createPeriod(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator, long j) {
        return new RtspMediaPeriod(allocator, this.rtpDataChannelFactory, this.uri, new RtspMediaPeriod.Listener() { // from class: com.google.android.exoplayer2.source.rtsp.-$$Lambda$RtspMediaSource$TkClrk5QW6DufBv2TPC2_TnFbOA
            @Override // com.google.android.exoplayer2.source.rtsp.RtspMediaPeriod.Listener
            public final void onSourceInfoRefreshed(RtspSessionTiming rtspSessionTiming) {
                RtspMediaSource.this.lambda$createPeriod$0$RtspMediaSource(rtspSessionTiming);
            }
        }, this.userAgent);
    }

    public /* synthetic */ void lambda$createPeriod$0$RtspMediaSource(RtspSessionTiming rtspSessionTiming) {
        this.timelineDurationUs = C.msToUs(rtspSessionTiming.getDurationMs());
        this.timelineIsSeekable = !rtspSessionTiming.isLive();
        this.timelineIsLive = rtspSessionTiming.isLive();
        this.timelineIsPlaceholder = false;
        notifySourceInfoRefreshed();
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void releasePeriod(MediaPeriod mediaPeriod) {
        ((RtspMediaPeriod) mediaPeriod).release();
    }

    private void notifySourceInfoRefreshed() {
        Timeline singlePeriodTimeline = new SinglePeriodTimeline(this.timelineDurationUs, this.timelineIsSeekable, false, this.timelineIsLive, (Object) null, this.mediaItem);
        if (this.timelineIsPlaceholder) {
            singlePeriodTimeline = new ForwardingTimeline(this, singlePeriodTimeline) { // from class: com.google.android.exoplayer2.source.rtsp.RtspMediaSource.1
                @Override // com.google.android.exoplayer2.source.ForwardingTimeline, com.google.android.exoplayer2.Timeline
                public Timeline.Window getWindow(int i, Timeline.Window window, long j) {
                    super.getWindow(i, window, j);
                    window.isPlaceholder = true;
                    return window;
                }

                @Override // com.google.android.exoplayer2.source.ForwardingTimeline, com.google.android.exoplayer2.Timeline
                public Timeline.Period getPeriod(int i, Timeline.Period period, boolean z) {
                    super.getPeriod(i, period, z);
                    period.isPlaceholder = true;
                    return period;
                }
            };
        }
        refreshSourceInfo(singlePeriodTimeline);
    }
}
