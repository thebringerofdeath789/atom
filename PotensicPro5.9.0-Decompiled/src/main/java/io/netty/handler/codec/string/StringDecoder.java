package io.netty.handler.codec.string;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Objects;

@ChannelHandler.Sharable
/* loaded from: classes3.dex */
public class StringDecoder extends MessageToMessageDecoder<ByteBuf> {
    private final Charset charset;

    @Override // io.netty.handler.codec.MessageToMessageDecoder
    protected /* bridge */ /* synthetic */ void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List list) throws Exception {
        decode2(channelHandlerContext, byteBuf, (List<Object>) list);
    }

    public StringDecoder() {
        this(Charset.defaultCharset());
    }

    public StringDecoder(Charset charset) {
        Objects.requireNonNull(charset, "charset");
        this.charset = charset;
    }

    /* renamed from: decode, reason: avoid collision after fix types in other method */
    protected void decode2(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        list.add(byteBuf.toString(this.charset));
    }
}
