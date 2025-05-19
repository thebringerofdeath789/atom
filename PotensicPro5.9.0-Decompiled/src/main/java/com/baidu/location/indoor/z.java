package com.baidu.location.indoor;

import android.os.Handler;
import com.baidu.location.BDLocation;
import com.baidu.location.indoor.y;

/* loaded from: classes.dex */
class z implements Runnable {
    final /* synthetic */ y a;

    z(y yVar) {
        this.a = yVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        y.b bVar;
        y.b a;
        Handler handler;
        Runnable runnable;
        y.a aVar;
        y.b bVar2;
        long j;
        long j2;
        BDLocation bDLocation;
        y.b bVar3;
        y.b bVar4;
        y.a aVar2;
        y yVar = this.a;
        bVar = yVar.e;
        a = yVar.a(bVar);
        if (a != null) {
            aVar = this.a.a;
            if (aVar != null) {
                y yVar2 = this.a;
                bVar2 = yVar2.e;
                yVar2.e = bVar2.b(a);
                long currentTimeMillis = System.currentTimeMillis();
                if (!a.b(2.0E-6d)) {
                    j = this.a.k;
                    long j3 = currentTimeMillis - j;
                    j2 = this.a.b;
                    if (j3 > j2) {
                        bDLocation = this.a.c;
                        BDLocation bDLocation2 = new BDLocation(bDLocation);
                        bVar3 = this.a.e;
                        bDLocation2.setLatitude(bVar3.a);
                        bVar4 = this.a.e;
                        bDLocation2.setLongitude(bVar4.b);
                        aVar2 = this.a.a;
                        aVar2.a(bDLocation2);
                        this.a.k = currentTimeMillis;
                    }
                }
            }
        }
        handler = this.a.m;
        runnable = this.a.o;
        handler.postDelayed(runnable, 450L);
    }
}
