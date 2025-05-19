package jxl.write.biff;

import common.Assert;
import common.Logger;
import jxl.CellReferenceHelper;
import jxl.CellType;
import jxl.Sheet;
import jxl.WorkbookSettings;
import jxl.biff.FormattingRecords;
import jxl.biff.FormulaData;
import jxl.biff.IntegerHelper;
import jxl.biff.Type;
import jxl.biff.WorkbookMethods;
import jxl.biff.formula.ExternalSheet;
import jxl.biff.formula.FormulaException;
import jxl.biff.formula.FormulaParser;
import jxl.format.CellFormat;
import jxl.write.WritableCell;

/* loaded from: classes4.dex */
public class FormulaRecord extends CellValue implements FormulaData {
    static /* synthetic */ Class class$jxl$write$biff$FormulaRecord;
    private static Logger logger;
    private CellValue copiedFrom;
    private byte[] formulaBytes;
    private String formulaString;
    private String formulaToParse;
    private FormulaParser parser;

    static {
        Class cls = class$jxl$write$biff$FormulaRecord;
        if (cls == null) {
            cls = class$("jxl.write.biff.FormulaRecord");
            class$jxl$write$biff$FormulaRecord = cls;
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

    public FormulaRecord(int i, int i2, String str) {
        super(Type.FORMULA2, i, i2);
        this.formulaToParse = str;
        this.copiedFrom = null;
    }

    public FormulaRecord(int i, int i2, String str, CellFormat cellFormat) {
        super(Type.FORMULA, i, i2, cellFormat);
        this.formulaToParse = str;
        this.copiedFrom = null;
    }

    protected FormulaRecord(int i, int i2, FormulaRecord formulaRecord) {
        super(Type.FORMULA, i, i2, formulaRecord);
        this.copiedFrom = formulaRecord;
        byte[] bArr = new byte[formulaRecord.formulaBytes.length];
        this.formulaBytes = bArr;
        System.arraycopy(formulaRecord.formulaBytes, 0, bArr, 0, bArr.length);
    }

    protected FormulaRecord(int i, int i2, ReadFormulaRecord readFormulaRecord) {
        super(Type.FORMULA, i, i2, readFormulaRecord);
        try {
            this.copiedFrom = readFormulaRecord;
            byte[] formulaData = readFormulaRecord.getFormulaData();
            byte[] bArr = new byte[formulaData.length - 16];
            this.formulaBytes = bArr;
            System.arraycopy(formulaData, 16, bArr, 0, bArr.length);
        } catch (FormulaException e) {
            logger.error("", e);
        }
    }

    private void initialize(WorkbookSettings workbookSettings, ExternalSheet externalSheet, WorkbookMethods workbookMethods) {
        if (this.copiedFrom != null) {
            initializeCopiedFormula(workbookSettings, externalSheet, workbookMethods);
            return;
        }
        FormulaParser formulaParser = new FormulaParser(this.formulaToParse, externalSheet, workbookMethods, workbookSettings);
        this.parser = formulaParser;
        try {
            formulaParser.parse();
            this.formulaString = this.parser.getFormula();
            this.formulaBytes = this.parser.getBytes();
        } catch (FormulaException e) {
            logger.warn(new StringBuffer().append(e.getMessage()).append(" when parsing formula ").append(this.formulaToParse).append(" in cell ").append(getSheet().getName()).append("!").append(CellReferenceHelper.getCellReference(getColumn(), getRow())).toString());
            try {
                this.formulaToParse = "ERROR(1)";
                FormulaParser formulaParser2 = new FormulaParser(this.formulaToParse, externalSheet, workbookMethods, workbookSettings);
                this.parser = formulaParser2;
                formulaParser2.parse();
                this.formulaString = this.parser.getFormula();
                this.formulaBytes = this.parser.getBytes();
            } catch (FormulaException e2) {
                logger.error("", e2);
            }
        }
    }

    private void initializeCopiedFormula(WorkbookSettings workbookSettings, ExternalSheet externalSheet, WorkbookMethods workbookMethods) {
        try {
            try {
                FormulaParser formulaParser = new FormulaParser(this.formulaBytes, this, externalSheet, workbookMethods, workbookSettings);
                this.parser = formulaParser;
                formulaParser.parse();
                this.parser.adjustRelativeCellReferences(getColumn() - this.copiedFrom.getColumn(), getRow() - this.copiedFrom.getRow());
                this.formulaString = this.parser.getFormula();
                this.formulaBytes = this.parser.getBytes();
            } catch (FormulaException unused) {
                this.formulaToParse = "ERROR(1)";
                FormulaParser formulaParser2 = new FormulaParser(this.formulaToParse, externalSheet, workbookMethods, workbookSettings);
                this.parser = formulaParser2;
                formulaParser2.parse();
                this.formulaString = this.parser.getFormula();
                this.formulaBytes = this.parser.getBytes();
            }
        } catch (FormulaException e) {
            logger.error("", e);
        }
    }

    @Override // jxl.write.biff.CellValue
    void setCellDetails(FormattingRecords formattingRecords, SharedStrings sharedStrings, WritableSheetImpl writableSheetImpl) {
        super.setCellDetails(formattingRecords, sharedStrings, writableSheetImpl);
        initialize(writableSheetImpl.getWorkbookSettings(), writableSheetImpl.getWorkbook(), writableSheetImpl.getWorkbook());
        writableSheetImpl.getWorkbook().addRCIRCell(this);
    }

    @Override // jxl.write.biff.CellValue, jxl.biff.WritableRecordData
    public byte[] getData() {
        byte[] data = super.getData();
        byte[] formulaData = getFormulaData();
        byte[] bArr = new byte[formulaData.length + data.length];
        System.arraycopy(data, 0, bArr, 0, data.length);
        System.arraycopy(formulaData, 0, bArr, data.length, formulaData.length);
        return bArr;
    }

    @Override // jxl.Cell
    public CellType getType() {
        return CellType.ERROR;
    }

    @Override // jxl.Cell
    public String getContents() {
        return this.formulaString;
    }

    @Override // jxl.biff.FormulaData
    public byte[] getFormulaData() {
        byte[] bArr = this.formulaBytes;
        byte[] bArr2 = new byte[bArr.length + 16];
        System.arraycopy(bArr, 0, bArr2, 16, bArr.length);
        bArr2[6] = 16;
        bArr2[7] = 64;
        bArr2[12] = -32;
        bArr2[13] = -4;
        bArr2[8] = (byte) (bArr2[8] | 2);
        IntegerHelper.getTwoBytes(this.formulaBytes.length, bArr2, 14);
        return bArr2;
    }

    public WritableCell copyTo(int i, int i2) {
        Assert.verify(false);
        return null;
    }

    @Override // jxl.write.biff.CellValue
    void columnInserted(Sheet sheet, int i, int i2) {
        this.parser.columnInserted(i, i2, sheet == getSheet());
        this.formulaBytes = this.parser.getBytes();
    }

    @Override // jxl.write.biff.CellValue
    void columnRemoved(Sheet sheet, int i, int i2) {
        this.parser.columnRemoved(i, i2, sheet == getSheet());
        this.formulaBytes = this.parser.getBytes();
    }

    @Override // jxl.write.biff.CellValue
    void rowInserted(Sheet sheet, int i, int i2) {
        this.parser.rowInserted(i, i2, sheet == getSheet());
        this.formulaBytes = this.parser.getBytes();
    }

    @Override // jxl.write.biff.CellValue
    void rowRemoved(Sheet sheet, int i, int i2) {
        this.parser.rowRemoved(i, i2, sheet == getSheet());
        this.formulaBytes = this.parser.getBytes();
    }
}
