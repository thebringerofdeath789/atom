package com.baidu.geofence;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.baidu.geofence.model.DPoint;
import com.baidu.geofence.p004a.C0604b;
import com.baidu.geofence.p004a.C0608f;
import com.baidu.geofence.p004a.C0612j;
import com.baidu.location.BDAbstractLocationListener;
import com.baidu.location.BDLocation;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.location.p012h.C0733o;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import tv.danmaku.ijk.media.player.IjkMediaCodecInfo;

/* loaded from: classes.dex */
public class GeoFenceClient extends BDAbstractLocationListener implements C0612j.a {
    public static final String BD09LL = "bd09ll";
    public static final String BD09MC = "bd09mc";
    public static final String GCJ02 = "gcj02";
    public static final int GEOFENCE_IN = 1;
    public static final int GEOFENCE_IN_OUT = 4;
    public static final int GEOFENCE_IN_OUT_STAYED = 7;
    public static final int GEOFENCE_IN_STAYED = 5;
    public static final int GEOFENCE_OUT = 2;
    public static final int GEOFENCE_OUT_STAYED = 6;
    public static final int GEOFENCE_STAYED = 3;
    public static final String WGS84 = "wgs84";

    /* renamed from: y */
    private static Handler f126y;

    /* renamed from: a */
    private String f127a;

    /* renamed from: c */
    private GeoFenceListener f129c;

    /* renamed from: e */
    private LocationClient f131e;

    /* renamed from: f */
    private Intent f132f;

    /* renamed from: g */
    private PendingIntent f133g;

    /* renamed from: h */
    private Context f134h;

    /* renamed from: l */
    private LocationClientOption f138l;

    /* renamed from: o */
    private long f141o;

    /* renamed from: b */
    private int f128b = IjkMediaCodecInfo.RANK_LAST_CHANCE;

    /* renamed from: i */
    private int f135i = 1;

    /* renamed from: j */
    private int f136j = 1;

    /* renamed from: k */
    private boolean f137k = true;

    /* renamed from: m */
    private boolean f139m = false;

    /* renamed from: n */
    private boolean f140n = false;

    /* renamed from: u */
    private int f147u = Integer.MAX_VALUE;

    /* renamed from: v */
    private int f148v = Integer.MAX_VALUE;

    /* renamed from: w */
    private int f149w = Integer.MAX_VALUE;

    /* renamed from: d */
    private ArrayList<GeoFence> f130d = new ArrayList<>();

    /* renamed from: x */
    private Map<String, Integer> f150x = new HashMap();

    /* renamed from: p */
    private StringBuilder f142p = new StringBuilder();

    /* renamed from: q */
    private StringBuilder f143q = new StringBuilder();

    /* renamed from: r */
    private StringBuilder f144r = new StringBuilder();

    /* renamed from: s */
    private StringBuilder f145s = new StringBuilder();

    /* renamed from: t */
    private StringBuilder f146t = new StringBuilder();

    public GeoFenceClient(Context context) {
        this.f134h = context;
        f126y = Looper.myLooper() == null ? new Handler(Looper.getMainLooper()) : new Handler(Looper.myLooper());
        try {
            this.f131e = new LocationClient(this.f134h);
        } catch (Exception e) {
            e.printStackTrace();
        }
        LocationClientOption locationClientOption = new LocationClientOption();
        this.f138l = locationClientOption;
        locationClientOption.setScanSpan(5000);
        this.f138l.setIsNeedAddress(true);
        LocationClient locationClient = this.f131e;
        if (locationClient != null) {
            locationClient.setLocOption(this.f138l);
            this.f131e.registerLocationListener(this);
        }
        this.f141o = System.currentTimeMillis();
    }

    /* renamed from: a */
    private long m82a(long j, long j2) {
        return (j2 - j) / 1000;
    }

    /* renamed from: a */
    private BDLocation m84a(DPoint dPoint, String str) {
        String str2;
        BDLocation bDLocation = new BDLocation();
        bDLocation.setLatitude(dPoint.getLatitude());
        bDLocation.setLongitude(dPoint.getLongitude());
        if (TextUtils.equals("bd09mc", str)) {
            str2 = BDLocation.BDLOCATION_BD09_TO_GCJ02;
        } else if (TextUtils.equals("bd09ll", str)) {
            str2 = BDLocation.BDLOCATION_BD09LL_TO_GCJ02;
        } else {
            if (!TextUtils.equals("wgs84", str)) {
                if (!TextUtils.equals("gcj02", str)) {
                    return null;
                }
                BDLocation bDLocation2 = new BDLocation();
                bDLocation2.setLatitude(dPoint.getLatitude());
                bDLocation2.setLongitude(dPoint.getLongitude());
                return bDLocation2;
            }
            str2 = BDLocation.BDLOCATION_WGS84_TO_GCJ02;
        }
        return LocationClient.getBDLocationInCoorType(bDLocation, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m85a() {
        this.f137k = true;
        LocationClient locationClient = this.f131e;
        if (locationClient == null || locationClient.isStarted()) {
            return;
        }
        this.f131e.start();
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0138, code lost:
    
        if (com.baidu.location.indoor.C0762u.m1434a(r20.getLatitude(), r20.getLongitude(), r21.getCenter().getLatitude(), r21.getCenter().getLongitude()) <= r21.getRadius()) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x013a, code lost:
    
        m88a(r21, r20);
        r18.f150x.put(r21.getFenceId(), 0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x014b, code lost:
    
        m107e(r21, r20);
        r18.f150x.put(r21.getFenceId(), 1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x016f, code lost:
    
        if (com.baidu.geofence.model.C0619c.m147a(new com.baidu.geofence.model.DPoint(r20.getLatitude(), r20.getLongitude()), r21.getPoints()) != false) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x018b, code lost:
    
        if (r20.getAddrStr().contains(r21.getRegion()) != false) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x010e, code lost:
    
        if (r8 <= r21.getStayTime()) goto L7;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m86a(int r19, com.baidu.location.BDLocation r20, com.baidu.geofence.GeoFence r21) {
        /*
            Method dump skipped, instructions count: 444
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.geofence.GeoFenceClient.m86a(int, com.baidu.location.BDLocation, com.baidu.geofence.GeoFence):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m87a(GeoFence geoFence) {
        String activatesAction = geoFence.getActivatesAction();
        if (geoFence == null || TextUtils.isEmpty(activatesAction)) {
            return;
        }
        if (activatesAction.contains("1")) {
            int i = this.f147u;
            if (i < 1) {
                geoFence.setInTriggerCount(1);
            } else {
                geoFence.setInTriggerCount(i);
            }
        }
        if (activatesAction.contains(GeoFence.BUNDLE_KEY_CUSTOMID)) {
            int i2 = this.f148v;
            if (i2 < 1) {
                geoFence.setOutTriggerCount(1);
            } else {
                geoFence.setOutTriggerCount(i2);
            }
        }
        if (activatesAction.contains(GeoFence.BUNDLE_KEY_FENCESTATUS)) {
            int i3 = this.f149w;
            if (i3 < 1) {
                geoFence.setStayTriggerCount(1);
            } else {
                geoFence.setStayTriggerCount(i3);
            }
        }
    }

    /* renamed from: a */
    private void m88a(GeoFence geoFence, BDLocation bDLocation) {
        if (geoFence.getActivatesAction().contains(GeoFence.BUNDLE_KEY_FENCESTATUS) && !geoFence.isIn()) {
            geoFence.setStartTimeMillis(System.currentTimeMillis());
            geoFence.setIn(true);
        }
        if (!geoFence.isSend()) {
            m91a(24, geoFence, bDLocation.getLocType());
            if (geoFence.getActivatesAction().contains("1")) {
                m102c(geoFence, bDLocation);
            }
            geoFence.setStatus(24);
            geoFence.setSend(true);
            return;
        }
        if (this.f150x.get(geoFence.getFenceId()).intValue() != 0 && geoFence.getActivatesAction().contains("1")) {
            m102c(geoFence, bDLocation);
        }
        if (!geoFence.getActivatesAction().contains(GeoFence.BUNDLE_KEY_FENCESTATUS) || !geoFence.isIn() || geoFence.isOut() || m82a(geoFence.getStartTimeMillis(), System.currentTimeMillis()) <= geoFence.getStayTime()) {
            return;
        }
        m105d(geoFence, bDLocation);
    }

    /* renamed from: a */
    private void m90a(String str, int i) {
        SharedPreferences.Editor edit = this.f134h.getApplicationContext().getSharedPreferences("geofence", 0).edit();
        edit.putInt(str, i);
        edit.apply();
    }

    /* renamed from: a */
    private boolean m91a(int i, GeoFence geoFence, int i2) {
        Bundle bundle = new Bundle();
        bundle.putInt(GeoFence.BUNDLE_KEY_FENCESTATUS, i);
        bundle.putString(GeoFence.BUNDLE_KEY_CUSTOMID, geoFence.getCustomId());
        bundle.putParcelable(GeoFence.BUNDLE_KEY_FENCE, geoFence);
        bundle.putInt(GeoFence.BUNDLE_KEY_LOCERRORCODE, i2);
        bundle.putString("1", geoFence.getFenceId());
        this.f132f.setExtrasClassLoader(GeoFence.class.getClassLoader());
        this.f132f.putExtras(bundle);
        PendingIntent broadcast = PendingIntent.getBroadcast(this.f134h, this.f135i, this.f132f, 201326592);
        this.f133g = broadcast;
        this.f135i++;
        try {
            broadcast.send();
            return true;
        } catch (PendingIntent.CanceledException unused) {
            return false;
        }
    }

    /* renamed from: a */
    private boolean m93a(String str) {
        return "gcj02".equalsIgnoreCase(str) || "bd09ll".equalsIgnoreCase(str) || "bd09mc".equalsIgnoreCase(str) || "wgs84".equalsIgnoreCase(str);
    }

    /* renamed from: b */
    private int m94b(String str) {
        return this.f134h.getApplicationContext().getSharedPreferences("geofence", 0).getInt(str, 0);
    }

    /* renamed from: b */
    private void m96b(GeoFence geoFence) {
        if (this.f138l.getScanSpan() != 1000) {
            this.f138l.setScanSpan(1000);
            if (this.f139m && this.f138l.getLocationMode() != LocationClientOption.LocationMode.Hight_Accuracy) {
                this.f138l.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy);
            }
            LocationClient locationClient = this.f131e;
            if (locationClient != null) {
                locationClient.setLocOption(this.f138l);
            }
            geoFence.setOneSecond(true);
        }
    }

    /* renamed from: b */
    private void m97b(GeoFence geoFence, BDLocation bDLocation) {
        geoFence.setCurrentLoc(bDLocation);
        geoFence.setStatus(16);
        if (m91a(16, geoFence, bDLocation.getLocType())) {
            geoFence.setOutTriggerCount(geoFence.getOutTriggerCount() - 1);
        }
        if (geoFence.getOutTriggerCount() != 0 || TextUtils.isEmpty(geoFence.getActivatesAction())) {
            return;
        }
        geoFence.setActivatesAction(geoFence.getActivatesAction().replace(GeoFence.BUNDLE_KEY_CUSTOMID, ""));
    }

    /* renamed from: b */
    private boolean m98b() {
        ArrayList<GeoFence> arrayList = this.f130d;
        if (arrayList != null && !arrayList.isEmpty()) {
            Iterator<GeoFence> it = this.f130d.iterator();
            while (it.hasNext()) {
                if (!TextUtils.isEmpty(it.next().getActivatesAction())) {
                    return false;
                }
            }
        }
        return true;
    }

    /* renamed from: c */
    private void m100c() {
        SharedPreferences.Editor edit = this.f134h.getApplicationContext().getSharedPreferences("geofence", 0).edit();
        edit.putInt("1", 0);
        edit.putInt(GeoFence.BUNDLE_KEY_CUSTOMID, 0);
        edit.putInt(GeoFence.BUNDLE_KEY_FENCESTATUS, 0);
        edit.putInt(GeoFence.BUNDLE_KEY_LOCERRORCODE, 0);
        edit.putInt(GeoFence.BUNDLE_KEY_FENCE, 0);
        edit.apply();
    }

    /* renamed from: c */
    private void m101c(GeoFence geoFence) {
        geoFence.setIn(false);
        geoFence.setOut(false);
        geoFence.setStartTimeMillis(0L);
        geoFence.setEndTimeMillis(0L);
    }

    /* renamed from: c */
    private void m102c(GeoFence geoFence, BDLocation bDLocation) {
        geoFence.setCurrentLoc(bDLocation);
        geoFence.setStatus(15);
        if (m91a(15, geoFence, bDLocation.getLocType())) {
            geoFence.setInTriggerCount(geoFence.getInTriggerCount() - 1);
        }
        if (geoFence.getInTriggerCount() != 0 || TextUtils.isEmpty(geoFence.getActivatesAction())) {
            return;
        }
        geoFence.setActivatesAction(geoFence.getActivatesAction().replace("1", ""));
    }

    /* renamed from: d */
    private void m104d() {
        if (!(m94b("1") == 0 && m94b(GeoFence.BUNDLE_KEY_CUSTOMID) == 0 && m94b(GeoFence.BUNDLE_KEY_FENCESTATUS) == 0 && m94b(GeoFence.BUNDLE_KEY_LOCERRORCODE) == 0 && m94b(GeoFence.BUNDLE_KEY_FENCE) == 0) && m82a(this.f141o, System.currentTimeMillis()) > 60) {
            ArrayList<StringBuilder> arrayList = new ArrayList<>();
            arrayList.add(this.f142p);
            arrayList.add(this.f143q);
            arrayList.add(this.f144r);
            arrayList.add(this.f145s);
            arrayList.add(this.f146t);
            C0612j c0612j = new C0612j();
            c0612j.m139a(arrayList);
            c0612j.m138a(this);
            c0612j.m140a(new String[]{"circleFence:" + m94b("1"), "polygonFence:" + m94b(GeoFence.BUNDLE_KEY_CUSTOMID), "poiCircleFence:" + m94b(GeoFence.BUNDLE_KEY_FENCESTATUS), "poiRegionFence:" + m94b(GeoFence.BUNDLE_KEY_LOCERRORCODE), "regionFence:" + m94b(GeoFence.BUNDLE_KEY_FENCE)});
            this.f141o = System.currentTimeMillis();
        }
    }

    /* renamed from: d */
    private void m105d(GeoFence geoFence, BDLocation bDLocation) {
        geoFence.setCurrentLoc(bDLocation);
        geoFence.setStatus(17);
        if (m91a(17, geoFence, bDLocation.getLocType())) {
            geoFence.setStayTriggerCount(geoFence.getStayTriggerCount() - 1);
            m101c(geoFence);
        }
        if (geoFence.getStayTriggerCount() != 0 || TextUtils.isEmpty(geoFence.getActivatesAction())) {
            return;
        }
        geoFence.setActivatesAction(geoFence.getActivatesAction().replace(GeoFence.BUNDLE_KEY_FENCESTATUS, ""));
    }

    /* renamed from: e */
    static /* synthetic */ int m106e(GeoFenceClient geoFenceClient) {
        int i = geoFenceClient.f136j;
        geoFenceClient.f136j = i + 1;
        return i;
    }

    /* renamed from: e */
    private void m107e(GeoFence geoFence, BDLocation bDLocation) {
        if (geoFence.isIn() && !geoFence.isOut()) {
            geoFence.setEndTimeMillis(System.currentTimeMillis());
            geoFence.setOut(true);
        }
        if (!geoFence.isSend()) {
            m91a(25, geoFence, bDLocation.getLocType());
            if (geoFence.getActivatesAction().contains(GeoFence.BUNDLE_KEY_CUSTOMID)) {
                m97b(geoFence, bDLocation);
            }
            geoFence.setStatus(25);
            geoFence.setSend(true);
            return;
        }
        if (this.f150x.get(geoFence.getFenceId()).intValue() != 1 && geoFence.getActivatesAction().contains(GeoFence.BUNDLE_KEY_CUSTOMID)) {
            m97b(geoFence, bDLocation);
        }
        if (geoFence.getActivatesAction().contains(GeoFence.BUNDLE_KEY_FENCESTATUS) && geoFence.isIn() && m82a(geoFence.getStartTimeMillis(), geoFence.getEndTimeMillis()) > geoFence.getStayTime()) {
            m105d(geoFence, bDLocation);
        }
    }

    public static Handler getHandlerInstance() {
        if (f126y == null) {
            f126y = Looper.myLooper() == null ? new Handler(Looper.getMainLooper()) : new Handler(Looper.myLooper());
        }
        return f126y;
    }

    public void addGeoFence(DPoint dPoint, String str, float f, String str2) {
        if (dPoint == null) {
            return;
        }
        this.f142p.append("[").append(dPoint.getLatitude()).append(",").append(dPoint.getLongitude()).append(",").append(str).append(",").append(f).append(",").append(str2).append("]");
        m90a("1", m94b("1") + 1);
        if (TextUtils.isEmpty(str) || !m93a(str) || f <= 0.0f || TextUtils.isEmpty(str2)) {
            GeoFenceListener geoFenceListener = this.f129c;
            if (geoFenceListener != null) {
                geoFenceListener.onGeoFenceCreateFinished(null, 8, str2);
                return;
            }
            return;
        }
        BDLocation m84a = m84a(dPoint, str);
        if (Math.abs(m84a.getLatitude()) > 90.0d || Math.abs(m84a.getLongitude()) > 180.0d) {
            GeoFenceListener geoFenceListener2 = this.f129c;
            if (geoFenceListener2 != null) {
                geoFenceListener2.onGeoFenceCreateFinished(null, 8, str2);
                return;
            }
            return;
        }
        DPoint dPoint2 = new DPoint(m84a.getLatitude(), m84a.getLongitude());
        Iterator<GeoFence> it = this.f130d.iterator();
        while (it.hasNext()) {
            GeoFence next = it.next();
            if (next.getType() == 20 && next.getCenter().getLatitude() == dPoint2.getLatitude() && next.getCenter().getLongitude() == dPoint2.getLongitude() && next.getRadius() == f) {
                this.f129c.onGeoFenceCreateFinished(this.f130d, 14, str2);
                return;
            }
        }
        GeoFence geoFence = new GeoFence();
        geoFence.setFenceType(20);
        geoFence.setActivatesAction(this.f127a);
        if (!TextUtils.isEmpty(this.f127a) && this.f127a.contains(GeoFence.BUNDLE_KEY_FENCESTATUS)) {
            geoFence.setStayTime(this.f128b);
        }
        geoFence.setCustomId(str2);
        int i = this.f136j;
        this.f136j = i + 1;
        geoFence.setFenceId(String.valueOf(i));
        geoFence.setCenter(dPoint2);
        geoFence.setRadius(f);
        m87a(geoFence);
        this.f130d.add(geoFence);
        this.f150x.put(geoFence.getFenceId(), 2);
        ArrayList arrayList = new ArrayList();
        arrayList.add(geoFence);
        GeoFenceListener geoFenceListener3 = this.f129c;
        if (geoFenceListener3 != null) {
            geoFenceListener3.onGeoFenceCreateFinished(arrayList, 7, str2);
        }
        this.f140n = false;
        m85a();
    }

    public void addGeoFence(String str, String str2) {
        this.f146t.append("[").append(str).append(",").append(str2).append("]");
        m90a(GeoFence.BUNDLE_KEY_FENCE, m94b(GeoFence.BUNDLE_KEY_FENCE) + 1);
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            GeoFenceListener geoFenceListener = this.f129c;
            if (geoFenceListener != null) {
                geoFenceListener.onGeoFenceCreateFinished(null, 8, str2);
                return;
            }
            return;
        }
        Iterator<GeoFence> it = this.f130d.iterator();
        while (it.hasNext()) {
            GeoFence next = it.next();
            if (next.getType() == 23 && TextUtils.equals(next.getRegion(), str)) {
                GeoFenceListener geoFenceListener2 = this.f129c;
                if (geoFenceListener2 != null) {
                    geoFenceListener2.onGeoFenceCreateFinished(null, 14, str2);
                    return;
                }
                return;
            }
        }
        C0604b c0604b = new C0604b(str, this.f134h);
        c0604b.m120a(this.f129c);
        c0604b.m121a(new C0615d(this, str2, str));
    }

    public void addGeoFence(String str, String str2, DPoint dPoint, String str3, float f, int i, String str4) {
        if (dPoint == null) {
            return;
        }
        this.f144r.append("[").append(str).append(",").append(str2).append(",").append("(").append(dPoint.getLatitude()).append(",").append(dPoint.getLongitude()).append(")").append(",").append(str3).append(",").append(f).append(",").append(i).append(",").append(str4).append("]");
        m90a(GeoFence.BUNDLE_KEY_FENCESTATUS, m94b(GeoFence.BUNDLE_KEY_FENCESTATUS) + 1);
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || f < 1.0f || f > 5000.0f || i <= 0 || i > 25 || TextUtils.isEmpty(str4) || !m93a(str3)) {
            GeoFenceListener geoFenceListener = this.f129c;
            if (geoFenceListener != null) {
                geoFenceListener.onGeoFenceCreateFinished(null, 8, str4);
                return;
            }
            return;
        }
        BDLocation m84a = m84a(dPoint, str3);
        if (Math.abs(m84a.getLatitude()) > 90.0d || Math.abs(m84a.getLongitude()) > 180.0d) {
            GeoFenceListener geoFenceListener2 = this.f129c;
            if (geoFenceListener2 != null) {
                geoFenceListener2.onGeoFenceCreateFinished(null, 8, str4);
                return;
            }
            return;
        }
        if (!C0733o.m1146a(this.f134h)) {
            GeoFenceListener geoFenceListener3 = this.f129c;
            if (geoFenceListener3 != null) {
                geoFenceListener3.onGeoFenceCreateFinished(null, 9, str4);
                return;
            }
            return;
        }
        DPoint dPoint2 = new DPoint(m84a.getLatitude(), m84a.getLongitude());
        C0608f c0608f = new C0608f(this.f134h, true, this.f129c, this.f130d);
        c0608f.m130a(i);
        c0608f.m134b(str);
        c0608f.m135c(str2);
        c0608f.m132a(dPoint2);
        c0608f.m129a(f);
        c0608f.m133a(str4);
        c0608f.m131a(new C0613b(this, str4, str));
    }

    public void addGeoFence(String str, String str2, String str3, int i, String str4) {
        this.f145s.append("[").append(str).append(",").append(str2).append(",").append(str3).append(",").append(i).append(",").append(str4).append("]");
        m90a(GeoFence.BUNDLE_KEY_LOCERRORCODE, m94b(GeoFence.BUNDLE_KEY_LOCERRORCODE) + 1);
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || i == 0 || TextUtils.isEmpty(str4)) {
            GeoFenceListener geoFenceListener = this.f129c;
            if (geoFenceListener != null) {
                geoFenceListener.onGeoFenceCreateFinished(null, 8, str4);
                return;
            }
            return;
        }
        if (!C0733o.m1146a(this.f134h)) {
            GeoFenceListener geoFenceListener2 = this.f129c;
            if (geoFenceListener2 != null) {
                geoFenceListener2.onGeoFenceCreateFinished(null, 9, str4);
                return;
            }
            return;
        }
        C0608f c0608f = new C0608f(this.f134h, false, this.f129c, this.f130d);
        c0608f.m134b(str);
        c0608f.m136d(str3);
        c0608f.m135c(str2);
        c0608f.m130a(i);
        c0608f.m133a(str4);
        c0608f.m131a(new C0614c(this, str4, str));
    }

    public void addGeoFence(ArrayList<DPoint> arrayList, String str, String str2) {
        this.f143q.append("[").append(str).append(",").append(str2);
        if (arrayList != null && !arrayList.isEmpty()) {
            Iterator<DPoint> it = arrayList.iterator();
            while (it.hasNext()) {
                DPoint next = it.next();
                this.f143q.append(",").append("(").append(next.getLatitude()).append(",").append(next.getLongitude()).append(")");
            }
        }
        this.f143q.append("]");
        m90a(GeoFence.BUNDLE_KEY_CUSTOMID, m94b(GeoFence.BUNDLE_KEY_CUSTOMID) + 1);
        if (arrayList == null || arrayList.size() < 3 || TextUtils.isEmpty(str) || !m93a(str) || TextUtils.isEmpty(str2)) {
            GeoFenceListener geoFenceListener = this.f129c;
            if (geoFenceListener != null) {
                geoFenceListener.onGeoFenceCreateFinished(null, 8, str2);
                return;
            }
            return;
        }
        ArrayList<DPoint> arrayList2 = new ArrayList<>();
        Iterator<DPoint> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            BDLocation m84a = m84a(it2.next(), str);
            if (Math.abs(m84a.getLatitude()) > 90.0d || Math.abs(m84a.getLongitude()) > 180.0d) {
                GeoFenceListener geoFenceListener2 = this.f129c;
                if (geoFenceListener2 != null) {
                    geoFenceListener2.onGeoFenceCreateFinished(null, 8, str2);
                    return;
                }
                return;
            }
            arrayList2.add(new DPoint(m84a.getLatitude(), m84a.getLongitude()));
        }
        Iterator<GeoFence> it3 = this.f130d.iterator();
        while (true) {
            if (!it3.hasNext()) {
                GeoFence geoFence = new GeoFence();
                geoFence.setPoints(arrayList2);
                geoFence.setFenceType(21);
                geoFence.setActivatesAction(this.f127a);
                if (!TextUtils.isEmpty(this.f127a) && this.f127a.contains(GeoFence.BUNDLE_KEY_FENCESTATUS)) {
                    geoFence.setStayTime(this.f128b);
                }
                geoFence.setCustomId(str2);
                int i = this.f136j;
                this.f136j = i + 1;
                geoFence.setFenceId(String.valueOf(i));
                m87a(geoFence);
                this.f130d.add(geoFence);
                this.f150x.put(geoFence.getFenceId(), 2);
                ArrayList arrayList3 = new ArrayList();
                arrayList3.add(geoFence);
                GeoFenceListener geoFenceListener3 = this.f129c;
                if (geoFenceListener3 != null) {
                    geoFenceListener3.onGeoFenceCreateFinished(arrayList3, 7, str2);
                }
                this.f140n = false;
                m85a();
                return;
            }
            GeoFence next2 = it3.next();
            if (next2.getType() == 21 && next2.getPoints().size() == arrayList2.size()) {
                int i2 = 0;
                for (int i3 = 0; i3 < arrayList2.size() && arrayList2.get(i3).getLatitude() == next2.getPoints().get(i3).getLatitude() && arrayList2.get(i3).getLongitude() == next2.getPoints().get(i3).getLongitude(); i3++) {
                    i2++;
                }
                if (i2 == arrayList2.size()) {
                    GeoFenceListener geoFenceListener4 = this.f129c;
                    if (geoFenceListener4 != null) {
                        geoFenceListener4.onGeoFenceCreateFinished(null, 14, str2);
                        return;
                    }
                    return;
                }
            }
        }
    }

    @Override // com.baidu.geofence.p004a.C0612j.a
    public void clear() {
        m100c();
    }

    public void createPendingIntent(String str) {
        this.f132f = new Intent(str);
    }

    public List<GeoFence> getAllGeoFence() {
        return this.f130d;
    }

    public void isHighAccuracyLoc(boolean z) {
        this.f139m = z;
    }

    public boolean isPause() {
        LocationClient locationClient = this.f131e;
        return (locationClient == null || this.f137k || locationClient.isStarted()) ? false : true;
    }

    /* JADX WARN: Removed duplicated region for block: B:97:0x0135  */
    @Override // com.baidu.location.BDAbstractLocationListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onReceiveLocation(com.baidu.location.BDLocation r9) {
        /*
            Method dump skipped, instructions count: 318
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.geofence.GeoFenceClient.onReceiveLocation(com.baidu.location.BDLocation):void");
    }

    public void pauseGeoFence() {
        this.f140n = true;
        this.f137k = false;
        LocationClient locationClient = this.f131e;
        if (locationClient == null || !locationClient.isStarted()) {
            return;
        }
        this.f131e.stop();
    }

    public void removeGeoFence() {
        ArrayList<GeoFence> arrayList = this.f130d;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        this.f130d.clear();
        this.f137k = false;
        this.f136j = 1;
        this.f150x.clear();
        LocationClient locationClient = this.f131e;
        if (locationClient == null || !locationClient.isStarted()) {
            return;
        }
        this.f131e.stop();
    }

    public boolean removeGeoFence(GeoFence geoFence) {
        ArrayList<GeoFence> arrayList;
        if (geoFence != null && (arrayList = this.f130d) != null && !arrayList.isEmpty()) {
            Iterator<GeoFence> it = this.f130d.iterator();
            while (it.hasNext()) {
                if (TextUtils.equals(it.next().getFenceId(), geoFence.getFenceId())) {
                    this.f130d.remove(geoFence);
                    return true;
                }
            }
        }
        return false;
    }

    public void resumeGeoFence() {
        ArrayList<GeoFence> arrayList = this.f130d;
        if (arrayList == null || arrayList.size() == 0 || m98b() || !isPause()) {
            return;
        }
        this.f137k = true;
        this.f140n = false;
        m85a();
    }

    public void setActivateAction(int i) {
        String str;
        if (i == 1) {
            str = "1";
        } else if (i == 2) {
            str = GeoFence.BUNDLE_KEY_CUSTOMID;
        } else if (i == 3) {
            str = GeoFence.BUNDLE_KEY_FENCESTATUS;
        } else if (i == 4) {
            str = "12";
        } else if (i == 5) {
            str = "13";
        } else {
            if (i != 6) {
                if (i == 7) {
                    str = "123";
                }
                TextUtils.isEmpty(this.f127a);
            }
            str = "23";
        }
        this.f127a = str;
        TextUtils.isEmpty(this.f127a);
    }

    public void setGeoFenceAble(String str, boolean z) {
        ArrayList<GeoFence> arrayList;
        if (TextUtils.isEmpty(str) || (arrayList = this.f130d) == null || arrayList.size() == 0) {
            return;
        }
        Iterator<GeoFence> it = this.f130d.iterator();
        while (it.hasNext()) {
            GeoFence next = it.next();
            if (TextUtils.equals(next.getFenceId(), str)) {
                next.setAble(z);
            }
        }
    }

    public void setGeoFenceListener(GeoFenceListener geoFenceListener) {
        this.f129c = geoFenceListener;
    }

    public void setStayTime(int i) {
        this.f128b = i;
    }

    public void setTriggerCount(int i, int i2, int i3) {
        if (TextUtils.isEmpty(this.f127a)) {
            return;
        }
        if (this.f127a.contains("1")) {
            if (i < 1) {
                this.f147u = 1;
            } else {
                this.f147u = i;
            }
        }
        if (this.f127a.contains(GeoFence.BUNDLE_KEY_CUSTOMID)) {
            if (i2 < 1) {
                this.f148v = 1;
            } else {
                this.f148v = i2;
            }
        }
        if (this.f127a.contains(GeoFence.BUNDLE_KEY_FENCESTATUS)) {
            if (i3 < 1) {
                this.f149w = 1;
            } else {
                this.f149w = i3;
            }
        }
    }
}