package com.opencsv.bean;

import com.opencsv.ICSVParser;
import com.opencsv.exceptions.CsvBadConverterException;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.function.UnaryOperator;
import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes3.dex */
public class ConverterNumber extends AbstractCsvConverter {
    private final UnaryOperator<Number> readConversionFunction;
    private final DecimalFormat readFormatter;
    private final DecimalFormat writeFormatter;

    static /* synthetic */ Number lambda$new$1(Number number) {
        return number;
    }

    public ConverterNumber(Class<?> cls, String str, String str2, Locale locale, String str3, String str4) throws CsvBadConverterException {
        super(cls, str, str2, locale);
        if (!Number.class.isAssignableFrom(this.type.isPrimitive() ? ClassUtils.primitiveToWrapper(this.type) : this.type)) {
            throw new CsvBadConverterException(ConverterNumber.class, ResourceBundle.getBundle(ICSVParser.DEFAULT_BUNDLE_NAME, this.errorLocale).getString("csvnumber.not.number"));
        }
        DecimalFormat createDecimalFormat = createDecimalFormat(str3, this.locale);
        this.readFormatter = createDecimalFormat;
        if (this.type == BigInteger.class || this.type == BigDecimal.class) {
            createDecimalFormat.setParseBigDecimal(true);
        }
        if (this.type == Byte.class || this.type == Byte.TYPE) {
            this.readConversionFunction = new UnaryOperator() { // from class: com.opencsv.bean.-$$Lambda$ConverterNumber$L0IGnMceKp-WEbdd5TcLMH_Nn-U
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    byte byteValue;
                    byteValue = ((Number) obj).byteValue();
                    return Byte.valueOf(byteValue);
                }
            };
        } else if (this.type == Short.class || this.type == Short.TYPE) {
            this.readConversionFunction = new UnaryOperator() { // from class: com.opencsv.bean.-$$Lambda$ConverterNumber$MPiXOoIwfbjGurx9P-xwcFCeWyg
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    short shortValue;
                    shortValue = ((Number) obj).shortValue();
                    return Short.valueOf(shortValue);
                }
            };
        } else if (this.type == Integer.class || this.type == Integer.TYPE) {
            this.readConversionFunction = new UnaryOperator() { // from class: com.opencsv.bean.-$$Lambda$ConverterNumber$y0wpLcsNfP0wlopHM2ek-H5h7KI
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    int intValue;
                    intValue = ((Number) obj).intValue();
                    return Integer.valueOf(intValue);
                }
            };
        } else if (this.type == Long.class || this.type == Long.TYPE) {
            this.readConversionFunction = new UnaryOperator() { // from class: com.opencsv.bean.-$$Lambda$ConverterNumber$qfHJlXtSrfRIyn12GwTBG6hYZzg
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    long longValue;
                    longValue = ((Number) obj).longValue();
                    return Long.valueOf(longValue);
                }
            };
        } else if (this.type == Float.class || this.type == Float.TYPE) {
            this.readConversionFunction = new UnaryOperator() { // from class: com.opencsv.bean.-$$Lambda$ConverterNumber$Ph0rGnhqOChOQQENtIA7hZ8fIdA
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    float floatValue;
                    floatValue = ((Number) obj).floatValue();
                    return Float.valueOf(floatValue);
                }
            };
        } else if (this.type == Double.class || this.type == Double.TYPE) {
            this.readConversionFunction = new UnaryOperator() { // from class: com.opencsv.bean.-$$Lambda$ConverterNumber$p-1_RTMQUlKY6kcBZPol546W2qg
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    double doubleValue;
                    doubleValue = ((Number) obj).doubleValue();
                    return Double.valueOf(doubleValue);
                }
            };
        } else if (this.type == BigInteger.class) {
            this.readConversionFunction = new UnaryOperator() { // from class: com.opencsv.bean.-$$Lambda$ConverterNumber$RTnH_lITohDEJ1ud7UUFKW6uG9I
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    Number bigInteger;
                    bigInteger = ((BigDecimal) ((Number) obj)).toBigInteger();
                    return bigInteger;
                }
            };
        } else {
            this.readConversionFunction = new UnaryOperator() { // from class: com.opencsv.bean.-$$Lambda$ConverterNumber$L3yg0QQpg0JXZaMrQ0HTqDlC9_E
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return ConverterNumber.lambda$new$1((Number) obj);
                }
            };
        }
        this.writeFormatter = createDecimalFormat(str4, this.writeLocale);
    }

    private DecimalFormat createDecimalFormat(String str, Locale locale) {
        NumberFormat numberFormat = NumberFormat.getInstance((Locale) ObjectUtils.defaultIfNull(locale, Locale.getDefault(Locale.Category.FORMAT)));
        if (!(numberFormat instanceof DecimalFormat)) {
            throw new CsvBadConverterException(ConverterNumber.class, ResourceBundle.getBundle(ICSVParser.DEFAULT_BUNDLE_NAME, this.errorLocale).getString("numberformat.not.decimalformat"));
        }
        DecimalFormat decimalFormat = (DecimalFormat) numberFormat;
        try {
            decimalFormat.applyLocalizedPattern(str);
            return decimalFormat;
        } catch (IllegalArgumentException e) {
            CsvBadConverterException csvBadConverterException = new CsvBadConverterException(ConverterNumber.class, String.format(ResourceBundle.getBundle(ICSVParser.DEFAULT_BUNDLE_NAME, this.errorLocale).getString("invalid.number.pattern"), str));
            csvBadConverterException.initCause(e);
            throw csvBadConverterException;
        }
    }

    @Override // com.opencsv.bean.CsvConverter
    public Object convertToRead(String str) throws CsvDataTypeMismatchException {
        Number parse;
        if (!StringUtils.isNotEmpty(str)) {
            return null;
        }
        try {
            synchronized (this.readFormatter) {
                parse = this.readFormatter.parse(str);
            }
            return (Number) this.readConversionFunction.apply(parse);
        } catch (ParseException e) {
            CsvDataTypeMismatchException csvDataTypeMismatchException = new CsvDataTypeMismatchException(str, this.type, String.format(ResourceBundle.getBundle(ICSVParser.DEFAULT_BUNDLE_NAME, this.errorLocale).getString("unparsable.number"), str, this.readFormatter.toPattern()));
            csvDataTypeMismatchException.initCause(e);
            throw csvDataTypeMismatchException;
        }
    }

    @Override // com.opencsv.bean.AbstractCsvConverter, com.opencsv.bean.CsvConverter
    public String convertToWrite(Object obj) {
        String format;
        synchronized (this.writeFormatter) {
            if (obj != null) {
                try {
                    format = this.writeFormatter.format(obj);
                } catch (Throwable th) {
                    throw th;
                }
            } else {
                format = null;
            }
        }
        return format;
    }
}