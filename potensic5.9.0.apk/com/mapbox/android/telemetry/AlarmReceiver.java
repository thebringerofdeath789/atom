package com.mapbox.android.telemetry;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/* loaded from: classes3.dex */
class AlarmReceiver extends BroadcastReceiver {
    private static final String TAG = "AlarmReceiver";
    private final SchedulerCallback callback;

    AlarmReceiver(SchedulerCallback schedulerCallback) {
        this.callback = schedulerCallback;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        try {
            if ("com.mapbox.scheduler_flusher".equals(intent.getAction())) {
                this.callback.onPeriodRaised();
            }
        } catch (Throwable th) {
            Log.e(TAG, th.toString());
        }
    }

    Intent supplyIntent() {
        return new Intent("com.mapbox.scheduler_flusher");
    }
}