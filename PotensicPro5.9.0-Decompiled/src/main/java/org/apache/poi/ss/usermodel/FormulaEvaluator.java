package org.apache.poi.ss.usermodel;

import java.util.Map;

/* loaded from: classes5.dex */
public interface FormulaEvaluator {
    void clearAllCachedResultValues();

    CellValue evaluate(Cell cell);

    void evaluateAll();

    int evaluateFormulaCell(Cell cell);

    Cell evaluateInCell(Cell cell);

    void notifyDeleteCell(Cell cell);

    void notifySetFormula(Cell cell);

    void notifyUpdateCell(Cell cell);

    void setDebugEvaluationOutputForNextEval(boolean z);

    void setIgnoreMissingWorkbooks(boolean z);

    void setupReferencedWorkbooks(Map<String, FormulaEvaluator> map);
}
