package com.baidu.lbsapi.auth;

import com.baidu.lbsapi.auth.g;

/* compiled from: LBSAuthManager.java */
/* loaded from: classes.dex */
class n implements g.a<String> {
    final /* synthetic */ String a;
    final /* synthetic */ LBSAuthManager b;

    n(LBSAuthManager lBSAuthManager, String str) {
        this.b = lBSAuthManager;
        this.a = str;
    }

    @Override // com.baidu.lbsapi.auth.g.a
    public void a(String str) {
        this.b.a(str, this.a);
    }
}
