package com.tencent.bugly.crashreport.crash;

import android.content.Context;
import com.tencent.bugly.crashreport.common.info.C3337a;
import com.tencent.bugly.crashreport.common.info.C3338b;
import com.tencent.bugly.crashreport.common.strategy.C3340a;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.proguard.C3400w;
import com.tencent.bugly.proguard.C3401x;
import com.tencent.bugly.proguard.C3402y;
import com.tencent.bugly.proguard.C3403z;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.crashreport.crash.d */
/* loaded from: classes3.dex */
public final class C3352d {

    /* renamed from: a */
    private static C3352d f3167a;

    /* renamed from: b */
    private C3340a f3168b;

    /* renamed from: c */
    private C3337a f3169c;

    /* renamed from: d */
    private C3350b f3170d;

    /* renamed from: e */
    private Context f3171e;

    /* renamed from: a */
    static /* synthetic */ void m2022a(C3352d c3352d) {
        C3401x.m2251c("[ExtraCrashManager] Trying to notify Bugly agents.", new Object[0]);
        try {
            Class<?> cls = Class.forName("com.tencent.bugly.agent.GameAgent");
            c3352d.f3169c.getClass();
            C3403z.m2290a(cls, "sdkPackageName", "com.tencent.bugly", null);
            C3401x.m2251c("[ExtraCrashManager] Bugly game agent has been notified.", new Object[0]);
        } catch (Throwable unused) {
            C3401x.m2246a("[ExtraCrashManager] no game agent", new Object[0]);
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m2023a(C3352d c3352d, Thread thread, int i, String str, String str2, String str3, Map map) {
        String str4;
        String str5;
        String str6;
        Thread currentThread = thread == null ? Thread.currentThread() : thread;
        if (i == 4) {
            str4 = "Unity";
        } else if (i == 5 || i == 6) {
            str4 = "Cocos";
        } else {
            if (i != 8) {
                C3401x.m2252d("[ExtraCrashManager] Unknown extra crash type: %d", Integer.valueOf(i));
                return;
            }
            str4 = "H5";
        }
        C3401x.m2253e("[ExtraCrashManager] %s Crash Happen", str4);
        try {
            if (!c3352d.f3168b.m1936b()) {
                C3401x.m2252d("[ExtraCrashManager] There is no remote strategy, but still store it.", new Object[0]);
            }
            StrategyBean m1937c = c3352d.f3168b.m1937c();
            if (!m1937c.f3000e && c3352d.f3168b.m1936b()) {
                C3401x.m2253e("[ExtraCrashManager] Crash report was closed by remote , will not upload to Bugly , print local for helpful!", new Object[0]);
                C3350b.m1974a(str4, C3403z.m2277a(), c3352d.f3169c.f2970d, currentThread.getName(), str + "\n" + str2 + "\n" + str3, null);
                C3401x.m2253e("[ExtraCrashManager] Successfully handled.", new Object[0]);
                return;
            }
            if (i == 5 || i == 6) {
                if (!m1937c.f3005j) {
                    C3401x.m2253e("[ExtraCrashManager] %s report is disabled.", str4);
                    C3401x.m2253e("[ExtraCrashManager] Successfully handled.", new Object[0]);
                    return;
                }
            } else if (i == 8 && !m1937c.f3006k) {
                C3401x.m2253e("[ExtraCrashManager] %s report is disabled.", str4);
                C3401x.m2253e("[ExtraCrashManager] Successfully handled.", new Object[0]);
                return;
            }
            int i2 = i != 8 ? i : 5;
            CrashDetailBean crashDetailBean = new CrashDetailBean();
            crashDetailBean.f3036C = C3338b.m1912g();
            crashDetailBean.f3037D = C3338b.m1908e();
            crashDetailBean.f3038E = C3338b.m1916i();
            crashDetailBean.f3039F = c3352d.f3169c.m1883k();
            crashDetailBean.f3040G = c3352d.f3169c.m1882j();
            crashDetailBean.f3041H = c3352d.f3169c.m1884l();
            crashDetailBean.f3080w = C3403z.m2279a(c3352d.f3171e, C3351c.f3137e, (String) null);
            crashDetailBean.f3059b = i2;
            crashDetailBean.f3062e = c3352d.f3169c.m1880h();
            crashDetailBean.f3063f = c3352d.f3169c.f2977k;
            crashDetailBean.f3064g = c3352d.f3169c.m1889q();
            crashDetailBean.f3070m = c3352d.f3169c.m1878g();
            crashDetailBean.f3071n = str;
            crashDetailBean.f3072o = str2;
            str5 = "";
            if (str3 != null) {
                String[] split = str3.split("\n");
                str5 = split.length > 0 ? split[0] : "";
                str6 = str3;
            } else {
                str6 = "";
            }
            crashDetailBean.f3073p = str5;
            crashDetailBean.f3074q = str6;
            crashDetailBean.f3075r = System.currentTimeMillis();
            crashDetailBean.f3078u = C3403z.m2284a(crashDetailBean.f3074q.getBytes());
            crashDetailBean.f3083z = C3403z.m2287a(C3351c.f3138f, false);
            crashDetailBean.f3034A = c3352d.f3169c.f2970d;
            crashDetailBean.f3035B = currentThread.getName() + "(" + currentThread.getId() + ")";
            crashDetailBean.f3042I = c3352d.f3169c.m1891s();
            crashDetailBean.f3065h = c3352d.f3169c.m1888p();
            crashDetailBean.f3046M = c3352d.f3169c.f2952a;
            crashDetailBean.f3047N = c3352d.f3169c.m1864a();
            if (!C3351c.m1990a().m2014o()) {
                c3352d.f3170d.m1988d(crashDetailBean);
            }
            crashDetailBean.f3050Q = c3352d.f3169c.m1898z();
            crashDetailBean.f3051R = c3352d.f3169c.m1856A();
            crashDetailBean.f3052S = c3352d.f3169c.m1892t();
            crashDetailBean.f3053T = c3352d.f3169c.m1897y();
            crashDetailBean.f3082y = C3402y.m2259a();
            if (crashDetailBean.f3048O == null) {
                crashDetailBean.f3048O = new LinkedHashMap();
            }
            if (map != null) {
                crashDetailBean.f3048O.putAll(map);
            }
            C3350b.m1974a(str4, C3403z.m2277a(), c3352d.f3169c.f2970d, currentThread.getName(), str + "\n" + str2 + "\n" + str3, crashDetailBean);
            if (!c3352d.f3170d.m1985a(crashDetailBean)) {
                c3352d.f3170d.m1983a(crashDetailBean, 3000L, false);
            }
            C3401x.m2253e("[ExtraCrashManager] Successfully handled.", new Object[0]);
        } catch (Throwable th) {
            try {
                if (!C3401x.m2247a(th)) {
                    th.printStackTrace();
                }
                C3401x.m2253e("[ExtraCrashManager] Successfully handled.", new Object[0]);
            } catch (Throwable th2) {
                C3401x.m2253e("[ExtraCrashManager] Successfully handled.", new Object[0]);
                throw th2;
            }
        }
    }

    private C3352d(Context context) {
        C3351c m1990a = C3351c.m1990a();
        if (m1990a == null) {
            return;
        }
        this.f3168b = C3340a.m1927a();
        this.f3169c = C3337a.m1854a(context);
        this.f3170d = m1990a.f3149p;
        this.f3171e = context;
        C3400w.m2238a().m2240a(new Runnable() { // from class: com.tencent.bugly.crashreport.crash.d.1
            @Override // java.lang.Runnable
            public final void run() {
                C3352d.m2022a(C3352d.this);
            }
        });
    }

    /* renamed from: a */
    public static C3352d m2021a(Context context) {
        if (f3167a == null) {
            f3167a = new C3352d(context);
        }
        return f3167a;
    }

    /* renamed from: a */
    public static void m2024a(final Thread thread, final int i, final String str, final String str2, final String str3, final Map<String, String> map) {
        C3400w.m2238a().m2240a(new Runnable() { // from class: com.tencent.bugly.crashreport.crash.d.2
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    if (C3352d.f3167a != null) {
                        C3352d.m2023a(C3352d.f3167a, thread, i, str, str2, str3, map);
                    } else {
                        C3401x.m2253e("[ExtraCrashManager] Extra crash manager has not been initialized.", new Object[0]);
                    }
                } catch (Throwable th) {
                    if (!C3401x.m2250b(th)) {
                        th.printStackTrace();
                    }
                    C3401x.m2253e("[ExtraCrashManager] Crash error %s %s %s", str, str2, str3);
                }
            }
        });
    }
}