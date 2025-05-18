package com.tencent.bugly;

import com.tencent.bugly.crashreport.common.info.C3337a;
import java.util.Map;

/* compiled from: BUGLY */
/* loaded from: classes3.dex */
public class BuglyStrategy {

    /* renamed from: c */
    private String f2845c;

    /* renamed from: d */
    private String f2846d;

    /* renamed from: e */
    private String f2847e;

    /* renamed from: f */
    private long f2848f;

    /* renamed from: g */
    private String f2849g;

    /* renamed from: h */
    private String f2850h;

    /* renamed from: r */
    private C3327a f2860r;

    /* renamed from: i */
    private boolean f2851i = true;

    /* renamed from: j */
    private boolean f2852j = true;

    /* renamed from: k */
    private boolean f2853k = true;

    /* renamed from: l */
    private boolean f2854l = true;

    /* renamed from: m */
    private Class<?> f2855m = null;

    /* renamed from: n */
    private boolean f2856n = true;

    /* renamed from: o */
    private boolean f2857o = true;

    /* renamed from: p */
    private boolean f2858p = true;

    /* renamed from: q */
    private boolean f2859q = false;

    /* renamed from: a */
    protected int f2843a = 31;

    /* renamed from: b */
    protected boolean f2844b = false;

    public synchronized BuglyStrategy setBuglyLogUpload(boolean z) {
        this.f2856n = z;
        return this;
    }

    public synchronized BuglyStrategy setRecordUserInfoOnceADay(boolean z) {
        this.f2859q = z;
        return this;
    }

    public synchronized BuglyStrategy setUploadProcess(boolean z) {
        this.f2858p = z;
        return this;
    }

    public synchronized boolean isUploadProcess() {
        return this.f2858p;
    }

    public synchronized boolean isBuglyLogUpload() {
        return this.f2856n;
    }

    public synchronized boolean recordUserInfoOnceADay() {
        return this.f2859q;
    }

    public boolean isReplaceOldChannel() {
        return this.f2857o;
    }

    public void setReplaceOldChannel(boolean z) {
        this.f2857o = z;
    }

    public synchronized String getAppVersion() {
        String str = this.f2845c;
        if (str != null) {
            return str;
        }
        return C3337a.m1855b().f2977k;
    }

    public synchronized BuglyStrategy setAppVersion(String str) {
        this.f2845c = str;
        return this;
    }

    public synchronized BuglyStrategy setUserInfoActivity(Class<?> cls) {
        this.f2855m = cls;
        return this;
    }

    public synchronized Class<?> getUserInfoActivity() {
        return this.f2855m;
    }

    public synchronized String getAppChannel() {
        String str = this.f2846d;
        if (str != null) {
            return str;
        }
        return C3337a.m1855b().f2979m;
    }

    public synchronized BuglyStrategy setAppChannel(String str) {
        this.f2846d = str;
        return this;
    }

    public synchronized String getAppPackageName() {
        String str = this.f2847e;
        if (str != null) {
            return str;
        }
        return C3337a.m1855b().f2969c;
    }

    public synchronized BuglyStrategy setAppPackageName(String str) {
        this.f2847e = str;
        return this;
    }

    public synchronized long getAppReportDelay() {
        return this.f2848f;
    }

    public synchronized BuglyStrategy setAppReportDelay(long j) {
        this.f2848f = j;
        return this;
    }

    public synchronized String getLibBuglySOFilePath() {
        return this.f2849g;
    }

    public synchronized BuglyStrategy setLibBuglySOFilePath(String str) {
        this.f2849g = str;
        return this;
    }

    public synchronized String getDeviceID() {
        return this.f2850h;
    }

    public synchronized BuglyStrategy setDeviceID(String str) {
        this.f2850h = str;
        return this;
    }

    public synchronized boolean isEnableNativeCrashMonitor() {
        return this.f2851i;
    }

    public synchronized BuglyStrategy setEnableNativeCrashMonitor(boolean z) {
        this.f2851i = z;
        return this;
    }

    public synchronized BuglyStrategy setEnableUserInfo(boolean z) {
        this.f2854l = z;
        return this;
    }

    public synchronized boolean isEnableUserInfo() {
        return this.f2854l;
    }

    public synchronized boolean isEnableCatchAnrTrace() {
        return this.f2853k;
    }

    public void setEnableCatchAnrTrace(boolean z) {
        this.f2853k = z;
    }

    public synchronized boolean isEnableANRCrashMonitor() {
        return this.f2852j;
    }

    public synchronized BuglyStrategy setEnableANRCrashMonitor(boolean z) {
        this.f2852j = z;
        return this;
    }

    public synchronized C3327a getCrashHandleCallback() {
        return this.f2860r;
    }

    public synchronized BuglyStrategy setCrashHandleCallback(C3327a c3327a) {
        this.f2860r = c3327a;
        return this;
    }

    public synchronized void setCallBackType(int i) {
        this.f2843a = i;
    }

    public synchronized int getCallBackType() {
        return this.f2843a;
    }

    public synchronized void setCloseErrorCallback(boolean z) {
        this.f2844b = z;
    }

    public synchronized boolean getCloseErrorCallback() {
        return this.f2844b;
    }

    /* compiled from: BUGLY */
    /* renamed from: com.tencent.bugly.BuglyStrategy$a */
    public static class C3327a {
        public static final int CRASHTYPE_ANR = 4;
        public static final int CRASHTYPE_BLOCK = 7;
        public static final int CRASHTYPE_COCOS2DX_JS = 5;
        public static final int CRASHTYPE_COCOS2DX_LUA = 6;
        public static final int CRASHTYPE_JAVA_CATCH = 1;
        public static final int CRASHTYPE_JAVA_CRASH = 0;
        public static final int CRASHTYPE_NATIVE = 2;
        public static final int CRASHTYPE_U3D = 3;
        public static final int MAX_USERDATA_KEY_LENGTH = 100;
        public static final int MAX_USERDATA_VALUE_LENGTH = 30000;

        public synchronized Map<String, String> onCrashHandleStart(int i, String str, String str2, String str3) {
            return null;
        }

        public synchronized byte[] onCrashHandleStart2GetExtraDatas(int i, String str, String str2, String str3) {
            return null;
        }
    }
}