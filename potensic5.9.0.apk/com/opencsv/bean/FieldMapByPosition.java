package com.opencsv.bean;

import com.opencsv.ICSVParser;
import com.opencsv.bean.FieldMapByPosition;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import java.lang.reflect.Field;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.apache.commons.collections4.MultiValuedMap;
import org.apache.commons.collections4.Transformer;
import org.apache.commons.collections4.iterators.LazyIteratorChain;
import org.apache.commons.collections4.iterators.TransformIterator;
import org.apache.commons.lang3.StringUtils;
import p000.C$r8$backportedMethods$utility$String$2$joinArray;

/* loaded from: classes3.dex */
public class FieldMapByPosition<T> extends AbstractFieldMap<String, Integer, PositionToBeanField<T>, T> implements Iterable<FieldMapByPositionEntry<T>> {
    private int maxIndex;
    private Comparator<Integer> writeOrder;

    public FieldMapByPosition(Locale locale) {
        super(locale);
        this.maxIndex = Integer.MAX_VALUE;
        this.writeOrder = null;
    }

    @Override // com.opencsv.bean.FieldMap
    public String[] generateHeader(T t) throws CsvRequiredFieldEmptyException {
        LinkedList linkedList = new LinkedList();
        TreeMap treeMap = new TreeMap(this.writeOrder);
        for (Map.Entry entry : this.simpleMap.entrySet()) {
            treeMap.put(entry.getKey(), ((BeanField) entry.getValue()).getField().getName());
        }
        Iterator it = this.complexMapList.iterator();
        while (true) {
            boolean z = false;
            if (!it.hasNext()) {
                break;
            }
            ComplexFieldMapEntry complexFieldMapEntry = (ComplexFieldMapEntry) it.next();
            MultiValuedMap multiValuedMap = (MultiValuedMap) complexFieldMapEntry.getBeanField().getFieldValue(t);
            if (multiValuedMap != null && !multiValuedMap.isEmpty()) {
                for (Map.Entry entry2 : multiValuedMap.entries()) {
                    if (complexFieldMapEntry.contains((Integer) entry2.getKey())) {
                        treeMap.put(entry2.getKey(), complexFieldMapEntry.getBeanField().getField().getName());
                        z = true;
                    }
                }
            }
            if (multiValuedMap == null || multiValuedMap.isEmpty() || !z) {
                if (complexFieldMapEntry.getBeanField().isRequired()) {
                    linkedList.add(complexFieldMapEntry.getBeanField().getField());
                }
            }
        }
        TreeSet<Integer> treeSet = new TreeSet(treeMap.keySet());
        String[] strArr = new String[treeSet.isEmpty() ? 0 : ((Integer) treeSet.last()).intValue() + 1];
        int intValue = treeSet.isEmpty() ? 0 : ((Integer) treeSet.first()).intValue();
        for (Integer num : treeSet) {
            for (int i = intValue + 1; i < num.intValue(); i++) {
                treeMap.put(Integer.valueOf(i), null);
            }
            intValue = num.intValue();
        }
        Iterator it2 = treeMap.values().iterator();
        int i2 = 0;
        while (it2.hasNext()) {
            strArr[i2] = (String) it2.next();
            i2++;
        }
        if (linkedList.isEmpty()) {
            return strArr;
        }
        throw new CsvRequiredFieldEmptyException(t.getClass(), linkedList, String.format(ResourceBundle.getBundle(ICSVParser.DEFAULT_BUNDLE_NAME, this.errorLocale).getString("header.required.field.absent"), linkedList.stream().map(new Function() { // from class: com.opencsv.bean.-$$Lambda$FieldMapByPosition$MuwDFrbA3G-IcKVjEbH-HfGjxvU
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                String name;
                name = ((Field) obj).getName();
                return name;
            }
        }).collect(Collectors.joining(StringUtils.SPACE)), C$r8$backportedMethods$utility$String$2$joinArray.join(StringUtils.SPACE, strArr)));
    }

    @Override // com.opencsv.bean.FieldMap
    public void putComplex(String str, BeanField<T, Integer> beanField) {
        this.complexMapList.add(new PositionToBeanField(str, this.maxIndex, beanField, this.errorLocale));
    }

    public void setMaxIndex(final int i) {
        this.maxIndex = i;
        this.complexMapList.forEach(new Consumer() { // from class: com.opencsv.bean.-$$Lambda$FieldMapByPosition$y7TqwmoyUk8VnWJ_KNTQWvD7BvE
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                ((PositionToBeanField) obj).attenuateRanges(i);
            }
        });
    }

    /* renamed from: com.opencsv.bean.FieldMapByPosition$1 */
    class C32961 extends LazyIteratorChain<FieldMapByPositionEntry<T>> {
        C32961() {
        }

        @Override // org.apache.commons.collections4.iterators.LazyIteratorChain
        protected Iterator<FieldMapByPositionEntry<T>> nextIterator(int i) {
            if (i <= FieldMapByPosition.this.complexMapList.size()) {
                return ((PositionToBeanField) FieldMapByPosition.this.complexMapList.get(i - 1)).iterator();
            }
            if (i == FieldMapByPosition.this.complexMapList.size() + 1) {
                return new TransformIterator(FieldMapByPosition.this.simpleMap.entrySet().iterator(), new Transformer() { // from class: com.opencsv.bean.-$$Lambda$FieldMapByPosition$1$6JzCRCaDCelHCNHI1qyyoOZu9UA
                    @Override // org.apache.commons.collections4.Transformer
                    public final Object transform(Object obj) {
                        return FieldMapByPosition.C32961.lambda$nextIterator$0((Map.Entry) obj);
                    }
                });
            }
            return null;
        }

        static /* synthetic */ FieldMapByPositionEntry lambda$nextIterator$0(Map.Entry entry) {
            return new FieldMapByPositionEntry(((Integer) entry.getKey()).intValue(), (BeanField) entry.getValue());
        }
    }

    @Override // java.lang.Iterable
    public Iterator<FieldMapByPositionEntry<T>> iterator() {
        return new C32961();
    }

    public void setColumnOrderOnWrite(Comparator<Integer> comparator) {
        this.writeOrder = comparator;
    }
}