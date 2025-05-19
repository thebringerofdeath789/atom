package org.apache.poi.hssf.usermodel;

import org.apache.poi.hssf.record.FooterRecord;
import org.apache.poi.hssf.record.aggregates.PageSettingsBlock;
import org.apache.poi.ss.usermodel.Footer;

/* loaded from: classes5.dex */
public final class HSSFFooter extends HeaderFooter implements Footer {
    private final PageSettingsBlock _psb;

    protected HSSFFooter(PageSettingsBlock pageSettingsBlock) {
        this._psb = pageSettingsBlock;
    }

    @Override // org.apache.poi.hssf.usermodel.HeaderFooter
    protected String getRawText() {
        FooterRecord footer = this._psb.getFooter();
        return footer == null ? "" : footer.getText();
    }

    @Override // org.apache.poi.hssf.usermodel.HeaderFooter
    protected void setHeaderFooterText(String str) {
        FooterRecord footer = this._psb.getFooter();
        if (footer == null) {
            this._psb.setFooter(new FooterRecord(str));
        } else {
            footer.setText(str);
        }
    }
}
