package com.tencent.bugly.proguard;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.ah */
/* loaded from: classes3.dex */
public final class C3368ah extends AbstractC3388k implements Cloneable {

    /* renamed from: a */
    public String f3244a = "";

    /* renamed from: d */
    private String f3247d = "";

    /* renamed from: b */
    public String f3245b = "";

    /* renamed from: e */
    private String f3248e = "";

    /* renamed from: c */
    public String f3246c = "";

    @Override // com.tencent.bugly.proguard.AbstractC3388k
    /* renamed from: a */
    public final void mo2098a(StringBuilder sb, int i) {
    }

    @Override // com.tencent.bugly.proguard.AbstractC3388k
    /* renamed from: a */
    public final void mo2097a(C3387j c3387j) {
        c3387j.m2153a(this.f3244a, 0);
        String str = this.f3247d;
        if (str != null) {
            c3387j.m2153a(str, 1);
        }
        String str2 = this.f3245b;
        if (str2 != null) {
            c3387j.m2153a(str2, 2);
        }
        String str3 = this.f3248e;
        if (str3 != null) {
            c3387j.m2153a(str3, 3);
        }
        String str4 = this.f3246c;
        if (str4 != null) {
            c3387j.m2153a(str4, 4);
        }
    }

    @Override // com.tencent.bugly.proguard.AbstractC3388k
    /* renamed from: a */
    public final void mo2096a(C3386i c3386i) {
        this.f3244a = c3386i.m2142b(0, true);
        this.f3247d = c3386i.m2142b(1, false);
        this.f3245b = c3386i.m2142b(2, false);
        this.f3248e = c3386i.m2142b(3, false);
        this.f3246c = c3386i.m2142b(4, false);
    }
}