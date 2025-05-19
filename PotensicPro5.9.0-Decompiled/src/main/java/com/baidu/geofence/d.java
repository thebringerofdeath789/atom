package com.baidu.geofence;

import android.text.TextUtils;
import com.baidu.geofence.a.b;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.util.ArrayList;
import java.util.Map;

/* loaded from: classes.dex */
class d implements b.a {
    final /* synthetic */ String a;
    final /* synthetic */ String b;
    final /* synthetic */ GeoFenceClient c;

    d(GeoFenceClient geoFenceClient, String str, String str2) {
        this.c = geoFenceClient;
        this.a = str;
        this.b = str2;
    }

    @Override // com.baidu.geofence.a.b.a
    public void a(int i) {
        String str;
        String str2;
        ArrayList arrayList;
        Map map;
        GeoFenceListener geoFenceListener;
        LocationClientOption locationClientOption;
        LocationClient locationClient;
        LocationClientOption locationClientOption2;
        LocationClient locationClient2;
        LocationClientOption locationClientOption3;
        GeoFenceListener geoFenceListener2;
        String str3;
        int i2;
        GeoFenceListener geoFenceListener3;
        GeoFenceListener geoFenceListener4;
        if (i != 0) {
            geoFenceListener3 = this.c.c;
            if (geoFenceListener3 != null) {
                geoFenceListener4 = this.c.c;
                geoFenceListener4.onGeoFenceCreateFinished(null, 13, this.a);
                return;
            }
            return;
        }
        GeoFence geoFence = new GeoFence();
        geoFence.setFenceType(23);
        geoFence.setRegion(this.b);
        geoFence.setKeyWord(this.b);
        geoFence.setCustomId(this.a);
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
        geoFence.setFenceId(String.valueOf(GeoFenceClient.e(this.c)));
        this.c.a(geoFence);
        arrayList = this.c.d;
        arrayList.add(geoFence);
        map = this.c.x;
        map.put(geoFence.getFenceId(), 2);
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(geoFence);
        geoFenceListener = this.c.c;
        if (geoFenceListener != null) {
            geoFenceListener2 = this.c.c;
            geoFenceListener2.onGeoFenceCreateFinished(arrayList2, 7, this.a);
        }
        locationClientOption = this.c.l;
        if (!TextUtils.equals(locationClientOption.getAddrType(), TtmlNode.COMBINE_ALL)) {
            locationClient = this.c.e;
            if (locationClient != null) {
                locationClientOption2 = this.c.l;
                locationClientOption2.setIsNeedAddress(true);
                locationClient2 = this.c.e;
                locationClientOption3 = this.c.l;
                locationClient2.setLocOption(locationClientOption3);
            }
        }
        this.c.n = false;
        this.c.a();
    }
}
