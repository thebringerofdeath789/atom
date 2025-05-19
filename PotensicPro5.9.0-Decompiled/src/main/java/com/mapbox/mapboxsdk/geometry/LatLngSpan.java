package com.mapbox.mapboxsdk.geometry;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes3.dex */
public class LatLngSpan implements Parcelable {
    public static final Parcelable.Creator<LatLngSpan> CREATOR = new Parcelable.Creator<LatLngSpan>() { // from class: com.mapbox.mapboxsdk.geometry.LatLngSpan.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LatLngSpan createFromParcel(Parcel parcel) {
            return new LatLngSpan(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LatLngSpan[] newArray(int i) {
            return new LatLngSpan[i];
        }
    };
    private double mLatitudeSpan;
    private double mLongitudeSpan;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    private LatLngSpan(Parcel parcel) {
        this.mLatitudeSpan = parcel.readDouble();
        this.mLongitudeSpan = parcel.readDouble();
    }

    public LatLngSpan(double d, double d2) {
        this.mLatitudeSpan = d;
        this.mLongitudeSpan = d2;
    }

    public double getLatitudeSpan() {
        return this.mLatitudeSpan;
    }

    public void setLatitudeSpan(double d) {
        this.mLatitudeSpan = d;
    }

    public double getLongitudeSpan() {
        return this.mLongitudeSpan;
    }

    public void setLongitudeSpan(double d) {
        this.mLongitudeSpan = d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LatLngSpan)) {
            return false;
        }
        LatLngSpan latLngSpan = (LatLngSpan) obj;
        return this.mLongitudeSpan == latLngSpan.getLongitudeSpan() && this.mLatitudeSpan == latLngSpan.getLatitudeSpan();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeDouble(this.mLatitudeSpan);
        parcel.writeDouble(this.mLongitudeSpan);
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.mLatitudeSpan);
        int i = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
        long doubleToLongBits2 = Double.doubleToLongBits(this.mLongitudeSpan);
        return (i * 31) + ((int) ((doubleToLongBits2 >>> 32) ^ doubleToLongBits2));
    }
}
