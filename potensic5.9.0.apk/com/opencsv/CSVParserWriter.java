package com.opencsv;

import java.io.IOException;
import java.io.Writer;

/* loaded from: classes3.dex */
public class CSVParserWriter extends AbstractCSVWriter {
    protected final ICSVParser parser;

    public CSVParserWriter(Writer writer, ICSVParser iCSVParser, String str) {
        super(writer, str);
        this.parser = iCSVParser;
    }

    @Override // com.opencsv.AbstractCSVWriter
    protected void writeNext(String[] strArr, boolean z, Appendable appendable) throws IOException {
        appendable.append(this.parser.parseToLine(strArr, z));
        appendable.append(this.lineEnd);
        this.writer.write(appendable.toString());
    }
}