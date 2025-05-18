package com.tencent.bugly.crashreport.biz;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import com.tencent.bugly.BuglyStrategy;
import com.tencent.bugly.crashreport.biz.C3334a.AnonymousClass2;
import com.tencent.bugly.crashreport.common.info.C3337a;
import com.tencent.bugly.crashreport.common.strategy.C3340a;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.proguard.C3400w;
import com.tencent.bugly.proguard.C3401x;
import com.tencent.bugly.proguard.C3403z;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.crashreport.biz.b */
/* loaded from: classes3.dex */
public class C3335b {

    /* renamed from: a */
    public static C3334a f2907a = null;

    /* renamed from: b */
    private static boolean f2908b = false;

    /* renamed from: c */
    private static int f2909c = 10;

    /* renamed from: d */
    private static long f2910d = 300000;

    /* renamed from: e */
    private static long f2911e = 30000;

    /* renamed from: f */
    private static long f2912f = 0;

    /* renamed from: g */
    private static int f2913g = 0;

    /* renamed from: h */
    private static long f2914h = 0;

    /* renamed from: i */
    private static long f2915i = 0;

    /* renamed from: j */
    private static long f2916j = 0;

    /* renamed from: k */
    private static Application.ActivityLifecycleCallbacks f2917k = null;

    /* renamed from: l */
    private static Class<?> f2918l = null;

    /* renamed from: m */
    private static boolean f2919m = true;

    /* renamed from: a */
    static /* synthetic */ String m1824a(String str, String str2) {
        return C3403z.m2277a() + "  " + str + "  " + str2 + "\n";
    }

    /* renamed from: g */
    static /* synthetic */ int m1839g() {
        int i = f2913g;
        f2913g = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0068 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0069  */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void m1835c(android.content.Context r14, com.tencent.bugly.BuglyStrategy r15) {
        /*
            Method dump skipped, instructions count: 273
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.biz.C3335b.m1835c(android.content.Context, com.tencent.bugly.BuglyStrategy):void");
    }

    /* renamed from: a */
    public static void m1828a(final Context context, final BuglyStrategy buglyStrategy) {
        long j;
        if (f2908b) {
            return;
        }
        f2919m = C3337a.m1854a(context).f2971e;
        f2907a = new C3334a(context, f2919m);
        f2908b = true;
        if (buglyStrategy != null) {
            f2918l = buglyStrategy.getUserInfoActivity();
            j = buglyStrategy.getAppReportDelay();
        } else {
            j = 0;
        }
        if (j <= 0) {
            m1835c(context, buglyStrategy);
        } else {
            C3400w.m2238a().m2241a(new Runnable() { // from class: com.tencent.bugly.crashreport.biz.b.1
                @Override // java.lang.Runnable
                public final void run() {
                    C3335b.m1835c(context, buglyStrategy);
                }
            }, j);
        }
    }

    /* renamed from: a */
    public static void m1826a(long j) {
        if (j < 0) {
            j = C3340a.m1927a().m1937c().f3010o;
        }
        f2912f = j;
    }

    /* renamed from: a */
    public static void m1829a(StrategyBean strategyBean, boolean z) {
        C3400w m2238a;
        C3334a c3334a = f2907a;
        if (c3334a != null && !z && (m2238a = C3400w.m2238a()) != null) {
            m2238a.m2240a(c3334a.new AnonymousClass2());
        }
        if (strategyBean == null) {
            return;
        }
        if (strategyBean.f3010o > 0) {
            f2911e = strategyBean.f3010o;
        }
        if (strategyBean.f3015t > 0) {
            f2909c = strategyBean.f3015t;
        }
        if (strategyBean.f3016u > 0) {
            f2910d = strategyBean.f3016u;
        }
    }

    /* renamed from: a */
    public static void m1825a() {
        C3334a c3334a = f2907a;
        if (c3334a != null) {
            c3334a.m1821a(2, false, 0L);
        }
    }

    /* renamed from: a */
    public static void m1827a(Context context) {
        if (!f2908b || context == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 14) {
            Application application = context.getApplicationContext() instanceof Application ? (Application) context.getApplicationContext() : null;
            if (application != null) {
                try {
                    Application.ActivityLifecycleCallbacks activityLifecycleCallbacks = f2917k;
                    if (activityLifecycleCallbacks != null) {
                        application.unregisterActivityLifecycleCallbacks(activityLifecycleCallbacks);
                    }
                } catch (Exception e) {
                    if (!C3401x.m2247a(e)) {
                        e.printStackTrace();
                    }
                }
            }
        }
        f2908b = false;
    }
}