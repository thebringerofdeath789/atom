package com.baidu.lbsapi.auth;

import android.content.Context;
import java.util.Hashtable;

/* compiled from: LBSAuthManager.java */
/* renamed from: com.baidu.lbsapi.auth.l */
/* loaded from: classes.dex */
class RunnableC0631l implements Runnable {

    /* renamed from: a */
    final /* synthetic */ int f243a;

    /* renamed from: b */
    final /* synthetic */ boolean f244b;

    /* renamed from: c */
    final /* synthetic */ String f245c;

    /* renamed from: d */
    final /* synthetic */ String f246d;

    /* renamed from: e */
    final /* synthetic */ Hashtable f247e;

    /* renamed from: f */
    final /* synthetic */ LBSAuthManager f248f;

    RunnableC0631l(LBSAuthManager lBSAuthManager, int i, boolean z, String str, String str2, Hashtable hashtable) {
        this.f248f = lBSAuthManager;
        this.f243a = i;
        this.f244b = z;
        this.f245c = str;
        this.f246d = str2;
        this.f247e = hashtable;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean m169b;
        Context context;
        boolean m169b2;
        C0634o c0634o;
        C0634o c0634o2;
        StringBuilder append = new StringBuilder().append("status = ").append(this.f243a).append("; forced = ").append(this.f244b).append("checkAK = ");
        m169b = this.f248f.m169b(this.f245c);
        C0621b.m177a(append.append(m169b).toString());
        int i = this.f243a;
        if (i != 601 && !this.f244b && i != -1) {
            m169b2 = this.f248f.m169b(this.f245c);
            if (!m169b2) {
                if (602 == this.f243a) {
                    C0621b.m177a("authenticate wait ");
                    c0634o = LBSAuthManager.f213d;
                    if (c0634o != null) {
                        c0634o2 = LBSAuthManager.f213d;
                        c0634o2.m213b();
                    }
                    this.f248f.m160a((String) null, this.f245c);
                    return;
                }
                C0621b.m177a("authenticate else");
                this.f248f.m160a((String) null, this.f245c);
                return;
            }
        }
        C0621b.m177a("authenticate sendAuthRequest");
        context = LBSAuthManager.f212a;
        String[] m188b = C0623d.m188b(context);
        if (m188b == null || m188b.length <= 1) {
            this.f248f.m164a(this.f244b, this.f246d, this.f247e, this.f245c);
            return;
        }
        C0621b.m177a("authStrings.length:" + m188b.length);
        C0621b.m177a("more sha1 auth");
        this.f248f.m165a(this.f244b, this.f246d, (Hashtable<String, String>) this.f247e, m188b, this.f245c);
    }
}