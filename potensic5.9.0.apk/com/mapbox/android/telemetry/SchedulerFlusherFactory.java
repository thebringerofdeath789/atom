package com.mapbox.android.telemetry;

import android.app.AlarmManager;
import android.content.Context;
import androidx.core.app.NotificationCompat;

/* loaded from: classes3.dex */
class SchedulerFlusherFactory {
    static final String SCHEDULER_FLUSHER_INTENT = "com.mapbox.scheduler_flusher";
    static long flushingPeriod = 180000;
    private final AlarmReceiver alarmReceiver;
    private final Context context;

    SchedulerFlusherFactory(Context context, AlarmReceiver alarmReceiver) {
        this.context = context;
        this.alarmReceiver = alarmReceiver;
        checkUpdatePeriod(context);
    }

    SchedulerFlusher supply() {
        Context context = this.context;
        return new AlarmSchedulerFlusher(context, (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM), this.alarmReceiver);
    }

    private void checkUpdatePeriod(Context context) {
        if (TelemetryUtils.adjustWakeUpMode(context)) {
            flushingPeriod = 600000L;
        }
    }
}