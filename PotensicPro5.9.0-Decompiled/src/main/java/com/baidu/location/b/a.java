package com.baidu.location.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.lbsapi.auth.LBSAuthManager;
import com.baidu.location.BDLocation;
import com.baidu.location.Jni;
import com.baidu.location.LocationClientOption;
import java.util.HashMap;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class a {
    private static String u = "BDLocConfigManager";
    private String A;
    private String B;
    private String C;
    public boolean a;
    public int b;
    public double c;
    public int d;
    public int e;
    public double f;
    public int g;
    public int h;
    public int i;
    public int j;
    public int k;
    public int l;
    public double[] m;
    public int n;
    public int o;
    public int p;
    public int q;
    public int r;
    public float s;
    public float t;
    private SharedPreferences v;
    private long w;
    private String x;
    private C0004a y;
    private boolean z;

    /* renamed from: com.baidu.location.b.a$a, reason: collision with other inner class name */
    class C0004a extends com.baidu.location.h.g {
        String a = null;
        boolean b = false;

        public C0004a() {
            this.k = new HashMap();
        }

        public void a(String str) {
            if (this.b) {
                return;
            }
            this.b = true;
            this.a = str;
            e(com.baidu.location.h.d.d);
        }

        @Override // com.baidu.location.h.g
        public void a(boolean z) {
            if (z && this.j != null) {
                try {
                    new JSONObject(this.j);
                    if (a.this.v != null) {
                        SharedPreferences.Editor edit = a.this.v.edit();
                        edit.putString(a.u + "_newConfig", Base64.encodeToString(com.baidu.location.h.o.a(this.j.getBytes()), 0));
                        edit.apply();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (this.k != null) {
                this.k.clear();
            }
            this.b = false;
        }

        @Override // com.baidu.location.h.g
        public void b() {
            this.i = 2;
            String encode = Jni.encode(this.a);
            this.a = null;
            this.k.put("qt", "conf");
            this.k.put("req", encode);
        }
    }

    private static class b {
        public static final a a = new a();
    }

    private a() {
        this.v = null;
        this.a = false;
        this.b = 16;
        this.w = 300L;
        this.c = 0.75d;
        this.d = 0;
        this.e = 1;
        this.f = -0.10000000149011612d;
        this.g = 0;
        this.h = 1;
        this.i = 1;
        this.j = 10;
        this.k = 3;
        this.l = 40;
        this.n = 1;
        this.o = 0;
        this.p = 1;
        this.q = 1;
        this.r = 0;
        this.s = 0.2f;
        this.t = 0.8f;
        this.x = null;
        this.y = null;
        this.z = false;
        this.A = null;
        this.B = null;
        this.C = null;
    }

    public static a a() {
        return b.a;
    }

    private void a(LocationClientOption locationClientOption) {
        String str = "&ver=" + com.baidu.location.h.o.x + "&usr=" + c() + "&app=" + this.A + "&prod=" + locationClientOption.prodName + "&newwf=1";
        String str2 = Build.VERSION.RELEASE;
        if (str2 != null && str2.length() > 6) {
            str2 = str2.substring(0, 6);
        }
        String str3 = str + "&sv=" + str2;
        String c = com.baidu.location.h.o.c("ro.miui.ui.version.name");
        if (!TextUtils.isEmpty(c)) {
            str3 = str3 + "&miui=" + c;
        }
        String j = com.baidu.location.h.o.j();
        if (!TextUtils.isEmpty(j)) {
            str3 = str3 + "&mtk=" + j;
        }
        String string = this.v.getString(u + "_loc", null);
        if (!TextUtils.isEmpty(string)) {
            try {
                str3 = str3 + "&loc=" + new String(Base64.decode(string, 0), "UTF-8");
            } catch (Exception unused) {
            }
        }
        if (this.y == null) {
            this.y = new C0004a();
        }
        this.y.a(str3);
    }

    private void a(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("is_check_Per") && jSONObject.getInt("is_check_Per") > 0) {
                this.a = true;
            }
            if (jSONObject.has("wfnum")) {
                this.b = jSONObject.getInt("wfnum");
            }
            if (jSONObject.has("freq")) {
                this.w = jSONObject.getLong("freq");
            }
            if (jSONObject.has("wfsm")) {
                this.c = jSONObject.getDouble("wfsm");
            }
            if (jSONObject.has("idmoc")) {
                this.d = jSONObject.getInt("idmoc");
            }
            if (jSONObject.has("gnmcrm")) {
                this.f = jSONObject.getDouble("gnmcrm");
            }
            if (jSONObject.has("gnmcon")) {
                this.g = jSONObject.getInt("gnmcon");
            }
            if (jSONObject.has("lpcs")) {
                this.e = jSONObject.getInt("lpcs");
            }
            if (jSONObject.has("iupl")) {
                this.h = jSONObject.getInt("iupl");
            }
            if (jSONObject.has("opetco")) {
                this.i = jSONObject.getInt("opetco");
            }
            if (jSONObject.has("ct")) {
                this.j = jSONObject.getInt("ct");
            }
            if (jSONObject.has("suci")) {
                this.k = jSONObject.getInt("suci");
            }
            if (jSONObject.has("smn")) {
                this.l = jSONObject.getInt("smn");
            }
            if (jSONObject.has("bcar")) {
                a(jSONObject);
            }
            if (jSONObject.has("ums")) {
                this.n = jSONObject.getInt("ums");
            }
            if (jSONObject.has("hpdts")) {
                this.o = jSONObject.getInt("hpdts");
            }
            if (jSONObject.has("oldts")) {
                this.p = jSONObject.getInt("oldts");
            }
            if (jSONObject.has("nlp_loc_coarse")) {
                this.q = jSONObject.optInt("nlp_loc_coarse");
            }
            if (jSONObject.has("new_loc_cache_switch")) {
                this.r = jSONObject.optInt("new_loc_cache_switch");
            }
            if (jSONObject.has("nc_same_rate")) {
                this.s = (float) jSONObject.optDouble("nc_same_rate", 0.8d);
            }
            if (jSONObject.has("cl_str_change_rate")) {
                this.t = (float) jSONObject.optDouble("cl_str_change_rate", 0.2d);
            }
            this.x = str;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String c() {
        return "v9.401|" + this.B + "|" + Build.MODEL + "&cu=" + this.B + "&mb=" + Build.MODEL;
    }

    public synchronized void a(double d, double d2, String str) {
        SharedPreferences sharedPreferences;
        if (this.C == null && str != null) {
            try {
                if (str.equals("bd09") || str.equals("wgs84mc")) {
                    double[] coorEncrypt = Jni.coorEncrypt(d2, d, BDLocation.BDLOCATION_BD09_TO_GCJ02);
                    double d3 = coorEncrypt[1];
                    double d4 = coorEncrypt[0];
                    d = d3;
                    d2 = d4;
                }
                String format = String.format(Locale.US, "%.5f|%.5f", Double.valueOf(d2), Double.valueOf(d));
                this.C = format;
                String encodeToString = Base64.encodeToString(format.getBytes("UTF-8"), 0);
                if (encodeToString != null && (sharedPreferences = this.v) != null) {
                    SharedPreferences.Editor edit = sharedPreferences.edit();
                    edit.putString(u + "_loc", encodeToString);
                    edit.apply();
                }
            } catch (Exception unused) {
                this.C = null;
            }
        }
    }

    public synchronized void a(Context context, LocationClientOption locationClientOption, String str) {
        if (!this.z && context != null) {
            this.z = true;
            if (locationClientOption == null) {
                locationClientOption = new LocationClientOption();
            }
            this.A = context.getPackageName();
            try {
                this.B = LBSAuthManager.getInstance(context).getCUID();
            } catch (Throwable unused) {
                this.B = null;
            }
            if (this.v == null) {
                this.v = context.getSharedPreferences(u + "BDLocConfig", 0);
            }
            SharedPreferences sharedPreferences = this.v;
            if (sharedPreferences != null) {
                long j = sharedPreferences.getLong(u + "_lastCheckTime", 0L);
                String string = this.v.getString(u + "_config", "");
                String string2 = this.v.getString(u + "_newConfig", "");
                if (!TextUtils.isEmpty(string2)) {
                    a(new String(com.baidu.location.h.o.b(Base64.decode(string2, 0))));
                } else if (!TextUtils.isEmpty(string)) {
                    a(string);
                    SharedPreferences.Editor edit = this.v.edit();
                    edit.remove(u + "_config");
                    edit.apply();
                }
                if (Math.abs((System.currentTimeMillis() / 1000) - j) > this.w) {
                    long currentTimeMillis = System.currentTimeMillis() / 1000;
                    SharedPreferences.Editor edit2 = this.v.edit();
                    edit2.putLong(u + "_lastCheckTime", currentTimeMillis);
                    edit2.apply();
                    a(locationClientOption);
                }
            }
        }
    }

    public void a(JSONObject jSONObject) {
        JSONArray jSONArray;
        if (jSONObject != null) {
            double[] dArr = this.m;
            if (dArr != null && dArr.length > 0) {
                this.m = null;
            }
            try {
                if (!jSONObject.has("bcar") || (jSONArray = jSONObject.getJSONArray("bcar")) == null || jSONArray.length() <= 0) {
                    return;
                }
                if (this.m == null) {
                    this.m = new double[jSONArray.length() * 4];
                }
                int i = 0;
                int i2 = 0;
                while (i < jSONArray.length()) {
                    int i3 = i2 + 1;
                    this.m[i2] = jSONArray.getJSONObject(i).getDouble("x1");
                    int i4 = i3 + 1;
                    this.m[i3] = jSONArray.getJSONObject(i).getDouble("y1");
                    int i5 = i4 + 1;
                    this.m[i4] = jSONArray.getJSONObject(i).getDouble("x2");
                    int i6 = i5 + 1;
                    this.m[i5] = jSONArray.getJSONObject(i).getDouble("y2");
                    i++;
                    i2 = i6;
                }
            } catch (Exception unused) {
            }
        }
    }
}
