package io.netty.handler.codec.http.websocketx.extensions.compression;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.CompositeByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.embedded.EmbeddedChannel;
import io.netty.handler.codec.CodecException;
import io.netty.handler.codec.compression.ZlibCodecFactory;
import io.netty.handler.codec.compression.ZlibWrapper;
import io.netty.handler.codec.http.websocketx.BinaryWebSocketFrame;
import io.netty.handler.codec.http.websocketx.ContinuationWebSocketFrame;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.handler.codec.http.websocketx.WebSocketFrame;
import io.netty.handler.codec.http.websocketx.extensions.WebSocketExtensionEncoder;
import java.util.List;

/* loaded from: classes3.dex */
abstract class DeflateEncoder extends WebSocketExtensionEncoder {
    private final int compressionLevel;
    private EmbeddedChannel encoder;
    private final boolean noContext;
    private final int windowSize;

    protected abstract boolean removeFrameTail(WebSocketFrame webSocketFrame);

    protected abstract int rsv(WebSocketFrame webSocketFrame);

    @Override // io.netty.handler.codec.MessageToMessageEncoder
    protected /* bridge */ /* synthetic */ void encode(ChannelHandlerContext channelHandlerContext, WebSocketFrame webSocketFrame, List list) throws Exception {
        encode2(channelHandlerContext, webSocketFrame, (List<Object>) list);
    }

    public DeflateEncoder(int i, int i2, boolean z) {
        this.compressionLevel = i;
        this.windowSize = i2;
        this.noContext = z;
    }

    /* renamed from: encode, reason: avoid collision after fix types in other method */
    protected void encode2(ChannelHandlerContext channelHandlerContext, WebSocketFrame webSocketFrame, List<Object> list) throws Exception {
        Object continuationWebSocketFrame;
        if (this.encoder == null) {
            this.encoder = new EmbeddedChannel(ZlibCodecFactory.newZlibEncoder(ZlibWrapper.NONE, this.compressionLevel, this.windowSize, 8));
        }
        this.encoder.writeOutbound(webSocketFrame.content().retain());
        CompositeByteBuf compositeBuffer = channelHandlerContext.alloc().compositeBuffer();
        while (true) {
            ByteBuf byteBuf = (ByteBuf) this.encoder.readOutbound();
            if (byteBuf == null) {
                break;
            } else if (!byteBuf.isReadable()) {
                byteBuf.release();
            } else {
                compositeBuffer.addComponent(true, byteBuf);
            }
        }
        if (compositeBuffer.numComponents() <= 0) {
            compositeBuffer.release();
            throw new CodecException("cannot read compressed buffer");
        }
        if (webSocketFrame.isFinalFragment() && this.noContext) {
            cleanup();
        }
        ByteBuf byteBuf2 = compositeBuffer;
        if (removeFrameTail(webSocketFrame)) {
            byteBuf2 = compositeBuffer.slice(0, compositeBuffer.readableBytes() - PerMessageDeflateDecoder.FRAME_TAIL.length);
        }
        if (webSocketFrame instanceof TextWebSocketFrame) {
            continuationWebSocketFrame = new TextWebSocketFrame(webSocketFrame.isFinalFragment(), rsv(webSocketFrame), byteBuf2);
        } else if (webSocketFrame instanceof BinaryWebSocketFrame) {
            continuationWebSocketFrame = new BinaryWebSocketFrame(webSocketFrame.isFinalFragment(), rsv(webSocketFrame), byteBuf2);
        } else if (webSocketFrame instanceof ContinuationWebSocketFrame) {
            continuationWebSocketFrame = new ContinuationWebSocketFrame(webSocketFrame.isFinalFragment(), rsv(webSocketFrame), byteBuf2);
        } else {
            throw new CodecException("unexpected frame type: " + webSocketFrame.getClass().getName());
        }
        list.add(continuationWebSocketFrame);
    }

    @Override // io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
    public void handlerRemoved(ChannelHandlerContext channelHandlerContext) throws Exception {
        cleanup();
        super.handlerRemoved(channelHandlerContext);
    }

    private void cleanup() {
        EmbeddedChannel embeddedChannel = this.encoder;
        if (embeddedChannel != null) {
            if (embeddedChannel.finish()) {
                while (true) {
                    ByteBuf byteBuf = (ByteBuf) this.encoder.readOutbound();
                    if (byteBuf == null) {
                        break;
                    } else {
                        byteBuf.release();
                    }
                }
            }
            this.encoder = null;
        }
    }
}
