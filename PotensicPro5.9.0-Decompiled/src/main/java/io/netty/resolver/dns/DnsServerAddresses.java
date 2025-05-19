package io.netty.resolver.dns;

import com.mapbox.api.geocoding.v5.GeocodingCriteria;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* loaded from: classes4.dex */
public abstract class DnsServerAddresses {
    public abstract DnsServerAddressStream stream();

    @Deprecated
    public static List<InetSocketAddress> defaultAddressList() {
        return DefaultDnsServerAddressStreamProvider.defaultAddressList();
    }

    @Deprecated
    public static DnsServerAddresses defaultAddresses() {
        return DefaultDnsServerAddressStreamProvider.defaultAddresses();
    }

    public static DnsServerAddresses sequential(Iterable<? extends InetSocketAddress> iterable) {
        return sequential0(sanitize(iterable));
    }

    public static DnsServerAddresses sequential(InetSocketAddress... inetSocketAddressArr) {
        return sequential0(sanitize(inetSocketAddressArr));
    }

    private static DnsServerAddresses sequential0(InetSocketAddress... inetSocketAddressArr) {
        if (inetSocketAddressArr.length == 1) {
            return singleton(inetSocketAddressArr[0]);
        }
        return new DefaultDnsServerAddresses("sequential", inetSocketAddressArr) { // from class: io.netty.resolver.dns.DnsServerAddresses.1
            @Override // io.netty.resolver.dns.DnsServerAddresses
            public DnsServerAddressStream stream() {
                return new SequentialDnsServerAddressStream(this.addresses, 0);
            }
        };
    }

    public static DnsServerAddresses shuffled(Iterable<? extends InetSocketAddress> iterable) {
        return shuffled0(sanitize(iterable));
    }

    public static DnsServerAddresses shuffled(InetSocketAddress... inetSocketAddressArr) {
        return shuffled0(sanitize(inetSocketAddressArr));
    }

    private static DnsServerAddresses shuffled0(InetSocketAddress[] inetSocketAddressArr) {
        if (inetSocketAddressArr.length == 1) {
            return singleton(inetSocketAddressArr[0]);
        }
        return new DefaultDnsServerAddresses("shuffled", inetSocketAddressArr) { // from class: io.netty.resolver.dns.DnsServerAddresses.2
            @Override // io.netty.resolver.dns.DnsServerAddresses
            public DnsServerAddressStream stream() {
                return new ShuffledDnsServerAddressStream(this.addresses);
            }
        };
    }

    public static DnsServerAddresses rotational(Iterable<? extends InetSocketAddress> iterable) {
        return rotational0(sanitize(iterable));
    }

    public static DnsServerAddresses rotational(InetSocketAddress... inetSocketAddressArr) {
        return rotational0(sanitize(inetSocketAddressArr));
    }

    private static DnsServerAddresses rotational0(InetSocketAddress[] inetSocketAddressArr) {
        if (inetSocketAddressArr.length == 1) {
            return singleton(inetSocketAddressArr[0]);
        }
        return new RotationalDnsServerAddresses(inetSocketAddressArr);
    }

    public static DnsServerAddresses singleton(InetSocketAddress inetSocketAddress) {
        Objects.requireNonNull(inetSocketAddress, GeocodingCriteria.TYPE_ADDRESS);
        if (inetSocketAddress.isUnresolved()) {
            throw new IllegalArgumentException("cannot use an unresolved DNS server address: " + inetSocketAddress);
        }
        return new SingletonDnsServerAddresses(inetSocketAddress);
    }

    private static InetSocketAddress[] sanitize(Iterable<? extends InetSocketAddress> iterable) {
        ArrayList arrayList;
        InetSocketAddress next;
        Objects.requireNonNull(iterable, "addresses");
        if (iterable instanceof Collection) {
            arrayList = new ArrayList(((Collection) iterable).size());
        } else {
            arrayList = new ArrayList(4);
        }
        Iterator<? extends InetSocketAddress> it = iterable.iterator();
        while (it.hasNext() && (next = it.next()) != null) {
            if (next.isUnresolved()) {
                throw new IllegalArgumentException("cannot use an unresolved DNS server address: " + next);
            }
            arrayList.add(next);
        }
        if (arrayList.isEmpty()) {
            throw new IllegalArgumentException("empty addresses");
        }
        return (InetSocketAddress[]) arrayList.toArray(new InetSocketAddress[arrayList.size()]);
    }

    private static InetSocketAddress[] sanitize(InetSocketAddress[] inetSocketAddressArr) {
        Objects.requireNonNull(inetSocketAddressArr, "addresses");
        ArrayList arrayList = new ArrayList(inetSocketAddressArr.length);
        for (InetSocketAddress inetSocketAddress : inetSocketAddressArr) {
            if (inetSocketAddress == null) {
                break;
            }
            if (inetSocketAddress.isUnresolved()) {
                throw new IllegalArgumentException("cannot use an unresolved DNS server address: " + inetSocketAddress);
            }
            arrayList.add(inetSocketAddress);
        }
        if (arrayList.isEmpty()) {
            return DefaultDnsServerAddressStreamProvider.defaultAddressArray();
        }
        return (InetSocketAddress[]) arrayList.toArray(new InetSocketAddress[arrayList.size()]);
    }
}
