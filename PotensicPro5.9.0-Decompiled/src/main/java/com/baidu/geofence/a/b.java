package com.baidu.geofence.a;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.baidu.geofence.GeoFenceClient;
import com.baidu.geofence.GeoFenceListener;
import com.baidu.lbsapi.auth.LBSAuthManager;
import com.baidu.lbsapi.auth.LBSAuthManagerListener;
import com.baidu.location.b.x;
import com.baidu.location.h.o;
import com.mapbox.api.geocoding.v5.GeocodingCriteria;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class b extends com.baidu.location.h.g implements LBSAuthManagerListener {
    private String b;
    private String c;
    private GeoFenceListener e;
    private a f;
    private final String a = "https://api.map.baidu.com/sdkproxy/v2/lbs_locsdk/geocoding/v3/";
    private boolean d = false;

    public interface a {
        void a(int i);
    }

    public b(String str, Context context) {
        this.c = str;
        LBSAuthManager.getInstance(context).authenticate(false, "lbs_locsdk", null, this);
    }

    public void a() {
        if (this.d) {
            return;
        }
        this.d = true;
        ExecutorService c = x.a().c();
        if (c != null) {
            a(c);
        } else {
            b(false);
        }
    }

    public void a(GeoFenceListener geoFenceListener) {
        this.e = geoFenceListener;
    }

    public void a(a aVar) {
        this.f = aVar;
    }

    @Override // com.baidu.location.h.g
    public void a(boolean z) {
        if (z && TextUtils.isEmpty(this.j)) {
            GeoFenceClient.getHandlerInstance().post(new c(this));
            return;
        }
        if (!z) {
            GeoFenceClient.getHandlerInstance().post(new d(this));
            return;
        }
        if (z && this.j != null) {
            try {
                JSONObject jSONObject = new JSONObject(this.j);
                if (jSONObject.has(NotificationCompat.CATEGORY_STATUS)) {
                    GeoFenceClient.getHandlerInstance().post(new e(this, jSONObject.optInt(NotificationCompat.CATEGORY_STATUS)));
                }
            } catch (JSONException unused) {
                GeoFenceListener geoFenceListener = this.e;
                if (geoFenceListener != null) {
                    geoFenceListener.onGeoFenceCreateFinished(null, 10, null);
                }
            }
        }
        this.d = false;
    }

    @Override // com.baidu.location.h.g
    public void b() {
        StringBuffer stringBuffer = new StringBuffer(128);
        try {
            stringBuffer.append("address=");
            stringBuffer.append(URLEncoder.encode(this.c, "UTF-8"));
            stringBuffer.append("&token=");
            stringBuffer.append(URLEncoder.encode(this.b, "UTF-8"));
            stringBuffer.append("&output=");
            stringBuffer.append(URLEncoder.encode("json", "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        HashMap hashMap = new HashMap();
        hashMap.put(GeocodingCriteria.TYPE_ADDRESS, this.c);
        hashMap.put("token", this.b);
        hashMap.put("output", "json");
        String a2 = com.baidu.geofence.a.a.a(hashMap, "&");
        stringBuffer.append("&sign=");
        stringBuffer.append(a2);
        this.h = "https://api.map.baidu.com/sdkproxy/v2/lbs_locsdk/geocoding/v3/?" + stringBuffer.toString();
    }

    @Override // com.baidu.lbsapi.auth.LBSAuthManagerListener
    public void onAuthResult(int i, String str) {
        GeoFenceListener geoFenceListener;
        if (i != 0 && (geoFenceListener = this.e) != null) {
            geoFenceListener.onGeoFenceCreateFinished(null, 11, null);
        }
        if (str != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("token")) {
                    this.b = jSONObject.optString("token");
                    if (o.b() || TextUtils.isEmpty(this.b)) {
                        return;
                    }
                    a();
                }
            } catch (Exception unused) {
            }
        }
    }
}
