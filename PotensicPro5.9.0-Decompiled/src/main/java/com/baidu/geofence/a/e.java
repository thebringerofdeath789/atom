package com.baidu.geofence.a;

import com.baidu.geofence.a.b;

/* loaded from: classes.dex */
class e implements Runnable {
    final /* synthetic */ int a;
    final /* synthetic */ b b;

    e(b bVar, int i) {
        this.b = bVar;
        this.a = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        b.a aVar;
        b.a aVar2;
        aVar = this.b.f;
        if (aVar != null) {
            aVar2 = this.b.f;
            aVar2.a(this.a);
        }
    }
}
