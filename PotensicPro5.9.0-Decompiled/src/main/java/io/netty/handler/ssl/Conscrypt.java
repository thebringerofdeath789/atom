package io.netty.handler.ssl;

import io.netty.util.internal.PlatformDependent;
import java.lang.reflect.Method;
import javax.net.ssl.SSLEngine;

/* loaded from: classes4.dex */
final class Conscrypt {
    private static final Class<?> ENGINES_CLASS = getEnginesClass();

    static boolean isAvailable() {
        return ENGINES_CLASS != null && PlatformDependent.javaVersion() >= 8;
    }

    static boolean isEngineSupported(SSLEngine sSLEngine) {
        return isAvailable() && isConscryptEngine(sSLEngine, ENGINES_CLASS);
    }

    private static Class<?> getEnginesClass() {
        try {
            Class<?> cls = Class.forName("org.conscrypt.Conscrypt$Engines", true, ConscryptAlpnSslEngine.class.getClassLoader());
            getIsConscryptMethod(cls);
            return cls;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static boolean isConscryptEngine(SSLEngine sSLEngine, Class<?> cls) {
        try {
            return ((Boolean) getIsConscryptMethod(cls).invoke(null, sSLEngine)).booleanValue();
        } catch (Throwable unused) {
            return false;
        }
    }

    private static Method getIsConscryptMethod(Class<?> cls) throws NoSuchMethodException {
        return cls.getMethod("isConscrypt", SSLEngine.class);
    }

    private Conscrypt() {
    }
}
