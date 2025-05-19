package com.google.android.exoplayer2.source.rtsp.reader;

import com.google.android.exoplayer2.source.rtsp.RtpPayloadFormat;
import com.google.android.exoplayer2.source.rtsp.reader.RtpPayloadReader;
import com.google.android.exoplayer2.util.Assertions;

/* loaded from: classes.dex */
public final class DefaultRtpPayloadReaderFactory implements RtpPayloadReader.Factory {
    @Override // com.google.android.exoplayer2.source.rtsp.reader.RtpPayloadReader.Factory
    public RtpPayloadReader createPayloadReader(RtpPayloadFormat rtpPayloadFormat) {
        String str = (String) Assertions.checkNotNull(rtpPayloadFormat.format.sampleMimeType);
        str.hashCode();
        switch (str) {
            case "audio/mp4a-latm":
                return new RtpAacReader(rtpPayloadFormat);
            case "audio/ac3":
                return new RtpAc3Reader(rtpPayloadFormat);
            case "video/avc":
                return new RtpH264Reader(rtpPayloadFormat);
            default:
                return null;
        }
    }
}
