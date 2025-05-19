package io.netty.handler.codec.spdy;

import io.netty.util.internal.StringUtil;
import org.apache.commons.beanutils.PropertyUtils;

/* loaded from: classes3.dex */
public class DefaultSpdySynStreamFrame extends DefaultSpdyHeadersFrame implements SpdySynStreamFrame {
    private int associatedStreamId;
    private byte priority;
    private boolean unidirectional;

    public DefaultSpdySynStreamFrame(int i, int i2, byte b) {
        this(i, i2, b, true);
    }

    public DefaultSpdySynStreamFrame(int i, int i2, byte b, boolean z) {
        super(i, z);
        setAssociatedStreamId(i2);
        setPriority(b);
    }

    @Override // io.netty.handler.codec.spdy.DefaultSpdyHeadersFrame, io.netty.handler.codec.spdy.DefaultSpdyStreamFrame, io.netty.handler.codec.spdy.SpdyStreamFrame, io.netty.handler.codec.spdy.SpdyDataFrame
    public SpdySynStreamFrame setStreamId(int i) {
        super.setStreamId(i);
        return this;
    }

    @Override // io.netty.handler.codec.spdy.DefaultSpdyHeadersFrame, io.netty.handler.codec.spdy.DefaultSpdyStreamFrame, io.netty.handler.codec.spdy.SpdyStreamFrame, io.netty.handler.codec.spdy.SpdyDataFrame
    public SpdySynStreamFrame setLast(boolean z) {
        super.setLast(z);
        return this;
    }

    @Override // io.netty.handler.codec.spdy.DefaultSpdyHeadersFrame, io.netty.handler.codec.spdy.SpdyHeadersFrame
    public SpdySynStreamFrame setInvalid() {
        super.setInvalid();
        return this;
    }

    @Override // io.netty.handler.codec.spdy.SpdySynStreamFrame
    public int associatedStreamId() {
        return this.associatedStreamId;
    }

    @Override // io.netty.handler.codec.spdy.SpdySynStreamFrame
    public SpdySynStreamFrame setAssociatedStreamId(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("Associated-To-Stream-ID cannot be negative: " + i);
        }
        this.associatedStreamId = i;
        return this;
    }

    @Override // io.netty.handler.codec.spdy.SpdySynStreamFrame
    public byte priority() {
        return this.priority;
    }

    @Override // io.netty.handler.codec.spdy.SpdySynStreamFrame
    public SpdySynStreamFrame setPriority(byte b) {
        if (b < 0 || b > 7) {
            throw new IllegalArgumentException("Priority must be between 0 and 7 inclusive: " + ((int) b));
        }
        this.priority = b;
        return this;
    }

    @Override // io.netty.handler.codec.spdy.SpdySynStreamFrame
    public boolean isUnidirectional() {
        return this.unidirectional;
    }

    @Override // io.netty.handler.codec.spdy.SpdySynStreamFrame
    public SpdySynStreamFrame setUnidirectional(boolean z) {
        this.unidirectional = z;
        return this;
    }

    @Override // io.netty.handler.codec.spdy.DefaultSpdyHeadersFrame
    public String toString() {
        StringBuilder append = new StringBuilder().append(StringUtil.simpleClassName(this)).append("(last: ").append(isLast()).append("; unidirectional: ").append(isUnidirectional()).append(PropertyUtils.MAPPED_DELIM2).append(StringUtil.NEWLINE).append("--> Stream-ID = ").append(streamId()).append(StringUtil.NEWLINE);
        if (this.associatedStreamId != 0) {
            append.append("--> Associated-To-Stream-ID = ").append(associatedStreamId()).append(StringUtil.NEWLINE);
        }
        append.append("--> Priority = ").append((int) priority()).append(StringUtil.NEWLINE).append("--> Headers:").append(StringUtil.NEWLINE);
        appendHeaders(append);
        append.setLength(append.length() - StringUtil.NEWLINE.length());
        return append.toString();
    }
}
