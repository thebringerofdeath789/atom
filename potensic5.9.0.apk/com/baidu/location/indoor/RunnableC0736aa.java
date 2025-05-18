package com.baidu.location.indoor;

import android.os.Handler;
import com.baidu.location.BDLocation;
import com.baidu.location.indoor.C0766y;

/* renamed from: com.baidu.location.indoor.aa */
/* loaded from: classes.dex */
class RunnableC0736aa implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C0766y f1424a;

    RunnableC0736aa(C0766y c0766y) {
        this.f1424a = c0766y;
    }

    @Override // java.lang.Runnable
    public void run() {
        BDLocation bDLocation;
        Handler handler;
        Runnable runnable;
        long j;
        C0766y.a aVar;
        BDLocation bDLocation2;
        BDLocation bDLocation3;
        BDLocation bDLocation4;
        C0766y.a aVar2;
        bDLocation = this.f1424a.f1779j;
        if (bDLocation != null) {
            aVar = this.f1424a.f1770a;
            if (aVar != null) {
                bDLocation2 = this.f1424a.f1772c;
                BDLocation bDLocation5 = new BDLocation(bDLocation2);
                bDLocation3 = this.f1424a.f1779j;
                bDLocation5.setLatitude(bDLocation3.getLatitude());
                bDLocation4 = this.f1424a.f1779j;
                bDLocation5.setLongitude(bDLocation4.getLongitude());
                aVar2 = this.f1424a.f1770a;
                aVar2.mo1430a(bDLocation5);
            }
        }
        handler = this.f1424a.f1782m;
        runnable = this.f1424a.f1784o;
        j = this.f1424a.f1771b;
        handler.postDelayed(runnable, j);
    }
}