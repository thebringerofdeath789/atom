package io.netty.resolver.dns;

import java.net.InetSocketAddress;

/* loaded from: classes4.dex */
final class SingletonDnsServerAddresses extends DnsServerAddresses {
    private final InetSocketAddress address;
    private final DnsServerAddressStream stream = new DnsServerAddressStream() { // from class: io.netty.resolver.dns.SingletonDnsServerAddresses.1
        @Override // io.netty.resolver.dns.DnsServerAddressStream
        public DnsServerAddressStream duplicate() {
            return this;
        }

        @Override // io.netty.resolver.dns.DnsServerAddressStream
        public int size() {
            return 1;
        }

        @Override // io.netty.resolver.dns.DnsServerAddressStream
        public InetSocketAddress next() {
            return SingletonDnsServerAddresses.this.address;
        }

        public String toString() {
            return SingletonDnsServerAddresses.this.toString();
        }
    };

    SingletonDnsServerAddresses(InetSocketAddress inetSocketAddress) {
        this.address = inetSocketAddress;
    }

    @Override // io.netty.resolver.dns.DnsServerAddresses
    public DnsServerAddressStream stream() {
        return this.stream;
    }

    public String toString() {
        return "singleton(" + this.address + ")";
    }
}
