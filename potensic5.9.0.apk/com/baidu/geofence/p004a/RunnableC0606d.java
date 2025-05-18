package com.baidu.geofence.p004a;

import com.baidu.geofence.GeoFenceListener;

/* renamed from: com.baidu.geofence.a.d */
/* loaded from: classes.dex */
class RunnableC0606d implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C0604b f169a;

    RunnableC0606d(C0604b c0604b) {
        this.f169a = c0604b;
    }

    @Override // java.lang.Runnable
    public void run() {
        GeoFenceListener geoFenceListener;
        GeoFenceListener geoFenceListener2;
        geoFenceListener = this.f169a.f166e;
        if (geoFenceListener != null) {
            geoFenceListener2 = this.f169a.f166e;
            geoFenceListener2.onGeoFenceCreateFinished(null, 9, null);
        }
    }
}