package com.baidu.lbsapi.auth;

import android.os.Handler;
import android.os.Looper;

/* compiled from: LooperThread.java */
/* loaded from: classes.dex */
class o extends Thread {
    Handler a;
    private Object b;
    private boolean c;

    o() {
        this.a = null;
        this.b = new Object();
        this.c = false;
    }

    o(String str) {
        super(str);
        this.a = null;
        this.b = new Object();
        this.c = false;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Looper.prepare();
        this.a = new Handler();
        if (b.a) {
            b.a("new Handler() finish!!");
        }
        Looper.loop();
        if (b.a) {
            b.a("LooperThread run() thread id:" + String.valueOf(Thread.currentThread().getId()));
        }
    }

    public void a() {
        if (b.a) {
            b.a("Looper thread quit()");
        }
        Handler handler = this.a;
        if (handler == null || handler.getLooper() == null) {
            return;
        }
        this.a.getLooper().quit();
    }

    public void b() {
        synchronized (this.b) {
            try {
                if (!this.c) {
                    this.b.wait();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void c() {
        synchronized (this.b) {
            this.c = true;
            this.b.notifyAll();
        }
    }
}
