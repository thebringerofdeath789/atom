package org.apache.poi.ss.formula.ptg;

import org.apache.poi.util.LittleEndianInput;
import org.apache.poi.util.LittleEndianOutput;

/* loaded from: classes5.dex */
public final class BoolPtg extends ScalarConstantPtg {
    public static final int SIZE = 2;
    public static final byte sid = 29;
    private final boolean _value;
    private static final BoolPtg FALSE = new BoolPtg(false);
    private static final BoolPtg TRUE = new BoolPtg(true);

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public int getSize() {
        return 2;
    }

    private BoolPtg(boolean z) {
        this._value = z;
    }

    public static BoolPtg valueOf(boolean z) {
        return z ? TRUE : FALSE;
    }

    public static BoolPtg read(LittleEndianInput littleEndianInput) {
        return valueOf(littleEndianInput.readByte() == 1);
    }

    public boolean getValue() {
        return this._value;
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public void write(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeByte(getPtgClass() + 29);
        littleEndianOutput.writeByte(this._value ? 1 : 0);
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public String toFormulaString() {
        return this._value ? "TRUE" : "FALSE";
    }
}
