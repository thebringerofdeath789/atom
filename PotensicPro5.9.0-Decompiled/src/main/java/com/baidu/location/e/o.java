package com.baidu.location.e;

import com.baidu.location.e.l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
enum o extends l.b {
    o(String str, int i, String str2, String str3, String str4, int i2, int i3) {
        super(str, i, str2, str3, str4, i2, i3);
    }

    @Override // com.baidu.location.e.l.b
    List<String> a(JSONObject jSONObject, String str, int i) {
        int i2;
        char c;
        JSONArray jSONArray;
        String str2;
        String str3;
        String str4;
        String str5;
        Iterator<String> it;
        String str6;
        String str7;
        String str8;
        String str9;
        Iterator<String> it2;
        String str10;
        String str11;
        Double d;
        String str12 = "y";
        String str13 = "x";
        String str14 = "stn";
        String str15 = "st";
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
            l.b.b(stringBuffer, next, str, 0);
            try {
                jSONArray = jSONObject.getJSONArray(next);
            } catch (JSONException unused) {
                jSONArray = null;
            }
            if (jSONArray != null) {
                while (i3 < jSONArray.length()) {
                    try {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i3);
                        if (jSONObject2.has(str15)) {
                            str9 = str15;
                            str10 = jSONObject2.getString(str15);
                        } else {
                            str9 = str15;
                            str10 = null;
                        }
                        try {
                            if (jSONObject2.has(str14)) {
                                str8 = str14;
                                str11 = jSONObject2.getString(str14);
                            } else {
                                str8 = str14;
                                str11 = null;
                            }
                            try {
                                if (jSONObject2.has(str13)) {
                                    str7 = str13;
                                    d = Double.valueOf(jSONObject2.getDouble(str13));
                                } else {
                                    str7 = str13;
                                    d = null;
                                }
                                try {
                                    Double valueOf = jSONObject2.has(str12) ? Double.valueOf(jSONObject2.getDouble(str12)) : null;
                                    str6 = str12;
                                    if (stringBuffer2.length() > 0) {
                                        try {
                                            stringBuffer2.append(",");
                                        } catch (JSONException unused2) {
                                            it2 = keys;
                                            if (i3 % 50 != 49) {
                                            }
                                            i3++;
                                            str15 = str9;
                                            str14 = str8;
                                            str13 = str7;
                                            keys = it2;
                                            str12 = str6;
                                        }
                                    }
                                    it2 = keys;
                                    try {
                                        stringBuffer2.append("(NULL,\"").append(next).append("\",\"").append(str10).append("\",\"").append(str11).append("\",").append(d).append(",").append(valueOf).append(")");
                                    } catch (JSONException unused3) {
                                    }
                                } catch (JSONException unused4) {
                                    str6 = str12;
                                }
                            } catch (JSONException unused5) {
                                str6 = str12;
                                str7 = str13;
                            }
                        } catch (JSONException unused6) {
                            str6 = str12;
                            str7 = str13;
                            str8 = str14;
                        }
                    } catch (JSONException unused7) {
                        str6 = str12;
                        str7 = str13;
                        str8 = str14;
                        str9 = str15;
                    }
                    if (i3 % 50 != 49 && stringBuffer2.length() > 0) {
                        arrayList.add(String.format(Locale.US, "INSERT OR REPLACE INTO %s VALUES %s", "RGCSITE", stringBuffer2.toString()));
                        stringBuffer2.setLength(0);
                    }
                    i3++;
                    str15 = str9;
                    str14 = str8;
                    str13 = str7;
                    keys = it2;
                    str12 = str6;
                }
                str2 = str12;
                str3 = str13;
                str4 = str14;
                str5 = str15;
                it = keys;
                if (stringBuffer2.length() > 0) {
                    arrayList.add(String.format(Locale.US, "INSERT OR REPLACE INTO %s VALUES %s", "RGCSITE", stringBuffer2.toString()));
                }
            } else {
                str2 = str12;
                str3 = str13;
                str4 = str14;
                str5 = str15;
                it = keys;
            }
            str15 = str5;
            str14 = str4;
            str13 = str3;
            keys = it;
            str12 = str2;
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
        arrayList.add(String.format(locale, "DELETE FROM RGCSITE WHERE _id NOT IN (SELECT _id FROM RGCSITE LIMIT %d);", objArr));
        return arrayList;
    }
}
