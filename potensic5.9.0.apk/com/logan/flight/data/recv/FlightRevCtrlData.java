package com.logan.flight.data.recv;

import com.ipotensic.baselib.netty.ParseUtil;
import com.logan.flight.enums.CtrlType;

/* loaded from: classes.dex */
public class FlightRevCtrlData extends BaseFlightRevData {
    private CtrlType ctrlType = null;

    @Override // com.logan.flight.data.recv.BaseFlightRevData
    protected void parseData(byte[] bArr, int i) {
        int unsignedShortFromByteArr = ParseUtil.getUnsignedShortFromByteArr(bArr, i);
        int intFromByteArr = ParseUtil.getIntFromByteArr(bArr, i + 4);
        for (CtrlType ctrlType : CtrlType.values()) {
            if (ctrlType.command == unsignedShortFromByteArr && ctrlType.result_param2 == intFromByteArr) {
                this.ctrlType = ctrlType;
                return;
            }
        }
    }

    public CtrlType getCtrlType() {
        return this.ctrlType;
    }

    public String toString() {
        return "FlightRevCtrlData{功能类型=" + this.ctrlType + '}';
    }
}