package com.baidu.location.f;

import com.baidu.location.f.b;

/* loaded from: classes.dex */
class c implements Runnable {
    final /* synthetic */ b.d a;

    c(b.d dVar) {
        this.a = dVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            b.this.m();
        } catch (Exception unused) {
        }
        com.baidu.location.c.b.a().e();
    }
}
