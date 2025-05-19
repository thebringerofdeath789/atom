package com.baidu.lbsapi.auth;

import java.util.HashMap;
import java.util.List;

/* compiled from: HttpSyncTask.java */
/* loaded from: classes.dex */
class h implements Runnable {
    final /* synthetic */ g a;

    h(g gVar) {
        this.a = gVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        List list;
        g gVar = this.a;
        list = gVar.b;
        gVar.a((List<HashMap<String, String>>) list);
    }
}
