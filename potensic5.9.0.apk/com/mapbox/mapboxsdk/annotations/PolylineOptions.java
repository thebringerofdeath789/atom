package com.mapbox.mapboxsdk.annotations;

import android.os.Parcel;
import android.os.Parcelable;
import com.mapbox.mapboxsdk.geometry.LatLng;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Deprecated
/* loaded from: classes3.dex */
public final class PolylineOptions implements Parcelable {
    public static final Parcelable.Creator<PolylineOptions> CREATOR = new Parcelable.Creator<PolylineOptions>() { // from class: com.mapbox.mapboxsdk.annotations.PolylineOptions.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PolylineOptions createFromParcel(Parcel parcel) {
            return new PolylineOptions(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PolylineOptions[] newArray(int i) {
            return new PolylineOptions[i];
        }
    };
    private Polyline polyline;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    private PolylineOptions(Parcel parcel) {
        this.polyline = new Polyline();
        ArrayList arrayList = new ArrayList();
        parcel.readList(arrayList, LatLng.class.getClassLoader());
        addAll(arrayList);
        alpha(parcel.readFloat());
        color(parcel.readInt());
        width(parcel.readFloat());
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(getPoints());
        parcel.writeFloat(getAlpha());
        parcel.writeInt(getColor());
        parcel.writeFloat(getWidth());
    }

    public PolylineOptions() {
        this.polyline = new Polyline();
    }

    public PolylineOptions add(LatLng latLng) {
        this.polyline.addPoint(latLng);
        return this;
    }

    public PolylineOptions add(LatLng... latLngArr) {
        for (LatLng latLng : latLngArr) {
            add(latLng);
        }
        return this;
    }

    public PolylineOptions addAll(Iterable<LatLng> iterable) {
        Iterator<LatLng> it = iterable.iterator();
        while (it.hasNext()) {
            add(it.next());
        }
        return this;
    }

    public PolylineOptions alpha(float f) {
        this.polyline.setAlpha(f);
        return this;
    }

    public float getAlpha() {
        return this.polyline.getAlpha();
    }

    public PolylineOptions color(int i) {
        this.polyline.setColor(i);
        return this;
    }

    public int getColor() {
        return this.polyline.getColor();
    }

    public Polyline getPolyline() {
        return this.polyline;
    }

    public float getWidth() {
        return this.polyline.getWidth();
    }

    public PolylineOptions width(float f) {
        this.polyline.setWidth(f);
        return this;
    }

    public List<LatLng> getPoints() {
        return this.polyline.getPoints();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        PolylineOptions polylineOptions = (PolylineOptions) obj;
        if (Float.compare(polylineOptions.getAlpha(), getAlpha()) != 0 || getColor() != polylineOptions.getColor() || Float.compare(polylineOptions.getWidth(), getWidth()) != 0) {
            return false;
        }
        if (getPoints() != null) {
            if (getPoints().equals(polylineOptions.getPoints())) {
                return true;
            }
        } else if (polylineOptions.getPoints() == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((((getAlpha() != 0.0f ? Float.floatToIntBits(getAlpha()) : 0) + 31) * 31) + getColor()) * 31) + (getWidth() != 0.0f ? Float.floatToIntBits(getWidth()) : 0)) * 31) + (getPoints() != null ? getPoints().hashCode() : 0);
    }
}