package com.opencsv;

import com.opencsv.exceptions.CsvValidationException;
import com.opencsv.processor.RowProcessor;
import com.opencsv.validators.LineValidatorAggregator;
import com.opencsv.validators.RowValidatorAggregator;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

/* loaded from: classes3.dex */
public class CSVReaderHeaderAware extends CSVReader {
    private final Map<String, Integer> headerIndex;

    public CSVReaderHeaderAware(Reader reader) throws IOException {
        super(reader);
        this.headerIndex = new HashMap();
        initializeHeader();
    }

    CSVReaderHeaderAware(Reader reader, int i, ICSVParser iCSVParser, boolean z, boolean z2, int i2, Locale locale, LineValidatorAggregator lineValidatorAggregator, RowValidatorAggregator rowValidatorAggregator, RowProcessor rowProcessor) throws IOException {
        super(reader, i, iCSVParser, z, z2, i2, locale, lineValidatorAggregator, rowValidatorAggregator, rowProcessor);
        this.headerIndex = new HashMap();
        initializeHeader();
    }

    public String[] readNext(String... strArr) throws IOException, CsvValidationException {
        if (strArr == null) {
            return super.readNextSilently();
        }
        String[] readNext = readNext();
        if (readNext == null) {
            return null;
        }
        if (readNext.length != this.headerIndex.size()) {
            throw new IOException(String.format(ResourceBundle.getBundle(ICSVParser.DEFAULT_BUNDLE_NAME, this.errorLocale).getString("header.data.mismatch.with.line.number"), Long.valueOf(getRecordsRead()), Integer.valueOf(this.headerIndex.size()), Integer.valueOf(readNext.length)));
        }
        String[] strArr2 = new String[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            String str = strArr[i];
            Integer num = this.headerIndex.get(str);
            if (num == null) {
                throw new IllegalArgumentException(String.format(ResourceBundle.getBundle(ICSVParser.DEFAULT_BUNDLE_NAME, this.errorLocale).getString("header.nonexistant"), str));
            }
            strArr2[i] = readNext[num.intValue()];
        }
        return strArr2;
    }

    public Map<String, String> readMap() throws IOException, CsvValidationException {
        String[] readNext = readNext();
        if (readNext == null) {
            return null;
        }
        if (readNext.length != this.headerIndex.size()) {
            throw new IOException(String.format(ResourceBundle.getBundle(ICSVParser.DEFAULT_BUNDLE_NAME, this.errorLocale).getString("header.data.mismatch.with.line.number"), Long.valueOf(getRecordsRead()), Integer.valueOf(this.headerIndex.size()), Integer.valueOf(readNext.length)));
        }
        HashMap hashMap = new HashMap(this.headerIndex.size() * 2);
        for (Map.Entry<String, Integer> entry : this.headerIndex.entrySet()) {
            if (entry.getValue().intValue() < readNext.length) {
                hashMap.put(entry.getKey(), readNext[entry.getValue().intValue()]);
            }
        }
        return hashMap;
    }

    private void initializeHeader() throws IOException {
        String[] readNextSilently = super.readNextSilently();
        for (int i = 0; i < readNextSilently.length; i++) {
            this.headerIndex.put(readNextSilently[i], Integer.valueOf(i));
        }
    }
}