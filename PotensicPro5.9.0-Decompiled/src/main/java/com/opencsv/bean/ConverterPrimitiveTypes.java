package com.opencsv.bean;

import com.opencsv.ICSVParser;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import java.util.Locale;
import java.util.ResourceBundle;
import org.apache.commons.beanutils.ConversionException;
import org.apache.commons.beanutils.ConvertUtilsBean;
import org.apache.commons.beanutils.locale.LocaleConvertUtilsBean;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes3.dex */
public class ConverterPrimitiveTypes extends AbstractCsvConverter {
    protected final ConvertUtilsBean readConverter;
    protected final LocaleConvertUtilsBean readLocaleConverter;
    protected final ConvertUtilsBean writeConverter;
    protected final LocaleConvertUtilsBean writeLocaleConverter;

    public ConverterPrimitiveTypes(Class<?> cls, String str, String str2, Locale locale) {
        super(cls, str, str2, locale);
        if (this.locale == null) {
            ConvertUtilsBean convertUtilsBean = new ConvertUtilsBean();
            this.readConverter = convertUtilsBean;
            convertUtilsBean.register(true, false, 0);
            this.readLocaleConverter = null;
        } else {
            LocaleConvertUtilsBean localeConvertUtilsBean = new LocaleConvertUtilsBean();
            this.readLocaleConverter = localeConvertUtilsBean;
            localeConvertUtilsBean.setDefaultLocale(this.locale);
            this.readConverter = null;
        }
        if (this.writeLocale == null) {
            ConvertUtilsBean convertUtilsBean2 = new ConvertUtilsBean();
            this.writeConverter = convertUtilsBean2;
            convertUtilsBean2.register(true, false, 0);
            this.writeLocaleConverter = null;
            return;
        }
        LocaleConvertUtilsBean localeConvertUtilsBean2 = new LocaleConvertUtilsBean();
        this.writeLocaleConverter = localeConvertUtilsBean2;
        localeConvertUtilsBean2.setDefaultLocale(this.writeLocale);
        this.writeConverter = null;
    }

    @Override // com.opencsv.bean.CsvConverter
    public Object convertToRead(String str) throws CsvDataTypeMismatchException {
        Object convert;
        if (!StringUtils.isNotBlank(str) && (str == null || !this.type.equals(String.class))) {
            return null;
        }
        try {
            ConvertUtilsBean convertUtilsBean = this.readConverter;
            if (convertUtilsBean != null) {
                synchronized (convertUtilsBean) {
                    convert = this.readConverter.convert(str, this.type);
                }
                return convert;
            }
            synchronized (this.readLocaleConverter) {
                convert = this.readLocaleConverter.convert(str, this.type);
            }
            return convert;
        } catch (ConversionException e) {
            CsvDataTypeMismatchException csvDataTypeMismatchException = new CsvDataTypeMismatchException(str, this.type, String.format(ResourceBundle.getBundle(ICSVParser.DEFAULT_BUNDLE_NAME, this.errorLocale).getString("conversion.impossible"), str, this.type.getCanonicalName()));
            csvDataTypeMismatchException.initCause(e);
            throw csvDataTypeMismatchException;
        }
    }

    @Override // com.opencsv.bean.AbstractCsvConverter, com.opencsv.bean.CsvConverter
    public String convertToWrite(Object obj) throws CsvDataTypeMismatchException {
        String convert;
        String convert2;
        if (obj == null) {
            return null;
        }
        try {
            ConvertUtilsBean convertUtilsBean = this.writeConverter;
            if (convertUtilsBean != null) {
                synchronized (convertUtilsBean) {
                    convert2 = this.writeConverter.convert(obj);
                }
                return convert2;
            }
            synchronized (this.writeLocaleConverter) {
                convert = this.writeLocaleConverter.convert(obj);
            }
            return convert;
        } catch (ConversionException e) {
            CsvDataTypeMismatchException csvDataTypeMismatchException = new CsvDataTypeMismatchException(ResourceBundle.getBundle(ICSVParser.DEFAULT_BUNDLE_NAME, this.errorLocale).getString("field.not.primitive"));
            csvDataTypeMismatchException.initCause(e);
            throw csvDataTypeMismatchException;
        }
        CsvDataTypeMismatchException csvDataTypeMismatchException2 = new CsvDataTypeMismatchException(ResourceBundle.getBundle(ICSVParser.DEFAULT_BUNDLE_NAME, this.errorLocale).getString("field.not.primitive"));
        csvDataTypeMismatchException2.initCause(e);
        throw csvDataTypeMismatchException2;
    }
}
