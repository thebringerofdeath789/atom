package io.netty.handler.codec.spdy;

/* loaded from: classes3.dex */
public interface SpdyStreamFrame extends SpdyFrame {
    boolean isLast();

    SpdyStreamFrame setLast(boolean z);

    SpdyStreamFrame setStreamId(int i);

    int streamId();
}
