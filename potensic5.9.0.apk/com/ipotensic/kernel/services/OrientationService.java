package com.ipotensic.kernel.services;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.Display;
import android.view.WindowManager;
import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.configs.PhoneConfig;
import com.ipotensic.baselib.dispatcher.EventDispatcher;
import com.ipotensic.baselib.dispatcher.EventID;
import com.ipotensic.baselib.netty.Constant;

/* loaded from: classes2.dex */
public class OrientationService implements SensorEventListener {
    private Sensor acceleSensor;
    private Display display;
    private float lastX;
    private float mAngle;
    private Context mContext;
    private OnOrientationListener mOnOrientationListener;
    private Sensor mSensor;
    private SensorManager mSensorManager;
    private Sensor magSensor;
    private float orientationX;
    private float rotateValue;
    private boolean isRunning = false;
    private long lastTime = 0;
    private final int TIME_SENSOR = 200;
    private float[] gravity = null;
    private float[] geomagnetic = null;

    /* renamed from: r */
    private float[] f2237r = new float[9];
    private float[] values = new float[3];
    private long lastRecordTime = 0;
    private final long LOG_INTERVAL_TIME = Constant.DELAY_MILLIS;
    private Handler handler = new Handler(Looper.getMainLooper()) { // from class: com.ipotensic.kernel.services.OrientationService.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int screenRotationOnPhone = OrientationService.this.getScreenRotationOnPhone(PhoneConfig.applicationContext);
            int i = message.what;
            if (i != 0) {
                if (i == 1 && OrientationService.this.gravity != null && OrientationService.this.geomagnetic != null && SensorManager.getRotationMatrix(OrientationService.this.f2237r, null, OrientationService.this.gravity, OrientationService.this.geomagnetic)) {
                    SensorManager.getOrientation(OrientationService.this.f2237r, OrientationService.this.values);
                    DDLog.m1685e("map", "values[0]: " + OrientationService.this.values[0]);
                    OrientationService.this.orientationX = (float) Math.toDegrees(OrientationService.this.values[0]);
                    DDLog.m1685e("map", "values[1]: " + OrientationService.this.orientationX);
                    OrientationService.access$116(OrientationService.this, screenRotationOnPhone);
                    if (Math.abs(OrientationService.this.mAngle - OrientationService.this.orientationX) < 1.0f) {
                        return;
                    }
                    OrientationService orientationService = OrientationService.this;
                    orientationService.mAngle = Float.isNaN(orientationService.orientationX) ? 0.0f : OrientationService.this.orientationX;
                    if (Math.abs(OrientationService.this.orientationX - OrientationService.this.lastX) > 1.0d && OrientationService.this.mOnOrientationListener != null) {
                        OrientationService.this.mOnOrientationListener.onOrientationChanged(360.0f - OrientationService.this.orientationX);
                    }
                    OrientationService orientationService2 = OrientationService.this;
                    orientationService2.lastX = orientationService2.orientationX;
                }
            } else {
                OrientationService.access$116(OrientationService.this, screenRotationOnPhone);
                OrientationService.access$148(OrientationService.this, 360.0f);
                if (OrientationService.this.orientationX > 180.0f) {
                    OrientationService.access$124(OrientationService.this, 360.0f);
                } else if (OrientationService.this.orientationX < -180.0f) {
                    OrientationService.access$116(OrientationService.this, 360.0f);
                }
                if (Math.abs(OrientationService.this.mAngle - OrientationService.this.orientationX) < 1.0f) {
                    return;
                }
                OrientationService orientationService3 = OrientationService.this;
                orientationService3.mAngle = Float.isNaN(orientationService3.orientationX) ? 0.0f : OrientationService.this.orientationX;
                if (Math.abs(OrientationService.this.orientationX - OrientationService.this.lastX) > 1.0d && OrientationService.this.mOnOrientationListener != null) {
                    OrientationService.this.mOnOrientationListener.onOrientationChanged(360.0f - OrientationService.this.orientationX);
                }
                OrientationService orientationService4 = OrientationService.this;
                orientationService4.lastX = orientationService4.orientationX;
            }
            EventDispatcher.get().sendEvent(EventID.EVENT_COMPASS_ROTATE_CHANGED, Float.valueOf(360.0f - OrientationService.this.orientationX));
            OrientationService.this.orientationX %= 360.0f;
            OrientationService orientationService5 = OrientationService.this;
            orientationService5.rotateValue = orientationService5.orientationX;
            EventDispatcher.get().sendEvent(EventID.EVENT_DEVICE_ROTATE_CHANGED, Float.valueOf(OrientationService.this.orientationX));
            if (System.currentTimeMillis() - OrientationService.this.lastRecordTime > Constant.DELAY_MILLIS) {
                OrientationService.this.lastRecordTime = System.currentTimeMillis();
                DDLog.m1684e("Map orientationService orientation = " + OrientationService.this.orientationX + ",screenRotationOnPhone = " + screenRotationOnPhone);
            }
        }
    };

    public interface OnOrientationListener {
        void onOrientationChanged(float f);
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    static /* synthetic */ float access$116(OrientationService orientationService, float f) {
        float f2 = orientationService.orientationX + f;
        orientationService.orientationX = f2;
        return f2;
    }

    static /* synthetic */ float access$124(OrientationService orientationService, float f) {
        float f2 = orientationService.orientationX - f;
        orientationService.orientationX = f2;
        return f2;
    }

    static /* synthetic */ float access$148(OrientationService orientationService, float f) {
        float f2 = orientationService.orientationX % f;
        orientationService.orientationX = f2;
        return f2;
    }

    public OrientationService(Context context) {
        this.mContext = context;
    }

    public void start() {
        SensorManager sensorManager = (SensorManager) this.mContext.getSystemService("sensor");
        this.mSensorManager = sensorManager;
        if (sensorManager != null) {
            this.mSensor = sensorManager.getDefaultSensor(3);
            this.acceleSensor = this.mSensorManager.getDefaultSensor(1);
            this.magSensor = this.mSensorManager.getDefaultSensor(2);
        }
        Sensor sensor = this.mSensor;
        if (sensor != null) {
            this.mSensorManager.registerListener(this, sensor, 3);
        } else {
            this.mSensorManager.registerListener(this, this.acceleSensor, 3);
            this.mSensorManager.registerListener(this, this.magSensor, 3);
        }
        this.isRunning = true;
    }

    public void stop() {
        this.mSensorManager.unregisterListener(this);
        this.isRunning = false;
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (this.lastTime > System.currentTimeMillis()) {
            this.lastTime = 0L;
        }
        if (System.currentTimeMillis() - this.lastTime < 200) {
            return;
        }
        int type = sensorEvent.sensor.getType();
        if (type == 1) {
            this.gravity = sensorEvent.values;
            this.handler.sendEmptyMessage(1);
        } else if (type == 2) {
            this.geomagnetic = sensorEvent.values;
            this.handler.sendEmptyMessage(1);
        } else if (type == 3) {
            this.orientationX = sensorEvent.values[0];
            this.handler.sendEmptyMessage(0);
        }
        this.lastTime = System.currentTimeMillis();
    }

    public float getRotate() {
        return this.rotateValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getScreenRotationOnPhone(Context context) {
        try {
            if (this.display == null) {
                this.display = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            }
            int rotation = this.display.getRotation();
            if (rotation == 1) {
                return 90;
            }
            if (rotation != 2) {
                return rotation != 3 ? 0 : -90;
            }
            return 180;
        } catch (Exception e) {
            DDLog.m1684e("OrientationService.getScreenRotationOnPhone:" + e.getMessage());
            return 0;
        }
    }

    public boolean isRunning() {
        return this.isRunning;
    }

    public void setOnOrientationListener(OnOrientationListener onOrientationListener) {
        this.mOnOrientationListener = onOrientationListener;
    }

    public float getSensorValue() {
        return this.lastX;
    }
}