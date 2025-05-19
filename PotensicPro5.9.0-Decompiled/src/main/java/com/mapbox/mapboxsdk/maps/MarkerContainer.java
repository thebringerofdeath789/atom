package com.mapbox.mapboxsdk.maps;

import android.graphics.RectF;
import androidx.collection.LongSparseArray;
import com.mapbox.mapboxsdk.annotations.Annotation;
import com.mapbox.mapboxsdk.annotations.BaseMarkerOptions;
import com.mapbox.mapboxsdk.annotations.Marker;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
class MarkerContainer implements Markers {
    private final LongSparseArray<Annotation> annotations;
    private final IconManager iconManager;
    private final NativeMap nativeMapView;

    MarkerContainer(NativeMap nativeMap, LongSparseArray<Annotation> longSparseArray, IconManager iconManager) {
        this.nativeMapView = nativeMap;
        this.annotations = longSparseArray;
        this.iconManager = iconManager;
    }

    @Override // com.mapbox.mapboxsdk.maps.Markers
    public Marker addBy(BaseMarkerOptions baseMarkerOptions, MapboxMap mapboxMap) {
        Marker prepareMarker = prepareMarker(baseMarkerOptions);
        NativeMap nativeMap = this.nativeMapView;
        long addMarker = nativeMap != null ? nativeMap.addMarker(prepareMarker) : 0L;
        prepareMarker.setMapboxMap(mapboxMap);
        prepareMarker.setId(addMarker);
        this.annotations.put(addMarker, prepareMarker);
        return prepareMarker;
    }

    @Override // com.mapbox.mapboxsdk.maps.Markers
    public List<Marker> addBy(List<? extends BaseMarkerOptions> list, MapboxMap mapboxMap) {
        int size = list.size();
        ArrayList arrayList = new ArrayList(size);
        if (this.nativeMapView != null && size > 0) {
            for (int i = 0; i < size; i++) {
                arrayList.add(prepareMarker(list.get(i)));
            }
            if (arrayList.size() > 0) {
                long[] addMarkers = this.nativeMapView.addMarkers(arrayList);
                for (int i2 = 0; i2 < addMarkers.length; i2++) {
                    Marker marker = (Marker) arrayList.get(i2);
                    marker.setMapboxMap(mapboxMap);
                    marker.setId(addMarkers[i2]);
                    this.annotations.put(addMarkers[i2], marker);
                }
            }
        }
        return arrayList;
    }

    @Override // com.mapbox.mapboxsdk.maps.Markers
    public void update(Marker marker, MapboxMap mapboxMap) {
        ensureIconLoaded(marker, mapboxMap);
        this.nativeMapView.updateMarker(marker);
        LongSparseArray<Annotation> longSparseArray = this.annotations;
        longSparseArray.setValueAt(longSparseArray.indexOfKey(marker.getId()), marker);
    }

    @Override // com.mapbox.mapboxsdk.maps.Markers
    public List<Marker> obtainAll() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.annotations.size(); i++) {
            LongSparseArray<Annotation> longSparseArray = this.annotations;
            Annotation annotation = longSparseArray.get(longSparseArray.keyAt(i));
            if (annotation instanceof Marker) {
                arrayList.add((Marker) annotation);
            }
        }
        return arrayList;
    }

    @Override // com.mapbox.mapboxsdk.maps.Markers
    public List<Marker> obtainAllIn(RectF rectF) {
        long[] queryPointAnnotations = this.nativeMapView.queryPointAnnotations(this.nativeMapView.getDensityDependantRectangle(rectF));
        ArrayList arrayList = new ArrayList(queryPointAnnotations.length);
        for (long j : queryPointAnnotations) {
            arrayList.add(Long.valueOf(j));
        }
        ArrayList arrayList2 = new ArrayList(queryPointAnnotations.length);
        List<Annotation> obtainAnnotations = obtainAnnotations();
        int size = obtainAnnotations.size();
        for (int i = 0; i < size; i++) {
            Annotation annotation = obtainAnnotations.get(i);
            if ((annotation instanceof Marker) && arrayList.contains(Long.valueOf(annotation.getId()))) {
                arrayList2.add((Marker) annotation);
            }
        }
        return new ArrayList(arrayList2);
    }

    @Override // com.mapbox.mapboxsdk.maps.Markers
    public void reload() {
        this.iconManager.reloadIcons();
        int size = this.annotations.size();
        for (int i = 0; i < size; i++) {
            Annotation annotation = this.annotations.get(i);
            if (annotation instanceof Marker) {
                Marker marker = (Marker) annotation;
                this.nativeMapView.removeAnnotation(annotation.getId());
                marker.setId(this.nativeMapView.addMarker(marker));
            }
        }
    }

    private Marker prepareMarker(BaseMarkerOptions baseMarkerOptions) {
        Marker marker = baseMarkerOptions.getMarker();
        marker.setTopOffsetPixels(this.iconManager.getTopOffsetPixelsForIcon(this.iconManager.loadIconForMarker(marker)));
        return marker;
    }

    private void ensureIconLoaded(Marker marker, MapboxMap mapboxMap) {
        this.iconManager.ensureIconLoaded(marker, mapboxMap);
    }

    private List<Annotation> obtainAnnotations() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.annotations.size(); i++) {
            LongSparseArray<Annotation> longSparseArray = this.annotations;
            arrayList.add(longSparseArray.get(longSparseArray.keyAt(i)));
        }
        return arrayList;
    }
}
