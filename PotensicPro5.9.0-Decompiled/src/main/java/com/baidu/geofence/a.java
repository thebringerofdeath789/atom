package com.baidu.geofence;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
final class a implements Parcelable.Creator<GeoFence> {
    a() {
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public GeoFence createFromParcel(Parcel parcel) {
        return new GeoFence(parcel, null);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public GeoFence[] newArray(int i) {
        return new GeoFence[i];
    }
}
