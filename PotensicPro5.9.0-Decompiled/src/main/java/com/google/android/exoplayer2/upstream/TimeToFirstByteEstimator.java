package com.google.android.exoplayer2.upstream;

/* loaded from: classes.dex */
public interface TimeToFirstByteEstimator {
    long getTimeToFirstByteEstimateUs();

    void onTransferInitializing(DataSpec dataSpec);

    void onTransferStart(DataSpec dataSpec);

    void reset();
}
