package com.baidu.location.p006b;

import android.location.Location;

/* renamed from: com.baidu.location.b.i */
/* loaded from: classes.dex */
class RunnableC0655i implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Location f545a;

    /* renamed from: b */
    final /* synthetic */ C0654h f546b;

    RunnableC0655i(C0654h c0654h, Location location) {
        this.f546b = c0654h;
        this.f545a = location;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f546b.m421b(this.f545a);
    }
}