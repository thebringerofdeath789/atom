package com.google.android.exoplayer2;

import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.util.Util;

/* loaded from: classes.dex */
final class MediaPeriodInfo {
    public final long durationUs;
    public final long endPositionUs;
    public final MediaSource.MediaPeriodId id;
    public final boolean isFinal;
    public final boolean isLastInTimelinePeriod;
    public final boolean isLastInTimelineWindow;
    public final long requestedContentPositionUs;
    public final long startPositionUs;

    MediaPeriodInfo(MediaSource.MediaPeriodId mediaPeriodId, long j, long j2, long j3, long j4, boolean z, boolean z2, boolean z3) {
        this.id = mediaPeriodId;
        this.startPositionUs = j;
        this.requestedContentPositionUs = j2;
        this.endPositionUs = j3;
        this.durationUs = j4;
        this.isLastInTimelinePeriod = z;
        this.isLastInTimelineWindow = z2;
        this.isFinal = z3;
    }

    public MediaPeriodInfo copyWithStartPositionUs(long j) {
        return j == this.startPositionUs ? this : new MediaPeriodInfo(this.id, j, this.requestedContentPositionUs, this.endPositionUs, this.durationUs, this.isLastInTimelinePeriod, this.isLastInTimelineWindow, this.isFinal);
    }

    public MediaPeriodInfo copyWithRequestedContentPositionUs(long j) {
        return j == this.requestedContentPositionUs ? this : new MediaPeriodInfo(this.id, this.startPositionUs, j, this.endPositionUs, this.durationUs, this.isLastInTimelinePeriod, this.isLastInTimelineWindow, this.isFinal);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        MediaPeriodInfo mediaPeriodInfo = (MediaPeriodInfo) obj;
        return this.startPositionUs == mediaPeriodInfo.startPositionUs && this.requestedContentPositionUs == mediaPeriodInfo.requestedContentPositionUs && this.endPositionUs == mediaPeriodInfo.endPositionUs && this.durationUs == mediaPeriodInfo.durationUs && this.isLastInTimelinePeriod == mediaPeriodInfo.isLastInTimelinePeriod && this.isLastInTimelineWindow == mediaPeriodInfo.isLastInTimelineWindow && this.isFinal == mediaPeriodInfo.isFinal && Util.areEqual(this.id, mediaPeriodInfo.id);
    }

    public int hashCode() {
        return ((((((((((((((527 + this.id.hashCode()) * 31) + ((int) this.startPositionUs)) * 31) + ((int) this.requestedContentPositionUs)) * 31) + ((int) this.endPositionUs)) * 31) + ((int) this.durationUs)) * 31) + (this.isLastInTimelinePeriod ? 1 : 0)) * 31) + (this.isLastInTimelineWindow ? 1 : 0)) * 31) + (this.isFinal ? 1 : 0);
    }
}
