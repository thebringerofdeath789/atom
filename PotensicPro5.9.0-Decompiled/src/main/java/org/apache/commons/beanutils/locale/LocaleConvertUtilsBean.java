package org.apache.commons.beanutils.locale;

import com.ipotensic.baselib.utils.DateUtils;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.locale.converters.BigDecimalLocaleConverter;
import org.apache.commons.beanutils.locale.converters.BigIntegerLocaleConverter;
import org.apache.commons.beanutils.locale.converters.ByteLocaleConverter;
import org.apache.commons.beanutils.locale.converters.DoubleLocaleConverter;
import org.apache.commons.beanutils.locale.converters.FloatLocaleConverter;
import org.apache.commons.beanutils.locale.converters.IntegerLocaleConverter;
import org.apache.commons.beanutils.locale.converters.LongLocaleConverter;
import org.apache.commons.beanutils.locale.converters.ShortLocaleConverter;
import org.apache.commons.beanutils.locale.converters.SqlDateLocaleConverter;
import org.apache.commons.beanutils.locale.converters.SqlTimeLocaleConverter;
import org.apache.commons.beanutils.locale.converters.SqlTimestampLocaleConverter;
import org.apache.commons.beanutils.locale.converters.StringLocaleConverter;
import org.apache.commons.collections.FastHashMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/* loaded from: classes4.dex */
public class LocaleConvertUtilsBean {
    private final FastHashMap mapConverters;
    private Locale defaultLocale = Locale.getDefault();
    private boolean applyLocalized = false;
    private final Log log = LogFactory.getLog(LocaleConvertUtils.class);

    public static LocaleConvertUtilsBean getInstance() {
        return LocaleBeanUtilsBean.getLocaleBeanUtilsInstance().getLocaleConvertUtils();
    }

    public LocaleConvertUtilsBean() {
        DelegateFastHashMap delegateFastHashMap = new DelegateFastHashMap(BeanUtils.createCache());
        this.mapConverters = delegateFastHashMap;
        delegateFastHashMap.setFast(false);
        deregister();
        delegateFastHashMap.setFast(true);
    }

    public Locale getDefaultLocale() {
        return this.defaultLocale;
    }

    public void setDefaultLocale(Locale locale) {
        if (locale == null) {
            this.defaultLocale = Locale.getDefault();
        } else {
            this.defaultLocale = locale;
        }
    }

    public boolean getApplyLocalized() {
        return this.applyLocalized;
    }

    public void setApplyLocalized(boolean z) {
        this.applyLocalized = z;
    }

    public String convert(Object obj) {
        return convert(obj, this.defaultLocale, (String) null);
    }

    public String convert(Object obj, String str) {
        return convert(obj, this.defaultLocale, str);
    }

    public String convert(Object obj, Locale locale, String str) {
        return (String) lookup(String.class, locale).convert(String.class, obj, str);
    }

    public Object convert(String str, Class<?> cls) {
        return convert(str, cls, this.defaultLocale, (String) null);
    }

    public Object convert(String str, Class<?> cls, String str2) {
        return convert(str, cls, this.defaultLocale, str2);
    }

    public Object convert(String str, Class<?> cls, Locale locale, String str2) {
        if (this.log.isDebugEnabled()) {
            this.log.debug("Convert string " + str + " to class " + cls.getName() + " using " + locale + " locale and " + str2 + " pattern");
        }
        LocaleConverter lookup = lookup(cls, locale);
        if (lookup == null) {
            lookup = lookup(String.class, locale);
            cls = String.class;
        }
        if (this.log.isTraceEnabled()) {
            this.log.trace("  Using converter " + lookup);
        }
        return lookup.convert(cls, str, str2);
    }

    public Object convert(String[] strArr, Class<?> cls, String str) {
        return convert(strArr, cls, getDefaultLocale(), str);
    }

    public Object convert(String[] strArr, Class<?> cls) {
        return convert(strArr, cls, getDefaultLocale(), (String) null);
    }

    public Object convert(String[] strArr, Class<?> cls, Locale locale, String str) {
        if (cls.isArray()) {
            cls = cls.getComponentType();
        }
        if (this.log.isDebugEnabled()) {
            this.log.debug("Convert String[" + strArr.length + "] to class " + cls.getName() + "[] using " + locale + " locale and " + str + " pattern");
        }
        Object newInstance = Array.newInstance(cls, strArr.length);
        for (int i = 0; i < strArr.length; i++) {
            Array.set(newInstance, i, convert(strArr[i], cls, locale, str));
        }
        return newInstance;
    }

    public void register(LocaleConverter localeConverter, Class<?> cls, Locale locale) {
        lookup(locale).put(cls, localeConverter);
    }

    public void deregister() {
        FastHashMap lookup = lookup(this.defaultLocale);
        this.mapConverters.setFast(false);
        this.mapConverters.clear();
        this.mapConverters.put(this.defaultLocale, lookup);
        this.mapConverters.setFast(true);
    }

    public void deregister(Locale locale) {
        this.mapConverters.remove(locale);
    }

    public void deregister(Class<?> cls, Locale locale) {
        lookup(locale).remove(cls);
    }

    public LocaleConverter lookup(Class<?> cls, Locale locale) {
        LocaleConverter localeConverter = (LocaleConverter) lookup(locale).get(cls);
        if (this.log.isTraceEnabled()) {
            this.log.trace("LocaleConverter:" + localeConverter);
        }
        return localeConverter;
    }

    @Deprecated
    protected FastHashMap lookup(Locale locale) {
        if (locale == null) {
            return (FastHashMap) this.mapConverters.get(this.defaultLocale);
        }
        FastHashMap fastHashMap = (FastHashMap) this.mapConverters.get(locale);
        if (fastHashMap == null) {
            fastHashMap = create(locale);
            this.mapConverters.put(locale, fastHashMap);
        }
        return fastHashMap;
    }

    @Deprecated
    protected FastHashMap create(Locale locale) {
        DelegateFastHashMap delegateFastHashMap = new DelegateFastHashMap(BeanUtils.createCache());
        delegateFastHashMap.setFast(false);
        delegateFastHashMap.put(BigDecimal.class, new BigDecimalLocaleConverter(locale, this.applyLocalized));
        delegateFastHashMap.put(BigInteger.class, new BigIntegerLocaleConverter(locale, this.applyLocalized));
        delegateFastHashMap.put(Byte.class, new ByteLocaleConverter(locale, this.applyLocalized));
        delegateFastHashMap.put(Byte.TYPE, new ByteLocaleConverter(locale, this.applyLocalized));
        delegateFastHashMap.put(Double.class, new DoubleLocaleConverter(locale, this.applyLocalized));
        delegateFastHashMap.put(Double.TYPE, new DoubleLocaleConverter(locale, this.applyLocalized));
        delegateFastHashMap.put(Float.class, new FloatLocaleConverter(locale, this.applyLocalized));
        delegateFastHashMap.put(Float.TYPE, new FloatLocaleConverter(locale, this.applyLocalized));
        delegateFastHashMap.put(Integer.class, new IntegerLocaleConverter(locale, this.applyLocalized));
        delegateFastHashMap.put(Integer.TYPE, new IntegerLocaleConverter(locale, this.applyLocalized));
        delegateFastHashMap.put(Long.class, new LongLocaleConverter(locale, this.applyLocalized));
        delegateFastHashMap.put(Long.TYPE, new LongLocaleConverter(locale, this.applyLocalized));
        delegateFastHashMap.put(Short.class, new ShortLocaleConverter(locale, this.applyLocalized));
        delegateFastHashMap.put(Short.TYPE, new ShortLocaleConverter(locale, this.applyLocalized));
        delegateFastHashMap.put(String.class, new StringLocaleConverter(locale, this.applyLocalized));
        delegateFastHashMap.put(Date.class, new SqlDateLocaleConverter(locale, DateUtils.YMDHMS2));
        delegateFastHashMap.put(Time.class, new SqlTimeLocaleConverter(locale, DateUtils.YMDHMS3));
        delegateFastHashMap.put(Timestamp.class, new SqlTimestampLocaleConverter(locale, "yyyy-MM-dd HH:mm:ss.S"));
        delegateFastHashMap.setFast(true);
        return delegateFastHashMap;
    }

    private static class DelegateFastHashMap extends FastHashMap {
        private final Map<Object, Object> map;

        private DelegateFastHashMap(Map<Object, Object> map) {
            this.map = map;
        }

        @Override // org.apache.commons.collections.FastHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public void clear() {
            this.map.clear();
        }

        @Override // org.apache.commons.collections.FastHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return this.map.containsKey(obj);
        }

        @Override // org.apache.commons.collections.FastHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public boolean containsValue(Object obj) {
            return this.map.containsValue(obj);
        }

        @Override // org.apache.commons.collections.FastHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public Set<Map.Entry<Object, Object>> entrySet() {
            return this.map.entrySet();
        }

        @Override // org.apache.commons.collections.FastHashMap, java.util.AbstractMap, java.util.Map
        public boolean equals(Object obj) {
            return this.map.equals(obj);
        }

        @Override // org.apache.commons.collections.FastHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public Object get(Object obj) {
            return this.map.get(obj);
        }

        @Override // org.apache.commons.collections.FastHashMap, java.util.AbstractMap, java.util.Map
        public int hashCode() {
            return this.map.hashCode();
        }

        @Override // org.apache.commons.collections.FastHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public boolean isEmpty() {
            return this.map.isEmpty();
        }

        @Override // org.apache.commons.collections.FastHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public Set<Object> keySet() {
            return this.map.keySet();
        }

        @Override // org.apache.commons.collections.FastHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public Object put(Object obj, Object obj2) {
            return this.map.put(obj, obj2);
        }

        @Override // org.apache.commons.collections.FastHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public void putAll(Map map) {
            this.map.putAll(map);
        }

        @Override // org.apache.commons.collections.FastHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public Object remove(Object obj) {
            return this.map.remove(obj);
        }

        @Override // org.apache.commons.collections.FastHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public int size() {
            return this.map.size();
        }

        @Override // org.apache.commons.collections.FastHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public Collection<Object> values() {
            return this.map.values();
        }

        @Override // org.apache.commons.collections.FastHashMap
        public boolean getFast() {
            return BeanUtils.getCacheFast(this.map);
        }

        @Override // org.apache.commons.collections.FastHashMap
        public void setFast(boolean z) {
            BeanUtils.setCacheFast(this.map, z);
        }
    }
}
