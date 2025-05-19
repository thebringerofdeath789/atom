package org.apache.poi.ss.formula.ptg;

import com.logan.usb.UsbCameraHandler;
import org.apache.poi.util.LittleEndianInput;

/* loaded from: classes5.dex */
public final class AreaNPtg extends Area2DPtgBase {
    public static final short sid = 45;

    @Override // org.apache.poi.ss.formula.ptg.Area2DPtgBase
    protected byte getSid() {
        return UsbCameraHandler.MSG_ID_SET_TARGET;
    }

    public AreaNPtg(LittleEndianInput littleEndianInput) {
        super(littleEndianInput);
    }
}
