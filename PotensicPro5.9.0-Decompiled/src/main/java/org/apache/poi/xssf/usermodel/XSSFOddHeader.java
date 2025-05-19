package org.apache.poi.xssf.usermodel;

import org.apache.poi.ss.usermodel.Header;
import org.apache.poi.xssf.usermodel.extensions.XSSFHeaderFooter;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTHeaderFooter;

/* loaded from: classes5.dex */
public class XSSFOddHeader extends XSSFHeaderFooter implements Header {
    protected XSSFOddHeader(CTHeaderFooter cTHeaderFooter) {
        super(cTHeaderFooter);
    }

    @Override // org.apache.poi.xssf.usermodel.extensions.XSSFHeaderFooter
    public String getText() {
        return getHeaderFooter().getOddHeader();
    }

    @Override // org.apache.poi.xssf.usermodel.extensions.XSSFHeaderFooter
    public void setText(String str) {
        if (str == null) {
            getHeaderFooter().unsetOddHeader();
        } else {
            getHeaderFooter().setOddHeader(str);
        }
    }
}
