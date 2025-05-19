package com.baidu.location.indoor;

import java.util.concurrent.ExecutorService;

/* loaded from: classes.dex */
class b implements Runnable {
    final /* synthetic */ a a;

    b(a aVar) {
        this.a = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        String str2;
        String str3;
        String str4;
        str = this.a.t;
        if (str != null) {
            a aVar = this.a;
            str2 = aVar.t;
            aVar.f = str2;
            ExecutorService c = com.baidu.location.b.x.a().c();
            if (c != null) {
                a aVar2 = this.a;
                str4 = aVar2.b;
                aVar2.a(c, str4);
            } else {
                a aVar3 = this.a;
                str3 = aVar3.b;
                aVar3.e(str3);
            }
        }
    }
}
