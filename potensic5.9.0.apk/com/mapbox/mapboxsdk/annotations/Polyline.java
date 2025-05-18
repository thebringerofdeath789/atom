package com.mapbox.mapboxsdk.annotations;

import androidx.core.view.ViewCompat;
import com.mapbox.mapboxsdk.maps.MapboxMap;

@Deprecated
/* loaded from: classes3.dex */
public final class Polyline extends BasePointCollection {
    private int color = ViewCompat.MEASURED_STATE_MASK;
    private float width = 10.0f;

    Polyline() {
    }

    public int getColor() {
        return this.color;
    }

    public float getWidth() {
        return this.width;
    }

    public void setColor(int i) {
        this.color = i;
        update();
    }

    public void setWidth(float f) {
        this.width = f;
        update();
    }

    @Override // com.mapbox.mapboxsdk.annotations.BasePointCollection
    void update() {
        MapboxMap mapboxMap = getMapboxMap();
        if (mapboxMap != null) {
            mapboxMap.updatePolyline(this);
        }
    }
}