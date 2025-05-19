package com.baidu.location.indoor;

import android.os.Build;
import com.baidu.location.indoor.mapversion.IndoorJni;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes.dex */
public class m {
    private static Lock b = new ReentrantLock();
    public static boolean a = false;
    private static boolean c = false;

    public static int a(int i) {
        if (a()) {
            long currentTimeMillis = System.currentTimeMillis();
            b.lock();
            try {
                return IndoorJni.getInout(currentTimeMillis, i);
            } catch (Throwable th) {
                try {
                    th.printStackTrace();
                } finally {
                    b.unlock();
                }
            }
        }
        return -1;
    }

    public static void a(double d, double d2, float f, float f2, float f3, double d3, int i, long j) {
        if (a()) {
            b.lock();
            try {
                IndoorJni.setGps(d, d2, f, f2, f3, d3, i, j);
            } finally {
                try {
                } finally {
                }
            }
        }
    }

    public static void a(double d, double d2, String str, int i, long j, int i2) {
        String str2 = str;
        if (a()) {
            if (str2 == null || "".equals(str)) {
                str2 = "unknow";
            }
            String str3 = str2;
            b.lock();
            try {
                IndoorJni.setBleLoc4Scenario(d, d2, str3, i, j, i2);
            } finally {
                try {
                } finally {
                }
            }
        }
    }

    public static void a(float f, long j) {
        if (a()) {
            b.lock();
            try {
                IndoorJni.setBarometers(f, j);
            } finally {
                try {
                } finally {
                }
            }
        }
    }

    public static boolean a() {
        if (Build.VERSION.SDK_INT < 19) {
            return false;
        }
        return IndoorJni.a;
    }

    public static String b() {
        if (a()) {
            b.lock();
            try {
                String buildingId = IndoorJni.getBuildingId(System.currentTimeMillis());
                b.unlock();
                return buildingId;
            } catch (Throwable unused) {
                b.unlock();
            }
        }
        return "";
    }

    public static String b(int i) {
        if (a()) {
            long currentTimeMillis = System.currentTimeMillis();
            b.lock();
            try {
                return IndoorJni.getFloor(currentTimeMillis, i);
            } catch (Throwable th) {
                try {
                    th.printStackTrace();
                } finally {
                    b.unlock();
                }
            }
        }
        return "";
    }
}
