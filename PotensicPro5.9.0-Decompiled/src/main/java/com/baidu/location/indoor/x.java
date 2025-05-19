package com.baidu.location.indoor;

import org.json.JSONObject;

/* loaded from: classes.dex */
public class x {
    private String a;
    private int b;
    private int c;

    private enum a {
        UNKNOWN(0),
        NORMAL(1);

        private int c;

        a(int i) {
            this.c = 0;
            this.c = i;
        }

        public int a() {
            return this.c;
        }
    }

    public x(JSONObject jSONObject) {
        this.a = "";
        this.b = 0;
        this.c = 0;
        try {
            if (jSONObject.has("rect_type")) {
                if ((jSONObject.optInt("rect_type") & a.NORMAL.a()) == a.NORMAL.a()) {
                    this.c = 1;
                } else {
                    this.c = 0;
                }
            }
            if (jSONObject.has("is_support_poi_data")) {
                this.b = jSONObject.optInt("is_support_poi_data");
            }
            if (jSONObject.has("city_code")) {
                this.a = jSONObject.optString("city_code");
            }
        } catch (Exception unused) {
        }
    }

    public String toString() {
        return "OutdoorParkingArea{cityCode='" + this.a + "', isSupportPoiData=" + this.b + ", isOutdoorParkingRect=" + this.c + '}';
    }
}
