package com.mapbox.mapboxsdk.plugins.annotation;

import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.mapbox.geojson.Feature;
import com.mapbox.geojson.FeatureCollection;
import com.mapbox.mapboxsdk.maps.MapView;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import com.mapbox.mapboxsdk.maps.Style;
import com.mapbox.mapboxsdk.style.expressions.Expression;
import com.mapbox.mapboxsdk.style.layers.CircleLayer;
import com.mapbox.mapboxsdk.style.layers.PropertyFactory;
import com.mapbox.mapboxsdk.style.layers.PropertyValue;
import com.mapbox.mapboxsdk.style.sources.GeoJsonOptions;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class CircleManager extends AnnotationManager<CircleLayer, Circle, CircleOptions, OnCircleDragListener, OnCircleClickListener, OnCircleLongClickListener> {
    private static final String PROPERTY_CIRCLE_PITCH_ALIGNMENT = "circle-pitch-alignment";
    private static final String PROPERTY_CIRCLE_PITCH_SCALE = "circle-pitch-scale";
    private static final String PROPERTY_CIRCLE_TRANSLATE = "circle-translate";
    private static final String PROPERTY_CIRCLE_TRANSLATE_ANCHOR = "circle-translate-anchor";

    @Override // com.mapbox.mapboxsdk.plugins.annotation.AnnotationManager
    String getAnnotationIdKey() {
        return TtmlNode.ATTR_ID;
    }

    public CircleManager(MapView mapView, MapboxMap mapboxMap, Style style) {
        this(mapView, mapboxMap, style, null, null);
    }

    public CircleManager(MapView mapView, MapboxMap mapboxMap, Style style, String str) {
        this(mapView, mapboxMap, style, str, null);
    }

    public CircleManager(MapView mapView, MapboxMap mapboxMap, Style style, String str, GeoJsonOptions geoJsonOptions) {
        this(mapView, mapboxMap, style, new CircleElementProvider(), str, geoJsonOptions, DraggableAnnotationController.getInstance(mapView, mapboxMap));
    }

    CircleManager(MapView mapView, MapboxMap mapboxMap, Style style, CoreElementProvider<CircleLayer> coreElementProvider, String str, GeoJsonOptions geoJsonOptions, DraggableAnnotationController draggableAnnotationController) {
        super(mapView, mapboxMap, style, coreElementProvider, draggableAnnotationController, str, geoJsonOptions);
    }

    @Override // com.mapbox.mapboxsdk.plugins.annotation.AnnotationManager
    void initializeDataDrivenPropertyMap() {
        this.dataDrivenPropertyUsageMap.put("circle-radius", false);
        this.dataDrivenPropertyUsageMap.put("circle-color", false);
        this.dataDrivenPropertyUsageMap.put("circle-blur", false);
        this.dataDrivenPropertyUsageMap.put("circle-opacity", false);
        this.dataDrivenPropertyUsageMap.put("circle-stroke-width", false);
        this.dataDrivenPropertyUsageMap.put("circle-stroke-color", false);
        this.dataDrivenPropertyUsageMap.put("circle-stroke-opacity", false);
    }

    @Override // com.mapbox.mapboxsdk.plugins.annotation.AnnotationManager
    protected void setDataDrivenPropertyIsUsed(String str) {
        str.hashCode();
        switch (str) {
            case "circle-opacity":
                ((CircleLayer) this.layer).setProperties(PropertyFactory.circleOpacity(Expression.get("circle-opacity")));
                break;
            case "circle-radius":
                ((CircleLayer) this.layer).setProperties(PropertyFactory.circleRadius(Expression.get("circle-radius")));
                break;
            case "circle-stroke-color":
                ((CircleLayer) this.layer).setProperties(PropertyFactory.circleStrokeColor(Expression.get("circle-stroke-color")));
                break;
            case "circle-stroke-width":
                ((CircleLayer) this.layer).setProperties(PropertyFactory.circleStrokeWidth(Expression.get("circle-stroke-width")));
                break;
            case "circle-blur":
                ((CircleLayer) this.layer).setProperties(PropertyFactory.circleBlur(Expression.get("circle-blur")));
                break;
            case "circle-color":
                ((CircleLayer) this.layer).setProperties(PropertyFactory.circleColor(Expression.get("circle-color")));
                break;
            case "circle-stroke-opacity":
                ((CircleLayer) this.layer).setProperties(PropertyFactory.circleStrokeOpacity(Expression.get("circle-stroke-opacity")));
                break;
        }
    }

    public List<Circle> create(String str) {
        return create(FeatureCollection.fromJson(str));
    }

    public List<Circle> create(FeatureCollection featureCollection) {
        List<Feature> features = featureCollection.features();
        ArrayList arrayList = new ArrayList();
        if (features != null) {
            Iterator<Feature> it = features.iterator();
            while (it.hasNext()) {
                CircleOptions fromFeature = CircleOptions.fromFeature(it.next());
                if (fromFeature != null) {
                    arrayList.add(fromFeature);
                }
            }
        }
        return create(arrayList);
    }

    public Float[] getCircleTranslate() {
        return ((CircleLayer) this.layer).getCircleTranslate().value;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setCircleTranslate(Float[] fArr) {
        PropertyValue<Float[]> circleTranslate = PropertyFactory.circleTranslate(fArr);
        this.constantPropertyUsageMap.put(PROPERTY_CIRCLE_TRANSLATE, circleTranslate);
        ((CircleLayer) this.layer).setProperties(circleTranslate);
    }

    public String getCircleTranslateAnchor() {
        return ((CircleLayer) this.layer).getCircleTranslateAnchor().value;
    }

    public void setCircleTranslateAnchor(String str) {
        PropertyValue<String> circleTranslateAnchor = PropertyFactory.circleTranslateAnchor(str);
        this.constantPropertyUsageMap.put(PROPERTY_CIRCLE_TRANSLATE_ANCHOR, circleTranslateAnchor);
        ((CircleLayer) this.layer).setProperties(circleTranslateAnchor);
    }

    public String getCirclePitchScale() {
        return ((CircleLayer) this.layer).getCirclePitchScale().value;
    }

    public void setCirclePitchScale(String str) {
        PropertyValue<String> circlePitchScale = PropertyFactory.circlePitchScale(str);
        this.constantPropertyUsageMap.put(PROPERTY_CIRCLE_PITCH_SCALE, circlePitchScale);
        ((CircleLayer) this.layer).setProperties(circlePitchScale);
    }

    public String getCirclePitchAlignment() {
        return ((CircleLayer) this.layer).getCirclePitchAlignment().value;
    }

    public void setCirclePitchAlignment(String str) {
        PropertyValue<String> circlePitchAlignment = PropertyFactory.circlePitchAlignment(str);
        this.constantPropertyUsageMap.put(PROPERTY_CIRCLE_PITCH_ALIGNMENT, circlePitchAlignment);
        ((CircleLayer) this.layer).setProperties(circlePitchAlignment);
    }

    @Override // com.mapbox.mapboxsdk.plugins.annotation.AnnotationManager
    public void setFilter(Expression expression) {
        this.layerFilter = expression;
        ((CircleLayer) this.layer).setFilter(this.layerFilter);
    }

    public Expression getFilter() {
        return ((CircleLayer) this.layer).getFilter();
    }
}
