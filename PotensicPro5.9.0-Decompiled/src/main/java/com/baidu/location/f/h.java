package com.baidu.location.f;

import android.location.OnNmeaMessageListener;

/* loaded from: classes.dex */
class h implements OnNmeaMessageListener {
    final /* synthetic */ g a;

    h(g gVar) {
        this.a = gVar;
    }

    @Override // android.location.OnNmeaMessageListener
    public void onNmeaMessage(String str, long j) {
        if (this.a.R != null) {
            this.a.R.sendMessage(this.a.R.obtainMessage(5, str));
        }
    }
}
