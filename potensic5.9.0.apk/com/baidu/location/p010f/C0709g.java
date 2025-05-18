package com.baidu.location.p010f;

import android.content.Context;
import android.location.GnssMeasurementsEvent;
import android.location.GnssNavigationMessage;
import android.location.GnssStatus;
import android.location.GpsSatellite;
import android.location.GpsStatus;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.OnNmeaMessageListener;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.location.BDLocation;
import com.baidu.location.Jni;
import com.baidu.location.ServiceC0702f;
import com.baidu.location.p006b.C0646aa;
import com.baidu.location.p006b.C0648b;
import com.baidu.location.p006b.C0649c;
import com.baidu.location.p006b.C0662p;
import com.baidu.location.p006b.C0668v;
import com.baidu.location.p006b.C0672z;
import com.baidu.location.p012h.C0721c;
import com.baidu.location.p012h.C0724f;
import com.baidu.location.p012h.C0733o;
import com.google.android.exoplayer2.source.rtsp.SessionDescription;
import com.hjq.permissions.Permission;
import com.ipotensic.baselib.netty.Constant;
import io.netty.handler.codec.http.websocketx.WebSocketServerHandshaker;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.Random;
import org.apache.commons.net.nntp.NNTPReply;

/* renamed from: com.baidu.location.f.g */
/* loaded from: classes.dex */
public class C0709g {

    /* renamed from: A */
    private static int f1069A = 0;

    /* renamed from: B */
    private static int f1070B = 0;

    /* renamed from: C */
    private static long f1071C = 0;

    /* renamed from: Q */
    private static String f1072Q = null;

    /* renamed from: S */
    private static double f1073S = 100.0d;

    /* renamed from: V */
    private static float f1074V = -1.0f;

    /* renamed from: a */
    public static int f1075a = 0;

    /* renamed from: b */
    public static String f1076b = "";

    /* renamed from: c */
    public static String f1077c = "";

    /* renamed from: e */
    private static C0709g f1078e = null;

    /* renamed from: i */
    private static Location f1079i = null;

    /* renamed from: j */
    private static int f1080j = -1;

    /* renamed from: t */
    private static int f1081t;

    /* renamed from: u */
    private static int f1082u;

    /* renamed from: v */
    private static int f1083v;

    /* renamed from: w */
    private static int f1084w;

    /* renamed from: x */
    private static int f1085x;

    /* renamed from: y */
    private static int f1086y;

    /* renamed from: z */
    private static int f1087z;

    /* renamed from: an */
    private BDLocation f1121an;

    /* renamed from: ar */
    private String f1125ar;

    /* renamed from: f */
    private Context f1135f;

    /* renamed from: h */
    private Location f1137h;

    /* renamed from: m */
    private GpsStatus f1140m;

    /* renamed from: n */
    private c f1141n;

    /* renamed from: o */
    private boolean f1142o;

    /* renamed from: q */
    private boolean f1144q;

    /* renamed from: g */
    private LocationManager f1136g = null;

    /* renamed from: k */
    private f f1138k = null;

    /* renamed from: l */
    private h f1139l = null;

    /* renamed from: p */
    private d f1143p = null;

    /* renamed from: r */
    private GpsStatus.NmeaListener f1145r = null;

    /* renamed from: s */
    private OnNmeaMessageListener f1146s = null;

    /* renamed from: D */
    private long f1088D = 0;

    /* renamed from: E */
    private boolean f1089E = false;

    /* renamed from: F */
    private boolean f1090F = false;

    /* renamed from: G */
    private String f1091G = null;

    /* renamed from: H */
    private boolean f1092H = false;

    /* renamed from: I */
    private long f1093I = 0;

    /* renamed from: J */
    private long f1094J = 0;

    /* renamed from: K */
    private double f1095K = -1.0d;

    /* renamed from: L */
    private double f1096L = 0.0d;

    /* renamed from: M */
    private double f1097M = 0.0d;

    /* renamed from: N */
    private long f1098N = 0;

    /* renamed from: O */
    private long f1099O = 0;

    /* renamed from: P */
    private long f1100P = 0;

    /* renamed from: R */
    private e f1101R = null;

    /* renamed from: T */
    private long f1102T = 0;

    /* renamed from: U */
    private long f1103U = 0;

    /* renamed from: W */
    private a f1104W = null;

    /* renamed from: X */
    private b f1105X = null;

    /* renamed from: Y */
    private ArrayList<ArrayList<Float>> f1106Y = new ArrayList<>();

    /* renamed from: Z */
    private ArrayList<ArrayList<Float>> f1107Z = new ArrayList<>();

    /* renamed from: aa */
    private ArrayList<ArrayList<Float>> f1108aa = new ArrayList<>();

    /* renamed from: ab */
    private ArrayList<ArrayList<Float>> f1109ab = new ArrayList<>();

    /* renamed from: ac */
    private ArrayList<ArrayList<Float>> f1110ac = new ArrayList<>();

    /* renamed from: ad */
    private ArrayList<ArrayList<Float>> f1111ad = new ArrayList<>();

    /* renamed from: ae */
    private ArrayList<ArrayList<Float>> f1112ae = new ArrayList<>();

    /* renamed from: af */
    private String f1113af = null;

    /* renamed from: ag */
    private long f1114ag = 0;

    /* renamed from: ah */
    private ArrayList<Integer> f1115ah = new ArrayList<>();

    /* renamed from: ai */
    private String f1116ai = null;

    /* renamed from: aj */
    private String f1117aj = null;

    /* renamed from: ak */
    private long f1118ak = 0;

    /* renamed from: al */
    private long f1119al = -1;

    /* renamed from: am */
    private long f1120am = -1;

    /* renamed from: ao */
    private boolean f1122ao = false;

    /* renamed from: ap */
    private boolean f1123ap = false;

    /* renamed from: aq */
    private long f1124aq = 0;

    /* renamed from: as */
    private long f1126as = 0;

    /* renamed from: at */
    private boolean f1127at = false;

    /* renamed from: au */
    private boolean f1128au = false;

    /* renamed from: av */
    private boolean f1129av = false;

    /* renamed from: aw */
    private StringBuilder f1130aw = new StringBuilder();

    /* renamed from: ax */
    private String f1131ax = "";

    /* renamed from: ay */
    private long f1132ay = -1;

    /* renamed from: az */
    private long f1133az = 0;

    /* renamed from: d */
    public long f1134d = 0;

    /* renamed from: com.baidu.location.f.g$a */
    private class a extends GnssMeasurementsEvent.Callback {

        /* renamed from: a */
        public int f1147a;

        @Override // android.location.GnssMeasurementsEvent.Callback
        public void onGnssMeasurementsReceived(GnssMeasurementsEvent gnssMeasurementsEvent) {
        }

        @Override // android.location.GnssMeasurementsEvent.Callback
        public void onStatusChanged(int i) {
            this.f1147a = i;
        }
    }

    /* renamed from: com.baidu.location.f.g$b */
    private class b extends GnssNavigationMessage.Callback {

        /* renamed from: a */
        public int f1148a;

        private b() {
            this.f1148a = 0;
        }

        /* synthetic */ b(C0709g c0709g, C0710h c0710h) {
            this();
        }

        @Override // android.location.GnssNavigationMessage.Callback
        public void onGnssNavigationMessageReceived(GnssNavigationMessage gnssNavigationMessage) {
            C0646aa m312a;
            long currentTimeMillis;
            if (C0709g.this.f1100P != 0) {
                m312a = C0646aa.m312a();
                currentTimeMillis = C0709g.this.f1100P;
            } else {
                m312a = C0646aa.m312a();
                currentTimeMillis = System.currentTimeMillis() / 1000;
            }
            m312a.m313a(gnssNavigationMessage, currentTimeMillis);
        }

        @Override // android.location.GnssNavigationMessage.Callback
        public void onStatusChanged(int i) {
            this.f1148a = i;
        }
    }

    /* renamed from: com.baidu.location.f.g$c */
    private class c extends GnssStatus.Callback {
        private c() {
        }

        /* synthetic */ c(C0709g c0709g, C0710h c0710h) {
            this();
        }

        @Override // android.location.GnssStatus.Callback
        public void onFirstFix(int i) {
        }

        @Override // android.location.GnssStatus.Callback
        public void onSatelliteStatusChanged(GnssStatus gnssStatus) {
            ArrayList arrayList;
            if (C0709g.this.f1136g == null || gnssStatus == null) {
                return;
            }
            C0709g.this.f1103U = System.currentTimeMillis();
            int satelliteCount = gnssStatus.getSatelliteCount();
            C0709g.this.f1109ab.clear();
            C0709g.this.f1110ac.clear();
            C0709g.this.f1111ad.clear();
            C0709g.this.f1112ae.clear();
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            for (int i4 = 0; i4 < satelliteCount; i4++) {
                i3++;
                ArrayList arrayList2 = new ArrayList();
                int constellationType = gnssStatus.getConstellationType(i4);
                arrayList2.add(Float.valueOf(gnssStatus.getAzimuthDegrees(i4)));
                arrayList2.add(Float.valueOf(gnssStatus.getElevationDegrees(i4)));
                arrayList2.add(Float.valueOf(gnssStatus.getCn0DbHz(i4)));
                if (gnssStatus.usedInFix(i4)) {
                    i++;
                    arrayList2.add(Float.valueOf(1.0f));
                    if (constellationType == 1) {
                        i2++;
                    }
                } else {
                    arrayList2.add(Float.valueOf(0.0f));
                }
                arrayList2.add(Float.valueOf(gnssStatus.getSvid(i4)));
                if (constellationType == 1) {
                    arrayList2.add(Float.valueOf(1.0f));
                    arrayList = C0709g.this.f1109ab;
                } else {
                    if (constellationType == 5) {
                        arrayList2.add(Float.valueOf(2.0f));
                        C0709g.this.f1110ac.add(arrayList2);
                        C0709g.this.f1133az = System.currentTimeMillis();
                    } else if (constellationType == 3) {
                        arrayList2.add(Float.valueOf(3.0f));
                        arrayList = C0709g.this.f1111ad;
                    } else if (constellationType == 6) {
                        arrayList2.add(Float.valueOf(4.0f));
                        arrayList = C0709g.this.f1112ae;
                    }
                }
                arrayList.add(arrayList2);
            }
            ArrayList arrayList3 = new ArrayList();
            arrayList3.addAll(C0709g.this.f1109ab);
            arrayList3.addAll(C0709g.this.f1110ac);
            arrayList3.addAll(C0709g.this.f1111ad);
            arrayList3.addAll(C0709g.this.f1112ae);
            C0709g.this.m980b((ArrayList<ArrayList<Float>>) arrayList3);
            C0709g c0709g = C0709g.this;
            c0709g.f1106Y = c0709g.m965a(true, false, false, false, true, -1.0f);
            C0709g c0709g2 = C0709g.this;
            C0709g.f1076b = c0709g2.m961a((ArrayList<ArrayList<Float>>) c0709g2.f1106Y);
            C0709g c0709g3 = C0709g.this;
            c0709g3.f1107Z = c0709g3.m965a(true, true, true, true, true, -1.0f);
            C0709g c0709g4 = C0709g.this;
            c0709g4.f1108aa = c0709g4.m965a(true, true, true, true, false, -1.0f);
            C0709g c0709g5 = C0709g.this;
            C0709g.f1077c = c0709g5.m961a((ArrayList<ArrayList<Float>>) c0709g5.f1108aa);
            C0709g.f1075a = i;
            int unused = C0709g.f1081t = i2;
            int unused2 = C0709g.f1070B = i3;
            long unused3 = C0709g.f1071C = System.currentTimeMillis();
            C0709g c0709g6 = C0709g.this;
            int unused4 = C0709g.f1082u = c0709g6.m964a((ArrayList<ArrayList<Float>>) c0709g6.f1111ad, true, -1.0f).size();
            C0709g c0709g7 = C0709g.this;
            int unused5 = C0709g.f1083v = c0709g7.m964a((ArrayList<ArrayList<Float>>) c0709g7.f1112ae, true, -1.0f).size();
            C0709g c0709g8 = C0709g.this;
            int unused6 = C0709g.f1084w = c0709g8.m964a((ArrayList<ArrayList<Float>>) c0709g8.f1110ac, true, -1.0f).size();
            C0709g c0709g9 = C0709g.this;
            int unused7 = C0709g.f1085x = c0709g9.m964a((ArrayList<ArrayList<Float>>) c0709g9.f1109ab, false, -1.0f).size();
            C0709g c0709g10 = C0709g.this;
            int unused8 = C0709g.f1086y = c0709g10.m964a((ArrayList<ArrayList<Float>>) c0709g10.f1111ad, false, -1.0f).size();
            C0709g c0709g11 = C0709g.this;
            int unused9 = C0709g.f1087z = c0709g11.m964a((ArrayList<ArrayList<Float>>) c0709g11.f1112ae, false, -1.0f).size();
            C0709g c0709g12 = C0709g.this;
            int unused10 = C0709g.f1069A = c0709g12.m964a((ArrayList<ArrayList<Float>>) c0709g12.f1110ac, false, -1.0f).size();
        }

        @Override // android.location.GnssStatus.Callback
        public void onStarted() {
        }

        @Override // android.location.GnssStatus.Callback
        public void onStopped() {
            C0709g.this.m999e((Location) null);
            C0709g.this.m981b(false);
            C0709g.f1075a = 0;
            int unused = C0709g.f1081t = 0;
            int unused2 = C0709g.f1082u = 0;
            int unused3 = C0709g.f1083v = 0;
            int unused4 = C0709g.f1084w = 0;
            int unused5 = C0709g.f1085x = 0;
            int unused6 = C0709g.f1086y = 0;
            int unused7 = C0709g.f1087z = 0;
            int unused8 = C0709g.f1069A = 0;
            int unused9 = C0709g.f1070B = 0;
            int unused10 = C0709g.f1080j = -1;
            Location unused11 = C0709g.f1079i = null;
        }
    }

    /* renamed from: com.baidu.location.f.g$d */
    private class d implements GpsStatus.Listener {

        /* renamed from: b */
        private long f1152b;

        private d() {
            this.f1152b = 0L;
        }

        /* synthetic */ d(C0709g c0709g, C0710h c0710h) {
            this();
        }

        @Override // android.location.GpsStatus.Listener
        public void onGpsStatusChanged(int i) {
            long currentTimeMillis;
            ArrayList arrayList;
            if (C0709g.this.f1136g == null) {
                return;
            }
            int i2 = 0;
            if (i == 2) {
                C0709g.this.m999e((Location) null);
                C0709g.this.m981b(false);
                C0709g.f1075a = 0;
                int unused = C0709g.f1081t = 0;
                int unused2 = C0709g.f1082u = 0;
                int unused3 = C0709g.f1083v = 0;
                int unused4 = C0709g.f1084w = 0;
                return;
            }
            if (i == 4 && C0709g.this.f1090F) {
                try {
                    if (C0709g.this.f1140m == null) {
                        C0709g c0709g = C0709g.this;
                        c0709g.f1140m = c0709g.f1136g.getGpsStatus(null);
                    } else {
                        C0709g.this.f1136g.getGpsStatus(C0709g.this.f1140m);
                    }
                    C0709g.this.f1103U = System.currentTimeMillis();
                    C0709g.this.f1109ab.clear();
                    C0709g.this.f1110ac.clear();
                    C0709g.this.f1111ad.clear();
                    C0709g.this.f1112ae.clear();
                    int i3 = 0;
                    for (GpsSatellite gpsSatellite : C0709g.this.f1140m.getSatellites()) {
                        ArrayList arrayList2 = new ArrayList();
                        int prn = gpsSatellite.getPrn();
                        arrayList2.add(Float.valueOf(gpsSatellite.getAzimuth()));
                        arrayList2.add(Float.valueOf(gpsSatellite.getElevation()));
                        arrayList2.add(Float.valueOf(gpsSatellite.getSnr()));
                        if (gpsSatellite.usedInFix()) {
                            i2++;
                            arrayList2.add(Float.valueOf(1.0f));
                            if (prn >= 1 && prn <= 32) {
                                i3++;
                            }
                        } else {
                            arrayList2.add(Float.valueOf(0.0f));
                        }
                        arrayList2.add(Float.valueOf(prn));
                        if (prn >= 1 && prn <= 32) {
                            arrayList2.add(Float.valueOf(1.0f));
                            arrayList = C0709g.this.f1109ab;
                        } else if (prn >= 201 && prn <= 261) {
                            arrayList2.add(Float.valueOf(2.0f));
                            arrayList = C0709g.this.f1110ac;
                        } else if (prn >= 65 && prn <= 96) {
                            arrayList2.add(Float.valueOf(3.0f));
                            arrayList = C0709g.this.f1111ad;
                        } else if (prn >= 301 && prn <= 336) {
                            arrayList2.add(Float.valueOf(4.0f));
                            arrayList = C0709g.this.f1112ae;
                        }
                        arrayList.add(arrayList2);
                    }
                    ArrayList arrayList3 = new ArrayList();
                    arrayList3.addAll(C0709g.this.f1109ab);
                    arrayList3.addAll(C0709g.this.f1110ac);
                    arrayList3.addAll(C0709g.this.f1111ad);
                    arrayList3.addAll(C0709g.this.f1112ae);
                    C0709g.this.m980b((ArrayList<ArrayList<Float>>) arrayList3);
                    C0709g c0709g2 = C0709g.this;
                    c0709g2.f1106Y = c0709g2.m965a(true, false, false, false, true, -1.0f);
                    C0709g c0709g3 = C0709g.this;
                    C0709g.f1076b = c0709g3.m961a((ArrayList<ArrayList<Float>>) c0709g3.f1106Y);
                    C0709g c0709g4 = C0709g.this;
                    c0709g4.f1107Z = c0709g4.m965a(true, true, true, true, true, -1.0f);
                    C0709g c0709g5 = C0709g.this;
                    c0709g5.f1108aa = c0709g5.m965a(true, true, true, true, false, -1.0f);
                    C0709g c0709g6 = C0709g.this;
                    C0709g.f1077c = c0709g6.m961a((ArrayList<ArrayList<Float>>) c0709g6.f1108aa);
                    if (i3 > 0) {
                        int unused5 = C0709g.f1081t = i3;
                    }
                    if (i2 <= 0) {
                        if (System.currentTimeMillis() - this.f1152b > 100) {
                            currentTimeMillis = System.currentTimeMillis();
                        }
                        long unused6 = C0709g.f1071C = System.currentTimeMillis();
                    }
                    currentTimeMillis = System.currentTimeMillis();
                    this.f1152b = currentTimeMillis;
                    C0709g.f1075a = i2;
                    long unused62 = C0709g.f1071C = System.currentTimeMillis();
                } catch (Exception unused7) {
                }
            }
        }
    }

    /* renamed from: com.baidu.location.f.g$e */
    private static class e extends Handler {

        /* renamed from: a */
        WeakReference<C0709g> f1153a;

        /* renamed from: b */
        C0709g f1154b;

        e(C0709g c0709g) {
            this.f1153a = new WeakReference<>(c0709g);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            C0709g c0709g;
            Location location;
            String str;
            if (ServiceC0702f.isServing) {
                C0709g c0709g2 = this.f1153a.get();
                this.f1154b = c0709g2;
                if (c0709g2 == null) {
                    return;
                }
                int i = message.what;
                if (i == 1) {
                    this.f1154b.m1007g((Location) message.obj);
                    return;
                }
                if (i == 3) {
                    c0709g = this.f1154b;
                    location = (Location) message.obj;
                    str = "&og=1";
                } else if (i != 4) {
                    if (i != 5) {
                        return;
                    }
                    this.f1154b.m971a((String) message.obj);
                    return;
                } else {
                    c0709g = this.f1154b;
                    location = (Location) message.obj;
                    str = "&og=2";
                }
                c0709g.m973a(str, location);
            }
        }
    }

    /* renamed from: com.baidu.location.f.g$f */
    private class f implements LocationListener {
        private f() {
        }

        /* synthetic */ f(C0709g c0709g, C0710h c0710h) {
            this();
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(Location location) {
            if (location == null && C0733o.f1390f == 4) {
                return;
            }
            if (C0733o.m1173l()) {
                C0707e.m946a().m948a(location);
                return;
            }
            if (!C0733o.m1147a(location) && Math.abs(location.getLatitude()) <= 360.0d && Math.abs(location.getLongitude()) <= 360.0d) {
                C0709g.this.f1100P = location.getTime() / 1000;
                C0709g.this.f1119al = System.currentTimeMillis();
                if (C0709g.this.f1099O != 0) {
                    C0709g.this.f1098N = System.currentTimeMillis() - C0709g.this.f1099O;
                }
                C0709g.this.f1099O = System.currentTimeMillis();
                int i = C0709g.f1075a;
                if (i == 0) {
                    try {
                        i = location.getExtras().getInt("satellites");
                    } catch (Exception unused) {
                    }
                }
                if (i == 0 || C0662p.m509c().m537k()) {
                    System.currentTimeMillis();
                    long unused2 = C0709g.this.f1103U;
                }
                C0709g.this.m981b(true);
                C0709g.this.m999e(location);
                C0709g.this.f1089E = false;
            }
        }

        @Override // android.location.LocationListener
        public void onProviderDisabled(String str) {
            C0709g.this.m999e((Location) null);
            C0709g.this.m981b(false);
        }

        @Override // android.location.LocationListener
        public void onProviderEnabled(String str) {
        }

        @Override // android.location.LocationListener
        public void onStatusChanged(String str, int i, Bundle bundle) {
            if (i == 0) {
                C0709g.this.m999e((Location) null);
            } else if (i != 1) {
                if (i != 2) {
                    return;
                }
                C0709g.this.f1089E = false;
                return;
            } else {
                C0709g.this.f1088D = System.currentTimeMillis();
                C0709g.this.f1089E = true;
            }
            C0709g.this.m981b(false);
        }
    }

    /* renamed from: com.baidu.location.f.g$g */
    private class g implements GpsStatus.NmeaListener {
        private g() {
        }

        /* synthetic */ g(C0709g c0709g, C0710h c0710h) {
            this();
        }

        @Override // android.location.GpsStatus.NmeaListener
        public void onNmeaReceived(long j, String str) {
            if (C0709g.this.f1101R != null) {
                C0709g.this.f1101R.sendMessage(C0709g.this.f1101R.obtainMessage(5, str));
            }
        }
    }

    /* renamed from: com.baidu.location.f.g$h */
    private class h implements LocationListener {

        /* renamed from: b */
        private long f1158b;

        private h() {
            this.f1158b = 0L;
        }

        /* synthetic */ h(C0709g c0709g, C0710h c0710h) {
            this();
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(Location location) {
            if (!(C0709g.this.f1090F && C0733o.f1390f == 4) && location != null && TextUtils.equals(location.getProvider(), "gps") && System.currentTimeMillis() - this.f1158b >= Constant.DELAY_MILLIS && Math.abs(location.getLatitude()) <= 360.0d && Math.abs(location.getLongitude()) <= 360.0d && C0672z.m610a(location, false)) {
                this.f1158b = System.currentTimeMillis();
                if (C0709g.this.f1101R != null) {
                    C0709g.this.f1134d = System.currentTimeMillis();
                    C0709g.this.f1101R.sendMessage(C0709g.this.f1101R.obtainMessage(4, location));
                }
            }
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

    private C0709g() {
        this.f1142o = false;
        this.f1144q = false;
        this.f1125ar = null;
        if (Build.VERSION.SDK_INT >= 24) {
            try {
                Class.forName("android.location.GnssStatus");
                this.f1142o = true;
            } catch (ClassNotFoundException unused) {
                this.f1142o = false;
            }
        }
        if (Build.VERSION.SDK_INT >= 28) {
            try {
                this.f1125ar = Build.MANUFACTURER;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        this.f1144q = false;
    }

    /* renamed from: a */
    public static synchronized C0709g m959a() {
        C0709g c0709g;
        synchronized (C0709g.class) {
            if (f1078e == null) {
                f1078e = new C0709g();
            }
            c0709g = f1078e;
        }
        return c0709g;
    }

    /* renamed from: a */
    public static String m960a(Location location) {
        if (location == null) {
            return null;
        }
        float speed = (float) (location.getSpeed() * 3.6d);
        if (!location.hasSpeed()) {
            speed = -1.0f;
        }
        int accuracy = (int) (location.hasAccuracy() ? location.getAccuracy() : -1.0f);
        double altitude = location.hasAltitude() ? location.getAltitude() : 555.0d;
        float bearing = location.hasBearing() ? location.getBearing() : -1.0f;
        String format = f1074V < -0.01f ? String.format(Locale.CHINA, "&ll=%.5f|%.5f&s=%.1f&d=%.1f&ll_r=%d&ll_n=%d&ll_h=%.2f&ll_t=%d&ll_sn=%d|%d|%d|%d|%d&ll_asn=%d|%d|%d|%d|%d&ll_snr=%.1f", Double.valueOf(location.getLongitude()), Double.valueOf(location.getLatitude()), Float.valueOf(speed), Float.valueOf(bearing), Integer.valueOf(accuracy), Integer.valueOf(f1075a), Double.valueOf(altitude), Long.valueOf(location.getTime() / 1000), Integer.valueOf(f1075a), Integer.valueOf(f1081t), Integer.valueOf(f1082u), Integer.valueOf(f1083v), Integer.valueOf(f1084w), Integer.valueOf(f1070B), Integer.valueOf(f1085x), Integer.valueOf(f1086y), Integer.valueOf(f1087z), Integer.valueOf(f1069A), Double.valueOf(f1073S)) : String.format(Locale.CHINA, "&ll=%.5f|%.5f&s=%.1f&d=%.1f&ll_r=%d&ll_n=%d&ll_h=%.2f&ll_t=%d&ll_sn=%d|%d|%d|%d|%d&ll_asn=%d|%d|%d|%d|%d&ll_snr=%.1f&ll_bp=%.2f", Double.valueOf(location.getLongitude()), Double.valueOf(location.getLatitude()), Float.valueOf(speed), Float.valueOf(bearing), Integer.valueOf(accuracy), Integer.valueOf(f1075a), Double.valueOf(altitude), Long.valueOf(location.getTime() / 1000), Integer.valueOf(f1075a), Integer.valueOf(f1081t), Integer.valueOf(f1082u), Integer.valueOf(f1083v), Integer.valueOf(f1084w), Integer.valueOf(f1070B), Integer.valueOf(f1085x), Integer.valueOf(f1086y), Integer.valueOf(f1087z), Integer.valueOf(f1069A), Double.valueOf(f1073S), Float.valueOf(f1074V));
        try {
            return ((f1080j != 2 || f1079i == null) ? new StringBuilder().append(format).append("&ll_fake=").append(f1080j) : new StringBuilder().append(format).append(String.format(Locale.CHINA, "&ll_fake=%d|%.5f|%.5f|%d", Integer.valueOf(f1080j), Double.valueOf(f1079i.getLongitude()), Double.valueOf(f1079i.getLatitude()), Long.valueOf(f1079i.getTime() / 1000)))).toString();
        } catch (Exception e2) {
            e2.printStackTrace();
            return format;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public String m961a(ArrayList<ArrayList<Float>> arrayList) {
        StringBuilder sb = new StringBuilder();
        if (arrayList.size() == 0) {
            return sb.toString();
        }
        Iterator<ArrayList<Float>> it = arrayList.iterator();
        boolean z = true;
        while (it.hasNext()) {
            ArrayList<Float> next = it.next();
            if (next.size() == 6) {
                if (z) {
                    z = false;
                } else {
                    sb.append("|");
                }
                sb.append(String.format("%.1f;", next.get(0)));
                sb.append(String.format("%.1f;", next.get(1)));
                sb.append(String.format("%.1f;", next.get(2)));
                sb.append(String.format("%.0f;", next.get(3)));
                sb.append(String.format("%.0f;", next.get(4)));
                sb.append(String.format("%.0f", next.get(5)));
            }
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public ArrayList<ArrayList<Float>> m964a(ArrayList<ArrayList<Float>> arrayList, boolean z, float f2) {
        ArrayList<ArrayList<Float>> arrayList2 = new ArrayList<>();
        if (arrayList.size() <= 40 && arrayList.size() != 0) {
            Iterator<ArrayList<Float>> it = arrayList.iterator();
            while (it.hasNext()) {
                ArrayList<Float> next = it.next();
                if (next.size() == 6) {
                    float floatValue = next.get(3).floatValue();
                    float floatValue2 = next.get(2).floatValue();
                    if (!z || floatValue >= 1.0f) {
                        if (f2 <= 0.0f || floatValue2 >= f2) {
                            arrayList2.add(next);
                        }
                    }
                }
            }
        }
        return arrayList2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public ArrayList<ArrayList<Float>> m965a(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, float f2) {
        ArrayList<ArrayList<Float>> arrayList = new ArrayList<>();
        if (z) {
            arrayList.addAll(m964a(this.f1109ab, z5, f2));
        }
        if (z2) {
            arrayList.addAll(m964a(this.f1110ac, z5, f2));
        }
        if (z3) {
            arrayList.addAll(m964a(this.f1111ad, z5, f2));
        }
        if (z4) {
            arrayList.addAll(m964a(this.f1112ae, z5, f2));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m971a(String str) {
        if (TextUtils.isEmpty(str) || !m984b(str)) {
            return;
        }
        if (str.startsWith("$GPGGA,")) {
            m972a(str, 2, 4, 6);
        } else if (str.startsWith("$GPRMC,")) {
            m972a(str, 3, 5, 2);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x00e9, code lost:
    
        if (android.text.TextUtils.equals(r0[r14], "A") != false) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00f9, code lost:
    
        r10.f1122ao = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00f6, code lost:
    
        if (android.text.TextUtils.equals(r0[r14], com.google.android.exoplayer2.source.rtsp.SessionDescription.SUPPORTED_SDP_VERSION) != false) goto L43;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m972a(java.lang.String r11, int r12, int r13, int r14) {
        /*
            Method dump skipped, instructions count: 264
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.p010f.C0709g.m972a(java.lang.String, int, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m973a(String str, Location location) {
        if (location == null) {
            return;
        }
        String str2 = str + C0648b.m321a().m339d();
        boolean m1072f = C0715m.m1058a().m1072f();
        C0668v.m582a(new C0703a(C0704b.m912a().m940f()));
        C0668v.m580a(System.currentTimeMillis());
        C0668v.m581a(new Location(location));
        C0668v.m583a(str2);
        C0668v.m585b(C0649c.m358a().m369c());
        if (m1072f) {
            return;
        }
        C0672z.m605a(C0668v.m586c(), (C0714l) null, C0668v.m587d(), str2, C0668v.m588e());
    }

    /* renamed from: a */
    public static boolean m974a(Location location, Location location2, boolean z) {
        if (location == location2) {
            return false;
        }
        if (location == null || location2 == null) {
            return true;
        }
        float speed = location2.getSpeed();
        if (z && ((C0733o.f1405u == 3 || !C0724f.m1123a().m1125a(location2.getLongitude(), location2.getLatitude())) && speed < 5.0f)) {
            return true;
        }
        float distanceTo = location2.distanceTo(location);
        return speed > C0733o.f1324K ? distanceTo > C0733o.f1326M : speed > C0733o.f1323J ? distanceTo > C0733o.f1325L : distanceTo > 5.0f;
    }

    /* renamed from: b */
    public static String m977b(Location location) {
        String m960a = m960a(location);
        return m960a != null ? m960a + "&g_tp=0" : m960a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m980b(ArrayList<ArrayList<Float>> arrayList) {
        String str;
        if (arrayList == null || arrayList.size() <= 0) {
            str = null;
        } else {
            StringBuilder sb = new StringBuilder(100);
            ArrayList arrayList2 = new ArrayList();
            arrayList2.addAll(this.f1109ab);
            sb.append(C0721c.m1114g(arrayList2)).append("|").append(C0721c.m1113f(arrayList2)).append("|").append(C0721c.m1108a(arrayList2)).append("|").append(C0721c.m1115h(arrayList2)).append("|").append(C0721c.m1109b(arrayList2)).append("|").append(C0721c.m1110c(arrayList2)).append("|").append(C0721c.m1112e(arrayList2)).append("|").append(C0721c.m1111d(arrayList2));
            str = sb.toString();
        }
        this.f1113af = str;
        this.f1114ag = System.currentTimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m981b(boolean z) {
        this.f1092H = z;
        f1074V = -1.0f;
    }

    /* renamed from: b */
    private boolean m984b(String str) {
        int i;
        if (str.indexOf(WebSocketServerHandshaker.SUB_PROTOCOL_WILDCARD) != -1 && str.indexOf("$") != -1 && str.indexOf("$") <= str.indexOf(WebSocketServerHandshaker.SUB_PROTOCOL_WILDCARD) && str.length() >= str.indexOf(WebSocketServerHandshaker.SUB_PROTOCOL_WILDCARD)) {
            byte[] bytes = str.substring(0, str.indexOf(WebSocketServerHandshaker.SUB_PROTOCOL_WILDCARD)).getBytes();
            int i2 = bytes[1];
            for (int i3 = 2; i3 < bytes.length; i3++) {
                i2 ^= bytes[i3];
            }
            String format = String.format("%02x", Integer.valueOf(i2));
            int indexOf = str.indexOf(WebSocketServerHandshaker.SUB_PROTOCOL_WILDCARD);
            if (indexOf != -1 && str.length() >= (i = indexOf + 3) && format.equalsIgnoreCase(str.substring(indexOf + 1, i))) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: c */
    public static String m988c(Location location) {
        String m960a = m960a(location);
        return m960a != null ? m960a + f1072Q : m960a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m999e(Location location) {
        if (this.f1101R == null || System.currentTimeMillis() - this.f1126as <= 3000) {
            return;
        }
        this.f1101R.sendMessage(this.f1101R.obtainMessage(1, location));
    }

    /* renamed from: f */
    private int m1001f(Location location) {
        if (location == null) {
            return 0;
        }
        if (Build.VERSION.SDK_INT > 17 && location.isFromMockProvider()) {
            return 100;
        }
        if (Math.abs(this.f1119al - this.f1120am) >= 3000) {
            this.f1120am = -1L;
            this.f1123ap = false;
            this.f1122ao = false;
            this.f1121an = null;
        } else if (this.f1121an == null) {
            if (!this.f1122ao) {
                return 200;
            }
            if (this.f1123ap) {
                return 300;
            }
        } else if (!this.f1123ap && this.f1122ao) {
            return NNTPReply.SERVICE_DISCONTINUED;
        }
        if (this.f1119al > 0) {
            if (this.f1120am == -1) {
                return 500;
            }
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x015a, code lost:
    
        r0.setGnssProvider(com.baidu.location.BDLocation.BDLOCATION_GNSS_PROVIDER_FROM_BAIDU_BEIDOU);
     */
    /* renamed from: g */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m1007g(android.location.Location r14) {
        /*
            Method dump skipped, instructions count: 471
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.p010f.C0709g.m1007g(android.location.Location):void");
    }

    /* renamed from: l */
    public static String m1016l() {
        long currentTimeMillis = System.currentTimeMillis() - f1071C;
        if (currentTimeMillis < 0 || currentTimeMillis >= 3000) {
            return null;
        }
        return String.format(Locale.US, "&gsvn=%d&gsfn=%d", Integer.valueOf(f1070B), Integer.valueOf(f1075a));
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x000f, code lost:
    
        if (r3 == 1) goto L5;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m1019a(int r3) {
        /*
            r2 = this;
            r0 = 0
            if (r3 != 0) goto L8
            r2.f1129av = r0
        L5:
            r2.f1128au = r0
            goto L12
        L8:
            r1 = 2
            if (r3 != r1) goto Le
            r2.f1129av = r0
            goto L12
        Le:
            r1 = 1
            if (r3 != r1) goto L12
            goto L5
        L12:
            boolean r3 = r2.f1128au
            if (r3 != 0) goto L34
            boolean r3 = r2.f1129av
            if (r3 == 0) goto L1b
            goto L34
        L1b:
            boolean r3 = r2.f1142o
            if (r3 == 0) goto L34
            com.baidu.location.f.g$a r3 = r2.f1104W
            if (r3 == 0) goto L34
            android.location.LocationManager r1 = r2.f1136g
            if (r1 == 0) goto L34
            r1.unregisterGnssMeasurementsCallback(r3)     // Catch: java.lang.Exception -> L2b
            goto L2f
        L2b:
            r3 = move-exception
            r3.printStackTrace()
        L2f:
            r3 = 0
            r2.f1104W = r3
            r2.f1127at = r0
        L34:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.p010f.C0709g.m1019a(int):void");
    }

    /* renamed from: a */
    public void m1020a(BDLocation bDLocation) {
        if (C0733o.f1396l || m1001f(this.f1137h) <= 0) {
            C0648b.m321a().m340d(bDLocation);
        } else {
            C0648b.m321a().m336c(bDLocation);
        }
    }

    /* renamed from: a */
    public void m1021a(boolean z) {
        if (z) {
            m1023c();
        } else {
            m1024d();
        }
    }

    /* renamed from: b */
    public synchronized void m1022b() {
        if (ServiceC0702f.isServing) {
            Context serviceContext = ServiceC0702f.getServiceContext();
            this.f1135f = serviceContext;
            try {
                this.f1136g = (LocationManager) serviceContext.getSystemService("location");
            } catch (Exception unused) {
            }
            this.f1101R = new e(this);
        }
    }

    /* renamed from: c */
    public void m1023c() {
        if (this.f1090F) {
            return;
        }
        C0710h c0710h = null;
        try {
            if (!this.f1142o) {
                d dVar = new d(this, c0710h);
                this.f1143p = dVar;
                this.f1136g.addGpsStatusListener(dVar);
            } else if (C0733o.m1135a(this.f1135f, Permission.ACCESS_FINE_LOCATION) == 1) {
                c cVar = new c(this, c0710h);
                this.f1141n = cVar;
                this.f1136g.registerGnssStatusCallback(cVar);
            }
            h hVar = new h(this, c0710h);
            this.f1139l = hVar;
            this.f1136g.requestLocationUpdates("passive", 9000L, 0.0f, hVar);
        } catch (Exception unused) {
        }
        try {
            this.f1138k = new f(this, c0710h);
            try {
                this.f1136g.sendExtraCommand("gps", "force_xtra_injection", new Bundle());
            } catch (Exception unused2) {
            }
            this.f1136g.requestLocationUpdates("gps", 1000L, 0.0f, this.f1138k);
            if (this.f1142o && this.f1105X == null && C0733o.f1342aB == 1 && new Random().nextDouble() < C0733o.f1341aA) {
                this.f1105X = new b(this, c0710h);
            }
            b bVar = this.f1105X;
            if (bVar != null) {
                this.f1136g.registerGnssNavigationMessageCallback(bVar);
            }
            this.f1102T = System.currentTimeMillis();
            if (!C0733o.f1396l && C0733o.f1357aQ == 1) {
                if (Build.VERSION.SDK_INT >= 24) {
                    C0710h c0710h2 = new C0710h(this);
                    this.f1146s = c0710h2;
                    this.f1136g.addNmeaListener(c0710h2);
                } else {
                    this.f1145r = new g(this, c0710h);
                    Class.forName("android.location.LocationManager").getMethod("addNmeaListener", GpsStatus.NmeaListener.class).invoke(this.f1136g, this.f1145r);
                }
            }
            this.f1090F = true;
        } catch (Exception unused3) {
        }
    }

    /* renamed from: d */
    public void m1024d() {
        c cVar;
        if (this.f1090F) {
            LocationManager locationManager = this.f1136g;
            if (locationManager != null) {
                try {
                    d dVar = this.f1143p;
                    if (dVar != null) {
                        locationManager.removeGpsStatusListener(dVar);
                        this.f1143p = null;
                    }
                    if (this.f1142o && (cVar = this.f1141n) != null) {
                        this.f1136g.unregisterGnssStatusCallback(cVar);
                        this.f1141n = null;
                    }
                    h hVar = this.f1139l;
                    if (hVar != null) {
                        this.f1136g.removeUpdates(hVar);
                        this.f1139l = null;
                    }
                } catch (Exception unused) {
                }
                try {
                    f fVar = this.f1138k;
                    if (fVar != null) {
                        this.f1136g.removeUpdates(fVar);
                    }
                    OnNmeaMessageListener onNmeaMessageListener = this.f1146s;
                    if (onNmeaMessageListener != null) {
                        this.f1136g.removeNmeaListener(onNmeaMessageListener);
                    }
                    if (this.f1145r != null) {
                        Class.forName("android.location.LocationManager").getMethod("removeNmeaListener", GpsStatus.NmeaListener.class).invoke(this.f1136g, this.f1145r);
                    }
                    b bVar = this.f1105X;
                    if (bVar != null) {
                        this.f1136g.unregisterGnssNavigationMessageCallback(bVar);
                    }
                    m1019a(0);
                } catch (Exception unused2) {
                }
            }
            C0733o.f1388d = 0;
            C0733o.f1405u = 0;
            this.f1138k = null;
            this.f1090F = false;
            m981b(false);
        }
    }

    /* renamed from: e */
    public synchronized void m1025e() {
        m1024d();
        if (this.f1136g == null) {
            return;
        }
        try {
            e eVar = this.f1101R;
            if (eVar != null) {
                eVar.removeCallbacksAndMessages(null);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.f1136g = null;
    }

    /* renamed from: f */
    public String m1026f() {
        Location location;
        if (!m1031k() || (location = this.f1137h) == null) {
            return null;
        }
        return String.format("%s&idgps_tp=%s", m960a(location).replaceAll("ll", "idll").replaceAll("&d=", "&idd=").replaceAll("&s", "&ids="), this.f1137h.getProvider());
    }

    /* renamed from: g */
    public String m1027g() {
        boolean z;
        StringBuilder append;
        String str;
        if (this.f1137h == null) {
            return null;
        }
        String str2 = "{\"result\":{\"time\":\"" + C0733o.m1138a() + "\",\"error\":\"61\"},\"content\":{\"point\":{\"x\":\"%f\",\"y\":\"%f\"},\"radius\":\"%d\",\"d\":\"%f\",\"s\":\"%f\",\"n\":\"%d\"";
        int accuracy = (int) (this.f1137h.hasAccuracy() ? this.f1137h.getAccuracy() : 10.0f);
        float speed = (float) (this.f1137h.getSpeed() * 3.6d);
        if (!this.f1137h.hasSpeed()) {
            speed = -1.0f;
        }
        double[] dArr = new double[2];
        if (C0724f.m1123a().m1125a(this.f1137h.getLongitude(), this.f1137h.getLatitude())) {
            dArr = Jni.coorEncrypt(this.f1137h.getLongitude(), this.f1137h.getLatitude(), BDLocation.BDLOCATION_WGS84_TO_GCJ02);
            if (dArr[0] <= 0.0d && dArr[1] <= 0.0d) {
                dArr[0] = this.f1137h.getLongitude();
                dArr[1] = this.f1137h.getLatitude();
            }
            z = true;
        } else {
            dArr[0] = this.f1137h.getLongitude();
            dArr[1] = this.f1137h.getLatitude();
            if (dArr[0] <= 0.0d && dArr[1] <= 0.0d) {
                dArr[0] = this.f1137h.getLongitude();
                dArr[1] = this.f1137h.getLatitude();
            }
            z = false;
        }
        String format = String.format(Locale.CHINA, str2, Double.valueOf(dArr[0]), Double.valueOf(dArr[1]), Integer.valueOf(accuracy), Float.valueOf(this.f1137h.getBearing()), Float.valueOf(speed), Integer.valueOf(f1075a));
        if (!z) {
            format = format + ",\"in_cn\":\"0\"";
        }
        if (!C0733o.f1396l) {
            format = format + String.format(Locale.CHINA, ",\"is_mock\":%d", Integer.valueOf(m1001f(this.f1137h)));
        }
        if (this.f1137h.hasAltitude()) {
            append = new StringBuilder().append(format);
            str = String.format(Locale.CHINA, ",\"h\":%.2f}}", Double.valueOf(this.f1137h.getAltitude()));
        } else {
            append = new StringBuilder().append(format);
            str = "}}";
        }
        return append.append(str).toString();
    }

    /* renamed from: h */
    public Location m1028h() {
        if (this.f1137h != null && Math.abs(System.currentTimeMillis() - this.f1137h.getTime()) <= 60000) {
            return this.f1137h;
        }
        return null;
    }

    /* renamed from: i */
    public BDLocation m1029i() {
        if (this.f1121an != null && Math.abs(System.currentTimeMillis() - this.f1120am) <= 3000) {
            return this.f1121an;
        }
        return null;
    }

    /* renamed from: j */
    public boolean m1030j() {
        try {
            System.currentTimeMillis();
            if (f1075a == 0) {
                try {
                    this.f1137h.getExtras().getInt("satellites");
                } catch (Exception unused) {
                }
            }
            Location location = this.f1137h;
            if (location != null && location.getLatitude() != 0.0d) {
                if (this.f1137h.getLongitude() != 0.0d) {
                    return true;
                }
            }
            return false;
        } catch (Exception unused2) {
            Location location2 = this.f1137h;
            return (location2 == null || location2.getLatitude() == 0.0d || this.f1137h.getLongitude() == 0.0d) ? false : true;
        }
    }

    /* renamed from: k */
    public boolean m1031k() {
        if (!m1030j() || C0733o.m1173l() || System.currentTimeMillis() - this.f1093I > Constant.DELAY_MILLIS) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (!this.f1089E || currentTimeMillis - this.f1088D >= 3000) {
            return this.f1092H;
        }
        return true;
    }

    /* renamed from: m */
    public synchronized String m1032m() {
        String str;
        str = "-2";
        try {
            if (Math.abs(System.currentTimeMillis() - this.f1114ag) < 3000) {
                String str2 = this.f1113af;
                str = str2 == null ? SessionDescription.SUPPORTED_SDP_VERSION : str2;
            } else {
                str = "-1";
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return "&gnsf=" + str;
    }
}