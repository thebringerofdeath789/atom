package com.mapbox.android.telemetry.errors;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.mapbox.android.telemetry.MapboxTelemetryConstants;

/* loaded from: classes3.dex */
public class TokenChangeBroadcastReceiver extends BroadcastReceiver {
    private static final String LOG_TAG = "TknBroadcastReceiver";

    public static void register(Context context) {
        LocalBroadcastManager.getInstance(context).registerReceiver(new TokenChangeBroadcastReceiver(), new IntentFilter(MapboxTelemetryConstants.ACTION_TOKEN_CHANGED));
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        try {
            ErrorReporterJobIntentService.enqueueWork(context);
            LocalBroadcastManager.getInstance(context).unregisterReceiver(this);
        } catch (Throwable th) {
            Log.e(LOG_TAG, th.toString());
        }
    }
}
