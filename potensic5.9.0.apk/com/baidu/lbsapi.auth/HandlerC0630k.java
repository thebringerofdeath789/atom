package com.baidu.lbsapi.auth;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.Hashtable;
import org.json.JSONObject;

/* compiled from: LBSAuthManager.java */
/* renamed from: com.baidu.lbsapi.auth.k */
/* loaded from: classes.dex */
class HandlerC0630k extends Handler {

    /* renamed from: a */
    final /* synthetic */ LBSAuthManager f242a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HandlerC0630k(LBSAuthManager lBSAuthManager, Looper looper) {
        super(looper);
        this.f242a = lBSAuthManager;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        Hashtable hashtable;
        C0621b.m177a("handleMessage !!");
        if (message.what == 0) {
            this.f242a.m162a((JSONObject) message.obj);
        }
        String string = message.getData().getString("listenerKey");
        hashtable = LBSAuthManager.f215f;
        LBSAuthManagerListener lBSAuthManagerListener = (LBSAuthManagerListener) hashtable.get(string);
        C0621b.m177a("handleMessage listener = " + lBSAuthManagerListener);
        if (lBSAuthManagerListener != null) {
            lBSAuthManagerListener.onAuthResult(message.what, message.obj.toString());
        }
    }
}