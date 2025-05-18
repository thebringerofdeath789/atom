package com.tencent.bugly.crashreport;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.tencent.bugly.BuglyStrategy;
import com.tencent.bugly.C3329b;
import com.tencent.bugly.CrashModule;
import com.tencent.bugly.crashreport.biz.C3335b;
import com.tencent.bugly.crashreport.common.info.C3337a;
import com.tencent.bugly.crashreport.common.strategy.C3340a;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.crashreport.crash.BuglyBroadcastReceiver;
import com.tencent.bugly.crashreport.crash.C3351c;
import com.tencent.bugly.crashreport.crash.C3352d;
import com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler;
import com.tencent.bugly.crashreport.crash.p032h5.C3355b;
import com.tencent.bugly.crashreport.crash.p032h5.H5JavaScriptInterface;
import com.tencent.bugly.proguard.C3360a;
import com.tencent.bugly.proguard.C3394q;
import com.tencent.bugly.proguard.C3400w;
import com.tencent.bugly.proguard.C3401x;
import com.tencent.bugly.proguard.C3403z;
import java.net.InetAddress;
import java.net.Proxy;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* compiled from: BUGLY */
/* loaded from: classes3.dex */
public class CrashReport {

    /* renamed from: a */
    private static Context f2872a;

    /* compiled from: BUGLY */
    public static class CrashHandleCallback extends BuglyStrategy.C3327a {
    }

    /* compiled from: BUGLY */
    public interface WebViewInterface {
        void addJavascriptInterface(H5JavaScriptInterface h5JavaScriptInterface, String str);

        CharSequence getContentDescription();

        String getUrl();

        void loadUrl(String str);

        void setJavaScriptEnabled(boolean z);
    }

    public static void enableBugly(boolean z) {
        C3329b.f2867a = z;
    }

    public static void initCrashReport(Context context) {
        if (context == null) {
            return;
        }
        f2872a = context;
        C3329b.m1804a(CrashModule.getInstance());
        C3329b.m1801a(context);
    }

    public static void initCrashReport(Context context, UserStrategy userStrategy) {
        if (context == null) {
            return;
        }
        f2872a = context;
        C3329b.m1804a(CrashModule.getInstance());
        C3329b.m1802a(context, userStrategy);
    }

    public static void initCrashReport(Context context, String str, boolean z) {
        if (context != null) {
            f2872a = context;
            C3329b.m1804a(CrashModule.getInstance());
            C3329b.m1803a(context, str, z, null);
        }
    }

    public static void initCrashReport(Context context, String str, boolean z, UserStrategy userStrategy) {
        if (context == null) {
            return;
        }
        f2872a = context;
        C3329b.m1804a(CrashModule.getInstance());
        C3329b.m1803a(context, str, z, userStrategy);
    }

    public static String getBuglyVersion(Context context) {
        if (context == null) {
            C3401x.m2252d("Please call with context.", new Object[0]);
            return "unknown";
        }
        return C3337a.m1854a(context).m1869c();
    }

    public static void testJavaCrash() {
        if (!C3329b.f2867a) {
            Log.w(C3401x.f3473a, "Can not test Java crash because bugly is disable.");
        } else {
            if (!CrashModule.getInstance().hasInitialized()) {
                Log.e(C3401x.f3473a, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
                return;
            }
            C3337a m1855b = C3337a.m1855b();
            if (m1855b != null) {
                m1855b.m1865b(24096);
            }
            throw new RuntimeException("This Crash create for Test! You can go to Bugly see more detail!");
        }
    }

    public static void testNativeCrash() {
        testNativeCrash(false, false, false);
    }

    public static void testNativeCrash(boolean z, boolean z2, boolean z3) {
        if (!C3329b.f2867a) {
            Log.w(C3401x.f3473a, "Can not test native crash because bugly is disable.");
        } else if (!CrashModule.getInstance().hasInitialized()) {
            Log.e(C3401x.f3473a, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
        } else {
            C3401x.m2246a("start to create a native crash for test!", new Object[0]);
            C3351c.m1990a().m2000a(z, z2, z3);
        }
    }

    public static void testANRCrash() {
        if (!C3329b.f2867a) {
            Log.w(C3401x.f3473a, "Can not test ANR crash because bugly is disable.");
        } else if (!CrashModule.getInstance().hasInitialized()) {
            Log.e(C3401x.f3473a, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
        } else {
            C3401x.m2246a("start to create a anr crash for test!", new Object[0]);
            C3351c.m1990a().m2010k();
        }
    }

    public static void postException(Thread thread, int i, String str, String str2, String str3, Map<String, String> map) {
        if (!C3329b.f2867a) {
            Log.w(C3401x.f3473a, "Can not post crash caught because bugly is disable.");
        } else if (!CrashModule.getInstance().hasInitialized()) {
            Log.e(C3401x.f3473a, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
        } else {
            C3352d.m2024a(thread, i, str, str2, str3, map);
        }
    }

    public static void postException(int i, String str, String str2, String str3, Map<String, String> map) {
        postException(Thread.currentThread(), i, str, str2, str3, map);
    }

    public static void postCatchedException(Throwable th) {
        postCatchedException(th, Thread.currentThread(), false);
    }

    public static void postCatchedException(Throwable th, Thread thread) {
        postCatchedException(th, thread, false);
    }

    public static void postCatchedException(Throwable th, Thread thread, boolean z) {
        if (!C3329b.f2867a) {
            Log.w(C3401x.f3473a, "Can not post crash caught because bugly is disable.");
            return;
        }
        if (!CrashModule.getInstance().hasInitialized()) {
            Log.e(C3401x.f3473a, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
            return;
        }
        if (th == null) {
            C3401x.m2252d("throwable is null, just return", new Object[0]);
            return;
        }
        if (thread == null) {
            thread = Thread.currentThread();
        }
        C3351c.m1990a().m1998a(thread, th, false, (String) null, (byte[]) null, z);
    }

    public static void closeNativeReport() {
        if (!C3329b.f2867a) {
            Log.w(C3401x.f3473a, "Can not close native report because bugly is disable.");
        } else if (!CrashModule.getInstance().hasInitialized()) {
            Log.e(C3401x.f3473a, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
        } else {
            C3351c.m1990a().m2005f();
        }
    }

    public static void startCrashReport() {
        if (!C3329b.f2867a) {
            Log.w(C3401x.f3473a, "Can not start crash report because bugly is disable.");
        } else if (!CrashModule.getInstance().hasInitialized()) {
            Log.w(C3401x.f3473a, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
        } else {
            C3351c.m1990a().m2002c();
        }
    }

    public static void closeCrashReport() {
        if (!C3329b.f2867a) {
            Log.w(C3401x.f3473a, "Can not close crash report because bugly is disable.");
        } else if (!CrashModule.getInstance().hasInitialized()) {
            Log.w(C3401x.f3473a, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
        } else {
            C3351c.m1990a().m2003d();
        }
    }

    public static void closeBugly() {
        if (!C3329b.f2867a) {
            Log.w(C3401x.f3473a, "Can not close bugly because bugly is disable.");
            return;
        }
        if (!CrashModule.getInstance().hasInitialized()) {
            Log.w(C3401x.f3473a, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
            return;
        }
        if (f2872a == null) {
            return;
        }
        BuglyBroadcastReceiver buglyBroadcastReceiver = BuglyBroadcastReceiver.getInstance();
        if (buglyBroadcastReceiver != null) {
            buglyBroadcastReceiver.unregister(f2872a);
        }
        closeCrashReport();
        C3335b.m1827a(f2872a);
        C3400w m2238a = C3400w.m2238a();
        if (m2238a != null) {
            m2238a.m2242b();
        }
    }

    public static void setUserSceneTag(Context context, int i) {
        if (!C3329b.f2867a) {
            Log.w(C3401x.f3473a, "Can not set tag caught because bugly is disable.");
            return;
        }
        if (context == null) {
            Log.e(C3401x.f3473a, "setTag args context should not be null");
            return;
        }
        if (i <= 0) {
            C3401x.m2252d("setTag args tagId should > 0", new Object[0]);
        }
        C3337a.m1854a(context).m1860a(i);
        C3401x.m2249b("[param] set user scene tag: %d", Integer.valueOf(i));
    }

    public static int getUserSceneTagId(Context context) {
        if (!C3329b.f2867a) {
            Log.w(C3401x.f3473a, "Can not get user scene tag because bugly is disable.");
            return -1;
        }
        if (context == null) {
            Log.e(C3401x.f3473a, "getUserSceneTagId args context should not be null");
            return -1;
        }
        return C3337a.m1854a(context).m1898z();
    }

    public static String getUserData(Context context, String str) {
        if (!C3329b.f2867a) {
            Log.w(C3401x.f3473a, "Can not get user data because bugly is disable.");
            return "unknown";
        }
        if (context == null) {
            Log.e(C3401x.f3473a, "getUserDataValue args context should not be null");
            return "unknown";
        }
        if (C3403z.m2294a(str)) {
            return null;
        }
        return C3337a.m1854a(context).m1879g(str);
    }

    public static void putUserData(Context context, String str, String str2) {
        if (!C3329b.f2867a) {
            Log.w(C3401x.f3473a, "Can not put user data because bugly is disable.");
            return;
        }
        if (context == null) {
            Log.w(C3401x.f3473a, "putUserData args context should not be null");
            return;
        }
        if (str == null) {
            String str3 = str;
            C3401x.m2252d("putUserData args key should not be null or empty", new Object[0]);
            return;
        }
        if (str2 == null) {
            String str4 = str2;
            C3401x.m2252d("putUserData args value should not be null", new Object[0]);
            return;
        }
        if (str2.length() > 200) {
            C3401x.m2252d("user data value length over limit %d, it will be cutted!", 200);
            str2 = str2.substring(0, 200);
        }
        C3337a m1854a = C3337a.m1854a(context);
        if (m1854a.m1895w().contains(str)) {
            NativeCrashHandler nativeCrashHandler = NativeCrashHandler.getInstance();
            if (nativeCrashHandler != null) {
                nativeCrashHandler.putKeyValueToNative(str, str2);
            }
            C3337a.m1854a(context).m1867b(str, str2);
            C3401x.m2251c("replace KV %s %s", str, str2);
            return;
        }
        if (m1854a.m1894v() >= 50) {
            C3401x.m2252d("user data size is over limit %d, it will be cutted!", 50);
            return;
        }
        if (str.length() > 50) {
            C3401x.m2252d("user data key length over limit %d , will drop this new key %s", 50, str);
            str = str.substring(0, 50);
        }
        NativeCrashHandler nativeCrashHandler2 = NativeCrashHandler.getInstance();
        if (nativeCrashHandler2 != null) {
            nativeCrashHandler2.putKeyValueToNative(str, str2);
        }
        C3337a.m1854a(context).m1867b(str, str2);
        C3401x.m2249b("[param] set user data: %s - %s", str, str2);
    }

    public static String removeUserData(Context context, String str) {
        if (!C3329b.f2867a) {
            Log.w(C3401x.f3473a, "Can not remove user data because bugly is disable.");
            return "unknown";
        }
        if (context == null) {
            Log.e(C3401x.f3473a, "removeUserData args context should not be null");
            return "unknown";
        }
        if (C3403z.m2294a(str)) {
            return null;
        }
        C3401x.m2249b("[param] remove user data: %s", str);
        return C3337a.m1854a(context).m1877f(str);
    }

    public static Set<String> getAllUserDataKeys(Context context) {
        if (!C3329b.f2867a) {
            Log.w(C3401x.f3473a, "Can not get all keys of user data because bugly is disable.");
            return new HashSet();
        }
        if (context == null) {
            Log.e(C3401x.f3473a, "getAllUserDataKeys args context should not be null");
            return new HashSet();
        }
        return C3337a.m1854a(context).m1895w();
    }

    public static int getUserDatasSize(Context context) {
        if (!C3329b.f2867a) {
            Log.w(C3401x.f3473a, "Can not get size of user data because bugly is disable.");
            return -1;
        }
        if (context == null) {
            Log.e(C3401x.f3473a, "getUserDatasSize args context should not be null");
            return -1;
        }
        return C3337a.m1854a(context).m1894v();
    }

    public static String getAppID() {
        if (!C3329b.f2867a) {
            Log.w(C3401x.f3473a, "Can not get App ID because bugly is disable.");
            return "unknown";
        }
        if (!CrashModule.getInstance().hasInitialized()) {
            Log.e(C3401x.f3473a, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
            return "unknown";
        }
        return C3337a.m1854a(f2872a).m1876f();
    }

    public static void setUserId(String str) {
        if (!C3329b.f2867a) {
            Log.w(C3401x.f3473a, "Can not set user ID because bugly is disable.");
        } else if (!CrashModule.getInstance().hasInitialized()) {
            Log.e(C3401x.f3473a, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
        } else {
            setUserId(f2872a, str);
        }
    }

    public static void setUserId(Context context, String str) {
        if (!C3329b.f2867a) {
            Log.w(C3401x.f3473a, "Can not set user ID because bugly is disable.");
            return;
        }
        if (context == null) {
            Log.e(C3401x.f3473a, "Context should not be null when bugly has not been initialed!");
            return;
        }
        if (TextUtils.isEmpty(str)) {
            C3401x.m2252d("userId should not be null", new Object[0]);
            return;
        }
        if (str.length() > 100) {
            String substring = str.substring(0, 100);
            C3401x.m2252d("userId %s length is over limit %d substring to %s", str, 100, substring);
            str = substring;
        }
        if (str.equals(C3337a.m1854a(context).m1878g())) {
            return;
        }
        C3337a.m1854a(context).m1866b(str);
        C3401x.m2249b("[user] set userId : %s", str);
        NativeCrashHandler nativeCrashHandler = NativeCrashHandler.getInstance();
        if (nativeCrashHandler != null) {
            nativeCrashHandler.setNativeUserId(str);
        }
        if (CrashModule.getInstance().hasInitialized()) {
            C3335b.m1825a();
        }
    }

    public static String getUserId() {
        if (!C3329b.f2867a) {
            Log.w(C3401x.f3473a, "Can not get user ID because bugly is disable.");
            return "unknown";
        }
        if (!CrashModule.getInstance().hasInitialized()) {
            Log.e(C3401x.f3473a, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
            return "unknown";
        }
        return C3337a.m1854a(f2872a).m1878g();
    }

    public static String getAppVer() {
        if (!C3329b.f2867a) {
            Log.w(C3401x.f3473a, "Can not get app version because bugly is disable.");
            return "unknown";
        }
        if (!CrashModule.getInstance().hasInitialized()) {
            Log.e(C3401x.f3473a, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
            return "unknown";
        }
        return C3337a.m1854a(f2872a).f2977k;
    }

    public static String getAppChannel() {
        if (!C3329b.f2867a) {
            Log.w(C3401x.f3473a, "Can not get App channel because bugly is disable.");
            return "unknown";
        }
        if (!CrashModule.getInstance().hasInitialized()) {
            Log.e(C3401x.f3473a, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
            return "unknown";
        }
        return C3337a.m1854a(f2872a).f2979m;
    }

    public static void setContext(Context context) {
        f2872a = context;
    }

    public static boolean isLastSessionCrash() {
        if (!C3329b.f2867a) {
            Log.w(C3401x.f3473a, "The info 'isLastSessionCrash' is not accurate because bugly is disable.");
            return false;
        }
        if (!CrashModule.getInstance().hasInitialized()) {
            Log.e(C3401x.f3473a, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
            return false;
        }
        return C3351c.m1990a().m2001b();
    }

    public static void setSdkExtraData(Context context, String str, String str2) {
        if (!C3329b.f2867a) {
            Log.w(C3401x.f3473a, "Can not put SDK extra data because bugly is disable.");
        } else {
            if (context == null || C3403z.m2294a(str) || C3403z.m2294a(str2)) {
                return;
            }
            C3337a.m1854a(context).m1862a(str, str2);
        }
    }

    public static Map<String, String> getSdkExtraData() {
        if (!C3329b.f2867a) {
            Log.w(C3401x.f3473a, "Can not get SDK extra data because bugly is disable.");
            return new HashMap();
        }
        if (!CrashModule.getInstance().hasInitialized()) {
            Log.e(C3401x.f3473a, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
            return null;
        }
        return C3337a.m1854a(f2872a).f2929C;
    }

    public static Map<String, String> getSdkExtraData(Context context) {
        if (!C3329b.f2867a) {
            Log.w(C3401x.f3473a, "Can not get SDK extra data because bugly is disable.");
            return new HashMap();
        }
        if (context == null) {
            C3401x.m2252d("Context should not be null.", new Object[0]);
            return null;
        }
        return C3337a.m1854a(context).f2929C;
    }

    private static void putSdkData(Context context, String str, String str2) {
        if (context == null || C3403z.m2294a(str) || C3403z.m2294a(str2)) {
            return;
        }
        String replace = str.replace("[a-zA-Z[0-9]]+", "");
        if (replace.length() > 100) {
            Log.w(C3401x.f3473a, String.format("putSdkData key length over limit %d, will be cutted.", 50));
            replace = replace.substring(0, 50);
        }
        if (str2.length() > 500) {
            Log.w(C3401x.f3473a, String.format("putSdkData value length over limit %d, will be cutted!", 200));
            str2 = str2.substring(0, 200);
        }
        C3337a.m1854a(context).m1871c(replace, str2);
        C3401x.m2249b(String.format("[param] putSdkData data: %s - %s", replace, str2), new Object[0]);
    }

    public static void setIsAppForeground(Context context, boolean z) {
        if (!C3329b.f2867a) {
            Log.w(C3401x.f3473a, "Can not set 'isAppForeground' because bugly is disable.");
            return;
        }
        if (context == null) {
            C3401x.m2252d("Context should not be null.", new Object[0]);
            return;
        }
        if (z) {
            C3401x.m2251c("App is in foreground.", new Object[0]);
        } else {
            C3401x.m2251c("App is in background.", new Object[0]);
        }
        C3337a.m1854a(context).m1863a(z);
    }

    public static void setIsDevelopmentDevice(Context context, boolean z) {
        if (!C3329b.f2867a) {
            Log.w(C3401x.f3473a, "Can not set 'isDevelopmentDevice' because bugly is disable.");
            return;
        }
        if (context == null) {
            C3401x.m2252d("Context should not be null.", new Object[0]);
            return;
        }
        if (z) {
            C3401x.m2251c("This is a development device.", new Object[0]);
        } else {
            C3401x.m2251c("This is not a development device.", new Object[0]);
        }
        C3337a.m1854a(context).f2927A = z;
    }

    public static void setSessionIntervalMills(long j) {
        if (!C3329b.f2867a) {
            Log.w(C3401x.f3473a, "Can not set 'SessionIntervalMills' because bugly is disable.");
        } else {
            C3335b.m1826a(j);
        }
    }

    public static void setAppVersion(Context context, String str) {
        if (!C3329b.f2867a) {
            Log.w(C3401x.f3473a, "Can not set App version because bugly is disable.");
            return;
        }
        if (context == null) {
            Log.w(C3401x.f3473a, "setAppVersion args context should not be null");
            return;
        }
        if (str == null) {
            Log.w(C3401x.f3473a, "App version is null, will not set");
            return;
        }
        C3337a.m1854a(context).f2977k = str;
        NativeCrashHandler nativeCrashHandler = NativeCrashHandler.getInstance();
        if (nativeCrashHandler != null) {
            nativeCrashHandler.setNativeAppVersion(str);
        }
    }

    public static void setAppChannel(Context context, String str) {
        if (!C3329b.f2867a) {
            Log.w(C3401x.f3473a, "Can not set App channel because Bugly is disable.");
            return;
        }
        if (context == null) {
            Log.w(C3401x.f3473a, "setAppChannel args context should not be null");
            return;
        }
        if (str == null) {
            Log.w(C3401x.f3473a, "App channel is null, will not set");
            return;
        }
        C3337a.m1854a(context).f2979m = str;
        NativeCrashHandler nativeCrashHandler = NativeCrashHandler.getInstance();
        if (nativeCrashHandler != null) {
            nativeCrashHandler.setNativeAppChannel(str);
        }
    }

    public static void setAppPackage(Context context, String str) {
        if (!C3329b.f2867a) {
            Log.w(C3401x.f3473a, "Can not set App package because bugly is disable.");
            return;
        }
        if (context == null) {
            Log.w(C3401x.f3473a, "setAppPackage args context should not be null");
            return;
        }
        if (str == null) {
            Log.w(C3401x.f3473a, "App package is null, will not set");
            return;
        }
        C3337a.m1854a(context).f2969c = str;
        NativeCrashHandler nativeCrashHandler = NativeCrashHandler.getInstance();
        if (nativeCrashHandler != null) {
            nativeCrashHandler.setNativeAppPackage(str);
        }
    }

    public static void setCrashFilter(String str) {
        if (!C3329b.f2867a) {
            Log.w(C3401x.f3473a, "Can not set App package because bugly is disable.");
        } else {
            Log.i(C3401x.f3473a, "Set crash stack filter: " + str);
            C3351c.f3146n = str;
        }
    }

    public static void setCrashRegularFilter(String str) {
        if (!C3329b.f2867a) {
            Log.w(C3401x.f3473a, "Can not set App package because bugly is disable.");
        } else {
            Log.i(C3401x.f3473a, "Set crash stack filter: " + str);
            C3351c.f3147o = str;
        }
    }

    public static void setHandleNativeCrashInJava(boolean z) {
        if (!C3329b.f2867a) {
            Log.w(C3401x.f3473a, "Can not set App package because bugly is disable.");
        } else {
            Log.i(C3401x.f3473a, "Should handle native crash in Java profile after handled in native profile: " + z);
            NativeCrashHandler.setShouldHandleInJava(z);
        }
    }

    public static void setBuglyDbName(String str) {
        if (!C3329b.f2867a) {
            Log.w(C3401x.f3473a, "Can not set DB name because bugly is disable.");
        } else {
            Log.i(C3401x.f3473a, "Set Bugly DB name: " + str);
            C3394q.f3423a = str;
        }
    }

    public static void enableObtainId(Context context, boolean z) {
        if (!C3329b.f2867a) {
            Log.w(C3401x.f3473a, "Can not set DB name because bugly is disable.");
        } else if (context == null) {
            Log.w(C3401x.f3473a, "enableObtainId args context should not be null");
        } else {
            Log.i(C3401x.f3473a, "Enable identification obtaining? " + z);
            C3337a.m1854a(context).m1868b(z);
        }
    }

    public static void setServerUrl(String str) {
        if (C3403z.m2294a(str) || !C3403z.m2308c(str)) {
            Log.i(C3401x.f3473a, "URL is invalid.");
            return;
        }
        C3340a.m1929a(str);
        StrategyBean.f2996a = str;
        StrategyBean.f2997b = str;
    }

    public static boolean setJavascriptMonitor(WebView webView, boolean z) {
        return setJavascriptMonitor(webView, z, false);
    }

    public static boolean setJavascriptMonitor(final WebView webView, boolean z, boolean z2) {
        if (webView == null) {
            Log.w(C3401x.f3473a, "WebView is null.");
            return false;
        }
        return setJavascriptMonitor(new WebViewInterface() { // from class: com.tencent.bugly.crashreport.CrashReport.1
            @Override // com.tencent.bugly.crashreport.CrashReport.WebViewInterface
            public final String getUrl() {
                return webView.getUrl();
            }

            @Override // com.tencent.bugly.crashreport.CrashReport.WebViewInterface
            public final void setJavaScriptEnabled(boolean z3) {
                WebSettings settings = webView.getSettings();
                if (settings.getJavaScriptEnabled()) {
                    return;
                }
                settings.setJavaScriptEnabled(true);
            }

            @Override // com.tencent.bugly.crashreport.CrashReport.WebViewInterface
            public final void loadUrl(String str) {
                webView.loadUrl(str);
            }

            @Override // com.tencent.bugly.crashreport.CrashReport.WebViewInterface
            public final void addJavascriptInterface(H5JavaScriptInterface h5JavaScriptInterface, String str) {
                webView.addJavascriptInterface(h5JavaScriptInterface, str);
            }

            @Override // com.tencent.bugly.crashreport.CrashReport.WebViewInterface
            public final CharSequence getContentDescription() {
                return webView.getContentDescription();
            }
        }, z, z2);
    }

    public static boolean setJavascriptMonitor(WebViewInterface webViewInterface, boolean z) {
        return setJavascriptMonitor(webViewInterface, z, false);
    }

    public static boolean setJavascriptMonitor(WebViewInterface webViewInterface, boolean z, boolean z2) {
        if (webViewInterface == null) {
            Log.w(C3401x.f3473a, "WebViewInterface is null.");
            return false;
        }
        if (!CrashModule.getInstance().hasInitialized()) {
            C3401x.m2253e("CrashReport has not been initialed! please to call method 'initCrashReport' first!", new Object[0]);
            return false;
        }
        C3401x.m2246a("Set Javascript exception monitor of webview.", new Object[0]);
        if (!C3329b.f2867a) {
            Log.w(C3401x.f3473a, "Can not set JavaScript monitor because bugly is disable.");
            return false;
        }
        C3401x.m2251c("URL of webview is %s", webViewInterface.getUrl());
        if (!z2 && Build.VERSION.SDK_INT < 19) {
            C3401x.m2253e("This interface is only available for Android 4.4 or later.", new Object[0]);
            return false;
        }
        C3401x.m2246a("Enable the javascript needed by webview monitor.", new Object[0]);
        webViewInterface.setJavaScriptEnabled(true);
        H5JavaScriptInterface h5JavaScriptInterface = H5JavaScriptInterface.getInstance(webViewInterface);
        if (h5JavaScriptInterface != null) {
            C3401x.m2246a("Add a secure javascript interface to the webview.", new Object[0]);
            webViewInterface.addJavascriptInterface(h5JavaScriptInterface, "exceptionUploader");
        }
        if (z) {
            C3401x.m2246a("Inject bugly.js(v%s) to the webview.", C3355b.m2036b());
            String m2035a = C3355b.m2035a();
            if (m2035a == null) {
                C3401x.m2253e("Failed to inject Bugly.js.", C3355b.m2036b());
                return false;
            }
            webViewInterface.loadUrl("javascript:" + m2035a);
        }
        return true;
    }

    public static void setHttpProxy(String str, int i) {
        C3360a.m2067a(str, i);
    }

    public static void setHttpProxy(InetAddress inetAddress, int i) {
        C3360a.m2068a(inetAddress, i);
    }

    public static Proxy getHttpProxy() {
        return C3360a.m2073b();
    }

    /* compiled from: BUGLY */
    public static class UserStrategy extends BuglyStrategy {

        /* renamed from: c */
        private CrashHandleCallback f2874c;

        public UserStrategy(Context context) {
        }

        @Override // com.tencent.bugly.BuglyStrategy
        public synchronized void setCallBackType(int i) {
            this.f2843a = i;
        }

        @Override // com.tencent.bugly.BuglyStrategy
        public synchronized int getCallBackType() {
            return this.f2843a;
        }

        @Override // com.tencent.bugly.BuglyStrategy
        public synchronized void setCloseErrorCallback(boolean z) {
            this.f2844b = z;
        }

        @Override // com.tencent.bugly.BuglyStrategy
        public synchronized boolean getCloseErrorCallback() {
            return this.f2844b;
        }

        @Override // com.tencent.bugly.BuglyStrategy
        public synchronized CrashHandleCallback getCrashHandleCallback() {
            return this.f2874c;
        }

        public synchronized void setCrashHandleCallback(CrashHandleCallback crashHandleCallback) {
            this.f2874c = crashHandleCallback;
        }
    }
}