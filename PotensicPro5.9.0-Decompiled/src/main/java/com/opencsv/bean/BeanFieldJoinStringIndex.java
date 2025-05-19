package com.opencsv.bean;

import java.lang.reflect.Field;
import java.util.Locale;
import org.apache.commons.collections4.MultiValuedMap;

/* loaded from: classes3.dex */
public class BeanFieldJoinStringIndex<T> extends BeanFieldJoin<T, String> {
    public BeanFieldJoinStringIndex(Class<?> cls, Field field, boolean z, Locale locale, CsvConverter csvConverter, Class<? extends MultiValuedMap> cls2, String str, String str2) {
        super(cls, field, z, locale, csvConverter, cls2, str, str2);
    }

    @Override // com.opencsv.bean.BeanFieldJoin
    protected Object putNewValue(MultiValuedMap<String, Object> multiValuedMap, String str, Object obj) {
        return Boolean.valueOf(multiValuedMap.put(str, obj));
    }
}
