package com.baidu.location.indoor;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.baidu.location.indoor.v;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes.dex */
class w implements SensorEventListener {
    final /* synthetic */ v a;

    w(v vVar) {
        this.a = vVar;
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        boolean z;
        String a;
        Set set;
        Set set2;
        float f;
        float f2;
        float[] fArr;
        float[] fArr2;
        float[] fArr3;
        float[] fArr4;
        float[] fArr5;
        float[] fArr6;
        boolean z2;
        int type = sensorEvent.sensor.getType();
        if (type == 1) {
            float[] fArr7 = (float[]) sensorEvent.values.clone();
            this.a.m = System.currentTimeMillis();
            z = this.a.g;
            if (!z || !com.baidu.location.indoor.mapversion.a.c() || (a = com.baidu.location.indoor.mapversion.a.a(1, fArr7, System.currentTimeMillis())) == null || a.length() <= 1) {
                return;
            }
            float d = com.baidu.location.indoor.mapversion.a.d();
            if (d > 0.01f) {
                v.b(this.a);
            }
            try {
                set = this.a.b;
                synchronized (set) {
                    set2 = this.a.b;
                    Iterator it = set2.iterator();
                    while (it.hasNext()) {
                        f = this.a.j;
                        double d2 = f;
                        f2 = this.a.j;
                        ((v.b) it.next()).a(d, d2, f2, System.currentTimeMillis(), a);
                    }
                }
                return;
            } catch (Throwable th) {
                th.printStackTrace();
                return;
            }
        }
        if (type != 11) {
            return;
        }
        float[] fArr8 = (float[]) sensorEvent.values.clone();
        fArr = this.a.i;
        SensorManager.getRotationMatrixFromVector(fArr, fArr8);
        fArr2 = this.a.i;
        fArr3 = this.a.h;
        SensorManager.getOrientation(fArr2, fArr3);
        float[] fArr9 = new float[3];
        fArr4 = this.a.h;
        double degrees = Math.toDegrees(fArr4[0]);
        if (degrees < 0.0d) {
            fArr9[2] = ((float) (degrees + 360.0d)) % 360.0f;
        } else {
            fArr9[2] = (float) degrees;
        }
        this.a.j = fArr9[2];
        fArr5 = this.a.h;
        fArr9[0] = (float) Math.toDegrees(fArr5[1]);
        fArr6 = this.a.h;
        fArr9[1] = (float) Math.toDegrees(fArr6[2]);
        z2 = this.a.g;
        if (z2 && com.baidu.location.indoor.mapversion.a.c()) {
            com.baidu.location.indoor.mapversion.a.a(5, fArr9, System.currentTimeMillis());
        }
    }
}
