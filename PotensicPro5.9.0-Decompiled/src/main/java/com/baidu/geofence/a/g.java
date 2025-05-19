package com.baidu.geofence.a;

import com.baidu.geofence.GeoFenceListener;

/* loaded from: classes.dex */
class g implements Runnable {
    final /* synthetic */ f a;

    g(f fVar) {
        this.a = fVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        GeoFenceListener geoFenceListener;
        GeoFenceListener geoFenceListener2;
        String str;
        geoFenceListener = this.a.v;
        if (geoFenceListener != null) {
            geoFenceListener2 = this.a.v;
            str = this.a.w;
            geoFenceListener2.onGeoFenceCreateFinished(null, 10, str);
        }
    }
}
