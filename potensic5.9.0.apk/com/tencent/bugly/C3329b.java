package com.tencent.bugly;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.bugly.crashreport.biz.C3335b;
import com.tencent.bugly.crashreport.common.info.C3337a;
import com.tencent.bugly.crashreport.common.strategy.C3340a;
import com.tencent.bugly.proguard.C3391n;
import com.tencent.bugly.proguard.C3393p;
import com.tencent.bugly.proguard.C3398u;
import com.tencent.bugly.proguard.C3401x;
import com.tencent.bugly.proguard.C3402y;
import com.tencent.bugly.proguard.C3403z;
import com.tencent.bugly.proguard.InterfaceC3392o;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.b */
/* loaded from: classes3.dex */
public final class C3329b {

    /* renamed from: a */
    public static boolean f2867a = true;

    /* renamed from: b */
    public static List<AbstractC3328a> f2868b = new ArrayList();

    /* renamed from: c */
    public static boolean f2869c;

    /* renamed from: d */
    private static C3393p f2870d;

    /* renamed from: e */
    private static boolean f2871e;

    /* renamed from: a */
    private static boolean m1805a(C3337a c3337a) {
        List<String> list = c3337a.f2982p;
        c3337a.getClass();
        return list != null && list.contains("bugly");
    }

    /* renamed from: a */
    public static synchronized void m1801a(Context context) {
        synchronized (C3329b.class) {
            m1802a(context, null);
        }
    }

    /* renamed from: a */
    public static synchronized void m1802a(Context context, BuglyStrategy buglyStrategy) {
        synchronized (C3329b.class) {
            if (f2871e) {
                C3401x.m2252d("[init] initial Multi-times, ignore this.", new Object[0]);
                return;
            }
            if (context == null) {
                Log.w(C3401x.f3473a, "[init] context of init() is null, check it.");
                return;
            }
            C3337a m1854a = C3337a.m1854a(context);
            if (m1805a(m1854a)) {
                f2867a = false;
                return;
            }
            String m1876f = m1854a.m1876f();
            if (m1876f == null) {
                Log.e(C3401x.f3473a, "[init] meta data of BUGLY_APPID in AndroidManifest.xml should be set.");
            } else {
                m1803a(context, m1876f, m1854a.f2988v, buglyStrategy);
            }
        }
    }

    /* renamed from: a */
    public static synchronized void m1803a(Context context, String str, boolean z, BuglyStrategy buglyStrategy) {
        byte[] bArr;
        synchronized (C3329b.class) {
            if (f2871e) {
                C3401x.m2252d("[init] initial Multi-times, ignore this.", new Object[0]);
                return;
            }
            if (context == null) {
                Log.w(C3401x.f3473a, "[init] context is null, check it.");
                return;
            }
            if (str == null) {
                Log.e(C3401x.f3473a, "init arg 'crashReportAppID' should not be null!");
                return;
            }
            f2871e = true;
            if (z) {
                f2869c = true;
                C3401x.f3474b = true;
                C3401x.m2252d("Bugly debug模式开启，请在发布时把isDebug关闭。 -- Running in debug model for 'isDebug' is enabled. Please disable it when you release.", new Object[0]);
                C3401x.m2253e("--------------------------------------------------------------------------------------------", new Object[0]);
                C3401x.m2252d("Bugly debug模式将有以下行为特性 -- The following list shows the behaviour of debug model: ", new Object[0]);
                C3401x.m2252d("[1] 输出详细的Bugly SDK的Log -- More detailed log of Bugly SDK will be output to logcat;", new Object[0]);
                C3401x.m2252d("[2] 每一条Crash都会被立即上报 -- Every crash caught by Bugly will be uploaded immediately.", new Object[0]);
                C3401x.m2252d("[3] 自定义日志将会在Logcat中输出 -- Custom log will be output to logcat.", new Object[0]);
                C3401x.m2253e("--------------------------------------------------------------------------------------------", new Object[0]);
                C3401x.m2249b("[init] Open debug mode of Bugly.", new Object[0]);
            }
            C3401x.m2246a(" crash report start initializing...", new Object[0]);
            C3401x.m2249b("[init] Bugly start initializing...", new Object[0]);
            C3401x.m2246a("[init] Bugly complete version: v%s", "3.3.3");
            Context m2271a = C3403z.m2271a(context);
            C3337a m1854a = C3337a.m1854a(m2271a);
            m1854a.m1887o();
            C3402y.m2256a(m2271a);
            f2870d = C3393p.m2188a(m2271a, f2868b);
            C3398u.m2220a(m2271a);
            C3340a m1928a = C3340a.m1928a(m2271a, f2868b);
            C3391n m2166a = C3391n.m2166a(m2271a);
            if (m1805a(m1854a)) {
                f2867a = false;
                return;
            }
            m1854a.m1861a(str);
            C3401x.m2246a("[param] Set APP ID:%s", str);
            if (buglyStrategy != null) {
                String appVersion = buglyStrategy.getAppVersion();
                if (!TextUtils.isEmpty(appVersion)) {
                    if (appVersion.length() > 100) {
                        String substring = appVersion.substring(0, 100);
                        C3401x.m2252d("appVersion %s length is over limit %d substring to %s", appVersion, 100, substring);
                        appVersion = substring;
                    }
                    m1854a.f2977k = appVersion;
                    C3401x.m2246a("[param] Set App version: %s", buglyStrategy.getAppVersion());
                }
                try {
                    if (buglyStrategy.isReplaceOldChannel()) {
                        String appChannel = buglyStrategy.getAppChannel();
                        if (!TextUtils.isEmpty(appChannel)) {
                            if (appChannel.length() > 100) {
                                String substring2 = appChannel.substring(0, 100);
                                C3401x.m2252d("appChannel %s length is over limit %d substring to %s", appChannel, 100, substring2);
                                appChannel = substring2;
                            }
                            f2870d.m2207a(556, "app_channel", appChannel.getBytes(), (InterfaceC3392o) null, false);
                            m1854a.f2979m = appChannel;
                        }
                    } else {
                        Map<String, byte[]> m2205a = f2870d.m2205a(556, (InterfaceC3392o) null, true);
                        if (m2205a != null && (bArr = m2205a.get("app_channel")) != null) {
                            m1854a.f2979m = new String(bArr);
                        }
                    }
                    C3401x.m2246a("[param] Set App channel: %s", m1854a.f2979m);
                } catch (Exception e) {
                    if (f2869c) {
                        e.printStackTrace();
                    }
                }
                String appPackageName = buglyStrategy.getAppPackageName();
                if (!TextUtils.isEmpty(appPackageName)) {
                    if (appPackageName.length() > 100) {
                        String substring3 = appPackageName.substring(0, 100);
                        C3401x.m2252d("appPackageName %s length is over limit %d substring to %s", appPackageName, 100, substring3);
                        appPackageName = substring3;
                    }
                    m1854a.f2969c = appPackageName;
                    C3401x.m2246a("[param] Set App package: %s", buglyStrategy.getAppPackageName());
                }
                String deviceID = buglyStrategy.getDeviceID();
                if (deviceID != null) {
                    if (deviceID.length() > 100) {
                        String substring4 = deviceID.substring(0, 100);
                        C3401x.m2252d("deviceId %s length is over limit %d substring to %s", deviceID, 100, substring4);
                        deviceID = substring4;
                    }
                    m1854a.m1870c(deviceID);
                    C3401x.m2246a("[param] Set device ID: %s", deviceID);
                }
                m1854a.f2971e = buglyStrategy.isUploadProcess();
                C3402y.f3476a = buglyStrategy.isBuglyLogUpload();
            }
            for (int i = 0; i < f2868b.size(); i++) {
                try {
                    if (m2166a.m2177a(f2868b.get(i).f2866id)) {
                        f2868b.get(i).init(m2271a, z, buglyStrategy);
                    }
                } catch (Throwable th) {
                    if (!C3401x.m2247a(th)) {
                        th.printStackTrace();
                    }
                }
            }
            C3335b.m1828a(m2271a, buglyStrategy);
            m1928a.m1933a(buglyStrategy != null ? buglyStrategy.getAppReportDelay() : 0L);
            C3401x.m2249b("[init] Bugly initialization finished.", new Object[0]);
        }
    }

    /* renamed from: a */
    public static synchronized void m1804a(AbstractC3328a abstractC3328a) {
        synchronized (C3329b.class) {
            if (!f2868b.contains(abstractC3328a)) {
                f2868b.add(abstractC3328a);
            }
        }
    }
}