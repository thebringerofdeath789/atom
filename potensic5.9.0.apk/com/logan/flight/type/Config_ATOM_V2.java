package com.logan.flight.type;

import com.ipotensic.baselib.record.AtomRecord;
import com.ipotensic.baselib.record.BaseRecord;
import com.logan.flight.C2962R;
import com.logan.flight.FlightConfig;

/* loaded from: classes.dex */
public class Config_ATOM_V2 implements BaseConfig {
    @Override // com.logan.flight.type.BaseConfig
    public byte getFlightByte() {
        return FlightConfig.ATOM_V2;
    }

    @Override // com.logan.flight.type.BaseConfig
    public String getFlightModel() {
        return "Mini";
    }

    @Override // com.logan.flight.type.BaseConfig
    public String getFlightName() {
        return "Atom V2";
    }

    @Override // com.logan.flight.type.BaseConfig
    public String getFlightTypeString() {
        return "Atom";
    }

    @Override // com.logan.flight.type.BaseConfig
    public byte getGimbalByte() {
        return FlightConfig.ATOM_GIMBAL;
    }

    @Override // com.logan.flight.type.BaseConfig
    public String getLogName() {
        return "Atom_V2";
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
        return "AtomV2";
    }

    @Override // com.logan.flight.type.BaseConfig
    public byte getRcByte() {
        return FlightConfig.ATOM_RC;
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
        return C2962R.mipmap.img_bg_main_device_mini;
    }

    @Override // com.logan.flight.type.BaseConfig
    public BaseRecord newFlightRecorder() {
        return new AtomRecord();
    }
}