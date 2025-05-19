package com.baidu.lbsapi.auth;

import android.content.Context;
import java.util.HashMap;

/* compiled from: HttpAsyncTask.java */
/* loaded from: classes.dex */
class f implements Runnable {
    final /* synthetic */ e a;

    f(e eVar) {
        this.a = eVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Context context;
        HashMap<String, String> hashMap;
        b.a("postWithHttps start Thread id = " + String.valueOf(Thread.currentThread().getId()));
        context = this.a.a;
        i iVar = new i(context);
        hashMap = this.a.b;
        this.a.a(iVar.a(hashMap));
    }
}
