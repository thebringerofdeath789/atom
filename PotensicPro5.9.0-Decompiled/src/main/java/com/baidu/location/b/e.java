package com.baidu.location.b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.telephony.CellInfo;
import android.telephony.CellLocation;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import android.text.TextUtils;
import com.baidu.lbsapi.auth.LBSAuthManager;
import com.baidu.location.BDLocation;
import com.baidu.location.Jni;
import com.baidu.location.LocationClientOption;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.hjq.permissions.Permission;
import com.ipotensic.baselib.netty.Constant;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Timer;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class e {
    private static char[] q = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_.".toCharArray();
    String a;
    String b;
    private Context d;
    private TelephonyManager e;
    private WifiManager g;
    private String i;
    private String j;
    private LocationClientOption k;
    private b l;
    private String n;
    private String o;
    private boolean p;
    private f t;
    private boolean v;
    private com.baidu.location.f.a f = new com.baidu.location.f.a();
    private C0006e h = null;
    private String m = null;
    c c = new c();
    private boolean r = false;
    private final Object s = new Object();
    private boolean u = true;
    private long w = 0;
    private boolean x = false;

    private class a extends TelephonyManager.CellInfoCallback {
        private a() {
        }

        /* synthetic */ a(e eVar, com.baidu.location.b.f fVar) {
            this();
        }

        @Override // android.telephony.TelephonyManager.CellInfoCallback
        public void onCellInfo(List<CellInfo> list) {
            if (list == null) {
                return;
            }
            e.this.u = !r2.u;
            if (e.this.u || e.this.k.priority == 4) {
                synchronized (e.this.s) {
                    e.this.s.notifyAll();
                }
            }
        }
    }

    public interface b {
        void onReceiveLocation(BDLocation bDLocation);
    }

    class c extends com.baidu.location.h.g {
        LocationManager b;
        a c;
        String a = null;
        boolean d = false;

        private class a implements LocationListener {
            private a() {
            }

            /* synthetic */ a(c cVar, com.baidu.location.b.f fVar) {
                this();
            }

            @Override // android.location.LocationListener
            public void onLocationChanged(Location location) {
                c.this.c();
                c.this.d = true;
            }

            @Override // android.location.LocationListener
            public void onProviderDisabled(String str) {
            }

            @Override // android.location.LocationListener
            public void onProviderEnabled(String str) {
            }

            @Override // android.location.LocationListener
            public void onStatusChanged(String str, int i, Bundle bundle) {
            }
        }

        c() {
            this.k = new HashMap();
        }

        private void a() {
            try {
                this.b = (LocationManager) e.this.d.getSystemService("location");
                a aVar = new a(this, null);
                this.c = aVar;
                LocationManager locationManager = this.b;
                if (locationManager == null || aVar == null) {
                    return;
                }
                try {
                    locationManager.requestLocationUpdates("network", 1000L, 0.0f, aVar, Looper.getMainLooper());
                } catch (SecurityException e) {
                    e.printStackTrace();
                }
            } catch (Throwable unused) {
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c() {
            LocationManager locationManager;
            a aVar = this.c;
            if (aVar == null || (locationManager = this.b) == null) {
                return;
            }
            try {
                locationManager.removeUpdates(aVar);
            } catch (Exception unused) {
            }
        }

        public void a(String str) {
            this.a = str;
            e(com.baidu.location.h.d.c);
            if (e.this.r) {
                a();
                Timer timer = new Timer();
                timer.schedule(new g(this, timer), Constant.DELAY_MILLIS);
                SharedPreferences.Editor edit = e.this.d.getSharedPreferences("cuidRelate", 0).edit();
                edit.putLong("reqtime", System.currentTimeMillis());
                edit.apply();
            }
        }

        @Override // com.baidu.location.h.g
        public void a(boolean z) {
            BDLocation bDLocation;
            if (!z || this.j == null) {
                e.this.b(63);
            } else {
                try {
                    String str = this.j;
                    if (str.contains("\"enc\"")) {
                        try {
                            JSONObject jSONObject = new JSONObject(str);
                            if (jSONObject.has("enc")) {
                                str = n.a().b(jSONObject.getString("enc"));
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    try {
                        bDLocation = new BDLocation(str);
                        e.this.a(str);
                    } catch (Exception unused) {
                        bDLocation = new BDLocation();
                        bDLocation.setLocType(63);
                    }
                    if (bDLocation.getLocType() == 161) {
                        bDLocation.setCoorType(e.this.k.coorType);
                        bDLocation.setLocationID(Jni.en1(e.this.a + ";" + e.this.b + ";" + bDLocation.getTime()));
                        bDLocation.setRoadLocString(0.0f, 0.0f, null, null);
                        e.this.x = true;
                        e.this.l.onReceiveLocation(bDLocation);
                    } else {
                        e.this.b(bDLocation.getLocType());
                    }
                } catch (Exception e2) {
                    e.this.b(63);
                    e2.printStackTrace();
                }
            }
            if (this.k != null) {
                this.k.clear();
            }
        }

        @Override // com.baidu.location.h.g
        public void b() {
            if (e.this.n != null && e.this.o != null) {
                this.a += String.format(Locale.CHINA, "&ki=%s&sn=%s", e.this.n, e.this.o);
            }
            String str = this.a + "&enc=2";
            this.a = str;
            String encodeTp4 = Jni.encodeTp4(str);
            this.a = null;
            this.k.put("bloc", encodeTp4);
            this.k.put("trtm", String.format(Locale.CHINA, "%d", Long.valueOf(System.currentTimeMillis())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    class d {
        public String a;
        public int b;

        d(String str, int i) {
            this.a = str;
            this.b = i;
        }
    }

    /* renamed from: com.baidu.location.b.e$e, reason: collision with other inner class name */
    public static class C0006e {
        public List<ScanResult> a;
        private long c;
        public String b = null;
        private String d = null;
        private int e = 16;

        public C0006e(List<ScanResult> list) {
            this.a = null;
            this.c = 0L;
            this.a = list;
            this.c = System.currentTimeMillis();
            try {
                b();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        /*  JADX ERROR: JadxOverflowException in pass: LoopRegionVisitor
            jadx.core.utils.exceptions.JadxOverflowException: LoopRegionVisitor.assignOnlyInLoop endless recursion
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        private void b() {
            /*
                r7 = this;
                int r0 = r7.a()
                r1 = 1
                if (r0 >= r1) goto L8
                return
            L8:
                java.util.List<android.net.wifi.ScanResult> r0 = r7.a
                int r0 = r0.size()
                int r0 = r0 - r1
                r2 = r1
            L10:
                if (r0 < r1) goto L5e
                if (r2 == 0) goto L5e
                r2 = 0
                r3 = r2
            L16:
                if (r2 >= r0) goto L5a
                java.util.List<android.net.wifi.ScanResult> r4 = r7.a
                java.lang.Object r4 = r4.get(r2)
                if (r4 == 0) goto L57
                java.util.List<android.net.wifi.ScanResult> r4 = r7.a
                int r5 = r2 + 1
                java.lang.Object r4 = r4.get(r5)
                if (r4 == 0) goto L57
                java.util.List<android.net.wifi.ScanResult> r4 = r7.a
                java.lang.Object r4 = r4.get(r2)
                android.net.wifi.ScanResult r4 = (android.net.wifi.ScanResult) r4
                int r4 = r4.level
                java.util.List<android.net.wifi.ScanResult> r6 = r7.a
                java.lang.Object r6 = r6.get(r5)
                android.net.wifi.ScanResult r6 = (android.net.wifi.ScanResult) r6
                int r6 = r6.level
                if (r4 >= r6) goto L57
                java.util.List<android.net.wifi.ScanResult> r3 = r7.a
                java.lang.Object r3 = r3.get(r5)
                android.net.wifi.ScanResult r3 = (android.net.wifi.ScanResult) r3
                java.util.List<android.net.wifi.ScanResult> r4 = r7.a
                java.lang.Object r6 = r4.get(r2)
                r4.set(r5, r6)
                java.util.List<android.net.wifi.ScanResult> r4 = r7.a
                r4.set(r2, r3)
                r3 = r1
            L57:
                int r2 = r2 + 1
                goto L16
            L5a:
                int r0 = r0 + (-1)
                r2 = r3
                goto L10
            L5e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.b.e.C0006e.b():void");
        }

        public int a() {
            List<ScanResult> list = this.a;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x0053  */
        /* JADX WARN: Removed duplicated region for block: B:36:0x00f3  */
        /* JADX WARN: Removed duplicated region for block: B:38:0x00f8  */
        /* JADX WARN: Removed duplicated region for block: B:92:0x00eb A[SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public java.lang.String a(int r26, java.lang.String r27, boolean r28, int r29) {
            /*
                Method dump skipped, instructions count: 475
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.b.e.C0006e.a(int, java.lang.String, boolean, int):java.lang.String");
        }
    }

    private class f extends BroadcastReceiver {
        private f() {
        }

        /* synthetic */ f(e eVar, com.baidu.location.b.f fVar) {
            this();
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (context == null || intent == null) {
                return;
            }
            String action = intent.getAction();
            e.this.u = !r3.u;
            if (!(action.equals("android.net.wifi.SCAN_RESULTS") && e.this.u) && Build.VERSION.SDK_INT >= 29 && e.this.v) {
                return;
            }
            synchronized (e.this.s) {
                e.this.s.notifyAll();
            }
        }
    }

    public e(Context context, LocationClientOption locationClientOption, b bVar, String str) {
        StringBuilder append;
        String str2 = null;
        byte b2 = 0;
        this.d = null;
        this.e = null;
        this.g = null;
        this.i = null;
        this.j = null;
        this.n = null;
        this.o = null;
        this.a = null;
        this.b = null;
        this.p = false;
        this.t = null;
        this.v = false;
        Context applicationContext = context.getApplicationContext();
        this.d = applicationContext;
        try {
            com.baidu.location.h.o.aw = applicationContext.getPackageName();
        } catch (Exception unused) {
        }
        this.p = true;
        this.k = new LocationClientOption(locationClientOption);
        this.l = bVar;
        this.a = this.d.getPackageName();
        this.b = null;
        try {
            this.e = (TelephonyManager) this.d.getSystemService("phone");
            this.g = (WifiManager) this.d.getApplicationContext().getSystemService("wifi");
        } catch (Exception unused2) {
        }
        if (this.k.firstLocType == LocationClientOption.FirstLocType.ACCURACY_IN_FIRST_LOC) {
            if (this.k.priority != 4) {
                f fVar = new f(this, b2 == true ? 1 : 0);
                this.t = fVar;
                try {
                    this.d.registerReceiver(fVar, new IntentFilter("android.net.wifi.SCAN_RESULTS"));
                } catch (Exception unused3) {
                }
            }
            if (Build.VERSION.SDK_INT >= 30) {
                this.v = com.baidu.location.h.o.b("android.telephony.TelephonyManager$CellInfoCallback");
            }
        }
        this.j = "&" + this.a + "&" + ((String) null);
        try {
            this.b = LBSAuthManager.getInstance(this.d).getCUID();
        } catch (Throwable unused4) {
            this.b = null;
            this.e = null;
            this.g = null;
        }
        if (this.b != null) {
            com.baidu.location.h.o.n = "" + this.b;
            append = new StringBuilder().append("&prod=").append(this.k.prodName).append(":").append(this.a).append("|&cu=");
            str2 = this.b;
        } else {
            append = new StringBuilder().append("&prod=").append(this.k.prodName).append(":").append(this.a).append("|&im=");
        }
        this.i = append.append(str2).append("&coor=").append(locationClientOption.getCoorType()).toString();
        StringBuffer stringBuffer = new StringBuffer(256);
        stringBuffer.append("&fw=");
        stringBuffer.append("9.401");
        stringBuffer.append("&sdk=");
        stringBuffer.append("9.401");
        stringBuffer.append("&lt=1");
        stringBuffer.append("&mb=");
        stringBuffer.append(Build.MODEL);
        stringBuffer.append("&resid=");
        stringBuffer.append("12");
        locationClientOption.getAddrType();
        if (locationClientOption.getAddrType() != null && locationClientOption.getAddrType().equals(TtmlNode.COMBINE_ALL)) {
            this.i += "&addr=allj2";
            if (locationClientOption.isNeedNewVersionRgc) {
                stringBuffer.append("&adtp=n2");
            }
        }
        if (locationClientOption.isNeedAptag || locationClientOption.isNeedAptagd) {
            this.i += "&sema=";
            if (locationClientOption.isNeedAptag) {
                this.i += "aptag|";
            }
            if (locationClientOption.isNeedAptagd) {
                this.i += "aptagd2|";
            }
            this.n = com.baidu.location.a.a.b(this.d);
            this.o = com.baidu.location.a.a.c(this.d);
        }
        stringBuffer.append("&first=1");
        stringBuffer.append("&os=A");
        stringBuffer.append(Build.VERSION.SDK);
        this.i += stringBuffer.toString();
    }

    public static com.baidu.location.f.a a(CellLocation cellLocation, TelephonyManager telephonyManager, com.baidu.location.f.a aVar) {
        if (cellLocation == null || telephonyManager == null) {
            return null;
        }
        com.baidu.location.f.a aVar2 = new com.baidu.location.f.a();
        aVar2.l = 1;
        String networkOperator = telephonyManager.getNetworkOperator();
        if (networkOperator != null && networkOperator.length() > 0) {
            try {
                if (networkOperator.length() >= 3) {
                    int intValue = Integer.valueOf(networkOperator.substring(0, 3)).intValue();
                    if (intValue < 0) {
                        intValue = aVar.c;
                    }
                    aVar2.c = intValue;
                }
                String substring = networkOperator.substring(3);
                if (substring != null) {
                    char[] charArray = substring.toCharArray();
                    int i = 0;
                    while (i < charArray.length && Character.isDigit(charArray[i])) {
                        i++;
                    }
                    int intValue2 = Integer.valueOf(substring.substring(0, i)).intValue();
                    if (intValue2 < 0) {
                        intValue2 = aVar.d;
                    }
                    aVar2.d = intValue2;
                }
            } catch (Exception unused) {
            }
        }
        if (cellLocation instanceof GsmCellLocation) {
            aVar2.a = ((GsmCellLocation) cellLocation).getLac();
            aVar2.b = r6.getCid();
            aVar2.i = 'g';
        } else if (cellLocation instanceof CdmaCellLocation) {
            aVar2.i = 'c';
            try {
                Class<?> cls = Class.forName("android.telephony.cdma.CdmaCellLocation");
                if (cls != null && cls.isInstance(cellLocation)) {
                    try {
                        int systemId = ((CdmaCellLocation) cellLocation).getSystemId();
                        if (systemId < 0) {
                            systemId = -1;
                        }
                        aVar2.d = systemId;
                        aVar2.b = ((CdmaCellLocation) cellLocation).getBaseStationId();
                        aVar2.a = ((CdmaCellLocation) cellLocation).getNetworkId();
                        int baseStationLatitude = ((CdmaCellLocation) cellLocation).getBaseStationLatitude();
                        if (baseStationLatitude < Integer.MAX_VALUE) {
                            aVar2.e = baseStationLatitude;
                        }
                        int baseStationLongitude = ((CdmaCellLocation) cellLocation).getBaseStationLongitude();
                        if (baseStationLongitude < Integer.MAX_VALUE) {
                            aVar2.f = baseStationLongitude;
                        }
                    } catch (Exception unused2) {
                    }
                }
            } catch (Exception unused3) {
                return null;
            }
        }
        if (aVar2.b()) {
            return aVar2;
        }
        return null;
    }

    private Object a(Object obj, String str) throws Exception {
        return obj.getClass().getField(str).get(obj);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(19:0|1|(2:2|3)|(15:5|(1:7)|8|9|(1:58)(1:13)|15|16|(1:22)|24|25|(5:29|30|31|(1:35)|(2:(1:(1:44)(1:45))|(1:47)(4:48|(1:50)|51|52))(2:39|40))|55|(0)|(0)|(0)(0))|59|(2:61|8)|9|(1:11)|58|15|16|(3:18|20|22)|24|25|(8:27|29|30|31|(2:33|35)|(0)|(0)|(0)(0))|55|(0)|(0)|(0)(0)) */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00a5 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00c3 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00c4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String a(int r7) {
        /*
            Method dump skipped, instructions count: 248
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.b.e.a(int):java.lang.String");
    }

    private String a(List<WifiConfiguration> list) {
        ArrayList<d> arrayList;
        int i;
        int i2 = 0;
        if (list == null || list.size() <= 0) {
            arrayList = null;
        } else {
            arrayList = new ArrayList();
            for (WifiConfiguration wifiConfiguration : list) {
                String str = wifiConfiguration.SSID;
                try {
                    i = ((Integer) a(wifiConfiguration, "numAssociation")).intValue();
                } catch (Throwable unused) {
                    i = 0;
                }
                if (i > 0 && !TextUtils.isEmpty(str)) {
                    arrayList.add(new d(str, i));
                }
            }
        }
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        if (arrayList.size() > 1) {
            Collections.sort(arrayList, new com.baidu.location.b.f(this));
        }
        StringBuffer stringBuffer = new StringBuffer(200);
        for (d dVar : arrayList) {
            stringBuffer.append(dVar.a).append(",").append(dVar.b).append("|");
            i2++;
            if (i2 == 4) {
                break;
            }
        }
        if (arrayList.size() >= 5) {
            stringBuffer.append(((d) arrayList.get(4)).a).append(",").append(((d) arrayList.get(4)).b);
        }
        return stringBuffer.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        String[] split;
        try {
            JSONObject jSONObject = new JSONObject(str).getJSONObject("content");
            String string = jSONObject.has("ideocfre") ? jSONObject.getString("ideocfre") : null;
            if (TextUtils.isEmpty(string) || !string.contains("|") || (split = string.split("\\|")) == null || split.length < 2) {
                return;
            }
            int parseInt = Integer.parseInt(split[0]);
            long parseLong = Long.parseLong(split[1]);
            SharedPreferences.Editor edit = this.d.getSharedPreferences("cuidRelate", 0).edit();
            edit.putInt("cuidoc", parseInt);
            edit.putLong("cuidfreq", parseLong);
            edit.apply();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean a(WifiManager wifiManager) {
        try {
            if (!wifiManager.isWifiEnabled()) {
                if (Build.VERSION.SDK_INT <= 17) {
                    return false;
                }
                if (!wifiManager.isScanAlwaysAvailable()) {
                    return false;
                }
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static String b(WifiManager wifiManager) {
        if (wifiManager == null) {
            return null;
        }
        try {
            WifiInfo connectionInfo = wifiManager.getConnectionInfo();
            if (connectionInfo == null) {
                return null;
            }
            String bssid = connectionInfo.getBSSID();
            String replace = bssid != null ? bssid.replace(":", "") : null;
            if (replace == null || replace.length() == 12) {
                return new String(replace);
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i) {
        if (this.k.isOnceLocation()) {
            BDLocation bDLocation = new BDLocation();
            bDLocation.setLocType(i);
            bDLocation.setLocationID(Jni.en1(this.a + ";" + this.b + ";" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).format(new Date(System.currentTimeMillis()))));
            b bVar = this.l;
            if (bVar != null) {
                bVar.onReceiveLocation(bDLocation);
            }
        }
    }

    private boolean f() {
        if (com.baidu.location.b.a.a().d == 0) {
            return false;
        }
        SharedPreferences sharedPreferences = this.d.getApplicationContext().getSharedPreferences("cuidRelate", 0);
        if (!sharedPreferences.contains("isInstalled")) {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            if (!com.baidu.location.h.o.b(this.d, "com.baidu.map.location")) {
                edit.putInt("isInstalled", 0);
                return false;
            }
            edit.putInt("isInstalled", 1);
            edit.apply();
        } else if (sharedPreferences.getInt("isInstalled", -1) == 0) {
            return false;
        }
        return sharedPreferences.getInt("cuidoc", 1) != 0 && (System.currentTimeMillis() - sharedPreferences.getLong("reqtime", 0L)) / 1000 >= sharedPreferences.getLong("cuidfreq", 60L) && com.baidu.location.h.o.c(this.d) >= 2 && a(this.g) && this.h.a() > 3;
    }

    private void g() {
        String a2;
        if (!f()) {
            this.r = false;
            return;
        }
        this.r = true;
        if (this.h.a() >= 10) {
            String a3 = this.h.a(9, b(this.g), this.r, com.baidu.location.b.a.a().b);
            if (!TextUtils.isEmpty(a3)) {
                a2 = com.baidu.location.h.o.a(a3.getBytes(), false);
            }
            a2 = null;
        } else {
            C0006e c0006e = this.h;
            String a4 = c0006e.a(c0006e.a(), b(this.g), this.r, com.baidu.location.b.a.a().b);
            if (!TextUtils.isEmpty(a4)) {
                a2 = com.baidu.location.h.o.a(a4.getBytes(), false);
            }
            a2 = null;
        }
        String a5 = a(h());
        String a6 = TextUtils.isEmpty(a5) ? null : com.baidu.location.h.o.a(a5.getBytes(), false);
        if (TextUtils.isEmpty(a2)) {
            this.r = false;
        } else {
            this.m += "&swf5=" + a2;
            this.r = true;
        }
        if (TextUtils.isEmpty(a6)) {
            return;
        }
        this.m += "&hwf5=" + a6;
        this.r = true;
    }

    private List<WifiConfiguration> h() {
        try {
            WifiManager wifiManager = this.g;
            if (wifiManager != null) {
                return wifiManager.getConfiguredNetworks();
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public void a() {
        b();
    }

    public String b() {
        try {
            return a(15);
        } catch (Exception unused) {
            return null;
        }
    }

    public void c() {
        BDLocation bDLocation;
        if (this.m == null) {
            int i = 62;
            int h = com.baidu.location.h.o.h(this.d);
            if (h == -1) {
                i = 69;
            } else if (h == -2) {
                i = 70;
            } else if (h == 0) {
                i = 71;
            }
            b(i);
            return;
        }
        if (this.p) {
            if (this.d != null) {
                com.baidu.location.b.c.a().a(this.d);
                this.m += com.baidu.location.b.c.a().b();
            }
            BDLocation bDLocation2 = null;
            if (this.g != null && this.k.scanSpan >= 1000 && !this.k.getAddrType().equals(TtmlNode.COMBINE_ALL) && !this.k.isNeedAptag && !this.k.isNeedAptagd && !this.k.isOnceLocation()) {
                try {
                    com.baidu.location.f.a aVar = this.f;
                    String g = aVar != null ? aVar.g() : null;
                    if (this.g != null) {
                        bDLocation = com.baidu.location.e.a.a().a(g, this.k.priority != 4 ? this.g.getScanResults() : null, false);
                        if (bDLocation != null && bDLocation.getLocType() == 66 && Math.abs(bDLocation.getLatitude()) < 0.10000000149011612d && Math.abs(bDLocation.getLongitude()) < 0.10000000149011612d) {
                            bDLocation.setLocType(67);
                        }
                    } else {
                        bDLocation = null;
                    }
                    if (bDLocation != null) {
                        bDLocation.getLocType();
                    }
                    if (bDLocation != null) {
                        bDLocation.getLocType();
                    }
                    if (!this.k.coorType.equals("gcj02") && bDLocation != null && bDLocation.getLocType() == 66) {
                        double longitude = bDLocation.getLongitude();
                        double latitude = bDLocation.getLatitude();
                        if (Math.abs(longitude) > 0.10000000149011612d && Math.abs(latitude) > 0.10000000149011612d) {
                            double[] coorEncrypt = Jni.coorEncrypt(longitude, latitude, this.k.coorType);
                            bDLocation.setLongitude(coorEncrypt[0]);
                            bDLocation.setLatitude(coorEncrypt[1]);
                            bDLocation.setCoorType(this.k.coorType);
                        }
                    }
                    if (bDLocation != null && bDLocation.getLocType() == 66 && Math.abs(bDLocation.getLatitude()) > 0.10000000149011612d && Math.abs(bDLocation.getLongitude()) > 0.10000000149011612d) {
                        if (!this.x) {
                            this.l.onReceiveLocation(bDLocation);
                        }
                        bDLocation2 = bDLocation;
                    }
                } catch (Exception unused) {
                }
            }
            if (bDLocation2 == null) {
                this.c.a(this.m);
            }
        }
    }

    public void d() {
        if ((this.g.isWifiEnabled() || this.g.isScanAlwaysAvailable()) && this.k.priority != 4) {
            this.g.startScan();
        }
        if (com.baidu.location.h.o.a(this.d, Permission.ACCESS_FINE_LOCATION) == 1 && Build.VERSION.SDK_INT >= 29 && this.v) {
            this.e.requestCellInfoUpdate(this.d.getMainExecutor(), new a(this, null));
        }
        synchronized (this.s) {
            try {
                this.s.wait(3000L);
            } catch (InterruptedException unused) {
            }
        }
    }

    public void e() {
        try {
            f fVar = this.t;
            if (fVar != null) {
                this.d.unregisterReceiver(fVar);
            }
        } catch (Exception unused) {
        }
    }
}
