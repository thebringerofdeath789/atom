package com.baidu.location.f;

import com.baidu.location.b.aa;
import com.baidu.location.b.p;
import com.baidu.location.b.v;
import com.baidu.location.f.m;

/* loaded from: classes.dex */
class n implements Runnable {
    final /* synthetic */ boolean a;
    final /* synthetic */ m.a b;

    n(m.a aVar, boolean z) {
        this.b = aVar;
        this.a = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        z = m.this.k;
        if (!z) {
            m.this.k = this.a;
        }
        m.this.t();
        p.c().j();
        if (com.baidu.location.indoor.n.a().e()) {
            com.baidu.location.indoor.n.a().a.obtainMessage(41).sendToTarget();
        }
        if (System.currentTimeMillis() - v.b() <= 5000) {
            aa.a().c();
        }
    }
}
