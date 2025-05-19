package com.mapbox.android.telemetry;

import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
class ComServerInformation implements EnvironmentResolver {
    private final String LOG_TAG = "ComServerInformation";
    private final String DIGEST = "SHA-256";
    private final String KEY_META_DATA_COM_SERVER = "com.mapbox.ComEventsServer";
    private List<String> configurationList = new ArrayList<String>() { // from class: com.mapbox.android.telemetry.ComServerInformation.1
        {
            add("FVQ3CP/SEI8eLPxHJnjyew2P5DTC1OBKK4Y6XkmC0WI=");
        }
    };

    @Override // com.mapbox.android.telemetry.EnvironmentResolver
    public void nextChain(EnvironmentResolver environmentResolver) {
    }

    ComServerInformation() {
    }

    @Override // com.mapbox.android.telemetry.EnvironmentResolver
    public ServerInformation obtainServerInformation(Bundle bundle) {
        ServerInformation serverInformation = new ServerInformation(Environment.COM);
        String string = bundle.getString("com.mapbox.ComEventsServer");
        if (!TelemetryUtils.isEmpty(string)) {
            String obtainHash = obtainHash(string);
            if (!TelemetryUtils.isEmpty(obtainHash) && this.configurationList.contains(obtainHash)) {
                serverInformation.setHostname(string);
            }
        }
        return serverInformation;
    }

    private String obtainHash(String str) {
        try {
            return Base64.encodeToString(MessageDigest.getInstance("SHA-256").digest(str.getBytes()), 2);
        } catch (Exception e) {
            Log.d("ComServerInformation", String.format("Hostname error %s", e.getMessage()));
            return null;
        }
    }

    void setConfigurationList(List<String> list) {
        this.configurationList = list;
    }
}
