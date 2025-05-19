package org.apache.commons.beanutils.locale;

import java.util.Locale;
import org.apache.commons.collections.FastHashMap;

/* loaded from: classes4.dex */
public class LocaleConvertUtils {
    public static Locale getDefaultLocale() {
        return LocaleConvertUtilsBean.getInstance().getDefaultLocale();
    }

    public static void setDefaultLocale(Locale locale) {
        LocaleConvertUtilsBean.getInstance().setDefaultLocale(locale);
    }

    public static boolean getApplyLocalized() {
        return LocaleConvertUtilsBean.getInstance().getApplyLocalized();
    }

    public static void setApplyLocalized(boolean z) {
        LocaleConvertUtilsBean.getInstance().setApplyLocalized(z);
    }

    public static String convert(Object obj) {
        return LocaleConvertUtilsBean.getInstance().convert(obj);
    }

    public static String convert(Object obj, String str) {
        return LocaleConvertUtilsBean.getInstance().convert(obj, str);
    }

    public static String convert(Object obj, Locale locale, String str) {
        return LocaleConvertUtilsBean.getInstance().convert(obj, locale, str);
    }

    public static Object convert(String str, Class<?> cls) {
        return LocaleConvertUtilsBean.getInstance().convert(str, cls);
    }

    public static Object convert(String str, Class<?> cls, String str2) {
        return LocaleConvertUtilsBean.getInstance().convert(str, cls, str2);
    }

    public static Object convert(String str, Class<?> cls, Locale locale, String str2) {
        return LocaleConvertUtilsBean.getInstance().convert(str, cls, locale, str2);
    }

    public static Object convert(String[] strArr, Class<?> cls, String str) {
        return LocaleConvertUtilsBean.getInstance().convert(strArr, cls, str);
    }

    public static Object convert(String[] strArr, Class<?> cls) {
        return LocaleConvertUtilsBean.getInstance().convert(strArr, cls);
    }

    public static Object convert(String[] strArr, Class<?> cls, Locale locale, String str) {
        return LocaleConvertUtilsBean.getInstance().convert(strArr, cls, locale, str);
    }

    public static void register(LocaleConverter localeConverter, Class<?> cls, Locale locale) {
        LocaleConvertUtilsBean.getInstance().register(localeConverter, cls, locale);
    }

    public static void deregister() {
        LocaleConvertUtilsBean.getInstance().deregister();
    }

    public static void deregister(Locale locale) {
        LocaleConvertUtilsBean.getInstance().deregister(locale);
    }

    public static void deregister(Class<?> cls, Locale locale) {
        LocaleConvertUtilsBean.getInstance().deregister(cls, locale);
    }

    public static LocaleConverter lookup(Class<?> cls, Locale locale) {
        return LocaleConvertUtilsBean.getInstance().lookup(cls, locale);
    }

    @Deprecated
    protected static FastHashMap lookup(Locale locale) {
        return LocaleConvertUtilsBean.getInstance().lookup(locale);
    }

    @Deprecated
    protected static FastHashMap create(Locale locale) {
        return LocaleConvertUtilsBean.getInstance().create(locale);
    }
}
