package com.ipotensic.kernel.enums;

import com.logan.flight.FlightConfig;

/* loaded from: classes2.dex */
public enum FwType {
    ITA("ita"),
    ITG("itg"),
    RC("rc"),
    FCS("fcs"),
    GIMBAL(FlightConfig.PRODUCT_CLASS_P1_PRO_GIMBAL),
    ESC("esc"),
    BMS("bms"),
    CAM("cam"),
    NONE("none");

    String type;

    FwType(String str) {
        this.type = str;
    }
}
