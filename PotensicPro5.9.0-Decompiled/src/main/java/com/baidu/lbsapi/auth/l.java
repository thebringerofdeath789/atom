package com.baidu.lbsapi.auth;

import android.content.Context;
import java.util.Hashtable;

/* compiled from: LBSAuthManager.java */
/* loaded from: classes.dex */
class l implements Runnable {
    final /* synthetic */ int a;
    final /* synthetic */ boolean b;
    final /* synthetic */ String c;
    final /* synthetic */ String d;
    final /* synthetic */ Hashtable e;
    final /* synthetic */ LBSAuthManager f;

    l(LBSAuthManager lBSAuthManager, int i, boolean z, String str, String str2, Hashtable hashtable) {
        this.f = lBSAuthManager;
        this.a = i;
        this.b = z;
        this.c = str;
        this.d = str2;
        this.e = hashtable;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean b;
        Context context;
        boolean b2;
        o oVar;
        o oVar2;
        StringBuilder append = new StringBuilder().append("status = ").append(this.a).append("; forced = ").append(this.b).append("checkAK = ");
        b = this.f.b(this.c);
        b.a(append.append(b).toString());
        int i = this.a;
        if (i != 601 && !this.b && i != -1) {
            b2 = this.f.b(this.c);
            if (!b2) {
                if (602 == this.a) {
                    b.a("authenticate wait ");
                    oVar = LBSAuthManager.d;
                    if (oVar != null) {
                        oVar2 = LBSAuthManager.d;
                        oVar2.b();
                    }
                    this.f.a((String) null, this.c);
                    return;
                }
                b.a("authenticate else");
                this.f.a((String) null, this.c);
                return;
            }
        }
        b.a("authenticate sendAuthRequest");
        context = LBSAuthManager.a;
        String[] b3 = d.b(context);
        if (b3 == null || b3.length <= 1) {
            this.f.a(this.b, this.d, this.e, this.c);
            return;
        }
        b.a("authStrings.length:" + b3.length);
        b.a("more sha1 auth");
        this.f.a(this.b, this.d, (Hashtable<String, String>) this.e, b3, this.c);
    }
}
