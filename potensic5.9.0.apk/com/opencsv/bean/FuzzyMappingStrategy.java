package com.opencsv.bean;

import com.opencsv.CSVReader;
import com.opencsv.bean.FuzzyMappingStrategy;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.apache.commons.collections4.ListValuedMap;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.text.similarity.LevenshteinDistance;

/* loaded from: classes3.dex */
public class FuzzyMappingStrategy<T> extends HeaderColumnNameMappingStrategy<T> {
    @Override // com.opencsv.bean.HeaderNameBaseMappingStrategy, com.opencsv.bean.AbstractMappingStrategy
    protected void loadUnadornedFieldMap(ListValuedMap<Class<?>, Field> listValuedMap) {
    }

    public FuzzyMappingStrategy() {
    }

    public FuzzyMappingStrategy(boolean z) {
        super(z);
    }

    @Override // com.opencsv.bean.HeaderNameBaseMappingStrategy, com.opencsv.bean.MappingStrategy
    public void captureHeader(CSVReader cSVReader) throws IOException, CsvRequiredFieldEmptyException {
        super.captureHeader(cSVReader);
        Set set = (Set) Stream.of((Object[]) this.headerIndex.getHeaderIndex()).filter(new Predicate() { // from class: com.opencsv.bean.-$$Lambda$FuzzyMappingStrategy$RUgTMKBFSM5JmQYe-scT_4CThWo
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                boolean nonNull;
                nonNull = Objects.nonNull((String) obj);
                return nonNull;
            }
        }).filter(new Predicate() { // from class: com.opencsv.bean.-$$Lambda$FuzzyMappingStrategy$t8OLr1gDSmrI_ZRiuslBlKI3oqk
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return FuzzyMappingStrategy.this.lambda$captureHeader$0$FuzzyMappingStrategy((String) obj);
            }
        }).collect(Collectors.toSet());
        final ListValuedMap<Class<?>, Field> listValuedMap = partitionFields().get(Boolean.FALSE);
        final LevenshteinDistance defaultInstance = LevenshteinDistance.getDefaultInstance();
        final LinkedList linkedList = new LinkedList();
        set.forEach(new Consumer() { // from class: com.opencsv.bean.-$$Lambda$FuzzyMappingStrategy$jcuYwPOqJey54vCyMbp2uvptVjs
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                ListValuedMap.this.entries().forEach(new Consumer() { // from class: com.opencsv.bean.-$$Lambda$FuzzyMappingStrategy$Eo0IBMkUC_HS27dXkjeZ2Zooh9g
                    @Override // java.util.function.Consumer
                    public final void accept(Object obj2) {
                        r1.add(new FuzzyMappingStrategy.FuzzyComparison(r2.apply((CharSequence) r2.toUpperCase(), (CharSequence) ((Field) r4.getValue()).getName().toUpperCase()), r3, (Class) r4.getKey(), (Field) ((Map.Entry) obj2).getValue()));
                    }
                });
            }
        });
        linkedList.sort(null);
        while (!linkedList.isEmpty()) {
            final FuzzyComparison fuzzyComparison = (FuzzyComparison) linkedList.get(0);
            this.fieldMap.put(fuzzyComparison.header.toUpperCase(), new BeanFieldSingleValue(fuzzyComparison.type, fuzzyComparison.field, false, this.errorLocale, determineConverter(fuzzyComparison.field, fuzzyComparison.field.getType(), null, null, null), null, null));
            linkedList.removeIf(new Predicate() { // from class: com.opencsv.bean.-$$Lambda$FuzzyMappingStrategy$SFxePVSqO5kY7XMkjNNVhERK0W0
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return FuzzyMappingStrategy.lambda$captureHeader$3(FuzzyMappingStrategy.FuzzyComparison.this, (FuzzyMappingStrategy.FuzzyComparison) obj);
                }
            });
        }
    }

    public /* synthetic */ boolean lambda$captureHeader$0$FuzzyMappingStrategy(String str) {
        return this.fieldMap.get(str.toUpperCase()) == null;
    }

    static /* synthetic */ boolean lambda$captureHeader$3(FuzzyComparison fuzzyComparison, FuzzyComparison fuzzyComparison2) {
        return StringUtils.equals(fuzzyComparison2.header, fuzzyComparison.header) || Objects.equals(fuzzyComparison2.field, fuzzyComparison.field);
    }

    private static class FuzzyComparison implements Comparable<FuzzyComparison> {
        final Integer distance;
        final Field field;
        final String header;
        final Class<?> type;

        FuzzyComparison(Integer num, String str, Class<?> cls, Field field) {
            this.distance = num;
            this.header = str;
            this.type = cls;
            this.field = field;
        }

        @Override // java.lang.Comparable
        public int compareTo(FuzzyComparison fuzzyComparison) {
            return Integer.compare(this.distance.intValue(), fuzzyComparison.distance.intValue());
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof FuzzyComparison) {
                return Objects.equals(this.distance, ((FuzzyComparison) obj).distance);
            }
            return false;
        }

        public int hashCode() {
            return Objects.hash(this.distance);
        }
    }
}