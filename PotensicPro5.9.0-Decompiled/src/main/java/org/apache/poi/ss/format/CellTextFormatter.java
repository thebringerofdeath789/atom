package org.apache.poi.ss.format;

import java.util.regex.Matcher;
import org.apache.poi.ss.format.CellFormatPart;

/* loaded from: classes5.dex */
public class CellTextFormatter extends CellFormatter {
    static final CellFormatter SIMPLE_TEXT = new CellTextFormatter("@");
    private final String desc;
    private final int[] textPos;

    public CellTextFormatter(String str) {
        super(str);
        final int[] iArr = new int[1];
        String stringBuffer = CellFormatPart.parseFormat(str, CellFormatType.TEXT, new CellFormatPart.PartHandler() { // from class: org.apache.poi.ss.format.CellTextFormatter.1
            @Override // org.apache.poi.ss.format.CellFormatPart.PartHandler
            public String handlePart(Matcher matcher, String str2, CellFormatType cellFormatType, StringBuffer stringBuffer2) {
                if (!str2.equals("@")) {
                    return null;
                }
                int[] iArr2 = iArr;
                iArr2[0] = iArr2[0] + 1;
                return "\u0000";
            }
        }).toString();
        this.desc = stringBuffer;
        int i = 0;
        this.textPos = new int[iArr[0]];
        int length = stringBuffer.length() - 1;
        while (true) {
            int[] iArr2 = this.textPos;
            if (i >= iArr2.length) {
                return;
            }
            iArr2[i] = this.desc.lastIndexOf("\u0000", length);
            length = this.textPos[i] - 1;
            i++;
        }
    }

    @Override // org.apache.poi.ss.format.CellFormatter
    public void formatValue(StringBuffer stringBuffer, Object obj) {
        int length = stringBuffer.length();
        String obj2 = obj.toString();
        if (obj instanceof Boolean) {
            obj2 = obj2.toUpperCase();
        }
        stringBuffer.append(this.desc);
        int i = 0;
        while (true) {
            int[] iArr = this.textPos;
            if (i >= iArr.length) {
                return;
            }
            int i2 = iArr[i] + length;
            stringBuffer.replace(i2, i2 + 1, obj2);
            i++;
        }
    }

    @Override // org.apache.poi.ss.format.CellFormatter
    public void simpleValue(StringBuffer stringBuffer, Object obj) {
        SIMPLE_TEXT.formatValue(stringBuffer, obj);
    }
}
