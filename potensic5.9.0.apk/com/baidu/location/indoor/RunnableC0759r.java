package com.baidu.location.indoor;

/* renamed from: com.baidu.location.indoor.r */
/* loaded from: classes.dex */
class RunnableC0759r implements Runnable {

    /* renamed from: a */
    final /* synthetic */ float[] f1739a;

    /* renamed from: b */
    final /* synthetic */ C0755n f1740b;

    RunnableC0759r(C0755n c0755n, float[] fArr) {
        this.f1740b = c0755n;
        this.f1739a = fArr;
    }

    @Override // java.lang.Runnable
    public void run() {
        C0748m.m1258a(this.f1739a[0], System.currentTimeMillis());
    }
}