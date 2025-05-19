package io.netty.handler.codec.stomp;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.util.CharsetUtil;
import java.util.Objects;

/* loaded from: classes3.dex */
public class DefaultStompFrame extends DefaultStompHeadersSubframe implements StompFrame {
    private final ByteBuf content;

    public DefaultStompFrame(StompCommand stompCommand) {
        this(stompCommand, Unpooled.buffer(0));
    }

    public DefaultStompFrame(StompCommand stompCommand, ByteBuf byteBuf) {
        super(stompCommand);
        Objects.requireNonNull(byteBuf, "content");
        this.content = byteBuf;
    }

    @Override // io.netty.buffer.ByteBufHolder
    public ByteBuf content() {
        return this.content;
    }

    @Override // io.netty.handler.codec.stomp.StompContentSubframe, io.netty.buffer.ByteBufHolder
    public StompFrame copy() {
        return replace(this.content.copy());
    }

    @Override // io.netty.handler.codec.stomp.StompContentSubframe, io.netty.buffer.ByteBufHolder
    public StompFrame duplicate() {
        return replace(this.content.duplicate());
    }

    @Override // io.netty.handler.codec.stomp.StompContentSubframe, io.netty.buffer.ByteBufHolder
    public StompFrame retainedDuplicate() {
        return replace(this.content.retainedDuplicate());
    }

    @Override // io.netty.handler.codec.stomp.StompContentSubframe, io.netty.buffer.ByteBufHolder
    public StompFrame replace(ByteBuf byteBuf) {
        return new DefaultStompFrame(this.command, byteBuf);
    }

    @Override // io.netty.util.ReferenceCounted
    public int refCnt() {
        return this.content.refCnt();
    }

    @Override // io.netty.util.ReferenceCounted
    public StompFrame retain() {
        this.content.retain();
        return this;
    }

    @Override // io.netty.util.ReferenceCounted
    public StompFrame retain(int i) {
        this.content.retain(i);
        return this;
    }

    @Override // io.netty.util.ReferenceCounted
    public StompFrame touch() {
        this.content.touch();
        return this;
    }

    @Override // io.netty.util.ReferenceCounted
    public StompFrame touch(Object obj) {
        this.content.touch(obj);
        return this;
    }

    @Override // io.netty.util.ReferenceCounted
    public boolean release() {
        return this.content.release();
    }

    @Override // io.netty.util.ReferenceCounted
    public boolean release(int i) {
        return this.content.release(i);
    }

    @Override // io.netty.handler.codec.stomp.DefaultStompHeadersSubframe
    public String toString() {
        return "DefaultStompFrame{command=" + this.command + ", headers=" + this.headers + ", content=" + this.content.toString(CharsetUtil.UTF_8) + '}';
    }
}
