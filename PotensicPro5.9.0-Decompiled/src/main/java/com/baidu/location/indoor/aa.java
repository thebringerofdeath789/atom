package com.baidu.location.indoor;

import android.os.Handler;
import com.baidu.location.BDLocation;
import com.baidu.location.indoor.y;

/* loaded from: classes.dex */
class aa implements Runnable {
    final /* synthetic */ y a;

    aa(y yVar) {
        this.a = yVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        BDLocation bDLocation;
        Handler handler;
        Runnable runnable;
        long j;
        y.a aVar;
        BDLocation bDLocation2;
        BDLocation bDLocation3;
        BDLocation bDLocation4;
        y.a aVar2;
        bDLocation = this.a.j;
        if (bDLocation != null) {
            aVar = this.a.a;
            if (aVar != null) {
                bDLocation2 = this.a.c;
                BDLocation bDLocation5 = new BDLocation(bDLocation2);
                bDLocation3 = this.a.j;
                bDLocation5.setLatitude(bDLocation3.getLatitude());
                bDLocation4 = this.a.j;
                bDLocation5.setLongitude(bDLocation4.getLongitude());
                aVar2 = this.a.a;
                aVar2.a(bDLocation5);
            }
        }
        handler = this.a.m;
        runnable = this.a.o;
        j = this.a.b;
        handler.postDelayed(runnable, j);
    }
}
