package com.baidu.geofence;

import android.text.TextUtils;
import com.baidu.geofence.a.f;
import com.baidu.geofence.model.DPoint;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
class b implements f.a {
    final /* synthetic */ String a;
    final /* synthetic */ String b;
    final /* synthetic */ GeoFenceClient c;

    b(GeoFenceClient geoFenceClient, String str, String str2) {
        this.c = geoFenceClient;
        this.a = str;
        this.b = str2;
    }

    @Override // com.baidu.geofence.a.f.a
    public void a(int i, ArrayList<PoiItem> arrayList) {
        ArrayList arrayList2;
        ArrayList arrayList3;
        GeoFenceListener geoFenceListener;
        GeoFenceListener geoFenceListener2;
        GeoFenceListener geoFenceListener3;
        GeoFenceListener geoFenceListener4;
        ArrayList arrayList4;
        GeoFence geoFence;
        String str;
        String str2;
        Map map;
        String str3;
        int i2;
        ArrayList arrayList5;
        ArrayList arrayList6;
        String str4;
        String str5;
        Map map2;
        String str6;
        int i3;
        GeoFenceListener geoFenceListener5;
        GeoFenceListener geoFenceListener6;
        GeoFenceListener geoFenceListener7;
        GeoFenceListener geoFenceListener8;
        if (i != 0) {
            geoFenceListener7 = this.c.c;
            if (geoFenceListener7 != null) {
                geoFenceListener8 = this.c.c;
                geoFenceListener8.onGeoFenceCreateFinished(null, 13, this.a);
                return;
            }
            return;
        }
        if (arrayList == null || arrayList.size() == 0) {
            return;
        }
        Iterator<PoiItem> it = arrayList.iterator();
        ArrayList arrayList7 = null;
        while (true) {
            boolean z = false;
            if (!it.hasNext()) {
                break;
            }
            PoiItem next = it.next();
            arrayList4 = this.c.d;
            if (arrayList4 != null) {
                arrayList5 = this.c.d;
                if (arrayList5.size() != 0) {
                    arrayList6 = this.c.d;
                    Iterator it2 = arrayList6.iterator();
                    while (it2.hasNext()) {
                        GeoFence geoFence2 = (GeoFence) it2.next();
                        if (geoFence2.getType() == 22 && next.getLatitude() == geoFence2.getPoiItem().getLatitude() && next.getLongitude() == geoFence2.getPoiItem().getLongitude()) {
                            geoFenceListener5 = this.c.c;
                            if (geoFenceListener5 != null) {
                                geoFenceListener6 = this.c.c;
                                geoFenceListener6.onGeoFenceCreateFinished(null, 14, this.a);
                            }
                            z = true;
                        }
                    }
                    if (!z) {
                        geoFence = new GeoFence();
                        geoFence.setFenceType(22);
                        geoFence.setPoiItem(next);
                        geoFence.setRadius(200.0f);
                        geoFence.setKeyWord(this.b);
                        str4 = this.c.a;
                        geoFence.setActivatesAction(str4);
                        str5 = this.c.a;
                        if (!TextUtils.isEmpty(str5)) {
                            str6 = this.c.a;
                            if (str6.contains(GeoFence.BUNDLE_KEY_FENCESTATUS)) {
                                i3 = this.c.b;
                                geoFence.setStayTime(i3);
                            }
                        }
                        geoFence.setCustomId(this.a);
                        geoFence.setFenceId(String.valueOf(GeoFenceClient.e(this.c)));
                        map2 = this.c.x;
                        map2.put(geoFence.getFenceId(), 2);
                        geoFence.setCenter(new DPoint(next.getLatitude(), next.getLongitude()));
                        if (arrayList7 == null) {
                            arrayList7 = new ArrayList();
                        }
                        this.c.a(geoFence);
                        arrayList7.add(geoFence);
                    }
                }
            }
            geoFence = new GeoFence();
            geoFence.setFenceType(22);
            geoFence.setPoiItem(next);
            geoFence.setRadius(200.0f);
            geoFence.setKeyWord(this.b);
            str = this.c.a;
            geoFence.setActivatesAction(str);
            str2 = this.c.a;
            if (!TextUtils.isEmpty(str2)) {
                str3 = this.c.a;
                if (str3.contains(GeoFence.BUNDLE_KEY_FENCESTATUS)) {
                    i2 = this.c.b;
                    geoFence.setStayTime(i2);
                }
            }
            geoFence.setCustomId(this.a);
            geoFence.setFenceId(String.valueOf(GeoFenceClient.e(this.c)));
            map = this.c.x;
            map.put(geoFence.getFenceId(), 2);
            geoFence.setCenter(new DPoint(next.getLatitude(), next.getLongitude()));
            if (arrayList7 == null) {
                arrayList7 = new ArrayList();
            }
            this.c.a(geoFence);
            arrayList7.add(geoFence);
        }
        if (arrayList7 == null) {
            geoFenceListener3 = this.c.c;
            if (geoFenceListener3 != null) {
                geoFenceListener4 = this.c.c;
                geoFenceListener4.onGeoFenceCreateFinished(null, 13, this.a);
                return;
            }
            return;
        }
        if (arrayList7.isEmpty()) {
            return;
        }
        arrayList2 = this.c.d;
        if (arrayList2 != null) {
            arrayList3 = this.c.d;
            arrayList3.addAll(arrayList7);
            geoFenceListener = this.c.c;
            if (geoFenceListener != null) {
                geoFenceListener2 = this.c.c;
                geoFenceListener2.onGeoFenceCreateFinished(arrayList7, 7, this.a);
            }
            this.c.n = false;
            this.c.a();
        }
    }
}
