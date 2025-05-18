package com.baidu.location.indoor;

import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.location.p006b.C0665s;
import com.baidu.location.p012h.AbstractC0725g;
import com.baidu.location.p012h.C0733o;
import com.google.android.exoplayer2.source.rtsp.SessionDescription;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.baidu.location.indoor.d */
/* loaded from: classes.dex */
public class C0739d {

    /* renamed from: a */
    public CopyOnWriteArrayList<C0738c> f1469a;

    /* renamed from: b */
    public CopyOnWriteArrayList<C0765x> f1470b;

    /* renamed from: c */
    private SharedPreferences f1471c;

    /* renamed from: d */
    private a f1472d;

    /* renamed from: e */
    private boolean f1473e;

    /* renamed from: f */
    private C0738c f1474f;

    /* renamed from: g */
    private long f1475g;

    /* renamed from: h */
    private String f1476h;

    /* renamed from: i */
    private C0765x f1477i;

    /* renamed from: com.baidu.location.indoor.d$a */
    class a extends AbstractC0725g {

        /* renamed from: a */
        public boolean f1478a;

        /* renamed from: b */
        final /* synthetic */ C0739d f1479b;

        @Override // com.baidu.location.p012h.AbstractC0725g
        /* renamed from: a */
        public void mo122a(boolean z) {
            if (z && !TextUtils.isEmpty(this.f1291j)) {
                try {
                    byte[] m1155b = C0733o.m1155b(Base64.decode(new JSONObject(this.f1291j).optString("data").getBytes(), 0));
                    String str = m1155b != null ? new String(m1155b, "UTF-8") : "";
                    JSONObject jSONObject = new JSONObject(str);
                    if (this.f1479b.f1471c != null) {
                        this.f1479b.f1471c.getString("Indoor-> BleWalkNavConfig_ver", SessionDescription.SUPPORTED_SDP_VERSION);
                        String string = jSONObject.has("ver") ? jSONObject.getString("ver") : null;
                        SharedPreferences.Editor edit = this.f1479b.f1471c.edit();
                        edit.putString("Indoor-> BleWalkNavConfig_data", str);
                        edit.putString("Indoor-> BleWalkNavConfig_ver", string);
                        edit.apply();
                        this.f1479b.m1202a(str);
                        long currentTimeMillis = System.currentTimeMillis() / 1000;
                        this.f1479b.f1475g = currentTimeMillis;
                        edit.putLong("Indoor-> BleWalkNavConfig_lastCheckTime", currentTimeMillis);
                        edit.putString("Indoor-> BleWalkNavConfig_cityCode", this.f1479b.f1476h);
                        edit.apply();
                    }
                } catch (Exception unused) {
                }
            }
            if (this.f1292k != null) {
                this.f1292k.clear();
            }
            this.f1478a = false;
        }

        @Override // com.baidu.location.p012h.AbstractC0725g
        /* renamed from: b */
        public void mo123b() {
            this.f1290i = 2;
            this.f1479b.f1471c.getString("Indoor-> BleWalkNavConfig_ver", SessionDescription.SUPPORTED_SDP_VERSION);
            this.f1292k.put("ver", SessionDescription.SUPPORTED_SDP_VERSION);
            this.f1292k.put("newIn", "newIn");
            this.f1292k.put("sdk", Float.valueOf(9.401f));
            this.f1292k.put("stp", 1);
            this.f1292k.put("city_code", this.f1479b.f1476h);
        }
    }

    /* renamed from: com.baidu.location.indoor.d$b */
    private static class b {

        /* renamed from: a */
        public static final C0739d f1480a = new C0739d(null);
    }

    private C0739d() {
        this.f1471c = null;
        this.f1472d = null;
        this.f1473e = false;
        this.f1474f = null;
        this.f1475g = 0L;
        this.f1476h = "";
        this.f1477i = null;
        this.f1476h = C0665s.m546a().m548a("mapcity", "");
    }

    /* synthetic */ C0739d(C0740e c0740e) {
        this();
    }

    /* renamed from: a */
    public static C0739d m1200a() {
        return b.f1480a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m1202a(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("city_indoor_loc_rects")) {
                JSONArray jSONArray = jSONObject.getJSONArray("city_indoor_loc_rects");
                if (jSONArray.length() > 0) {
                    ArrayList<C0738c> arrayList = new ArrayList<>();
                    ArrayList<C0765x> arrayList2 = new ArrayList<>();
                    for (int i = 0; i < jSONArray.length(); i++) {
                        JSONObject optJSONObject = jSONArray.optJSONObject(i);
                        if (optJSONObject != null) {
                            if (optJSONObject.has("city_code")) {
                                optJSONObject.optString("city_code");
                            }
                            m1204a(optJSONObject, arrayList);
                            m1207b(optJSONObject, arrayList2);
                        }
                    }
                    m1203a(arrayList);
                    m1206b(arrayList2);
                }
            }
        } catch (Exception unused) {
        }
    }

    /* renamed from: a */
    private void m1203a(ArrayList<C0738c> arrayList) {
        CopyOnWriteArrayList<C0738c> copyOnWriteArrayList = this.f1469a;
        if (copyOnWriteArrayList == null) {
            this.f1469a = new CopyOnWriteArrayList<>();
        } else if (copyOnWriteArrayList.size() > 0) {
            this.f1469a.clear();
        }
        if (arrayList.size() > 0) {
            this.f1469a.addAll(arrayList);
        }
    }

    /* renamed from: a */
    private void m1204a(JSONObject jSONObject, ArrayList<C0738c> arrayList) {
        JSONArray optJSONArray;
        if (!jSONObject.has("indoor_loc_rect_info") || (optJSONArray = jSONObject.optJSONArray("indoor_loc_rect_info")) == null) {
            return;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            arrayList.add(new C0738c(optJSONArray.optJSONObject(i)));
        }
    }

    /* renamed from: b */
    private void m1206b(ArrayList<C0765x> arrayList) {
        CopyOnWriteArrayList<C0765x> copyOnWriteArrayList = this.f1470b;
        if (copyOnWriteArrayList == null) {
            this.f1470b = new CopyOnWriteArrayList<>();
        } else if (copyOnWriteArrayList.size() > 0) {
            this.f1470b.clear();
        }
        if (arrayList.size() > 0) {
            this.f1470b.addAll(arrayList);
        }
    }

    /* renamed from: b */
    private void m1207b(JSONObject jSONObject, ArrayList<C0765x> arrayList) {
        JSONArray optJSONArray;
        if (!jSONObject.has("outdoor_loc_rect_info") || (optJSONArray = jSONObject.optJSONArray("outdoor_loc_rect_info")) == null) {
            return;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            arrayList.add(new C0765x(optJSONArray.optJSONObject(i)));
        }
    }

    /* renamed from: b */
    public synchronized C0738c m1208b() {
        return this.f1474f;
    }
}