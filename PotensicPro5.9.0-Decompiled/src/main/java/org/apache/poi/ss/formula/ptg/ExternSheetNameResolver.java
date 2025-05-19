package org.apache.poi.ss.formula.ptg;

import org.apache.poi.ss.formula.EvaluationWorkbook;
import org.apache.poi.ss.formula.FormulaRenderingWorkbook;
import org.apache.poi.ss.formula.SheetNameFormatter;
import org.apache.xmlbeans.impl.common.NameUtil;

/* loaded from: classes5.dex */
final class ExternSheetNameResolver {
    private ExternSheetNameResolver() {
    }

    public static String prependSheetName(FormulaRenderingWorkbook formulaRenderingWorkbook, int i, String str) {
        StringBuffer stringBuffer;
        EvaluationWorkbook.ExternalSheet externalSheet = formulaRenderingWorkbook.getExternalSheet(i);
        if (externalSheet != null) {
            String workbookName = externalSheet.getWorkbookName();
            String sheetName = externalSheet.getSheetName();
            if (workbookName != null) {
                stringBuffer = new StringBuffer(workbookName.length() + sheetName.length() + str.length() + 4);
                SheetNameFormatter.appendFormat(stringBuffer, workbookName, sheetName);
            } else {
                stringBuffer = new StringBuffer(sheetName.length() + str.length() + 4);
                SheetNameFormatter.appendFormat(stringBuffer, sheetName);
            }
            if (externalSheet instanceof EvaluationWorkbook.ExternalSheetRange) {
                EvaluationWorkbook.ExternalSheetRange externalSheetRange = (EvaluationWorkbook.ExternalSheetRange) externalSheet;
                if (!externalSheetRange.getFirstSheetName().equals(externalSheetRange.getLastSheetName())) {
                    stringBuffer.append(NameUtil.COLON);
                    SheetNameFormatter.appendFormat(stringBuffer, externalSheetRange.getLastSheetName());
                }
            }
        } else {
            String sheetFirstNameByExternSheet = formulaRenderingWorkbook.getSheetFirstNameByExternSheet(i);
            String sheetLastNameByExternSheet = formulaRenderingWorkbook.getSheetLastNameByExternSheet(i);
            stringBuffer = new StringBuffer(sheetFirstNameByExternSheet.length() + str.length() + 4);
            if (sheetFirstNameByExternSheet.length() < 1) {
                stringBuffer.append("#REF");
            } else {
                SheetNameFormatter.appendFormat(stringBuffer, sheetFirstNameByExternSheet);
                if (!sheetFirstNameByExternSheet.equals(sheetLastNameByExternSheet)) {
                    stringBuffer.append(NameUtil.COLON);
                    stringBuffer.append(sheetLastNameByExternSheet);
                }
            }
        }
        stringBuffer.append('!');
        stringBuffer.append(str);
        return stringBuffer.toString();
    }
}
