package io.netty.handler.ssl;

import io.netty.buffer.ByteBufAllocator;
import io.netty.handler.ssl.ApplicationProtocolConfig;
import io.netty.handler.ssl.JdkApplicationProtocolNegotiator;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.File;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.crypto.NoSuchPaddingException;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLSessionContext;

/* loaded from: classes4.dex */
public class JdkSslContext extends SslContext {
    private static final List<String> DEFAULT_CIPHERS;
    private static final String[] DEFAULT_PROTOCOLS;
    static final String PROTOCOL = "TLS";
    private static final Set<String> SUPPORTED_CIPHERS;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) JdkSslContext.class);
    private final JdkApplicationProtocolNegotiator apn;
    private final String[] cipherSuites;
    private final ClientAuth clientAuth;
    private final boolean isClient;
    private final String[] protocols;
    private final SSLContext sslContext;
    private final List<String> unmodifiableCipherSuites;

    static {
        try {
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            sSLContext.init(null, null, null);
            SSLEngine createSSLEngine = sSLContext.createSSLEngine();
            String[] supportedProtocols = createSSLEngine.getSupportedProtocols();
            HashSet hashSet = new HashSet(supportedProtocols.length);
            for (String str : supportedProtocols) {
                hashSet.add(str);
            }
            ArrayList arrayList = new ArrayList();
            SslUtils.addIfSupported(hashSet, arrayList, "TLSv1.2", "TLSv1.1", "TLSv1");
            if (!arrayList.isEmpty()) {
                DEFAULT_PROTOCOLS = (String[]) arrayList.toArray(new String[arrayList.size()]);
            } else {
                DEFAULT_PROTOCOLS = createSSLEngine.getEnabledProtocols();
            }
            String[] supportedCipherSuites = createSSLEngine.getSupportedCipherSuites();
            SUPPORTED_CIPHERS = new HashSet(supportedCipherSuites.length);
            for (String str2 : supportedCipherSuites) {
                Set<String> set = SUPPORTED_CIPHERS;
                set.add(str2);
                if (str2.startsWith("SSL_")) {
                    set.add("TLS_" + str2.substring(4));
                }
            }
            ArrayList arrayList2 = new ArrayList();
            SslUtils.addIfSupported(SUPPORTED_CIPHERS, arrayList2, SslUtils.DEFAULT_CIPHER_SUITES);
            SslUtils.useFallbackCiphersIfDefaultIsEmpty(arrayList2, createSSLEngine.getEnabledCipherSuites());
            List<String> unmodifiableList = Collections.unmodifiableList(arrayList2);
            DEFAULT_CIPHERS = unmodifiableList;
            InternalLogger internalLogger = logger;
            if (internalLogger.isDebugEnabled()) {
                internalLogger.debug("Default protocols (JDK): {} ", Arrays.asList(DEFAULT_PROTOCOLS));
                internalLogger.debug("Default cipher suites (JDK): {}", unmodifiableList);
            }
        } catch (Exception e) {
            throw new Error("failed to initialize the default SSL context", e);
        }
    }

    public JdkSslContext(SSLContext sSLContext, boolean z, ClientAuth clientAuth) {
        this(sSLContext, z, null, IdentityCipherSuiteFilter.INSTANCE, JdkDefaultApplicationProtocolNegotiator.INSTANCE, clientAuth, null, false);
    }

    public JdkSslContext(SSLContext sSLContext, boolean z, Iterable<String> iterable, CipherSuiteFilter cipherSuiteFilter, ApplicationProtocolConfig applicationProtocolConfig, ClientAuth clientAuth) {
        this(sSLContext, z, iterable, cipherSuiteFilter, toNegotiator(applicationProtocolConfig, !z), clientAuth, null, false);
    }

    JdkSslContext(SSLContext sSLContext, boolean z, Iterable<String> iterable, CipherSuiteFilter cipherSuiteFilter, JdkApplicationProtocolNegotiator jdkApplicationProtocolNegotiator, ClientAuth clientAuth, String[] strArr, boolean z2) {
        super(z2);
        this.apn = (JdkApplicationProtocolNegotiator) ObjectUtil.checkNotNull(jdkApplicationProtocolNegotiator, "apn");
        this.clientAuth = (ClientAuth) ObjectUtil.checkNotNull(clientAuth, "clientAuth");
        String[] filterCipherSuites = ((CipherSuiteFilter) ObjectUtil.checkNotNull(cipherSuiteFilter, "cipherFilter")).filterCipherSuites(iterable, DEFAULT_CIPHERS, SUPPORTED_CIPHERS);
        this.cipherSuites = filterCipherSuites;
        this.protocols = strArr == null ? DEFAULT_PROTOCOLS : strArr;
        this.unmodifiableCipherSuites = Collections.unmodifiableList(Arrays.asList(filterCipherSuites));
        this.sslContext = (SSLContext) ObjectUtil.checkNotNull(sSLContext, "sslContext");
        this.isClient = z;
    }

    public final SSLContext context() {
        return this.sslContext;
    }

    @Override // io.netty.handler.ssl.SslContext
    public final boolean isClient() {
        return this.isClient;
    }

    @Override // io.netty.handler.ssl.SslContext
    public final SSLSessionContext sessionContext() {
        if (isServer()) {
            return context().getServerSessionContext();
        }
        return context().getClientSessionContext();
    }

    @Override // io.netty.handler.ssl.SslContext
    public final List<String> cipherSuites() {
        return this.unmodifiableCipherSuites;
    }

    @Override // io.netty.handler.ssl.SslContext
    public final long sessionCacheSize() {
        return sessionContext().getSessionCacheSize();
    }

    @Override // io.netty.handler.ssl.SslContext
    public final long sessionTimeout() {
        return sessionContext().getSessionTimeout();
    }

    @Override // io.netty.handler.ssl.SslContext
    public final SSLEngine newEngine(ByteBufAllocator byteBufAllocator) {
        return configureAndWrapEngine(context().createSSLEngine(), byteBufAllocator);
    }

    @Override // io.netty.handler.ssl.SslContext
    public final SSLEngine newEngine(ByteBufAllocator byteBufAllocator, String str, int i) {
        return configureAndWrapEngine(context().createSSLEngine(str, i), byteBufAllocator);
    }

    private SSLEngine configureAndWrapEngine(SSLEngine sSLEngine, ByteBufAllocator byteBufAllocator) {
        sSLEngine.setEnabledCipherSuites(this.cipherSuites);
        sSLEngine.setEnabledProtocols(this.protocols);
        sSLEngine.setUseClientMode(isClient());
        if (isServer()) {
            int i = AnonymousClass1.$SwitchMap$io$netty$handler$ssl$ClientAuth[this.clientAuth.ordinal()];
            if (i == 1) {
                sSLEngine.setWantClientAuth(true);
            } else if (i == 2) {
                sSLEngine.setNeedClientAuth(true);
            } else if (i != 3) {
                throw new Error("Unknown auth " + this.clientAuth);
            }
        }
        JdkApplicationProtocolNegotiator.SslEngineWrapperFactory wrapperFactory = this.apn.wrapperFactory();
        if (wrapperFactory instanceof JdkApplicationProtocolNegotiator.AllocatorAwareSslEngineWrapperFactory) {
            return ((JdkApplicationProtocolNegotiator.AllocatorAwareSslEngineWrapperFactory) wrapperFactory).wrapSslEngine(sSLEngine, byteBufAllocator, this.apn, isServer());
        }
        return wrapperFactory.wrapSslEngine(sSLEngine, this.apn, isServer());
    }

    @Override // io.netty.handler.ssl.SslContext
    public final JdkApplicationProtocolNegotiator applicationProtocolNegotiator() {
        return this.apn;
    }

    static JdkApplicationProtocolNegotiator toNegotiator(ApplicationProtocolConfig applicationProtocolConfig, boolean z) {
        if (applicationProtocolConfig == null) {
            return JdkDefaultApplicationProtocolNegotiator.INSTANCE;
        }
        int i = AnonymousClass1.$SwitchMap$io$netty$handler$ssl$ApplicationProtocolConfig$Protocol[applicationProtocolConfig.protocol().ordinal()];
        if (i == 1) {
            return JdkDefaultApplicationProtocolNegotiator.INSTANCE;
        }
        if (i == 2) {
            if (z) {
                int i2 = AnonymousClass1.$SwitchMap$io$netty$handler$ssl$ApplicationProtocolConfig$SelectorFailureBehavior[applicationProtocolConfig.selectorFailureBehavior().ordinal()];
                if (i2 == 1) {
                    return new JdkAlpnApplicationProtocolNegotiator(true, (Iterable<String>) applicationProtocolConfig.supportedProtocols());
                }
                if (i2 == 2) {
                    return new JdkAlpnApplicationProtocolNegotiator(false, (Iterable<String>) applicationProtocolConfig.supportedProtocols());
                }
                throw new UnsupportedOperationException("JDK provider does not support " + applicationProtocolConfig.selectorFailureBehavior() + " failure behavior");
            }
            int i3 = AnonymousClass1.$SwitchMap$io$netty$handler$ssl$ApplicationProtocolConfig$SelectedListenerFailureBehavior[applicationProtocolConfig.selectedListenerFailureBehavior().ordinal()];
            if (i3 == 1) {
                return new JdkAlpnApplicationProtocolNegotiator(false, (Iterable<String>) applicationProtocolConfig.supportedProtocols());
            }
            if (i3 == 2) {
                return new JdkAlpnApplicationProtocolNegotiator(true, (Iterable<String>) applicationProtocolConfig.supportedProtocols());
            }
            throw new UnsupportedOperationException("JDK provider does not support " + applicationProtocolConfig.selectedListenerFailureBehavior() + " failure behavior");
        }
        if (i != 3) {
            throw new UnsupportedOperationException("JDK provider does not support " + applicationProtocolConfig.protocol() + " protocol");
        }
        if (z) {
            int i4 = AnonymousClass1.$SwitchMap$io$netty$handler$ssl$ApplicationProtocolConfig$SelectedListenerFailureBehavior[applicationProtocolConfig.selectedListenerFailureBehavior().ordinal()];
            if (i4 == 1) {
                return new JdkNpnApplicationProtocolNegotiator(false, (Iterable<String>) applicationProtocolConfig.supportedProtocols());
            }
            if (i4 == 2) {
                return new JdkNpnApplicationProtocolNegotiator(true, (Iterable<String>) applicationProtocolConfig.supportedProtocols());
            }
            throw new UnsupportedOperationException("JDK provider does not support " + applicationProtocolConfig.selectedListenerFailureBehavior() + " failure behavior");
        }
        int i5 = AnonymousClass1.$SwitchMap$io$netty$handler$ssl$ApplicationProtocolConfig$SelectorFailureBehavior[applicationProtocolConfig.selectorFailureBehavior().ordinal()];
        if (i5 == 1) {
            return new JdkNpnApplicationProtocolNegotiator(true, (Iterable<String>) applicationProtocolConfig.supportedProtocols());
        }
        if (i5 == 2) {
            return new JdkNpnApplicationProtocolNegotiator(false, (Iterable<String>) applicationProtocolConfig.supportedProtocols());
        }
        throw new UnsupportedOperationException("JDK provider does not support " + applicationProtocolConfig.selectorFailureBehavior() + " failure behavior");
    }

    /* renamed from: io.netty.handler.ssl.JdkSslContext$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$ssl$ApplicationProtocolConfig$Protocol;
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$ssl$ApplicationProtocolConfig$SelectedListenerFailureBehavior;
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$ssl$ApplicationProtocolConfig$SelectorFailureBehavior;
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$ssl$ClientAuth;

        static {
            int[] iArr = new int[ApplicationProtocolConfig.Protocol.values().length];
            $SwitchMap$io$netty$handler$ssl$ApplicationProtocolConfig$Protocol = iArr;
            try {
                iArr[ApplicationProtocolConfig.Protocol.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$handler$ssl$ApplicationProtocolConfig$Protocol[ApplicationProtocolConfig.Protocol.ALPN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$netty$handler$ssl$ApplicationProtocolConfig$Protocol[ApplicationProtocolConfig.Protocol.NPN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[ApplicationProtocolConfig.SelectedListenerFailureBehavior.values().length];
            $SwitchMap$io$netty$handler$ssl$ApplicationProtocolConfig$SelectedListenerFailureBehavior = iArr2;
            try {
                iArr2[ApplicationProtocolConfig.SelectedListenerFailureBehavior.ACCEPT.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$io$netty$handler$ssl$ApplicationProtocolConfig$SelectedListenerFailureBehavior[ApplicationProtocolConfig.SelectedListenerFailureBehavior.FATAL_ALERT.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            int[] iArr3 = new int[ApplicationProtocolConfig.SelectorFailureBehavior.values().length];
            $SwitchMap$io$netty$handler$ssl$ApplicationProtocolConfig$SelectorFailureBehavior = iArr3;
            try {
                iArr3[ApplicationProtocolConfig.SelectorFailureBehavior.FATAL_ALERT.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$io$netty$handler$ssl$ApplicationProtocolConfig$SelectorFailureBehavior[ApplicationProtocolConfig.SelectorFailureBehavior.NO_ADVERTISE.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
            int[] iArr4 = new int[ClientAuth.values().length];
            $SwitchMap$io$netty$handler$ssl$ClientAuth = iArr4;
            try {
                iArr4[ClientAuth.OPTIONAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$io$netty$handler$ssl$ClientAuth[ClientAuth.REQUIRE.ordinal()] = 2;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$io$netty$handler$ssl$ClientAuth[ClientAuth.NONE.ordinal()] = 3;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    @Deprecated
    protected static KeyManagerFactory buildKeyManagerFactory(File file, File file2, String str, KeyManagerFactory keyManagerFactory) throws UnrecoverableKeyException, KeyStoreException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeySpecException, InvalidAlgorithmParameterException, CertificateException, KeyException, IOException {
        String property = Security.getProperty("ssl.KeyManagerFactory.algorithm");
        if (property == null) {
            property = "SunX509";
        }
        return buildKeyManagerFactory(file, property, file2, str, keyManagerFactory);
    }

    @Deprecated
    protected static KeyManagerFactory buildKeyManagerFactory(File file, String str, File file2, String str2, KeyManagerFactory keyManagerFactory) throws KeyStoreException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeySpecException, InvalidAlgorithmParameterException, IOException, CertificateException, KeyException, UnrecoverableKeyException {
        return buildKeyManagerFactory(toX509Certificates(file), str, toPrivateKey(file2, str2), str2, keyManagerFactory);
    }
}
