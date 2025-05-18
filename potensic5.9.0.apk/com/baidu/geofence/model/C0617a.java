package com.baidu.geofence.model;

import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: com.baidu.geofence.model.a */
/* loaded from: classes.dex */
final class C0617a implements Parcelable.Creator<DPoint> {
    C0617a() {
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public DPoint createFromParcel(Parcel parcel) {
        return new DPoint(parcel, (C0617a) null);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public DPoint[] newArray(int i) {
        return new DPoint[i];
    }
}