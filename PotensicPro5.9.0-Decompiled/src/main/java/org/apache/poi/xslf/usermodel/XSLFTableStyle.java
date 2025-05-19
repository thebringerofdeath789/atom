package org.apache.poi.xslf.usermodel;

import org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle;

/* loaded from: classes5.dex */
public class XSLFTableStyle {
    private CTTableStyle _tblStyle;

    XSLFTableStyle(CTTableStyle cTTableStyle) {
        this._tblStyle = cTTableStyle;
    }

    public CTTableStyle getXmlObject() {
        return this._tblStyle;
    }

    public String getStyleName() {
        return this._tblStyle.getStyleName();
    }

    public String getStyleId() {
        return this._tblStyle.getStyleId();
    }
}
