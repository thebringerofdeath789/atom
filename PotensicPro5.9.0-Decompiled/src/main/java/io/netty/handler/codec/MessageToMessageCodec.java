package io.netty.handler.codec;

import io.netty.channel.ChannelDuplexHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import io.netty.util.internal.TypeParameterMatcher;
import java.util.List;

/* loaded from: classes.dex */
public abstract class MessageToMessageCodec<INBOUND_IN, OUTBOUND_IN> extends ChannelDuplexHandler {
    private final MessageToMessageDecoder<Object> decoder;
    private final MessageToMessageEncoder<Object> encoder;
    private final TypeParameterMatcher inboundMsgMatcher;
    private final TypeParameterMatcher outboundMsgMatcher;

    protected abstract void decode(ChannelHandlerContext channelHandlerContext, INBOUND_IN inbound_in, List<Object> list) throws Exception;

    protected abstract void encode(ChannelHandlerContext channelHandlerContext, OUTBOUND_IN outbound_in, List<Object> list) throws Exception;

    protected MessageToMessageCodec() {
        this.encoder = new MessageToMessageEncoder<Object>() { // from class: io.netty.handler.codec.MessageToMessageCodec.1
            @Override // io.netty.handler.codec.MessageToMessageEncoder
            public boolean acceptOutboundMessage(Object obj) throws Exception {
                return MessageToMessageCodec.this.acceptOutboundMessage(obj);
            }

            @Override // io.netty.handler.codec.MessageToMessageEncoder
            protected void encode(ChannelHandlerContext channelHandlerContext, Object obj, List<Object> list) throws Exception {
                MessageToMessageCodec.this.encode(channelHandlerContext, obj, list);
            }
        };
        this.decoder = new MessageToMessageDecoder<Object>() { // from class: io.netty.handler.codec.MessageToMessageCodec.2
            @Override // io.netty.handler.codec.MessageToMessageDecoder
            public boolean acceptInboundMessage(Object obj) throws Exception {
                return MessageToMessageCodec.this.acceptInboundMessage(obj);
            }

            @Override // io.netty.handler.codec.MessageToMessageDecoder
            protected void decode(ChannelHandlerContext channelHandlerContext, Object obj, List<Object> list) throws Exception {
                MessageToMessageCodec.this.decode(channelHandlerContext, obj, list);
            }
        };
        this.inboundMsgMatcher = TypeParameterMatcher.find(this, MessageToMessageCodec.class, "INBOUND_IN");
        this.outboundMsgMatcher = TypeParameterMatcher.find(this, MessageToMessageCodec.class, "OUTBOUND_IN");
    }

    protected MessageToMessageCodec(Class<? extends INBOUND_IN> cls, Class<? extends OUTBOUND_IN> cls2) {
        this.encoder = new MessageToMessageEncoder<Object>() { // from class: io.netty.handler.codec.MessageToMessageCodec.1
            @Override // io.netty.handler.codec.MessageToMessageEncoder
            public boolean acceptOutboundMessage(Object obj) throws Exception {
                return MessageToMessageCodec.this.acceptOutboundMessage(obj);
            }

            @Override // io.netty.handler.codec.MessageToMessageEncoder
            protected void encode(ChannelHandlerContext channelHandlerContext, Object obj, List<Object> list) throws Exception {
                MessageToMessageCodec.this.encode(channelHandlerContext, obj, list);
            }
        };
        this.decoder = new MessageToMessageDecoder<Object>() { // from class: io.netty.handler.codec.MessageToMessageCodec.2
            @Override // io.netty.handler.codec.MessageToMessageDecoder
            public boolean acceptInboundMessage(Object obj) throws Exception {
                return MessageToMessageCodec.this.acceptInboundMessage(obj);
            }

            @Override // io.netty.handler.codec.MessageToMessageDecoder
            protected void decode(ChannelHandlerContext channelHandlerContext, Object obj, List<Object> list) throws Exception {
                MessageToMessageCodec.this.decode(channelHandlerContext, obj, list);
            }
        };
        this.inboundMsgMatcher = TypeParameterMatcher.get(cls);
        this.outboundMsgMatcher = TypeParameterMatcher.get(cls2);
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelRead(ChannelHandlerContext channelHandlerContext, Object obj) throws Exception {
        this.decoder.channelRead(channelHandlerContext, obj);
    }

    @Override // io.netty.channel.ChannelDuplexHandler, io.netty.channel.ChannelOutboundHandler
    public void write(ChannelHandlerContext channelHandlerContext, Object obj, ChannelPromise channelPromise) throws Exception {
        this.encoder.write(channelHandlerContext, obj, channelPromise);
    }

    public boolean acceptInboundMessage(Object obj) throws Exception {
        return this.inboundMsgMatcher.match(obj);
    }

    public boolean acceptOutboundMessage(Object obj) throws Exception {
        return this.outboundMsgMatcher.match(obj);
    }
}
