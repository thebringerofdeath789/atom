package com.tencent.bugly.crashreport.common.strategy;

import android.content.Context;
import com.tencent.bugly.AbstractC3328a;
import com.tencent.bugly.crashreport.biz.C3335b;
import com.tencent.bugly.crashreport.common.info.C3337a;
import com.tencent.bugly.proguard.C3376ap;
import com.tencent.bugly.proguard.C3393p;
import com.tencent.bugly.proguard.C3395r;
import com.tencent.bugly.proguard.C3400w;
import com.tencent.bugly.proguard.C3401x;
import com.tencent.bugly.proguard.C3403z;
import com.tencent.bugly.proguard.InterfaceC3392o;
import java.util.List;
import java.util.Map;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.crashreport.common.strategy.a */
/* loaded from: classes3.dex */
public final class C3340a {

    /* renamed from: a */
    public static int f3018a = 1000;

    /* renamed from: b */
    private static C3340a f3019b;

    /* renamed from: h */
    private static String f3020h;

    /* renamed from: c */
    private final List<AbstractC3328a> f3021c;

    /* renamed from: d */
    private final C3400w f3022d;

    /* renamed from: e */
    private final StrategyBean f3023e;

    /* renamed from: f */
    private StrategyBean f3024f = null;

    /* renamed from: g */
    private Context f3025g;

    private C3340a(Context context, List<AbstractC3328a> list) {
        String str;
        this.f3025g = context;
        if (C3337a.m1854a(context) != null) {
            String str2 = C3337a.m1854a(context).f2992z;
            if (!"oversea".equals(str2)) {
                str = "na_https".equals(str2) ? "https://astat.bugly.cros.wr.pvp.net/:8180/rqd/async" : "https://astat.bugly.qcloud.com/rqd/async";
            }
            StrategyBean.f2996a = str;
            StrategyBean.f2997b = str;
        }
        this.f3023e = new StrategyBean();
        this.f3021c = list;
        this.f3022d = C3400w.m2238a();
    }

    /* renamed from: a */
    public static synchronized C3340a m1928a(Context context, List<AbstractC3328a> list) {
        C3340a c3340a;
        synchronized (C3340a.class) {
            if (f3019b == null) {
                f3019b = new C3340a(context, list);
            }
            c3340a = f3019b;
        }
        return c3340a;
    }

    /* renamed from: a */
    public final void m1933a(long j) {
        this.f3022d.m2241a(new Thread() { // from class: com.tencent.bugly.crashreport.common.strategy.a.1
            @Override // java.lang.Thread, java.lang.Runnable
            public final void run() {
                try {
                    Map<String, byte[]> m2205a = C3393p.m2187a().m2205a(C3340a.f3018a, (InterfaceC3392o) null, true);
                    if (m2205a != null) {
                        byte[] bArr = m2205a.get("device");
                        byte[] bArr2 = m2205a.get("gateway");
                        if (bArr != null) {
                            C3337a.m1854a(C3340a.this.f3025g).m1875e(new String(bArr));
                        }
                        if (bArr2 != null) {
                            C3337a.m1854a(C3340a.this.f3025g).m1873d(new String(bArr2));
                        }
                    }
                    C3340a.this.f3024f = C3340a.m1931d();
                    if (C3340a.this.f3024f != null) {
                        if (C3403z.m2294a(C3340a.f3020h) || !C3403z.m2308c(C3340a.f3020h)) {
                            C3340a.this.f3024f.f3011p = StrategyBean.f2996a;
                            C3340a.this.f3024f.f3012q = StrategyBean.f2997b;
                        } else {
                            C3340a.this.f3024f.f3011p = C3340a.f3020h;
                            C3340a.this.f3024f.f3012q = C3340a.f3020h;
                        }
                    }
                } catch (Throwable th) {
                    if (!C3401x.m2247a(th)) {
                        th.printStackTrace();
                    }
                }
                C3340a c3340a = C3340a.this;
                c3340a.m1934a(c3340a.f3024f, false);
            }
        }, j);
    }

    /* renamed from: a */
    public static synchronized C3340a m1927a() {
        C3340a c3340a;
        synchronized (C3340a.class) {
            c3340a = f3019b;
        }
        return c3340a;
    }

    /* renamed from: b */
    public final synchronized boolean m1936b() {
        return this.f3024f != null;
    }

    /* renamed from: c */
    public final StrategyBean m1937c() {
        StrategyBean strategyBean = this.f3024f;
        if (strategyBean != null) {
            if (!C3403z.m2308c(strategyBean.f3011p)) {
                this.f3024f.f3011p = StrategyBean.f2996a;
            }
            if (!C3403z.m2308c(this.f3024f.f3012q)) {
                this.f3024f.f3012q = StrategyBean.f2997b;
            }
            return this.f3024f;
        }
        if (!C3403z.m2294a(f3020h) && C3403z.m2308c(f3020h)) {
            this.f3023e.f3011p = f3020h;
            this.f3023e.f3012q = f3020h;
        }
        return this.f3023e;
    }

    /* renamed from: a */
    protected final void m1934a(StrategyBean strategyBean, boolean z) {
        C3401x.m2251c("[Strategy] Notify %s", C3335b.class.getName());
        C3335b.m1829a(strategyBean, z);
        for (AbstractC3328a abstractC3328a : this.f3021c) {
            try {
                C3401x.m2251c("[Strategy] Notify %s", abstractC3328a.getClass().getName());
                abstractC3328a.onServerStrategyChanged(strategyBean);
            } catch (Throwable th) {
                if (!C3401x.m2247a(th)) {
                    th.printStackTrace();
                }
            }
        }
    }

    /* renamed from: a */
    public static void m1929a(String str) {
        if (C3403z.m2294a(str) || !C3403z.m2308c(str)) {
            C3401x.m2252d("URL user set is invalid.", new Object[0]);
        } else {
            f3020h = str;
        }
    }

    /* renamed from: a */
    public final void m1935a(C3376ap c3376ap) {
        if (c3376ap == null) {
            return;
        }
        if (this.f3024f == null || c3376ap.f3335h != this.f3024f.f3009n) {
            StrategyBean strategyBean = new StrategyBean();
            strategyBean.f3000e = c3376ap.f3328a;
            strategyBean.f3002g = c3376ap.f3330c;
            strategyBean.f3001f = c3376ap.f3329b;
            if (C3403z.m2294a(f3020h) || !C3403z.m2308c(f3020h)) {
                if (C3403z.m2308c(c3376ap.f3331d)) {
                    C3401x.m2251c("[Strategy] Upload url changes to %s", c3376ap.f3331d);
                    strategyBean.f3011p = c3376ap.f3331d;
                }
                if (C3403z.m2308c(c3376ap.f3332e)) {
                    C3401x.m2251c("[Strategy] Exception upload url changes to %s", c3376ap.f3332e);
                    strategyBean.f3012q = c3376ap.f3332e;
                }
            }
            if (c3376ap.f3333f != null && !C3403z.m2294a(c3376ap.f3333f.f3323a)) {
                strategyBean.f3013r = c3376ap.f3333f.f3323a;
            }
            if (c3376ap.f3335h != 0) {
                strategyBean.f3009n = c3376ap.f3335h;
            }
            if (c3376ap.f3334g != null && c3376ap.f3334g.size() > 0) {
                strategyBean.f3014s = c3376ap.f3334g;
                String str = c3376ap.f3334g.get("B11");
                if (str != null && str.equals("1")) {
                    strategyBean.f3003h = true;
                } else {
                    strategyBean.f3003h = false;
                }
                String str2 = c3376ap.f3334g.get("B3");
                if (str2 != null) {
                    strategyBean.f3017v = Long.valueOf(str2).longValue();
                }
                strategyBean.f3010o = c3376ap.f3336i;
                strategyBean.f3016u = c3376ap.f3336i;
                String str3 = c3376ap.f3334g.get("B27");
                if (str3 != null && str3.length() > 0) {
                    try {
                        int parseInt = Integer.parseInt(str3);
                        if (parseInt > 0) {
                            strategyBean.f3015t = parseInt;
                        }
                    } catch (Exception e) {
                        if (!C3401x.m2247a(e)) {
                            e.printStackTrace();
                        }
                    }
                }
                String str4 = c3376ap.f3334g.get("B25");
                if (str4 != null && str4.equals("1")) {
                    strategyBean.f3005j = true;
                } else {
                    strategyBean.f3005j = false;
                }
            }
            C3401x.m2246a("[Strategy] enableCrashReport:%b, enableQuery:%b, enableUserInfo:%b, enableAnr:%b, enableBlock:%b, enableSession:%b, enableSessionTimer:%b, sessionOverTime:%d, enableCocos:%b, strategyLastUpdateTime:%d", Boolean.valueOf(strategyBean.f3000e), Boolean.valueOf(strategyBean.f3002g), Boolean.valueOf(strategyBean.f3001f), Boolean.valueOf(strategyBean.f3003h), Boolean.valueOf(strategyBean.f3004i), Boolean.valueOf(strategyBean.f3007l), Boolean.valueOf(strategyBean.f3008m), Long.valueOf(strategyBean.f3010o), Boolean.valueOf(strategyBean.f3005j), Long.valueOf(strategyBean.f3009n));
            this.f3024f = strategyBean;
            if (!C3403z.m2308c(c3376ap.f3331d)) {
                C3401x.m2251c("[Strategy] download url is null", new Object[0]);
                this.f3024f.f3011p = "";
            }
            if (!C3403z.m2308c(c3376ap.f3332e)) {
                C3401x.m2251c("[Strategy] download crashurl is null", new Object[0]);
                this.f3024f.f3012q = "";
            }
            C3393p.m2187a().m2209b(2);
            C3395r c3395r = new C3395r();
            c3395r.f3428b = 2;
            c3395r.f3427a = strategyBean.f2998c;
            c3395r.f3431e = strategyBean.f2999d;
            c3395r.f3433g = C3403z.m2295a(strategyBean);
            C3393p.m2187a().m2208a(c3395r);
            m1934a(strategyBean, true);
        }
    }

    /* renamed from: d */
    public static StrategyBean m1931d() {
        List<C3395r> m2204a = C3393p.m2187a().m2204a(2);
        if (m2204a == null || m2204a.size() <= 0) {
            return null;
        }
        C3395r c3395r = m2204a.get(0);
        if (c3395r.f3433g != null) {
            return (StrategyBean) C3403z.m2276a(c3395r.f3433g, StrategyBean.CREATOR);
        }
        return null;
    }
}