package com.baidu.geofence.model;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class DPoint implements Parcelable {
    public static final Parcelable.Creator<DPoint> CREATOR = new C0617a();

    /* renamed from: a */
    private double f207a;

    /* renamed from: b */
    private double f208b;

    public DPoint(double d, double d2) {
        this.f207a = d;
        this.f208b = d2;
    }

    private DPoint(Parcel parcel) {
        this.f207a = parcel.readDouble();
        this.f208b = parcel.readDouble();
    }

    /* synthetic */ DPoint(Parcel parcel, C0617a c0617a) {
        this(parcel);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public double getLatitude() {
        return this.f207a;
    }

    public double getLongitude() {
        return this.f208b;
    }

    public void setLatitude(double d) {
        this.f207a = d;
    }

    public void setLongitude(double d) {
        this.f208b = d;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeDouble(this.f207a);
        parcel.writeDouble(this.f208b);
    }
}