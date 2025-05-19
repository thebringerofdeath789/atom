package io.netty.handler.codec.http2;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufHolder;

/* loaded from: classes3.dex */
public interface Http2PingFrame extends Http2Frame, ByteBufHolder {
    boolean ack();

    @Override // io.netty.buffer.ByteBufHolder
    ByteBuf content();
}
