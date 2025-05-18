package com.baidu.location.p011g;

import android.util.Log;
import java.lang.ref.WeakReference;

/* renamed from: com.baidu.location.g.b */
/* loaded from: classes.dex */
class RunnableC0718b implements Runnable {

    /* renamed from: a */
    final /* synthetic */ WeakReference f1221a;

    /* renamed from: b */
    final /* synthetic */ ServiceC0717a f1222b;

    RunnableC0718b(ServiceC0717a serviceC0717a, WeakReference weakReference) {
        this.f1222b = serviceC0717a;
        this.f1221a = weakReference;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        ServiceC0717a serviceC0717a = (ServiceC0717a) this.f1221a.get();
        if (serviceC0717a != null) {
            i = serviceC0717a.f1218h;
            if (i == 3) {
                Log.d("baidu_location_service", "baidu location service force stopped ...");
                serviceC0717a.f1219i = false;
                serviceC0717a.m1099d();
            }
        }
    }
}