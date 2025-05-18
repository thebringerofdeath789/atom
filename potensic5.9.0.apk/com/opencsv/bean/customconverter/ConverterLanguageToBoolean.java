package com.opencsv.bean.customconverter;

import com.opencsv.bean.AbstractBeanField;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import java.util.ResourceBundle;
import org.apache.commons.beanutils.ConversionException;
import org.apache.commons.beanutils.converters.BooleanConverter;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes3.dex */
public abstract class ConverterLanguageToBoolean<T, I> extends AbstractBeanField<T, I> {
    protected abstract String[] getAllLocalizedFalseValues();

    protected abstract String[] getAllLocalizedTrueValues();

    protected abstract String getLocalizedFalse();

    protected abstract String getLocalizedTrue();

    @Override // com.opencsv.bean.AbstractBeanField
    protected Object convert(String str) throws CsvDataTypeMismatchException {
        if (StringUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new BooleanConverter(getAllLocalizedTrueValues(), getAllLocalizedFalseValues()).convert(Boolean.class, str.trim());
        } catch (ConversionException e) {
            CsvDataTypeMismatchException csvDataTypeMismatchException = new CsvDataTypeMismatchException(str, this.field.getType(), ResourceBundle.getBundle("convertLanguageToBoolean", this.errorLocale).getString("input.not.boolean"));
            csvDataTypeMismatchException.initCause(e);
            throw csvDataTypeMismatchException;
        }
    }

    @Override // com.opencsv.bean.AbstractBeanField
    protected String convertToWrite(Object obj) throws CsvDataTypeMismatchException {
        if (obj == null) {
            return "";
        }
        try {
            return ((Boolean) obj).booleanValue() ? getLocalizedTrue() : getLocalizedFalse();
        } catch (ClassCastException e) {
            CsvDataTypeMismatchException csvDataTypeMismatchException = new CsvDataTypeMismatchException(ResourceBundle.getBundle("convertLanguageToBoolean", this.errorLocale).getString("field.not.boolean"));
            csvDataTypeMismatchException.initCause(e);
            throw csvDataTypeMismatchException;
        }
    }
}