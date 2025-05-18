package com.baidu.location.p010f;

import com.baidu.location.p007c.C0675b;
import com.baidu.location.p010f.C0704b;

/* renamed from: com.baidu.location.f.c */
/* loaded from: classes.dex */
class RunnableC0705c implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C0704b.d f1058a;

    RunnableC0705c(C0704b.d dVar) {
        this.f1058a = dVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            C0704b.this.m930m();
        } catch (Exception unused) {
        }
        C0675b.m634a().m644e();
    }
}