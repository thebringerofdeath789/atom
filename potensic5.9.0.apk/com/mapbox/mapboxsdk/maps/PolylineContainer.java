package com.mapbox.mapboxsdk.maps;

import androidx.collection.LongSparseArray;
import com.mapbox.mapboxsdk.annotations.Annotation;
import com.mapbox.mapboxsdk.annotations.Polyline;
import com.mapbox.mapboxsdk.annotations.PolylineOptions;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
class PolylineContainer implements Polylines {
    private final LongSparseArray<Annotation> annotations;
    private final NativeMap nativeMap;

    PolylineContainer(NativeMap nativeMap, LongSparseArray<Annotation> longSparseArray) {
        this.nativeMap = nativeMap;
        this.annotations = longSparseArray;
    }

    @Override // com.mapbox.mapboxsdk.maps.Polylines
    public Polyline addBy(PolylineOptions polylineOptions, MapboxMap mapboxMap) {
        Polyline polyline = polylineOptions.getPolyline();
        if (!polyline.getPoints().isEmpty()) {
            NativeMap nativeMap = this.nativeMap;
            long addPolyline = nativeMap != null ? nativeMap.addPolyline(polyline) : 0L;
            polyline.setMapboxMap(mapboxMap);
            polyline.setId(addPolyline);
            this.annotations.put(addPolyline, polyline);
        }
        return polyline;
    }

    @Override // com.mapbox.mapboxsdk.maps.Polylines
    public List<Polyline> addBy(List<PolylineOptions> list, MapboxMap mapboxMap) {
        int size = list.size();
        ArrayList arrayList = new ArrayList(size);
        if (this.nativeMap != null && size > 0) {
            Iterator<PolylineOptions> it = list.iterator();
            while (it.hasNext()) {
                Polyline polyline = it.next().getPolyline();
                if (!polyline.getPoints().isEmpty()) {
                    arrayList.add(polyline);
                }
            }
            long[] addPolylines = this.nativeMap.addPolylines(arrayList);
            for (int i = 0; i < addPolylines.length; i++) {
                Polyline polyline2 = (Polyline) arrayList.get(i);
                polyline2.setMapboxMap(mapboxMap);
                polyline2.setId(addPolylines[i]);
                this.annotations.put(addPolylines[i], polyline2);
            }
        }
        return arrayList;
    }

    @Override // com.mapbox.mapboxsdk.maps.Polylines
    public void update(Polyline polyline) {
        this.nativeMap.updatePolyline(polyline);
        LongSparseArray<Annotation> longSparseArray = this.annotations;
        longSparseArray.setValueAt(longSparseArray.indexOfKey(polyline.getId()), polyline);
    }

    @Override // com.mapbox.mapboxsdk.maps.Polylines
    public List<Polyline> obtainAll() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.annotations.size(); i++) {
            LongSparseArray<Annotation> longSparseArray = this.annotations;
            Annotation annotation = longSparseArray.get(longSparseArray.keyAt(i));
            if (annotation instanceof Polyline) {
                arrayList.add((Polyline) annotation);
            }
        }
        return arrayList;
    }
}