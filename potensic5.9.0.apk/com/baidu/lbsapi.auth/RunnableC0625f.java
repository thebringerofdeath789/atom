package com.baidu.lbsapi.auth;

import android.content.Context;
import java.util.HashMap;

/* compiled from: HttpAsyncTask.java */
/* renamed from: com.baidu.lbsapi.auth.f */
/* loaded from: classes.dex */
class RunnableC0625f implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C0624e f232a;

    RunnableC0625f(C0624e c0624e) {
        this.f232a = c0624e;
    }

    @Override // java.lang.Runnable
    public void run() {
        Context context;
        HashMap<String, String> hashMap;
        C0621b.m177a("postWithHttps start Thread id = " + String.valueOf(Thread.currentThread().getId()));
        context = this.f232a.f229a;
        C0628i c0628i = new C0628i(context);
        hashMap = this.f232a.f230b;
        this.f232a.m194a(c0628i.m210a(hashMap));
    }
}