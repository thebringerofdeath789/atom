package com.baidu.location.p006b;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.baidu.location.ServiceC0702f;

/* renamed from: com.baidu.location.b.u */
/* loaded from: classes.dex */
public class C0667u implements SensorEventListener {

    /* renamed from: a */
    private float[] f702a;

    /* renamed from: b */
    private SensorManager f703b;

    /* renamed from: c */
    private float f704c;

    /* renamed from: d */
    private boolean f705d;

    /* renamed from: e */
    private boolean f706e;

    /* renamed from: f */
    private boolean f707f;

    /* renamed from: com.baidu.location.b.u$a */
    private static class a {

        /* renamed from: a */
        private static final C0667u f708a = new C0667u();
    }

    private C0667u() {
        this.f705d = false;
        this.f706e = false;
        this.f707f = false;
    }

    /* renamed from: a */
    public static C0667u m571a() {
        return a.f708a;
    }

    /* renamed from: a */
    public void m572a(boolean z) {
        this.f705d = z;
    }

    /* renamed from: b */
    public synchronized void m573b() {
        Sensor defaultSensor;
        if (this.f707f) {
            return;
        }
        if (this.f705d) {
            if (this.f703b == null) {
                this.f703b = (SensorManager) ServiceC0702f.getServiceContext().getSystemService("sensor");
            }
            SensorManager sensorManager = this.f703b;
            if (sensorManager != null && (defaultSensor = sensorManager.getDefaultSensor(11)) != null && this.f705d) {
                this.f703b.registerListener(this, defaultSensor, 3);
            }
            this.f707f = true;
        }
    }

    /* renamed from: b */
    public void m574b(boolean z) {
        this.f706e = z;
    }

    /* renamed from: c */
    public synchronized void m575c() {
        if (this.f707f) {
            SensorManager sensorManager = this.f703b;
            if (sensorManager != null) {
                sensorManager.unregisterListener(this);
                this.f703b = null;
            }
            this.f707f = false;
        }
    }

    /* renamed from: d */
    public boolean m576d() {
        return this.f705d;
    }

    /* renamed from: e */
    public float m577e() {
        return this.f704c;
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor.getType() != 11) {
            return;
        }
        float[] fArr = (float[]) sensorEvent.values.clone();
        this.f702a = fArr;
        if (fArr != null) {
            float[] fArr2 = new float[9];
            try {
                SensorManager.getRotationMatrixFromVector(fArr2, fArr);
                SensorManager.getOrientation(fArr2, new float[3]);
                float degrees = (float) Math.toDegrees(r5[0]);
                this.f704c = degrees;
                if (degrees < 0.0f) {
                    degrees += 360.0f;
                }
                this.f704c = (float) Math.floor(degrees);
            } catch (Exception unused) {
                this.f704c = 0.0f;
            }
        }
    }
}