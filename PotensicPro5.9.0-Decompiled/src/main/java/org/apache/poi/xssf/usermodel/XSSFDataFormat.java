package org.apache.poi.xssf.usermodel;

import org.apache.poi.ss.usermodel.BuiltinFormats;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.xssf.model.StylesTable;

/* loaded from: classes5.dex */
public class XSSFDataFormat implements DataFormat {
    private StylesTable stylesSource;

    protected XSSFDataFormat(StylesTable stylesTable) {
        this.stylesSource = stylesTable;
    }

    @Override // org.apache.poi.ss.usermodel.DataFormat
    public short getFormat(String str) {
        int builtinFormat = BuiltinFormats.getBuiltinFormat(str);
        if (builtinFormat == -1) {
            builtinFormat = this.stylesSource.putNumberFormat(str);
        }
        return (short) builtinFormat;
    }

    @Override // org.apache.poi.ss.usermodel.DataFormat
    public String getFormat(short s) {
        return getFormat(s & 65535);
    }

    public String getFormat(int i) {
        String numberFormatAt = this.stylesSource.getNumberFormatAt(i);
        return numberFormatAt == null ? BuiltinFormats.getBuiltinFormat(i) : numberFormatAt;
    }
}
