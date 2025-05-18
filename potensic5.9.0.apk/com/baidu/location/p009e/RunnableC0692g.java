package com.baidu.location.p009e;

import com.baidu.location.p006b.C0670x;
import com.baidu.location.p009e.C0691f;
import java.util.concurrent.ExecutorService;

/* renamed from: com.baidu.location.e.g */
/* loaded from: classes.dex */
class RunnableC0692g implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C0691f.a f941a;

    RunnableC0692g(C0691f.a aVar) {
        this.f941a = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        ExecutorService m592c = C0670x.m590a().m592c();
        if (m592c != null) {
            this.f941a.m1129a(m592c, "https://ofloc.map.baidu.com/offline_loc");
        } else {
            this.f941a.m1133e("https://ofloc.map.baidu.com/offline_loc");
        }
    }
}