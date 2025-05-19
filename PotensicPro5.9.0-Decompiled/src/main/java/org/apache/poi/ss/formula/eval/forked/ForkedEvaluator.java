package org.apache.poi.ss.formula.eval.forked;

import org.apache.poi.hssf.usermodel.HSSFEvaluationWorkbook;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.formula.CollaboratingWorkbooksEnvironment;
import org.apache.poi.ss.formula.EvaluationCell;
import org.apache.poi.ss.formula.EvaluationWorkbook;
import org.apache.poi.ss.formula.IStabilityClassifier;
import org.apache.poi.ss.formula.WorkbookEvaluator;
import org.apache.poi.ss.formula.eval.BoolEval;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.StringEval;
import org.apache.poi.ss.formula.eval.ValueEval;
import org.apache.poi.ss.formula.udf.UDFFinder;
import org.apache.poi.ss.usermodel.Workbook;

/* loaded from: classes5.dex */
public final class ForkedEvaluator {
    private WorkbookEvaluator _evaluator;
    private ForkedEvaluationWorkbook _sewb;

    private ForkedEvaluator(EvaluationWorkbook evaluationWorkbook, IStabilityClassifier iStabilityClassifier, UDFFinder uDFFinder) {
        this._sewb = new ForkedEvaluationWorkbook(evaluationWorkbook);
        this._evaluator = new WorkbookEvaluator(this._sewb, iStabilityClassifier, uDFFinder);
    }

    private static EvaluationWorkbook createEvaluationWorkbook(Workbook workbook) {
        if (workbook instanceof HSSFWorkbook) {
            return HSSFEvaluationWorkbook.create((HSSFWorkbook) workbook);
        }
        throw new IllegalArgumentException("Unexpected workbook type (" + workbook.getClass().getName() + ")");
    }

    public static ForkedEvaluator create(Workbook workbook, IStabilityClassifier iStabilityClassifier) {
        return create(workbook, iStabilityClassifier, null);
    }

    public static ForkedEvaluator create(Workbook workbook, IStabilityClassifier iStabilityClassifier, UDFFinder uDFFinder) {
        return new ForkedEvaluator(createEvaluationWorkbook(workbook), iStabilityClassifier, uDFFinder);
    }

    public void updateCell(String str, int i, int i2, ValueEval valueEval) {
        ForkedEvaluationCell orCreateUpdatableCell = this._sewb.getOrCreateUpdatableCell(str, i, i2);
        orCreateUpdatableCell.setValue(valueEval);
        this._evaluator.notifyUpdateCell(orCreateUpdatableCell);
    }

    public void copyUpdatedCells(Workbook workbook) {
        this._sewb.copyUpdatedCells(workbook);
    }

    public ValueEval evaluate(String str, int i, int i2) {
        EvaluationCell evaluationCell = this._sewb.getEvaluationCell(str, i, i2);
        int cellType = evaluationCell.getCellType();
        if (cellType == 0) {
            return new NumberEval(evaluationCell.getNumericCellValue());
        }
        if (cellType == 1) {
            return new StringEval(evaluationCell.getStringCellValue());
        }
        if (cellType == 2) {
            return this._evaluator.evaluate(evaluationCell);
        }
        if (cellType == 3) {
            return null;
        }
        if (cellType == 4) {
            return BoolEval.valueOf(evaluationCell.getBooleanCellValue());
        }
        if (cellType == 5) {
            return ErrorEval.valueOf(evaluationCell.getErrorCellValue());
        }
        throw new IllegalStateException("Bad cell type (" + evaluationCell.getCellType() + ")");
    }

    public static void setupEnvironment(String[] strArr, ForkedEvaluator[] forkedEvaluatorArr) {
        int length = forkedEvaluatorArr.length;
        WorkbookEvaluator[] workbookEvaluatorArr = new WorkbookEvaluator[length];
        for (int i = 0; i < length; i++) {
            workbookEvaluatorArr[i] = forkedEvaluatorArr[i]._evaluator;
        }
        CollaboratingWorkbooksEnvironment.setup(strArr, workbookEvaluatorArr);
    }
}
