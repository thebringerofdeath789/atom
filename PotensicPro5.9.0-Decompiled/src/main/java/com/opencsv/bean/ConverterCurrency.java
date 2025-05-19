package com.opencsv.bean;

import com.opencsv.ICSVParser;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import java.util.Currency;
import java.util.Locale;
import java.util.ResourceBundle;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes3.dex */
public class ConverterCurrency extends AbstractCsvConverter {
    public ConverterCurrency(Locale locale) {
        super(Currency.class, null, null, locale);
    }

    @Override // com.opencsv.bean.CsvConverter
    public Object convertToRead(String str) throws CsvDataTypeMismatchException {
        if (!StringUtils.isNotEmpty(str)) {
            return null;
        }
        try {
            return Currency.getInstance(str);
        } catch (IllegalArgumentException e) {
            CsvDataTypeMismatchException csvDataTypeMismatchException = new CsvDataTypeMismatchException(str, this.type, String.format(ResourceBundle.getBundle(ICSVParser.DEFAULT_BUNDLE_NAME).getString("invalid.currency.value"), str, this.type.getName()));
            csvDataTypeMismatchException.initCause(e);
            throw csvDataTypeMismatchException;
        }
    }

    @Override // com.opencsv.bean.AbstractCsvConverter, com.opencsv.bean.CsvConverter
    public String convertToWrite(Object obj) throws CsvDataTypeMismatchException {
        if (obj != null) {
            return ((Currency) obj).getCurrencyCode();
        }
        return null;
    }
}
