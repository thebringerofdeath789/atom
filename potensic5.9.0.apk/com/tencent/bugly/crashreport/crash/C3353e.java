package com.tencent.bugly.crashreport.crash;

import android.content.Context;
import android.os.Process;
import com.tencent.bugly.crashreport.common.info.C3337a;
import com.tencent.bugly.crashreport.common.info.C3338b;
import com.tencent.bugly.crashreport.common.strategy.C3340a;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.proguard.C3401x;
import com.tencent.bugly.proguard.C3402y;
import com.tencent.bugly.proguard.C3403z;
import java.lang.Thread;
import java.util.HashMap;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.crashreport.crash.e */
/* loaded from: classes3.dex */
public final class C3353e implements Thread.UncaughtExceptionHandler {

    /* renamed from: h */
    private static String f3179h;

    /* renamed from: i */
    private static final Object f3180i = new Object();

    /* renamed from: a */
    private Context f3181a;

    /* renamed from: b */
    private C3350b f3182b;

    /* renamed from: c */
    private C3340a f3183c;

    /* renamed from: d */
    private C3337a f3184d;

    /* renamed from: e */
    private Thread.UncaughtExceptionHandler f3185e;

    /* renamed from: f */
    private Thread.UncaughtExceptionHandler f3186f;

    /* renamed from: g */
    private boolean f3187g = false;

    /* renamed from: j */
    private int f3188j;

    public C3353e(Context context, C3350b c3350b, C3340a c3340a, C3337a c3337a) {
        this.f3181a = context;
        this.f3182b = c3350b;
        this.f3183c = c3340a;
        this.f3184d = c3337a;
    }

    /* renamed from: a */
    public final synchronized void m2030a() {
        if (this.f3188j >= 10) {
            C3401x.m2246a("java crash handler over %d, no need set.", 10);
            return;
        }
        this.f3187g = true;
        Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        if (defaultUncaughtExceptionHandler != null) {
            if (getClass().getName().equals(defaultUncaughtExceptionHandler.getClass().getName())) {
                return;
            }
            if ("com.android.internal.os.RuntimeInit$UncaughtHandler".equals(defaultUncaughtExceptionHandler.getClass().getName())) {
                C3401x.m2246a("backup system java handler: %s", defaultUncaughtExceptionHandler.toString());
                this.f3186f = defaultUncaughtExceptionHandler;
                this.f3185e = defaultUncaughtExceptionHandler;
            } else {
                C3401x.m2246a("backup java handler: %s", defaultUncaughtExceptionHandler.toString());
                this.f3185e = defaultUncaughtExceptionHandler;
            }
        }
        Thread.setDefaultUncaughtExceptionHandler(this);
        this.f3188j++;
        C3401x.m2246a("registered java monitor: %s", toString());
    }

    /* renamed from: b */
    public final synchronized void m2033b() {
        this.f3187g = false;
        C3401x.m2246a("close java monitor!", new Object[0]);
        if (Thread.getDefaultUncaughtExceptionHandler().getClass().getName().contains("bugly")) {
            C3401x.m2246a("Java monitor to unregister: %s", toString());
            Thread.setDefaultUncaughtExceptionHandler(this.f3185e);
            this.f3188j--;
        }
    }

    /* renamed from: b */
    private CrashDetailBean m2028b(Thread thread, Throwable th, boolean z, String str, byte[] bArr) {
        String m2025a;
        if (th == null) {
            C3401x.m2252d("We can do nothing with a null throwable.", new Object[0]);
            return null;
        }
        boolean m2011l = C3351c.m1990a().m2011l();
        String str2 = (m2011l && z) ? " This Crash Caused By ANR , PLS To Fix ANR , This Trace May Be Not Useful![Bugly]" : "";
        if (m2011l && z) {
            C3401x.m2253e("This Crash Caused By ANR , PLS To Fix ANR , This Trace May Be Not Useful!", new Object[0]);
        }
        CrashDetailBean crashDetailBean = new CrashDetailBean();
        crashDetailBean.f3036C = C3338b.m1912g();
        crashDetailBean.f3037D = C3338b.m1908e();
        crashDetailBean.f3038E = C3338b.m1916i();
        crashDetailBean.f3039F = this.f3184d.m1883k();
        crashDetailBean.f3040G = this.f3184d.m1882j();
        crashDetailBean.f3041H = this.f3184d.m1884l();
        crashDetailBean.f3080w = C3403z.m2279a(this.f3181a, C3351c.f3137e, (String) null);
        crashDetailBean.f3082y = C3402y.m2259a();
        Object[] objArr = new Object[1];
        objArr[0] = Integer.valueOf(crashDetailBean.f3082y == null ? 0 : crashDetailBean.f3082y.length);
        C3401x.m2246a("user log size:%d", objArr);
        crashDetailBean.f3059b = z ? 0 : 2;
        crashDetailBean.f3062e = this.f3184d.m1880h();
        crashDetailBean.f3063f = this.f3184d.f2977k;
        crashDetailBean.f3064g = this.f3184d.m1889q();
        crashDetailBean.f3070m = this.f3184d.m1878g();
        String name = th.getClass().getName();
        String m2029b = m2029b(th, 1000);
        if (m2029b == null) {
            m2029b = "";
        }
        Object[] objArr2 = new Object[2];
        objArr2[0] = Integer.valueOf(th.getStackTrace().length);
        objArr2[1] = Boolean.valueOf(th.getCause() != null);
        C3401x.m2253e("stack frame :%d, has cause %b", objArr2);
        String stackTraceElement = th.getStackTrace().length > 0 ? th.getStackTrace()[0].toString() : "";
        Throwable th2 = th;
        while (th2 != null && th2.getCause() != null) {
            th2 = th2.getCause();
        }
        if (th2 != null && th2 != th) {
            crashDetailBean.f3071n = th2.getClass().getName();
            crashDetailBean.f3072o = m2029b(th2, 1000);
            if (crashDetailBean.f3072o == null) {
                crashDetailBean.f3072o = "";
            }
            if (th2.getStackTrace().length > 0) {
                crashDetailBean.f3073p = th2.getStackTrace()[0].toString();
            }
            StringBuilder sb = new StringBuilder();
            sb.append(name).append(":").append(m2029b).append("\n");
            sb.append(stackTraceElement);
            sb.append("\n......");
            sb.append("\nCaused by:\n");
            sb.append(crashDetailBean.f3071n).append(":").append(crashDetailBean.f3072o).append("\n");
            m2025a = m2025a(th2, C3351c.f3138f);
            sb.append(m2025a);
            crashDetailBean.f3074q = sb.toString();
        } else {
            crashDetailBean.f3071n = name;
            crashDetailBean.f3072o = m2029b + str2;
            if (crashDetailBean.f3072o == null) {
                crashDetailBean.f3072o = "";
            }
            crashDetailBean.f3073p = stackTraceElement;
            m2025a = m2025a(th, C3351c.f3138f);
            crashDetailBean.f3074q = m2025a;
        }
        crashDetailBean.f3075r = System.currentTimeMillis();
        crashDetailBean.f3078u = C3403z.m2284a(crashDetailBean.f3074q.getBytes());
        try {
            crashDetailBean.f3083z = C3403z.m2287a(C3351c.f3138f, false);
            crashDetailBean.f3034A = this.f3184d.f2970d;
            crashDetailBean.f3035B = thread.getName() + "(" + thread.getId() + ")";
            crashDetailBean.f3083z.put(crashDetailBean.f3035B, m2025a);
            crashDetailBean.f3042I = this.f3184d.m1891s();
            crashDetailBean.f3065h = this.f3184d.m1888p();
            crashDetailBean.f3066i = this.f3184d.m1857B();
            crashDetailBean.f3046M = this.f3184d.f2952a;
            crashDetailBean.f3047N = this.f3184d.m1864a();
            if (z) {
                this.f3182b.m1988d(crashDetailBean);
            } else {
                boolean z2 = str != null && str.length() > 0;
                boolean z3 = bArr != null && bArr.length > 0;
                if (z2) {
                    crashDetailBean.f3048O = new HashMap(1);
                    crashDetailBean.f3048O.put("UserData", str);
                }
                if (z3) {
                    crashDetailBean.f3054U = bArr;
                }
            }
            crashDetailBean.f3050Q = this.f3184d.m1898z();
            crashDetailBean.f3051R = this.f3184d.m1856A();
            crashDetailBean.f3052S = this.f3184d.m1892t();
            crashDetailBean.f3053T = this.f3184d.m1897y();
        } catch (Throwable th3) {
            C3401x.m2253e("handle crash error %s", th3.toString());
        }
        return crashDetailBean;
    }

    /* renamed from: a */
    private static boolean m2027a(Thread thread) {
        synchronized (f3180i) {
            if (f3179h != null && thread.getName().equals(f3179h)) {
                return true;
            }
            f3179h = thread.getName();
            return false;
        }
    }

    /* renamed from: a */
    public final void m2032a(Thread thread, Throwable th, boolean z, String str, byte[] bArr) {
        if (z) {
            C3401x.m2253e("Java Crash Happen cause by %s(%d)", thread.getName(), Long.valueOf(thread.getId()));
            if (m2027a(thread)) {
                C3401x.m2246a("this class has handled this exception", new Object[0]);
                if (this.f3186f != null) {
                    C3401x.m2246a("call system handler", new Object[0]);
                    this.f3186f.uncaughtException(thread, th);
                } else {
                    C3401x.m2253e("current process die", new Object[0]);
                    Process.killProcess(Process.myPid());
                    System.exit(1);
                }
            }
        } else {
            C3401x.m2253e("Java Catch Happen", new Object[0]);
        }
        try {
            if (!this.f3187g) {
                C3401x.m2251c("Java crash handler is disable. Just return.", new Object[0]);
                if (z) {
                    Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f3185e;
                    if (uncaughtExceptionHandler != null && m2026a(uncaughtExceptionHandler)) {
                        C3401x.m2253e("sys default last handle start!", new Object[0]);
                        this.f3185e.uncaughtException(thread, th);
                        C3401x.m2253e("sys default last handle end!", new Object[0]);
                        return;
                    } else if (this.f3186f != null) {
                        C3401x.m2253e("system handle start!", new Object[0]);
                        this.f3186f.uncaughtException(thread, th);
                        C3401x.m2253e("system handle end!", new Object[0]);
                        return;
                    } else {
                        C3401x.m2253e("crashreport last handle start!", new Object[0]);
                        C3401x.m2253e("current process die", new Object[0]);
                        Process.killProcess(Process.myPid());
                        System.exit(1);
                        C3401x.m2253e("crashreport last handle end!", new Object[0]);
                        return;
                    }
                }
                return;
            }
            if (!this.f3183c.m1936b()) {
                C3401x.m2252d("no remote but still store!", new Object[0]);
            }
            if (!this.f3183c.m1937c().f3000e && this.f3183c.m1936b()) {
                C3401x.m2253e("crash report was closed by remote , will not upload to Bugly , print local for helpful!", new Object[0]);
                C3350b.m1974a(z ? "JAVA_CRASH" : "JAVA_CATCH", C3403z.m2277a(), this.f3184d.f2970d, thread.getName(), C3403z.m2282a(th), null);
                if (z) {
                    Thread.UncaughtExceptionHandler uncaughtExceptionHandler2 = this.f3185e;
                    if (uncaughtExceptionHandler2 != null && m2026a(uncaughtExceptionHandler2)) {
                        C3401x.m2253e("sys default last handle start!", new Object[0]);
                        this.f3185e.uncaughtException(thread, th);
                        C3401x.m2253e("sys default last handle end!", new Object[0]);
                        return;
                    } else if (this.f3186f != null) {
                        C3401x.m2253e("system handle start!", new Object[0]);
                        this.f3186f.uncaughtException(thread, th);
                        C3401x.m2253e("system handle end!", new Object[0]);
                        return;
                    } else {
                        C3401x.m2253e("crashreport last handle start!", new Object[0]);
                        C3401x.m2253e("current process die", new Object[0]);
                        Process.killProcess(Process.myPid());
                        System.exit(1);
                        C3401x.m2253e("crashreport last handle end!", new Object[0]);
                        return;
                    }
                }
                return;
            }
            CrashDetailBean m2028b = m2028b(thread, th, z, str, bArr);
            if (m2028b == null) {
                C3401x.m2253e("pkg crash datas fail!", new Object[0]);
                if (z) {
                    Thread.UncaughtExceptionHandler uncaughtExceptionHandler3 = this.f3185e;
                    if (uncaughtExceptionHandler3 != null && m2026a(uncaughtExceptionHandler3)) {
                        C3401x.m2253e("sys default last handle start!", new Object[0]);
                        this.f3185e.uncaughtException(thread, th);
                        C3401x.m2253e("sys default last handle end!", new Object[0]);
                        return;
                    } else if (this.f3186f != null) {
                        C3401x.m2253e("system handle start!", new Object[0]);
                        this.f3186f.uncaughtException(thread, th);
                        C3401x.m2253e("system handle end!", new Object[0]);
                        return;
                    } else {
                        C3401x.m2253e("crashreport last handle start!", new Object[0]);
                        C3401x.m2253e("current process die", new Object[0]);
                        Process.killProcess(Process.myPid());
                        System.exit(1);
                        C3401x.m2253e("crashreport last handle end!", new Object[0]);
                        return;
                    }
                }
                return;
            }
            C3350b.m1974a(z ? "JAVA_CRASH" : "JAVA_CATCH", C3403z.m2277a(), this.f3184d.f2970d, thread.getName(), C3403z.m2282a(th), m2028b);
            if (!this.f3182b.m1985a(m2028b)) {
                this.f3182b.m1983a(m2028b, 3000L, z);
            }
            if (z) {
                this.f3182b.m1987c(m2028b);
            }
            if (z) {
                Thread.UncaughtExceptionHandler uncaughtExceptionHandler4 = this.f3185e;
                if (uncaughtExceptionHandler4 != null && m2026a(uncaughtExceptionHandler4)) {
                    C3401x.m2253e("sys default last handle start!", new Object[0]);
                    this.f3185e.uncaughtException(thread, th);
                    C3401x.m2253e("sys default last handle end!", new Object[0]);
                } else if (this.f3186f != null) {
                    C3401x.m2253e("system handle start!", new Object[0]);
                    this.f3186f.uncaughtException(thread, th);
                    C3401x.m2253e("system handle end!", new Object[0]);
                } else {
                    C3401x.m2253e("crashreport last handle start!", new Object[0]);
                    C3401x.m2253e("current process die", new Object[0]);
                    Process.killProcess(Process.myPid());
                    System.exit(1);
                    C3401x.m2253e("crashreport last handle end!", new Object[0]);
                }
            }
        } catch (Throwable th2) {
            try {
                if (!C3401x.m2247a(th2)) {
                    th2.printStackTrace();
                }
                if (z) {
                    Thread.UncaughtExceptionHandler uncaughtExceptionHandler5 = this.f3185e;
                    if (uncaughtExceptionHandler5 != null && m2026a(uncaughtExceptionHandler5)) {
                        C3401x.m2253e("sys default last handle start!", new Object[0]);
                        this.f3185e.uncaughtException(thread, th);
                        C3401x.m2253e("sys default last handle end!", new Object[0]);
                    } else if (this.f3186f != null) {
                        C3401x.m2253e("system handle start!", new Object[0]);
                        this.f3186f.uncaughtException(thread, th);
                        C3401x.m2253e("system handle end!", new Object[0]);
                    } else {
                        C3401x.m2253e("crashreport last handle start!", new Object[0]);
                        C3401x.m2253e("current process die", new Object[0]);
                        Process.killProcess(Process.myPid());
                        System.exit(1);
                        C3401x.m2253e("crashreport last handle end!", new Object[0]);
                    }
                }
            } catch (Throwable th3) {
                if (z) {
                    Thread.UncaughtExceptionHandler uncaughtExceptionHandler6 = this.f3185e;
                    if (uncaughtExceptionHandler6 != null && m2026a(uncaughtExceptionHandler6)) {
                        C3401x.m2253e("sys default last handle start!", new Object[0]);
                        this.f3185e.uncaughtException(thread, th);
                        C3401x.m2253e("sys default last handle end!", new Object[0]);
                    } else if (this.f3186f != null) {
                        C3401x.m2253e("system handle start!", new Object[0]);
                        this.f3186f.uncaughtException(thread, th);
                        C3401x.m2253e("system handle end!", new Object[0]);
                    } else {
                        C3401x.m2253e("crashreport last handle start!", new Object[0]);
                        C3401x.m2253e("current process die", new Object[0]);
                        Process.killProcess(Process.myPid());
                        System.exit(1);
                        C3401x.m2253e("crashreport last handle end!", new Object[0]);
                    }
                }
                throw th3;
            }
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(Thread thread, Throwable th) {
        synchronized (f3180i) {
            m2032a(thread, th, true, null, null);
        }
    }

    /* renamed from: a */
    private static boolean m2026a(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        if (uncaughtExceptionHandler == null) {
            return true;
        }
        String name = uncaughtExceptionHandler.getClass().getName();
        for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
            String className = stackTraceElement.getClassName();
            String methodName = stackTraceElement.getMethodName();
            if (name.equals(className) && "uncaughtException".equals(methodName)) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    public final synchronized void m2031a(StrategyBean strategyBean) {
        if (strategyBean != null) {
            if (strategyBean.f3000e != this.f3187g) {
                C3401x.m2246a("java changed to %b", Boolean.valueOf(strategyBean.f3000e));
                if (strategyBean.f3000e) {
                    m2030a();
                    return;
                }
                m2033b();
            }
        }
    }

    /* renamed from: a */
    private static String m2025a(Throwable th, int i) {
        if (th == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        try {
            if (th.getStackTrace() != null) {
                for (StackTraceElement stackTraceElement : th.getStackTrace()) {
                    if (i > 0 && sb.length() >= i) {
                        sb.append("\n[Stack over limit size :" + i + " , has been cutted !]");
                        return sb.toString();
                    }
                    sb.append(stackTraceElement.toString()).append("\n");
                }
            }
        } catch (Throwable th2) {
            C3401x.m2253e("gen stack error %s", th2.toString());
        }
        return sb.toString();
    }

    /* renamed from: b */
    private static String m2029b(Throwable th, int i) {
        if (th.getMessage() == null) {
            return "";
        }
        if (th.getMessage().length() <= 1000) {
            return th.getMessage();
        }
        return th.getMessage().substring(0, 1000) + "\n[Message over limit size:1000, has been cutted!]";
    }
}