package com.mapbox.mapboxsdk.maps;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.mapbox.mapboxsdk.utils.MapFragmentUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public final class MapFragment extends Fragment implements OnMapReadyCallback {
    private MapView map;
    private final List<OnMapReadyCallback> mapReadyCallbackList = new ArrayList();
    private OnMapViewReadyCallback mapViewReadyCallback;
    private MapboxMap mapboxMap;

    public interface OnMapViewReadyCallback {
        void onMapViewReady(MapView mapView);
    }

    public static MapFragment newInstance() {
        return new MapFragment();
    }

    public static MapFragment newInstance(MapboxMapOptions mapboxMapOptions) {
        MapFragment mapFragment = new MapFragment();
        mapFragment.setArguments(MapFragmentUtils.createFragmentArgs(mapboxMapOptions));
        return mapFragment;
    }

    @Override // android.app.Fragment
    public void onInflate(Context context, AttributeSet attributeSet, Bundle bundle) {
        super.onInflate(context, attributeSet, bundle);
        setArguments(MapFragmentUtils.createFragmentArgs(MapboxMapOptions.createFromAttributes(context, attributeSet)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnMapViewReadyCallback) {
            this.mapViewReadyCallback = (OnMapViewReadyCallback) context;
        }
    }

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        Context context = layoutInflater.getContext();
        MapView mapView = new MapView(context, MapFragmentUtils.resolveArgs(context, getArguments()));
        this.map = mapView;
        return mapView;
    }

    @Override // android.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.map.onCreate(bundle);
        this.map.getMapAsync(this);
        OnMapViewReadyCallback onMapViewReadyCallback = this.mapViewReadyCallback;
        if (onMapViewReadyCallback != null) {
            onMapViewReadyCallback.onMapViewReady(this.map);
        }
    }

    @Override // com.mapbox.mapboxsdk.maps.OnMapReadyCallback
    public void onMapReady(MapboxMap mapboxMap) {
        this.mapboxMap = mapboxMap;
        Iterator<OnMapReadyCallback> it = this.mapReadyCallbackList.iterator();
        while (it.hasNext()) {
            it.next().onMapReady(mapboxMap);
        }
    }

    @Override // android.app.Fragment
    public void onStart() {
        super.onStart();
        this.map.onStart();
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        this.map.onResume();
    }

    @Override // android.app.Fragment
    public void onPause() {
        super.onPause();
        this.map.onPause();
    }

    @Override // android.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        MapView mapView = this.map;
        if (mapView == null || mapView.isDestroyed()) {
            return;
        }
        this.map.onSaveInstanceState(bundle);
    }

    @Override // android.app.Fragment
    public void onStop() {
        super.onStop();
        this.map.onStop();
    }

    @Override // android.app.Fragment, android.content.ComponentCallbacks
    public void onLowMemory() {
        super.onLowMemory();
        MapView mapView = this.map;
        if (mapView == null || mapView.isDestroyed()) {
            return;
        }
        this.map.onLowMemory();
    }

    @Override // android.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.map.onDestroy();
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.mapReadyCallbackList.clear();
    }

    public void getMapAsync(OnMapReadyCallback onMapReadyCallback) {
        MapboxMap mapboxMap = this.mapboxMap;
        if (mapboxMap == null) {
            this.mapReadyCallbackList.add(onMapReadyCallback);
        } else {
            onMapReadyCallback.onMapReady(mapboxMap);
        }
    }
}