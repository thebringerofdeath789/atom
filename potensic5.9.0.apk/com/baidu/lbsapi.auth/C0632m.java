package com.baidu.lbsapi.auth;

import com.baidu.lbsapi.auth.C0624e;

/* compiled from: LBSAuthManager.java */
/* renamed from: com.baidu.lbsapi.auth.m */
/* loaded from: classes.dex */
class C0632m implements C0624e.a<String> {

    /* renamed from: a */
    final /* synthetic */ String f249a;

    /* renamed from: b */
    final /* synthetic */ LBSAuthManager f250b;

    C0632m(LBSAuthManager lBSAuthManager, String str) {
        this.f250b = lBSAuthManager;
        this.f249a = str;
    }

    @Override // com.baidu.lbsapi.auth.C0624e.a
    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public void mo197a(String str) {
        this.f250b.m160a(str, this.f249a);
    }
}