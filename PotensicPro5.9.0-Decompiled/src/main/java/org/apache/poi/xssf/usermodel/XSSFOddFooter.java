package org.apache.poi.xssf.usermodel;

import org.apache.poi.ss.usermodel.Footer;
import org.apache.poi.xssf.usermodel.extensions.XSSFHeaderFooter;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTHeaderFooter;

/* loaded from: classes5.dex */
public class XSSFOddFooter extends XSSFHeaderFooter implements Footer {
    public XSSFOddFooter(CTHeaderFooter cTHeaderFooter) {
        super(cTHeaderFooter);
    }

    @Override // org.apache.poi.xssf.usermodel.extensions.XSSFHeaderFooter
    public String getText() {
        return getHeaderFooter().getOddFooter();
    }

    @Override // org.apache.poi.xssf.usermodel.extensions.XSSFHeaderFooter
    public void setText(String str) {
        if (str == null) {
            getHeaderFooter().unsetOddFooter();
        } else {
            getHeaderFooter().setOddFooter(str);
        }
    }
}
