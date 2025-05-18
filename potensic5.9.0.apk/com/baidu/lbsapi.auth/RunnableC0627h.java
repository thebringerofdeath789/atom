package com.baidu.lbsapi.auth;

import java.util.HashMap;
import java.util.List;

/* compiled from: HttpSyncTask.java */
/* renamed from: com.baidu.lbsapi.auth.h */
/* loaded from: classes.dex */
class RunnableC0627h implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C0626g f236a;

    RunnableC0627h(C0626g c0626g) {
        this.f236a = c0626g;
    }

    @Override // java.lang.Runnable
    public void run() {
        List list;
        C0626g c0626g = this.f236a;
        list = c0626g.f234b;
        c0626g.m202a((List<HashMap<String, String>>) list);
    }
}