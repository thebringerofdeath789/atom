package org.apache.poi.ss.formula.ptg;

import org.apache.poi.util.LittleEndianOutput;

/* loaded from: classes5.dex */
public class UnknownPtg extends Ptg {
    private final int _sid;
    private short size = 1;

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public byte getDefaultOperandClass() {
        return (byte) 32;
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public boolean isBaseToken() {
        return true;
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public String toFormulaString() {
        return "UNKNOWN";
    }

    public UnknownPtg(int i) {
        this._sid = i;
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public void write(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeByte(this._sid);
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public int getSize() {
        return this.size;
    }
}
