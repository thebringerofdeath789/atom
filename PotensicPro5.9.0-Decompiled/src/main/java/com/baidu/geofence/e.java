package com.baidu.geofence;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
final class e implements Parcelable.Creator<PoiItem> {
    e() {
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
