package io.netty.handler.codec.sctp;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.sctp.SctpMessage;
import io.netty.handler.codec.MessageToMessageDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class SctpMessageCompletionHandler extends MessageToMessageDecoder<SctpMessage> {
    private final Map<Integer, ByteBuf> fragments = new HashMap();

    @Override // io.netty.handler.codec.MessageToMessageDecoder
    protected /* bridge */ /* synthetic */ void decode(ChannelHandlerContext channelHandlerContext, SctpMessage sctpMessage, List list) throws Exception {
        decode2(channelHandlerContext, sctpMessage, (List<Object>) list);
    }

    /* renamed from: decode, reason: avoid collision after fix types in other method */
    protected void decode2(ChannelHandlerContext channelHandlerContext, SctpMessage sctpMessage, List<Object> list) throws Exception {
        ByteBuf content = sctpMessage.content();
        int protocolIdentifier = sctpMessage.protocolIdentifier();
        int streamIdentifier = sctpMessage.streamIdentifier();
        boolean isComplete = sctpMessage.isComplete();
        boolean isUnordered = sctpMessage.isUnordered();
        ByteBuf remove = this.fragments.remove(Integer.valueOf(streamIdentifier));
        if (remove == null) {
            remove = Unpooled.EMPTY_BUFFER;
        }
        if (isComplete && !remove.isReadable()) {
            list.add(sctpMessage);
        } else if (!isComplete && remove.isReadable()) {
            this.fragments.put(Integer.valueOf(streamIdentifier), Unpooled.wrappedBuffer(remove, content));
        } else if (isComplete && remove.isReadable()) {
            list.add(new SctpMessage(protocolIdentifier, streamIdentifier, isUnordered, Unpooled.wrappedBuffer(remove, content)));
        } else {
            this.fragments.put(Integer.valueOf(streamIdentifier), content);
        }
        content.retain();
    }
}
