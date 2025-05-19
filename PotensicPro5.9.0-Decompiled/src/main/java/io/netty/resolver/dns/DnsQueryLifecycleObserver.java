package io.netty.resolver.dns;

import io.netty.channel.ChannelFuture;
import io.netty.handler.codec.dns.DnsQuestion;
import io.netty.handler.codec.dns.DnsResponseCode;
import java.net.InetSocketAddress;
import java.util.List;

/* loaded from: classes4.dex */
public interface DnsQueryLifecycleObserver {
    DnsQueryLifecycleObserver queryCNAMEd(DnsQuestion dnsQuestion);

    void queryCancelled(int i);

    void queryFailed(Throwable th);

    DnsQueryLifecycleObserver queryNoAnswer(DnsResponseCode dnsResponseCode);

    DnsQueryLifecycleObserver queryRedirected(List<InetSocketAddress> list);

    void querySucceed();

    void queryWritten(InetSocketAddress inetSocketAddress, ChannelFuture channelFuture);
}
