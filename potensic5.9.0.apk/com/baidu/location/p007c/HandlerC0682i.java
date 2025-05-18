package com.baidu.location.p007c;

import android.os.Handler;
import android.os.Message;

/* renamed from: com.baidu.location.c.i */
/* loaded from: classes.dex */
class HandlerC0682i extends Handler {

    /* renamed from: a */
    final /* synthetic */ C0681h f835a;

    HandlerC0682i(C0681h c0681h) {
        this.f835a = c0681h;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (message.what != 1) {
            return;
        }
        this.f835a.m687d();
    }
}