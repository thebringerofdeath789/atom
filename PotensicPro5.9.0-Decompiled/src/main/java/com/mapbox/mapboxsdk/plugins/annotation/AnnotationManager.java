package com.mapbox.mapboxsdk.plugins.annotation;

import android.graphics.PointF;
import androidx.collection.LongSparseArray;
import com.mapbox.geojson.Feature;
import com.mapbox.geojson.FeatureCollection;
import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.mapboxsdk.log.Logger;
import com.mapbox.mapboxsdk.maps.MapView;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import com.mapbox.mapboxsdk.maps.Style;
import com.mapbox.mapboxsdk.plugins.annotation.Annotation;
import com.mapbox.mapboxsdk.plugins.annotation.OnAnnotationClickListener;
import com.mapbox.mapboxsdk.plugins.annotation.OnAnnotationDragListener;
import com.mapbox.mapboxsdk.plugins.annotation.OnAnnotationLongClickListener;
import com.mapbox.mapboxsdk.plugins.annotation.Options;
import com.mapbox.mapboxsdk.style.expressions.Expression;
import com.mapbox.mapboxsdk.style.layers.Layer;
import com.mapbox.mapboxsdk.style.layers.PropertyValue;
import com.mapbox.mapboxsdk.style.sources.GeoJsonOptions;
import com.mapbox.mapboxsdk.style.sources.GeoJsonSource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public abstract class AnnotationManager<L extends Layer, T extends Annotation, S extends Options<T>, D extends OnAnnotationDragListener<T>, U extends OnAnnotationClickListener<T>, V extends OnAnnotationLongClickListener<T>> {
    private static final String TAG = "AnnotationManager";
    private String belowLayerId;
    private CoreElementProvider<L> coreElementProvider;
    private long currentId;
    private DraggableAnnotationController draggableAnnotationController;
    private GeoJsonSource geoJsonSource;
    protected L layer;
    Expression layerFilter;
    private final AnnotationManager<L, T, S, D, U, V>.MapClickResolver mapClickResolver;
    protected final MapboxMap mapboxMap;
    private Style style;
    protected final LongSparseArray<T> annotations = new LongSparseArray<>();
    final Map<String, Boolean> dataDrivenPropertyUsageMap = new HashMap();
    final Map<String, PropertyValue> constantPropertyUsageMap = new HashMap();
    private final List<D> dragListeners = new ArrayList();
    private final List<U> clickListeners = new ArrayList();
    private final List<V> longClickListeners = new ArrayList();

    abstract String getAnnotationIdKey();

    abstract void initializeDataDrivenPropertyMap();

    protected abstract void setDataDrivenPropertyIsUsed(String str);

    abstract void setFilter(Expression expression);

    protected AnnotationManager(MapView mapView, final MapboxMap mapboxMap, Style style, CoreElementProvider<L> coreElementProvider, DraggableAnnotationController draggableAnnotationController, String str, final GeoJsonOptions geoJsonOptions) {
        this.mapboxMap = mapboxMap;
        this.style = style;
        this.belowLayerId = str;
        this.coreElementProvider = coreElementProvider;
        this.draggableAnnotationController = draggableAnnotationController;
        if (!style.isFullyLoaded()) {
            throw new RuntimeException("The style has to be non-null and fully loaded.");
        }
        AnnotationManager<L, T, S, D, U, V>.MapClickResolver mapClickResolver = new MapClickResolver();
        this.mapClickResolver = mapClickResolver;
        mapboxMap.addOnMapClickListener(mapClickResolver);
        mapboxMap.addOnMapLongClickListener(mapClickResolver);
        draggableAnnotationController.addAnnotationManager(this);
        initializeSourcesAndLayers(geoJsonOptions);
        mapView.addOnDidFinishLoadingStyleListener(new MapView.OnDidFinishLoadingStyleListener() { // from class: com.mapbox.mapboxsdk.plugins.annotation.AnnotationManager.1
            @Override // com.mapbox.mapboxsdk.maps.MapView.OnDidFinishLoadingStyleListener
            public void onDidFinishLoadingStyle() {
                mapboxMap.getStyle(new Style.OnStyleLoaded() { // from class: com.mapbox.mapboxsdk.plugins.annotation.AnnotationManager.1.1
                    @Override // com.mapbox.mapboxsdk.maps.Style.OnStyleLoaded
                    public void onStyleLoaded(Style style2) {
                        AnnotationManager.this.style = style2;
                        AnnotationManager.this.initializeSourcesAndLayers(geoJsonOptions);
                    }
                });
            }
        });
    }

    public String getLayerId() {
        return this.layer.getId();
    }

    public LongSparseArray<T> getAnnotations() {
        return this.annotations;
    }

    public T create(S s) {
        T t = (T) s.build(this.currentId, this);
        this.annotations.put(t.getId(), t);
        this.currentId++;
        updateSource();
        return t;
    }

    public List<T> create(List<S> list) {
        ArrayList arrayList = new ArrayList();
        Iterator<S> it = list.iterator();
        while (it.hasNext()) {
            Annotation build = it.next().build(this.currentId, this);
            arrayList.add(build);
            this.annotations.put(build.getId(), build);
            this.currentId++;
        }
        updateSource();
        return arrayList;
    }

    public void delete(T t) {
        this.annotations.remove(t.getId());
        updateSource();
    }

    public void delete(List<T> list) {
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            this.annotations.remove(it.next().getId());
        }
        updateSource();
    }

    public void deleteAll() {
        this.annotations.clear();
        updateSource();
    }

    public void update(T t) {
        if (this.annotations.containsValue(t)) {
            this.annotations.put(t.getId(), t);
            updateSource();
        } else {
            Logger.e(TAG, "Can't update annotation: " + t.toString() + ", the annotation isn't active annotation.");
        }
    }

    public void update(List<T> list) {
        for (T t : list) {
            this.annotations.put(t.getId(), t);
        }
        updateSource();
    }

    public void updateSource() {
        this.draggableAnnotationController.onSourceUpdated();
        internalUpdateSource();
    }

    void internalUpdateSource() {
        if (this.style.isFullyLoaded()) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < this.annotations.size(); i++) {
                T valueAt = this.annotations.valueAt(i);
                arrayList.add(Feature.fromGeometry(valueAt.getGeometry(), valueAt.getFeature()));
                valueAt.setUsedDataDrivenProperties();
            }
            this.geoJsonSource.setGeoJson(FeatureCollection.fromFeatures(arrayList));
        }
    }

    void enableDataDrivenProperty(String str) {
        if (this.dataDrivenPropertyUsageMap.get(str).equals(false)) {
            this.dataDrivenPropertyUsageMap.put(str, true);
            setDataDrivenPropertyIsUsed(str);
        }
    }

    public void addDragListener(D d) {
        this.dragListeners.add(d);
    }

    public void removeDragListener(D d) {
        this.dragListeners.remove(d);
    }

    public void addClickListener(U u) {
        this.clickListeners.add(u);
    }

    public void removeClickListener(U u) {
        this.clickListeners.remove(u);
    }

    public void addLongClickListener(V v) {
        this.longClickListeners.add(v);
    }

    public void removeLongClickListener(V v) {
        this.longClickListeners.remove(v);
    }

    List<U> getClickListeners() {
        return this.clickListeners;
    }

    List<V> getLongClickListeners() {
        return this.longClickListeners;
    }

    List<D> getDragListeners() {
        return this.dragListeners;
    }

    public void onDestroy() {
        this.mapboxMap.removeOnMapClickListener(this.mapClickResolver);
        this.mapboxMap.removeOnMapLongClickListener(this.mapClickResolver);
        this.draggableAnnotationController.removeAnnotationManager(this);
        this.dragListeners.clear();
        this.clickListeners.clear();
        this.longClickListeners.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initializeSourcesAndLayers(GeoJsonOptions geoJsonOptions) {
        this.geoJsonSource = this.coreElementProvider.getSource(geoJsonOptions);
        this.layer = this.coreElementProvider.getLayer();
        this.style.addSource(this.geoJsonSource);
        String str = this.belowLayerId;
        if (str == null) {
            this.style.addLayer(this.layer);
        } else {
            this.style.addLayerBelow(this.layer, str);
        }
        initializeDataDrivenPropertyMap();
        this.layer.setProperties((PropertyValue[]) this.constantPropertyUsageMap.values().toArray(new PropertyValue[0]));
        Expression expression = this.layerFilter;
        if (expression != null) {
            setFilter(expression);
        }
        updateSource();
    }

    private class MapClickResolver implements MapboxMap.OnMapClickListener, MapboxMap.OnMapLongClickListener {
        private MapClickResolver() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.mapbox.mapboxsdk.maps.MapboxMap.OnMapClickListener
        public boolean onMapClick(LatLng latLng) {
            Annotation queryMapForFeatures;
            if (!AnnotationManager.this.clickListeners.isEmpty() && (queryMapForFeatures = AnnotationManager.this.queryMapForFeatures(latLng)) != null) {
                Iterator it = AnnotationManager.this.clickListeners.iterator();
                while (it.hasNext()) {
                    if (((OnAnnotationClickListener) it.next()).onAnnotationClick(queryMapForFeatures)) {
                        return true;
                    }
                }
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.mapbox.mapboxsdk.maps.MapboxMap.OnMapLongClickListener
        public boolean onMapLongClick(LatLng latLng) {
            Annotation queryMapForFeatures;
            if (!AnnotationManager.this.longClickListeners.isEmpty() && (queryMapForFeatures = AnnotationManager.this.queryMapForFeatures(latLng)) != null) {
                Iterator it = AnnotationManager.this.longClickListeners.iterator();
                while (it.hasNext()) {
                    if (((OnAnnotationLongClickListener) it.next()).onAnnotationLongClick(queryMapForFeatures)) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public T queryMapForFeatures(LatLng latLng) {
        return queryMapForFeatures(this.mapboxMap.getProjection().toScreenLocation(latLng));
    }

    T queryMapForFeatures(PointF pointF) {
        List<Feature> queryRenderedFeatures = this.mapboxMap.queryRenderedFeatures(pointF, this.coreElementProvider.getLayerId());
        if (queryRenderedFeatures.isEmpty()) {
            return null;
        }
        return this.annotations.get(queryRenderedFeatures.get(0).getProperty(getAnnotationIdKey()).getAsLong());
    }
}
