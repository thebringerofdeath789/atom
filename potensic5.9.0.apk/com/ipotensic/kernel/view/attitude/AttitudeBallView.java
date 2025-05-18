package com.ipotensic.kernel.view.attitude;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import com.ipotensic.baselib.DDLog;
import com.mapbox.mapboxsdk.geometry.LatLng;

/* loaded from: classes2.dex */
public class AttitudeBallView extends View implements AttitudeSettingInterface {
    private Attitude attitude;
    private Compass compass;
    private GlobalBg globalBg;
    private int height;
    private boolean isDestroy;
    private boolean isInit;
    private Points points;
    private int width;
    private Wind wind;

    public AttitudeBallView(Context context) {
        super(context);
        this.isInit = false;
        this.isDestroy = false;
    }

    public AttitudeBallView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isInit = false;
        this.isDestroy = false;
    }

    public AttitudeBallView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isInit = false;
        this.isDestroy = false;
    }

    public AttitudeBallView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.isInit = false;
        this.isDestroy = false;
    }

    private void init() {
        if (this.isInit || this.isDestroy) {
            return;
        }
        this.width = getMeasuredWidth();
        this.height = getMeasuredHeight();
        this.compass = new Compass(getContext(), this.width, this.height);
        this.globalBg = new GlobalBg(getContext(), this.width, this.height);
        this.points = new Points(getContext(), this.width, this.height, this.globalBg.getRadius());
        this.attitude = new Attitude(getContext(), this.width, this.height);
        this.wind = new Wind(getContext(), this.width, this.height);
        this.isInit = true;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        init();
        try {
            this.globalBg.draw(canvas);
            this.attitude.draw(canvas);
            this.compass.draw(canvas);
            this.points.draw(canvas);
            this.wind.draw(canvas);
        } catch (Exception e) {
            DDLog.m1684e("姿态球绘制失败:" + e.getMessage());
        }
    }

    @Override // com.ipotensic.kernel.view.attitude.AttitudeSettingInterface
    public void setAngleToNorth(int i) {
        if (this.isInit) {
            int i2 = -i;
            this.compass.setRotate(i2);
            this.points.setRotate(i2);
            this.wind.setRotate(i2);
            postInvalidate();
        }
    }

    @Override // com.ipotensic.kernel.view.attitude.AttitudeSettingInterface
    public void setRemoterAngel(int i) {
        if (this.isInit) {
            this.points.setRemoterRotate(i);
            postInvalidate();
        }
    }

    @Override // com.ipotensic.kernel.view.attitude.AttitudeSettingInterface
    public void setYawPitch(int i) {
        if (this.isInit) {
            this.attitude.setYawPitch(i);
            postInvalidate();
        }
    }

    @Override // com.ipotensic.kernel.view.attitude.AttitudeSettingInterface
    public void setRotate(int i) {
        if (this.isInit) {
            this.attitude.setRotate(i);
            postInvalidate();
        }
    }

    @Override // com.ipotensic.kernel.view.attitude.AttitudeSettingInterface
    public void setFlightLatLng(LatLng latLng) {
        if (this.isInit) {
            this.points.setFlightPosition(latLng);
            postInvalidate();
        }
    }

    @Override // com.ipotensic.kernel.view.attitude.AttitudeSettingInterface
    public void setRemoterLatLng(LatLng latLng) {
        if (this.isInit) {
            this.points.setRemoterPosition(latLng);
            postInvalidate();
        }
    }

    @Override // com.ipotensic.kernel.view.attitude.AttitudeSettingInterface
    public void setHomeLatLng(LatLng latLng) {
        if (this.isInit) {
            this.points.setHomePosition(latLng);
            postInvalidate();
        }
    }

    @Override // com.ipotensic.kernel.view.attitude.AttitudeSettingInterface
    public void setConnect(boolean z) {
        if (this.isInit) {
            this.points.setConnect(z);
            this.compass.setConnect(z);
            this.attitude.setConnect(z);
            postInvalidate();
        }
    }

    public void setConnected(boolean z) {
        if (this.isInit) {
            this.wind.setConnect(z);
            postInvalidate();
        }
    }

    @Override // com.ipotensic.kernel.view.attitude.AttitudeSettingInterface
    public void setWindSpeedAndDirection(int i, float f) {
        if (this.isInit) {
            this.wind.setWindSpeedAndDirection(i, f);
            postInvalidate();
        }
    }

    @Override // com.ipotensic.kernel.view.attitude.AttitudeSettingInterface
    public void deInit() {
        if (this.isInit) {
            this.points.release();
            this.compass.release();
            this.wind.release();
        }
        this.isInit = false;
        this.isDestroy = true;
    }
}