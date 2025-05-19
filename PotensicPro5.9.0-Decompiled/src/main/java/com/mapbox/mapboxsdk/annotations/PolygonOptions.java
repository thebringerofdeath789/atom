package com.mapbox.mapboxsdk.annotations;

import android.os.Parcel;
import android.os.Parcelable;
import com.mapbox.mapboxsdk.geometry.LatLng;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Deprecated
/* loaded from: classes3.dex */
public final class PolygonOptions implements Parcelable {
    public static final Parcelable.Creator<PolygonOptions> CREATOR = new Parcelable.Creator<PolygonOptions>() { // from class: com.mapbox.mapboxsdk.annotations.PolygonOptions.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PolygonOptions createFromParcel(Parcel parcel) {
            return new PolygonOptions(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PolygonOptions[] newArray(int i) {
            return new PolygonOptions[i];
        }
    };
    private Polygon polygon;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    private PolygonOptions(Parcel parcel) {
        this.polygon = new Polygon();
        ArrayList arrayList = new ArrayList();
        parcel.readList(arrayList, LatLng.class.getClassLoader());
        addAll(arrayList);
        ArrayList arrayList2 = new ArrayList();
        parcel.readList(arrayList2, LatLng.class.getClassLoader());
        addAllHoles(arrayList2);
        alpha(parcel.readFloat());
        fillColor(parcel.readInt());
        strokeColor(parcel.readInt());
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(getPoints());
        parcel.writeList(getHoles());
        parcel.writeFloat(getAlpha());
        parcel.writeInt(getFillColor());
        parcel.writeInt(getStrokeColor());
    }

    public PolygonOptions() {
        this.polygon = new Polygon();
    }

    public PolygonOptions add(LatLng latLng) {
        this.polygon.addPoint(latLng);
        return this;
    }

    public PolygonOptions add(LatLng... latLngArr) {
        for (LatLng latLng : latLngArr) {
            add(latLng);
        }
        return this;
    }

    public PolygonOptions addAll(Iterable<LatLng> iterable) {
        Iterator<LatLng> it = iterable.iterator();
        while (it.hasNext()) {
            add(it.next());
        }
        return this;
    }

    public PolygonOptions addHole(List<LatLng> list) {
        this.polygon.addHole(list);
        return this;
    }

    public PolygonOptions addHole(List<LatLng>... listArr) {
        for (List<LatLng> list : listArr) {
            addHole(list);
        }
        return this;
    }

    public PolygonOptions addAllHoles(Iterable<List<LatLng>> iterable) {
        Iterator<List<LatLng>> it = iterable.iterator();
        while (it.hasNext()) {
            addHole(it.next());
        }
        return this;
    }

    public PolygonOptions alpha(float f) {
        this.polygon.setAlpha(f);
        return this;
    }

    public float getAlpha() {
        return this.polygon.getAlpha();
    }

    public PolygonOptions fillColor(int i) {
        this.polygon.setFillColor(i);
        return this;
    }

    public int getFillColor() {
        return this.polygon.getFillColor();
    }

    public Polygon getPolygon() {
        return this.polygon;
    }

    public PolygonOptions strokeColor(int i) {
        this.polygon.setStrokeColor(i);
        return this;
    }

    public int getStrokeColor() {
        return this.polygon.getStrokeColor();
    }

    public List<LatLng> getPoints() {
        return this.polygon.getPoints();
    }

    public List<List<LatLng>> getHoles() {
        return this.polygon.getHoles();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        PolygonOptions polygonOptions = (PolygonOptions) obj;
        if (Float.compare(polygonOptions.getAlpha(), getAlpha()) != 0 || getFillColor() != polygonOptions.getFillColor() || getStrokeColor() != polygonOptions.getStrokeColor()) {
            return false;
        }
        if (getPoints() == null ? polygonOptions.getPoints() != null : !getPoints().equals(polygonOptions.getPoints())) {
            return false;
        }
        if (getHoles() != null) {
            if (getHoles().equals(polygonOptions.getHoles())) {
                return true;
            }
        } else if (polygonOptions.getHoles() == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((getAlpha() != 0.0f ? Float.floatToIntBits(getAlpha()) : 0) + 31) * 31) + getFillColor()) * 31) + getStrokeColor()) * 31) + (getPoints() != null ? getPoints().hashCode() : 0)) * 31) + (getHoles() != null ? getHoles().hashCode() : 0);
    }
}
