package com.opencsv;

import com.opencsv.enums.CSVReaderNullFieldIndicator;
import com.opencsv.processor.RowProcessor;
import com.opencsv.validators.LineValidator;
import com.opencsv.validators.RowValidator;
import java.io.IOException;
import java.io.Reader;
import java.util.Locale;
import java.util.ResourceBundle;
import org.apache.commons.lang3.ObjectUtils;

/* loaded from: classes3.dex */
public class CSVReaderHeaderAwareBuilder extends CSVReaderBaseBuilder<CSVReaderHeaderAware> {
    public CSVReaderHeaderAwareBuilder(Reader reader) {
        super(reader);
    }

    public CSVReaderHeaderAwareBuilder withSkipLines(int i) {
        this.skipLines = Math.max(i, 0);
        return this;
    }

    public CSVReaderHeaderAwareBuilder withCSVParser(ICSVParser iCSVParser) {
        this.icsvParser = iCSVParser;
        return this;
    }

    public CSVReaderHeaderAwareBuilder withKeepCarriageReturn(boolean z) {
        this.keepCR = z;
        return this;
    }

    public CSVReaderHeaderAwareBuilder withVerifyReader(boolean z) {
        this.verifyReader = z;
        return this;
    }

    public CSVReaderHeaderAwareBuilder withFieldAsNull(CSVReaderNullFieldIndicator cSVReaderNullFieldIndicator) {
        this.nullFieldIndicator = cSVReaderNullFieldIndicator;
        return this;
    }

    public CSVReaderHeaderAwareBuilder withMultilineLimit(int i) {
        this.multilineLimit = i;
        return this;
    }

    public CSVReaderHeaderAwareBuilder withErrorLocale(Locale locale) {
        this.errorLocale = (Locale) ObjectUtils.defaultIfNull(locale, Locale.getDefault());
        return this;
    }

    public CSVReaderHeaderAwareBuilder withLineValidator(LineValidator lineValidator) {
        this.lineValidatorAggregator.addValidator(lineValidator);
        return this;
    }

    public CSVReaderHeaderAwareBuilder withRowValidator(RowValidator rowValidator) {
        this.rowValidatorAggregator.addValidator(rowValidator);
        return this;
    }

    public CSVReaderHeaderAwareBuilder withRowProcessor(RowProcessor rowProcessor) {
        this.rowProcessor = rowProcessor;
        return this;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.opencsv.CSVReaderBaseBuilder
    public CSVReaderHeaderAware build() throws RuntimeException {
        try {
            return new CSVReaderHeaderAware(this.reader, this.skipLines, getOrCreateCsvParser(), this.keepCR, this.verifyReader, this.multilineLimit, this.errorLocale, this.lineValidatorAggregator, this.rowValidatorAggregator, this.rowProcessor);
        } catch (IOException e) {
            throw new RuntimeException(ResourceBundle.getBundle(ICSVParser.DEFAULT_BUNDLE_NAME, this.errorLocale).getString("csvreaderheaderaware.impossible"), e);
        }
    }
}
