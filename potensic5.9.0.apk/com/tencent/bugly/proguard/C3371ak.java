package com.tencent.bugly.proguard;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.ak */
/* loaded from: classes3.dex */
public final class C3371ak extends AbstractC3388k {

    /* renamed from: A */
    private static ArrayList<C3370aj> f3256A;

    /* renamed from: B */
    private static Map<String, String> f3257B;

    /* renamed from: C */
    private static Map<String, String> f3258C;

    /* renamed from: v */
    private static Map<String, String> f3259v;

    /* renamed from: w */
    private static C3369ai f3260w;

    /* renamed from: x */
    private static C3368ah f3261x;

    /* renamed from: y */
    private static ArrayList<C3368ah> f3262y;

    /* renamed from: z */
    private static ArrayList<C3368ah> f3263z;

    /* renamed from: a */
    public String f3264a = "";

    /* renamed from: b */
    public long f3265b = 0;

    /* renamed from: c */
    public String f3266c = "";

    /* renamed from: d */
    public String f3267d = "";

    /* renamed from: e */
    public String f3268e = "";

    /* renamed from: f */
    public String f3269f = "";

    /* renamed from: g */
    public String f3270g = "";

    /* renamed from: h */
    public Map<String, String> f3271h = null;

    /* renamed from: i */
    public String f3272i = "";

    /* renamed from: j */
    public C3369ai f3273j = null;

    /* renamed from: k */
    public int f3274k = 0;

    /* renamed from: l */
    public String f3275l = "";

    /* renamed from: m */
    public String f3276m = "";

    /* renamed from: n */
    public C3368ah f3277n = null;

    /* renamed from: o */
    public ArrayList<C3368ah> f3278o = null;

    /* renamed from: p */
    public ArrayList<C3368ah> f3279p = null;

    /* renamed from: q */
    public ArrayList<C3370aj> f3280q = null;

    /* renamed from: r */
    public Map<String, String> f3281r = null;

    /* renamed from: s */
    public Map<String, String> f3282s = null;

    /* renamed from: t */
    private String f3283t = "";

    /* renamed from: u */
    private boolean f3284u = true;

    @Override // com.tencent.bugly.proguard.AbstractC3388k
    /* renamed from: a */
    public final void mo2097a(C3387j c3387j) {
        c3387j.m2153a(this.f3264a, 0);
        c3387j.m2150a(this.f3265b, 1);
        c3387j.m2153a(this.f3266c, 2);
        String str = this.f3267d;
        if (str != null) {
            c3387j.m2153a(str, 3);
        }
        String str2 = this.f3268e;
        if (str2 != null) {
            c3387j.m2153a(str2, 4);
        }
        String str3 = this.f3269f;
        if (str3 != null) {
            c3387j.m2153a(str3, 5);
        }
        String str4 = this.f3270g;
        if (str4 != null) {
            c3387j.m2153a(str4, 6);
        }
        Map<String, String> map = this.f3271h;
        if (map != null) {
            c3387j.m2155a((Map) map, 7);
        }
        String str5 = this.f3272i;
        if (str5 != null) {
            c3387j.m2153a(str5, 8);
        }
        C3369ai c3369ai = this.f3273j;
        if (c3369ai != null) {
            c3387j.m2151a((AbstractC3388k) c3369ai, 9);
        }
        c3387j.m2149a(this.f3274k, 10);
        String str6 = this.f3275l;
        if (str6 != null) {
            c3387j.m2153a(str6, 11);
        }
        String str7 = this.f3276m;
        if (str7 != null) {
            c3387j.m2153a(str7, 12);
        }
        C3368ah c3368ah = this.f3277n;
        if (c3368ah != null) {
            c3387j.m2151a((AbstractC3388k) c3368ah, 13);
        }
        ArrayList<C3368ah> arrayList = this.f3278o;
        if (arrayList != null) {
            c3387j.m2154a((Collection) arrayList, 14);
        }
        ArrayList<C3368ah> arrayList2 = this.f3279p;
        if (arrayList2 != null) {
            c3387j.m2154a((Collection) arrayList2, 15);
        }
        ArrayList<C3370aj> arrayList3 = this.f3280q;
        if (arrayList3 != null) {
            c3387j.m2154a((Collection) arrayList3, 16);
        }
        Map<String, String> map2 = this.f3281r;
        if (map2 != null) {
            c3387j.m2155a((Map) map2, 17);
        }
        Map<String, String> map3 = this.f3282s;
        if (map3 != null) {
            c3387j.m2155a((Map) map3, 18);
        }
        String str8 = this.f3283t;
        if (str8 != null) {
            c3387j.m2153a(str8, 19);
        }
        c3387j.m2157a(this.f3284u, 20);
    }

    static {
        HashMap hashMap = new HashMap();
        f3259v = hashMap;
        hashMap.put("", "");
        f3260w = new C3369ai();
        f3261x = new C3368ah();
        f3262y = new ArrayList<>();
        f3262y.add(new C3368ah());
        f3263z = new ArrayList<>();
        f3263z.add(new C3368ah());
        f3256A = new ArrayList<>();
        f3256A.add(new C3370aj());
        HashMap hashMap2 = new HashMap();
        f3257B = hashMap2;
        hashMap2.put("", "");
        HashMap hashMap3 = new HashMap();
        f3258C = hashMap3;
        hashMap3.put("", "");
    }

    @Override // com.tencent.bugly.proguard.AbstractC3388k
    /* renamed from: a */
    public final void mo2096a(C3386i c3386i) {
        this.f3264a = c3386i.m2142b(0, true);
        this.f3265b = c3386i.m2135a(this.f3265b, 1, true);
        this.f3266c = c3386i.m2142b(2, true);
        this.f3267d = c3386i.m2142b(3, false);
        this.f3268e = c3386i.m2142b(4, false);
        this.f3269f = c3386i.m2142b(5, false);
        this.f3270g = c3386i.m2142b(6, false);
        this.f3271h = (Map) c3386i.m2137a((C3386i) f3259v, 7, false);
        this.f3272i = c3386i.m2142b(8, false);
        this.f3273j = (C3369ai) c3386i.m2136a((AbstractC3388k) f3260w, 9, false);
        this.f3274k = c3386i.m2133a(this.f3274k, 10, false);
        this.f3275l = c3386i.m2142b(11, false);
        this.f3276m = c3386i.m2142b(12, false);
        this.f3277n = (C3368ah) c3386i.m2136a((AbstractC3388k) f3261x, 13, false);
        this.f3278o = (ArrayList) c3386i.m2137a((C3386i) f3262y, 14, false);
        this.f3279p = (ArrayList) c3386i.m2137a((C3386i) f3263z, 15, false);
        this.f3280q = (ArrayList) c3386i.m2137a((C3386i) f3256A, 16, false);
        this.f3281r = (Map) c3386i.m2137a((C3386i) f3257B, 17, false);
        this.f3282s = (Map) c3386i.m2137a((C3386i) f3258C, 18, false);
        this.f3283t = c3386i.m2142b(19, false);
        this.f3284u = c3386i.m2141a(20, false);
    }
}