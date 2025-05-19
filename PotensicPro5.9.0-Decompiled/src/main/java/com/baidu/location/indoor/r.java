package com.baidu.location.indoor;

/* loaded from: classes.dex */
class r implements Runnable {
    final /* synthetic */ float[] a;
    final /* synthetic */ n b;

    r(n nVar, float[] fArr) {
        this.b = nVar;
        this.a = fArr;
    }

    @Override // java.lang.Runnable
    public void run() {
        m.a(this.a[0], System.currentTimeMillis());
    }
}
