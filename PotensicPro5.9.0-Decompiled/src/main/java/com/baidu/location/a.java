package com.baidu.location;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
final class a implements Parcelable.Creator<BDLocation> {
    a() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public BDLocation createFromParcel(Parcel parcel) {
        return new BDLocation(parcel, null);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public BDLocation[] newArray(int i) {
        return new BDLocation[i];
    }
}
