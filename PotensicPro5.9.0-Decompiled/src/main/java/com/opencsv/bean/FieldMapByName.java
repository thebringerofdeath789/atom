package com.opencsv.bean;

import com.opencsv.ICSVParser;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import defpackage.C$r8$backportedMethods$utility$String$2$joinIterable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.apache.commons.collections4.MultiValuedMap;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes3.dex */
public class FieldMapByName<T> extends AbstractFieldMap<String, String, RegexToBeanField<T>, T> {
    private Comparator<String> writeOrder;

    public static /* synthetic */ LinkedList lambda$3kEwb89y_3mqdjFd9lZCoRLWtdA() {
        return new LinkedList();
    }

    public FieldMapByName(Locale locale) {
        super(locale);
        this.writeOrder = null;
    }

    @Override // com.opencsv.bean.FieldMap
    public void putComplex(String str, BeanField<T, String> beanField) {
        this.complexMapList.add(new RegexToBeanField(str, beanField, this.errorLocale));
    }

    public List<FieldMapByNameEntry<T>> determineMissingRequiredHeaders(String[] strArr) {
        List<String> list = (List) this.simpleMap.entrySet().stream().filter(new Predicate() { // from class: com.opencsv.bean.-$$Lambda$FieldMapByName$4lylHzY0kwJsqDIRXHrOV87K4b4
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                boolean isRequired;
                isRequired = ((BeanField) ((Map.Entry) obj).getValue()).isRequired();
                return isRequired;
            }
        }).map($$Lambda$kD2gyJeP3PcrLMDu6_8bXivD2ts.INSTANCE).collect(Collectors.toCollection(new Supplier() { // from class: com.opencsv.bean.-$$Lambda$FieldMapByName$3kEwb89y_3mqdjFd9lZCoRLWtdA
            @Override // java.util.function.Supplier
            public final Object get() {
                return FieldMapByName.lambda$3kEwb89y_3mqdjFd9lZCoRLWtdA();
            }
        }));
        List<ComplexFieldMapEntry> list2 = (List) this.complexMapList.stream().filter(new Predicate() { // from class: com.opencsv.bean.-$$Lambda$FieldMapByName$111VR5w3Gdocego9nYRXuRYdVvU
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                boolean isRequired;
                isRequired = ((RegexToBeanField) obj).getBeanField().isRequired();
                return isRequired;
            }
        }).collect(Collectors.toList());
        for (String str : strArr) {
            if (!list.remove(str.toUpperCase())) {
                ListIterator listIterator = list2.listIterator();
                boolean z = false;
                while (!z && listIterator.hasNext()) {
                    if (((ComplexFieldMapEntry) listIterator.next()).contains(str)) {
                        listIterator.remove();
                        z = true;
                    }
                }
            }
        }
        LinkedList linkedList = new LinkedList();
        for (String str2 : list) {
            linkedList.add(new FieldMapByNameEntry(str2, (BeanField) this.simpleMap.get(str2), false));
        }
        for (ComplexFieldMapEntry complexFieldMapEntry : list2) {
            linkedList.add(new FieldMapByNameEntry((String) complexFieldMapEntry.getInitializer(), complexFieldMapEntry.getBeanField(), true));
        }
        return linkedList;
    }

    @Override // com.opencsv.bean.FieldMap
    public String[] generateHeader(T t) throws CsvRequiredFieldEmptyException {
        LinkedList linkedList = new LinkedList();
        ArrayList arrayList = new ArrayList(this.simpleMap.keySet());
        for (final C c : this.complexMapList) {
            MultiValuedMap multiValuedMap = (MultiValuedMap) c.getBeanField().getFieldValue(t);
            if (multiValuedMap != null && !multiValuedMap.isEmpty()) {
                Stream map = multiValuedMap.entries().stream().map($$Lambda$kD2gyJeP3PcrLMDu6_8bXivD2ts.INSTANCE);
                c.getClass();
                arrayList.addAll((Collection) map.filter(new Predicate() { // from class: com.opencsv.bean.-$$Lambda$y2vcGfnKbscZ9nR_Z0ydUlhH51U
                    @Override // java.util.function.Predicate
                    public final boolean test(Object obj) {
                        return ComplexFieldMapEntry.this.contains((String) obj);
                    }
                }).collect(Collectors.toList()));
            } else if (c.getBeanField().isRequired()) {
                linkedList.add(c.getBeanField().getField());
            }
        }
        if (!linkedList.isEmpty()) {
            throw new CsvRequiredFieldEmptyException(t.getClass(), linkedList, String.format(ResourceBundle.getBundle(ICSVParser.DEFAULT_BUNDLE_NAME, this.errorLocale).getString("header.required.field.absent"), linkedList.stream().map(new Function() { // from class: com.opencsv.bean.-$$Lambda$FieldMapByName$MuwDFrbA3G-IcKVjEbH-HfGjxvU
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    String name;
                    name = ((Field) obj).getName();
                    return name;
                }
            }).collect(Collectors.joining(StringUtils.SPACE)), C$r8$backportedMethods$utility$String$2$joinIterable.join(StringUtils.SPACE, arrayList)));
        }
        arrayList.sort(this.writeOrder);
        return (String[]) arrayList.toArray(ArrayUtils.EMPTY_STRING_ARRAY);
    }

    public void setColumnOrderOnWrite(Comparator<String> comparator) {
        this.writeOrder = comparator;
    }
}
