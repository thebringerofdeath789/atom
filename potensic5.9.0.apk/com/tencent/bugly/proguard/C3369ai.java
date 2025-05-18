package com.tencent.bugly.proguard;

import java.util.ArrayList;
import java.util.Collection;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.ai */
/* loaded from: classes3.dex */
public final class C3369ai extends AbstractC3388k implements Cloneable {

    /* renamed from: c */
    private static ArrayList<String> f3249c;

    /* renamed from: a */
    private String f3250a = "";

    /* renamed from: b */
    private ArrayList<String> f3251b = null;

    @Override // com.tencent.bugly.proguard.AbstractC3388k
    /* renamed from: a */
    public final void mo2098a(StringBuilder sb, int i) {
    }

    @Override // com.tencent.bugly.proguard.AbstractC3388k
    /* renamed from: a */
    public final void mo2097a(C3387j c3387j) {
        c3387j.m2153a(this.f3250a, 0);
        ArrayList<String> arrayList = this.f3251b;
        if (arrayList != null) {
            c3387j.m2154a((Collection) arrayList, 1);
        }
    }

    @Override // com.tencent.bugly.proguard.AbstractC3388k
    /* renamed from: a */
    public final void mo2096a(C3386i c3386i) {
        this.f3250a = c3386i.m2142b(0, true);
        if (f3249c == null) {
            ArrayList<String> arrayList = new ArrayList<>();
            f3249c = arrayList;
            arrayList.add("");
        }
        this.f3251b = (ArrayList) c3386i.m2137a((C3386i) f3249c, 1, false);
    }
}