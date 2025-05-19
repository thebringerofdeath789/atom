package com.logan.flight.type;

import com.ipotensic.baselib.record.BaseRecord;

/* loaded from: classes.dex */
public interface BaseConfig {
    byte[] getBatteryBytes();

    int getFlightBg();

    byte getFlightByte();

    String getFlightModel();

    String getFlightName();

    String getFlightTypeString();

    byte getGimbalByte();

    String getLogName();

    int getMaxDistance();

    int getMaxDrawDistance();

    int getMaxHeight();

    int getMaxReturnHeight();

    String getProductClass();

    byte getRcByte();

    byte getTofByte();

    boolean isUsb();

    BaseRecord newFlightRecorder();
}
