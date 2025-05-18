package com.baidu.location.indoor;

import com.baidu.location.BDLocation;
import com.baidu.location.Jni;
import com.ipotensic.potensicpro.activities.PdfShowActivity;
import java.util.Arrays;
import java.util.Random;
import org.json.JSONObject;

/* renamed from: com.baidu.location.indoor.c */
/* loaded from: classes.dex */
public class C0738c {

    /* renamed from: A */
    private int f1426A;

    /* renamed from: B */
    private int f1427B;

    /* renamed from: C */
    private int f1428C;

    /* renamed from: D */
    private int f1429D;

    /* renamed from: E */
    private String f1430E;

    /* renamed from: a */
    public String f1431a;

    /* renamed from: b */
    public String f1432b;

    /* renamed from: c */
    public double f1433c;

    /* renamed from: d */
    public double f1434d;

    /* renamed from: e */
    public double f1435e;

    /* renamed from: f */
    public double f1436f;

    /* renamed from: g */
    public String f1437g;

    /* renamed from: h */
    public String[] f1438h;

    /* renamed from: i */
    public String f1439i;

    /* renamed from: j */
    public String f1440j;

    /* renamed from: k */
    public int f1441k;

    /* renamed from: l */
    public String f1442l;

    /* renamed from: m */
    public String f1443m;

    /* renamed from: n */
    public b f1444n;

    /* renamed from: o */
    private double f1445o;

    /* renamed from: p */
    private double f1446p;

    /* renamed from: q */
    private int f1447q;

    /* renamed from: r */
    private String f1448r;

    /* renamed from: s */
    private String f1449s;

    /* renamed from: t */
    private String f1450t;

    /* renamed from: u */
    private int f1451u = 8;

    /* renamed from: v */
    private double f1452v;

    /* renamed from: w */
    private boolean f1453w;

    /* renamed from: x */
    private double f1454x;

    /* renamed from: y */
    private boolean f1455y;

    /* renamed from: z */
    private boolean f1456z;

    /* renamed from: com.baidu.location.indoor.c$a */
    public enum a {
        UNKNOWN(0),
        NORMAL(1),
        AUTH(2),
        BIG_RECT(4);


        /* renamed from: e */
        private int f1462e;

        a(int i) {
            this.f1462e = 0;
            this.f1462e = i;
        }

        /* renamed from: a */
        public int m1192a() {
            return this.f1462e;
        }
    }

    /* renamed from: com.baidu.location.indoor.c$b */
    public class b {

        /* renamed from: a */
        public String f1463a;

        /* renamed from: b */
        public String f1464b;

        /* renamed from: c */
        public String f1465c;

        /* renamed from: d */
        public String f1466d;

        /* renamed from: e */
        public String f1467e;

        public b() {
        }

        /* renamed from: a */
        public void m1193a(String str) {
            this.f1463a = str;
        }

        /* renamed from: b */
        public void m1194b(String str) {
            this.f1464b = str;
        }

        /* renamed from: c */
        public void m1195c(String str) {
            this.f1465c = str;
        }

        /* renamed from: d */
        public void m1196d(String str) {
            this.f1466d = str;
        }

        /* renamed from: e */
        public void m1197e(String str) {
            this.f1467e = str;
        }

        public String toString() {
            return "OfflineFileInfo{fileUrl='" + this.f1463a + "', zipMd5='" + this.f1464b + "', modleMd5='" + this.f1465c + "', dataMd5='" + this.f1466d + "', dictMd5='" + this.f1467e + "'}";
        }
    }

    public C0738c(JSONObject jSONObject) {
        String str;
        String string;
        String[] split;
        JSONObject optJSONObject;
        String string2;
        this.f1447q = 100;
        this.f1448r = "default";
        this.f1449s = "default";
        this.f1450t = "0|0";
        this.f1452v = 1.0d;
        this.f1453w = true;
        this.f1454x = 0.0d;
        this.f1455y = false;
        this.f1456z = false;
        this.f1426A = 2;
        this.f1427B = 0;
        this.f1428C = 0;
        this.f1429D = 0;
        this.f1430E = "";
        if (jSONObject != null) {
            try {
                if (jSONObject.has("rect_type")) {
                    int optInt = jSONObject.optInt("rect_type");
                    str = "support_types";
                    if ((optInt & a.AUTH.m1192a()) == a.AUTH.m1192a()) {
                        this.f1428C = 1;
                    } else {
                        this.f1428C = 0;
                    }
                    if ((a.BIG_RECT.m1192a() & optInt) == a.BIG_RECT.m1192a()) {
                        this.f1429D = 1;
                    } else {
                        this.f1429D = 0;
                    }
                    int m1192a = optInt & a.NORMAL.m1192a();
                    a.NORMAL.m1192a();
                } else {
                    str = "support_types";
                }
                if (jSONObject.has("bldg")) {
                    this.f1431a = jSONObject.optString("bldg");
                }
                if (jSONObject.has("bid")) {
                    this.f1432b = jSONObject.optString("bid");
                }
                if (jSONObject.has("inout_points")) {
                    this.f1442l = jSONObject.optString("inout_points");
                }
                if (jSONObject.has("off_ble_ver")) {
                    this.f1443m = jSONObject.optString("off_ble_ver");
                }
                if (jSONObject.has("max_scan_num")) {
                    this.f1447q = jSONObject.optInt("max_scan_num");
                }
                if (jSONObject.has("scenario_detector")) {
                    this.f1448r = jSONObject.optString("scenario_detector");
                }
                if (jSONObject.has("passageway_info")) {
                    this.f1449s = jSONObject.optString("passageway_info");
                }
                if (jSONObject.has("offloc_parameter")) {
                    this.f1450t = jSONObject.optString("offloc_parameter");
                }
                if (jSONObject.has("uuid")) {
                    this.f1437g = jSONObject.getString("uuid").replace("-", "");
                }
                if (jSONObject.has("uuids") && (string2 = jSONObject.getString("uuids")) != null) {
                    if (string2.contains("|")) {
                        String[] split2 = string2.split("\\|");
                        for (int i = 0; i < split2.length; i++) {
                            split2[i] = split2[i].replace("-", "").toUpperCase();
                        }
                        this.f1438h = split2;
                    } else {
                        this.f1438h = new String[]{string2.replace("-", "").toUpperCase()};
                    }
                }
                String str2 = str;
                if (jSONObject.has(str2)) {
                    this.f1439i = jSONObject.optString(str2);
                }
                if (jSONObject.has("conf_type")) {
                    this.f1440j = jSONObject.optString("conf_type");
                }
                if (jSONObject.has("offline_data_mode")) {
                    this.f1426A = jSONObject.optInt("offline_data_mode");
                }
                if (jSONObject.has("algo_rects")) {
                    this.f1430E = jSONObject.optString("algo_rects");
                }
                String str3 = "is_support_off_ble_v2";
                int i2 = this.f1426A;
                String str4 = "indoor_file_info_v2";
                if (i2 == 2) {
                    str3 = "is_support_off_ble_v2";
                } else if (i2 == 3) {
                    str4 = "indoor_file_info_v3";
                    str3 = "is_support_off_ble_v3";
                }
                if (jSONObject.has(str3)) {
                    this.f1441k = jSONObject.optInt(str3);
                }
                if (!jSONObject.has(str4) || (optJSONObject = jSONObject.optJSONArray(str4).optJSONObject(0)) == null) {
                    this.f1456z = false;
                } else {
                    this.f1444n = new b();
                    this.f1456z = true;
                    if (optJSONObject.has(PdfShowActivity.FILE_PATH)) {
                        this.f1444n.m1193a(optJSONObject.optString(PdfShowActivity.FILE_PATH));
                    } else {
                        this.f1456z = false;
                    }
                    if (optJSONObject.has("zip_md5")) {
                        this.f1444n.m1194b(optJSONObject.optString("zip_md5"));
                    } else {
                        this.f1456z = false;
                    }
                    if (optJSONObject.has("model_md5")) {
                        this.f1444n.m1195c(optJSONObject.optString("model_md5"));
                    } else {
                        this.f1456z = false;
                    }
                    if (optJSONObject.has("data_md5")) {
                        this.f1444n.m1196d(optJSONObject.optString("data_md5"));
                    } else {
                        this.f1456z = false;
                    }
                    if (optJSONObject.has("dict_md5")) {
                        this.f1444n.m1197e(optJSONObject.optString("dict_md5"));
                    } else {
                        this.f1456z = false;
                    }
                }
                if (jSONObject.has("rect") && (string = jSONObject.getString("rect")) != null && string.contains(",") && (split = string.split(",")) != null && split.length >= 4) {
                    this.f1433c = Double.valueOf(split[1]).doubleValue();
                    this.f1435e = Double.valueOf(split[0]).doubleValue();
                    this.f1434d = Double.valueOf(split[3]).doubleValue();
                    double doubleValue = Double.valueOf(split[2]).doubleValue();
                    this.f1436f = doubleValue;
                    double d = this.f1433c;
                    this.f1445o = (this.f1435e + d) / 2.0d;
                    double d2 = this.f1434d;
                    this.f1446p = (doubleValue + d2) / 2.0d;
                    double[] coorEncrypt = Jni.coorEncrypt(d, d2, BDLocation.BDLOCATION_WGS84_TO_GCJ02);
                    this.f1433c = coorEncrypt[0];
                    this.f1434d = coorEncrypt[1];
                    double[] coorEncrypt2 = Jni.coorEncrypt(this.f1435e, this.f1436f, BDLocation.BDLOCATION_WGS84_TO_GCJ02);
                    this.f1435e = coorEncrypt2[0];
                    this.f1436f = coorEncrypt2[1];
                }
                if (jSONObject.has("indoor_log_rate")) {
                    this.f1452v = jSONObject.optDouble("indoor_log_rate");
                    if (new Random().nextDouble() <= this.f1452v) {
                        this.f1453w = true;
                    } else {
                        this.f1453w = false;
                    }
                }
                if (jSONObject.has("sensor_log_rate")) {
                    this.f1454x = jSONObject.optDouble("sensor_log_rate");
                    if (new Random().nextDouble() <= this.f1454x) {
                        this.f1455y = true;
                    } else {
                        this.f1455y = false;
                    }
                }
                if (jSONObject.has("is_support_poi_data")) {
                    this.f1427B = jSONObject.optInt("is_support_poi_data");
                }
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: a */
    public int m1189a() {
        return this.f1447q;
    }

    /* renamed from: b */
    public String[] m1190b() {
        return this.f1438h;
    }

    /* renamed from: c */
    public int m1191c() {
        return this.f1429D;
    }

    public String toString() {
        return "BlePdrEffectArea{bldg='" + this.f1431a + "', bid='" + this.f1432b + "', lon0=" + this.f1433c + ", lat0=" + this.f1434d + ", lon1=" + this.f1435e + ", lat1=" + this.f1436f + ", uuid='" + this.f1437g + "', uuids=" + Arrays.toString(this.f1438h) + ", supportTypes='" + this.f1439i + "', confType='" + this.f1440j + "', isSupportOffBle=" + this.f1441k + ", inoutPoints='" + this.f1442l + "', offBleVer='" + this.f1443m + "', offline_data_mode=" + this.f1426A + ", offlineFileInfo=" + this.f1444n + ", middlelon=" + this.f1445o + ", middlelat=" + this.f1446p + ", bleNumlimit=" + this.f1447q + ", conf='" + this.f1448r + "', passageWayInfo='" + this.f1449s + "', offLocParameter='" + this.f1450t + "', mThrYaw=" + this.f1451u + ", mIndoorLogRate=" + this.f1452v + ", isIndoorLogReport=" + this.f1453w + ", mIndoorSensorLogRate=" + this.f1454x + ", isIndoorSensorLogReport=" + this.f1455y + ", isOfflineServerDataValid=" + this.f1456z + ", isNeedCompanyAuth=" + this.f1428C + ", isBigRect=" + this.f1429D + ", isSupportPoiData=" + this.f1427B + ", algoRects=" + this.f1430E + '}';
    }
}