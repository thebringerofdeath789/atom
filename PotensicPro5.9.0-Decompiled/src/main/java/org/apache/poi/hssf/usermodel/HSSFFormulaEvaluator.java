package org.apache.poi.hssf.usermodel;

import java.util.Iterator;
import java.util.Map;
import org.apache.poi.ss.formula.CollaboratingWorkbooksEnvironment;
import org.apache.poi.ss.formula.IStabilityClassifier;
import org.apache.poi.ss.formula.WorkbookEvaluator;
import org.apache.poi.ss.formula.WorkbookEvaluatorProvider;
import org.apache.poi.ss.formula.eval.BoolEval;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.NumericValueEval;
import org.apache.poi.ss.formula.eval.StringValueEval;
import org.apache.poi.ss.formula.eval.ValueEval;
import org.apache.poi.ss.formula.udf.UDFFinder;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellValue;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;

/* loaded from: classes5.dex */
public class HSSFFormulaEvaluator implements FormulaEvaluator, WorkbookEvaluatorProvider {
    private HSSFWorkbook _book;
    private WorkbookEvaluator _bookEvaluator;

    @Deprecated
    public void setCurrentRow(HSSFRow hSSFRow) {
    }

    @Deprecated
    public HSSFFormulaEvaluator(HSSFSheet hSSFSheet, HSSFWorkbook hSSFWorkbook) {
        this(hSSFWorkbook);
        this._book = hSSFWorkbook;
    }

    public HSSFFormulaEvaluator(HSSFWorkbook hSSFWorkbook) {
        this(hSSFWorkbook, (IStabilityClassifier) null);
        this._book = hSSFWorkbook;
    }

    public HSSFFormulaEvaluator(HSSFWorkbook hSSFWorkbook, IStabilityClassifier iStabilityClassifier) {
        this(hSSFWorkbook, iStabilityClassifier, null);
    }

    private HSSFFormulaEvaluator(HSSFWorkbook hSSFWorkbook, IStabilityClassifier iStabilityClassifier, UDFFinder uDFFinder) {
        this._bookEvaluator = new WorkbookEvaluator(HSSFEvaluationWorkbook.create(hSSFWorkbook), iStabilityClassifier, uDFFinder);
    }

    public static HSSFFormulaEvaluator create(HSSFWorkbook hSSFWorkbook, IStabilityClassifier iStabilityClassifier, UDFFinder uDFFinder) {
        return new HSSFFormulaEvaluator(hSSFWorkbook, iStabilityClassifier, uDFFinder);
    }

    public static void setupEnvironment(String[] strArr, HSSFFormulaEvaluator[] hSSFFormulaEvaluatorArr) {
        int length = hSSFFormulaEvaluatorArr.length;
        WorkbookEvaluator[] workbookEvaluatorArr = new WorkbookEvaluator[length];
        for (int i = 0; i < length; i++) {
            workbookEvaluatorArr[i] = hSSFFormulaEvaluatorArr[i]._bookEvaluator;
        }
        CollaboratingWorkbooksEnvironment.setup(strArr, workbookEvaluatorArr);
    }

    @Override // org.apache.poi.ss.usermodel.FormulaEvaluator
    public void setupReferencedWorkbooks(Map<String, FormulaEvaluator> map) {
        CollaboratingWorkbooksEnvironment.setupFormulaEvaluator(map);
    }

    @Override // org.apache.poi.ss.formula.WorkbookEvaluatorProvider
    public WorkbookEvaluator _getWorkbookEvaluator() {
        return this._bookEvaluator;
    }

    @Override // org.apache.poi.ss.usermodel.FormulaEvaluator
    public void clearAllCachedResultValues() {
        this._bookEvaluator.clearAllCachedResultValues();
    }

    public void notifyUpdateCell(HSSFCell hSSFCell) {
        this._bookEvaluator.notifyUpdateCell(new HSSFEvaluationCell(hSSFCell));
    }

    @Override // org.apache.poi.ss.usermodel.FormulaEvaluator
    public void notifyUpdateCell(Cell cell) {
        this._bookEvaluator.notifyUpdateCell(new HSSFEvaluationCell((HSSFCell) cell));
    }

    public void notifyDeleteCell(HSSFCell hSSFCell) {
        this._bookEvaluator.notifyDeleteCell(new HSSFEvaluationCell(hSSFCell));
    }

    @Override // org.apache.poi.ss.usermodel.FormulaEvaluator
    public void notifyDeleteCell(Cell cell) {
        this._bookEvaluator.notifyDeleteCell(new HSSFEvaluationCell((HSSFCell) cell));
    }

    @Override // org.apache.poi.ss.usermodel.FormulaEvaluator
    public void notifySetFormula(Cell cell) {
        this._bookEvaluator.notifyUpdateCell(new HSSFEvaluationCell((HSSFCell) cell));
    }

    @Override // org.apache.poi.ss.usermodel.FormulaEvaluator
    public CellValue evaluate(Cell cell) {
        if (cell == null) {
            return null;
        }
        int cellType = cell.getCellType();
        if (cellType == 0) {
            return new CellValue(cell.getNumericCellValue());
        }
        if (cellType == 1) {
            return new CellValue(cell.getRichStringCellValue().getString());
        }
        if (cellType == 2) {
            return evaluateFormulaCellValue(cell);
        }
        if (cellType == 3) {
            return null;
        }
        if (cellType == 4) {
            return CellValue.valueOf(cell.getBooleanCellValue());
        }
        if (cellType == 5) {
            return CellValue.getError(cell.getErrorCellValue());
        }
        throw new IllegalStateException("Bad cell type (" + cell.getCellType() + ")");
    }

    @Override // org.apache.poi.ss.usermodel.FormulaEvaluator
    public int evaluateFormulaCell(Cell cell) {
        if (cell == null || cell.getCellType() != 2) {
            return -1;
        }
        CellValue evaluateFormulaCellValue = evaluateFormulaCellValue(cell);
        setCellValue(cell, evaluateFormulaCellValue);
        return evaluateFormulaCellValue.getCellType();
    }

    @Override // org.apache.poi.ss.usermodel.FormulaEvaluator
    public HSSFCell evaluateInCell(Cell cell) {
        if (cell == null) {
            return null;
        }
        HSSFCell hSSFCell = (HSSFCell) cell;
        if (cell.getCellType() == 2) {
            CellValue evaluateFormulaCellValue = evaluateFormulaCellValue(cell);
            setCellValue(cell, evaluateFormulaCellValue);
            setCellType(cell, evaluateFormulaCellValue);
        }
        return hSSFCell;
    }

    private static void setCellType(Cell cell, CellValue cellValue) {
        int cellType = cellValue.getCellType();
        if (cellType == 0 || cellType == 1 || cellType == 4 || cellType == 5) {
            cell.setCellType(cellType);
            return;
        }
        throw new IllegalStateException("Unexpected cell value type (" + cellType + ")");
    }

    private static void setCellValue(Cell cell, CellValue cellValue) {
        int cellType = cellValue.getCellType();
        if (cellType == 0) {
            cell.setCellValue(cellValue.getNumberValue());
            return;
        }
        if (cellType == 1) {
            cell.setCellValue(new HSSFRichTextString(cellValue.getStringValue()));
        } else if (cellType == 4) {
            cell.setCellValue(cellValue.getBooleanValue());
        } else {
            if (cellType == 5) {
                cell.setCellErrorValue(cellValue.getErrorValue());
                return;
            }
            throw new IllegalStateException("Unexpected cell value type (" + cellType + ")");
        }
    }

    public static void evaluateAllFormulaCells(HSSFWorkbook hSSFWorkbook) {
        evaluateAllFormulaCells(hSSFWorkbook, new HSSFFormulaEvaluator(hSSFWorkbook));
    }

    public static void evaluateAllFormulaCells(Workbook workbook) {
        evaluateAllFormulaCells(workbook, workbook.getCreationHelper().createFormulaEvaluator());
    }

    private static void evaluateAllFormulaCells(Workbook workbook, FormulaEvaluator formulaEvaluator) {
        for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
            Iterator<Row> it = workbook.getSheetAt(i).iterator();
            while (it.hasNext()) {
                for (Cell cell : it.next()) {
                    if (cell.getCellType() == 2) {
                        formulaEvaluator.evaluateFormulaCell(cell);
                    }
                }
            }
        }
    }

    @Override // org.apache.poi.ss.usermodel.FormulaEvaluator
    public void evaluateAll() {
        evaluateAllFormulaCells(this._book, this);
    }

    private CellValue evaluateFormulaCellValue(Cell cell) {
        ValueEval evaluate = this._bookEvaluator.evaluate(new HSSFEvaluationCell((HSSFCell) cell));
        if (evaluate instanceof BoolEval) {
            return CellValue.valueOf(((BoolEval) evaluate).getBooleanValue());
        }
        if (evaluate instanceof NumericValueEval) {
            return new CellValue(((NumericValueEval) evaluate).getNumberValue());
        }
        if (evaluate instanceof StringValueEval) {
            return new CellValue(((StringValueEval) evaluate).getStringValue());
        }
        if (evaluate instanceof ErrorEval) {
            return CellValue.getError(((ErrorEval) evaluate).getErrorCode());
        }
        throw new RuntimeException("Unexpected eval class (" + evaluate.getClass().getName() + ")");
    }

    @Override // org.apache.poi.ss.usermodel.FormulaEvaluator
    public void setIgnoreMissingWorkbooks(boolean z) {
        this._bookEvaluator.setIgnoreMissingWorkbooks(z);
    }

    @Override // org.apache.poi.ss.usermodel.FormulaEvaluator
    public void setDebugEvaluationOutputForNextEval(boolean z) {
        this._bookEvaluator.setDebugEvaluationOutputForNextEval(z);
    }
}
