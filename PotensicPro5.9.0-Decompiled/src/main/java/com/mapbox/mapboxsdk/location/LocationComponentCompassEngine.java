package com.mapbox.mapboxsdk.location;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.SystemClock;
import android.view.WindowManager;
import com.mapbox.mapboxsdk.log.Logger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
class LocationComponentCompassEngine implements CompassEngine, SensorEventListener {
    private static final float ALPHA = 0.45f;
    static final int SENSOR_DELAY_MICROS = 100000;
    private static final String TAG = "Mbgl-LocationComponentCompassEngine";
    private Sensor compassSensor;
    private long compassUpdateNextTimestamp;
    private Sensor gravitySensor;
    private int lastAccuracySensorStatus;
    private float lastHeading;
    private Sensor magneticFieldSensor;
    private float[] rotationVectorValue;
    private final SensorManager sensorManager;
    private final WindowManager windowManager;
    private final List<CompassListener> compassListeners = new ArrayList();
    private float[] truncatedRotationVectorValue = new float[4];
    private float[] rotationMatrix = new float[9];
    private float[] gravityValues = new float[3];
    private float[] magneticValues = new float[3];

    LocationComponentCompassEngine(WindowManager windowManager, SensorManager sensorManager) {
        this.windowManager = windowManager;
        this.sensorManager = sensorManager;
        Sensor defaultSensor = sensorManager.getDefaultSensor(11);
        this.compassSensor = defaultSensor;
        if (defaultSensor == null) {
            Logger.d(TAG, "Rotation vector sensor not supported on device, falling back to accelerometer and magnetic field.");
            this.gravitySensor = sensorManager.getDefaultSensor(1);
            this.magneticFieldSensor = sensorManager.getDefaultSensor(2);
        }
    }

    @Override // com.mapbox.mapboxsdk.location.CompassEngine
    public void addCompassListener(CompassListener compassListener) {
        if (this.compassListeners.isEmpty()) {
            registerSensorListeners();
        }
        this.compassListeners.add(compassListener);
    }

    @Override // com.mapbox.mapboxsdk.location.CompassEngine
    public void removeCompassListener(CompassListener compassListener) {
        this.compassListeners.remove(compassListener);
        if (this.compassListeners.isEmpty()) {
            unregisterSensorListeners();
        }
    }

    @Override // com.mapbox.mapboxsdk.location.CompassEngine
    public int getLastAccuracySensorStatus() {
        return this.lastAccuracySensorStatus;
    }

    @Override // com.mapbox.mapboxsdk.location.CompassEngine
    public float getLastHeading() {
        return this.lastHeading;
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (this.lastAccuracySensorStatus == 0) {
            Logger.d(TAG, "Compass sensor is unreliable, device calibration is needed.");
        }
        if (sensorEvent.sensor.getType() == 11) {
            this.rotationVectorValue = getRotationVectorFromSensorEvent(sensorEvent);
            updateOrientation();
        } else if (sensorEvent.sensor.getType() == 1) {
            this.gravityValues = lowPassFilter(getRotationVectorFromSensorEvent(sensorEvent), this.gravityValues);
            updateOrientation();
        } else if (sensorEvent.sensor.getType() == 2) {
            this.magneticValues = lowPassFilter(getRotationVectorFromSensorEvent(sensorEvent), this.magneticValues);
            updateOrientation();
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
        if (this.lastAccuracySensorStatus != i) {
            Iterator<CompassListener> it = this.compassListeners.iterator();
            while (it.hasNext()) {
                it.next().onCompassAccuracyChange(i);
            }
            this.lastAccuracySensorStatus = i;
        }
    }

    private void updateOrientation() {
        int i;
        int i2;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (elapsedRealtime < this.compassUpdateNextTimestamp) {
            return;
        }
        float[] fArr = this.rotationVectorValue;
        if (fArr != null) {
            SensorManager.getRotationMatrixFromVector(this.rotationMatrix, fArr);
        } else {
            SensorManager.getRotationMatrix(this.rotationMatrix, null, this.gravityValues, this.magneticValues);
        }
        int rotation = this.windowManager.getDefaultDisplay().getRotation();
        int i3 = 130;
        int i4 = 129;
        if (rotation == 1) {
            i = 129;
            i2 = 2;
        } else if (rotation == 2) {
            i = 130;
            i2 = 129;
        } else if (rotation != 3) {
            i = 2;
            i2 = 1;
        } else {
            i2 = 130;
            i = 1;
        }
        float[] fArr2 = new float[9];
        SensorManager.remapCoordinateSystem(this.rotationMatrix, i2, i, fArr2);
        float[] fArr3 = new float[3];
        SensorManager.getOrientation(fArr2, fArr3);
        if (fArr3[1] < -0.7853981633974483d) {
            int rotation2 = this.windowManager.getDefaultDisplay().getRotation();
            if (rotation2 == 1) {
                i3 = 3;
            } else if (rotation2 == 2) {
                i3 = 129;
                i4 = 131;
            } else if (rotation2 != 3) {
                i4 = 3;
                i3 = 1;
            } else {
                i4 = 1;
                i3 = 131;
            }
        } else if (fArr3[1] > 0.7853981633974483d) {
            int rotation3 = this.windowManager.getDefaultDisplay().getRotation();
            if (rotation3 != 1) {
                if (rotation3 == 2) {
                    i3 = 129;
                    i4 = 3;
                } else if (rotation3 != 3) {
                    i3 = 1;
                    i4 = 131;
                } else {
                    i3 = 3;
                    i4 = 1;
                }
            }
            i3 = 131;
        } else if (Math.abs(fArr3[2]) > 1.5707963267948966d) {
            int rotation4 = this.windowManager.getDefaultDisplay().getRotation();
            if (rotation4 != 1) {
                if (rotation4 == 2) {
                    i3 = 129;
                    i4 = 2;
                } else if (rotation4 != 3) {
                    i4 = 130;
                    i3 = 1;
                } else {
                    i3 = 2;
                    i4 = 1;
                }
            }
        } else {
            i3 = i2;
            i4 = i;
        }
        SensorManager.remapCoordinateSystem(this.rotationMatrix, i3, i4, fArr2);
        SensorManager.getOrientation(fArr2, fArr3);
        notifyCompassChangeListeners((float) Math.toDegrees(fArr3[0]));
        this.compassUpdateNextTimestamp = elapsedRealtime + 500;
    }

    private void notifyCompassChangeListeners(float f) {
        Iterator<CompassListener> it = this.compassListeners.iterator();
        while (it.hasNext()) {
            it.next().onCompassChanged(f);
        }
        this.lastHeading = f;
    }

    private void registerSensorListeners() {
        if (isCompassSensorAvailable()) {
            this.sensorManager.registerListener(this, this.compassSensor, 100000);
        } else {
            this.sensorManager.registerListener(this, this.gravitySensor, 100000);
            this.sensorManager.registerListener(this, this.magneticFieldSensor, 100000);
        }
    }

    private void unregisterSensorListeners() {
        if (isCompassSensorAvailable()) {
            this.sensorManager.unregisterListener(this, this.compassSensor);
        } else {
            this.sensorManager.unregisterListener(this, this.gravitySensor);
            this.sensorManager.unregisterListener(this, this.magneticFieldSensor);
        }
    }

    private boolean isCompassSensorAvailable() {
        return this.compassSensor != null;
    }

    private float[] lowPassFilter(float[] fArr, float[] fArr2) {
        if (fArr2 == null) {
            return fArr;
        }
        for (int i = 0; i < fArr.length; i++) {
            fArr2[i] = fArr2[i] + ((fArr[i] - fArr2[i]) * ALPHA);
        }
        return fArr2;
    }

    private float[] getRotationVectorFromSensorEvent(SensorEvent sensorEvent) {
        if (sensorEvent.values.length > 4) {
            System.arraycopy(sensorEvent.values, 0, this.truncatedRotationVectorValue, 0, 4);
            return this.truncatedRotationVectorValue;
        }
        return sensorEvent.values;
    }
}
