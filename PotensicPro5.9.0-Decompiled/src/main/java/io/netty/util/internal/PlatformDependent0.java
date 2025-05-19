package io.netty.util.internal;

import com.mapbox.api.geocoding.v5.GeocodingCriteria;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.security.AccessController;
import java.security.PrivilegedAction;
import sun.misc.Unsafe;

/* loaded from: classes4.dex */
final class PlatformDependent0 {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final long ADDRESS_FIELD_OFFSET;
    private static final Method ALLOCATE_ARRAY_METHOD;
    private static final long BYTE_ARRAY_BASE_OFFSET;
    private static final Constructor<?> DIRECT_BUFFER_CONSTRUCTOR;
    static final int HASH_CODE_ASCII_SEED = -1028477387;
    static final int HASH_CODE_C1 = -862048943;
    static final int HASH_CODE_C2 = 461845907;
    private static final Object INTERNAL_UNSAFE;
    private static final boolean IS_ANDROID;
    private static final boolean IS_EXPLICIT_NO_UNSAFE;
    private static final int JAVA_VERSION;
    private static final boolean UNALIGNED;
    static final Unsafe UNSAFE;
    private static final long UNSAFE_COPY_THRESHOLD = 1048576;
    private static final Throwable UNSAFE_UNAVAILABILITY_CAUSE;
    private static final InternalLogger logger;

    static int hashCodeAsciiSanitize(byte b) {
        return b & 31;
    }

    static int hashCodeAsciiSanitize(int i) {
        return i & 522133279;
    }

    static int hashCodeAsciiSanitize(short s) {
        return s & 7967;
    }

    static {
        final Unsafe unsafe;
        Throwable th;
        Field field;
        final ByteBuffer byteBuffer;
        Throwable th2;
        Unsafe unsafe2;
        long j;
        Constructor<?> constructor;
        boolean z;
        Method method;
        InternalLogger internalLoggerFactory = InternalLoggerFactory.getInstance((Class<?>) PlatformDependent0.class);
        logger = internalLoggerFactory;
        IS_EXPLICIT_NO_UNSAFE = explicitNoUnsafe0();
        JAVA_VERSION = javaVersion0();
        IS_ANDROID = isAndroid0();
        Method method2 = null;
        if (isExplicitNoUnsafe()) {
            th2 = new UnsupportedOperationException("Unsafe explicitly disabled");
            byteBuffer = null;
            unsafe2 = null;
            field = null;
        } else {
            final ByteBuffer allocateDirect = ByteBuffer.allocateDirect(1);
            Object doPrivileged = AccessController.doPrivileged(new PrivilegedAction<Object>() { // from class: io.netty.util.internal.PlatformDependent0.1
                @Override // java.security.PrivilegedAction
                public Object run() {
                    try {
                        Field declaredField = Unsafe.class.getDeclaredField("theUnsafe");
                        Throwable trySetAccessible = ReflectionUtil.trySetAccessible(declaredField);
                        return trySetAccessible != null ? trySetAccessible : declaredField.get(null);
                    } catch (IllegalAccessException e) {
                        return e;
                    } catch (NoClassDefFoundError e2) {
                        return e2;
                    } catch (NoSuchFieldException e3) {
                        return e3;
                    } catch (SecurityException e4) {
                        return e4;
                    }
                }
            });
            if (doPrivileged instanceof Throwable) {
                Throwable th3 = (Throwable) doPrivileged;
                internalLoggerFactory.debug("sun.misc.Unsafe.theUnsafe: unavailable", th3);
                th = th3;
                unsafe = null;
            } else {
                unsafe = (Unsafe) doPrivileged;
                internalLoggerFactory.debug("sun.misc.Unsafe.theUnsafe: available");
                th = null;
            }
            if (unsafe != null) {
                Object doPrivileged2 = AccessController.doPrivileged(new PrivilegedAction<Object>() { // from class: io.netty.util.internal.PlatformDependent0.2
                    @Override // java.security.PrivilegedAction
                    public Object run() {
                        try {
                            unsafe.getClass().getDeclaredMethod("copyMemory", Object.class, Long.TYPE, Object.class, Long.TYPE, Long.TYPE);
                            return null;
                        } catch (NoSuchMethodException e) {
                            return e;
                        } catch (SecurityException e2) {
                            return e2;
                        }
                    }
                });
                if (doPrivileged2 == null) {
                    internalLoggerFactory.debug("sun.misc.Unsafe.copyMemory: available");
                } else {
                    th = (Throwable) doPrivileged2;
                    internalLoggerFactory.debug("sun.misc.Unsafe.copyMemory: unavailable", th);
                    unsafe = null;
                }
            }
            if (unsafe != null) {
                Object doPrivileged3 = AccessController.doPrivileged(new PrivilegedAction<Object>() { // from class: io.netty.util.internal.PlatformDependent0.3
                    @Override // java.security.PrivilegedAction
                    public Object run() {
                        try {
                            Field declaredField = Buffer.class.getDeclaredField(GeocodingCriteria.TYPE_ADDRESS);
                            if (unsafe.getLong(allocateDirect, unsafe.objectFieldOffset(declaredField)) == 0) {
                                return null;
                            }
                            return declaredField;
                        } catch (NoSuchFieldException e) {
                            return e;
                        } catch (SecurityException e2) {
                            return e2;
                        }
                    }
                });
                if (doPrivileged3 instanceof Field) {
                    field = (Field) doPrivileged3;
                    internalLoggerFactory.debug("java.nio.Buffer.address: available");
                } else {
                    Throwable th4 = (Throwable) doPrivileged3;
                    internalLoggerFactory.debug("java.nio.Buffer.address: unavailable", th4);
                    unsafe = null;
                    th = th4;
                    field = null;
                }
            } else {
                field = null;
            }
            if (unsafe != null) {
                long arrayIndexScale = unsafe.arrayIndexScale(byte[].class);
                if (arrayIndexScale != 1) {
                    internalLoggerFactory.debug("unsafe.arrayIndexScale is {} (expected: 1). Not using unsafe.", Long.valueOf(arrayIndexScale));
                    unsafe2 = null;
                    byteBuffer = allocateDirect;
                    th2 = new UnsupportedOperationException("Unexpected unsafe.arrayIndexScale");
                }
            }
            Unsafe unsafe3 = unsafe;
            byteBuffer = allocateDirect;
            th2 = th;
            unsafe2 = unsafe3;
        }
        UNSAFE_UNAVAILABILITY_CAUSE = th2;
        UNSAFE = unsafe2;
        if (unsafe2 == null) {
            ADDRESS_FIELD_OFFSET = -1L;
            BYTE_ARRAY_BASE_OFFSET = -1L;
            UNALIGNED = false;
            DIRECT_BUFFER_CONSTRUCTOR = null;
            ALLOCATE_ARRAY_METHOD = null;
        } else {
            try {
                Object doPrivileged4 = AccessController.doPrivileged(new PrivilegedAction<Object>() { // from class: io.netty.util.internal.PlatformDependent0.4
                    @Override // java.security.PrivilegedAction
                    public Object run() {
                        try {
                            Constructor<?> declaredConstructor = byteBuffer.getClass().getDeclaredConstructor(Long.TYPE, Integer.TYPE);
                            Throwable trySetAccessible = ReflectionUtil.trySetAccessible(declaredConstructor);
                            return trySetAccessible != null ? trySetAccessible : declaredConstructor;
                        } catch (NoSuchMethodException e) {
                            return e;
                        } catch (SecurityException e2) {
                            return e2;
                        }
                    }
                });
                if (doPrivileged4 instanceof Constructor) {
                    j = unsafe2.allocateMemory(1L);
                    try {
                        ((Constructor) doPrivileged4).newInstance(Long.valueOf(j), 1);
                        constructor = (Constructor) doPrivileged4;
                        internalLoggerFactory.debug("direct buffer constructor: available");
                    } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
                        constructor = null;
                    } catch (Throwable th5) {
                        th = th5;
                        if (j != -1) {
                            UNSAFE.freeMemory(j);
                        }
                        throw th;
                    }
                } else {
                    internalLoggerFactory.debug("direct buffer constructor: unavailable", (Throwable) doPrivileged4);
                    constructor = null;
                    j = -1;
                }
                if (j != -1) {
                    UNSAFE.freeMemory(j);
                }
                DIRECT_BUFFER_CONSTRUCTOR = constructor;
                ADDRESS_FIELD_OFFSET = objectFieldOffset(field);
                BYTE_ARRAY_BASE_OFFSET = UNSAFE.arrayBaseOffset(byte[].class);
                Object doPrivileged5 = AccessController.doPrivileged(new PrivilegedAction<Object>() { // from class: io.netty.util.internal.PlatformDependent0.5
                    @Override // java.security.PrivilegedAction
                    public Object run() {
                        try {
                            Method declaredMethod = Class.forName("java.nio.Bits", false, PlatformDependent0.getSystemClassLoader()).getDeclaredMethod("unaligned", new Class[0]);
                            Throwable trySetAccessible = ReflectionUtil.trySetAccessible(declaredMethod);
                            return trySetAccessible != null ? trySetAccessible : declaredMethod.invoke(null, new Object[0]);
                        } catch (ClassNotFoundException e) {
                            return e;
                        } catch (IllegalAccessException e2) {
                            return e2;
                        } catch (NoSuchMethodException e3) {
                            return e3;
                        } catch (SecurityException e4) {
                            return e4;
                        } catch (InvocationTargetException e5) {
                            return e5;
                        }
                    }
                });
                if (doPrivileged5 instanceof Boolean) {
                    z = ((Boolean) doPrivileged5).booleanValue();
                    logger.debug("java.nio.Bits.unaligned: available, {}", Boolean.valueOf(z));
                } else {
                    boolean matches = SystemPropertyUtil.get("os.arch", "").matches("^(i[3-6]86|x86(_64)?|x64|amd64)$");
                    logger.debug("java.nio.Bits.unaligned: unavailable {}", Boolean.valueOf(matches), (Throwable) doPrivileged5);
                    z = matches;
                }
                UNALIGNED = z;
                if (javaVersion() >= 9) {
                    final Object doPrivileged6 = AccessController.doPrivileged(new PrivilegedAction<Object>() { // from class: io.netty.util.internal.PlatformDependent0.6
                        @Override // java.security.PrivilegedAction
                        public Object run() {
                            try {
                                return PlatformDependent0.getClassLoader(PlatformDependent0.class).loadClass("jdk.internal.misc.Unsafe").getDeclaredMethod("getUnsafe", new Class[0]).invoke(null, new Object[0]);
                            } catch (Throwable th6) {
                                return th6;
                            }
                        }
                    });
                    if (doPrivileged6 instanceof Throwable) {
                        method = null;
                    } else {
                        Object e = AccessController.doPrivileged(new PrivilegedAction<Object>() { // from class: io.netty.util.internal.PlatformDependent0.7
                            @Override // java.security.PrivilegedAction
                            public Object run() {
                                try {
                                    return doPrivileged6.getClass().getDeclaredMethod("allocateUninitializedArray", Class.class, Integer.TYPE);
                                } catch (NoSuchMethodException e2) {
                                    return e2;
                                } catch (SecurityException e3) {
                                    return e3;
                                }
                            }
                        });
                        if (e instanceof Method) {
                            try {
                                Method method3 = (Method) e;
                                method2 = method3;
                            } catch (IllegalAccessException e2) {
                                e = e2;
                            } catch (InvocationTargetException e3) {
                                e = e3;
                            }
                        }
                        Object obj = e;
                        method = doPrivileged6;
                        doPrivileged6 = obj;
                    }
                    if (doPrivileged6 instanceof Throwable) {
                        logger.debug("jdk.internal.misc.Unsafe.allocateUninitializedArray(int): unavailable", (Throwable) doPrivileged6);
                    } else {
                        logger.debug("jdk.internal.misc.Unsafe.allocateUninitializedArray(int): available");
                    }
                } else {
                    logger.debug("jdk.internal.misc.Unsafe.allocateUninitializedArray(int): unavailable prior to Java9");
                    method = null;
                }
                ALLOCATE_ARRAY_METHOD = method2;
                method2 = method;
            } catch (Throwable th6) {
                th = th6;
                j = -1;
            }
        }
        INTERNAL_UNSAFE = method2;
        logger.debug("java.nio.DirectByteBuffer.<init>(long, int): {}", DIRECT_BUFFER_CONSTRUCTOR != null ? "available" : "unavailable");
    }

    static boolean isExplicitNoUnsafe() {
        return IS_EXPLICIT_NO_UNSAFE;
    }

    private static boolean explicitNoUnsafe0() {
        boolean z;
        boolean z2 = SystemPropertyUtil.getBoolean("io.netty.noUnsafe", false);
        InternalLogger internalLogger = logger;
        internalLogger.debug("-Dio.netty.noUnsafe: {}", Boolean.valueOf(z2));
        if (z2) {
            internalLogger.debug("sun.misc.Unsafe: unavailable (io.netty.noUnsafe)");
            return true;
        }
        if (SystemPropertyUtil.contains("io.netty.tryUnsafe")) {
            z = SystemPropertyUtil.getBoolean("io.netty.tryUnsafe", true);
        } else {
            z = SystemPropertyUtil.getBoolean("org.jboss.netty.tryUnsafe", true);
        }
        if (z) {
            return false;
        }
        internalLogger.debug("sun.misc.Unsafe: unavailable (io.netty.tryUnsafe/org.jboss.netty.tryUnsafe)");
        return true;
    }

    static boolean isUnaligned() {
        return UNALIGNED;
    }

    static boolean hasUnsafe() {
        return UNSAFE != null;
    }

    static Throwable getUnsafeUnavailabilityCause() {
        return UNSAFE_UNAVAILABILITY_CAUSE;
    }

    static boolean unalignedAccess() {
        return UNALIGNED;
    }

    static void throwException(Throwable th) {
        UNSAFE.throwException((Throwable) ObjectUtil.checkNotNull(th, "cause"));
    }

    static boolean hasDirectBufferNoCleanerConstructor() {
        return DIRECT_BUFFER_CONSTRUCTOR != null;
    }

    static ByteBuffer reallocateDirectNoCleaner(ByteBuffer byteBuffer, int i) {
        return newDirectBuffer(UNSAFE.reallocateMemory(directBufferAddress(byteBuffer), i), i);
    }

    static ByteBuffer allocateDirectNoCleaner(int i) {
        return newDirectBuffer(UNSAFE.allocateMemory(i), i);
    }

    static boolean hasAllocateArrayMethod() {
        return ALLOCATE_ARRAY_METHOD != null;
    }

    static byte[] allocateUninitializedArray(int i) {
        try {
            return (byte[]) ALLOCATE_ARRAY_METHOD.invoke(INTERNAL_UNSAFE, Byte.TYPE, Integer.valueOf(i));
        } catch (IllegalAccessException e) {
            throw new Error(e);
        } catch (InvocationTargetException e2) {
            throw new Error(e2);
        }
    }

    static ByteBuffer newDirectBuffer(long j, int i) {
        ObjectUtil.checkPositiveOrZero(i, "capacity");
        try {
            return (ByteBuffer) DIRECT_BUFFER_CONSTRUCTOR.newInstance(Long.valueOf(j), Integer.valueOf(i));
        } catch (Throwable th) {
            if (th instanceof Error) {
                throw th;
            }
            throw new Error(th);
        }
    }

    static long directBufferAddress(ByteBuffer byteBuffer) {
        return getLong(byteBuffer, ADDRESS_FIELD_OFFSET);
    }

    static long byteArrayBaseOffset() {
        return BYTE_ARRAY_BASE_OFFSET;
    }

    static Object getObject(Object obj, long j) {
        return UNSAFE.getObject(obj, j);
    }

    static int getInt(Object obj, long j) {
        return UNSAFE.getInt(obj, j);
    }

    private static long getLong(Object obj, long j) {
        return UNSAFE.getLong(obj, j);
    }

    static long objectFieldOffset(Field field) {
        return UNSAFE.objectFieldOffset(field);
    }

    static byte getByte(long j) {
        return UNSAFE.getByte(j);
    }

    static short getShort(long j) {
        return UNSAFE.getShort(j);
    }

    static int getInt(long j) {
        return UNSAFE.getInt(j);
    }

    static long getLong(long j) {
        return UNSAFE.getLong(j);
    }

    static byte getByte(byte[] bArr, int i) {
        return UNSAFE.getByte(bArr, BYTE_ARRAY_BASE_OFFSET + i);
    }

    static short getShort(byte[] bArr, int i) {
        return UNSAFE.getShort(bArr, BYTE_ARRAY_BASE_OFFSET + i);
    }

    static int getInt(byte[] bArr, int i) {
        return UNSAFE.getInt(bArr, BYTE_ARRAY_BASE_OFFSET + i);
    }

    static long getLong(byte[] bArr, int i) {
        return UNSAFE.getLong(bArr, BYTE_ARRAY_BASE_OFFSET + i);
    }

    static void putByte(long j, byte b) {
        UNSAFE.putByte(j, b);
    }

    static void putShort(long j, short s) {
        UNSAFE.putShort(j, s);
    }

    static void putInt(long j, int i) {
        UNSAFE.putInt(j, i);
    }

    static void putLong(long j, long j2) {
        UNSAFE.putLong(j, j2);
    }

    static void putByte(byte[] bArr, int i, byte b) {
        UNSAFE.putByte(bArr, BYTE_ARRAY_BASE_OFFSET + i, b);
    }

    static void putShort(byte[] bArr, int i, short s) {
        UNSAFE.putShort(bArr, BYTE_ARRAY_BASE_OFFSET + i, s);
    }

    static void putInt(byte[] bArr, int i, int i2) {
        UNSAFE.putInt(bArr, BYTE_ARRAY_BASE_OFFSET + i, i2);
    }

    static void putLong(byte[] bArr, int i, long j) {
        UNSAFE.putLong(bArr, BYTE_ARRAY_BASE_OFFSET + i, j);
    }

    static void copyMemory(long j, long j2, long j3) {
        while (j3 > 0) {
            long min = Math.min(j3, 1048576L);
            UNSAFE.copyMemory(j, j2, min);
            j3 -= min;
            j += min;
            j2 += min;
        }
    }

    static void copyMemory(Object obj, long j, Object obj2, long j2, long j3) {
        long j4 = j;
        long j5 = j2;
        long j6 = j3;
        while (j6 > 0) {
            long min = Math.min(j6, 1048576L);
            UNSAFE.copyMemory(obj, j4, obj2, j5, min);
            j6 -= min;
            j4 += min;
            j5 += min;
        }
    }

    static void setMemory(long j, long j2, byte b) {
        UNSAFE.setMemory(j, j2, b);
    }

    static void setMemory(Object obj, long j, long j2, byte b) {
        UNSAFE.setMemory(obj, j, j2, b);
    }

    static boolean equals(byte[] bArr, int i, byte[] bArr2, int i2, int i3) {
        if (i3 <= 0) {
            return true;
        }
        long j = BYTE_ARRAY_BASE_OFFSET;
        long j2 = i + j;
        long j3 = j + i2;
        int i4 = i3 & 7;
        long j4 = i4 + j2;
        long j5 = i3;
        long j6 = (j3 - 8) + j5;
        long j7 = (j2 - 8) + j5;
        long j8 = j6;
        while (j7 >= j4) {
            Unsafe unsafe = UNSAFE;
            if (unsafe.getLong(bArr, j7) != unsafe.getLong(bArr2, j8)) {
                return false;
            }
            j7 -= 8;
            j8 -= 8;
        }
        if (i4 >= 4) {
            i4 -= 4;
            Unsafe unsafe2 = UNSAFE;
            long j9 = i4;
            if (unsafe2.getInt(bArr, j2 + j9) != unsafe2.getInt(bArr2, j9 + j3)) {
                return false;
            }
        }
        if (i4 < 2) {
            return bArr[i] == bArr2[i2];
        }
        Unsafe unsafe3 = UNSAFE;
        return unsafe3.getChar(bArr, j2) == unsafe3.getChar(bArr2, j3) && (i4 == 2 || bArr[i + 2] == bArr2[i2 + 2]);
    }

    static int equalsConstantTime(byte[] bArr, int i, byte[] bArr2, int i2, int i3) {
        long j = BYTE_ARRAY_BASE_OFFSET;
        long j2 = i + j;
        int i4 = i3 & 7;
        long j3 = i4 + j2;
        long j4 = i3;
        long j5 = (j2 - 8) + j4;
        long j6 = ((j + i2) - 8) + j4;
        long j7 = 0;
        while (j5 >= j3) {
            Unsafe unsafe = UNSAFE;
            j7 |= unsafe.getLong(bArr, j5) ^ unsafe.getLong(bArr2, j6);
            j5 -= 8;
            j6 -= 8;
        }
        switch (i4) {
            case 1:
                Unsafe unsafe2 = UNSAFE;
                return ConstantTimeUtils.equalsConstantTime((unsafe2.getByte(bArr, j2) ^ unsafe2.getByte(bArr2, r3)) | j7, 0L);
            case 2:
                Unsafe unsafe3 = UNSAFE;
                return ConstantTimeUtils.equalsConstantTime((unsafe3.getChar(bArr, j2) ^ unsafe3.getChar(bArr2, r3)) | j7, 0L);
            case 3:
                Unsafe unsafe4 = UNSAFE;
                return ConstantTimeUtils.equalsConstantTime((unsafe4.getByte(bArr, j2) ^ unsafe4.getByte(bArr2, r3)) | (unsafe4.getChar(bArr, j2 + 1) ^ unsafe4.getChar(bArr2, 1 + r3)) | j7, 0L);
            case 4:
                Unsafe unsafe5 = UNSAFE;
                return ConstantTimeUtils.equalsConstantTime((unsafe5.getInt(bArr, j2) ^ unsafe5.getInt(bArr2, r3)) | j7, 0L);
            case 5:
                Unsafe unsafe6 = UNSAFE;
                return ConstantTimeUtils.equalsConstantTime((unsafe6.getByte(bArr, j2) ^ unsafe6.getByte(bArr2, r3)) | (unsafe6.getInt(bArr, j2 + 1) ^ unsafe6.getInt(bArr2, 1 + r3)) | j7, 0L);
            case 6:
                Unsafe unsafe7 = UNSAFE;
                return ConstantTimeUtils.equalsConstantTime((unsafe7.getChar(bArr, j2) ^ unsafe7.getChar(bArr2, r3)) | (unsafe7.getInt(bArr2, 2 + r3) ^ unsafe7.getInt(bArr, j2 + 2)) | j7, 0L);
            case 7:
                Unsafe unsafe8 = UNSAFE;
                return ConstantTimeUtils.equalsConstantTime((unsafe8.getByte(bArr, j2) ^ unsafe8.getByte(bArr2, r3)) | (unsafe8.getChar(bArr, j2 + 1) ^ unsafe8.getChar(bArr2, 1 + r3)) | j7 | (unsafe8.getInt(bArr, j2 + 3) ^ unsafe8.getInt(bArr2, 3 + r3)), 0L);
            default:
                return ConstantTimeUtils.equalsConstantTime(j7, 0L);
        }
    }

    static boolean isZero(byte[] bArr, int i, int i2) {
        if (i2 <= 0) {
            return true;
        }
        long j = BYTE_ARRAY_BASE_OFFSET + i;
        int i3 = i2 & 7;
        long j2 = i3 + j;
        for (long j3 = (j - 8) + i2; j3 >= j2; j3 -= 8) {
            if (UNSAFE.getLong(bArr, j3) != 0) {
                return false;
            }
        }
        if (i3 >= 4) {
            i3 -= 4;
            if (UNSAFE.getInt(bArr, i3 + j) != 0) {
                return false;
            }
        }
        return i3 >= 2 ? UNSAFE.getChar(bArr, j) == 0 && (i3 == 2 || bArr[i + 2] == 0) : bArr[i] == 0;
    }

    static int hashCodeAscii(byte[] bArr, int i, int i2) {
        int i3;
        int hashCodeAsciiSanitize;
        long j = BYTE_ARRAY_BASE_OFFSET + i;
        int i4 = i2 & 7;
        long j2 = i4 + j;
        int i5 = HASH_CODE_ASCII_SEED;
        for (long j3 = (j - 8) + i2; j3 >= j2; j3 -= 8) {
            i5 = hashCodeAsciiCompute(UNSAFE.getLong(bArr, j3), i5);
        }
        switch (i4) {
            case 1:
                i3 = i5 * HASH_CODE_C1;
                hashCodeAsciiSanitize = hashCodeAsciiSanitize(UNSAFE.getByte(bArr, j));
                break;
            case 2:
                i3 = i5 * HASH_CODE_C1;
                hashCodeAsciiSanitize = hashCodeAsciiSanitize(UNSAFE.getShort(bArr, j));
                break;
            case 3:
                int i6 = i5 * HASH_CODE_C1;
                Unsafe unsafe = UNSAFE;
                i3 = (i6 + hashCodeAsciiSanitize(unsafe.getByte(bArr, j))) * HASH_CODE_C2;
                hashCodeAsciiSanitize = hashCodeAsciiSanitize(unsafe.getShort(bArr, j + 1));
                break;
            case 4:
                i3 = i5 * HASH_CODE_C1;
                hashCodeAsciiSanitize = hashCodeAsciiSanitize(UNSAFE.getInt(bArr, j));
                break;
            case 5:
                int i7 = i5 * HASH_CODE_C1;
                Unsafe unsafe2 = UNSAFE;
                i3 = (i7 + hashCodeAsciiSanitize(unsafe2.getByte(bArr, j))) * HASH_CODE_C2;
                hashCodeAsciiSanitize = hashCodeAsciiSanitize(unsafe2.getInt(bArr, j + 1));
                break;
            case 6:
                int i8 = i5 * HASH_CODE_C1;
                Unsafe unsafe3 = UNSAFE;
                i3 = (i8 + hashCodeAsciiSanitize(unsafe3.getShort(bArr, j))) * HASH_CODE_C2;
                hashCodeAsciiSanitize = hashCodeAsciiSanitize(unsafe3.getInt(bArr, j + 2));
                break;
            case 7:
                int i9 = i5 * HASH_CODE_C1;
                Unsafe unsafe4 = UNSAFE;
                i3 = (((i9 + hashCodeAsciiSanitize(unsafe4.getByte(bArr, j))) * HASH_CODE_C2) + hashCodeAsciiSanitize(unsafe4.getShort(bArr, 1 + j))) * HASH_CODE_C1;
                hashCodeAsciiSanitize = hashCodeAsciiSanitize(unsafe4.getInt(bArr, j + 3));
                break;
            default:
                return i5;
        }
        return i3 + hashCodeAsciiSanitize;
    }

    static int hashCodeAsciiCompute(long j, int i) {
        return (i * HASH_CODE_C1) + (hashCodeAsciiSanitize((int) j) * HASH_CODE_C2) + ((int) ((j & 2242545357458243584L) >>> 32));
    }

    static ClassLoader getClassLoader(final Class<?> cls) {
        if (System.getSecurityManager() == null) {
            return cls.getClassLoader();
        }
        return (ClassLoader) AccessController.doPrivileged(new PrivilegedAction<ClassLoader>() { // from class: io.netty.util.internal.PlatformDependent0.8
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.security.PrivilegedAction
            public ClassLoader run() {
                return cls.getClassLoader();
            }
        });
    }

    static ClassLoader getContextClassLoader() {
        if (System.getSecurityManager() == null) {
            return Thread.currentThread().getContextClassLoader();
        }
        return (ClassLoader) AccessController.doPrivileged(new PrivilegedAction<ClassLoader>() { // from class: io.netty.util.internal.PlatformDependent0.9
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.security.PrivilegedAction
            public ClassLoader run() {
                return Thread.currentThread().getContextClassLoader();
            }
        });
    }

    static ClassLoader getSystemClassLoader() {
        if (System.getSecurityManager() == null) {
            return ClassLoader.getSystemClassLoader();
        }
        return (ClassLoader) AccessController.doPrivileged(new PrivilegedAction<ClassLoader>() { // from class: io.netty.util.internal.PlatformDependent0.10
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.security.PrivilegedAction
            public ClassLoader run() {
                return ClassLoader.getSystemClassLoader();
            }
        });
    }

    static int addressSize() {
        return UNSAFE.addressSize();
    }

    static long allocateMemory(long j) {
        return UNSAFE.allocateMemory(j);
    }

    static void freeMemory(long j) {
        UNSAFE.freeMemory(j);
    }

    static long reallocateMemory(long j, long j2) {
        return UNSAFE.reallocateMemory(j, j2);
    }

    static boolean isAndroid() {
        return IS_ANDROID;
    }

    private static boolean isAndroid0() {
        boolean z = false;
        try {
            Class.forName("android.app.Application", false, getSystemClassLoader());
            z = true;
        } catch (Throwable unused) {
        }
        if (z) {
            logger.debug("Platform: Android");
        }
        return z;
    }

    static int javaVersion() {
        return JAVA_VERSION;
    }

    private static int javaVersion0() {
        int majorVersionFromJavaSpecificationVersion = isAndroid0() ? 6 : majorVersionFromJavaSpecificationVersion();
        logger.debug("Java version: {}", Integer.valueOf(majorVersionFromJavaSpecificationVersion));
        return majorVersionFromJavaSpecificationVersion;
    }

    static int majorVersionFromJavaSpecificationVersion() {
        return majorVersion(SystemPropertyUtil.get("java.specification.version", "1.6"));
    }

    static int majorVersion(String str) {
        String[] split = str.split("\\.");
        int[] iArr = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            iArr[i] = Integer.parseInt(split[i]);
        }
        if (iArr[0] == 1) {
            return iArr[1];
        }
        return iArr[0];
    }

    private PlatformDependent0() {
    }
}
