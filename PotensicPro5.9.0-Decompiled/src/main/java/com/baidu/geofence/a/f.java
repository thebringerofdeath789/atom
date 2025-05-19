package com.baidu.geofence.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.geofence.GeoFence;
import com.baidu.geofence.GeoFenceListener;
import com.baidu.geofence.PoiItem;
import com.baidu.geofence.model.DPoint;
import com.baidu.lbsapi.auth.LBSAuthManager;
import com.baidu.lbsapi.auth.LBSAuthManagerListener;
import com.baidu.location.b.x;
import com.baidu.location.h.o;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class f extends com.baidu.location.h.g implements LBSAuthManagerListener {
    private String b;
    private String c;
    private String d;
    private boolean e;
    private DPoint f;
    private float r;
    private int s;
    private String t;
    private GeoFenceListener v;
    private String w;
    private ArrayList<GeoFence> x;
    private Context y;
    private a z;
    private final String a = "https://api.map.baidu.com/sdkproxy/v2/lbs_locsdk/place/v2/search";
    private boolean u = false;

    public interface a {
        void a(int i, ArrayList<PoiItem> arrayList);
    }

    public f(Context context, boolean z, GeoFenceListener geoFenceListener, ArrayList<GeoFence> arrayList) {
        this.k = new HashMap();
        this.e = z;
        this.x = arrayList;
        this.v = geoFenceListener;
        this.y = context;
        LBSAuthManager.getInstance(context).authenticate(false, "lbs_locsdk", null, this);
    }

    private void a() {
        if (this.u) {
            return;
        }
        this.u = true;
        ExecutorService c = x.a().c();
        if (c != null) {
            a(c);
        } else {
            b(false);
        }
    }

    public void a(float f) {
        this.r = f;
    }

    public void a(int i) {
        this.s = i;
    }

    public void a(a aVar) {
        this.z = aVar;
    }

    public void a(DPoint dPoint) {
        this.f = dPoint;
    }

    public void a(String str) {
        this.w = str;
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x01a2 A[Catch: JSONException -> 0x01cf, LOOP:0: B:23:0x005f->B:50:0x01a2, LOOP_END, TryCatch #2 {JSONException -> 0x01cf, blocks: (B:47:0x0121, B:48:0x019d, B:53:0x01b2, B:50:0x01a2, B:72:0x0141, B:77:0x01c1, B:79:0x01c6), top: B:18:0x0055 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x01a1 A[SYNTHETIC] */
    @Override // com.baidu.location.h.g
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(boolean r27) {
        /*
            Method dump skipped, instructions count: 488
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.geofence.a.f.a(boolean):void");
    }

    @Override // com.baidu.location.h.g
    public void b() {
        String str;
        String str2;
        StringBuffer stringBuffer = new StringBuffer(128);
        HashMap hashMap = new HashMap();
        hashMap.put("query", this.b);
        hashMap.put("token", this.c);
        hashMap.put("tag", this.d);
        hashMap.put("output", "json");
        hashMap.put("page_size", "20");
        hashMap.put("ret_coordtype", "gcj02ll");
        try {
            stringBuffer.append("query=");
            stringBuffer.append(URLEncoder.encode(this.b, "UTF-8"));
            stringBuffer.append("&output=");
            stringBuffer.append(URLEncoder.encode("json", "UTF-8"));
            stringBuffer.append("&ret_coordtype=");
            stringBuffer.append(URLEncoder.encode("gcj02ll", "UTF-8"));
            stringBuffer.append("&token=");
            stringBuffer.append(URLEncoder.encode(this.c, "UTF-8"));
            stringBuffer.append("&tag=");
            stringBuffer.append(URLEncoder.encode(this.d, "UTF-8"));
            stringBuffer.append("&page_size=");
            stringBuffer.append(URLEncoder.encode("20", "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        if (this.e) {
            try {
                stringBuffer.append("&location=");
                stringBuffer.append(URLEncoder.encode(this.f.getLatitude() + "," + this.f.getLongitude(), "UTF-8"));
                stringBuffer.append("&coord_type=");
                stringBuffer.append(URLEncoder.encode(String.valueOf(2), "UTF-8"));
                stringBuffer.append("&radius=");
                stringBuffer.append(URLEncoder.encode(String.valueOf(this.r), "UTF-8"));
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
            }
            hashMap.put("location", this.f.getLatitude() + "," + this.f.getLongitude());
            hashMap.put("coord_type", String.valueOf(2));
            str = String.valueOf(this.r);
            str2 = "radius";
        } else {
            stringBuffer.append("&region=");
            try {
                stringBuffer.append(URLEncoder.encode(this.t, "UTF-8"));
            } catch (UnsupportedEncodingException e3) {
                e3.printStackTrace();
            }
            str = this.t;
            str2 = "region";
        }
        hashMap.put(str2, str);
        String a2 = com.baidu.geofence.a.a.a(hashMap, "&");
        stringBuffer.append("&sign=");
        stringBuffer.append(a2);
        this.h = "https://api.map.baidu.com/sdkproxy/v2/lbs_locsdk/place/v2/search?" + stringBuffer.toString();
    }

    public void b(String str) {
        this.b = str;
    }

    public void c(String str) {
        this.d = str;
    }

    public void d(String str) {
        this.t = str;
    }

    @Override // com.baidu.lbsapi.auth.LBSAuthManagerListener
    public void onAuthResult(int i, String str) {
        GeoFenceListener geoFenceListener;
        if (i != 0 && (geoFenceListener = this.v) != null) {
            geoFenceListener.onGeoFenceCreateFinished(null, 11, this.w);
        }
        if (str != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("token")) {
                    this.c = jSONObject.optString("token");
                    if (o.b() || TextUtils.isEmpty(this.c)) {
                        return;
                    }
                    a();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
