package com.tencent.bugly.crashreport.biz;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.bugly.proguard.C3403z;
import java.util.Map;

/* compiled from: BUGLY */
/* loaded from: classes3.dex */
public class UserInfoBean implements Parcelable {
    public static final Parcelable.Creator<UserInfoBean> CREATOR = new Parcelable.Creator<UserInfoBean>() { // from class: com.tencent.bugly.crashreport.biz.UserInfoBean.1
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ UserInfoBean createFromParcel(Parcel parcel) {
            return new UserInfoBean(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ UserInfoBean[] newArray(int i) {
            return new UserInfoBean[i];
        }
    };

    /* renamed from: a */
    public long f2875a;

    /* renamed from: b */
    public int f2876b;

    /* renamed from: c */
    public String f2877c;

    /* renamed from: d */
    public String f2878d;

    /* renamed from: e */
    public long f2879e;

    /* renamed from: f */
    public long f2880f;

    /* renamed from: g */
    public long f2881g;

    /* renamed from: h */
    public long f2882h;

    /* renamed from: i */
    public long f2883i;

    /* renamed from: j */
    public String f2884j;

    /* renamed from: k */
    public long f2885k;

    /* renamed from: l */
    public boolean f2886l;

    /* renamed from: m */
    public String f2887m;

    /* renamed from: n */
    public String f2888n;

    /* renamed from: o */
    public int f2889o;

    /* renamed from: p */
    public int f2890p;

    /* renamed from: q */
    public int f2891q;

    /* renamed from: r */
    public Map<String, String> f2892r;

    /* renamed from: s */
    public Map<String, String> f2893s;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public UserInfoBean() {
        this.f2885k = 0L;
        this.f2886l = false;
        this.f2887m = "unknown";
        this.f2890p = -1;
        this.f2891q = -1;
        this.f2892r = null;
        this.f2893s = null;
    }

    public UserInfoBean(Parcel parcel) {
        this.f2885k = 0L;
        this.f2886l = false;
        this.f2887m = "unknown";
        this.f2890p = -1;
        this.f2891q = -1;
        this.f2892r = null;
        this.f2893s = null;
        this.f2876b = parcel.readInt();
        this.f2877c = parcel.readString();
        this.f2878d = parcel.readString();
        this.f2879e = parcel.readLong();
        this.f2880f = parcel.readLong();
        this.f2881g = parcel.readLong();
        this.f2882h = parcel.readLong();
        this.f2883i = parcel.readLong();
        this.f2884j = parcel.readString();
        this.f2885k = parcel.readLong();
        this.f2886l = parcel.readByte() == 1;
        this.f2887m = parcel.readString();
        this.f2890p = parcel.readInt();
        this.f2891q = parcel.readInt();
        this.f2892r = C3403z.m2302b(parcel);
        this.f2893s = C3403z.m2302b(parcel);
        this.f2888n = parcel.readString();
        this.f2889o = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f2876b);
        parcel.writeString(this.f2877c);
        parcel.writeString(this.f2878d);
        parcel.writeLong(this.f2879e);
        parcel.writeLong(this.f2880f);
        parcel.writeLong(this.f2881g);
        parcel.writeLong(this.f2882h);
        parcel.writeLong(this.f2883i);
        parcel.writeString(this.f2884j);
        parcel.writeLong(this.f2885k);
        parcel.writeByte(this.f2886l ? (byte) 1 : (byte) 0);
        parcel.writeString(this.f2887m);
        parcel.writeInt(this.f2890p);
        parcel.writeInt(this.f2891q);
        C3403z.m2304b(parcel, this.f2892r);
        C3403z.m2304b(parcel, this.f2893s);
        parcel.writeString(this.f2888n);
        parcel.writeInt(this.f2889o);
    }
}