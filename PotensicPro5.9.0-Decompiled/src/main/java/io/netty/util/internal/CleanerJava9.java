package io.netty.util.internal;

import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;

/* loaded from: classes4.dex */
final class CleanerJava9 implements Cleaner {
    private static final Method INVOKE_CLEANER;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) CleanerJava9.class);

    CleanerJava9() {
    }

    static {
        Throwable unsupportedOperationException;
        Object obj;
        Method method = null;
        if (PlatformDependent0.hasUnsafe()) {
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(1);
            try {
                Method declaredMethod = PlatformDependent0.UNSAFE.getClass().getDeclaredMethod("invokeCleaner", ByteBuffer.class);
                declaredMethod.invoke(PlatformDependent0.UNSAFE, allocateDirect);
                obj = declaredMethod;
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
                obj = e;
            }
            if (obj instanceof Throwable) {
                unsupportedOperationException = (Throwable) obj;
            } else {
                Method method2 = (Method) obj;
                unsupportedOperationException = null;
                method = method2;
            }
        } else {
            unsupportedOperationException = new UnsupportedOperationException("sun.misc.Unsafe unavailable");
        }
        if (unsupportedOperationException == null) {
            logger.debug("java.nio.ByteBuffer.cleaner(): available");
        } else {
            logger.debug("java.nio.ByteBuffer.cleaner(): unavailable", unsupportedOperationException);
        }
        INVOKE_CLEANER = method;
    }

    static boolean isSupported() {
        return INVOKE_CLEANER != null;
    }

    @Override // io.netty.util.internal.Cleaner
    public void freeDirectBuffer(ByteBuffer byteBuffer) {
        try {
            INVOKE_CLEANER.invoke(PlatformDependent0.UNSAFE, byteBuffer);
        } catch (Throwable th) {
            PlatformDependent0.throwException(th);
        }
    }
}
