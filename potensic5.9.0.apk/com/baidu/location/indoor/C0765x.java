package com.baidu.location.indoor;

import org.json.JSONObject;

/* renamed from: com.baidu.location.indoor.x */
/* loaded from: classes.dex */
public class C0765x {

    /* renamed from: a */
    private String f1763a;

    /* renamed from: b */
    private int f1764b;

    /* renamed from: c */
    private int f1765c;

    /* renamed from: com.baidu.location.indoor.x$a */
    private enum a {
        UNKNOWN(0),
        NORMAL(1);


        /* renamed from: c */
        private int f1769c;

        a(int i) {
            this.f1769c = 0;
            this.f1769c = i;
        }

        /* renamed from: a */
        public int m1452a() {
            return this.f1769c;
        }
    }

    public C0765x(JSONObject jSONObject) {
        this.f1763a = "";
        this.f1764b = 0;
        this.f1765c = 0;
        try {
            if (jSONObject.has("rect_type")) {
                if ((jSONObject.optInt("rect_type") & a.NORMAL.m1452a()) == a.NORMAL.m1452a()) {
                    this.f1765c = 1;
                } else {
                    this.f1765c = 0;
                }
            }
            if (jSONObject.has("is_support_poi_data")) {
                this.f1764b = jSONObject.optInt("is_support_poi_data");
            }
            if (jSONObject.has("city_code")) {
                this.f1763a = jSONObject.optString("city_code");
            }
        } catch (Exception unused) {
        }
    }

    public String toString() {
        return "OutdoorParkingArea{cityCode='" + this.f1763a + "', isSupportPoiData=" + this.f1764b + ", isOutdoorParkingRect=" + this.f1765c + '}';
    }
}