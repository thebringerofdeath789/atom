package com.baidu.location.indoor;

import com.baidu.location.BDLocation;
import com.baidu.location.Jni;
import com.ipotensic.potensicpro.activities.PdfShowActivity;
import java.util.Arrays;
import java.util.Random;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class c {
    private int A;
    private int B;
    private int C;
    private int D;
    private String E;
    public String a;
    public String b;
    public double c;
    public double d;
    public double e;
    public double f;
    public String g;
    public String[] h;
    public String i;
    public String j;
    public int k;
    public String l;
    public String m;
    public b n;
    private double o;
    private double p;
    private int q;
    private String r;
    private String s;
    private String t;
    private int u = 8;
    private double v;
    private boolean w;
    private double x;
    private boolean y;
    private boolean z;

    public enum a {
        UNKNOWN(0),
        NORMAL(1),
        AUTH(2),
        BIG_RECT(4);

        private int e;

        a(int i) {
            this.e = 0;
            this.e = i;
        }

        public int a() {
            return this.e;
        }
    }

    public class b {
        public String a;
        public String b;
        public String c;
        public String d;
        public String e;

        public b() {
        }

        public void a(String str) {
            this.a = str;
        }

        public void b(String str) {
            this.b = str;
        }

        public void c(String str) {
            this.c = str;
        }

        public void d(String str) {
            this.d = str;
        }

        public void e(String str) {
            this.e = str;
        }

        public String toString() {
            return "OfflineFileInfo{fileUrl='" + this.a + "', zipMd5='" + this.b + "', modleMd5='" + this.c + "', dataMd5='" + this.d + "', dictMd5='" + this.e + "'}";
        }
    }

    public c(JSONObject jSONObject) {
        String str;
        String string;
        String[] split;
        JSONObject optJSONObject;
        String string2;
        this.q = 100;
        this.r = "default";
        this.s = "default";
        this.t = "0|0";
        this.v = 1.0d;
        this.w = true;
        this.x = 0.0d;
        this.y = false;
        this.z = false;
        this.A = 2;
        this.B = 0;
        this.C = 0;
        this.D = 0;
        this.E = "";
        if (jSONObject != null) {
            try {
                if (jSONObject.has("rect_type")) {
                    int optInt = jSONObject.optInt("rect_type");
                    str = "support_types";
                    if ((optInt & a.AUTH.a()) == a.AUTH.a()) {
                        this.C = 1;
                    } else {
                        this.C = 0;
                    }
                    if ((a.BIG_RECT.a() & optInt) == a.BIG_RECT.a()) {
                        this.D = 1;
                    } else {
                        this.D = 0;
                    }
                    int a2 = optInt & a.NORMAL.a();
                    a.NORMAL.a();
                } else {
                    str = "support_types";
                }
                if (jSONObject.has("bldg")) {
                    this.a = jSONObject.optString("bldg");
                }
                if (jSONObject.has("bid")) {
                    this.b = jSONObject.optString("bid");
                }
                if (jSONObject.has("inout_points")) {
                    this.l = jSONObject.optString("inout_points");
                }
                if (jSONObject.has("off_ble_ver")) {
                    this.m = jSONObject.optString("off_ble_ver");
                }
                if (jSONObject.has("max_scan_num")) {
                    this.q = jSONObject.optInt("max_scan_num");
                }
                if (jSONObject.has("scenario_detector")) {
                    this.r = jSONObject.optString("scenario_detector");
                }
                if (jSONObject.has("passageway_info")) {
                    this.s = jSONObject.optString("passageway_info");
                }
                if (jSONObject.has("offloc_parameter")) {
                    this.t = jSONObject.optString("offloc_parameter");
                }
                if (jSONObject.has("uuid")) {
                    this.g = jSONObject.getString("uuid").replace("-", "");
                }
                if (jSONObject.has("uuids") && (string2 = jSONObject.getString("uuids")) != null) {
                    if (string2.contains("|")) {
                        String[] split2 = string2.split("\\|");
                        for (int i = 0; i < split2.length; i++) {
                            split2[i] = split2[i].replace("-", "").toUpperCase();
                        }
                        this.h = split2;
                    } else {
                        this.h = new String[]{string2.replace("-", "").toUpperCase()};
                    }
                }
                String str2 = str;
                if (jSONObject.has(str2)) {
                    this.i = jSONObject.optString(str2);
                }
                if (jSONObject.has("conf_type")) {
                    this.j = jSONObject.optString("conf_type");
                }
                if (jSONObject.has("offline_data_mode")) {
                    this.A = jSONObject.optInt("offline_data_mode");
                }
                if (jSONObject.has("algo_rects")) {
                    this.E = jSONObject.optString("algo_rects");
                }
                String str3 = "is_support_off_ble_v2";
                int i2 = this.A;
                String str4 = "indoor_file_info_v2";
                if (i2 == 2) {
                    str3 = "is_support_off_ble_v2";
                } else if (i2 == 3) {
                    str4 = "indoor_file_info_v3";
                    str3 = "is_support_off_ble_v3";
                }
                if (jSONObject.has(str3)) {
                    this.k = jSONObject.optInt(str3);
                }
                if (!jSONObject.has(str4) || (optJSONObject = jSONObject.optJSONArray(str4).optJSONObject(0)) == null) {
                    this.z = false;
                } else {
                    this.n = new b();
                    this.z = true;
                    if (optJSONObject.has(PdfShowActivity.FILE_PATH)) {
                        this.n.a(optJSONObject.optString(PdfShowActivity.FILE_PATH));
                    } else {
                        this.z = false;
                    }
                    if (optJSONObject.has("zip_md5")) {
                        this.n.b(optJSONObject.optString("zip_md5"));
                    } else {
                        this.z = false;
                    }
                    if (optJSONObject.has("model_md5")) {
                        this.n.c(optJSONObject.optString("model_md5"));
                    } else {
                        this.z = false;
                    }
                    if (optJSONObject.has("data_md5")) {
                        this.n.d(optJSONObject.optString("data_md5"));
                    } else {
                        this.z = false;
                    }
                    if (optJSONObject.has("dict_md5")) {
                        this.n.e(optJSONObject.optString("dict_md5"));
                    } else {
                        this.z = false;
                    }
                }
                if (jSONObject.has("rect") && (string = jSONObject.getString("rect")) != null && string.contains(",") && (split = string.split(",")) != null && split.length >= 4) {
                    this.c = Double.valueOf(split[1]).doubleValue();
                    this.e = Double.valueOf(split[0]).doubleValue();
                    this.d = Double.valueOf(split[3]).doubleValue();
                    double doubleValue = Double.valueOf(split[2]).doubleValue();
                    this.f = doubleValue;
                    double d = this.c;
                    this.o = (this.e + d) / 2.0d;
                    double d2 = this.d;
                    this.p = (doubleValue + d2) / 2.0d;
                    double[] coorEncrypt = Jni.coorEncrypt(d, d2, BDLocation.BDLOCATION_WGS84_TO_GCJ02);
                    this.c = coorEncrypt[0];
                    this.d = coorEncrypt[1];
                    double[] coorEncrypt2 = Jni.coorEncrypt(this.e, this.f, BDLocation.BDLOCATION_WGS84_TO_GCJ02);
                    this.e = coorEncrypt2[0];
                    this.f = coorEncrypt2[1];
                }
                if (jSONObject.has("indoor_log_rate")) {
                    this.v = jSONObject.optDouble("indoor_log_rate");
                    if (new Random().nextDouble() <= this.v) {
                        this.w = true;
                    } else {
                        this.w = false;
                    }
                }
                if (jSONObject.has("sensor_log_rate")) {
                    this.x = jSONObject.optDouble("sensor_log_rate");
                    if (new Random().nextDouble() <= this.x) {
                        this.y = true;
                    } else {
                        this.y = false;
                    }
                }
                if (jSONObject.has("is_support_poi_data")) {
                    this.B = jSONObject.optInt("is_support_poi_data");
                }
            } catch (Exception unused) {
            }
        }
    }

    public int a() {
        return this.q;
    }

    public String[] b() {
        return this.h;
    }

    public int c() {
        return this.D;
    }

    public String toString() {
        return "BlePdrEffectArea{bldg='" + this.a + "', bid='" + this.b + "', lon0=" + this.c + ", lat0=" + this.d + ", lon1=" + this.e + ", lat1=" + this.f + ", uuid='" + this.g + "', uuids=" + Arrays.toString(this.h) + ", supportTypes='" + this.i + "', confType='" + this.j + "', isSupportOffBle=" + this.k + ", inoutPoints='" + this.l + "', offBleVer='" + this.m + "', offline_data_mode=" + this.A + ", offlineFileInfo=" + this.n + ", middlelon=" + this.o + ", middlelat=" + this.p + ", bleNumlimit=" + this.q + ", conf='" + this.r + "', passageWayInfo='" + this.s + "', offLocParameter='" + this.t + "', mThrYaw=" + this.u + ", mIndoorLogRate=" + this.v + ", isIndoorLogReport=" + this.w + ", mIndoorSensorLogRate=" + this.x + ", isIndoorSensorLogReport=" + this.y + ", isOfflineServerDataValid=" + this.z + ", isNeedCompanyAuth=" + this.C + ", isBigRect=" + this.D + ", isSupportPoiData=" + this.B + ", algoRects=" + this.E + '}';
    }
}
