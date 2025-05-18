package com.mapbox.mapboxsdk.offline;

import android.os.Parcel;
import android.os.Parcelable;
import com.mapbox.mapboxsdk.geometry.LatLngBoundsZoom;

/* loaded from: classes3.dex */
public class CacheAreaDefinition implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() { // from class: com.mapbox.mapboxsdk.offline.CacheAreaDefinition.1
        @Override // android.os.Parcelable.Creator
        public CacheAreaDefinition createFromParcel(Parcel parcel) {
            return new CacheAreaDefinition(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public CacheAreaDefinition[] newArray(int i) {
            return new CacheAreaDefinition[i];
        }
    };
    private LatLngBoundsZoom[] boundsZoomList;
    private boolean includeIdeographs;
    private float pixelRatio;
    private String styleURL;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public CacheAreaDefinition(String str, LatLngBoundsZoom[] latLngBoundsZoomArr, float f) {
        this(str, latLngBoundsZoomArr, f, false);
    }

    public CacheAreaDefinition(String str, LatLngBoundsZoom[] latLngBoundsZoomArr, float f, boolean z) {
        this.styleURL = str;
        this.boundsZoomList = latLngBoundsZoomArr;
        this.pixelRatio = f;
        this.includeIdeographs = z;
    }

    public CacheAreaDefinition(Parcel parcel) {
        this.styleURL = parcel.readString();
        parcel.readTypedArray(this.boundsZoomList, LatLngBoundsZoom.CREATOR);
        this.pixelRatio = parcel.readFloat();
        this.includeIdeographs = parcel.readByte() != 0;
    }

    public String getStyleURL() {
        return this.styleURL;
    }

    public float getPixelRatio() {
        return this.pixelRatio;
    }

    public boolean getIncludeIdeographs() {
        return this.includeIdeographs;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.styleURL);
        parcel.writeTypedArray(this.boundsZoomList, 0);
        parcel.writeFloat(this.pixelRatio);
        parcel.writeByte(this.includeIdeographs ? (byte) 1 : (byte) 0);
    }
}