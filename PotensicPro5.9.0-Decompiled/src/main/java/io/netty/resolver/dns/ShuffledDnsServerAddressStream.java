package io.netty.resolver.dns;

import io.netty.util.internal.PlatformDependent;
import java.net.InetSocketAddress;
import java.util.Random;

/* loaded from: classes4.dex */
final class ShuffledDnsServerAddressStream implements DnsServerAddressStream {
    private final InetSocketAddress[] addresses;
    private int i;

    ShuffledDnsServerAddressStream(InetSocketAddress[] inetSocketAddressArr) {
        this.addresses = inetSocketAddressArr;
        shuffle();
    }

    private ShuffledDnsServerAddressStream(InetSocketAddress[] inetSocketAddressArr, int i) {
        this.addresses = inetSocketAddressArr;
        this.i = i;
    }

    private void shuffle() {
        InetSocketAddress[] inetSocketAddressArr = this.addresses;
        Random threadLocalRandom = PlatformDependent.threadLocalRandom();
        for (int length = inetSocketAddressArr.length - 1; length >= 0; length--) {
            InetSocketAddress inetSocketAddress = inetSocketAddressArr[length];
            int nextInt = threadLocalRandom.nextInt(length + 1);
            inetSocketAddressArr[length] = inetSocketAddressArr[nextInt];
            inetSocketAddressArr[nextInt] = inetSocketAddress;
        }
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
            shuffle();
        }
        return inetSocketAddress;
    }

    @Override // io.netty.resolver.dns.DnsServerAddressStream
    public int size() {
        return this.addresses.length;
    }

    @Override // io.netty.resolver.dns.DnsServerAddressStream
    public ShuffledDnsServerAddressStream duplicate() {
        return new ShuffledDnsServerAddressStream(this.addresses, this.i);
    }

    public String toString() {
        return SequentialDnsServerAddressStream.toString("shuffled", this.i, this.addresses);
    }
}
