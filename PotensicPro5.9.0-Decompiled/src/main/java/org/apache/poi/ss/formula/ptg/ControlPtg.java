package org.apache.poi.ss.formula.ptg;

/* loaded from: classes5.dex */
public abstract class ControlPtg extends Ptg {
    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public boolean isBaseToken() {
        return true;
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public final byte getDefaultOperandClass() {
        throw new IllegalStateException("Control tokens are not classified");
    }
}
