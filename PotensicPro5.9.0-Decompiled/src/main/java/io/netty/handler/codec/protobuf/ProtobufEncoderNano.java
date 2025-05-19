package io.netty.handler.codec.protobuf;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.MessageNano;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageEncoder;
import java.util.List;

@ChannelHandler.Sharable
/* loaded from: classes3.dex */
public class ProtobufEncoderNano extends MessageToMessageEncoder<MessageNano> {
    @Override // io.netty.handler.codec.MessageToMessageEncoder
    protected /* bridge */ /* synthetic */ void encode(ChannelHandlerContext channelHandlerContext, MessageNano messageNano, List list) throws Exception {
        encode2(channelHandlerContext, messageNano, (List<Object>) list);
    }

    /* renamed from: encode, reason: avoid collision after fix types in other method */
    protected void encode2(ChannelHandlerContext channelHandlerContext, MessageNano messageNano, List<Object> list) throws Exception {
        int serializedSize = messageNano.getSerializedSize();
        ByteBuf heapBuffer = channelHandlerContext.alloc().heapBuffer(serializedSize, serializedSize);
        messageNano.writeTo(CodedOutputByteBufferNano.newInstance(heapBuffer.array(), heapBuffer.arrayOffset(), heapBuffer.capacity()));
        heapBuffer.writerIndex(serializedSize);
        list.add(heapBuffer);
    }
}
