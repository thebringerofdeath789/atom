package com.baidu.geofence.model;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
final class a implements Parcelable.Creator<DPoint> {
    a() {
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public DPoint createFromParcel(Parcel parcel) {
        return new DPoint(parcel, (a) null);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public DPoint[] newArray(int i) {
        return new DPoint[i];
    }
}
