package jxl.write.biff;

import common.Logger;
import jxl.ErrorFormulaCell;
import jxl.biff.FormulaData;
import jxl.biff.IntegerHelper;
import jxl.biff.formula.FormulaErrorCode;
import jxl.biff.formula.FormulaException;
import jxl.biff.formula.FormulaParser;

/* loaded from: classes4.dex */
class ReadErrorFormulaRecord extends ReadFormulaRecord implements ErrorFormulaCell {
    static /* synthetic */ Class class$jxl$write$biff$ReadErrorFormulaRecord;
    private static Logger logger;

    static {
        Class cls = class$jxl$write$biff$ReadErrorFormulaRecord;
        if (cls == null) {
            cls = class$("jxl.write.biff.ReadErrorFormulaRecord");
            class$jxl$write$biff$ReadErrorFormulaRecord = cls;
        }
        logger = Logger.getLogger(cls);
    }

    static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError(e.getMessage());
        }
    }

    public ReadErrorFormulaRecord(FormulaData formulaData) {
        super(formulaData);
    }

    @Override // jxl.ErrorCell
    public int getErrorCode() {
        return ((ErrorFormulaCell) getReadFormula()).getErrorCode();
    }

    @Override // jxl.write.biff.ReadFormulaRecord
    protected byte[] handleFormulaException() {
        String str;
        byte[] cellData = super.getCellData();
        int errorCode = getErrorCode();
        if (errorCode == FormulaErrorCode.DIV0.getCode()) {
            str = "1/0";
        } else if (errorCode == FormulaErrorCode.VALUE.getCode()) {
            str = "\"\"/0";
        } else {
            str = errorCode == FormulaErrorCode.REF.getCode() ? "\"#REF!\"" : "\"ERROR\"";
        }
        WritableWorkbookImpl workbook = getSheet().getWorkbook();
        FormulaParser formulaParser = new FormulaParser(str, workbook, workbook, workbook.getSettings());
        try {
            formulaParser.parse();
        } catch (FormulaException e) {
            logger.warn(e.getMessage());
        }
        byte[] bytes = formulaParser.getBytes();
        int length = bytes.length + 16;
        byte[] bArr = new byte[length];
        IntegerHelper.getTwoBytes(bytes.length, bArr, 14);
        System.arraycopy(bytes, 0, bArr, 16, bytes.length);
        bArr[8] = (byte) (bArr[8] | 2);
        byte[] bArr2 = new byte[cellData.length + length];
        System.arraycopy(cellData, 0, bArr2, 0, cellData.length);
        System.arraycopy(bArr, 0, bArr2, cellData.length, length);
        bArr2[6] = 2;
        bArr2[12] = -1;
        bArr2[13] = -1;
        bArr2[8] = (byte) errorCode;
        return bArr2;
    }
}
