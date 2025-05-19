package org.apache.poi.xssf.usermodel;

import org.apache.poi.ss.usermodel.Footer;
import org.apache.poi.xssf.usermodel.extensions.XSSFHeaderFooter;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTHeaderFooter;

/* loaded from: classes5.dex */
public class XSSFEvenFooter extends XSSFHeaderFooter implements Footer {
    public XSSFEvenFooter(CTHeaderFooter cTHeaderFooter) {
        super(cTHeaderFooter);
        cTHeaderFooter.setDifferentOddEven(true);
    }

    @Override // org.apache.poi.xssf.usermodel.extensions.XSSFHeaderFooter
    public String getText() {
        return getHeaderFooter().getEvenFooter();
    }

    @Override // org.apache.poi.xssf.usermodel.extensions.XSSFHeaderFooter
    public void setText(String str) {
        if (str == null) {
            getHeaderFooter().unsetEvenFooter();
        } else {
            getHeaderFooter().setEvenFooter(str);
        }
    }
}
