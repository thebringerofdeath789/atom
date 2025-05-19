package org.apache.commons.lang3.time;

import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.apache.commons.lang3.LocaleUtils;
import org.apache.commons.lang3.Validate;

/* loaded from: classes4.dex */
abstract class FormatCache<F extends Format> {
    static final int NONE = -1;
    private static final ConcurrentMap<ArrayKey, String> cDateTimeInstanceCache = new ConcurrentHashMap(7);
    private final ConcurrentMap<ArrayKey, F> cInstanceCache = new ConcurrentHashMap(7);

    protected abstract F createInstance(String str, TimeZone timeZone, Locale locale);

    FormatCache() {
    }

    public F getInstance() {
        return getDateTimeInstance(3, 3, TimeZone.getDefault(), Locale.getDefault());
    }

    public F getInstance(String str, TimeZone timeZone, Locale locale) {
        Validate.notNull(str, "pattern", new Object[0]);
        if (timeZone == null) {
            timeZone = TimeZone.getDefault();
        }
        Locale locale2 = LocaleUtils.toLocale(locale);
        ArrayKey arrayKey = new ArrayKey(str, timeZone, locale2);
        F f = this.cInstanceCache.get(arrayKey);
        if (f != null) {
            return f;
        }
        F createInstance = createInstance(str, timeZone, locale2);
        F putIfAbsent = this.cInstanceCache.putIfAbsent(arrayKey, createInstance);
        return putIfAbsent != null ? putIfAbsent : createInstance;
    }

    private F getDateTimeInstance(Integer num, Integer num2, TimeZone timeZone, Locale locale) {
        Locale locale2 = LocaleUtils.toLocale(locale);
        return getInstance(getPatternForStyle(num, num2, locale2), timeZone, locale2);
    }

    F getDateTimeInstance(int i, int i2, TimeZone timeZone, Locale locale) {
        return getDateTimeInstance(Integer.valueOf(i), Integer.valueOf(i2), timeZone, locale);
    }

    F getDateInstance(int i, TimeZone timeZone, Locale locale) {
        return getDateTimeInstance(Integer.valueOf(i), (Integer) null, timeZone, locale);
    }

    F getTimeInstance(int i, TimeZone timeZone, Locale locale) {
        return getDateTimeInstance((Integer) null, Integer.valueOf(i), timeZone, locale);
    }

    static String getPatternForStyle(Integer num, Integer num2, Locale locale) {
        DateFormat dateTimeInstance;
        Locale locale2 = LocaleUtils.toLocale(locale);
        ArrayKey arrayKey = new ArrayKey(num, num2, locale2);
        ConcurrentMap<ArrayKey, String> concurrentMap = cDateTimeInstanceCache;
        String str = concurrentMap.get(arrayKey);
        if (str != null) {
            return str;
        }
        try {
            if (num == null) {
                dateTimeInstance = DateFormat.getTimeInstance(num2.intValue(), locale2);
            } else if (num2 == null) {
                dateTimeInstance = DateFormat.getDateInstance(num.intValue(), locale2);
            } else {
                dateTimeInstance = DateFormat.getDateTimeInstance(num.intValue(), num2.intValue(), locale2);
            }
            String pattern = ((SimpleDateFormat) dateTimeInstance).toPattern();
            String putIfAbsent = concurrentMap.putIfAbsent(arrayKey, pattern);
            return putIfAbsent != null ? putIfAbsent : pattern;
        } catch (ClassCastException unused) {
            throw new IllegalArgumentException("No date time pattern for locale: " + locale2);
        }
    }

    private static final class ArrayKey {
        private final int hashCode;
        private final Object[] keys;

        private static int computeHashCode(Object[] objArr) {
            return 31 + Arrays.hashCode(objArr);
        }

        ArrayKey(Object... objArr) {
            this.keys = objArr;
            this.hashCode = computeHashCode(objArr);
        }

        public int hashCode() {
            return this.hashCode;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && getClass() == obj.getClass()) {
                return Arrays.deepEquals(this.keys, ((ArrayKey) obj).keys);
            }
            return false;
        }
    }
}
