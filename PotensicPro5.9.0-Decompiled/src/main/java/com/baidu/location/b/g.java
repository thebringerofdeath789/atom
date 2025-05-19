package com.baidu.location.b;

import com.baidu.location.b.e;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: classes.dex */
class g extends TimerTask {
    final /* synthetic */ Timer a;
    final /* synthetic */ e.c b;

    g(e.c cVar, Timer timer) {
        this.b = cVar;
        this.a = timer;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        if (!this.b.d) {
            this.b.c();
        }
        this.a.cancel();
        this.a.purge();
    }
}
