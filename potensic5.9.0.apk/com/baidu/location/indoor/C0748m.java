package com.baidu.location.indoor;

import android.os.Build;
import com.baidu.location.indoor.mapversion.IndoorJni;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* renamed from: com.baidu.location.indoor.m */
/* loaded from: classes.dex */
public class C0748m {

    /* renamed from: b */
    private static Lock f1546b = new ReentrantLock();

    /* renamed from: a */
    public static boolean f1545a = false;

    /* renamed from: c */
    private static boolean f1547c = false;

    /* renamed from: a */
    public static int m1255a(int i) {
        if (m1259a()) {
            long currentTimeMillis = System.currentTimeMillis();
            f1546b.lock();
            try {
                return IndoorJni.getInout(currentTimeMillis, i);
            } catch (Throwable th) {
                try {
                    th.printStackTrace();
                } finally {
                    f1546b.unlock();
                }
            }
        }
        return -1;
    }

    /* renamed from: a */
    public static void m1256a(double d, double d2, float f, float f2, float f3, double d3, int i, long j) {
        if (m1259a()) {
            f1546b.lock();
            try {
                IndoorJni.setGps(d, d2, f, f2, f3, d3, i, j);
            } finally {
                try {
                } finally {
                }
            }
        }
    }

    /* renamed from: a */
    public static void m1257a(double d, double d2, String str, int i, long j, int i2) {
        String str2 = str;
        if (m1259a()) {
            if (str2 == null || "".equals(str)) {
                str2 = "unknow";
            }
            String str3 = str2;
            f1546b.lock();
            try {
                IndoorJni.setBleLoc4Scenario(d, d2, str3, i, j, i2);
            } finally {
                try {
                } finally {
                }
            }
        }
    }

    /* renamed from: a */
    public static void m1258a(float f, long j) {
        if (m1259a()) {
            f1546b.lock();
            try {
                IndoorJni.setBarometers(f, j);
            } finally {
                try {
                } finally {
                }
            }
        }
    }

    /* renamed from: a */
    public static boolean m1259a() {
        if (Build.VERSION.SDK_INT < 19) {
            return false;
        }
        return IndoorJni.f1548a;
    }

    /* renamed from: b */
    public static String m1260b() {
        if (m1259a()) {
            f1546b.lock();
            try {
                String buildingId = IndoorJni.getBuildingId(System.currentTimeMillis());
                f1546b.unlock();
                return buildingId;
            } catch (Throwable unused) {
                f1546b.unlock();
            }
        }
        return "";
    }

    /* renamed from: b */
    public static String m1261b(int i) {
        if (m1259a()) {
            long currentTimeMillis = System.currentTimeMillis();
            f1546b.lock();
            try {
                return IndoorJni.getFloor(currentTimeMillis, i);
            } catch (Throwable th) {
                try {
                    th.printStackTrace();
                } finally {
                    f1546b.unlock();
                }
            }
        }
        return "";
    }
}