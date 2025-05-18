package com.baidu.location.p006b;

import android.content.Intent;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import android.text.TextUtils;
import com.baidu.location.Address;
import com.baidu.location.BDLocation;
import com.baidu.location.Jni;
import com.baidu.location.LocationClientOption;
import com.baidu.location.Poi;
import com.baidu.location.PoiRegion;
import com.baidu.location.ServiceC0702f;
import com.baidu.location.indoor.C0755n;
import com.baidu.location.p005a.C0643a;
import com.baidu.location.p007c.C0674a;
import com.baidu.location.p010f.C0709g;
import com.baidu.location.p010f.C0715m;
import com.baidu.location.p012h.C0720b;
import com.baidu.location.p012h.C0733o;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.logging.LogFactory;

/* renamed from: com.baidu.location.b.b */
/* loaded from: classes.dex */
public class C0648b {

    /* renamed from: c */
    public static long f423c = 0;

    /* renamed from: d */
    public static int f424d = -1;

    /* renamed from: a */
    public boolean f425a;

    /* renamed from: b */
    boolean f426b;

    /* renamed from: e */
    int f427e;

    /* renamed from: f */
    private ArrayList<a> f428f;

    /* renamed from: g */
    private boolean f429g;

    /* renamed from: h */
    private BDLocation f430h;

    /* renamed from: i */
    private BDLocation f431i;

    /* renamed from: j */
    private Object f432j;

    /* renamed from: k */
    private BDLocation f433k;

    /* renamed from: l */
    private boolean f434l;

    /* renamed from: m */
    private boolean f435m;

    /* renamed from: n */
    private c f436n;

    /* renamed from: com.baidu.location.b.b$a */
    private class a {

        /* renamed from: a */
        public String f437a;

        /* renamed from: b */
        public Messenger f438b;

        /* renamed from: c */
        public LocationClientOption f439c = new LocationClientOption();

        /* renamed from: d */
        public int f440d = 0;

        public a(Message message) {
            this.f437a = null;
            this.f438b = null;
            this.f438b = message.replyTo;
            this.f437a = message.getData().getString("packName");
            this.f439c.prodName = message.getData().getString("prodName");
            C0720b.m1100a().m1104a(this.f439c.prodName, this.f437a);
            this.f439c.coorType = message.getData().getString("coorType");
            this.f439c.addrType = message.getData().getString("addrType");
            this.f439c.enableSimulateGps = message.getData().getBoolean("enableSimulateGps", false);
            C0733o.f1396l = C0733o.f1396l || this.f439c.enableSimulateGps;
            if (!C0733o.f1389e.equals(TtmlNode.COMBINE_ALL)) {
                C0733o.f1389e = this.f439c.addrType;
            }
            this.f439c.openGps = message.getData().getBoolean("openGPS");
            this.f439c.scanSpan = message.getData().getInt("scanSpan");
            this.f439c.timeOut = message.getData().getInt("timeOut");
            this.f439c.priority = message.getData().getInt(LogFactory.PRIORITY_KEY);
            this.f439c.location_change_notify = message.getData().getBoolean("location_change_notify");
            this.f439c.mIsNeedDeviceDirect = message.getData().getBoolean("needDirect", false);
            this.f439c.isNeedAltitude = message.getData().getBoolean("isneedaltitude", false);
            this.f439c.isNeedNewVersionRgc = message.getData().getBoolean("isneednewrgc", false);
            C0733o.f1392h = C0733o.f1392h || this.f439c.isNeedNewVersionRgc;
            C0733o.f1391g = C0733o.f1391g || message.getData().getBoolean("isneedaptag", false);
            C0733o.f1393i = C0733o.f1393i || message.getData().getBoolean("isneedaptagd", false);
            C0733o.f1331R = message.getData().getFloat("autoNotifyLocSensitivity", 0.5f);
            int i = message.getData().getInt("wfnum", C0733o.f1384ay);
            float f = message.getData().getFloat("wfsm", C0733o.f1385az);
            int i2 = message.getData().getInt("gnmcon", C0733o.f1342aB);
            double d = message.getData().getDouble("gnmcrm", C0733o.f1341aA);
            int i3 = message.getData().getInt("iupl", 1);
            C0733o.f1351aK = message.getData().getInt("ct", 10);
            C0733o.f1352aL = message.getData().getInt("suci", 3);
            C0733o.f1354aN = message.getData().getDoubleArray("cgs");
            C0733o.f1355aO = message.getData().getInt("ums", 1);
            C0733o.f1353aM = message.getData().getInt("smn", 40);
            if (i3 <= 0) {
                C0733o.f1350aJ = 0;
            } else if (C0733o.f1350aJ == -1) {
                C0733o.f1350aJ = 1;
            }
            if (message.getData().getInt("opetco", 1) == 0) {
                C0733o.f1356aP = 0;
            }
            if (message.getData().getInt("lpcs", C0733o.f1357aQ) == 0) {
                C0733o.f1357aQ = 0;
            }
            if (i2 == 1) {
                C0733o.f1342aB = 1;
            }
            if (d > C0733o.f1341aA) {
                C0733o.f1341aA = d;
            }
            C0733o.f1383ax = C0733o.f1383ax || message.getData().getBoolean("ischeckper", false);
            boolean z = message.getData().getBoolean("isEnableBeidouMode", false);
            if (Build.VERSION.SDK_INT >= 28) {
                C0733o.f1358aR = C0733o.f1358aR || z;
            }
            if (i > C0733o.f1384ay) {
                C0733o.f1384ay = i;
            }
            if (f > C0733o.f1385az) {
                C0733o.f1385az = f;
            }
            int i4 = message.getData().getInt("wifitimeout", Integer.MAX_VALUE);
            if (i4 < C0733o.f1365af) {
                C0733o.f1365af = i4;
            }
            int i5 = message.getData().getInt("autoNotifyMaxInterval", 0);
            if (i5 >= C0733o.f1336W) {
                C0733o.f1336W = i5;
            }
            int i6 = message.getData().getInt("autoNotifyMinDistance", 0);
            if (i6 >= C0733o.f1338Y) {
                C0733o.f1338Y = i6;
            }
            int i7 = message.getData().getInt("autoNotifyMinTimeInterval", 0);
            if (i7 >= C0733o.f1337X) {
                C0733o.f1337X = i7;
            }
            if (this.f439c.mIsNeedDeviceDirect || this.f439c.isNeedAltitude) {
                C0667u.m571a().m572a(this.f439c.mIsNeedDeviceDirect);
                C0667u.m571a().m573b();
            }
            C0648b.this.f426b = C0648b.this.f426b || this.f439c.isNeedAltitude;
            if (message.getData().getInt("hpdts", C0733o.f1343aC) == 1) {
                C0733o.f1343aC = 1;
            } else {
                C0733o.f1343aC = 0;
            }
            if (message.getData().getInt("oldts", C0733o.f1344aD) == 1) {
                C0733o.f1344aD = 1;
            } else {
                C0733o.f1344aD = 0;
            }
            int i8 = message.getData().getInt("onic", C0733o.f1345aE);
            if (i8 == 0) {
                C0733o.f1345aE = i8;
            }
            int i9 = message.getData().getInt("nlcs", C0733o.f1346aF);
            if (i9 == 1) {
                C0733o.f1346aF = i9;
            }
            C0733o.f1347aG = message.getData().getFloat("ncsr", C0733o.f1347aG);
            C0733o.f1348aH = message.getData().getFloat("cscr", C0733o.f1348aH);
        }

        /* renamed from: a */
        private double m343a(boolean z, BDLocation bDLocation, BDLocation bDLocation2) {
            double d;
            double latitude;
            double longitude;
            double latitude2;
            double longitude2;
            double m1134a;
            double[] dArr;
            if (z) {
                if (TextUtils.equals(bDLocation2.getCoorType(), bDLocation.getCoorType())) {
                    if (TextUtils.equals("bd09", bDLocation2.getCoorType())) {
                        double[] coorEncrypt = Jni.coorEncrypt(bDLocation2.getLongitude(), bDLocation2.getLatitude(), BDLocation.BDLOCATION_BD09_TO_GCJ02);
                        double[] coorEncrypt2 = Jni.coorEncrypt(bDLocation.getLongitude(), bDLocation.getLatitude(), BDLocation.BDLOCATION_BD09_TO_GCJ02);
                        latitude = coorEncrypt[1];
                        longitude = coorEncrypt[0];
                        latitude2 = coorEncrypt2[1];
                        longitude2 = coorEncrypt2[0];
                        m1134a = C0733o.m1134a(latitude, longitude, latitude2, longitude2);
                    }
                    m1134a = C0733o.m1134a(bDLocation2.getLatitude(), bDLocation2.getLongitude(), bDLocation.getLatitude(), bDLocation.getLongitude());
                } else {
                    if (TextUtils.equals("wgs84", bDLocation.getCoorType())) {
                        dArr = new double[]{bDLocation.getLongitude(), bDLocation.getLatitude()};
                    } else {
                        double[] coorEncrypt3 = TextUtils.equals("bd09", bDLocation.getCoorType()) ? Jni.coorEncrypt(bDLocation.getLongitude(), bDLocation.getLatitude(), BDLocation.BDLOCATION_BD09_TO_GCJ02) : TextUtils.equals("bd09ll", bDLocation.getCoorType()) ? Jni.coorEncrypt(bDLocation.getLongitude(), bDLocation.getLatitude(), BDLocation.BDLOCATION_BD09LL_TO_GCJ02) : new double[]{bDLocation.getLongitude(), bDLocation.getLatitude()};
                        dArr = Jni.coorEncrypt(coorEncrypt3[0], coorEncrypt3[1], "gcj2wgs");
                    }
                    bDLocation.setLatitude(dArr[1]);
                    d = dArr[0];
                    bDLocation.setLongitude(d);
                    bDLocation.setTime(C0733o.m1138a());
                    bDLocation.setCoorType("wgs84");
                    m1134a = C0733o.m1134a(bDLocation2.getLatitude(), bDLocation2.getLongitude(), bDLocation.getLatitude(), bDLocation.getLongitude());
                }
            } else if (TextUtils.equals(bDLocation2.getCoorType(), bDLocation.getCoorType())) {
                latitude = bDLocation2.getLatitude();
                longitude = bDLocation2.getLongitude();
                latitude2 = bDLocation.getLatitude();
                longitude2 = bDLocation.getLongitude();
                m1134a = C0733o.m1134a(latitude, longitude, latitude2, longitude2);
            } else {
                double[] coorEncrypt4 = Jni.coorEncrypt(bDLocation.getLongitude(), bDLocation.getLatitude(), "gcj2wgs");
                bDLocation.setLatitude(coorEncrypt4[1]);
                d = coorEncrypt4[0];
                bDLocation.setLongitude(d);
                bDLocation.setTime(C0733o.m1138a());
                bDLocation.setCoorType("wgs84");
                m1134a = C0733o.m1134a(bDLocation2.getLatitude(), bDLocation2.getLongitude(), bDLocation.getLatitude(), bDLocation.getLongitude());
            }
            bDLocation2.setDisToRealLocation(m1134a);
            if (bDLocation != null) {
                bDLocation2.setReallLocation(bDLocation);
            }
            return m1134a;
        }

        /* renamed from: a */
        private int m344a(double d) {
            if (d >= 0.0d && d <= 10.0d) {
                return 0;
            }
            if (d <= 10.0d || d > 100.0d) {
                return (d <= 100.0d || d > 200.0d) ? 3 : 2;
            }
            return 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public void m345a(int i) {
            Message obtain = Message.obtain((Handler) null, i);
            try {
                Messenger messenger = this.f438b;
                if (messenger != null) {
                    messenger.send(obtain);
                }
                this.f440d = 0;
            } catch (Exception e) {
                if (e instanceof DeadObjectException) {
                    this.f440d++;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public void m346a(int i, Bundle bundle) {
            Message obtain = Message.obtain((Handler) null, i);
            obtain.setData(bundle);
            try {
                Messenger messenger = this.f438b;
                if (messenger != null) {
                    messenger.send(obtain);
                }
                this.f440d = 0;
            } catch (Exception e) {
                if (e instanceof DeadObjectException) {
                    this.f440d++;
                }
                e.printStackTrace();
            }
        }

        /* renamed from: a */
        private void m347a(int i, String str, BDLocation bDLocation) {
            Bundle bundle = new Bundle();
            bundle.putParcelable(str, bDLocation);
            bundle.setClassLoader(BDLocation.class.getClassLoader());
            Message obtain = Message.obtain((Handler) null, i);
            obtain.setData(bundle);
            try {
                Messenger messenger = this.f438b;
                if (messenger != null) {
                    messenger.send(obtain);
                }
                this.f440d = 0;
            } catch (Exception e) {
                if (e instanceof DeadObjectException) {
                    this.f440d++;
                }
            }
        }

        /* renamed from: c */
        private BDLocation m350c() {
            BDLocation m1029i = C0709g.m959a().m1029i();
            if (m1029i == null) {
                return null;
            }
            double[] coorEncrypt = Jni.coorEncrypt(m1029i.getLongitude(), m1029i.getLatitude(), BDLocation.BDLOCATION_WGS84_TO_GCJ02);
            double[] coorEncrypt2 = Jni.coorEncrypt(coorEncrypt[0], coorEncrypt[1], this.f439c.coorType);
            BDLocation bDLocation = new BDLocation();
            bDLocation.setLongitude(coorEncrypt2[0]);
            bDLocation.setLatitude(coorEncrypt2[1]);
            bDLocation.setTime(C0733o.m1138a());
            bDLocation.setLocType(61);
            bDLocation.setCoorType(this.f439c.coorType);
            return bDLocation;
        }

        /* renamed from: d */
        private BDLocation m351d() {
            BDLocation m1029i = C0709g.m959a().m1029i();
            if (m1029i == null) {
                return null;
            }
            double[] coorEncrypt = Jni.coorEncrypt(m1029i.getLongitude(), m1029i.getLatitude(), BDLocation.BDLOCATION_WGS84_TO_GCJ02);
            BDLocation bDLocation = new BDLocation();
            bDLocation.setLongitude(coorEncrypt[0]);
            bDLocation.setLatitude(coorEncrypt[1]);
            bDLocation.setTime(C0733o.m1138a());
            bDLocation.setLocType(61);
            bDLocation.setCoorType("gcj02");
            return bDLocation;
        }

        /* renamed from: a */
        public int m352a(int i, boolean z, BDLocation bDLocation) {
            double m343a;
            if (i == 100) {
                if (z) {
                    BDLocation m350c = m350c();
                    if (m350c == null) {
                        return 3;
                    }
                    m343a(true, m350c, bDLocation);
                    return 3;
                }
                BDLocation m351d = m351d();
                if (m351d == null) {
                    return 3;
                }
                m343a(false, m351d, bDLocation);
                return 3;
            }
            if (i == 200 || i == 300) {
                return 1;
            }
            if (i != 400) {
                return i == 500 ? 1 : 0;
            }
            if (z) {
                BDLocation m350c2 = m350c();
                if (m350c2 == null) {
                    return -1;
                }
                m343a = m343a(true, m350c2, bDLocation);
            } else {
                BDLocation m351d2 = m351d();
                if (m351d2 == null) {
                    return -1;
                }
                m343a = m343a(false, m351d2, bDLocation);
            }
            return m344a(m343a);
        }

        /* renamed from: a */
        public void m353a() {
            m345a(111);
        }

        /* renamed from: a */
        public void m354a(BDLocation bDLocation) {
            m355a(bDLocation, 21);
        }

        /* renamed from: a */
        public void m355a(BDLocation bDLocation, int i) {
            int m352a;
            String str;
            BDLocation bDLocation2 = new BDLocation(bDLocation);
            if (C0755n.m1327a().m1387e()) {
                bDLocation2.setIndoorLocMode(true);
            }
            if (i == 21) {
                m347a(27, "locStr", bDLocation2);
            }
            if (this.f439c.coorType != null && !this.f439c.coorType.equals("gcj02")) {
                double longitude = bDLocation2.getLongitude();
                double latitude = bDLocation2.getLatitude();
                if (longitude != Double.MIN_VALUE && latitude != Double.MIN_VALUE) {
                    if ((bDLocation2.getCoorType() != null && bDLocation2.getCoorType().equals("gcj02")) || bDLocation2.getCoorType() == null) {
                        double[] coorEncrypt = Jni.coorEncrypt(longitude, latitude, this.f439c.coorType);
                        bDLocation2.setLongitude(coorEncrypt[0]);
                        bDLocation2.setLatitude(coorEncrypt[1]);
                        str = this.f439c.coorType;
                    } else if (bDLocation2.getCoorType() != null && bDLocation2.getCoorType().equals("wgs84") && !this.f439c.coorType.equals("bd09ll")) {
                        double[] coorEncrypt2 = Jni.coorEncrypt(longitude, latitude, "wgs842mc");
                        bDLocation2.setLongitude(coorEncrypt2[0]);
                        bDLocation2.setLatitude(coorEncrypt2[1]);
                        str = "wgs84mc";
                    }
                    bDLocation2.setCoorType(str);
                }
                if (!C0733o.f1396l && bDLocation2.getMockGpsStrategy() > 0) {
                    m352a = m352a(bDLocation2.getMockGpsStrategy(), true, bDLocation2);
                    bDLocation2.setMockGpsProbability(m352a);
                }
            } else if (!C0733o.f1396l && bDLocation2.getMockGpsStrategy() > 0) {
                m352a = m352a(bDLocation2.getMockGpsStrategy(), false, bDLocation2);
                bDLocation2.setMockGpsProbability(m352a);
            }
            m347a(i, "locStr", bDLocation2);
        }

        /* renamed from: b */
        public void m356b() {
            if (this.f439c.location_change_notify) {
                m345a(C0733o.f1386b ? 54 : 55);
            }
        }
    }

    /* renamed from: com.baidu.location.b.b$b */
    private static class b {

        /* renamed from: a */
        private static C0648b f442a = new C0648b();
    }

    /* renamed from: com.baidu.location.b.b$c */
    private class c implements Runnable {

        /* renamed from: a */
        final /* synthetic */ C0648b f443a;

        /* renamed from: b */
        private int f444b;

        /* renamed from: c */
        private boolean f445c;

        @Override // java.lang.Runnable
        public void run() {
            if (this.f445c) {
                return;
            }
            this.f444b++;
            this.f443a.f435m = false;
        }
    }

    private C0648b() {
        this.f428f = null;
        this.f429g = false;
        this.f425a = false;
        this.f426b = false;
        this.f430h = null;
        this.f431i = null;
        this.f432j = new Object();
        this.f427e = 0;
        this.f433k = null;
        this.f434l = false;
        this.f435m = false;
        this.f436n = null;
        this.f428f = new ArrayList<>();
    }

    /* renamed from: a */
    private a m320a(Messenger messenger) {
        if (this.f428f == null) {
            return null;
        }
        try {
        } catch (Exception e) {
            e.printStackTrace();
        }
        synchronized (this.f432j) {
            Iterator<a> it = this.f428f.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next.f438b.equals(messenger)) {
                    return next;
                }
            }
            return null;
        }
    }

    /* renamed from: a */
    public static C0648b m321a() {
        return b.f442a;
    }

    /* renamed from: a */
    private void m322a(a aVar) {
        if (aVar == null) {
            return;
        }
        synchronized (this.f432j) {
            if (m320a(aVar.f438b) != null) {
                aVar.m345a(14);
            } else {
                this.f428f.add(aVar);
                aVar.m345a(13);
            }
        }
    }

    /* renamed from: a */
    private void m323a(String str) {
        Intent intent = new Intent("com.baidu.location.flp.log");
        intent.setPackage("com.baidu.baidulocationdemo");
        intent.putExtra("data", str);
        intent.putExtra("pack", C0720b.f1244e);
        intent.putExtra("tag", "state");
        ServiceC0702f.getServiceContext().sendBroadcast(intent);
    }

    /* renamed from: f */
    private void m325f() {
        m326g();
        m342e();
        m327h();
    }

    /* renamed from: g */
    private void m326g() {
        boolean z;
        boolean z2 = false;
        try {
            try {
                synchronized (this.f432j) {
                    try {
                        Iterator<a> it = this.f428f.iterator();
                        z = false;
                        while (it.hasNext()) {
                            a next = it.next();
                            if (next.f439c.openGps) {
                                z2 = true;
                            }
                            if (next.f439c.location_change_notify) {
                                z = true;
                            }
                        }
                    } catch (Throwable th) {
                        th = th;
                        z = false;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e) {
            e = e;
            z = false;
        }
        try {
            throw th;
        } catch (Exception e2) {
            e = e2;
            e.printStackTrace();
            C0733o.f1340a = z;
            if (this.f429g != z2) {
                this.f429g = z2;
                C0709g.m959a().m1021a(this.f429g);
            }
        }
    }

    /* renamed from: h */
    private void m327h() {
        try {
            Iterator<a> it = this.f428f.iterator();
            while (it.hasNext()) {
                C0733o.f1390f = Math.min(C0733o.f1390f, it.next().f439c.priority);
            }
            if (ServiceC0702f.isServing) {
                return;
            }
            C0733o.f1390f = 4;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public void m328a(Bundle bundle, int i) {
        synchronized (this.f432j) {
            Iterator<a> it = this.f428f.iterator();
            while (it.hasNext()) {
                try {
                    a next = it.next();
                    next.m346a(i, bundle);
                    if (next.f440d > 4) {
                        it.remove();
                    }
                } catch (Exception unused) {
                }
            }
        }
    }

    /* renamed from: a */
    public void m329a(Message message) {
        if (message == null || message.replyTo == null) {
            return;
        }
        f423c = System.currentTimeMillis();
        this.f425a = true;
        C0715m.m1058a().m1068b();
        m322a(new a(message));
        m325f();
        if (this.f434l) {
            m323a(TtmlNode.START);
            this.f427e = 0;
        }
    }

    /* renamed from: a */
    public void m330a(BDLocation bDLocation) {
        m334b(bDLocation);
    }

    /* renamed from: a */
    public void m331a(boolean z) {
        this.f425a = z;
        f424d = z ? 1 : 0;
    }

    /* renamed from: b */
    public void m332b() {
        synchronized (this.f432j) {
            try {
                ArrayList<a> arrayList = this.f428f;
                if (arrayList != null) {
                    arrayList.clear();
                }
            } catch (Throwable unused) {
            }
        }
        this.f430h = null;
        m325f();
    }

    /* renamed from: b */
    public void m333b(Message message) {
        synchronized (this.f432j) {
            a m320a = m320a(message.replyTo);
            if (m320a != null) {
                this.f428f.remove(m320a);
            }
        }
        C0667u.m571a().m575c();
        m325f();
        if (this.f434l) {
            m323a("stop");
            this.f427e = 0;
        }
    }

    /* renamed from: b */
    public void m334b(BDLocation bDLocation) {
        BDLocation bDLocation2;
        if (bDLocation == null || bDLocation.getLocType() != 161 || C0643a.m295a().m300b()) {
            if (!bDLocation.hasAltitude() && this.f426b && (bDLocation.getLocType() == 161 || bDLocation.getLocType() == 66)) {
                double d = C0674a.m623a().m629a(bDLocation.getLongitude(), bDLocation.getLatitude())[0];
                C0674a.m623a();
                if (d < 9999.0d) {
                    bDLocation.setAltitude(d);
                }
            }
            if (bDLocation.getLocType() == 61) {
                bDLocation.setGpsAccuracyStatus(C0674a.m623a().m628a(bDLocation));
            }
            synchronized (this.f432j) {
                Iterator<a> it = this.f428f.iterator();
                while (it.hasNext()) {
                    try {
                        a next = it.next();
                        next.m354a(bDLocation);
                        if (next.f440d > 4) {
                            it.remove();
                        }
                    } catch (Exception unused) {
                    }
                }
            }
        } else {
            if (this.f431i == null) {
                BDLocation bDLocation3 = new BDLocation();
                this.f431i = bDLocation3;
                bDLocation3.setLocType(BDLocation.TypeServerCheckKeyError);
            }
            synchronized (this.f432j) {
                Iterator<a> it2 = this.f428f.iterator();
                while (it2.hasNext()) {
                    try {
                        a next2 = it2.next();
                        next2.m354a(this.f431i);
                        if (next2.f440d > 4) {
                            it2.remove();
                        }
                    } catch (Exception unused2) {
                    }
                }
            }
        }
        boolean z = C0662p.f622i;
        if (z) {
            C0662p.f622i = false;
        }
        if (C0733o.f1336W >= 10000) {
            if (bDLocation.getLocType() == 61 || bDLocation.getLocType() == 161 || bDLocation.getLocType() == 66) {
                BDLocation bDLocation4 = this.f430h;
                if (bDLocation4 != null) {
                    float[] fArr = new float[1];
                    Location.distanceBetween(bDLocation4.getLatitude(), this.f430h.getLongitude(), bDLocation.getLatitude(), bDLocation.getLongitude(), fArr);
                    if (fArr[0] <= C0733o.f1338Y && !z) {
                        return;
                    }
                    this.f430h = null;
                    bDLocation2 = new BDLocation(bDLocation);
                } else {
                    bDLocation2 = new BDLocation(bDLocation);
                }
                this.f430h = bDLocation2;
            }
        }
    }

    /* renamed from: c */
    public void m335c() {
        synchronized (this.f432j) {
            Iterator<a> it = this.f428f.iterator();
            while (it.hasNext()) {
                it.next().m353a();
            }
        }
    }

    /* renamed from: c */
    public void m336c(BDLocation bDLocation) {
        Address m525a = C0662p.m509c().m525a(bDLocation);
        String m532f = C0662p.m509c().m532f();
        List<Poi> m533g = C0662p.m509c().m533g();
        PoiRegion m534h = C0662p.m509c().m534h();
        if (m525a != null) {
            bDLocation.setAddr(m525a);
        }
        if (m532f != null) {
            bDLocation.setLocationDescribe(m532f);
        }
        if (m533g != null) {
            bDLocation.setPoiList(m533g);
        }
        if (m534h != null) {
            bDLocation.setPoiRegion(m534h);
        }
        if (C0755n.m1327a().m1388f() && C0755n.m1327a().m1389g() != null) {
            bDLocation.setFloor(C0755n.m1327a().m1389g());
            bDLocation.setIndoorLocMode(true);
            if (C0755n.m1327a().m1390h() != null) {
                bDLocation.setBuildingID(C0755n.m1327a().m1390h());
            }
        }
        m330a(bDLocation);
        C0662p.m509c().m529c(bDLocation);
    }

    /* renamed from: c */
    public boolean m337c(Message message) {
        a m320a = m320a(message.replyTo);
        if (m320a == null) {
            return false;
        }
        int i = m320a.f439c.scanSpan;
        m320a.f439c.scanSpan = message.getData().getInt("scanSpan", m320a.f439c.scanSpan);
        if (m320a.f439c.scanSpan < 1000) {
            C0667u.m571a().m575c();
            this.f425a = false;
        } else {
            this.f425a = true;
        }
        if (m320a.f439c.scanSpan > 999 && i < 1000) {
            if (m320a.f439c.mIsNeedDeviceDirect || m320a.f439c.isNeedAltitude) {
                C0667u.m571a().m572a(m320a.f439c.mIsNeedDeviceDirect);
                C0667u.m571a().m573b();
            }
            this.f426b = this.f426b || m320a.f439c.isNeedAltitude;
            r1 = true;
        }
        m320a.f439c.openGps = message.getData().getBoolean("openGPS", m320a.f439c.openGps);
        String string = message.getData().getString("coorType");
        LocationClientOption locationClientOption = m320a.f439c;
        if (string == null || string.equals("")) {
            string = m320a.f439c.coorType;
        }
        locationClientOption.coorType = string;
        String string2 = message.getData().getString("addrType");
        LocationClientOption locationClientOption2 = m320a.f439c;
        if (string2 == null || string2.equals("")) {
            string2 = m320a.f439c.addrType;
        }
        locationClientOption2.addrType = string2;
        if (!C0733o.f1389e.equals(m320a.f439c.addrType)) {
            C0662p.m509c().m538l();
        }
        m320a.f439c.timeOut = message.getData().getInt("timeOut", m320a.f439c.timeOut);
        m320a.f439c.location_change_notify = message.getData().getBoolean("location_change_notify", m320a.f439c.location_change_notify);
        m320a.f439c.priority = message.getData().getInt(LogFactory.PRIORITY_KEY, m320a.f439c.priority);
        C0733o.f1390f = m320a.f439c.priority;
        int i2 = message.getData().getInt("wifitimeout", Integer.MAX_VALUE);
        if (i2 < C0733o.f1365af) {
            C0733o.f1365af = i2;
        }
        m325f();
        return r1;
    }

    /* renamed from: d */
    public int m338d(Message message) {
        a m320a;
        if (message == null || message.replyTo == null || (m320a = m320a(message.replyTo)) == null || m320a.f439c == null) {
            return 1;
        }
        return C0733o.f1390f;
    }

    /* renamed from: d */
    public String m339d() {
        StringBuilder append;
        StringBuffer stringBuffer = new StringBuffer(256);
        if (this.f428f.isEmpty()) {
            return "&prod=" + C0720b.f1245f + ":" + C0720b.f1244e;
        }
        String stringBuffer2 = stringBuffer.toString();
        try {
            a aVar = this.f428f.get(0);
            if (aVar.f439c.prodName != null) {
                stringBuffer.append(aVar.f439c.prodName);
            }
            if (aVar.f437a != null) {
                stringBuffer.append(":");
                stringBuffer.append(aVar.f437a);
                stringBuffer.append("|");
            }
            if (stringBuffer2 == null || stringBuffer2.equals("")) {
                append = new StringBuilder().append("&prod=").append(C0720b.f1245f).append(":");
                stringBuffer2 = C0720b.f1244e;
            } else {
                append = new StringBuilder().append("&prod=");
            }
            return append.append(stringBuffer2).toString();
        } catch (Exception unused) {
            return "&prod=" + C0720b.f1245f + ":" + C0720b.f1244e;
        }
    }

    /* renamed from: d */
    public void m340d(BDLocation bDLocation) {
        m336c(bDLocation);
    }

    /* renamed from: e */
    public int m341e(Message message) {
        a m320a;
        if (message == null || message.replyTo == null || (m320a = m320a(message.replyTo)) == null || m320a.f439c == null) {
            return 1000;
        }
        return m320a.f439c.scanSpan;
    }

    /* renamed from: e */
    public void m342e() {
        try {
            synchronized (this.f432j) {
                Iterator<a> it = this.f428f.iterator();
                while (it.hasNext()) {
                    it.next().m356b();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}