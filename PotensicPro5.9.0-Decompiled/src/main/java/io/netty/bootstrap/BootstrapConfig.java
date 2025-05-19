package io.netty.bootstrap;

import io.netty.channel.Channel;
import io.netty.resolver.AddressResolverGroup;
import java.net.SocketAddress;
import org.apache.commons.beanutils.PropertyUtils;

/* loaded from: classes3.dex */
public final class BootstrapConfig extends AbstractBootstrapConfig<Bootstrap, Channel> {
    BootstrapConfig(Bootstrap bootstrap) {
        super(bootstrap);
    }

    public SocketAddress remoteAddress() {
        return ((Bootstrap) this.bootstrap).remoteAddress();
    }

    public AddressResolverGroup<?> resolver() {
        return ((Bootstrap) this.bootstrap).resolver();
    }

    @Override // io.netty.bootstrap.AbstractBootstrapConfig
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.setLength(sb.length() - 1);
        sb.append(", resolver: ").append(resolver());
        SocketAddress remoteAddress = remoteAddress();
        if (remoteAddress != null) {
            sb.append(", remoteAddress: ").append(remoteAddress);
        }
        return sb.append(PropertyUtils.MAPPED_DELIM2).toString();
    }
}
