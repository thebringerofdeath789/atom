package com.ipotensic.kernel.view.mapscaleview;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import com.ipotensic.baselib.utils.SPHelper;

/* loaded from: classes2.dex */
public class MapScaleView extends View {
    private final int desiredWidth;
    private final Drawer drawer;
    private boolean isChina;
    private double latitude;
    private final MapScaleModel mapScaleModel;
    private ScaleType scaleType;
    private Scales scales;
    private float zoom;

    private enum ScaleType {
        METERS_ONLY,
        MILES_ONLY,
        BOTH
    }

    public MapScaleView(Context context) {
        this(context, null);
    }

    public MapScaleView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MapScaleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.scaleType = ScaleType.BOTH;
        float f = getResources().getDisplayMetrics().density;
        this.mapScaleModel = new MapScaleModel(f);
        ViewConfig viewConfig = new ViewConfig(context, attributeSet);
        this.drawer = new Drawer(viewConfig.color, viewConfig.textSize, viewConfig.strokeWidth, f, viewConfig.outline, viewConfig.expandRtl, context);
        this.desiredWidth = viewConfig.desiredWidth;
        if (viewConfig.isMiles) {
            this.scaleType = ScaleType.MILES_ONLY;
        }
    }

    public void setColor(int i) {
        this.drawer.setColor(i);
        invalidate();
    }

    public void setTextSize(float f) {
        this.drawer.setTextSize(f);
        invalidate();
        requestLayout();
    }

    public void setStrokeWidth(float f) {
        this.drawer.setStrokeWidth(f);
        invalidate();
        requestLayout();
    }

    public void setOutlineEnabled(boolean z) {
        this.drawer.setOutlineEnabled(z);
        invalidate();
    }

    public void setExpandRtlEnabled(boolean z) {
        this.drawer.setExpandRtlEnabled(z);
        invalidate();
    }

    @Deprecated
    public void setIsMiles(boolean z) {
        if (z) {
            milesOnly();
        } else {
            metersAndMiles();
        }
    }

    public void metersOnly() {
        this.scaleType = ScaleType.METERS_ONLY;
        updateScales();
    }

    public void milesOnly() {
        this.scaleType = ScaleType.MILES_ONLY;
        updateScales();
    }

    public void metersAndMiles() {
        this.scaleType = ScaleType.BOTH;
        updateScales();
    }

    public void update(float f, double d) {
        boolean z = !SPHelper.getInstance().isFt();
        this.isChina = z;
        this.zoom = f;
        this.latitude = d;
        this.mapScaleModel.setPosition(f, d, z);
        updateScales();
    }

    private void updateScales() {
        Scale update;
        if (this.isChina) {
            update = this.mapScaleModel.update(true);
        } else {
            update = this.mapScaleModel.update(false);
        }
        this.scales = new Scales(update, null);
        invalidate();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int measureDimension = measureDimension(desiredWidth(), i);
        int measureDimension2 = measureDimension(desiredHeight(), i2);
        this.mapScaleModel.setMaxWidth(measureDimension);
        this.drawer.setViewWidth(measureDimension);
        updateScales();
        setMeasuredDimension(measureDimension, measureDimension2);
    }

    private int desiredWidth() {
        return this.desiredWidth;
    }

    private int desiredHeight() {
        return this.drawer.getHeight();
    }

    private int measureDimension(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        return mode == 1073741824 ? size : mode == Integer.MIN_VALUE ? Math.min(i, size) : i;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        this.drawer.draw(canvas, this.scales);
    }

    public void setUnitType() {
        boolean z = !SPHelper.getInstance().isFt();
        this.isChina = z;
        this.mapScaleModel.setPosition(this.zoom, this.latitude, z);
        updateScales();
    }
}
