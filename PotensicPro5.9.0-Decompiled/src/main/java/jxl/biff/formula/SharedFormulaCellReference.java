package jxl.biff.formula;

import jxl.Cell;
import jxl.biff.CellReferenceHelper;
import jxl.biff.IntegerHelper;

/* loaded from: classes4.dex */
class SharedFormulaCellReference extends Operand implements ParsedThing {
    private int column;
    private boolean columnRelative;
    private Cell relativeTo;
    private int row;
    private boolean rowRelative;

    public SharedFormulaCellReference(Cell cell) {
        this.relativeTo = cell;
    }

    @Override // jxl.biff.formula.ParsedThing
    public int read(byte[] bArr, int i) {
        this.row = IntegerHelper.getShort(bArr[i], bArr[i + 1]);
        int i2 = IntegerHelper.getInt(bArr[i + 2], bArr[i + 3]);
        this.column = (byte) (i2 & 255);
        boolean z = (i2 & 16384) != 0;
        this.columnRelative = z;
        this.rowRelative = (i2 & 32768) != 0;
        if (z) {
            this.column = this.relativeTo.getColumn() + this.column;
        }
        if (!this.rowRelative) {
            return 4;
        }
        this.row = this.relativeTo.getRow() + this.row;
        return 4;
    }

    public int getColumn() {
        return this.column;
    }

    public int getRow() {
        return this.row;
    }

    @Override // jxl.biff.formula.ParseItem
    public void getString(StringBuffer stringBuffer) {
        CellReferenceHelper.getCellReference(this.column, this.row, stringBuffer);
    }

    @Override // jxl.biff.formula.ParseItem
    byte[] getBytes() {
        byte[] bArr = new byte[5];
        bArr[0] = Token.REF.getCode();
        IntegerHelper.getTwoBytes(this.row, bArr, 1);
        int i = this.column;
        if (this.columnRelative) {
            i |= 16384;
        }
        if (this.rowRelative) {
            i |= 32768;
        }
        IntegerHelper.getTwoBytes(i, bArr, 3);
        return bArr;
    }
}
