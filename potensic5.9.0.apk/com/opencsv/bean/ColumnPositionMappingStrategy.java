package com.opencsv.bean;

import com.opencsv.CSVReader;
import com.opencsv.ICSVParser;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.function.Function;
import java.util.function.IntFunction;
import org.apache.commons.collections4.ListValuedMap;
import org.apache.commons.lang3.ArrayUtils;

/* loaded from: classes3.dex */
public class ColumnPositionMappingStrategy<T> extends AbstractMappingStrategy<String, Integer, ComplexFieldMapEntry<String, Integer, T>, T> {
    private FieldMapByPosition<T> fieldMap;
    private Comparator<Integer> writeOrder;
    private boolean columnsExplicitlySet = false;
    private Integer[] columnIndexForWriting = null;

    @Override // com.opencsv.bean.MappingStrategy
    public void captureHeader(CSVReader cSVReader) throws IOException {
        if (this.type == null) {
            throw new IllegalStateException(ResourceBundle.getBundle(ICSVParser.DEFAULT_BUNDLE_NAME, this.errorLocale).getString("type.unset"));
        }
        this.fieldMap.setMaxIndex(ArrayUtils.nullToEmpty(cSVReader.peek()).length - 1);
        if (this.columnsExplicitlySet) {
            return;
        }
        this.headerIndex.clear();
        Iterator<FieldMapByPositionEntry<T>> it = this.fieldMap.iterator();
        while (it.hasNext()) {
            FieldMapByPositionEntry<T> next = it.next();
            Field field = next.getField().getField();
            if (field.getAnnotation(CsvCustomBindByPosition.class) != null || field.getAnnotation(CsvBindAndSplitByPosition.class) != null || field.getAnnotation(CsvBindAndJoinByPosition.class) != null || field.getAnnotation(CsvBindByPosition.class) != null) {
                this.headerIndex.put(next.getPosition(), field.getName().toUpperCase().trim());
            }
        }
    }

    @Override // com.opencsv.bean.AbstractMappingStrategy
    protected Integer chooseMultivaluedFieldIndexFromHeaderIndex(int i) {
        return Integer.valueOf(i);
    }

    @Override // com.opencsv.bean.AbstractMappingStrategy
    protected BeanField<T, Integer> findField(int i) {
        Integer[] numArr = this.columnIndexForWriting;
        if (numArr != null) {
            if (i < numArr.length) {
                return this.fieldMap.get(numArr[i]);
            }
            return null;
        }
        return this.fieldMap.get(Integer.valueOf(i));
    }

    @Override // com.opencsv.bean.AbstractMappingStrategy, com.opencsv.bean.MappingStrategy
    public String[] generateHeader(T t) throws CsvRequiredFieldEmptyException {
        Integer[] numArr = new Integer[super.generateHeader(t).length];
        this.columnIndexForWriting = numArr;
        Arrays.setAll(numArr, new IntFunction() { // from class: com.opencsv.bean.-$$Lambda$ColumnPositionMappingStrategy$9-ITz5HMN-Kqu3U2lJWfs03O0Fw
            @Override // java.util.function.IntFunction
            public final Object apply(int i) {
                Integer valueOf;
                valueOf = Integer.valueOf(i);
                return valueOf;
            }
        });
        Arrays.sort(this.columnIndexForWriting, this.writeOrder);
        return ArrayUtils.EMPTY_STRING_ARRAY;
    }

    @Override // com.opencsv.bean.AbstractMappingStrategy
    public String getColumnName(int i) {
        return this.headerIndex.getByPosition(i);
    }

    public String[] getColumnMapping() {
        return this.headerIndex.getHeaderIndex();
    }

    public void setColumnMapping(String... strArr) {
        if (strArr != null) {
            this.headerIndex.initializeHeaderIndex(strArr);
        } else {
            this.headerIndex.clear();
        }
        this.columnsExplicitlySet = true;
        if (getType() != null) {
            loadFieldMap();
        }
    }

    private void registerCustomBinding(CsvCustomBindByPosition csvCustomBindByPosition, Class<?> cls, Field field) {
        BeanField<T, Integer> instantiateCustomConverter = instantiateCustomConverter(csvCustomBindByPosition.converter());
        instantiateCustomConverter.setType(cls);
        instantiateCustomConverter.setField(field);
        instantiateCustomConverter.setRequired(csvCustomBindByPosition.required());
        this.fieldMap.put(Integer.valueOf(csvCustomBindByPosition.position()), instantiateCustomConverter);
    }

    private void registerSplitBinding(CsvBindAndSplitByPosition csvBindAndSplitByPosition, Class<?> cls, Field field) {
        String locale = csvBindAndSplitByPosition.locale();
        String writeLocale = csvBindAndSplitByPosition.writeLocaleEqualsReadLocale() ? locale : csvBindAndSplitByPosition.writeLocale();
        Class<?> elementType = csvBindAndSplitByPosition.elementType();
        this.fieldMap.put(Integer.valueOf(csvBindAndSplitByPosition.position()), new BeanFieldSplit(cls, field, csvBindAndSplitByPosition.required(), this.errorLocale, determineConverter(field, elementType, locale, writeLocale, csvBindAndSplitByPosition.converter()), csvBindAndSplitByPosition.splitOn(), csvBindAndSplitByPosition.writeDelimiter(), csvBindAndSplitByPosition.collectionType(), elementType, csvBindAndSplitByPosition.capture(), csvBindAndSplitByPosition.format()));
    }

    private void registerJoinBinding(CsvBindAndJoinByPosition csvBindAndJoinByPosition, Class<?> cls, Field field) {
        String locale = csvBindAndJoinByPosition.locale();
        this.fieldMap.putComplex(csvBindAndJoinByPosition.position(), (BeanField) new BeanFieldJoinIntegerIndex(cls, field, csvBindAndJoinByPosition.required(), this.errorLocale, determineConverter(field, csvBindAndJoinByPosition.elementType(), locale, csvBindAndJoinByPosition.writeLocaleEqualsReadLocale() ? locale : csvBindAndJoinByPosition.writeLocale(), csvBindAndJoinByPosition.converter()), csvBindAndJoinByPosition.mapType(), csvBindAndJoinByPosition.capture(), csvBindAndJoinByPosition.format()));
    }

    private void registerBinding(CsvBindByPosition csvBindByPosition, Class<?> cls, Field field) {
        String locale = csvBindByPosition.locale();
        this.fieldMap.put(Integer.valueOf(csvBindByPosition.position()), new BeanFieldSingleValue(cls, field, csvBindByPosition.required(), this.errorLocale, determineConverter(field, field.getType(), locale, csvBindByPosition.writeLocaleEqualsReadLocale() ? locale : csvBindByPosition.writeLocale(), null), csvBindByPosition.capture(), csvBindByPosition.format()));
    }

    @Override // com.opencsv.bean.AbstractMappingStrategy
    protected void loadAnnotatedFieldMap(ListValuedMap<Class<?>, Field> listValuedMap) {
        for (Map.Entry<Class<?>, Field> entry : listValuedMap.entries()) {
            Class<?> key = entry.getKey();
            Field value = entry.getValue();
            if (value.isAnnotationPresent(CsvCustomBindByPosition.class) || value.isAnnotationPresent(CsvCustomBindByPositions.class)) {
                CsvCustomBindByPosition csvCustomBindByPosition = (CsvCustomBindByPosition) selectAnnotationForProfile(value.getAnnotationsByType(CsvCustomBindByPosition.class), new Function() { // from class: com.opencsv.bean.-$$Lambda$GULE8rDII_NjDDBL4CVk6s_u0h4
                    @Override // java.util.function.Function
                    public final Object apply(Object obj) {
                        return ((CsvCustomBindByPosition) obj).profiles();
                    }
                });
                if (csvCustomBindByPosition != null) {
                    registerCustomBinding(csvCustomBindByPosition, key, value);
                }
            } else if (value.isAnnotationPresent(CsvBindAndSplitByPosition.class) || value.isAnnotationPresent(CsvBindAndSplitByPositions.class)) {
                CsvBindAndSplitByPosition csvBindAndSplitByPosition = (CsvBindAndSplitByPosition) selectAnnotationForProfile(value.getAnnotationsByType(CsvBindAndSplitByPosition.class), new Function() { // from class: com.opencsv.bean.-$$Lambda$-bfHASrAbKObkOVPMOv7BQ6WXIA
                    @Override // java.util.function.Function
                    public final Object apply(Object obj) {
                        return ((CsvBindAndSplitByPosition) obj).profiles();
                    }
                });
                if (csvBindAndSplitByPosition != null) {
                    registerSplitBinding(csvBindAndSplitByPosition, key, value);
                }
            } else if (value.isAnnotationPresent(CsvBindAndJoinByPosition.class) || value.isAnnotationPresent(CsvBindAndJoinByPositions.class)) {
                CsvBindAndJoinByPosition csvBindAndJoinByPosition = (CsvBindAndJoinByPosition) selectAnnotationForProfile(value.getAnnotationsByType(CsvBindAndJoinByPosition.class), new Function() { // from class: com.opencsv.bean.-$$Lambda$3NsPIoN0XySMA0CyK3GbWldA5oA
                    @Override // java.util.function.Function
                    public final Object apply(Object obj) {
                        return ((CsvBindAndJoinByPosition) obj).profiles();
                    }
                });
                if (csvBindAndJoinByPosition != null) {
                    registerJoinBinding(csvBindAndJoinByPosition, key, value);
                }
            } else {
                CsvBindByPosition csvBindByPosition = (CsvBindByPosition) selectAnnotationForProfile(value.getAnnotationsByType(CsvBindByPosition.class), new Function() { // from class: com.opencsv.bean.-$$Lambda$E45RwR5gL5ixZ2Jp9k2-puynRXc
                    @Override // java.util.function.Function
                    public final Object apply(Object obj) {
                        return ((CsvBindByPosition) obj).profiles();
                    }
                });
                if (csvBindByPosition != null) {
                    registerBinding(csvBindByPosition, key, value);
                }
            }
        }
    }

    @Override // com.opencsv.bean.AbstractMappingStrategy
    protected void loadUnadornedFieldMap(ListValuedMap<Class<?>, Field> listValuedMap) {
        for (Map.Entry<Class<?>, Field> entry : listValuedMap.entries()) {
            Class<?> key = entry.getKey();
            Field value = entry.getValue();
            CsvConverter determineConverter = determineConverter(value, value.getType(), null, null, null);
            int[] byName = this.headerIndex.getByName(value.getName());
            if (byName.length != 0) {
                this.fieldMap.put(Integer.valueOf(byName[0]), new BeanFieldSingleValue(key, value, false, this.errorLocale, determineConverter, null, null));
            }
        }
    }

    @Override // com.opencsv.bean.AbstractMappingStrategy
    protected Set<Class<? extends Annotation>> getBindingAnnotations() {
        return new HashSet(Arrays.asList(CsvBindByPositions.class, CsvCustomBindByPositions.class, CsvBindAndJoinByPositions.class, CsvBindAndSplitByPositions.class, CsvBindByPosition.class, CsvCustomBindByPosition.class, CsvBindAndJoinByPosition.class, CsvBindAndSplitByPosition.class));
    }

    @Override // com.opencsv.bean.AbstractMappingStrategy
    protected void initializeFieldMap() {
        FieldMapByPosition<T> fieldMapByPosition = new FieldMapByPosition<>(this.errorLocale);
        this.fieldMap = fieldMapByPosition;
        fieldMapByPosition.setColumnOrderOnWrite(this.writeOrder);
    }

    @Override // com.opencsv.bean.AbstractMappingStrategy
    protected void verifyLineLength(int i) throws CsvRequiredFieldEmptyException {
        if (this.headerIndex.isEmpty()) {
            return;
        }
        StringBuilder sb = null;
        while (i <= this.headerIndex.findMaxIndex()) {
            BeanField<T, Integer> findField = findField(i);
            if (findField != null && findField.isRequired()) {
                if (sb == null) {
                    sb = new StringBuilder(ResourceBundle.getBundle(ICSVParser.DEFAULT_BUNDLE_NAME, this.errorLocale).getString("multiple.required.field.empty"));
                }
                sb.append(' ');
                sb.append(findField.getField().getName());
            }
            i++;
        }
        if (sb != null) {
            throw new CsvRequiredFieldEmptyException(this.type, sb.toString());
        }
    }

    @Override // com.opencsv.bean.AbstractMappingStrategy
    public String findHeader(int i) {
        return Integer.toString(i);
    }

    @Override // com.opencsv.bean.AbstractMappingStrategy
    protected FieldMap<String, Integer, ? extends ComplexFieldMapEntry<String, Integer, T>, T> getFieldMap() {
        return this.fieldMap;
    }

    public void setColumnOrderOnWrite(Comparator<Integer> comparator) {
        this.writeOrder = comparator;
        FieldMapByPosition<T> fieldMapByPosition = this.fieldMap;
        if (fieldMapByPosition != null) {
            fieldMapByPosition.setColumnOrderOnWrite(comparator);
        }
    }
}