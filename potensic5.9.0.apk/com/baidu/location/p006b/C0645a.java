package com.baidu.location.p006b;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.lbsapi.auth.LBSAuthManager;
import com.baidu.location.BDLocation;
import com.baidu.location.Jni;
import com.baidu.location.LocationClientOption;
import com.baidu.location.p012h.AbstractC0725g;
import com.baidu.location.p012h.C0722d;
import com.baidu.location.p012h.C0733o;
import java.util.HashMap;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.baidu.location.b.a */
/* loaded from: classes.dex */
public class C0645a {

    /* renamed from: u */
    private static String f384u = "BDLocConfigManager";

    /* renamed from: A */
    private String f385A;

    /* renamed from: B */
    private String f386B;

    /* renamed from: C */
    private String f387C;

    /* renamed from: a */
    public boolean f388a;

    /* renamed from: b */
    public int f389b;

    /* renamed from: c */
    public double f390c;

    /* renamed from: d */
    public int f391d;

    /* renamed from: e */
    public int f392e;

    /* renamed from: f */
    public double f393f;

    /* renamed from: g */
    public int f394g;

    /* renamed from: h */
    public int f395h;

    /* renamed from: i */
    public int f396i;

    /* renamed from: j */
    public int f397j;

    /* renamed from: k */
    public int f398k;

    /* renamed from: l */
    public int f399l;

    /* renamed from: m */
    public double[] f400m;

    /* renamed from: n */
    public int f401n;

    /* renamed from: o */
    public int f402o;

    /* renamed from: p */
    public int f403p;

    /* renamed from: q */
    public int f404q;

    /* renamed from: r */
    public int f405r;

    /* renamed from: s */
    public float f406s;

    /* renamed from: t */
    public float f407t;

    /* renamed from: v */
    private SharedPreferences f408v;

    /* renamed from: w */
    private long f409w;

    /* renamed from: x */
    private String f410x;

    /* renamed from: y */
    private a f411y;

    /* renamed from: z */
    private boolean f412z;

    /* renamed from: com.baidu.location.b.a$a */
    class a extends AbstractC0725g {

        /* renamed from: a */
        String f413a = null;

        /* renamed from: b */
        boolean f414b = false;

        public a() {
            this.f1292k = new HashMap();
        }

        /* renamed from: a */
        public void m310a(String str) {
            if (this.f414b) {
                return;
            }
            this.f414b = true;
            this.f413a = str;
            m1133e(C0722d.f1261d);
        }

        @Override // com.baidu.location.p012h.AbstractC0725g
        /* renamed from: a */
        public void mo122a(boolean z) {
            if (z && this.f1291j != null) {
                try {
                    new JSONObject(this.f1291j);
                    if (C0645a.this.f408v != null) {
                        SharedPreferences.Editor edit = C0645a.this.f408v.edit();
                        edit.putString(C0645a.f384u + "_newConfig", Base64.encodeToString(C0733o.m1149a(this.f1291j.getBytes()), 0));
                        edit.apply();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (this.f1292k != null) {
                this.f1292k.clear();
            }
            this.f414b = false;
        }

        @Override // com.baidu.location.p012h.AbstractC0725g
        /* renamed from: b */
        public void mo123b() {
            this.f1290i = 2;
            String encode = Jni.encode(this.f413a);
            this.f413a = null;
            this.f1292k.put("qt", "conf");
            this.f1292k.put("req", encode);
        }
    }

    /* renamed from: com.baidu.location.b.a$b */
    private static class b {

        /* renamed from: a */
        public static final C0645a f416a = new C0645a();
    }

    private C0645a() {
        this.f408v = null;
        this.f388a = false;
        this.f389b = 16;
        this.f409w = 300L;
        this.f390c = 0.75d;
        this.f391d = 0;
        this.f392e = 1;
        this.f393f = -0.10000000149011612d;
        this.f394g = 0;
        this.f395h = 1;
        this.f396i = 1;
        this.f397j = 10;
        this.f398k = 3;
        this.f399l = 40;
        this.f401n = 1;
        this.f402o = 0;
        this.f403p = 1;
        this.f404q = 1;
        this.f405r = 0;
        this.f406s = 0.2f;
        this.f407t = 0.8f;
        this.f410x = null;
        this.f411y = null;
        this.f412z = false;
        this.f385A = null;
        this.f386B = null;
        this.f387C = null;
    }

    /* renamed from: a */
    public static C0645a m302a() {
        return b.f416a;
    }

    /* renamed from: a */
    private void m303a(LocationClientOption locationClientOption) {
        String str = "&ver=" + C0733o.f1408x + "&usr=" + m306c() + "&app=" + this.f385A + "&prod=" + locationClientOption.prodName + "&newwf=1";
        String str2 = Build.VERSION.RELEASE;
        if (str2 != null && str2.length() > 6) {
            str2 = str2.substring(0, 6);
        }
        String str3 = str + "&sv=" + str2;
        String m1158c = C0733o.m1158c("ro.miui.ui.version.name");
        if (!TextUtils.isEmpty(m1158c)) {
            str3 = str3 + "&miui=" + m1158c;
        }
        String m1171j = C0733o.m1171j();
        if (!TextUtils.isEmpty(m1171j)) {
            str3 = str3 + "&mtk=" + m1171j;
        }
        String string = this.f408v.getString(f384u + "_loc", null);
        if (!TextUtils.isEmpty(string)) {
            try {
                str3 = str3 + "&loc=" + new String(Base64.decode(string, 0), "UTF-8");
            } catch (Exception unused) {
            }
        }
        if (this.f411y == null) {
            this.f411y = new a();
        }
        this.f411y.m310a(str3);
    }

    /* renamed from: a */
    private void m304a(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("is_check_Per") && jSONObject.getInt("is_check_Per") > 0) {
                this.f388a = true;
            }
            if (jSONObject.has("wfnum")) {
                this.f389b = jSONObject.getInt("wfnum");
            }
            if (jSONObject.has("freq")) {
                this.f409w = jSONObject.getLong("freq");
            }
            if (jSONObject.has("wfsm")) {
                this.f390c = jSONObject.getDouble("wfsm");
            }
            if (jSONObject.has("idmoc")) {
                this.f391d = jSONObject.getInt("idmoc");
            }
            if (jSONObject.has("gnmcrm")) {
                this.f393f = jSONObject.getDouble("gnmcrm");
            }
            if (jSONObject.has("gnmcon")) {
                this.f394g = jSONObject.getInt("gnmcon");
            }
            if (jSONObject.has("lpcs")) {
                this.f392e = jSONObject.getInt("lpcs");
            }
            if (jSONObject.has("iupl")) {
                this.f395h = jSONObject.getInt("iupl");
            }
            if (jSONObject.has("opetco")) {
                this.f396i = jSONObject.getInt("opetco");
            }
            if (jSONObject.has("ct")) {
                this.f397j = jSONObject.getInt("ct");
            }
            if (jSONObject.has("suci")) {
                this.f398k = jSONObject.getInt("suci");
            }
            if (jSONObject.has("smn")) {
                this.f399l = jSONObject.getInt("smn");
            }
            if (jSONObject.has("bcar")) {
                m309a(jSONObject);
            }
            if (jSONObject.has("ums")) {
                this.f401n = jSONObject.getInt("ums");
            }
            if (jSONObject.has("hpdts")) {
                this.f402o = jSONObject.getInt("hpdts");
            }
            if (jSONObject.has("oldts")) {
                this.f403p = jSONObject.getInt("oldts");
            }
            if (jSONObject.has("nlp_loc_coarse")) {
                this.f404q = jSONObject.optInt("nlp_loc_coarse");
            }
            if (jSONObject.has("new_loc_cache_switch")) {
                this.f405r = jSONObject.optInt("new_loc_cache_switch");
            }
            if (jSONObject.has("nc_same_rate")) {
                this.f406s = (float) jSONObject.optDouble("nc_same_rate", 0.8d);
            }
            if (jSONObject.has("cl_str_change_rate")) {
                this.f407t = (float) jSONObject.optDouble("cl_str_change_rate", 0.2d);
            }
            this.f410x = str;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: c */
    private String m306c() {
        return "v9.401|" + this.f386B + "|" + Build.MODEL + "&cu=" + this.f386B + "&mb=" + Build.MODEL;
    }

    /* renamed from: a */
    public synchronized void m307a(double d, double d2, String str) {
        SharedPreferences sharedPreferences;
        if (this.f387C == null && str != null) {
            try {
                if (str.equals("bd09") || str.equals("wgs84mc")) {
                    double[] coorEncrypt = Jni.coorEncrypt(d2, d, BDLocation.BDLOCATION_BD09_TO_GCJ02);
                    double d3 = coorEncrypt[1];
                    double d4 = coorEncrypt[0];
                    d = d3;
                    d2 = d4;
                }
                String format = String.format(Locale.US, "%.5f|%.5f", Double.valueOf(d2), Double.valueOf(d));
                this.f387C = format;
                String encodeToString = Base64.encodeToString(format.getBytes("UTF-8"), 0);
                if (encodeToString != null && (sharedPreferences = this.f408v) != null) {
                    SharedPreferences.Editor edit = sharedPreferences.edit();
                    edit.putString(f384u + "_loc", encodeToString);
                    edit.apply();
                }
            } catch (Exception unused) {
                this.f387C = null;
            }
        }
    }

    /* renamed from: a */
    public synchronized void m308a(Context context, LocationClientOption locationClientOption, String str) {
        if (!this.f412z && context != null) {
            this.f412z = true;
            if (locationClientOption == null) {
                locationClientOption = new LocationClientOption();
            }
            this.f385A = context.getPackageName();
            try {
                this.f386B = LBSAuthManager.getInstance(context).getCUID();
            } catch (Throwable unused) {
                this.f386B = null;
            }
            if (this.f408v == null) {
                this.f408v = context.getSharedPreferences(f384u + "BDLocConfig", 0);
            }
            SharedPreferences sharedPreferences = this.f408v;
            if (sharedPreferences != null) {
                long j = sharedPreferences.getLong(f384u + "_lastCheckTime", 0L);
                String string = this.f408v.getString(f384u + "_config", "");
                String string2 = this.f408v.getString(f384u + "_newConfig", "");
                if (!TextUtils.isEmpty(string2)) {
                    m304a(new String(C0733o.m1155b(Base64.decode(string2, 0))));
                } else if (!TextUtils.isEmpty(string)) {
                    m304a(string);
                    SharedPreferences.Editor edit = this.f408v.edit();
                    edit.remove(f384u + "_config");
                    edit.apply();
                }
                if (Math.abs((System.currentTimeMillis() / 1000) - j) > this.f409w) {
                    long currentTimeMillis = System.currentTimeMillis() / 1000;
                    SharedPreferences.Editor edit2 = this.f408v.edit();
                    edit2.putLong(f384u + "_lastCheckTime", currentTimeMillis);
                    edit2.apply();
                    m303a(locationClientOption);
                }
            }
        }
    }

    /* renamed from: a */
    public void m309a(JSONObject jSONObject) {
        JSONArray jSONArray;
        if (jSONObject != null) {
            double[] dArr = this.f400m;
            if (dArr != null && dArr.length > 0) {
                this.f400m = null;
            }
            try {
                if (!jSONObject.has("bcar") || (jSONArray = jSONObject.getJSONArray("bcar")) == null || jSONArray.length() <= 0) {
                    return;
                }
                if (this.f400m == null) {
                    this.f400m = new double[jSONArray.length() * 4];
                }
                int i = 0;
                int i2 = 0;
                while (i < jSONArray.length()) {
                    int i3 = i2 + 1;
                    this.f400m[i2] = jSONArray.getJSONObject(i).getDouble("x1");
                    int i4 = i3 + 1;
                    this.f400m[i3] = jSONArray.getJSONObject(i).getDouble("y1");
                    int i5 = i4 + 1;
                    this.f400m[i4] = jSONArray.getJSONObject(i).getDouble("x2");
                    int i6 = i5 + 1;
                    this.f400m[i5] = jSONArray.getJSONObject(i).getDouble("y2");
                    i++;
                    i2 = i6;
                }
            } catch (Exception unused) {
            }
        }
    }
}