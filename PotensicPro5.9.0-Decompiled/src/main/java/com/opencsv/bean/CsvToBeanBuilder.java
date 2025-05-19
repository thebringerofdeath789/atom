package com.opencsv.bean;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.ICSVParser;
import com.opencsv.bean.exceptionhandler.CsvExceptionHandler;
import com.opencsv.bean.util.OpencsvUtils;
import com.opencsv.enums.CSVReaderNullFieldIndicator;
import java.io.Reader;
import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import org.apache.commons.collections4.ListValuedMap;
import org.apache.commons.collections4.multimap.ArrayListValuedHashMap;
import org.apache.commons.lang3.ObjectUtils;

/* loaded from: classes3.dex */
public class CsvToBeanBuilder<T> {
    private final CSVReader csvReader;
    private boolean keepCR;
    private final Reader reader;
    private MappingStrategy<? extends T> mappingStrategy = null;
    private CsvToBeanFilter filter = null;
    private CsvExceptionHandler exceptionHandler = null;
    private CSVReaderNullFieldIndicator nullFieldIndicator = null;
    private Integer skipLines = null;
    private Boolean verifyReader = null;
    private Character separator = null;
    private Character quoteChar = null;
    private Character escapeChar = null;
    private Boolean strictQuotes = null;
    private Boolean ignoreLeadingWhiteSpace = null;
    private Boolean ignoreQuotations = null;
    private Boolean throwsExceptions = true;
    private Class<? extends T> type = null;
    private Integer multilineLimit = null;
    private boolean orderedResults = true;
    private boolean ignoreEmptyLines = false;
    private Locale errorLocale = Locale.getDefault();
    private final List<BeanVerifier<T>> verifiers = new LinkedList();
    private final ListValuedMap<Class<?>, Field> ignoredFields = new ArrayListValuedHashMap();
    private String profile = "";

    public CsvToBeanBuilder(Reader reader) {
        if (reader == null) {
            throw new IllegalArgumentException(ResourceBundle.getBundle(ICSVParser.DEFAULT_BUNDLE_NAME).getString("reader.null"));
        }
        this.reader = reader;
        this.csvReader = null;
    }

    public CsvToBeanBuilder(CSVReader cSVReader) {
        if (cSVReader == null) {
            throw new IllegalArgumentException(ResourceBundle.getBundle(ICSVParser.DEFAULT_BUNDLE_NAME).getString("reader.null"));
        }
        this.reader = null;
        this.csvReader = cSVReader;
    }

    public CsvToBean<T> build() throws IllegalStateException {
        if (this.mappingStrategy == null && this.type == null) {
            throw new IllegalStateException(ResourceBundle.getBundle(ICSVParser.DEFAULT_BUNDLE_NAME, this.errorLocale).getString("strategy.type.missing"));
        }
        CsvToBean<T> csvToBean = new CsvToBean<>();
        CSVReader cSVReader = this.csvReader;
        if (cSVReader != null) {
            csvToBean.setCsvReader(cSVReader);
        } else {
            csvToBean.setCsvReader(buildReader(buildParser()));
        }
        CsvExceptionHandler csvExceptionHandler = this.exceptionHandler;
        if (csvExceptionHandler != null) {
            csvToBean.setExceptionHandler(csvExceptionHandler);
        } else {
            csvToBean.setThrowExceptions(this.throwsExceptions.booleanValue());
        }
        csvToBean.setOrderedResults(this.orderedResults);
        CsvToBeanFilter csvToBeanFilter = this.filter;
        if (csvToBeanFilter != null) {
            csvToBean.setFilter(csvToBeanFilter);
        }
        csvToBean.setVerifiers(this.verifiers);
        if (this.mappingStrategy == null) {
            this.mappingStrategy = OpencsvUtils.determineMappingStrategy(this.type, this.errorLocale, this.profile);
        }
        if (!this.ignoredFields.isEmpty()) {
            this.mappingStrategy.ignoreFields(this.ignoredFields);
        }
        csvToBean.setMappingStrategy(this.mappingStrategy);
        csvToBean.setErrorLocale(this.errorLocale);
        csvToBean.setIgnoreEmptyLines(this.ignoreEmptyLines);
        return csvToBean;
    }

    private CSVParser buildParser() {
        CSVParserBuilder cSVParserBuilder = new CSVParserBuilder();
        CSVReaderNullFieldIndicator cSVReaderNullFieldIndicator = this.nullFieldIndicator;
        if (cSVReaderNullFieldIndicator != null) {
            cSVParserBuilder.withFieldAsNull(cSVReaderNullFieldIndicator);
        }
        Character ch = this.separator;
        if (ch != null) {
            cSVParserBuilder.withSeparator(ch.charValue());
        }
        Character ch2 = this.quoteChar;
        if (ch2 != null) {
            cSVParserBuilder.withQuoteChar(ch2.charValue());
        }
        Character ch3 = this.escapeChar;
        if (ch3 != null) {
            cSVParserBuilder.withEscapeChar(ch3.charValue());
        }
        Boolean bool = this.strictQuotes;
        if (bool != null) {
            cSVParserBuilder.withStrictQuotes(bool.booleanValue());
        }
        Boolean bool2 = this.ignoreLeadingWhiteSpace;
        if (bool2 != null) {
            cSVParserBuilder.withIgnoreLeadingWhiteSpace(bool2.booleanValue());
        }
        Boolean bool3 = this.ignoreQuotations;
        if (bool3 != null) {
            cSVParserBuilder.withIgnoreQuotations(bool3.booleanValue());
        }
        cSVParserBuilder.withErrorLocale(this.errorLocale);
        return cSVParserBuilder.build();
    }

    private CSVReader buildReader(CSVParser cSVParser) {
        CSVReaderBuilder cSVReaderBuilder = new CSVReaderBuilder(this.reader);
        cSVReaderBuilder.withCSVParser(cSVParser);
        cSVReaderBuilder.withKeepCarriageReturn(this.keepCR);
        Boolean bool = this.verifyReader;
        if (bool != null) {
            cSVReaderBuilder.withVerifyReader(bool.booleanValue());
        }
        Integer num = this.skipLines;
        if (num != null) {
            cSVReaderBuilder.withSkipLines(num.intValue());
        }
        Integer num2 = this.multilineLimit;
        if (num2 != null) {
            cSVReaderBuilder.withMultilineLimit(num2.intValue());
        }
        cSVReaderBuilder.withErrorLocale(this.errorLocale);
        return cSVReaderBuilder.build();
    }

    public CsvToBeanBuilder<T> withMappingStrategy(MappingStrategy<? extends T> mappingStrategy) {
        this.mappingStrategy = mappingStrategy;
        return this;
    }

    public CsvToBeanBuilder<T> withFilter(CsvToBeanFilter csvToBeanFilter) {
        this.filter = csvToBeanFilter;
        return this;
    }

    public CsvToBeanBuilder<T> withThrowExceptions(boolean z) {
        this.throwsExceptions = Boolean.valueOf(z);
        return this;
    }

    public CsvToBeanBuilder<T> withExceptionHandler(CsvExceptionHandler csvExceptionHandler) {
        if (csvExceptionHandler != null) {
            this.exceptionHandler = csvExceptionHandler;
        }
        return this;
    }

    public CsvToBeanBuilder<T> withFieldAsNull(CSVReaderNullFieldIndicator cSVReaderNullFieldIndicator) {
        this.nullFieldIndicator = cSVReaderNullFieldIndicator;
        return this;
    }

    public CsvToBeanBuilder<T> withKeepCarriageReturn(boolean z) {
        this.keepCR = z;
        return this;
    }

    public CsvToBeanBuilder<T> withVerifyReader(boolean z) {
        this.verifyReader = Boolean.valueOf(z);
        return this;
    }

    public CsvToBeanBuilder<T> withSkipLines(int i) {
        this.skipLines = Integer.valueOf(i);
        return this;
    }

    public CsvToBeanBuilder<T> withSeparator(char c) {
        this.separator = Character.valueOf(c);
        return this;
    }

    public CsvToBeanBuilder<T> withQuoteChar(char c) {
        this.quoteChar = Character.valueOf(c);
        return this;
    }

    public CsvToBeanBuilder<T> withEscapeChar(char c) {
        this.escapeChar = Character.valueOf(c);
        return this;
    }

    public CsvToBeanBuilder<T> withStrictQuotes(boolean z) {
        this.strictQuotes = Boolean.valueOf(z);
        return this;
    }

    public CsvToBeanBuilder<T> withIgnoreLeadingWhiteSpace(boolean z) {
        this.ignoreLeadingWhiteSpace = Boolean.valueOf(z);
        return this;
    }

    public CsvToBeanBuilder<T> withIgnoreQuotations(boolean z) {
        this.ignoreQuotations = Boolean.valueOf(z);
        return this;
    }

    public CsvToBeanBuilder<T> withType(Class<? extends T> cls) {
        this.type = cls;
        return this;
    }

    public CsvToBeanBuilder<T> withMultilineLimit(int i) {
        this.multilineLimit = Integer.valueOf(i);
        return this;
    }

    public CsvToBeanBuilder<T> withOrderedResults(boolean z) {
        this.orderedResults = z;
        return this;
    }

    public CsvToBeanBuilder<T> withErrorLocale(Locale locale) {
        this.errorLocale = (Locale) ObjectUtils.defaultIfNull(locale, Locale.getDefault());
        return this;
    }

    public CsvToBeanBuilder<T> withVerifier(BeanVerifier<T> beanVerifier) {
        if (beanVerifier != null) {
            this.verifiers.add(beanVerifier);
        }
        return this;
    }

    public CsvToBeanBuilder<T> withIgnoreField(Class<?> cls, Field field) throws IllegalArgumentException {
        if (cls != null && field != null && field.getDeclaringClass().isAssignableFrom(cls)) {
            this.ignoredFields.put(cls, field);
            return this;
        }
        throw new IllegalArgumentException(ResourceBundle.getBundle(ICSVParser.DEFAULT_BUNDLE_NAME, this.errorLocale).getString("ignore.field.inconsistent"));
    }

    public CsvToBeanBuilder<T> withIgnoreEmptyLine(boolean z) {
        this.ignoreEmptyLines = z;
        return this;
    }

    public CsvToBeanBuilder<T> withProfile(String str) {
        this.profile = str;
        return this;
    }
}
