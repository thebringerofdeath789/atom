package com.baidu.location.indoor;

import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import com.google.android.exoplayer2.source.rtsp.SessionDescription;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class d {
    public CopyOnWriteArrayList<c> a;
    public CopyOnWriteArrayList<x> b;
    private SharedPreferences c;
    private a d;
    private boolean e;
    private c f;
    private long g;
    private String h;
    private x i;

    class a extends com.baidu.location.h.g {
        public boolean a;
        final /* synthetic */ d b;

        @Override // com.baidu.location.h.g
        public void a(boolean z) {
            if (z && !TextUtils.isEmpty(this.j)) {
                try {
                    byte[] b = com.baidu.location.h.o.b(Base64.decode(new JSONObject(this.j).optString("data").getBytes(), 0));
                    String str = b != null ? new String(b, "UTF-8") : "";
                    JSONObject jSONObject = new JSONObject(str);
                    if (this.b.c != null) {
                        this.b.c.getString("Indoor-> BleWalkNavConfig_ver", SessionDescription.SUPPORTED_SDP_VERSION);
                        String string = jSONObject.has("ver") ? jSONObject.getString("ver") : null;
                        SharedPreferences.Editor edit = this.b.c.edit();
                        edit.putString("Indoor-> BleWalkNavConfig_data", str);
                        edit.putString("Indoor-> BleWalkNavConfig_ver", string);
                        edit.apply();
                        this.b.a(str);
                        long currentTimeMillis = System.currentTimeMillis() / 1000;
                        this.b.g = currentTimeMillis;
                        edit.putLong("Indoor-> BleWalkNavConfig_lastCheckTime", currentTimeMillis);
                        edit.putString("Indoor-> BleWalkNavConfig_cityCode", this.b.h);
                        edit.apply();
                    }
                } catch (Exception unused) {
                }
            }
            if (this.k != null) {
                this.k.clear();
            }
            this.a = false;
        }

        @Override // com.baidu.location.h.g
        public void b() {
            this.i = 2;
            this.b.c.getString("Indoor-> BleWalkNavConfig_ver", SessionDescription.SUPPORTED_SDP_VERSION);
            this.k.put("ver", SessionDescription.SUPPORTED_SDP_VERSION);
            this.k.put("newIn", "newIn");
            this.k.put("sdk", Float.valueOf(9.401f));
            this.k.put("stp", 1);
            this.k.put("city_code", this.b.h);
        }
    }

    private static class b {
        public static final d a = new d(null);
    }

    private d() {
        this.c = null;
        this.d = null;
        this.e = false;
        this.f = null;
        this.g = 0L;
        this.h = "";
        this.i = null;
        this.h = com.baidu.location.b.s.a().a("mapcity", "");
    }

    /* synthetic */ d(e eVar) {
        this();
    }

    public static d a() {
        return b.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("city_indoor_loc_rects")) {
                JSONArray jSONArray = jSONObject.getJSONArray("city_indoor_loc_rects");
                if (jSONArray.length() > 0) {
                    ArrayList<c> arrayList = new ArrayList<>();
                    ArrayList<x> arrayList2 = new ArrayList<>();
                    for (int i = 0; i < jSONArray.length(); i++) {
                        JSONObject optJSONObject = jSONArray.optJSONObject(i);
                        if (optJSONObject != null) {
                            if (optJSONObject.has("city_code")) {
                                optJSONObject.optString("city_code");
                            }
                            a(optJSONObject, arrayList);
                            b(optJSONObject, arrayList2);
                        }
                    }
                    a(arrayList);
                    b(arrayList2);
                }
            }
        } catch (Exception unused) {
        }
    }

    private void a(ArrayList<c> arrayList) {
        CopyOnWriteArrayList<c> copyOnWriteArrayList = this.a;
        if (copyOnWriteArrayList == null) {
            this.a = new CopyOnWriteArrayList<>();
        } else if (copyOnWriteArrayList.size() > 0) {
            this.a.clear();
        }
        if (arrayList.size() > 0) {
            this.a.addAll(arrayList);
        }
    }

    private void a(JSONObject jSONObject, ArrayList<c> arrayList) {
        JSONArray optJSONArray;
        if (!jSONObject.has("indoor_loc_rect_info") || (optJSONArray = jSONObject.optJSONArray("indoor_loc_rect_info")) == null) {
            return;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            arrayList.add(new c(optJSONArray.optJSONObject(i)));
        }
    }

    private void b(ArrayList<x> arrayList) {
        CopyOnWriteArrayList<x> copyOnWriteArrayList = this.b;
        if (copyOnWriteArrayList == null) {
            this.b = new CopyOnWriteArrayList<>();
        } else if (copyOnWriteArrayList.size() > 0) {
            this.b.clear();
        }
        if (arrayList.size() > 0) {
            this.b.addAll(arrayList);
        }
    }

    private void b(JSONObject jSONObject, ArrayList<x> arrayList) {
        JSONArray optJSONArray;
        if (!jSONObject.has("outdoor_loc_rect_info") || (optJSONArray = jSONObject.optJSONArray("outdoor_loc_rect_info")) == null) {
            return;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            arrayList.add(new x(optJSONArray.optJSONObject(i)));
        }
    }

    public synchronized c b() {
        return this.f;
    }
}
