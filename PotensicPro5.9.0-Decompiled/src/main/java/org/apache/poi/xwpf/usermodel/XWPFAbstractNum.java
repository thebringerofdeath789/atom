package org.apache.poi.xwpf.usermodel;

import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTAbstractNum;

/* loaded from: classes5.dex */
public class XWPFAbstractNum {
    private CTAbstractNum ctAbstractNum;
    protected XWPFNumbering numbering;

    protected XWPFAbstractNum() {
        this.ctAbstractNum = null;
        this.numbering = null;
    }

    public XWPFAbstractNum(CTAbstractNum cTAbstractNum) {
        this.ctAbstractNum = cTAbstractNum;
    }

    public XWPFAbstractNum(CTAbstractNum cTAbstractNum, XWPFNumbering xWPFNumbering) {
        this.ctAbstractNum = cTAbstractNum;
        this.numbering = xWPFNumbering;
    }

    public CTAbstractNum getAbstractNum() {
        return this.ctAbstractNum;
    }

    public XWPFNumbering getNumbering() {
        return this.numbering;
    }

    public CTAbstractNum getCTAbstractNum() {
        return this.ctAbstractNum;
    }

    public void setNumbering(XWPFNumbering xWPFNumbering) {
        this.numbering = xWPFNumbering;
    }
}
