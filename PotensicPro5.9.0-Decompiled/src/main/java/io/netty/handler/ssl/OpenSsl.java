package io.netty.handler.ssl;

import io.netty.buffer.ByteBuf;
import io.netty.internal.tcnative.Buffer;
import io.netty.internal.tcnative.Library;
import io.netty.internal.tcnative.SSL;
import io.netty.internal.tcnative.SSLContext;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.ReferenceCounted;
import io.netty.util.internal.NativeLibraryLoader;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import org.apache.xmlbeans.impl.common.NameUtil;

/* loaded from: classes4.dex */
public final class OpenSsl {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static final Set<String> AVAILABLE_CIPHER_SUITES;
    private static final Set<String> AVAILABLE_JAVA_CIPHER_SUITES;
    private static final Set<String> AVAILABLE_OPENSSL_CIPHER_SUITES;
    static final List<String> DEFAULT_CIPHERS;
    static final Set<String> SUPPORTED_PROTOCOLS_SET;
    private static final boolean SUPPORTS_HOSTNAME_VALIDATION;
    private static final boolean SUPPORTS_KEYMANAGER_FACTORY;
    private static final boolean SUPPORTS_OCSP;
    private static final Throwable UNAVAILABILITY_CAUSE;
    private static final boolean USE_KEYMANAGER_FACTORY;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) OpenSsl.class);

    /* JADX WARN: Removed duplicated region for block: B:39:0x015a A[Catch: all -> 0x0163, TryCatch #3 {all -> 0x0163, blocks: (B:37:0x0153, B:39:0x015a, B:41:0x015f, B:42:0x0162), top: B:36:0x0153 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x015f A[Catch: all -> 0x0163, TryCatch #3 {all -> 0x0163, blocks: (B:37:0x0153, B:39:0x015a, B:41:0x015f, B:42:0x0162), top: B:36:0x0153 }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x013f A[Catch: all -> 0x014b, TryCatch #8 {all -> 0x014b, blocks: (B:63:0x0138, B:65:0x013f, B:67:0x0144), top: B:62:0x0138 }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0144 A[Catch: all -> 0x014b, TRY_LEAVE, TryCatch #8 {all -> 0x014b, blocks: (B:63:0x0138, B:65:0x013f, B:67:0x0144), top: B:62:0x0138 }] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0196 A[LOOP:1: B:71:0x0190->B:73:0x0196, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01f2  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01fd  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0209  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0216  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0223  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x023c  */
    /* JADX WARN: Removed duplicated region for block: B:94:? A[RETURN, SYNTHETIC] */
    static {
        /*
            Method dump skipped, instructions count: 632
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.ssl.OpenSsl.<clinit>():void");
    }

    private static boolean doesSupportOcsp() {
        long j;
        if (version() >= 268443648) {
            try {
                j = SSLContext.make(16, 1);
            } catch (Exception unused) {
                j = -1;
            } catch (Throwable th) {
                th = th;
                j = -1;
            }
            try {
                SSLContext.enableOcsp(j, false);
                if (j == -1) {
                    return true;
                }
                SSLContext.free(j);
                return true;
            } catch (Exception unused2) {
                if (j != -1) {
                    SSLContext.free(j);
                }
                return false;
            } catch (Throwable th2) {
                th = th2;
                if (j != -1) {
                    SSLContext.free(j);
                }
                throw th;
            }
        }
        return false;
    }

    private static boolean doesSupportProtocol(int i) {
        try {
            long make = SSLContext.make(i, 2);
            if (make != -1) {
                SSLContext.free(make);
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean isAvailable() {
        return UNAVAILABILITY_CAUSE == null;
    }

    public static boolean isAlpnSupported() {
        return ((long) version()) >= 268443648;
    }

    public static boolean isOcspSupported() {
        return SUPPORTS_OCSP;
    }

    public static int version() {
        if (isAvailable()) {
            return SSL.version();
        }
        return -1;
    }

    public static String versionString() {
        if (isAvailable()) {
            return SSL.versionString();
        }
        return null;
    }

    public static void ensureAvailability() {
        Throwable th = UNAVAILABILITY_CAUSE;
        if (th != null) {
            throw ((Error) new UnsatisfiedLinkError("failed to load the required native library").initCause(th));
        }
    }

    public static Throwable unavailabilityCause() {
        return UNAVAILABILITY_CAUSE;
    }

    @Deprecated
    public static Set<String> availableCipherSuites() {
        return availableOpenSslCipherSuites();
    }

    public static Set<String> availableOpenSslCipherSuites() {
        return AVAILABLE_OPENSSL_CIPHER_SUITES;
    }

    public static Set<String> availableJavaCipherSuites() {
        return AVAILABLE_JAVA_CIPHER_SUITES;
    }

    public static boolean isCipherSuiteAvailable(String str) {
        String openSsl = CipherSuiteConverter.toOpenSsl(str);
        if (openSsl != null) {
            str = openSsl;
        }
        return AVAILABLE_OPENSSL_CIPHER_SUITES.contains(str);
    }

    public static boolean supportsKeyManagerFactory() {
        return SUPPORTS_KEYMANAGER_FACTORY;
    }

    public static boolean supportsHostnameValidation() {
        return SUPPORTS_HOSTNAME_VALIDATION;
    }

    static boolean useKeyManagerFactory() {
        return USE_KEYMANAGER_FACTORY;
    }

    static long memoryAddress(ByteBuf byteBuf) {
        return byteBuf.hasMemoryAddress() ? byteBuf.memoryAddress() : Buffer.address(byteBuf.nioBuffer());
    }

    private OpenSsl() {
    }

    private static void loadTcNative() throws Exception {
        String normalizedOs = PlatformDependent.normalizedOs();
        String normalizedArch = PlatformDependent.normalizedArch();
        LinkedHashSet linkedHashSet = new LinkedHashSet(4);
        linkedHashSet.add("netty_tcnative_" + normalizedOs + NameUtil.USCORE + normalizedArch);
        if ("linux".equalsIgnoreCase(normalizedOs)) {
            linkedHashSet.add("netty_tcnative_" + normalizedOs + NameUtil.USCORE + normalizedArch + "_fedora");
        }
        linkedHashSet.add("netty_tcnative_" + normalizedArch);
        linkedHashSet.add("netty_tcnative");
        NativeLibraryLoader.loadFirstAvailable(SSL.class.getClassLoader(), (String[]) linkedHashSet.toArray(new String[linkedHashSet.size()]));
    }

    private static boolean initializeTcNative() throws Exception {
        return Library.initialize();
    }

    static void releaseIfNeeded(ReferenceCounted referenceCounted) {
        if (referenceCounted.refCnt() > 0) {
            ReferenceCountUtil.safeRelease(referenceCounted);
        }
    }
}
