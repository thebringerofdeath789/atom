package com.tencent.bugly.proguard;

import java.util.HashMap;
import java.util.Map;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.ap */
/* loaded from: classes3.dex */
public final class C3376ap extends AbstractC3388k implements Cloneable {

    /* renamed from: m */
    private static C3375ao f3325m = new C3375ao();

    /* renamed from: n */
    private static Map<String, String> f3326n = null;

    /* renamed from: o */
    private static /* synthetic */ boolean f3327o = true;

    /* renamed from: a */
    public boolean f3328a = true;

    /* renamed from: b */
    public boolean f3329b = true;

    /* renamed from: c */
    public boolean f3330c = true;

    /* renamed from: d */
    public String f3331d = "";

    /* renamed from: e */
    public String f3332e = "";

    /* renamed from: f */
    public C3375ao f3333f = null;

    /* renamed from: g */
    public Map<String, String> f3334g = null;

    /* renamed from: h */
    public long f3335h = 0;

    /* renamed from: j */
    private String f3337j = "";

    /* renamed from: k */
    private String f3338k = "";

    /* renamed from: l */
    private int f3339l = 0;

    /* renamed from: i */
    public int f3336i = 0;

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        C3376ap c3376ap = (C3376ap) obj;
        return C3389l.m2163a(this.f3328a, c3376ap.f3328a) && C3389l.m2163a(this.f3329b, c3376ap.f3329b) && C3389l.m2163a(this.f3330c, c3376ap.f3330c) && C3389l.m2162a(this.f3331d, c3376ap.f3331d) && C3389l.m2162a(this.f3332e, c3376ap.f3332e) && C3389l.m2162a(this.f3333f, c3376ap.f3333f) && C3389l.m2162a(this.f3334g, c3376ap.f3334g) && C3389l.m2161a(this.f3335h, c3376ap.f3335h) && C3389l.m2162a(this.f3337j, c3376ap.f3337j) && C3389l.m2162a(this.f3338k, c3376ap.f3338k) && C3389l.m2160a(this.f3339l, c3376ap.f3339l) && C3389l.m2160a(this.f3336i, c3376ap.f3336i);
    }

    public final int hashCode() {
        try {
            throw new Exception("Need define key first!");
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public final Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            if (f3327o) {
                return null;
            }
            throw new AssertionError();
        }
    }

    @Override // com.tencent.bugly.proguard.AbstractC3388k
    /* renamed from: a */
    public final void mo2097a(C3387j c3387j) {
        c3387j.m2157a(this.f3328a, 0);
        c3387j.m2157a(this.f3329b, 1);
        c3387j.m2157a(this.f3330c, 2);
        String str = this.f3331d;
        if (str != null) {
            c3387j.m2153a(str, 3);
        }
        String str2 = this.f3332e;
        if (str2 != null) {
            c3387j.m2153a(str2, 4);
        }
        C3375ao c3375ao = this.f3333f;
        if (c3375ao != null) {
            c3387j.m2151a((AbstractC3388k) c3375ao, 5);
        }
        Map<String, String> map = this.f3334g;
        if (map != null) {
            c3387j.m2155a((Map) map, 6);
        }
        c3387j.m2150a(this.f3335h, 7);
        String str3 = this.f3337j;
        if (str3 != null) {
            c3387j.m2153a(str3, 8);
        }
        String str4 = this.f3338k;
        if (str4 != null) {
            c3387j.m2153a(str4, 9);
        }
        c3387j.m2149a(this.f3339l, 10);
        c3387j.m2149a(this.f3336i, 11);
    }

    static {
        HashMap hashMap = new HashMap();
        f3326n = hashMap;
        hashMap.put("", "");
    }

    @Override // com.tencent.bugly.proguard.AbstractC3388k
    /* renamed from: a */
    public final void mo2096a(C3386i c3386i) {
        this.f3328a = c3386i.m2141a(0, true);
        this.f3329b = c3386i.m2141a(1, true);
        this.f3330c = c3386i.m2141a(2, true);
        this.f3331d = c3386i.m2142b(3, false);
        this.f3332e = c3386i.m2142b(4, false);
        this.f3333f = (C3375ao) c3386i.m2136a((AbstractC3388k) f3325m, 5, false);
        this.f3334g = (Map) c3386i.m2137a((C3386i) f3326n, 6, false);
        this.f3335h = c3386i.m2135a(this.f3335h, 7, false);
        this.f3337j = c3386i.m2142b(8, false);
        this.f3338k = c3386i.m2142b(9, false);
        this.f3339l = c3386i.m2133a(this.f3339l, 10, false);
        this.f3336i = c3386i.m2133a(this.f3336i, 11, false);
    }

    @Override // com.tencent.bugly.proguard.AbstractC3388k
    /* renamed from: a */
    public final void mo2098a(StringBuilder sb, int i) {
        C3385h c3385h = new C3385h(sb, i);
        c3385h.m2115a(this.f3328a, "enable");
        c3385h.m2115a(this.f3329b, "enableUserInfo");
        c3385h.m2115a(this.f3330c, "enableQuery");
        c3385h.m2112a(this.f3331d, "url");
        c3385h.m2112a(this.f3332e, "expUrl");
        c3385h.m2111a((AbstractC3388k) this.f3333f, "security");
        c3385h.m2113a((Map) this.f3334g, "valueMap");
        c3385h.m2110a(this.f3335h, "strategylastUpdateTime");
        c3385h.m2112a(this.f3337j, "httpsUrl");
        c3385h.m2112a(this.f3338k, "httpsExpUrl");
        c3385h.m2109a(this.f3339l, "eventRecordCount");
        c3385h.m2109a(this.f3336i, "eventTimeInterval");
    }
}