package com.baidu.location.g;

import android.util.Log;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
class b implements Runnable {
    final /* synthetic */ WeakReference a;
    final /* synthetic */ a b;

    b(a aVar, WeakReference weakReference) {
        this.b = aVar;
        this.a = weakReference;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        a aVar = (a) this.a.get();
        if (aVar != null) {
            i = aVar.h;
            if (i == 3) {
                Log.d("baidu_location_service", "baidu location service force stopped ...");
                aVar.i = false;
                aVar.d();
            }
        }
    }
}
