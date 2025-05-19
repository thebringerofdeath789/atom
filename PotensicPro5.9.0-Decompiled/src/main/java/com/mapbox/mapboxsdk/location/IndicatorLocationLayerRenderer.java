package com.mapbox.mapboxsdk.location;

import android.graphics.Bitmap;
import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.mapboxsdk.maps.Style;
import com.mapbox.mapboxsdk.style.expressions.Expression;
import com.mapbox.mapboxsdk.style.layers.Layer;
import com.mapbox.mapboxsdk.style.layers.Property;
import com.mapbox.mapboxsdk.style.layers.PropertyValue;
import com.mapbox.mapboxsdk.utils.BitmapUtils;
import com.mapbox.mapboxsdk.utils.ColorUtils;

/* loaded from: classes3.dex */
class IndicatorLocationLayerRenderer implements LocationLayerRenderer {
    private LatLng lastLatLng;
    private Layer layer;
    private final LayerSourceProvider layerSourceProvider;
    private Style style;
    private double lastBearing = 0.0d;
    private float lastAccuracy = 0.0f;

    @Override // com.mapbox.mapboxsdk.location.LocationLayerRenderer
    public void adjustPulsingCircleLayerVisibility(boolean z) {
    }

    @Override // com.mapbox.mapboxsdk.location.LocationLayerRenderer
    public void cameraBearingUpdated(double d) {
    }

    @Override // com.mapbox.mapboxsdk.location.LocationLayerRenderer
    public void cameraTiltUpdated(double d) {
    }

    @Override // com.mapbox.mapboxsdk.location.LocationLayerRenderer
    public void stylePulsingCircle(LocationComponentOptions locationComponentOptions) {
    }

    @Override // com.mapbox.mapboxsdk.location.LocationLayerRenderer
    public void updateIconIds(String str, String str2, String str3, String str4, String str5) {
    }

    @Override // com.mapbox.mapboxsdk.location.LocationLayerRenderer
    public void updatePulsingUi(float f, Float f2) {
    }

    IndicatorLocationLayerRenderer(LayerSourceProvider layerSourceProvider) {
        this.layerSourceProvider = layerSourceProvider;
    }

    @Override // com.mapbox.mapboxsdk.location.LocationLayerRenderer
    public void initializeComponents(Style style) {
        this.style = style;
        this.layer = this.layerSourceProvider.generateLocationComponentLayer();
        LatLng latLng = this.lastLatLng;
        if (latLng != null) {
            setLatLng(latLng);
        }
        setLayerBearing(this.lastBearing);
        setAccuracyRadius(Float.valueOf(this.lastAccuracy));
    }

    @Override // com.mapbox.mapboxsdk.location.LocationLayerRenderer
    public void addLayers(LocationComponentPositionManager locationComponentPositionManager) {
        locationComponentPositionManager.addLayerToMap(this.layer);
    }

    @Override // com.mapbox.mapboxsdk.location.LocationLayerRenderer
    public void removeLayers() {
        this.style.removeLayer(this.layer);
    }

    @Override // com.mapbox.mapboxsdk.location.LocationLayerRenderer
    public void hide() {
        setLayerVisibility(false);
    }

    @Override // com.mapbox.mapboxsdk.location.LocationLayerRenderer
    public void show(int i, boolean z) {
        setImages(i, z);
        setLayerVisibility(true);
    }

    @Override // com.mapbox.mapboxsdk.location.LocationLayerRenderer
    public void styleAccuracy(float f, int i) {
        float[] colorToRgbaArray = ColorUtils.colorToRgbaArray(i);
        colorToRgbaArray[3] = f;
        Expression rgba = Expression.rgba(Float.valueOf(colorToRgbaArray[0]), Float.valueOf(colorToRgbaArray[1]), Float.valueOf(colorToRgbaArray[2]), Float.valueOf(colorToRgbaArray[3]));
        this.layer.setProperties(LocationPropertyFactory.accuracyRadiusColor(rgba), LocationPropertyFactory.accuracyRadiusBorderColor(rgba));
    }

    @Override // com.mapbox.mapboxsdk.location.LocationLayerRenderer
    public void setLatLng(LatLng latLng) {
        setLayerLocation(latLng);
    }

    @Override // com.mapbox.mapboxsdk.location.LocationLayerRenderer
    public void setGpsBearing(Float f) {
        setLayerBearing(f.floatValue());
    }

    @Override // com.mapbox.mapboxsdk.location.LocationLayerRenderer
    public void setCompassBearing(Float f) {
        setLayerBearing(f.floatValue());
    }

    @Override // com.mapbox.mapboxsdk.location.LocationLayerRenderer
    public void setAccuracyRadius(Float f) {
        this.layer.setProperties(LocationPropertyFactory.accuracyRadius(f));
        this.lastAccuracy = f.floatValue();
    }

    @Override // com.mapbox.mapboxsdk.location.LocationLayerRenderer
    public void styleScaling(Expression expression) {
        this.layer.setProperties(LocationPropertyFactory.shadowImageSize(expression), LocationPropertyFactory.bearingImageSize(expression), LocationPropertyFactory.topImageSize(expression));
    }

    @Override // com.mapbox.mapboxsdk.location.LocationLayerRenderer
    public void setLocationStale(boolean z, int i) {
        setImages(i, z);
    }

    @Override // com.mapbox.mapboxsdk.location.LocationLayerRenderer
    public void addBitmaps(int i, Bitmap bitmap, Bitmap bitmap2, Bitmap bitmap3, Bitmap bitmap4, Bitmap bitmap5, Bitmap bitmap6) {
        if (bitmap != null) {
            this.style.addImage("mapbox-location-shadow-icon", bitmap);
        } else {
            this.style.removeImage("mapbox-location-shadow-icon");
        }
        this.style.addImage("mapbox-location-icon", bitmap5);
        this.style.addImage("mapbox-location-stale-icon", bitmap6);
        if (i == 4) {
            this.style.addImage("mapbox-location-bearing-icon", BitmapUtils.mergeBitmap(bitmap4, bitmap2, (bitmap4.getWidth() - bitmap2.getWidth()) / 2.0f, (bitmap4.getHeight() - bitmap2.getHeight()) / 2.0f));
            this.style.addImage("mapbox-location-bearing-stale-icon", BitmapUtils.mergeBitmap(bitmap4, bitmap3, (bitmap4.getWidth() - bitmap3.getWidth()) / 2.0f, (bitmap4.getHeight() - bitmap3.getHeight()) / 2.0f));
            return;
        }
        this.style.addImage("mapbox-location-stroke-icon", bitmap2);
        this.style.addImage("mapbox-location-background-stale-icon", bitmap3);
        this.style.addImage("mapbox-location-bearing-icon", bitmap4);
    }

    private void setLayerVisibility(boolean z) {
        Layer layer = this.layer;
        PropertyValue<?>[] propertyValueArr = new PropertyValue[1];
        propertyValueArr[0] = LocationPropertyFactory.visibility(z ? Property.VISIBLE : "none");
        layer.setProperties(propertyValueArr);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void setLayerLocation(LatLng latLng) {
        this.layer.setProperties(LocationPropertyFactory.location(new Double[]{Double.valueOf(latLng.getLatitude()), Double.valueOf(latLng.getLongitude()), Double.valueOf(0.0d)}));
        this.lastLatLng = latLng;
    }

    private void setLayerBearing(double d) {
        this.layer.setProperties(LocationPropertyFactory.bearing(Double.valueOf(d)));
        this.lastBearing = d;
    }

    private void setImages(int i, boolean z) {
        String str;
        String str2;
        String str3 = "mapbox-location-shadow-icon";
        String str4 = "";
        if (i != 4) {
            if (i == 8) {
                str = z ? "mapbox-location-stale-icon" : "mapbox-location-icon";
                str3 = z ? "mapbox-location-background-stale-icon" : "mapbox-location-stroke-icon";
                setAccuracyRadius(Float.valueOf(0.0f));
            } else if (i != 18) {
                str3 = "";
                str = str3;
            } else {
                str = z ? "mapbox-location-stale-icon" : "mapbox-location-icon";
                str2 = z ? "mapbox-location-background-stale-icon" : "mapbox-location-stroke-icon";
            }
            this.layer.setProperties(LocationPropertyFactory.topImage(str4), LocationPropertyFactory.bearingImage(str), LocationPropertyFactory.shadowImage(str3));
        }
        str = z ? "mapbox-location-stale-icon" : "mapbox-location-icon";
        str2 = z ? "mapbox-location-bearing-stale-icon" : "mapbox-location-bearing-icon";
        String str5 = str2;
        str4 = str;
        str = str5;
        this.layer.setProperties(LocationPropertyFactory.topImage(str4), LocationPropertyFactory.bearingImage(str), LocationPropertyFactory.shadowImage(str3));
    }
}
