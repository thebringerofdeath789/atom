package com.baidu.location.indoor;

import com.baidu.location.indoor.mapversion.b.a;

/* loaded from: classes.dex */
class q implements a.c {
    final /* synthetic */ String a;
    final /* synthetic */ String b;
    final /* synthetic */ n c;

    q(n nVar, String str, String str2) {
        this.c = nVar;
        this.a = str;
        this.b = str2;
    }

    @Override // com.baidu.location.indoor.mapversion.b.a.c
    public void a(boolean z, String str) {
        this.c.Z = z;
        if (z) {
            this.c.aa = com.baidu.location.indoor.mapversion.a.a.a(this.b);
        }
    }
}
