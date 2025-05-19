package com.baidu.geofence.a;

import com.baidu.geofence.a.f;
import java.util.ArrayList;

/* loaded from: classes.dex */
class i implements Runnable {
    final /* synthetic */ int a;
    final /* synthetic */ ArrayList b;
    final /* synthetic */ f c;

    i(f fVar, int i, ArrayList arrayList) {
        this.c = fVar;
        this.a = i;
        this.b = arrayList;
    }

    @Override // java.lang.Runnable
    public void run() {
        f.a aVar;
        f.a aVar2;
        aVar = this.c.z;
        if (aVar != null) {
            aVar2 = this.c.z;
            aVar2.a(this.a, this.b);
        }
    }
}
