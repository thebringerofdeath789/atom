package jxl.write.biff;

import common.Assert;
import common.Logger;
import jxl.CellReferenceHelper;
import jxl.CellType;
import jxl.FormulaCell;
import jxl.Sheet;
import jxl.biff.FormattingRecords;
import jxl.biff.FormulaData;
import jxl.biff.IntegerHelper;
import jxl.biff.Type;
import jxl.biff.formula.FormulaException;
import jxl.biff.formula.FormulaParser;
import jxl.write.WritableCell;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes4.dex */
class ReadFormulaRecord extends CellValue implements FormulaData {
    static /* synthetic */ Class class$jxl$write$biff$ReadFormulaRecord;
    private static Logger logger;
    private FormulaData formula;
    private FormulaParser parser;

    static {
        Class cls = class$jxl$write$biff$ReadFormulaRecord;
        if (cls == null) {
            cls = class$("jxl.write.biff.ReadFormulaRecord");
            class$jxl$write$biff$ReadFormulaRecord = cls;
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

    protected ReadFormulaRecord(FormulaData formulaData) {
        super(Type.FORMULA, formulaData);
        this.formula = formulaData;
    }

    protected final byte[] getCellData() {
        return super.getData();
    }

    protected byte[] handleFormulaException() {
        byte[] data = super.getData();
        WritableWorkbookImpl workbook = getSheet().getWorkbook();
        FormulaParser formulaParser = new FormulaParser(getContents(), workbook, workbook, workbook.getSettings());
        this.parser = formulaParser;
        try {
            formulaParser.parse();
        } catch (FormulaException e) {
            logger.warn(e.getMessage());
            FormulaParser formulaParser2 = new FormulaParser("\"ERROR\"", workbook, workbook, workbook.getSettings());
            this.parser = formulaParser2;
            try {
                formulaParser2.parse();
            } catch (FormulaException unused) {
                Assert.verify(false);
            }
        }
        byte[] bytes = this.parser.getBytes();
        int length = bytes.length + 16;
        byte[] bArr = new byte[length];
        IntegerHelper.getTwoBytes(bytes.length, bArr, 14);
        System.arraycopy(bytes, 0, bArr, 16, bytes.length);
        bArr[8] = (byte) (bArr[8] | 2);
        byte[] bArr2 = new byte[data.length + length];
        System.arraycopy(data, 0, bArr2, 0, data.length);
        System.arraycopy(bArr, 0, bArr2, data.length, length);
        return bArr2;
    }

    @Override // jxl.write.biff.CellValue, jxl.biff.WritableRecordData
    public byte[] getData() {
        byte[] bArr;
        byte[] data = super.getData();
        try {
            FormulaParser formulaParser = this.parser;
            if (formulaParser == null) {
                bArr = this.formula.getFormulaData();
            } else {
                byte[] bytes = formulaParser.getBytes();
                byte[] bArr2 = new byte[bytes.length + 16];
                IntegerHelper.getTwoBytes(bytes.length, bArr2, 14);
                System.arraycopy(bytes, 0, bArr2, 16, bytes.length);
                bArr = bArr2;
            }
            bArr[8] = (byte) (bArr[8] | 2);
            byte[] bArr3 = new byte[data.length + bArr.length];
            System.arraycopy(data, 0, bArr3, 0, data.length);
            System.arraycopy(bArr, 0, bArr3, data.length, bArr.length);
            return bArr3;
        } catch (FormulaException e) {
            logger.warn(new StringBuffer().append(CellReferenceHelper.getCellReference(getColumn(), getRow())).append(StringUtils.SPACE).append(e.getMessage()).toString());
            return handleFormulaException();
        }
    }

    @Override // jxl.Cell
    public CellType getType() {
        return this.formula.getType();
    }

    @Override // jxl.Cell
    public String getContents() {
        return this.formula.getContents();
    }

    @Override // jxl.biff.FormulaData
    public byte[] getFormulaData() throws FormulaException {
        byte[] formulaData = this.formula.getFormulaData();
        byte[] bArr = new byte[formulaData.length];
        System.arraycopy(formulaData, 0, bArr, 0, formulaData.length);
        bArr[8] = (byte) (bArr[8] | 2);
        return bArr;
    }

    @Override // jxl.write.WritableCell
    public WritableCell copyTo(int i, int i2) {
        return new FormulaRecord(i, i2, this);
    }

    @Override // jxl.write.biff.CellValue
    void setCellDetails(FormattingRecords formattingRecords, SharedStrings sharedStrings, WritableSheetImpl writableSheetImpl) {
        super.setCellDetails(formattingRecords, sharedStrings, writableSheetImpl);
        writableSheetImpl.getWorkbook().addRCIRCell(this);
    }

    @Override // jxl.write.biff.CellValue
    void columnInserted(Sheet sheet, int i, int i2) {
        try {
            if (this.parser == null) {
                byte[] formulaData = this.formula.getFormulaData();
                int length = formulaData.length - 16;
                byte[] bArr = new byte[length];
                System.arraycopy(formulaData, 16, bArr, 0, length);
                FormulaParser formulaParser = new FormulaParser(bArr, this, getSheet().getWorkbook(), getSheet().getWorkbook(), getSheet().getWorkbookSettings());
                this.parser = formulaParser;
                formulaParser.parse();
            }
            this.parser.columnInserted(i, i2, sheet == getSheet());
        } catch (FormulaException e) {
            logger.warn(new StringBuffer().append("cannot insert column within formula:  ").append(e.getMessage()).toString());
        }
    }

    @Override // jxl.write.biff.CellValue
    void columnRemoved(Sheet sheet, int i, int i2) {
        try {
            if (this.parser == null) {
                byte[] formulaData = this.formula.getFormulaData();
                int length = formulaData.length - 16;
                byte[] bArr = new byte[length];
                System.arraycopy(formulaData, 16, bArr, 0, length);
                FormulaParser formulaParser = new FormulaParser(bArr, this, getSheet().getWorkbook(), getSheet().getWorkbook(), getSheet().getWorkbookSettings());
                this.parser = formulaParser;
                formulaParser.parse();
            }
            this.parser.columnRemoved(i, i2, sheet == getSheet());
        } catch (FormulaException e) {
            logger.warn(new StringBuffer().append("cannot remove column within formula:  ").append(e.getMessage()).toString());
        }
    }

    @Override // jxl.write.biff.CellValue
    void rowInserted(Sheet sheet, int i, int i2) {
        try {
            if (this.parser == null) {
                byte[] formulaData = this.formula.getFormulaData();
                int length = formulaData.length - 16;
                byte[] bArr = new byte[length];
                System.arraycopy(formulaData, 16, bArr, 0, length);
                FormulaParser formulaParser = new FormulaParser(bArr, this, getSheet().getWorkbook(), getSheet().getWorkbook(), getSheet().getWorkbookSettings());
                this.parser = formulaParser;
                formulaParser.parse();
            }
            this.parser.rowInserted(i, i2, sheet == getSheet());
        } catch (FormulaException e) {
            logger.warn(new StringBuffer().append("cannot insert row within formula:  ").append(e.getMessage()).toString());
        }
    }

    @Override // jxl.write.biff.CellValue
    void rowRemoved(Sheet sheet, int i, int i2) {
        try {
            if (this.parser == null) {
                byte[] formulaData = this.formula.getFormulaData();
                int length = formulaData.length - 16;
                byte[] bArr = new byte[length];
                System.arraycopy(formulaData, 16, bArr, 0, length);
                FormulaParser formulaParser = new FormulaParser(bArr, this, getSheet().getWorkbook(), getSheet().getWorkbook(), getSheet().getWorkbookSettings());
                this.parser = formulaParser;
                formulaParser.parse();
            }
            this.parser.rowRemoved(i, i2, sheet == getSheet());
        } catch (FormulaException e) {
            logger.warn(new StringBuffer().append("cannot remove row within formula:  ").append(e.getMessage()).toString());
        }
    }

    protected FormulaData getReadFormula() {
        return this.formula;
    }

    public String getFormula() throws FormulaException {
        return ((FormulaCell) this.formula).getFormula();
    }
}
