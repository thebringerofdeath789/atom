package com.logan.flight.type;

import com.ipotensic.baselib.record.AtomLTRecord;
import com.ipotensic.baselib.record.BaseRecord;
import com.logan.flight.FlightConfig;
import com.logan.flight.R;

/* loaded from: classes.dex */
public class Config_ATOM_LT implements BaseConfig {
    @Override // com.logan.flight.type.BaseConfig
    public byte getFlightByte() {
        return FlightConfig.ATOM_LT;
    }

    @Override // com.logan.flight.type.BaseConfig
    public String getFlightModel() {
        return FlightConfig.MODEL_ATOM_LT;
    }

    @Override // com.logan.flight.type.BaseConfig
    public String getFlightName() {
        return FlightConfig.PRODUCT_CLASS_ATOM_LT;
    }

    @Override // com.logan.flight.type.BaseConfig
    public String getFlightTypeString() {
        return FlightConfig.TYPE_ATOM_LT;
    }

    @Override // com.logan.flight.type.BaseConfig
    public byte getGimbalByte() {
        return (byte) -1;
    }

    @Override // com.logan.flight.type.BaseConfig
    public String getLogName() {
        return FlightConfig.LOG_NAME_ATOMLT;
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
    public int getMaxHeight() {
        return 800;
    }

    @Override // com.logan.flight.type.BaseConfig
    public int getMaxReturnHeight() {
        return 120;
    }

    @Override // com.logan.flight.type.BaseConfig
    public String getProductClass() {
        return FlightConfig.PRODUCT_CLASS_ATOM_LT;
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
    public int getFlightBg() {
        return R.mipmap.img_bg_main_device_mini_lt;
    }

    @Override // com.logan.flight.type.BaseConfig
    public BaseRecord newFlightRecorder() {
        return new AtomLTRecord();
    }
}
