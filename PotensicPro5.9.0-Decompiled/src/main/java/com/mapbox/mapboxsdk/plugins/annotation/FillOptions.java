package com.mapbox.mapboxsdk.plugins.annotation;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.mapbox.geojson.Feature;
import com.mapbox.geojson.Point;
import com.mapbox.geojson.Polygon;
import com.mapbox.mapboxsdk.geometry.LatLng;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class FillOptions extends Options<Fill> {
    static final String PROPERTY_FILL_COLOR = "fill-color";
    static final String PROPERTY_FILL_OPACITY = "fill-opacity";
    static final String PROPERTY_FILL_OUTLINE_COLOR = "fill-outline-color";
    static final String PROPERTY_FILL_PATTERN = "fill-pattern";
    private static final String PROPERTY_IS_DRAGGABLE = "is-draggable";
    private JsonElement data;
    private String fillColor;
    private Float fillOpacity;
    private String fillOutlineColor;
    private String fillPattern;
    private Polygon geometry;
    private boolean isDraggable;

    public FillOptions withFillOpacity(Float f) {
        this.fillOpacity = f;
        return this;
    }

    public Float getFillOpacity() {
        return this.fillOpacity;
    }

    public FillOptions withFillColor(String str) {
        this.fillColor = str;
        return this;
    }

    public String getFillColor() {
        return this.fillColor;
    }

    public FillOptions withFillOutlineColor(String str) {
        this.fillOutlineColor = str;
        return this;
    }

    public String getFillOutlineColor() {
        return this.fillOutlineColor;
    }

    public FillOptions withFillPattern(String str) {
        this.fillPattern = str;
        return this;
    }

    public String getFillPattern() {
        return this.fillPattern;
    }

    public FillOptions withLatLngs(List<List<LatLng>> list) {
        ArrayList arrayList = new ArrayList();
        for (List<LatLng> list2 : list) {
            ArrayList arrayList2 = new ArrayList();
            for (LatLng latLng : list2) {
                arrayList2.add(Point.fromLngLat(latLng.getLongitude(), latLng.getLatitude()));
            }
            arrayList.add(arrayList2);
        }
        this.geometry = Polygon.fromLngLats(arrayList);
        return this;
    }

    public List<List<LatLng>> getLatLngs() {
        ArrayList arrayList = new ArrayList();
        Polygon polygon = this.geometry;
        if (polygon != null) {
            for (List<Point> list : polygon.coordinates()) {
                ArrayList arrayList2 = new ArrayList();
                for (Point point : list) {
                    arrayList2.add(new LatLng(point.latitude(), point.longitude()));
                }
                arrayList.add(arrayList2);
            }
        }
        return arrayList;
    }

    public FillOptions withGeometry(Polygon polygon) {
        this.geometry = polygon;
        return this;
    }

    public Polygon getGeometry() {
        return this.geometry;
    }

    public boolean getDraggable() {
        return this.isDraggable;
    }

    public FillOptions withDraggable(boolean z) {
        this.isDraggable = z;
        return this;
    }

    public FillOptions withData(JsonElement jsonElement) {
        this.data = jsonElement;
        return this;
    }

    public JsonElement getData() {
        return this.data;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.mapbox.mapboxsdk.plugins.annotation.Options
    public Fill build(long j, AnnotationManager<?, Fill, ?, ?, ?, ?> annotationManager) {
        if (this.geometry == null) {
            throw new RuntimeException("geometry field is required");
        }
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty(PROPERTY_FILL_OPACITY, this.fillOpacity);
        jsonObject.addProperty(PROPERTY_FILL_COLOR, this.fillColor);
        jsonObject.addProperty(PROPERTY_FILL_OUTLINE_COLOR, this.fillOutlineColor);
        jsonObject.addProperty(PROPERTY_FILL_PATTERN, this.fillPattern);
        Fill fill = new Fill(j, annotationManager, jsonObject, this.geometry);
        fill.setDraggable(this.isDraggable);
        fill.setData(this.data);
        return fill;
    }

    static FillOptions fromFeature(Feature feature) {
        if (feature.geometry() == null) {
            throw new RuntimeException("geometry field is required");
        }
        if (!(feature.geometry() instanceof Polygon)) {
            return null;
        }
        FillOptions fillOptions = new FillOptions();
        fillOptions.geometry = (Polygon) feature.geometry();
        if (feature.hasProperty(PROPERTY_FILL_OPACITY)) {
            fillOptions.fillOpacity = Float.valueOf(feature.getProperty(PROPERTY_FILL_OPACITY).getAsFloat());
        }
        if (feature.hasProperty(PROPERTY_FILL_COLOR)) {
            fillOptions.fillColor = feature.getProperty(PROPERTY_FILL_COLOR).getAsString();
        }
        if (feature.hasProperty(PROPERTY_FILL_OUTLINE_COLOR)) {
            fillOptions.fillOutlineColor = feature.getProperty(PROPERTY_FILL_OUTLINE_COLOR).getAsString();
        }
        if (feature.hasProperty(PROPERTY_FILL_PATTERN)) {
            fillOptions.fillPattern = feature.getProperty(PROPERTY_FILL_PATTERN).getAsString();
        }
        if (feature.hasProperty(PROPERTY_IS_DRAGGABLE)) {
            fillOptions.isDraggable = feature.getProperty(PROPERTY_IS_DRAGGABLE).getAsBoolean();
        }
        return fillOptions;
    }
}
