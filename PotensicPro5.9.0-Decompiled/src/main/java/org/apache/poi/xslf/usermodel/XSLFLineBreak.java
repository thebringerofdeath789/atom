package org.apache.poi.xslf.usermodel;

import org.openxmlformats.schemas.drawingml.x2006.main.CTRegularTextRun;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextCharacterProperties;

/* loaded from: classes5.dex */
class XSLFLineBreak extends XSLFTextRun {
    private final CTTextCharacterProperties _brProps;

    XSLFLineBreak(CTRegularTextRun cTRegularTextRun, XSLFTextParagraph xSLFTextParagraph, CTTextCharacterProperties cTTextCharacterProperties) {
        super(cTRegularTextRun, xSLFTextParagraph);
        this._brProps = cTTextCharacterProperties;
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFTextRun
    protected CTTextCharacterProperties getRPr() {
        return this._brProps;
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFTextRun
    public void setText(String str) {
        throw new IllegalStateException("You cannot change text of a line break, it is always '\\n'");
    }
}
