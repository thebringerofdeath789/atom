package com.baidu.lbsapi.auth;

import com.baidu.lbsapi.auth.e;

/* compiled from: LBSAuthManager.java */
/* loaded from: classes.dex */
class m implements e.a<String> {
    final /* synthetic */ String a;
    final /* synthetic */ LBSAuthManager b;

    m(LBSAuthManager lBSAuthManager, String str) {
        this.b = lBSAuthManager;
        this.a = str;
    }

    @Override // com.baidu.lbsapi.auth.e.a
    public void a(String str) {
        this.b.a(str, this.a);
    }
}
