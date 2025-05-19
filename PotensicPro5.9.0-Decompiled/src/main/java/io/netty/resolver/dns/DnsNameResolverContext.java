package io.netty.resolver.dns;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufHolder;
import io.netty.channel.AddressedEnvelope;
import io.netty.channel.ChannelPromise;
import io.netty.channel.socket.InternetProtocolFamily;
import io.netty.handler.codec.CorruptedFrameException;
import io.netty.handler.codec.dns.DefaultDnsQuestion;
import io.netty.handler.codec.dns.DefaultDnsRecordDecoder;
import io.netty.handler.codec.dns.DnsQuestion;
import io.netty.handler.codec.dns.DnsRawRecord;
import io.netty.handler.codec.dns.DnsRecord;
import io.netty.handler.codec.dns.DnsRecordType;
import io.netty.handler.codec.dns.DnsResponse;
import io.netty.handler.codec.dns.DnsResponseCode;
import io.netty.handler.codec.dns.DnsSection;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.FutureListener;
import io.netty.util.concurrent.GenericFutureListener;
import io.netty.util.concurrent.Promise;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.StringUtil;
import io.netty.util.internal.ThrowableUtil;
import java.net.IDN;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

/* loaded from: classes4.dex */
abstract class DnsNameResolverContext<T> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int INADDRSZ4 = 4;
    private static final int INADDRSZ6 = 16;
    private final DnsRecord[] additionals;
    private int allowedQueries;
    private final String hostname;
    private final int maxAllowedQueries;
    private final DnsServerAddressStream nameServerAddrs;
    private final DnsNameResolver parent;
    private final Set<Future<AddressedEnvelope<DnsResponse, InetSocketAddress>>> queriesInProgress = Collections.newSetFromMap(new IdentityHashMap());
    private final DnsCache resolveCache;
    private List<DnsCacheEntry> resolvedEntries;
    private final InternetProtocolFamily[] resolvedInternetProtocolFamilies;
    private boolean triedCNAME;
    private static final FutureListener<AddressedEnvelope<DnsResponse, InetSocketAddress>> RELEASE_RESPONSE = new FutureListener<AddressedEnvelope<DnsResponse, InetSocketAddress>>() { // from class: io.netty.resolver.dns.DnsNameResolverContext.1
        @Override // io.netty.util.concurrent.GenericFutureListener
        public void operationComplete(Future<AddressedEnvelope<DnsResponse, InetSocketAddress>> future) {
            if (future.isSuccess()) {
                future.getNow().release();
            }
        }
    };
    private static final RuntimeException NXDOMAIN_QUERY_FAILED_EXCEPTION = (RuntimeException) ThrowableUtil.unknownStackTrace(new RuntimeException("No answer found and NXDOMAIN response code returned"), DnsNameResolverContext.class, "onResponse(..)");
    private static final RuntimeException CNAME_NOT_FOUND_QUERY_FAILED_EXCEPTION = (RuntimeException) ThrowableUtil.unknownStackTrace(new RuntimeException("No matching CNAME record found"), DnsNameResolverContext.class, "onResponseCNAME(..)");
    private static final RuntimeException NO_MATCHING_RECORD_QUERY_FAILED_EXCEPTION = (RuntimeException) ThrowableUtil.unknownStackTrace(new RuntimeException("No matching record type found"), DnsNameResolverContext.class, "onResponseAorAAAA(..)");
    private static final RuntimeException UNRECOGNIZED_TYPE_QUERY_FAILED_EXCEPTION = (RuntimeException) ThrowableUtil.unknownStackTrace(new RuntimeException("Response type was unrecognized"), DnsNameResolverContext.class, "onResponse(..)");
    private static final RuntimeException NAME_SERVERS_EXHAUSTED_EXCEPTION = (RuntimeException) ThrowableUtil.unknownStackTrace(new RuntimeException("No name servers returned an answer"), DnsNameResolverContext.class, "tryToFinishResolve(..)");

    abstract boolean finishResolve(Class<? extends InetAddress> cls, List<DnsCacheEntry> list, Promise<T> promise);

    abstract DnsNameResolverContext<T> newResolverContext(DnsNameResolver dnsNameResolver, String str, DnsRecord[] dnsRecordArr, DnsCache dnsCache, DnsServerAddressStream dnsServerAddressStream);

    DnsNameResolverContext(DnsNameResolver dnsNameResolver, String str, DnsRecord[] dnsRecordArr, DnsCache dnsCache, DnsServerAddressStream dnsServerAddressStream) {
        this.parent = dnsNameResolver;
        this.hostname = str;
        this.additionals = dnsRecordArr;
        this.resolveCache = dnsCache;
        this.nameServerAddrs = (DnsServerAddressStream) ObjectUtil.checkNotNull(dnsServerAddressStream, "nameServerAddrs");
        int maxQueriesPerResolve = dnsNameResolver.maxQueriesPerResolve();
        this.maxAllowedQueries = maxQueriesPerResolve;
        this.resolvedInternetProtocolFamilies = dnsNameResolver.resolvedInternetProtocolFamiliesUnsafe();
        this.allowedQueries = maxQueriesPerResolve;
    }

    void resolve(Promise<T> promise) {
        String[] searchDomains = this.parent.searchDomains();
        if (searchDomains.length == 0 || this.parent.ndots() == 0 || StringUtil.endsWith(this.hostname, '.')) {
            internalResolve(promise);
        } else {
            boolean hasNDots = hasNDots();
            doSearchDomainQuery(hasNDots ? this.hostname : this.hostname + '.' + searchDomains[0], new FutureListener<T>(!hasNDots ? 1 : 0, promise, searchDomains, hasNDots) { // from class: io.netty.resolver.dns.DnsNameResolverContext.2
                private int searchDomainIdx;
                final /* synthetic */ int val$initialSearchDomainIdx;
                final /* synthetic */ Promise val$promise;
                final /* synthetic */ String[] val$searchDomains;
                final /* synthetic */ boolean val$startWithoutSearchDomain;

                {
                    this.val$initialSearchDomainIdx = r2;
                    this.val$promise = promise;
                    this.val$searchDomains = searchDomains;
                    this.val$startWithoutSearchDomain = hasNDots;
                    this.searchDomainIdx = r2;
                }

                @Override // io.netty.util.concurrent.GenericFutureListener
                public void operationComplete(Future<T> future) throws Exception {
                    Throwable cause = future.cause();
                    if (cause == null) {
                        this.val$promise.trySuccess(future.getNow());
                        return;
                    }
                    if (DnsNameResolver.isTransportOrTimeoutError(cause)) {
                        this.val$promise.tryFailure(new SearchDomainUnknownHostException(cause, DnsNameResolverContext.this.hostname));
                        return;
                    }
                    if (this.searchDomainIdx < this.val$searchDomains.length) {
                        DnsNameResolverContext dnsNameResolverContext = DnsNameResolverContext.this;
                        StringBuilder append = new StringBuilder().append(DnsNameResolverContext.this.hostname).append('.');
                        String[] strArr = this.val$searchDomains;
                        int i = this.searchDomainIdx;
                        this.searchDomainIdx = i + 1;
                        dnsNameResolverContext.doSearchDomainQuery(append.append(strArr[i]).toString(), this);
                        return;
                    }
                    if (!this.val$startWithoutSearchDomain) {
                        DnsNameResolverContext.this.internalResolve(this.val$promise);
                    } else {
                        this.val$promise.tryFailure(new SearchDomainUnknownHostException(cause, DnsNameResolverContext.this.hostname));
                    }
                }
            });
        }
    }

    private boolean hasNDots() {
        int i = 0;
        for (int length = this.hostname.length() - 1; length >= 0; length--) {
            if (this.hostname.charAt(length) == '.' && (i = i + 1) >= this.parent.ndots()) {
                return true;
            }
        }
        return false;
    }

    private static final class SearchDomainUnknownHostException extends UnknownHostException {
        private static final long serialVersionUID = -8573510133644997085L;

        @Override // java.lang.Throwable
        public Throwable fillInStackTrace() {
            return this;
        }

        SearchDomainUnknownHostException(Throwable th, String str) {
            super("Search domain query failed. Original hostname: '" + str + "' " + th.getMessage());
            setStackTrace(th.getStackTrace());
            initCause(th.getCause());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doSearchDomainQuery(String str, FutureListener<T> futureListener) {
        DnsNameResolverContext<T> newResolverContext = newResolverContext(this.parent, str, this.additionals, this.resolveCache, this.nameServerAddrs);
        Promise<T> newPromise = this.parent.executor().newPromise();
        newResolverContext.internalResolve(newPromise);
        newPromise.addListener((GenericFutureListener<? extends Future<? super T>>) futureListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void internalResolve(Promise<T> promise) {
        DnsServerAddressStream nameServers = getNameServers(this.hostname);
        DnsRecordType[] resolveRecordTypes = this.parent.resolveRecordTypes();
        int length = resolveRecordTypes.length - 1;
        for (int i = 0; i < length; i++) {
            if (!query(this.hostname, resolveRecordTypes[i], nameServers.duplicate(), promise, (Throwable) null)) {
                return;
            }
        }
        query(this.hostname, resolveRecordTypes[length], nameServers, promise, (Throwable) null);
    }

    private void addNameServerToCache(AuthoritativeNameServer authoritativeNameServer, InetAddress inetAddress, long j) {
        if (authoritativeNameServer.isRootServer()) {
            return;
        }
        this.parent.authoritativeDnsServerCache().cache(authoritativeNameServer.domainName(), this.additionals, inetAddress, j, this.parent.ch.eventLoop());
    }

    private DnsServerAddressStream getNameServersFromCache(String str) {
        int length = str.length();
        if (length == 0) {
            return null;
        }
        if (str.charAt(length - 1) != '.') {
            str = str + ".";
        }
        int indexOf = str.indexOf(46);
        if (indexOf == str.length() - 1) {
            return null;
        }
        while (true) {
            str = str.substring(indexOf + 1);
            indexOf = str.indexOf(46);
            if (indexOf <= 0 || indexOf == str.length() - 1) {
                break;
            }
            List<? extends DnsCacheEntry> list = this.parent.authoritativeDnsServerCache().get(str, this.additionals);
            if (list != null && !list.isEmpty()) {
                return DnsServerAddresses.sequential(new DnsCacheIterable(list)).stream();
            }
        }
        return null;
    }

    private final class DnsCacheIterable implements Iterable<InetSocketAddress> {
        private final List<? extends DnsCacheEntry> entries;

        DnsCacheIterable(List<? extends DnsCacheEntry> list) {
            this.entries = list;
        }

        @Override // java.lang.Iterable
        public Iterator<InetSocketAddress> iterator() {
            return new Iterator<InetSocketAddress>() { // from class: io.netty.resolver.dns.DnsNameResolverContext.DnsCacheIterable.1
                Iterator<? extends DnsCacheEntry> entryIterator;

                {
                    this.entryIterator = DnsCacheIterable.this.entries.iterator();
                }

                @Override // java.util.Iterator
                public boolean hasNext() {
                    return this.entryIterator.hasNext();
                }

                @Override // java.util.Iterator
                public InetSocketAddress next() {
                    InetAddress address = this.entryIterator.next().address();
                    return new InetSocketAddress(address, DnsNameResolverContext.this.parent.dnsRedirectPort(address));
                }

                @Override // java.util.Iterator
                public void remove() {
                    this.entryIterator.remove();
                }
            };
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void query(DnsServerAddressStream dnsServerAddressStream, int i, DnsQuestion dnsQuestion, Promise<T> promise, Throwable th) {
        query(dnsServerAddressStream, i, dnsQuestion, this.parent.dnsQueryLifecycleObserverFactory().newDnsQueryLifecycleObserver(dnsQuestion), promise, th);
    }

    private void query(final DnsServerAddressStream dnsServerAddressStream, final int i, final DnsQuestion dnsQuestion, final DnsQueryLifecycleObserver dnsQueryLifecycleObserver, final Promise<T> promise, Throwable th) {
        if (i >= dnsServerAddressStream.size() || this.allowedQueries == 0 || promise.isCancelled()) {
            tryToFinishResolve(dnsServerAddressStream, i, dnsQuestion, dnsQueryLifecycleObserver, promise, th);
            return;
        }
        this.allowedQueries--;
        InetSocketAddress next = dnsServerAddressStream.next();
        ChannelPromise newPromise = this.parent.ch.newPromise();
        DnsNameResolver dnsNameResolver = this.parent;
        Future<AddressedEnvelope<DnsResponse, InetSocketAddress>> query0 = dnsNameResolver.query0(next, dnsQuestion, this.additionals, newPromise, dnsNameResolver.ch.eventLoop().newPromise());
        this.queriesInProgress.add(query0);
        dnsQueryLifecycleObserver.queryWritten(next, newPromise);
        query0.addListener(new FutureListener<AddressedEnvelope<DnsResponse, InetSocketAddress>>() { // from class: io.netty.resolver.dns.DnsNameResolverContext.3
            @Override // io.netty.util.concurrent.GenericFutureListener
            public void operationComplete(Future<AddressedEnvelope<DnsResponse, InetSocketAddress>> future) {
                DnsNameResolverContext.this.queriesInProgress.remove(future);
                if (promise.isDone() || future.isCancelled()) {
                    dnsQueryLifecycleObserver.queryCancelled(DnsNameResolverContext.this.allowedQueries);
                    return;
                }
                Throwable cause = future.cause();
                try {
                    if (cause == null) {
                        DnsNameResolverContext.this.onResponse(dnsServerAddressStream, i, dnsQuestion, future.getNow(), dnsQueryLifecycleObserver, promise);
                    } else {
                        dnsQueryLifecycleObserver.queryFailed(cause);
                        DnsNameResolverContext.this.query(dnsServerAddressStream, i + 1, dnsQuestion, promise, cause);
                    }
                } finally {
                    DnsNameResolverContext.this.tryToFinishResolve(dnsServerAddressStream, i, dnsQuestion, NoopDnsQueryLifecycleObserver.INSTANCE, promise, cause);
                }
            }
        });
    }

    void onResponse(DnsServerAddressStream dnsServerAddressStream, int i, DnsQuestion dnsQuestion, AddressedEnvelope<DnsResponse, InetSocketAddress> addressedEnvelope, DnsQueryLifecycleObserver dnsQueryLifecycleObserver, Promise<T> promise) {
        try {
            DnsResponseCode code = addressedEnvelope.content().code();
            if (code == DnsResponseCode.NOERROR) {
                if (handleRedirect(dnsQuestion, addressedEnvelope, dnsQueryLifecycleObserver, promise)) {
                    return;
                }
                DnsRecordType type = dnsQuestion.type();
                if (type != DnsRecordType.A && type != DnsRecordType.AAAA) {
                    if (type == DnsRecordType.CNAME) {
                        onResponseCNAME(dnsQuestion, addressedEnvelope, dnsQueryLifecycleObserver, promise);
                    } else {
                        dnsQueryLifecycleObserver.queryFailed(UNRECOGNIZED_TYPE_QUERY_FAILED_EXCEPTION);
                    }
                    return;
                }
                onResponseAorAAAA(type, dnsQuestion, addressedEnvelope, dnsQueryLifecycleObserver, promise);
                return;
            }
            if (code != DnsResponseCode.NXDOMAIN) {
                query(dnsServerAddressStream, i + 1, dnsQuestion, dnsQueryLifecycleObserver.queryNoAnswer(code), promise, null);
            } else {
                dnsQueryLifecycleObserver.queryFailed(NXDOMAIN_QUERY_FAILED_EXCEPTION);
            }
        } finally {
            ReferenceCountUtil.safeRelease(addressedEnvelope);
        }
    }

    private boolean handleRedirect(DnsQuestion dnsQuestion, AddressedEnvelope<DnsResponse, InetSocketAddress> addressedEnvelope, DnsQueryLifecycleObserver dnsQueryLifecycleObserver, Promise<T> promise) {
        AuthoritativeNameServerList extractAuthoritativeNameServers;
        String name;
        AuthoritativeNameServer remove;
        InetAddress parseAddress;
        DnsResponse content = addressedEnvelope.content();
        if (content.count(DnsSection.ANSWER) == 0 && (extractAuthoritativeNameServers = extractAuthoritativeNameServers(dnsQuestion.name(), content)) != null) {
            ArrayList arrayList = new ArrayList(extractAuthoritativeNameServers.size());
            int count = content.count(DnsSection.ADDITIONAL);
            for (int i = 0; i < count; i++) {
                DnsRecord recordAt = content.recordAt(DnsSection.ADDITIONAL, i);
                if ((recordAt.type() != DnsRecordType.A || this.parent.supportsARecords()) && ((recordAt.type() != DnsRecordType.AAAA || this.parent.supportsAAAARecords()) && (remove = extractAuthoritativeNameServers.remove((name = recordAt.name()))) != null && (parseAddress = parseAddress(recordAt, name)) != null)) {
                    arrayList.add(new InetSocketAddress(parseAddress, this.parent.dnsRedirectPort(parseAddress)));
                    addNameServerToCache(remove, parseAddress, recordAt.timeToLive());
                }
            }
            if (!arrayList.isEmpty()) {
                query(this.parent.uncachedRedirectDnsServerStream(arrayList), 0, dnsQuestion, dnsQueryLifecycleObserver.queryRedirected(Collections.unmodifiableList(arrayList)), promise, null);
                return true;
            }
        }
        return false;
    }

    private static AuthoritativeNameServerList extractAuthoritativeNameServers(String str, DnsResponse dnsResponse) {
        int count = dnsResponse.count(DnsSection.AUTHORITY);
        if (count == 0) {
            return null;
        }
        AuthoritativeNameServerList authoritativeNameServerList = new AuthoritativeNameServerList(str);
        for (int i = 0; i < count; i++) {
            authoritativeNameServerList.add(dnsResponse.recordAt(DnsSection.AUTHORITY, i));
        }
        return authoritativeNameServerList;
    }

    private void onResponseAorAAAA(DnsRecordType dnsRecordType, DnsQuestion dnsQuestion, AddressedEnvelope<DnsResponse, InetSocketAddress> addressedEnvelope, DnsQueryLifecycleObserver dnsQueryLifecycleObserver, Promise<T> promise) {
        DnsResponse content = addressedEnvelope.content();
        Map<String, String> buildAliasMap = buildAliasMap(content);
        int count = content.count(DnsSection.ANSWER);
        boolean z = false;
        for (int i = 0; i < count; i++) {
            DnsRecord recordAt = content.recordAt(DnsSection.ANSWER, i);
            DnsRecordType type = recordAt.type();
            if (type == DnsRecordType.A || type == DnsRecordType.AAAA) {
                String lowerCase = dnsQuestion.name().toLowerCase(Locale.US);
                String lowerCase2 = recordAt.name().toLowerCase(Locale.US);
                if (!lowerCase2.equals(lowerCase)) {
                    do {
                        lowerCase = buildAliasMap.get(lowerCase);
                        if (lowerCase2.equals(lowerCase)) {
                            break;
                        }
                    } while (lowerCase != null);
                    if (lowerCase == null) {
                    }
                }
                InetAddress parseAddress = parseAddress(recordAt, this.hostname);
                if (parseAddress != null) {
                    if (this.resolvedEntries == null) {
                        this.resolvedEntries = new ArrayList(8);
                    }
                    this.resolvedEntries.add(this.resolveCache.cache(this.hostname, this.additionals, parseAddress, recordAt.timeToLive(), this.parent.ch.eventLoop()));
                    z = true;
                }
            }
        }
        if (z) {
            dnsQueryLifecycleObserver.querySucceed();
        } else if (buildAliasMap.isEmpty()) {
            dnsQueryLifecycleObserver.queryFailed(NO_MATCHING_RECORD_QUERY_FAILED_EXCEPTION);
        } else {
            onResponseCNAME(dnsQuestion, addressedEnvelope, buildAliasMap, dnsQueryLifecycleObserver, promise);
        }
    }

    private InetAddress parseAddress(DnsRecord dnsRecord, String str) {
        if (!(dnsRecord instanceof DnsRawRecord)) {
            return null;
        }
        ByteBuf content = ((ByteBufHolder) dnsRecord).content();
        int readableBytes = content.readableBytes();
        if (readableBytes != 4 && readableBytes != 16) {
            return null;
        }
        byte[] bArr = new byte[readableBytes];
        content.getBytes(content.readerIndex(), bArr);
        try {
            if (this.parent.isDecodeIdn()) {
                str = IDN.toUnicode(str);
            }
            return InetAddress.getByAddress(str, bArr);
        } catch (UnknownHostException e) {
            throw new Error(e);
        }
    }

    private void onResponseCNAME(DnsQuestion dnsQuestion, AddressedEnvelope<DnsResponse, InetSocketAddress> addressedEnvelope, DnsQueryLifecycleObserver dnsQueryLifecycleObserver, Promise<T> promise) {
        onResponseCNAME(dnsQuestion, addressedEnvelope, buildAliasMap(addressedEnvelope.content()), dnsQueryLifecycleObserver, promise);
    }

    private void onResponseCNAME(DnsQuestion dnsQuestion, AddressedEnvelope<DnsResponse, InetSocketAddress> addressedEnvelope, Map<String, String> map, DnsQueryLifecycleObserver dnsQueryLifecycleObserver, Promise<T> promise) {
        String remove;
        String lowerCase = dnsQuestion.name().toLowerCase(Locale.US);
        boolean z = false;
        while (!map.isEmpty() && (remove = map.remove(lowerCase)) != null) {
            z = true;
            lowerCase = remove;
        }
        if (z) {
            followCname(lowerCase, dnsQueryLifecycleObserver, promise);
        } else {
            dnsQueryLifecycleObserver.queryFailed(CNAME_NOT_FOUND_QUERY_FAILED_EXCEPTION);
        }
    }

    private static Map<String, String> buildAliasMap(DnsResponse dnsResponse) {
        String decodeDomainName;
        int count = dnsResponse.count(DnsSection.ANSWER);
        HashMap hashMap = null;
        for (int i = 0; i < count; i++) {
            DnsRecord recordAt = dnsResponse.recordAt(DnsSection.ANSWER, i);
            if (recordAt.type() == DnsRecordType.CNAME && (recordAt instanceof DnsRawRecord) && (decodeDomainName = decodeDomainName(((ByteBufHolder) recordAt).content())) != null) {
                if (hashMap == null) {
                    hashMap = new HashMap(Math.min(8, count));
                }
                hashMap.put(recordAt.name().toLowerCase(Locale.US), decodeDomainName.toLowerCase(Locale.US));
            }
        }
        return hashMap != null ? hashMap : Collections.emptyMap();
    }

    void tryToFinishResolve(DnsServerAddressStream dnsServerAddressStream, int i, DnsQuestion dnsQuestion, DnsQueryLifecycleObserver dnsQueryLifecycleObserver, Promise<T> promise, Throwable th) {
        if (!this.queriesInProgress.isEmpty()) {
            dnsQueryLifecycleObserver.queryCancelled(this.allowedQueries);
            if (gotPreferredAddress()) {
                finishResolve(promise, th);
                return;
            }
            return;
        }
        if (this.resolvedEntries == null) {
            if (i < dnsServerAddressStream.size()) {
                if (dnsQueryLifecycleObserver == NoopDnsQueryLifecycleObserver.INSTANCE) {
                    query(dnsServerAddressStream, 1 + i, dnsQuestion, promise, th);
                    return;
                } else {
                    query(dnsServerAddressStream, 1 + i, dnsQuestion, dnsQueryLifecycleObserver, promise, th);
                    return;
                }
            }
            dnsQueryLifecycleObserver.queryFailed(NAME_SERVERS_EXHAUSTED_EXCEPTION);
            if (th == null && !this.triedCNAME) {
                this.triedCNAME = true;
                query(this.hostname, DnsRecordType.CNAME, getNameServers(this.hostname), promise, (Throwable) null);
                return;
            }
        } else {
            dnsQueryLifecycleObserver.queryCancelled(this.allowedQueries);
        }
        finishResolve(promise, th);
    }

    private boolean gotPreferredAddress() {
        List<DnsCacheEntry> list = this.resolvedEntries;
        if (list == null) {
            return false;
        }
        int size = list.size();
        Class<? extends InetAddress> addressType = this.parent.preferredAddressType().addressType();
        for (int i = 0; i < size; i++) {
            if (addressType.isInstance(this.resolvedEntries.get(i).address())) {
                return true;
            }
        }
        return false;
    }

    private void finishResolve(Promise<T> promise, Throwable th) {
        if (!this.queriesInProgress.isEmpty()) {
            Iterator<Future<AddressedEnvelope<DnsResponse, InetSocketAddress>>> it = this.queriesInProgress.iterator();
            while (it.hasNext()) {
                Future<AddressedEnvelope<DnsResponse, InetSocketAddress>> next = it.next();
                it.remove();
                if (!next.cancel(false)) {
                    next.addListener(RELEASE_RESPONSE);
                }
            }
        }
        if (this.resolvedEntries != null) {
            for (InternetProtocolFamily internetProtocolFamily : this.resolvedInternetProtocolFamilies) {
                if (finishResolve(internetProtocolFamily.addressType(), this.resolvedEntries, promise)) {
                    return;
                }
            }
        }
        int i = this.maxAllowedQueries - this.allowedQueries;
        StringBuilder sb = new StringBuilder(64);
        sb.append("failed to resolve '").append(this.hostname).append('\'');
        if (i > 1) {
            if (i < this.maxAllowedQueries) {
                sb.append(" after ").append(i).append(" queries ");
            } else {
                sb.append(". Exceeded max queries per resolve ").append(this.maxAllowedQueries).append(' ');
            }
        }
        UnknownHostException unknownHostException = new UnknownHostException(sb.toString());
        if (th == null) {
            this.resolveCache.cache(this.hostname, this.additionals, unknownHostException, this.parent.ch.eventLoop());
        } else {
            unknownHostException.initCause(th);
        }
        promise.tryFailure(unknownHostException);
    }

    static String decodeDomainName(ByteBuf byteBuf) {
        byteBuf.markReaderIndex();
        try {
            return DefaultDnsRecordDecoder.decodeName(byteBuf);
        } catch (CorruptedFrameException unused) {
            return null;
        } finally {
            byteBuf.resetReaderIndex();
        }
    }

    private DnsServerAddressStream getNameServers(String str) {
        DnsServerAddressStream nameServersFromCache = getNameServersFromCache(str);
        return nameServersFromCache == null ? this.nameServerAddrs : nameServersFromCache;
    }

    private void followCname(String str, DnsQueryLifecycleObserver dnsQueryLifecycleObserver, Promise<T> promise) {
        DnsQuestion dnsQuestion;
        DnsQuestion newQuestion;
        DnsServerAddressStream stream = DnsServerAddresses.singleton(getNameServers(str).next()).stream();
        DnsQuestion dnsQuestion2 = null;
        if (this.parent.supportsARecords()) {
            try {
                dnsQuestion2 = newQuestion(str, DnsRecordType.A);
                if (dnsQuestion2 == null) {
                    return;
                }
            } catch (Throwable th) {
                dnsQueryLifecycleObserver.queryFailed(th);
                PlatformDependent.throwException(th);
            }
            DnsQuestion dnsQuestion3 = dnsQuestion2;
            query(stream, 0, dnsQuestion3, dnsQueryLifecycleObserver.queryCNAMEd(dnsQuestion3), promise, null);
            dnsQuestion2 = dnsQuestion3;
        }
        if (this.parent.supportsAAAARecords()) {
            try {
                newQuestion = newQuestion(str, DnsRecordType.AAAA);
            } catch (Throwable th2) {
                dnsQueryLifecycleObserver.queryFailed(th2);
                PlatformDependent.throwException(th2);
                dnsQuestion = dnsQuestion2;
            }
            if (newQuestion == null) {
                return;
            }
            dnsQuestion = newQuestion;
            query(stream, 0, dnsQuestion, dnsQueryLifecycleObserver.queryCNAMEd(dnsQuestion), promise, null);
        }
    }

    private boolean query(String str, DnsRecordType dnsRecordType, DnsServerAddressStream dnsServerAddressStream, Promise<T> promise, Throwable th) {
        DnsQuestion newQuestion = newQuestion(str, dnsRecordType);
        if (newQuestion == null) {
            return false;
        }
        query(dnsServerAddressStream, 0, newQuestion, promise, th);
        return true;
    }

    private static DnsQuestion newQuestion(String str, DnsRecordType dnsRecordType) {
        try {
            return new DefaultDnsQuestion(str, dnsRecordType);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    private static final class AuthoritativeNameServerList {
        private int count;
        private AuthoritativeNameServer head;
        private final String questionName;

        AuthoritativeNameServerList(String str) {
            this.questionName = str.toLowerCase(Locale.US);
        }

        void add(DnsRecord dnsRecord) {
            String decodeDomainName;
            if (dnsRecord.type() == DnsRecordType.NS && (dnsRecord instanceof DnsRawRecord) && this.questionName.length() >= dnsRecord.name().length()) {
                String lowerCase = dnsRecord.name().toLowerCase(Locale.US);
                int i = 0;
                int length = lowerCase.length() - 1;
                int length2 = this.questionName.length() - 1;
                while (length >= 0) {
                    char charAt = lowerCase.charAt(length);
                    if (this.questionName.charAt(length2) != charAt) {
                        return;
                    }
                    if (charAt == '.') {
                        i++;
                    }
                    length--;
                    length2--;
                }
                AuthoritativeNameServer authoritativeNameServer = this.head;
                if ((authoritativeNameServer == null || authoritativeNameServer.dots <= i) && (decodeDomainName = DnsNameResolverContext.decodeDomainName(((ByteBufHolder) dnsRecord).content())) != null) {
                    AuthoritativeNameServer authoritativeNameServer2 = this.head;
                    if (authoritativeNameServer2 == null || authoritativeNameServer2.dots < i) {
                        this.count = 1;
                        this.head = new AuthoritativeNameServer(i, lowerCase, decodeDomainName);
                    } else if (this.head.dots == i) {
                        AuthoritativeNameServer authoritativeNameServer3 = this.head;
                        while (authoritativeNameServer3.next != null) {
                            authoritativeNameServer3 = authoritativeNameServer3.next;
                        }
                        authoritativeNameServer3.next = new AuthoritativeNameServer(i, lowerCase, decodeDomainName);
                        this.count++;
                    }
                }
            }
        }

        AuthoritativeNameServer remove(String str) {
            for (AuthoritativeNameServer authoritativeNameServer = this.head; authoritativeNameServer != null; authoritativeNameServer = authoritativeNameServer.next) {
                if (!authoritativeNameServer.removed && authoritativeNameServer.nsName.equalsIgnoreCase(str)) {
                    authoritativeNameServer.removed = true;
                    return authoritativeNameServer;
                }
            }
            return null;
        }

        int size() {
            return this.count;
        }
    }

    static final class AuthoritativeNameServer {
        final String domainName;
        final int dots;
        AuthoritativeNameServer next;
        final String nsName;
        boolean removed;

        AuthoritativeNameServer(int i, String str, String str2) {
            this.dots = i;
            this.nsName = str2;
            this.domainName = str;
        }

        boolean isRootServer() {
            return this.dots == 1;
        }

        String domainName() {
            return this.domainName;
        }
    }
}
