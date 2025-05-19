package org.apache.poi.ss.formula.ptg;

import org.apache.poi.util.LittleEndianInput;
import org.apache.poi.util.LittleEndianOutput;

/* loaded from: classes5.dex */
public final class RefNPtg extends Ref2DPtgBase {
    public static final byte sid = 44;

    @Override // org.apache.poi.ss.formula.ptg.Ref2DPtgBase
    protected byte getSid() {
        return (byte) 44;
    }

    @Override // org.apache.poi.ss.formula.ptg.Ref2DPtgBase, org.apache.poi.ss.formula.ptg.Ptg
    public /* bridge */ /* synthetic */ void write(LittleEndianOutput littleEndianOutput) {
        super.write(littleEndianOutput);
    }

    public RefNPtg(LittleEndianInput littleEndianInput) {
        super(littleEndianInput);
    }
}
