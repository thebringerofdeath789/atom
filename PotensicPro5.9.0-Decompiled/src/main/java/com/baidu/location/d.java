package com.baidu.location;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
final class d implements Parcelable.Creator<Poi> {
    d() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public Poi createFromParcel(Parcel parcel) {
        return new Poi(parcel.readString(), parcel.readString(), parcel.readDouble(), parcel.readString(), parcel.readString());
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public Poi[] newArray(int i) {
        return new Poi[i];
    }
}
