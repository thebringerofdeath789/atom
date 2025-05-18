package com.baidu.geofence.p004a;

import com.baidu.geofence.GeoFenceListener;

/* renamed from: com.baidu.geofence.a.c */
/* loaded from: classes.dex */
class RunnableC0605c implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C0604b f168a;

    RunnableC0605c(C0604b c0604b) {
        this.f168a = c0604b;
    }

    @Override // java.lang.Runnable
    public void run() {
        GeoFenceListener geoFenceListener;
        GeoFenceListener geoFenceListener2;
        geoFenceListener = this.f168a.f166e;
        if (geoFenceListener != null) {
            geoFenceListener2 = this.f168a.f166e;
            geoFenceListener2.onGeoFenceCreateFinished(null, 10, null);
        }
    }
}