package jxl.read.biff;

import common.Logger;
import java.util.ArrayList;
import jxl.Cell;
import jxl.CellType;
import jxl.biff.FormattingRecords;
import jxl.biff.IntegerHelper;
import jxl.biff.WorkbookMethods;
import jxl.biff.formula.ExternalSheet;

/* loaded from: classes4.dex */
class SharedFormulaRecord {
    static /* synthetic */ Class class$jxl$read$biff$SharedFormulaRecord;
    private static Logger logger;
    private ExternalSheet externalSheet;
    private int firstCol;
    private int firstRow;
    private ArrayList formulas;
    private int lastCol;
    private int lastRow;
    private SheetImpl sheet;
    private BaseSharedFormulaRecord templateFormula;
    private byte[] tokens;

    static {
        Class cls = class$jxl$read$biff$SharedFormulaRecord;
        if (cls == null) {
            cls = class$("jxl.read.biff.SharedFormulaRecord");
            class$jxl$read$biff$SharedFormulaRecord = cls;
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

    public SharedFormulaRecord(Record record, BaseSharedFormulaRecord baseSharedFormulaRecord, ExternalSheet externalSheet, WorkbookMethods workbookMethods, SheetImpl sheetImpl) {
        this.sheet = sheetImpl;
        byte[] data = record.getData();
        this.firstRow = IntegerHelper.getInt(data[0], data[1]);
        this.lastRow = IntegerHelper.getInt(data[2], data[3]);
        this.firstCol = data[4] & 255;
        this.lastCol = data[5] & 255;
        this.formulas = new ArrayList();
        this.templateFormula = baseSharedFormulaRecord;
        byte[] bArr = new byte[data.length - 10];
        this.tokens = bArr;
        System.arraycopy(data, 10, bArr, 0, bArr.length);
    }

    public boolean add(BaseSharedFormulaRecord baseSharedFormulaRecord) {
        int column;
        int row = baseSharedFormulaRecord.getRow();
        if (row < this.firstRow || row > this.lastRow || (column = baseSharedFormulaRecord.getColumn()) < this.firstCol || column > this.lastCol) {
            return false;
        }
        this.formulas.add(baseSharedFormulaRecord);
        return true;
    }

    Cell[] getFormulas(FormattingRecords formattingRecords, boolean z) {
        Cell[] cellArr = new Cell[this.formulas.size() + 1];
        BaseSharedFormulaRecord baseSharedFormulaRecord = this.templateFormula;
        int i = 0;
        if (baseSharedFormulaRecord == null) {
            logger.warn("Shared formula template formula is null");
            return new Cell[0];
        }
        baseSharedFormulaRecord.setTokens(this.tokens);
        if (this.templateFormula.getType() == CellType.NUMBER_FORMULA) {
            SharedNumberFormulaRecord sharedNumberFormulaRecord = (SharedNumberFormulaRecord) this.templateFormula;
            sharedNumberFormulaRecord.getNumberFormat();
            if (formattingRecords.isDate(this.templateFormula.getXFIndex())) {
                SharedDateFormulaRecord sharedDateFormulaRecord = new SharedDateFormulaRecord(sharedNumberFormulaRecord, formattingRecords, z, this.sheet, sharedNumberFormulaRecord.getFilePos());
                this.templateFormula = sharedDateFormulaRecord;
                sharedDateFormulaRecord.setTokens(sharedNumberFormulaRecord.getTokens());
            }
        }
        cellArr[0] = this.templateFormula;
        while (i < this.formulas.size()) {
            BaseSharedFormulaRecord baseSharedFormulaRecord2 = (BaseSharedFormulaRecord) this.formulas.get(i);
            if (baseSharedFormulaRecord2.getType() == CellType.NUMBER_FORMULA) {
                SharedNumberFormulaRecord sharedNumberFormulaRecord2 = (SharedNumberFormulaRecord) baseSharedFormulaRecord2;
                if (formattingRecords.isDate(baseSharedFormulaRecord2.getXFIndex())) {
                    baseSharedFormulaRecord2 = new SharedDateFormulaRecord(sharedNumberFormulaRecord2, formattingRecords, z, this.sheet, sharedNumberFormulaRecord2.getFilePos());
                }
            }
            baseSharedFormulaRecord2.setTokens(this.tokens);
            i++;
            cellArr[i] = baseSharedFormulaRecord2;
        }
        return cellArr;
    }

    BaseSharedFormulaRecord getTemplateFormula() {
        return this.templateFormula;
    }
}
