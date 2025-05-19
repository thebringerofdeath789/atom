package org.apache.poi.xssf.usermodel.helpers;

import java.util.Iterator;
import org.apache.poi.ss.formula.FormulaParser;
import org.apache.poi.ss.formula.FormulaRenderer;
import org.apache.poi.ss.formula.ptg.Ptg;
import org.apache.poi.ss.formula.ptg.Pxg;
import org.apache.poi.ss.formula.ptg.Pxg3D;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFEvaluationWorkbook;
import org.apache.poi.xssf.usermodel.XSSFName;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCellFormula;

/* loaded from: classes5.dex */
public final class XSSFFormulaUtils {
    private final XSSFEvaluationWorkbook _fpwb;
    private final XSSFWorkbook _wb;

    public XSSFFormulaUtils(XSSFWorkbook xSSFWorkbook) {
        this._wb = xSSFWorkbook;
        this._fpwb = XSSFEvaluationWorkbook.create(xSSFWorkbook);
    }

    public void updateSheetName(int i, String str, String str2) {
        for (int i2 = 0; i2 < this._wb.getNumberOfNames(); i2++) {
            XSSFName nameAt = this._wb.getNameAt(i2);
            if (nameAt.getSheetIndex() == -1 || nameAt.getSheetIndex() == i) {
                updateName(nameAt, str, str2);
            }
        }
        Iterator<XSSFSheet> it = this._wb.iterator();
        while (it.hasNext()) {
            Iterator<Row> it2 = it.next().iterator();
            while (it2.hasNext()) {
                for (Cell cell : it2.next()) {
                    if (cell.getCellType() == 2) {
                        updateFormula((XSSFCell) cell, str, str2);
                    }
                }
            }
        }
    }

    private void updateFormula(XSSFCell xSSFCell, String str, String str2) {
        String stringValue;
        CTCellFormula f = xSSFCell.getCTCell().getF();
        if (f == null || (stringValue = f.getStringValue()) == null || stringValue.length() <= 0) {
            return;
        }
        Ptg[] parse = FormulaParser.parse(stringValue, this._fpwb, 0, this._wb.getSheetIndex(xSSFCell.getSheet()));
        for (Ptg ptg : parse) {
            updatePtg(ptg, str, str2);
        }
        String formulaString = FormulaRenderer.toFormulaString(this._fpwb, parse);
        if (stringValue.equals(formulaString)) {
            return;
        }
        f.setStringValue(formulaString);
    }

    private void updateName(XSSFName xSSFName, String str, String str2) {
        String refersToFormula = xSSFName.getRefersToFormula();
        if (refersToFormula != null) {
            Ptg[] parse = FormulaParser.parse(refersToFormula, this._fpwb, 4, xSSFName.getSheetIndex());
            for (Ptg ptg : parse) {
                updatePtg(ptg, str, str2);
            }
            String formulaString = FormulaRenderer.toFormulaString(this._fpwb, parse);
            if (refersToFormula.equals(formulaString)) {
                return;
            }
            xSSFName.setRefersToFormula(formulaString);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void updatePtg(Ptg ptg, String str, String str2) {
        if (ptg instanceof Pxg) {
            Pxg pxg = (Pxg) ptg;
            if (pxg.getExternalWorkbookNumber() < 1) {
                if (pxg.getSheetName() != null && pxg.getSheetName().equals(str)) {
                    pxg.setSheetName(str2);
                }
                if (pxg instanceof Pxg3D) {
                    Pxg3D pxg3D = (Pxg3D) pxg;
                    if (pxg3D.getLastSheetName() == null || !pxg3D.getLastSheetName().equals(str)) {
                        return;
                    }
                    pxg3D.setLastSheetName(str2);
                }
            }
        }
    }
}
