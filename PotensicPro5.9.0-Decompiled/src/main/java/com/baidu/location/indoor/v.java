package com.baidu.location.indoor;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* loaded from: classes.dex */
public class v {
    private SensorManager c;
    private int d;
    private Sensor e;
    private Sensor f;
    private Set<b> b = Collections.synchronizedSet(new HashSet());
    private boolean g = true;
    private float[] h = new float[3];
    private float[] i = new float[9];
    private float j = -1.0f;
    private int k = 0;
    private String l = null;
    private long m = 0;
    private long n = 3000;
    private ArrayList<Long> o = new ArrayList<>();
    public SensorEventListener a = new w(this);

    private static class a {
        private static v a = new v();
    }

    public interface b {
        void a(double d, double d2, double d3, long j, String str);
    }

    public v() {
        a(com.baidu.location.f.getServiceContext(), 1);
    }

    public static v a() {
        return a.a;
    }

    private void a(Context context, int i) {
        try {
            SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
            this.c = sensorManager;
            this.d = i;
            this.e = sensorManager.getDefaultSensor(1);
            this.f = this.c.getDefaultSensor(11);
            e();
        } catch (Exception unused) {
        }
    }

    static /* synthetic */ int b(v vVar) {
        int i = vVar.k;
        vVar.k = i + 1;
        return i;
    }

    private void e() {
        int intValue;
        try {
            List<Sensor> sensorList = this.c.getSensorList(-1);
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
            this.l = new String(cArr);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void a(b bVar) {
        synchronized (this.b) {
            if (!this.b.contains(bVar)) {
                this.b.add(bVar);
            }
            if (this.b.size() == 1) {
                Sensor sensor = this.e;
                if (sensor != null) {
                    try {
                        this.c.registerListener(this.a, sensor, this.d);
                    } catch (Exception unused) {
                        this.g = false;
                    }
                    if (com.baidu.location.indoor.mapversion.a.c()) {
                        com.baidu.location.indoor.mapversion.a.a();
                    }
                }
                Sensor sensor2 = this.f;
                if (sensor2 != null) {
                    try {
                        this.c.registerListener(this.a, sensor2, this.d);
                    } catch (Exception unused2) {
                        this.g = false;
                    }
                }
            }
        }
    }

    public synchronized int b() {
        return this.k;
    }

    public void b(b bVar) {
        synchronized (this.b) {
            if (this.b.contains(bVar)) {
                this.b.remove(bVar);
            }
            if (this.b.size() == 0) {
                try {
                    this.c.unregisterListener(this.a);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (com.baidu.location.indoor.mapversion.a.c()) {
                    com.baidu.location.indoor.mapversion.a.b();
                }
            }
        }
    }

    public double c() {
        return this.j;
    }

    protected String d() {
        return this.l;
    }
}
