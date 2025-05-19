package com.baidu.geofence.model;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class DPoint implements Parcelable {
    public static final Parcelable.Creator<DPoint> CREATOR = new a();
    private double a;
    private double b;

    public DPoint(double d, double d2) {
        this.a = d;
        this.b = d2;
    }

    private DPoint(Parcel parcel) {
        this.a = parcel.readDouble();
        this.b = parcel.readDouble();
    }

    /* synthetic */ DPoint(Parcel parcel, a aVar) {
        this(parcel);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public double getLatitude() {
        return this.a;
    }

    public double getLongitude() {
        return this.b;
    }

    public void setLatitude(double d) {
        this.a = d;
    }

    public void setLongitude(double d) {
        this.b = d;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeDouble(this.a);
        parcel.writeDouble(this.b);
    }
}
