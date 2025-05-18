package com.baidu.geofence;

import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: com.baidu.geofence.e */
/* loaded from: classes.dex */
final class C0616e implements Parcelable.Creator<PoiItem> {
    C0616e() {
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public PoiItem createFromParcel(Parcel parcel) {
        return new PoiItem(parcel, null);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public PoiItem[] newArray(int i) {
        return new PoiItem[0];
    }
}