package io.netty.resolver.dns;

import io.netty.handler.codec.dns.DnsQuestion;

/* loaded from: classes4.dex */
public interface DnsQueryLifecycleObserverFactory {
    DnsQueryLifecycleObserver newDnsQueryLifecycleObserver(DnsQuestion dnsQuestion);
}
