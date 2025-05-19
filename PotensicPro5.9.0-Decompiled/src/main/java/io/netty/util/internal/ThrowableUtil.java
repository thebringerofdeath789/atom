package io.netty.util.internal;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes4.dex */
public final class ThrowableUtil {
    private static final Method addSupressedMethod = getAddSuppressed();

    private static Method getAddSuppressed() {
        if (PlatformDependent.javaVersion() < 7) {
            return null;
        }
        try {
            return Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    private ThrowableUtil() {
    }

    public static <T extends Throwable> T unknownStackTrace(T t, Class<?> cls, String str) {
        t.setStackTrace(new StackTraceElement[]{new StackTraceElement(cls.getName(), str, null, -1)});
        return t;
    }

    public static String stackTraceToString(Throwable th) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        th.printStackTrace(printStream);
        printStream.flush();
        try {
            return new String(byteArrayOutputStream.toByteArray());
        } finally {
            try {
                byteArrayOutputStream.close();
            } catch (IOException unused) {
            }
        }
    }

    public static boolean haveSuppressed() {
        return addSupressedMethod != null;
    }

    public static void addSuppressed(Throwable th, Throwable th2) {
        if (haveSuppressed()) {
            try {
                addSupressedMethod.invoke(th, th2);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e2) {
                throw new RuntimeException(e2);
            }
        }
    }

    public static void addSuppressedAndClear(Throwable th, List<Throwable> list) {
        addSuppressed(th, list);
        list.clear();
    }

    public static void addSuppressed(Throwable th, List<Throwable> list) {
        Iterator<Throwable> it = list.iterator();
        while (it.hasNext()) {
            addSuppressed(th, it.next());
        }
    }
}
