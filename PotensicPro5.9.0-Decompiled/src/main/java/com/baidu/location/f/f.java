package com.baidu.location.f;

import java.util.TimerTask;

/* loaded from: classes.dex */
class f extends TimerTask {
    final /* synthetic */ e a;

    f(e eVar) {
        this.a = eVar;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        this.a.c();
    }
}
