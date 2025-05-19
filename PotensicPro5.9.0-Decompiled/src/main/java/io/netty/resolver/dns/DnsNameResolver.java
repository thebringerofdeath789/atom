package io.netty.resolver.dns;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.AddressedEnvelope;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFactory;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPromise;
import io.netty.channel.EventLoop;
import io.netty.channel.FixedRecvByteBufAllocator;
import io.netty.channel.RecvByteBufAllocator;
import io.netty.channel.socket.DatagramChannel;
import io.netty.channel.socket.InternetProtocolFamily;
import io.netty.handler.codec.dns.DatagramDnsQueryEncoder;
import io.netty.handler.codec.dns.DatagramDnsResponse;
import io.netty.handler.codec.dns.DatagramDnsResponseDecoder;
import io.netty.handler.codec.dns.DnsQuestion;
import io.netty.handler.codec.dns.DnsRawRecord;
import io.netty.handler.codec.dns.DnsRecord;
import io.netty.handler.codec.dns.DnsRecordType;
import io.netty.handler.codec.dns.DnsResponse;
import io.netty.resolver.HostsFileEntriesResolver;
import io.netty.resolver.InetNameResolver;
import io.netty.resolver.ResolvedAddressTypes;
import io.netty.util.NetUtil;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.concurrent.FastThreadLocal;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import io.netty.util.concurrent.Promise;
import io.netty.util.internal.EmptyArrays;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.StringUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.net.IDN;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes4.dex */
public class DnsNameResolver extends InetNameResolver {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final DatagramDnsResponseDecoder DECODER;
    private static final int DEFAULT_NDOTS;
    static final ResolvedAddressTypes DEFAULT_RESOLVE_ADDRESS_TYPES;
    static final String[] DEFAULT_SEARCH_DOMAINS;
    private static final DatagramDnsQueryEncoder ENCODER;
    private static final String LOCALHOST = "localhost";
    private static final InetAddress LOCALHOST_ADDRESS;
    private final DnsCache authoritativeDnsServerCache;
    final DatagramChannel ch;
    final Future<Channel> channelFuture;
    private final boolean decodeIdn;
    private final DnsQueryLifecycleObserverFactory dnsQueryLifecycleObserverFactory;
    private final DnsServerAddressStreamProvider dnsServerAddressStreamProvider;
    private final HostsFileEntriesResolver hostsFileEntriesResolver;
    private final int maxPayloadSize;
    private final int maxQueriesPerResolve;
    private final FastThreadLocal<DnsServerAddressStream> nameServerAddrStream;
    private final int ndots;
    private final boolean optResourceEnabled;
    private final InternetProtocolFamily preferredAddressType;
    final DnsQueryContextManager queryContextManager;
    private final long queryTimeoutMillis;
    private final boolean recursionDesired;
    private final DnsCache resolveCache;
    private final DnsRecordType[] resolveRecordTypes;
    private final ResolvedAddressTypes resolvedAddressTypes;
    private final InternetProtocolFamily[] resolvedInternetProtocolFamilies;
    private final String[] searchDomains;
    private final boolean supportsAAAARecords;
    private final boolean supportsARecords;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) DnsNameResolver.class);
    private static final DnsRecord[] EMPTY_ADDITIONALS = new DnsRecord[0];
    private static final DnsRecordType[] IPV4_ONLY_RESOLVED_RECORD_TYPES = {DnsRecordType.A};
    private static final InternetProtocolFamily[] IPV4_ONLY_RESOLVED_PROTOCOL_FAMILIES = {InternetProtocolFamily.IPv4};
    private static final DnsRecordType[] IPV4_PREFERRED_RESOLVED_RECORD_TYPES = {DnsRecordType.A, DnsRecordType.AAAA};
    private static final InternetProtocolFamily[] IPV4_PREFERRED_RESOLVED_PROTOCOL_FAMILIES = {InternetProtocolFamily.IPv4, InternetProtocolFamily.IPv6};
    private static final DnsRecordType[] IPV6_ONLY_RESOLVED_RECORD_TYPES = {DnsRecordType.AAAA};
    private static final InternetProtocolFamily[] IPV6_ONLY_RESOLVED_PROTOCOL_FAMILIES = {InternetProtocolFamily.IPv6};
    private static final DnsRecordType[] IPV6_PREFERRED_RESOLVED_RECORD_TYPES = {DnsRecordType.AAAA, DnsRecordType.A};
    private static final InternetProtocolFamily[] IPV6_PREFERRED_RESOLVED_PROTOCOL_FAMILIES = {InternetProtocolFamily.IPv6, InternetProtocolFamily.IPv4};

    /* JADX WARN: Multi-variable type inference failed */
    private static Promise<AddressedEnvelope<DnsResponse, InetSocketAddress>> cast(Promise<?> promise) {
        return promise;
    }

    int dnsRedirectPort(InetAddress inetAddress) {
        return 53;
    }

    static {
        String[] strArr;
        int i = 1;
        if (NetUtil.isIpV4StackPreferred()) {
            DEFAULT_RESOLVE_ADDRESS_TYPES = ResolvedAddressTypes.IPV4_ONLY;
            LOCALHOST_ADDRESS = NetUtil.LOCALHOST4;
        } else if (NetUtil.isIpV6AddressesPreferred()) {
            DEFAULT_RESOLVE_ADDRESS_TYPES = ResolvedAddressTypes.IPV6_PREFERRED;
            LOCALHOST_ADDRESS = NetUtil.LOCALHOST6;
        } else {
            DEFAULT_RESOLVE_ADDRESS_TYPES = ResolvedAddressTypes.IPV4_PREFERRED;
            LOCALHOST_ADDRESS = NetUtil.LOCALHOST4;
        }
        try {
            Class<?> cls = Class.forName("sun.net.dns.ResolverConfiguration");
            List list = (List) cls.getMethod("searchlist", new Class[0]).invoke(cls.getMethod("open", new Class[0]).invoke(null, new Object[0]), new Object[0]);
            strArr = (String[]) list.toArray(new String[list.size()]);
        } catch (Exception unused) {
            strArr = EmptyArrays.EMPTY_STRINGS;
        }
        DEFAULT_SEARCH_DOMAINS = strArr;
        try {
            i = UnixResolverDnsServerAddressStreamProvider.parseEtcResolverFirstNdots();
        } catch (Exception unused2) {
        }
        DEFAULT_NDOTS = i;
        DECODER = new DatagramDnsResponseDecoder();
        ENCODER = new DatagramDnsQueryEncoder();
    }

    public DnsNameResolver(EventLoop eventLoop, ChannelFactory<? extends DatagramChannel> channelFactory, final DnsCache dnsCache, DnsCache dnsCache2, DnsQueryLifecycleObserverFactory dnsQueryLifecycleObserverFactory, long j, ResolvedAddressTypes resolvedAddressTypes, boolean z, int i, boolean z2, int i2, boolean z3, HostsFileEntriesResolver hostsFileEntriesResolver, DnsServerAddressStreamProvider dnsServerAddressStreamProvider, String[] strArr, int i3, boolean z4) {
        super(eventLoop);
        DnsQueryLifecycleObserverFactory dnsQueryLifecycleObserverFactory2;
        this.queryContextManager = new DnsQueryContextManager();
        this.nameServerAddrStream = new FastThreadLocal<DnsServerAddressStream>() { // from class: io.netty.resolver.dns.DnsNameResolver.1
            /* JADX INFO: Access modifiers changed from: protected */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // io.netty.util.concurrent.FastThreadLocal
            public DnsServerAddressStream initialValue() throws Exception {
                return DnsNameResolver.this.dnsServerAddressStreamProvider.nameServerAddressStream("");
            }
        };
        this.queryTimeoutMillis = ObjectUtil.checkPositive(j, "queryTimeoutMillis");
        ResolvedAddressTypes resolvedAddressTypes2 = resolvedAddressTypes != null ? resolvedAddressTypes : DEFAULT_RESOLVE_ADDRESS_TYPES;
        this.resolvedAddressTypes = resolvedAddressTypes2;
        this.recursionDesired = z;
        this.maxQueriesPerResolve = ObjectUtil.checkPositive(i, "maxQueriesPerResolve");
        this.maxPayloadSize = ObjectUtil.checkPositive(i2, "maxPayloadSize");
        this.optResourceEnabled = z3;
        this.hostsFileEntriesResolver = (HostsFileEntriesResolver) ObjectUtil.checkNotNull(hostsFileEntriesResolver, "hostsFileEntriesResolver");
        this.dnsServerAddressStreamProvider = (DnsServerAddressStreamProvider) ObjectUtil.checkNotNull(dnsServerAddressStreamProvider, "dnsServerAddressStreamProvider");
        this.resolveCache = (DnsCache) ObjectUtil.checkNotNull(dnsCache, "resolveCache");
        this.authoritativeDnsServerCache = (DnsCache) ObjectUtil.checkNotNull(dnsCache2, "authoritativeDnsServerCache");
        if (z2) {
            dnsQueryLifecycleObserverFactory2 = dnsQueryLifecycleObserverFactory instanceof NoopDnsQueryLifecycleObserverFactory ? new TraceDnsQueryLifeCycleObserverFactory() : new BiDnsQueryLifecycleObserverFactory(new TraceDnsQueryLifeCycleObserverFactory(), dnsQueryLifecycleObserverFactory);
        } else {
            dnsQueryLifecycleObserverFactory2 = (DnsQueryLifecycleObserverFactory) ObjectUtil.checkNotNull(dnsQueryLifecycleObserverFactory, "dnsQueryLifecycleObserverFactory");
        }
        this.dnsQueryLifecycleObserverFactory = dnsQueryLifecycleObserverFactory2;
        this.searchDomains = strArr != null ? (String[]) strArr.clone() : DEFAULT_SEARCH_DOMAINS;
        this.ndots = i3 >= 0 ? i3 : DEFAULT_NDOTS;
        this.decodeIdn = z4;
        int i4 = AnonymousClass4.$SwitchMap$io$netty$resolver$ResolvedAddressTypes[resolvedAddressTypes2.ordinal()];
        if (i4 == 1) {
            this.supportsAAAARecords = false;
            this.supportsARecords = true;
            this.resolveRecordTypes = IPV4_ONLY_RESOLVED_RECORD_TYPES;
            this.resolvedInternetProtocolFamilies = IPV4_ONLY_RESOLVED_PROTOCOL_FAMILIES;
            this.preferredAddressType = InternetProtocolFamily.IPv4;
        } else if (i4 == 2) {
            this.supportsAAAARecords = true;
            this.supportsARecords = true;
            this.resolveRecordTypes = IPV4_PREFERRED_RESOLVED_RECORD_TYPES;
            this.resolvedInternetProtocolFamilies = IPV4_PREFERRED_RESOLVED_PROTOCOL_FAMILIES;
            this.preferredAddressType = InternetProtocolFamily.IPv4;
        } else if (i4 == 3) {
            this.supportsAAAARecords = true;
            this.supportsARecords = false;
            this.resolveRecordTypes = IPV6_ONLY_RESOLVED_RECORD_TYPES;
            this.resolvedInternetProtocolFamilies = IPV6_ONLY_RESOLVED_PROTOCOL_FAMILIES;
            this.preferredAddressType = InternetProtocolFamily.IPv6;
        } else if (i4 == 4) {
            this.supportsAAAARecords = true;
            this.supportsARecords = true;
            this.resolveRecordTypes = IPV6_PREFERRED_RESOLVED_RECORD_TYPES;
            this.resolvedInternetProtocolFamilies = IPV6_PREFERRED_RESOLVED_PROTOCOL_FAMILIES;
            this.preferredAddressType = InternetProtocolFamily.IPv6;
        } else {
            throw new IllegalArgumentException("Unknown ResolvedAddressTypes " + resolvedAddressTypes);
        }
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(executor());
        bootstrap.channelFactory((ChannelFactory) channelFactory);
        bootstrap.option(ChannelOption.DATAGRAM_CHANNEL_ACTIVE_ON_REGISTRATION, true);
        final DnsResponseHandler dnsResponseHandler = new DnsResponseHandler(executor().newPromise());
        bootstrap.handler(new ChannelInitializer<DatagramChannel>() { // from class: io.netty.resolver.dns.DnsNameResolver.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // io.netty.channel.ChannelInitializer
            public void initChannel(DatagramChannel datagramChannel) throws Exception {
                datagramChannel.pipeline().addLast(DnsNameResolver.DECODER, DnsNameResolver.ENCODER, dnsResponseHandler);
            }
        });
        this.channelFuture = dnsResponseHandler.channelActivePromise;
        DatagramChannel datagramChannel = (DatagramChannel) bootstrap.register().channel();
        this.ch = datagramChannel;
        datagramChannel.config().setRecvByteBufAllocator((RecvByteBufAllocator) new FixedRecvByteBufAllocator(i2));
        datagramChannel.closeFuture().addListener((GenericFutureListener<? extends Future<? super Void>>) new ChannelFutureListener() { // from class: io.netty.resolver.dns.DnsNameResolver.3
            @Override // io.netty.util.concurrent.GenericFutureListener
            public void operationComplete(ChannelFuture channelFuture) throws Exception {
                dnsCache.clear();
            }
        });
    }

    /* renamed from: io.netty.resolver.dns.DnsNameResolver$4, reason: invalid class name */
    static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$resolver$ResolvedAddressTypes;

        static {
            int[] iArr = new int[ResolvedAddressTypes.values().length];
            $SwitchMap$io$netty$resolver$ResolvedAddressTypes = iArr;
            try {
                iArr[ResolvedAddressTypes.IPV4_ONLY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$resolver$ResolvedAddressTypes[ResolvedAddressTypes.IPV4_PREFERRED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$netty$resolver$ResolvedAddressTypes[ResolvedAddressTypes.IPV6_ONLY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$netty$resolver$ResolvedAddressTypes[ResolvedAddressTypes.IPV6_PREFERRED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    final DnsQueryLifecycleObserverFactory dnsQueryLifecycleObserverFactory() {
        return this.dnsQueryLifecycleObserverFactory;
    }

    protected DnsServerAddressStream uncachedRedirectDnsServerStream(List<InetSocketAddress> list) {
        return DnsServerAddresses.sequential(list).stream();
    }

    public DnsCache resolveCache() {
        return this.resolveCache;
    }

    public DnsCache authoritativeDnsServerCache() {
        return this.authoritativeDnsServerCache;
    }

    public long queryTimeoutMillis() {
        return this.queryTimeoutMillis;
    }

    public ResolvedAddressTypes resolvedAddressTypes() {
        return this.resolvedAddressTypes;
    }

    InternetProtocolFamily[] resolvedInternetProtocolFamiliesUnsafe() {
        return this.resolvedInternetProtocolFamilies;
    }

    final String[] searchDomains() {
        return this.searchDomains;
    }

    final int ndots() {
        return this.ndots;
    }

    final boolean supportsAAAARecords() {
        return this.supportsAAAARecords;
    }

    final boolean supportsARecords() {
        return this.supportsARecords;
    }

    final InternetProtocolFamily preferredAddressType() {
        return this.preferredAddressType;
    }

    final DnsRecordType[] resolveRecordTypes() {
        return this.resolveRecordTypes;
    }

    final boolean isDecodeIdn() {
        return this.decodeIdn;
    }

    public boolean isRecursionDesired() {
        return this.recursionDesired;
    }

    public int maxQueriesPerResolve() {
        return this.maxQueriesPerResolve;
    }

    public int maxPayloadSize() {
        return this.maxPayloadSize;
    }

    public boolean isOptResourceEnabled() {
        return this.optResourceEnabled;
    }

    public HostsFileEntriesResolver hostsFileEntriesResolver() {
        return this.hostsFileEntriesResolver;
    }

    @Override // io.netty.resolver.SimpleNameResolver, io.netty.resolver.NameResolver, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.ch.isOpen()) {
            this.ch.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.resolver.SimpleNameResolver
    public EventLoop executor() {
        return (EventLoop) super.executor();
    }

    private InetAddress resolveHostsFileEntry(String str) {
        HostsFileEntriesResolver hostsFileEntriesResolver = this.hostsFileEntriesResolver;
        if (hostsFileEntriesResolver == null) {
            return null;
        }
        InetAddress address = hostsFileEntriesResolver.address(str, this.resolvedAddressTypes);
        return (address == null && PlatformDependent.isWindows() && "localhost".equalsIgnoreCase(str)) ? LOCALHOST_ADDRESS : address;
    }

    public final Future<InetAddress> resolve(String str, Iterable<DnsRecord> iterable) {
        return resolve(str, iterable, executor().newPromise());
    }

    public final Future<InetAddress> resolve(String str, Iterable<DnsRecord> iterable, Promise<InetAddress> promise) {
        ObjectUtil.checkNotNull(promise, "promise");
        try {
            doResolve(str, toArray(iterable, true), promise, this.resolveCache);
            return promise;
        } catch (Exception e) {
            return promise.setFailure(e);
        }
    }

    public final Future<List<InetAddress>> resolveAll(String str, Iterable<DnsRecord> iterable) {
        return resolveAll(str, iterable, executor().newPromise());
    }

    public final Future<List<InetAddress>> resolveAll(String str, Iterable<DnsRecord> iterable, Promise<List<InetAddress>> promise) {
        ObjectUtil.checkNotNull(promise, "promise");
        try {
            doResolveAll(str, toArray(iterable, true), promise, this.resolveCache);
            return promise;
        } catch (Exception e) {
            return promise.setFailure(e);
        }
    }

    @Override // io.netty.resolver.SimpleNameResolver
    protected void doResolve(String str, Promise<InetAddress> promise) throws Exception {
        doResolve(str, EMPTY_ADDITIONALS, promise, this.resolveCache);
    }

    private static DnsRecord[] toArray(Iterable<DnsRecord> iterable, boolean z) {
        ObjectUtil.checkNotNull(iterable, "additionals");
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            Iterator<DnsRecord> it = iterable.iterator();
            while (it.hasNext()) {
                validateAdditional(it.next(), z);
            }
            return (DnsRecord[]) collection.toArray(new DnsRecord[collection.size()]);
        }
        Iterator<DnsRecord> it2 = iterable.iterator();
        if (!it2.hasNext()) {
            return EMPTY_ADDITIONALS;
        }
        ArrayList arrayList = new ArrayList();
        do {
            DnsRecord next = it2.next();
            validateAdditional(next, z);
            arrayList.add(next);
        } while (it2.hasNext());
        return (DnsRecord[]) arrayList.toArray(new DnsRecord[arrayList.size()]);
    }

    private static void validateAdditional(DnsRecord dnsRecord, boolean z) {
        ObjectUtil.checkNotNull(dnsRecord, "record");
        if (z && (dnsRecord instanceof DnsRawRecord)) {
            throw new IllegalArgumentException("DnsRawRecord implementations not allowed: " + dnsRecord);
        }
    }

    private InetAddress loopbackAddress() {
        return preferredAddressType().localhost();
    }

    protected void doResolve(String str, DnsRecord[] dnsRecordArr, Promise<InetAddress> promise, DnsCache dnsCache) throws Exception {
        if (str == null || str.isEmpty()) {
            promise.setSuccess(loopbackAddress());
            return;
        }
        byte[] createByteArrayFromIpAddressString = NetUtil.createByteArrayFromIpAddressString(str);
        if (createByteArrayFromIpAddressString != null) {
            promise.setSuccess(InetAddress.getByAddress(createByteArrayFromIpAddressString));
            return;
        }
        String hostname = hostname(str);
        InetAddress resolveHostsFileEntry = resolveHostsFileEntry(hostname);
        if (resolveHostsFileEntry != null) {
            promise.setSuccess(resolveHostsFileEntry);
        } else {
            if (doResolveCached(hostname, dnsRecordArr, promise, dnsCache)) {
                return;
            }
            doResolveUncached(hostname, dnsRecordArr, promise, dnsCache);
        }
    }

    private boolean doResolveCached(String str, DnsRecord[] dnsRecordArr, Promise<InetAddress> promise, DnsCache dnsCache) {
        InetAddress inetAddress;
        Throwable th;
        List<? extends DnsCacheEntry> list = dnsCache.get(str, dnsRecordArr);
        if (list == null || list.isEmpty()) {
            return false;
        }
        synchronized (list) {
            int size = list.size();
            inetAddress = null;
            if (list.get(0).cause() != null) {
                th = list.get(0).cause();
            } else {
                InetAddress inetAddress2 = null;
                for (InternetProtocolFamily internetProtocolFamily : this.resolvedInternetProtocolFamilies) {
                    int i = 0;
                    while (true) {
                        if (i < size) {
                            DnsCacheEntry dnsCacheEntry = list.get(i);
                            if (internetProtocolFamily.addressType().isInstance(dnsCacheEntry.address())) {
                                inetAddress2 = dnsCacheEntry.address();
                                break;
                            }
                            i++;
                        }
                    }
                }
                th = null;
                inetAddress = inetAddress2;
            }
        }
        if (inetAddress != null) {
            trySuccess(promise, inetAddress);
            return true;
        }
        if (th == null) {
            return false;
        }
        tryFailure(promise, th);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <T> void trySuccess(Promise<T> promise, T t) {
        if (promise.trySuccess(t)) {
            return;
        }
        logger.warn("Failed to notify success ({}) to a promise: {}", t, promise);
    }

    private static void tryFailure(Promise<?> promise, Throwable th) {
        if (promise.tryFailure(th)) {
            return;
        }
        logger.warn("Failed to notify failure to a promise: {}", promise, th);
    }

    private void doResolveUncached(String str, DnsRecord[] dnsRecordArr, Promise<InetAddress> promise, DnsCache dnsCache) {
        new SingleResolverContext(this, str, dnsRecordArr, dnsCache, this.dnsServerAddressStreamProvider.nameServerAddressStream(str)).resolve(promise);
    }

    static final class SingleResolverContext extends DnsNameResolverContext<InetAddress> {
        SingleResolverContext(DnsNameResolver dnsNameResolver, String str, DnsRecord[] dnsRecordArr, DnsCache dnsCache, DnsServerAddressStream dnsServerAddressStream) {
            super(dnsNameResolver, str, dnsRecordArr, dnsCache, dnsServerAddressStream);
        }

        @Override // io.netty.resolver.dns.DnsNameResolverContext
        DnsNameResolverContext<InetAddress> newResolverContext(DnsNameResolver dnsNameResolver, String str, DnsRecord[] dnsRecordArr, DnsCache dnsCache, DnsServerAddressStream dnsServerAddressStream) {
            return new SingleResolverContext(dnsNameResolver, str, dnsRecordArr, dnsCache, dnsServerAddressStream);
        }

        @Override // io.netty.resolver.dns.DnsNameResolverContext
        boolean finishResolve(Class<? extends InetAddress> cls, List<DnsCacheEntry> list, Promise<InetAddress> promise) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                InetAddress address = list.get(i).address();
                if (cls.isInstance(address)) {
                    DnsNameResolver.trySuccess(promise, address);
                    return true;
                }
            }
            return false;
        }
    }

    @Override // io.netty.resolver.SimpleNameResolver
    protected void doResolveAll(String str, Promise<List<InetAddress>> promise) throws Exception {
        doResolveAll(str, EMPTY_ADDITIONALS, promise, this.resolveCache);
    }

    protected void doResolveAll(String str, DnsRecord[] dnsRecordArr, Promise<List<InetAddress>> promise, DnsCache dnsCache) throws Exception {
        if (str == null || str.isEmpty()) {
            promise.setSuccess(Collections.singletonList(loopbackAddress()));
            return;
        }
        byte[] createByteArrayFromIpAddressString = NetUtil.createByteArrayFromIpAddressString(str);
        if (createByteArrayFromIpAddressString != null) {
            promise.setSuccess(Collections.singletonList(InetAddress.getByAddress(createByteArrayFromIpAddressString)));
            return;
        }
        String hostname = hostname(str);
        InetAddress resolveHostsFileEntry = resolveHostsFileEntry(hostname);
        if (resolveHostsFileEntry != null) {
            promise.setSuccess(Collections.singletonList(resolveHostsFileEntry));
        } else {
            if (doResolveAllCached(hostname, dnsRecordArr, promise, dnsCache)) {
                return;
            }
            doResolveAllUncached(hostname, dnsRecordArr, promise, dnsCache);
        }
    }

    private boolean doResolveAllCached(String str, DnsRecord[] dnsRecordArr, Promise<List<InetAddress>> promise, DnsCache dnsCache) {
        ArrayList arrayList;
        Throwable th;
        List<? extends DnsCacheEntry> list = dnsCache.get(str, dnsRecordArr);
        if (list == null || list.isEmpty()) {
            return false;
        }
        synchronized (list) {
            int size = list.size();
            arrayList = null;
            if (list.get(0).cause() != null) {
                th = list.get(0).cause();
            } else {
                ArrayList arrayList2 = null;
                for (InternetProtocolFamily internetProtocolFamily : this.resolvedInternetProtocolFamilies) {
                    for (int i = 0; i < size; i++) {
                        DnsCacheEntry dnsCacheEntry = list.get(i);
                        if (internetProtocolFamily.addressType().isInstance(dnsCacheEntry.address())) {
                            if (arrayList2 == null) {
                                arrayList2 = new ArrayList(size);
                            }
                            arrayList2.add(dnsCacheEntry.address());
                        }
                    }
                }
                th = null;
                arrayList = arrayList2;
            }
        }
        if (arrayList != null) {
            trySuccess(promise, arrayList);
            return true;
        }
        if (th == null) {
            return false;
        }
        tryFailure(promise, th);
        return true;
    }

    static final class ListResolverContext extends DnsNameResolverContext<List<InetAddress>> {
        ListResolverContext(DnsNameResolver dnsNameResolver, String str, DnsRecord[] dnsRecordArr, DnsCache dnsCache, DnsServerAddressStream dnsServerAddressStream) {
            super(dnsNameResolver, str, dnsRecordArr, dnsCache, dnsServerAddressStream);
        }

        @Override // io.netty.resolver.dns.DnsNameResolverContext
        DnsNameResolverContext<List<InetAddress>> newResolverContext(DnsNameResolver dnsNameResolver, String str, DnsRecord[] dnsRecordArr, DnsCache dnsCache, DnsServerAddressStream dnsServerAddressStream) {
            return new ListResolverContext(dnsNameResolver, str, dnsRecordArr, dnsCache, dnsServerAddressStream);
        }

        @Override // io.netty.resolver.dns.DnsNameResolverContext
        boolean finishResolve(Class<? extends InetAddress> cls, List<DnsCacheEntry> list, Promise<List<InetAddress>> promise) {
            int size = list.size();
            ArrayList arrayList = null;
            for (int i = 0; i < size; i++) {
                InetAddress address = list.get(i).address();
                if (cls.isInstance(address)) {
                    if (arrayList == null) {
                        arrayList = new ArrayList(size);
                    }
                    arrayList.add(address);
                }
            }
            if (arrayList == null) {
                return false;
            }
            promise.trySuccess(arrayList);
            return true;
        }
    }

    private void doResolveAllUncached(String str, DnsRecord[] dnsRecordArr, Promise<List<InetAddress>> promise, DnsCache dnsCache) {
        new ListResolverContext(this, str, dnsRecordArr, dnsCache, this.dnsServerAddressStreamProvider.nameServerAddressStream(str)).resolve(promise);
    }

    private static String hostname(String str) {
        String ascii = IDN.toASCII(str);
        return (!StringUtil.endsWith(str, '.') || StringUtil.endsWith(ascii, '.')) ? ascii : ascii + ".";
    }

    public Future<AddressedEnvelope<DnsResponse, InetSocketAddress>> query(DnsQuestion dnsQuestion) {
        return query(nextNameServerAddress(), dnsQuestion);
    }

    public Future<AddressedEnvelope<DnsResponse, InetSocketAddress>> query(DnsQuestion dnsQuestion, Iterable<DnsRecord> iterable) {
        return query(nextNameServerAddress(), dnsQuestion, iterable);
    }

    public Future<AddressedEnvelope<DnsResponse, InetSocketAddress>> query(DnsQuestion dnsQuestion, Promise<AddressedEnvelope<? extends DnsResponse, InetSocketAddress>> promise) {
        return query(nextNameServerAddress(), dnsQuestion, Collections.emptyList(), promise);
    }

    private InetSocketAddress nextNameServerAddress() {
        return this.nameServerAddrStream.get().next();
    }

    public Future<AddressedEnvelope<DnsResponse, InetSocketAddress>> query(InetSocketAddress inetSocketAddress, DnsQuestion dnsQuestion) {
        return query0(inetSocketAddress, dnsQuestion, EMPTY_ADDITIONALS, this.ch.eventLoop().newPromise());
    }

    public Future<AddressedEnvelope<DnsResponse, InetSocketAddress>> query(InetSocketAddress inetSocketAddress, DnsQuestion dnsQuestion, Iterable<DnsRecord> iterable) {
        return query0(inetSocketAddress, dnsQuestion, toArray(iterable, false), this.ch.eventLoop().newPromise());
    }

    public Future<AddressedEnvelope<DnsResponse, InetSocketAddress>> query(InetSocketAddress inetSocketAddress, DnsQuestion dnsQuestion, Promise<AddressedEnvelope<? extends DnsResponse, InetSocketAddress>> promise) {
        return query0(inetSocketAddress, dnsQuestion, EMPTY_ADDITIONALS, promise);
    }

    public Future<AddressedEnvelope<DnsResponse, InetSocketAddress>> query(InetSocketAddress inetSocketAddress, DnsQuestion dnsQuestion, Iterable<DnsRecord> iterable, Promise<AddressedEnvelope<? extends DnsResponse, InetSocketAddress>> promise) {
        return query0(inetSocketAddress, dnsQuestion, toArray(iterable, false), promise);
    }

    public static boolean isTransportOrTimeoutError(Throwable th) {
        return th != null && (th.getCause() instanceof DnsNameResolverException);
    }

    public static boolean isTimeoutError(Throwable th) {
        return th != null && (th.getCause() instanceof DnsNameResolverTimeoutException);
    }

    final Future<AddressedEnvelope<DnsResponse, InetSocketAddress>> query0(InetSocketAddress inetSocketAddress, DnsQuestion dnsQuestion, DnsRecord[] dnsRecordArr, Promise<AddressedEnvelope<? extends DnsResponse, InetSocketAddress>> promise) {
        return query0(inetSocketAddress, dnsQuestion, dnsRecordArr, this.ch.newPromise(), promise);
    }

    final Future<AddressedEnvelope<DnsResponse, InetSocketAddress>> query0(InetSocketAddress inetSocketAddress, DnsQuestion dnsQuestion, DnsRecord[] dnsRecordArr, ChannelPromise channelPromise, Promise<AddressedEnvelope<? extends DnsResponse, InetSocketAddress>> promise) {
        Promise<AddressedEnvelope<DnsResponse, InetSocketAddress>> cast = cast((Promise) ObjectUtil.checkNotNull(promise, "promise"));
        try {
            new DnsQueryContext(this, inetSocketAddress, dnsQuestion, dnsRecordArr, cast).query(channelPromise);
            return cast;
        } catch (Exception e) {
            return cast.setFailure(e);
        }
    }

    private final class DnsResponseHandler extends ChannelInboundHandlerAdapter {
        private final Promise<Channel> channelActivePromise;

        DnsResponseHandler(Promise<Channel> promise) {
            this.channelActivePromise = promise;
        }

        @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
        public void channelRead(ChannelHandlerContext channelHandlerContext, Object obj) throws Exception {
            try {
                DatagramDnsResponse datagramDnsResponse = (DatagramDnsResponse) obj;
                int id = datagramDnsResponse.id();
                if (DnsNameResolver.logger.isDebugEnabled()) {
                    DnsNameResolver.logger.debug("{} RECEIVED: [{}: {}], {}", DnsNameResolver.this.ch, Integer.valueOf(id), datagramDnsResponse.sender(), datagramDnsResponse);
                }
                DnsQueryContext dnsQueryContext = DnsNameResolver.this.queryContextManager.get(datagramDnsResponse.sender(), id);
                if (dnsQueryContext == null) {
                    DnsNameResolver.logger.warn("{} Received a DNS response with an unknown ID: {}", DnsNameResolver.this.ch, Integer.valueOf(id));
                } else {
                    dnsQueryContext.finish(datagramDnsResponse);
                }
            } finally {
                ReferenceCountUtil.safeRelease(obj);
            }
        }

        @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
        public void channelActive(ChannelHandlerContext channelHandlerContext) throws Exception {
            super.channelActive(channelHandlerContext);
            this.channelActivePromise.setSuccess(channelHandlerContext.channel());
        }

        @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler, io.netty.channel.ChannelInboundHandler
        public void exceptionCaught(ChannelHandlerContext channelHandlerContext, Throwable th) throws Exception {
            DnsNameResolver.logger.warn("{} Unexpected exception: ", DnsNameResolver.this.ch, th);
        }
    }
}
