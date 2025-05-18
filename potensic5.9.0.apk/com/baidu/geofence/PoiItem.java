package com.baidu.geofence;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class PoiItem implements Parcelable {
    public static final Parcelable.Creator<PoiItem> CREATOR = new C0616e();

    /* renamed from: a */
    private double f151a;

    /* renamed from: b */
    private double f152b;

    /* renamed from: c */
    private String f153c;

    /* renamed from: d */
    private String f154d;

    /* renamed from: e */
    private String f155e;

    /* renamed from: f */
    private String f156f;

    /* renamed from: g */
    private String f157g;

    /* renamed from: h */
    private String f158h;

    /* renamed from: i */
    private String f159i;

    /* renamed from: j */
    private String f160j;

    /* renamed from: k */
    private String f161k;

    public PoiItem() {
    }

    private PoiItem(Parcel parcel) {
        this.f153c = parcel.readString();
        this.f161k = parcel.readString();
        this.f154d = parcel.readString();
        this.f155e = parcel.readString();
        this.f159i = parcel.readString();
        this.f156f = parcel.readString();
        this.f160j = parcel.readString();
        this.f157g = parcel.readString();
        this.f158h = parcel.readString();
        this.f151a = parcel.readDouble();
        this.f152b = parcel.readDouble();
    }

    /* synthetic */ PoiItem(Parcel parcel, C0616e c0616e) {
        this(parcel);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAdName() {
        return this.f160j;
    }

    public String getAddress() {
        return this.f156f;
    }

    public String getCity() {
        return this.f159i;
    }

    public double getLatitude() {
        return this.f151a;
    }

    public double getLongitude() {
        return this.f152b;
    }

    public String getPoiId() {
        return this.f153c;
    }

    public String getPoiName() {
        return this.f161k;
    }

    public String getPoiType() {
        return this.f154d;
    }

    public String getPoiTypeCode() {
        return this.f155e;
    }

    public String getProvince() {
        return this.f158h;
    }

    public String getTel() {
        return this.f157g;
    }

    public void setAdName(String str) {
        this.f160j = str;
    }

    public void setAddress(String str) {
        this.f156f = str;
    }

    public void setCity(String str) {
        this.f159i = str;
    }

    public void setLatitude(double d) {
        this.f151a = d;
    }

    public void setLongitude(double d) {
        this.f152b = d;
    }

    public void setPoiId(String str) {
        this.f153c = str;
    }

    public void setPoiName(String str) {
        this.f161k = str;
    }

    public void setPoiType(String str) {
        this.f154d = str;
    }

    public void setPoiTypeCode(String str) {
        this.f155e = str;
    }

    public void setProvince(String str) {
        this.f158h = str;
    }

    public void setTel(String str) {
        this.f157g = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f153c);
        parcel.writeString(this.f161k);
        parcel.writeString(this.f154d);
        parcel.writeString(this.f155e);
        parcel.writeString(this.f159i);
        parcel.writeString(this.f156f);
        parcel.writeString(this.f160j);
        parcel.writeString(this.f157g);
        parcel.writeString(this.f158h);
        parcel.writeDouble(this.f151a);
        parcel.writeDouble(this.f152b);
    }
}