package org.apache.poi.xssf.usermodel;

import java.util.Map;
import org.apache.poi.hssf.usermodel.HSSFFormulaEvaluator;
import org.apache.poi.ss.formula.CollaboratingWorkbooksEnvironment;
import org.apache.poi.ss.formula.IStabilityClassifier;
import org.apache.poi.ss.formula.WorkbookEvaluator;
import org.apache.poi.ss.formula.WorkbookEvaluatorProvider;
import org.apache.poi.ss.formula.eval.BoolEval;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.StringEval;
import org.apache.poi.ss.formula.eval.ValueEval;
import org.apache.poi.ss.formula.udf.UDFFinder;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellValue;
import org.apache.poi.ss.usermodel.FormulaEvaluator;

/* loaded from: classes5.dex */
public class XSSFFormulaEvaluator implements FormulaEvaluator, WorkbookEvaluatorProvider {
    private XSSFWorkbook _book;
    private WorkbookEvaluator _bookEvaluator;

    public XSSFFormulaEvaluator(XSSFWorkbook xSSFWorkbook) {
        this(xSSFWorkbook, null, null);
    }

    @Deprecated
    public XSSFFormulaEvaluator(XSSFWorkbook xSSFWorkbook, IStabilityClassifier iStabilityClassifier) {
        this._bookEvaluator = new WorkbookEvaluator(XSSFEvaluationWorkbook.create(xSSFWorkbook), iStabilityClassifier, null);
        this._book = xSSFWorkbook;
    }

    private XSSFFormulaEvaluator(XSSFWorkbook xSSFWorkbook, IStabilityClassifier iStabilityClassifier, UDFFinder uDFFinder) {
        this._bookEvaluator = new WorkbookEvaluator(XSSFEvaluationWorkbook.create(xSSFWorkbook), iStabilityClassifier, uDFFinder);
        this._book = xSSFWorkbook;
    }

    public static XSSFFormulaEvaluator create(XSSFWorkbook xSSFWorkbook, IStabilityClassifier iStabilityClassifier, UDFFinder uDFFinder) {
        return new XSSFFormulaEvaluator(xSSFWorkbook, iStabilityClassifier, uDFFinder);
    }

    @Override // org.apache.poi.ss.usermodel.FormulaEvaluator
    public void clearAllCachedResultValues() {
        this._bookEvaluator.clearAllCachedResultValues();
    }

    @Override // org.apache.poi.ss.usermodel.FormulaEvaluator
    public void notifySetFormula(Cell cell) {
        this._bookEvaluator.notifyUpdateCell(new XSSFEvaluationCell((XSSFCell) cell));
    }

    @Override // org.apache.poi.ss.usermodel.FormulaEvaluator
    public void notifyDeleteCell(Cell cell) {
        this._bookEvaluator.notifyDeleteCell(new XSSFEvaluationCell((XSSFCell) cell));
    }

    @Override // org.apache.poi.ss.usermodel.FormulaEvaluator
    public void notifyUpdateCell(Cell cell) {
        this._bookEvaluator.notifyUpdateCell(new XSSFEvaluationCell((XSSFCell) cell));
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
    public XSSFCell evaluateInCell(Cell cell) {
        if (cell == null) {
            return null;
        }
        XSSFCell xSSFCell = (XSSFCell) cell;
        if (cell.getCellType() == 2) {
            CellValue evaluateFormulaCellValue = evaluateFormulaCellValue(cell);
            setCellType(cell, evaluateFormulaCellValue);
            setCellValue(cell, evaluateFormulaCellValue);
        }
        return xSSFCell;
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
            cell.setCellValue(new XSSFRichTextString(cellValue.getStringValue()));
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

    public static void evaluateAllFormulaCells(XSSFWorkbook xSSFWorkbook) {
        HSSFFormulaEvaluator.evaluateAllFormulaCells(xSSFWorkbook);
    }

    @Override // org.apache.poi.ss.usermodel.FormulaEvaluator
    public void evaluateAll() {
        HSSFFormulaEvaluator.evaluateAllFormulaCells(this._book);
    }

    private CellValue evaluateFormulaCellValue(Cell cell) {
        if (!(cell instanceof XSSFCell)) {
            throw new IllegalArgumentException("Unexpected type of cell: " + cell.getClass() + ". Only XSSFCells can be evaluated.");
        }
        ValueEval evaluate = this._bookEvaluator.evaluate(new XSSFEvaluationCell((XSSFCell) cell));
        if (evaluate instanceof NumberEval) {
            return new CellValue(((NumberEval) evaluate).getNumberValue());
        }
        if (evaluate instanceof BoolEval) {
            return CellValue.valueOf(((BoolEval) evaluate).getBooleanValue());
        }
        if (evaluate instanceof StringEval) {
            return new CellValue(((StringEval) evaluate).getStringValue());
        }
        if (evaluate instanceof ErrorEval) {
            return CellValue.getError(((ErrorEval) evaluate).getErrorCode());
        }
        throw new RuntimeException("Unexpected eval class (" + evaluate.getClass().getName() + ")");
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
    public void setIgnoreMissingWorkbooks(boolean z) {
        this._bookEvaluator.setIgnoreMissingWorkbooks(z);
    }

    @Override // org.apache.poi.ss.usermodel.FormulaEvaluator
    public void setDebugEvaluationOutputForNextEval(boolean z) {
        this._bookEvaluator.setDebugEvaluationOutputForNextEval(z);
    }
}
