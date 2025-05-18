package com.tencent.bugly.crashreport.crash;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.crashreport.crash.a */
/* loaded from: classes3.dex */
public final class C3343a implements Comparable<C3343a> {

    /* renamed from: a */
    public long f3084a = -1;

    /* renamed from: b */
    public long f3085b = -1;

    /* renamed from: c */
    public String f3086c = null;

    /* renamed from: d */
    public boolean f3087d = false;

    /* renamed from: e */
    public boolean f3088e = false;

    /* renamed from: f */
    public int f3089f = 0;

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(C3343a c3343a) {
        C3343a c3343a2 = c3343a;
        if (c3343a2 == null) {
            return 1;
        }
        long j = this.f3085b - c3343a2.f3085b;
        if (j <= 0) {
            return j < 0 ? -1 : 0;
        }
        return 1;
    }
}