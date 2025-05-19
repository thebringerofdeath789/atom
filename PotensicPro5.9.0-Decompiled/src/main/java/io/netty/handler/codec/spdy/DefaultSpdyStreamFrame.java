package io.netty.handler.codec.spdy;

/* loaded from: classes3.dex */
public abstract class DefaultSpdyStreamFrame implements SpdyStreamFrame {
    private boolean last;
    private int streamId;

    protected DefaultSpdyStreamFrame(int i) {
        setStreamId(i);
    }

    @Override // io.netty.handler.codec.spdy.SpdyStreamFrame
    public int streamId() {
        return this.streamId;
    }

    @Override // io.netty.handler.codec.spdy.SpdyStreamFrame, io.netty.handler.codec.spdy.SpdyDataFrame
    public SpdyStreamFrame setStreamId(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("Stream-ID must be positive: " + i);
        }
        this.streamId = i;
        return this;
    }

    @Override // io.netty.handler.codec.spdy.SpdyStreamFrame
    public boolean isLast() {
        return this.last;
    }

    @Override // io.netty.handler.codec.spdy.SpdyStreamFrame, io.netty.handler.codec.spdy.SpdyDataFrame
    public SpdyStreamFrame setLast(boolean z) {
        this.last = z;
        return this;
    }
}
