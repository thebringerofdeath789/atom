package com.google.android.exoplayer2.analytics;

import android.util.Base64;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.analytics.PlaybackSessionManager;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import com.google.common.base.Supplier;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* loaded from: classes.dex */
public final class DefaultPlaybackSessionManager implements PlaybackSessionManager {
    public static final Supplier<String> DEFAULT_SESSION_ID_GENERATOR = new Supplier() { // from class: com.google.android.exoplayer2.analytics.-$$Lambda$DefaultPlaybackSessionManager$vmk78wQ9svbZ0HpAtbMXEpmt6SE
        @Override // com.google.common.base.Supplier
        public final Object get() {
            String generateDefaultSessionId;
            generateDefaultSessionId = DefaultPlaybackSessionManager.generateDefaultSessionId();
            return generateDefaultSessionId;
        }
    };
    private static final Random RANDOM = new Random();
    private static final int SESSION_ID_LENGTH = 12;
    private String currentSessionId;
    private Timeline currentTimeline;
    private PlaybackSessionManager.Listener listener;
    private final Timeline.Period period;
    private final Supplier<String> sessionIdGenerator;
    private final HashMap<String, SessionDescriptor> sessions;
    private final Timeline.Window window;

    public DefaultPlaybackSessionManager() {
        this(DEFAULT_SESSION_ID_GENERATOR);
    }

    public DefaultPlaybackSessionManager(Supplier<String> supplier) {
        this.sessionIdGenerator = supplier;
        this.window = new Timeline.Window();
        this.period = new Timeline.Period();
        this.sessions = new HashMap<>();
        this.currentTimeline = Timeline.EMPTY;
    }

    @Override // com.google.android.exoplayer2.analytics.PlaybackSessionManager
    public void setListener(PlaybackSessionManager.Listener listener) {
        this.listener = listener;
    }

    @Override // com.google.android.exoplayer2.analytics.PlaybackSessionManager
    public synchronized String getSessionForMediaPeriodId(Timeline timeline, MediaSource.MediaPeriodId mediaPeriodId) {
        return getOrAddSession(timeline.getPeriodByUid(mediaPeriodId.periodUid, this.period).windowIndex, mediaPeriodId).sessionId;
    }

    @Override // com.google.android.exoplayer2.analytics.PlaybackSessionManager
    public synchronized boolean belongsToSession(AnalyticsListener.EventTime eventTime, String str) {
        SessionDescriptor sessionDescriptor = this.sessions.get(str);
        if (sessionDescriptor == null) {
            return false;
        }
        sessionDescriptor.maybeSetWindowSequenceNumber(eventTime.windowIndex, eventTime.mediaPeriodId);
        return sessionDescriptor.belongsToSession(eventTime.windowIndex, eventTime.mediaPeriodId);
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00e7 A[Catch: all -> 0x011e, TryCatch #0 {, blocks: (B:4:0x0005, B:9:0x0014, B:12:0x0025, B:14:0x0030, B:20:0x003a, B:23:0x004b, B:25:0x0057, B:26:0x005d, B:28:0x0061, B:30:0x0069, B:32:0x0086, B:33:0x00e1, B:35:0x00e7, B:36:0x00fd, B:38:0x0109, B:40:0x010f), top: B:3:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00f9  */
    @Override // com.google.android.exoplayer2.analytics.PlaybackSessionManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized void updateSessions(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime r25) {
        /*
            Method dump skipped, instructions count: 289
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.analytics.DefaultPlaybackSessionManager.updateSessions(com.google.android.exoplayer2.analytics.AnalyticsListener$EventTime):void");
    }

    @Override // com.google.android.exoplayer2.analytics.PlaybackSessionManager
    public synchronized void updateSessionsWithTimelineChange(AnalyticsListener.EventTime eventTime) {
        Assertions.checkNotNull(this.listener);
        Timeline timeline = this.currentTimeline;
        this.currentTimeline = eventTime.timeline;
        Iterator<SessionDescriptor> it = this.sessions.values().iterator();
        while (it.hasNext()) {
            SessionDescriptor next = it.next();
            if (!next.tryResolvingToNewTimeline(timeline, this.currentTimeline)) {
                it.remove();
                if (next.isCreated) {
                    if (next.sessionId.equals(this.currentSessionId)) {
                        this.currentSessionId = null;
                    }
                    this.listener.onSessionFinished(eventTime, next.sessionId, false);
                }
            }
        }
        updateCurrentSession(eventTime);
    }

    @Override // com.google.android.exoplayer2.analytics.PlaybackSessionManager
    public synchronized void updateSessionsWithDiscontinuity(AnalyticsListener.EventTime eventTime, int i) {
        Assertions.checkNotNull(this.listener);
        boolean z = i == 0;
        Iterator<SessionDescriptor> it = this.sessions.values().iterator();
        while (it.hasNext()) {
            SessionDescriptor next = it.next();
            if (next.isFinishedAtEventTime(eventTime)) {
                it.remove();
                if (next.isCreated) {
                    boolean equals = next.sessionId.equals(this.currentSessionId);
                    boolean z2 = z && equals && next.isActive;
                    if (equals) {
                        this.currentSessionId = null;
                    }
                    this.listener.onSessionFinished(eventTime, next.sessionId, z2);
                }
            }
        }
        updateCurrentSession(eventTime);
    }

    @Override // com.google.android.exoplayer2.analytics.PlaybackSessionManager
    public synchronized String getActiveSessionId() {
        return this.currentSessionId;
    }

    @Override // com.google.android.exoplayer2.analytics.PlaybackSessionManager
    public synchronized void finishAllSessions(AnalyticsListener.EventTime eventTime) {
        PlaybackSessionManager.Listener listener;
        this.currentSessionId = null;
        Iterator<SessionDescriptor> it = this.sessions.values().iterator();
        while (it.hasNext()) {
            SessionDescriptor next = it.next();
            it.remove();
            if (next.isCreated && (listener = this.listener) != null) {
                listener.onSessionFinished(eventTime, next.sessionId, false);
            }
        }
    }

    @RequiresNonNull({"listener"})
    private void updateCurrentSession(AnalyticsListener.EventTime eventTime) {
        if (eventTime.timeline.isEmpty()) {
            this.currentSessionId = null;
            return;
        }
        SessionDescriptor sessionDescriptor = this.sessions.get(this.currentSessionId);
        SessionDescriptor orAddSession = getOrAddSession(eventTime.windowIndex, eventTime.mediaPeriodId);
        this.currentSessionId = orAddSession.sessionId;
        updateSessions(eventTime);
        if (eventTime.mediaPeriodId == null || !eventTime.mediaPeriodId.isAd()) {
            return;
        }
        if (sessionDescriptor != null && sessionDescriptor.windowSequenceNumber == eventTime.mediaPeriodId.windowSequenceNumber && sessionDescriptor.adMediaPeriodId != null && sessionDescriptor.adMediaPeriodId.adGroupIndex == eventTime.mediaPeriodId.adGroupIndex && sessionDescriptor.adMediaPeriodId.adIndexInAdGroup == eventTime.mediaPeriodId.adIndexInAdGroup) {
            return;
        }
        this.listener.onAdPlaybackStarted(eventTime, getOrAddSession(eventTime.windowIndex, new MediaSource.MediaPeriodId(eventTime.mediaPeriodId.periodUid, eventTime.mediaPeriodId.windowSequenceNumber)).sessionId, orAddSession.sessionId);
    }

    private SessionDescriptor getOrAddSession(int i, MediaSource.MediaPeriodId mediaPeriodId) {
        SessionDescriptor sessionDescriptor = null;
        long j = Long.MAX_VALUE;
        for (SessionDescriptor sessionDescriptor2 : this.sessions.values()) {
            sessionDescriptor2.maybeSetWindowSequenceNumber(i, mediaPeriodId);
            if (sessionDescriptor2.belongsToSession(i, mediaPeriodId)) {
                long j2 = sessionDescriptor2.windowSequenceNumber;
                if (j2 == -1 || j2 < j) {
                    sessionDescriptor = sessionDescriptor2;
                    j = j2;
                } else if (j2 == j && ((SessionDescriptor) Util.castNonNull(sessionDescriptor)).adMediaPeriodId != null && sessionDescriptor2.adMediaPeriodId != null) {
                    sessionDescriptor = sessionDescriptor2;
                }
            }
        }
        if (sessionDescriptor != null) {
            return sessionDescriptor;
        }
        String str = this.sessionIdGenerator.get();
        SessionDescriptor sessionDescriptor3 = new SessionDescriptor(str, i, mediaPeriodId);
        this.sessions.put(str, sessionDescriptor3);
        return sessionDescriptor3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String generateDefaultSessionId() {
        byte[] bArr = new byte[12];
        RANDOM.nextBytes(bArr);
        return Base64.encodeToString(bArr, 10);
    }

    private final class SessionDescriptor {
        private MediaSource.MediaPeriodId adMediaPeriodId;
        private boolean isActive;
        private boolean isCreated;
        private final String sessionId;
        private int windowIndex;
        private long windowSequenceNumber;

        public SessionDescriptor(String str, int i, MediaSource.MediaPeriodId mediaPeriodId) {
            this.sessionId = str;
            this.windowIndex = i;
            this.windowSequenceNumber = mediaPeriodId == null ? -1L : mediaPeriodId.windowSequenceNumber;
            if (mediaPeriodId == null || !mediaPeriodId.isAd()) {
                return;
            }
            this.adMediaPeriodId = mediaPeriodId;
        }

        public boolean tryResolvingToNewTimeline(Timeline timeline, Timeline timeline2) {
            int resolveWindowIndexToNewTimeline = resolveWindowIndexToNewTimeline(timeline, timeline2, this.windowIndex);
            this.windowIndex = resolveWindowIndexToNewTimeline;
            if (resolveWindowIndexToNewTimeline == -1) {
                return false;
            }
            MediaSource.MediaPeriodId mediaPeriodId = this.adMediaPeriodId;
            return mediaPeriodId == null || timeline2.getIndexOfPeriod(mediaPeriodId.periodUid) != -1;
        }

        public boolean belongsToSession(int i, MediaSource.MediaPeriodId mediaPeriodId) {
            return mediaPeriodId == null ? i == this.windowIndex : this.adMediaPeriodId == null ? !mediaPeriodId.isAd() && mediaPeriodId.windowSequenceNumber == this.windowSequenceNumber : mediaPeriodId.windowSequenceNumber == this.adMediaPeriodId.windowSequenceNumber && mediaPeriodId.adGroupIndex == this.adMediaPeriodId.adGroupIndex && mediaPeriodId.adIndexInAdGroup == this.adMediaPeriodId.adIndexInAdGroup;
        }

        public void maybeSetWindowSequenceNumber(int i, MediaSource.MediaPeriodId mediaPeriodId) {
            if (this.windowSequenceNumber == -1 && i == this.windowIndex && mediaPeriodId != null) {
                this.windowSequenceNumber = mediaPeriodId.windowSequenceNumber;
            }
        }

        public boolean isFinishedAtEventTime(AnalyticsListener.EventTime eventTime) {
            if (this.windowSequenceNumber == -1) {
                return false;
            }
            if (eventTime.mediaPeriodId == null) {
                return this.windowIndex != eventTime.windowIndex;
            }
            if (eventTime.mediaPeriodId.windowSequenceNumber > this.windowSequenceNumber) {
                return true;
            }
            if (this.adMediaPeriodId == null) {
                return false;
            }
            int indexOfPeriod = eventTime.timeline.getIndexOfPeriod(eventTime.mediaPeriodId.periodUid);
            int indexOfPeriod2 = eventTime.timeline.getIndexOfPeriod(this.adMediaPeriodId.periodUid);
            if (eventTime.mediaPeriodId.windowSequenceNumber < this.adMediaPeriodId.windowSequenceNumber || indexOfPeriod < indexOfPeriod2) {
                return false;
            }
            if (indexOfPeriod > indexOfPeriod2) {
                return true;
            }
            if (!eventTime.mediaPeriodId.isAd()) {
                return eventTime.mediaPeriodId.nextAdGroupIndex == -1 || eventTime.mediaPeriodId.nextAdGroupIndex > this.adMediaPeriodId.adGroupIndex;
            }
            int i = eventTime.mediaPeriodId.adGroupIndex;
            return i > this.adMediaPeriodId.adGroupIndex || (i == this.adMediaPeriodId.adGroupIndex && eventTime.mediaPeriodId.adIndexInAdGroup > this.adMediaPeriodId.adIndexInAdGroup);
        }

        private int resolveWindowIndexToNewTimeline(Timeline timeline, Timeline timeline2, int i) {
            if (i < timeline.getWindowCount()) {
                timeline.getWindow(i, DefaultPlaybackSessionManager.this.window);
                for (int i2 = DefaultPlaybackSessionManager.this.window.firstPeriodIndex; i2 <= DefaultPlaybackSessionManager.this.window.lastPeriodIndex; i2++) {
                    int indexOfPeriod = timeline2.getIndexOfPeriod(timeline.getUidOfPeriod(i2));
                    if (indexOfPeriod != -1) {
                        return timeline2.getPeriod(indexOfPeriod, DefaultPlaybackSessionManager.this.period).windowIndex;
                    }
                }
                return -1;
            }
            if (i < timeline2.getWindowCount()) {
                return i;
            }
            return -1;
        }
    }
}
