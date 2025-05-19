package io.netty.resolver.dns;

import java.net.InetSocketAddress;

/* loaded from: classes4.dex */
final class SequentialDnsServerAddressStream implements DnsServerAddressStream {
    private final InetSocketAddress[] addresses;
    private int i;

    SequentialDnsServerAddressStream(InetSocketAddress[] inetSocketAddressArr, int i) {
        this.addresses = inetSocketAddressArr;
        this.i = i;
    }

    @Override // io.netty.resolver.dns.DnsServerAddressStream
    public InetSocketAddress next() {
        int i = this.i;
        InetSocketAddress[] inetSocketAddressArr = this.addresses;
        InetSocketAddress inetSocketAddress = inetSocketAddressArr[i];
        int i2 = i + 1;
        if (i2 < inetSocketAddressArr.length) {
            this.i = i2;
        } else {
            this.i = 0;
        }
        return inetSocketAddress;
    }

    @Override // io.netty.resolver.dns.DnsServerAddressStream
    public int size() {
        return this.addresses.length;
    }

    @Override // io.netty.resolver.dns.DnsServerAddressStream
    public SequentialDnsServerAddressStream duplicate() {
        return new SequentialDnsServerAddressStream(this.addresses, this.i);
    }

    public String toString() {
        return toString("sequential", this.i, this.addresses);
    }

    static String toString(String str, int i, InetSocketAddress[] inetSocketAddressArr) {
        StringBuilder sb = new StringBuilder(str.length() + 2 + (inetSocketAddressArr.length * 16));
        sb.append(str).append("(index: ").append(i);
        sb.append(", addrs: (");
        for (InetSocketAddress inetSocketAddress : inetSocketAddressArr) {
            sb.append(inetSocketAddress).append(", ");
        }
        sb.setLength(sb.length() - 2);
        sb.append("))");
        return sb.toString();
    }
}
