package com.mapbox.android.telemetry.location;

import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.os.Build;
import android.util.Log;
import com.mapbox.android.core.location.LocationEngineResult;
import com.mapbox.android.telemetry.MapboxTelemetry;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class LocationUpdatesBroadcastReceiver extends BroadcastReceiver {
    static final String ACTION_LOCATION_UPDATED = "com.mapbox.android.telemetry.location.locationupdatespendingintent.action.LOCATION_UPDATED";
    private static final String TAG = "LocationUpdateReceiver";
    private ActivityManager activityManager;
    private String appPackageName;

    /* renamed from: com.mapbox.android.telemetry.location.LocationUpdatesBroadcastReceiver$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$mapbox$android$telemetry$location$LocationUpdatesBroadcastReceiver$AppState;

        static {
            int[] iArr = new int[AppState.values().length];
            $SwitchMap$com$mapbox$android$telemetry$location$LocationUpdatesBroadcastReceiver$AppState = iArr;
            try {
                iArr[AppState.FOREGROUND.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$mapbox$android$telemetry$location$LocationUpdatesBroadcastReceiver$AppState[AppState.BACKGROUND.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    enum AppState {
        UNKNOWN,
        FOREGROUND,
        BACKGROUND;

        @Override // java.lang.Enum
        public String toString() {
            int i = AnonymousClass1.$SwitchMap$com$mapbox$android$telemetry$location$LocationUpdatesBroadcastReceiver$AppState[ordinal()];
            return i != 1 ? i != 2 ? "Unknown" : "Background" : "Foreground";
        }
    }

    private AppState getAppStatePreLollipop() {
        AppState appState = AppState.UNKNOWN;
        List<ActivityManager.RunningTaskInfo> runningTasks = this.activityManager.getRunningTasks(32);
        for (ActivityManager.RunningTaskInfo runningTaskInfo : runningTasks) {
            if (runningTaskInfo.topActivity != null && runningTaskInfo.topActivity.getPackageName().equals(this.appPackageName)) {
                appState = AppState.FOREGROUND;
            }
        }
        return (runningTasks.size() >= 32 || appState != AppState.UNKNOWN) ? appState : AppState.BACKGROUND;
    }

    private AppState getAppStateLollipopAndHigher() {
        AppState appState = AppState.BACKGROUND;
        Iterator<ActivityManager.AppTask> it = this.activityManager.getAppTasks().iterator();
        while (it.hasNext()) {
            if (it.next().getTaskInfo().id != -1) {
                appState = AppState.FOREGROUND;
            }
        }
        return appState;
    }

    private AppState getAppStateQAndHigher() {
        AppState appState = AppState.BACKGROUND;
        Iterator<ActivityManager.AppTask> it = this.activityManager.getAppTasks().iterator();
        while (it.hasNext()) {
            if (it.next().getTaskInfo().isRunning) {
                appState = AppState.FOREGROUND;
            }
        }
        return appState;
    }

    private AppState getAppState() {
        if (Build.VERSION.SDK_INT >= 29) {
            return getAppStateQAndHigher();
        }
        if (Build.VERSION.SDK_INT >= 21) {
            return getAppStateLollipopAndHigher();
        }
        return getAppStatePreLollipop();
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        try {
            if (intent == null) {
                Log.w(TAG, "intent == null");
                return;
            }
            this.activityManager = (ActivityManager) context.getSystemService("activity");
            this.appPackageName = context.getApplicationContext().getPackageName();
            if (ACTION_LOCATION_UPDATED.equals(intent.getAction())) {
                LocationEngineResult extractResult = LocationEngineResult.extractResult(intent);
                if (extractResult == null) {
                    Log.w(TAG, "LocationEngineResult == null");
                    return;
                }
                LocationCollectionClient locationCollectionClient = LocationCollectionClient.getInstance();
                MapboxTelemetry telemetry = locationCollectionClient.getTelemetry();
                String sessionId = locationCollectionClient.getSessionId();
                for (Location location : extractResult.getLocations()) {
                    if (!isThereAnyNaN(location) && !isThereAnyInfinite(location)) {
                        telemetry.push(LocationMapper.create(location, getAppState().toString(), sessionId));
                    }
                }
            }
        } catch (Throwable th) {
            Log.e(TAG, th.toString());
        }
    }

    private static boolean isThereAnyNaN(Location location) {
        return Double.isNaN(location.getLatitude()) || Double.isNaN(location.getLongitude()) || Double.isNaN(location.getAltitude()) || Float.isNaN(location.getAccuracy());
    }

    private static boolean isThereAnyInfinite(Location location) {
        return Double.isInfinite(location.getLatitude()) || Double.isInfinite(location.getLongitude()) || Double.isInfinite(location.getAltitude()) || Float.isInfinite(location.getAccuracy());
    }
}
