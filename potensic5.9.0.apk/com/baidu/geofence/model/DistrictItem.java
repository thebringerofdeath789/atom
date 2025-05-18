package com.baidu.geofence.model;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class DistrictItem implements Parcelable {
    public static final Parcelable.Creator<DistrictItem> CREATOR = new C0618b();

    /* renamed from: a */
    private String f209a;

    /* renamed from: b */
    private String f210b;

    /* renamed from: c */
    private String f211c;

    private DistrictItem(Parcel parcel) {
        this.f209a = parcel.readString();
        this.f210b = parcel.readString();
        this.f211c = parcel.readString();
    }

    /* synthetic */ DistrictItem(Parcel parcel, C0618b c0618b) {
        this(parcel);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f209a);
        parcel.writeString(this.f210b);
        parcel.writeString(this.f211c);
    }
}