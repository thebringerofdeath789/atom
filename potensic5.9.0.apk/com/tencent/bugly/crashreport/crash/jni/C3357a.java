package com.tencent.bugly.crashreport.crash.jni;

import android.content.Context;
import com.tencent.bugly.crashreport.common.info.C3337a;
import com.tencent.bugly.crashreport.common.info.C3338b;
import com.tencent.bugly.crashreport.common.strategy.C3340a;
import com.tencent.bugly.crashreport.crash.C3350b;
import com.tencent.bugly.crashreport.crash.C3351c;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.proguard.C3401x;
import com.tencent.bugly.proguard.C3402y;
import com.tencent.bugly.proguard.C3403z;
import java.util.Map;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.crashreport.crash.jni.a */
/* loaded from: classes3.dex */
public final class C3357a implements NativeExceptionHandler {

    /* renamed from: a */
    private final Context f3223a;

    /* renamed from: b */
    private final C3350b f3224b;

    /* renamed from: c */
    private final C3337a f3225c;

    /* renamed from: d */
    private final C3340a f3226d;

    public C3357a(Context context, C3337a c3337a, C3350b c3350b, C3340a c3340a) {
        this.f3223a = context;
        this.f3224b = c3350b;
        this.f3225c = c3337a;
        this.f3226d = c3340a;
    }

    @Override // com.tencent.bugly.crashreport.crash.jni.NativeExceptionHandler
    public final CrashDetailBean packageCrashDatas(String str, String str2, long j, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, byte[] bArr, Map<String, String> map, boolean z, boolean z2) {
        int i;
        String str12;
        int indexOf;
        boolean m2011l = C3351c.m1990a().m2011l();
        if (m2011l) {
            C3401x.m2253e("This Crash Caused By ANR , PLS To Fix ANR , This Trace May Be Not Useful!", new Object[0]);
        }
        CrashDetailBean crashDetailBean = new CrashDetailBean();
        crashDetailBean.f3059b = 1;
        crashDetailBean.f3062e = this.f3225c.m1880h();
        crashDetailBean.f3063f = this.f3225c.f2977k;
        crashDetailBean.f3064g = this.f3225c.m1889q();
        crashDetailBean.f3070m = this.f3225c.m1878g();
        crashDetailBean.f3071n = str3;
        crashDetailBean.f3072o = m2011l ? " This Crash Caused By ANR , PLS To Fix ANR , This Trace May Be Not Useful![Bugly]" : "";
        crashDetailBean.f3073p = str4;
        crashDetailBean.f3074q = str5 != null ? str5 : "";
        crashDetailBean.f3075r = j;
        crashDetailBean.f3078u = C3403z.m2284a(crashDetailBean.f3074q.getBytes());
        crashDetailBean.f3034A = str;
        crashDetailBean.f3035B = str2;
        crashDetailBean.f3042I = this.f3225c.m1891s();
        crashDetailBean.f3065h = this.f3225c.m1888p();
        crashDetailBean.f3066i = this.f3225c.m1857B();
        crashDetailBean.f3079v = str8;
        NativeCrashHandler nativeCrashHandler = NativeCrashHandler.getInstance();
        String dumpFilePath = nativeCrashHandler != null ? nativeCrashHandler.getDumpFilePath() : null;
        String m2055a = C3358b.m2055a(dumpFilePath, str8);
        if (!C3403z.m2294a(m2055a)) {
            crashDetailBean.f3055V = m2055a;
        }
        crashDetailBean.f3056W = C3358b.m2057b(dumpFilePath);
        crashDetailBean.f3080w = C3358b.m2054a(str9, C3351c.f3137e, null, false);
        crashDetailBean.f3081x = C3358b.m2054a(str10, C3351c.f3137e, null, true);
        crashDetailBean.f3043J = str7;
        crashDetailBean.f3044K = str6;
        crashDetailBean.f3045L = str11;
        crashDetailBean.f3039F = this.f3225c.m1883k();
        crashDetailBean.f3040G = this.f3225c.m1882j();
        crashDetailBean.f3041H = this.f3225c.m1884l();
        if (z) {
            crashDetailBean.f3036C = C3338b.m1912g();
            crashDetailBean.f3037D = C3338b.m1908e();
            crashDetailBean.f3038E = C3338b.m1916i();
            if (crashDetailBean.f3080w == null) {
                crashDetailBean.f3080w = C3403z.m2279a(this.f3223a, C3351c.f3137e, (String) null);
            }
            crashDetailBean.f3082y = C3402y.m2259a();
            crashDetailBean.f3046M = this.f3225c.f2952a;
            crashDetailBean.f3047N = this.f3225c.m1864a();
            crashDetailBean.f3083z = C3403z.m2287a(C3351c.f3138f, false);
            int indexOf2 = crashDetailBean.f3074q.indexOf("java:\n");
            if (indexOf2 > 0 && (i = indexOf2 + 6) < crashDetailBean.f3074q.length()) {
                String substring = crashDetailBean.f3074q.substring(i, crashDetailBean.f3074q.length() - 1);
                if (substring.length() > 0 && crashDetailBean.f3083z.containsKey(crashDetailBean.f3035B) && (indexOf = (str12 = crashDetailBean.f3083z.get(crashDetailBean.f3035B)).indexOf(substring)) > 0) {
                    String substring2 = str12.substring(indexOf);
                    crashDetailBean.f3083z.put(crashDetailBean.f3035B, substring2);
                    crashDetailBean.f3074q = crashDetailBean.f3074q.substring(0, i);
                    crashDetailBean.f3074q += substring2;
                }
            }
            if (str == null) {
                crashDetailBean.f3034A = this.f3225c.f2970d;
            }
            this.f3224b.m1988d(crashDetailBean);
            crashDetailBean.f3050Q = this.f3225c.m1898z();
            crashDetailBean.f3051R = this.f3225c.m1856A();
            crashDetailBean.f3052S = this.f3225c.m1892t();
            crashDetailBean.f3053T = this.f3225c.m1897y();
        } else {
            crashDetailBean.f3036C = -1L;
            crashDetailBean.f3037D = -1L;
            crashDetailBean.f3038E = -1L;
            if (crashDetailBean.f3080w == null) {
                crashDetailBean.f3080w = "this crash is occurred at last process! Log is miss, when get an terrible ABRT Native Exception etc.";
            }
            crashDetailBean.f3046M = -1L;
            crashDetailBean.f3050Q = -1;
            crashDetailBean.f3051R = -1;
            crashDetailBean.f3052S = map;
            crashDetailBean.f3053T = this.f3225c.m1897y();
            crashDetailBean.f3083z = null;
            if (str == null) {
                crashDetailBean.f3034A = "unknown(record)";
            }
            if (bArr != null) {
                crashDetailBean.f3082y = bArr;
            }
        }
        return crashDetailBean;
    }

    @Override // com.tencent.bugly.crashreport.crash.jni.NativeExceptionHandler
    public final void handleNativeException(int i, int i2, long j, long j2, String str, String str2, String str3, String str4, int i3, String str5, int i4, int i5, int i6, String str6, String str7) {
        C3401x.m2246a("Native Crash Happen v1", new Object[0]);
        handleNativeException2(i, i2, j, j2, str, str2, str3, str4, i3, str5, i4, i5, i6, str6, str7, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x0125 A[Catch: all -> 0x02af, TryCatch #2 {all -> 0x02af, blocks: (B:3:0x0010, B:6:0x001c, B:7:0x0071, B:10:0x0079, B:12:0x007c, B:14:0x0080, B:16:0x009b, B:19:0x00a4, B:18:0x00ae, B:23:0x00b8, B:25:0x00c2, B:27:0x00ca, B:28:0x00d6, B:30:0x00e0, B:33:0x00e7, B:34:0x00f6, B:36:0x0102, B:39:0x0109, B:40:0x011f, B:42:0x0125, B:45:0x0135, B:47:0x0159, B:48:0x019b, B:50:0x01c0, B:51:0x01c7, B:54:0x01d3, B:56:0x01db, B:93:0x0175, B:94:0x00f2, B:96:0x00b1, B:99:0x0045, B:100:0x0049, B:102:0x0053), top: B:2:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0159 A[Catch: all -> 0x02af, TryCatch #2 {all -> 0x02af, blocks: (B:3:0x0010, B:6:0x001c, B:7:0x0071, B:10:0x0079, B:12:0x007c, B:14:0x0080, B:16:0x009b, B:19:0x00a4, B:18:0x00ae, B:23:0x00b8, B:25:0x00c2, B:27:0x00ca, B:28:0x00d6, B:30:0x00e0, B:33:0x00e7, B:34:0x00f6, B:36:0x0102, B:39:0x0109, B:40:0x011f, B:42:0x0125, B:45:0x0135, B:47:0x0159, B:48:0x019b, B:50:0x01c0, B:51:0x01c7, B:54:0x01d3, B:56:0x01db, B:93:0x0175, B:94:0x00f2, B:96:0x00b1, B:99:0x0045, B:100:0x0049, B:102:0x0053), top: B:2:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x01c0 A[Catch: all -> 0x02af, TryCatch #2 {all -> 0x02af, blocks: (B:3:0x0010, B:6:0x001c, B:7:0x0071, B:10:0x0079, B:12:0x007c, B:14:0x0080, B:16:0x009b, B:19:0x00a4, B:18:0x00ae, B:23:0x00b8, B:25:0x00c2, B:27:0x00ca, B:28:0x00d6, B:30:0x00e0, B:33:0x00e7, B:34:0x00f6, B:36:0x0102, B:39:0x0109, B:40:0x011f, B:42:0x0125, B:45:0x0135, B:47:0x0159, B:48:0x019b, B:50:0x01c0, B:51:0x01c7, B:54:0x01d3, B:56:0x01db, B:93:0x0175, B:94:0x00f2, B:96:0x00b1, B:99:0x0045, B:100:0x0049, B:102:0x0053), top: B:2:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x01d3 A[Catch: all -> 0x02af, TRY_ENTER, TryCatch #2 {all -> 0x02af, blocks: (B:3:0x0010, B:6:0x001c, B:7:0x0071, B:10:0x0079, B:12:0x007c, B:14:0x0080, B:16:0x009b, B:19:0x00a4, B:18:0x00ae, B:23:0x00b8, B:25:0x00c2, B:27:0x00ca, B:28:0x00d6, B:30:0x00e0, B:33:0x00e7, B:34:0x00f6, B:36:0x0102, B:39:0x0109, B:40:0x011f, B:42:0x0125, B:45:0x0135, B:47:0x0159, B:48:0x019b, B:50:0x01c0, B:51:0x01c7, B:54:0x01d3, B:56:0x01db, B:93:0x0175, B:94:0x00f2, B:96:0x00b1, B:99:0x0045, B:100:0x0049, B:102:0x0053), top: B:2:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x023c A[Catch: all -> 0x02ab, TryCatch #1 {all -> 0x02ab, blocks: (B:62:0x0236, B:64:0x023c, B:66:0x0245), top: B:61:0x0236 }] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0245 A[Catch: all -> 0x02ab, TRY_LEAVE, TryCatch #1 {all -> 0x02ab, blocks: (B:62:0x0236, B:64:0x023c, B:66:0x0245), top: B:61:0x0236 }] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0155 A[SYNTHETIC] */
    @Override // com.tencent.bugly.crashreport.crash.jni.NativeExceptionHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void handleNativeException2(int r27, int r28, long r29, long r31, java.lang.String r33, java.lang.String r34, java.lang.String r35, java.lang.String r36, int r37, java.lang.String r38, int r39, int r40, int r41, java.lang.String r42, java.lang.String r43, java.lang.String[] r44) {
        /*
            Method dump skipped, instructions count: 699
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.crash.jni.C3357a.handleNativeException2(int, int, long, long, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, java.lang.String, int, int, int, java.lang.String, java.lang.String, java.lang.String[]):void");
    }
}