package com.baidu.location.indoor.mapversion.a;

import android.os.Build;
import com.baidu.location.BDLocation;
import com.baidu.location.indoor.f;
import com.baidu.location.indoor.m;
import com.baidu.location.indoor.mapversion.IndoorJni;
import com.baidu.location.indoor.mapversion.b.a;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes.dex */
public class a {
    private static Lock a = new ReentrantLock();

    public static boolean a() {
        return IndoorJni.a && Build.VERSION.SDK_INT > 19;
    }

    public static synchronized boolean a(String str) {
        Lock lock;
        synchronized (a.class) {
            if (!a()) {
                return false;
            }
            a.d b = com.baidu.location.indoor.mapversion.b.a.a().b(str);
            double[][] c = com.baidu.location.indoor.mapversion.b.a.a().c(str);
            if (b == null) {
                return false;
            }
            b.a("gcj02");
            short[][] sArr = b.h;
            double d = b.a().a;
            double d2 = b.a().b;
            a.d c2 = com.baidu.location.indoor.mapversion.b.a.a().c();
            if (c2 == null) {
                return false;
            }
            double a2 = c2.a(-b.a().d);
            double b2 = c2.b(-b.a().f);
            a.lock();
            try {
                IndoorJni.setPfRdnt(str, sArr, d, d2, (int) b.g.g, (int) b.g.h, a2, b2, b.c);
                IndoorJni.setPfGeoMap(c, str, (int) b.g.g, (int) b.g.h);
                lock = a;
            } catch (Throwable th) {
                try {
                    th.printStackTrace();
                    lock = a;
                } catch (Throwable th2) {
                    a.unlock();
                    throw th2;
                }
            }
            lock.unlock();
            return true;
        }
    }

    private static double[] a(double d, double d2, double d3, double d4, String str, String str2, long j, int i, String str3) {
        String str4 = str;
        double[] dArr = {-1.0d, -1.0d, -1.0d, -1.0d, -1.0d, -1.0d, -1.0d, -1.0d, -1.0d, -1.0d, -1.0d, -1.0d};
        if (a()) {
            if (str4 == null || "".equals(str4)) {
                str4 = "unknow";
            }
            String str5 = str4;
            a.lock();
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

    public static synchronized double[] a(String str, double d, double d2, double d3, String str2) {
        Lock lock;
        synchronized (a.class) {
            if (!a()) {
                return null;
            }
            a.d c = com.baidu.location.indoor.mapversion.b.a.a().c();
            double[] dArr = {-1.0d, -1.0d, -1.0d, -1.0d, -1.0d, -1.0d, -1.0d, -1.0d, -1.0d, -1.0d, -1.0d, -1.0d};
            if (c != null) {
                a.lock();
                try {
                    dArr = IndoorJni.setPfDr(d2, d3, str2, System.currentTimeMillis());
                    lock = a;
                } catch (Throwable th) {
                    try {
                        th.printStackTrace();
                        lock = a;
                    } catch (Throwable th2) {
                        a.unlock();
                        throw th2;
                    }
                }
                lock.unlock();
                if (dArr[0] == 0.0d) {
                    double c2 = c.c(dArr[1]);
                    double d4 = c.d(dArr[2]);
                    dArr[1] = c2;
                    dArr[2] = d4;
                }
            }
            return dArr;
        }
    }

    public static synchronized double[] a(boolean z, BDLocation bDLocation) {
        double[] pfWf;
        synchronized (a.class) {
            if (!a()) {
                return null;
            }
            a.d c = com.baidu.location.indoor.mapversion.b.a.a().c();
            double[] dArr = {-1.0d, -1.0d, -1.0d, -1.0d, -1.0d, -1.0d, -1.0d, -1.0d, -1.0d, -1.0d, -1.0d, -1.0d};
            if (c != null) {
                double a2 = c.a(bDLocation.getLongitude());
                double b = c.b(bDLocation.getLatitude());
                if (z) {
                    String b2 = m.b(2);
                    if (b2 != null || !"".equals(b2)) {
                        b2 = b2.split("_")[0];
                    }
                    if (b2 == null || "".equals(b2)) {
                        b2 = "unknow";
                    }
                    String str = b2;
                    String e = f.a().e();
                    if (e == null || "".equals(e)) {
                        e = "unknow";
                    }
                    String str2 = e;
                    str.toUpperCase();
                    int a3 = m.a(2);
                    String buildingName = bDLocation.getBuildingName();
                    if (buildingName == null || "".equals(buildingName)) {
                        buildingName = "unknown";
                    }
                    pfWf = a(a2, b, bDLocation.getRadius(), bDLocation.getAcc(), str, str2, System.currentTimeMillis(), a3, buildingName);
                } else {
                    a.lock();
                    try {
                        pfWf = IndoorJni.setPfWf(a2, b, 8.0d, System.currentTimeMillis());
                        a.unlock();
                    } catch (Throwable th) {
                        try {
                            th.printStackTrace();
                        } finally {
                            a.unlock();
                        }
                    }
                }
                dArr = pfWf;
                if (dArr[0] == 0.0d) {
                    double c2 = c.c(dArr[1]);
                    double d = c.d(dArr[2]);
                    dArr[1] = c2;
                    dArr[2] = d;
                }
            }
            return dArr;
        }
    }

    public static void b() {
        if (a()) {
            a.lock();
            try {
                IndoorJni.initPf();
            } finally {
                try {
                } finally {
                }
            }
        }
    }

    public static void c() {
        if (a()) {
            a.lock();
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
