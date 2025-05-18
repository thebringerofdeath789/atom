package com.baidu.geofence.p004a;

import com.baidu.geofence.p004a.C0604b;

/* renamed from: com.baidu.geofence.a.e */
/* loaded from: classes.dex */
class RunnableC0607e implements Runnable {

    /* renamed from: a */
    final /* synthetic */ int f170a;

    /* renamed from: b */
    final /* synthetic */ C0604b f171b;

    RunnableC0607e(C0604b c0604b, int i) {
        this.f171b = c0604b;
        this.f170a = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        C0604b.a aVar;
        C0604b.a aVar2;
        aVar = this.f171b.f167f;
        if (aVar != null) {
            aVar2 = this.f171b.f167f;
            aVar2.mo124a(this.f170a);
        }
    }
}