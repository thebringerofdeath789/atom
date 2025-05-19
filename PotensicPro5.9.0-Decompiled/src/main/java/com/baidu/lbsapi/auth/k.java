package com.baidu.lbsapi.auth;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.Hashtable;
import org.json.JSONObject;

/* compiled from: LBSAuthManager.java */
/* loaded from: classes.dex */
class k extends Handler {
    final /* synthetic */ LBSAuthManager a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    k(LBSAuthManager lBSAuthManager, Looper looper) {
        super(looper);
        this.a = lBSAuthManager;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        Hashtable hashtable;
        b.a("handleMessage !!");
        if (message.what == 0) {
            this.a.a((JSONObject) message.obj);
        }
        String string = message.getData().getString("listenerKey");
        hashtable = LBSAuthManager.f;
        LBSAuthManagerListener lBSAuthManagerListener = (LBSAuthManagerListener) hashtable.get(string);
        b.a("handleMessage listener = " + lBSAuthManagerListener);
        if (lBSAuthManagerListener != null) {
            lBSAuthManagerListener.onAuthResult(message.what, message.obj.toString());
        }
    }
}
