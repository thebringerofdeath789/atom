package com.ipotensic.baselib.netty;

import android.os.Handler;
import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.netty.handler.NettyClientHandler;
import com.ipotensic.baselib.netty.handler.OnConnectStateListener;
import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import java.net.InetSocketAddress;

/* loaded from: classes2.dex */
public final class NettyClient {
    private Bootstrap mBootstrap;
    private Channel mChannel;
    private NettyClientHandler mClientHandler;
    private EventLoopGroup mEventLoopGroup;
    private String mHost;
    private int mPort;

    public void connect(String str, int i, OnConnectStateListener<byte[]> onConnectStateListener) {
        this.mClientHandler = new NettyClientHandler(onConnectStateListener);
        this.mHost = str;
        this.mPort = i;
        DDLog.d("\u5f00\u59cb\u8fde\u63a5:host=[" + this.mHost + "] port=[" + i + "]");
        this.mEventLoopGroup = new NioEventLoopGroup();
        Bootstrap bootstrap = new Bootstrap();
        this.mBootstrap = bootstrap;
        bootstrap.group(this.mEventLoopGroup);
        this.mBootstrap.option(ChannelOption.SO_KEEPALIVE, true);
        this.mBootstrap.option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 5000);
        this.mBootstrap.channel(NioSocketChannel.class);
        this.mBootstrap.handler(new ChannelInitializer<SocketChannel>() { // from class: com.ipotensic.baselib.netty.NettyClient.1
            @Override // io.netty.channel.ChannelInitializer
            protected void initChannel(SocketChannel socketChannel) throws Exception {
                socketChannel.pipeline().addLast(NettyClient.this.mClientHandler);
            }
        });
        try {
            this.mBootstrap.connect(new InetSocketAddress(this.mHost, this.mPort)).addListener((GenericFutureListener<? extends Future<? super Void>>) new ChannelFutureListener() { // from class: com.ipotensic.baselib.netty.NettyClient.2
                @Override // io.netty.util.concurrent.GenericFutureListener
                public void operationComplete(ChannelFuture channelFuture) throws Exception {
                    if (channelFuture != null) {
                        if (channelFuture.isSuccess()) {
                            NettyClient.this.mChannel = channelFuture.channel();
                            return;
                        } else {
                            DDLog.d("\u8fde\u63a5\u5931\u8d251");
                            return;
                        }
                    }
                    DDLog.e("\u662f\u5426\u8fde\u63a5\u6210\u529f:" + channelFuture.isSuccess());
                }
            }).sync();
        } catch (Exception e) {
            e.printStackTrace();
            DDLog.e("\u8fde\u63a5\u5931\u8d252:" + e.getMessage());
        }
    }

    /* JADX WARN: Type inference failed for: r0v7, types: [io.netty.channel.ChannelFuture] */
    public void reConnect() {
        if (this.mChannel != null) {
            this.mChannel = null;
        }
        try {
            this.mChannel = this.mBootstrap.connect(new InetSocketAddress(this.mHost, this.mPort)).sync().channel();
            this.mBootstrap.handler(new ChannelInitializer<SocketChannel>() { // from class: com.ipotensic.baselib.netty.NettyClient.3
                @Override // io.netty.channel.ChannelInitializer
                protected void initChannel(SocketChannel socketChannel) throws Exception {
                    socketChannel.pipeline().addLast(NettyClient.this.mClientHandler);
                }
            });
            Channel channel = this.mChannel;
            if (channel == null || !channel.isOpen()) {
                return;
            }
            DDLog.d("onReconnect()..\u91cd\u8fde\u72b6\u6001:" + this.mChannel.isActive());
        } catch (Exception e) {
            e.printStackTrace();
            DDLog.d("onReconnect()..\u91cd\u8fde\u5931\u8d25:" + e.getMessage());
        }
    }

    public boolean onPostCommand(byte[] bArr) {
        if (this.mChannel == null) {
            return false;
        }
        ByteBuf buffer = Unpooled.buffer(bArr.length);
        buffer.writeBytes(bArr);
        Future<Void> awaitUninterruptibly = this.mChannel.writeAndFlush(buffer).awaitUninterruptibly();
        buffer.clear();
        return awaitUninterruptibly.isSuccess();
    }

    public void onShutDown() {
        new Handler().post(new Runnable() { // from class: com.ipotensic.baselib.netty.NettyClient.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    try {
                        if (NettyClient.this.mChannel != null && NettyClient.this.mChannel.isOpen()) {
                            NettyClient.this.mChannel.close().sync();
                        }
                        if (NettyClient.this.mEventLoopGroup == null) {
                            return;
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        if (NettyClient.this.mEventLoopGroup == null) {
                            return;
                        }
                    }
                    DDLog.d("onShutDown()..\u9500\u6bc1\u6210\u529f");
                    NettyClient.this.mEventLoopGroup.shutdownGracefully();
                } catch (Throwable th) {
                    if (NettyClient.this.mEventLoopGroup != null) {
                        DDLog.d("onShutDown()..\u9500\u6bc1\u6210\u529f");
                        NettyClient.this.mEventLoopGroup.shutdownGracefully();
                    }
                    throw th;
                }
            }
        });
    }
}