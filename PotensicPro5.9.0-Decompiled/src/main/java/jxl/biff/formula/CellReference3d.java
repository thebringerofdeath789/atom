package jxl.biff.formula;

import common.Logger;
import jxl.Cell;
import jxl.biff.CellReferenceHelper;
import jxl.biff.IntegerHelper;

/* loaded from: classes4.dex */
class CellReference3d extends Operand implements ParsedThing {
    static /* synthetic */ Class class$jxl$biff$formula$CellReference3d;
    private static Logger logger;
    private int column;
    private boolean columnRelative;
    private Cell relativeTo;
    private int row;
    private boolean rowRelative;
    private int sheet;
    private ExternalSheet workbook;

    static {
        Class cls = class$jxl$biff$formula$CellReference3d;
        if (cls == null) {
            cls = class$("jxl.biff.formula.CellReference3d");
            class$jxl$biff$formula$CellReference3d = cls;
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

    public CellReference3d(Cell cell, ExternalSheet externalSheet) {
        this.relativeTo = cell;
        this.workbook = externalSheet;
    }

    public CellReference3d(String str, ExternalSheet externalSheet) throws FormulaException {
        this.workbook = externalSheet;
        this.columnRelative = true;
        this.rowRelative = true;
        int indexOf = str.indexOf(33);
        String substring = str.substring(indexOf + 1);
        this.column = CellReferenceHelper.getColumn(substring);
        this.row = CellReferenceHelper.getRow(substring);
        String substring2 = str.substring(0, indexOf);
        if (substring2.charAt(0) == '\'' && substring2.charAt(substring2.length() - 1) == '\'') {
            substring2 = substring2.substring(1, substring2.length() - 1);
        }
        int externalSheetIndex = externalSheet.getExternalSheetIndex(substring2);
        this.sheet = externalSheetIndex;
        if (externalSheetIndex < 0) {
            throw new FormulaException(FormulaException.SHEET_REF_NOT_FOUND, substring2);
        }
    }

    @Override // jxl.biff.formula.ParsedThing
    public int read(byte[] bArr, int i) {
        this.sheet = IntegerHelper.getInt(bArr[i], bArr[i + 1]);
        this.row = IntegerHelper.getInt(bArr[i + 2], bArr[i + 3]);
        int i2 = IntegerHelper.getInt(bArr[i + 4], bArr[i + 5]);
        this.column = i2 & 255;
        this.columnRelative = (i2 & 16384) != 0;
        this.rowRelative = (i2 & 32768) != 0;
        return 6;
    }

    public int getColumn() {
        return this.column;
    }

    public int getRow() {
        return this.row;
    }

    @Override // jxl.biff.formula.ParseItem
    public void getString(StringBuffer stringBuffer) {
        CellReferenceHelper.getCellReference(this.sheet, this.column, !this.columnRelative, this.row, !this.rowRelative, this.workbook, stringBuffer);
    }

    @Override // jxl.biff.formula.ParseItem
    byte[] getBytes() {
        byte[] bArr = new byte[7];
        bArr[0] = Token.REF3D.getCode();
        IntegerHelper.getTwoBytes(this.sheet, bArr, 1);
        IntegerHelper.getTwoBytes(this.row, bArr, 3);
        int i = this.column;
        if (this.rowRelative) {
            i |= 32768;
        }
        if (this.columnRelative) {
            i |= 16384;
        }
        IntegerHelper.getTwoBytes(i, bArr, 5);
        return bArr;
    }

    @Override // jxl.biff.formula.Operand, jxl.biff.formula.ParseItem
    public void adjustRelativeCellReferences(int i, int i2) {
        if (this.columnRelative) {
            this.column += i;
        }
        if (this.rowRelative) {
            this.row += i2;
        }
    }

    @Override // jxl.biff.formula.Operand, jxl.biff.formula.ParseItem
    public void columnInserted(int i, int i2, boolean z) {
        int i3;
        if (i == this.sheet && (i3 = this.column) >= i2) {
            this.column = i3 + 1;
        }
    }

    @Override // jxl.biff.formula.Operand, jxl.biff.formula.ParseItem
    void columnRemoved(int i, int i2, boolean z) {
        int i3;
        if (i == this.sheet && (i3 = this.column) >= i2) {
            this.column = i3 - 1;
        }
    }

    @Override // jxl.biff.formula.Operand, jxl.biff.formula.ParseItem
    void rowInserted(int i, int i2, boolean z) {
        int i3;
        if (i == this.sheet && (i3 = this.row) >= i2) {
            this.row = i3 + 1;
        }
    }

    @Override // jxl.biff.formula.Operand, jxl.biff.formula.ParseItem
    void rowRemoved(int i, int i2, boolean z) {
        int i3;
        if (i == this.sheet && (i3 = this.row) >= i2) {
            this.row = i3 - 1;
        }
    }
}
