package com.baidu.location.c;

import android.os.Handler;
import android.os.Message;

/* loaded from: classes.dex */
class c extends Handler {
    final /* synthetic */ b a;

    c(b bVar) {
        this.a = bVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        int i = message.what;
        try {
            if (i == 1) {
                this.a.f();
            } else if (i != 2) {
            } else {
                this.a.g();
            }
        } catch (Exception unused) {
        }
    }
}
