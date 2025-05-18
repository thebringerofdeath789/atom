package com.tencent.bugly.crashreport.crash;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.bugly.crashreport.common.info.PlugInBean;
import com.tencent.bugly.proguard.C3403z;
import java.util.Map;
import java.util.UUID;

/* compiled from: BUGLY */
/* loaded from: classes3.dex */
public class CrashDetailBean implements Parcelable, Comparable<CrashDetailBean> {
    public static final Parcelable.Creator<CrashDetailBean> CREATOR = new Parcelable.Creator<CrashDetailBean>() { // from class: com.tencent.bugly.crashreport.crash.CrashDetailBean.1
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ CrashDetailBean createFromParcel(Parcel parcel) {
            return new CrashDetailBean(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ CrashDetailBean[] newArray(int i) {
            return new CrashDetailBean[i];
        }
    };

    /* renamed from: A */
    public String f3034A;

    /* renamed from: B */
    public String f3035B;

    /* renamed from: C */
    public long f3036C;

    /* renamed from: D */
    public long f3037D;

    /* renamed from: E */
    public long f3038E;

    /* renamed from: F */
    public long f3039F;

    /* renamed from: G */
    public long f3040G;

    /* renamed from: H */
    public long f3041H;

    /* renamed from: I */
    public String f3042I;

    /* renamed from: J */
    public String f3043J;

    /* renamed from: K */
    public String f3044K;

    /* renamed from: L */
    public String f3045L;

    /* renamed from: M */
    public long f3046M;

    /* renamed from: N */
    public boolean f3047N;

    /* renamed from: O */
    public Map<String, String> f3048O;

    /* renamed from: P */
    public Map<String, String> f3049P;

    /* renamed from: Q */
    public int f3050Q;

    /* renamed from: R */
    public int f3051R;

    /* renamed from: S */
    public Map<String, String> f3052S;

    /* renamed from: T */
    public Map<String, String> f3053T;

    /* renamed from: U */
    public byte[] f3054U;

    /* renamed from: V */
    public String f3055V;

    /* renamed from: W */
    public String f3056W;

    /* renamed from: X */
    private String f3057X;

    /* renamed from: a */
    public long f3058a;

    /* renamed from: b */
    public int f3059b;

    /* renamed from: c */
    public String f3060c;

    /* renamed from: d */
    public boolean f3061d;

    /* renamed from: e */
    public String f3062e;

    /* renamed from: f */
    public String f3063f;

    /* renamed from: g */
    public String f3064g;

    /* renamed from: h */
    public Map<String, PlugInBean> f3065h;

    /* renamed from: i */
    public Map<String, PlugInBean> f3066i;

    /* renamed from: j */
    public boolean f3067j;

    /* renamed from: k */
    public boolean f3068k;

    /* renamed from: l */
    public int f3069l;

    /* renamed from: m */
    public String f3070m;

    /* renamed from: n */
    public String f3071n;

    /* renamed from: o */
    public String f3072o;

    /* renamed from: p */
    public String f3073p;

    /* renamed from: q */
    public String f3074q;

    /* renamed from: r */
    public long f3075r;

    /* renamed from: s */
    public String f3076s;

    /* renamed from: t */
    public int f3077t;

    /* renamed from: u */
    public String f3078u;

    /* renamed from: v */
    public String f3079v;

    /* renamed from: w */
    public String f3080w;

    /* renamed from: x */
    public String f3081x;

    /* renamed from: y */
    public byte[] f3082y;

    /* renamed from: z */
    public Map<String, String> f3083z;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(CrashDetailBean crashDetailBean) {
        CrashDetailBean crashDetailBean2 = crashDetailBean;
        if (crashDetailBean2 == null) {
            return 1;
        }
        long j = this.f3075r - crashDetailBean2.f3075r;
        if (j <= 0) {
            return j < 0 ? -1 : 0;
        }
        return 1;
    }

    public CrashDetailBean() {
        this.f3058a = -1L;
        this.f3059b = 0;
        this.f3060c = UUID.randomUUID().toString();
        this.f3061d = false;
        this.f3062e = "";
        this.f3063f = "";
        this.f3064g = "";
        this.f3065h = null;
        this.f3066i = null;
        this.f3067j = false;
        this.f3068k = false;
        this.f3069l = 0;
        this.f3070m = "";
        this.f3071n = "";
        this.f3072o = "";
        this.f3073p = "";
        this.f3074q = "";
        this.f3075r = -1L;
        this.f3076s = null;
        this.f3077t = 0;
        this.f3078u = "";
        this.f3079v = "";
        this.f3080w = null;
        this.f3081x = null;
        this.f3082y = null;
        this.f3083z = null;
        this.f3034A = "";
        this.f3035B = "";
        this.f3036C = -1L;
        this.f3037D = -1L;
        this.f3038E = -1L;
        this.f3039F = -1L;
        this.f3040G = -1L;
        this.f3041H = -1L;
        this.f3042I = "";
        this.f3057X = "";
        this.f3043J = "";
        this.f3044K = "";
        this.f3045L = "";
        this.f3046M = -1L;
        this.f3047N = false;
        this.f3048O = null;
        this.f3049P = null;
        this.f3050Q = -1;
        this.f3051R = -1;
        this.f3052S = null;
        this.f3053T = null;
        this.f3054U = null;
        this.f3055V = null;
        this.f3056W = null;
    }

    public CrashDetailBean(Parcel parcel) {
        this.f3058a = -1L;
        this.f3059b = 0;
        this.f3060c = UUID.randomUUID().toString();
        this.f3061d = false;
        this.f3062e = "";
        this.f3063f = "";
        this.f3064g = "";
        this.f3065h = null;
        this.f3066i = null;
        this.f3067j = false;
        this.f3068k = false;
        this.f3069l = 0;
        this.f3070m = "";
        this.f3071n = "";
        this.f3072o = "";
        this.f3073p = "";
        this.f3074q = "";
        this.f3075r = -1L;
        this.f3076s = null;
        this.f3077t = 0;
        this.f3078u = "";
        this.f3079v = "";
        this.f3080w = null;
        this.f3081x = null;
        this.f3082y = null;
        this.f3083z = null;
        this.f3034A = "";
        this.f3035B = "";
        this.f3036C = -1L;
        this.f3037D = -1L;
        this.f3038E = -1L;
        this.f3039F = -1L;
        this.f3040G = -1L;
        this.f3041H = -1L;
        this.f3042I = "";
        this.f3057X = "";
        this.f3043J = "";
        this.f3044K = "";
        this.f3045L = "";
        this.f3046M = -1L;
        this.f3047N = false;
        this.f3048O = null;
        this.f3049P = null;
        this.f3050Q = -1;
        this.f3051R = -1;
        this.f3052S = null;
        this.f3053T = null;
        this.f3054U = null;
        this.f3055V = null;
        this.f3056W = null;
        this.f3059b = parcel.readInt();
        this.f3060c = parcel.readString();
        this.f3061d = parcel.readByte() == 1;
        this.f3062e = parcel.readString();
        this.f3063f = parcel.readString();
        this.f3064g = parcel.readString();
        this.f3067j = parcel.readByte() == 1;
        this.f3068k = parcel.readByte() == 1;
        this.f3069l = parcel.readInt();
        this.f3070m = parcel.readString();
        this.f3071n = parcel.readString();
        this.f3072o = parcel.readString();
        this.f3073p = parcel.readString();
        this.f3074q = parcel.readString();
        this.f3075r = parcel.readLong();
        this.f3076s = parcel.readString();
        this.f3077t = parcel.readInt();
        this.f3078u = parcel.readString();
        this.f3079v = parcel.readString();
        this.f3080w = parcel.readString();
        this.f3083z = C3403z.m2302b(parcel);
        this.f3034A = parcel.readString();
        this.f3035B = parcel.readString();
        this.f3036C = parcel.readLong();
        this.f3037D = parcel.readLong();
        this.f3038E = parcel.readLong();
        this.f3039F = parcel.readLong();
        this.f3040G = parcel.readLong();
        this.f3041H = parcel.readLong();
        this.f3042I = parcel.readString();
        this.f3057X = parcel.readString();
        this.f3043J = parcel.readString();
        this.f3044K = parcel.readString();
        this.f3045L = parcel.readString();
        this.f3046M = parcel.readLong();
        this.f3047N = parcel.readByte() == 1;
        this.f3048O = C3403z.m2302b(parcel);
        this.f3065h = C3403z.m2288a(parcel);
        this.f3066i = C3403z.m2288a(parcel);
        this.f3050Q = parcel.readInt();
        this.f3051R = parcel.readInt();
        this.f3052S = C3403z.m2302b(parcel);
        this.f3053T = C3403z.m2302b(parcel);
        this.f3054U = parcel.createByteArray();
        this.f3082y = parcel.createByteArray();
        this.f3055V = parcel.readString();
        this.f3056W = parcel.readString();
        this.f3081x = parcel.readString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f3059b);
        parcel.writeString(this.f3060c);
        parcel.writeByte(this.f3061d ? (byte) 1 : (byte) 0);
        parcel.writeString(this.f3062e);
        parcel.writeString(this.f3063f);
        parcel.writeString(this.f3064g);
        parcel.writeByte(this.f3067j ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f3068k ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.f3069l);
        parcel.writeString(this.f3070m);
        parcel.writeString(this.f3071n);
        parcel.writeString(this.f3072o);
        parcel.writeString(this.f3073p);
        parcel.writeString(this.f3074q);
        parcel.writeLong(this.f3075r);
        parcel.writeString(this.f3076s);
        parcel.writeInt(this.f3077t);
        parcel.writeString(this.f3078u);
        parcel.writeString(this.f3079v);
        parcel.writeString(this.f3080w);
        C3403z.m2304b(parcel, this.f3083z);
        parcel.writeString(this.f3034A);
        parcel.writeString(this.f3035B);
        parcel.writeLong(this.f3036C);
        parcel.writeLong(this.f3037D);
        parcel.writeLong(this.f3038E);
        parcel.writeLong(this.f3039F);
        parcel.writeLong(this.f3040G);
        parcel.writeLong(this.f3041H);
        parcel.writeString(this.f3042I);
        parcel.writeString(this.f3057X);
        parcel.writeString(this.f3043J);
        parcel.writeString(this.f3044K);
        parcel.writeString(this.f3045L);
        parcel.writeLong(this.f3046M);
        parcel.writeByte(this.f3047N ? (byte) 1 : (byte) 0);
        C3403z.m2304b(parcel, this.f3048O);
        C3403z.m2289a(parcel, this.f3065h);
        C3403z.m2289a(parcel, this.f3066i);
        parcel.writeInt(this.f3050Q);
        parcel.writeInt(this.f3051R);
        C3403z.m2304b(parcel, this.f3052S);
        C3403z.m2304b(parcel, this.f3053T);
        parcel.writeByteArray(this.f3054U);
        parcel.writeByteArray(this.f3082y);
        parcel.writeString(this.f3055V);
        parcel.writeString(this.f3056W);
        parcel.writeString(this.f3081x);
    }
}