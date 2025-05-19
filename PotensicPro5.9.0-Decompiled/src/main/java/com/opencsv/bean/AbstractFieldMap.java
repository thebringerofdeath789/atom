package com.opencsv.bean;

import com.opencsv.bean.ComplexFieldMapEntry;
import java.lang.Comparable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import org.apache.commons.lang3.ObjectUtils;

/* loaded from: classes3.dex */
public abstract class AbstractFieldMap<I, K extends Comparable<K>, C extends ComplexFieldMapEntry<I, K, T>, T> implements FieldMap<I, K, C, T> {
    protected Locale errorLocale;
    protected final SortedMap<K, BeanField<T, K>> simpleMap = new TreeMap();
    protected final List<C> complexMapList = new ArrayList();

    protected AbstractFieldMap(Locale locale) {
        this.errorLocale = (Locale) ObjectUtils.defaultIfNull(locale, Locale.getDefault());
    }

    @Override // com.opencsv.bean.FieldMap
    public BeanField<T, K> get(final K k) {
        BeanField<T, K> beanField = this.simpleMap.get(k);
        return beanField == null ? (BeanField) this.complexMapList.stream().filter(new Predicate() { // from class: com.opencsv.bean.-$$Lambda$AbstractFieldMap$-jHer8GPoVNR7VG1mVaRBuvXCQw
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                boolean contains;
                contains = ((ComplexFieldMapEntry) obj).contains(k);
                return contains;
            }
        }).map(new Function() { // from class: com.opencsv.bean.-$$Lambda$5qkX2PUxoxL15C2iDVTHz7YTbo0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((ComplexFieldMapEntry) obj).getBeanField();
            }
        }).findAny().orElse(null) : beanField;
    }

    @Override // com.opencsv.bean.FieldMap
    public BeanField<T, K> put(K k, BeanField<T, K> beanField) {
        return this.simpleMap.put(k, beanField);
    }

    @Override // com.opencsv.bean.FieldMap
    public Collection<BeanField<T, K>> values() {
        final ArrayList arrayList = new ArrayList(this.simpleMap.size() + this.complexMapList.size());
        arrayList.addAll(this.simpleMap.values());
        this.complexMapList.forEach(new Consumer() { // from class: com.opencsv.bean.-$$Lambda$AbstractFieldMap$Yzo78WCQvY625q_YP3M6tHaLnec
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                arrayList.add(((ComplexFieldMapEntry) obj).getBeanField());
            }
        });
        return arrayList;
    }

    @Override // com.opencsv.bean.FieldMap
    public void setErrorLocale(Locale locale) {
        this.errorLocale = (Locale) ObjectUtils.defaultIfNull(locale, Locale.getDefault());
        this.complexMapList.forEach(new Consumer() { // from class: com.opencsv.bean.-$$Lambda$AbstractFieldMap$4lelIGPUbEW1LUFbIixrK8liDgw
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                AbstractFieldMap.this.lambda$setErrorLocale$2$AbstractFieldMap((ComplexFieldMapEntry) obj);
            }
        });
    }

    public /* synthetic */ void lambda$setErrorLocale$2$AbstractFieldMap(ComplexFieldMapEntry complexFieldMapEntry) {
        complexFieldMapEntry.setErrorLocale(this.errorLocale);
    }
}
