package com.ipotensic.baselib.utils;

import java.util.concurrent.ScheduledFuture;

/* loaded from: classes2.dex */
public class CancelRunnable implements Runnable {
    private ScheduledFuture future;

    @Override // java.lang.Runnable
    public void run() {
    }

    public void setFuture(ScheduledFuture scheduledFuture) {
        this.future = scheduledFuture;
    }

    public ScheduledFuture getFuture() {
        return this.future;
    }
}
