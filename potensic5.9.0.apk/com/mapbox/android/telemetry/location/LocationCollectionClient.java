package com.mapbox.android.telemetry.location;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.Log;
import com.mapbox.android.core.location.LocationEngineProvider;
import com.mapbox.android.telemetry.BuildConfig;
import com.mapbox.android.telemetry.MapboxTelemetry;
import com.mapbox.android.telemetry.MapboxTelemetryConstants;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public class LocationCollectionClient implements SharedPreferences.OnSharedPreferenceChangeListener {
    public static final int DEFAULT_SESSION_ROTATION_INTERVAL_HOURS = 24;
    private static final int LOCATION_COLLECTION_STATUS_UPDATED = 0;
    private static final String LOCATION_COLLECTOR_USER_AGENT = "mapbox-android-location";
    private static final String TAG = "LocationCollectionCli";
    private static LocationCollectionClient locationCollectionClient;
    private static final Object lock = new Object();
    private final AtomicBoolean isEnabled = new AtomicBoolean(false);
    final LocationEngineController locationEngineController;
    private final AtomicReference<SessionIdentifier> sessionIdentifier;
    private Handler settingsChangeHandler;
    private final HandlerThread settingsChangeHandlerThread;
    private final SharedPreferences sharedPreferences;
    private final MapboxTelemetry telemetry;

    LocationCollectionClient(LocationEngineController locationEngineController, HandlerThread handlerThread, SessionIdentifier sessionIdentifier, SharedPreferences sharedPreferences, MapboxTelemetry mapboxTelemetry) {
        AtomicReference<SessionIdentifier> atomicReference = new AtomicReference<>();
        this.sessionIdentifier = atomicReference;
        this.locationEngineController = locationEngineController;
        this.settingsChangeHandlerThread = handlerThread;
        atomicReference.set(sessionIdentifier);
        this.telemetry = mapboxTelemetry;
        handlerThread.start();
        this.settingsChangeHandler = new Handler(handlerThread.getLooper()) { // from class: com.mapbox.android.telemetry.location.LocationCollectionClient.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                try {
                    LocationCollectionClient.this.handleSettingsChangeMessage(message);
                } catch (Throwable th) {
                    Log.e(LocationCollectionClient.TAG, th.toString());
                }
            }
        };
        this.sharedPreferences = sharedPreferences;
        initializeSharedPreferences(sharedPreferences);
    }

    public static LocationCollectionClient install(Context context, long j) {
        if (context.getApplicationContext() != null) {
            context = context.getApplicationContext();
        }
        synchronized (lock) {
            if (locationCollectionClient == null) {
                locationCollectionClient = new LocationCollectionClient(new LocationEngineControllerImpl(context, LocationEngineProvider.getBestLocationEngine(context), new LocationUpdatesBroadcastReceiver()), new HandlerThread("LocationSettingsChangeThread"), new SessionIdentifier(j), context.getSharedPreferences("MapboxSharedPreferences", 0), new MapboxTelemetry(context, "", String.format("%s/%s", LOCATION_COLLECTOR_USER_AGENT, BuildConfig.VERSION_NAME)));
            }
        }
        return locationCollectionClient;
    }

    static boolean uninstall() {
        boolean z;
        synchronized (lock) {
            LocationCollectionClient locationCollectionClient2 = locationCollectionClient;
            if (locationCollectionClient2 != null) {
                locationCollectionClient2.locationEngineController.onDestroy();
                locationCollectionClient.settingsChangeHandlerThread.quit();
                LocationCollectionClient locationCollectionClient3 = locationCollectionClient;
                locationCollectionClient3.sharedPreferences.unregisterOnSharedPreferenceChangeListener(locationCollectionClient3);
                locationCollectionClient = null;
                z = true;
            } else {
                z = false;
            }
        }
        return z;
    }

    static LocationCollectionClient getInstance() {
        LocationCollectionClient locationCollectionClient2;
        synchronized (lock) {
            locationCollectionClient2 = locationCollectionClient;
            if (locationCollectionClient2 == null) {
                throw new IllegalStateException("LocationCollectionClient is not installed.");
            }
        }
        return locationCollectionClient2;
    }

    void setSessionRotationInterval(long j) {
        this.sessionIdentifier.set(new SessionIdentifier(j));
    }

    long getSessionRotationInterval() {
        return this.sessionIdentifier.get().getInterval();
    }

    String getSessionId() {
        return this.sessionIdentifier.get().getSessionId();
    }

    boolean isEnabled() {
        return this.isEnabled.get();
    }

    void setEnabled(boolean z) {
        if (this.isEnabled.compareAndSet(!z, z)) {
            this.settingsChangeHandler.sendEmptyMessage(0);
        }
    }

    MapboxTelemetry getTelemetry() {
        return this.telemetry;
    }

    void setMockHandler(Handler handler) {
        this.settingsChangeHandler = handler;
    }

    void handleSettingsChangeMessage(Message message) {
        if (message.what != 0) {
            return;
        }
        if (isEnabled()) {
            this.locationEngineController.onResume();
            this.telemetry.enable();
        } else {
            this.locationEngineController.onDestroy();
            this.telemetry.disable();
        }
    }

    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        try {
            if (MapboxTelemetryConstants.LOCATION_COLLECTOR_ENABLED.equals(str)) {
                setEnabled(sharedPreferences.getBoolean(MapboxTelemetryConstants.LOCATION_COLLECTOR_ENABLED, false));
            } else if (MapboxTelemetryConstants.SESSION_ROTATION_INTERVAL_MILLIS.equals(str)) {
                setSessionRotationInterval(sharedPreferences.getLong(MapboxTelemetryConstants.SESSION_ROTATION_INTERVAL_MILLIS, TimeUnit.HOURS.toMillis(24L)));
            }
        } catch (Exception e) {
            Log.e(TAG, e.toString());
        }
    }

    private void initializeSharedPreferences(SharedPreferences sharedPreferences) {
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putBoolean(MapboxTelemetryConstants.LOCATION_COLLECTOR_ENABLED, this.isEnabled.get());
        edit.putLong(MapboxTelemetryConstants.SESSION_ROTATION_INTERVAL_MILLIS, this.sessionIdentifier.get().getInterval());
        edit.apply();
        sharedPreferences.registerOnSharedPreferenceChangeListener(this);
    }
}