package com.google.android.exoplayer2.upstream;

import com.google.android.exoplayer2.source.LoadEventInfo;
import com.google.android.exoplayer2.source.MediaLoadData;
import java.io.IOException;

/* loaded from: classes.dex */
public interface LoadErrorHandlingPolicy {
    int getMinimumLoadableRetryCount(int i);

    default void onLoadTaskConcluded(long j) {
    }

    public static final class LoadErrorInfo {
        public final int errorCount;
        public final IOException exception;
        public final LoadEventInfo loadEventInfo;
        public final MediaLoadData mediaLoadData;

        public LoadErrorInfo(LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, IOException iOException, int i) {
            this.loadEventInfo = loadEventInfo;
            this.mediaLoadData = mediaLoadData;
            this.exception = iOException;
            this.errorCount = i;
        }
    }

    @Deprecated
    default long getBlacklistDurationMsFor(int i, long j, IOException iOException, int i2) {
        throw new UnsupportedOperationException();
    }

    default long getBlacklistDurationMsFor(LoadErrorInfo loadErrorInfo) {
        return getBlacklistDurationMsFor(loadErrorInfo.mediaLoadData.dataType, loadErrorInfo.loadEventInfo.loadDurationMs, loadErrorInfo.exception, loadErrorInfo.errorCount);
    }

    @Deprecated
    default long getRetryDelayMsFor(int i, long j, IOException iOException, int i2) {
        throw new UnsupportedOperationException();
    }

    default long getRetryDelayMsFor(LoadErrorInfo loadErrorInfo) {
        return getRetryDelayMsFor(loadErrorInfo.mediaLoadData.dataType, loadErrorInfo.loadEventInfo.loadDurationMs, loadErrorInfo.exception, loadErrorInfo.errorCount);
    }
}