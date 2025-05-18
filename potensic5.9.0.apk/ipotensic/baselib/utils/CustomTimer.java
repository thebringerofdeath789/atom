package com.ipotensic.baselib.utils;

import com.ipotensic.baselib.configs.PhoneConfig;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class CustomTimer {
    public static final int TIMEOUT_COUNTS_NONE = -1;
    private long delay;
    private ScheduledFuture future;
    private long initDelay;
    private Runnable runnable;
    private int timeoutCounts;

    public interface OnUpdateInChildThreadListener {
        void timeout();

        void update();
    }

    public interface OnUpdateInMainThreadListener {
        void timeout();

        void update();
    }

    static /* synthetic */ int access$010(CustomTimer customTimer) {
        int i = customTimer.timeoutCounts;
        customTimer.timeoutCounts = i - 1;
        return i;
    }

    public CustomTimer(long j, long j2, int i, final OnUpdateInMainThreadListener onUpdateInMainThreadListener) {
        this.timeoutCounts = -1;
        this.initDelay = j;
        this.delay = j2;
        this.timeoutCounts = i;
        this.runnable = new Runnable() { // from class: com.ipotensic.baselib.utils.CustomTimer.1
            @Override // java.lang.Runnable
            public void run() {
                PhoneConfig.mainHandler.post(new Runnable() { // from class: com.ipotensic.baselib.utils.CustomTimer.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        onUpdateInMainThreadListener.update();
                        if (CustomTimer.this.timeoutCounts != -1) {
                            CustomTimer.access$010(CustomTimer.this);
                            if (CustomTimer.this.timeoutCounts == 0) {
                                onUpdateInMainThreadListener.timeout();
                            }
                        }
                    }
                });
            }
        };
    }

    public CustomTimer(long j, long j2, int i, final OnUpdateInChildThreadListener onUpdateInChildThreadListener) {
        this.timeoutCounts = -1;
        this.initDelay = j;
        this.delay = j2;
        this.timeoutCounts = i;
        this.runnable = new Runnable() { // from class: com.ipotensic.baselib.utils.CustomTimer.2
            @Override // java.lang.Runnable
            public void run() {
                PhoneConfig.mainHandler.post(new Runnable() { // from class: com.ipotensic.baselib.utils.CustomTimer.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        onUpdateInChildThreadListener.update();
                        if (CustomTimer.this.timeoutCounts != -1) {
                            CustomTimer.access$010(CustomTimer.this);
                            if (CustomTimer.this.timeoutCounts == 0) {
                                onUpdateInChildThreadListener.timeout();
                            }
                        }
                    }
                });
            }
        };
    }

    public void start() {
        if (this.future == null) {
            this.future = PhoneConfig.schedule.scheduleWithFixedDelay(this.runnable, this.initDelay, this.delay, TimeUnit.MILLISECONDS);
        }
    }

    public boolean isRunning() {
        ScheduledFuture scheduledFuture = this.future;
        return (scheduledFuture == null || scheduledFuture.isCancelled()) ? false : true;
    }

    public void cancel() {
        ScheduledFuture scheduledFuture = this.future;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
            this.future = null;
        }
    }
}