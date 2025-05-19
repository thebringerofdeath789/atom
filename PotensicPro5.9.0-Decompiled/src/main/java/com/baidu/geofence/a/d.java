package com.baidu.geofence.a;

import com.baidu.geofence.GeoFenceListener;

/* loaded from: classes.dex */
class d implements Runnable {
    final /* synthetic */ b a;

    d(b bVar) {
        this.a = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        GeoFenceListener geoFenceListener;
        GeoFenceListener geoFenceListener2;
        geoFenceListener = this.a.e;
        if (geoFenceListener != null) {
            geoFenceListener2 = this.a.e;
            geoFenceListener2.onGeoFenceCreateFinished(null, 9, null);
        }
    }
}
