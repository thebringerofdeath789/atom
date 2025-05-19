package org.apache.commons.beanutils;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/* loaded from: classes4.dex */
public class BeanUtils {

    @Deprecated
    private static int debug;

    @Deprecated
    public static int getDebug() {
        return debug;
    }

    @Deprecated
    public static void setDebug(int i) {
        debug = i;
    }

    public static Object cloneBean(Object obj) throws IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException {
        return BeanUtilsBean.getInstance().cloneBean(obj);
    }

    public static void copyProperties(Object obj, Object obj2) throws IllegalAccessException, InvocationTargetException {
        BeanUtilsBean.getInstance().copyProperties(obj, obj2);
    }

    public static void copyProperty(Object obj, String str, Object obj2) throws IllegalAccessException, InvocationTargetException {
        BeanUtilsBean.getInstance().copyProperty(obj, str, obj2);
    }

    public static Map<String, String> describe(Object obj) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        return BeanUtilsBean.getInstance().describe(obj);
    }

    public static String[] getArrayProperty(Object obj, String str) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        return BeanUtilsBean.getInstance().getArrayProperty(obj, str);
    }

    public static String getIndexedProperty(Object obj, String str) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        return BeanUtilsBean.getInstance().getIndexedProperty(obj, str);
    }

    public static String getIndexedProperty(Object obj, String str, int i) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        return BeanUtilsBean.getInstance().getIndexedProperty(obj, str, i);
    }

    public static String getMappedProperty(Object obj, String str) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        return BeanUtilsBean.getInstance().getMappedProperty(obj, str);
    }

    public static String getMappedProperty(Object obj, String str, String str2) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        return BeanUtilsBean.getInstance().getMappedProperty(obj, str, str2);
    }

    public static String getNestedProperty(Object obj, String str) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        return BeanUtilsBean.getInstance().getNestedProperty(obj, str);
    }

    public static String getProperty(Object obj, String str) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        return BeanUtilsBean.getInstance().getProperty(obj, str);
    }

    public static String getSimpleProperty(Object obj, String str) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        return BeanUtilsBean.getInstance().getSimpleProperty(obj, str);
    }

    public static void populate(Object obj, Map<String, ? extends Object> map) throws IllegalAccessException, InvocationTargetException {
        BeanUtilsBean.getInstance().populate(obj, map);
    }

    public static void setProperty(Object obj, String str, Object obj2) throws IllegalAccessException, InvocationTargetException {
        BeanUtilsBean.getInstance().setProperty(obj, str, obj2);
    }

    public static boolean initCause(Throwable th, Throwable th2) {
        return BeanUtilsBean.getInstance().initCause(th, th2);
    }

    public static <K, V> Map<K, V> createCache() {
        return new WeakFastHashMap();
    }

    public static boolean getCacheFast(Map<?, ?> map) {
        if (map instanceof WeakFastHashMap) {
            return ((WeakFastHashMap) map).getFast();
        }
        return false;
    }

    public static void setCacheFast(Map<?, ?> map, boolean z) {
        if (map instanceof WeakFastHashMap) {
            ((WeakFastHashMap) map).setFast(z);
        }
    }
}
