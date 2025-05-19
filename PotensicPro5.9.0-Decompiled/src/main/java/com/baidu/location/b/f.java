package com.baidu.location.b;

import com.baidu.location.b.e;
import java.util.Comparator;

/* loaded from: classes.dex */
class f implements Comparator<e.d> {
    final /* synthetic */ e a;

    f(e eVar) {
        this.a = eVar;
    }

    @Override // java.util.Comparator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(e.d dVar, e.d dVar2) {
        if (dVar.b > dVar2.b) {
            return -1;
        }
        return dVar.b == dVar2.b ? 0 : 1;
    }
}
