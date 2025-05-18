package com.tencent.bugly.crashreport.crash;

import android.content.Context;
import com.ipotensic.baselib.netty.Constant;
import com.tencent.bugly.BuglyStrategy;
import com.tencent.bugly.crashreport.common.info.AppInfo;
import com.tencent.bugly.crashreport.common.info.C3337a;
import com.tencent.bugly.crashreport.common.strategy.C3340a;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.crashreport.crash.anr.C3349b;
import com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler;
import com.tencent.bugly.proguard.C3393p;
import com.tencent.bugly.proguard.C3395r;
import com.tencent.bugly.proguard.C3398u;
import com.tencent.bugly.proguard.C3400w;
import com.tencent.bugly.proguard.C3401x;
import com.tencent.bugly.proguard.C3403z;
import com.tencent.bugly.proguard.InterfaceC3392o;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.crashreport.crash.c */
/* loaded from: classes3.dex */
public final class C3351c {

    /* renamed from: a */
    public static int f3133a = 0;

    /* renamed from: b */
    public static boolean f3134b = false;

    /* renamed from: c */
    public static int f3135c = 2;

    /* renamed from: d */
    public static boolean f3136d = true;

    /* renamed from: e */
    public static int f3137e = 20480;

    /* renamed from: f */
    public static int f3138f = 20480;

    /* renamed from: g */
    public static long f3139g = 604800000;

    /* renamed from: h */
    public static String f3140h = null;

    /* renamed from: i */
    public static boolean f3141i = false;

    /* renamed from: j */
    public static String f3142j = null;

    /* renamed from: k */
    public static int f3143k = 5000;

    /* renamed from: l */
    public static boolean f3144l = true;

    /* renamed from: m */
    public static boolean f3145m = false;

    /* renamed from: n */
    public static String f3146n;

    /* renamed from: o */
    public static String f3147o;

    /* renamed from: r */
    private static C3351c f3148r;

    /* renamed from: p */
    public final C3350b f3149p;

    /* renamed from: q */
    private final Context f3150q;

    /* renamed from: s */
    private final C3353e f3151s;

    /* renamed from: t */
    private final NativeCrashHandler f3152t;

    /* renamed from: u */
    private C3340a f3153u;

    /* renamed from: v */
    private C3400w f3154v;

    /* renamed from: w */
    private final C3349b f3155w;

    /* renamed from: x */
    private Boolean f3156x;

    /* renamed from: y */
    private int f3157y = 31;

    /* renamed from: z */
    private boolean f3158z = false;

    private C3351c(int i, Context context, C3400w c3400w, boolean z, BuglyStrategy.C3327a c3327a, InterfaceC3392o interfaceC3392o, String str) {
        f3133a = i;
        Context m2271a = C3403z.m2271a(context);
        this.f3150q = m2271a;
        this.f3153u = C3340a.m1927a();
        this.f3154v = c3400w;
        C3398u m2219a = C3398u.m2219a();
        C3393p m2187a = C3393p.m2187a();
        C3350b c3350b = new C3350b(i, m2271a, m2219a, m2187a, this.f3153u, c3327a, interfaceC3392o);
        this.f3149p = c3350b;
        C3337a m1854a = C3337a.m1854a(m2271a);
        this.f3151s = new C3353e(m2271a, c3350b, this.f3153u, m1854a);
        NativeCrashHandler nativeCrashHandler = NativeCrashHandler.getInstance(m2271a, m1854a, c3350b, this.f3153u, c3400w, z, str);
        this.f3152t = nativeCrashHandler;
        m1854a.f2931E = nativeCrashHandler;
        this.f3155w = C3349b.m1950a(m2271a, this.f3153u, m1854a, c3400w, m2187a, c3350b, c3327a);
    }

    /* renamed from: a */
    public static synchronized C3351c m1991a(int i, Context context, boolean z, BuglyStrategy.C3327a c3327a, InterfaceC3392o interfaceC3392o, String str) {
        C3351c c3351c;
        synchronized (C3351c.class) {
            if (f3148r == null) {
                f3148r = new C3351c(1004, context, C3400w.m2238a(), z, c3327a, null, null);
            }
            c3351c = f3148r;
        }
        return c3351c;
    }

    /* renamed from: a */
    public static synchronized C3351c m1990a() {
        C3351c c3351c;
        synchronized (C3351c.class) {
            c3351c = f3148r;
        }
        return c3351c;
    }

    /* renamed from: a */
    public final void m1996a(StrategyBean strategyBean) {
        this.f3151s.m2031a(strategyBean);
        this.f3152t.onStrategyChanged(strategyBean);
        this.f3155w.m1968c();
        C3400w.m2238a().m2241a(new AnonymousClass2(), 3000L);
    }

    /* renamed from: b */
    public final boolean m2001b() {
        Boolean bool = this.f3156x;
        if (bool != null) {
            return bool.booleanValue();
        }
        String str = C3337a.m1855b().f2970d;
        List<C3395r> m2204a = C3393p.m2187a().m2204a(1);
        ArrayList arrayList = new ArrayList();
        if (m2204a != null && m2204a.size() > 0) {
            for (C3395r c3395r : m2204a) {
                if (str.equals(c3395r.f3429c)) {
                    this.f3156x = true;
                    arrayList.add(c3395r);
                }
            }
            if (arrayList.size() > 0) {
                C3393p.m2187a().m2206a(arrayList);
            }
            return true;
        }
        this.f3156x = false;
        return false;
    }

    /* renamed from: c */
    public final synchronized void m2002c() {
        this.f3151s.m2030a();
        this.f3152t.setUserOpened(true);
        this.f3155w.m1964a(true);
    }

    /* renamed from: d */
    public final synchronized void m2003d() {
        this.f3151s.m2033b();
        this.f3152t.setUserOpened(false);
        this.f3155w.m1964a(false);
    }

    /* renamed from: e */
    public final void m2004e() {
        this.f3151s.m2030a();
    }

    /* renamed from: f */
    public final void m2005f() {
        this.f3152t.setUserOpened(false);
    }

    /* renamed from: g */
    public final void m2006g() {
        this.f3152t.setUserOpened(true);
    }

    /* renamed from: h */
    public final void m2007h() {
        this.f3155w.m1964a(true);
    }

    /* renamed from: i */
    public final void m2008i() {
        this.f3155w.m1964a(false);
    }

    /* renamed from: j */
    public final void m2009j() {
        this.f3152t.enableCatchAnrTrace();
    }

    /* renamed from: a */
    public final synchronized void m2000a(boolean z, boolean z2, boolean z3) {
        this.f3152t.testNativeCrash(z, z2, z3);
    }

    /* renamed from: k */
    public final synchronized void m2010k() {
        int i = 0;
        while (true) {
            int i2 = i + 1;
            if (i < 30) {
                try {
                    C3401x.m2246a("try main sleep for make a test anr! try:%d/30 , kill it if you don't want to wait!", Integer.valueOf(i2));
                    C3403z.m2303b(5000L);
                    i = i2;
                } catch (Throwable th) {
                    if (C3401x.m2247a(th)) {
                        return;
                    }
                    th.printStackTrace();
                    return;
                }
            }
        }
    }

    /* renamed from: l */
    public final boolean m2011l() {
        return this.f3155w.m1965a();
    }

    /* renamed from: a */
    public final void m1998a(final Thread thread, final Throwable th, boolean z, String str, byte[] bArr, final boolean z2) {
        final boolean z3 = false;
        final String str2 = null;
        final byte[] bArr2 = null;
        this.f3154v.m2240a(new Runnable() { // from class: com.tencent.bugly.crashreport.crash.c.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    C3401x.m2251c("post a throwable %b", Boolean.valueOf(z3));
                    C3351c.this.f3151s.m2032a(thread, th, false, str2, bArr2);
                    if (z2) {
                        C3401x.m2246a("clear user datas", new Object[0]);
                        C3337a.m1854a(C3351c.this.f3150q).m1893u();
                    }
                } catch (Throwable th2) {
                    if (!C3401x.m2250b(th2)) {
                        th2.printStackTrace();
                    }
                    C3401x.m2253e("java catch error: %s", th.toString());
                }
            }
        });
    }

    /* renamed from: a */
    public final void m1997a(CrashDetailBean crashDetailBean) {
        this.f3149p.m1989e(crashDetailBean);
    }

    /* compiled from: BUGLY */
    /* renamed from: com.tencent.bugly.crashreport.crash.c$2, reason: invalid class name */
    final class AnonymousClass2 extends Thread {
        AnonymousClass2() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            List<CrashDetailBean> list;
            if (C3403z.m2291a(C3351c.this.f3150q, "local_crash_lock", Constant.DELAY_MILLIS)) {
                List<CrashDetailBean> m1982a = C3351c.this.f3149p.m1982a();
                if (m1982a != null && m1982a.size() > 0) {
                    C3401x.m2251c("Size of crash list: %s", Integer.valueOf(m1982a.size()));
                    int size = m1982a.size();
                    if (size > 20) {
                        ArrayList arrayList = new ArrayList();
                        Collections.sort(m1982a);
                        for (int i = 0; i < 20; i++) {
                            arrayList.add(m1982a.get((size - 1) - i));
                        }
                        list = arrayList;
                    } else {
                        list = m1982a;
                    }
                    C3351c.this.f3149p.m1984a(list, 0L, false, false, false);
                }
                C3403z.m2306b(C3351c.this.f3150q, "local_crash_lock");
            }
        }
    }

    /* renamed from: a */
    public final void m1995a(long j) {
        C3400w.m2238a().m2241a(new AnonymousClass2(), j);
    }

    /* renamed from: m */
    public final void m2012m() {
        this.f3152t.checkUploadRecordCrash();
    }

    /* renamed from: n */
    public final void m2013n() {
        if (C3337a.m1855b().f2970d.equals(AppInfo.m1846a(this.f3150q))) {
            this.f3152t.removeEmptyNativeRecordFiles();
        }
    }

    /* renamed from: a */
    public final void m1994a(int i) {
        this.f3157y = i;
    }

    /* renamed from: a */
    public final void m1999a(boolean z) {
        this.f3158z = z;
    }

    /* renamed from: o */
    public final boolean m2014o() {
        return this.f3158z;
    }

    /* renamed from: p */
    public final boolean m2015p() {
        return (this.f3157y & 16) > 0;
    }

    /* renamed from: q */
    public final boolean m2016q() {
        return (this.f3157y & 8) > 0;
    }

    /* renamed from: r */
    public final boolean m2017r() {
        return (this.f3157y & 4) > 0;
    }

    /* renamed from: s */
    public final boolean m2018s() {
        return (this.f3157y & 2) > 0;
    }

    /* renamed from: t */
    public final boolean m2019t() {
        return (this.f3157y & 1) > 0;
    }
}