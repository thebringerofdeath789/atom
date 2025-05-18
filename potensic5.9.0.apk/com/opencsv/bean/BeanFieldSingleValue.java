package com.opencsv.bean;

import com.opencsv.ICSVParser;
import com.opencsv.bean.util.OpencsvUtils;
import com.opencsv.exceptions.CsvBadConverterException;
import com.opencsv.exceptions.CsvConstraintViolationException;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import java.lang.reflect.Field;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes3.dex */
public class BeanFieldSingleValue<T, I> extends AbstractBeanField<T, I> {
    protected final Pattern capture;
    protected final String writeFormat;

    public BeanFieldSingleValue(Class<?> cls, Field field, boolean z, Locale locale, CsvConverter csvConverter, String str, String str2) {
        super(cls, field, z, locale, csvConverter);
        this.capture = OpencsvUtils.compilePatternAtLeastOneGroup(str, 0, BeanFieldSingleValue.class, this.errorLocale);
        this.writeFormat = str2;
        OpencsvUtils.verifyFormatString(str2, BeanFieldSingleValue.class, this.errorLocale);
    }

    @Override // com.opencsv.bean.AbstractBeanField
    protected Object convert(String str) throws CsvDataTypeMismatchException, CsvConstraintViolationException {
        Pattern pattern = this.capture;
        if (pattern != null && str != null) {
            Matcher matcher = pattern.matcher(str);
            if (matcher.matches()) {
                str = matcher.group(1);
            }
        }
        if (this.converter != null) {
            return this.converter.convertToRead(str);
        }
        throw new CsvBadConverterException(ResourceBundle.getBundle(ICSVParser.DEFAULT_BUNDLE_NAME, this.errorLocale).getString("no.converter.specified"));
    }

    @Override // com.opencsv.bean.AbstractBeanField
    protected String convertToWrite(Object obj) throws CsvDataTypeMismatchException {
        if (this.converter != null) {
            String convertToWrite = this.converter.convertToWrite(obj);
            return (StringUtils.isNotEmpty(this.writeFormat) && StringUtils.isNotEmpty(convertToWrite)) ? String.format(this.writeFormat, convertToWrite) : convertToWrite;
        }
        throw new CsvBadConverterException(ResourceBundle.getBundle(ICSVParser.DEFAULT_BUNDLE_NAME, this.errorLocale).getString("no.converter.specified"));
    }
}