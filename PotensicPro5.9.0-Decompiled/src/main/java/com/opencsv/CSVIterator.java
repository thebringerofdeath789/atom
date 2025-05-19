package com.opencsv;

import com.opencsv.exceptions.CsvValidationException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.ResourceBundle;
import org.apache.commons.lang3.ObjectUtils;

/* loaded from: classes3.dex */
public class CSVIterator implements Iterator<String[]> {
    private Locale errorLocale = Locale.getDefault();
    private String[] nextLine;
    private final CSVReader reader;

    public CSVIterator(CSVReader cSVReader) throws IOException, CsvValidationException {
        this.reader = cSVReader;
        this.nextLine = cSVReader.readNext();
    }

    public void setErrorLocale(Locale locale) {
        this.errorLocale = (Locale) ObjectUtils.defaultIfNull(locale, Locale.getDefault());
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.nextLine != null;
    }

    @Override // java.util.Iterator
    public String[] next() {
        String[] strArr = this.nextLine;
        try {
            this.nextLine = this.reader.readNext();
            return strArr;
        } catch (CsvValidationException | IOException e) {
            NoSuchElementException noSuchElementException = new NoSuchElementException(e.getLocalizedMessage());
            noSuchElementException.initCause(e);
            throw noSuchElementException;
        }
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException(ResourceBundle.getBundle(ICSVParser.DEFAULT_BUNDLE_NAME, this.errorLocale).getString("read.only.iterator"));
    }
}
