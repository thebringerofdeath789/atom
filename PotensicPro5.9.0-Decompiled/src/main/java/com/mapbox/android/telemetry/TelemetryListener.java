package com.mapbox.android.telemetry;

/* loaded from: classes3.dex */
public interface TelemetryListener {
    void onHttpFailure(String str);

    void onHttpResponse(boolean z, int i);
}
