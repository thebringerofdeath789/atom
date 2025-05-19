package com.baidu.location.indoor;

import com.baidu.location.indoor.l;
import com.baidu.location.indoor.n;

/* loaded from: classes.dex */
class s implements l.c {
    final /* synthetic */ n.j a;

    s(n.j jVar) {
        this.a = jVar;
    }

    @Override // com.baidu.location.indoor.l.c
    public void a(boolean z, String str, String str2, String str3) {
        if (z) {
            n.this.P = "&ibuuid=" + str + "&ibname=" + str2 + "&ibfls=" + str3;
        }
    }
}
