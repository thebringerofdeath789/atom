package com.baidu.location.p009e;

import com.baidu.location.p009e.C0697l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.baidu.location.e.n */
/* loaded from: classes.dex */
enum C0699n extends C0697l.b {
    C0699n(String str, int i, String str2, String str3, String str4, int i2, int i3) {
        super(str, i, str2, str3, str4, i2, i3);
    }

    @Override // com.baidu.location.p009e.C0697l.b
    /* renamed from: a */
    List<String> mo893a(JSONObject jSONObject, String str, int i) {
        int i2;
        char c;
        JSONArray jSONArray;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        Iterator<String> it;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        Iterator<String> it2;
        JSONArray jSONArray2;
        String str12;
        Double d;
        Double d2;
        Double d3;
        Double valueOf;
        String str13 = "y2";
        String str14 = "x2";
        String str15 = "y1";
        String str16 = "x1";
        String str17 = "st";
        Iterator<String> keys = jSONObject.keys();
        ArrayList arrayList = new ArrayList();
        StringBuffer stringBuffer = new StringBuffer();
        while (true) {
            int i3 = 0;
            if (!keys.hasNext()) {
                break;
            }
            StringBuffer stringBuffer2 = new StringBuffer();
            String next = keys.next();
            C0697l.b.m890b(stringBuffer, next, str, 0);
            try {
                jSONArray = jSONObject.getJSONArray(next);
            } catch (JSONException unused) {
                jSONArray = null;
            }
            if (jSONArray != null) {
                while (i3 < jSONArray.length()) {
                    try {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i3);
                        if (jSONObject2.has(str17)) {
                            str11 = str17;
                            str12 = jSONObject2.getString(str17);
                        } else {
                            str11 = str17;
                            str12 = null;
                        }
                        try {
                            if (jSONObject2.has(str16)) {
                                str10 = str16;
                                d = Double.valueOf(jSONObject2.getDouble(str16));
                            } else {
                                str10 = str16;
                                d = null;
                            }
                            try {
                                if (jSONObject2.has(str15)) {
                                    str9 = str15;
                                    d2 = Double.valueOf(jSONObject2.getDouble(str15));
                                } else {
                                    str9 = str15;
                                    d2 = null;
                                }
                                try {
                                    if (jSONObject2.has(str14)) {
                                        str8 = str14;
                                        d3 = Double.valueOf(jSONObject2.getDouble(str14));
                                    } else {
                                        str8 = str14;
                                        d3 = null;
                                    }
                                    try {
                                        valueOf = jSONObject2.has(str13) ? Double.valueOf(jSONObject2.getDouble(str13)) : null;
                                    } catch (JSONException unused2) {
                                    }
                                } catch (JSONException unused3) {
                                    str7 = str13;
                                    str8 = str14;
                                }
                            } catch (JSONException unused4) {
                                str7 = str13;
                                str8 = str14;
                                str9 = str15;
                            }
                        } catch (JSONException unused5) {
                            str7 = str13;
                            str8 = str14;
                            str9 = str15;
                            str10 = str16;
                        }
                    } catch (JSONException unused6) {
                        str7 = str13;
                        str8 = str14;
                        str9 = str15;
                        str10 = str16;
                        str11 = str17;
                    }
                    if (str12 != null && d != null && d2 != null && d3 != null && valueOf != null) {
                        str7 = str13;
                        if (stringBuffer2.length() > 0) {
                            try {
                                stringBuffer2.append(",");
                            } catch (JSONException unused7) {
                            }
                        }
                        it2 = keys;
                        try {
                            jSONArray2 = jSONArray;
                            try {
                                stringBuffer2.append("(NULL,\"").append(next).append("\",\"").append(str12).append("\",").append(d).append(",").append(d2).append(",").append(d3).append(",").append(valueOf).append(")");
                            } catch (JSONException unused8) {
                            }
                        } catch (JSONException unused9) {
                        }
                        if (i3 % 50 != 49 && stringBuffer2.length() > 0) {
                            arrayList.add(String.format(Locale.US, "INSERT OR REPLACE INTO %s VALUES %s", "RGCROAD", stringBuffer2.toString()));
                            stringBuffer2.setLength(0);
                        }
                        i3++;
                        str17 = str11;
                        str16 = str10;
                        str15 = str9;
                        str14 = str8;
                        keys = it2;
                        str13 = str7;
                        jSONArray = jSONArray2;
                    }
                    str7 = str13;
                    it2 = keys;
                    jSONArray2 = jSONArray;
                    if (i3 % 50 != 49) {
                    }
                    i3++;
                    str17 = str11;
                    str16 = str10;
                    str15 = str9;
                    str14 = str8;
                    keys = it2;
                    str13 = str7;
                    jSONArray = jSONArray2;
                }
                str2 = str13;
                str3 = str14;
                str4 = str15;
                str5 = str16;
                str6 = str17;
                it = keys;
                if (stringBuffer2.length() > 0) {
                    arrayList.add(String.format(Locale.US, "INSERT OR REPLACE INTO %s VALUES %s", "RGCROAD", stringBuffer2.toString()));
                }
            } else {
                str2 = str13;
                str3 = str14;
                str4 = str15;
                str5 = str16;
                str6 = str17;
                it = keys;
            }
            str17 = str6;
            str16 = str5;
            str15 = str4;
            str14 = str3;
            keys = it;
            str13 = str2;
        }
        if (stringBuffer.length() > 0) {
            c = 0;
            i2 = 1;
            arrayList.add(String.format(Locale.US, "INSERT OR REPLACE INTO %s VALUES %s", "RGCUPDATE", stringBuffer));
        } else {
            i2 = 1;
            c = 0;
        }
        Locale locale = Locale.US;
        Object[] objArr = new Object[i2];
        objArr[c] = Integer.valueOf(i);
        arrayList.add(String.format(locale, "DELETE FROM RGCROAD WHERE _id NOT IN (SELECT _id FROM RGCROAD LIMIT %d);", objArr));
        return arrayList;
    }
}