package com.tencent.bugly.crashreport.common.strategy;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.drm.DefaultDrmSessionManager;
import com.tencent.bugly.proguard.C3403z;
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

    /* renamed from: a */
    public static String f2996a = "https://android.bugly.qq.com/rqd/async";

    /* renamed from: b */
    public static String f2997b = "https://android.bugly.qq.com/rqd/async";

    /* renamed from: c */
    public long f2998c;

    /* renamed from: d */
    public long f2999d;

    /* renamed from: e */
    public boolean f3000e;

    /* renamed from: f */
    public boolean f3001f;

    /* renamed from: g */
    public boolean f3002g;

    /* renamed from: h */
    public boolean f3003h;

    /* renamed from: i */
    public boolean f3004i;

    /* renamed from: j */
    public boolean f3005j;

    /* renamed from: k */
    public boolean f3006k;

    /* renamed from: l */
    public boolean f3007l;

    /* renamed from: m */
    public boolean f3008m;

    /* renamed from: n */
    public long f3009n;

    /* renamed from: o */
    public long f3010o;

    /* renamed from: p */
    public String f3011p;

    /* renamed from: q */
    public String f3012q;

    /* renamed from: r */
    public String f3013r;

    /* renamed from: s */
    public Map<String, String> f3014s;

    /* renamed from: t */
    public int f3015t;

    /* renamed from: u */
    public long f3016u;

    /* renamed from: v */
    public long f3017v;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public StrategyBean() {
        this.f2998c = -1L;
        this.f2999d = -1L;
        this.f3000e = true;
        this.f3001f = true;
        this.f3002g = true;
        this.f3003h = true;
        this.f3004i = false;
        this.f3005j = true;
        this.f3006k = true;
        this.f3007l = true;
        this.f3008m = true;
        this.f3010o = 30000L;
        this.f3011p = f2996a;
        this.f3012q = f2997b;
        this.f3015t = 10;
        this.f3016u = DefaultDrmSessionManager.DEFAULT_SESSION_KEEPALIVE_MS;
        this.f3017v = -1L;
        this.f2999d = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        sb.append("S(@L@L").append("@)");
        sb.toString();
        sb.setLength(0);
        sb.append("*^@K#K").append("@!");
        this.f3013r = sb.toString();
    }

    public StrategyBean(Parcel parcel) {
        this.f2998c = -1L;
        this.f2999d = -1L;
        boolean z = true;
        this.f3000e = true;
        this.f3001f = true;
        this.f3002g = true;
        this.f3003h = true;
        this.f3004i = false;
        this.f3005j = true;
        this.f3006k = true;
        this.f3007l = true;
        this.f3008m = true;
        this.f3010o = 30000L;
        this.f3011p = f2996a;
        this.f3012q = f2997b;
        this.f3015t = 10;
        this.f3016u = DefaultDrmSessionManager.DEFAULT_SESSION_KEEPALIVE_MS;
        this.f3017v = -1L;
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("S(@L@L").append("@)");
            sb.toString();
            this.f2999d = parcel.readLong();
            this.f3000e = parcel.readByte() == 1;
            this.f3001f = parcel.readByte() == 1;
            this.f3002g = parcel.readByte() == 1;
            this.f3011p = parcel.readString();
            this.f3012q = parcel.readString();
            this.f3013r = parcel.readString();
            this.f3014s = C3403z.m2302b(parcel);
            this.f3003h = parcel.readByte() == 1;
            this.f3004i = parcel.readByte() == 1;
            this.f3007l = parcel.readByte() == 1;
            this.f3008m = parcel.readByte() == 1;
            this.f3010o = parcel.readLong();
            this.f3005j = parcel.readByte() == 1;
            if (parcel.readByte() != 1) {
                z = false;
            }
            this.f3006k = z;
            this.f3009n = parcel.readLong();
            this.f3015t = parcel.readInt();
            this.f3016u = parcel.readLong();
            this.f3017v = parcel.readLong();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.f2999d);
        parcel.writeByte(this.f3000e ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f3001f ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f3002g ? (byte) 1 : (byte) 0);
        parcel.writeString(this.f3011p);
        parcel.writeString(this.f3012q);
        parcel.writeString(this.f3013r);
        C3403z.m2304b(parcel, this.f3014s);
        parcel.writeByte(this.f3003h ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f3004i ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f3007l ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f3008m ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.f3010o);
        parcel.writeByte(this.f3005j ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f3006k ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.f3009n);
        parcel.writeInt(this.f3015t);
        parcel.writeLong(this.f3016u);
        parcel.writeLong(this.f3017v);
    }
}