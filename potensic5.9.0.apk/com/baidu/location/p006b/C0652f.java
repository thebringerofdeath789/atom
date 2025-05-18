package com.baidu.location.p006b;

import com.baidu.location.p006b.C0651e;
import java.util.Comparator;

/* renamed from: com.baidu.location.b.f */
/* loaded from: classes.dex */
class C0652f implements Comparator<C0651e.d> {

    /* renamed from: a */
    final /* synthetic */ C0651e f499a;

    C0652f(C0651e c0651e) {
        this.f499a = c0651e;
    }

    @Override // java.util.Comparator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(C0651e.d dVar, C0651e.d dVar2) {
        if (dVar.f491b > dVar2.f491b) {
            return -1;
        }
        return dVar.f491b == dVar2.f491b ? 0 : 1;
    }
}