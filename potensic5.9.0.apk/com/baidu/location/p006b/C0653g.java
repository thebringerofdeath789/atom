package com.baidu.location.p006b;

import com.baidu.location.p006b.C0651e;
import java.util.Timer;
import java.util.TimerTask;

/* renamed from: com.baidu.location.b.g */
/* loaded from: classes.dex */
class C0653g extends TimerTask {

    /* renamed from: a */
    final /* synthetic */ Timer f500a;

    /* renamed from: b */
    final /* synthetic */ C0651e.c f501b;

    C0653g(C0651e.c cVar, Timer timer) {
        this.f501b = cVar;
        this.f500a = timer;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        if (!this.f501b.f487d) {
            this.f501b.m405c();
        }
        this.f500a.cancel();
        this.f500a.purge();
    }
}