package io.netty.handler.codec.base64;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;
import java.util.List;
import java.util.Objects;

@ChannelHandler.Sharable
/* loaded from: classes.dex */
public class Base64Decoder extends MessageToMessageDecoder<ByteBuf> {
    private final Base64Dialect dialect;

    @Override // io.netty.handler.codec.MessageToMessageDecoder
    protected /* bridge */ /* synthetic */ void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List list) throws Exception {
        decode2(channelHandlerContext, byteBuf, (List<Object>) list);
    }

    public Base64Decoder() {
        this(Base64Dialect.STANDARD);
    }

    public Base64Decoder(Base64Dialect base64Dialect) {
        Objects.requireNonNull(base64Dialect, "dialect");
        this.dialect = base64Dialect;
    }

    /* renamed from: decode, reason: avoid collision after fix types in other method */
    protected void decode2(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        list.add(Base64.decode(byteBuf, byteBuf.readerIndex(), byteBuf.readableBytes(), this.dialect));
    }
}
