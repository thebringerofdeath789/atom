package org.apache.poi.xssf.usermodel.extensions;

import org.apache.poi.util.Internal;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTColor;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFill;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPatternFill;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STPatternType;

/* loaded from: classes5.dex */
public final class XSSFCellFill {
    private CTFill _fill;

    public XSSFCellFill(CTFill cTFill) {
        this._fill = cTFill;
    }

    public XSSFCellFill() {
        this._fill = CTFill.Factory.newInstance();
    }

    public XSSFColor getFillBackgroundColor() {
        CTColor bgColor;
        CTPatternFill patternFill = this._fill.getPatternFill();
        if (patternFill == null || (bgColor = patternFill.getBgColor()) == null) {
            return null;
        }
        return new XSSFColor(bgColor);
    }

    public void setFillBackgroundColor(int i) {
        CTPatternFill ensureCTPatternFill = ensureCTPatternFill();
        (ensureCTPatternFill.isSetBgColor() ? ensureCTPatternFill.getBgColor() : ensureCTPatternFill.addNewBgColor()).setIndexed(i);
    }

    public void setFillBackgroundColor(XSSFColor xSSFColor) {
        ensureCTPatternFill().setBgColor(xSSFColor.getCTColor());
    }

    public XSSFColor getFillForegroundColor() {
        CTColor fgColor;
        CTPatternFill patternFill = this._fill.getPatternFill();
        if (patternFill == null || (fgColor = patternFill.getFgColor()) == null) {
            return null;
        }
        return new XSSFColor(fgColor);
    }

    public void setFillForegroundColor(int i) {
        CTPatternFill ensureCTPatternFill = ensureCTPatternFill();
        (ensureCTPatternFill.isSetFgColor() ? ensureCTPatternFill.getFgColor() : ensureCTPatternFill.addNewFgColor()).setIndexed(i);
    }

    public void setFillForegroundColor(XSSFColor xSSFColor) {
        ensureCTPatternFill().setFgColor(xSSFColor.getCTColor());
    }

    public STPatternType.Enum getPatternType() {
        CTPatternFill patternFill = this._fill.getPatternFill();
        if (patternFill == null) {
            return null;
        }
        return patternFill.getPatternType();
    }

    public void setPatternType(STPatternType.Enum r2) {
        ensureCTPatternFill().setPatternType(r2);
    }

    private CTPatternFill ensureCTPatternFill() {
        CTPatternFill patternFill = this._fill.getPatternFill();
        return patternFill == null ? this._fill.addNewPatternFill() : patternFill;
    }

    @Internal
    public CTFill getCTFill() {
        return this._fill;
    }

    public int hashCode() {
        return this._fill.toString().hashCode();
    }

    public boolean equals(Object obj) {
        if (obj instanceof XSSFCellFill) {
            return this._fill.toString().equals(((XSSFCellFill) obj).getCTFill().toString());
        }
        return false;
    }
}
