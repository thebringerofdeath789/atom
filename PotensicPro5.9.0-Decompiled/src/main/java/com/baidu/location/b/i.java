package com.baidu.location.b;

import android.location.Location;

/* loaded from: classes.dex */
class i implements Runnable {
    final /* synthetic */ Location a;
    final /* synthetic */ h b;

    i(h hVar, Location location) {
        this.b = hVar;
        this.a = location;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.b.b(this.a);
    }
}
