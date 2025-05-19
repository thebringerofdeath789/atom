package com.mapbox.mapboxsdk.annotations;

import android.view.View;
import com.mapbox.mapboxsdk.R;
import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.mapboxsdk.maps.MapView;
import com.mapbox.mapboxsdk.maps.MapboxMap;

@Deprecated
/* loaded from: classes3.dex */
public class Marker extends Annotation {
    private Icon icon;
    private String iconId;
    private InfoWindow infoWindow;
    private boolean infoWindowShown;
    private LatLng position;
    private int rightOffsetPixels;
    private String snippet;
    private String title;
    private int topOffsetPixels;

    Marker() {
    }

    public Marker(BaseMarkerOptions baseMarkerOptions) {
        this(baseMarkerOptions.position, baseMarkerOptions.icon, baseMarkerOptions.title, baseMarkerOptions.snippet);
    }

    Marker(LatLng latLng, Icon icon, String str, String str2) {
        this.position = latLng;
        this.title = str;
        this.snippet = str2;
        setIcon(icon);
    }

    public LatLng getPosition() {
        return this.position;
    }

    public String getSnippet() {
        return this.snippet;
    }

    public String getTitle() {
        return this.title;
    }

    public void hideInfoWindow() {
        InfoWindow infoWindow = this.infoWindow;
        if (infoWindow != null) {
            infoWindow.close();
        }
        this.infoWindowShown = false;
    }

    public boolean isInfoWindowShown() {
        return this.infoWindowShown;
    }

    public void setPosition(LatLng latLng) {
        this.position = latLng;
        MapboxMap mapboxMap = getMapboxMap();
        if (mapboxMap != null) {
            mapboxMap.updateMarker(this);
        }
    }

    public void setSnippet(String str) {
        this.snippet = str;
        refreshInfoWindowContent();
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
        this.iconId = icon != null ? icon.getId() : null;
        MapboxMap mapboxMap = getMapboxMap();
        if (mapboxMap != null) {
            mapboxMap.updateMarker(this);
        }
    }

    public Icon getIcon() {
        return this.icon;
    }

    public void setTitle(String str) {
        this.title = str;
        refreshInfoWindowContent();
    }

    public InfoWindow getInfoWindow() {
        return this.infoWindow;
    }

    private void refreshInfoWindowContent() {
        if (!isInfoWindowShown() || this.mapView == null || this.mapboxMap == null || this.mapboxMap.getInfoWindowAdapter() != null) {
            return;
        }
        InfoWindow infoWindow = getInfoWindow(this.mapView);
        if (this.mapView.getContext() != null) {
            infoWindow.adaptDefaultMarker(this, this.mapboxMap, this.mapView);
        }
        MapboxMap mapboxMap = getMapboxMap();
        if (mapboxMap != null) {
            mapboxMap.updateMarker(this);
        }
        infoWindow.onContentUpdate();
    }

    public InfoWindow showInfoWindow(MapboxMap mapboxMap, MapView mapView) {
        View infoWindow;
        setMapboxMap(mapboxMap);
        setMapView(mapView);
        MapboxMap.InfoWindowAdapter infoWindowAdapter = getMapboxMap().getInfoWindowAdapter();
        if (infoWindowAdapter != null && (infoWindow = infoWindowAdapter.getInfoWindow(this)) != null) {
            InfoWindow infoWindow2 = new InfoWindow(infoWindow, mapboxMap);
            this.infoWindow = infoWindow2;
            showInfoWindow(infoWindow2, mapView);
            return this.infoWindow;
        }
        InfoWindow infoWindow3 = getInfoWindow(mapView);
        if (mapView.getContext() != null) {
            infoWindow3.adaptDefaultMarker(this, mapboxMap, mapView);
        }
        return showInfoWindow(infoWindow3, mapView);
    }

    private InfoWindow showInfoWindow(InfoWindow infoWindow, MapView mapView) {
        infoWindow.open(mapView, this, getPosition(), this.rightOffsetPixels, this.topOffsetPixels);
        this.infoWindowShown = true;
        return infoWindow;
    }

    private InfoWindow getInfoWindow(MapView mapView) {
        if (this.infoWindow == null && mapView.getContext() != null) {
            this.infoWindow = new InfoWindow(mapView, R.layout.mapbox_infowindow_content, getMapboxMap());
        }
        return this.infoWindow;
    }

    public void setTopOffsetPixels(int i) {
        this.topOffsetPixels = i;
    }

    public void setRightOffsetPixels(int i) {
        this.rightOffsetPixels = i;
    }

    public String toString() {
        return "Marker [position[" + getPosition() + "]]";
    }
}
