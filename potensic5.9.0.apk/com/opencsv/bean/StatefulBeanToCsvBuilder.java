package com.opencsv.bean;

import com.opencsv.ICSVParser;
import com.opencsv.ICSVWriter;
import com.opencsv.bean.exceptionhandler.CsvExceptionHandler;
import com.opencsv.bean.exceptionhandler.ExceptionHandlerQueue;
import com.opencsv.bean.exceptionhandler.ExceptionHandlerThrow;
import java.io.Writer;
import java.lang.reflect.Field;
import java.util.Locale;
import java.util.ResourceBundle;
import org.apache.commons.collections4.ListValuedMap;
import org.apache.commons.collections4.multimap.ArrayListValuedHashMap;
import org.apache.commons.lang3.ObjectUtils;

/* loaded from: classes3.dex */
public class StatefulBeanToCsvBuilder<T> {
    private boolean applyQuotesToAll;
    private final ICSVWriter csvWriter;
    private Locale errorLocale;
    private char escapechar;
    private CsvExceptionHandler exceptionHandler;
    private final ListValuedMap<Class<?>, Field> ignoredFields;
    private String lineEnd;
    private MappingStrategy<T> mappingStrategy;
    private boolean orderedResults;
    private String profile;
    private char quotechar;
    private char separator;
    private final Writer writer;

    public StatefulBeanToCsvBuilder(Writer writer) {
        this.separator = ',';
        this.quotechar = '\"';
        this.escapechar = '\"';
        this.lineEnd = "\n";
        this.mappingStrategy = null;
        this.exceptionHandler = new ExceptionHandlerThrow();
        this.orderedResults = true;
        this.errorLocale = Locale.getDefault();
        this.applyQuotesToAll = true;
        this.ignoredFields = new ArrayListValuedHashMap();
        this.profile = "";
        this.writer = writer;
        this.csvWriter = null;
    }

    public StatefulBeanToCsvBuilder(ICSVWriter iCSVWriter) {
        this.separator = ',';
        this.quotechar = '\"';
        this.escapechar = '\"';
        this.lineEnd = "\n";
        this.mappingStrategy = null;
        this.exceptionHandler = new ExceptionHandlerThrow();
        this.orderedResults = true;
        this.errorLocale = Locale.getDefault();
        this.applyQuotesToAll = true;
        this.ignoredFields = new ArrayListValuedHashMap();
        this.profile = "";
        this.writer = null;
        this.csvWriter = iCSVWriter;
    }

    public StatefulBeanToCsvBuilder<T> withMappingStrategy(MappingStrategy<T> mappingStrategy) {
        this.mappingStrategy = mappingStrategy;
        return this;
    }

    public StatefulBeanToCsvBuilder<T> withSeparator(char c) {
        this.separator = c;
        return this;
    }

    public StatefulBeanToCsvBuilder<T> withQuotechar(char c) {
        this.quotechar = c;
        return this;
    }

    public StatefulBeanToCsvBuilder<T> withEscapechar(char c) {
        this.escapechar = c;
        return this;
    }

    public StatefulBeanToCsvBuilder<T> withLineEnd(String str) {
        this.lineEnd = str;
        return this;
    }

    public StatefulBeanToCsvBuilder<T> withThrowExceptions(boolean z) {
        if (z) {
            this.exceptionHandler = new ExceptionHandlerThrow();
        } else {
            this.exceptionHandler = new ExceptionHandlerQueue();
        }
        return this;
    }

    public StatefulBeanToCsvBuilder<T> withExceptionHandler(CsvExceptionHandler csvExceptionHandler) {
        if (csvExceptionHandler != null) {
            this.exceptionHandler = csvExceptionHandler;
        }
        return this;
    }

    public StatefulBeanToCsvBuilder<T> withOrderedResults(boolean z) {
        this.orderedResults = z;
        return this;
    }

    public StatefulBeanToCsvBuilder<T> withErrorLocale(Locale locale) {
        this.errorLocale = (Locale) ObjectUtils.defaultIfNull(locale, Locale.getDefault());
        return this;
    }

    public StatefulBeanToCsvBuilder<T> withApplyQuotesToAll(boolean z) {
        this.applyQuotesToAll = z;
        return this;
    }

    public StatefulBeanToCsvBuilder<T> withIgnoreField(Class<?> cls, Field field) throws IllegalArgumentException {
        if (cls != null && field != null && field.getDeclaringClass().isAssignableFrom(cls)) {
            this.ignoredFields.put(cls, field);
            return this;
        }
        throw new IllegalArgumentException(ResourceBundle.getBundle(ICSVParser.DEFAULT_BUNDLE_NAME, this.errorLocale).getString("ignore.field.inconsistent"));
    }

    public StatefulBeanToCsvBuilder<T> withProfile(String str) {
        this.profile = str;
        return this;
    }

    public StatefulBeanToCsv<T> build() {
        StatefulBeanToCsv<T> statefulBeanToCsv;
        if (this.writer != null) {
            statefulBeanToCsv = new StatefulBeanToCsv<>(this.escapechar, this.lineEnd, this.mappingStrategy, this.quotechar, this.separator, this.exceptionHandler, this.writer, this.applyQuotesToAll, this.ignoredFields, this.profile);
        } else {
            statefulBeanToCsv = new StatefulBeanToCsv<>(this.mappingStrategy, this.exceptionHandler, this.applyQuotesToAll, this.csvWriter, this.ignoredFields, this.profile);
        }
        statefulBeanToCsv.setOrderedResults(this.orderedResults);
        statefulBeanToCsv.setErrorLocale(this.errorLocale);
        return statefulBeanToCsv;
    }
}