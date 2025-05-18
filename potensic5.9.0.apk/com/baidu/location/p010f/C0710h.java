package com.baidu.location.p010f;

import android.location.OnNmeaMessageListener;

/* renamed from: com.baidu.location.f.h */
/* loaded from: classes.dex */
class C0710h implements OnNmeaMessageListener {

    /* renamed from: a */
    final /* synthetic */ C0709g f1159a;

    C0710h(C0709g c0709g) {
        this.f1159a = c0709g;
    }

    @Override // android.location.OnNmeaMessageListener
    public void onNmeaMessage(String str, long j) {
        if (this.f1159a.f1101R != null) {
            this.f1159a.f1101R.sendMessage(this.f1159a.f1101R.obtainMessage(5, str));
        }
    }
}