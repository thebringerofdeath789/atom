package com.logan.flight.data.recv;

import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.netty.ParseUtil;
import com.logan.flight.FlightConfig;

/* loaded from: classes.dex */
public class FlightRevRemoteCtrlInfoData extends BaseFlightRevData {
    private byte remoteCtrlModel;
    private String remoteCtrlVersion;
    private String remoteSN = null;

    @Override // com.logan.flight.data.recv.BaseFlightRevData
    protected void parseData(byte[] bArr, int i) {
        this.remoteCtrlModel = bArr[i];
        DDLog.m1684e("遥控器 飞机类型:" + ParseUtil.byteToHexString(new byte[]{this.remoteCtrlModel}));
        FlightConfig.setFlightType(this.remoteCtrlModel);
        this.remoteCtrlVersion = ParseUtil.getUnsignedByte(bArr[i + 1]) + "." + ParseUtil.getUnsignedByte(bArr[i + 2]) + "." + ParseUtil.getUnsignedByte(bArr[i + 3]);
        if (bArr.length >= i + 17) {
            this.remoteSN = ParseUtil.byteToHexString(bArr, i + 4, 12);
        }
    }

    public byte getRemoteCtrlModel() {
        return this.remoteCtrlModel;
    }

    public String getRemoteCtrlVersion() {
        return this.remoteCtrlVersion;
    }

    public String getRemoteSN() {
        return this.remoteSN;
    }

    public String toString() {
        return "FlightRevRemoteCtrlInfoData{遥控器型号=" + ((int) this.remoteCtrlModel) + ", 遥控器版本号='" + this.remoteCtrlVersion + "',遥控器SN" + this.remoteSN + '}';
    }
}