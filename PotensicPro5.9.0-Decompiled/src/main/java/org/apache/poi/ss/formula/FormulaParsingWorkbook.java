package org.apache.poi.ss.formula;

import org.apache.poi.ss.SpreadsheetVersion;
import org.apache.poi.ss.formula.ptg.Ptg;
import org.apache.poi.ss.util.AreaReference;
import org.apache.poi.ss.util.CellReference;

/* loaded from: classes5.dex */
public interface FormulaParsingWorkbook {
    Ptg get3DReferencePtg(AreaReference areaReference, SheetIdentifier sheetIdentifier);

    Ptg get3DReferencePtg(CellReference cellReference, SheetIdentifier sheetIdentifier);

    int getExternalSheetIndex(String str);

    int getExternalSheetIndex(String str, String str2);

    EvaluationName getName(String str, int i);

    Ptg getNameXPtg(String str, SheetIdentifier sheetIdentifier);

    SpreadsheetVersion getSpreadsheetVersion();
}
