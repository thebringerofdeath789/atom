package com.mapbox.mapboxsdk.location;

import android.graphics.Bitmap;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.mapbox.geojson.Feature;
import com.mapbox.geojson.Point;
import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.mapboxsdk.log.Logger;
import com.mapbox.mapboxsdk.maps.Style;
import com.mapbox.mapboxsdk.style.expressions.Expression;
import com.mapbox.mapboxsdk.style.layers.Layer;
import com.mapbox.mapboxsdk.style.layers.Property;
import com.mapbox.mapboxsdk.style.layers.PropertyFactory;
import com.mapbox.mapboxsdk.style.layers.PropertyValue;
import com.mapbox.mapboxsdk.style.layers.SymbolLayer;
import com.mapbox.mapboxsdk.style.sources.GeoJsonSource;
import com.mapbox.mapboxsdk.utils.ColorUtils;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes3.dex */
final class SymbolLocationLayerRenderer implements LocationLayerRenderer {
    private static final String TAG = "mbgl-locationSymbol";
    private final Set<String> layerSet;
    private final LayerSourceProvider layerSourceProvider;
    private Feature locationFeature;
    private GeoJsonSource locationSource;
    private Style style;

    SymbolLocationLayerRenderer(LayerSourceProvider layerSourceProvider, LayerFeatureProvider layerFeatureProvider, boolean z) {
        this.layerSourceProvider = layerSourceProvider;
        this.layerSet = layerSourceProvider.getEmptyLayerSet();
        this.locationFeature = layerFeatureProvider.generateLocationFeature(this.locationFeature, z);
    }

    @Override // com.mapbox.mapboxsdk.location.LocationLayerRenderer
    public void initializeComponents(Style style) {
        this.style = style;
        addLocationSource();
    }

    @Override // com.mapbox.mapboxsdk.location.LocationLayerRenderer
    public void addLayers(LocationComponentPositionManager locationComponentPositionManager) {
        Layer generateLayer = this.layerSourceProvider.generateLayer(LocationComponentConstants.BEARING_LAYER);
        locationComponentPositionManager.addLayerToMap(generateLayer);
        this.layerSet.add(generateLayer.getId());
        addSymbolLayer(LocationComponentConstants.FOREGROUND_LAYER, LocationComponentConstants.BEARING_LAYER);
        addSymbolLayer(LocationComponentConstants.BACKGROUND_LAYER, LocationComponentConstants.FOREGROUND_LAYER);
        addSymbolLayer(LocationComponentConstants.SHADOW_LAYER, LocationComponentConstants.BACKGROUND_LAYER);
        addAccuracyLayer();
        addPulsingCircleLayerToMap();
    }

    @Override // com.mapbox.mapboxsdk.location.LocationLayerRenderer
    public void removeLayers() {
        Iterator<String> it = this.layerSet.iterator();
        while (it.hasNext()) {
            this.style.removeLayer(it.next());
        }
        this.layerSet.clear();
    }

    @Override // com.mapbox.mapboxsdk.location.LocationLayerRenderer
    public void hide() {
        Iterator<String> it = this.layerSet.iterator();
        while (it.hasNext()) {
            setLayerVisibility(it.next(), false);
        }
    }

    @Override // com.mapbox.mapboxsdk.location.LocationLayerRenderer
    public void cameraTiltUpdated(double d) {
        updateForegroundOffset(d);
    }

    @Override // com.mapbox.mapboxsdk.location.LocationLayerRenderer
    public void cameraBearingUpdated(double d) {
        updateForegroundBearing((float) d);
    }

    @Override // com.mapbox.mapboxsdk.location.LocationLayerRenderer
    public void show(int i, boolean z) {
        if (i == 4) {
            setLayerVisibility(LocationComponentConstants.SHADOW_LAYER, true);
            setLayerVisibility(LocationComponentConstants.FOREGROUND_LAYER, true);
            setLayerVisibility(LocationComponentConstants.BACKGROUND_LAYER, true);
            setLayerVisibility(LocationComponentConstants.ACCURACY_LAYER, !z);
            setLayerVisibility(LocationComponentConstants.BEARING_LAYER, true);
            return;
        }
        if (i == 8) {
            setLayerVisibility(LocationComponentConstants.SHADOW_LAYER, false);
            setLayerVisibility(LocationComponentConstants.FOREGROUND_LAYER, true);
            setLayerVisibility(LocationComponentConstants.BACKGROUND_LAYER, true);
            setLayerVisibility(LocationComponentConstants.ACCURACY_LAYER, false);
            setLayerVisibility(LocationComponentConstants.BEARING_LAYER, false);
            return;
        }
        if (i != 18) {
            return;
        }
        setLayerVisibility(LocationComponentConstants.SHADOW_LAYER, true);
        setLayerVisibility(LocationComponentConstants.FOREGROUND_LAYER, true);
        setLayerVisibility(LocationComponentConstants.BACKGROUND_LAYER, true);
        setLayerVisibility(LocationComponentConstants.ACCURACY_LAYER, !z);
        setLayerVisibility(LocationComponentConstants.BEARING_LAYER, false);
    }

    @Override // com.mapbox.mapboxsdk.location.LocationLayerRenderer
    public void styleAccuracy(float f, int i) {
        this.locationFeature.addNumberProperty("mapbox-property-accuracy-alpha", Float.valueOf(f));
        this.locationFeature.addStringProperty("mapbox-property-accuracy-color", ColorUtils.colorToRgbaString(i));
        refreshSource();
    }

    @Override // com.mapbox.mapboxsdk.location.LocationLayerRenderer
    public void setLatLng(LatLng latLng) {
        setLocationPoint(Point.fromLngLat(latLng.getLongitude(), latLng.getLatitude()));
    }

    @Override // com.mapbox.mapboxsdk.location.LocationLayerRenderer
    public void setGpsBearing(Float f) {
        setBearingProperty("mapbox-property-gps-bearing", f.floatValue());
    }

    @Override // com.mapbox.mapboxsdk.location.LocationLayerRenderer
    public void setCompassBearing(Float f) {
        setBearingProperty("mapbox-property-compass-bearing", f.floatValue());
    }

    @Override // com.mapbox.mapboxsdk.location.LocationLayerRenderer
    public void setAccuracyRadius(Float f) {
        updateAccuracyRadius(f.floatValue());
    }

    @Override // com.mapbox.mapboxsdk.location.LocationLayerRenderer
    public void styleScaling(Expression expression) {
        if (!this.style.isFullyLoaded()) {
            Logger.m1762w(TAG, "Style is not fully loaded, not able to get layer!");
            return;
        }
        Iterator<String> it = this.layerSet.iterator();
        while (it.hasNext()) {
            Layer layer = this.style.getLayer(it.next());
            if (layer instanceof SymbolLayer) {
                layer.setProperties(PropertyFactory.iconSize(expression));
            }
        }
    }

    @Override // com.mapbox.mapboxsdk.location.LocationLayerRenderer
    public void setLocationStale(boolean z, int i) {
        this.locationFeature.addBooleanProperty("mapbox-property-location-stale", Boolean.valueOf(z));
        refreshSource();
        if (i != 8) {
            setLayerVisibility(LocationComponentConstants.ACCURACY_LAYER, !z);
        }
    }

    @Override // com.mapbox.mapboxsdk.location.LocationLayerRenderer
    public void updateIconIds(String str, String str2, String str3, String str4, String str5) {
        this.locationFeature.addStringProperty("mapbox-property-foreground-icon", str);
        this.locationFeature.addStringProperty("mapbox-property-background-icon", str3);
        this.locationFeature.addStringProperty("mapbox-property-foreground-stale-icon", str2);
        this.locationFeature.addStringProperty("mapbox-property-background-stale-icon", str4);
        this.locationFeature.addStringProperty("mapbox-property-shadow-icon", str5);
        refreshSource();
    }

    @Override // com.mapbox.mapboxsdk.location.LocationLayerRenderer
    public void addBitmaps(int i, Bitmap bitmap, Bitmap bitmap2, Bitmap bitmap3, Bitmap bitmap4, Bitmap bitmap5, Bitmap bitmap6) {
        if (bitmap != null) {
            this.style.addImage("mapbox-location-shadow-icon", bitmap);
        } else {
            this.style.removeImage("mapbox-location-shadow-icon");
        }
        this.style.addImage("mapbox-location-stroke-icon", bitmap2);
        this.style.addImage("mapbox-location-background-stale-icon", bitmap3);
        this.style.addImage("mapbox-location-bearing-icon", bitmap4);
        this.style.addImage("mapbox-location-icon", bitmap5);
        this.style.addImage("mapbox-location-stale-icon", bitmap6);
    }

    private void updateForegroundOffset(double d) {
        JsonArray jsonArray = new JsonArray();
        Float valueOf = Float.valueOf(0.0f);
        jsonArray.add(valueOf);
        jsonArray.add(Float.valueOf((float) ((-0.05d) * d)));
        this.locationFeature.addProperty("mapbox-property-foreground-icon-offset", jsonArray);
        JsonArray jsonArray2 = new JsonArray();
        jsonArray2.add(valueOf);
        jsonArray2.add(Float.valueOf((float) (d * 0.05d)));
        this.locationFeature.addProperty("mapbox-property-shadow-icon-offset", jsonArray2);
        refreshSource();
    }

    private void updateForegroundBearing(float f) {
        setBearingProperty("mapbox-property-gps-bearing", f);
    }

    private void setLayerVisibility(String str, boolean z) {
        if (!this.style.isFullyLoaded()) {
            Logger.m1762w(TAG, "Style is not fully loaded, not able to get layer!");
            return;
        }
        Layer layer = this.style.getLayer(str);
        if (layer != null) {
            String str2 = Property.VISIBLE;
            if (layer.getVisibility().value.equals(z ? Property.VISIBLE : "none")) {
                return;
            }
            PropertyValue<?>[] propertyValueArr = new PropertyValue[1];
            if (!z) {
                str2 = "none";
            }
            propertyValueArr[0] = PropertyFactory.visibility(str2);
            layer.setProperties(propertyValueArr);
        }
    }

    @Override // com.mapbox.mapboxsdk.location.LocationLayerRenderer
    public void adjustPulsingCircleLayerVisibility(boolean z) {
        setLayerVisibility(LocationComponentConstants.PULSING_CIRCLE_LAYER, z);
    }

    @Override // com.mapbox.mapboxsdk.location.LocationLayerRenderer
    public void stylePulsingCircle(LocationComponentOptions locationComponentOptions) {
        if (!this.style.isFullyLoaded()) {
            Logger.m1762w(TAG, "Style is not fully loaded, not able to get layer!");
        } else if (this.style.getLayer(LocationComponentConstants.PULSING_CIRCLE_LAYER) != null) {
            setLayerVisibility(LocationComponentConstants.PULSING_CIRCLE_LAYER, true);
            this.style.getLayer(LocationComponentConstants.PULSING_CIRCLE_LAYER).setProperties(PropertyFactory.circleRadius(Expression.get("mapbox-property-pulsing-circle-radius")), PropertyFactory.circleColor(locationComponentOptions.pulseColor().intValue()), PropertyFactory.circleStrokeColor(locationComponentOptions.pulseColor().intValue()), PropertyFactory.circleOpacity(Expression.get("mapbox-property-pulsing-circle-opacity")));
        }
    }

    @Override // com.mapbox.mapboxsdk.location.LocationLayerRenderer
    public void updatePulsingUi(float f, Float f2) {
        this.locationFeature.addNumberProperty("mapbox-property-pulsing-circle-radius", Float.valueOf(f));
        if (f2 != null) {
            this.locationFeature.addNumberProperty("mapbox-property-pulsing-circle-opacity", f2);
        }
        refreshSource();
    }

    private void addSymbolLayer(String str, String str2) {
        addLayerToMap(this.layerSourceProvider.generateLayer(str), str2);
    }

    private void addAccuracyLayer() {
        addLayerToMap(this.layerSourceProvider.generateAccuracyLayer(), LocationComponentConstants.BACKGROUND_LAYER);
    }

    private void addPulsingCircleLayerToMap() {
        addLayerToMap(this.layerSourceProvider.generatePulsingCircleLayer(), LocationComponentConstants.ACCURACY_LAYER);
    }

    private void addLayerToMap(Layer layer, String str) {
        this.style.addLayerBelow(layer, str);
        this.layerSet.add(layer.getId());
    }

    private void addLocationSource() {
        GeoJsonSource generateSource = this.layerSourceProvider.generateSource(this.locationFeature);
        this.locationSource = generateSource;
        this.style.addSource(generateSource);
    }

    private void refreshSource() {
        if (!this.style.isFullyLoaded()) {
            Logger.m1762w(TAG, "Style is not fully loaded, not able to get source!");
        } else if (((GeoJsonSource) this.style.getSourceAs(LocationComponentConstants.LOCATION_SOURCE)) != null) {
            this.locationSource.setGeoJson(this.locationFeature);
        }
    }

    private void setLocationPoint(Point point) {
        JsonObject properties = this.locationFeature.properties();
        if (properties != null) {
            this.locationFeature = Feature.fromGeometry(point, properties);
            refreshSource();
        }
    }

    private void setBearingProperty(String str, float f) {
        this.locationFeature.addNumberProperty(str, Float.valueOf(f));
        refreshSource();
    }

    private void updateAccuracyRadius(float f) {
        this.locationFeature.addNumberProperty("mapbox-property-accuracy-radius", Float.valueOf(f));
        refreshSource();
    }
}