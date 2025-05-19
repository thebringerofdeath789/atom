package io.netty.resolver.dns;

import io.netty.util.internal.PlatformDependent;

/* loaded from: classes4.dex */
public final class DnsServerAddressStreamProviders {
    private static final DnsServerAddressStreamProvider DEFAULT_DNS_SERVER_ADDRESS_STREAM_PROVIDER;

    static {
        DEFAULT_DNS_SERVER_ADDRESS_STREAM_PROVIDER = PlatformDependent.isWindows() ? DefaultDnsServerAddressStreamProvider.INSTANCE : UnixResolverDnsServerAddressStreamProvider.parseSilently();
    }

    private DnsServerAddressStreamProviders() {
    }

    public static DnsServerAddressStreamProvider platformDefault() {
        return DEFAULT_DNS_SERVER_ADDRESS_STREAM_PROVIDER;
    }
}
