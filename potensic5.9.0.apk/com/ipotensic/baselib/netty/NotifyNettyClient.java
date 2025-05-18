package com.ipotensic.baselib.netty;

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
public final class NotifyNettyClient {
    private static volatile NotifyNettyClient instance;
    private Bootstrap mBootstrap;
    private Channel mChannel;
    private NettyClientHandler mClientHandler;
    private EventLoopGroup mEventLoopGroup;
    private String mHost;
    private int mPort;

    private NotifyNettyClient() {
    }

    public static NotifyNettyClient getInstance() {
        if (instance == null) {
            synchronized (NotifyNettyClient.class) {
                if (instance == null) {
                    NotifyNettyClient notifyNettyClient = new NotifyNettyClient();
                    instance = notifyNettyClient;
                    return notifyNettyClient;
                }
            }
        }
        return instance;
    }

    public synchronized void connect(String str, int i, OnConnectStateListener<byte[]> onConnectStateListener) {
        this.mClientHandler = new NettyClientHandler(onConnectStateListener);
        this.mHost = str;
        this.mPort = i;
        DDLog.m1682d("开始连接通知socket:host=[" + this.mHost + "] port=[" + i + "]");
        this.mEventLoopGroup = new NioEventLoopGroup();
        Bootstrap bootstrap = new Bootstrap();
        this.mBootstrap = bootstrap;
        bootstrap.group(this.mEventLoopGroup);
        this.mBootstrap.option(ChannelOption.SO_KEEPALIVE, true);
        this.mBootstrap.option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 5000);
        this.mBootstrap.channel(NioSocketChannel.class);
        this.mBootstrap.handler(new ChannelInitializer<SocketChannel>() { // from class: com.ipotensic.baselib.netty.NotifyNettyClient.1
            @Override // io.netty.channel.ChannelInitializer
            protected void initChannel(SocketChannel socketChannel) throws Exception {
                socketChannel.pipeline().addLast(NotifyNettyClient.this.mClientHandler);
            }
        });
        try {
            this.mBootstrap.connect(new InetSocketAddress(this.mHost, this.mPort)).addListener((GenericFutureListener<? extends Future<? super Void>>) new ChannelFutureListener() { // from class: com.ipotensic.baselib.netty.NotifyNettyClient.2
                @Override // io.netty.util.concurrent.GenericFutureListener
                public void operationComplete(ChannelFuture channelFuture) throws Exception {
                    if (channelFuture != null) {
                        if (channelFuture.isSuccess()) {
                            NotifyNettyClient.this.mChannel = channelFuture.channel();
                            return;
                        } else {
                            DDLog.m1682d("通知socket连接失败1");
                            return;
                        }
                    }
                    DDLog.m1684e("通知socket是否连接成功:" + channelFuture.isSuccess());
                }
            }).sync();
        } catch (Exception e) {
            e.printStackTrace();
            DDLog.m1684e("通知socket连接失败2:" + e.getMessage());
        }
    }

    /* JADX WARN: Type inference failed for: r0v7, types: [io.netty.channel.ChannelFuture] */
    public void reConnect() {
        if (this.mChannel != null) {
            this.mChannel = null;
        }
        try {
            this.mChannel = this.mBootstrap.connect(new InetSocketAddress(this.mHost, this.mPort)).sync().channel();
            this.mBootstrap.handler(new ChannelInitializer<SocketChannel>() { // from class: com.ipotensic.baselib.netty.NotifyNettyClient.3
                @Override // io.netty.channel.ChannelInitializer
                protected void initChannel(SocketChannel socketChannel) throws Exception {
                    socketChannel.pipeline().addLast(NotifyNettyClient.this.mClientHandler);
                }
            });
            Channel channel = this.mChannel;
            if (channel == null || !channel.isOpen()) {
                return;
            }
            DDLog.m1682d("onReconnect()..通知socket重连状态:" + this.mChannel.isActive());
        } catch (Exception e) {
            e.printStackTrace();
            DDLog.m1682d("onReconnect()..通知socket重连失败:" + e.getMessage());
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
        try {
            try {
                Channel channel = this.mChannel;
                if (channel != null && channel.isOpen()) {
                    this.mChannel.close().sync();
                }
                if (this.mEventLoopGroup == null) {
                    return;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
                if (this.mEventLoopGroup == null) {
                    return;
                }
            }
            DDLog.m1682d("onShutDown()..通知socket销毁成功");
            this.mEventLoopGroup.shutdownGracefully();
        } catch (Throwable th) {
            if (this.mEventLoopGroup != null) {
                DDLog.m1682d("onShutDown()..通知socket销毁成功");
                this.mEventLoopGroup.shutdownGracefully();
            }
            throw th;
        }
    }
}