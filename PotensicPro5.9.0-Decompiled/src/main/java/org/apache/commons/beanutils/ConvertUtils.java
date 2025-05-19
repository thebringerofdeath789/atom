package org.apache.commons.beanutils;

/* loaded from: classes4.dex */
public class ConvertUtils {
    @Deprecated
    public static boolean getDefaultBoolean() {
        return ConvertUtilsBean.getInstance().getDefaultBoolean();
    }

    @Deprecated
    public static void setDefaultBoolean(boolean z) {
        ConvertUtilsBean.getInstance().setDefaultBoolean(z);
    }

    @Deprecated
    public static byte getDefaultByte() {
        return ConvertUtilsBean.getInstance().getDefaultByte();
    }

    @Deprecated
    public static void setDefaultByte(byte b) {
        ConvertUtilsBean.getInstance().setDefaultByte(b);
    }

    @Deprecated
    public static char getDefaultCharacter() {
        return ConvertUtilsBean.getInstance().getDefaultCharacter();
    }

    @Deprecated
    public static void setDefaultCharacter(char c) {
        ConvertUtilsBean.getInstance().setDefaultCharacter(c);
    }

    @Deprecated
    public static double getDefaultDouble() {
        return ConvertUtilsBean.getInstance().getDefaultDouble();
    }

    @Deprecated
    public static void setDefaultDouble(double d) {
        ConvertUtilsBean.getInstance().setDefaultDouble(d);
    }

    @Deprecated
    public static float getDefaultFloat() {
        return ConvertUtilsBean.getInstance().getDefaultFloat();
    }

    @Deprecated
    public static void setDefaultFloat(float f) {
        ConvertUtilsBean.getInstance().setDefaultFloat(f);
    }

    @Deprecated
    public static int getDefaultInteger() {
        return ConvertUtilsBean.getInstance().getDefaultInteger();
    }

    @Deprecated
    public static void setDefaultInteger(int i) {
        ConvertUtilsBean.getInstance().setDefaultInteger(i);
    }

    @Deprecated
    public static long getDefaultLong() {
        return ConvertUtilsBean.getInstance().getDefaultLong();
    }

    @Deprecated
    public static void setDefaultLong(long j) {
        ConvertUtilsBean.getInstance().setDefaultLong(j);
    }

    @Deprecated
    public static short getDefaultShort() {
        return ConvertUtilsBean.getInstance().getDefaultShort();
    }

    @Deprecated
    public static void setDefaultShort(short s) {
        ConvertUtilsBean.getInstance().setDefaultShort(s);
    }

    public static String convert(Object obj) {
        return ConvertUtilsBean.getInstance().convert(obj);
    }

    public static Object convert(String str, Class<?> cls) {
        return ConvertUtilsBean.getInstance().convert(str, cls);
    }

    public static Object convert(String[] strArr, Class<?> cls) {
        return ConvertUtilsBean.getInstance().convert(strArr, cls);
    }

    public static Object convert(Object obj, Class<?> cls) {
        return ConvertUtilsBean.getInstance().convert(obj, cls);
    }

    public static void deregister() {
        ConvertUtilsBean.getInstance().deregister();
    }

    public static void deregister(Class<?> cls) {
        ConvertUtilsBean.getInstance().deregister(cls);
    }

    public static Converter lookup(Class<?> cls) {
        return ConvertUtilsBean.getInstance().lookup(cls);
    }

    public static Converter lookup(Class<?> cls, Class<?> cls2) {
        return ConvertUtilsBean.getInstance().lookup(cls, cls2);
    }

    public static void register(Converter converter, Class<?> cls) {
        ConvertUtilsBean.getInstance().register(converter, cls);
    }

    public static <T> Class<T> primitiveToWrapper(Class<T> cls) {
        if (cls == null || !cls.isPrimitive()) {
            return cls;
        }
        if (cls == Integer.TYPE) {
            return Integer.class;
        }
        if (cls == Double.TYPE) {
            return Double.class;
        }
        if (cls == Long.TYPE) {
            return Long.class;
        }
        if (cls == Boolean.TYPE) {
            return Boolean.class;
        }
        if (cls == Float.TYPE) {
            return Float.class;
        }
        if (cls == Short.TYPE) {
            return Short.class;
        }
        if (cls == Byte.TYPE) {
            return Byte.class;
        }
        return cls == Character.TYPE ? Character.class : cls;
    }
}
