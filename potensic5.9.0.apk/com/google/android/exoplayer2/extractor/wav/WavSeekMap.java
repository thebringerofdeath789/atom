package com.google.android.exoplayer2.extractor.wav;

import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.SeekPoint;
import com.google.android.exoplayer2.util.Util;

/* loaded from: classes.dex */
final class WavSeekMap implements SeekMap {
    private final long blockCount;
    private final long durationUs;
    private final long firstBlockPosition;
    private final int framesPerBlock;
    private final WavHeader wavHeader;

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public boolean isSeekable() {
        return true;
    }

    public WavSeekMap(WavHeader wavHeader, int i, long j, long j2) {
        this.wavHeader = wavHeader;
        this.framesPerBlock = i;
        this.firstBlockPosition = j;
        long j3 = (j2 - j) / wavHeader.blockSize;
        this.blockCount = j3;
        this.durationUs = blockIndexToTimeUs(j3);
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public long getDurationUs() {
        return this.durationUs;
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public SeekMap.SeekPoints getSeekPoints(long j) {
        long constrainValue = Util.constrainValue((this.wavHeader.frameRateHz * j) / (this.framesPerBlock * 1000000), 0L, this.blockCount - 1);
        long j2 = this.firstBlockPosition + (this.wavHeader.blockSize * constrainValue);
        long blockIndexToTimeUs = blockIndexToTimeUs(constrainValue);
        SeekPoint seekPoint = new SeekPoint(blockIndexToTimeUs, j2);
        if (blockIndexToTimeUs >= j || constrainValue == this.blockCount - 1) {
            return new SeekMap.SeekPoints(seekPoint);
        }
        long j3 = constrainValue + 1;
        return new SeekMap.SeekPoints(seekPoint, new SeekPoint(blockIndexToTimeUs(j3), this.firstBlockPosition + (this.wavHeader.blockSize * j3)));
    }

    private long blockIndexToTimeUs(long j) {
        return Util.scaleLargeTimestamp(j * this.framesPerBlock, 1000000L, this.wavHeader.frameRateHz);
    }
}