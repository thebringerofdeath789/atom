package org.apache.poi.xwpf.usermodel;

import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNum;

/* loaded from: classes5.dex */
public class XWPFNum {
    private CTNum ctNum;
    protected XWPFNumbering numbering;

    public XWPFNum() {
        this.ctNum = null;
        this.numbering = null;
    }

    public XWPFNum(CTNum cTNum) {
        this.ctNum = cTNum;
        this.numbering = null;
    }

    public XWPFNum(XWPFNumbering xWPFNumbering) {
        this.ctNum = null;
        this.numbering = xWPFNumbering;
    }

    public XWPFNum(CTNum cTNum, XWPFNumbering xWPFNumbering) {
        this.ctNum = cTNum;
        this.numbering = xWPFNumbering;
    }

    public XWPFNumbering getNumbering() {
        return this.numbering;
    }

    public CTNum getCTNum() {
        return this.ctNum;
    }

    public void setNumbering(XWPFNumbering xWPFNumbering) {
        this.numbering = xWPFNumbering;
    }

    public void setCTNum(CTNum cTNum) {
        this.ctNum = cTNum;
    }
}
