package org.apache.poi.xssf.usermodel;

import org.apache.poi.ss.usermodel.PatternFormatting;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTColor;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFill;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPatternFill;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STPatternType;

/* loaded from: classes5.dex */
public class XSSFPatternFormatting implements PatternFormatting {
    CTFill _fill;

    XSSFPatternFormatting(CTFill cTFill) {
        this._fill = cTFill;
    }

    @Override // org.apache.poi.ss.usermodel.PatternFormatting
    public short getFillBackgroundColor() {
        if (this._fill.isSetPatternFill()) {
            return (short) this._fill.getPatternFill().getBgColor().getIndexed();
        }
        return (short) 0;
    }

    @Override // org.apache.poi.ss.usermodel.PatternFormatting
    public short getFillForegroundColor() {
        if (this._fill.isSetPatternFill() && this._fill.getPatternFill().isSetFgColor()) {
            return (short) this._fill.getPatternFill().getFgColor().getIndexed();
        }
        return (short) 0;
    }

    @Override // org.apache.poi.ss.usermodel.PatternFormatting
    public short getFillPattern() {
        if (this._fill.isSetPatternFill() && this._fill.getPatternFill().isSetPatternType()) {
            return (short) (this._fill.getPatternFill().getPatternType().intValue() - 1);
        }
        return (short) 0;
    }

    @Override // org.apache.poi.ss.usermodel.PatternFormatting
    public void setFillBackgroundColor(short s) {
        CTPatternFill patternFill = this._fill.isSetPatternFill() ? this._fill.getPatternFill() : this._fill.addNewPatternFill();
        CTColor newInstance = CTColor.Factory.newInstance();
        newInstance.setIndexed(s);
        patternFill.setBgColor(newInstance);
    }

    @Override // org.apache.poi.ss.usermodel.PatternFormatting
    public void setFillForegroundColor(short s) {
        CTPatternFill patternFill = this._fill.isSetPatternFill() ? this._fill.getPatternFill() : this._fill.addNewPatternFill();
        CTColor newInstance = CTColor.Factory.newInstance();
        newInstance.setIndexed(s);
        patternFill.setFgColor(newInstance);
    }

    @Override // org.apache.poi.ss.usermodel.PatternFormatting
    public void setFillPattern(short s) {
        CTPatternFill patternFill = this._fill.isSetPatternFill() ? this._fill.getPatternFill() : this._fill.addNewPatternFill();
        if (s == 0) {
            patternFill.unsetPatternType();
        } else {
            patternFill.setPatternType(STPatternType.Enum.forInt(s + 1));
        }
    }
}
