package io.netty.handler.proxy;

import io.netty.util.internal.StringUtil;
import java.net.SocketAddress;
import java.util.Objects;
import org.apache.commons.beanutils.PropertyUtils;

/* loaded from: classes.dex */
public final class ProxyConnectionEvent {
    private final String authScheme;
    private final SocketAddress destinationAddress;
    private final String protocol;
    private final SocketAddress proxyAddress;
    private String strVal;

    public ProxyConnectionEvent(String str, String str2, SocketAddress socketAddress, SocketAddress socketAddress2) {
        Objects.requireNonNull(str, "protocol");
        Objects.requireNonNull(str2, "authScheme");
        Objects.requireNonNull(socketAddress, "proxyAddress");
        Objects.requireNonNull(socketAddress2, "destinationAddress");
        this.protocol = str;
        this.authScheme = str2;
        this.proxyAddress = socketAddress;
        this.destinationAddress = socketAddress2;
    }

    public String protocol() {
        return this.protocol;
    }

    public String authScheme() {
        return this.authScheme;
    }

    public <T extends SocketAddress> T proxyAddress() {
        return (T) this.proxyAddress;
    }

    public <T extends SocketAddress> T destinationAddress() {
        return (T) this.destinationAddress;
    }

    public String toString() {
        String str = this.strVal;
        if (str != null) {
            return str;
        }
        String sb = new StringBuilder(128).append(StringUtil.simpleClassName(this)).append(PropertyUtils.MAPPED_DELIM).append(this.protocol).append(", ").append(this.authScheme).append(", ").append(this.proxyAddress).append(" => ").append(this.destinationAddress).append(PropertyUtils.MAPPED_DELIM2).toString();
        this.strVal = sb;
        return sb;
    }
}
