package io.netty.handler.codec.base64;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageEncoder;
import java.util.List;
import java.util.Objects;

@ChannelHandler.Sharable
/* loaded from: classes.dex */
public class Base64Encoder extends MessageToMessageEncoder<ByteBuf> {
    private final boolean breakLines;
    private final Base64Dialect dialect;

    @Override // io.netty.handler.codec.MessageToMessageEncoder
    protected /* bridge */ /* synthetic */ void encode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List list) throws Exception {
        encode2(channelHandlerContext, byteBuf, (List<Object>) list);
    }

    public Base64Encoder() {
        this(true);
    }

    public Base64Encoder(boolean z) {
        this(z, Base64Dialect.STANDARD);
    }

    public Base64Encoder(boolean z, Base64Dialect base64Dialect) {
        Objects.requireNonNull(base64Dialect, "dialect");
        this.breakLines = z;
        this.dialect = base64Dialect;
    }

    /* renamed from: encode, reason: avoid collision after fix types in other method */
    protected void encode2(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        list.add(Base64.encode(byteBuf, byteBuf.readerIndex(), byteBuf.readableBytes(), this.breakLines, this.dialect));
    }
}
