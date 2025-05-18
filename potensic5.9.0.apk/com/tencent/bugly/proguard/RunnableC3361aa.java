package com.tencent.bugly.proguard;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.aa */
/* loaded from: classes3.dex */
public final class RunnableC3361aa implements Runnable {

    /* renamed from: a */
    private final Handler f3233a;

    /* renamed from: b */
    private final String f3234b;

    /* renamed from: c */
    private long f3235c;

    /* renamed from: d */
    private final long f3236d;

    /* renamed from: e */
    private boolean f3237e = true;

    /* renamed from: f */
    private long f3238f;

    RunnableC3361aa(Handler handler, String str, long j) {
        this.f3233a = handler;
        this.f3234b = str;
        this.f3235c = j;
        this.f3236d = j;
    }

    /* renamed from: a */
    public final void m2078a() {
        if (this.f3237e) {
            this.f3237e = false;
            this.f3238f = SystemClock.uptimeMillis();
            this.f3233a.post(this);
        }
    }

    /* renamed from: b */
    public final boolean m2080b() {
        return !this.f3237e && SystemClock.uptimeMillis() > this.f3238f + this.f3235c;
    }

    /* renamed from: c */
    public final int m2081c() {
        if (this.f3237e) {
            return 0;
        }
        return SystemClock.uptimeMillis() - this.f3238f < this.f3235c ? 1 : 3;
    }

    /* renamed from: d */
    public final String m2082d() {
        return this.f3234b;
    }

    /* renamed from: e */
    public final Looper m2083e() {
        return this.f3233a.getLooper();
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f3237e = true;
        this.f3235c = this.f3236d;
    }

    /* renamed from: a */
    public final void m2079a(long j) {
        this.f3235c = Long.MAX_VALUE;
    }
}