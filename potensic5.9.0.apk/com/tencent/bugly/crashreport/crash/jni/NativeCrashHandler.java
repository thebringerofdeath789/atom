package com.tencent.bugly.crashreport.crash.jni;

import android.content.Context;
import android.os.Build;
import com.ipotensic.baselib.netty.Constant;
import com.tencent.bugly.crashreport.InterfaceC3332a;
import com.tencent.bugly.crashreport.common.info.C3337a;
import com.tencent.bugly.crashreport.common.info.C3338b;
import com.tencent.bugly.crashreport.common.strategy.C3340a;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.crashreport.crash.C3350b;
import com.tencent.bugly.crashreport.crash.C3351c;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.proguard.C3400w;
import com.tencent.bugly.proguard.C3401x;
import com.tencent.bugly.proguard.C3403z;
import java.io.File;
import org.apache.commons.lang3.BooleanUtils;

/* compiled from: BUGLY */
/* loaded from: classes3.dex */
public class NativeCrashHandler implements InterfaceC3332a {
    public static int JNI_CALL_TYPE = 1;

    /* renamed from: a */
    private static NativeCrashHandler f3207a = null;

    /* renamed from: l */
    private static boolean f3208l = false;

    /* renamed from: m */
    private static boolean f3209m = false;

    /* renamed from: o */
    private static boolean f3210o = true;

    /* renamed from: b */
    private final Context f3211b;

    /* renamed from: c */
    private final C3337a f3212c;

    /* renamed from: d */
    private final C3400w f3213d;

    /* renamed from: e */
    private NativeExceptionHandler f3214e;

    /* renamed from: f */
    private String f3215f;

    /* renamed from: g */
    private final boolean f3216g;

    /* renamed from: h */
    private boolean f3217h = false;

    /* renamed from: i */
    private boolean f3218i = false;

    /* renamed from: j */
    private boolean f3219j = false;

    /* renamed from: k */
    private boolean f3220k = false;

    /* renamed from: n */
    private C3350b f3221n;

    protected native boolean appendNativeLog(String str, String str2, String str3);

    protected native boolean appendWholeNativeLog(String str);

    protected native String getNativeKeyValueList();

    protected native String getNativeLog();

    protected native boolean putNativeKeyValue(String str, String str2);

    protected native String regist(String str, boolean z, int i);

    protected native String removeNativeKeyValue(String str);

    protected native void setNativeInfo(int i, String str);

    protected native void testCrash();

    protected native String unregist();

    /* renamed from: a */
    static /* synthetic */ boolean m2040a(NativeCrashHandler nativeCrashHandler, int i, String str) {
        return nativeCrashHandler.m2039a(999, str);
    }

    private NativeCrashHandler(Context context, C3337a c3337a, C3350b c3350b, C3400w c3400w, boolean z, String str) {
        this.f3211b = C3403z.m2271a(context);
        try {
            if (C3403z.m2294a(str)) {
                str = context.getDir("bugly", 0).getAbsolutePath();
            }
        } catch (Throwable unused) {
            str = "/data/data/" + C3337a.m1854a(context).f2969c + "/app_bugly";
        }
        this.f3221n = c3350b;
        this.f3215f = str;
        this.f3212c = c3337a;
        this.f3213d = c3400w;
        this.f3216g = z;
        this.f3214e = new C3357a(context, c3337a, c3350b, C3340a.m1927a());
    }

    public static synchronized NativeCrashHandler getInstance(Context context, C3337a c3337a, C3350b c3350b, C3340a c3340a, C3400w c3400w, boolean z, String str) {
        NativeCrashHandler nativeCrashHandler;
        synchronized (NativeCrashHandler.class) {
            if (f3207a == null) {
                f3207a = new NativeCrashHandler(context, c3337a, c3350b, c3400w, z, str);
            }
            nativeCrashHandler = f3207a;
        }
        return nativeCrashHandler;
    }

    public static synchronized NativeCrashHandler getInstance() {
        NativeCrashHandler nativeCrashHandler;
        synchronized (NativeCrashHandler.class) {
            nativeCrashHandler = f3207a;
        }
        return nativeCrashHandler;
    }

    public synchronized String getDumpFilePath() {
        return this.f3215f;
    }

    public synchronized void setDumpFilePath(String str) {
        this.f3215f = str;
    }

    public static void setShouldHandleInJava(boolean z) {
        f3210o = z;
        NativeCrashHandler nativeCrashHandler = f3207a;
        if (nativeCrashHandler != null) {
            nativeCrashHandler.m2039a(999, new StringBuilder().append(z).toString());
        }
    }

    public static boolean isShouldHandleInJava() {
        return f3210o;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(17:40|(1:42)(16:68|(1:70)|44|45|(1:47)|48|(1:50)|52|(1:54)(1:66)|55|(1:57)(1:65)|58|(1:60)|61|62|63)|43|44|45|(0)|48|(0)|52|(0)(0)|55|(0)(0)|58|(0)|61|62|63) */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0081 A[Catch: all -> 0x008f, TryCatch #3 {all -> 0x008f, blocks: (B:45:0x0077, B:47:0x0081, B:48:0x0083, B:50:0x008d), top: B:44:0x0077 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x008d A[Catch: all -> 0x008f, TRY_LEAVE, TryCatch #3 {all -> 0x008f, blocks: (B:45:0x0077, B:47:0x0081, B:48:0x0083, B:50:0x008d), top: B:44:0x0077 }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0093 A[Catch: all -> 0x00f2, TryCatch #0 {all -> 0x00f2, blocks: (B:38:0x0015, B:40:0x001f, B:42:0x0051, B:43:0x005c, B:52:0x008f, B:54:0x0093, B:55:0x00a2, B:57:0x00a6, B:58:0x00b5, B:60:0x00cd, B:61:0x00e1, B:65:0x00ae, B:66:0x009b, B:68:0x0065, B:70:0x006b), top: B:37:0x0015, outer: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00a6 A[Catch: all -> 0x00f2, TryCatch #0 {all -> 0x00f2, blocks: (B:38:0x0015, B:40:0x001f, B:42:0x0051, B:43:0x005c, B:52:0x008f, B:54:0x0093, B:55:0x00a2, B:57:0x00a6, B:58:0x00b5, B:60:0x00cd, B:61:0x00e1, B:65:0x00ae, B:66:0x009b, B:68:0x0065, B:70:0x006b), top: B:37:0x0015, outer: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00cd A[Catch: all -> 0x00f2, TryCatch #0 {all -> 0x00f2, blocks: (B:38:0x0015, B:40:0x001f, B:42:0x0051, B:43:0x005c, B:52:0x008f, B:54:0x0093, B:55:0x00a2, B:57:0x00a6, B:58:0x00b5, B:60:0x00cd, B:61:0x00e1, B:65:0x00ae, B:66:0x009b, B:68:0x0065, B:70:0x006b), top: B:37:0x0015, outer: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00ae A[Catch: all -> 0x00f2, TryCatch #0 {all -> 0x00f2, blocks: (B:38:0x0015, B:40:0x001f, B:42:0x0051, B:43:0x005c, B:52:0x008f, B:54:0x0093, B:55:0x00a2, B:57:0x00a6, B:58:0x00b5, B:60:0x00cd, B:61:0x00e1, B:65:0x00ae, B:66:0x009b, B:68:0x0065, B:70:0x006b), top: B:37:0x0015, outer: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x009b A[Catch: all -> 0x00f2, TryCatch #0 {all -> 0x00f2, blocks: (B:38:0x0015, B:40:0x001f, B:42:0x0051, B:43:0x005c, B:52:0x008f, B:54:0x0093, B:55:0x00a2, B:57:0x00a6, B:58:0x00b5, B:60:0x00cd, B:61:0x00e1, B:65:0x00ae, B:66:0x009b, B:68:0x0065, B:70:0x006b), top: B:37:0x0015, outer: #2 }] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private synchronized void m2038a(boolean r11) {
        /*
            Method dump skipped, instructions count: 463
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler.m2038a(boolean):void");
    }

    public synchronized void startNativeMonitor() {
        if (!this.f3218i && !this.f3217h) {
            String str = "Bugly";
            boolean z = !C3403z.m2294a(this.f3212c.f2980n);
            String str2 = this.f3212c.f2980n;
            if (z) {
                str = str2;
            } else {
                this.f3212c.getClass();
            }
            boolean m2041a = m2041a(str, z);
            this.f3218i = m2041a;
            if (m2041a || this.f3217h) {
                m2038a(this.f3216g);
                if (f3208l) {
                    setNativeAppVersion(this.f3212c.f2977k);
                    setNativeAppChannel(this.f3212c.f2979m);
                    setNativeAppPackage(this.f3212c.f2969c);
                    setNativeUserId(this.f3212c.m1878g());
                    setNativeIsAppForeground(this.f3212c.m1864a());
                    setNativeLaunchTime(this.f3212c.f2952a);
                }
                return;
            }
            return;
        }
        m2038a(this.f3216g);
    }

    public void checkUploadRecordCrash() {
        this.f3213d.m2240a(new Runnable() { // from class: com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler.1
            @Override // java.lang.Runnable
            public final void run() {
                if (C3403z.m2291a(NativeCrashHandler.this.f3211b, "native_record_lock", Constant.DELAY_MILLIS)) {
                    if (!NativeCrashHandler.f3210o) {
                        NativeCrashHandler.m2040a(NativeCrashHandler.this, 999, "false");
                    }
                    CrashDetailBean m2050a = C3358b.m2050a(NativeCrashHandler.this.f3211b, NativeCrashHandler.this.f3215f, NativeCrashHandler.this.f3214e);
                    if (m2050a != null) {
                        C3401x.m2246a("[Native] Get crash from native record.", new Object[0]);
                        if (!NativeCrashHandler.this.f3221n.m1985a(m2050a)) {
                            NativeCrashHandler.this.f3221n.m1983a(m2050a, 3000L, false);
                        }
                        C3358b.m2056a(false, NativeCrashHandler.this.f3215f);
                    }
                    NativeCrashHandler.this.m2049a();
                    C3403z.m2306b(NativeCrashHandler.this.f3211b, "native_record_lock");
                    return;
                }
                C3401x.m2246a("[Native] Failed to lock file for handling native crash record.", new Object[0]);
            }
        });
    }

    /* renamed from: a */
    private static boolean m2041a(String str, boolean z) {
        boolean z2;
        try {
            C3401x.m2246a("[Native] Trying to load so: %s", str);
            if (z) {
                System.load(str);
            } else {
                System.loadLibrary(str);
            }
            try {
                C3401x.m2246a("[Native] Successfully loaded SO: %s", str);
                return true;
            } catch (Throwable th) {
                th = th;
                z2 = true;
                C3401x.m2252d(th.getMessage(), new Object[0]);
                C3401x.m2252d("[Native] Failed to load so: %s", str);
                return z2;
            }
        } catch (Throwable th2) {
            th = th2;
            z2 = false;
        }
    }

    /* renamed from: c */
    private synchronized void m2046c() {
        if (!this.f3219j) {
            C3401x.m2252d("[Native] Native crash report has already unregistered.", new Object[0]);
            return;
        }
        try {
            if (unregist() != null) {
                C3401x.m2246a("[Native] Successfully closed native crash report.", new Object[0]);
                this.f3219j = false;
                return;
            }
        } catch (Throwable unused) {
            C3401x.m2251c("[Native] Failed to close native crash report.", new Object[0]);
        }
        try {
            C3403z.m2275a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "enableHandler", null, new Class[]{Boolean.TYPE}, new Object[]{false});
            this.f3219j = false;
            C3401x.m2246a("[Native] Successfully closed native crash report.", new Object[0]);
        } catch (Throwable unused2) {
            C3401x.m2251c("[Native] Failed to close native crash report.", new Object[0]);
            this.f3218i = false;
            this.f3217h = false;
        }
    }

    public void testNativeCrash() {
        if (!this.f3218i) {
            C3401x.m2252d("[Native] Bugly SO file has not been load.", new Object[0]);
        } else {
            testCrash();
        }
    }

    public void testNativeCrash(boolean z, boolean z2, boolean z3) {
        m2039a(16, new StringBuilder().append(z).toString());
        m2039a(17, new StringBuilder().append(z2).toString());
        m2039a(18, new StringBuilder().append(z3).toString());
        testNativeCrash();
    }

    public NativeExceptionHandler getNativeExceptionHandler() {
        return this.f3214e;
    }

    /* renamed from: a */
    protected final void m2049a() {
        long m2298b = C3403z.m2298b() - C3351c.f3139g;
        long m2298b2 = C3403z.m2298b() + 86400000;
        File file = new File(this.f3215f);
        if (file.exists() && file.isDirectory()) {
            try {
                File[] listFiles = file.listFiles();
                if (listFiles != null && listFiles.length != 0) {
                    int i = 0;
                    int i2 = 0;
                    for (File file2 : listFiles) {
                        long lastModified = file2.lastModified();
                        if (lastModified < m2298b || lastModified >= m2298b2) {
                            C3401x.m2246a("[Native] Delete record file: %s", file2.getAbsolutePath());
                            i++;
                            if (file2.delete()) {
                                i2++;
                            }
                        }
                    }
                    C3401x.m2251c("[Native] Number of record files overdue: %d, has deleted: %d", Integer.valueOf(i), Integer.valueOf(i2));
                }
            } catch (Throwable th) {
                C3401x.m2247a(th);
            }
        }
    }

    public void removeEmptyNativeRecordFiles() {
        C3358b.m2060c(this.f3215f);
    }

    /* renamed from: b */
    private synchronized void m2043b(boolean z) {
        if (z) {
            startNativeMonitor();
        } else {
            m2046c();
        }
    }

    public synchronized boolean isUserOpened() {
        return this.f3220k;
    }

    /* renamed from: c */
    private synchronized void m2047c(boolean z) {
        if (this.f3220k != z) {
            C3401x.m2246a("user change native %b", Boolean.valueOf(z));
            this.f3220k = z;
        }
    }

    public synchronized void setUserOpened(boolean z) {
        m2047c(z);
        boolean isUserOpened = isUserOpened();
        C3340a m1927a = C3340a.m1927a();
        if (m1927a != null) {
            isUserOpened = isUserOpened && m1927a.m1937c().f3000e;
        }
        if (isUserOpened != this.f3219j) {
            C3401x.m2246a("native changed to %b", Boolean.valueOf(isUserOpened));
            m2043b(isUserOpened);
        }
    }

    public synchronized void onStrategyChanged(StrategyBean strategyBean) {
        if (strategyBean != null) {
            if (strategyBean.f3000e != this.f3219j) {
                C3401x.m2252d("server native changed to %b", Boolean.valueOf(strategyBean.f3000e));
            }
        }
        boolean z = C3340a.m1927a().m1937c().f3000e && this.f3220k;
        if (z != this.f3219j) {
            C3401x.m2246a("native changed to %b", Boolean.valueOf(z));
            m2043b(z);
        }
    }

    public boolean appendLogToNative(String str, String str2, String str3) {
        if ((this.f3217h || this.f3218i) && f3208l && str != null && str2 != null && str3 != null) {
            try {
                if (this.f3218i) {
                    return appendNativeLog(str, str2, str3);
                }
                Boolean bool = (Boolean) C3403z.m2275a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "appendNativeLog", null, new Class[]{String.class, String.class, String.class}, new Object[]{str, str2, str3});
                if (bool != null) {
                    return bool.booleanValue();
                }
                return false;
            } catch (UnsatisfiedLinkError unused) {
                f3208l = false;
            } catch (Throwable th) {
                if (!C3401x.m2247a(th)) {
                    th.printStackTrace();
                }
                return false;
            }
        }
        return false;
    }

    public String getLogFromNative() {
        if ((!this.f3217h && !this.f3218i) || !f3208l) {
            return null;
        }
        try {
            if (this.f3218i) {
                return getNativeLog();
            }
            return (String) C3403z.m2275a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "getNativeLog", null, null, null);
        } catch (UnsatisfiedLinkError unused) {
            f3208l = false;
            return null;
        } catch (Throwable th) {
            if (!C3401x.m2247a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    public boolean putKeyValueToNative(String str, String str2) {
        if ((this.f3217h || this.f3218i) && f3208l && str != null && str2 != null) {
            try {
                if (this.f3218i) {
                    return putNativeKeyValue(str, str2);
                }
                Boolean bool = (Boolean) C3403z.m2275a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "putNativeKeyValue", null, new Class[]{String.class, String.class}, new Object[]{str, str2});
                if (bool != null) {
                    return bool.booleanValue();
                }
                return false;
            } catch (UnsatisfiedLinkError unused) {
                f3208l = false;
            } catch (Throwable th) {
                if (!C3401x.m2247a(th)) {
                    th.printStackTrace();
                }
                return false;
            }
        }
        return false;
    }

    /* renamed from: a */
    private boolean m2039a(int i, String str) {
        if (this.f3218i && f3209m) {
            try {
                setNativeInfo(i, str);
                return true;
            } catch (UnsatisfiedLinkError unused) {
                f3209m = false;
            } catch (Throwable th) {
                if (!C3401x.m2247a(th)) {
                    th.printStackTrace();
                }
                return false;
            }
        }
        return false;
    }

    public boolean filterSigabrtSysLog() {
        return m2039a(998, BooleanUtils.TRUE);
    }

    public boolean setNativeAppVersion(String str) {
        return m2039a(10, str);
    }

    public boolean setNativeAppChannel(String str) {
        return m2039a(12, str);
    }

    public boolean setNativeAppPackage(String str) {
        return m2039a(13, str);
    }

    public boolean setNativeUserId(String str) {
        return m2039a(11, str);
    }

    @Override // com.tencent.bugly.crashreport.InterfaceC3332a
    public boolean setNativeIsAppForeground(boolean z) {
        return m2039a(14, z ? BooleanUtils.TRUE : "false");
    }

    public boolean setNativeLaunchTime(long j) {
        try {
            return m2039a(15, String.valueOf(j));
        } catch (NumberFormatException e) {
            if (C3401x.m2247a(e)) {
                return false;
            }
            e.printStackTrace();
            return false;
        }
    }

    public void enableCatchAnrTrace() {
        if (Build.VERSION.SDK_INT > 29 || Build.VERSION.SDK_INT < 26 || !C3338b.m1905c(this.f3211b).contains("Oppo")) {
            return;
        }
        JNI_CALL_TYPE |= 2;
    }

    public boolean isEnableCatchAnrTrace() {
        return (JNI_CALL_TYPE & 2) == 2;
    }
}