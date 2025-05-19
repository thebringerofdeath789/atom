package com.opencsv.bean;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import org.apache.commons.collections4.ListValuedMap;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes3.dex */
public class HeaderColumnNameMappingStrategy<T> extends HeaderNameBaseMappingStrategy<T> {
    public HeaderColumnNameMappingStrategy() {
    }

    public HeaderColumnNameMappingStrategy(boolean z) {
        super(z);
    }

    private void registerCustomBinding(CsvCustomBindByName csvCustomBindByName, Class<?> cls, Field field) {
        String trim = csvCustomBindByName.column().toUpperCase().trim();
        if (StringUtils.isEmpty(trim)) {
            trim = field.getName().toUpperCase();
        }
        BeanField<T, String> instantiateCustomConverter = instantiateCustomConverter(csvCustomBindByName.converter());
        instantiateCustomConverter.setType(cls);
        instantiateCustomConverter.setField(field);
        instantiateCustomConverter.setRequired(csvCustomBindByName.required());
        this.fieldMap.put(trim, instantiateCustomConverter);
    }

    private void registerSplitBinding(CsvBindAndSplitByName csvBindAndSplitByName, Class<?> cls, Field field) {
        String trim = csvBindAndSplitByName.column().toUpperCase().trim();
        String locale = csvBindAndSplitByName.locale();
        String writeLocale = csvBindAndSplitByName.writeLocaleEqualsReadLocale() ? locale : csvBindAndSplitByName.writeLocale();
        Class<?> elementType = csvBindAndSplitByName.elementType();
        CsvConverter determineConverter = determineConverter(field, elementType, locale, writeLocale, csvBindAndSplitByName.converter());
        if (StringUtils.isEmpty(trim)) {
            this.fieldMap.put(field.getName().toUpperCase(), new BeanFieldSplit(cls, field, csvBindAndSplitByName.required(), this.errorLocale, determineConverter, csvBindAndSplitByName.splitOn(), csvBindAndSplitByName.writeDelimiter(), csvBindAndSplitByName.collectionType(), elementType, csvBindAndSplitByName.capture(), csvBindAndSplitByName.format()));
        } else {
            this.fieldMap.put(trim, new BeanFieldSplit(cls, field, csvBindAndSplitByName.required(), this.errorLocale, determineConverter, csvBindAndSplitByName.splitOn(), csvBindAndSplitByName.writeDelimiter(), csvBindAndSplitByName.collectionType(), elementType, csvBindAndSplitByName.capture(), csvBindAndSplitByName.format()));
        }
    }

    private void registerJoinBinding(CsvBindAndJoinByName csvBindAndJoinByName, Class<?> cls, Field field) {
        String column = csvBindAndJoinByName.column();
        String locale = csvBindAndJoinByName.locale();
        CsvConverter determineConverter = determineConverter(field, csvBindAndJoinByName.elementType(), locale, csvBindAndJoinByName.writeLocaleEqualsReadLocale() ? locale : csvBindAndJoinByName.writeLocale(), csvBindAndJoinByName.converter());
        if (StringUtils.isEmpty(column)) {
            this.fieldMap.putComplex(field.getName(), (BeanField) new BeanFieldJoinStringIndex(cls, field, csvBindAndJoinByName.required(), this.errorLocale, determineConverter, csvBindAndJoinByName.mapType(), csvBindAndJoinByName.capture(), csvBindAndJoinByName.format()));
        } else {
            this.fieldMap.putComplex(column, (BeanField) new BeanFieldJoinStringIndex(cls, field, csvBindAndJoinByName.required(), this.errorLocale, determineConverter, csvBindAndJoinByName.mapType(), csvBindAndJoinByName.capture(), csvBindAndJoinByName.format()));
        }
    }

    private void registerBinding(CsvBindByName csvBindByName, Class<?> cls, Field field) {
        String trim = csvBindByName.column().toUpperCase().trim();
        String locale = csvBindByName.locale();
        CsvConverter determineConverter = determineConverter(field, field.getType(), locale, csvBindByName.writeLocaleEqualsReadLocale() ? locale : csvBindByName.writeLocale(), null);
        if (StringUtils.isEmpty(trim)) {
            this.fieldMap.put(field.getName().toUpperCase(), new BeanFieldSingleValue(cls, field, csvBindByName.required(), this.errorLocale, determineConverter, csvBindByName.capture(), csvBindByName.format()));
        } else {
            this.fieldMap.put(trim, new BeanFieldSingleValue(cls, field, csvBindByName.required(), this.errorLocale, determineConverter, csvBindByName.capture(), csvBindByName.format()));
        }
    }

    @Override // com.opencsv.bean.AbstractMappingStrategy
    protected void loadAnnotatedFieldMap(ListValuedMap<Class<?>, Field> listValuedMap) {
        for (Map.Entry<Class<?>, Field> entry : listValuedMap.entries()) {
            Class<?> key = entry.getKey();
            Field value = entry.getValue();
            if (value.isAnnotationPresent(CsvCustomBindByName.class) || value.isAnnotationPresent(CsvCustomBindByNames.class)) {
                CsvCustomBindByName csvCustomBindByName = (CsvCustomBindByName) selectAnnotationForProfile(value.getAnnotationsByType(CsvCustomBindByName.class), new Function() { // from class: com.opencsv.bean.-$$Lambda$VfHqYxnlKVZOtAylp5wBdpLEBD4
                    @Override // java.util.function.Function
                    public final Object apply(Object obj) {
                        return ((CsvCustomBindByName) obj).profiles();
                    }
                });
                if (csvCustomBindByName != null) {
                    registerCustomBinding(csvCustomBindByName, key, value);
                }
            } else if (value.isAnnotationPresent(CsvBindAndSplitByName.class) || value.isAnnotationPresent(CsvBindAndSplitByNames.class)) {
                CsvBindAndSplitByName csvBindAndSplitByName = (CsvBindAndSplitByName) selectAnnotationForProfile(value.getAnnotationsByType(CsvBindAndSplitByName.class), new Function() { // from class: com.opencsv.bean.-$$Lambda$cTKbfGGlzX9xDa1AFUuAVD6SvWY
                    @Override // java.util.function.Function
                    public final Object apply(Object obj) {
                        return ((CsvBindAndSplitByName) obj).profiles();
                    }
                });
                if (csvBindAndSplitByName != null) {
                    registerSplitBinding(csvBindAndSplitByName, key, value);
                }
            } else if (value.isAnnotationPresent(CsvBindAndJoinByName.class) || value.isAnnotationPresent(CsvBindAndJoinByNames.class)) {
                CsvBindAndJoinByName csvBindAndJoinByName = (CsvBindAndJoinByName) selectAnnotationForProfile(value.getAnnotationsByType(CsvBindAndJoinByName.class), new Function() { // from class: com.opencsv.bean.-$$Lambda$TEnbfRA4DuvVkGiTZ4J-CAT1iFM
                    @Override // java.util.function.Function
                    public final Object apply(Object obj) {
                        return ((CsvBindAndJoinByName) obj).profiles();
                    }
                });
                if (csvBindAndJoinByName != null) {
                    registerJoinBinding(csvBindAndJoinByName, key, value);
                }
            } else {
                CsvBindByName csvBindByName = (CsvBindByName) selectAnnotationForProfile(value.getAnnotationsByType(CsvBindByName.class), new Function() { // from class: com.opencsv.bean.-$$Lambda$UAShLeivXsM281qrbbIwlJyH7oc
                    @Override // java.util.function.Function
                    public final Object apply(Object obj) {
                        return ((CsvBindByName) obj).profiles();
                    }
                });
                if (csvBindByName != null) {
                    registerBinding(csvBindByName, key, value);
                }
            }
        }
    }

    @Override // com.opencsv.bean.AbstractMappingStrategy
    protected Set<Class<? extends Annotation>> getBindingAnnotations() {
        return new HashSet(Arrays.asList(CsvBindByNames.class, CsvCustomBindByNames.class, CsvBindAndSplitByNames.class, CsvBindAndJoinByNames.class, CsvBindByName.class, CsvCustomBindByName.class, CsvBindAndSplitByName.class, CsvBindAndJoinByName.class));
    }
}
