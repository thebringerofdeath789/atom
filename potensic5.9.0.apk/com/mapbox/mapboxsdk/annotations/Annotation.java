package com.mapbox.mapboxsdk.annotations;

import com.mapbox.mapboxsdk.maps.MapView;
import com.mapbox.mapboxsdk.maps.MapboxMap;

@Deprecated
/* loaded from: classes3.dex */
public abstract class Annotation implements Comparable<Annotation> {

    /* renamed from: id */
    private long f2698id = -1;
    protected MapView mapView;
    protected MapboxMap mapboxMap;

    protected Annotation() {
    }

    public long getId() {
        return this.f2698id;
    }

    public void remove() {
        MapboxMap mapboxMap = this.mapboxMap;
        if (mapboxMap == null) {
            return;
        }
        mapboxMap.removeAnnotation(this);
    }

    public void setId(long j) {
        this.f2698id = j;
    }

    public void setMapboxMap(MapboxMap mapboxMap) {
        this.mapboxMap = mapboxMap;
    }

    protected MapboxMap getMapboxMap() {
        return this.mapboxMap;
    }

    public void setMapView(MapView mapView) {
        this.mapView = mapView;
    }

    protected MapView getMapView() {
        return this.mapView;
    }

    @Override // java.lang.Comparable
    public int compareTo(Annotation annotation) {
        if (this.f2698id < annotation.getId()) {
            return 1;
        }
        return this.f2698id > annotation.getId() ? -1 : 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && (obj instanceof Annotation) && this.f2698id == ((Annotation) obj).getId();
    }

    public int hashCode() {
        return (int) (getId() ^ (getId() >>> 32));
    }
}