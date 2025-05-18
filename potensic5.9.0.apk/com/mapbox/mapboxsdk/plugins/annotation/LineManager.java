package com.mapbox.mapboxsdk.plugins.annotation;

import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.mapbox.geojson.Feature;
import com.mapbox.geojson.FeatureCollection;
import com.mapbox.mapboxsdk.maps.MapView;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import com.mapbox.mapboxsdk.maps.Style;
import com.mapbox.mapboxsdk.style.expressions.Expression;
import com.mapbox.mapboxsdk.style.layers.LineLayer;
import com.mapbox.mapboxsdk.style.layers.PropertyFactory;
import com.mapbox.mapboxsdk.style.layers.PropertyValue;
import com.mapbox.mapboxsdk.style.sources.GeoJsonOptions;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class LineManager extends AnnotationManager<LineLayer, Line, LineOptions, OnLineDragListener, OnLineClickListener, OnLineLongClickListener> {
    private static final String PROPERTY_LINE_CAP = "line-cap";
    private static final String PROPERTY_LINE_DASHARRAY = "line-dasharray";
    private static final String PROPERTY_LINE_MITER_LIMIT = "line-miter-limit";
    private static final String PROPERTY_LINE_ROUND_LIMIT = "line-round-limit";
    private static final String PROPERTY_LINE_TRANSLATE = "line-translate";
    private static final String PROPERTY_LINE_TRANSLATE_ANCHOR = "line-translate-anchor";

    @Override // com.mapbox.mapboxsdk.plugins.annotation.AnnotationManager
    String getAnnotationIdKey() {
        return TtmlNode.ATTR_ID;
    }

    public LineManager(MapView mapView, MapboxMap mapboxMap, Style style) {
        this(mapView, mapboxMap, style, null, null);
    }

    public LineManager(MapView mapView, MapboxMap mapboxMap, Style style, String str) {
        this(mapView, mapboxMap, style, str, null);
    }

    public LineManager(MapView mapView, MapboxMap mapboxMap, Style style, String str, GeoJsonOptions geoJsonOptions) {
        this(mapView, mapboxMap, style, new LineElementProvider(), str, geoJsonOptions, DraggableAnnotationController.getInstance(mapView, mapboxMap));
    }

    LineManager(MapView mapView, MapboxMap mapboxMap, Style style, CoreElementProvider<LineLayer> coreElementProvider, String str, GeoJsonOptions geoJsonOptions, DraggableAnnotationController draggableAnnotationController) {
        super(mapView, mapboxMap, style, coreElementProvider, draggableAnnotationController, str, geoJsonOptions);
    }

    @Override // com.mapbox.mapboxsdk.plugins.annotation.AnnotationManager
    void initializeDataDrivenPropertyMap() {
        this.dataDrivenPropertyUsageMap.put("line-join", false);
        this.dataDrivenPropertyUsageMap.put("line-opacity", false);
        this.dataDrivenPropertyUsageMap.put("line-color", false);
        this.dataDrivenPropertyUsageMap.put("line-width", false);
        this.dataDrivenPropertyUsageMap.put("line-gap-width", false);
        this.dataDrivenPropertyUsageMap.put("line-offset", false);
        this.dataDrivenPropertyUsageMap.put("line-blur", false);
        this.dataDrivenPropertyUsageMap.put("line-pattern", false);
    }

    @Override // com.mapbox.mapboxsdk.plugins.annotation.AnnotationManager
    protected void setDataDrivenPropertyIsUsed(String str) {
        str.hashCode();
        switch (str) {
            case "line-blur":
                ((LineLayer) this.layer).setProperties(PropertyFactory.lineBlur(Expression.get("line-blur")));
                break;
            case "line-join":
                ((LineLayer) this.layer).setProperties(PropertyFactory.lineJoin(Expression.get("line-join")));
                break;
            case "line-gap-width":
                ((LineLayer) this.layer).setProperties(PropertyFactory.lineGapWidth(Expression.get("line-gap-width")));
                break;
            case "line-color":
                ((LineLayer) this.layer).setProperties(PropertyFactory.lineColor(Expression.get("line-color")));
                break;
            case "line-width":
                ((LineLayer) this.layer).setProperties(PropertyFactory.lineWidth(Expression.get("line-width")));
                break;
            case "line-opacity":
                ((LineLayer) this.layer).setProperties(PropertyFactory.lineOpacity(Expression.get("line-opacity")));
                break;
            case "line-offset":
                ((LineLayer) this.layer).setProperties(PropertyFactory.lineOffset(Expression.get("line-offset")));
                break;
            case "line-pattern":
                ((LineLayer) this.layer).setProperties(PropertyFactory.linePattern(Expression.get("line-pattern")));
                break;
        }
    }

    public List<Line> create(String str) {
        return create(FeatureCollection.fromJson(str));
    }

    public List<Line> create(FeatureCollection featureCollection) {
        List<Feature> features = featureCollection.features();
        ArrayList arrayList = new ArrayList();
        if (features != null) {
            Iterator<Feature> it = features.iterator();
            while (it.hasNext()) {
                LineOptions fromFeature = LineOptions.fromFeature(it.next());
                if (fromFeature != null) {
                    arrayList.add(fromFeature);
                }
            }
        }
        return create(arrayList);
    }

    public String getLineCap() {
        return ((LineLayer) this.layer).getLineCap().value;
    }

    public void setLineCap(String str) {
        PropertyValue<String> lineCap = PropertyFactory.lineCap(str);
        this.constantPropertyUsageMap.put(PROPERTY_LINE_CAP, lineCap);
        ((LineLayer) this.layer).setProperties(lineCap);
    }

    public Float getLineMiterLimit() {
        return ((LineLayer) this.layer).getLineMiterLimit().value;
    }

    public void setLineMiterLimit(Float f) {
        PropertyValue<Float> lineMiterLimit = PropertyFactory.lineMiterLimit(f);
        this.constantPropertyUsageMap.put(PROPERTY_LINE_MITER_LIMIT, lineMiterLimit);
        ((LineLayer) this.layer).setProperties(lineMiterLimit);
    }

    public Float getLineRoundLimit() {
        return ((LineLayer) this.layer).getLineRoundLimit().value;
    }

    public void setLineRoundLimit(Float f) {
        PropertyValue<Float> lineRoundLimit = PropertyFactory.lineRoundLimit(f);
        this.constantPropertyUsageMap.put(PROPERTY_LINE_ROUND_LIMIT, lineRoundLimit);
        ((LineLayer) this.layer).setProperties(lineRoundLimit);
    }

    public Float[] getLineTranslate() {
        return ((LineLayer) this.layer).getLineTranslate().value;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setLineTranslate(Float[] fArr) {
        PropertyValue<Float[]> lineTranslate = PropertyFactory.lineTranslate(fArr);
        this.constantPropertyUsageMap.put(PROPERTY_LINE_TRANSLATE, lineTranslate);
        ((LineLayer) this.layer).setProperties(lineTranslate);
    }

    public String getLineTranslateAnchor() {
        return ((LineLayer) this.layer).getLineTranslateAnchor().value;
    }

    public void setLineTranslateAnchor(String str) {
        PropertyValue<String> lineTranslateAnchor = PropertyFactory.lineTranslateAnchor(str);
        this.constantPropertyUsageMap.put(PROPERTY_LINE_TRANSLATE_ANCHOR, lineTranslateAnchor);
        ((LineLayer) this.layer).setProperties(lineTranslateAnchor);
    }

    public Float[] getLineDasharray() {
        return ((LineLayer) this.layer).getLineDasharray().value;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setLineDasharray(Float[] fArr) {
        PropertyValue<Float[]> lineDasharray = PropertyFactory.lineDasharray(fArr);
        this.constantPropertyUsageMap.put(PROPERTY_LINE_DASHARRAY, lineDasharray);
        ((LineLayer) this.layer).setProperties(lineDasharray);
    }

    @Override // com.mapbox.mapboxsdk.plugins.annotation.AnnotationManager
    public void setFilter(Expression expression) {
        this.layerFilter = expression;
        ((LineLayer) this.layer).setFilter(this.layerFilter);
    }

    public Expression getFilter() {
        return ((LineLayer) this.layer).getFilter();
    }
}