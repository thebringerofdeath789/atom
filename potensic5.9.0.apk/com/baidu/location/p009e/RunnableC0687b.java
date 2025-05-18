package com.baidu.location.p009e;

import com.baidu.location.ServiceC0702f;

/* renamed from: com.baidu.location.e.b */
/* loaded from: classes.dex */
class RunnableC0687b implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C0686a f868a;

    RunnableC0687b(C0686a c0686a) {
        this.f868a = c0686a;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (ServiceC0702f.isServing) {
            this.f868a.m714e();
        }
    }
}