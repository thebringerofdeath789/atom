package com.baidu.lbsapi.auth;

import android.os.Handler;
import android.os.Looper;

/* compiled from: LooperThread.java */
/* renamed from: com.baidu.lbsapi.auth.o */
/* loaded from: classes.dex */
class C0634o extends Thread {

    /* renamed from: a */
    Handler f253a;

    /* renamed from: b */
    private Object f254b;

    /* renamed from: c */
    private boolean f255c;

    C0634o() {
        this.f253a = null;
        this.f254b = new Object();
        this.f255c = false;
    }

    C0634o(String str) {
        super(str);
        this.f253a = null;
        this.f254b = new Object();
        this.f255c = false;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Looper.prepare();
        this.f253a = new Handler();
        if (C0621b.f226a) {
            C0621b.m177a("new Handler() finish!!");
        }
        Looper.loop();
        if (C0621b.f226a) {
            C0621b.m177a("LooperThread run() thread id:" + String.valueOf(Thread.currentThread().getId()));
        }
    }

    /* renamed from: a */
    public void m212a() {
        if (C0621b.f226a) {
            C0621b.m177a("Looper thread quit()");
        }
        Handler handler = this.f253a;
        if (handler == null || handler.getLooper() == null) {
            return;
        }
        this.f253a.getLooper().quit();
    }

    /* renamed from: b */
    public void m213b() {
        synchronized (this.f254b) {
            try {
                if (!this.f255c) {
                    this.f254b.wait();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: c */
    public void m214c() {
        synchronized (this.f254b) {
            this.f255c = true;
            this.f254b.notifyAll();
        }
    }
}