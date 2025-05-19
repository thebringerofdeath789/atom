package org.apache.poi.ss.formula.ptg;

import org.apache.poi.util.LittleEndianInput;
import org.apache.poi.util.LittleEndianOutput;

/* loaded from: classes5.dex */
public final class TblPtg extends ControlPtg {
    private static final int SIZE = 5;
    public static final short sid = 2;
    private final int field_1_first_row;
    private final int field_2_first_col;

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public int getSize() {
        return 5;
    }

    public TblPtg(LittleEndianInput littleEndianInput) {
        this.field_1_first_row = littleEndianInput.readUShort();
        this.field_2_first_col = littleEndianInput.readUShort();
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public void write(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeByte(getPtgClass() + 2);
        littleEndianOutput.writeShort(this.field_1_first_row);
        littleEndianOutput.writeShort(this.field_2_first_col);
    }

    public int getRow() {
        return this.field_1_first_row;
    }

    public int getColumn() {
        return this.field_2_first_col;
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public String toFormulaString() {
        throw new RuntimeException("Table and Arrays are not yet supported");
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("[Data Table - Parent cell is an interior cell in a data table]\n");
        stringBuffer.append("top left row = ").append(getRow()).append("\n");
        stringBuffer.append("top left col = ").append(getColumn()).append("\n");
        return stringBuffer.toString();
    }
}
