package org.apache.poi.xwpf.usermodel;

import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHyperlink;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR;

/* loaded from: classes5.dex */
public class XWPFHyperlinkRun extends XWPFRun {
    private CTHyperlink hyperlink;

    public XWPFHyperlinkRun(CTHyperlink cTHyperlink, CTR ctr, IRunBody iRunBody) {
        super(ctr, iRunBody);
        this.hyperlink = cTHyperlink;
    }

    public CTHyperlink getCTHyperlink() {
        return this.hyperlink;
    }

    public String getAnchor() {
        return this.hyperlink.getAnchor();
    }

    public String getHyperlinkId() {
        return this.hyperlink.getId();
    }

    public void setHyperlinkId(String str) {
        this.hyperlink.setId(str);
    }

    public XWPFHyperlink getHyperlink(XWPFDocument xWPFDocument) {
        String hyperlinkId = getHyperlinkId();
        if (hyperlinkId == null) {
            return null;
        }
        return xWPFDocument.getHyperlinkByID(hyperlinkId);
    }
}
