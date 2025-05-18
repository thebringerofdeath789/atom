package com.tencent.bugly.proguard;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.ar */
/* loaded from: classes3.dex */
public final class C3378ar extends AbstractC3388k implements Cloneable {

    /* renamed from: f */
    private static ArrayList<C3377aq> f3349f;

    /* renamed from: g */
    private static Map<String, String> f3350g;

    /* renamed from: a */
    public byte f3351a = 0;

    /* renamed from: b */
    public String f3352b = "";

    /* renamed from: c */
    public String f3353c = "";

    /* renamed from: d */
    public ArrayList<C3377aq> f3354d = null;

    /* renamed from: e */
    public Map<String, String> f3355e = null;

    @Override // com.tencent.bugly.proguard.AbstractC3388k
    /* renamed from: a */
    public final void mo2098a(StringBuilder sb, int i) {
    }

    @Override // com.tencent.bugly.proguard.AbstractC3388k
    /* renamed from: a */
    public final void mo2097a(C3387j c3387j) {
        c3387j.m2148a(this.f3351a, 0);
        String str = this.f3352b;
        if (str != null) {
            c3387j.m2153a(str, 1);
        }
        String str2 = this.f3353c;
        if (str2 != null) {
            c3387j.m2153a(str2, 2);
        }
        ArrayList<C3377aq> arrayList = this.f3354d;
        if (arrayList != null) {
            c3387j.m2154a((Collection) arrayList, 3);
        }
        Map<String, String> map = this.f3355e;
        if (map != null) {
            c3387j.m2155a((Map) map, 4);
        }
    }

    @Override // com.tencent.bugly.proguard.AbstractC3388k
    /* renamed from: a */
    public final void mo2096a(C3386i c3386i) {
        this.f3351a = c3386i.m2132a(this.f3351a, 0, true);
        this.f3352b = c3386i.m2142b(1, false);
        this.f3353c = c3386i.m2142b(2, false);
        if (f3349f == null) {
            f3349f = new ArrayList<>();
            f3349f.add(new C3377aq());
        }
        this.f3354d = (ArrayList) c3386i.m2137a((C3386i) f3349f, 3, false);
        if (f3350g == null) {
            HashMap hashMap = new HashMap();
            f3350g = hashMap;
            hashMap.put("", "");
        }
        this.f3355e = (Map) c3386i.m2137a((C3386i) f3350g, 4, false);
    }
}