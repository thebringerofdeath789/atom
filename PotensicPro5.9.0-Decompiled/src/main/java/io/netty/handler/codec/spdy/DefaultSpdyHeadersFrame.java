package io.netty.handler.codec.spdy;

import io.netty.util.internal.StringUtil;
import java.util.Map;
import org.apache.commons.beanutils.PropertyUtils;

/* loaded from: classes3.dex */
public class DefaultSpdyHeadersFrame extends DefaultSpdyStreamFrame implements SpdyHeadersFrame {
    private final SpdyHeaders headers;
    private boolean invalid;
    private boolean truncated;

    public DefaultSpdyHeadersFrame(int i) {
        this(i, true);
    }

    public DefaultSpdyHeadersFrame(int i, boolean z) {
        super(i);
        this.headers = new DefaultSpdyHeaders(z);
    }

    @Override // io.netty.handler.codec.spdy.DefaultSpdyStreamFrame, io.netty.handler.codec.spdy.SpdyStreamFrame, io.netty.handler.codec.spdy.SpdyDataFrame
    public SpdyHeadersFrame setStreamId(int i) {
        super.setStreamId(i);
        return this;
    }

    @Override // io.netty.handler.codec.spdy.DefaultSpdyStreamFrame, io.netty.handler.codec.spdy.SpdyStreamFrame, io.netty.handler.codec.spdy.SpdyDataFrame
    public SpdyHeadersFrame setLast(boolean z) {
        super.setLast(z);
        return this;
    }

    @Override // io.netty.handler.codec.spdy.SpdyHeadersFrame
    public boolean isInvalid() {
        return this.invalid;
    }

    @Override // io.netty.handler.codec.spdy.SpdyHeadersFrame
    public SpdyHeadersFrame setInvalid() {
        this.invalid = true;
        return this;
    }

    @Override // io.netty.handler.codec.spdy.SpdyHeadersFrame
    public boolean isTruncated() {
        return this.truncated;
    }

    @Override // io.netty.handler.codec.spdy.SpdyHeadersFrame
    public SpdyHeadersFrame setTruncated() {
        this.truncated = true;
        return this;
    }

    @Override // io.netty.handler.codec.spdy.SpdyHeadersFrame
    public SpdyHeaders headers() {
        return this.headers;
    }

    public String toString() {
        StringBuilder append = new StringBuilder().append(StringUtil.simpleClassName(this)).append("(last: ").append(isLast()).append(PropertyUtils.MAPPED_DELIM2).append(StringUtil.NEWLINE).append("--> Stream-ID = ").append(streamId()).append(StringUtil.NEWLINE).append("--> Headers:").append(StringUtil.NEWLINE);
        appendHeaders(append);
        append.setLength(append.length() - StringUtil.NEWLINE.length());
        return append.toString();
    }

    protected void appendHeaders(StringBuilder sb) {
        for (Map.Entry<CharSequence, CharSequence> entry : headers()) {
            sb.append("    ");
            sb.append(entry.getKey());
            sb.append(": ");
            sb.append(entry.getValue());
            sb.append(StringUtil.NEWLINE);
        }
    }
}
