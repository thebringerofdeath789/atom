package com.baidu.location.indoor;

import com.baidu.location.p006b.C0670x;
import java.util.concurrent.ExecutorService;

/* renamed from: com.baidu.location.indoor.b */
/* loaded from: classes.dex */
class RunnableC0737b implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C0735a f1425a;

    RunnableC0737b(C0735a c0735a) {
        this.f1425a = c0735a;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        String str2;
        String str3;
        String str4;
        str = this.f1425a.f1421t;
        if (str != null) {
            C0735a c0735a = this.f1425a;
            str2 = c0735a.f1421t;
            c0735a.f1418f = str2;
            ExecutorService m592c = C0670x.m590a().m592c();
            if (m592c != null) {
                C0735a c0735a2 = this.f1425a;
                str4 = c0735a2.f1414b;
                c0735a2.m1129a(m592c, str4);
            } else {
                C0735a c0735a3 = this.f1425a;
                str3 = c0735a3.f1414b;
                c0735a3.m1133e(str3);
            }
        }
    }
}