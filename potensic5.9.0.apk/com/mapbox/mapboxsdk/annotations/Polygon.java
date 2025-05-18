package com.mapbox.mapboxsdk.annotations;

import androidx.core.view.ViewCompat;
import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import java.util.ArrayList;
import java.util.List;

@Deprecated
/* loaded from: classes3.dex */
public final class Polygon extends BasePointCollection {
    private int fillColor = ViewCompat.MEASURED_STATE_MASK;
    private int strokeColor = ViewCompat.MEASURED_STATE_MASK;
    private List<List<LatLng>> holes = new ArrayList();

    Polygon() {
    }

    public int getFillColor() {
        return this.fillColor;
    }

    public int getStrokeColor() {
        return this.strokeColor;
    }

    public List<List<LatLng>> getHoles() {
        return new ArrayList(this.holes);
    }

    public void setFillColor(int i) {
        this.fillColor = i;
        update();
    }

    public void setStrokeColor(int i) {
        this.strokeColor = i;
        update();
    }

    public void setHoles(List<? extends List<LatLng>> list) {
        this.holes = new ArrayList(list);
        update();
    }

    void addHole(List<LatLng> list) {
        this.holes.add(list);
        update();
    }

    @Override // com.mapbox.mapboxsdk.annotations.BasePointCollection
    void update() {
        MapboxMap mapboxMap = getMapboxMap();
        if (mapboxMap != null) {
            mapboxMap.updatePolygon(this);
        }
    }
}