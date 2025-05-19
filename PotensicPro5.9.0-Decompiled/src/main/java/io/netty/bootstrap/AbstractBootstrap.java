package io.netty.bootstrap;

import io.netty.bootstrap.AbstractBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPromise;
import io.netty.channel.DefaultChannelPromise;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.ReflectiveChannelFactory;
import io.netty.util.AttributeKey;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import io.netty.util.concurrent.GlobalEventExecutor;
import io.netty.util.internal.SocketUtils;
import io.netty.util.internal.StringUtil;
import io.netty.util.internal.logging.InternalLogger;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import org.apache.commons.beanutils.PropertyUtils;

/* loaded from: classes3.dex */
public abstract class AbstractBootstrap<B extends AbstractBootstrap<B, C>, C extends Channel> implements Cloneable {
    private final Map<AttributeKey<?>, Object> attrs;
    private volatile ChannelFactory<? extends C> channelFactory;
    volatile EventLoopGroup group;
    private volatile ChannelHandler handler;
    private volatile SocketAddress localAddress;
    private final Map<ChannelOption<?>, Object> options;

    private B self() {
        return this;
    }

    @Override // 
    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public abstract B mo45clone();

    public abstract AbstractBootstrapConfig<B, C> config();

    abstract void init(Channel channel) throws Exception;

    AbstractBootstrap() {
        this.options = new LinkedHashMap();
        this.attrs = new LinkedHashMap();
    }

    AbstractBootstrap(AbstractBootstrap<B, C> abstractBootstrap) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.options = linkedHashMap;
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        this.attrs = linkedHashMap2;
        this.group = abstractBootstrap.group;
        this.channelFactory = abstractBootstrap.channelFactory;
        this.handler = abstractBootstrap.handler;
        this.localAddress = abstractBootstrap.localAddress;
        synchronized (abstractBootstrap.options) {
            linkedHashMap.putAll(abstractBootstrap.options);
        }
        synchronized (abstractBootstrap.attrs) {
            linkedHashMap2.putAll(abstractBootstrap.attrs);
        }
    }

    public B group(EventLoopGroup eventLoopGroup) {
        Objects.requireNonNull(eventLoopGroup, "group");
        if (this.group != null) {
            throw new IllegalStateException("group set already");
        }
        this.group = eventLoopGroup;
        return self();
    }

    public B channel(Class<? extends C> cls) {
        Objects.requireNonNull(cls, "channelClass");
        return channelFactory((io.netty.channel.ChannelFactory) new ReflectiveChannelFactory(cls));
    }

    @Deprecated
    public B channelFactory(ChannelFactory<? extends C> channelFactory) {
        Objects.requireNonNull(channelFactory, "channelFactory");
        if (this.channelFactory != null) {
            throw new IllegalStateException("channelFactory set already");
        }
        this.channelFactory = channelFactory;
        return self();
    }

    public B channelFactory(io.netty.channel.ChannelFactory<? extends C> channelFactory) {
        return channelFactory((ChannelFactory) channelFactory);
    }

    public B localAddress(SocketAddress socketAddress) {
        this.localAddress = socketAddress;
        return self();
    }

    public B localAddress(int i) {
        return localAddress(new InetSocketAddress(i));
    }

    public B localAddress(String str, int i) {
        return localAddress(SocketUtils.socketAddress(str, i));
    }

    public B localAddress(InetAddress inetAddress, int i) {
        return localAddress(new InetSocketAddress(inetAddress, i));
    }

    public <T> B option(ChannelOption<T> channelOption, T t) {
        Objects.requireNonNull(channelOption, "option");
        if (t == null) {
            synchronized (this.options) {
                this.options.remove(channelOption);
            }
        } else {
            synchronized (this.options) {
                this.options.put(channelOption, t);
            }
        }
        return self();
    }

    public <T> B attr(AttributeKey<T> attributeKey, T t) {
        Objects.requireNonNull(attributeKey, "key");
        if (t == null) {
            synchronized (this.attrs) {
                this.attrs.remove(attributeKey);
            }
        } else {
            synchronized (this.attrs) {
                this.attrs.put(attributeKey, t);
            }
        }
        return self();
    }

    public B validate() {
        if (this.group == null) {
            throw new IllegalStateException("group not set");
        }
        if (this.channelFactory == null) {
            throw new IllegalStateException("channel or channelFactory not set");
        }
        return self();
    }

    public ChannelFuture register() {
        validate();
        return initAndRegister();
    }

    public ChannelFuture bind() {
        validate();
        SocketAddress socketAddress = this.localAddress;
        if (socketAddress == null) {
            throw new IllegalStateException("localAddress not set");
        }
        return doBind(socketAddress);
    }

    public ChannelFuture bind(int i) {
        return bind(new InetSocketAddress(i));
    }

    public ChannelFuture bind(String str, int i) {
        return bind(SocketUtils.socketAddress(str, i));
    }

    public ChannelFuture bind(InetAddress inetAddress, int i) {
        return bind(new InetSocketAddress(inetAddress, i));
    }

    public ChannelFuture bind(SocketAddress socketAddress) {
        validate();
        Objects.requireNonNull(socketAddress, "localAddress");
        return doBind(socketAddress);
    }

    private ChannelFuture doBind(final SocketAddress socketAddress) {
        final ChannelFuture initAndRegister = initAndRegister();
        final Channel channel = initAndRegister.channel();
        if (initAndRegister.cause() != null) {
            return initAndRegister;
        }
        if (initAndRegister.isDone()) {
            ChannelPromise newPromise = channel.newPromise();
            doBind0(initAndRegister, channel, socketAddress, newPromise);
            return newPromise;
        }
        final PendingRegistrationPromise pendingRegistrationPromise = new PendingRegistrationPromise(channel);
        initAndRegister.addListener((GenericFutureListener<? extends Future<? super Void>>) new ChannelFutureListener() { // from class: io.netty.bootstrap.AbstractBootstrap.1
            @Override // io.netty.util.concurrent.GenericFutureListener
            public void operationComplete(ChannelFuture channelFuture) throws Exception {
                Throwable cause = channelFuture.cause();
                if (cause != null) {
                    pendingRegistrationPromise.setFailure(cause);
                } else {
                    pendingRegistrationPromise.registered();
                    AbstractBootstrap.doBind0(initAndRegister, channel, socketAddress, pendingRegistrationPromise);
                }
            }
        });
        return pendingRegistrationPromise;
    }

    final ChannelFuture initAndRegister() {
        C c = null;
        try {
            c = this.channelFactory.newChannel();
            init(c);
            ChannelFuture register = config().group().register(c);
            if (register.cause() != null) {
                if (c.isRegistered()) {
                    c.close();
                } else {
                    c.unsafe().closeForcibly();
                }
            }
            return register;
        } catch (Throwable th) {
            if (c != null) {
                c.unsafe().closeForcibly();
            }
            return new DefaultChannelPromise(c, GlobalEventExecutor.INSTANCE).setFailure(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void doBind0(final ChannelFuture channelFuture, final Channel channel, final SocketAddress socketAddress, final ChannelPromise channelPromise) {
        channel.eventLoop().execute(new Runnable() { // from class: io.netty.bootstrap.AbstractBootstrap.2
            @Override // java.lang.Runnable
            public void run() {
                if (ChannelFuture.this.isSuccess()) {
                    channel.bind(socketAddress, channelPromise).addListener((GenericFutureListener<? extends Future<? super Void>>) ChannelFutureListener.CLOSE_ON_FAILURE);
                } else {
                    channelPromise.setFailure(ChannelFuture.this.cause());
                }
            }
        });
    }

    public B handler(ChannelHandler channelHandler) {
        Objects.requireNonNull(channelHandler, "handler");
        this.handler = channelHandler;
        return self();
    }

    @Deprecated
    public final EventLoopGroup group() {
        return this.group;
    }

    static <K, V> Map<K, V> copiedMap(Map<K, V> map) {
        synchronized (map) {
            if (map.isEmpty()) {
                return Collections.emptyMap();
            }
            return Collections.unmodifiableMap(new LinkedHashMap(map));
        }
    }

    final Map<ChannelOption<?>, Object> options0() {
        return this.options;
    }

    final Map<AttributeKey<?>, Object> attrs0() {
        return this.attrs;
    }

    final SocketAddress localAddress() {
        return this.localAddress;
    }

    final ChannelFactory<? extends C> channelFactory() {
        return this.channelFactory;
    }

    final ChannelHandler handler() {
        return this.handler;
    }

    final Map<ChannelOption<?>, Object> options() {
        return copiedMap(this.options);
    }

    final Map<AttributeKey<?>, Object> attrs() {
        return copiedMap(this.attrs);
    }

    static void setChannelOptions(Channel channel, Map<ChannelOption<?>, Object> map, InternalLogger internalLogger) {
        for (Map.Entry<ChannelOption<?>, Object> entry : map.entrySet()) {
            setChannelOption(channel, entry.getKey(), entry.getValue(), internalLogger);
        }
    }

    static void setChannelOptions(Channel channel, Map.Entry<ChannelOption<?>, Object>[] entryArr, InternalLogger internalLogger) {
        for (Map.Entry<ChannelOption<?>, Object> entry : entryArr) {
            setChannelOption(channel, entry.getKey(), entry.getValue(), internalLogger);
        }
    }

    private static void setChannelOption(Channel channel, ChannelOption<?> channelOption, Object obj, InternalLogger internalLogger) {
        try {
            if (channel.config().setOption(channelOption, obj)) {
                return;
            }
            internalLogger.warn("Unknown channel option '{}' for channel '{}'", channelOption, channel);
        } catch (Throwable th) {
            internalLogger.warn("Failed to set channel option '{}' with value '{}' for channel '{}'", channelOption, obj, channel, th);
        }
    }

    public String toString() {
        return StringUtil.simpleClassName(this) + PropertyUtils.MAPPED_DELIM + config() + PropertyUtils.MAPPED_DELIM2;
    }

    static final class PendingRegistrationPromise extends DefaultChannelPromise {
        private volatile boolean registered;

        PendingRegistrationPromise(Channel channel) {
            super(channel);
        }

        void registered() {
            this.registered = true;
        }

        @Override // io.netty.channel.DefaultChannelPromise, io.netty.util.concurrent.DefaultPromise
        protected EventExecutor executor() {
            if (this.registered) {
                return super.executor();
            }
            return GlobalEventExecutor.INSTANCE;
        }
    }
}
