package com.mapbox.android.telemetry;

import android.os.SystemClock;

/* loaded from: classes3.dex */
class Clock {
    Clock() {
    }

    long giveMeTheElapsedRealtime() {
        return SystemClock.elapsedRealtime();
    }
}