package com.tencent.bugly.proguard;

import java.util.HashMap;
import java.util.Map;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.an */
/* loaded from: classes3.dex */
public final class C3374an extends AbstractC3388k {

    /* renamed from: i */
    private static byte[] f3313i = {0};

    /* renamed from: j */
    private static Map<String, String> f3314j;

    /* renamed from: a */
    public byte f3315a = 0;

    /* renamed from: b */
    public int f3316b = 0;

    /* renamed from: c */
    public byte[] f3317c = null;

    /* renamed from: f */
    private String f3320f = "";

    /* renamed from: d */
    public long f3318d = 0;

    /* renamed from: g */
    private String f3321g = "";

    /* renamed from: e */
    public String f3319e = "";

    /* renamed from: h */
    private Map<String, String> f3322h = null;

    @Override // com.tencent.bugly.proguard.AbstractC3388k
    /* renamed from: a */
    public final void mo2097a(C3387j c3387j) {
        c3387j.m2148a(this.f3315a, 0);
        c3387j.m2149a(this.f3316b, 1);
        byte[] bArr = this.f3317c;
        if (bArr != null) {
            c3387j.m2158a(bArr, 2);
        }
        String str = this.f3320f;
        if (str != null) {
            c3387j.m2153a(str, 3);
        }
        c3387j.m2150a(this.f3318d, 4);
        String str2 = this.f3321g;
        if (str2 != null) {
            c3387j.m2153a(str2, 5);
        }
        String str3 = this.f3319e;
        if (str3 != null) {
            c3387j.m2153a(str3, 6);
        }
        Map<String, String> map = this.f3322h;
        if (map != null) {
            c3387j.m2155a((Map) map, 7);
        }
    }

    static {
        HashMap hashMap = new HashMap();
        f3314j = hashMap;
        hashMap.put("", "");
    }

    @Override // com.tencent.bugly.proguard.AbstractC3388k
    /* renamed from: a */
    public final void mo2096a(C3386i c3386i) {
        this.f3315a = c3386i.m2132a(this.f3315a, 0, true);
        this.f3316b = c3386i.m2133a(this.f3316b, 1, true);
        this.f3317c = c3386i.m2143c(2, false);
        this.f3320f = c3386i.m2142b(3, false);
        this.f3318d = c3386i.m2135a(this.f3318d, 4, false);
        this.f3321g = c3386i.m2142b(5, false);
        this.f3319e = c3386i.m2142b(6, false);
        this.f3322h = (Map) c3386i.m2137a((C3386i) f3314j, 7, false);
    }
}