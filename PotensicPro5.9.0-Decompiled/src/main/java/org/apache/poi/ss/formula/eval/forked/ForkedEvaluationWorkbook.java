package org.apache.poi.ss.formula.eval.forked;

import java.util.HashMap;
import java.util.Map;
import org.apache.poi.ss.formula.EvaluationCell;
import org.apache.poi.ss.formula.EvaluationName;
import org.apache.poi.ss.formula.EvaluationSheet;
import org.apache.poi.ss.formula.EvaluationWorkbook;
import org.apache.poi.ss.formula.ptg.NamePtg;
import org.apache.poi.ss.formula.ptg.NameXPtg;
import org.apache.poi.ss.formula.ptg.Ptg;
import org.apache.poi.ss.formula.udf.UDFFinder;
import org.apache.poi.ss.usermodel.Workbook;

/* loaded from: classes5.dex */
final class ForkedEvaluationWorkbook implements EvaluationWorkbook {
    private final EvaluationWorkbook _masterBook;
    private final Map<String, ForkedEvaluationSheet> _sharedSheetsByName = new HashMap();

    public ForkedEvaluationWorkbook(EvaluationWorkbook evaluationWorkbook) {
        this._masterBook = evaluationWorkbook;
    }

    public ForkedEvaluationCell getOrCreateUpdatableCell(String str, int i, int i2) {
        return getSharedSheet(str).getOrCreateUpdatableCell(i, i2);
    }

    public EvaluationCell getEvaluationCell(String str, int i, int i2) {
        return getSharedSheet(str).getCell(i, i2);
    }

    private ForkedEvaluationSheet getSharedSheet(String str) {
        ForkedEvaluationSheet forkedEvaluationSheet = this._sharedSheetsByName.get(str);
        if (forkedEvaluationSheet != null) {
            return forkedEvaluationSheet;
        }
        EvaluationWorkbook evaluationWorkbook = this._masterBook;
        ForkedEvaluationSheet forkedEvaluationSheet2 = new ForkedEvaluationSheet(evaluationWorkbook.getSheet(evaluationWorkbook.getSheetIndex(str)));
        this._sharedSheetsByName.put(str, forkedEvaluationSheet2);
        return forkedEvaluationSheet2;
    }

    public void copyUpdatedCells(Workbook workbook) {
        int size = this._sharedSheetsByName.size();
        String[] strArr = new String[size];
        this._sharedSheetsByName.keySet().toArray(strArr);
        OrderedSheet[] orderedSheetArr = new OrderedSheet[size];
        for (int i = 0; i < size; i++) {
            String str = strArr[i];
            orderedSheetArr[i] = new OrderedSheet(str, this._masterBook.getSheetIndex(str));
        }
        for (int i2 = 0; i2 < size; i2++) {
            String sheetName = orderedSheetArr[i2].getSheetName();
            this._sharedSheetsByName.get(sheetName).copyUpdatedCells(workbook.getSheet(sheetName));
        }
    }

    @Override // org.apache.poi.ss.formula.EvaluationWorkbook
    public int convertFromExternSheetIndex(int i) {
        return this._masterBook.convertFromExternSheetIndex(i);
    }

    @Override // org.apache.poi.ss.formula.EvaluationWorkbook
    public EvaluationWorkbook.ExternalSheet getExternalSheet(int i) {
        return this._masterBook.getExternalSheet(i);
    }

    @Override // org.apache.poi.ss.formula.EvaluationWorkbook
    public EvaluationWorkbook.ExternalSheet getExternalSheet(String str, String str2, int i) {
        return this._masterBook.getExternalSheet(str, str2, i);
    }

    @Override // org.apache.poi.ss.formula.EvaluationWorkbook
    public Ptg[] getFormulaTokens(EvaluationCell evaluationCell) {
        if (evaluationCell instanceof ForkedEvaluationCell) {
            throw new RuntimeException("Updated formulas not supported yet");
        }
        return this._masterBook.getFormulaTokens(evaluationCell);
    }

    @Override // org.apache.poi.ss.formula.EvaluationWorkbook
    public EvaluationName getName(NamePtg namePtg) {
        return this._masterBook.getName(namePtg);
    }

    @Override // org.apache.poi.ss.formula.EvaluationWorkbook, org.apache.poi.ss.formula.FormulaParsingWorkbook
    public EvaluationName getName(String str, int i) {
        return this._masterBook.getName(str, i);
    }

    @Override // org.apache.poi.ss.formula.EvaluationWorkbook
    public EvaluationSheet getSheet(int i) {
        return getSharedSheet(getSheetName(i));
    }

    @Override // org.apache.poi.ss.formula.EvaluationWorkbook
    public EvaluationWorkbook.ExternalName getExternalName(int i, int i2) {
        return this._masterBook.getExternalName(i, i2);
    }

    @Override // org.apache.poi.ss.formula.EvaluationWorkbook
    public EvaluationWorkbook.ExternalName getExternalName(String str, String str2, int i) {
        return this._masterBook.getExternalName(str, str2, i);
    }

    @Override // org.apache.poi.ss.formula.EvaluationWorkbook
    public int getSheetIndex(EvaluationSheet evaluationSheet) {
        if (evaluationSheet instanceof ForkedEvaluationSheet) {
            return ((ForkedEvaluationSheet) evaluationSheet).getSheetIndex(this._masterBook);
        }
        return this._masterBook.getSheetIndex(evaluationSheet);
    }

    @Override // org.apache.poi.ss.formula.EvaluationWorkbook
    public int getSheetIndex(String str) {
        return this._masterBook.getSheetIndex(str);
    }

    @Override // org.apache.poi.ss.formula.EvaluationWorkbook
    public String getSheetName(int i) {
        return this._masterBook.getSheetName(i);
    }

    @Override // org.apache.poi.ss.formula.EvaluationWorkbook
    public String resolveNameXText(NameXPtg nameXPtg) {
        return this._masterBook.resolveNameXText(nameXPtg);
    }

    @Override // org.apache.poi.ss.formula.EvaluationWorkbook
    public UDFFinder getUDFFinder() {
        return this._masterBook.getUDFFinder();
    }

    private static final class OrderedSheet implements Comparable<OrderedSheet> {
        private final int _index;
        private final String _sheetName;

        public OrderedSheet(String str, int i) {
            this._sheetName = str;
            this._index = i;
        }

        public String getSheetName() {
            return this._sheetName;
        }

        @Override // java.lang.Comparable
        public int compareTo(OrderedSheet orderedSheet) {
            return this._index - orderedSheet._index;
        }
    }
}
