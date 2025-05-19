package com.baidu.lbsapi.auth;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.google.android.exoplayer2.source.rtsp.SessionDescription;
import com.ipotensic.baselib.utils.DateUtils;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.UUID;
import javax.xml.transform.OutputKeys;
import org.json.JSONException;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* loaded from: classes.dex */
public class LBSAuthManager {
    public static final int CODE_AUTHENTICATE_SUCC = 0;
    public static final int CODE_AUTHENTICATING = 602;
    public static final int CODE_INNER_ERROR = -1;
    public static final int CODE_KEY_NOT_EXIST = 101;
    public static final int CODE_NETWORK_FAILED = -11;
    public static final int CODE_NETWORK_INVALID = -10;
    public static final int CODE_UNAUTHENTICATE = 601;
    public static final String VERSION = "1.0.26";
    private static Context a;
    private static o d;
    private static int e;
    private static LBSAuthManager g;
    private byte[] i;
    private static Hashtable<String, LBSAuthManagerListener> f = new Hashtable<>();
    private static String j = "";
    private static String k = "";
    private static boolean l = false;
    private static String m = null;
    private e b = null;
    private g c = null;
    private boolean h = false;
    private final Handler n = new k(this, Looper.getMainLooper());

    private LBSAuthManager(Context context) {
        a = context;
        o oVar = d;
        if (oVar != null && !oVar.isAlive()) {
            d = null;
        }
        b.b("BaiduApiAuth SDK Version:1.0.26");
        d();
    }

    private void d() {
        synchronized (LBSAuthManager.class) {
            if (d == null) {
                o oVar = new o("auth");
                d = oVar;
                oVar.start();
                while (d.a == null) {
                    try {
                        b.a("wait for create auth thread.");
                        Thread.sleep(3L);
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                    }
                }
            }
        }
    }

    public static LBSAuthManager getInstance(Context context) {
        if (g == null) {
            synchronized (LBSAuthManager.class) {
                if (g == null) {
                    g = new LBSAuthManager(context);
                }
            }
        } else if (context == null) {
            if (b.a) {
                b.c("input context is null");
                new RuntimeException("here").printStackTrace();
            }
        } else {
            a = context;
        }
        return g;
    }

    public void setPackageName(String str) {
        k = str;
    }

    public void setKey(String str) {
        if (a == null || TextUtils.isEmpty(str)) {
            return;
        }
        j = str;
    }

    public String getKey() {
        Context context = a;
        if (context == null) {
            return "";
        }
        try {
            return getPublicKey(context);
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public String getMCode() {
        Context context = a;
        return context == null ? "" : d.a(context);
    }

    public String getCUID() {
        if (!TextUtils.isEmpty(m)) {
            return m;
        }
        String str = "";
        if (a == null) {
            return "";
        }
        try {
            b.a("mIsPrivacyMode " + l);
            if (l) {
                str = com.baidu.android.bbalbs.common.util.c.a(a);
                m = str;
                b.a("getCUID: " + str);
            } else {
                SharedPreferences sharedPreferences = a.getSharedPreferences("Map_Privacy", 0);
                if (sharedPreferences.contains("cuid")) {
                    str = sharedPreferences.getString("cuid", "");
                } else {
                    str = p.a(UUID.randomUUID().toString().getBytes(), true) + "|MAPSDK001";
                    SharedPreferences.Editor edit = sharedPreferences.edit();
                    edit.putString("cuid", str);
                    edit.apply();
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return str;
    }

    public void setPrivacyMode(boolean z) {
        Context context = a;
        if (context == null) {
            return;
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences("Map_Privacy", 0);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        if (z) {
            edit.putBoolean("privacyMode", z);
            edit.apply();
            l = z;
            return;
        }
        l = sharedPreferences.getBoolean("privacyMode", false);
    }

    public boolean getPrivacyMode() {
        return l;
    }

    public String getPublicKey(Context context) throws PackageManager.NameNotFoundException {
        if (!TextUtils.isEmpty(j)) {
            return j;
        }
        return context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.getString("com.baidu.lbsapi.API_KEY");
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0046, code lost:
    
        if (r6.equals("") != false) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String a(android.content.Context r6, java.lang.String r7) {
        /*
            r5 = this;
            java.lang.String r0 = "无法在AndroidManifest.xml中获取com.baidu.android.lbs.API_KEY的值"
            java.lang.String r1 = ""
            java.lang.String r2 = com.baidu.lbsapi.auth.LBSAuthManager.j
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L10
            java.lang.String r6 = com.baidu.lbsapi.auth.LBSAuthManager.j
            return r6
        L10:
            java.lang.String r2 = r6.getPackageName()
            r3 = 101(0x65, float:1.42E-43)
            android.content.pm.PackageManager r6 = r6.getPackageManager()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L5c
            r4 = 128(0x80, float:1.8E-43)
            android.content.pm.ApplicationInfo r6 = r6.getApplicationInfo(r2, r4)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L5c
            android.os.Bundle r2 = r6.metaData     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L5c
            if (r2 != 0) goto L38
            java.util.Hashtable<java.lang.String, com.baidu.lbsapi.auth.LBSAuthManagerListener> r6 = com.baidu.lbsapi.auth.LBSAuthManager.f     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L5c
            java.lang.Object r6 = r6.get(r7)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L5c
            com.baidu.lbsapi.auth.LBSAuthManagerListener r6 = (com.baidu.lbsapi.auth.LBSAuthManagerListener) r6     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L5c
            if (r6 == 0) goto L6d
            java.lang.String r2 = "AndroidManifest.xml的application中没有meta-data标签"
            java.lang.String r2 = com.baidu.lbsapi.auth.ErrorMessage.a(r3, r2)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L5c
            r6.onAuthResult(r3, r2)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L5c
            goto L6d
        L38:
            android.os.Bundle r6 = r6.metaData     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L5c
            java.lang.String r2 = "com.baidu.lbsapi.API_KEY"
            java.lang.String r6 = r6.getString(r2)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L5c
            if (r6 == 0) goto L48
            boolean r1 = r6.equals(r1)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L5b
            if (r1 == 0) goto L59
        L48:
            java.util.Hashtable<java.lang.String, com.baidu.lbsapi.auth.LBSAuthManagerListener> r1 = com.baidu.lbsapi.auth.LBSAuthManager.f     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L5b
            java.lang.Object r1 = r1.get(r7)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L5b
            com.baidu.lbsapi.auth.LBSAuthManagerListener r1 = (com.baidu.lbsapi.auth.LBSAuthManagerListener) r1     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L5b
            if (r1 == 0) goto L59
            java.lang.String r2 = com.baidu.lbsapi.auth.ErrorMessage.a(r3, r0)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L5b
            r1.onAuthResult(r3, r2)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L5b
        L59:
            r1 = r6
            goto L6d
        L5b:
            r1 = r6
        L5c:
            java.util.Hashtable<java.lang.String, com.baidu.lbsapi.auth.LBSAuthManagerListener> r6 = com.baidu.lbsapi.auth.LBSAuthManager.f
            java.lang.Object r6 = r6.get(r7)
            com.baidu.lbsapi.auth.LBSAuthManagerListener r6 = (com.baidu.lbsapi.auth.LBSAuthManagerListener) r6
            if (r6 == 0) goto L6d
            java.lang.String r7 = com.baidu.lbsapi.auth.ErrorMessage.a(r3, r0)
            r6.onAuthResult(r3, r7)
        L6d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.lbsapi.auth.LBSAuthManager.a(android.content.Context, java.lang.String):java.lang.String");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.length() <= 0 || !jSONObject.has("en")) {
            return;
        }
        if (jSONObject.optInt("en", 0) == 0) {
            if (jSONObject.optString("ck").length() > 0) {
                this.i = c.a(jSONObject.optString("ck").getBytes(StandardCharsets.UTF_8));
            }
        } else {
            a(jSONObject, "ak");
            a(jSONObject, "ck");
            a(jSONObject, "sk");
            a(jSONObject, "uid");
            b(jSONObject);
        }
    }

    private void a(JSONObject jSONObject, String str) {
        if (jSONObject == null || jSONObject.length() <= 0 || str == null || str.length() <= 0 || !jSONObject.has(str)) {
            return;
        }
        try {
            byte[] b = q.b(jSONObject.optString(str));
            if (b != null && b.length > 0) {
                jSONObject.put(str, new String(b, StandardCharsets.UTF_8));
                if ("ck".equals(str)) {
                    this.i = b;
                    return;
                }
                return;
            }
            jSONObject.put(str, "");
            jSONObject.put("decode_status", -1);
        } catch (Exception e2) {
            Log.e("LBSAuthManager", " decodeAuthResult ", e2);
        }
    }

    private void b(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.length() <= 0) {
            return;
        }
        if (jSONObject.has("ck")) {
            jSONObject.remove("ck");
        }
        if (jSONObject.has("en")) {
            jSONObject.remove("en");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(String str, String str2) {
        o oVar;
        if (str == null) {
            str = f();
        }
        Message obtainMessage = this.n.obtainMessage();
        int i = -1;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has(NotificationCompat.CATEGORY_STATUS)) {
                jSONObject.put(NotificationCompat.CATEGORY_STATUS, -1);
            }
            if (!jSONObject.has("current")) {
                jSONObject.put("current", System.currentTimeMillis());
            }
            c(jSONObject.toString());
            if (jSONObject.has("current")) {
                jSONObject.remove("current");
            }
            i = jSONObject.getInt(NotificationCompat.CATEGORY_STATUS);
            obtainMessage.what = i;
            obtainMessage.obj = jSONObject;
            Bundle bundle = new Bundle();
            bundle.putString("listenerKey", str2);
            obtainMessage.setData(bundle);
            this.n.sendMessage(obtainMessage);
        } catch (JSONException e2) {
            e2.printStackTrace();
            obtainMessage.what = i;
            obtainMessage.obj = new JSONObject();
            Bundle bundle2 = new Bundle();
            bundle2.putString("listenerKey", str2);
            obtainMessage.setData(bundle2);
            this.n.sendMessage(obtainMessage);
        }
        o oVar2 = d;
        if (oVar2 != null) {
            oVar2.c();
        }
        e--;
        b.a("httpRequest called mAuthCounter-- = " + e);
        if (e == 0 && (oVar = d) != null) {
            oVar.a();
            d = null;
        }
    }

    private int a(String str) {
        int i = -1;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has(NotificationCompat.CATEGORY_STATUS)) {
                jSONObject.put(NotificationCompat.CATEGORY_STATUS, -1);
            }
            i = jSONObject.getInt(NotificationCompat.CATEGORY_STATUS);
            if (jSONObject.has("current") && i == 0) {
                long j2 = jSONObject.getLong("current");
                long currentTimeMillis = System.currentTimeMillis();
                if ((currentTimeMillis - j2) / 3600000.0d < 24.0d) {
                    if (this.h) {
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DateUtils.YMDHMS2);
                        if (!simpleDateFormat.format(Long.valueOf(currentTimeMillis)).equals(simpleDateFormat.format(Long.valueOf(j2)))) {
                        }
                    }
                }
                i = 601;
            }
            if (jSONObject.has("current") && i == 602) {
                if ((System.currentTimeMillis() - jSONObject.getLong("current")) / 1000 > 180.0d) {
                    return 601;
                }
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return i;
    }

    public String decodeAESMessage(String str) {
        byte[] bArr;
        if (str != null && str.length() > 0 && (bArr = this.i) != null && bArr.length > 0) {
            try {
                byte[] a2 = c.a(str.getBytes(StandardCharsets.UTF_8));
                byte[] bArr2 = this.i;
                return new String(a.a(bArr2, bArr2, a2), StandardCharsets.UTF_8);
            } catch (Exception e2) {
                Log.e("LBSAuthManager", "decodeAESMessage", e2);
            }
        }
        return null;
    }

    public int authenticate(boolean z, String str, Hashtable<String, String> hashtable, LBSAuthManagerListener lBSAuthManagerListener) {
        synchronized (LBSAuthManager.class) {
            if (hashtable != null) {
                String str2 = hashtable.get("zero_auth");
                if (str2 == null) {
                    this.h = false;
                } else {
                    this.h = Integer.valueOf(str2).intValue() == 1;
                }
            } else {
                this.h = false;
            }
            String str3 = System.currentTimeMillis() + "";
            if (lBSAuthManagerListener != null) {
                f.put(str3, lBSAuthManagerListener);
            }
            String a2 = a(a, str3);
            if (a2 != null && !a2.equals("")) {
                e++;
                b.a(" mAuthCounter  ++ = " + e);
                String f2 = f();
                b.a("getAuthMessage from cache:" + f2);
                int a3 = a(f2);
                if (a3 == 601) {
                    try {
                        c(new JSONObject().put(NotificationCompat.CATEGORY_STATUS, 602).toString());
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }
                d();
                o oVar = d;
                if (oVar != null && oVar.a != null) {
                    b.a("mThreadLooper.mHandler = " + d.a);
                    d.a.post(new l(this, a3, z, str3, str, hashtable));
                    return a3;
                }
                return -1;
            }
            return 101;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(String str) {
        String str2;
        JSONObject jSONObject;
        String a2 = a(a, str);
        try {
            jSONObject = new JSONObject(f());
        } catch (JSONException e2) {
            e2.printStackTrace();
            str2 = "";
        }
        if (!jSONObject.has("ak")) {
            return true;
        }
        str2 = jSONObject.getString("ak");
        return (a2 == null || str2 == null || a2.equals(str2)) ? false : true;
    }

    private void a(HashMap<String, String> hashMap, String str, String str2) {
        if (hashMap == null || hashMap.size() <= 0 || str == null || str.length() <= 0 || str2 == null || str2.length() <= 0) {
            return;
        }
        try {
            String a2 = q.a(str2);
            if (a2 != null && a2.length() > 0) {
                hashMap.put(str, a2);
            } else {
                hashMap.put(str, str2);
            }
        } catch (Exception e2) {
            hashMap.put(str, str2);
            Log.e("LBSAuthManager", "encodeAuthParam", e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, String str, Hashtable<String, String> hashtable, String str2) {
        String str3;
        String a2 = a(a, str2);
        if (a2 == null || a2.equals("")) {
            return;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        q.a();
        hashMap.put("pk", q.b() != null ? q.b() : "");
        hashMap.put("url", "https://api.map.baidu.com/sdkcs/verify");
        b.a("url:https://api.map.baidu.com/sdkcs/verify");
        hashMap.put("output", "json");
        a(hashMap, "ak", a2);
        b.a("ak:" + hashMap.get("ak"));
        a(hashMap, "mcode", d.a(a));
        hashMap.put("from", "lbs_yunsdk");
        if (hashtable != null && hashtable.size() > 0) {
            for (Map.Entry<String, String> entry : hashtable.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                if (!TextUtils.isEmpty(key) && !TextUtils.isEmpty(value)) {
                    hashMap.put(key, value);
                }
            }
        }
        String cuid = getCUID();
        b.a("cuid:" + cuid);
        if (!TextUtils.isEmpty(cuid)) {
            hashMap.put("cuid", cuid);
        } else {
            hashMap.put("cuid", "");
        }
        hashMap.put("pcn", a.getPackageName());
        hashMap.put(OutputKeys.VERSION, VERSION);
        hashMap.put("macaddr", "");
        try {
            str3 = d.a();
        } catch (Exception unused) {
            str3 = "";
        }
        if (!TextUtils.isEmpty(str3)) {
            hashMap.put(IjkMediaMeta.IJKM_KEY_LANGUAGE, str3);
        } else {
            hashMap.put(IjkMediaMeta.IJKM_KEY_LANGUAGE, "");
        }
        if (z) {
            hashMap.put("force", z ? "1" : SessionDescription.SUPPORTED_SDP_VERSION);
        }
        if (str == null) {
            hashMap.put("from_service", "");
        } else {
            hashMap.put("from_service", str);
        }
        String e2 = e();
        if (!TextUtils.isEmpty(e2)) {
            hashMap.put("extend", e2);
        }
        e eVar = new e(a);
        this.b = eVar;
        eVar.a(hashMap, new m(this, str2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, String str, Hashtable<String, String> hashtable, String[] strArr, String str2) {
        String str3;
        String a2 = a(a, str2);
        if (a2 == null || a2.equals("")) {
            return;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        q.a();
        hashMap.put("pk", q.b() != null ? q.b() : "");
        hashMap.put("url", "https://api.map.baidu.com/sdkcs/verify");
        hashMap.put("output", "json");
        a(hashMap, "ak", a2);
        hashMap.put("from", "lbs_yunsdk");
        if (hashtable != null && hashtable.size() > 0) {
            for (Map.Entry<String, String> entry : hashtable.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                if (!TextUtils.isEmpty(key) && !TextUtils.isEmpty(value)) {
                    hashMap.put(key, value);
                }
            }
        }
        String cuid = getCUID();
        b.a("sendAuthRequests : cuid: " + cuid);
        if (!TextUtils.isEmpty(cuid)) {
            hashMap.put("cuid", cuid);
        } else {
            hashMap.put("cuid", "");
        }
        hashMap.put("pcn", a.getPackageName());
        hashMap.put(OutputKeys.VERSION, VERSION);
        hashMap.put("macaddr", "");
        try {
            str3 = d.a();
        } catch (Exception unused) {
            str3 = "";
        }
        if (!TextUtils.isEmpty(str3)) {
            hashMap.put(IjkMediaMeta.IJKM_KEY_LANGUAGE, str3);
        } else {
            hashMap.put(IjkMediaMeta.IJKM_KEY_LANGUAGE, "");
        }
        if (z) {
            hashMap.put("force", z ? "1" : SessionDescription.SUPPORTED_SDP_VERSION);
        }
        if (str == null) {
            hashMap.put("from_service", "");
        } else {
            hashMap.put("from_service", str);
        }
        String e2 = e();
        if (!TextUtils.isEmpty(e2)) {
            hashMap.put("extend", e2);
        }
        g gVar = new g(a);
        this.c = gVar;
        gVar.a(hashMap, strArr, new n(this, str2));
    }

    private String e() {
        try {
            JSONObject jSONObject = new JSONObject(f());
            return !jSONObject.has("extend") ? "" : jSONObject.getString("extend");
        } catch (JSONException unused) {
            return "";
        }
    }

    private String f() {
        return a.getSharedPreferences("authStatus_" + a(a), 0).getString(NotificationCompat.CATEGORY_STATUS, "{\"status\":601}");
    }

    private void c(String str) {
        a.getSharedPreferences("authStatus_" + a(a), 0).edit().putString(NotificationCompat.CATEGORY_STATUS, str).commit();
    }

    private String a(Context context) {
        String str;
        try {
            str = a(Process.myPid());
        } catch (IOException unused) {
            str = null;
        }
        return str != null ? str : a.getPackageName();
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0083, code lost:
    
        if (r6 == null) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0073, code lost:
    
        if (r6 == null) goto L44;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:19:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0070  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String a(int r6) throws java.io.IOException {
        /*
            r5 = this;
            r0 = 0
            java.io.File r1 = new java.io.File     // Catch: java.lang.Throwable -> L51 java.io.IOException -> L66 java.io.FileNotFoundException -> L76
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L51 java.io.IOException -> L66 java.io.FileNotFoundException -> L76
            r2.<init>()     // Catch: java.lang.Throwable -> L51 java.io.IOException -> L66 java.io.FileNotFoundException -> L76
            java.lang.String r3 = "/proc/"
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch: java.lang.Throwable -> L51 java.io.IOException -> L66 java.io.FileNotFoundException -> L76
            java.lang.StringBuilder r6 = r2.append(r6)     // Catch: java.lang.Throwable -> L51 java.io.IOException -> L66 java.io.FileNotFoundException -> L76
            java.lang.String r2 = "/cmdline"
            java.lang.StringBuilder r6 = r6.append(r2)     // Catch: java.lang.Throwable -> L51 java.io.IOException -> L66 java.io.FileNotFoundException -> L76
            java.lang.String r6 = r6.toString()     // Catch: java.lang.Throwable -> L51 java.io.IOException -> L66 java.io.FileNotFoundException -> L76
            r1.<init>(r6)     // Catch: java.lang.Throwable -> L51 java.io.IOException -> L66 java.io.FileNotFoundException -> L76
            java.io.FileInputStream r6 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L51 java.io.IOException -> L66 java.io.FileNotFoundException -> L76
            r6.<init>(r1)     // Catch: java.lang.Throwable -> L51 java.io.IOException -> L66 java.io.FileNotFoundException -> L76
            java.io.InputStreamReader r1 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L48 java.io.IOException -> L4d java.io.FileNotFoundException -> L4f
            r1.<init>(r6)     // Catch: java.lang.Throwable -> L48 java.io.IOException -> L4d java.io.FileNotFoundException -> L4f
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L3f java.io.IOException -> L44 java.io.FileNotFoundException -> L46
            r2.<init>(r1)     // Catch: java.lang.Throwable -> L3f java.io.IOException -> L44 java.io.FileNotFoundException -> L46
            java.lang.String r0 = r2.readLine()     // Catch: java.lang.Throwable -> L3d java.io.IOException -> L69 java.io.FileNotFoundException -> L79
            r2.close()
            r1.close()
        L38:
            r6.close()
            goto L86
        L3d:
            r0 = move-exception
            goto L56
        L3f:
            r2 = move-exception
            r4 = r2
            r2 = r0
            r0 = r4
            goto L56
        L44:
            r2 = r0
            goto L69
        L46:
            r2 = r0
            goto L79
        L48:
            r1 = move-exception
            r2 = r0
            r0 = r1
            r1 = r2
            goto L56
        L4d:
            r1 = r0
            goto L68
        L4f:
            r1 = r0
            goto L78
        L51:
            r6 = move-exception
            r1 = r0
            r2 = r1
            r0 = r6
            r6 = r2
        L56:
            if (r2 == 0) goto L5b
            r2.close()
        L5b:
            if (r1 == 0) goto L60
            r1.close()
        L60:
            if (r6 == 0) goto L65
            r6.close()
        L65:
            throw r0
        L66:
            r6 = r0
            r1 = r6
        L68:
            r2 = r1
        L69:
            if (r2 == 0) goto L6e
            r2.close()
        L6e:
            if (r1 == 0) goto L73
            r1.close()
        L73:
            if (r6 == 0) goto L86
            goto L38
        L76:
            r6 = r0
            r1 = r6
        L78:
            r2 = r1
        L79:
            if (r2 == 0) goto L7e
            r2.close()
        L7e:
            if (r1 == 0) goto L83
            r1.close()
        L83:
            if (r6 == 0) goto L86
            goto L38
        L86:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.lbsapi.auth.LBSAuthManager.a(int):java.lang.String");
    }
}
