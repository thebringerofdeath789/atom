package com.opencsv;

import java.io.Writer;

/* loaded from: classes3.dex */
public class CSVWriterBuilder {
    private Character escapechar;
    private String lineEnd = "\n";
    private ICSVParser parser;
    private Character quotechar;
    private ResultSetHelper resultSetHelper;
    private Character separator;
    private final Writer writer;

    public CSVWriterBuilder(Writer writer) {
        this.writer = writer;
    }

    public CSVWriterBuilder withParser(ICSVParser iCSVParser) {
        if (this.separator != null || this.quotechar != null || this.escapechar != null) {
            throw new IllegalArgumentException("You cannot set the parser in the builder if you have set the separator, quote, or escape character");
        }
        this.parser = iCSVParser;
        return this;
    }

    public CSVWriterBuilder withSeparator(char c) {
        if (this.parser != null) {
            throw new IllegalArgumentException("You cannot set the separator in the builder if you have a ICSVParser set.  Set the separator in the parser instead.");
        }
        this.separator = Character.valueOf(c);
        return this;
    }

    public CSVWriterBuilder withQuoteChar(char c) {
        if (this.parser != null) {
            throw new IllegalArgumentException("You cannot set the quote character in the builder if you have a ICSVParser set.  Set the quote character in the parser instead.");
        }
        this.quotechar = Character.valueOf(c);
        return this;
    }

    public CSVWriterBuilder withEscapeChar(char c) {
        if (this.parser != null) {
            throw new IllegalArgumentException("You cannot set the escape character in the builder if you have a ICSVParser set.  Set the escape character in the parser instead.");
        }
        this.escapechar = Character.valueOf(c);
        return this;
    }

    public CSVWriterBuilder withLineEnd(String str) {
        this.lineEnd = str;
        return this;
    }

    public ICSVWriter build() {
        if (this.parser != null) {
            return createCSVParserWriter();
        }
        return createCSVWriter();
    }

    private ICSVWriter createCSVParserWriter() {
        return new CSVParserWriter(this.writer, this.parser, this.lineEnd);
    }

    private ICSVWriter createCSVWriter() {
        if (this.separator == null) {
            this.separator = ',';
        }
        if (this.quotechar == null) {
            this.quotechar = '\"';
        }
        if (this.escapechar == null) {
            this.escapechar = '\"';
        }
        CSVWriter cSVWriter = new CSVWriter(this.writer, this.separator.charValue(), this.quotechar.charValue(), this.escapechar.charValue(), this.lineEnd);
        ResultSetHelper resultSetHelper = this.resultSetHelper;
        if (resultSetHelper != null) {
            cSVWriter.setResultService(resultSetHelper);
        }
        return cSVWriter;
    }

    public CSVWriterBuilder withResultSetHelper(ResultSetHelper resultSetHelper) {
        this.resultSetHelper = resultSetHelper;
        return this;
    }
}
