package com.google.android.exoplayer2.source.rtsp;

/* loaded from: classes.dex */
final class RtspResponse {
    public static final String SDP_MIME_TYPE = "application/sdp";
    public final RtspHeaders headers;
    public final String messageBody;
    public final int status;

    public RtspResponse(int i, RtspHeaders rtspHeaders, String str) {
        this.status = i;
        this.headers = rtspHeaders;
        this.messageBody = str;
    }
}