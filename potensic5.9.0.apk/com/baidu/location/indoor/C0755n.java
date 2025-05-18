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
import com.baidu.location.ServiceC0702f;
import com.baidu.location.indoor.C0735a;
import com.baidu.location.indoor.C0763v;
import com.baidu.location.indoor.C0766y;
import com.baidu.location.indoor.mapversion.p013a.C0750a;
import com.baidu.location.indoor.mapversion.p014b.C0751a;
import com.baidu.location.indoor.mapversion.p014b.C0753c;
import com.baidu.location.p006b.C0648b;
import com.baidu.location.p006b.C0649c;
import com.baidu.location.p006b.C0660n;
import com.baidu.location.p006b.C0667u;
import com.baidu.location.p006b.C0670x;
import com.baidu.location.p007c.C0674a;
import com.baidu.location.p010f.C0704b;
import com.baidu.location.p010f.C0709g;
import com.baidu.location.p010f.C0714l;
import com.baidu.location.p010f.C0715m;
import com.baidu.location.p012h.AbstractC0725g;
import com.baidu.location.p012h.C0720b;
import com.baidu.location.p012h.C0722d;
import com.baidu.location.p012h.C0733o;
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

/* renamed from: com.baidu.location.indoor.n */
/* loaded from: classes.dex */
public class C0755n implements SensorEventListener {

    /* renamed from: A */
    private int f1601A;

    /* renamed from: B */
    private int f1602B;

    /* renamed from: C */
    private C0746k<String> f1603C;

    /* renamed from: D */
    private int f1604D;

    /* renamed from: E */
    private C0746k<String> f1605E;

    /* renamed from: F */
    private double f1606F;

    /* renamed from: G */
    private double f1607G;

    /* renamed from: H */
    private double f1608H;

    /* renamed from: I */
    private boolean f1609I;

    /* renamed from: J */
    private boolean f1610J;

    /* renamed from: K */
    private List<i> f1611K;

    /* renamed from: L */
    private int f1612L;

    /* renamed from: M */
    private int f1613M;

    /* renamed from: N */
    private int f1614N;

    /* renamed from: O */
    private C0735a f1615O;

    /* renamed from: P */
    private String f1616P;

    /* renamed from: Q */
    private C0747l f1617Q;

    /* renamed from: R */
    private boolean f1618R;

    /* renamed from: S */
    private boolean f1619S;

    /* renamed from: T */
    private C0766y f1620T;

    /* renamed from: U */
    private C0766y.a f1621U;

    /* renamed from: V */
    private int f1622V;

    /* renamed from: W */
    private BDLocation f1623W;

    /* renamed from: X */
    private boolean f1624X;

    /* renamed from: Y */
    private boolean f1625Y;

    /* renamed from: Z */
    private boolean f1626Z;

    /* renamed from: a */
    public d f1627a;

    /* renamed from: aa */
    private boolean f1628aa;

    /* renamed from: ab */
    private boolean f1629ab;

    /* renamed from: ac */
    private Sensor f1630ac;

    /* renamed from: ad */
    private boolean f1631ad;

    /* renamed from: ae */
    private c f1632ae;

    /* renamed from: af */
    private e f1633af;

    /* renamed from: ag */
    private g f1634ag;

    /* renamed from: ah */
    private b f1635ah;

    /* renamed from: b */
    public SimpleDateFormat f1636b;

    /* renamed from: c */
    private int f1637c;

    /* renamed from: d */
    private boolean f1638d;

    /* renamed from: e */
    private int f1639e;

    /* renamed from: f */
    private boolean f1640f;

    /* renamed from: g */
    private long f1641g;

    /* renamed from: h */
    private volatile boolean f1642h;

    /* renamed from: i */
    private h f1643i;

    /* renamed from: j */
    private j f1644j;

    /* renamed from: k */
    private long f1645k;

    /* renamed from: l */
    private boolean f1646l;

    /* renamed from: m */
    private boolean f1647m;

    /* renamed from: n */
    private long f1648n;

    /* renamed from: o */
    private long f1649o;

    /* renamed from: p */
    private int f1650p;

    /* renamed from: q */
    private String f1651q;

    /* renamed from: r */
    private C0763v.b f1652r;

    /* renamed from: s */
    private int f1653s;

    /* renamed from: t */
    private int f1654t;

    /* renamed from: u */
    private String f1655u;

    /* renamed from: v */
    private String f1656v;

    /* renamed from: w */
    private C0761t f1657w;

    /* renamed from: x */
    private String f1658x;

    /* renamed from: y */
    private String f1659y;

    /* renamed from: z */
    private String f1660z;

    /* renamed from: com.baidu.location.indoor.n$a */
    class a {
    }

    /* renamed from: com.baidu.location.indoor.n$b */
    class b {

        /* renamed from: e */
        private ArrayList<Double> f1665e;

        /* renamed from: f */
        private ArrayList<String> f1666f;

        /* renamed from: i */
        private Map<String, Integer> f1669i;

        /* renamed from: a */
        public String f1661a = null;

        /* renamed from: g */
        private Map<String, Double> f1667g = null;

        /* renamed from: h */
        private int f1668h = 0;

        /* renamed from: b */
        public int f1662b = 0;

        /* renamed from: c */
        public String f1663c = null;

        public b() {
            this.f1665e = null;
            this.f1666f = null;
            this.f1669i = null;
            this.f1665e = new ArrayList<>();
            this.f1666f = new ArrayList<>();
            this.f1669i = new HashMap();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public int m1392a(BDLocation bDLocation) {
            if (!bDLocation.getBuildingID().equals(this.f1663c)) {
                this.f1663c = bDLocation.getBuildingID();
                m1398a();
            }
            if (m1399b(bDLocation.getRetFields("p_floor")) != 0) {
                this.f1662b = 0;
                return 1;
            }
            try {
                double d = 0.0d;
                if (this.f1666f.size() == 0) {
                    for (Map.Entry<String, Double> entry : this.f1667g.entrySet()) {
                        this.f1666f.add(entry.getKey());
                        this.f1665e.add(entry.getValue());
                    }
                } else {
                    ArrayList<String> arrayList = new ArrayList<>();
                    ArrayList arrayList2 = new ArrayList();
                    Iterator<String> it = this.f1666f.iterator();
                    while (it.hasNext()) {
                        arrayList.add(it.next());
                        arrayList2.add(Double.valueOf(0.0d));
                    }
                    HashMap hashMap = new HashMap();
                    for (Map.Entry<String, Double> entry2 : this.f1667g.entrySet()) {
                        String key = entry2.getKey();
                        Double value = entry2.getValue();
                        hashMap.put(key, value);
                        if (!this.f1666f.contains(key)) {
                            arrayList.add(key);
                            arrayList2.add(value);
                        }
                    }
                    Iterator<Double> it2 = this.f1667g.values().iterator();
                    double d2 = 0.0d;
                    while (it2.hasNext()) {
                        d2 += it2.next().doubleValue();
                    }
                    for (int i = 0; i < arrayList.size(); i++) {
                        arrayList2.set(i, hashMap.containsKey(arrayList.get(i)) ? hashMap.get(arrayList.get(i)) : Double.valueOf((1.0d - d2) / (this.f1668h - hashMap.size())));
                    }
                    ArrayList<Double> arrayList3 = new ArrayList<>();
                    for (int i2 = 0; i2 < arrayList.size(); i2++) {
                        arrayList3.add(Double.valueOf(0.0d));
                    }
                    for (int i3 = 0; i3 < this.f1666f.size(); i3++) {
                        Double d3 = this.f1665e.get(i3);
                        ArrayList<Double> m1397a = m1397a(arrayList, this.f1666f.get(i3));
                        for (int i4 = 0; i4 < arrayList.size(); i4++) {
                            arrayList3.set(i4, Double.valueOf(arrayList3.get(i4).doubleValue() + (d3.doubleValue() * m1397a.get(i4).doubleValue() * ((Double) arrayList2.get(i4)).doubleValue())));
                        }
                    }
                    this.f1666f = arrayList;
                    this.f1665e = m1396a(arrayList3);
                }
                String str = null;
                for (int i5 = 0; i5 < this.f1666f.size(); i5++) {
                    if (this.f1665e.get(i5).doubleValue() > d) {
                        d = this.f1665e.get(i5).doubleValue();
                        str = this.f1666f.get(i5);
                    }
                }
                this.f1661a = str;
            } catch (Exception unused) {
                this.f1662b = 0;
            }
            this.f1662b = 1;
            return 0;
        }

        /* renamed from: a */
        private int m1394a(String str) {
            if (this.f1669i.containsKey(str)) {
                return this.f1669i.get(str).intValue();
            }
            int i = 1000;
            if (!str.startsWith("F") && !str.startsWith("f")) {
                if (str.startsWith("B") || str.startsWith("b")) {
                    i = -Integer.parseInt(str.substring(1));
                }
                this.f1669i.put(str, Integer.valueOf(i));
                return i;
            }
            i = Integer.parseInt(str.substring(1)) - 1;
            this.f1669i.put(str, Integer.valueOf(i));
            return i;
        }

        /* renamed from: a */
        private ArrayList<Double> m1396a(ArrayList<Double> arrayList) {
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

        /* renamed from: a */
        private ArrayList<Double> m1397a(ArrayList<String> arrayList, String str) {
            ArrayList<Double> arrayList2 = new ArrayList<>();
            double[] dArr = {180.0d, 10.0d, 1.0d};
            int m1394a = m1394a(str);
            Iterator<String> it = arrayList.iterator();
            if (m1394a == 1000) {
                while (it.hasNext()) {
                    arrayList2.add(Double.valueOf(it.next().equals(str) ? dArr[0] : dArr[2]));
                }
                return arrayList2;
            }
            while (it.hasNext()) {
                int m1394a2 = m1394a(it.next());
                int i = m1394a2 == 1000 ? 2 : m1394a > m1394a2 ? m1394a - m1394a2 : m1394a2 - m1394a;
                if (i > 2) {
                    i = 2;
                }
                arrayList2.add(Double.valueOf(dArr[i]));
            }
            return arrayList2;
        }

        /* renamed from: a */
        private void m1398a() {
            this.f1665e.clear();
            this.f1666f.clear();
            this.f1669i.clear();
        }

        /* renamed from: b */
        private int m1399b(String str) {
            try {
                String[] split = str.split(";");
                if (split.length <= 1) {
                    return 1;
                }
                this.f1668h = Integer.parseInt(split[0]);
                this.f1667g = new HashMap();
                for (int i = 1; i < split.length; i++) {
                    String[] split2 = split[i].split(":");
                    this.f1667g.put(split2[0], Double.valueOf(Double.parseDouble(split2[1])));
                }
                return 0;
            } catch (Exception unused) {
                return 1;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: b */
        public String m1400b() {
            return this.f1661a;
        }
    }

    /* renamed from: com.baidu.location.indoor.n$c */
    class c {

        /* renamed from: d */
        private float f1673d = -0.18181887f;

        /* renamed from: e */
        private float f1674e = -0.90904963f;

        /* renamed from: f */
        private float f1675f = -0.55321634f;

        /* renamed from: g */
        private float f1676g = -0.05259979f;

        /* renamed from: h */
        private float f1677h = 24.0f;

        /* renamed from: i */
        private float f1678i = 8.61f;

        /* renamed from: j */
        private float f1679j = 4.25f;

        /* renamed from: k */
        private float f1680k = 60.39f;

        /* renamed from: l */
        private float f1681l = 15.6f;

        /* renamed from: m */
        private float f1682m = 68.07f;

        /* renamed from: n */
        private float f1683n = 11.61f;

        /* renamed from: a */
        public ArrayList<ArrayList<Float>> f1670a = null;

        /* renamed from: b */
        public double[] f1671b = null;

        public c() {
        }

        /* renamed from: a */
        public double m1401a(double d, double d2, double d3, double d4) {
            double[] m1402a = m1402a(d2, d3);
            double abs = Math.abs(d4 - m1402a[0]);
            return abs > m1402a[1] * 2.0d ? d + abs : d;
        }

        /* renamed from: a */
        public double[] m1402a(double d, double d2) {
            return C0674a.m623a().m629a(d, d2);
        }
    }

    /* renamed from: com.baidu.location.indoor.n$d */
    public class d extends Handler {
        public d() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (ServiceC0702f.isServing) {
                int i = message.what;
                if (i == 21) {
                    C0755n.this.m1332a(message);
                    return;
                }
                if (i == 41) {
                    C0755n.this.m1363k();
                } else if (i != 801) {
                    super.dispatchMessage(message);
                } else {
                    C0755n.this.m1333a((BDLocation) message.obj);
                }
            }
        }
    }

    /* renamed from: com.baidu.location.indoor.n$e */
    class e {

        /* renamed from: b */
        private double f1686b = -1.0d;

        /* renamed from: c */
        private long f1687c = 0;

        /* renamed from: d */
        private long f1688d = 0;

        /* renamed from: e */
        private long f1689e = 0;

        /* renamed from: f */
        private long f1690f = 0;

        /* renamed from: g */
        private long f1691g = 0;

        /* renamed from: h */
        private long f1692h = 0;

        /* renamed from: i */
        private long f1693i = 0;

        /* renamed from: j */
        private long f1694j = 0;

        /* renamed from: k */
        private long f1695k = 0;

        /* renamed from: l */
        private double f1696l = 0.0d;

        /* renamed from: m */
        private double f1697m = 0.0d;

        /* renamed from: n */
        private double f1698n = 0.0d;

        /* renamed from: o */
        private double f1699o = 0.0d;

        /* renamed from: p */
        private int f1700p = 0;

        /* renamed from: q */
        private int f1701q = 0;

        /* renamed from: r */
        private C0714l f1702r = null;

        /* renamed from: s */
        private long f1703s = 0;

        /* renamed from: t */
        private int f1704t = 0;

        /* renamed from: u */
        private int f1705u = 0;

        public e() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public void m1404a() {
            this.f1686b = -1.0d;
            this.f1687c = 0L;
            this.f1688d = 0L;
            this.f1690f = 0L;
            this.f1691g = 0L;
            this.f1692h = 0L;
            this.f1693i = 0L;
            this.f1694j = 0L;
            this.f1695k = 0L;
            this.f1696l = 0.0d;
            this.f1697m = 0.0d;
            this.f1700p = 0;
            this.f1701q = 0;
            this.f1702r = null;
            this.f1703s = 0L;
            this.f1704t = 0;
            this.f1705u = 0;
            this.f1689e = 0L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public void m1405a(double d, double d2, double d3, long j) {
            this.f1694j = j;
            this.f1705u = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public void m1406a(Location location, boolean z) {
            this.f1695k = System.currentTimeMillis();
            double longitude = location.getLongitude();
            double latitude = location.getLatitude();
            double d = this.f1696l;
            if (d != 0.0d) {
                float[] fArr = new float[2];
                Location.distanceBetween(this.f1697m, d, latitude, longitude, fArr);
                if (fArr[0] < 20.0f) {
                    this.f1700p++;
                } else {
                    this.f1700p = 0;
                }
                if (fArr[0] < 5.0f) {
                    this.f1701q++;
                } else {
                    this.f1701q = 0;
                }
            }
            this.f1696l = longitude;
            this.f1697m = latitude;
            if (location.hasSpeed() && location.getSpeed() > 3.0f) {
                this.f1692h = System.currentTimeMillis();
            }
            if (location.getAccuracy() >= 50.0f || z) {
                this.f1704t = 0;
            } else {
                this.f1704t++;
            }
            if (this.f1704t <= 10 || System.currentTimeMillis() - this.f1687c <= 30000) {
                return;
            }
            C0755n.this.m1386d();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public boolean m1409a(double d, double d2, double d3) {
            if (!C0755n.this.f1633af.m1415c()) {
                return true;
            }
            long currentTimeMillis = System.currentTimeMillis();
            long j = this.f1690f;
            if (j != 0 && currentTimeMillis - j > Constant.DELAY_MILLIS) {
                return true;
            }
            if (this.f1701q >= 5 && d3 < 15.0d && currentTimeMillis - this.f1687c > SilenceSkippingAudioProcessor.DEFAULT_PADDING_SILENCE_US) {
                float[] fArr = new float[2];
                Location.distanceBetween(this.f1699o, this.f1698n, d2, d, fArr);
                if (fArr[0] > 30.0f) {
                    return true;
                }
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public boolean m1410a(BDLocation bDLocation, double d, String str) {
            long currentTimeMillis = System.currentTimeMillis();
            this.f1693i = currentTimeMillis;
            this.f1686b = d;
            this.f1698n = bDLocation.getLongitude();
            this.f1699o = bDLocation.getLatitude();
            if (str.equals("wifi")) {
                this.f1687c = currentTimeMillis;
            }
            if (str.equals("gps")) {
                this.f1689e = currentTimeMillis;
            }
            if (m1419e()) {
                this.f1690f = currentTimeMillis;
            }
            C0755n c0755n = C0755n.this;
            c0755n.f1638d = c0755n.m1381a(bDLocation.getLongitude(), bDLocation.getLatitude());
            if (C0755n.this.f1638d || C0755n.this.f1637c == 1) {
                this.f1691g = currentTimeMillis;
            }
            long j = this.f1703s;
            if (j != 0 && currentTimeMillis - j > 30000 && currentTimeMillis - this.f1694j < Constant.DELAY_MILLIS && currentTimeMillis - this.f1695k < Constant.DELAY_MILLIS) {
                return false;
            }
            if (this.f1704t > 10 && currentTimeMillis - this.f1687c > 30000) {
                return false;
            }
            if (currentTimeMillis - this.f1691g > Constant.DELAY_MILLIS && currentTimeMillis - this.f1687c > 30000) {
                return false;
            }
            long j2 = this.f1690f;
            return j2 == 0 || currentTimeMillis - j2 <= 60000;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: b */
        public boolean m1414b() {
            System.currentTimeMillis();
            if (C0755n.this.f1646l || this.f1700p < 3) {
                return false;
            }
            if (!C0715m.m1058a().m1075i().contains("&wifio") && C0755n.this.f1637c != 1) {
                return false;
            }
            this.f1705u = 1;
            return true;
        }

        /* renamed from: c */
        private boolean m1415c() {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.f1692h < Constant.DELAY_MILLIS && currentTimeMillis - this.f1687c > 30000) {
                return false;
            }
            if (currentTimeMillis - this.f1695k >= Constant.DELAY_MILLIS) {
                return true;
            }
            long j = this.f1694j;
            return j == 0 || currentTimeMillis - j <= Cea608Decoder.MIN_DATA_CHANNEL_TIMEOUT_MS || currentTimeMillis - this.f1687c <= 30000;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: d */
        public void m1417d() {
            long currentTimeMillis = System.currentTimeMillis();
            C0714l m1084r = C0715m.m1058a().m1084r();
            if (m1084r.f1188a == null) {
                return;
            }
            C0714l c0714l = this.f1702r;
            if (c0714l == null || !m1084r.m1044b(c0714l)) {
                if (currentTimeMillis - this.f1703s < Constant.DELAY_MILLIS) {
                    this.f1688d = currentTimeMillis;
                }
                this.f1703s = currentTimeMillis;
                this.f1702r = m1084r;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: e */
        public boolean m1419e() {
            if (this.f1705u == 1 || !m1415c() || this.f1686b > 25.0d || System.currentTimeMillis() - this.f1693i > 30000) {
                return false;
            }
            this.f1690f = System.currentTimeMillis();
            return true;
        }
    }

    /* renamed from: com.baidu.location.indoor.n$f */
    private static class f {

        /* renamed from: a */
        private static C0755n f1706a = new C0755n(null);
    }

    /* renamed from: com.baidu.location.indoor.n$g */
    private class g {

        /* renamed from: a */
        public int f1707a = 10;

        /* renamed from: c */
        private List<a> f1709c = Collections.synchronizedList(new ArrayList());

        /* renamed from: com.baidu.location.indoor.n$g$a */
        private class a {

            /* renamed from: a */
            public double f1710a;

            /* renamed from: b */
            public double f1711b;

            /* renamed from: c */
            public double f1712c;

            public a(double d, double d2, double d3) {
                this.f1710a = d;
                this.f1711b = d2;
                this.f1712c = d3;
            }
        }

        public g() {
        }

        /* renamed from: a */
        public void m1426a(BDLocation bDLocation) {
            this.f1709c.add(new a(bDLocation.getLongitude(), bDLocation.getLatitude(), C0755n.this.f1633af.f1686b));
        }

        public String toString() {
            if (this.f1709c.size() == 0) {
                return "";
            }
            try {
                StringBuffer stringBuffer = new StringBuffer();
                double d = this.f1709c.get(0).f1710a;
                double d2 = this.f1709c.get(0).f1711b;
                stringBuffer.append(String.format("%.6f:%.6f:%.1f", Double.valueOf(d), Double.valueOf(d2), Double.valueOf(this.f1709c.get(0).f1712c)));
                int size = (this.f1709c.size() > this.f1707a ? this.f1709c.size() - this.f1707a : 0) + 1;
                while (size < this.f1709c.size()) {
                    stringBuffer.append(String.format(";%.0f:%.0f:%.1f", Double.valueOf((this.f1709c.get(size).f1710a - d) * 1000000.0d), Double.valueOf((this.f1709c.get(size).f1711b - d2) * 1000000.0d), Double.valueOf(this.f1709c.get(size).f1712c)));
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

    /* renamed from: com.baidu.location.indoor.n$h */
    class h extends Thread {

        /* renamed from: b */
        private volatile boolean f1715b = true;

        /* renamed from: c */
        private long f1716c = 0;

        /* renamed from: d */
        private long f1717d = 0;

        /* renamed from: e */
        private long f1718e = 0;

        h() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            C0755n c0755n;
            long j;
            while (this.f1715b) {
                if (C0755n.this.f1637c != 1 || C0755n.this.f1638d) {
                    c0755n = C0755n.this;
                    j = 3000;
                } else {
                    c0755n = C0755n.this;
                    j = 5000;
                }
                c0755n.f1641g = j;
                if (System.currentTimeMillis() - this.f1716c > C0755n.this.f1641g) {
                    C0715m.m1058a().m1076j();
                    this.f1716c = System.currentTimeMillis();
                    C0755n.this.f1642h = false;
                }
                if (C0715m.m1058a().m1085s()) {
                    this.f1718e = 0L;
                } else {
                    long j2 = this.f1718e + 1;
                    this.f1718e = j2;
                    if (j2 >= 10) {
                        this.f1715b = false;
                        C0755n.this.m1386d();
                        return;
                    }
                }
                if (C0755n.this.f1646l && C0755n.this.f1633af != null && System.currentTimeMillis() - C0755n.this.f1649o > 30000 && System.currentTimeMillis() - C0755n.this.f1633af.f1690f > 30000) {
                    C0755n.m1327a().m1386d();
                }
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException unused) {
                    this.f1715b = false;
                    return;
                }
            }
        }
    }

    /* renamed from: com.baidu.location.indoor.n$i */
    private class i {

        /* renamed from: a */
        public int f1719a;

        /* renamed from: b */
        public double f1720b;

        /* renamed from: c */
        public double f1721c;

        /* renamed from: d */
        public int f1722d = 1;

        /* renamed from: e */
        public double f1723e;

        public i(int i, double d, double d2, double d3) {
            this.f1719a = i;
            this.f1720b = d;
            this.f1721c = d2;
            this.f1723e = d3;
        }

        public String toString() {
            return this.f1721c == this.f1723e ? String.format("%d:%.1f:%.2f", Integer.valueOf(this.f1722d), Double.valueOf(this.f1721c), Double.valueOf(this.f1720b)) : String.format("%d:%.1f:%.2f:%.1f", Integer.valueOf(this.f1722d), Double.valueOf(this.f1721c), Double.valueOf(this.f1720b), Double.valueOf(this.f1723e));
        }
    }

    /* renamed from: com.baidu.location.indoor.n$j */
    class j extends AbstractC0725g {

        /* renamed from: b */
        private boolean f1726b = false;

        /* renamed from: c */
        private boolean f1727c = false;

        /* renamed from: d */
        private String f1728d = null;

        /* renamed from: e */
        private String f1729e = null;

        /* renamed from: f */
        private long f1730f = 0;

        /* renamed from: r */
        private a f1731r = null;

        /* renamed from: s */
        private long f1732s = 0;

        /* renamed from: t */
        private long f1733t = 0;

        public j() {
            this.f1292k = new HashMap();
        }

        /* renamed from: a */
        public void m1428a() {
            boolean z;
            if (this.f1726b) {
                this.f1727c = true;
                return;
            }
            if (C0755n.this.f1637c != 1 || C0755n.this.f1638d || System.currentTimeMillis() - this.f1730f >= 30000 || System.currentTimeMillis() - C0755n.this.f1633af.f1687c <= 30000) {
                long currentTimeMillis = System.currentTimeMillis() - this.f1732s;
                if (currentTimeMillis >= 1000 || currentTimeMillis <= 0) {
                    StringBuffer stringBuffer = new StringBuffer(1024);
                    String m903i = C0704b.m912a().m940f().m903i();
                    String m1026f = C0709g.m959a().m1026f();
                    stringBuffer.append(C0709g.m959a().m1032m());
                    C0755n.this.f1608H = 0.5d;
                    if (C0755n.this.f1617Q == null || C0755n.this.f1617Q.m1249d() == null || !C0755n.this.f1617Q.m1251f()) {
                        z = false;
                    } else {
                        stringBuffer.append("&bleand=").append(C0755n.this.f1617Q.m1249d());
                        stringBuffer.append("&bleand_et=").append(C0755n.this.f1617Q.m1250e());
                        z = true;
                    }
                    C0714l m1084r = C0715m.m1058a().m1084r();
                    String m1329a = C0755n.this.m1329a(m1084r);
                    if (m1329a == null) {
                        m1329a = m1084r.m1039a(C0755n.this.f1639e, true, false);
                    }
                    if (!z) {
                        if (m1329a == null || m1329a.length() < 10) {
                            return;
                        }
                        String str = this.f1729e;
                        if (str != null && str.equals(m1329a)) {
                            return;
                        }
                    }
                    this.f1729e = m1329a;
                    this.f1726b = true;
                    stringBuffer.append(m903i);
                    if (m1026f != null) {
                        stringBuffer.append(m1026f);
                    }
                    stringBuffer.append("&coor=gcj02");
                    stringBuffer.append("&lt=1");
                    if (m1329a != null && !"null".equals(m1329a) && !"".equals(m1329a)) {
                        stringBuffer.append(m1329a);
                    }
                    String m1450d = C0763v.m1437a().m1450d();
                    if (C0755n.this.f1613M <= 2 && m1450d != null) {
                        stringBuffer.append("&idsl=" + m1450d);
                    }
                    int size = C0755n.this.f1611K.size();
                    stringBuffer.append(C0755n.this.m1328a(size));
                    C0755n.this.f1612L = size;
                    C0755n.m1379y(C0755n.this);
                    stringBuffer.append("&drsi=" + C0755n.this.f1613M);
                    stringBuffer.append("&drc=" + C0755n.this.f1653s);
                    if (C0755n.this.f1606F != 0.0d && C0755n.this.f1607G != 0.0d) {
                        stringBuffer.append("&lst_idl=" + String.format(Locale.CHINA, "%.5f:%.5f", Double.valueOf(C0755n.this.f1606F), Double.valueOf(C0755n.this.f1607G)));
                    }
                    C0755n.this.f1653s = 0;
                    stringBuffer.append("&idpfv=1");
                    stringBuffer.append("&iflxy=" + C0755n.this.f1634ag.toString());
                    C0755n.this.f1634ag.f1709c.clear();
                    C0755n.m1321C(C0755n.this);
                    if (C0755n.this.f1616P != null) {
                        stringBuffer.append(C0755n.this.f1616P);
                        C0755n.this.f1616P = null;
                    }
                    String m339d = C0648b.m321a().m339d();
                    if (m339d != null) {
                        stringBuffer.append(m339d);
                    }
                    stringBuffer.append(C0720b.m1100a().m1101a(true));
                    stringBuffer.append(C0649c.m358a().m369c());
                    stringBuffer.append(C0733o.m1163e(ServiceC0702f.getServiceContext()));
                    int m1156c = C0733o.m1156c(ServiceC0702f.getServiceContext());
                    if (m1156c >= 0) {
                        stringBuffer.append("&lmd=").append(m1156c);
                    }
                    this.f1728d = stringBuffer.toString();
                    ExecutorService m591b = C0670x.m590a().m591b();
                    if (m591b != null) {
                        m1129a(m591b, C0722d.f1260c);
                    } else {
                        m1133e(C0722d.f1260c);
                    }
                    this.f1730f = System.currentTimeMillis();
                }
            }
        }

        @Override // com.baidu.location.p012h.AbstractC0725g
        /* renamed from: a */
        public void mo122a(boolean z) {
            if (!z || this.f1291j == null) {
                C0755n.m1375u(C0755n.this);
                C0755n.this.f1622V = 0;
                this.f1726b = false;
                if (C0755n.this.f1650p <= 40) {
                    return;
                } else {
                    C0755n.this.m1386d();
                }
            } else {
                try {
                    String str = this.f1291j;
                    if (str.contains("enc") && C0660n.m467a().m470b()) {
                        try {
                            JSONObject jSONObject = new JSONObject(str);
                            if (jSONObject.has("enc")) {
                                str = C0660n.m467a().m469b(jSONObject.getString("enc"));
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    if (!C0755n.this.f1646l) {
                        this.f1726b = false;
                        return;
                    }
                    BDLocation bDLocation = new BDLocation(str);
                    if (bDLocation.getLocType() == 161 && bDLocation.getBuildingID() != null) {
                        C0755n.this.f1623W = new BDLocation(bDLocation);
                    }
                    String indoorLocationSurpportBuidlingName = bDLocation.getIndoorLocationSurpportBuidlingName();
                    if (indoorLocationSurpportBuidlingName != null && !C0755n.this.f1615O.m1184a(indoorLocationSurpportBuidlingName)) {
                        C0755n.this.f1615O.m1185a(indoorLocationSurpportBuidlingName, (C0735a.a) null);
                    }
                    if (C0755n.this.f1617Q != null) {
                        C0755n.this.f1617Q.m1246a(new C0760s(this));
                    }
                    C0667u.m571a().m574b(true);
                    if (bDLocation.getBuildingName() != null) {
                        C0755n.this.f1659y = bDLocation.getBuildingName();
                    }
                    if (bDLocation.getFloor() != null) {
                        C0755n.this.f1648n = System.currentTimeMillis();
                        long currentTimeMillis = System.currentTimeMillis();
                        this.f1733t = currentTimeMillis;
                        int i = (int) (currentTimeMillis - this.f1732s);
                        if (i > 10000) {
                            C0755n.this.f1622V = 0;
                        } else if (i < 3000) {
                            C0755n.this.f1622V = 2;
                        } else {
                            C0755n.this.f1622V = 1;
                        }
                        if (bDLocation.getFloor().contains("-a")) {
                            C0755n.this.f1609I = true;
                            bDLocation.setFloor(bDLocation.getFloor().split("-")[0]);
                        } else {
                            C0755n.this.f1609I = false;
                        }
                        C0755n.this.f1603C.add(bDLocation.getFloor());
                    }
                    Message obtainMessage = C0755n.this.f1627a.obtainMessage(21);
                    obtainMessage.obj = bDLocation;
                    obtainMessage.sendToTarget();
                } catch (Exception unused) {
                }
            }
            if (this.f1292k != null) {
                this.f1292k.clear();
            }
            this.f1726b = false;
        }

        @Override // com.baidu.location.p012h.AbstractC0725g
        /* renamed from: b */
        public void mo123b() {
            if (C0755n.this.f1656v == null || C0755n.this.f1657w == null || !C0755n.this.f1656v.equals(C0755n.this.f1657w.m1433a())) {
                this.f1728d = "&nd_idf=1&indoor_polygon=1" + this.f1728d;
            }
            this.f1290i = 1;
            if (C0660n.m467a().m470b()) {
                this.f1728d += "&enc=2";
            }
            String encodeTp4 = Jni.encodeTp4(this.f1728d);
            this.f1728d = null;
            this.f1292k.put("bloc", encodeTp4);
            this.f1732s = System.currentTimeMillis();
        }

        /* renamed from: c */
        public synchronized void m1429c() {
            if (this.f1726b) {
                return;
            }
            if (this.f1727c) {
                this.f1727c = false;
                m1428a();
            }
        }
    }

    private C0755n() {
        this.f1637c = 0;
        this.f1638d = false;
        this.f1639e = 32;
        this.f1641g = 3000L;
        this.f1642h = true;
        this.f1627a = null;
        this.f1643i = null;
        this.f1644j = null;
        this.f1645k = 0L;
        this.f1646l = false;
        this.f1647m = false;
        this.f1648n = 0L;
        this.f1649o = 0L;
        this.f1650p = 0;
        this.f1651q = null;
        this.f1653s = 0;
        this.f1654t = 0;
        this.f1655u = null;
        this.f1656v = null;
        this.f1657w = null;
        this.f1658x = null;
        this.f1659y = null;
        this.f1660z = null;
        this.f1601A = 0;
        this.f1602B = 5;
        this.f1603C = null;
        this.f1604D = 20;
        this.f1605E = null;
        this.f1606F = 0.0d;
        this.f1607G = 0.0d;
        this.f1608H = 0.4d;
        this.f1609I = false;
        this.f1610J = true;
        this.f1611K = Collections.synchronizedList(new ArrayList());
        this.f1612L = -1;
        this.f1613M = 0;
        this.f1614N = 0;
        this.f1616P = null;
        this.f1617Q = null;
        this.f1618R = false;
        this.f1619S = false;
        this.f1636b = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.f1622V = 2;
        this.f1623W = null;
        this.f1624X = false;
        this.f1625Y = false;
        this.f1626Z = false;
        this.f1628aa = false;
        this.f1629ab = false;
        this.f1630ac = null;
        this.f1631ad = false;
        this.f1632ae = null;
        this.f1633af = null;
        this.f1634ag = null;
        this.f1635ah = null;
        this.f1640f = false;
        this.f1627a = new d();
        try {
            C0751a.m1275a(ServiceC0702f.getServiceContext());
        } catch (Exception unused) {
        }
        try {
            C0753c.m1314a(ServiceC0702f.getServiceContext());
        } catch (Exception unused2) {
        }
        C0766y c0766y = new C0766y();
        this.f1620T = c0766y;
        c0766y.m1466a(1000L);
        this.f1621U = new C0756o(this);
        this.f1652r = new C0757p(this);
        this.f1644j = new j();
        this.f1603C = new C0746k<>(this.f1602B);
        this.f1605E = new C0746k<>(this.f1604D);
        this.f1615O = new C0735a(ServiceC0702f.getServiceContext());
        this.f1632ae = new c();
        this.f1633af = new e();
        this.f1634ag = new g();
        this.f1635ah = new b();
    }

    /* synthetic */ C0755n(C0756o c0756o) {
        this();
    }

    /* renamed from: C */
    static /* synthetic */ int m1321C(C0755n c0755n) {
        int i2 = c0755n.f1614N;
        c0755n.f1614N = i2 + 1;
        return i2;
    }

    /* renamed from: a */
    public static C0755n m1327a() {
        return f.f1706a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public String m1328a(int i2) {
        if (this.f1611K.size() == 0) {
            return "&dr=0:0";
        }
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("&dr=");
            this.f1611K.get(0).f1722d = 1;
            sb.append(this.f1611K.get(0).toString());
            int i3 = this.f1611K.get(0).f1719a;
            for (int i4 = 1; i4 < this.f1611K.size() && i4 <= i2; i4++) {
                this.f1611K.get(i4).f1722d = this.f1611K.get(i4).f1719a - i3;
                sb.append(";");
                sb.append(this.f1611K.get(i4).toString());
                i3 = this.f1611K.get(i4).f1719a;
            }
            return sb.toString();
        } catch (Exception e2) {
            e2.printStackTrace();
            return "&dr=0:0";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public String m1329a(C0714l c0714l) {
        String str;
        String m1039a;
        StringBuilder sb;
        int m1037a = c0714l.m1037a();
        int i2 = this.f1639e;
        if (m1037a <= i2) {
            m1039a = c0714l.m1039a(i2, true, true);
            str = "&aprk=0";
            if (m1039a == null || "null".equals(m1039a)) {
                return "&aprk=0";
            }
            sb = new StringBuilder();
        } else {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (int i3 = 0; i3 < m1037a; i3++) {
                String lowerCase = c0714l.f1188a.get(i3).BSSID.replaceAll(":", "").toLowerCase();
                C0735a c0735a = this.f1615O;
                if (c0735a == null || !c0735a.m1186b(lowerCase)) {
                    arrayList2.add(c0714l.f1188a.get(i3));
                } else {
                    arrayList.add(c0714l.f1188a.get(i3));
                }
            }
            str = arrayList.size() > 0 ? "&aprk=3" : "";
            if ("".equals(str)) {
                C0735a c0735a2 = this.f1615O;
                str = (c0735a2 == null || !c0735a2.m1183a()) ? "&aprk=1" : "&aprk=2";
            }
            arrayList.addAll(arrayList2);
            c0714l.f1188a = arrayList;
            m1039a = c0714l.m1039a(this.f1639e, true, true);
            sb = new StringBuilder();
        }
        return sb.append(m1039a).append(str).toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m1332a(Message message) {
        boolean z;
        C0761t c0761t;
        if (this.f1646l) {
            this.f1647m = false;
            BDLocation bDLocation = (BDLocation) message.obj;
            if (bDLocation.getLocType() == 161) {
                m1367m();
                if (bDLocation.getIndoorSurpportPolygon() != null && bDLocation.getIndoorLocationSurpportBuidlingID() != null && ((c0761t = this.f1657w) == null || !c0761t.m1433a().equals(bDLocation.getBuildingID()))) {
                    String[] split = bDLocation.getIndoorSurpportPolygon().split("\\|");
                    Location[] locationArr = new Location[split.length];
                    for (int i2 = 0; i2 < split.length; i2++) {
                        String[] split2 = split[i2].split(",");
                        Location location = new Location("gps");
                        location.setLatitude(Double.valueOf(split2[1]).doubleValue());
                        location.setLongitude(Double.valueOf(split2[0]).doubleValue());
                        locationArr[i2] = location;
                    }
                    this.f1657w = new C0761t(bDLocation.getIndoorLocationSurpportBuidlingID(), locationArr);
                }
                if (m1391i() && bDLocation != null && bDLocation.getLocType() == 161) {
                    if ("ble".equals(bDLocation.getNetworkLocationType())) {
                        C0748m.m1257a(bDLocation.getLongitude(), bDLocation.getLatitude(), bDLocation.getFloor(), bDLocation.getInOutStatus(), System.currentTimeMillis(), C0741f.m1211a().m1224d());
                        this.f1619S = true;
                    } else {
                        C0748m.m1257a(0.0d, 0.0d, bDLocation.getFloor(), bDLocation.getInOutStatus(), System.currentTimeMillis(), C0741f.m1211a().m1224d());
                        this.f1619S = false;
                    }
                }
                this.f1650p = 0;
                if (bDLocation.getBuildingID() != null) {
                    this.f1647m = true;
                    bDLocation.setIndoorLocMode(true);
                    if (bDLocation.getRetFields("tp") == null || !bDLocation.getRetFields("tp").equalsIgnoreCase("ble")) {
                        this.f1618R = false;
                    } else {
                        bDLocation.setRadius(8.0f);
                        bDLocation.setNetworkLocationType("ble");
                        this.f1618R = true;
                    }
                    this.f1656v = bDLocation.getBuildingID();
                    this.f1658x = bDLocation.getBuildingName();
                    this.f1660z = bDLocation.getNetworkLocationType();
                    this.f1601A = bDLocation.isParkAvailable();
                    this.f1635ah.m1392a(bDLocation);
                    String floor = bDLocation.getFloor();
                    String m1364l = m1364l();
                    if (floor != null && m1364l != null && !floor.equals(m1364l)) {
                        return;
                    }
                    if (this.f1655u == null) {
                        this.f1655u = bDLocation.getFloor();
                    }
                    C0751a.m1274a().m1297a(bDLocation.getLongitude(), bDLocation.getLatitude());
                    m1338a(bDLocation.getBuildingName(), bDLocation.getFloor());
                    if (floor != null && m1364l != null && !floor.equals(m1364l)) {
                        return;
                    }
                    if (!floor.equalsIgnoreCase(this.f1655u) && this.f1626Z) {
                        this.f1633af.m1404a();
                        C0750a.m1273c();
                        this.f1628aa = C0750a.m1268a(bDLocation.getFloor());
                    }
                    this.f1655u = bDLocation.getFloor();
                    double m1449c = C0763v.m1437a().m1449c();
                    if (m1449c >= 0.0d && bDLocation.getDirection() <= 0.0f) {
                        bDLocation.setDirection((float) m1449c);
                    }
                    double[] m1271a = C0750a.m1271a(this.f1619S, bDLocation);
                    if (m1271a != null && m1271a[0] != -1.0d && m1271a[0] == 0.0d) {
                        bDLocation.setLongitude(m1271a[1]);
                        bDLocation.setLatitude(m1271a[2]);
                        bDLocation.setFusionLocInfo("res", m1271a);
                        bDLocation.setRadius((float) m1271a[5]);
                        bDLocation.setDirection((float) m1271a[6]);
                        bDLocation.setSpeed((float) m1271a[8]);
                        if (!this.f1633af.m1410a(bDLocation, m1271a[5], "wifi")) {
                            m1386d();
                            return;
                        }
                    }
                } else if (m1391i() && (z = this.f1619S)) {
                    double[] m1271a2 = C0750a.m1271a(z, bDLocation);
                    if (m1271a2 != null && m1271a2[0] != -1.0d && m1271a2[0] == 0.0d) {
                        bDLocation.setLongitude(m1271a2[1]);
                        bDLocation.setLatitude(m1271a2[2]);
                        bDLocation.setFusionLocInfo("res", m1271a2);
                        bDLocation.setRadius((float) m1271a2[5]);
                        bDLocation.setDirection((float) m1271a2[6]);
                        bDLocation.setSpeed((float) m1271a2[8]);
                        if (!this.f1633af.m1410a(bDLocation, m1271a2[5], "wifi")) {
                            m1386d();
                            return;
                        }
                    }
                }
                this.f1607G = bDLocation.getLatitude();
                this.f1606F = bDLocation.getLongitude();
            } else if (bDLocation.getLocType() == 63) {
                int i3 = this.f1650p + 1;
                this.f1650p = i3;
                if (i3 <= 10) {
                    return;
                } else {
                    m1386d();
                }
            } else {
                this.f1650p = 0;
            }
            if (this.f1647m) {
                if (bDLocation.getTime() == null) {
                    bDLocation.setTime(this.f1636b.format(new Date()));
                }
                BDLocation bDLocation2 = new BDLocation(bDLocation);
                bDLocation2.setNetworkLocationType(bDLocation2.getNetworkLocationType() + GeoFence.BUNDLE_KEY_CUSTOMID);
                C0766y c0766y = this.f1620T;
                if (c0766y == null || !c0766y.m1469c()) {
                    m1334a(bDLocation2, 21);
                } else {
                    this.f1620T.m1467a(bDLocation2);
                }
            }
            this.f1644j.m1429c();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m1333a(BDLocation bDLocation) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x005d, code lost:
    
        if ("unknow".equals(r3) == false) goto L12;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m1334a(com.baidu.location.BDLocation r7, int r8) {
        /*
            Method dump skipped, instructions count: 425
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.indoor.C0755n.m1334a(com.baidu.location.BDLocation, int):void");
    }

    /* renamed from: a */
    private void m1338a(String str, String str2) {
        String str3 = this.f1658x;
        if (str3 != null && str3.equals(str) && this.f1626Z) {
            return;
        }
        C0751a m1274a = C0751a.m1274a();
        m1274a.m1298a("gcj02");
        m1274a.m1299a(str, new C0758q(this, str, str2));
    }

    /* renamed from: f */
    static /* synthetic */ int m1356f(C0755n c0755n) {
        int i2 = c0755n.f1653s;
        c0755n.f1653s = i2 + 1;
        return i2;
    }

    /* renamed from: j */
    private void m1360j() {
        this.f1603C.clear();
        this.f1605E.clear();
        this.f1648n = 0L;
        this.f1650p = 0;
        this.f1601A = 0;
        this.f1654t = 0;
        this.f1655u = null;
        this.f1656v = null;
        this.f1658x = null;
        this.f1659y = null;
        this.f1660z = null;
        this.f1610J = true;
        this.f1608H = 0.4d;
        this.f1618R = false;
        this.f1619S = false;
        this.f1606F = 0.0d;
        this.f1607G = 0.0d;
        this.f1609I = false;
        this.f1613M = 0;
        this.f1653s = 0;
        this.f1651q = null;
        this.f1649o = 0L;
        this.f1633af.m1404a();
        C0750a.m1273c();
        if (this.f1626Z) {
            C0751a.m1274a().m1301b();
        }
        this.f1628aa = false;
        this.f1626Z = false;
        C0667u.m571a().m574b(false);
        C0747l c0747l = this.f1617Q;
        if (c0747l != null) {
            c0747l.m1247b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k */
    public void m1363k() {
        if (this.f1646l) {
            this.f1642h = true;
            this.f1633af.m1417d();
            this.f1644j.m1428a();
            this.f1645k = System.currentTimeMillis();
        }
    }

    /* renamed from: l */
    private String m1364l() {
        String str;
        C0746k<String> c0746k;
        if (this.f1635ah.f1662b == 1 && this.f1635ah.f1661a != null) {
            return this.f1635ah.m1400b();
        }
        HashMap hashMap = new HashMap();
        int size = this.f1603C.size();
        String str2 = null;
        int i2 = -1;
        String str3 = "";
        for (int i3 = 0; i3 < size; i3++) {
            try {
                String str4 = this.f1603C.get(i3);
                str3 = str3 + str4 + "|";
                hashMap.put(str4, hashMap.containsKey(str4) ? Integer.valueOf(((Integer) hashMap.get(str4)).intValue() + 1) : 1);
            } catch (Exception unused) {
                return this.f1655u;
            }
        }
        for (String str5 : hashMap.keySet()) {
            if (((Integer) hashMap.get(str5)).intValue() > i2) {
                i2 = ((Integer) hashMap.get(str5)).intValue();
                str2 = str5;
            }
        }
        return (str2 == null || (str = this.f1655u) == null || str2.equals(str) || (c0746k = this.f1603C) == null || c0746k.size() != this.f1602B) ? str2 : (this.f1603C.get(size + (-3)).equals(str2) && this.f1603C.get(size + (-2)).equals(str2) && this.f1603C.get(size - 1).equals(str2)) ? str2 : this.f1655u;
    }

    /* renamed from: m */
    private void m1367m() {
        for (int i2 = this.f1612L; i2 >= 0 && this.f1611K.size() > 0; i2--) {
            this.f1611K.remove(0);
        }
        this.f1612L = -1;
    }

    /* renamed from: u */
    static /* synthetic */ int m1375u(C0755n c0755n) {
        int i2 = c0755n.f1650p;
        c0755n.f1650p = i2 + 1;
        return i2;
    }

    /* renamed from: y */
    static /* synthetic */ int m1379y(C0755n c0755n) {
        int i2 = c0755n.f1613M;
        c0755n.f1613M = i2 + 1;
        return i2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0054, code lost:
    
        r8 = r4.f1595b;
        r2 = r4.f1594a;
        r8 = r4.f1600g;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean m1381a(double r8, double r10) {
        /*
            r7 = this;
            com.baidu.location.indoor.mapversion.b.c r0 = com.baidu.location.indoor.mapversion.p014b.C0753c.m1313a()
            boolean r0 = r0.m1316c()
            r1 = 0
            if (r0 == 0) goto L68
            com.baidu.location.indoor.mapversion.b.c r0 = com.baidu.location.indoor.mapversion.p014b.C0753c.m1313a()
            boolean r0 = r0.m1315b()
            if (r0 != 0) goto L16
            goto L68
        L16:
            com.baidu.location.indoor.mapversion.b.c r0 = com.baidu.location.indoor.mapversion.p014b.C0753c.m1313a()
            java.util.Map r0 = r0.m1317d()
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
            com.baidu.location.indoor.mapversion.b.c$b r4 = (com.baidu.location.indoor.mapversion.p014b.C0753c.b) r4     // Catch: java.lang.Exception -> L5b java.util.ConcurrentModificationException -> L60
            double r5 = r4.f1598e     // Catch: java.lang.Exception -> L5b java.util.ConcurrentModificationException -> L60
            int r5 = (r8 > r5 ? 1 : (r8 == r5 ? 0 : -1))
            if (r5 <= 0) goto L2a
            double r5 = r4.f1596c     // Catch: java.lang.Exception -> L5b java.util.ConcurrentModificationException -> L60
            int r5 = (r8 > r5 ? 1 : (r8 == r5 ? 0 : -1))
            if (r5 >= 0) goto L2a
            double r5 = r4.f1599f     // Catch: java.lang.Exception -> L5b java.util.ConcurrentModificationException -> L60
            int r5 = (r10 > r5 ? 1 : (r10 == r5 ? 0 : -1))
            if (r5 <= 0) goto L2a
            double r5 = r4.f1597d     // Catch: java.lang.Exception -> L5b java.util.ConcurrentModificationException -> L60
            int r5 = (r10 > r5 ? 1 : (r10 == r5 ? 0 : -1))
            if (r5 >= 0) goto L2a
            java.lang.String r8 = r4.f1595b     // Catch: java.lang.Exception -> L5b java.util.ConcurrentModificationException -> L60
            java.lang.String r2 = r4.f1594a     // Catch: java.lang.Exception -> L5b java.util.ConcurrentModificationException -> L60
            java.lang.String r8 = r4.f1600g     // Catch: java.lang.Exception -> L5b java.util.ConcurrentModificationException -> L60
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
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.indoor.C0755n.m1381a(double, double):boolean");
    }

    /* renamed from: a */
    public boolean m1382a(Location location, ArrayList<ArrayList<Float>> arrayList) {
        int size = arrayList.size();
        if (m1391i()) {
            double[] coorEncrypt = Jni.coorEncrypt(location.getLongitude(), location.getLatitude(), BDLocation.BDLOCATION_WGS84_TO_GCJ02);
            C0748m.m1256a(coorEncrypt[0], coorEncrypt[1], location.getAccuracy(), location.getSpeed(), location.getBearing(), location.getAltitude(), size, System.currentTimeMillis());
        }
        if (size == 0 || !C0709g.m959a().m1031k() || (!this.f1646l && location.getSpeed() > 3.0f)) {
            return false;
        }
        double[] coorEncrypt2 = Jni.coorEncrypt(location.getLongitude(), location.getLatitude(), BDLocation.BDLOCATION_WGS84_TO_GCJ02);
        double d2 = coorEncrypt2[0];
        double d3 = coorEncrypt2[1];
        double accuracy = location.getAccuracy();
        location.getBearing();
        double altitude = location.getAltitude();
        location.getSpeed();
        boolean z = m1381a(d2, d3) || this.f1637c == 1;
        if (!this.f1646l && !z) {
            return false;
        }
        try {
            this.f1633af.m1406a(location, z);
        } catch (Exception unused) {
        }
        if (this.f1633af.m1414b()) {
            m1385c();
            return true;
        }
        if (!m1387e()) {
            return false;
        }
        if (this.f1633af.m1409a(d2, d3, accuracy)) {
            C0750a.m1273c();
        }
        this.f1632ae.m1401a(accuracy, d2, d3, altitude);
        return false;
    }

    /* renamed from: a */
    public boolean m1383a(Bundle bundle) {
        if (bundle == null) {
            return false;
        }
        this.f1637c = bundle.getInt(RtspHeaders.Values.MODE);
        return true;
    }

    /* renamed from: b */
    public synchronized void m1384b() {
        if (this.f1646l) {
            this.f1603C.clear();
        }
    }

    /* renamed from: c */
    public synchronized void m1385c() {
        if (this.f1646l) {
            return;
        }
        C0750a.m1272b();
        this.f1648n = System.currentTimeMillis();
        this.f1649o = System.currentTimeMillis();
        C0763v.m1437a().m1446a(this.f1652r);
        h hVar = new h();
        this.f1643i = hVar;
        hVar.start();
        this.f1647m = false;
        this.f1646l = true;
        if (this.f1617Q == null) {
            this.f1617Q = new C0747l(ServiceC0702f.getServiceContext());
        }
        this.f1613M = 0;
        this.f1653s = 0;
        C0667u.m571a().m574b(true);
    }

    /* renamed from: d */
    public synchronized void m1386d() {
        if (this.f1646l) {
            this.f1646l = false;
            C0763v.m1437a().m1448b(this.f1652r);
            C0766y c0766y = this.f1620T;
            if (c0766y != null && c0766y.m1469c()) {
                this.f1620T.m1465a();
            }
            C0735a c0735a = this.f1615O;
            if (c0735a != null) {
                c0735a.m1187c();
            }
            C0747l c0747l = this.f1617Q;
            if (c0747l != null) {
                c0747l.m1248c();
            }
            h hVar = this.f1643i;
            if (hVar != null) {
                hVar.f1715b = false;
                this.f1643i.interrupt();
                this.f1643i = null;
            }
            m1360j();
            this.f1647m = false;
            C0648b.m321a().m335c();
        }
    }

    /* renamed from: e */
    public boolean m1387e() {
        return this.f1646l;
    }

    /* renamed from: f */
    public boolean m1388f() {
        return this.f1646l && this.f1633af.m1419e();
    }

    /* renamed from: g */
    public String m1389g() {
        return this.f1655u;
    }

    /* renamed from: h */
    public String m1390h() {
        return this.f1656v;
    }

    /* renamed from: i */
    public boolean m1391i() {
        return this.f1629ab;
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
        if (m1391i()) {
            try {
                this.f1627a.post(new RunnableC0759r(this, fArr));
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }
}