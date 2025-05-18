package com.mapbox.mapboxsdk.offline;

import android.os.Parcel;
import android.os.Parcelable;
import com.mapbox.geojson.Feature;
import com.mapbox.geojson.Geometry;
import com.mapbox.mapboxsdk.geometry.LatLngBounds;
import com.mapbox.turf.TurfMeasurement;

/* loaded from: classes3.dex */
public class OfflineGeometryRegionDefinition implements OfflineRegionDefinition {
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() { // from class: com.mapbox.mapboxsdk.offline.OfflineGeometryRegionDefinition.1
        @Override // android.os.Parcelable.Creator
        public OfflineGeometryRegionDefinition createFromParcel(Parcel parcel) {
            return new OfflineGeometryRegionDefinition(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public OfflineGeometryRegionDefinition[] newArray(int i) {
            return new OfflineGeometryRegionDefinition[i];
        }
    };
    private Geometry geometry;
    private boolean includeIdeographs;
    private double maxZoom;
    private double minZoom;
    private float pixelRatio;
    private String styleURL;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.mapbox.mapboxsdk.offline.OfflineRegionDefinition
    public String getType() {
        return "shaperegion";
    }

    public OfflineGeometryRegionDefinition(String str, Geometry geometry, double d, double d2, float f) {
        this(str, geometry, d, d2, f, false);
    }

    public OfflineGeometryRegionDefinition(String str, Geometry geometry, double d, double d2, float f, boolean z) {
        this.styleURL = str;
        this.geometry = geometry;
        this.minZoom = d;
        this.maxZoom = d2;
        this.pixelRatio = f;
        this.includeIdeographs = z;
    }

    public OfflineGeometryRegionDefinition(Parcel parcel) {
        this.styleURL = parcel.readString();
        this.geometry = Feature.fromJson(parcel.readString()).geometry();
        this.minZoom = parcel.readDouble();
        this.maxZoom = parcel.readDouble();
        this.pixelRatio = parcel.readFloat();
        this.includeIdeographs = parcel.readByte() != 0;
    }

    @Override // com.mapbox.mapboxsdk.offline.OfflineRegionDefinition
    public String getStyleURL() {
        return this.styleURL;
    }

    public Geometry getGeometry() {
        return this.geometry;
    }

    @Override // com.mapbox.mapboxsdk.offline.OfflineRegionDefinition
    public LatLngBounds getBounds() {
        Geometry geometry = this.geometry;
        if (geometry == null) {
            return null;
        }
        double[] bbox = TurfMeasurement.bbox(geometry);
        return LatLngBounds.from(bbox[3], bbox[2], bbox[1], bbox[0]);
    }

    @Override // com.mapbox.mapboxsdk.offline.OfflineRegionDefinition
    public double getMinZoom() {
        return this.minZoom;
    }

    @Override // com.mapbox.mapboxsdk.offline.OfflineRegionDefinition
    public double getMaxZoom() {
        return this.maxZoom;
    }

    @Override // com.mapbox.mapboxsdk.offline.OfflineRegionDefinition
    public float getPixelRatio() {
        return this.pixelRatio;
    }

    @Override // com.mapbox.mapboxsdk.offline.OfflineRegionDefinition
    public boolean getIncludeIdeographs() {
        return this.includeIdeographs;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.styleURL);
        parcel.writeString(Feature.fromGeometry(this.geometry).toJson());
        parcel.writeDouble(this.minZoom);
        parcel.writeDouble(this.maxZoom);
        parcel.writeFloat(this.pixelRatio);
        parcel.writeByte(this.includeIdeographs ? (byte) 1 : (byte) 0);
    }
}