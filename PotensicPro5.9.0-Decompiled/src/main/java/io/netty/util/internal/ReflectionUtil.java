package io.netty.util.internal;

import java.lang.reflect.AccessibleObject;

/* loaded from: classes4.dex */
public final class ReflectionUtil {
    private ReflectionUtil() {
    }

    public static Throwable trySetAccessible(AccessibleObject accessibleObject) {
        try {
            accessibleObject.setAccessible(true);
            return null;
        } catch (SecurityException e) {
            return e;
        } catch (RuntimeException e2) {
            return handleInaccessibleObjectException(e2);
        }
    }

    private static RuntimeException handleInaccessibleObjectException(RuntimeException runtimeException) {
        if ("java.lang.reflect.InaccessibleObjectException".equals(runtimeException.getClass().getName())) {
            return runtimeException;
        }
        throw runtimeException;
    }
}
