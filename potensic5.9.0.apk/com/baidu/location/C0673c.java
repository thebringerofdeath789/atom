package com.baidu.location;

import com.baidu.location.p012h.C0733o;

/* renamed from: com.baidu.location.c */
/* loaded from: classes.dex */
class C0673c extends Thread {

    /* renamed from: a */
    final /* synthetic */ LocationClient f762a;

    C0673c(LocationClient locationClient) {
        this.f762a = locationClient;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        try {
            if (this.f762a.f340H != null) {
                if (C0733o.m1168h(this.f762a.f350f) > 0) {
                    this.f762a.f340H.m398a();
                }
                this.f762a.f340H.m400c();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}