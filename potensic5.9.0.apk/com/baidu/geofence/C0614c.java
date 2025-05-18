package com.baidu.geofence;

import android.text.TextUtils;
import com.baidu.geofence.model.DPoint;
import com.baidu.geofence.p004a.C0608f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* renamed from: com.baidu.geofence.c */
/* loaded from: classes.dex */
class C0614c implements C0608f.a {

    /* renamed from: a */
    final /* synthetic */ String f201a;

    /* renamed from: b */
    final /* synthetic */ String f202b;

    /* renamed from: c */
    final /* synthetic */ GeoFenceClient f203c;

    C0614c(GeoFenceClient geoFenceClient, String str, String str2) {
        this.f203c = geoFenceClient;
        this.f201a = str;
        this.f202b = str2;
    }

    @Override // com.baidu.geofence.p004a.C0608f.a
    /* renamed from: a */
    public void mo137a(int i, ArrayList<PoiItem> arrayList) {
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
        Map map2;
        GeoFenceListener geoFenceListener5;
        GeoFenceListener geoFenceListener6;
        GeoFenceListener geoFenceListener7;
        GeoFenceListener geoFenceListener8;
        if (i != 0) {
            geoFenceListener7 = this.f203c.f129c;
            if (geoFenceListener7 != null) {
                geoFenceListener8 = this.f203c.f129c;
                geoFenceListener8.onGeoFenceCreateFinished(null, 13, this.f201a);
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
            arrayList4 = this.f203c.f130d;
            if (arrayList4 != null) {
                arrayList5 = this.f203c.f130d;
                if (arrayList5.size() != 0) {
                    arrayList6 = this.f203c.f130d;
                    Iterator it2 = arrayList6.iterator();
                    while (it2.hasNext()) {
                        GeoFence geoFence2 = (GeoFence) it2.next();
                        if (geoFence2.getType() == 22 && next.getLatitude() == geoFence2.getPoiItem().getLatitude() && next.getLongitude() == geoFence2.getPoiItem().getLongitude()) {
                            geoFenceListener5 = this.f203c.f129c;
                            if (geoFenceListener5 != null) {
                                geoFenceListener6 = this.f203c.f129c;
                                geoFenceListener6.onGeoFenceCreateFinished(null, 14, this.f201a);
                            }
                            z = true;
                        }
                    }
                    if (!z) {
                        geoFence = new GeoFence();
                        geoFence.setFenceType(22);
                        geoFence.setRadius(1000.0f);
                        geoFence.setKeyWord(this.f202b);
                        str4 = this.f203c.f127a;
                        geoFence.setActivatesAction(str4);
                        geoFence.setPoiItem(next);
                        geoFence.setCustomId(this.f201a);
                        geoFence.setFenceId(String.valueOf(GeoFenceClient.m106e(this.f203c)));
                        map2 = this.f203c.f150x;
                        map2.put(geoFence.getFenceId(), 2);
                        geoFence.setCenter(new DPoint(next.getLatitude(), next.getLongitude()));
                        if (arrayList7 == null) {
                            arrayList7 = new ArrayList();
                        }
                        this.f203c.m87a(geoFence);
                        arrayList7.add(geoFence);
                    }
                }
            }
            geoFence = new GeoFence();
            geoFence.setFenceType(22);
            geoFence.setRadius(1000.0f);
            geoFence.setKeyWord(this.f202b);
            str = this.f203c.f127a;
            geoFence.setActivatesAction(str);
            str2 = this.f203c.f127a;
            if (!TextUtils.isEmpty(str2)) {
                str3 = this.f203c.f127a;
                if (str3.contains(GeoFence.BUNDLE_KEY_FENCESTATUS)) {
                    i2 = this.f203c.f128b;
                    geoFence.setStayTime(i2);
                }
            }
            geoFence.setPoiItem(next);
            geoFence.setCustomId(this.f201a);
            geoFence.setFenceId(String.valueOf(GeoFenceClient.m106e(this.f203c)));
            map = this.f203c.f150x;
            map.put(geoFence.getFenceId(), 2);
            geoFence.setCenter(new DPoint(next.getLatitude(), next.getLongitude()));
            if (arrayList7 == null) {
                arrayList7 = new ArrayList();
            }
            this.f203c.m87a(geoFence);
            arrayList7.add(geoFence);
        }
        if (arrayList7 == null) {
            geoFenceListener3 = this.f203c.f129c;
            if (geoFenceListener3 != null) {
                geoFenceListener4 = this.f203c.f129c;
                geoFenceListener4.onGeoFenceCreateFinished(null, 13, this.f201a);
                return;
            }
            return;
        }
        if (arrayList7.isEmpty()) {
            return;
        }
        arrayList2 = this.f203c.f130d;
        if (arrayList2 != null) {
            arrayList3 = this.f203c.f130d;
            arrayList3.addAll(arrayList7);
            geoFenceListener = this.f203c.f129c;
            if (geoFenceListener != null) {
                geoFenceListener2 = this.f203c.f129c;
                geoFenceListener2.onGeoFenceCreateFinished(arrayList7, 7, this.f201a);
            }
            this.f203c.f140n = false;
            this.f203c.m85a();
        }
    }
}