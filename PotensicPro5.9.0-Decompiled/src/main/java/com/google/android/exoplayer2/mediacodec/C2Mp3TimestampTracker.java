package com.google.android.exoplayer2.mediacodec;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.audio.MpegAudioUtil;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
final class C2Mp3TimestampTracker {
    private static final long DECODER_DELAY_SAMPLES = 529;
    private static final String TAG = "C2Mp3TimestampTracker";
    private long anchorTimestampUs;
    private long processedSamples;
    private boolean seenInvalidMpegAudioHeader;

    C2Mp3TimestampTracker() {
    }

    public void reset() {
        this.processedSamples = 0L;
        this.anchorTimestampUs = 0L;
        this.seenInvalidMpegAudioHeader = false;
    }

    public long updateAndGetPresentationTimeUs(Format format, DecoderInputBuffer decoderInputBuffer) {
        if (this.seenInvalidMpegAudioHeader) {
            return decoderInputBuffer.timeUs;
        }
        ByteBuffer byteBuffer = (ByteBuffer) Assertions.checkNotNull(decoderInputBuffer.data);
        int i = 0;
        for (int i2 = 0; i2 < 4; i2++) {
            i = (i << 8) | (byteBuffer.get(i2) & 255);
        }
        int parseMpegAudioFrameSampleCount = MpegAudioUtil.parseMpegAudioFrameSampleCount(i);
        if (parseMpegAudioFrameSampleCount == -1) {
            this.seenInvalidMpegAudioHeader = true;
            Log.w(TAG, "MPEG audio header is invalid.");
            return decoderInputBuffer.timeUs;
        }
        if (this.processedSamples == 0) {
            long j = decoderInputBuffer.timeUs;
            this.anchorTimestampUs = j;
            this.processedSamples = parseMpegAudioFrameSampleCount - DECODER_DELAY_SAMPLES;
            return j;
        }
        long processedDurationUs = getProcessedDurationUs(format);
        this.processedSamples += parseMpegAudioFrameSampleCount;
        return this.anchorTimestampUs + processedDurationUs;
    }

    private long getProcessedDurationUs(Format format) {
        return (this.processedSamples * 1000000) / format.sampleRate;
    }
}
