package org.apache.commons.beanutils;

import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import org.apache.commons.collections.FastHashMap;

/* loaded from: classes4.dex */
public class PropertyUtils {

    @Deprecated
    public static final char INDEXED_DELIM = '[';

    @Deprecated
    public static final char INDEXED_DELIM2 = ']';

    @Deprecated
    public static final char MAPPED_DELIM = '(';

    @Deprecated
    public static final char MAPPED_DELIM2 = ')';

    @Deprecated
    public static final char NESTED_DELIM = '.';

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

    public static void clearDescriptors() {
        PropertyUtilsBean.getInstance().clearDescriptors();
    }

    public static void resetBeanIntrospectors() {
        PropertyUtilsBean.getInstance().resetBeanIntrospectors();
    }

    public static void addBeanIntrospector(BeanIntrospector beanIntrospector) {
        PropertyUtilsBean.getInstance().addBeanIntrospector(beanIntrospector);
    }

    public static boolean removeBeanIntrospector(BeanIntrospector beanIntrospector) {
        return PropertyUtilsBean.getInstance().removeBeanIntrospector(beanIntrospector);
    }

    public static void copyProperties(Object obj, Object obj2) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        PropertyUtilsBean.getInstance().copyProperties(obj, obj2);
    }

    public static Map<String, Object> describe(Object obj) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        return PropertyUtilsBean.getInstance().describe(obj);
    }

    public static Object getIndexedProperty(Object obj, String str) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        return PropertyUtilsBean.getInstance().getIndexedProperty(obj, str);
    }

    public static Object getIndexedProperty(Object obj, String str, int i) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        return PropertyUtilsBean.getInstance().getIndexedProperty(obj, str, i);
    }

    public static Object getMappedProperty(Object obj, String str) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        return PropertyUtilsBean.getInstance().getMappedProperty(obj, str);
    }

    public static Object getMappedProperty(Object obj, String str, String str2) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        return PropertyUtilsBean.getInstance().getMappedProperty(obj, str, str2);
    }

    @Deprecated
    public static FastHashMap getMappedPropertyDescriptors(Class<?> cls) {
        return PropertyUtilsBean.getInstance().getMappedPropertyDescriptors(cls);
    }

    @Deprecated
    public static FastHashMap getMappedPropertyDescriptors(Object obj) {
        return PropertyUtilsBean.getInstance().getMappedPropertyDescriptors(obj);
    }

    public static Object getNestedProperty(Object obj, String str) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        return PropertyUtilsBean.getInstance().getNestedProperty(obj, str);
    }

    public static Object getProperty(Object obj, String str) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        return PropertyUtilsBean.getInstance().getProperty(obj, str);
    }

    public static PropertyDescriptor getPropertyDescriptor(Object obj, String str) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        return PropertyUtilsBean.getInstance().getPropertyDescriptor(obj, str);
    }

    public static PropertyDescriptor[] getPropertyDescriptors(Class<?> cls) {
        return PropertyUtilsBean.getInstance().getPropertyDescriptors(cls);
    }

    public static PropertyDescriptor[] getPropertyDescriptors(Object obj) {
        return PropertyUtilsBean.getInstance().getPropertyDescriptors(obj);
    }

    public static Class<?> getPropertyEditorClass(Object obj, String str) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        return PropertyUtilsBean.getInstance().getPropertyEditorClass(obj, str);
    }

    public static Class<?> getPropertyType(Object obj, String str) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        return PropertyUtilsBean.getInstance().getPropertyType(obj, str);
    }

    public static Method getReadMethod(PropertyDescriptor propertyDescriptor) {
        return PropertyUtilsBean.getInstance().getReadMethod(propertyDescriptor);
    }

    public static Object getSimpleProperty(Object obj, String str) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        return PropertyUtilsBean.getInstance().getSimpleProperty(obj, str);
    }

    public static Method getWriteMethod(PropertyDescriptor propertyDescriptor) {
        return PropertyUtilsBean.getInstance().getWriteMethod(propertyDescriptor);
    }

    public static boolean isReadable(Object obj, String str) {
        return PropertyUtilsBean.getInstance().isReadable(obj, str);
    }

    public static boolean isWriteable(Object obj, String str) {
        return PropertyUtilsBean.getInstance().isWriteable(obj, str);
    }

    public static void setIndexedProperty(Object obj, String str, Object obj2) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        PropertyUtilsBean.getInstance().setIndexedProperty(obj, str, obj2);
    }

    public static void setIndexedProperty(Object obj, String str, int i, Object obj2) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        PropertyUtilsBean.getInstance().setIndexedProperty(obj, str, i, obj2);
    }

    public static void setMappedProperty(Object obj, String str, Object obj2) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        PropertyUtilsBean.getInstance().setMappedProperty(obj, str, obj2);
    }

    public static void setMappedProperty(Object obj, String str, String str2, Object obj2) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        PropertyUtilsBean.getInstance().setMappedProperty(obj, str, str2, obj2);
    }

    public static void setNestedProperty(Object obj, String str, Object obj2) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        PropertyUtilsBean.getInstance().setNestedProperty(obj, str, obj2);
    }

    public static void setProperty(Object obj, String str, Object obj2) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        PropertyUtilsBean.getInstance().setProperty(obj, str, obj2);
    }

    public static void setSimpleProperty(Object obj, String str, Object obj2) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        PropertyUtilsBean.getInstance().setSimpleProperty(obj, str, obj2);
    }
}
