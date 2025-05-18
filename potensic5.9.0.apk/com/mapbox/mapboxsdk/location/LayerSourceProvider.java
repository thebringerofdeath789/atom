package com.mapbox.mapboxsdk.location;

import com.mapbox.geojson.Feature;
import com.mapbox.mapboxsdk.style.expressions.Expression;
import com.mapbox.mapboxsdk.style.layers.CircleLayer;
import com.mapbox.mapboxsdk.style.layers.Layer;
import com.mapbox.mapboxsdk.style.layers.PropertyFactory;
import com.mapbox.mapboxsdk.style.layers.SymbolLayer;
import com.mapbox.mapboxsdk.style.layers.TransitionOptions;
import com.mapbox.mapboxsdk.style.sources.GeoJsonOptions;
import com.mapbox.mapboxsdk.style.sources.GeoJsonSource;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes3.dex */
class LayerSourceProvider {
    private static final String EMPTY_STRING = "";

    LayerSourceProvider() {
    }

    GeoJsonSource generateSource(Feature feature) {
        return new GeoJsonSource(LocationComponentConstants.LOCATION_SOURCE, feature, new GeoJsonOptions().withMaxZoom(16));
    }

    Layer generateLayer(String str) {
        SymbolLayer symbolLayer = new SymbolLayer(str, LocationComponentConstants.LOCATION_SOURCE);
        Expression literal = Expression.literal(str);
        Float valueOf = Float.valueOf(0.0f);
        symbolLayer.setProperties(PropertyFactory.iconAllowOverlap((Boolean) true), PropertyFactory.iconIgnorePlacement((Boolean) true), PropertyFactory.iconRotationAlignment("map"), PropertyFactory.iconRotate(Expression.match(literal, Expression.literal((Number) valueOf), Expression.stop(LocationComponentConstants.FOREGROUND_LAYER, Expression.get("mapbox-property-gps-bearing")), Expression.stop(LocationComponentConstants.BACKGROUND_LAYER, Expression.get("mapbox-property-gps-bearing")), Expression.stop(LocationComponentConstants.SHADOW_LAYER, Expression.get("mapbox-property-gps-bearing")), Expression.stop(LocationComponentConstants.BEARING_LAYER, Expression.get("mapbox-property-compass-bearing")))), PropertyFactory.iconImage(Expression.match(Expression.literal(str), Expression.literal(""), Expression.stop(LocationComponentConstants.FOREGROUND_LAYER, Expression.switchCase(Expression.get("mapbox-property-location-stale"), Expression.get("mapbox-property-foreground-stale-icon"), Expression.get("mapbox-property-foreground-icon"))), Expression.stop(LocationComponentConstants.BACKGROUND_LAYER, Expression.switchCase(Expression.get("mapbox-property-location-stale"), Expression.get("mapbox-property-background-stale-icon"), Expression.get("mapbox-property-background-icon"))), Expression.stop(LocationComponentConstants.SHADOW_LAYER, Expression.literal("mapbox-location-shadow-icon")), Expression.stop(LocationComponentConstants.BEARING_LAYER, Expression.get("mapbox-property-shadow-icon")))), PropertyFactory.iconOffset(Expression.match(Expression.literal(str), Expression.literal((Object[]) new Float[]{valueOf, valueOf}), Expression.stop(Expression.literal(LocationComponentConstants.FOREGROUND_LAYER), Expression.get("mapbox-property-foreground-icon-offset")), Expression.stop(Expression.literal(LocationComponentConstants.SHADOW_LAYER), Expression.get("mapbox-property-shadow-icon-offset")))));
        return symbolLayer;
    }

    Layer generateAccuracyLayer() {
        return new CircleLayer(LocationComponentConstants.ACCURACY_LAYER, LocationComponentConstants.LOCATION_SOURCE).withProperties(PropertyFactory.circleRadius(Expression.get("mapbox-property-accuracy-radius")), PropertyFactory.circleColor(Expression.get("mapbox-property-accuracy-color")), PropertyFactory.circleOpacity(Expression.get("mapbox-property-accuracy-alpha")), PropertyFactory.circleStrokeColor(Expression.get("mapbox-property-accuracy-color")), PropertyFactory.circlePitchAlignment("map"));
    }

    Set<String> getEmptyLayerSet() {
        return new HashSet();
    }

    LocationLayerRenderer getSymbolLocationLayerRenderer(LayerFeatureProvider layerFeatureProvider, boolean z) {
        return new SymbolLocationLayerRenderer(this, layerFeatureProvider, z);
    }

    LocationLayerRenderer getIndicatorLocationLayerRenderer() {
        return new IndicatorLocationLayerRenderer(this);
    }

    Layer generateLocationComponentLayer() {
        LocationIndicatorLayer locationIndicatorLayer = new LocationIndicatorLayer(LocationComponentConstants.FOREGROUND_LAYER);
        locationIndicatorLayer.setLocationTransition(new TransitionOptions(0L, 0L));
        locationIndicatorLayer.setProperties(LocationPropertyFactory.perspectiveCompensation(Float.valueOf(0.9f)), LocationPropertyFactory.imageTiltDisplacement(Float.valueOf(4.0f)));
        return locationIndicatorLayer;
    }

    Layer generatePulsingCircleLayer() {
        return new CircleLayer(LocationComponentConstants.PULSING_CIRCLE_LAYER, LocationComponentConstants.LOCATION_SOURCE).withProperties(PropertyFactory.circlePitchAlignment("map"));
    }
}