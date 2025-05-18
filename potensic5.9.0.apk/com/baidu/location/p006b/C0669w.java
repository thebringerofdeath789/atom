package com.baidu.location.p006b;

import android.os.HandlerThread;

/* renamed from: com.baidu.location.b.w */
/* loaded from: classes.dex */
public class C0669w {

    /* renamed from: a */
    private static HandlerThread f714a;

    /* renamed from: a */
    public static synchronized HandlerThread m589a() {
        HandlerThread handlerThread;
        synchronized (C0669w.class) {
            if (f714a == null) {
                try {
                    HandlerThread handlerThread2 = new HandlerThread("ServiceStartArguments", 10);
                    f714a = handlerThread2;
                    handlerThread2.start();
                } catch (Throwable th) {
                    th.printStackTrace();
                    f714a = null;
                }
            }
            handlerThread = f714a;
        }
        return handlerThread;
    }
}