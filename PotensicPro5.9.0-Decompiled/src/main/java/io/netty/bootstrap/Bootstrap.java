package io.netty.bootstrap;

import io.netty.bootstrap.AbstractBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPromise;
import io.netty.channel.EventLoopGroup;
import io.netty.resolver.AddressResolver;
import io.netty.resolver.AddressResolverGroup;
import io.netty.resolver.DefaultAddressResolverGroup;
import io.netty.util.AttributeKey;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.FutureListener;
import io.netty.util.concurrent.GenericFutureListener;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes3.dex */
public class Bootstrap extends AbstractBootstrap<Bootstrap, Channel> {
    private final BootstrapConfig config;
    private volatile SocketAddress remoteAddress;
    private volatile AddressResolverGroup<SocketAddress> resolver;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) Bootstrap.class);
    private static final AddressResolverGroup<?> DEFAULT_RESOLVER = DefaultAddressResolverGroup.INSTANCE;

    public Bootstrap() {
        this.config = new BootstrapConfig(this);
        this.resolver = DEFAULT_RESOLVER;
    }

    private Bootstrap(Bootstrap bootstrap) {
        super(bootstrap);
        this.config = new BootstrapConfig(this);
        this.resolver = DEFAULT_RESOLVER;
        this.resolver = bootstrap.resolver;
        this.remoteAddress = bootstrap.remoteAddress;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Bootstrap resolver(AddressResolverGroup<?> addressResolverGroup) {
        AddressResolverGroup addressResolverGroup2 = addressResolverGroup;
        if (addressResolverGroup == null) {
            addressResolverGroup2 = DEFAULT_RESOLVER;
        }
        this.resolver = addressResolverGroup2;
        return this;
    }

    public Bootstrap remoteAddress(SocketAddress socketAddress) {
        this.remoteAddress = socketAddress;
        return this;
    }

    public Bootstrap remoteAddress(String str, int i) {
        this.remoteAddress = InetSocketAddress.createUnresolved(str, i);
        return this;
    }

    public Bootstrap remoteAddress(InetAddress inetAddress, int i) {
        this.remoteAddress = new InetSocketAddress(inetAddress, i);
        return this;
    }

    public ChannelFuture connect() {
        validate();
        SocketAddress socketAddress = this.remoteAddress;
        if (socketAddress == null) {
            throw new IllegalStateException("remoteAddress not set");
        }
        return doResolveAndConnect(socketAddress, this.config.localAddress());
    }

    public ChannelFuture connect(String str, int i) {
        return connect(InetSocketAddress.createUnresolved(str, i));
    }

    public ChannelFuture connect(InetAddress inetAddress, int i) {
        return connect(new InetSocketAddress(inetAddress, i));
    }

    public ChannelFuture connect(SocketAddress socketAddress) {
        Objects.requireNonNull(socketAddress, "remoteAddress");
        validate();
        return doResolveAndConnect(socketAddress, this.config.localAddress());
    }

    public ChannelFuture connect(SocketAddress socketAddress, SocketAddress socketAddress2) {
        Objects.requireNonNull(socketAddress, "remoteAddress");
        validate();
        return doResolveAndConnect(socketAddress, socketAddress2);
    }

    private ChannelFuture doResolveAndConnect(final SocketAddress socketAddress, final SocketAddress socketAddress2) {
        ChannelFuture initAndRegister = initAndRegister();
        final Channel channel = initAndRegister.channel();
        if (initAndRegister.isDone()) {
            return !initAndRegister.isSuccess() ? initAndRegister : doResolveAndConnect0(channel, socketAddress, socketAddress2, channel.newPromise());
        }
        final AbstractBootstrap.PendingRegistrationPromise pendingRegistrationPromise = new AbstractBootstrap.PendingRegistrationPromise(channel);
        initAndRegister.addListener((GenericFutureListener<? extends Future<? super Void>>) new ChannelFutureListener() { // from class: io.netty.bootstrap.Bootstrap.1
            @Override // io.netty.util.concurrent.GenericFutureListener
            public void operationComplete(ChannelFuture channelFuture) throws Exception {
                Throwable cause = channelFuture.cause();
                if (cause != null) {
                    pendingRegistrationPromise.setFailure(cause);
                } else {
                    pendingRegistrationPromise.registered();
                    Bootstrap.this.doResolveAndConnect0(channel, socketAddress, socketAddress2, pendingRegistrationPromise);
                }
            }
        });
        return pendingRegistrationPromise;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ChannelFuture doResolveAndConnect0(final Channel channel, SocketAddress socketAddress, final SocketAddress socketAddress2, final ChannelPromise channelPromise) {
        AddressResolver<SocketAddress> resolver;
        try {
            resolver = this.resolver.getResolver(channel.eventLoop());
        } catch (Throwable th) {
            channelPromise.tryFailure(th);
        }
        if (resolver.isSupported(socketAddress) && !resolver.isResolved(socketAddress)) {
            Future<SocketAddress> resolve = resolver.resolve(socketAddress);
            if (resolve.isDone()) {
                Throwable cause = resolve.cause();
                if (cause != null) {
                    channel.close();
                    channelPromise.setFailure(cause);
                } else {
                    doConnect(resolve.getNow(), socketAddress2, channelPromise);
                }
                return channelPromise;
            }
            resolve.addListener(new FutureListener<SocketAddress>() { // from class: io.netty.bootstrap.Bootstrap.2
                @Override // io.netty.util.concurrent.GenericFutureListener
                public void operationComplete(Future<SocketAddress> future) throws Exception {
                    if (future.cause() == null) {
                        Bootstrap.doConnect(future.getNow(), socketAddress2, channelPromise);
                    } else {
                        channel.close();
                        channelPromise.setFailure(future.cause());
                    }
                }
            });
            return channelPromise;
        }
        doConnect(socketAddress, socketAddress2, channelPromise);
        return channelPromise;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void doConnect(final SocketAddress socketAddress, final SocketAddress socketAddress2, final ChannelPromise channelPromise) {
        final Channel channel = channelPromise.channel();
        channel.eventLoop().execute(new Runnable() { // from class: io.netty.bootstrap.Bootstrap.3
            @Override // java.lang.Runnable
            public void run() {
                SocketAddress socketAddress3 = socketAddress2;
                if (socketAddress3 == null) {
                    channel.connect(socketAddress, channelPromise);
                } else {
                    channel.connect(socketAddress, socketAddress3, channelPromise);
                }
                channelPromise.addListener((GenericFutureListener<? extends Future<? super Void>>) ChannelFutureListener.CLOSE_ON_FAILURE);
            }
        });
    }

    @Override // io.netty.bootstrap.AbstractBootstrap
    void init(Channel channel) throws Exception {
        channel.pipeline().addLast(this.config.handler());
        Map<ChannelOption<?>, Object> options0 = options0();
        synchronized (options0) {
            setChannelOptions(channel, options0, logger);
        }
        Map<AttributeKey<?>, Object> attrs0 = attrs0();
        synchronized (attrs0) {
            for (Map.Entry<AttributeKey<?>, Object> entry : attrs0.entrySet()) {
                channel.attr(entry.getKey()).set(entry.getValue());
            }
        }
    }

    @Override // io.netty.bootstrap.AbstractBootstrap
    public Bootstrap validate() {
        super.validate();
        if (this.config.handler() != null) {
            return this;
        }
        throw new IllegalStateException("handler not set");
    }

    @Override // io.netty.bootstrap.AbstractBootstrap
    /* renamed from: clone, reason: avoid collision after fix types in other method */
    public Bootstrap mo45clone() {
        return new Bootstrap(this);
    }

    public Bootstrap clone(EventLoopGroup eventLoopGroup) {
        Bootstrap bootstrap = new Bootstrap(this);
        bootstrap.group = eventLoopGroup;
        return bootstrap;
    }

    @Override // io.netty.bootstrap.AbstractBootstrap
    public final AbstractBootstrapConfig<Bootstrap, Channel> config() {
        return this.config;
    }

    final SocketAddress remoteAddress() {
        return this.remoteAddress;
    }

    final AddressResolverGroup<?> resolver() {
        return this.resolver;
    }
}
