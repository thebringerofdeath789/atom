package com.tencent.bugly.crashreport.crash.anr;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.FileObserver;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import com.camera.JCameraView;
import com.ipotensic.baselib.netty.Constant;
import com.tencent.bugly.BuglyStrategy;
import com.tencent.bugly.crashreport.common.info.AppInfo;
import com.tencent.bugly.crashreport.common.info.C3337a;
import com.tencent.bugly.crashreport.common.info.C3338b;
import com.tencent.bugly.crashreport.common.strategy.C3340a;
import com.tencent.bugly.crashreport.crash.C3350b;
import com.tencent.bugly.crashreport.crash.C3351c;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.crashreport.crash.anr.TraceFileHelper;
import com.tencent.bugly.proguard.C3362ab;
import com.tencent.bugly.proguard.C3393p;
import com.tencent.bugly.proguard.C3400w;
import com.tencent.bugly.proguard.C3401x;
import com.tencent.bugly.proguard.C3402y;
import com.tencent.bugly.proguard.C3403z;
import com.tencent.bugly.proguard.InterfaceC3363ac;
import com.tencent.bugly.proguard.RunnableC3361aa;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.crashreport.crash.anr.b */
/* loaded from: classes3.dex */
public final class C3349b implements InterfaceC3363ac {

    /* renamed from: m */
    private static C3349b f3106m;

    /* renamed from: c */
    private final Context f3109c;

    /* renamed from: d */
    private final C3337a f3110d;

    /* renamed from: e */
    private final C3400w f3111e;

    /* renamed from: f */
    private String f3112f;

    /* renamed from: g */
    private final C3350b f3113g;

    /* renamed from: h */
    private FileObserver f3114h;

    /* renamed from: j */
    private C3362ab f3116j;

    /* renamed from: k */
    private int f3117k;

    /* renamed from: a */
    private AtomicInteger f3107a = new AtomicInteger(0);

    /* renamed from: b */
    private long f3108b = -1;

    /* renamed from: i */
    private boolean f3115i = true;

    /* renamed from: l */
    private ActivityManager.ProcessErrorStateInfo f3118l = new ActivityManager.ProcessErrorStateInfo();

    /* renamed from: a */
    public static C3349b m1950a(Context context, C3340a c3340a, C3337a c3337a, C3400w c3400w, C3393p c3393p, C3350b c3350b, BuglyStrategy.C3327a c3327a) {
        if (f3106m == null) {
            f3106m = new C3349b(context, c3340a, c3337a, c3400w, c3350b);
        }
        return f3106m;
    }

    private C3349b(Context context, C3340a c3340a, C3337a c3337a, C3400w c3400w, C3350b c3350b) {
        this.f3109c = C3403z.m2271a(context);
        this.f3112f = context.getDir("bugly", 0).getAbsolutePath();
        this.f3110d = c3337a;
        this.f3111e = c3400w;
        this.f3113g = c3350b;
    }

    /* renamed from: a */
    private ActivityManager.ProcessErrorStateInfo m1948a(Context context, long j) {
        try {
            C3401x.m2251c("to find!", new Object[0]);
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            int i = 0;
            while (true) {
                C3401x.m2251c("waiting!", new Object[0]);
                List<ActivityManager.ProcessErrorStateInfo> processesInErrorState = activityManager.getProcessesInErrorState();
                if (processesInErrorState != null) {
                    for (ActivityManager.ProcessErrorStateInfo processErrorStateInfo : processesInErrorState) {
                        if (processErrorStateInfo.condition == 2) {
                            C3401x.m2251c("found!", new Object[0]);
                            return processErrorStateInfo;
                        }
                    }
                }
                C3403z.m2303b(500L);
                int i2 = i + 1;
                if (i >= 20) {
                    C3401x.m2251c("end!", new Object[0]);
                    return null;
                }
                i = i2;
            }
        } catch (Exception e) {
            C3401x.m2250b(e);
            return null;
        } catch (OutOfMemoryError e2) {
            this.f3118l.pid = Process.myPid();
            this.f3118l.shortMsg = "bugly sdk waitForAnrProcessStateChanged encount error:" + e2.getMessage();
            return this.f3118l;
        }
    }

    /* renamed from: a */
    private CrashDetailBean m1949a(C3348a c3348a) {
        CrashDetailBean crashDetailBean = new CrashDetailBean();
        try {
            crashDetailBean.f3036C = C3338b.m1912g();
            crashDetailBean.f3037D = C3338b.m1908e();
            crashDetailBean.f3038E = C3338b.m1916i();
            crashDetailBean.f3039F = this.f3110d.m1883k();
            crashDetailBean.f3040G = this.f3110d.m1882j();
            crashDetailBean.f3041H = this.f3110d.m1884l();
            if (!C3338b.m1920m()) {
                crashDetailBean.f3080w = C3403z.m2279a(this.f3109c, C3351c.f3137e, (String) null);
            }
            crashDetailBean.f3059b = 3;
            crashDetailBean.f3062e = this.f3110d.m1880h();
            crashDetailBean.f3063f = this.f3110d.f2977k;
            crashDetailBean.f3064g = this.f3110d.m1889q();
            crashDetailBean.f3070m = this.f3110d.m1878g();
            crashDetailBean.f3071n = "ANR_EXCEPTION";
            crashDetailBean.f3072o = c3348a.f3104f;
            crashDetailBean.f3074q = c3348a.f3105g;
            crashDetailBean.f3049P = new HashMap();
            crashDetailBean.f3049P.put("BUGLY_CR_01", c3348a.f3103e);
            int indexOf = crashDetailBean.f3074q != null ? crashDetailBean.f3074q.indexOf("\n") : -1;
            crashDetailBean.f3073p = indexOf > 0 ? crashDetailBean.f3074q.substring(0, indexOf) : "GET_FAIL";
            crashDetailBean.f3075r = c3348a.f3101c;
            if (crashDetailBean.f3074q != null) {
                crashDetailBean.f3078u = C3403z.m2284a(crashDetailBean.f3074q.getBytes());
            }
            crashDetailBean.f3083z = c3348a.f3100b;
            crashDetailBean.f3034A = c3348a.f3099a;
            crashDetailBean.f3035B = "main(1)";
            crashDetailBean.f3042I = this.f3110d.m1891s();
            crashDetailBean.f3065h = this.f3110d.m1888p();
            crashDetailBean.f3066i = this.f3110d.m1857B();
            crashDetailBean.f3079v = c3348a.f3102d;
            crashDetailBean.f3045L = this.f3110d.f2981o;
            crashDetailBean.f3046M = this.f3110d.f2952a;
            crashDetailBean.f3047N = this.f3110d.m1864a();
            if (!C3338b.m1920m()) {
                this.f3113g.m1988d(crashDetailBean);
            }
            crashDetailBean.f3050Q = this.f3110d.m1898z();
            crashDetailBean.f3051R = this.f3110d.m1856A();
            crashDetailBean.f3052S = this.f3110d.m1892t();
            crashDetailBean.f3053T = this.f3110d.m1897y();
            crashDetailBean.f3082y = C3402y.m2259a();
        } catch (Throwable th) {
            if (!C3401x.m2247a(th)) {
                th.printStackTrace();
            }
        }
        return crashDetailBean;
    }

    /* renamed from: a */
    private static boolean m1953a(String str, String str2, String str3) {
        Throwable th;
        TraceFileHelper.C3346a readTargetDumpInfo = TraceFileHelper.readTargetDumpInfo(str3, str, true);
        if (readTargetDumpInfo == null || readTargetDumpInfo.f3098d == null || readTargetDumpInfo.f3098d.size() <= 0) {
            C3401x.m2253e("not found trace dump for %s", str3);
            return false;
        }
        File file = new File(str2);
        try {
            if (!file.exists()) {
                if (!file.getParentFile().exists()) {
                    file.getParentFile().mkdirs();
                }
                file.createNewFile();
            }
            if (!file.exists() || !file.canWrite()) {
                C3401x.m2253e("backup file create fail %s", str2);
                return false;
            }
            BufferedWriter bufferedWriter = null;
            try {
                try {
                    BufferedWriter bufferedWriter2 = new BufferedWriter(new FileWriter(file, false));
                    try {
                        String[] strArr = readTargetDumpInfo.f3098d.get("main");
                        int i = 3;
                        if (strArr != null && strArr.length >= 3) {
                            bufferedWriter2.write("\"main\" tid=" + strArr[2] + " :\n" + strArr[0] + "\n" + strArr[1] + "\n\n");
                            bufferedWriter2.flush();
                        }
                        for (Map.Entry<String, String[]> entry : readTargetDumpInfo.f3098d.entrySet()) {
                            if (!entry.getKey().equals("main")) {
                                if (entry.getValue() != null && entry.getValue().length >= i) {
                                    bufferedWriter2.write("\"" + entry.getKey() + "\" tid=" + entry.getValue()[2] + " :\n" + entry.getValue()[0] + "\n" + entry.getValue()[1] + "\n\n");
                                    bufferedWriter2.flush();
                                }
                                i = 3;
                            }
                        }
                        try {
                            bufferedWriter2.close();
                        } catch (IOException e) {
                            if (!C3401x.m2247a(e)) {
                                e.printStackTrace();
                            }
                        }
                        return true;
                    } catch (IOException e2) {
                        e = e2;
                        bufferedWriter = bufferedWriter2;
                        if (!C3401x.m2247a(e)) {
                            e.printStackTrace();
                        }
                        C3401x.m2253e("dump trace fail %s", e.getClass().getName() + ":" + e.getMessage());
                        if (bufferedWriter != null) {
                            try {
                                bufferedWriter.close();
                            } catch (IOException e3) {
                                if (!C3401x.m2247a(e3)) {
                                    e3.printStackTrace();
                                }
                            }
                        }
                        return false;
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedWriter = bufferedWriter2;
                        if (bufferedWriter != null) {
                            try {
                                bufferedWriter.close();
                                throw th;
                            } catch (IOException e4) {
                                if (!C3401x.m2247a(e4)) {
                                    e4.printStackTrace();
                                    throw th;
                                }
                                throw th;
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            } catch (IOException e5) {
                e = e5;
            }
        } catch (Exception e6) {
            if (!C3401x.m2247a(e6)) {
                e6.printStackTrace();
            }
            C3401x.m2253e("backup file create error! %s  %s", e6.getClass().getName() + ":" + e6.getMessage(), str2);
            return false;
        }
    }

    /* renamed from: a */
    public final boolean m1965a() {
        return this.f3107a.get() != 0;
    }

    /* renamed from: a */
    private boolean m1952a(Context context, String str, ActivityManager.ProcessErrorStateInfo processErrorStateInfo, long j, Map<String, String> map) {
        C3348a c3348a = new C3348a();
        c3348a.f3101c = j;
        c3348a.f3099a = processErrorStateInfo != null ? processErrorStateInfo.processName : AppInfo.m1845a(Process.myPid());
        c3348a.f3104f = processErrorStateInfo != null ? processErrorStateInfo.shortMsg : "";
        c3348a.f3103e = processErrorStateInfo != null ? processErrorStateInfo.longMsg : "";
        c3348a.f3100b = map;
        Thread thread = Looper.getMainLooper().getThread();
        if (map != null) {
            Iterator<String> it = map.keySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                String next = it.next();
                if (next.startsWith(thread.getName())) {
                    c3348a.f3105g = map.get(next);
                    break;
                }
            }
        }
        if (TextUtils.isEmpty(c3348a.f3105g)) {
            c3348a.f3105g = "main stack is null , some error may be encountered.";
        }
        Object[] objArr = new Object[7];
        objArr[0] = Long.valueOf(c3348a.f3101c);
        objArr[1] = c3348a.f3102d;
        objArr[2] = c3348a.f3099a;
        objArr[3] = c3348a.f3105g;
        objArr[4] = c3348a.f3104f;
        objArr[5] = c3348a.f3103e;
        objArr[6] = Integer.valueOf(c3348a.f3100b == null ? 0 : c3348a.f3100b.size());
        C3401x.m2251c("anr tm:%d\ntr:%s\nproc:%s\nmain stack:%s\nsMsg:%s\n lMsg:%s\n threads:%d", objArr);
        C3401x.m2246a("found visiable anr , start to upload!", new Object[0]);
        CrashDetailBean m1949a = m1949a(c3348a);
        if (m1949a == null) {
            C3401x.m2253e("pack anr fail!", new Object[0]);
            return false;
        }
        C3351c.m1990a().m1997a(m1949a);
        if (m1949a.f3058a >= 0) {
            C3401x.m2246a("backup anr record success!", new Object[0]);
        } else {
            C3401x.m2252d("backup anr record fail!", new Object[0]);
        }
        if (str != null && new File(str).exists()) {
            c3348a.f3102d = new File(this.f3112f, "bugly_trace_" + j + ".txt").getAbsolutePath();
            this.f3107a.set(3);
            if (m1953a(str, c3348a.f3102d, c3348a.f3099a)) {
                C3401x.m2246a("backup trace success", new Object[0]);
            }
        } else {
            File m1960h = m1960h();
            C3401x.m2246a("traceFile is %s", m1960h);
            if (m1960h != null) {
                m1949a.f3079v = m1960h.getAbsolutePath();
            }
        }
        C3350b.m1974a("ANR", C3403z.m2277a(), c3348a.f3099a, "main", c3348a.f3105g, m1949a);
        if (!this.f3113g.m1985a(m1949a)) {
            this.f3113g.m1983a(m1949a, 3000L, true);
        }
        this.f3113g.m1987c(m1949a);
        return true;
    }

    /* renamed from: a */
    public final void m1963a(String str) {
        synchronized (this) {
            if (this.f3107a.get() != 0) {
                C3401x.m2251c("trace started return ", new Object[0]);
                return;
            }
            this.f3107a.set(1);
            try {
                C3401x.m2251c("read trace first dump for create time!", new Object[0]);
                TraceFileHelper.C3346a readFirstDumpInfo = TraceFileHelper.readFirstDumpInfo(str, false);
                long j = readFirstDumpInfo != null ? readFirstDumpInfo.f3097c : -1L;
                if (j == -1) {
                    C3401x.m2252d("trace dump fail could not get time!", new Object[0]);
                    j = System.currentTimeMillis();
                }
                long j2 = j;
                if (Math.abs(j2 - this.f3108b) < Constant.DELAY_MILLIS) {
                    C3401x.m2252d("should not process ANR too Fre in %d", 10000);
                } else {
                    this.f3108b = j2;
                    this.f3107a.set(1);
                    try {
                        Map<String, String> m2287a = C3403z.m2287a(C3351c.f3138f, false);
                        if (m2287a != null && m2287a.size() > 0) {
                            ActivityManager.ProcessErrorStateInfo m1948a = m1948a(this.f3109c, Constant.DELAY_MILLIS);
                            this.f3118l = m1948a;
                            if (m1948a == null) {
                                C3401x.m2251c("proc state is unvisiable!", new Object[0]);
                            } else if (m1948a.pid != Process.myPid()) {
                                C3401x.m2251c("not mind proc!", this.f3118l.processName);
                            } else {
                                C3401x.m2246a("found visiable anr , start to process!", new Object[0]);
                                m1952a(this.f3109c, str, this.f3118l, j2, m2287a);
                            }
                        }
                        C3401x.m2252d("can't get all thread skip this anr", new Object[0]);
                    } catch (Throwable th) {
                        C3401x.m2247a(th);
                        C3401x.m2253e("get all thread stack fail!", new Object[0]);
                    }
                }
            } finally {
                try {
                } finally {
                }
            }
        }
    }

    /* renamed from: d */
    private synchronized void m1956d() {
        if (m1958f()) {
            C3401x.m2252d("start when started!", new Object[0]);
            return;
        }
        FileObserver fileObserver = new FileObserver("/data/anr/", 8) { // from class: com.tencent.bugly.crashreport.crash.anr.b.1
            @Override // android.os.FileObserver
            public final void onEvent(int i, String str) {
                if (str == null) {
                    return;
                }
                String str2 = "/data/anr/" + str;
                C3401x.m2252d("watching file %s", str2);
                if (!str2.contains("trace")) {
                    C3401x.m2252d("not anr file %s", str2);
                } else {
                    C3349b.this.m1963a(str2);
                }
            }
        };
        this.f3114h = fileObserver;
        try {
            fileObserver.startWatching();
            C3401x.m2246a("start anr monitor!", new Object[0]);
            this.f3111e.m2240a(new Runnable() { // from class: com.tencent.bugly.crashreport.crash.anr.b.2
                @Override // java.lang.Runnable
                public final void run() {
                    C3349b.this.m1967b();
                }
            });
        } catch (Throwable th) {
            this.f3114h = null;
            C3401x.m2252d("start anr monitor failed!", new Object[0]);
            if (C3401x.m2247a(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    /* renamed from: e */
    private synchronized void m1957e() {
        if (!m1958f()) {
            C3401x.m2252d("close when closed!", new Object[0]);
            return;
        }
        try {
            this.f3114h.stopWatching();
            this.f3114h = null;
            C3401x.m2252d("close anr monitor!", new Object[0]);
        } catch (Throwable th) {
            C3401x.m2252d("stop anr monitor failed!", new Object[0]);
            if (C3401x.m2247a(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    /* renamed from: f */
    private synchronized boolean m1958f() {
        return this.f3114h != null;
    }

    /* renamed from: b */
    private synchronized void m1954b(boolean z) {
        if (Build.VERSION.SDK_INT <= 19) {
            if (z) {
                m1956d();
                return;
            } else {
                m1957e();
                return;
            }
        }
        if (z) {
            m1961i();
        } else {
            m1962j();
        }
    }

    /* renamed from: g */
    private synchronized boolean m1959g() {
        return this.f3115i;
    }

    /* renamed from: c */
    private synchronized void m1955c(boolean z) {
        if (this.f3115i != z) {
            C3401x.m2246a("user change anr %b", Boolean.valueOf(z));
            this.f3115i = z;
        }
    }

    /* renamed from: a */
    public final void m1964a(boolean z) {
        m1955c(z);
        boolean m1959g = m1959g();
        C3340a m1927a = C3340a.m1927a();
        if (m1927a != null) {
            m1959g = m1959g && m1927a.m1937c().f3000e;
        }
        if (m1959g != m1958f()) {
            C3401x.m2246a("anr changed to %b", Boolean.valueOf(m1959g));
            m1954b(m1959g);
        }
    }

    /* renamed from: b */
    protected final void m1967b() {
        long m2298b = C3403z.m2298b() - C3351c.f3139g;
        File file = new File(this.f3112f);
        if (file.exists() && file.isDirectory()) {
            try {
                File[] listFiles = file.listFiles();
                if (listFiles != null && listFiles.length != 0) {
                    int i = 0;
                    for (File file2 : listFiles) {
                        String name = file2.getName();
                        C3401x.m2251c("Number Trace file : " + name, new Object[0]);
                        if (name.startsWith("bugly_trace_")) {
                            try {
                                int indexOf = name.indexOf(".txt");
                                if (indexOf > 0 && Long.parseLong(name.substring(12, indexOf)) >= m2298b) {
                                }
                            } catch (Throwable unused) {
                                C3401x.m2251c("Trace file that has invalid format: " + name, new Object[0]);
                            }
                            if (file2.delete()) {
                                i++;
                            }
                        }
                    }
                    C3401x.m2251c("Number of overdue trace files that has deleted: " + i, new Object[0]);
                }
            } catch (Throwable th) {
                C3401x.m2247a(th);
            }
        }
    }

    /* renamed from: c */
    public final synchronized void m1968c() {
        C3401x.m2252d("customer decides whether to open or close.", new Object[0]);
    }

    @Override // com.tencent.bugly.proguard.InterfaceC3363ac
    /* renamed from: a */
    public final boolean mo1966a(RunnableC3361aa runnableC3361aa) {
        Map<String, String> hashMap = new HashMap<>();
        if (runnableC3361aa.m2083e().equals(Looper.getMainLooper())) {
            try {
                hashMap = C3403z.m2287a(JCameraView.MEDIA_QUALITY_DESPAIR, false);
            } catch (Throwable th) {
                C3401x.m2250b(th);
                hashMap.put("main", th.getMessage());
            }
            Map<String, String> map = hashMap;
            C3401x.m2251c("onThreadBlock found visiable anr , start to process!", new Object[0]);
            m1952a(this.f3109c, "", null, System.currentTimeMillis(), map);
        } else {
            C3401x.m2251c("anr handler onThreadBlock only care main thread ,current thread is: %s", runnableC3361aa.m2082d());
        }
        return true;
    }

    /* renamed from: h */
    private File m1960h() {
        long currentTimeMillis = System.currentTimeMillis();
        File file = new File(this.f3112f);
        if (file.exists() && file.isDirectory()) {
            try {
                File[] listFiles = file.listFiles();
                if (listFiles != null && listFiles.length != 0) {
                    int i = 12;
                    int length = listFiles.length;
                    int i2 = 0;
                    while (i2 < length) {
                        File file2 = listFiles[i2];
                        String name = file2.getName();
                        if (name.startsWith("bugly_trace_")) {
                            try {
                                int indexOf = name.indexOf(".txt");
                                if (indexOf > 0) {
                                    long parseLong = Long.parseLong(name.substring(i, indexOf));
                                    long j = (currentTimeMillis - parseLong) / 1000;
                                    C3401x.m2251c("current time %d trace time is %d s", Long.valueOf(currentTimeMillis), Long.valueOf(parseLong));
                                    C3401x.m2251c("current time minus trace time is %d s", Long.valueOf(j));
                                    if (j < 30) {
                                        return file2;
                                    }
                                } else {
                                    continue;
                                }
                            } catch (Throwable unused) {
                                C3401x.m2251c("Trace file that has invalid format: " + name, new Object[0]);
                            }
                        }
                        i2++;
                        i = 12;
                    }
                }
                return null;
            } catch (Throwable th) {
                C3401x.m2247a(th);
                return null;
            }
        }
        return null;
    }

    /* renamed from: i */
    private synchronized void m1961i() {
        if (m1958f()) {
            C3401x.m2252d("start when started!", new Object[0]);
            return;
        }
        if (TextUtils.isEmpty(this.f3112f)) {
            return;
        }
        C3362ab c3362ab = this.f3116j;
        if (c3362ab == null || !c3362ab.isAlive()) {
            C3362ab c3362ab2 = new C3362ab();
            this.f3116j = c3362ab2;
            StringBuilder sb = new StringBuilder("Bugly-ThreadMonitor");
            int i = this.f3117k;
            this.f3117k = i + 1;
            c3362ab2.setName(sb.append(i).toString());
            this.f3116j.m2086a();
            this.f3116j.m2087a(this);
            this.f3116j.m2092d();
            C3400w c3400w = this.f3111e;
            if (c3400w != null) {
                c3400w.m2240a(new Runnable() { // from class: com.tencent.bugly.crashreport.crash.anr.b.3
                    @Override // java.lang.Runnable
                    public final void run() {
                        C3349b.this.m1967b();
                    }
                });
            }
        }
        FileObserver fileObserver = new FileObserver(this.f3112f, 256) { // from class: com.tencent.bugly.crashreport.crash.anr.b.4
            @Override // android.os.FileObserver
            public final void onEvent(int i2, String str) {
                if (str == null) {
                    return;
                }
                C3401x.m2252d("startWatchingPrivateAnrDir %s", str);
                String str2 = "/data/anr/" + str;
                if (str2.contains("trace")) {
                    if (C3349b.this.f3116j != null) {
                        C3349b.this.f3116j.m2088a(true);
                        return;
                    }
                    return;
                }
                C3401x.m2252d("not anr file %s", str2);
            }
        };
        this.f3114h = fileObserver;
        try {
            fileObserver.startWatching();
            C3401x.m2246a("startWatchingPrivateAnrDir! dumFilePath is %s", this.f3112f);
            this.f3111e.m2240a(new Runnable() { // from class: com.tencent.bugly.crashreport.crash.anr.b.5
                @Override // java.lang.Runnable
                public final void run() {
                    C3349b.this.m1967b();
                }
            });
        } catch (Throwable th) {
            this.f3114h = null;
            C3401x.m2252d("startWatchingPrivateAnrDir failed!", new Object[0]);
            if (C3401x.m2247a(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    /* renamed from: j */
    private synchronized void m1962j() {
        if (!m1958f()) {
            C3401x.m2252d("close when closed!", new Object[0]);
            return;
        }
        C3362ab c3362ab = this.f3116j;
        if (c3362ab != null) {
            c3362ab.m2091c();
            this.f3116j.m2089b();
            this.f3116j.m2090b(this);
            this.f3116j = null;
        }
        C3401x.m2246a("stopWatchingPrivateAnrDir", new Object[0]);
        try {
            this.f3114h.stopWatching();
            this.f3114h = null;
            C3401x.m2252d("close anr monitor!", new Object[0]);
        } catch (Throwable th) {
            C3401x.m2252d("stop anr monitor failed!", new Object[0]);
            if (C3401x.m2247a(th)) {
                return;
            }
            th.printStackTrace();
        }
    }
}