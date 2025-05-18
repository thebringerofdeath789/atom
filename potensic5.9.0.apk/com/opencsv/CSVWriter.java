package com.opencsv;

import java.io.IOException;
import java.io.Writer;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes3.dex */
public class CSVWriter extends AbstractCSVWriter {
    protected final char escapechar;
    protected final char quotechar;
    protected final char separator;

    public CSVWriter(Writer writer) {
        this(writer, ',', '\"', '\"', "\n");
    }

    public CSVWriter(Writer writer, char c, char c2, char c3, String str) {
        super(writer, str);
        this.escapechar = c3;
        this.quotechar = c2;
        this.separator = c;
    }

    @Override // com.opencsv.AbstractCSVWriter
    protected void writeNext(String[] strArr, boolean z, Appendable appendable) throws IOException {
        if (strArr == null) {
            return;
        }
        for (int i = 0; i < strArr.length; i++) {
            if (i != 0) {
                appendable.append(this.separator);
            }
            String str = strArr[i];
            if (str != null) {
                Boolean valueOf = Boolean.valueOf(stringContainsSpecialCharacters(str));
                appendQuoteCharacterIfNeeded(z, appendable, valueOf);
                if (valueOf.booleanValue()) {
                    processLine(str, appendable);
                } else {
                    appendable.append(str);
                }
                appendQuoteCharacterIfNeeded(z, appendable, valueOf);
            }
        }
        appendable.append(this.lineEnd);
        this.writer.write(appendable.toString());
    }

    private void appendQuoteCharacterIfNeeded(boolean z, Appendable appendable, Boolean bool) throws IOException {
        char c;
        if ((z || bool.booleanValue()) && (c = this.quotechar) != 0) {
            appendable.append(c);
        }
    }

    protected boolean stringContainsSpecialCharacters(String str) {
        return (str.indexOf(this.quotechar) == -1 && str.indexOf(this.escapechar) == -1 && str.indexOf(this.separator) == -1 && !str.contains("\n") && !str.contains(StringUtils.f4244CR)) ? false : true;
    }

    protected void processLine(String str, Appendable appendable) throws IOException {
        for (int i = 0; i < str.length(); i++) {
            processCharacter(appendable, str.charAt(i));
        }
    }

    protected void processCharacter(Appendable appendable, char c) throws IOException {
        if (this.escapechar != 0 && checkCharactersToEscape(c)) {
            appendable.append(this.escapechar);
        }
        appendable.append(c);
    }

    protected boolean checkCharactersToEscape(char c) {
        char c2 = this.quotechar;
        if (c2 == 0) {
            if (c != c2 && c != this.escapechar && c != this.separator && c != '\n') {
                return false;
            }
        } else if (c != c2 && c != this.escapechar) {
            return false;
        }
        return true;
    }
}