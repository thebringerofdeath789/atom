package io.netty.resolver.dns;

import io.netty.handler.codec.dns.DnsQuestion;
import java.net.InetSocketAddress;

/* loaded from: classes4.dex */
public final class DnsNameResolverTimeoutException extends DnsNameResolverException {
    private static final long serialVersionUID = -8826717969627131854L;

    public DnsNameResolverTimeoutException(InetSocketAddress inetSocketAddress, DnsQuestion dnsQuestion, String str) {
        super(inetSocketAddress, dnsQuestion, str);
    }
}
