package org.apache.poi.ss.formula.ptg;

import org.apache.poi.ss.usermodel.ErrorConstants;
import org.apache.poi.util.LittleEndianInput;
import org.apache.poi.util.LittleEndianOutput;

/* loaded from: classes5.dex */
public final class RefErrorPtg extends OperandPtg {
    private static final int SIZE = 5;
    public static final byte sid = 42;
    private int field_1_reserved;

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public byte getDefaultOperandClass() {
        return (byte) 0;
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public int getSize() {
        return 5;
    }

    public RefErrorPtg() {
        this.field_1_reserved = 0;
    }

    public RefErrorPtg(LittleEndianInput littleEndianInput) {
        this.field_1_reserved = littleEndianInput.readInt();
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public String toString() {
        return getClass().getName();
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public void write(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeByte(getPtgClass() + 42);
        littleEndianOutput.writeInt(this.field_1_reserved);
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public String toFormulaString() {
        return ErrorConstants.getText(23);
    }
}
