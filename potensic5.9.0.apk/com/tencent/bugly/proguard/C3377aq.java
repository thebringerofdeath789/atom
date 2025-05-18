package com.tencent.bugly.proguard;

import java.util.HashMap;
import java.util.Map;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.aq */
/* loaded from: classes3.dex */
public final class C3377aq extends AbstractC3388k {

    /* renamed from: i */
    private static Map<String, String> f3340i;

    /* renamed from: a */
    public long f3341a = 0;

    /* renamed from: b */
    public byte f3342b = 0;

    /* renamed from: c */
    public String f3343c = "";

    /* renamed from: d */
    public String f3344d = "";

    /* renamed from: e */
    public String f3345e = "";

    /* renamed from: f */
    public Map<String, String> f3346f = null;

    /* renamed from: h */
    private String f3348h = "";

    /* renamed from: g */
    public boolean f3347g = true;

    @Override // com.tencent.bugly.proguard.AbstractC3388k
    /* renamed from: a */
    public final void mo2097a(C3387j c3387j) {
        c3387j.m2150a(this.f3341a, 0);
        c3387j.m2148a(this.f3342b, 1);
        String str = this.f3343c;
        if (str != null) {
            c3387j.m2153a(str, 2);
        }
        String str2 = this.f3344d;
        if (str2 != null) {
            c3387j.m2153a(str2, 3);
        }
        String str3 = this.f3345e;
        if (str3 != null) {
            c3387j.m2153a(str3, 4);
        }
        Map<String, String> map = this.f3346f;
        if (map != null) {
            c3387j.m2155a((Map) map, 5);
        }
        String str4 = this.f3348h;
        if (str4 != null) {
            c3387j.m2153a(str4, 6);
        }
        c3387j.m2157a(this.f3347g, 7);
    }

    static {
        HashMap hashMap = new HashMap();
        f3340i = hashMap;
        hashMap.put("", "");
    }

    @Override // com.tencent.bugly.proguard.AbstractC3388k
    /* renamed from: a */
    public final void mo2096a(C3386i c3386i) {
        this.f3341a = c3386i.m2135a(this.f3341a, 0, true);
        this.f3342b = c3386i.m2132a(this.f3342b, 1, true);
        this.f3343c = c3386i.m2142b(2, false);
        this.f3344d = c3386i.m2142b(3, false);
        this.f3345e = c3386i.m2142b(4, false);
        this.f3346f = (Map) c3386i.m2137a((C3386i) f3340i, 5, false);
        this.f3348h = c3386i.m2142b(6, false);
        this.f3347g = c3386i.m2141a(7, false);
    }
}