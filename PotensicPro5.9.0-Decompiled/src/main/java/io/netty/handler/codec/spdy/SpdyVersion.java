package io.netty.handler.codec.spdy;

/* loaded from: classes3.dex */
public enum SpdyVersion {
    SPDY_3_1(3, 1);

    private final int minorVersion;
    private final int version;

    SpdyVersion(int i, int i2) {
        this.version = i;
        this.minorVersion = i2;
    }

    int getVersion() {
        return this.version;
    }

    int getMinorVersion() {
        return this.minorVersion;
    }
}
