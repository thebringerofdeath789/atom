package io.netty.resolver.dns;

import io.netty.util.internal.ObjectUtil;

/* loaded from: classes4.dex */
abstract class UniSequentialDnsServerAddressStreamProvider implements DnsServerAddressStreamProvider {
    private final DnsServerAddresses addresses;

    UniSequentialDnsServerAddressStreamProvider(DnsServerAddresses dnsServerAddresses) {
        this.addresses = (DnsServerAddresses) ObjectUtil.checkNotNull(dnsServerAddresses, "addresses");
    }

    @Override // io.netty.resolver.dns.DnsServerAddressStreamProvider
    public final DnsServerAddressStream nameServerAddressStream(String str) {
        return this.addresses.stream();
    }
}
