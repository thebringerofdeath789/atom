package org.apache.poi.hssf.usermodel;

import androidx.core.net.MailTo;
import org.apache.poi.hssf.record.HyperlinkRecord;
import org.apache.poi.ss.usermodel.Hyperlink;

/* loaded from: classes5.dex */
public class HSSFHyperlink implements Hyperlink {
    public static final int LINK_DOCUMENT = 2;
    public static final int LINK_EMAIL = 3;
    public static final int LINK_FILE = 4;
    public static final int LINK_URL = 1;
    protected int link_type;
    protected HyperlinkRecord record;

    public HSSFHyperlink(int i) {
        this.record = null;
        this.link_type = i;
        HyperlinkRecord hyperlinkRecord = new HyperlinkRecord();
        this.record = hyperlinkRecord;
        if (i != 1) {
            if (i == 2) {
                hyperlinkRecord.newDocumentLink();
                return;
            } else if (i != 3) {
                if (i != 4) {
                    return;
                }
                hyperlinkRecord.newFileLink();
                return;
            }
        }
        hyperlinkRecord.newUrlLink();
    }

    protected HSSFHyperlink(HyperlinkRecord hyperlinkRecord) {
        this.record = null;
        this.record = hyperlinkRecord;
        if (hyperlinkRecord.isFileLink()) {
            this.link_type = 4;
            return;
        }
        if (hyperlinkRecord.isDocumentLink()) {
            this.link_type = 2;
        } else if (hyperlinkRecord.getAddress() != null && hyperlinkRecord.getAddress().startsWith(MailTo.MAILTO_SCHEME)) {
            this.link_type = 3;
        } else {
            this.link_type = 1;
        }
    }

    @Override // org.apache.poi.ss.usermodel.Hyperlink
    public int getFirstRow() {
        return this.record.getFirstRow();
    }

    @Override // org.apache.poi.ss.usermodel.Hyperlink
    public void setFirstRow(int i) {
        this.record.setFirstRow(i);
    }

    @Override // org.apache.poi.ss.usermodel.Hyperlink
    public int getLastRow() {
        return this.record.getLastRow();
    }

    @Override // org.apache.poi.ss.usermodel.Hyperlink
    public void setLastRow(int i) {
        this.record.setLastRow(i);
    }

    @Override // org.apache.poi.ss.usermodel.Hyperlink
    public int getFirstColumn() {
        return this.record.getFirstColumn();
    }

    @Override // org.apache.poi.ss.usermodel.Hyperlink
    public void setFirstColumn(int i) {
        this.record.setFirstColumn((short) i);
    }

    @Override // org.apache.poi.ss.usermodel.Hyperlink
    public int getLastColumn() {
        return this.record.getLastColumn();
    }

    @Override // org.apache.poi.ss.usermodel.Hyperlink
    public void setLastColumn(int i) {
        this.record.setLastColumn((short) i);
    }

    @Override // org.apache.poi.common.usermodel.Hyperlink
    public String getAddress() {
        return this.record.getAddress();
    }

    public String getTextMark() {
        return this.record.getTextMark();
    }

    public void setTextMark(String str) {
        this.record.setTextMark(str);
    }

    public String getShortFilename() {
        return this.record.getShortFilename();
    }

    public void setShortFilename(String str) {
        this.record.setShortFilename(str);
    }

    @Override // org.apache.poi.common.usermodel.Hyperlink
    public void setAddress(String str) {
        this.record.setAddress(str);
    }

    @Override // org.apache.poi.common.usermodel.Hyperlink
    public String getLabel() {
        return this.record.getLabel();
    }

    @Override // org.apache.poi.common.usermodel.Hyperlink
    public void setLabel(String str) {
        this.record.setLabel(str);
    }

    @Override // org.apache.poi.common.usermodel.Hyperlink
    public int getType() {
        return this.link_type;
    }
}
