package com.tencent.bugly;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.bugly.crashreport.common.info.C3337a;
import com.tencent.bugly.proguard.C3393p;
import com.tencent.bugly.proguard.C3401x;
import com.tencent.bugly.proguard.C3403z;
import com.tencent.bugly.proguard.InterfaceC3392o;
import java.util.Map;

/* compiled from: BUGLY */
/* loaded from: classes3.dex */
public class Bugly {
    public static final String SDK_IS_DEV = "false";

    /* renamed from: a */
    private static boolean f2840a = false;
    public static Context applicationContext = null;

    /* renamed from: b */
    private static String[] f2841b = {"BuglyCrashModule", "BuglyRqdModule", "BuglyBetaModule"};

    /* renamed from: c */
    private static String[] f2842c = {"BuglyRqdModule", "BuglyCrashModule", "BuglyBetaModule"};
    public static boolean enable = true;
    public static Boolean isDev;

    public static void init(Context context, String str, boolean z) {
        init(context, str, z, null);
    }

    public static synchronized void init(Context context, String str, boolean z, BuglyStrategy buglyStrategy) {
        synchronized (Bugly.class) {
            if (f2840a) {
                return;
            }
            f2840a = true;
            Context m2271a = C3403z.m2271a(context);
            applicationContext = m2271a;
            if (m2271a == null) {
                Log.e(C3401x.f3473a, "init arg 'context' should not be null!");
                return;
            }
            if (isDev()) {
                f2841b = f2842c;
            }
            for (String str2 : f2841b) {
                try {
                    if (str2.equals("BuglyCrashModule")) {
                        C3329b.m1804a(CrashModule.getInstance());
                    } else if (!str2.equals("BuglyBetaModule") && !str2.equals("BuglyRqdModule")) {
                        str2.equals("BuglyFeedbackModule");
                    }
                } catch (Throwable th) {
                    C3401x.m2250b(th);
                }
            }
            C3329b.f2867a = enable;
            C3329b.m1803a(applicationContext, str, z, buglyStrategy);
        }
    }

    public static synchronized String getAppChannel() {
        byte[] bArr;
        synchronized (Bugly.class) {
            C3337a m1855b = C3337a.m1855b();
            if (m1855b == null) {
                return null;
            }
            if (TextUtils.isEmpty(m1855b.f2979m)) {
                C3393p m2187a = C3393p.m2187a();
                if (m2187a == null) {
                    return m1855b.f2979m;
                }
                Map<String, byte[]> m2205a = m2187a.m2205a(556, (InterfaceC3392o) null, true);
                if (m2205a != null && (bArr = m2205a.get("app_channel")) != null) {
                    return new String(bArr);
                }
            }
            return m1855b.f2979m;
        }
    }

    public static boolean isDev() {
        if (isDev == null) {
            isDev = Boolean.valueOf(Boolean.parseBoolean("false".replace("@", "")));
        }
        return isDev.booleanValue();
    }
}