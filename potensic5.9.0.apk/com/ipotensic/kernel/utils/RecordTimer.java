package com.ipotensic.kernel.utils;

import com.ipotensic.baselib.configs.PhoneConfig;
import com.ipotensic.baselib.utils.CancelRunnable;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class RecordTimer {
    private CancelRunnable cancelRunnable;
    private long num;
    private long startTime = 0;

    public interface OnRecordTimerListener {
        void onRedUpdate(long j);

        void onTimeUpdate(long j);
    }

    static /* synthetic */ long access$008(RecordTimer recordTimer) {
        long j = recordTimer.num;
        recordTimer.num = 1 + j;
        return j;
    }

    static /* synthetic */ long access$108(RecordTimer recordTimer) {
        long j = recordTimer.startTime;
        recordTimer.startTime = 1 + j;
        return j;
    }

    public void start(long j, final OnRecordTimerListener onRecordTimerListener) {
        this.startTime = j;
        CancelRunnable cancelRunnable = new CancelRunnable() { // from class: com.ipotensic.kernel.utils.RecordTimer.1
            @Override // com.ipotensic.baselib.utils.CancelRunnable, java.lang.Runnable
            public void run() {
                PhoneConfig.mainHandler.post(new Runnable() { // from class: com.ipotensic.kernel.utils.RecordTimer.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (RecordTimer.this.num % 2 == 0 && onRecordTimerListener != null) {
                            onRecordTimerListener.onTimeUpdate(RecordTimer.access$108(RecordTimer.this));
                        }
                        if (onRecordTimerListener != null) {
                            onRecordTimerListener.onRedUpdate(RecordTimer.this.num);
                        }
                        RecordTimer.access$008(RecordTimer.this);
                    }
                });
            }
        };
        this.cancelRunnable = cancelRunnable;
        cancelRunnable.setFuture(PhoneConfig.schedule.scheduleWithFixedDelay(this.cancelRunnable, 0L, 500L, TimeUnit.MILLISECONDS));
    }

    public void stop() {
        CancelRunnable cancelRunnable = this.cancelRunnable;
        if (cancelRunnable == null || cancelRunnable.getFuture() == null) {
            return;
        }
        this.cancelRunnable.getFuture().cancel(true);
        this.cancelRunnable = null;
    }
}