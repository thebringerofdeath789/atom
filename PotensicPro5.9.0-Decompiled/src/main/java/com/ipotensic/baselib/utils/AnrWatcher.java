package com.ipotensic.baselib.utils;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* loaded from: classes2.dex */
public class AnrWatcher extends Thread {
    public static final int ACTIVITY_ANR_TIMEOUT = 4500;
    public static final int MESSAGE_WATCHDOG_TIME_TICK = 0;
    private static int lastTimeTick = -1;
    private static int timeTick;
    private Handler watchDogHandler = new Handler() { // from class: com.ipotensic.baselib.utils.AnrWatcher.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            AnrWatcher.access$008();
            AnrWatcher.timeTick %= Integer.MAX_VALUE;
        }
    };

    static /* synthetic */ int access$008() {
        int i = timeTick;
        timeTick = i + 1;
        return i;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        while (true) {
            this.watchDogHandler.sendEmptyMessage(0);
            try {
                Thread.sleep(4500L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int i = timeTick;
            if (i == lastTimeTick) {
                throw new ANRException();
            }
            lastTimeTick = i;
        }
    }

    public class ANRException extends RuntimeException {
        public ANRException() {
            super("DDLog : ANR异常，快来改BUG啊 !!");
            setStackTrace(Looper.getMainLooper().getThread().getStackTrace());
        }
    }
}
