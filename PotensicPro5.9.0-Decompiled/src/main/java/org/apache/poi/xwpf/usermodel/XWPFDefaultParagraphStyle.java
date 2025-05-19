package org.apache.poi.xwpf.usermodel;

import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPr;

/* loaded from: classes5.dex */
public class XWPFDefaultParagraphStyle {
    private CTPPr ppr;

    public XWPFDefaultParagraphStyle(CTPPr cTPPr) {
        this.ppr = cTPPr;
    }

    protected CTPPr getPPr() {
        return this.ppr;
    }

    public int getSpacingAfter() {
        if (this.ppr.isSetSpacing()) {
            return this.ppr.getSpacing().getAfter().intValue();
        }
        return -1;
    }
}
