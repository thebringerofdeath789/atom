package com.mapbox.android.telemetry.errors;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import androidx.core.app.JobIntentService;

/* loaded from: classes3.dex */
public final class ErrorReporterJobIntentService extends JobIntentService {
    private static final int JOB_ID = 666;
    private static final String LOG_TAG = "CrashJobIntentService";

    static void enqueueWork(Context context) {
        enqueueWork(context, (Class<?>) ErrorReporterJobIntentService.class, JOB_ID, new Intent(context, (Class<?>) ErrorReporterJobIntentService.class));
    }

    @Override // androidx.core.app.JobIntentService
    protected void onHandleWork(Intent intent) {
        Log.d(LOG_TAG, "onHandleWork");
        try {
            ErrorReporterEngine.sendReports(getApplicationContext());
        } catch (Throwable th) {
            Log.e(LOG_TAG, th.toString());
        }
    }
}
