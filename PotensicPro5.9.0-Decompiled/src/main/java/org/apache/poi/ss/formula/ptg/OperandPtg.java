package org.apache.poi.ss.formula.ptg;

/* loaded from: classes5.dex */
public abstract class OperandPtg extends Ptg implements Cloneable {
    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public final boolean isBaseToken() {
        return false;
    }

    public final OperandPtg copy() {
        try {
            return (OperandPtg) clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
