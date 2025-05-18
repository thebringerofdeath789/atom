package com.baidu.location.indoor;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import com.baidu.location.ServiceC0702f;
import com.baidu.location.indoor.mapversion.C0749a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* renamed from: com.baidu.location.indoor.v */
/* loaded from: classes.dex */
public class C0763v {

    /* renamed from: c */
    private SensorManager f1748c;

    /* renamed from: d */
    private int f1749d;

    /* renamed from: e */
    private Sensor f1750e;

    /* renamed from: f */
    private Sensor f1751f;

    /* renamed from: b */
    private Set<b> f1747b = Collections.synchronizedSet(new HashSet());

    /* renamed from: g */
    private boolean f1752g = true;

    /* renamed from: h */
    private float[] f1753h = new float[3];

    /* renamed from: i */
    private float[] f1754i = new float[9];

    /* renamed from: j */
    private float f1755j = -1.0f;

    /* renamed from: k */
    private int f1756k = 0;

    /* renamed from: l */
    private String f1757l = null;

    /* renamed from: m */
    private long f1758m = 0;

    /* renamed from: n */
    private long f1759n = 3000;

    /* renamed from: o */
    private ArrayList<Long> f1760o = new ArrayList<>();

    /* renamed from: a */
    public SensorEventListener f1746a = new C0764w(this);

    /* renamed from: com.baidu.location.indoor.v$a */
    private static class a {

        /* renamed from: a */
        private static C0763v f1761a = new C0763v();
    }

    /* renamed from: com.baidu.location.indoor.v$b */
    public interface b {
        /* renamed from: a */
        void mo1431a(double d, double d2, double d3, long j, String str);
    }

    public C0763v() {
        m1438a(ServiceC0702f.getServiceContext(), 1);
    }

    /* renamed from: a */
    public static C0763v m1437a() {
        return a.f1761a;
    }

    /* renamed from: a */
    private void m1438a(Context context, int i) {
        try {
            SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
            this.f1748c = sensorManager;
            this.f1749d = i;
            this.f1750e = sensorManager.getDefaultSensor(1);
            this.f1751f = this.f1748c.getDefaultSensor(11);
            m1443e();
        } catch (Exception unused) {
        }
    }

    /* renamed from: b */
    static /* synthetic */ int m1440b(C0763v c0763v) {
        int i = c0763v.f1756k;
        c0763v.f1756k = i + 1;
        return i;
    }

    /* renamed from: e */
    private void m1443e() {
        int intValue;
        try {
            List<Sensor> sensorList = this.f1748c.getSensorList(-1);
            HashMap hashMap = new HashMap();
            hashMap.put(1, 0);
            hashMap.put(10, 1);
            hashMap.put(9, 2);
            hashMap.put(4, 3);
            hashMap.put(2, 4);
            hashMap.put(11, 5);
            hashMap.put(6, 6);
            if (Build.VERSION.SDK_INT >= 18) {
                hashMap.put(14, 7);
                hashMap.put(16, 8);
            }
            int size = hashMap.size();
            char[] cArr = new char[size];
            for (int i = 0; i < size; i++) {
                cArr[i] = '0';
            }
            Iterator<Sensor> it = sensorList.iterator();
            while (it.hasNext()) {
                int type = it.next().getType();
                if (hashMap.get(Integer.valueOf(type)) != null && (intValue = ((Integer) hashMap.get(Integer.valueOf(type))).intValue()) < size) {
                    cArr[intValue] = '1';
                }
            }
            this.f1757l = new String(cArr);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public void m1446a(b bVar) {
        synchronized (this.f1747b) {
            if (!this.f1747b.contains(bVar)) {
                this.f1747b.add(bVar);
            }
            if (this.f1747b.size() == 1) {
                Sensor sensor = this.f1750e;
                if (sensor != null) {
                    try {
                        this.f1748c.registerListener(this.f1746a, sensor, this.f1749d);
                    } catch (Exception unused) {
                        this.f1752g = false;
                    }
                    if (C0749a.m1265c()) {
                        C0749a.m1263a();
                    }
                }
                Sensor sensor2 = this.f1751f;
                if (sensor2 != null) {
                    try {
                        this.f1748c.registerListener(this.f1746a, sensor2, this.f1749d);
                    } catch (Exception unused2) {
                        this.f1752g = false;
                    }
                }
            }
        }
    }

    /* renamed from: b */
    public synchronized int m1447b() {
        return this.f1756k;
    }

    /* renamed from: b */
    public void m1448b(b bVar) {
        synchronized (this.f1747b) {
            if (this.f1747b.contains(bVar)) {
                this.f1747b.remove(bVar);
            }
            if (this.f1747b.size() == 0) {
                try {
                    this.f1748c.unregisterListener(this.f1746a);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (C0749a.m1265c()) {
                    C0749a.m1264b();
                }
            }
        }
    }

    /* renamed from: c */
    public double m1449c() {
        return this.f1755j;
    }

    /* renamed from: d */
    protected String m1450d() {
        return this.f1757l;
    }
}