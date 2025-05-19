package com.mapbox.android.core.crashreporter;

import android.util.Log;
import androidx.core.app.NotificationCompat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class CrashReport {
    private static final String CRASH_EVENT = "mobile.crash";
    private static final String TAG = "MapboxCrashReport";
    private final JSONObject content;

    CrashReport(Calendar calendar) {
        this.content = new JSONObject();
        put(NotificationCompat.CATEGORY_EVENT, CRASH_EVENT);
        put("created", new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ", Locale.US).format(Long.valueOf(calendar.getTimeInMillis())));
    }

    CrashReport(String str) throws JSONException {
        this.content = new JSONObject(str);
    }

    public synchronized void put(String str, String str2) {
        if (str2 == null) {
            putNull(str);
        } else {
            try {
                this.content.put(str, str2);
            } catch (JSONException unused) {
                Log.e(TAG, "Failed json encode value: " + String.valueOf(str2));
            }
        }
    }

    public String getDateString() {
        return getString("created");
    }

    public String toJson() {
        return this.content.toString();
    }

    String getString(String str) {
        return this.content.optString(str);
    }

    private void putNull(String str) {
        try {
            this.content.put(str, "null");
        } catch (JSONException unused) {
            Log.e(TAG, "Failed json encode null value");
        }
    }
}
