package com.ipotensic.kernel.maps;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import com.ipotensic.kernel.bean.MultiPointBean;
import com.ipotensic.kernel.view.mapscaleview.MapScaleView;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public abstract class BaseMap<T extends Parcelable> {
    protected MapInfoListener listener;
    protected float rotate;
    protected MapScaleView scaleView;
    protected final int MAX_POINT_NUM = 15;
    protected final int ATOM_MAX_POINT_NUM = 30;
    protected final int MIN_POINT_NUM = 1;

    public abstract void clearMarkAndPoly(boolean z);

    public abstract void drawCircle(float f);

    public abstract void drawLine(ArrayList<T> arrayList, boolean z);

    public abstract void drawPoint();

    public abstract void fly();

    public abstract void flyAlwaysLocation(double d, double d2, float f);

    public abstract void init();

    public abstract void locationStart(double d, double d2);

    public abstract void onCreate(Bundle bundle);

    public abstract void onDestroy();

    public abstract void onLowMemory();

    public abstract void onPause();

    public abstract void onResume();

    public abstract void onSaveInstanceState(Bundle bundle);

    public abstract void saveMarkFlight();

    public abstract void setMapType(String str);

    public abstract void setZoomScale(float f);

    public abstract void showFlyLocation();

    public abstract void showFlyStartLocation();

    public abstract void showHomePointLocation(double d, double d2);

    public abstract void showMyLocation();

    public abstract void showRecordMarkFlight(List<MultiPointBean> list);

    public abstract void startRotate(View view);

    public abstract void stopRotate();

    public abstract void systemLocationStart(double d, double d2);

    public void setView(View... viewArr) {
        this.scaleView = (MapScaleView) viewArr[1];
    }

    protected Bitmap convertViewToBitmap(View view) {
        view.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
        view.buildDrawingCache();
        return view.getDrawingCache();
    }

    public void setMapInfoListener(MapInfoListener mapInfoListener) {
        this.listener = mapInfoListener;
    }

    public int getGoogleDistance(double d, double d2, double d3, double d4) {
        double d5 = d * 0.017453292519943295d;
        double d6 = d3 * 0.017453292519943295d;
        return (int) (Math.acos((Math.sin(d5) * Math.sin(d6)) + (Math.cos(d5) * Math.cos(d6) * Math.cos((d4 * 0.017453292519943295d) - (d2 * 0.017453292519943295d)))) * 6371.0d * 1000.0d);
    }

    public String getMapPointsDistance(float f) {
        if (f < 1000.0f) {
            return Math.round(f) + "m";
        }
        return new BigDecimal(f / 1000.0f).setScale(1, 1).floatValue() + "km";
    }
}