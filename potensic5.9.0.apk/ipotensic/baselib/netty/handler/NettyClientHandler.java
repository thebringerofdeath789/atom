package com.ipotensic.baselib.netty.handler;

import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.netty.ParseUtil;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

@ChannelHandler.Sharable
/* loaded from: classes2.dex */
public class NettyClientHandler extends ChannelInboundHandlerAdapter {
    private static final String TAG = "NettyClientHandler";
    private OnConnectStateListener<byte[]> onConnectStateListener;

    public NettyClientHandler() {
    }

    public NettyClientHandler(OnConnectStateListener<byte[]> onConnectStateListener) {
        this.onConnectStateListener = onConnectStateListener;
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelRegistered(ChannelHandlerContext channelHandlerContext) throws Exception {
        super.channelRegistered(channelHandlerContext);
        DDLog.d("channel-->[id=" + channelHandlerContext.channel().id() + "] registered");
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelActive(ChannelHandlerContext channelHandlerContext) throws Exception {
        DDLog.d("channel-->[id=" + channelHandlerContext.channel().id() + "] active");
        super.channelActive(channelHandlerContext);
        this.onConnectStateListener.onClientStatusConnectChanged(1);
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelRead(ChannelHandlerContext channelHandlerContext, Object obj) throws Exception {
        ByteBuf byteBuf = (ByteBuf) obj;
        byte[] bArr = new byte[byteBuf.readableBytes()];
        byteBuf.readBytes(bArr);
        DDLog.d("\u6536\u5230\u6570\u636e\uff1a" + ParseUtil.byteToHexString(bArr));
        this.onConnectStateListener.onMessageResponseClient(bArr);
        byteBuf.clear();
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelInactive(ChannelHandlerContext channelHandlerContext) throws Exception {
        super.channelInactive(channelHandlerContext);
        DDLog.d("channelInactive channel-->[id=" + channelHandlerContext.channel().id() + "] socket channel is inactive");
        this.onConnectStateListener.onClientStatusConnectChanged(0);
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler, io.netty.channel.ChannelInboundHandler
    public void exceptionCaught(ChannelHandlerContext channelHandlerContext, Throwable th) throws Exception {
        super.exceptionCaught(channelHandlerContext, th);
        if (channelHandlerContext.channel().isActive()) {
            channelHandlerContext.close();
        }
        DDLog.e("exceptionCaught channel-->[id=" + channelHandlerContext.channel().id() + "] got an exception:" + th.getMessage());
        this.onConnectStateListener.onClientStatusConnectChanged(-1);
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelReadComplete(ChannelHandlerContext channelHandlerContext) throws Exception {
        super.channelReadComplete(channelHandlerContext);
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelUnregistered(ChannelHandlerContext channelHandlerContext) throws Exception {
        super.channelUnregistered(channelHandlerContext);
        DDLog.d("channelUnregistered channel-->[id=" + channelHandlerContext.channel().id() + "] unregistered");
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void userEventTriggered(ChannelHandlerContext channelHandlerContext, Object obj) throws Exception {
        super.userEventTriggered(channelHandlerContext, obj);
        DDLog.d("userEventTriggered channel-->[id=" + channelHandlerContext.channel().id() + "] user event triggered");
    }
}