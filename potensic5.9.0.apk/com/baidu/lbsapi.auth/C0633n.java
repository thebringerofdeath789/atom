package com.baidu.lbsapi.auth;

import com.baidu.lbsapi.auth.C0626g;

/* compiled from: LBSAuthManager.java */
/* renamed from: com.baidu.lbsapi.auth.n */
/* loaded from: classes.dex */
class C0633n implements C0626g.a<String> {

    /* renamed from: a */
    final /* synthetic */ String f251a;

    /* renamed from: b */
    final /* synthetic */ LBSAuthManager f252b;

    C0633n(LBSAuthManager lBSAuthManager, String str) {
        this.f252b = lBSAuthManager;
        this.f251a = str;
    }

    @Override // com.baidu.lbsapi.auth.C0626g.a
    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public void mo204a(String str) {
        this.f252b.m160a(str, this.f251a);
    }
}