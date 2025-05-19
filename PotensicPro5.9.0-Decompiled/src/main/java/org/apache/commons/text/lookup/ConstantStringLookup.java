package org.apache.commons.text.lookup;

import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.commons.lang3.ClassUtils;

/* loaded from: classes4.dex */
class ConstantStringLookup extends AbstractStringLookup {
    private static final char FIELD_SEPARATOR = '.';
    private static final ConcurrentHashMap<String, String> CONSTANT_CACHE = new ConcurrentHashMap<>();
    static final ConstantStringLookup INSTANCE = new ConstantStringLookup();

    ConstantStringLookup() {
    }

    static void clear() {
        CONSTANT_CACHE.clear();
    }

    protected Class<?> fetchClass(String str) throws ClassNotFoundException {
        return ClassUtils.getClass(str);
    }

    @Override // org.apache.commons.text.lookup.StringLookup
    public synchronized String lookup(String str) {
        if (str == null) {
            return null;
        }
        ConcurrentHashMap<String, String> concurrentHashMap = CONSTANT_CACHE;
        String str2 = concurrentHashMap.get(str);
        if (str2 != null) {
            return str2;
        }
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf < 0) {
            return null;
        }
        try {
            Object resolveField = resolveField(str.substring(0, lastIndexOf), str.substring(lastIndexOf + 1));
            if (resolveField != null) {
                str2 = Objects.toString(resolveField, null);
                concurrentHashMap.put(str, str2);
            }
            return str2;
        } catch (Exception unused) {
            return null;
        }
    }

    protected Object resolveField(String str, String str2) throws Exception {
        Class<?> fetchClass = fetchClass(str);
        if (fetchClass == null) {
            return null;
        }
        return fetchClass.getField(str2).get(null);
    }
}
