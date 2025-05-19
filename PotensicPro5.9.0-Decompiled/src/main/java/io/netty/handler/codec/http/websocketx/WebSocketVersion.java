package io.netty.handler.codec.http.websocketx;

import com.google.android.exoplayer2.source.rtsp.SessionDescription;

/* loaded from: classes3.dex */
public enum WebSocketVersion {
    UNKNOWN,
    V00,
    V07,
    V08,
    V13;

    public String toHttpHeaderValue() {
        if (this == V00) {
            return SessionDescription.SUPPORTED_SDP_VERSION;
        }
        if (this == V07) {
            return "7";
        }
        if (this == V08) {
            return "8";
        }
        if (this == V13) {
            return "13";
        }
        throw new IllegalStateException("Unknown web socket version: " + this);
    }
}
