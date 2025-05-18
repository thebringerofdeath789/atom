package com.mapbox.mapboxsdk.geometry;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes3.dex */
public class LatLngBoundsZoom implements Parcelable {
    public static final Parcelable.Creator<LatLngBoundsZoom> CREATOR = new Parcelable.Creator<LatLngBoundsZoom>() { // from class: com.mapbox.mapboxsdk.geometry.LatLngBoundsZoom.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LatLngBoundsZoom createFromParcel(Parcel parcel) {
            return LatLngBoundsZoom.readFromParcel(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LatLngBoundsZoom[] newArray(int i) {
            return new LatLngBoundsZoom[i];
        }
    };
    private final LatLngBounds bounds;
    private final double zoom;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    LatLngBoundsZoom(LatLngBounds latLngBounds, double d) {
        this.bounds = latLngBounds;
        this.zoom = d;
    }

    LatLngBoundsZoom(double d, double d2, double d3, double d4, double d5) {
        this.bounds = LatLngBounds.from(d, d2, d3, d4);
        this.zoom = d5;
    }

    public LatLngBounds getLatLngBounds() {
        return this.bounds;
    }

    public double getZoom() {
        return this.zoom;
    }

    public String toString() {
        return "Bounds: {" + this.bounds + "}, Zoom: " + this.zoom;
    }

    public static LatLngBoundsZoom from(double d, double d2, double d3, double d4, double d5) {
        return new LatLngBoundsZoom(LatLngBounds.from(d, d2, d3, d4), d5);
    }

    public static LatLngBoundsZoom from(int i, int i2, int i3) {
        return new LatLngBoundsZoom(LatLngBounds.from(i, i2, i3), i);
    }

    public static LatLngBoundsZoom from(LatLngBounds latLngBounds, double d) {
        return new LatLngBoundsZoom(latLngBounds, d);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LatLngBoundsZoom)) {
            return false;
        }
        LatLngBoundsZoom latLngBoundsZoom = (LatLngBoundsZoom) obj;
        return this.bounds == latLngBoundsZoom.getLatLngBounds() && this.zoom == latLngBoundsZoom.getZoom();
    }

    public int hashCode() {
        return (int) (this.bounds.hashCode() + (this.zoom * 31.0d));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeDouble(this.bounds.getLatNorth());
        parcel.writeDouble(this.bounds.getLonEast());
        parcel.writeDouble(this.bounds.getLatSouth());
        parcel.writeDouble(this.bounds.getLonWest());
        parcel.writeDouble(this.zoom);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static LatLngBoundsZoom readFromParcel(Parcel parcel) {
        return from(parcel.readDouble(), parcel.readDouble(), parcel.readDouble(), parcel.readDouble(), parcel.readDouble());
    }
}