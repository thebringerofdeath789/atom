package com.tencent.bugly.proguard;

import java.util.ArrayList;
import java.util.Collection;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.al */
/* loaded from: classes3.dex */
public final class C3372al extends AbstractC3388k implements Cloneable {

    /* renamed from: b */
    private static ArrayList<C3371ak> f3285b;

    /* renamed from: a */
    public ArrayList<C3371ak> f3286a = null;

    @Override // com.tencent.bugly.proguard.AbstractC3388k
    /* renamed from: a */
    public final void mo2098a(StringBuilder sb, int i) {
    }

    @Override // com.tencent.bugly.proguard.AbstractC3388k
    /* renamed from: a */
    public final void mo2097a(C3387j c3387j) {
        c3387j.m2154a((Collection) this.f3286a, 0);
    }

    @Override // com.tencent.bugly.proguard.AbstractC3388k
    /* renamed from: a */
    public final void mo2096a(C3386i c3386i) {
        if (f3285b == null) {
            f3285b = new ArrayList<>();
            f3285b.add(new C3371ak());
        }
        this.f3286a = (ArrayList) c3386i.m2137a((C3386i) f3285b, 0, true);
    }
}