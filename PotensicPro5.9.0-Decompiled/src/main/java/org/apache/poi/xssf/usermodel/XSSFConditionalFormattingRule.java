package org.apache.poi.xssf.usermodel;

import org.apache.poi.ss.usermodel.ConditionalFormattingRule;
import org.apache.poi.xssf.model.StylesTable;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorder;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDxf;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFill;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFont;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STConditionalFormattingOperator;

/* loaded from: classes5.dex */
public class XSSFConditionalFormattingRule implements ConditionalFormattingRule {
    private final CTCfRule _cfRule;
    private XSSFSheet _sh;

    XSSFConditionalFormattingRule(XSSFSheet xSSFSheet) {
        this._cfRule = CTCfRule.Factory.newInstance();
        this._sh = xSSFSheet;
    }

    XSSFConditionalFormattingRule(XSSFSheet xSSFSheet, CTCfRule cTCfRule) {
        this._cfRule = cTCfRule;
        this._sh = xSSFSheet;
    }

    CTCfRule getCTCfRule() {
        return this._cfRule;
    }

    CTDxf getDxf(boolean z) {
        StylesTable stylesSource = this._sh.getWorkbook().getStylesSource();
        CTDxf dxfAt = (stylesSource._getDXfsSize() <= 0 || !this._cfRule.isSetDxfId()) ? null : stylesSource.getDxfAt((int) this._cfRule.getDxfId());
        if (!z || dxfAt != null) {
            return dxfAt;
        }
        CTDxf newInstance = CTDxf.Factory.newInstance();
        this._cfRule.setDxfId(stylesSource.putDxf(newInstance) - 1);
        return newInstance;
    }

    @Override // org.apache.poi.ss.usermodel.ConditionalFormattingRule
    public XSSFBorderFormatting createBorderFormatting() {
        CTBorder border;
        CTDxf dxf = getDxf(true);
        if (!dxf.isSetBorder()) {
            border = dxf.addNewBorder();
        } else {
            border = dxf.getBorder();
        }
        return new XSSFBorderFormatting(border);
    }

    @Override // org.apache.poi.ss.usermodel.ConditionalFormattingRule
    public XSSFBorderFormatting getBorderFormatting() {
        CTDxf dxf = getDxf(false);
        if (dxf == null || !dxf.isSetBorder()) {
            return null;
        }
        return new XSSFBorderFormatting(dxf.getBorder());
    }

    @Override // org.apache.poi.ss.usermodel.ConditionalFormattingRule
    public XSSFFontFormatting createFontFormatting() {
        CTFont font;
        CTDxf dxf = getDxf(true);
        if (!dxf.isSetFont()) {
            font = dxf.addNewFont();
        } else {
            font = dxf.getFont();
        }
        return new XSSFFontFormatting(font);
    }

    @Override // org.apache.poi.ss.usermodel.ConditionalFormattingRule
    public XSSFFontFormatting getFontFormatting() {
        CTDxf dxf = getDxf(false);
        if (dxf == null || !dxf.isSetFont()) {
            return null;
        }
        return new XSSFFontFormatting(dxf.getFont());
    }

    @Override // org.apache.poi.ss.usermodel.ConditionalFormattingRule
    public XSSFPatternFormatting createPatternFormatting() {
        CTFill fill;
        CTDxf dxf = getDxf(true);
        if (!dxf.isSetFill()) {
            fill = dxf.addNewFill();
        } else {
            fill = dxf.getFill();
        }
        return new XSSFPatternFormatting(fill);
    }

    @Override // org.apache.poi.ss.usermodel.ConditionalFormattingRule
    public XSSFPatternFormatting getPatternFormatting() {
        CTDxf dxf = getDxf(false);
        if (dxf == null || !dxf.isSetFill()) {
            return null;
        }
        return new XSSFPatternFormatting(dxf.getFill());
    }

    @Override // org.apache.poi.ss.usermodel.ConditionalFormattingRule
    public byte getConditionType() {
        int intValue = this._cfRule.getType().intValue();
        if (intValue != 1) {
            return intValue != 2 ? (byte) 0 : (byte) 1;
        }
        return (byte) 2;
    }

    @Override // org.apache.poi.ss.usermodel.ConditionalFormattingRule
    public byte getComparisonOperation() {
        STConditionalFormattingOperator.Enum operator = this._cfRule.getOperator();
        if (operator == null) {
            return (byte) 0;
        }
        switch (operator.intValue()) {
        }
        return (byte) 0;
    }

    @Override // org.apache.poi.ss.usermodel.ConditionalFormattingRule
    public String getFormula1() {
        if (this._cfRule.sizeOfFormulaArray() > 0) {
            return this._cfRule.getFormulaArray(0);
        }
        return null;
    }

    @Override // org.apache.poi.ss.usermodel.ConditionalFormattingRule
    public String getFormula2() {
        if (this._cfRule.sizeOfFormulaArray() == 2) {
            return this._cfRule.getFormulaArray(1);
        }
        return null;
    }
}
