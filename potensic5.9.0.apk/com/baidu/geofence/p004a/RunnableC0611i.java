package com.baidu.geofence.p004a;

import com.baidu.geofence.p004a.C0608f;
import java.util.ArrayList;

/* renamed from: com.baidu.geofence.a.i */
/* loaded from: classes.dex */
class RunnableC0611i implements Runnable {

    /* renamed from: a */
    final /* synthetic */ int f189a;

    /* renamed from: b */
    final /* synthetic */ ArrayList f190b;

    /* renamed from: c */
    final /* synthetic */ C0608f f191c;

    RunnableC0611i(C0608f c0608f, int i, ArrayList arrayList) {
        this.f191c = c0608f;
        this.f189a = i;
        this.f190b = arrayList;
    }

    @Override // java.lang.Runnable
    public void run() {
        C0608f.a aVar;
        C0608f.a aVar2;
        aVar = this.f191c.f186z;
        if (aVar != null) {
            aVar2 = this.f191c.f186z;
            aVar2.mo137a(this.f189a, this.f190b);
        }
    }
}