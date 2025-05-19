package com.baidu.geofence.model;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
final class b implements Parcelable.Creator<DistrictItem> {
    b() {
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public DistrictItem createFromParcel(Parcel parcel) {
        return new DistrictItem(parcel, null);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public DistrictItem[] newArray(int i) {
        return new DistrictItem[0];
    }
}
