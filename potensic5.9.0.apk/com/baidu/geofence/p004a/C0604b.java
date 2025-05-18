package com.baidu.geofence.p004a;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.baidu.geofence.GeoFenceClient;
import com.baidu.geofence.GeoFenceListener;
import com.baidu.lbsapi.auth.LBSAuthManager;
import com.baidu.lbsapi.auth.LBSAuthManagerListener;
import com.baidu.location.p006b.C0670x;
import com.baidu.location.p012h.AbstractC0725g;
import com.baidu.location.p012h.C0733o;
import com.mapbox.api.geocoding.p024v5.GeocodingCriteria;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.baidu.geofence.a.b */
/* loaded from: classes.dex */
public class C0604b extends AbstractC0725g implements LBSAuthManagerListener {

    /* renamed from: b */
    private String f163b;

    /* renamed from: c */
    private String f164c;

    /* renamed from: e */
    private GeoFenceListener f166e;

    /* renamed from: f */
    private a f167f;

    /* renamed from: a */
    private final String f162a = "https://api.map.baidu.com/sdkproxy/v2/lbs_locsdk/geocoding/v3/";

    /* renamed from: d */
    private boolean f165d = false;

    /* renamed from: com.baidu.geofence.a.b$a */
    public interface a {
        /* renamed from: a */
        void mo124a(int i);
    }

    public C0604b(String str, Context context) {
        this.f164c = str;
        LBSAuthManager.getInstance(context).authenticate(false, "lbs_locsdk", null, this);
    }

    /* renamed from: a */
    public void m119a() {
        if (this.f165d) {
            return;
        }
        this.f165d = true;
        ExecutorService m592c = C0670x.m590a().m592c();
        if (m592c != null) {
            m1128a(m592c);
        } else {
            m1132b(false);
        }
    }

    /* renamed from: a */
    public void m120a(GeoFenceListener geoFenceListener) {
        this.f166e = geoFenceListener;
    }

    /* renamed from: a */
    public void m121a(a aVar) {
        this.f167f = aVar;
    }

    @Override // com.baidu.location.p012h.AbstractC0725g
    /* renamed from: a */
    public void mo122a(boolean z) {
        if (z && TextUtils.isEmpty(this.f1291j)) {
            GeoFenceClient.getHandlerInstance().post(new RunnableC0605c(this));
            return;
        }
        if (!z) {
            GeoFenceClient.getHandlerInstance().post(new RunnableC0606d(this));
            return;
        }
        if (z && this.f1291j != null) {
            try {
                JSONObject jSONObject = new JSONObject(this.f1291j);
                if (jSONObject.has(NotificationCompat.CATEGORY_STATUS)) {
                    GeoFenceClient.getHandlerInstance().post(new RunnableC0607e(this, jSONObject.optInt(NotificationCompat.CATEGORY_STATUS)));
                }
            } catch (JSONException unused) {
                GeoFenceListener geoFenceListener = this.f166e;
                if (geoFenceListener != null) {
                    geoFenceListener.onGeoFenceCreateFinished(null, 10, null);
                }
            }
        }
        this.f165d = false;
    }

    @Override // com.baidu.location.p012h.AbstractC0725g
    /* renamed from: b */
    public void mo123b() {
        StringBuffer stringBuffer = new StringBuffer(128);
        try {
            stringBuffer.append("address=");
            stringBuffer.append(URLEncoder.encode(this.f164c, "UTF-8"));
            stringBuffer.append("&token=");
            stringBuffer.append(URLEncoder.encode(this.f163b, "UTF-8"));
            stringBuffer.append("&output=");
            stringBuffer.append(URLEncoder.encode("json", "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        HashMap hashMap = new HashMap();
        hashMap.put(GeocodingCriteria.TYPE_ADDRESS, this.f164c);
        hashMap.put("token", this.f163b);
        hashMap.put("output", "json");
        String m115a = C0603a.m115a(hashMap, "&");
        stringBuffer.append("&sign=");
        stringBuffer.append(m115a);
        this.f1289h = "https://api.map.baidu.com/sdkproxy/v2/lbs_locsdk/geocoding/v3/?" + stringBuffer.toString();
    }

    @Override // com.baidu.lbsapi.auth.LBSAuthManagerListener
    public void onAuthResult(int i, String str) {
        GeoFenceListener geoFenceListener;
        if (i != 0 && (geoFenceListener = this.f166e) != null) {
            geoFenceListener.onGeoFenceCreateFinished(null, 11, null);
        }
        if (str != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("token")) {
                    this.f163b = jSONObject.optString("token");
                    if (C0733o.m1152b() || TextUtils.isEmpty(this.f163b)) {
                        return;
                    }
                    m119a();
                }
            } catch (Exception unused) {
            }
        }
    }
}