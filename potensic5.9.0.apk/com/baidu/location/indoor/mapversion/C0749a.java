package com.baidu.location.indoor.mapversion;

import android.os.Build;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* renamed from: com.baidu.location.indoor.mapversion.a */
/* loaded from: classes.dex */
public class C0749a {

    /* renamed from: a */
    private static Lock f1549a = new ReentrantLock();

    /* renamed from: a */
    public static synchronized String m1262a(int i, float[] fArr, long j) {
        String str;
        Lock lock;
        synchronized (C0749a.class) {
            str = null;
            f1549a.lock();
            try {
                if (m1265c() && fArr != null && fArr.length >= 3) {
                    str = IndoorJni.phs(i, fArr[0], fArr[1], fArr[2], j);
                }
                lock = f1549a;
            } catch (Throwable th) {
                try {
                    th.printStackTrace();
                    lock = f1549a;
                } catch (Throwable th2) {
                    f1549a.unlock();
                    throw th2;
                }
            }
            lock.unlock();
        }
        return str;
    }

    /* renamed from: a */
    public static void m1263a() {
        f1549a.lock();
        try {
            IndoorJni.startPdr();
        } finally {
            try {
            } finally {
            }
        }
    }

    /* renamed from: b */
    public static void m1264b() {
        f1549a.lock();
        try {
            IndoorJni.stopPdr();
        } finally {
            try {
            } finally {
            }
        }
    }

    /* renamed from: c */
    public static boolean m1265c() {
        if (Build.VERSION.SDK_INT < 19) {
            return false;
        }
        return IndoorJni.f1548a;
    }

    /* renamed from: d */
    public static float m1266d() {
        f1549a.lock();
        try {
            return IndoorJni.pgo();
        } catch (Throwable th) {
            try {
                th.printStackTrace();
                f1549a.unlock();
                return -1.0f;
            } finally {
                f1549a.unlock();
            }
        }
    }
}