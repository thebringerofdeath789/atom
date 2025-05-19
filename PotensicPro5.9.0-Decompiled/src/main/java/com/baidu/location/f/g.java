package com.baidu.location.f;

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
import com.baidu.location.b.aa;
import com.baidu.location.b.p;
import com.baidu.location.b.v;
import com.baidu.location.b.z;
import com.baidu.location.h.o;
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

/* loaded from: classes.dex */
public class g {
    private static int A = 0;
    private static int B = 0;
    private static long C = 0;
    private static String Q = null;
    private static double S = 100.0d;
    private static float V = -1.0f;
    public static int a = 0;
    public static String b = "";
    public static String c = "";
    private static g e = null;
    private static Location i = null;
    private static int j = -1;
    private static int t;
    private static int u;
    private static int v;
    private static int w;
    private static int x;
    private static int y;
    private static int z;
    private BDLocation an;
    private String ar;
    private Context f;
    private Location h;
    private GpsStatus m;
    private c n;
    private boolean o;
    private boolean q;
    private LocationManager g = null;
    private f k = null;
    private h l = null;
    private d p = null;
    private GpsStatus.NmeaListener r = null;
    private OnNmeaMessageListener s = null;
    private long D = 0;
    private boolean E = false;
    private boolean F = false;
    private String G = null;
    private boolean H = false;
    private long I = 0;
    private long J = 0;
    private double K = -1.0d;
    private double L = 0.0d;
    private double M = 0.0d;
    private long N = 0;
    private long O = 0;
    private long P = 0;
    private e R = null;
    private long T = 0;
    private long U = 0;
    private a W = null;
    private b X = null;
    private ArrayList<ArrayList<Float>> Y = new ArrayList<>();
    private ArrayList<ArrayList<Float>> Z = new ArrayList<>();
    private ArrayList<ArrayList<Float>> aa = new ArrayList<>();
    private ArrayList<ArrayList<Float>> ab = new ArrayList<>();
    private ArrayList<ArrayList<Float>> ac = new ArrayList<>();
    private ArrayList<ArrayList<Float>> ad = new ArrayList<>();
    private ArrayList<ArrayList<Float>> ae = new ArrayList<>();
    private String af = null;
    private long ag = 0;
    private ArrayList<Integer> ah = new ArrayList<>();
    private String ai = null;
    private String aj = null;
    private long ak = 0;
    private long al = -1;
    private long am = -1;
    private boolean ao = false;
    private boolean ap = false;
    private long aq = 0;
    private long as = 0;
    private boolean at = false;
    private boolean au = false;
    private boolean av = false;
    private StringBuilder aw = new StringBuilder();
    private String ax = "";
    private long ay = -1;
    private long az = 0;
    public long d = 0;

    private class a extends GnssMeasurementsEvent.Callback {
        public int a;

        @Override // android.location.GnssMeasurementsEvent.Callback
        public void onGnssMeasurementsReceived(GnssMeasurementsEvent gnssMeasurementsEvent) {
        }

        @Override // android.location.GnssMeasurementsEvent.Callback
        public void onStatusChanged(int i) {
            this.a = i;
        }
    }

    private class b extends GnssNavigationMessage.Callback {
        public int a;

        private b() {
            this.a = 0;
        }

        /* synthetic */ b(g gVar, com.baidu.location.f.h hVar) {
            this();
        }

        @Override // android.location.GnssNavigationMessage.Callback
        public void onGnssNavigationMessageReceived(GnssNavigationMessage gnssNavigationMessage) {
            aa a;
            long currentTimeMillis;
            if (g.this.P != 0) {
                a = aa.a();
                currentTimeMillis = g.this.P;
            } else {
                a = aa.a();
                currentTimeMillis = System.currentTimeMillis() / 1000;
            }
            a.a(gnssNavigationMessage, currentTimeMillis);
        }

        @Override // android.location.GnssNavigationMessage.Callback
        public void onStatusChanged(int i) {
            this.a = i;
        }
    }

    private class c extends GnssStatus.Callback {
        private c() {
        }

        /* synthetic */ c(g gVar, com.baidu.location.f.h hVar) {
            this();
        }

        @Override // android.location.GnssStatus.Callback
        public void onFirstFix(int i) {
        }

        @Override // android.location.GnssStatus.Callback
        public void onSatelliteStatusChanged(GnssStatus gnssStatus) {
            ArrayList arrayList;
            if (g.this.g == null || gnssStatus == null) {
                return;
            }
            g.this.U = System.currentTimeMillis();
            int satelliteCount = gnssStatus.getSatelliteCount();
            g.this.ab.clear();
            g.this.ac.clear();
            g.this.ad.clear();
            g.this.ae.clear();
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
                    arrayList = g.this.ab;
                } else {
                    if (constellationType == 5) {
                        arrayList2.add(Float.valueOf(2.0f));
                        g.this.ac.add(arrayList2);
                        g.this.az = System.currentTimeMillis();
                    } else if (constellationType == 3) {
                        arrayList2.add(Float.valueOf(3.0f));
                        arrayList = g.this.ad;
                    } else if (constellationType == 6) {
                        arrayList2.add(Float.valueOf(4.0f));
                        arrayList = g.this.ae;
                    }
                }
                arrayList.add(arrayList2);
            }
            ArrayList arrayList3 = new ArrayList();
            arrayList3.addAll(g.this.ab);
            arrayList3.addAll(g.this.ac);
            arrayList3.addAll(g.this.ad);
            arrayList3.addAll(g.this.ae);
            g.this.b((ArrayList<ArrayList<Float>>) arrayList3);
            g gVar = g.this;
            gVar.Y = gVar.a(true, false, false, false, true, -1.0f);
            g gVar2 = g.this;
            g.b = gVar2.a((ArrayList<ArrayList<Float>>) gVar2.Y);
            g gVar3 = g.this;
            gVar3.Z = gVar3.a(true, true, true, true, true, -1.0f);
            g gVar4 = g.this;
            gVar4.aa = gVar4.a(true, true, true, true, false, -1.0f);
            g gVar5 = g.this;
            g.c = gVar5.a((ArrayList<ArrayList<Float>>) gVar5.aa);
            g.a = i;
            int unused = g.t = i2;
            int unused2 = g.B = i3;
            long unused3 = g.C = System.currentTimeMillis();
            g gVar6 = g.this;
            int unused4 = g.u = gVar6.a((ArrayList<ArrayList<Float>>) gVar6.ad, true, -1.0f).size();
            g gVar7 = g.this;
            int unused5 = g.v = gVar7.a((ArrayList<ArrayList<Float>>) gVar7.ae, true, -1.0f).size();
            g gVar8 = g.this;
            int unused6 = g.w = gVar8.a((ArrayList<ArrayList<Float>>) gVar8.ac, true, -1.0f).size();
            g gVar9 = g.this;
            int unused7 = g.x = gVar9.a((ArrayList<ArrayList<Float>>) gVar9.ab, false, -1.0f).size();
            g gVar10 = g.this;
            int unused8 = g.y = gVar10.a((ArrayList<ArrayList<Float>>) gVar10.ad, false, -1.0f).size();
            g gVar11 = g.this;
            int unused9 = g.z = gVar11.a((ArrayList<ArrayList<Float>>) gVar11.ae, false, -1.0f).size();
            g gVar12 = g.this;
            int unused10 = g.A = gVar12.a((ArrayList<ArrayList<Float>>) gVar12.ac, false, -1.0f).size();
        }

        @Override // android.location.GnssStatus.Callback
        public void onStarted() {
        }

        @Override // android.location.GnssStatus.Callback
        public void onStopped() {
            g.this.e((Location) null);
            g.this.b(false);
            g.a = 0;
            int unused = g.t = 0;
            int unused2 = g.u = 0;
            int unused3 = g.v = 0;
            int unused4 = g.w = 0;
            int unused5 = g.x = 0;
            int unused6 = g.y = 0;
            int unused7 = g.z = 0;
            int unused8 = g.A = 0;
            int unused9 = g.B = 0;
            int unused10 = g.j = -1;
            Location unused11 = g.i = null;
        }
    }

    private class d implements GpsStatus.Listener {
        private long b;

        private d() {
            this.b = 0L;
        }

        /* synthetic */ d(g gVar, com.baidu.location.f.h hVar) {
            this();
        }

        @Override // android.location.GpsStatus.Listener
        public void onGpsStatusChanged(int i) {
            long currentTimeMillis;
            ArrayList arrayList;
            if (g.this.g == null) {
                return;
            }
            int i2 = 0;
            if (i == 2) {
                g.this.e((Location) null);
                g.this.b(false);
                g.a = 0;
                int unused = g.t = 0;
                int unused2 = g.u = 0;
                int unused3 = g.v = 0;
                int unused4 = g.w = 0;
                return;
            }
            if (i == 4 && g.this.F) {
                try {
                    if (g.this.m == null) {
                        g gVar = g.this;
                        gVar.m = gVar.g.getGpsStatus(null);
                    } else {
                        g.this.g.getGpsStatus(g.this.m);
                    }
                    g.this.U = System.currentTimeMillis();
                    g.this.ab.clear();
                    g.this.ac.clear();
                    g.this.ad.clear();
                    g.this.ae.clear();
                    int i3 = 0;
                    for (GpsSatellite gpsSatellite : g.this.m.getSatellites()) {
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
                            arrayList = g.this.ab;
                        } else if (prn >= 201 && prn <= 261) {
                            arrayList2.add(Float.valueOf(2.0f));
                            arrayList = g.this.ac;
                        } else if (prn >= 65 && prn <= 96) {
                            arrayList2.add(Float.valueOf(3.0f));
                            arrayList = g.this.ad;
                        } else if (prn >= 301 && prn <= 336) {
                            arrayList2.add(Float.valueOf(4.0f));
                            arrayList = g.this.ae;
                        }
                        arrayList.add(arrayList2);
                    }
                    ArrayList arrayList3 = new ArrayList();
                    arrayList3.addAll(g.this.ab);
                    arrayList3.addAll(g.this.ac);
                    arrayList3.addAll(g.this.ad);
                    arrayList3.addAll(g.this.ae);
                    g.this.b((ArrayList<ArrayList<Float>>) arrayList3);
                    g gVar2 = g.this;
                    gVar2.Y = gVar2.a(true, false, false, false, true, -1.0f);
                    g gVar3 = g.this;
                    g.b = gVar3.a((ArrayList<ArrayList<Float>>) gVar3.Y);
                    g gVar4 = g.this;
                    gVar4.Z = gVar4.a(true, true, true, true, true, -1.0f);
                    g gVar5 = g.this;
                    gVar5.aa = gVar5.a(true, true, true, true, false, -1.0f);
                    g gVar6 = g.this;
                    g.c = gVar6.a((ArrayList<ArrayList<Float>>) gVar6.aa);
                    if (i3 > 0) {
                        int unused5 = g.t = i3;
                    }
                    if (i2 <= 0) {
                        if (System.currentTimeMillis() - this.b > 100) {
                            currentTimeMillis = System.currentTimeMillis();
                        }
                        long unused6 = g.C = System.currentTimeMillis();
                    }
                    currentTimeMillis = System.currentTimeMillis();
                    this.b = currentTimeMillis;
                    g.a = i2;
                    long unused62 = g.C = System.currentTimeMillis();
                } catch (Exception unused7) {
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class e extends Handler {
        WeakReference<g> a;
        g b;

        e(g gVar) {
            this.a = new WeakReference<>(gVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            g gVar;
            Location location;
            String str;
            if (com.baidu.location.f.isServing) {
                g gVar2 = this.a.get();
                this.b = gVar2;
                if (gVar2 == null) {
                    return;
                }
                int i = message.what;
                if (i == 1) {
                    this.b.g((Location) message.obj);
                    return;
                }
                if (i == 3) {
                    gVar = this.b;
                    location = (Location) message.obj;
                    str = "&og=1";
                } else if (i != 4) {
                    if (i != 5) {
                        return;
                    }
                    this.b.a((String) message.obj);
                    return;
                } else {
                    gVar = this.b;
                    location = (Location) message.obj;
                    str = "&og=2";
                }
                gVar.a(str, location);
            }
        }
    }

    private class f implements LocationListener {
        private f() {
        }

        /* synthetic */ f(g gVar, com.baidu.location.f.h hVar) {
            this();
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(Location location) {
            if (location == null && o.f == 4) {
                return;
            }
            if (o.l()) {
                com.baidu.location.f.e.a().a(location);
                return;
            }
            if (!o.a(location) && Math.abs(location.getLatitude()) <= 360.0d && Math.abs(location.getLongitude()) <= 360.0d) {
                g.this.P = location.getTime() / 1000;
                g.this.al = System.currentTimeMillis();
                if (g.this.O != 0) {
                    g.this.N = System.currentTimeMillis() - g.this.O;
                }
                g.this.O = System.currentTimeMillis();
                int i = g.a;
                if (i == 0) {
                    try {
                        i = location.getExtras().getInt("satellites");
                    } catch (Exception unused) {
                    }
                }
                if (i == 0 || p.c().k()) {
                    System.currentTimeMillis();
                    long unused2 = g.this.U;
                }
                g.this.b(true);
                g.this.e(location);
                g.this.E = false;
            }
        }

        @Override // android.location.LocationListener
        public void onProviderDisabled(String str) {
            g.this.e((Location) null);
            g.this.b(false);
        }

        @Override // android.location.LocationListener
        public void onProviderEnabled(String str) {
        }

        @Override // android.location.LocationListener
        public void onStatusChanged(String str, int i, Bundle bundle) {
            if (i == 0) {
                g.this.e((Location) null);
            } else if (i != 1) {
                if (i != 2) {
                    return;
                }
                g.this.E = false;
                return;
            } else {
                g.this.D = System.currentTimeMillis();
                g.this.E = true;
            }
            g.this.b(false);
        }
    }

    /* renamed from: com.baidu.location.f.g$g, reason: collision with other inner class name */
    private class C0012g implements GpsStatus.NmeaListener {
        private C0012g() {
        }

        /* synthetic */ C0012g(g gVar, com.baidu.location.f.h hVar) {
            this();
        }

        @Override // android.location.GpsStatus.NmeaListener
        public void onNmeaReceived(long j, String str) {
            if (g.this.R != null) {
                g.this.R.sendMessage(g.this.R.obtainMessage(5, str));
            }
        }
    }

    private class h implements LocationListener {
        private long b;

        private h() {
            this.b = 0L;
        }

        /* synthetic */ h(g gVar, com.baidu.location.f.h hVar) {
            this();
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(Location location) {
            if (!(g.this.F && o.f == 4) && location != null && TextUtils.equals(location.getProvider(), "gps") && System.currentTimeMillis() - this.b >= Constant.DELAY_MILLIS && Math.abs(location.getLatitude()) <= 360.0d && Math.abs(location.getLongitude()) <= 360.0d && z.a(location, false)) {
                this.b = System.currentTimeMillis();
                if (g.this.R != null) {
                    g.this.d = System.currentTimeMillis();
                    g.this.R.sendMessage(g.this.R.obtainMessage(4, location));
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

    private g() {
        this.o = false;
        this.q = false;
        this.ar = null;
        if (Build.VERSION.SDK_INT >= 24) {
            try {
                Class.forName("android.location.GnssStatus");
                this.o = true;
            } catch (ClassNotFoundException unused) {
                this.o = false;
            }
        }
        if (Build.VERSION.SDK_INT >= 28) {
            try {
                this.ar = Build.MANUFACTURER;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        this.q = false;
    }

    public static synchronized g a() {
        g gVar;
        synchronized (g.class) {
            if (e == null) {
                e = new g();
            }
            gVar = e;
        }
        return gVar;
    }

    public static String a(Location location) {
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
        String format = V < -0.01f ? String.format(Locale.CHINA, "&ll=%.5f|%.5f&s=%.1f&d=%.1f&ll_r=%d&ll_n=%d&ll_h=%.2f&ll_t=%d&ll_sn=%d|%d|%d|%d|%d&ll_asn=%d|%d|%d|%d|%d&ll_snr=%.1f", Double.valueOf(location.getLongitude()), Double.valueOf(location.getLatitude()), Float.valueOf(speed), Float.valueOf(bearing), Integer.valueOf(accuracy), Integer.valueOf(a), Double.valueOf(altitude), Long.valueOf(location.getTime() / 1000), Integer.valueOf(a), Integer.valueOf(t), Integer.valueOf(u), Integer.valueOf(v), Integer.valueOf(w), Integer.valueOf(B), Integer.valueOf(x), Integer.valueOf(y), Integer.valueOf(z), Integer.valueOf(A), Double.valueOf(S)) : String.format(Locale.CHINA, "&ll=%.5f|%.5f&s=%.1f&d=%.1f&ll_r=%d&ll_n=%d&ll_h=%.2f&ll_t=%d&ll_sn=%d|%d|%d|%d|%d&ll_asn=%d|%d|%d|%d|%d&ll_snr=%.1f&ll_bp=%.2f", Double.valueOf(location.getLongitude()), Double.valueOf(location.getLatitude()), Float.valueOf(speed), Float.valueOf(bearing), Integer.valueOf(accuracy), Integer.valueOf(a), Double.valueOf(altitude), Long.valueOf(location.getTime() / 1000), Integer.valueOf(a), Integer.valueOf(t), Integer.valueOf(u), Integer.valueOf(v), Integer.valueOf(w), Integer.valueOf(B), Integer.valueOf(x), Integer.valueOf(y), Integer.valueOf(z), Integer.valueOf(A), Double.valueOf(S), Float.valueOf(V));
        try {
            return ((j != 2 || i == null) ? new StringBuilder().append(format).append("&ll_fake=").append(j) : new StringBuilder().append(format).append(String.format(Locale.CHINA, "&ll_fake=%d|%.5f|%.5f|%d", Integer.valueOf(j), Double.valueOf(i.getLongitude()), Double.valueOf(i.getLatitude()), Long.valueOf(i.getTime() / 1000)))).toString();
        } catch (Exception e2) {
            e2.printStackTrace();
            return format;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(ArrayList<ArrayList<Float>> arrayList) {
        StringBuilder sb = new StringBuilder();
        if (arrayList.size() == 0) {
            return sb.toString();
        }
        Iterator<ArrayList<Float>> it = arrayList.iterator();
        boolean z2 = true;
        while (it.hasNext()) {
            ArrayList<Float> next = it.next();
            if (next.size() == 6) {
                if (z2) {
                    z2 = false;
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
    public ArrayList<ArrayList<Float>> a(ArrayList<ArrayList<Float>> arrayList, boolean z2, float f2) {
        ArrayList<ArrayList<Float>> arrayList2 = new ArrayList<>();
        if (arrayList.size() <= 40 && arrayList.size() != 0) {
            Iterator<ArrayList<Float>> it = arrayList.iterator();
            while (it.hasNext()) {
                ArrayList<Float> next = it.next();
                if (next.size() == 6) {
                    float floatValue = next.get(3).floatValue();
                    float floatValue2 = next.get(2).floatValue();
                    if (!z2 || floatValue >= 1.0f) {
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
    public ArrayList<ArrayList<Float>> a(boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, float f2) {
        ArrayList<ArrayList<Float>> arrayList = new ArrayList<>();
        if (z2) {
            arrayList.addAll(a(this.ab, z6, f2));
        }
        if (z3) {
            arrayList.addAll(a(this.ac, z6, f2));
        }
        if (z4) {
            arrayList.addAll(a(this.ad, z6, f2));
        }
        if (z5) {
            arrayList.addAll(a(this.ae, z6, f2));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        if (TextUtils.isEmpty(str) || !b(str)) {
            return;
        }
        if (str.startsWith("$GPGGA,")) {
            a(str, 2, 4, 6);
        } else if (str.startsWith("$GPRMC,")) {
            a(str, 3, 5, 2);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x00e9, code lost:
    
        if (android.text.TextUtils.equals(r0[r14], "A") != false) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00f9, code lost:
    
        r10.ao = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00f6, code lost:
    
        if (android.text.TextUtils.equals(r0[r14], com.google.android.exoplayer2.source.rtsp.SessionDescription.SUPPORTED_SDP_VERSION) != false) goto L43;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(java.lang.String r11, int r12, int r13, int r14) {
        /*
            Method dump skipped, instructions count: 264
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.f.g.a(java.lang.String, int, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, Location location) {
        if (location == null) {
            return;
        }
        String str2 = str + com.baidu.location.b.b.a().d();
        boolean f2 = m.a().f();
        v.a(new com.baidu.location.f.a(com.baidu.location.f.b.a().f()));
        v.a(System.currentTimeMillis());
        v.a(new Location(location));
        v.a(str2);
        v.b(com.baidu.location.b.c.a().c());
        if (f2) {
            return;
        }
        z.a(v.c(), (l) null, v.d(), str2, v.e());
    }

    public static boolean a(Location location, Location location2, boolean z2) {
        if (location == location2) {
            return false;
        }
        if (location == null || location2 == null) {
            return true;
        }
        float speed = location2.getSpeed();
        if (z2 && ((o.u == 3 || !com.baidu.location.h.f.a().a(location2.getLongitude(), location2.getLatitude())) && speed < 5.0f)) {
            return true;
        }
        float distanceTo = location2.distanceTo(location);
        return speed > o.K ? distanceTo > o.M : speed > o.J ? distanceTo > o.L : distanceTo > 5.0f;
    }

    public static String b(Location location) {
        String a2 = a(location);
        return a2 != null ? a2 + "&g_tp=0" : a2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ArrayList<ArrayList<Float>> arrayList) {
        String str;
        if (arrayList == null || arrayList.size() <= 0) {
            str = null;
        } else {
            StringBuilder sb = new StringBuilder(100);
            ArrayList arrayList2 = new ArrayList();
            arrayList2.addAll(this.ab);
            sb.append(com.baidu.location.h.c.g(arrayList2)).append("|").append(com.baidu.location.h.c.f(arrayList2)).append("|").append(com.baidu.location.h.c.a(arrayList2)).append("|").append(com.baidu.location.h.c.h(arrayList2)).append("|").append(com.baidu.location.h.c.b(arrayList2)).append("|").append(com.baidu.location.h.c.c(arrayList2)).append("|").append(com.baidu.location.h.c.e(arrayList2)).append("|").append(com.baidu.location.h.c.d(arrayList2));
            str = sb.toString();
        }
        this.af = str;
        this.ag = System.currentTimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z2) {
        this.H = z2;
        V = -1.0f;
    }

    private boolean b(String str) {
        int i2;
        if (str.indexOf(WebSocketServerHandshaker.SUB_PROTOCOL_WILDCARD) != -1 && str.indexOf("$") != -1 && str.indexOf("$") <= str.indexOf(WebSocketServerHandshaker.SUB_PROTOCOL_WILDCARD) && str.length() >= str.indexOf(WebSocketServerHandshaker.SUB_PROTOCOL_WILDCARD)) {
            byte[] bytes = str.substring(0, str.indexOf(WebSocketServerHandshaker.SUB_PROTOCOL_WILDCARD)).getBytes();
            int i3 = bytes[1];
            for (int i4 = 2; i4 < bytes.length; i4++) {
                i3 ^= bytes[i4];
            }
            String format = String.format("%02x", Integer.valueOf(i3));
            int indexOf = str.indexOf(WebSocketServerHandshaker.SUB_PROTOCOL_WILDCARD);
            if (indexOf != -1 && str.length() >= (i2 = indexOf + 3) && format.equalsIgnoreCase(str.substring(indexOf + 1, i2))) {
                return true;
            }
        }
        return false;
    }

    public static String c(Location location) {
        String a2 = a(location);
        return a2 != null ? a2 + Q : a2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(Location location) {
        if (this.R == null || System.currentTimeMillis() - this.as <= 3000) {
            return;
        }
        this.R.sendMessage(this.R.obtainMessage(1, location));
    }

    private int f(Location location) {
        if (location == null) {
            return 0;
        }
        if (Build.VERSION.SDK_INT > 17 && location.isFromMockProvider()) {
            return 100;
        }
        if (Math.abs(this.al - this.am) >= 3000) {
            this.am = -1L;
            this.ap = false;
            this.ao = false;
            this.an = null;
        } else if (this.an == null) {
            if (!this.ao) {
                return 200;
            }
            if (this.ap) {
                return 300;
            }
        } else if (!this.ap && this.ao) {
            return NNTPReply.SERVICE_DISCONTINUED;
        }
        if (this.al > 0) {
            if (this.am == -1) {
                return 500;
            }
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x015a, code lost:
    
        r0.setGnssProvider(com.baidu.location.BDLocation.BDLOCATION_GNSS_PROVIDER_FROM_BAIDU_BEIDOU);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void g(android.location.Location r14) {
        /*
            Method dump skipped, instructions count: 471
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.f.g.g(android.location.Location):void");
    }

    public static String l() {
        long currentTimeMillis = System.currentTimeMillis() - C;
        if (currentTimeMillis < 0 || currentTimeMillis >= 3000) {
            return null;
        }
        return String.format(Locale.US, "&gsvn=%d&gsfn=%d", Integer.valueOf(B), Integer.valueOf(a));
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x000f, code lost:
    
        if (r3 == 1) goto L5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(int r3) {
        /*
            r2 = this;
            r0 = 0
            if (r3 != 0) goto L8
            r2.av = r0
        L5:
            r2.au = r0
            goto L12
        L8:
            r1 = 2
            if (r3 != r1) goto Le
            r2.av = r0
            goto L12
        Le:
            r1 = 1
            if (r3 != r1) goto L12
            goto L5
        L12:
            boolean r3 = r2.au
            if (r3 != 0) goto L34
            boolean r3 = r2.av
            if (r3 == 0) goto L1b
            goto L34
        L1b:
            boolean r3 = r2.o
            if (r3 == 0) goto L34
            com.baidu.location.f.g$a r3 = r2.W
            if (r3 == 0) goto L34
            android.location.LocationManager r1 = r2.g
            if (r1 == 0) goto L34
            r1.unregisterGnssMeasurementsCallback(r3)     // Catch: java.lang.Exception -> L2b
            goto L2f
        L2b:
            r3 = move-exception
            r3.printStackTrace()
        L2f:
            r3 = 0
            r2.W = r3
            r2.at = r0
        L34:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.f.g.a(int):void");
    }

    public void a(BDLocation bDLocation) {
        if (o.l || f(this.h) <= 0) {
            com.baidu.location.b.b.a().d(bDLocation);
        } else {
            com.baidu.location.b.b.a().c(bDLocation);
        }
    }

    public void a(boolean z2) {
        if (z2) {
            c();
        } else {
            d();
        }
    }

    public synchronized void b() {
        if (com.baidu.location.f.isServing) {
            Context serviceContext = com.baidu.location.f.getServiceContext();
            this.f = serviceContext;
            try {
                this.g = (LocationManager) serviceContext.getSystemService("location");
            } catch (Exception unused) {
            }
            this.R = new e(this);
        }
    }

    public void c() {
        if (this.F) {
            return;
        }
        com.baidu.location.f.h hVar = null;
        try {
            if (!this.o) {
                d dVar = new d(this, hVar);
                this.p = dVar;
                this.g.addGpsStatusListener(dVar);
            } else if (o.a(this.f, Permission.ACCESS_FINE_LOCATION) == 1) {
                c cVar = new c(this, hVar);
                this.n = cVar;
                this.g.registerGnssStatusCallback(cVar);
            }
            h hVar2 = new h(this, hVar);
            this.l = hVar2;
            this.g.requestLocationUpdates("passive", 9000L, 0.0f, hVar2);
        } catch (Exception unused) {
        }
        try {
            this.k = new f(this, hVar);
            try {
                this.g.sendExtraCommand("gps", "force_xtra_injection", new Bundle());
            } catch (Exception unused2) {
            }
            this.g.requestLocationUpdates("gps", 1000L, 0.0f, this.k);
            if (this.o && this.X == null && o.aB == 1 && new Random().nextDouble() < o.aA) {
                this.X = new b(this, hVar);
            }
            b bVar = this.X;
            if (bVar != null) {
                this.g.registerGnssNavigationMessageCallback(bVar);
            }
            this.T = System.currentTimeMillis();
            if (!o.l && o.aQ == 1) {
                if (Build.VERSION.SDK_INT >= 24) {
                    com.baidu.location.f.h hVar3 = new com.baidu.location.f.h(this);
                    this.s = hVar3;
                    this.g.addNmeaListener(hVar3);
                } else {
                    this.r = new C0012g(this, hVar);
                    Class.forName("android.location.LocationManager").getMethod("addNmeaListener", GpsStatus.NmeaListener.class).invoke(this.g, this.r);
                }
            }
            this.F = true;
        } catch (Exception unused3) {
        }
    }

    public void d() {
        c cVar;
        if (this.F) {
            LocationManager locationManager = this.g;
            if (locationManager != null) {
                try {
                    d dVar = this.p;
                    if (dVar != null) {
                        locationManager.removeGpsStatusListener(dVar);
                        this.p = null;
                    }
                    if (this.o && (cVar = this.n) != null) {
                        this.g.unregisterGnssStatusCallback(cVar);
                        this.n = null;
                    }
                    h hVar = this.l;
                    if (hVar != null) {
                        this.g.removeUpdates(hVar);
                        this.l = null;
                    }
                } catch (Exception unused) {
                }
                try {
                    f fVar = this.k;
                    if (fVar != null) {
                        this.g.removeUpdates(fVar);
                    }
                    OnNmeaMessageListener onNmeaMessageListener = this.s;
                    if (onNmeaMessageListener != null) {
                        this.g.removeNmeaListener(onNmeaMessageListener);
                    }
                    if (this.r != null) {
                        Class.forName("android.location.LocationManager").getMethod("removeNmeaListener", GpsStatus.NmeaListener.class).invoke(this.g, this.r);
                    }
                    b bVar = this.X;
                    if (bVar != null) {
                        this.g.unregisterGnssNavigationMessageCallback(bVar);
                    }
                    a(0);
                } catch (Exception unused2) {
                }
            }
            o.d = 0;
            o.u = 0;
            this.k = null;
            this.F = false;
            b(false);
        }
    }

    public synchronized void e() {
        d();
        if (this.g == null) {
            return;
        }
        try {
            e eVar = this.R;
            if (eVar != null) {
                eVar.removeCallbacksAndMessages(null);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.g = null;
    }

    public String f() {
        Location location;
        if (!k() || (location = this.h) == null) {
            return null;
        }
        return String.format("%s&idgps_tp=%s", a(location).replaceAll("ll", "idll").replaceAll("&d=", "&idd=").replaceAll("&s", "&ids="), this.h.getProvider());
    }

    public String g() {
        boolean z2;
        StringBuilder append;
        String str;
        if (this.h == null) {
            return null;
        }
        String str2 = "{\"result\":{\"time\":\"" + o.a() + "\",\"error\":\"61\"},\"content\":{\"point\":{\"x\":\"%f\",\"y\":\"%f\"},\"radius\":\"%d\",\"d\":\"%f\",\"s\":\"%f\",\"n\":\"%d\"";
        int accuracy = (int) (this.h.hasAccuracy() ? this.h.getAccuracy() : 10.0f);
        float speed = (float) (this.h.getSpeed() * 3.6d);
        if (!this.h.hasSpeed()) {
            speed = -1.0f;
        }
        double[] dArr = new double[2];
        if (com.baidu.location.h.f.a().a(this.h.getLongitude(), this.h.getLatitude())) {
            dArr = Jni.coorEncrypt(this.h.getLongitude(), this.h.getLatitude(), BDLocation.BDLOCATION_WGS84_TO_GCJ02);
            if (dArr[0] <= 0.0d && dArr[1] <= 0.0d) {
                dArr[0] = this.h.getLongitude();
                dArr[1] = this.h.getLatitude();
            }
            z2 = true;
        } else {
            dArr[0] = this.h.getLongitude();
            dArr[1] = this.h.getLatitude();
            if (dArr[0] <= 0.0d && dArr[1] <= 0.0d) {
                dArr[0] = this.h.getLongitude();
                dArr[1] = this.h.getLatitude();
            }
            z2 = false;
        }
        String format = String.format(Locale.CHINA, str2, Double.valueOf(dArr[0]), Double.valueOf(dArr[1]), Integer.valueOf(accuracy), Float.valueOf(this.h.getBearing()), Float.valueOf(speed), Integer.valueOf(a));
        if (!z2) {
            format = format + ",\"in_cn\":\"0\"";
        }
        if (!o.l) {
            format = format + String.format(Locale.CHINA, ",\"is_mock\":%d", Integer.valueOf(f(this.h)));
        }
        if (this.h.hasAltitude()) {
            append = new StringBuilder().append(format);
            str = String.format(Locale.CHINA, ",\"h\":%.2f}}", Double.valueOf(this.h.getAltitude()));
        } else {
            append = new StringBuilder().append(format);
            str = "}}";
        }
        return append.append(str).toString();
    }

    public Location h() {
        if (this.h != null && Math.abs(System.currentTimeMillis() - this.h.getTime()) <= 60000) {
            return this.h;
        }
        return null;
    }

    public BDLocation i() {
        if (this.an != null && Math.abs(System.currentTimeMillis() - this.am) <= 3000) {
            return this.an;
        }
        return null;
    }

    public boolean j() {
        try {
            System.currentTimeMillis();
            if (a == 0) {
                try {
                    this.h.getExtras().getInt("satellites");
                } catch (Exception unused) {
                }
            }
            Location location = this.h;
            if (location != null && location.getLatitude() != 0.0d) {
                if (this.h.getLongitude() != 0.0d) {
                    return true;
                }
            }
            return false;
        } catch (Exception unused2) {
            Location location2 = this.h;
            return (location2 == null || location2.getLatitude() == 0.0d || this.h.getLongitude() == 0.0d) ? false : true;
        }
    }

    public boolean k() {
        if (!j() || o.l() || System.currentTimeMillis() - this.I > Constant.DELAY_MILLIS) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (!this.E || currentTimeMillis - this.D >= 3000) {
            return this.H;
        }
        return true;
    }

    public synchronized String m() {
        String str;
        str = "-2";
        try {
            if (Math.abs(System.currentTimeMillis() - this.ag) < 3000) {
                String str2 = this.af;
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
