package com.baidu.location.indoor;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.baidu.location.indoor.C0763v;
import com.baidu.location.indoor.mapversion.C0749a;
import java.util.Iterator;
import java.util.Set;

/* renamed from: com.baidu.location.indoor.w */
/* loaded from: classes.dex */
class C0764w implements SensorEventListener {

    /* renamed from: a */
    final /* synthetic */ C0763v f1762a;

    C0764w(C0763v c0763v) {
        this.f1762a = c0763v;
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        boolean z;
        String m1262a;
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
            this.f1762a.f1758m = System.currentTimeMillis();
            z = this.f1762a.f1752g;
            if (!z || !C0749a.m1265c() || (m1262a = C0749a.m1262a(1, fArr7, System.currentTimeMillis())) == null || m1262a.length() <= 1) {
                return;
            }
            float m1266d = C0749a.m1266d();
            if (m1266d > 0.01f) {
                C0763v.m1440b(this.f1762a);
            }
            try {
                set = this.f1762a.f1747b;
                synchronized (set) {
                    set2 = this.f1762a.f1747b;
                    Iterator it = set2.iterator();
                    while (it.hasNext()) {
                        f = this.f1762a.f1755j;
                        double d = f;
                        f2 = this.f1762a.f1755j;
                        ((C0763v.b) it.next()).mo1431a(m1266d, d, f2, System.currentTimeMillis(), m1262a);
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
        fArr = this.f1762a.f1754i;
        SensorManager.getRotationMatrixFromVector(fArr, fArr8);
        fArr2 = this.f1762a.f1754i;
        fArr3 = this.f1762a.f1753h;
        SensorManager.getOrientation(fArr2, fArr3);
        float[] fArr9 = new float[3];
        fArr4 = this.f1762a.f1753h;
        double degrees = Math.toDegrees(fArr4[0]);
        if (degrees < 0.0d) {
            fArr9[2] = ((float) (degrees + 360.0d)) % 360.0f;
        } else {
            fArr9[2] = (float) degrees;
        }
        this.f1762a.f1755j = fArr9[2];
        fArr5 = this.f1762a.f1753h;
        fArr9[0] = (float) Math.toDegrees(fArr5[1]);
        fArr6 = this.f1762a.f1753h;
        fArr9[1] = (float) Math.toDegrees(fArr6[2]);
        z2 = this.f1762a.f1752g;
        if (z2 && C0749a.m1265c()) {
            C0749a.m1262a(5, fArr9, System.currentTimeMillis());
        }
    }
}