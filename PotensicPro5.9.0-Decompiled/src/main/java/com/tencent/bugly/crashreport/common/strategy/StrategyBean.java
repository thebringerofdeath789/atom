package com.tencent.bugly.crashreport.common.strategy;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.drm.DefaultDrmSessionManager;
import com.tencent.bugly.proguard.z;
import java.util.Map;

/* compiled from: BUGLY */
/* loaded from: classes3.dex */
public class StrategyBean implements Parcelable {
    public static final Parcelable.Creator<StrategyBean> CREATOR = new Parcelable.Creator<StrategyBean>() { // from class: com.tencent.bugly.crashreport.common.strategy.StrategyBean.1
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ StrategyBean createFromParcel(Parcel parcel) {
            return new StrategyBean(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ StrategyBean[] newArray(int i) {
            return new StrategyBean[i];
        }
    };
    public static String a = "https://android.bugly.qq.com/rqd/async";
    public static String b = "https://android.bugly.qq.com/rqd/async";
    public long c;
    public long d;
    public boolean e;
    public boolean f;
    public boolean g;
    public boolean h;
    public boolean i;
    public boolean j;
    public boolean k;
    public boolean l;
    public boolean m;
    public long n;
    public long o;
    public String p;
    public String q;
    public String r;
    public Map<String, String> s;
    public int t;
    public long u;
    public long v;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public StrategyBean() {
        this.c = -1L;
        this.d = -1L;
        this.e = true;
        this.f = true;
        this.g = true;
        this.h = true;
        this.i = false;
        this.j = true;
        this.k = true;
        this.l = true;
        this.m = true;
        this.o = 30000L;
        this.p = a;
        this.q = b;
        this.t = 10;
        this.u = DefaultDrmSessionManager.DEFAULT_SESSION_KEEPALIVE_MS;
        this.v = -1L;
        this.d = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        sb.append("S(@L@L").append("@)");
        sb.toString();
        sb.setLength(0);
        sb.append("*^@K#K").append("@!");
        this.r = sb.toString();
    }

    public StrategyBean(Parcel parcel) {
        this.c = -1L;
        this.d = -1L;
        boolean z = true;
        this.e = true;
        this.f = true;
        this.g = true;
        this.h = true;
        this.i = false;
        this.j = true;
        this.k = true;
        this.l = true;
        this.m = true;
        this.o = 30000L;
        this.p = a;
        this.q = b;
        this.t = 10;
        this.u = DefaultDrmSessionManager.DEFAULT_SESSION_KEEPALIVE_MS;
        this.v = -1L;
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("S(@L@L").append("@)");
            sb.toString();
            this.d = parcel.readLong();
            this.e = parcel.readByte() == 1;
            this.f = parcel.readByte() == 1;
            this.g = parcel.readByte() == 1;
            this.p = parcel.readString();
            this.q = parcel.readString();
            this.r = parcel.readString();
            this.s = z.b(parcel);
            this.h = parcel.readByte() == 1;
            this.i = parcel.readByte() == 1;
            this.l = parcel.readByte() == 1;
            this.m = parcel.readByte() == 1;
            this.o = parcel.readLong();
            this.j = parcel.readByte() == 1;
            if (parcel.readByte() != 1) {
                z = false;
            }
            this.k = z;
            this.n = parcel.readLong();
            this.t = parcel.readInt();
            this.u = parcel.readLong();
            this.v = parcel.readLong();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.d);
        parcel.writeByte(this.e ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.g ? (byte) 1 : (byte) 0);
        parcel.writeString(this.p);
        parcel.writeString(this.q);
        parcel.writeString(this.r);
        z.b(parcel, this.s);
        parcel.writeByte(this.h ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.i ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.l ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.m ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.o);
        parcel.writeByte(this.j ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.k ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.n);
        parcel.writeInt(this.t);
        parcel.writeLong(this.u);
        parcel.writeLong(this.v);
    }
}
