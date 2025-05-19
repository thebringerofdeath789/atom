package io.netty.handler.codec.http2;

/* loaded from: classes3.dex */
public class DefaultHttp2WindowUpdateFrame extends AbstractHttp2StreamFrame implements Http2WindowUpdateFrame {
    private final int windowUpdateIncrement;

    @Override // io.netty.handler.codec.http2.Http2Frame
    public String name() {
        return "WINDOW_UPDATE";
    }

    public DefaultHttp2WindowUpdateFrame(int i) {
        this.windowUpdateIncrement = i;
    }

    @Override // io.netty.handler.codec.http2.AbstractHttp2StreamFrame, io.netty.handler.codec.http2.Http2StreamFrame
    public DefaultHttp2WindowUpdateFrame stream(Http2FrameStream http2FrameStream) {
        super.stream(http2FrameStream);
        return this;
    }

    @Override // io.netty.handler.codec.http2.Http2WindowUpdateFrame
    public int windowSizeIncrement() {
        return this.windowUpdateIncrement;
    }
}
