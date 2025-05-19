package com.logan.flight.data.recv;

import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.configs.UsbConfig;
import com.ipotensic.baselib.netty.ParseUtil;
import com.logan.flight.FlightConfig;
import com.logan.flight.type.Flight;

/* loaded from: classes.dex */
public class FlightRevFpvData extends BaseFlightRevData {
    private byte[] flightRecord;
    private String fpvVersion;
    private double imuTemp;
    private boolean isFpvData = false;
    private short functionCode = 0;
    private boolean isFlightLog = false;
    private Flight remoterType = null;

    @Override // com.logan.flight.data.recv.BaseFlightRevData
    protected void parseData(byte[] bArr, int i) {
        int i2 = i + 43;
        if (bArr.length >= i2) {
            this.functionCode = UsbConfig.getMsgId(bArr, 0);
            this.isFpvData = false;
            byte[] bArr2 = new byte[bArr.length - (i + 1)];
            this.flightRecord = bArr2;
            System.arraycopy(bArr, i, bArr2, 0, bArr2.length);
            this.isFlightLog = true;
            if (bArr.length >= i2) {
                this.imuTemp = ParseUtil.getSignedShortFromByteArr(bArr, i + 38) / 100.0d;
                return;
            }
            return;
        }
        this.isFlightLog = false;
        int unsignedShortFromByteArr = (short) (ParseUtil.getUnsignedShortFromByteArr(bArr, 2) - (i - 3));
        byte[] bArr3 = new byte[unsignedShortFromByteArr];
        System.arraycopy(bArr, i, bArr3, 0, unsignedShortFromByteArr);
        try {
            String str = new String(bArr3, "UTF-8");
            DDLog.e("飞机类型 图传版本号str:" + str);
            if (str.toLowerCase().contains(FlightConfig.PRODUCT_CLASS_P1_PRO.toLowerCase())) {
                this.fpvVersion = str.substring(11, 16);
                this.isFpvData = true;
            } else if (str.toLowerCase().contains("Mini-SEV2".toLowerCase())) {
                this.fpvVersion = str.substring(14, 19);
                this.isFpvData = true;
                FlightConfig.setFlightType(Flight.Flight_ATOM_SE_V2.getFlightByte());
                this.remoterType = Flight.Flight_ATOM_SE_V2;
            } else if (str.toLowerCase().contains("AtomSEV3".toLowerCase())) {
                this.fpvVersion = str.substring(13, 18);
                this.isFpvData = true;
                FlightConfig.setFlightType(Flight.Flight_ATOM_SE_V3.getFlightByte());
                this.remoterType = Flight.Flight_ATOM_SE_V3;
            } else if (str.toLowerCase().contains("Mini-SE".toLowerCase())) {
                this.fpvVersion = str.substring(12, 17);
                this.isFpvData = true;
                FlightConfig.setFlightType(Flight.Flight_ATOM_SE.getFlightByte());
                this.remoterType = Flight.Flight_ATOM_SE;
            } else if (str.toLowerCase().contains("Mini-LT".toLowerCase())) {
                this.fpvVersion = str.substring(12, 17);
                this.isFpvData = true;
                FlightConfig.setFlightType(Flight.Flight_ATOM_LT.getFlightByte());
                this.remoterType = Flight.Flight_ATOM_LT;
            } else if (str.toLowerCase().contains("Mini".toLowerCase())) {
                this.fpvVersion = str.substring(9, 14);
                this.isFpvData = true;
                FlightConfig.setFlightType(Flight.Flight_ATOM.getFlightByte());
                this.remoterType = Flight.Flight_ATOM;
            }
            DDLog.e("图传版本:" + this.fpvVersion);
        } catch (Exception e) {
            DDLog.e("图传解析出错e: " + e.getMessage());
        }
    }

    public Flight getRemoterType() {
        return this.remoterType;
    }

    public boolean isFlightLog() {
        return this.isFlightLog;
    }

    public double getImuTemp() {
        return this.imuTemp;
    }

    public short getFunctionCode() {
        return this.functionCode;
    }

    public byte[] getFlightRecord() {
        return this.flightRecord;
    }

    public String getFpvVersion() {
        return this.fpvVersion;
    }

    public boolean isFpvData() {
        return this.isFpvData;
    }

    public String toString() {
        return "FlightRevFpvData{fpvVersion=" + this.fpvVersion + '}';
    }
}
