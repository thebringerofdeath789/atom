package io.netty.util.internal;

import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;

/* loaded from: classes4.dex */
final class CleanerJava6 implements Cleaner {
    private static final long CLEANER_FIELD_OFFSET;
    private static final Method CLEAN_METHOD;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) CleanerJava6.class);

    CleanerJava6() {
    }

    static {
        UnsupportedOperationException th;
        long j = -1;
        Method method = null;
        if (PlatformDependent0.hasUnsafe()) {
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(1);
            try {
                long objectFieldOffset = PlatformDependent0.objectFieldOffset(allocateDirect.getClass().getDeclaredField("cleaner"));
                Object object = PlatformDependent0.getObject(allocateDirect, objectFieldOffset);
                Method declaredMethod = object.getClass().getDeclaredMethod("clean", new Class[0]);
                declaredMethod.invoke(object, new Object[0]);
                th = null;
                j = objectFieldOffset;
                method = declaredMethod;
            } catch (Throwable th2) {
                th = th2;
            }
        } else {
            th = new UnsupportedOperationException("sun.misc.Unsafe unavailable");
        }
        if (th == null) {
            logger.debug("java.nio.ByteBuffer.cleaner(): available");
        } else {
            logger.debug("java.nio.ByteBuffer.cleaner(): unavailable", (Throwable) th);
        }
        CLEANER_FIELD_OFFSET = j;
        CLEAN_METHOD = method;
    }

    static boolean isSupported() {
        return CLEANER_FIELD_OFFSET != -1;
    }

    @Override // io.netty.util.internal.Cleaner
    public void freeDirectBuffer(ByteBuffer byteBuffer) {
        if (byteBuffer.isDirect()) {
            try {
                Object object = PlatformDependent0.getObject(byteBuffer, CLEANER_FIELD_OFFSET);
                if (object != null) {
                    CLEAN_METHOD.invoke(object, new Object[0]);
                }
            } catch (Throwable th) {
                PlatformDependent0.throwException(th);
            }
        }
    }
}
