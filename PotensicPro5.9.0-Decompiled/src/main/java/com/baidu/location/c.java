package com.baidu.location;

import com.baidu.location.h.o;

/* loaded from: classes.dex */
class c extends Thread {
    final /* synthetic */ LocationClient a;

    c(LocationClient locationClient) {
        this.a = locationClient;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        try {
            if (this.a.H != null) {
                if (o.h(this.a.f) > 0) {
                    this.a.H.a();
                }
                this.a.H.c();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
