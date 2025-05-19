package com.tencent.bugly.crashreport.crash.jni;

import android.content.Context;
import android.os.Build;
import com.ipotensic.baselib.netty.Constant;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.crashreport.crash.c;
import com.tencent.bugly.proguard.w;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.z;
import java.io.File;
import org.apache.commons.lang3.BooleanUtils;

/* compiled from: BUGLY */
/* loaded from: classes3.dex */
public class NativeCrashHandler implements com.tencent.bugly.crashreport.a {
    public static int JNI_CALL_TYPE = 1;
    private static NativeCrashHandler a = null;
    private static boolean l = false;
    private static boolean m = false;
    private static boolean o = true;
    private final Context b;
    private final com.tencent.bugly.crashreport.common.info.a c;
    private final w d;
    private NativeExceptionHandler e;
    private String f;
    private final boolean g;
    private boolean h = false;
    private boolean i = false;
    private boolean j = false;
    private boolean k = false;
    private com.tencent.bugly.crashreport.crash.b n;

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

    static /* synthetic */ boolean a(NativeCrashHandler nativeCrashHandler, int i, String str) {
        return nativeCrashHandler.a(999, str);
    }

    private NativeCrashHandler(Context context, com.tencent.bugly.crashreport.common.info.a aVar, com.tencent.bugly.crashreport.crash.b bVar, w wVar, boolean z, String str) {
        this.b = z.a(context);
        try {
            if (z.a(str)) {
                str = context.getDir("bugly", 0).getAbsolutePath();
            }
        } catch (Throwable unused) {
            str = "/data/data/" + com.tencent.bugly.crashreport.common.info.a.a(context).c + "/app_bugly";
        }
        this.n = bVar;
        this.f = str;
        this.c = aVar;
        this.d = wVar;
        this.g = z;
        this.e = new a(context, aVar, bVar, com.tencent.bugly.crashreport.common.strategy.a.a());
    }

    public static synchronized NativeCrashHandler getInstance(Context context, com.tencent.bugly.crashreport.common.info.a aVar, com.tencent.bugly.crashreport.crash.b bVar, com.tencent.bugly.crashreport.common.strategy.a aVar2, w wVar, boolean z, String str) {
        NativeCrashHandler nativeCrashHandler;
        synchronized (NativeCrashHandler.class) {
            if (a == null) {
                a = new NativeCrashHandler(context, aVar, bVar, wVar, z, str);
            }
            nativeCrashHandler = a;
        }
        return nativeCrashHandler;
    }

    public static synchronized NativeCrashHandler getInstance() {
        NativeCrashHandler nativeCrashHandler;
        synchronized (NativeCrashHandler.class) {
            nativeCrashHandler = a;
        }
        return nativeCrashHandler;
    }

    public synchronized String getDumpFilePath() {
        return this.f;
    }

    public synchronized void setDumpFilePath(String str) {
        this.f = str;
    }

    public static void setShouldHandleInJava(boolean z) {
        o = z;
        NativeCrashHandler nativeCrashHandler = a;
        if (nativeCrashHandler != null) {
            nativeCrashHandler.a(999, new StringBuilder().append(z).toString());
        }
    }

    public static boolean isShouldHandleInJava() {
        return o;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(17:40|(1:42)(16:68|(1:70)|44|45|(1:47)|48|(1:50)|52|(1:54)(1:66)|55|(1:57)(1:65)|58|(1:60)|61|62|63)|43|44|45|(0)|48|(0)|52|(0)(0)|55|(0)(0)|58|(0)|61|62|63) */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0081 A[Catch: all -> 0x008f, TryCatch #3 {all -> 0x008f, blocks: (B:45:0x0077, B:47:0x0081, B:48:0x0083, B:50:0x008d), top: B:44:0x0077 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x008d A[Catch: all -> 0x008f, TRY_LEAVE, TryCatch #3 {all -> 0x008f, blocks: (B:45:0x0077, B:47:0x0081, B:48:0x0083, B:50:0x008d), top: B:44:0x0077 }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0093 A[Catch: all -> 0x00f2, TryCatch #0 {all -> 0x00f2, blocks: (B:38:0x0015, B:40:0x001f, B:42:0x0051, B:43:0x005c, B:52:0x008f, B:54:0x0093, B:55:0x00a2, B:57:0x00a6, B:58:0x00b5, B:60:0x00cd, B:61:0x00e1, B:65:0x00ae, B:66:0x009b, B:68:0x0065, B:70:0x006b), top: B:37:0x0015, outer: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00a6 A[Catch: all -> 0x00f2, TryCatch #0 {all -> 0x00f2, blocks: (B:38:0x0015, B:40:0x001f, B:42:0x0051, B:43:0x005c, B:52:0x008f, B:54:0x0093, B:55:0x00a2, B:57:0x00a6, B:58:0x00b5, B:60:0x00cd, B:61:0x00e1, B:65:0x00ae, B:66:0x009b, B:68:0x0065, B:70:0x006b), top: B:37:0x0015, outer: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00cd A[Catch: all -> 0x00f2, TryCatch #0 {all -> 0x00f2, blocks: (B:38:0x0015, B:40:0x001f, B:42:0x0051, B:43:0x005c, B:52:0x008f, B:54:0x0093, B:55:0x00a2, B:57:0x00a6, B:58:0x00b5, B:60:0x00cd, B:61:0x00e1, B:65:0x00ae, B:66:0x009b, B:68:0x0065, B:70:0x006b), top: B:37:0x0015, outer: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00ae A[Catch: all -> 0x00f2, TryCatch #0 {all -> 0x00f2, blocks: (B:38:0x0015, B:40:0x001f, B:42:0x0051, B:43:0x005c, B:52:0x008f, B:54:0x0093, B:55:0x00a2, B:57:0x00a6, B:58:0x00b5, B:60:0x00cd, B:61:0x00e1, B:65:0x00ae, B:66:0x009b, B:68:0x0065, B:70:0x006b), top: B:37:0x0015, outer: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x009b A[Catch: all -> 0x00f2, TryCatch #0 {all -> 0x00f2, blocks: (B:38:0x0015, B:40:0x001f, B:42:0x0051, B:43:0x005c, B:52:0x008f, B:54:0x0093, B:55:0x00a2, B:57:0x00a6, B:58:0x00b5, B:60:0x00cd, B:61:0x00e1, B:65:0x00ae, B:66:0x009b, B:68:0x0065, B:70:0x006b), top: B:37:0x0015, outer: #2 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private synchronized void a(boolean r11) {
        /*
            Method dump skipped, instructions count: 463
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler.a(boolean):void");
    }

    public synchronized void startNativeMonitor() {
        if (!this.i && !this.h) {
            String str = "Bugly";
            boolean z = !z.a(this.c.n);
            String str2 = this.c.n;
            if (z) {
                str = str2;
            } else {
                this.c.getClass();
            }
            boolean a2 = a(str, z);
            this.i = a2;
            if (a2 || this.h) {
                a(this.g);
                if (l) {
                    setNativeAppVersion(this.c.k);
                    setNativeAppChannel(this.c.m);
                    setNativeAppPackage(this.c.c);
                    setNativeUserId(this.c.g());
                    setNativeIsAppForeground(this.c.a());
                    setNativeLaunchTime(this.c.a);
                }
                return;
            }
            return;
        }
        a(this.g);
    }

    public void checkUploadRecordCrash() {
        this.d.a(new Runnable() { // from class: com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler.1
            @Override // java.lang.Runnable
            public final void run() {
                if (z.a(NativeCrashHandler.this.b, "native_record_lock", Constant.DELAY_MILLIS)) {
                    if (!NativeCrashHandler.o) {
                        NativeCrashHandler.a(NativeCrashHandler.this, 999, "false");
                    }
                    CrashDetailBean a2 = b.a(NativeCrashHandler.this.b, NativeCrashHandler.this.f, NativeCrashHandler.this.e);
                    if (a2 != null) {
                        x.a("[Native] Get crash from native record.", new Object[0]);
                        if (!NativeCrashHandler.this.n.a(a2)) {
                            NativeCrashHandler.this.n.a(a2, 3000L, false);
                        }
                        b.a(false, NativeCrashHandler.this.f);
                    }
                    NativeCrashHandler.this.a();
                    z.b(NativeCrashHandler.this.b, "native_record_lock");
                    return;
                }
                x.a("[Native] Failed to lock file for handling native crash record.", new Object[0]);
            }
        });
    }

    private static boolean a(String str, boolean z) {
        boolean z2;
        try {
            x.a("[Native] Trying to load so: %s", str);
            if (z) {
                System.load(str);
            } else {
                System.loadLibrary(str);
            }
            try {
                x.a("[Native] Successfully loaded SO: %s", str);
                return true;
            } catch (Throwable th) {
                th = th;
                z2 = true;
                x.d(th.getMessage(), new Object[0]);
                x.d("[Native] Failed to load so: %s", str);
                return z2;
            }
        } catch (Throwable th2) {
            th = th2;
            z2 = false;
        }
    }

    private synchronized void c() {
        if (!this.j) {
            x.d("[Native] Native crash report has already unregistered.", new Object[0]);
            return;
        }
        try {
            if (unregist() != null) {
                x.a("[Native] Successfully closed native crash report.", new Object[0]);
                this.j = false;
                return;
            }
        } catch (Throwable unused) {
            x.c("[Native] Failed to close native crash report.", new Object[0]);
        }
        try {
            z.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "enableHandler", null, new Class[]{Boolean.TYPE}, new Object[]{false});
            this.j = false;
            x.a("[Native] Successfully closed native crash report.", new Object[0]);
        } catch (Throwable unused2) {
            x.c("[Native] Failed to close native crash report.", new Object[0]);
            this.i = false;
            this.h = false;
        }
    }

    public void testNativeCrash() {
        if (!this.i) {
            x.d("[Native] Bugly SO file has not been load.", new Object[0]);
        } else {
            testCrash();
        }
    }

    public void testNativeCrash(boolean z, boolean z2, boolean z3) {
        a(16, new StringBuilder().append(z).toString());
        a(17, new StringBuilder().append(z2).toString());
        a(18, new StringBuilder().append(z3).toString());
        testNativeCrash();
    }

    public NativeExceptionHandler getNativeExceptionHandler() {
        return this.e;
    }

    protected final void a() {
        long b = z.b() - c.g;
        long b2 = z.b() + 86400000;
        File file = new File(this.f);
        if (file.exists() && file.isDirectory()) {
            try {
                File[] listFiles = file.listFiles();
                if (listFiles != null && listFiles.length != 0) {
                    int i = 0;
                    int i2 = 0;
                    for (File file2 : listFiles) {
                        long lastModified = file2.lastModified();
                        if (lastModified < b || lastModified >= b2) {
                            x.a("[Native] Delete record file: %s", file2.getAbsolutePath());
                            i++;
                            if (file2.delete()) {
                                i2++;
                            }
                        }
                    }
                    x.c("[Native] Number of record files overdue: %d, has deleted: %d", Integer.valueOf(i), Integer.valueOf(i2));
                }
            } catch (Throwable th) {
                x.a(th);
            }
        }
    }

    public void removeEmptyNativeRecordFiles() {
        b.c(this.f);
    }

    private synchronized void b(boolean z) {
        if (z) {
            startNativeMonitor();
        } else {
            c();
        }
    }

    public synchronized boolean isUserOpened() {
        return this.k;
    }

    private synchronized void c(boolean z) {
        if (this.k != z) {
            x.a("user change native %b", Boolean.valueOf(z));
            this.k = z;
        }
    }

    public synchronized void setUserOpened(boolean z) {
        c(z);
        boolean isUserOpened = isUserOpened();
        com.tencent.bugly.crashreport.common.strategy.a a2 = com.tencent.bugly.crashreport.common.strategy.a.a();
        if (a2 != null) {
            isUserOpened = isUserOpened && a2.c().e;
        }
        if (isUserOpened != this.j) {
            x.a("native changed to %b", Boolean.valueOf(isUserOpened));
            b(isUserOpened);
        }
    }

    public synchronized void onStrategyChanged(StrategyBean strategyBean) {
        if (strategyBean != null) {
            if (strategyBean.e != this.j) {
                x.d("server native changed to %b", Boolean.valueOf(strategyBean.e));
            }
        }
        boolean z = com.tencent.bugly.crashreport.common.strategy.a.a().c().e && this.k;
        if (z != this.j) {
            x.a("native changed to %b", Boolean.valueOf(z));
            b(z);
        }
    }

    public boolean appendLogToNative(String str, String str2, String str3) {
        if ((this.h || this.i) && l && str != null && str2 != null && str3 != null) {
            try {
                if (this.i) {
                    return appendNativeLog(str, str2, str3);
                }
                Boolean bool = (Boolean) z.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "appendNativeLog", null, new Class[]{String.class, String.class, String.class}, new Object[]{str, str2, str3});
                if (bool != null) {
                    return bool.booleanValue();
                }
                return false;
            } catch (UnsatisfiedLinkError unused) {
                l = false;
            } catch (Throwable th) {
                if (!x.a(th)) {
                    th.printStackTrace();
                }
                return false;
            }
        }
        return false;
    }

    public String getLogFromNative() {
        if ((!this.h && !this.i) || !l) {
            return null;
        }
        try {
            if (this.i) {
                return getNativeLog();
            }
            return (String) z.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "getNativeLog", null, null, null);
        } catch (UnsatisfiedLinkError unused) {
            l = false;
            return null;
        } catch (Throwable th) {
            if (!x.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    public boolean putKeyValueToNative(String str, String str2) {
        if ((this.h || this.i) && l && str != null && str2 != null) {
            try {
                if (this.i) {
                    return putNativeKeyValue(str, str2);
                }
                Boolean bool = (Boolean) z.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "putNativeKeyValue", null, new Class[]{String.class, String.class}, new Object[]{str, str2});
                if (bool != null) {
                    return bool.booleanValue();
                }
                return false;
            } catch (UnsatisfiedLinkError unused) {
                l = false;
            } catch (Throwable th) {
                if (!x.a(th)) {
                    th.printStackTrace();
                }
                return false;
            }
        }
        return false;
    }

    private boolean a(int i, String str) {
        if (this.i && m) {
            try {
                setNativeInfo(i, str);
                return true;
            } catch (UnsatisfiedLinkError unused) {
                m = false;
            } catch (Throwable th) {
                if (!x.a(th)) {
                    th.printStackTrace();
                }
                return false;
            }
        }
        return false;
    }

    public boolean filterSigabrtSysLog() {
        return a(998, BooleanUtils.TRUE);
    }

    public boolean setNativeAppVersion(String str) {
        return a(10, str);
    }

    public boolean setNativeAppChannel(String str) {
        return a(12, str);
    }

    public boolean setNativeAppPackage(String str) {
        return a(13, str);
    }

    public boolean setNativeUserId(String str) {
        return a(11, str);
    }

    @Override // com.tencent.bugly.crashreport.a
    public boolean setNativeIsAppForeground(boolean z) {
        return a(14, z ? BooleanUtils.TRUE : "false");
    }

    public boolean setNativeLaunchTime(long j) {
        try {
            return a(15, String.valueOf(j));
        } catch (NumberFormatException e) {
            if (x.a(e)) {
                return false;
            }
            e.printStackTrace();
            return false;
        }
    }

    public void enableCatchAnrTrace() {
        if (Build.VERSION.SDK_INT > 29 || Build.VERSION.SDK_INT < 26 || !com.tencent.bugly.crashreport.common.info.b.c(this.b).contains("Oppo")) {
            return;
        }
        JNI_CALL_TYPE |= 2;
    }

    public boolean isEnableCatchAnrTrace() {
        return (JNI_CALL_TYPE & 2) == 2;
    }
}
