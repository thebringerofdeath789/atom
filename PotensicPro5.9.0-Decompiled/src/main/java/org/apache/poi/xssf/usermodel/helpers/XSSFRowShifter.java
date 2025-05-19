package org.apache.poi.xssf.usermodel.helpers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.formula.FormulaParseException;
import org.apache.poi.ss.formula.FormulaParser;
import org.apache.poi.ss.formula.FormulaRenderer;
import org.apache.poi.ss.formula.FormulaShifter;
import org.apache.poi.ss.formula.ptg.AreaErrPtg;
import org.apache.poi.ss.formula.ptg.AreaPtg;
import org.apache.poi.ss.formula.ptg.Ptg;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.util.POILogFactory;
import org.apache.poi.util.POILogger;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFEvaluationWorkbook;
import org.apache.poi.xssf.usermodel.XSSFName;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCell;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCellFormula;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTConditionalFormatting;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STCellFormulaType;

/* loaded from: classes5.dex */
public final class XSSFRowShifter {
    private static POILogger logger = POILogFactory.getLogger((Class<?>) XSSFRowShifter.class);
    private final XSSFSheet sheet;

    public XSSFRowShifter(XSSFSheet xSSFSheet) {
        this.sheet = xSSFSheet;
    }

    public List<CellRangeAddress> shiftMerged(int i, int i2, int i3) {
        ArrayList arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        int numMergedRegions = this.sheet.getNumMergedRegions();
        for (int i4 = 0; i4 < numMergedRegions; i4++) {
            CellRangeAddress mergedRegion = this.sheet.getMergedRegion(i4);
            boolean z = true;
            boolean z2 = mergedRegion.getFirstRow() >= i || mergedRegion.getLastRow() >= i;
            if (mergedRegion.getFirstRow() > i2 && mergedRegion.getLastRow() > i2) {
                z = false;
            }
            if (z2 && z && !containsCell(mergedRegion, i - 1, 0) && !containsCell(mergedRegion, i2 + 1, 0)) {
                mergedRegion.setFirstRow(mergedRegion.getFirstRow() + i3);
                mergedRegion.setLastRow(mergedRegion.getLastRow() + i3);
                arrayList.add(mergedRegion);
                hashSet.add(Integer.valueOf(i4));
            }
        }
        if (!hashSet.isEmpty()) {
            this.sheet.removeMergedRegions(hashSet);
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            this.sheet.addMergedRegion((CellRangeAddress) it.next());
        }
        return arrayList;
    }

    private static boolean containsCell(CellRangeAddress cellRangeAddress, int i, int i2) {
        return cellRangeAddress.getFirstRow() <= i && cellRangeAddress.getLastRow() >= i && cellRangeAddress.getFirstColumn() <= i2 && cellRangeAddress.getLastColumn() >= i2;
    }

    public void updateNamedRanges(FormulaShifter formulaShifter) {
        XSSFWorkbook workbook = this.sheet.getWorkbook();
        XSSFEvaluationWorkbook create = XSSFEvaluationWorkbook.create(workbook);
        for (int i = 0; i < workbook.getNumberOfNames(); i++) {
            XSSFName nameAt = workbook.getNameAt(i);
            String refersToFormula = nameAt.getRefersToFormula();
            int sheetIndex = nameAt.getSheetIndex();
            Ptg[] parse = FormulaParser.parse(refersToFormula, create, 4, sheetIndex);
            if (formulaShifter.adjustFormula(parse, sheetIndex)) {
                nameAt.setRefersToFormula(FormulaRenderer.toFormulaString(create, parse));
            }
        }
    }

    public void updateFormulas(FormulaShifter formulaShifter) {
        updateSheetFormulas(this.sheet, formulaShifter);
        Iterator<XSSFSheet> it = this.sheet.getWorkbook().iterator();
        while (it.hasNext()) {
            XSSFSheet next = it.next();
            if (this.sheet != next) {
                updateSheetFormulas(next, formulaShifter);
            }
        }
    }

    private void updateSheetFormulas(XSSFSheet xSSFSheet, FormulaShifter formulaShifter) {
        Iterator<Row> it = xSSFSheet.iterator();
        while (it.hasNext()) {
            updateRowFormulas((XSSFRow) it.next(), formulaShifter);
        }
    }

    private void updateRowFormulas(XSSFRow xSSFRow, FormulaShifter formulaShifter) {
        String shiftFormula;
        String shiftFormula2;
        Iterator<Cell> it = xSSFRow.iterator();
        while (it.hasNext()) {
            CTCell cTCell = ((XSSFCell) it.next()).getCTCell();
            if (cTCell.isSetF()) {
                CTCellFormula f = cTCell.getF();
                String stringValue = f.getStringValue();
                if (stringValue.length() > 0 && (shiftFormula2 = shiftFormula(xSSFRow, stringValue, formulaShifter)) != null) {
                    f.setStringValue(shiftFormula2);
                    if (f.getT() == STCellFormulaType.SHARED) {
                        xSSFRow.getSheet().getSharedFormula((int) f.getSi()).setStringValue(shiftFormula2);
                    }
                }
                if (f.isSetRef() && (shiftFormula = shiftFormula(xSSFRow, f.getRef(), formulaShifter)) != null) {
                    f.setRef(shiftFormula);
                }
            }
        }
    }

    private static String shiftFormula(XSSFRow xSSFRow, String str, FormulaShifter formulaShifter) {
        XSSFSheet sheet = xSSFRow.getSheet();
        XSSFWorkbook workbook = sheet.getWorkbook();
        int sheetIndex = workbook.getSheetIndex(sheet);
        XSSFEvaluationWorkbook create = XSSFEvaluationWorkbook.create(workbook);
        try {
            Ptg[] parse = FormulaParser.parse(str, create, 0, sheetIndex);
            if (formulaShifter.adjustFormula(parse, sheetIndex)) {
                return FormulaRenderer.toFormulaString(create, parse);
            }
            return null;
        } catch (FormulaParseException e) {
            logger.log(5, (Object) "Error shifting formula on row ", (Object) Integer.valueOf(xSSFRow.getRowNum()), (Throwable) e);
            return str;
        }
    }

    public void updateConditionalFormatting(FormulaShifter formulaShifter) {
        XSSFWorkbook workbook = this.sheet.getWorkbook();
        int sheetIndex = workbook.getSheetIndex(this.sheet);
        XSSFEvaluationWorkbook create = XSSFEvaluationWorkbook.create(workbook);
        CTWorksheet cTWorksheet = this.sheet.getCTWorksheet();
        CTConditionalFormatting[] conditionalFormattingArray = cTWorksheet.getConditionalFormattingArray();
        for (int length = conditionalFormattingArray.length - 1; length >= 0; length--) {
            CTConditionalFormatting cTConditionalFormatting = conditionalFormattingArray[length];
            ArrayList arrayList = new ArrayList();
            Iterator it = cTConditionalFormatting.getSqref().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                for (String str : it.next().toString().split(StringUtils.SPACE)) {
                    arrayList.add(CellRangeAddress.valueOf(str));
                }
            }
            ArrayList arrayList2 = new ArrayList();
            Iterator it2 = arrayList.iterator();
            boolean z = false;
            while (it2.hasNext()) {
                CellRangeAddress cellRangeAddress = (CellRangeAddress) it2.next();
                CellRangeAddress shiftRange = shiftRange(formulaShifter, cellRangeAddress, sheetIndex);
                if (shiftRange != null) {
                    arrayList2.add(shiftRange);
                    if (shiftRange != cellRangeAddress) {
                    }
                }
                z = true;
            }
            if (z) {
                if (arrayList2.size() == 0) {
                    cTWorksheet.removeConditionalFormatting(length);
                } else {
                    ArrayList arrayList3 = new ArrayList();
                    Iterator it3 = arrayList2.iterator();
                    while (it3.hasNext()) {
                        arrayList3.add(((CellRangeAddress) it3.next()).formatAsString());
                    }
                    cTConditionalFormatting.setSqref(arrayList3);
                }
            }
            for (CTCfRule cTCfRule : cTConditionalFormatting.getCfRuleArray()) {
                String[] formulaArray = cTCfRule.getFormulaArray();
                for (int i = 0; i < formulaArray.length; i++) {
                    Ptg[] parse = FormulaParser.parse(formulaArray[i], create, 0, sheetIndex);
                    if (formulaShifter.adjustFormula(parse, sheetIndex)) {
                        cTCfRule.setFormulaArray(i, FormulaRenderer.toFormulaString(create, parse));
                    }
                }
            }
        }
    }

    private static CellRangeAddress shiftRange(FormulaShifter formulaShifter, CellRangeAddress cellRangeAddress, int i) {
        Ptg[] ptgArr = {new AreaPtg(cellRangeAddress.getFirstRow(), cellRangeAddress.getLastRow(), cellRangeAddress.getFirstColumn(), cellRangeAddress.getLastColumn(), false, false, false, false)};
        if (!formulaShifter.adjustFormula(ptgArr, i)) {
            return cellRangeAddress;
        }
        Ptg ptg = ptgArr[0];
        if (ptg instanceof AreaPtg) {
            AreaPtg areaPtg = (AreaPtg) ptg;
            return new CellRangeAddress(areaPtg.getFirstRow(), areaPtg.getLastRow(), areaPtg.getFirstColumn(), areaPtg.getLastColumn());
        }
        if (ptg instanceof AreaErrPtg) {
            return null;
        }
        throw new IllegalStateException("Unexpected shifted ptg class (" + ptg.getClass().getName() + ")");
    }
}
