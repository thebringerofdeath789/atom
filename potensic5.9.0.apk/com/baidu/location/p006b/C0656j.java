package com.baidu.location.p006b;

import com.baidu.location.p012h.C0733o;
import java.io.File;

/* renamed from: com.baidu.location.b.j */
/* loaded from: classes.dex */
class C0656j extends Thread {

    /* renamed from: a */
    final /* synthetic */ C0654h f547a;

    C0656j(C0654h c0654h) {
        this.f547a = c0654h;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        this.f547a.m413a(new File(C0733o.m1169h() + "/baidu/tempdata", "intime.dat"), "https://itsdata.map.baidu.com/long-conn-gps/sdk.php");
    }
}