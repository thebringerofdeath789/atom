package com.mapbox.mapboxsdk.plugins.annotation;

import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.mapbox.geojson.Feature;
import com.mapbox.geojson.FeatureCollection;
import com.mapbox.mapboxsdk.maps.MapView;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import com.mapbox.mapboxsdk.maps.Style;
import com.mapbox.mapboxsdk.style.expressions.Expression;
import com.mapbox.mapboxsdk.style.layers.FillLayer;
import com.mapbox.mapboxsdk.style.layers.PropertyFactory;
import com.mapbox.mapboxsdk.style.layers.PropertyValue;
import com.mapbox.mapboxsdk.style.sources.GeoJsonOptions;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class FillManager extends AnnotationManager<FillLayer, Fill, FillOptions, OnFillDragListener, OnFillClickListener, OnFillLongClickListener> {
    private static final String PROPERTY_FILL_ANTIALIAS = "fill-antialias";
    private static final String PROPERTY_FILL_TRANSLATE = "fill-translate";
    private static final String PROPERTY_FILL_TRANSLATE_ANCHOR = "fill-translate-anchor";

    @Override // com.mapbox.mapboxsdk.plugins.annotation.AnnotationManager
    String getAnnotationIdKey() {
        return TtmlNode.ATTR_ID;
    }

    public FillManager(MapView mapView, MapboxMap mapboxMap, Style style) {
        this(mapView, mapboxMap, style, null, null);
    }

    public FillManager(MapView mapView, MapboxMap mapboxMap, Style style, String str) {
        this(mapView, mapboxMap, style, str, null);
    }

    public FillManager(MapView mapView, MapboxMap mapboxMap, Style style, String str, GeoJsonOptions geoJsonOptions) {
        this(mapView, mapboxMap, style, new FillElementProvider(), str, geoJsonOptions, DraggableAnnotationController.getInstance(mapView, mapboxMap));
    }

    FillManager(MapView mapView, MapboxMap mapboxMap, Style style, CoreElementProvider<FillLayer> coreElementProvider, String str, GeoJsonOptions geoJsonOptions, DraggableAnnotationController draggableAnnotationController) {
        super(mapView, mapboxMap, style, coreElementProvider, draggableAnnotationController, str, geoJsonOptions);
    }

    @Override // com.mapbox.mapboxsdk.plugins.annotation.AnnotationManager
    void initializeDataDrivenPropertyMap() {
        this.dataDrivenPropertyUsageMap.put("fill-opacity", false);
        this.dataDrivenPropertyUsageMap.put("fill-color", false);
        this.dataDrivenPropertyUsageMap.put("fill-outline-color", false);
        this.dataDrivenPropertyUsageMap.put("fill-pattern", false);
    }

    @Override // com.mapbox.mapboxsdk.plugins.annotation.AnnotationManager
    protected void setDataDrivenPropertyIsUsed(String str) {
        str.hashCode();
        switch (str) {
            case "fill-color":
                ((FillLayer) this.layer).setProperties(PropertyFactory.fillColor(Expression.get("fill-color")));
                break;
            case "fill-opacity":
                ((FillLayer) this.layer).setProperties(PropertyFactory.fillOpacity(Expression.get("fill-opacity")));
                break;
            case "fill-pattern":
                ((FillLayer) this.layer).setProperties(PropertyFactory.fillPattern(Expression.get("fill-pattern")));
                break;
            case "fill-outline-color":
                ((FillLayer) this.layer).setProperties(PropertyFactory.fillOutlineColor(Expression.get("fill-outline-color")));
                break;
        }
    }

    public List<Fill> create(String str) {
        return create(FeatureCollection.fromJson(str));
    }

    public List<Fill> create(FeatureCollection featureCollection) {
        List<Feature> features = featureCollection.features();
        ArrayList arrayList = new ArrayList();
        if (features != null) {
            Iterator<Feature> it = features.iterator();
            while (it.hasNext()) {
                FillOptions fromFeature = FillOptions.fromFeature(it.next());
                if (fromFeature != null) {
                    arrayList.add(fromFeature);
                }
            }
        }
        return create(arrayList);
    }

    public Boolean getFillAntialias() {
        return ((FillLayer) this.layer).getFillAntialias().value;
    }

    public void setFillAntialias(Boolean bool) {
        PropertyValue<Boolean> fillAntialias = PropertyFactory.fillAntialias(bool);
        this.constantPropertyUsageMap.put(PROPERTY_FILL_ANTIALIAS, fillAntialias);
        ((FillLayer) this.layer).setProperties(fillAntialias);
    }

    public Float[] getFillTranslate() {
        return ((FillLayer) this.layer).getFillTranslate().value;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setFillTranslate(Float[] fArr) {
        PropertyValue<Float[]> fillTranslate = PropertyFactory.fillTranslate(fArr);
        this.constantPropertyUsageMap.put(PROPERTY_FILL_TRANSLATE, fillTranslate);
        ((FillLayer) this.layer).setProperties(fillTranslate);
    }

    public String getFillTranslateAnchor() {
        return ((FillLayer) this.layer).getFillTranslateAnchor().value;
    }

    public void setFillTranslateAnchor(String str) {
        PropertyValue<String> fillTranslateAnchor = PropertyFactory.fillTranslateAnchor(str);
        this.constantPropertyUsageMap.put(PROPERTY_FILL_TRANSLATE_ANCHOR, fillTranslateAnchor);
        ((FillLayer) this.layer).setProperties(fillTranslateAnchor);
    }

    @Override // com.mapbox.mapboxsdk.plugins.annotation.AnnotationManager
    public void setFilter(Expression expression) {
        this.layerFilter = expression;
        ((FillLayer) this.layer).setFilter(this.layerFilter);
    }

    public Expression getFilter() {
        return ((FillLayer) this.layer).getFilter();
    }
}
