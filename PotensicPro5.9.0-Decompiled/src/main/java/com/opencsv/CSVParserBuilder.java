package com.opencsv;

import com.opencsv.enums.CSVReaderNullFieldIndicator;
import java.util.Locale;
import org.apache.commons.lang3.ObjectUtils;

/* loaded from: classes3.dex */
public class CSVParserBuilder {
    private char separator = ',';
    private char quoteChar = '\"';
    private char escapeChar = ICSVParser.DEFAULT_ESCAPE_CHARACTER;
    private boolean strictQuotes = false;
    private boolean ignoreLeadingWhiteSpace = true;
    private boolean ignoreQuotations = false;
    private CSVReaderNullFieldIndicator nullFieldIndicator = CSVReaderNullFieldIndicator.NEITHER;
    private Locale errorLocale = Locale.getDefault();

    public CSVParserBuilder withSeparator(char c) {
        this.separator = c;
        return this;
    }

    public CSVParserBuilder withQuoteChar(char c) {
        this.quoteChar = c;
        return this;
    }

    public CSVParserBuilder withEscapeChar(char c) {
        this.escapeChar = c;
        return this;
    }

    public CSVParserBuilder withStrictQuotes(boolean z) {
        this.strictQuotes = z;
        return this;
    }

    public CSVParserBuilder withIgnoreLeadingWhiteSpace(boolean z) {
        this.ignoreLeadingWhiteSpace = z;
        return this;
    }

    public CSVParserBuilder withIgnoreQuotations(boolean z) {
        this.ignoreQuotations = z;
        return this;
    }

    public CSVParser build() {
        return new CSVParser(this.separator, this.quoteChar, this.escapeChar, this.strictQuotes, this.ignoreLeadingWhiteSpace, this.ignoreQuotations, this.nullFieldIndicator, this.errorLocale);
    }

    public char getSeparator() {
        return this.separator;
    }

    public char getQuoteChar() {
        return this.quoteChar;
    }

    public char getEscapeChar() {
        return this.escapeChar;
    }

    public boolean isStrictQuotes() {
        return this.strictQuotes;
    }

    public boolean isIgnoreLeadingWhiteSpace() {
        return this.ignoreLeadingWhiteSpace;
    }

    public boolean isIgnoreQuotations() {
        return this.ignoreQuotations;
    }

    public CSVParserBuilder withFieldAsNull(CSVReaderNullFieldIndicator cSVReaderNullFieldIndicator) {
        this.nullFieldIndicator = cSVReaderNullFieldIndicator;
        return this;
    }

    public CSVParserBuilder withErrorLocale(Locale locale) {
        this.errorLocale = (Locale) ObjectUtils.defaultIfNull(locale, Locale.getDefault());
        return this;
    }

    public CSVReaderNullFieldIndicator nullFieldIndicator() {
        return this.nullFieldIndicator;
    }
}
