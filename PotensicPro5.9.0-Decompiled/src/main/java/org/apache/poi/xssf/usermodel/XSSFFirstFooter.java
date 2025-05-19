package org.apache.poi.xssf.usermodel;

import org.apache.poi.ss.usermodel.Footer;
import org.apache.poi.xssf.usermodel.extensions.XSSFHeaderFooter;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTHeaderFooter;

/* loaded from: classes5.dex */
public class XSSFFirstFooter extends XSSFHeaderFooter implements Footer {
    protected XSSFFirstFooter(CTHeaderFooter cTHeaderFooter) {
        super(cTHeaderFooter);
        cTHeaderFooter.setDifferentFirst(true);
    }

    @Override // org.apache.poi.xssf.usermodel.extensions.XSSFHeaderFooter
    public String getText() {
        return getHeaderFooter().getFirstFooter();
    }

    @Override // org.apache.poi.xssf.usermodel.extensions.XSSFHeaderFooter
    public void setText(String str) {
        if (str == null) {
            getHeaderFooter().unsetFirstFooter();
        } else {
            getHeaderFooter().setFirstFooter(str);
        }
    }
}
