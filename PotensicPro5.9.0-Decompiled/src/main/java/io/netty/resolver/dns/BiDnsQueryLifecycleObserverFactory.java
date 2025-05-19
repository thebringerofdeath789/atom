package io.netty.resolver.dns;

import io.netty.handler.codec.dns.DnsQuestion;
import io.netty.util.internal.ObjectUtil;

/* loaded from: classes4.dex */
public final class BiDnsQueryLifecycleObserverFactory implements DnsQueryLifecycleObserverFactory {
    private final DnsQueryLifecycleObserverFactory a;
    private final DnsQueryLifecycleObserverFactory b;

    public BiDnsQueryLifecycleObserverFactory(DnsQueryLifecycleObserverFactory dnsQueryLifecycleObserverFactory, DnsQueryLifecycleObserverFactory dnsQueryLifecycleObserverFactory2) {
        this.a = (DnsQueryLifecycleObserverFactory) ObjectUtil.checkNotNull(dnsQueryLifecycleObserverFactory, "a");
        this.b = (DnsQueryLifecycleObserverFactory) ObjectUtil.checkNotNull(dnsQueryLifecycleObserverFactory2, "b");
    }

    @Override // io.netty.resolver.dns.DnsQueryLifecycleObserverFactory
    public DnsQueryLifecycleObserver newDnsQueryLifecycleObserver(DnsQuestion dnsQuestion) {
        return new BiDnsQueryLifecycleObserver(this.a.newDnsQueryLifecycleObserver(dnsQuestion), this.b.newDnsQueryLifecycleObserver(dnsQuestion));
    }
}
