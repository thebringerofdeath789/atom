package com.logan.camera.enums;

import com.logan.flight.type.BaseConfig;
import com.logan.flight.type.Config_ATOM;
import com.logan.flight.type.Config_ATOM_LT;
import com.logan.flight.type.Config_ATOM_SE_V2;
import com.logan.flight.type.Config_ATOM_SE_V3;
import com.logan.flight.type.Config_ATOM_V2;

/* loaded from: classes2.dex */
public enum BigPackageFlight {
    atomlt(new Config_ATOM_LT()),
    atom(new Config_ATOM()),
    atomv2(new Config_ATOM_V2()),
    atomsev2(new Config_ATOM_SE_V2()),
    atomsev3(new Config_ATOM_SE_V3());

    private final BaseConfig config;

    BigPackageFlight(BaseConfig baseConfig) {
        this.config = baseConfig;
    }

    public static BigPackageFlight getFlightByName(String str) {
        for (BigPackageFlight bigPackageFlight : values()) {
            if (bigPackageFlight.toString().equals(str)) {
                return bigPackageFlight;
            }
        }
        return null;
    }

    public String getProductClass() {
        return this.config.getProductClass();
    }
}