package com.baidu.geofence.model;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class DistrictItem implements Parcelable {
    public static final Parcelable.Creator<DistrictItem> CREATOR = new b();
    private String a;
    private String b;
    private String c;

    private DistrictItem(Parcel parcel) {
        this.a = parcel.readString();
        this.b = parcel.readString();
        this.c = parcel.readString();
    }

    /* synthetic */ DistrictItem(Parcel parcel, b bVar) {
        this(parcel);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
    }
}
