package org.apache.poi.hssf.usermodel;

import org.apache.poi.hssf.record.CFRuleRecord;
import org.apache.poi.ss.usermodel.BorderFormatting;

/* loaded from: classes5.dex */
public final class HSSFBorderFormatting implements BorderFormatting {
    private final org.apache.poi.hssf.record.cf.BorderFormatting borderFormatting;
    private final CFRuleRecord cfRuleRecord;

    protected HSSFBorderFormatting(CFRuleRecord cFRuleRecord) {
        this.cfRuleRecord = cFRuleRecord;
        this.borderFormatting = cFRuleRecord.getBorderFormatting();
    }

    protected org.apache.poi.hssf.record.cf.BorderFormatting getBorderFormattingBlock() {
        return this.borderFormatting;
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public short getBorderBottom() {
        return (short) this.borderFormatting.getBorderBottom();
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public short getBorderDiagonal() {
        return (short) this.borderFormatting.getBorderDiagonal();
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public short getBorderLeft() {
        return (short) this.borderFormatting.getBorderLeft();
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public short getBorderRight() {
        return (short) this.borderFormatting.getBorderRight();
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public short getBorderTop() {
        return (short) this.borderFormatting.getBorderTop();
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public short getBottomBorderColor() {
        return (short) this.borderFormatting.getBottomBorderColor();
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public short getDiagonalBorderColor() {
        return (short) this.borderFormatting.getDiagonalBorderColor();
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public short getLeftBorderColor() {
        return (short) this.borderFormatting.getLeftBorderColor();
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public short getRightBorderColor() {
        return (short) this.borderFormatting.getRightBorderColor();
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public short getTopBorderColor() {
        return (short) this.borderFormatting.getTopBorderColor();
    }

    public boolean isBackwardDiagonalOn() {
        return this.borderFormatting.isBackwardDiagonalOn();
    }

    public boolean isForwardDiagonalOn() {
        return this.borderFormatting.isForwardDiagonalOn();
    }

    public void setBackwardDiagonalOn(boolean z) {
        this.borderFormatting.setBackwardDiagonalOn(z);
        if (z) {
            this.cfRuleRecord.setTopLeftBottomRightBorderModified(z);
        }
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public void setBorderBottom(short s) {
        this.borderFormatting.setBorderBottom(s);
        if (s != 0) {
            this.cfRuleRecord.setBottomBorderModified(true);
        }
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public void setBorderDiagonal(short s) {
        this.borderFormatting.setBorderDiagonal(s);
        if (s != 0) {
            this.cfRuleRecord.setBottomLeftTopRightBorderModified(true);
            this.cfRuleRecord.setTopLeftBottomRightBorderModified(true);
        }
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public void setBorderLeft(short s) {
        this.borderFormatting.setBorderLeft(s);
        if (s != 0) {
            this.cfRuleRecord.setLeftBorderModified(true);
        }
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public void setBorderRight(short s) {
        this.borderFormatting.setBorderRight(s);
        if (s != 0) {
            this.cfRuleRecord.setRightBorderModified(true);
        }
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public void setBorderTop(short s) {
        this.borderFormatting.setBorderTop(s);
        if (s != 0) {
            this.cfRuleRecord.setTopBorderModified(true);
        }
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public void setBottomBorderColor(short s) {
        this.borderFormatting.setBottomBorderColor(s);
        if (s != 0) {
            this.cfRuleRecord.setBottomBorderModified(true);
        }
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public void setDiagonalBorderColor(short s) {
        this.borderFormatting.setDiagonalBorderColor(s);
        if (s != 0) {
            this.cfRuleRecord.setBottomLeftTopRightBorderModified(true);
            this.cfRuleRecord.setTopLeftBottomRightBorderModified(true);
        }
    }

    public void setForwardDiagonalOn(boolean z) {
        this.borderFormatting.setForwardDiagonalOn(z);
        if (z) {
            this.cfRuleRecord.setBottomLeftTopRightBorderModified(z);
        }
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public void setLeftBorderColor(short s) {
        this.borderFormatting.setLeftBorderColor(s);
        if (s != 0) {
            this.cfRuleRecord.setLeftBorderModified(true);
        }
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public void setRightBorderColor(short s) {
        this.borderFormatting.setRightBorderColor(s);
        if (s != 0) {
            this.cfRuleRecord.setRightBorderModified(true);
        }
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public void setTopBorderColor(short s) {
        this.borderFormatting.setTopBorderColor(s);
        if (s != 0) {
            this.cfRuleRecord.setTopBorderModified(true);
        }
    }
}
