package io.netty.resolver.dns;

import io.netty.channel.ChannelFuture;
import io.netty.handler.codec.dns.DnsQuestion;
import io.netty.handler.codec.dns.DnsResponseCode;
import io.netty.util.internal.ObjectUtil;
import java.net.InetSocketAddress;
import java.util.List;

/* loaded from: classes4.dex */
public final class BiDnsQueryLifecycleObserver implements DnsQueryLifecycleObserver {
    private final DnsQueryLifecycleObserver a;
    private final DnsQueryLifecycleObserver b;

    public BiDnsQueryLifecycleObserver(DnsQueryLifecycleObserver dnsQueryLifecycleObserver, DnsQueryLifecycleObserver dnsQueryLifecycleObserver2) {
        this.a = (DnsQueryLifecycleObserver) ObjectUtil.checkNotNull(dnsQueryLifecycleObserver, "a");
        this.b = (DnsQueryLifecycleObserver) ObjectUtil.checkNotNull(dnsQueryLifecycleObserver2, "b");
    }

    @Override // io.netty.resolver.dns.DnsQueryLifecycleObserver
    public void queryWritten(InetSocketAddress inetSocketAddress, ChannelFuture channelFuture) {
        try {
            this.a.queryWritten(inetSocketAddress, channelFuture);
        } finally {
            this.b.queryWritten(inetSocketAddress, channelFuture);
        }
    }

    @Override // io.netty.resolver.dns.DnsQueryLifecycleObserver
    public void queryCancelled(int i) {
        try {
            this.a.queryCancelled(i);
        } finally {
            this.b.queryCancelled(i);
        }
    }

    @Override // io.netty.resolver.dns.DnsQueryLifecycleObserver
    public DnsQueryLifecycleObserver queryRedirected(List<InetSocketAddress> list) {
        try {
            this.a.queryRedirected(list);
            return this;
        } finally {
            this.b.queryRedirected(list);
        }
    }

    @Override // io.netty.resolver.dns.DnsQueryLifecycleObserver
    public DnsQueryLifecycleObserver queryCNAMEd(DnsQuestion dnsQuestion) {
        try {
            this.a.queryCNAMEd(dnsQuestion);
            return this;
        } finally {
            this.b.queryCNAMEd(dnsQuestion);
        }
    }

    @Override // io.netty.resolver.dns.DnsQueryLifecycleObserver
    public DnsQueryLifecycleObserver queryNoAnswer(DnsResponseCode dnsResponseCode) {
        try {
            this.a.queryNoAnswer(dnsResponseCode);
            return this;
        } finally {
            this.b.queryNoAnswer(dnsResponseCode);
        }
    }

    @Override // io.netty.resolver.dns.DnsQueryLifecycleObserver
    public void queryFailed(Throwable th) {
        try {
            this.a.queryFailed(th);
        } finally {
            this.b.queryFailed(th);
        }
    }

    @Override // io.netty.resolver.dns.DnsQueryLifecycleObserver
    public void querySucceed() {
        try {
            this.a.querySucceed();
        } finally {
            this.b.querySucceed();
        }
    }
}
