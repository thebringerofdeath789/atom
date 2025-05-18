package com.opencsv;

import com.opencsv.enums.CSVReaderNullFieldIndicator;
import java.io.IOException;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes3.dex */
public abstract class AbstractCSVParser implements ICSVParser {
    protected final CSVReaderNullFieldIndicator nullFieldIndicator;
    protected String pending;
    protected final char quotechar;
    protected final char separator;

    /* renamed from: convertToCsvValue, reason: merged with bridge method [inline-methods] */
    protected abstract String lambda$parseToLine$0$AbstractCSVParser(String str, boolean z);

    protected abstract String[] parseLine(String str, boolean z) throws IOException;

    public AbstractCSVParser(char c, char c2, CSVReaderNullFieldIndicator cSVReaderNullFieldIndicator) {
        this.separator = c;
        this.quotechar = c2;
        this.nullFieldIndicator = cSVReaderNullFieldIndicator;
    }

    @Override // com.opencsv.ICSVParser
    public char getSeparator() {
        return this.separator;
    }

    @Override // com.opencsv.ICSVParser
    public char getQuotechar() {
        return this.quotechar;
    }

    @Override // com.opencsv.ICSVParser
    public boolean isPending() {
        return this.pending != null;
    }

    @Override // com.opencsv.ICSVParser
    public String[] parseLineMulti(String str) throws IOException {
        return parseLine(str, true);
    }

    @Override // com.opencsv.ICSVParser
    public String[] parseLine(String str) throws IOException {
        return parseLine(str, false);
    }

    @Override // com.opencsv.ICSVParser
    public String parseToLine(String[] strArr, final boolean z) {
        return (String) Stream.of((Object[]) strArr).map(new Function() { // from class: com.opencsv.-$$Lambda$AbstractCSVParser$rGy-MuPbexyQUtNXeydVcmx1rJ0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return AbstractCSVParser.this.lambda$parseToLine$0$AbstractCSVParser(z, (String) obj);
            }
        }).collect(Collectors.joining(Character.toString(getSeparator())));
    }

    protected boolean isSurroundWithQuotes(String str, boolean z) {
        if (str == null) {
            return this.nullFieldIndicator.equals(CSVReaderNullFieldIndicator.EMPTY_QUOTES);
        }
        return (str.isEmpty() && this.nullFieldIndicator.equals(CSVReaderNullFieldIndicator.EMPTY_SEPARATORS)) || z || str.contains(Character.toString(getSeparator())) || str.contains("\n");
    }

    @Override // com.opencsv.ICSVParser
    public CSVReaderNullFieldIndicator nullFieldIndicator() {
        return this.nullFieldIndicator;
    }

    @Override // com.opencsv.ICSVParser
    public String getPendingText() {
        return StringUtils.defaultString(this.pending);
    }
}