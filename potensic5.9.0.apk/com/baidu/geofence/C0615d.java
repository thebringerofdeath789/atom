package com.baidu.geofence;

import android.text.TextUtils;
import com.baidu.geofence.p004a.C0604b;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.util.ArrayList;
import java.util.Map;

/* renamed from: com.baidu.geofence.d */
/* loaded from: classes.dex */
class C0615d implements C0604b.a {

    /* renamed from: a */
    final /* synthetic */ String f204a;

    /* renamed from: b */
    final /* synthetic */ String f205b;

    /* renamed from: c */
    final /* synthetic */ GeoFenceClient f206c;

    C0615d(GeoFenceClient geoFenceClient, String str, String str2) {
        this.f206c = geoFenceClient;
        this.f204a = str;
        this.f205b = str2;
    }

    @Override // com.baidu.geofence.p004a.C0604b.a
    /* renamed from: a */
    public void mo124a(int i) {
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
            geoFenceListener3 = this.f206c.f129c;
            if (geoFenceListener3 != null) {
                geoFenceListener4 = this.f206c.f129c;
                geoFenceListener4.onGeoFenceCreateFinished(null, 13, this.f204a);
                return;
            }
            return;
        }
        GeoFence geoFence = new GeoFence();
        geoFence.setFenceType(23);
        geoFence.setRegion(this.f205b);
        geoFence.setKeyWord(this.f205b);
        geoFence.setCustomId(this.f204a);
        str = this.f206c.f127a;
        geoFence.setActivatesAction(str);
        str2 = this.f206c.f127a;
        if (!TextUtils.isEmpty(str2)) {
            str3 = this.f206c.f127a;
            if (str3.contains(GeoFence.BUNDLE_KEY_FENCESTATUS)) {
                i2 = this.f206c.f128b;
                geoFence.setStayTime(i2);
            }
        }
        geoFence.setFenceId(String.valueOf(GeoFenceClient.m106e(this.f206c)));
        this.f206c.m87a(geoFence);
        arrayList = this.f206c.f130d;
        arrayList.add(geoFence);
        map = this.f206c.f150x;
        map.put(geoFence.getFenceId(), 2);
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(geoFence);
        geoFenceListener = this.f206c.f129c;
        if (geoFenceListener != null) {
            geoFenceListener2 = this.f206c.f129c;
            geoFenceListener2.onGeoFenceCreateFinished(arrayList2, 7, this.f204a);
        }
        locationClientOption = this.f206c.f138l;
        if (!TextUtils.equals(locationClientOption.getAddrType(), TtmlNode.COMBINE_ALL)) {
            locationClient = this.f206c.f131e;
            if (locationClient != null) {
                locationClientOption2 = this.f206c.f138l;
                locationClientOption2.setIsNeedAddress(true);
                locationClient2 = this.f206c.f131e;
                locationClientOption3 = this.f206c.f138l;
                locationClient2.setLocOption(locationClientOption3);
            }
        }
        this.f206c.f140n = false;
        this.f206c.m85a();
    }
}