package com.mapbox.android.telemetry;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class TelemetryEnabler {
    private static final String KEY_META_DATA_ENABLED = "com.mapbox.EnableEvents";
    static final String MAPBOX_SHARED_PREFERENCE_KEY_TELEMETRY_STATE = "mapboxTelemetryState";
    private State currentTelemetryState = State.ENABLED;
    private boolean isFromPreferences;
    static final Map<State, Boolean> TELEMETRY_STATES = new HashMap<State, Boolean>() { // from class: com.mapbox.android.telemetry.TelemetryEnabler.1
        {
            put(State.ENABLED, true);
            put(State.DISABLED, false);
        }
    };
    private static final Map<String, State> STATES = new HashMap<String, State>() { // from class: com.mapbox.android.telemetry.TelemetryEnabler.2
        {
            put(State.ENABLED.name(), State.ENABLED);
            put(State.DISABLED.name(), State.DISABLED);
        }
    };

    public enum State {
        ENABLED,
        DISABLED
    }

    TelemetryEnabler(boolean z) {
        this.isFromPreferences = true;
        this.isFromPreferences = z;
    }

    public static State retrieveTelemetryStateFromPreferences() {
        if (MapboxTelemetry.applicationContext == null) {
            return STATES.get(State.ENABLED.name());
        }
        return STATES.get(TelemetryUtils.obtainSharedPreferences(MapboxTelemetry.applicationContext).getString(MAPBOX_SHARED_PREFERENCE_KEY_TELEMETRY_STATE, State.ENABLED.name()));
    }

    public static State updateTelemetryState(State state) {
        if (MapboxTelemetry.applicationContext == null) {
            return state;
        }
        SharedPreferences.Editor edit = TelemetryUtils.obtainSharedPreferences(MapboxTelemetry.applicationContext).edit();
        edit.putString(MAPBOX_SHARED_PREFERENCE_KEY_TELEMETRY_STATE, state.name());
        edit.apply();
        return state;
    }

    State obtainTelemetryState() {
        if (this.isFromPreferences) {
            return retrieveTelemetryStateFromPreferences();
        }
        return this.currentTelemetryState;
    }

    State updatePreferences(State state) {
        if (this.isFromPreferences) {
            return updateTelemetryState(state);
        }
        this.currentTelemetryState = state;
        return state;
    }

    static boolean isEventsEnabled(Context context) {
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo != null && applicationInfo.metaData != null) {
                return applicationInfo.metaData.getBoolean(KEY_META_DATA_ENABLED, true);
            }
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return true;
    }
}