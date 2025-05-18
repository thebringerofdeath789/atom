package com.opencsv.bean.concurrent;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import java.io.IOException;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes3.dex */
public class SingleLineReader {
    protected final CSVReader csvReader;
    protected final boolean ignoreEmptyLines;
    protected String[] line;

    public SingleLineReader(CSVReader cSVReader, boolean z) {
        this.csvReader = cSVReader;
        this.ignoreEmptyLines = z;
    }

    private boolean isCurrentLineEmpty() {
        String[] strArr = this.line;
        return strArr.length == 0 || (strArr.length == 1 && StringUtils.isEmpty(strArr[0]));
    }

    public String[] readNextLine() throws IOException, CsvValidationException {
        do {
            String[] readNext = this.csvReader.readNext();
            this.line = readNext;
            if (readNext == null || !isCurrentLineEmpty()) {
                break;
            }
        } while (this.ignoreEmptyLines);
        return getLine();
    }

    public long getLinesRead() {
        return this.csvReader.getLinesRead();
    }

    public String[] getLine() {
        String[] strArr = this.line;
        if (strArr == null) {
            return strArr;
        }
        String[] strArr2 = new String[strArr.length];
        System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
        return strArr2;
    }
}