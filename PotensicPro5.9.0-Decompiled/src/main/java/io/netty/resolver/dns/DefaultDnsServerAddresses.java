package io.netty.resolver.dns;

import java.net.InetSocketAddress;
import org.apache.commons.beanutils.PropertyUtils;

/* loaded from: classes4.dex */
abstract class DefaultDnsServerAddresses extends DnsServerAddresses {
    protected final InetSocketAddress[] addresses;
    private final String strVal;

    DefaultDnsServerAddresses(String str, InetSocketAddress[] inetSocketAddressArr) {
        this.addresses = inetSocketAddressArr;
        StringBuilder sb = new StringBuilder(str.length() + 2 + (inetSocketAddressArr.length * 16));
        sb.append(str).append(PropertyUtils.MAPPED_DELIM);
        for (InetSocketAddress inetSocketAddress : inetSocketAddressArr) {
            sb.append(inetSocketAddress).append(", ");
        }
        sb.setLength(sb.length() - 2);
        sb.append(PropertyUtils.MAPPED_DELIM2);
        this.strVal = sb.toString();
    }

    public String toString() {
        return this.strVal;
    }
}
