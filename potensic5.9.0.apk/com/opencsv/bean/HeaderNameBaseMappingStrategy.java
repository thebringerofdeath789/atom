package com.opencsv.bean;

import com.opencsv.CSVReader;
import com.opencsv.ICSVParser;
import com.opencsv.exceptions.CsvBadConverterException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.function.Consumer;
import java.util.function.Predicate;
import org.apache.commons.collections4.ListValuedMap;
import org.apache.commons.lang3.ArrayUtils;
import p000.C$r8$backportedMethods$utility$String$2$joinArray;

/* loaded from: classes3.dex */
public abstract class HeaderNameBaseMappingStrategy<T> extends AbstractMappingStrategy<String, String, ComplexFieldMapEntry<String, String, T>, T> {
    protected FieldMapByName<T> fieldMap;
    protected final boolean forceCorrectRecordLength;
    protected Comparator<String> writeOrder;

    public HeaderNameBaseMappingStrategy() {
        this.fieldMap = null;
        this.writeOrder = null;
        this.forceCorrectRecordLength = false;
    }

    public HeaderNameBaseMappingStrategy(boolean z) {
        this.fieldMap = null;
        this.writeOrder = null;
        this.forceCorrectRecordLength = z;
    }

    @Override // com.opencsv.bean.MappingStrategy
    public void captureHeader(CSVReader cSVReader) throws IOException, CsvRequiredFieldEmptyException {
        if (this.type == null) {
            throw new IllegalStateException(ResourceBundle.getBundle(ICSVParser.DEFAULT_BUNDLE_NAME, this.errorLocale).getString("type.unset"));
        }
        String[] nullToEmpty = ArrayUtils.nullToEmpty(cSVReader.readNextSilently());
        for (int i = 0; i < nullToEmpty.length; i++) {
            if (nullToEmpty[i] == null) {
                nullToEmpty[i] = "";
            }
        }
        this.headerIndex.initializeHeaderIndex(nullToEmpty);
        List<FieldMapByNameEntry<T>> determineMissingRequiredHeaders = this.fieldMap.determineMissingRequiredHeaders(nullToEmpty);
        if (determineMissingRequiredHeaders.isEmpty()) {
            return;
        }
        String[] strArr = new String[determineMissingRequiredHeaders.size()];
        ArrayList arrayList = new ArrayList(determineMissingRequiredHeaders.size());
        for (int i2 = 0; i2 < determineMissingRequiredHeaders.size(); i2++) {
            FieldMapByNameEntry<T> fieldMapByNameEntry = determineMissingRequiredHeaders.get(i2);
            if (fieldMapByNameEntry.isRegexPattern()) {
                strArr[i2] = String.format(ResourceBundle.getBundle(ICSVParser.DEFAULT_BUNDLE_NAME, this.errorLocale).getString("matching"), fieldMapByNameEntry.getName());
            } else {
                strArr[i2] = fieldMapByNameEntry.getName();
            }
            arrayList.add(fieldMapByNameEntry.getField().getField());
        }
        CsvRequiredFieldEmptyException csvRequiredFieldEmptyException = new CsvRequiredFieldEmptyException(this.type, arrayList, String.format(ResourceBundle.getBundle(ICSVParser.DEFAULT_BUNDLE_NAME, this.errorLocale).getString("header.required.field.absent"), C$r8$backportedMethods$utility$String$2$joinArray.join(", ", strArr), C$r8$backportedMethods$utility$String$2$joinArray.join(",", nullToEmpty)));
        csvRequiredFieldEmptyException.setLine(nullToEmpty);
        throw csvRequiredFieldEmptyException;
    }

    @Override // com.opencsv.bean.AbstractMappingStrategy
    protected String chooseMultivaluedFieldIndexFromHeaderIndex(int i) {
        String[] headerIndex = this.headerIndex.getHeaderIndex();
        if (i >= headerIndex.length) {
            return null;
        }
        return headerIndex[i];
    }

    @Override // com.opencsv.bean.AbstractMappingStrategy
    public void verifyLineLength(int i) throws CsvRequiredFieldEmptyException {
        if (!this.headerIndex.isEmpty() && i != this.headerIndex.getHeaderIndexLength() && !this.forceCorrectRecordLength) {
            throw new CsvRequiredFieldEmptyException(this.type, ResourceBundle.getBundle(ICSVParser.DEFAULT_BUNDLE_NAME, this.errorLocale).getString("header.data.mismatch"));
        }
    }

    @Override // com.opencsv.bean.AbstractMappingStrategy
    protected BeanField<T, String> findField(int i) throws CsvBadConverterException {
        String columnName = getColumnName(i);
        if (columnName == null) {
            return null;
        }
        String trim = columnName.trim();
        if (trim.isEmpty()) {
            return null;
        }
        return this.fieldMap.get(trim.toUpperCase());
    }

    @Override // com.opencsv.bean.AbstractMappingStrategy
    protected void loadUnadornedFieldMap(ListValuedMap<Class<?>, Field> listValuedMap) {
        listValuedMap.entries().stream().filter(new Predicate() { // from class: com.opencsv.bean.-$$Lambda$HeaderNameBaseMappingStrategy$969mtADElgbAGv8QDbGSXRpw6V0
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return HeaderNameBaseMappingStrategy.lambda$loadUnadornedFieldMap$0((Map.Entry) obj);
            }
        }).filter(new Predicate() { // from class: com.opencsv.bean.-$$Lambda$HeaderNameBaseMappingStrategy$XxuEv_iSFRM9snUWcKavKXwReGs
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return HeaderNameBaseMappingStrategy.lambda$loadUnadornedFieldMap$1((Map.Entry) obj);
            }
        }).forEach(new Consumer() { // from class: com.opencsv.bean.-$$Lambda$HeaderNameBaseMappingStrategy$Eu7SmMZjx5DatXv7NF9CFoNj2WQ
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                HeaderNameBaseMappingStrategy.this.lambda$loadUnadornedFieldMap$2$HeaderNameBaseMappingStrategy((Map.Entry) obj);
            }
        });
    }

    static /* synthetic */ boolean lambda$loadUnadornedFieldMap$0(Map.Entry entry) {
        return (Serializable.class.isAssignableFrom((Class) entry.getKey()) && "serialVersionUID".equals(((Field) entry.getValue()).getName())) ? false : true;
    }

    static /* synthetic */ boolean lambda$loadUnadornedFieldMap$1(Map.Entry entry) {
        return !((Field) entry.getValue()).isAnnotationPresent(CsvRecurse.class);
    }

    public /* synthetic */ void lambda$loadUnadornedFieldMap$2$HeaderNameBaseMappingStrategy(Map.Entry entry) {
        this.fieldMap.put(((Field) entry.getValue()).getName().toUpperCase(), new BeanFieldSingleValue((Class) entry.getKey(), (Field) entry.getValue(), false, this.errorLocale, determineConverter((Field) entry.getValue(), ((Field) entry.getValue()).getType(), null, null, null), null, null));
    }

    @Override // com.opencsv.bean.AbstractMappingStrategy
    protected void initializeFieldMap() {
        FieldMapByName<T> fieldMapByName = new FieldMapByName<>(this.errorLocale);
        this.fieldMap = fieldMapByName;
        fieldMapByName.setColumnOrderOnWrite(this.writeOrder);
    }

    @Override // com.opencsv.bean.AbstractMappingStrategy
    protected FieldMap<String, String, ? extends ComplexFieldMapEntry<String, String, T>, T> getFieldMap() {
        return this.fieldMap;
    }

    @Override // com.opencsv.bean.AbstractMappingStrategy
    public String findHeader(int i) {
        return this.headerIndex.getByPosition(i);
    }

    public void setColumnOrderOnWrite(Comparator<String> comparator) {
        this.writeOrder = comparator;
        FieldMapByName<T> fieldMapByName = this.fieldMap;
        if (fieldMapByName != null) {
            fieldMapByName.setColumnOrderOnWrite(comparator);
        }
    }
}