package com.baidu.location.p007c;

import android.os.Handler;
import android.os.Message;

/* renamed from: com.baidu.location.c.c */
/* loaded from: classes.dex */
class HandlerC0676c extends Handler {

    /* renamed from: a */
    final /* synthetic */ C0675b f790a;

    HandlerC0676c(C0675b c0675b) {
        this.f790a = c0675b;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        int i = message.what;
        try {
            if (i == 1) {
                this.f790a.m639f();
            } else if (i != 2) {
            } else {
                this.f790a.m640g();
            }
        } catch (Exception unused) {
        }
    }
}