package io.netty.handler.codec.http.websocketx.extensions.compression;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.websocketx.BinaryWebSocketFrame;
import io.netty.handler.codec.http.websocketx.ContinuationWebSocketFrame;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.handler.codec.http.websocketx.WebSocketFrame;
import java.util.List;

/* loaded from: classes3.dex */
class PerMessageDeflateDecoder extends DeflateDecoder {
    private boolean compressing;

    @Override // io.netty.handler.codec.http.websocketx.extensions.compression.DeflateDecoder, io.netty.handler.codec.MessageToMessageDecoder
    protected /* bridge */ /* synthetic */ void decode(ChannelHandlerContext channelHandlerContext, WebSocketFrame webSocketFrame, List list) throws Exception {
        decode(channelHandlerContext, webSocketFrame, (List<Object>) list);
    }

    public PerMessageDeflateDecoder(boolean z) {
        super(z);
    }

    @Override // io.netty.handler.codec.MessageToMessageDecoder
    public boolean acceptInboundMessage(Object obj) throws Exception {
        return (((obj instanceof TextWebSocketFrame) || (obj instanceof BinaryWebSocketFrame)) && (((WebSocketFrame) obj).rsv() & 4) > 0) || ((obj instanceof ContinuationWebSocketFrame) && this.compressing);
    }

    @Override // io.netty.handler.codec.http.websocketx.extensions.compression.DeflateDecoder
    protected int newRsv(WebSocketFrame webSocketFrame) {
        return (webSocketFrame.rsv() & 4) > 0 ? webSocketFrame.rsv() ^ 4 : webSocketFrame.rsv();
    }

    @Override // io.netty.handler.codec.http.websocketx.extensions.compression.DeflateDecoder
    protected boolean appendFrameTail(WebSocketFrame webSocketFrame) {
        return webSocketFrame.isFinalFragment();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.netty.handler.codec.http.websocketx.extensions.compression.DeflateDecoder
    protected void decode(ChannelHandlerContext channelHandlerContext, WebSocketFrame webSocketFrame, List<Object> list) throws Exception {
        super.decode2(channelHandlerContext, webSocketFrame, list);
        if (webSocketFrame.isFinalFragment()) {
            this.compressing = false;
        } else if ((webSocketFrame instanceof TextWebSocketFrame) || (webSocketFrame instanceof BinaryWebSocketFrame)) {
            this.compressing = true;
        }
    }
}
