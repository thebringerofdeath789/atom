package com.baidu.geofence.p004a;

import com.baidu.geofence.GeoFenceListener;

/* renamed from: com.baidu.geofence.a.g */
/* loaded from: classes.dex */
class RunnableC0609g implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C0608f f187a;

    RunnableC0609g(C0608f c0608f) {
        this.f187a = c0608f;
    }

    @Override // java.lang.Runnable
    public void run() {
        GeoFenceListener geoFenceListener;
        GeoFenceListener geoFenceListener2;
        String str;
        geoFenceListener = this.f187a.f182v;
        if (geoFenceListener != null) {
            geoFenceListener2 = this.f187a.f182v;
            str = this.f187a.f183w;
            geoFenceListener2.onGeoFenceCreateFinished(null, 10, str);
        }
    }
}