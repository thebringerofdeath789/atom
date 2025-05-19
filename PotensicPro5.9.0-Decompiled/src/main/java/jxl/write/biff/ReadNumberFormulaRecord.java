package jxl.write.biff;

import common.Logger;
import java.text.NumberFormat;
import jxl.NumberFormulaCell;
import jxl.biff.DoubleHelper;
import jxl.biff.FormulaData;
import jxl.biff.IntegerHelper;
import jxl.biff.formula.FormulaException;
import jxl.biff.formula.FormulaParser;

/* loaded from: classes4.dex */
class ReadNumberFormulaRecord extends ReadFormulaRecord implements NumberFormulaCell {
    static /* synthetic */ Class class$jxl$write$biff$ReadNumberFormulaRecord;
    private static Logger logger;

    static {
        Class cls = class$jxl$write$biff$ReadNumberFormulaRecord;
        if (cls == null) {
            cls = class$("jxl.write.biff.ReadNumberFormulaRecord");
            class$jxl$write$biff$ReadNumberFormulaRecord = cls;
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

    public ReadNumberFormulaRecord(FormulaData formulaData) {
        super(formulaData);
    }

    @Override // jxl.NumberCell
    public double getValue() {
        return ((NumberFormulaCell) getReadFormula()).getValue();
    }

    @Override // jxl.NumberCell
    public NumberFormat getNumberFormat() {
        return ((NumberFormulaCell) getReadFormula()).getNumberFormat();
    }

    @Override // jxl.write.biff.ReadFormulaRecord
    protected byte[] handleFormulaException() {
        byte[] cellData = super.getCellData();
        WritableWorkbookImpl workbook = getSheet().getWorkbook();
        FormulaParser formulaParser = new FormulaParser(Double.toString(getValue()), workbook, workbook, workbook.getSettings());
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
        DoubleHelper.getIEEEBytes(getValue(), bArr2, 6);
        return bArr2;
    }
}
