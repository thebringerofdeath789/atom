package com.google.android.exoplayer2.util;

import com.google.android.exoplayer2.C0858C;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* loaded from: classes.dex */
public final class TimestampAdjuster {
    public static final long DO_NOT_OFFSET = Long.MAX_VALUE;
    private static final long MAX_PTS_PLUS_ONE = 8589934592L;
    private long firstSampleTimestampUs;
    private long lastSampleTimestampUs = C0858C.TIME_UNSET;
    private boolean sharedInitializationStarted;
    private long timestampOffsetUs;

    public TimestampAdjuster(long j) {
        this.firstSampleTimestampUs = j;
    }

    public synchronized void sharedInitializeOrWait(boolean z, long j) throws InterruptedException {
        if (z) {
            try {
                if (!this.sharedInitializationStarted) {
                    this.firstSampleTimestampUs = j;
                    this.sharedInitializationStarted = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (!z || j != this.firstSampleTimestampUs) {
            while (this.lastSampleTimestampUs == C0858C.TIME_UNSET) {
                wait();
            }
        }
    }

    public synchronized long getFirstSampleTimestampUs() {
        return this.firstSampleTimestampUs;
    }

    public synchronized long getLastAdjustedTimestampUs() {
        long j;
        long j2 = this.lastSampleTimestampUs;
        j = C0858C.TIME_UNSET;
        if (j2 != C0858C.TIME_UNSET) {
            j = this.timestampOffsetUs + j2;
        } else {
            long j3 = this.firstSampleTimestampUs;
            if (j3 != Long.MAX_VALUE) {
                j = j3;
            }
        }
        return j;
    }

    public synchronized long getTimestampOffsetUs() {
        long j;
        long j2 = this.firstSampleTimestampUs;
        j = C0858C.TIME_UNSET;
        if (j2 == Long.MAX_VALUE) {
            j = 0;
        } else if (this.lastSampleTimestampUs != C0858C.TIME_UNSET) {
            j = this.timestampOffsetUs;
        }
        return j;
    }

    public synchronized void reset(long j) {
        this.firstSampleTimestampUs = j;
        this.lastSampleTimestampUs = C0858C.TIME_UNSET;
        this.sharedInitializationStarted = false;
    }

    public synchronized long adjustTsTimestamp(long j) {
        if (j == C0858C.TIME_UNSET) {
            return C0858C.TIME_UNSET;
        }
        long j2 = this.lastSampleTimestampUs;
        if (j2 != C0858C.TIME_UNSET) {
            long usToNonWrappedPts = usToNonWrappedPts(j2);
            long j3 = (IjkMediaMeta.AV_CH_WIDE_RIGHT + usToNonWrappedPts) / 8589934592L;
            long j4 = ((j3 - 1) * 8589934592L) + j;
            j += j3 * 8589934592L;
            if (Math.abs(j4 - usToNonWrappedPts) < Math.abs(j - usToNonWrappedPts)) {
                j = j4;
            }
        }
        return adjustSampleTimestamp(ptsToUs(j));
    }

    public synchronized long adjustSampleTimestamp(long j) {
        if (j == C0858C.TIME_UNSET) {
            return C0858C.TIME_UNSET;
        }
        if (this.lastSampleTimestampUs != C0858C.TIME_UNSET) {
            this.lastSampleTimestampUs = j;
        } else {
            long j2 = this.firstSampleTimestampUs;
            if (j2 != Long.MAX_VALUE) {
                this.timestampOffsetUs = j2 - j;
            }
            this.lastSampleTimestampUs = j;
            notifyAll();
        }
        return j + this.timestampOffsetUs;
    }

    public static long ptsToUs(long j) {
        return (j * 1000000) / 90000;
    }

    public static long usToWrappedPts(long j) {
        return usToNonWrappedPts(j) % 8589934592L;
    }

    public static long usToNonWrappedPts(long j) {
        return (j * 90000) / 1000000;
    }
}