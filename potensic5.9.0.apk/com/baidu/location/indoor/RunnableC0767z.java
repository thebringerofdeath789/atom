package com.baidu.location.indoor;

import android.os.Handler;
import com.baidu.location.BDLocation;
import com.baidu.location.indoor.C0766y;

/* renamed from: com.baidu.location.indoor.z */
/* loaded from: classes.dex */
class RunnableC0767z implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C0766y f1788a;

    RunnableC0767z(C0766y c0766y) {
        this.f1788a = c0766y;
    }

    @Override // java.lang.Runnable
    public void run() {
        C0766y.b bVar;
        C0766y.b m1454a;
        Handler handler;
        Runnable runnable;
        C0766y.a aVar;
        C0766y.b bVar2;
        long j;
        long j2;
        BDLocation bDLocation;
        C0766y.b bVar3;
        C0766y.b bVar4;
        C0766y.a aVar2;
        C0766y c0766y = this.f1788a;
        bVar = c0766y.f1774e;
        m1454a = c0766y.m1454a(bVar);
        if (m1454a != null) {
            aVar = this.f1788a.f1770a;
            if (aVar != null) {
                C0766y c0766y2 = this.f1788a;
                bVar2 = c0766y2.f1774e;
                c0766y2.f1774e = bVar2.m1472b(m1454a);
                long currentTimeMillis = System.currentTimeMillis();
                if (!m1454a.m1473b(2.0E-6d)) {
                    j = this.f1788a.f1780k;
                    long j3 = currentTimeMillis - j;
                    j2 = this.f1788a.f1771b;
                    if (j3 > j2) {
                        bDLocation = this.f1788a.f1772c;
                        BDLocation bDLocation2 = new BDLocation(bDLocation);
                        bVar3 = this.f1788a.f1774e;
                        bDLocation2.setLatitude(bVar3.f1785a);
                        bVar4 = this.f1788a.f1774e;
                        bDLocation2.setLongitude(bVar4.f1786b);
                        aVar2 = this.f1788a.f1770a;
                        aVar2.mo1430a(bDLocation2);
                        this.f1788a.f1780k = currentTimeMillis;
                    }
                }
            }
        }
        handler = this.f1788a.f1782m;
        runnable = this.f1788a.f1784o;
        handler.postDelayed(runnable, 450L);
    }
}