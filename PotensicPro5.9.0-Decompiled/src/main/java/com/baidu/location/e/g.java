package com.baidu.location.e;

import com.baidu.location.b.x;
import com.baidu.location.e.f;
import java.util.concurrent.ExecutorService;

/* loaded from: classes.dex */
class g implements Runnable {
    final /* synthetic */ f.a a;

    g(f.a aVar) {
        this.a = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        ExecutorService c = x.a().c();
        if (c != null) {
            this.a.a(c, "https://ofloc.map.baidu.com/offline_loc");
        } else {
            this.a.e("https://ofloc.map.baidu.com/offline_loc");
        }
    }
}
