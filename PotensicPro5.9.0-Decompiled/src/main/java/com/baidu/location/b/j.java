package com.baidu.location.b;

import java.io.File;

/* loaded from: classes.dex */
class j extends Thread {
    final /* synthetic */ h a;

    j(h hVar) {
        this.a = hVar;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        this.a.a(new File(com.baidu.location.h.o.h() + "/baidu/tempdata", "intime.dat"), "https://itsdata.map.baidu.com/long-conn-gps/sdk.php");
    }
}
