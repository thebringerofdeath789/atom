package com.baidu.location.indoor;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.baidu.geofence.GeoFence;
import com.baidu.location.BDLocation;
import com.baidu.location.Jni;
import com.baidu.location.indoor.a;
import com.baidu.location.indoor.v;
import com.baidu.location.indoor.y;
import com.google.android.exoplayer2.audio.SilenceSkippingAudioProcessor;
import com.google.android.exoplayer2.text.cea.Cea608Decoder;
import com.ipotensic.baselib.netty.Constant;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class n implements SensorEventListener {
    private int A;
    private int B;
    private k<String> C;
    private int D;
    private k<String> E;
    private double F;
    private double G;
    private double H;
    private boolean I;
    private boolean J;
    private List<i> K;
    private int L;
    private int M;
    private int N;
    private com.baidu.location.indoor.a O;
    private String P;
    private l Q;
    private boolean R;
    private boolean S;
    private y T;
    private y.a U;
    private int V;
    private BDLocation W;
    private boolean X;
    private boolean Y;
    private boolean Z;
    public d a;
    private boolean aa;
    private boolean ab;
    private Sensor ac;
    private boolean ad;
    private c ae;
    private e af;
    private g ag;
    private b ah;
    public SimpleDateFormat b;
    private int c;
    private boolean d;
    private int e;
    private boolean f;
    private long g;
    private volatile boolean h;
    private h i;
    private j j;
    private long k;
    private boolean l;
    private boolean m;
    private long n;
    private long o;
    private int p;
    private String q;
    private v.b r;
    private int s;
    private int t;
    private String u;
    private String v;
    private t w;
    private String x;
    private String y;
    private String z;

    class a {
    }

    class b {
        private ArrayList<Double> e;
        private ArrayList<String> f;
        private Map<String, Integer> i;
        public String a = null;
        private Map<String, Double> g = null;
        private int h = 0;
        public int b = 0;
        public String c = null;

        public b() {
            this.e = null;
            this.f = null;
            this.i = null;
            this.e = new ArrayList<>();
            this.f = new ArrayList<>();
            this.i = new HashMap();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int a(BDLocation bDLocation) {
            if (!bDLocation.getBuildingID().equals(this.c)) {
                this.c = bDLocation.getBuildingID();
                a();
            }
            if (b(bDLocation.getRetFields("p_floor")) != 0) {
                this.b = 0;
                return 1;
            }
            try {
                double d = 0.0d;
                if (this.f.size() == 0) {
                    for (Map.Entry<String, Double> entry : this.g.entrySet()) {
                        this.f.add(entry.getKey());
                        this.e.add(entry.getValue());
                    }
                } else {
                    ArrayList<String> arrayList = new ArrayList<>();
                    ArrayList arrayList2 = new ArrayList();
                    Iterator<String> it = this.f.iterator();
                    while (it.hasNext()) {
                        arrayList.add(it.next());
                        arrayList2.add(Double.valueOf(0.0d));
                    }
                    HashMap hashMap = new HashMap();
                    for (Map.Entry<String, Double> entry2 : this.g.entrySet()) {
                        String key = entry2.getKey();
                        Double value = entry2.getValue();
                        hashMap.put(key, value);
                        if (!this.f.contains(key)) {
                            arrayList.add(key);
                            arrayList2.add(value);
                        }
                    }
                    Iterator<Double> it2 = this.g.values().iterator();
                    double d2 = 0.0d;
                    while (it2.hasNext()) {
                        d2 += it2.next().doubleValue();
                    }
                    for (int i = 0; i < arrayList.size(); i++) {
                        arrayList2.set(i, hashMap.containsKey(arrayList.get(i)) ? hashMap.get(arrayList.get(i)) : Double.valueOf((1.0d - d2) / (this.h - hashMap.size())));
                    }
                    ArrayList<Double> arrayList3 = new ArrayList<>();
                    for (int i2 = 0; i2 < arrayList.size(); i2++) {
                        arrayList3.add(Double.valueOf(0.0d));
                    }
                    for (int i3 = 0; i3 < this.f.size(); i3++) {
                        Double d3 = this.e.get(i3);
                        ArrayList<Double> a = a(arrayList, this.f.get(i3));
                        for (int i4 = 0; i4 < arrayList.size(); i4++) {
                            arrayList3.set(i4, Double.valueOf(arrayList3.get(i4).doubleValue() + (d3.doubleValue() * a.get(i4).doubleValue() * ((Double) arrayList2.get(i4)).doubleValue())));
                        }
                    }
                    this.f = arrayList;
                    this.e = a(arrayList3);
                }
                String str = null;
                for (int i5 = 0; i5 < this.f.size(); i5++) {
                    if (this.e.get(i5).doubleValue() > d) {
                        d = this.e.get(i5).doubleValue();
                        str = this.f.get(i5);
                    }
                }
                this.a = str;
            } catch (Exception unused) {
                this.b = 0;
            }
            this.b = 1;
            return 0;
        }

        private int a(String str) {
            if (this.i.containsKey(str)) {
                return this.i.get(str).intValue();
            }
            int i = 1000;
            if (!str.startsWith("F") && !str.startsWith("f")) {
                if (str.startsWith("B") || str.startsWith("b")) {
                    i = -Integer.parseInt(str.substring(1));
                }
                this.i.put(str, Integer.valueOf(i));
                return i;
            }
            i = Integer.parseInt(str.substring(1)) - 1;
            this.i.put(str, Integer.valueOf(i));
            return i;
        }

        private ArrayList<Double> a(ArrayList<Double> arrayList) {
            ArrayList<Double> arrayList2 = new ArrayList<>();
            Double valueOf = Double.valueOf(0.0d);
            Iterator<Double> it = arrayList.iterator();
            while (it.hasNext()) {
                valueOf = Double.valueOf(valueOf.doubleValue() + it.next().doubleValue());
            }
            Iterator<Double> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                arrayList2.add(Double.valueOf(it2.next().doubleValue() / valueOf.doubleValue()));
            }
            return arrayList2;
        }

        private ArrayList<Double> a(ArrayList<String> arrayList, String str) {
            ArrayList<Double> arrayList2 = new ArrayList<>();
            double[] dArr = {180.0d, 10.0d, 1.0d};
            int a = a(str);
            Iterator<String> it = arrayList.iterator();
            if (a == 1000) {
                while (it.hasNext()) {
                    arrayList2.add(Double.valueOf(it.next().equals(str) ? dArr[0] : dArr[2]));
                }
                return arrayList2;
            }
            while (it.hasNext()) {
                int a2 = a(it.next());
                int i = a2 == 1000 ? 2 : a > a2 ? a - a2 : a2 - a;
                if (i > 2) {
                    i = 2;
                }
                arrayList2.add(Double.valueOf(dArr[i]));
            }
            return arrayList2;
        }

        private void a() {
            this.e.clear();
            this.f.clear();
            this.i.clear();
        }

        private int b(String str) {
            try {
                String[] split = str.split(";");
                if (split.length <= 1) {
                    return 1;
                }
                this.h = Integer.parseInt(split[0]);
                this.g = new HashMap();
                for (int i = 1; i < split.length; i++) {
                    String[] split2 = split[i].split(":");
                    this.g.put(split2[0], Double.valueOf(Double.parseDouble(split2[1])));
                }
                return 0;
            } catch (Exception unused) {
                return 1;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String b() {
            return this.a;
        }
    }

    class c {
        private float d = -0.18181887f;
        private float e = -0.90904963f;
        private float f = -0.55321634f;
        private float g = -0.05259979f;
        private float h = 24.0f;
        private float i = 8.61f;
        private float j = 4.25f;
        private float k = 60.39f;
        private float l = 15.6f;
        private float m = 68.07f;
        private float n = 11.61f;
        public ArrayList<ArrayList<Float>> a = null;
        public double[] b = null;

        public c() {
        }

        public double a(double d, double d2, double d3, double d4) {
            double[] a = a(d2, d3);
            double abs = Math.abs(d4 - a[0]);
            return abs > a[1] * 2.0d ? d + abs : d;
        }

        public double[] a(double d, double d2) {
            return com.baidu.location.c.a.a().a(d, d2);
        }
    }

    public class d extends Handler {
        public d() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (com.baidu.location.f.isServing) {
                int i = message.what;
                if (i == 21) {
                    n.this.a(message);
                    return;
                }
                if (i == 41) {
                    n.this.k();
                } else if (i != 801) {
                    super.dispatchMessage(message);
                } else {
                    n.this.a((BDLocation) message.obj);
                }
            }
        }
    }

    class e {
        private double b = -1.0d;
        private long c = 0;
        private long d = 0;
        private long e = 0;
        private long f = 0;
        private long g = 0;
        private long h = 0;
        private long i = 0;
        private long j = 0;
        private long k = 0;
        private double l = 0.0d;
        private double m = 0.0d;
        private double n = 0.0d;
        private double o = 0.0d;
        private int p = 0;
        private int q = 0;
        private com.baidu.location.f.l r = null;
        private long s = 0;
        private int t = 0;
        private int u = 0;

        public e() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a() {
            this.b = -1.0d;
            this.c = 0L;
            this.d = 0L;
            this.f = 0L;
            this.g = 0L;
            this.h = 0L;
            this.i = 0L;
            this.j = 0L;
            this.k = 0L;
            this.l = 0.0d;
            this.m = 0.0d;
            this.p = 0;
            this.q = 0;
            this.r = null;
            this.s = 0L;
            this.t = 0;
            this.u = 0;
            this.e = 0L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(double d, double d2, double d3, long j) {
            this.j = j;
            this.u = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(Location location, boolean z) {
            this.k = System.currentTimeMillis();
            double longitude = location.getLongitude();
            double latitude = location.getLatitude();
            double d = this.l;
            if (d != 0.0d) {
                float[] fArr = new float[2];
                Location.distanceBetween(this.m, d, latitude, longitude, fArr);
                if (fArr[0] < 20.0f) {
                    this.p++;
                } else {
                    this.p = 0;
                }
                if (fArr[0] < 5.0f) {
                    this.q++;
                } else {
                    this.q = 0;
                }
            }
            this.l = longitude;
            this.m = latitude;
            if (location.hasSpeed() && location.getSpeed() > 3.0f) {
                this.h = System.currentTimeMillis();
            }
            if (location.getAccuracy() >= 50.0f || z) {
                this.t = 0;
            } else {
                this.t++;
            }
            if (this.t <= 10 || System.currentTimeMillis() - this.c <= 30000) {
                return;
            }
            n.this.d();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean a(double d, double d2, double d3) {
            if (!n.this.af.c()) {
                return true;
            }
            long currentTimeMillis = System.currentTimeMillis();
            long j = this.f;
            if (j != 0 && currentTimeMillis - j > Constant.DELAY_MILLIS) {
                return true;
            }
            if (this.q >= 5 && d3 < 15.0d && currentTimeMillis - this.c > SilenceSkippingAudioProcessor.DEFAULT_PADDING_SILENCE_US) {
                float[] fArr = new float[2];
                Location.distanceBetween(this.o, this.n, d2, d, fArr);
                if (fArr[0] > 30.0f) {
                    return true;
                }
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean a(BDLocation bDLocation, double d, String str) {
            long currentTimeMillis = System.currentTimeMillis();
            this.i = currentTimeMillis;
            this.b = d;
            this.n = bDLocation.getLongitude();
            this.o = bDLocation.getLatitude();
            if (str.equals("wifi")) {
                this.c = currentTimeMillis;
            }
            if (str.equals("gps")) {
                this.e = currentTimeMillis;
            }
            if (e()) {
                this.f = currentTimeMillis;
            }
            n nVar = n.this;
            nVar.d = nVar.a(bDLocation.getLongitude(), bDLocation.getLatitude());
            if (n.this.d || n.this.c == 1) {
                this.g = currentTimeMillis;
            }
            long j = this.s;
            if (j != 0 && currentTimeMillis - j > 30000 && currentTimeMillis - this.j < Constant.DELAY_MILLIS && currentTimeMillis - this.k < Constant.DELAY_MILLIS) {
                return false;
            }
            if (this.t > 10 && currentTimeMillis - this.c > 30000) {
                return false;
            }
            if (currentTimeMillis - this.g > Constant.DELAY_MILLIS && currentTimeMillis - this.c > 30000) {
                return false;
            }
            long j2 = this.f;
            return j2 == 0 || currentTimeMillis - j2 <= 60000;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean b() {
            System.currentTimeMillis();
            if (n.this.l || this.p < 3) {
                return false;
            }
            if (!com.baidu.location.f.m.a().i().contains("&wifio") && n.this.c != 1) {
                return false;
            }
            this.u = 1;
            return true;
        }

        private boolean c() {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.h < Constant.DELAY_MILLIS && currentTimeMillis - this.c > 30000) {
                return false;
            }
            if (currentTimeMillis - this.k >= Constant.DELAY_MILLIS) {
                return true;
            }
            long j = this.j;
            return j == 0 || currentTimeMillis - j <= Cea608Decoder.MIN_DATA_CHANNEL_TIMEOUT_MS || currentTimeMillis - this.c <= 30000;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void d() {
            long currentTimeMillis = System.currentTimeMillis();
            com.baidu.location.f.l r = com.baidu.location.f.m.a().r();
            if (r.a == null) {
                return;
            }
            com.baidu.location.f.l lVar = this.r;
            if (lVar == null || !r.b(lVar)) {
                if (currentTimeMillis - this.s < Constant.DELAY_MILLIS) {
                    this.d = currentTimeMillis;
                }
                this.s = currentTimeMillis;
                this.r = r;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean e() {
            if (this.u == 1 || !c() || this.b > 25.0d || System.currentTimeMillis() - this.i > 30000) {
                return false;
            }
            this.f = System.currentTimeMillis();
            return true;
        }
    }

    private static class f {
        private static n a = new n(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    class g {
        public int a = 10;
        private List<a> c = Collections.synchronizedList(new ArrayList());

        private class a {
            public double a;
            public double b;
            public double c;

            public a(double d, double d2, double d3) {
                this.a = d;
                this.b = d2;
                this.c = d3;
            }
        }

        public g() {
        }

        public void a(BDLocation bDLocation) {
            this.c.add(new a(bDLocation.getLongitude(), bDLocation.getLatitude(), n.this.af.b));
        }

        public String toString() {
            if (this.c.size() == 0) {
                return "";
            }
            try {
                StringBuffer stringBuffer = new StringBuffer();
                double d = this.c.get(0).a;
                double d2 = this.c.get(0).b;
                stringBuffer.append(String.format("%.6f:%.6f:%.1f", Double.valueOf(d), Double.valueOf(d2), Double.valueOf(this.c.get(0).c)));
                int size = (this.c.size() > this.a ? this.c.size() - this.a : 0) + 1;
                while (size < this.c.size()) {
                    stringBuffer.append(String.format(";%.0f:%.0f:%.1f", Double.valueOf((this.c.get(size).a - d) * 1000000.0d), Double.valueOf((this.c.get(size).b - d2) * 1000000.0d), Double.valueOf(this.c.get(size).c)));
                    size++;
                    d = d;
                }
                return stringBuffer.toString();
            } catch (Exception e) {
                e.printStackTrace();
                return "";
            }
        }
    }

    class h extends Thread {
        private volatile boolean b = true;
        private long c = 0;
        private long d = 0;
        private long e = 0;

        h() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            n nVar;
            long j;
            while (this.b) {
                if (n.this.c != 1 || n.this.d) {
                    nVar = n.this;
                    j = 3000;
                } else {
                    nVar = n.this;
                    j = 5000;
                }
                nVar.g = j;
                if (System.currentTimeMillis() - this.c > n.this.g) {
                    com.baidu.location.f.m.a().j();
                    this.c = System.currentTimeMillis();
                    n.this.h = false;
                }
                if (com.baidu.location.f.m.a().s()) {
                    this.e = 0L;
                } else {
                    long j2 = this.e + 1;
                    this.e = j2;
                    if (j2 >= 10) {
                        this.b = false;
                        n.this.d();
                        return;
                    }
                }
                if (n.this.l && n.this.af != null && System.currentTimeMillis() - n.this.o > 30000 && System.currentTimeMillis() - n.this.af.f > 30000) {
                    n.a().d();
                }
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException unused) {
                    this.b = false;
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    class i {
        public int a;
        public double b;
        public double c;
        public int d = 1;
        public double e;

        public i(int i, double d, double d2, double d3) {
            this.a = i;
            this.b = d;
            this.c = d2;
            this.e = d3;
        }

        public String toString() {
            return this.c == this.e ? String.format("%d:%.1f:%.2f", Integer.valueOf(this.d), Double.valueOf(this.c), Double.valueOf(this.b)) : String.format("%d:%.1f:%.2f:%.1f", Integer.valueOf(this.d), Double.valueOf(this.c), Double.valueOf(this.b), Double.valueOf(this.e));
        }
    }

    class j extends com.baidu.location.h.g {
        private boolean b = false;
        private boolean c = false;
        private String d = null;
        private String e = null;
        private long f = 0;
        private a r = null;
        private long s = 0;
        private long t = 0;

        public j() {
            this.k = new HashMap();
        }

        public void a() {
            boolean z;
            if (this.b) {
                this.c = true;
                return;
            }
            if (n.this.c != 1 || n.this.d || System.currentTimeMillis() - this.f >= 30000 || System.currentTimeMillis() - n.this.af.c <= 30000) {
                long currentTimeMillis = System.currentTimeMillis() - this.s;
                if (currentTimeMillis >= 1000 || currentTimeMillis <= 0) {
                    StringBuffer stringBuffer = new StringBuffer(1024);
                    String i = com.baidu.location.f.b.a().f().i();
                    String f = com.baidu.location.f.g.a().f();
                    stringBuffer.append(com.baidu.location.f.g.a().m());
                    n.this.H = 0.5d;
                    if (n.this.Q == null || n.this.Q.d() == null || !n.this.Q.f()) {
                        z = false;
                    } else {
                        stringBuffer.append("&bleand=").append(n.this.Q.d());
                        stringBuffer.append("&bleand_et=").append(n.this.Q.e());
                        z = true;
                    }
                    com.baidu.location.f.l r = com.baidu.location.f.m.a().r();
                    String a = n.this.a(r);
                    if (a == null) {
                        a = r.a(n.this.e, true, false);
                    }
                    if (!z) {
                        if (a == null || a.length() < 10) {
                            return;
                        }
                        String str = this.e;
                        if (str != null && str.equals(a)) {
                            return;
                        }
                    }
                    this.e = a;
                    this.b = true;
                    stringBuffer.append(i);
                    if (f != null) {
                        stringBuffer.append(f);
                    }
                    stringBuffer.append("&coor=gcj02");
                    stringBuffer.append("&lt=1");
                    if (a != null && !"null".equals(a) && !"".equals(a)) {
                        stringBuffer.append(a);
                    }
                    String d = v.a().d();
                    if (n.this.M <= 2 && d != null) {
                        stringBuffer.append("&idsl=" + d);
                    }
                    int size = n.this.K.size();
                    stringBuffer.append(n.this.a(size));
                    n.this.L = size;
                    n.y(n.this);
                    stringBuffer.append("&drsi=" + n.this.M);
                    stringBuffer.append("&drc=" + n.this.s);
                    if (n.this.F != 0.0d && n.this.G != 0.0d) {
                        stringBuffer.append("&lst_idl=" + String.format(Locale.CHINA, "%.5f:%.5f", Double.valueOf(n.this.F), Double.valueOf(n.this.G)));
                    }
                    n.this.s = 0;
                    stringBuffer.append("&idpfv=1");
                    stringBuffer.append("&iflxy=" + n.this.ag.toString());
                    n.this.ag.c.clear();
                    n.C(n.this);
                    if (n.this.P != null) {
                        stringBuffer.append(n.this.P);
                        n.this.P = null;
                    }
                    String d2 = com.baidu.location.b.b.a().d();
                    if (d2 != null) {
                        stringBuffer.append(d2);
                    }
                    stringBuffer.append(com.baidu.location.h.b.a().a(true));
                    stringBuffer.append(com.baidu.location.b.c.a().c());
                    stringBuffer.append(com.baidu.location.h.o.e(com.baidu.location.f.getServiceContext()));
                    int c = com.baidu.location.h.o.c(com.baidu.location.f.getServiceContext());
                    if (c >= 0) {
                        stringBuffer.append("&lmd=").append(c);
                    }
                    this.d = stringBuffer.toString();
                    ExecutorService b = com.baidu.location.b.x.a().b();
                    if (b != null) {
                        a(b, com.baidu.location.h.d.c);
                    } else {
                        e(com.baidu.location.h.d.c);
                    }
                    this.f = System.currentTimeMillis();
                }
            }
        }

        @Override // com.baidu.location.h.g
        public void a(boolean z) {
            if (!z || this.j == null) {
                n.u(n.this);
                n.this.V = 0;
                this.b = false;
                if (n.this.p <= 40) {
                    return;
                } else {
                    n.this.d();
                }
            } else {
                try {
                    String str = this.j;
                    if (str.contains("enc") && com.baidu.location.b.n.a().b()) {
                        try {
                            JSONObject jSONObject = new JSONObject(str);
                            if (jSONObject.has("enc")) {
                                str = com.baidu.location.b.n.a().b(jSONObject.getString("enc"));
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    if (!n.this.l) {
                        this.b = false;
                        return;
                    }
                    BDLocation bDLocation = new BDLocation(str);
                    if (bDLocation.getLocType() == 161 && bDLocation.getBuildingID() != null) {
                        n.this.W = new BDLocation(bDLocation);
                    }
                    String indoorLocationSurpportBuidlingName = bDLocation.getIndoorLocationSurpportBuidlingName();
                    if (indoorLocationSurpportBuidlingName != null && !n.this.O.a(indoorLocationSurpportBuidlingName)) {
                        n.this.O.a(indoorLocationSurpportBuidlingName, (a.InterfaceC0014a) null);
                    }
                    if (n.this.Q != null) {
                        n.this.Q.a(new s(this));
                    }
                    com.baidu.location.b.u.a().b(true);
                    if (bDLocation.getBuildingName() != null) {
                        n.this.y = bDLocation.getBuildingName();
                    }
                    if (bDLocation.getFloor() != null) {
                        n.this.n = System.currentTimeMillis();
                        long currentTimeMillis = System.currentTimeMillis();
                        this.t = currentTimeMillis;
                        int i = (int) (currentTimeMillis - this.s);
                        if (i > 10000) {
                            n.this.V = 0;
                        } else if (i < 3000) {
                            n.this.V = 2;
                        } else {
                            n.this.V = 1;
                        }
                        if (bDLocation.getFloor().contains("-a")) {
                            n.this.I = true;
                            bDLocation.setFloor(bDLocation.getFloor().split("-")[0]);
                        } else {
                            n.this.I = false;
                        }
                        n.this.C.add(bDLocation.getFloor());
                    }
                    Message obtainMessage = n.this.a.obtainMessage(21);
                    obtainMessage.obj = bDLocation;
                    obtainMessage.sendToTarget();
                } catch (Exception unused) {
                }
            }
            if (this.k != null) {
                this.k.clear();
            }
            this.b = false;
        }

        @Override // com.baidu.location.h.g
        public void b() {
            if (n.this.v == null || n.this.w == null || !n.this.v.equals(n.this.w.a())) {
                this.d = "&nd_idf=1&indoor_polygon=1" + this.d;
            }
            this.i = 1;
            if (com.baidu.location.b.n.a().b()) {
                this.d += "&enc=2";
            }
            String encodeTp4 = Jni.encodeTp4(this.d);
            this.d = null;
            this.k.put("bloc", encodeTp4);
            this.s = System.currentTimeMillis();
        }

        public synchronized void c() {
            if (this.b) {
                return;
            }
            if (this.c) {
                this.c = false;
                a();
            }
        }
    }

    private n() {
        this.c = 0;
        this.d = false;
        this.e = 32;
        this.g = 3000L;
        this.h = true;
        this.a = null;
        this.i = null;
        this.j = null;
        this.k = 0L;
        this.l = false;
        this.m = false;
        this.n = 0L;
        this.o = 0L;
        this.p = 0;
        this.q = null;
        this.s = 0;
        this.t = 0;
        this.u = null;
        this.v = null;
        this.w = null;
        this.x = null;
        this.y = null;
        this.z = null;
        this.A = 0;
        this.B = 5;
        this.C = null;
        this.D = 20;
        this.E = null;
        this.F = 0.0d;
        this.G = 0.0d;
        this.H = 0.4d;
        this.I = false;
        this.J = true;
        this.K = Collections.synchronizedList(new ArrayList());
        this.L = -1;
        this.M = 0;
        this.N = 0;
        this.P = null;
        this.Q = null;
        this.R = false;
        this.S = false;
        this.b = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.V = 2;
        this.W = null;
        this.X = false;
        this.Y = false;
        this.Z = false;
        this.aa = false;
        this.ab = false;
        this.ac = null;
        this.ad = false;
        this.ae = null;
        this.af = null;
        this.ag = null;
        this.ah = null;
        this.f = false;
        this.a = new d();
        try {
            com.baidu.location.indoor.mapversion.b.a.a(com.baidu.location.f.getServiceContext());
        } catch (Exception unused) {
        }
        try {
            com.baidu.location.indoor.mapversion.b.c.a(com.baidu.location.f.getServiceContext());
        } catch (Exception unused2) {
        }
        y yVar = new y();
        this.T = yVar;
        yVar.a(1000L);
        this.U = new o(this);
        this.r = new p(this);
        this.j = new j();
        this.C = new k<>(this.B);
        this.E = new k<>(this.D);
        this.O = new com.baidu.location.indoor.a(com.baidu.location.f.getServiceContext());
        this.ae = new c();
        this.af = new e();
        this.ag = new g();
        this.ah = new b();
    }

    /* synthetic */ n(o oVar) {
        this();
    }

    static /* synthetic */ int C(n nVar) {
        int i2 = nVar.N;
        nVar.N = i2 + 1;
        return i2;
    }

    public static n a() {
        return f.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(int i2) {
        if (this.K.size() == 0) {
            return "&dr=0:0";
        }
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("&dr=");
            this.K.get(0).d = 1;
            sb.append(this.K.get(0).toString());
            int i3 = this.K.get(0).a;
            for (int i4 = 1; i4 < this.K.size() && i4 <= i2; i4++) {
                this.K.get(i4).d = this.K.get(i4).a - i3;
                sb.append(";");
                sb.append(this.K.get(i4).toString());
                i3 = this.K.get(i4).a;
            }
            return sb.toString();
        } catch (Exception e2) {
            e2.printStackTrace();
            return "&dr=0:0";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(com.baidu.location.f.l lVar) {
        String str;
        String a2;
        StringBuilder sb;
        int a3 = lVar.a();
        int i2 = this.e;
        if (a3 <= i2) {
            a2 = lVar.a(i2, true, true);
            str = "&aprk=0";
            if (a2 == null || "null".equals(a2)) {
                return "&aprk=0";
            }
            sb = new StringBuilder();
        } else {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (int i3 = 0; i3 < a3; i3++) {
                String lowerCase = lVar.a.get(i3).BSSID.replaceAll(":", "").toLowerCase();
                com.baidu.location.indoor.a aVar = this.O;
                if (aVar == null || !aVar.b(lowerCase)) {
                    arrayList2.add(lVar.a.get(i3));
                } else {
                    arrayList.add(lVar.a.get(i3));
                }
            }
            str = arrayList.size() > 0 ? "&aprk=3" : "";
            if ("".equals(str)) {
                com.baidu.location.indoor.a aVar2 = this.O;
                str = (aVar2 == null || !aVar2.a()) ? "&aprk=1" : "&aprk=2";
            }
            arrayList.addAll(arrayList2);
            lVar.a = arrayList;
            a2 = lVar.a(this.e, true, true);
            sb = new StringBuilder();
        }
        return sb.append(a2).append(str).toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Message message) {
        boolean z;
        t tVar;
        if (this.l) {
            this.m = false;
            BDLocation bDLocation = (BDLocation) message.obj;
            if (bDLocation.getLocType() == 161) {
                m();
                if (bDLocation.getIndoorSurpportPolygon() != null && bDLocation.getIndoorLocationSurpportBuidlingID() != null && ((tVar = this.w) == null || !tVar.a().equals(bDLocation.getBuildingID()))) {
                    String[] split = bDLocation.getIndoorSurpportPolygon().split("\\|");
                    Location[] locationArr = new Location[split.length];
                    for (int i2 = 0; i2 < split.length; i2++) {
                        String[] split2 = split[i2].split(",");
                        Location location = new Location("gps");
                        location.setLatitude(Double.valueOf(split2[1]).doubleValue());
                        location.setLongitude(Double.valueOf(split2[0]).doubleValue());
                        locationArr[i2] = location;
                    }
                    this.w = new t(bDLocation.getIndoorLocationSurpportBuidlingID(), locationArr);
                }
                if (i() && bDLocation != null && bDLocation.getLocType() == 161) {
                    if ("ble".equals(bDLocation.getNetworkLocationType())) {
                        m.a(bDLocation.getLongitude(), bDLocation.getLatitude(), bDLocation.getFloor(), bDLocation.getInOutStatus(), System.currentTimeMillis(), com.baidu.location.indoor.f.a().d());
                        this.S = true;
                    } else {
                        m.a(0.0d, 0.0d, bDLocation.getFloor(), bDLocation.getInOutStatus(), System.currentTimeMillis(), com.baidu.location.indoor.f.a().d());
                        this.S = false;
                    }
                }
                this.p = 0;
                if (bDLocation.getBuildingID() != null) {
                    this.m = true;
                    bDLocation.setIndoorLocMode(true);
                    if (bDLocation.getRetFields("tp") == null || !bDLocation.getRetFields("tp").equalsIgnoreCase("ble")) {
                        this.R = false;
                    } else {
                        bDLocation.setRadius(8.0f);
                        bDLocation.setNetworkLocationType("ble");
                        this.R = true;
                    }
                    this.v = bDLocation.getBuildingID();
                    this.x = bDLocation.getBuildingName();
                    this.z = bDLocation.getNetworkLocationType();
                    this.A = bDLocation.isParkAvailable();
                    this.ah.a(bDLocation);
                    String floor = bDLocation.getFloor();
                    String l = l();
                    if (floor != null && l != null && !floor.equals(l)) {
                        return;
                    }
                    if (this.u == null) {
                        this.u = bDLocation.getFloor();
                    }
                    com.baidu.location.indoor.mapversion.b.a.a().a(bDLocation.getLongitude(), bDLocation.getLatitude());
                    a(bDLocation.getBuildingName(), bDLocation.getFloor());
                    if (floor != null && l != null && !floor.equals(l)) {
                        return;
                    }
                    if (!floor.equalsIgnoreCase(this.u) && this.Z) {
                        this.af.a();
                        com.baidu.location.indoor.mapversion.a.a.c();
                        this.aa = com.baidu.location.indoor.mapversion.a.a.a(bDLocation.getFloor());
                    }
                    this.u = bDLocation.getFloor();
                    double c2 = v.a().c();
                    if (c2 >= 0.0d && bDLocation.getDirection() <= 0.0f) {
                        bDLocation.setDirection((float) c2);
                    }
                    double[] a2 = com.baidu.location.indoor.mapversion.a.a.a(this.S, bDLocation);
                    if (a2 != null && a2[0] != -1.0d && a2[0] == 0.0d) {
                        bDLocation.setLongitude(a2[1]);
                        bDLocation.setLatitude(a2[2]);
                        bDLocation.setFusionLocInfo("res", a2);
                        bDLocation.setRadius((float) a2[5]);
                        bDLocation.setDirection((float) a2[6]);
                        bDLocation.setSpeed((float) a2[8]);
                        if (!this.af.a(bDLocation, a2[5], "wifi")) {
                            d();
                            return;
                        }
                    }
                } else if (i() && (z = this.S)) {
                    double[] a3 = com.baidu.location.indoor.mapversion.a.a.a(z, bDLocation);
                    if (a3 != null && a3[0] != -1.0d && a3[0] == 0.0d) {
                        bDLocation.setLongitude(a3[1]);
                        bDLocation.setLatitude(a3[2]);
                        bDLocation.setFusionLocInfo("res", a3);
                        bDLocation.setRadius((float) a3[5]);
                        bDLocation.setDirection((float) a3[6]);
                        bDLocation.setSpeed((float) a3[8]);
                        if (!this.af.a(bDLocation, a3[5], "wifi")) {
                            d();
                            return;
                        }
                    }
                }
                this.G = bDLocation.getLatitude();
                this.F = bDLocation.getLongitude();
            } else if (bDLocation.getLocType() == 63) {
                int i3 = this.p + 1;
                this.p = i3;
                if (i3 <= 10) {
                    return;
                } else {
                    d();
                }
            } else {
                this.p = 0;
            }
            if (this.m) {
                if (bDLocation.getTime() == null) {
                    bDLocation.setTime(this.b.format(new Date()));
                }
                BDLocation bDLocation2 = new BDLocation(bDLocation);
                bDLocation2.setNetworkLocationType(bDLocation2.getNetworkLocationType() + GeoFence.BUNDLE_KEY_CUSTOMID);
                y yVar = this.T;
                if (yVar == null || !yVar.c()) {
                    a(bDLocation2, 21);
                } else {
                    this.T.a(bDLocation2);
                }
            }
            this.j.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(BDLocation bDLocation) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x005d, code lost:
    
        if ("unknow".equals(r3) == false) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(com.baidu.location.BDLocation r7, int r8) {
        /*
            Method dump skipped, instructions count: 425
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.indoor.n.a(com.baidu.location.BDLocation, int):void");
    }

    private void a(String str, String str2) {
        String str3 = this.x;
        if (str3 != null && str3.equals(str) && this.Z) {
            return;
        }
        com.baidu.location.indoor.mapversion.b.a a2 = com.baidu.location.indoor.mapversion.b.a.a();
        a2.a("gcj02");
        a2.a(str, new q(this, str, str2));
    }

    static /* synthetic */ int f(n nVar) {
        int i2 = nVar.s;
        nVar.s = i2 + 1;
        return i2;
    }

    private void j() {
        this.C.clear();
        this.E.clear();
        this.n = 0L;
        this.p = 0;
        this.A = 0;
        this.t = 0;
        this.u = null;
        this.v = null;
        this.x = null;
        this.y = null;
        this.z = null;
        this.J = true;
        this.H = 0.4d;
        this.R = false;
        this.S = false;
        this.F = 0.0d;
        this.G = 0.0d;
        this.I = false;
        this.M = 0;
        this.s = 0;
        this.q = null;
        this.o = 0L;
        this.af.a();
        com.baidu.location.indoor.mapversion.a.a.c();
        if (this.Z) {
            com.baidu.location.indoor.mapversion.b.a.a().b();
        }
        this.aa = false;
        this.Z = false;
        com.baidu.location.b.u.a().b(false);
        l lVar = this.Q;
        if (lVar != null) {
            lVar.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        if (this.l) {
            this.h = true;
            this.af.d();
            this.j.a();
            this.k = System.currentTimeMillis();
        }
    }

    private String l() {
        String str;
        k<String> kVar;
        if (this.ah.b == 1 && this.ah.a != null) {
            return this.ah.b();
        }
        HashMap hashMap = new HashMap();
        int size = this.C.size();
        String str2 = null;
        int i2 = -1;
        String str3 = "";
        for (int i3 = 0; i3 < size; i3++) {
            try {
                String str4 = this.C.get(i3);
                str3 = str3 + str4 + "|";
                hashMap.put(str4, hashMap.containsKey(str4) ? Integer.valueOf(((Integer) hashMap.get(str4)).intValue() + 1) : 1);
            } catch (Exception unused) {
                return this.u;
            }
        }
        for (String str5 : hashMap.keySet()) {
            if (((Integer) hashMap.get(str5)).intValue() > i2) {
                i2 = ((Integer) hashMap.get(str5)).intValue();
                str2 = str5;
            }
        }
        return (str2 == null || (str = this.u) == null || str2.equals(str) || (kVar = this.C) == null || kVar.size() != this.B) ? str2 : (this.C.get(size + (-3)).equals(str2) && this.C.get(size + (-2)).equals(str2) && this.C.get(size - 1).equals(str2)) ? str2 : this.u;
    }

    private void m() {
        for (int i2 = this.L; i2 >= 0 && this.K.size() > 0; i2--) {
            this.K.remove(0);
        }
        this.L = -1;
    }

    static /* synthetic */ int u(n nVar) {
        int i2 = nVar.p;
        nVar.p = i2 + 1;
        return i2;
    }

    static /* synthetic */ int y(n nVar) {
        int i2 = nVar.M;
        nVar.M = i2 + 1;
        return i2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0054, code lost:
    
        r8 = r4.b;
        r2 = r4.a;
        r8 = r4.g;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean a(double r8, double r10) {
        /*
            r7 = this;
            com.baidu.location.indoor.mapversion.b.c r0 = com.baidu.location.indoor.mapversion.b.c.a()
            boolean r0 = r0.c()
            r1 = 0
            if (r0 == 0) goto L68
            com.baidu.location.indoor.mapversion.b.c r0 = com.baidu.location.indoor.mapversion.b.c.a()
            boolean r0 = r0.b()
            if (r0 != 0) goto L16
            goto L68
        L16:
            com.baidu.location.indoor.mapversion.b.c r0 = com.baidu.location.indoor.mapversion.b.c.a()
            java.util.Map r0 = r0.d()
            if (r0 != 0) goto L21
            return r1
        L21:
            r2 = 0
            java.util.Set r3 = r0.keySet()     // Catch: java.lang.Exception -> L5b java.util.ConcurrentModificationException -> L60
            java.util.Iterator r3 = r3.iterator()     // Catch: java.lang.Exception -> L5b java.util.ConcurrentModificationException -> L60
        L2a:
            boolean r4 = r3.hasNext()     // Catch: java.lang.Exception -> L5b java.util.ConcurrentModificationException -> L60
            if (r4 == 0) goto L64
            java.lang.Object r4 = r3.next()     // Catch: java.lang.Exception -> L5b java.util.ConcurrentModificationException -> L60
            java.lang.String r4 = (java.lang.String) r4     // Catch: java.lang.Exception -> L5b java.util.ConcurrentModificationException -> L60
            java.lang.Object r4 = r0.get(r4)     // Catch: java.lang.Exception -> L5b java.util.ConcurrentModificationException -> L60
            com.baidu.location.indoor.mapversion.b.c$b r4 = (com.baidu.location.indoor.mapversion.b.c.b) r4     // Catch: java.lang.Exception -> L5b java.util.ConcurrentModificationException -> L60
            double r5 = r4.e     // Catch: java.lang.Exception -> L5b java.util.ConcurrentModificationException -> L60
            int r5 = (r8 > r5 ? 1 : (r8 == r5 ? 0 : -1))
            if (r5 <= 0) goto L2a
            double r5 = r4.c     // Catch: java.lang.Exception -> L5b java.util.ConcurrentModificationException -> L60
            int r5 = (r8 > r5 ? 1 : (r8 == r5 ? 0 : -1))
            if (r5 >= 0) goto L2a
            double r5 = r4.f     // Catch: java.lang.Exception -> L5b java.util.ConcurrentModificationException -> L60
            int r5 = (r10 > r5 ? 1 : (r10 == r5 ? 0 : -1))
            if (r5 <= 0) goto L2a
            double r5 = r4.d     // Catch: java.lang.Exception -> L5b java.util.ConcurrentModificationException -> L60
            int r5 = (r10 > r5 ? 1 : (r10 == r5 ? 0 : -1))
            if (r5 >= 0) goto L2a
            java.lang.String r8 = r4.b     // Catch: java.lang.Exception -> L5b java.util.ConcurrentModificationException -> L60
            java.lang.String r2 = r4.a     // Catch: java.lang.Exception -> L5b java.util.ConcurrentModificationException -> L60
            java.lang.String r8 = r4.g     // Catch: java.lang.Exception -> L5b java.util.ConcurrentModificationException -> L60
            goto L64
        L5b:
            r8 = move-exception
            r8.printStackTrace()
            goto L64
        L60:
            r8 = move-exception
            r8.printStackTrace()
        L64:
            if (r2 == 0) goto L68
            r8 = 1
            return r8
        L68:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.indoor.n.a(double, double):boolean");
    }

    public boolean a(Location location, ArrayList<ArrayList<Float>> arrayList) {
        int size = arrayList.size();
        if (i()) {
            double[] coorEncrypt = Jni.coorEncrypt(location.getLongitude(), location.getLatitude(), BDLocation.BDLOCATION_WGS84_TO_GCJ02);
            m.a(coorEncrypt[0], coorEncrypt[1], location.getAccuracy(), location.getSpeed(), location.getBearing(), location.getAltitude(), size, System.currentTimeMillis());
        }
        if (size == 0 || !com.baidu.location.f.g.a().k() || (!this.l && location.getSpeed() > 3.0f)) {
            return false;
        }
        double[] coorEncrypt2 = Jni.coorEncrypt(location.getLongitude(), location.getLatitude(), BDLocation.BDLOCATION_WGS84_TO_GCJ02);
        double d2 = coorEncrypt2[0];
        double d3 = coorEncrypt2[1];
        double accuracy = location.getAccuracy();
        location.getBearing();
        double altitude = location.getAltitude();
        location.getSpeed();
        boolean z = a(d2, d3) || this.c == 1;
        if (!this.l && !z) {
            return false;
        }
        try {
            this.af.a(location, z);
        } catch (Exception unused) {
        }
        if (this.af.b()) {
            c();
            return true;
        }
        if (!e()) {
            return false;
        }
        if (this.af.a(d2, d3, accuracy)) {
            com.baidu.location.indoor.mapversion.a.a.c();
        }
        this.ae.a(accuracy, d2, d3, altitude);
        return false;
    }

    public boolean a(Bundle bundle) {
        if (bundle == null) {
            return false;
        }
        this.c = bundle.getInt(RtspHeaders.Values.MODE);
        return true;
    }

    public synchronized void b() {
        if (this.l) {
            this.C.clear();
        }
    }

    public synchronized void c() {
        if (this.l) {
            return;
        }
        com.baidu.location.indoor.mapversion.a.a.b();
        this.n = System.currentTimeMillis();
        this.o = System.currentTimeMillis();
        v.a().a(this.r);
        h hVar = new h();
        this.i = hVar;
        hVar.start();
        this.m = false;
        this.l = true;
        if (this.Q == null) {
            this.Q = new l(com.baidu.location.f.getServiceContext());
        }
        this.M = 0;
        this.s = 0;
        com.baidu.location.b.u.a().b(true);
    }

    public synchronized void d() {
        if (this.l) {
            this.l = false;
            v.a().b(this.r);
            y yVar = this.T;
            if (yVar != null && yVar.c()) {
                this.T.a();
            }
            com.baidu.location.indoor.a aVar = this.O;
            if (aVar != null) {
                aVar.c();
            }
            l lVar = this.Q;
            if (lVar != null) {
                lVar.c();
            }
            h hVar = this.i;
            if (hVar != null) {
                hVar.b = false;
                this.i.interrupt();
                this.i = null;
            }
            j();
            this.m = false;
            com.baidu.location.b.b.a().c();
        }
    }

    public boolean e() {
        return this.l;
    }

    public boolean f() {
        return this.l && this.af.e();
    }

    public String g() {
        return this.u;
    }

    public String h() {
        return this.v;
    }

    public boolean i() {
        return this.ab;
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i2) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor.getType() != 6) {
            return;
        }
        float[] fArr = (float[]) sensorEvent.values.clone();
        if (i()) {
            try {
                this.a.post(new r(this, fArr));
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }
}
