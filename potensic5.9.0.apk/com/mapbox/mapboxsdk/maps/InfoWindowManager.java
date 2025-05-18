package com.mapbox.mapboxsdk.maps;

import android.text.TextUtils;
import com.mapbox.mapboxsdk.annotations.InfoWindow;
import com.mapbox.mapboxsdk.annotations.Marker;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
class InfoWindowManager {
    private boolean allowConcurrentMultipleInfoWindows;
    private MapboxMap.InfoWindowAdapter infoWindowAdapter;
    private final List<InfoWindow> infoWindows = new ArrayList();
    private MapboxMap.OnInfoWindowClickListener onInfoWindowClickListener;
    private MapboxMap.OnInfoWindowCloseListener onInfoWindowCloseListener;
    private MapboxMap.OnInfoWindowLongClickListener onInfoWindowLongClickListener;

    InfoWindowManager() {
    }

    void update() {
        if (this.infoWindows.isEmpty()) {
            return;
        }
        Iterator<InfoWindow> it = this.infoWindows.iterator();
        while (it.hasNext()) {
            it.next().update();
        }
    }

    void setInfoWindowAdapter(MapboxMap.InfoWindowAdapter infoWindowAdapter) {
        this.infoWindowAdapter = infoWindowAdapter;
    }

    MapboxMap.InfoWindowAdapter getInfoWindowAdapter() {
        return this.infoWindowAdapter;
    }

    void setAllowConcurrentMultipleOpenInfoWindows(boolean z) {
        this.allowConcurrentMultipleInfoWindows = z;
    }

    boolean isAllowConcurrentMultipleOpenInfoWindows() {
        return this.allowConcurrentMultipleInfoWindows;
    }

    boolean isInfoWindowValidForMarker(Marker marker) {
        return (marker == null || (TextUtils.isEmpty(marker.getTitle()) && TextUtils.isEmpty(marker.getSnippet()))) ? false : true;
    }

    void setOnInfoWindowClickListener(MapboxMap.OnInfoWindowClickListener onInfoWindowClickListener) {
        this.onInfoWindowClickListener = onInfoWindowClickListener;
    }

    MapboxMap.OnInfoWindowClickListener getOnInfoWindowClickListener() {
        return this.onInfoWindowClickListener;
    }

    void setOnInfoWindowLongClickListener(MapboxMap.OnInfoWindowLongClickListener onInfoWindowLongClickListener) {
        this.onInfoWindowLongClickListener = onInfoWindowLongClickListener;
    }

    MapboxMap.OnInfoWindowLongClickListener getOnInfoWindowLongClickListener() {
        return this.onInfoWindowLongClickListener;
    }

    void setOnInfoWindowCloseListener(MapboxMap.OnInfoWindowCloseListener onInfoWindowCloseListener) {
        this.onInfoWindowCloseListener = onInfoWindowCloseListener;
    }

    MapboxMap.OnInfoWindowCloseListener getOnInfoWindowCloseListener() {
        return this.onInfoWindowCloseListener;
    }

    public void add(InfoWindow infoWindow) {
        this.infoWindows.add(infoWindow);
    }
}