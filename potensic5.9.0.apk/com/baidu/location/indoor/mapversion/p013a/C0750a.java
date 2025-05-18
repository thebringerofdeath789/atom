package com.baidu.location.indoor.mapversion.p013a;

import android.os.Build;
import com.baidu.location.BDLocation;
import com.baidu.location.indoor.C0741f;
import com.baidu.location.indoor.C0748m;
import com.baidu.location.indoor.mapversion.IndoorJni;
import com.baidu.location.indoor.mapversion.p014b.C0751a;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* renamed from: com.baidu.location.indoor.mapversion.a.a */
/* loaded from: classes.dex */
public class C0750a {

    /* renamed from: a */
    private static Lock f1550a = new ReentrantLock();

    /* renamed from: a */
    public static boolean m1267a() {
        return IndoorJni.f1548a && Build.VERSION.SDK_INT > 19;
    }

    /* renamed from: a */
    public static synchronized boolean m1268a(String str) {
        Lock lock;
        synchronized (C0750a.class) {
            if (!m1267a()) {
                return false;
            }
            C0751a.d m1300b = C0751a.m1274a().m1300b(str);
            double[][] m1303c = C0751a.m1274a().m1303c(str);
            if (m1300b == null) {
                return false;
            }
            m1300b.m1308a("gcj02");
            short[][] sArr = m1300b.f1580h;
            double d = m1300b.m1307a().f1562a;
            double d2 = m1300b.m1307a().f1563b;
            C0751a.d m1302c = C0751a.m1274a().m1302c();
            if (m1302c == null) {
                return false;
            }
            double m1306a = m1302c.m1306a(-m1300b.m1307a().f1565d);
            double m1309b = m1302c.m1309b(-m1300b.m1307a().f1567f);
            f1550a.lock();
            try {
                IndoorJni.setPfRdnt(str, sArr, d, d2, (int) m1300b.f1579g.f1568g, (int) m1300b.f1579g.f1569h, m1306a, m1309b, m1300b.f1575c);
                IndoorJni.setPfGeoMap(m1303c, str, (int) m1300b.f1579g.f1568g, (int) m1300b.f1579g.f1569h);
                lock = f1550a;
            } catch (Throwable th) {
                try {
                    th.printStackTrace();
                    lock = f1550a;
                } catch (Throwable th2) {
                    f1550a.unlock();
                    throw th2;
                }
            }
            lock.unlock();
            return true;
        }
    }

    /* renamed from: a */
    private static double[] m1269a(double d, double d2, double d3, double d4, String str, String str2, long j, int i, String str3) {
        String str4 = str;
        double[] dArr = {-1.0d, -1.0d, -1.0d, -1.0d, -1.0d, -1.0d, -1.0d, -1.0d, -1.0d, -1.0d, -1.0d, -1.0d};
        if (m1267a()) {
            if (str4 == null || "".equals(str4)) {
                str4 = "unknow";
            }
            String str5 = str4;
            f1550a.lock();
            try {
                dArr = IndoorJni.setPfBle(d, d2, d3, d4, str5, str2, j, i, str3);
            } finally {
                try {
                } finally {
                }
            }
        }
        return dArr;
    }

    /* renamed from: a */
    public static synchronized double[] m1270a(String str, double d, double d2, double d3, String str2) {
        Lock lock;
        synchronized (C0750a.class) {
            if (!m1267a()) {
                return null;
            }
            C0751a.d m1302c = C0751a.m1274a().m1302c();
            double[] dArr = {-1.0d, -1.0d, -1.0d, -1.0d, -1.0d, -1.0d, -1.0d, -1.0d, -1.0d, -1.0d, -1.0d, -1.0d};
            if (m1302c != null) {
                f1550a.lock();
                try {
                    dArr = IndoorJni.setPfDr(d2, d3, str2, System.currentTimeMillis());
                    lock = f1550a;
                } catch (Throwable th) {
                    try {
                        th.printStackTrace();
                        lock = f1550a;
                    } catch (Throwable th2) {
                        f1550a.unlock();
                        throw th2;
                    }
                }
                lock.unlock();
                if (dArr[0] == 0.0d) {
                    double m1311c = m1302c.m1311c(dArr[1]);
                    double m1312d = m1302c.m1312d(dArr[2]);
                    dArr[1] = m1311c;
                    dArr[2] = m1312d;
                }
            }
            return dArr;
        }
    }

    /* renamed from: a */
    public static synchronized double[] m1271a(boolean z, BDLocation bDLocation) {
        double[] pfWf;
        synchronized (C0750a.class) {
            if (!m1267a()) {
                return null;
            }
            C0751a.d m1302c = C0751a.m1274a().m1302c();
            double[] dArr = {-1.0d, -1.0d, -1.0d, -1.0d, -1.0d, -1.0d, -1.0d, -1.0d, -1.0d, -1.0d, -1.0d, -1.0d};
            if (m1302c != null) {
                double m1306a = m1302c.m1306a(bDLocation.getLongitude());
                double m1309b = m1302c.m1309b(bDLocation.getLatitude());
                if (z) {
                    String m1261b = C0748m.m1261b(2);
                    if (m1261b != null || !"".equals(m1261b)) {
                        m1261b = m1261b.split("_")[0];
                    }
                    if (m1261b == null || "".equals(m1261b)) {
                        m1261b = "unknow";
                    }
                    String str = m1261b;
                    String m1225e = C0741f.m1211a().m1225e();
                    if (m1225e == null || "".equals(m1225e)) {
                        m1225e = "unknow";
                    }
                    String str2 = m1225e;
                    str.toUpperCase();
                    int m1255a = C0748m.m1255a(2);
                    String buildingName = bDLocation.getBuildingName();
                    if (buildingName == null || "".equals(buildingName)) {
                        buildingName = "unknown";
                    }
                    pfWf = m1269a(m1306a, m1309b, bDLocation.getRadius(), bDLocation.getAcc(), str, str2, System.currentTimeMillis(), m1255a, buildingName);
                } else {
                    f1550a.lock();
                    try {
                        pfWf = IndoorJni.setPfWf(m1306a, m1309b, 8.0d, System.currentTimeMillis());
                        f1550a.unlock();
                    } catch (Throwable th) {
                        try {
                            th.printStackTrace();
                        } finally {
                            f1550a.unlock();
                        }
                    }
                }
                dArr = pfWf;
                if (dArr[0] == 0.0d) {
                    double m1311c = m1302c.m1311c(dArr[1]);
                    double m1312d = m1302c.m1312d(dArr[2]);
                    dArr[1] = m1311c;
                    dArr[2] = m1312d;
                }
            }
            return dArr;
        }
    }

    /* renamed from: b */
    public static void m1272b() {
        if (m1267a()) {
            f1550a.lock();
            try {
                IndoorJni.initPf();
            } finally {
                try {
                } finally {
                }
            }
        }
    }

    /* renamed from: c */
    public static void m1273c() {
        if (m1267a()) {
            f1550a.lock();
            try {
                IndoorJni.resetPf();
            } finally {
                try {
                } finally {
                }
            }
        }
    }
}