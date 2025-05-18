package com.baidu.location.p010f;

import com.baidu.location.indoor.C0755n;
import com.baidu.location.p006b.C0646aa;
import com.baidu.location.p006b.C0662p;
import com.baidu.location.p006b.C0668v;
import com.baidu.location.p010f.C0715m;

/* renamed from: com.baidu.location.f.n */
/* loaded from: classes.dex */
class RunnableC0716n implements Runnable {

    /* renamed from: a */
    final /* synthetic */ boolean f1209a;

    /* renamed from: b */
    final /* synthetic */ C0715m.a f1210b;

    RunnableC0716n(C0715m.a aVar, boolean z) {
        this.f1210b = aVar;
        this.f1209a = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        z = C0715m.this.f1203k;
        if (!z) {
            C0715m.this.f1203k = this.f1209a;
        }
        C0715m.this.m1066t();
        C0662p.m509c().m536j();
        if (C0755n.m1327a().m1387e()) {
            C0755n.m1327a().f1627a.obtainMessage(41).sendToTarget();
        }
        if (System.currentTimeMillis() - C0668v.m584b() <= 5000) {
            C0646aa.m312a().m316c();
        }
    }
}