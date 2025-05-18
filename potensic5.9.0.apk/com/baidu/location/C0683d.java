package com.baidu.location;

import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: com.baidu.location.d */
/* loaded from: classes.dex */
final class C0683d implements Parcelable.Creator<Poi> {
    C0683d() {
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