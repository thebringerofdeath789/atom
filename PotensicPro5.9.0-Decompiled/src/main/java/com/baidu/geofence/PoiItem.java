package com.baidu.geofence;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class PoiItem implements Parcelable {
    public static final Parcelable.Creator<PoiItem> CREATOR = new e();
    private double a;
    private double b;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;
    private String h;
    private String i;
    private String j;
    private String k;

    public PoiItem() {
    }

    private PoiItem(Parcel parcel) {
        this.c = parcel.readString();
        this.k = parcel.readString();
        this.d = parcel.readString();
        this.e = parcel.readString();
        this.i = parcel.readString();
        this.f = parcel.readString();
        this.j = parcel.readString();
        this.g = parcel.readString();
        this.h = parcel.readString();
        this.a = parcel.readDouble();
        this.b = parcel.readDouble();
    }

    /* synthetic */ PoiItem(Parcel parcel, e eVar) {
        this(parcel);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAdName() {
        return this.j;
    }

    public String getAddress() {
        return this.f;
    }

    public String getCity() {
        return this.i;
    }

    public double getLatitude() {
        return this.a;
    }

    public double getLongitude() {
        return this.b;
    }

    public String getPoiId() {
        return this.c;
    }

    public String getPoiName() {
        return this.k;
    }

    public String getPoiType() {
        return this.d;
    }

    public String getPoiTypeCode() {
        return this.e;
    }

    public String getProvince() {
        return this.h;
    }

    public String getTel() {
        return this.g;
    }

    public void setAdName(String str) {
        this.j = str;
    }

    public void setAddress(String str) {
        this.f = str;
    }

    public void setCity(String str) {
        this.i = str;
    }

    public void setLatitude(double d) {
        this.a = d;
    }

    public void setLongitude(double d) {
        this.b = d;
    }

    public void setPoiId(String str) {
        this.c = str;
    }

    public void setPoiName(String str) {
        this.k = str;
    }

    public void setPoiType(String str) {
        this.d = str;
    }

    public void setPoiTypeCode(String str) {
        this.e = str;
    }

    public void setProvince(String str) {
        this.h = str;
    }

    public void setTel(String str) {
        this.g = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.c);
        parcel.writeString(this.k);
        parcel.writeString(this.d);
        parcel.writeString(this.e);
        parcel.writeString(this.i);
        parcel.writeString(this.f);
        parcel.writeString(this.j);
        parcel.writeString(this.g);
        parcel.writeString(this.h);
        parcel.writeDouble(this.a);
        parcel.writeDouble(this.b);
    }
}
