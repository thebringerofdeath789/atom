package com.baidu.location.p006b;

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
import com.baidu.location.p005a.C0643a;
import com.baidu.location.p009e.C0686a;
import com.baidu.location.p010f.C0703a;
import com.baidu.location.p012h.AbstractC0725g;
import com.baidu.location.p012h.C0722d;
import com.baidu.location.p012h.C0733o;
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

/* renamed from: com.baidu.location.b.e */
/* loaded from: classes.dex */
public class C0651e {

    /* renamed from: q */
    private static char[] f459q = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_.".toCharArray();

    /* renamed from: a */
    String f460a;

    /* renamed from: b */
    String f461b;

    /* renamed from: d */
    private Context f463d;

    /* renamed from: e */
    private TelephonyManager f464e;

    /* renamed from: g */
    private WifiManager f466g;

    /* renamed from: i */
    private String f468i;

    /* renamed from: j */
    private String f469j;

    /* renamed from: k */
    private LocationClientOption f470k;

    /* renamed from: l */
    private b f471l;

    /* renamed from: n */
    private String f473n;

    /* renamed from: o */
    private String f474o;

    /* renamed from: p */
    private boolean f475p;

    /* renamed from: t */
    private f f478t;

    /* renamed from: v */
    private boolean f480v;

    /* renamed from: f */
    private C0703a f465f = new C0703a();

    /* renamed from: h */
    private e f467h = null;

    /* renamed from: m */
    private String f472m = null;

    /* renamed from: c */
    c f462c = new c();

    /* renamed from: r */
    private boolean f476r = false;

    /* renamed from: s */
    private final Object f477s = new Object();

    /* renamed from: u */
    private boolean f479u = true;

    /* renamed from: w */
    private long f481w = 0;

    /* renamed from: x */
    private boolean f482x = false;

    /* renamed from: com.baidu.location.b.e$a */
    private class a extends TelephonyManager.CellInfoCallback {
        private a() {
        }

        /* synthetic */ a(C0651e c0651e, C0652f c0652f) {
            this();
        }

        @Override // android.telephony.TelephonyManager.CellInfoCallback
        public void onCellInfo(List<CellInfo> list) {
            if (list == null) {
                return;
            }
            C0651e.this.f479u = !r2.f479u;
            if (C0651e.this.f479u || C0651e.this.f470k.priority == 4) {
                synchronized (C0651e.this.f477s) {
                    C0651e.this.f477s.notifyAll();
                }
            }
        }
    }

    /* renamed from: com.baidu.location.b.e$b */
    public interface b {
        void onReceiveLocation(BDLocation bDLocation);
    }

    /* renamed from: com.baidu.location.b.e$c */
    class c extends AbstractC0725g {

        /* renamed from: b */
        LocationManager f485b;

        /* renamed from: c */
        a f486c;

        /* renamed from: a */
        String f484a = null;

        /* renamed from: d */
        boolean f487d = false;

        /* renamed from: com.baidu.location.b.e$c$a */
        private class a implements LocationListener {
            private a() {
            }

            /* synthetic */ a(c cVar, C0652f c0652f) {
                this();
            }

            @Override // android.location.LocationListener
            public void onLocationChanged(Location location) {
                c.this.m405c();
                c.this.f487d = true;
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
            this.f1292k = new HashMap();
        }

        /* renamed from: a */
        private void m403a() {
            try {
                this.f485b = (LocationManager) C0651e.this.f463d.getSystemService("location");
                a aVar = new a(this, null);
                this.f486c = aVar;
                LocationManager locationManager = this.f485b;
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
        /* renamed from: c */
        public void m405c() {
            LocationManager locationManager;
            a aVar = this.f486c;
            if (aVar == null || (locationManager = this.f485b) == null) {
                return;
            }
            try {
                locationManager.removeUpdates(aVar);
            } catch (Exception unused) {
            }
        }

        /* renamed from: a */
        public void m406a(String str) {
            this.f484a = str;
            m1133e(C0722d.f1260c);
            if (C0651e.this.f476r) {
                m403a();
                Timer timer = new Timer();
                timer.schedule(new C0653g(this, timer), Constant.DELAY_MILLIS);
                SharedPreferences.Editor edit = C0651e.this.f463d.getSharedPreferences("cuidRelate", 0).edit();
                edit.putLong("reqtime", System.currentTimeMillis());
                edit.apply();
            }
        }

        @Override // com.baidu.location.p012h.AbstractC0725g
        /* renamed from: a */
        public void mo122a(boolean z) {
            BDLocation bDLocation;
            if (!z || this.f1291j == null) {
                C0651e.this.m386b(63);
            } else {
                try {
                    String str = this.f1291j;
                    if (str.contains("\"enc\"")) {
                        try {
                            JSONObject jSONObject = new JSONObject(str);
                            if (jSONObject.has("enc")) {
                                str = C0660n.m467a().m469b(jSONObject.getString("enc"));
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    try {
                        bDLocation = new BDLocation(str);
                        C0651e.this.m381a(str);
                    } catch (Exception unused) {
                        bDLocation = new BDLocation();
                        bDLocation.setLocType(63);
                    }
                    if (bDLocation.getLocType() == 161) {
                        bDLocation.setCoorType(C0651e.this.f470k.coorType);
                        bDLocation.setLocationID(Jni.en1(C0651e.this.f460a + ";" + C0651e.this.f461b + ";" + bDLocation.getTime()));
                        bDLocation.setRoadLocString(0.0f, 0.0f, null, null);
                        C0651e.this.f482x = true;
                        C0651e.this.f471l.onReceiveLocation(bDLocation);
                    } else {
                        C0651e.this.m386b(bDLocation.getLocType());
                    }
                } catch (Exception e2) {
                    C0651e.this.m386b(63);
                    e2.printStackTrace();
                }
            }
            if (this.f1292k != null) {
                this.f1292k.clear();
            }
        }

        @Override // com.baidu.location.p012h.AbstractC0725g
        /* renamed from: b */
        public void mo123b() {
            if (C0651e.this.f473n != null && C0651e.this.f474o != null) {
                this.f484a += String.format(Locale.CHINA, "&ki=%s&sn=%s", C0651e.this.f473n, C0651e.this.f474o);
            }
            String str = this.f484a + "&enc=2";
            this.f484a = str;
            String encodeTp4 = Jni.encodeTp4(str);
            this.f484a = null;
            this.f1292k.put("bloc", encodeTp4);
            this.f1292k.put("trtm", String.format(Locale.CHINA, "%d", Long.valueOf(System.currentTimeMillis())));
        }
    }

    /* renamed from: com.baidu.location.b.e$d */
    private class d {

        /* renamed from: a */
        public String f490a;

        /* renamed from: b */
        public int f491b;

        d(String str, int i) {
            this.f490a = str;
            this.f491b = i;
        }
    }

    /* renamed from: com.baidu.location.b.e$e */
    public static class e {

        /* renamed from: a */
        public List<ScanResult> f493a;

        /* renamed from: c */
        private long f495c;

        /* renamed from: b */
        public String f494b = null;

        /* renamed from: d */
        private String f496d = null;

        /* renamed from: e */
        private int f497e = 16;

        public e(List<ScanResult> list) {
            this.f493a = null;
            this.f495c = 0L;
            this.f493a = list;
            this.f495c = System.currentTimeMillis();
            try {
                m407b();
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
        /* renamed from: b */
        private void m407b() {
            /*
                r7 = this;
                int r0 = r7.m408a()
                r1 = 1
                if (r0 >= r1) goto L8
                return
            L8:
                java.util.List<android.net.wifi.ScanResult> r0 = r7.f493a
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
                java.util.List<android.net.wifi.ScanResult> r4 = r7.f493a
                java.lang.Object r4 = r4.get(r2)
                if (r4 == 0) goto L57
                java.util.List<android.net.wifi.ScanResult> r4 = r7.f493a
                int r5 = r2 + 1
                java.lang.Object r4 = r4.get(r5)
                if (r4 == 0) goto L57
                java.util.List<android.net.wifi.ScanResult> r4 = r7.f493a
                java.lang.Object r4 = r4.get(r2)
                android.net.wifi.ScanResult r4 = (android.net.wifi.ScanResult) r4
                int r4 = r4.level
                java.util.List<android.net.wifi.ScanResult> r6 = r7.f493a
                java.lang.Object r6 = r6.get(r5)
                android.net.wifi.ScanResult r6 = (android.net.wifi.ScanResult) r6
                int r6 = r6.level
                if (r4 >= r6) goto L57
                java.util.List<android.net.wifi.ScanResult> r3 = r7.f493a
                java.lang.Object r3 = r3.get(r5)
                android.net.wifi.ScanResult r3 = (android.net.wifi.ScanResult) r3
                java.util.List<android.net.wifi.ScanResult> r4 = r7.f493a
                java.lang.Object r6 = r4.get(r2)
                r4.set(r5, r6)
                java.util.List<android.net.wifi.ScanResult> r4 = r7.f493a
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
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.p006b.C0651e.e.m407b():void");
        }

        /* renamed from: a */
        public int m408a() {
            List<ScanResult> list = this.f493a;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x0053  */
        /* JADX WARN: Removed duplicated region for block: B:36:0x00f3  */
        /* JADX WARN: Removed duplicated region for block: B:38:0x00f8  */
        /* JADX WARN: Removed duplicated region for block: B:92:0x00eb A[SYNTHETIC] */
        /* renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public java.lang.String m409a(int r26, java.lang.String r27, boolean r28, int r29) {
            /*
                Method dump skipped, instructions count: 475
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.p006b.C0651e.e.m409a(int, java.lang.String, boolean, int):java.lang.String");
        }
    }

    /* renamed from: com.baidu.location.b.e$f */
    private class f extends BroadcastReceiver {
        private f() {
        }

        /* synthetic */ f(C0651e c0651e, C0652f c0652f) {
            this();
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (context == null || intent == null) {
                return;
            }
            String action = intent.getAction();
            C0651e.this.f479u = !r3.f479u;
            if (!(action.equals("android.net.wifi.SCAN_RESULTS") && C0651e.this.f479u) && Build.VERSION.SDK_INT >= 29 && C0651e.this.f480v) {
                return;
            }
            synchronized (C0651e.this.f477s) {
                C0651e.this.f477s.notifyAll();
            }
        }
    }

    public C0651e(Context context, LocationClientOption locationClientOption, b bVar, String str) {
        StringBuilder append;
        String str2 = null;
        byte b2 = 0;
        this.f463d = null;
        this.f464e = null;
        this.f466g = null;
        this.f468i = null;
        this.f469j = null;
        this.f473n = null;
        this.f474o = null;
        this.f460a = null;
        this.f461b = null;
        this.f475p = false;
        this.f478t = null;
        this.f480v = false;
        Context applicationContext = context.getApplicationContext();
        this.f463d = applicationContext;
        try {
            C0733o.f1382aw = applicationContext.getPackageName();
        } catch (Exception unused) {
        }
        this.f475p = true;
        this.f470k = new LocationClientOption(locationClientOption);
        this.f471l = bVar;
        this.f460a = this.f463d.getPackageName();
        this.f461b = null;
        try {
            this.f464e = (TelephonyManager) this.f463d.getSystemService("phone");
            this.f466g = (WifiManager) this.f463d.getApplicationContext().getSystemService("wifi");
        } catch (Exception unused2) {
        }
        if (this.f470k.firstLocType == LocationClientOption.FirstLocType.ACCURACY_IN_FIRST_LOC) {
            if (this.f470k.priority != 4) {
                f fVar = new f(this, b2 == true ? 1 : 0);
                this.f478t = fVar;
                try {
                    this.f463d.registerReceiver(fVar, new IntentFilter("android.net.wifi.SCAN_RESULTS"));
                } catch (Exception unused3) {
                }
            }
            if (Build.VERSION.SDK_INT >= 30) {
                this.f480v = C0733o.m1154b("android.telephony.TelephonyManager$CellInfoCallback");
            }
        }
        this.f469j = "&" + this.f460a + "&" + ((String) null);
        try {
            this.f461b = LBSAuthManager.getInstance(this.f463d).getCUID();
        } catch (Throwable unused4) {
            this.f461b = null;
            this.f464e = null;
            this.f466g = null;
        }
        if (this.f461b != null) {
            C0733o.f1398n = "" + this.f461b;
            append = new StringBuilder().append("&prod=").append(this.f470k.prodName).append(":").append(this.f460a).append("|&cu=");
            str2 = this.f461b;
        } else {
            append = new StringBuilder().append("&prod=").append(this.f470k.prodName).append(":").append(this.f460a).append("|&im=");
        }
        this.f468i = append.append(str2).append("&coor=").append(locationClientOption.getCoorType()).toString();
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
            this.f468i += "&addr=allj2";
            if (locationClientOption.isNeedNewVersionRgc) {
                stringBuffer.append("&adtp=n2");
            }
        }
        if (locationClientOption.isNeedAptag || locationClientOption.isNeedAptagd) {
            this.f468i += "&sema=";
            if (locationClientOption.isNeedAptag) {
                this.f468i += "aptag|";
            }
            if (locationClientOption.isNeedAptagd) {
                this.f468i += "aptagd2|";
            }
            this.f473n = C0643a.m296b(this.f463d);
            this.f474o = C0643a.m297c(this.f463d);
        }
        stringBuffer.append("&first=1");
        stringBuffer.append("&os=A");
        stringBuffer.append(Build.VERSION.SDK);
        this.f468i += stringBuffer.toString();
    }

    /* renamed from: a */
    public static C0703a m374a(CellLocation cellLocation, TelephonyManager telephonyManager, C0703a c0703a) {
        if (cellLocation == null || telephonyManager == null) {
            return null;
        }
        C0703a c0703a2 = new C0703a();
        c0703a2.f1021l = 1;
        String networkOperator = telephonyManager.getNetworkOperator();
        if (networkOperator != null && networkOperator.length() > 0) {
            try {
                if (networkOperator.length() >= 3) {
                    int intValue = Integer.valueOf(networkOperator.substring(0, 3)).intValue();
                    if (intValue < 0) {
                        intValue = c0703a.f1012c;
                    }
                    c0703a2.f1012c = intValue;
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
                        intValue2 = c0703a.f1013d;
                    }
                    c0703a2.f1013d = intValue2;
                }
            } catch (Exception unused) {
            }
        }
        if (cellLocation instanceof GsmCellLocation) {
            c0703a2.f1010a = ((GsmCellLocation) cellLocation).getLac();
            c0703a2.f1011b = r6.getCid();
            c0703a2.f1018i = 'g';
        } else if (cellLocation instanceof CdmaCellLocation) {
            c0703a2.f1018i = 'c';
            try {
                Class<?> cls = Class.forName("android.telephony.cdma.CdmaCellLocation");
                if (cls != null && cls.isInstance(cellLocation)) {
                    try {
                        int systemId = ((CdmaCellLocation) cellLocation).getSystemId();
                        if (systemId < 0) {
                            systemId = -1;
                        }
                        c0703a2.f1013d = systemId;
                        c0703a2.f1011b = ((CdmaCellLocation) cellLocation).getBaseStationId();
                        c0703a2.f1010a = ((CdmaCellLocation) cellLocation).getNetworkId();
                        int baseStationLatitude = ((CdmaCellLocation) cellLocation).getBaseStationLatitude();
                        if (baseStationLatitude < Integer.MAX_VALUE) {
                            c0703a2.f1014e = baseStationLatitude;
                        }
                        int baseStationLongitude = ((CdmaCellLocation) cellLocation).getBaseStationLongitude();
                        if (baseStationLongitude < Integer.MAX_VALUE) {
                            c0703a2.f1015f = baseStationLongitude;
                        }
                    } catch (Exception unused2) {
                    }
                }
            } catch (Exception unused3) {
                return null;
            }
        }
        if (c0703a2.m896b()) {
            return c0703a2;
        }
        return null;
    }

    /* renamed from: a */
    private Object m375a(Object obj, String str) throws Exception {
        return obj.getClass().getField(str).get(obj);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(19:0|1|(2:2|3)|(15:5|(1:7)|8|9|(1:58)(1:13)|15|16|(1:22)|24|25|(5:29|30|31|(1:35)|(2:(1:(1:44)(1:45))|(1:47)(4:48|(1:50)|51|52))(2:39|40))|55|(0)|(0)|(0)(0))|59|(2:61|8)|9|(1:11)|58|15|16|(3:18|20|22)|24|25|(8:27|29|30|31|(2:33|35)|(0)|(0)|(0)(0))|55|(0)|(0)|(0)(0)) */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00a5 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00c3 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00c4  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String m376a(int r7) {
        /*
            Method dump skipped, instructions count: 248
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.p006b.C0651e.m376a(int):java.lang.String");
    }

    /* renamed from: a */
    private String m378a(List<WifiConfiguration> list) {
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
                    i = ((Integer) m375a(wifiConfiguration, "numAssociation")).intValue();
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
            Collections.sort(arrayList, new C0652f(this));
        }
        StringBuffer stringBuffer = new StringBuffer(200);
        for (d dVar : arrayList) {
            stringBuffer.append(dVar.f490a).append(",").append(dVar.f491b).append("|");
            i2++;
            if (i2 == 4) {
                break;
            }
        }
        if (arrayList.size() >= 5) {
            stringBuffer.append(((d) arrayList.get(4)).f490a).append(",").append(((d) arrayList.get(4)).f491b);
        }
        return stringBuffer.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m381a(String str) {
        String[] split;
        try {
            JSONObject jSONObject = new JSONObject(str).getJSONObject("content");
            String string = jSONObject.has("ideocfre") ? jSONObject.getString("ideocfre") : null;
            if (TextUtils.isEmpty(string) || !string.contains("|") || (split = string.split("\\|")) == null || split.length < 2) {
                return;
            }
            int parseInt = Integer.parseInt(split[0]);
            long parseLong = Long.parseLong(split[1]);
            SharedPreferences.Editor edit = this.f463d.getSharedPreferences("cuidRelate", 0).edit();
            edit.putInt("cuidoc", parseInt);
            edit.putLong("cuidfreq", parseLong);
            edit.apply();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* renamed from: a */
    public static boolean m382a(WifiManager wifiManager) {
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

    /* renamed from: b */
    public static String m384b(WifiManager wifiManager) {
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
    /* renamed from: b */
    public void m386b(int i) {
        if (this.f470k.isOnceLocation()) {
            BDLocation bDLocation = new BDLocation();
            bDLocation.setLocType(i);
            bDLocation.setLocationID(Jni.en1(this.f460a + ";" + this.f461b + ";" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).format(new Date(System.currentTimeMillis()))));
            b bVar = this.f471l;
            if (bVar != null) {
                bVar.onReceiveLocation(bDLocation);
            }
        }
    }

    /* renamed from: f */
    private boolean m392f() {
        if (C0645a.m302a().f391d == 0) {
            return false;
        }
        SharedPreferences sharedPreferences = this.f463d.getApplicationContext().getSharedPreferences("cuidRelate", 0);
        if (!sharedPreferences.contains("isInstalled")) {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            if (!C0733o.m1153b(this.f463d, "com.baidu.map.location")) {
                edit.putInt("isInstalled", 0);
                return false;
            }
            edit.putInt("isInstalled", 1);
            edit.apply();
        } else if (sharedPreferences.getInt("isInstalled", -1) == 0) {
            return false;
        }
        return sharedPreferences.getInt("cuidoc", 1) != 0 && (System.currentTimeMillis() - sharedPreferences.getLong("reqtime", 0L)) / 1000 >= sharedPreferences.getLong("cuidfreq", 60L) && C0733o.m1156c(this.f463d) >= 2 && m382a(this.f466g) && this.f467h.m408a() > 3;
    }

    /* renamed from: g */
    private void m393g() {
        String m1143a;
        if (!m392f()) {
            this.f476r = false;
            return;
        }
        this.f476r = true;
        if (this.f467h.m408a() >= 10) {
            String m409a = this.f467h.m409a(9, m384b(this.f466g), this.f476r, C0645a.m302a().f389b);
            if (!TextUtils.isEmpty(m409a)) {
                m1143a = C0733o.m1143a(m409a.getBytes(), false);
            }
            m1143a = null;
        } else {
            e eVar = this.f467h;
            String m409a2 = eVar.m409a(eVar.m408a(), m384b(this.f466g), this.f476r, C0645a.m302a().f389b);
            if (!TextUtils.isEmpty(m409a2)) {
                m1143a = C0733o.m1143a(m409a2.getBytes(), false);
            }
            m1143a = null;
        }
        String m378a = m378a(m395h());
        String m1143a2 = TextUtils.isEmpty(m378a) ? null : C0733o.m1143a(m378a.getBytes(), false);
        if (TextUtils.isEmpty(m1143a)) {
            this.f476r = false;
        } else {
            this.f472m += "&swf5=" + m1143a;
            this.f476r = true;
        }
        if (TextUtils.isEmpty(m1143a2)) {
            return;
        }
        this.f472m += "&hwf5=" + m1143a2;
        this.f476r = true;
    }

    /* renamed from: h */
    private List<WifiConfiguration> m395h() {
        try {
            WifiManager wifiManager = this.f466g;
            if (wifiManager != null) {
                return wifiManager.getConfiguredNetworks();
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: a */
    public void m398a() {
        m399b();
    }

    /* renamed from: b */
    public String m399b() {
        try {
            return m376a(15);
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: c */
    public void m400c() {
        BDLocation bDLocation;
        if (this.f472m == null) {
            int i = 62;
            int m1168h = C0733o.m1168h(this.f463d);
            if (m1168h == -1) {
                i = 69;
            } else if (m1168h == -2) {
                i = 70;
            } else if (m1168h == 0) {
                i = 71;
            }
            m386b(i);
            return;
        }
        if (this.f475p) {
            if (this.f463d != null) {
                C0649c.m358a().m366a(this.f463d);
                this.f472m += C0649c.m358a().m368b();
            }
            BDLocation bDLocation2 = null;
            if (this.f466g != null && this.f470k.scanSpan >= 1000 && !this.f470k.getAddrType().equals(TtmlNode.COMBINE_ALL) && !this.f470k.isNeedAptag && !this.f470k.isNeedAptagd && !this.f470k.isOnceLocation()) {
                try {
                    C0703a c0703a = this.f465f;
                    String m901g = c0703a != null ? c0703a.m901g() : null;
                    if (this.f466g != null) {
                        bDLocation = C0686a.m702a().m715a(m901g, this.f470k.priority != 4 ? this.f466g.getScanResults() : null, false);
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
                    if (!this.f470k.coorType.equals("gcj02") && bDLocation != null && bDLocation.getLocType() == 66) {
                        double longitude = bDLocation.getLongitude();
                        double latitude = bDLocation.getLatitude();
                        if (Math.abs(longitude) > 0.10000000149011612d && Math.abs(latitude) > 0.10000000149011612d) {
                            double[] coorEncrypt = Jni.coorEncrypt(longitude, latitude, this.f470k.coorType);
                            bDLocation.setLongitude(coorEncrypt[0]);
                            bDLocation.setLatitude(coorEncrypt[1]);
                            bDLocation.setCoorType(this.f470k.coorType);
                        }
                    }
                    if (bDLocation != null && bDLocation.getLocType() == 66 && Math.abs(bDLocation.getLatitude()) > 0.10000000149011612d && Math.abs(bDLocation.getLongitude()) > 0.10000000149011612d) {
                        if (!this.f482x) {
                            this.f471l.onReceiveLocation(bDLocation);
                        }
                        bDLocation2 = bDLocation;
                    }
                } catch (Exception unused) {
                }
            }
            if (bDLocation2 == null) {
                this.f462c.m406a(this.f472m);
            }
        }
    }

    /* renamed from: d */
    public void m401d() {
        if ((this.f466g.isWifiEnabled() || this.f466g.isScanAlwaysAvailable()) && this.f470k.priority != 4) {
            this.f466g.startScan();
        }
        if (C0733o.m1135a(this.f463d, Permission.ACCESS_FINE_LOCATION) == 1 && Build.VERSION.SDK_INT >= 29 && this.f480v) {
            this.f464e.requestCellInfoUpdate(this.f463d.getMainExecutor(), new a(this, null));
        }
        synchronized (this.f477s) {
            try {
                this.f477s.wait(3000L);
            } catch (InterruptedException unused) {
            }
        }
    }

    /* renamed from: e */
    public void m402e() {
        try {
            f fVar = this.f478t;
            if (fVar != null) {
                this.f463d.unregisterReceiver(fVar);
            }
        } catch (Exception unused) {
        }
    }
}