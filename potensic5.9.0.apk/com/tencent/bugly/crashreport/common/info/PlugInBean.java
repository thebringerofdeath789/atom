package com.tencent.bugly.crashreport.common.info;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: BUGLY */
/* loaded from: classes3.dex */
public class PlugInBean implements Parcelable {
    public static final Parcelable.Creator<PlugInBean> CREATOR = new Parcelable.Creator<PlugInBean>() { // from class: com.tencent.bugly.crashreport.common.info.PlugInBean.1
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ PlugInBean createFromParcel(Parcel parcel) {
            return new PlugInBean(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ PlugInBean[] newArray(int i) {
            return new PlugInBean[i];
        }
    };

    /* renamed from: a */
    public final String f2923a;

    /* renamed from: b */
    public final String f2924b;

    /* renamed from: c */
    public final String f2925c;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public PlugInBean(String str, String str2, String str3) {
        this.f2923a = str;
        this.f2924b = str2;
        this.f2925c = str3;
    }

    public String toString() {
        return "plid:" + this.f2923a + " plV:" + this.f2924b + " plUUID:" + this.f2925c;
    }

    public PlugInBean(Parcel parcel) {
        this.f2923a = parcel.readString();
        this.f2924b = parcel.readString();
        this.f2925c = parcel.readString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f2923a);
        parcel.writeString(this.f2924b);
        parcel.writeString(this.f2925c);
    }
}