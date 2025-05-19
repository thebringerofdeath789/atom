package io.netty.resolver.dns;

import com.mapbox.api.geocoding.v5.GeocodingCriteria;
import io.netty.channel.EventLoop;
import io.netty.handler.codec.dns.DnsRecord;
import io.netty.util.concurrent.ScheduledFuture;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.TimeUnit;

/* loaded from: classes4.dex */
public class DefaultDnsCache implements DnsCache {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final int maxTtl;
    private final int minTtl;
    private final int negativeTtl;
    private final ConcurrentMap<String, List<DefaultDnsCacheEntry>> resolveCache;

    public DefaultDnsCache() {
        this(0, Integer.MAX_VALUE, 0);
    }

    public DefaultDnsCache(int i, int i2, int i3) {
        this.resolveCache = PlatformDependent.newConcurrentHashMap();
        this.minTtl = ObjectUtil.checkPositiveOrZero(i, "minTtl");
        this.maxTtl = ObjectUtil.checkPositiveOrZero(i2, "maxTtl");
        if (i > i2) {
            throw new IllegalArgumentException("minTtl: " + i + ", maxTtl: " + i2 + " (expected: 0 <= minTtl <= maxTtl)");
        }
        this.negativeTtl = ObjectUtil.checkPositiveOrZero(i3, "negativeTtl");
    }

    public int minTtl() {
        return this.minTtl;
    }

    public int maxTtl() {
        return this.maxTtl;
    }

    public int negativeTtl() {
        return this.negativeTtl;
    }

    @Override // io.netty.resolver.dns.DnsCache
    public void clear() {
        Iterator<Map.Entry<String, List<DefaultDnsCacheEntry>>> it = this.resolveCache.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, List<DefaultDnsCacheEntry>> next = it.next();
            it.remove();
            cancelExpiration(next.getValue());
        }
    }

    @Override // io.netty.resolver.dns.DnsCache
    public boolean clear(String str) {
        ObjectUtil.checkNotNull(str, "hostname");
        Iterator<Map.Entry<String, List<DefaultDnsCacheEntry>>> it = this.resolveCache.entrySet().iterator();
        boolean z = false;
        while (it.hasNext()) {
            Map.Entry<String, List<DefaultDnsCacheEntry>> next = it.next();
            if (next.getKey().equals(str)) {
                it.remove();
                cancelExpiration(next.getValue());
                z = true;
            }
        }
        return z;
    }

    private static boolean emptyAdditionals(DnsRecord[] dnsRecordArr) {
        return dnsRecordArr == null || dnsRecordArr.length == 0;
    }

    @Override // io.netty.resolver.dns.DnsCache
    public List<? extends DnsCacheEntry> get(String str, DnsRecord[] dnsRecordArr) {
        ObjectUtil.checkNotNull(str, "hostname");
        if (emptyAdditionals(dnsRecordArr)) {
            return this.resolveCache.get(str);
        }
        return null;
    }

    private List<DefaultDnsCacheEntry> cachedEntries(String str) {
        List<DefaultDnsCacheEntry> list = this.resolveCache.get(str);
        if (list != null) {
            return list;
        }
        ArrayList arrayList = new ArrayList(8);
        List<DefaultDnsCacheEntry> putIfAbsent = this.resolveCache.putIfAbsent(str, arrayList);
        return putIfAbsent != null ? putIfAbsent : arrayList;
    }

    @Override // io.netty.resolver.dns.DnsCache
    public DnsCacheEntry cache(String str, DnsRecord[] dnsRecordArr, InetAddress inetAddress, long j, EventLoop eventLoop) {
        ObjectUtil.checkNotNull(str, "hostname");
        ObjectUtil.checkNotNull(inetAddress, GeocodingCriteria.TYPE_ADDRESS);
        ObjectUtil.checkNotNull(eventLoop, "loop");
        DefaultDnsCacheEntry defaultDnsCacheEntry = new DefaultDnsCacheEntry(str, inetAddress);
        if (this.maxTtl == 0 || !emptyAdditionals(dnsRecordArr)) {
            return defaultDnsCacheEntry;
        }
        int max = Math.max(this.minTtl, (int) Math.min(this.maxTtl, j));
        List<DefaultDnsCacheEntry> cachedEntries = cachedEntries(str);
        synchronized (cachedEntries) {
            if (!cachedEntries.isEmpty()) {
                DefaultDnsCacheEntry defaultDnsCacheEntry2 = cachedEntries.get(0);
                if (defaultDnsCacheEntry2.cause() != null) {
                    defaultDnsCacheEntry2.cancelExpiration();
                    cachedEntries.clear();
                }
            }
            cachedEntries.add(defaultDnsCacheEntry);
        }
        scheduleCacheExpiration(cachedEntries, defaultDnsCacheEntry, max, eventLoop);
        return defaultDnsCacheEntry;
    }

    @Override // io.netty.resolver.dns.DnsCache
    public DnsCacheEntry cache(String str, DnsRecord[] dnsRecordArr, Throwable th, EventLoop eventLoop) {
        ObjectUtil.checkNotNull(str, "hostname");
        ObjectUtil.checkNotNull(th, "cause");
        ObjectUtil.checkNotNull(eventLoop, "loop");
        DefaultDnsCacheEntry defaultDnsCacheEntry = new DefaultDnsCacheEntry(str, th);
        if (this.negativeTtl == 0 || !emptyAdditionals(dnsRecordArr)) {
            return defaultDnsCacheEntry;
        }
        List<DefaultDnsCacheEntry> cachedEntries = cachedEntries(str);
        synchronized (cachedEntries) {
            int size = cachedEntries.size();
            for (int i = 0; i < size; i++) {
                cachedEntries.get(i).cancelExpiration();
            }
            cachedEntries.clear();
            cachedEntries.add(defaultDnsCacheEntry);
        }
        scheduleCacheExpiration(cachedEntries, defaultDnsCacheEntry, this.negativeTtl, eventLoop);
        return defaultDnsCacheEntry;
    }

    private static void cancelExpiration(List<DefaultDnsCacheEntry> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            list.get(i).cancelExpiration();
        }
    }

    private void scheduleCacheExpiration(final List<DefaultDnsCacheEntry> list, final DefaultDnsCacheEntry defaultDnsCacheEntry, int i, EventLoop eventLoop) {
        defaultDnsCacheEntry.scheduleExpiration(eventLoop, new Runnable() { // from class: io.netty.resolver.dns.DefaultDnsCache.1
            @Override // java.lang.Runnable
            public void run() {
                synchronized (list) {
                    list.remove(defaultDnsCacheEntry);
                    if (list.isEmpty()) {
                        DefaultDnsCache.this.resolveCache.remove(defaultDnsCacheEntry.hostname());
                    }
                }
            }
        }, i, TimeUnit.SECONDS);
    }

    public String toString() {
        return "DefaultDnsCache(minTtl=" + this.minTtl + ", maxTtl=" + this.maxTtl + ", negativeTtl=" + this.negativeTtl + ", cached resolved hostname=" + this.resolveCache.size() + ")";
    }

    private static final class DefaultDnsCacheEntry implements DnsCacheEntry {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final InetAddress address;
        private final Throwable cause;
        private volatile ScheduledFuture<?> expirationFuture;
        private final String hostname;

        DefaultDnsCacheEntry(String str, InetAddress inetAddress) {
            this.hostname = (String) ObjectUtil.checkNotNull(str, "hostname");
            this.address = (InetAddress) ObjectUtil.checkNotNull(inetAddress, GeocodingCriteria.TYPE_ADDRESS);
            this.cause = null;
        }

        DefaultDnsCacheEntry(String str, Throwable th) {
            this.hostname = (String) ObjectUtil.checkNotNull(str, "hostname");
            this.cause = (Throwable) ObjectUtil.checkNotNull(th, "cause");
            this.address = null;
        }

        @Override // io.netty.resolver.dns.DnsCacheEntry
        public InetAddress address() {
            return this.address;
        }

        @Override // io.netty.resolver.dns.DnsCacheEntry
        public Throwable cause() {
            return this.cause;
        }

        String hostname() {
            return this.hostname;
        }

        void scheduleExpiration(EventLoop eventLoop, Runnable runnable, long j, TimeUnit timeUnit) {
            this.expirationFuture = eventLoop.schedule(runnable, j, timeUnit);
        }

        void cancelExpiration() {
            ScheduledFuture<?> scheduledFuture = this.expirationFuture;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(false);
            }
        }

        public String toString() {
            if (this.cause != null) {
                return this.hostname + '/' + this.cause;
            }
            return this.address.toString();
        }
    }
}
