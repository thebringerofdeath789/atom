package com.tencent.bugly.proguard;

import java.util.HashMap;
import java.util.Map;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.am */
/* loaded from: classes3.dex */
public final class C3373am extends AbstractC3388k {

    /* renamed from: y */
    private static byte[] f3287y = {0};

    /* renamed from: z */
    private static Map<String, String> f3288z;

    /* renamed from: a */
    public int f3289a = 0;

    /* renamed from: b */
    public String f3290b = "";

    /* renamed from: c */
    public String f3291c = "";

    /* renamed from: d */
    public String f3292d = "";

    /* renamed from: e */
    public String f3293e = "";

    /* renamed from: f */
    public String f3294f = "";

    /* renamed from: g */
    public int f3295g = 0;

    /* renamed from: h */
    public byte[] f3296h = null;

    /* renamed from: i */
    public String f3297i = "";

    /* renamed from: j */
    public String f3298j = "";

    /* renamed from: k */
    public Map<String, String> f3299k = null;

    /* renamed from: l */
    public String f3300l = "";

    /* renamed from: m */
    public long f3301m = 0;

    /* renamed from: n */
    public String f3302n = "";

    /* renamed from: o */
    public String f3303o = "";

    /* renamed from: p */
    public String f3304p = "";

    /* renamed from: q */
    public long f3305q = 0;

    /* renamed from: u */
    private String f3309u = "";

    /* renamed from: r */
    public String f3306r = "";

    /* renamed from: v */
    private String f3310v = "";

    /* renamed from: w */
    private String f3311w = "";

    /* renamed from: s */
    public String f3307s = "";

    /* renamed from: t */
    public String f3308t = "";

    /* renamed from: x */
    private String f3312x = "";

    @Override // com.tencent.bugly.proguard.AbstractC3388k
    /* renamed from: a */
    public final void mo2097a(C3387j c3387j) {
        c3387j.m2149a(this.f3289a, 0);
        c3387j.m2153a(this.f3290b, 1);
        c3387j.m2153a(this.f3291c, 2);
        c3387j.m2153a(this.f3292d, 3);
        String str = this.f3293e;
        if (str != null) {
            c3387j.m2153a(str, 4);
        }
        c3387j.m2153a(this.f3294f, 5);
        c3387j.m2149a(this.f3295g, 6);
        c3387j.m2158a(this.f3296h, 7);
        String str2 = this.f3297i;
        if (str2 != null) {
            c3387j.m2153a(str2, 8);
        }
        String str3 = this.f3298j;
        if (str3 != null) {
            c3387j.m2153a(str3, 9);
        }
        Map<String, String> map = this.f3299k;
        if (map != null) {
            c3387j.m2155a((Map) map, 10);
        }
        String str4 = this.f3300l;
        if (str4 != null) {
            c3387j.m2153a(str4, 11);
        }
        c3387j.m2150a(this.f3301m, 12);
        String str5 = this.f3302n;
        if (str5 != null) {
            c3387j.m2153a(str5, 13);
        }
        String str6 = this.f3303o;
        if (str6 != null) {
            c3387j.m2153a(str6, 14);
        }
        String str7 = this.f3304p;
        if (str7 != null) {
            c3387j.m2153a(str7, 15);
        }
        c3387j.m2150a(this.f3305q, 16);
        String str8 = this.f3309u;
        if (str8 != null) {
            c3387j.m2153a(str8, 17);
        }
        String str9 = this.f3306r;
        if (str9 != null) {
            c3387j.m2153a(str9, 18);
        }
        String str10 = this.f3310v;
        if (str10 != null) {
            c3387j.m2153a(str10, 19);
        }
        String str11 = this.f3311w;
        if (str11 != null) {
            c3387j.m2153a(str11, 20);
        }
        String str12 = this.f3307s;
        if (str12 != null) {
            c3387j.m2153a(str12, 21);
        }
        String str13 = this.f3308t;
        if (str13 != null) {
            c3387j.m2153a(str13, 22);
        }
        String str14 = this.f3312x;
        if (str14 != null) {
            c3387j.m2153a(str14, 23);
        }
    }

    static {
        HashMap hashMap = new HashMap();
        f3288z = hashMap;
        hashMap.put("", "");
    }

    @Override // com.tencent.bugly.proguard.AbstractC3388k
    /* renamed from: a */
    public final void mo2096a(C3386i c3386i) {
        this.f3289a = c3386i.m2133a(this.f3289a, 0, true);
        this.f3290b = c3386i.m2142b(1, true);
        this.f3291c = c3386i.m2142b(2, true);
        this.f3292d = c3386i.m2142b(3, true);
        this.f3293e = c3386i.m2142b(4, false);
        this.f3294f = c3386i.m2142b(5, true);
        this.f3295g = c3386i.m2133a(this.f3295g, 6, true);
        this.f3296h = c3386i.m2143c(7, true);
        this.f3297i = c3386i.m2142b(8, false);
        this.f3298j = c3386i.m2142b(9, false);
        this.f3299k = (Map) c3386i.m2137a((C3386i) f3288z, 10, false);
        this.f3300l = c3386i.m2142b(11, false);
        this.f3301m = c3386i.m2135a(this.f3301m, 12, false);
        this.f3302n = c3386i.m2142b(13, false);
        this.f3303o = c3386i.m2142b(14, false);
        this.f3304p = c3386i.m2142b(15, false);
        this.f3305q = c3386i.m2135a(this.f3305q, 16, false);
        this.f3309u = c3386i.m2142b(17, false);
        this.f3306r = c3386i.m2142b(18, false);
        this.f3310v = c3386i.m2142b(19, false);
        this.f3311w = c3386i.m2142b(20, false);
        this.f3307s = c3386i.m2142b(21, false);
        this.f3308t = c3386i.m2142b(22, false);
        this.f3312x = c3386i.m2142b(23, false);
    }
}