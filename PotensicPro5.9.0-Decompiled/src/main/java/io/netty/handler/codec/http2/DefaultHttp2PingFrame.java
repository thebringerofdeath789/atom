package io.netty.handler.codec.http2;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.DefaultByteBufHolder;
import io.netty.util.internal.StringUtil;
import org.apache.commons.beanutils.PropertyUtils;

/* loaded from: classes3.dex */
public class DefaultHttp2PingFrame extends DefaultByteBufHolder implements Http2PingFrame {
    private final boolean ack;

    @Override // io.netty.handler.codec.http2.Http2Frame
    public String name() {
        return "PING";
    }

    public DefaultHttp2PingFrame(ByteBuf byteBuf) {
        this(byteBuf, false);
    }

    DefaultHttp2PingFrame(ByteBuf byteBuf, boolean z) {
        super(mustBeEightBytes(byteBuf));
        this.ack = z;
    }

    @Override // io.netty.handler.codec.http2.Http2PingFrame
    public boolean ack() {
        return this.ack;
    }

    @Override // io.netty.buffer.DefaultByteBufHolder, io.netty.buffer.ByteBufHolder
    public DefaultHttp2PingFrame copy() {
        return replace(content().copy());
    }

    @Override // io.netty.buffer.DefaultByteBufHolder, io.netty.buffer.ByteBufHolder
    public DefaultHttp2PingFrame duplicate() {
        return replace(content().duplicate());
    }

    @Override // io.netty.buffer.DefaultByteBufHolder, io.netty.buffer.ByteBufHolder
    public DefaultHttp2PingFrame retainedDuplicate() {
        return replace(content().retainedDuplicate());
    }

    @Override // io.netty.buffer.DefaultByteBufHolder, io.netty.buffer.ByteBufHolder
    public DefaultHttp2PingFrame replace(ByteBuf byteBuf) {
        return new DefaultHttp2PingFrame(byteBuf, this.ack);
    }

    @Override // io.netty.buffer.DefaultByteBufHolder, io.netty.util.ReferenceCounted
    public DefaultHttp2PingFrame retain() {
        super.retain();
        return this;
    }

    @Override // io.netty.buffer.DefaultByteBufHolder, io.netty.util.ReferenceCounted
    public DefaultHttp2PingFrame retain(int i) {
        super.retain(i);
        return this;
    }

    @Override // io.netty.buffer.DefaultByteBufHolder, io.netty.util.ReferenceCounted
    public DefaultHttp2PingFrame touch() {
        super.touch();
        return this;
    }

    @Override // io.netty.buffer.DefaultByteBufHolder, io.netty.util.ReferenceCounted
    public DefaultHttp2PingFrame touch(Object obj) {
        super.touch(obj);
        return this;
    }

    @Override // io.netty.buffer.DefaultByteBufHolder
    public boolean equals(Object obj) {
        if (obj instanceof Http2PingFrame) {
            return super.equals(obj) && this.ack == ((Http2PingFrame) obj).ack();
        }
        return false;
    }

    @Override // io.netty.buffer.DefaultByteBufHolder
    public int hashCode() {
        return (super.hashCode() * 31) + (this.ack ? 1 : 0);
    }

    private static ByteBuf mustBeEightBytes(ByteBuf byteBuf) {
        if (byteBuf.readableBytes() == 8) {
            return byteBuf;
        }
        throw new IllegalArgumentException("PING frames require 8 bytes of content. Was " + byteBuf.readableBytes() + " bytes.");
    }

    @Override // io.netty.buffer.DefaultByteBufHolder
    public String toString() {
        return StringUtil.simpleClassName(this) + "(content=" + contentToString() + ", ack=" + this.ack + PropertyUtils.MAPPED_DELIM2;
    }
}
