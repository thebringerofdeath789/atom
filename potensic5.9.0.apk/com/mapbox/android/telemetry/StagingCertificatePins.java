package com.mapbox.android.telemetry;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
class StagingCertificatePins {
    static final Map<String, List<String>> CERTIFICATE_PINS = new HashMap<String, List<String>>() { // from class: com.mapbox.android.telemetry.StagingCertificatePins.1
        {
            put(MapboxTelemetryConstants.DEFAULT_STAGING_EVENTS_HOST, new ArrayList<String>() { // from class: com.mapbox.android.telemetry.StagingCertificatePins.1.1
                {
                    add("3euxrJOrEZI15R4104UsiAkDqe007EPyZ6eTL/XxdAY=");
                    add("5kJvNEMw0KjrCAu7eXY5HZdvyCS13BbA0VJG1RSP91w=");
                    add("r/mIkG3eEpVdm+u/ko/cwxzOMo1bk4TyHIlByibiA5E=");
                }
            });
        }
    };

    StagingCertificatePins() {
    }
}