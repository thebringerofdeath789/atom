package com.baidu.location.indoor;

import com.baidu.location.indoor.mapversion.p013a.C0750a;
import com.baidu.location.indoor.mapversion.p014b.C0751a;

/* renamed from: com.baidu.location.indoor.q */
/* loaded from: classes.dex */
class C0758q implements C0751a.c {

    /* renamed from: a */
    final /* synthetic */ String f1736a;

    /* renamed from: b */
    final /* synthetic */ String f1737b;

    /* renamed from: c */
    final /* synthetic */ C0755n f1738c;

    C0758q(C0755n c0755n, String str, String str2) {
        this.f1738c = c0755n;
        this.f1736a = str;
        this.f1737b = str2;
    }

    @Override // com.baidu.location.indoor.mapversion.p014b.C0751a.c
    /* renamed from: a */
    public void mo1305a(boolean z, String str) {
        this.f1738c.f1626Z = z;
        if (z) {
            this.f1738c.f1628aa = C0750a.m1268a(this.f1737b);
        }
    }
}