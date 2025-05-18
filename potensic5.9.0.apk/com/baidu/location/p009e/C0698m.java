package com.baidu.location.p009e;

import com.baidu.location.p009e.C0697l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.baidu.location.e.m */
/* loaded from: classes.dex */
enum C0698m extends C0697l.b {
    C0698m(String str, int i, String str2, String str3, String str4, int i2, int i3) {
        super(str, i, str2, str3, str4, i2, i3);
    }

    @Override // com.baidu.location.p009e.C0697l.b
    /* renamed from: a */
    List<String> mo893a(JSONObject jSONObject, String str, int i) {
        int i2;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        String str12;
        String str13 = "dist";
        String str14 = "ct";
        String str15 = "ctc";
        String str16 = "prov";
        String str17 = "cyc";
        String str18 = "cy";
        Iterator<String> keys = jSONObject.keys();
        StringBuffer stringBuffer = new StringBuffer();
        StringBuffer stringBuffer2 = new StringBuffer();
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        while (keys.hasNext()) {
            String next = keys.next();
            Iterator<String> it = keys;
            try {
                JSONObject jSONObject2 = jSONObject.getJSONObject(next);
                if (jSONObject2.has(str18)) {
                    str7 = str18;
                    str8 = jSONObject2.getString(str18);
                } else {
                    str7 = str18;
                    str8 = null;
                }
                try {
                    if (jSONObject2.has(str17)) {
                        str6 = str17;
                        str9 = jSONObject2.getString(str17);
                    } else {
                        str6 = str17;
                        str9 = null;
                    }
                    try {
                        if (jSONObject2.has(str16)) {
                            str5 = str16;
                            str10 = jSONObject2.getString(str16);
                        } else {
                            str5 = str16;
                            str10 = null;
                        }
                        try {
                            if (jSONObject2.has(str15)) {
                                str4 = str15;
                                str11 = jSONObject2.getString(str15);
                            } else {
                                str4 = str15;
                                str11 = null;
                            }
                            try {
                                if (jSONObject2.has(str14)) {
                                    str3 = str14;
                                    str12 = jSONObject2.getString(str14);
                                } else {
                                    str3 = str14;
                                    str12 = null;
                                }
                                try {
                                    String string = jSONObject2.has(str13) ? jSONObject2.getString(str13) : null;
                                    if (stringBuffer.length() > 0) {
                                        str2 = str13;
                                        try {
                                            stringBuffer.append(",");
                                        } catch (JSONException unused) {
                                            if (i3 % 50 != 49) {
                                            }
                                            i3++;
                                            keys = it;
                                            str18 = str7;
                                            str13 = str2;
                                            str17 = str6;
                                            str16 = str5;
                                            str15 = str4;
                                            str14 = str3;
                                        }
                                    } else {
                                        str2 = str13;
                                    }
                                    stringBuffer.append("(\"").append(next).append("\",\"").append(str8).append("\",\"").append(str9).append("\",\"").append(str10).append("\",\"").append(str12).append("\",\"").append(str11).append("\",\"").append(string).append("\",").append(System.currentTimeMillis() / 1000).append(",\"\")");
                                    try {
                                        C0697l.b.m890b(stringBuffer2, next, str, 0);
                                    } catch (JSONException unused2) {
                                    }
                                } catch (JSONException unused3) {
                                    str2 = str13;
                                }
                            } catch (JSONException unused4) {
                                str2 = str13;
                                str3 = str14;
                            }
                        } catch (JSONException unused5) {
                            str2 = str13;
                            str3 = str14;
                            str4 = str15;
                        }
                    } catch (JSONException unused6) {
                        str2 = str13;
                        str3 = str14;
                        str4 = str15;
                        str5 = str16;
                    }
                } catch (JSONException unused7) {
                    str2 = str13;
                    str3 = str14;
                    str4 = str15;
                    str5 = str16;
                    str6 = str17;
                }
            } catch (JSONException unused8) {
                str2 = str13;
                str3 = str14;
                str4 = str15;
                str5 = str16;
                str6 = str17;
                str7 = str18;
            }
            if (i3 % 50 != 49 && stringBuffer.length() > 0) {
                arrayList.add(String.format(Locale.US, "INSERT OR REPLACE INTO %s VALUES %s", "RGCAREA", stringBuffer));
                arrayList.add(String.format(Locale.US, "INSERT OR REPLACE INTO %s VALUES %s", "RGCUPDATE", stringBuffer2));
                stringBuffer.setLength(0);
            }
            i3++;
            keys = it;
            str18 = str7;
            str13 = str2;
            str17 = str6;
            str16 = str5;
            str15 = str4;
            str14 = str3;
        }
        if (stringBuffer.length() > 0) {
            i2 = 1;
            arrayList.add(String.format(Locale.US, "INSERT OR REPLACE INTO %s VALUES %s", "RGCAREA", stringBuffer));
            arrayList.add(String.format(Locale.US, "INSERT OR REPLACE INTO %s VALUES %s", "RGCUPDATE", stringBuffer2));
            stringBuffer.setLength(0);
        } else {
            i2 = 1;
        }
        Locale locale = Locale.US;
        Object[] objArr = new Object[i2];
        objArr[0] = Integer.valueOf(i);
        arrayList.add(String.format(locale, "DELETE FROM RGCAREA WHERE gridkey NOT IN (SELECT gridkey FROM RGCAREA LIMIT %d);", objArr));
        return arrayList;
    }
}