package org.apache.poi.ss.formula;

import org.apache.poi.ss.formula.ptg.NamePtg;
import org.apache.poi.ss.formula.ptg.NameXPtg;
import org.apache.poi.ss.formula.ptg.Ptg;
import org.apache.poi.ss.formula.udf.UDFFinder;

/* loaded from: classes5.dex */
public interface EvaluationWorkbook {
    int convertFromExternSheetIndex(int i);

    ExternalName getExternalName(int i, int i2);

    ExternalName getExternalName(String str, String str2, int i);

    ExternalSheet getExternalSheet(int i);

    ExternalSheet getExternalSheet(String str, String str2, int i);

    Ptg[] getFormulaTokens(EvaluationCell evaluationCell);

    EvaluationName getName(String str, int i);

    EvaluationName getName(NamePtg namePtg);

    EvaluationSheet getSheet(int i);

    int getSheetIndex(String str);

    int getSheetIndex(EvaluationSheet evaluationSheet);

    String getSheetName(int i);

    UDFFinder getUDFFinder();

    String resolveNameXText(NameXPtg nameXPtg);

    public static class ExternalSheet {
        private final String _sheetName;
        private final String _workbookName;

        public ExternalSheet(String str, String str2) {
            this._workbookName = str;
            this._sheetName = str2;
        }

        public String getWorkbookName() {
            return this._workbookName;
        }

        public String getSheetName() {
            return this._sheetName;
        }
    }

    public static class ExternalSheetRange extends ExternalSheet {
        private final String _lastSheetName;

        public ExternalSheetRange(String str, String str2, String str3) {
            super(str, str2);
            this._lastSheetName = str3;
        }

        public String getFirstSheetName() {
            return getSheetName();
        }

        public String getLastSheetName() {
            return this._lastSheetName;
        }
    }

    public static class ExternalName {
        private final int _ix;
        private final String _nameName;
        private final int _nameNumber;

        public ExternalName(String str, int i, int i2) {
            this._nameName = str;
            this._nameNumber = i;
            this._ix = i2;
        }

        public String getName() {
            return this._nameName;
        }

        public int getNumber() {
            return this._nameNumber;
        }

        public int getIx() {
            return this._ix;
        }
    }
}
