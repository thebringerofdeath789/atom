package com.mapbox.android.telemetry.errors;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.mapbox.android.core.FileUtils;
import com.mapbox.android.telemetry.CrashEvent;
import com.mapbox.android.telemetry.MapboxTelemetryConstants;
import java.io.File;
import java.util.concurrent.ExecutorService;

/* loaded from: classes3.dex */
public final class ErrorReporterEngine {
    private static final String LOG_TAG = "CrashReporter";

    public static void sendErrorReports(final Context context, ExecutorService executorService) {
        if (Build.VERSION.SDK_INT < 26) {
            LocalBroadcastManager.getInstance(context).sendBroadcast(new Intent(MapboxTelemetryConstants.ACTION_TOKEN_CHANGED));
            return;
        }
        try {
            executorService.execute(new Runnable() { // from class: com.mapbox.android.telemetry.errors.ErrorReporterEngine.1
                @Override // java.lang.Runnable
                public void run() {
                    ErrorReporterEngine.sendReports(context);
                }
            });
        } catch (Throwable th) {
            Log.e(LOG_TAG, th.toString());
        }
    }

    static void sendReports(Context context) {
        if (context == null || context.getApplicationContext() == null) {
            return;
        }
        File file = FileUtils.getFile(context.getApplicationContext(), "com.mapbox.android.telemetry");
        if (!file.exists()) {
            Log.w(LOG_TAG, "Root directory doesn't exist");
        } else {
            handleErrorReports(ErrorReporterClient.create(context.getApplicationContext()).loadFrom(file));
        }
    }

    static void handleErrorReports(ErrorReporterClient errorReporterClient) {
        if (!errorReporterClient.isEnabled()) {
            Log.w(LOG_TAG, "Crash reporter is disabled");
            return;
        }
        while (errorReporterClient.hasNextEvent()) {
            CrashEvent nextEvent = errorReporterClient.nextEvent();
            if (errorReporterClient.isDuplicate(nextEvent)) {
                Log.d(LOG_TAG, "Skip duplicate crash in this batch: " + nextEvent.getHash());
                errorReporterClient.delete(nextEvent);
            } else if (errorReporterClient.send(nextEvent)) {
                errorReporterClient.delete(nextEvent);
            } else {
                Log.w(LOG_TAG, "Failed to deliver crash event");
            }
        }
    }
}
