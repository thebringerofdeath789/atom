package io.netty.resolver.dns;

import io.netty.channel.EventLoop;
import io.netty.handler.codec.dns.DnsRecord;
import java.net.InetAddress;
import java.util.List;

/* loaded from: classes4.dex */
public interface DnsCache {
    DnsCacheEntry cache(String str, DnsRecord[] dnsRecordArr, Throwable th, EventLoop eventLoop);

    DnsCacheEntry cache(String str, DnsRecord[] dnsRecordArr, InetAddress inetAddress, long j, EventLoop eventLoop);

    void clear();

    boolean clear(String str);

    List<? extends DnsCacheEntry> get(String str, DnsRecord[] dnsRecordArr);
}
