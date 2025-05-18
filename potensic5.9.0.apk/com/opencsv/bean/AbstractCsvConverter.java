package com.opencsv.bean;

import com.opencsv.exceptions.CsvDataTypeMismatchException;
import java.util.Locale;
import java.util.Objects;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes3.dex */
public abstract class AbstractCsvConverter implements CsvConverter {
    protected Locale errorLocale;
    protected Locale locale;
    protected Class<?> type;
    protected Locale writeLocale;

    protected AbstractCsvConverter() {
        this.type = null;
        this.locale = null;
        this.writeLocale = null;
        this.errorLocale = Locale.getDefault();
    }

    protected AbstractCsvConverter(Class<?> cls, String str, String str2, Locale locale) {
        this.type = cls;
        this.locale = StringUtils.isNotEmpty(str) ? Locale.forLanguageTag(str) : null;
        this.writeLocale = StringUtils.isNotEmpty(str2) ? Locale.forLanguageTag(str2) : null;
        this.errorLocale = (Locale) ObjectUtils.defaultIfNull(locale, Locale.getDefault());
    }

    @Override // com.opencsv.bean.CsvConverter
    public String convertToWrite(Object obj) throws CsvDataTypeMismatchException {
        return Objects.toString(obj, "");
    }

    @Override // com.opencsv.bean.CsvConverter
    public void setErrorLocale(Locale locale) {
        this.errorLocale = (Locale) ObjectUtils.defaultIfNull(locale, Locale.getDefault());
    }

    @Override // com.opencsv.bean.CsvConverter
    public void setType(Class<?> cls) {
        this.type = cls;
    }

    @Override // com.opencsv.bean.CsvConverter
    public void setLocale(String str) {
        this.locale = StringUtils.isNotEmpty(str) ? Locale.forLanguageTag(str) : null;
    }

    @Override // com.opencsv.bean.CsvConverter
    public void setWriteLocale(String str) {
        this.writeLocale = StringUtils.isNotEmpty(str) ? Locale.forLanguageTag(str) : null;
    }
}