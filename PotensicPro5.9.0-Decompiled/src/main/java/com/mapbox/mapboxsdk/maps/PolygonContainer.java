package com.mapbox.mapboxsdk.maps;

import androidx.collection.LongSparseArray;
import com.mapbox.mapboxsdk.annotations.Annotation;
import com.mapbox.mapboxsdk.annotations.Polygon;
import com.mapbox.mapboxsdk.annotations.PolygonOptions;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
class PolygonContainer implements Polygons {
    private final LongSparseArray<Annotation> annotations;
    private final NativeMap nativeMap;

    PolygonContainer(NativeMap nativeMap, LongSparseArray<Annotation> longSparseArray) {
        this.nativeMap = nativeMap;
        this.annotations = longSparseArray;
    }

    @Override // com.mapbox.mapboxsdk.maps.Polygons
    public Polygon addBy(PolygonOptions polygonOptions, MapboxMap mapboxMap) {
        Polygon polygon = polygonOptions.getPolygon();
        if (!polygon.getPoints().isEmpty()) {
            NativeMap nativeMap = this.nativeMap;
            long addPolygon = nativeMap != null ? nativeMap.addPolygon(polygon) : 0L;
            polygon.setId(addPolygon);
            polygon.setMapboxMap(mapboxMap);
            this.annotations.put(addPolygon, polygon);
        }
        return polygon;
    }

    @Override // com.mapbox.mapboxsdk.maps.Polygons
    public List<Polygon> addBy(List<PolygonOptions> list, MapboxMap mapboxMap) {
        int size = list.size();
        ArrayList arrayList = new ArrayList(size);
        if (this.nativeMap != null && size > 0) {
            Iterator<PolygonOptions> it = list.iterator();
            while (it.hasNext()) {
                Polygon polygon = it.next().getPolygon();
                if (!polygon.getPoints().isEmpty()) {
                    arrayList.add(polygon);
                }
            }
            long[] addPolygons = this.nativeMap.addPolygons(arrayList);
            for (int i = 0; i < addPolygons.length; i++) {
                Polygon polygon2 = (Polygon) arrayList.get(i);
                polygon2.setMapboxMap(mapboxMap);
                polygon2.setId(addPolygons[i]);
                this.annotations.put(addPolygons[i], polygon2);
            }
        }
        return arrayList;
    }

    @Override // com.mapbox.mapboxsdk.maps.Polygons
    public void update(Polygon polygon) {
        this.nativeMap.updatePolygon(polygon);
        LongSparseArray<Annotation> longSparseArray = this.annotations;
        longSparseArray.setValueAt(longSparseArray.indexOfKey(polygon.getId()), polygon);
    }

    @Override // com.mapbox.mapboxsdk.maps.Polygons
    public List<Polygon> obtainAll() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.annotations.size(); i++) {
            LongSparseArray<Annotation> longSparseArray = this.annotations;
            Annotation annotation = longSparseArray.get(longSparseArray.keyAt(i));
            if (annotation instanceof Polygon) {
                arrayList.add((Polygon) annotation);
            }
        }
        return arrayList;
    }
}
