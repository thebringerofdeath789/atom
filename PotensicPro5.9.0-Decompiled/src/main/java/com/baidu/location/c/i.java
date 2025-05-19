package com.baidu.location.c;

import android.os.Handler;
import android.os.Message;

/* loaded from: classes.dex */
class i extends Handler {
    final /* synthetic */ h a;

    i(h hVar) {
        this.a = hVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (message.what != 1) {
            return;
        }
        this.a.d();
    }
}
