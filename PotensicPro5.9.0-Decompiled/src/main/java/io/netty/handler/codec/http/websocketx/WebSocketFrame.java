package io.netty.handler.codec.http.websocketx;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.DefaultByteBufHolder;
import io.netty.util.internal.StringUtil;
import org.apache.commons.beanutils.PropertyUtils;

/* loaded from: classes3.dex */
public abstract class WebSocketFrame extends DefaultByteBufHolder {
    private final boolean finalFragment;
    private final int rsv;

    @Override // io.netty.buffer.DefaultByteBufHolder, io.netty.buffer.ByteBufHolder
    public abstract WebSocketFrame replace(ByteBuf byteBuf);

    protected WebSocketFrame(ByteBuf byteBuf) {
        this(true, 0, byteBuf);
    }

    protected WebSocketFrame(boolean z, int i, ByteBuf byteBuf) {
        super(byteBuf);
        this.finalFragment = z;
        this.rsv = i;
    }

    public boolean isFinalFragment() {
        return this.finalFragment;
    }

    public int rsv() {
        return this.rsv;
    }

    @Override // io.netty.buffer.DefaultByteBufHolder, io.netty.buffer.ByteBufHolder
    public WebSocketFrame copy() {
        return (WebSocketFrame) super.copy();
    }

    @Override // io.netty.buffer.DefaultByteBufHolder, io.netty.buffer.ByteBufHolder
    public WebSocketFrame duplicate() {
        return (WebSocketFrame) super.duplicate();
    }

    @Override // io.netty.buffer.DefaultByteBufHolder, io.netty.buffer.ByteBufHolder
    public WebSocketFrame retainedDuplicate() {
        return (WebSocketFrame) super.retainedDuplicate();
    }

    @Override // io.netty.buffer.DefaultByteBufHolder
    public String toString() {
        return StringUtil.simpleClassName(this) + "(data: " + contentToString() + PropertyUtils.MAPPED_DELIM2;
    }

    @Override // io.netty.buffer.DefaultByteBufHolder, io.netty.util.ReferenceCounted
    public WebSocketFrame retain() {
        super.retain();
        return this;
    }

    @Override // io.netty.buffer.DefaultByteBufHolder, io.netty.util.ReferenceCounted
    public WebSocketFrame retain(int i) {
        super.retain(i);
        return this;
    }

    @Override // io.netty.buffer.DefaultByteBufHolder, io.netty.util.ReferenceCounted
    public WebSocketFrame touch() {
        super.touch();
        return this;
    }

    @Override // io.netty.buffer.DefaultByteBufHolder, io.netty.util.ReferenceCounted
    public WebSocketFrame touch(Object obj) {
        super.touch(obj);
        return this;
    }
}
