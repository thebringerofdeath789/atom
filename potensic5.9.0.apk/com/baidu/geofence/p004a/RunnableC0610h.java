package com.baidu.geofence.p004a;

import com.baidu.geofence.GeoFenceListener;

/* renamed from: com.baidu.geofence.a.h */
/* loaded from: classes.dex */
class RunnableC0610h implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C0608f f188a;

    RunnableC0610h(C0608f c0608f) {
        this.f188a = c0608f;
    }

    @Override // java.lang.Runnable
    public void run() {
        GeoFenceListener geoFenceListener;
        GeoFenceListener geoFenceListener2;
        String str;
        geoFenceListener = this.f188a.f182v;
        if (geoFenceListener != null) {
            geoFenceListener2 = this.f188a.f182v;
            str = this.f188a.f183w;
            geoFenceListener2.onGeoFenceCreateFinished(null, 9, str);
        }
    }
}