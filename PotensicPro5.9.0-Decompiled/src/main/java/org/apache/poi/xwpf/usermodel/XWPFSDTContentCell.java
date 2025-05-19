package org.apache.poi.xwpf.usermodel;

import aavax.xml.namespace.QName;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import org.apache.xmlbeans.XmlCursor;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell;

/* loaded from: classes5.dex */
public class XWPFSDTContentCell implements ISDTContent {
    private String text;

    public XWPFSDTContentCell(CTSdtContentCell cTSdtContentCell, XWPFTableRow xWPFTableRow, IBody iBody) {
        this.text = "";
        StringBuilder sb = new StringBuilder();
        XmlCursor newCursor = cTSdtContentCell.newCursor();
        int i = 1;
        int i2 = 0;
        int i3 = 0;
        while (newCursor.hasNextToken() && i > 0) {
            if (newCursor.toNextToken().isText()) {
                sb.append(newCursor.getTextValue());
            } else if (isStartToken(newCursor, "tr")) {
                i2 = 0;
                i3 = 0;
            } else if (isStartToken(newCursor, "tc")) {
                int i4 = i2 + 1;
                if (i2 > 0) {
                    sb.append("\t");
                }
                i2 = i4;
                i3 = 0;
            } else if (isStartToken(newCursor, TtmlNode.TAG_P) || isStartToken(newCursor, "tbl") || isStartToken(newCursor, "sdt")) {
                if (i3 > 0) {
                    sb.append("\n");
                }
                i3++;
            }
            if (newCursor.isStart()) {
                i++;
            } else if (newCursor.isEnd()) {
                i--;
            }
        }
        this.text = sb.toString();
    }

    private boolean isStartToken(XmlCursor xmlCursor, String str) {
        QName name;
        return xmlCursor.isStart() && (name = xmlCursor.getName()) != null && name.getLocalPart() != null && name.getLocalPart().equals(str);
    }

    @Override // org.apache.poi.xwpf.usermodel.ISDTContent
    public String getText() {
        return this.text;
    }

    @Override // org.apache.poi.xwpf.usermodel.ISDTContent
    public String toString() {
        return getText();
    }
}
