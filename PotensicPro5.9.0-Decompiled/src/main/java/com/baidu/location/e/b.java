package com.baidu.location.e;

/* loaded from: classes.dex */
class b implements Runnable {
    final /* synthetic */ a a;

    b(a aVar) {
        this.a = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (com.baidu.location.f.isServing) {
            this.a.e();
        }
    }
}
