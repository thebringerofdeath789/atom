package com.logan.flight.type;

import com.ipotensic.baselib.record.AtomSERecord;
import com.ipotensic.baselib.record.BaseRecord;
import com.ipotensic.baselib.utils.CommonUtil;
import com.logan.flight.C2962R;
import com.logan.flight.FlightConfig;
import com.logan.flight.data.FlightRevData;

/* loaded from: classes.dex */
public class Config_ATOM_SE_V2 implements BaseConfig {
    @Override // com.logan.flight.type.BaseConfig
    public byte getFlightByte() {
        return FlightConfig.ATOM_SE_V2;
    }

    @Override // com.logan.flight.type.BaseConfig
    public String getFlightModel() {
        return "MiniSE";
    }

    @Override // com.logan.flight.type.BaseConfig
    public String getFlightName() {
        return FlightConfig.PRODUCT_CLASS_ATOM_SE_V2;
    }

    @Override // com.logan.flight.type.BaseConfig
    public String getFlightTypeString() {
        return FlightConfig.TYPE_ATOM_SE;
    }

    @Override // com.logan.flight.type.BaseConfig
    public byte getGimbalByte() {
        return (byte) -1;
    }

    @Override // com.logan.flight.type.BaseConfig
    public String getLogName() {
        return "AtomSE_V2";
    }

    @Override // com.logan.flight.type.BaseConfig
    public int getMaxDistance() {
        return 4000;
    }

    @Override // com.logan.flight.type.BaseConfig
    public int getMaxDrawDistance() {
        return 500;
    }

    @Override // com.logan.flight.type.BaseConfig
    public int getMaxReturnHeight() {
        return 120;
    }

    @Override // com.logan.flight.type.BaseConfig
    public String getProductClass() {
        return FlightConfig.PRODUCT_CLASS_ATOM_SE_V2;
    }

    @Override // com.logan.flight.type.BaseConfig
    public byte getRcByte() {
        return FlightConfig.ATOM_SE_RC;
    }

    @Override // com.logan.flight.type.BaseConfig
    public byte getTofByte() {
        return (byte) -1;
    }

    @Override // com.logan.flight.type.BaseConfig
    public boolean isUsb() {
        return true;
    }

    @Override // com.logan.flight.type.BaseConfig
    public byte[] getBatteryBytes() {
        return new byte[]{112, 113, 114};
    }

    @Override // com.logan.flight.type.BaseConfig
    public int getMaxHeight() {
        return CommonUtil.hasNewVersion("3.0.7", FlightRevData.get().getFlightRevVersionData().getFlightControlVersion()) ? 800 : 120;
    }

    @Override // com.logan.flight.type.BaseConfig
    public int getFlightBg() {
        return C2962R.mipmap.img_bg_main_device_mini_se;
    }

    @Override // com.logan.flight.type.BaseConfig
    public BaseRecord newFlightRecorder() {
        return new AtomSERecord();
    }
}