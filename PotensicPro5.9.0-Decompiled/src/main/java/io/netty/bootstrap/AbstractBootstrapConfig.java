package io.netty.bootstrap;

import io.netty.bootstrap.AbstractBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.util.AttributeKey;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;
import java.net.SocketAddress;
import java.util.Map;
import org.apache.commons.beanutils.PropertyUtils;

/* loaded from: classes3.dex */
public abstract class AbstractBootstrapConfig<B extends AbstractBootstrap<B, C>, C extends Channel> {
    protected final B bootstrap;

    protected AbstractBootstrapConfig(B b) {
        this.bootstrap = (B) ObjectUtil.checkNotNull(b, "bootstrap");
    }

    public final SocketAddress localAddress() {
        return this.bootstrap.localAddress();
    }

    public final ChannelFactory<? extends C> channelFactory() {
        return this.bootstrap.channelFactory();
    }

    public final ChannelHandler handler() {
        return this.bootstrap.handler();
    }

    public final Map<ChannelOption<?>, Object> options() {
        return this.bootstrap.options();
    }

    public final Map<AttributeKey<?>, Object> attrs() {
        return this.bootstrap.attrs();
    }

    public final EventLoopGroup group() {
        return this.bootstrap.group();
    }

    public String toString() {
        StringBuilder append = new StringBuilder().append(StringUtil.simpleClassName(this)).append(PropertyUtils.MAPPED_DELIM);
        EventLoopGroup group = group();
        if (group != null) {
            append.append("group: ").append(StringUtil.simpleClassName(group)).append(", ");
        }
        ChannelFactory<? extends C> channelFactory = channelFactory();
        if (channelFactory != null) {
            append.append("channelFactory: ").append(channelFactory).append(", ");
        }
        SocketAddress localAddress = localAddress();
        if (localAddress != null) {
            append.append("localAddress: ").append(localAddress).append(", ");
        }
        Map<ChannelOption<?>, Object> options = options();
        if (!options.isEmpty()) {
            append.append("options: ").append(options).append(", ");
        }
        Map<AttributeKey<?>, Object> attrs = attrs();
        if (!attrs.isEmpty()) {
            append.append("attrs: ").append(attrs).append(", ");
        }
        ChannelHandler handler = handler();
        if (handler != null) {
            append.append("handler: ").append(handler).append(", ");
        }
        if (append.charAt(append.length() - 1) == '(') {
            append.append(PropertyUtils.MAPPED_DELIM2);
        } else {
            append.setCharAt(append.length() - 2, PropertyUtils.MAPPED_DELIM2);
            append.setLength(append.length() - 1);
        }
        return append.toString();
    }
}
