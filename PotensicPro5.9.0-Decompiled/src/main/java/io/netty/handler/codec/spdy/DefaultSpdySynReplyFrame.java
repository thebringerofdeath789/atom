package io.netty.handler.codec.spdy;

import io.netty.util.internal.StringUtil;
import org.apache.commons.beanutils.PropertyUtils;

/* loaded from: classes3.dex */
public class DefaultSpdySynReplyFrame extends DefaultSpdyHeadersFrame implements SpdySynReplyFrame {
    public DefaultSpdySynReplyFrame(int i) {
        super(i);
    }

    public DefaultSpdySynReplyFrame(int i, boolean z) {
        super(i, z);
    }

    @Override // io.netty.handler.codec.spdy.DefaultSpdyHeadersFrame, io.netty.handler.codec.spdy.DefaultSpdyStreamFrame, io.netty.handler.codec.spdy.SpdyStreamFrame, io.netty.handler.codec.spdy.SpdyDataFrame
    public SpdySynReplyFrame setStreamId(int i) {
        super.setStreamId(i);
        return this;
    }

    @Override // io.netty.handler.codec.spdy.DefaultSpdyHeadersFrame, io.netty.handler.codec.spdy.DefaultSpdyStreamFrame, io.netty.handler.codec.spdy.SpdyStreamFrame, io.netty.handler.codec.spdy.SpdyDataFrame
    public SpdySynReplyFrame setLast(boolean z) {
        super.setLast(z);
        return this;
    }

    @Override // io.netty.handler.codec.spdy.DefaultSpdyHeadersFrame, io.netty.handler.codec.spdy.SpdyHeadersFrame
    public SpdySynReplyFrame setInvalid() {
        super.setInvalid();
        return this;
    }

    @Override // io.netty.handler.codec.spdy.DefaultSpdyHeadersFrame
    public String toString() {
        StringBuilder append = new StringBuilder().append(StringUtil.simpleClassName(this)).append("(last: ").append(isLast()).append(PropertyUtils.MAPPED_DELIM2).append(StringUtil.NEWLINE).append("--> Stream-ID = ").append(streamId()).append(StringUtil.NEWLINE).append("--> Headers:").append(StringUtil.NEWLINE);
        appendHeaders(append);
        append.setLength(append.length() - StringUtil.NEWLINE.length());
        return append.toString();
    }
}
