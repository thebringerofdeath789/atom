package com.opencsv;

import com.opencsv.enums.CSVReaderNullFieldIndicator;
import com.opencsv.processor.RowProcessor;
import com.opencsv.validators.LineValidator;
import com.opencsv.validators.RowValidator;
import java.io.Reader;
import java.util.Locale;
import java.util.ResourceBundle;
import org.apache.commons.lang3.ObjectUtils;

/* loaded from: classes3.dex */
public class CSVReaderBuilder extends CSVReaderBaseBuilder<CSVReader> {
    public CSVReaderBuilder(Reader reader) {
        super(reader);
        if (reader == null) {
            throw new IllegalArgumentException(ResourceBundle.getBundle(ICSVParser.DEFAULT_BUNDLE_NAME).getString("reader.null"));
        }
    }

    public CSVReaderBuilder withSkipLines(int i) {
        this.skipLines = Math.max(i, 0);
        return this;
    }

    public CSVReaderBuilder withCSVParser(ICSVParser iCSVParser) {
        this.icsvParser = iCSVParser;
        return this;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.opencsv.CSVReaderBaseBuilder
    public CSVReader build() {
        return new CSVReader(this.reader, this.skipLines, getOrCreateCsvParser(), this.keepCR, this.verifyReader, this.multilineLimit, this.errorLocale, this.lineValidatorAggregator, this.rowValidatorAggregator, this.rowProcessor);
    }

    public CSVReaderBuilder withKeepCarriageReturn(boolean z) {
        this.keepCR = z;
        return this;
    }

    public CSVReaderBuilder withVerifyReader(boolean z) {
        this.verifyReader = z;
        return this;
    }

    public CSVReaderBuilder withFieldAsNull(CSVReaderNullFieldIndicator cSVReaderNullFieldIndicator) {
        this.nullFieldIndicator = cSVReaderNullFieldIndicator;
        return this;
    }

    public CSVReaderBuilder withMultilineLimit(int i) {
        this.multilineLimit = i;
        return this;
    }

    public CSVReaderBuilder withErrorLocale(Locale locale) {
        this.errorLocale = (Locale) ObjectUtils.defaultIfNull(locale, Locale.getDefault());
        return this;
    }

    public CSVReaderBuilder withLineValidator(LineValidator lineValidator) {
        this.lineValidatorAggregator.addValidator(lineValidator);
        return this;
    }

    public CSVReaderBuilder withRowValidator(RowValidator rowValidator) {
        this.rowValidatorAggregator.addValidator(rowValidator);
        return this;
    }

    public CSVReaderBuilder withRowProcessor(RowProcessor rowProcessor) {
        this.rowProcessor = rowProcessor;
        return this;
    }
}
