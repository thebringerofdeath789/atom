package com.opencsv;

import com.opencsv.enums.CSVReaderNullFieldIndicator;

/* loaded from: classes3.dex */
public class RFC4180ParserBuilder {
    private char separator = ',';
    private char quoteChar = '\"';
    private CSVReaderNullFieldIndicator nullFieldIndicator = CSVReaderNullFieldIndicator.NEITHER;

    public char getSeparator() {
        return this.separator;
    }

    public char getQuoteChar() {
        return this.quoteChar;
    }

    public CSVReaderNullFieldIndicator nullFieldIndicator() {
        return this.nullFieldIndicator;
    }

    public RFC4180Parser build() {
        return new RFC4180Parser(this.quoteChar, this.separator, this.nullFieldIndicator);
    }

    public RFC4180ParserBuilder withSeparator(char c) {
        this.separator = c;
        return this;
    }

    public RFC4180ParserBuilder withQuoteChar(char c) {
        this.quoteChar = c;
        return this;
    }

    public RFC4180ParserBuilder withFieldAsNull(CSVReaderNullFieldIndicator cSVReaderNullFieldIndicator) {
        this.nullFieldIndicator = cSVReaderNullFieldIndicator;
        return this;
    }
}
