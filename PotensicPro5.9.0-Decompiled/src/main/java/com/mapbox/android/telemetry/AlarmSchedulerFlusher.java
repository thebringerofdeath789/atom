package com.mapbox.android.telemetry;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Build;
import android.os.SystemClock;

/* loaded from: classes3.dex */
class AlarmSchedulerFlusher implements SchedulerFlusher {
    private final Context context;
    private final AlarmManager manager;
    private PendingIntent pendingIntent;
    private final AlarmReceiver receiver;

    AlarmSchedulerFlusher(Context context, AlarmManager alarmManager, AlarmReceiver alarmReceiver) {
        this.context = context;
        this.manager = alarmManager;
        this.receiver = alarmReceiver;
    }

    @Override // com.mapbox.android.telemetry.SchedulerFlusher
    public void register() {
        this.pendingIntent = PendingIntent.getBroadcast(this.context, 0, this.receiver.supplyIntent(), 134217728);
        this.context.registerReceiver(this.receiver, new IntentFilter("com.mapbox.scheduler_flusher"));
    }

    @Override // com.mapbox.android.telemetry.SchedulerFlusher
    public void schedule(long j) {
        this.manager.setInexactRepeating(3, j + SchedulerFlusherFactory.flushingPeriod, SchedulerFlusherFactory.flushingPeriod, this.pendingIntent);
    }

    boolean scheduleExact(long j) {
        if (Build.VERSION.SDK_INT < 19) {
            return false;
        }
        this.manager.setExact(3, SystemClock.elapsedRealtime() + j, this.pendingIntent);
        return true;
    }

    @Override // com.mapbox.android.telemetry.SchedulerFlusher
    public void unregister() {
        PendingIntent pendingIntent = this.pendingIntent;
        if (pendingIntent != null) {
            this.manager.cancel(pendingIntent);
        }
        try {
            this.context.unregisterReceiver(this.receiver);
        } catch (IllegalArgumentException unused) {
        }
    }

    PendingIntent obtainPendingIntent() {
        return this.pendingIntent;
    }
}
