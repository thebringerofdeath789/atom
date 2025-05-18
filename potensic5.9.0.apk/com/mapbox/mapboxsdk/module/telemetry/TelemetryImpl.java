package com.mapbox.mapboxsdk.module.telemetry;

import android.content.Context;
import android.os.Bundle;
import com.mapbox.android.accounts.p021v1.MapboxAccounts;
import com.mapbox.android.telemetry.AppUserTurnstile;
import com.mapbox.android.telemetry.MapboxTelemetry;
import com.mapbox.android.telemetry.SessionInterval;
import com.mapbox.android.telemetry.TelemetryEnabler;
import com.mapbox.mapboxsdk.BuildConfig;
import com.mapbox.mapboxsdk.Mapbox;
import com.mapbox.mapboxsdk.maps.TelemetryDefinition;
import com.mapbox.mapboxsdk.offline.OfflineRegionDefinition;
import java.util.UUID;

/* loaded from: classes3.dex */
public class TelemetryImpl implements TelemetryDefinition {
    private final Context appContext;
    private final MapboxTelemetry telemetry;

    @Override // com.mapbox.mapboxsdk.maps.TelemetryDefinition
    @Deprecated
    public void onGestureInteraction(String str, double d, double d2, double d3) {
    }

    public TelemetryImpl() {
        Context applicationContext = Mapbox.getApplicationContext();
        this.appContext = applicationContext;
        MapboxTelemetry mapboxTelemetry = new MapboxTelemetry(applicationContext, Mapbox.getAccessToken(), BuildConfig.MAPBOX_EVENTS_USER_AGENT);
        this.telemetry = mapboxTelemetry;
        if (TelemetryEnabler.State.ENABLED.equals(TelemetryEnabler.retrieveTelemetryStateFromPreferences())) {
            mapboxTelemetry.enable();
        }
    }

    @Override // com.mapbox.mapboxsdk.maps.TelemetryDefinition
    public void onAppUserTurnstileEvent() {
        AppUserTurnstile appUserTurnstile = new AppUserTurnstile(BuildConfig.MAPBOX_SDK_IDENTIFIER, BuildConfig.MAPBOX_SDK_VERSION);
        appUserTurnstile.setSkuId(MapboxAccounts.SKU_ID_MAPS_MAUS);
        this.telemetry.push(appUserTurnstile);
        this.telemetry.push(MapEventFactory.buildMapLoadEvent(new PhoneState(this.appContext)));
    }

    @Override // com.mapbox.mapboxsdk.maps.TelemetryDefinition
    public void setUserTelemetryRequestState(boolean z) {
        if (z) {
            TelemetryEnabler.updateTelemetryState(TelemetryEnabler.State.ENABLED);
            this.telemetry.enable();
        } else {
            this.telemetry.disable();
            TelemetryEnabler.updateTelemetryState(TelemetryEnabler.State.DISABLED);
        }
    }

    @Override // com.mapbox.mapboxsdk.maps.TelemetryDefinition
    public void disableTelemetrySession() {
        this.telemetry.disable();
    }

    @Override // com.mapbox.mapboxsdk.maps.TelemetryDefinition
    public void setDebugLoggingEnabled(boolean z) {
        this.telemetry.updateDebugLoggingEnabled(z);
    }

    @Override // com.mapbox.mapboxsdk.maps.TelemetryDefinition
    public boolean setSessionIdRotationInterval(int i) {
        return this.telemetry.updateSessionIdRotationInterval(new SessionInterval(i));
    }

    @Override // com.mapbox.mapboxsdk.maps.TelemetryDefinition
    public void onCreateOfflineRegion(OfflineRegionDefinition offlineRegionDefinition) {
        this.telemetry.push(MapEventFactory.buildOfflineDownloadStartEvent(new PhoneState(this.appContext), offlineRegionDefinition.getType(), Double.valueOf(offlineRegionDefinition.getMinZoom()), Double.valueOf(offlineRegionDefinition.getMaxZoom()), offlineRegionDefinition.getStyleURL()));
    }

    @Override // com.mapbox.mapboxsdk.maps.TelemetryDefinition
    public void onPerformanceEvent(Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        this.telemetry.push(MapEventFactory.buildPerformanceEvent(new PhoneState(this.appContext), UUID.randomUUID().toString(), bundle));
    }
}