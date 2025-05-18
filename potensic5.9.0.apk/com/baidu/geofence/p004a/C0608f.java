package com.baidu.geofence.p004a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.geofence.GeoFence;
import com.baidu.geofence.GeoFenceListener;
import com.baidu.geofence.PoiItem;
import com.baidu.geofence.model.DPoint;
import com.baidu.lbsapi.auth.LBSAuthManager;
import com.baidu.lbsapi.auth.LBSAuthManagerListener;
import com.baidu.location.p006b.C0670x;
import com.baidu.location.p012h.AbstractC0725g;
import com.baidu.location.p012h.C0733o;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import org.json.JSONObject;

/* renamed from: com.baidu.geofence.a.f */
/* loaded from: classes.dex */
public class C0608f extends AbstractC0725g implements LBSAuthManagerListener {

    /* renamed from: b */
    private String f173b;

    /* renamed from: c */
    private String f174c;

    /* renamed from: d */
    private String f175d;

    /* renamed from: e */
    private boolean f176e;

    /* renamed from: f */
    private DPoint f177f;

    /* renamed from: r */
    private float f178r;

    /* renamed from: s */
    private int f179s;

    /* renamed from: t */
    private String f180t;

    /* renamed from: v */
    private GeoFenceListener f182v;

    /* renamed from: w */
    private String f183w;

    /* renamed from: x */
    private ArrayList<GeoFence> f184x;

    /* renamed from: y */
    private Context f185y;

    /* renamed from: z */
    private a f186z;

    /* renamed from: a */
    private final String f172a = "https://api.map.baidu.com/sdkproxy/v2/lbs_locsdk/place/v2/search";

    /* renamed from: u */
    private boolean f181u = false;

    /* renamed from: com.baidu.geofence.a.f$a */
    public interface a {
        /* renamed from: a */
        void mo137a(int i, ArrayList<PoiItem> arrayList);
    }

    public C0608f(Context context, boolean z, GeoFenceListener geoFenceListener, ArrayList<GeoFence> arrayList) {
        this.f1292k = new HashMap();
        this.f176e = z;
        this.f184x = arrayList;
        this.f182v = geoFenceListener;
        this.f185y = context;
        LBSAuthManager.getInstance(context).authenticate(false, "lbs_locsdk", null, this);
    }

    /* renamed from: a */
    private void m126a() {
        if (this.f181u) {
            return;
        }
        this.f181u = true;
        ExecutorService m592c = C0670x.m590a().m592c();
        if (m592c != null) {
            m1128a(m592c);
        } else {
            m1132b(false);
        }
    }

    /* renamed from: a */
    public void m129a(float f) {
        this.f178r = f;
    }

    /* renamed from: a */
    public void m130a(int i) {
        this.f179s = i;
    }

    /* renamed from: a */
    public void m131a(a aVar) {
        this.f186z = aVar;
    }

    /* renamed from: a */
    public void m132a(DPoint dPoint) {
        this.f177f = dPoint;
    }

    /* renamed from: a */
    public void m133a(String str) {
        this.f183w = str;
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x01a2 A[Catch: JSONException -> 0x01cf, LOOP:0: B:23:0x005f->B:50:0x01a2, LOOP_END, TryCatch #2 {JSONException -> 0x01cf, blocks: (B:47:0x0121, B:48:0x019d, B:53:0x01b2, B:50:0x01a2, B:72:0x0141, B:77:0x01c1, B:79:0x01c6), top: B:18:0x0055 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x01a1 A[SYNTHETIC] */
    @Override // com.baidu.location.p012h.AbstractC0725g
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void mo122a(boolean r27) {
        /*
            Method dump skipped, instructions count: 488
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.geofence.p004a.C0608f.mo122a(boolean):void");
    }

    @Override // com.baidu.location.p012h.AbstractC0725g
    /* renamed from: b */
    public void mo123b() {
        String str;
        String str2;
        StringBuffer stringBuffer = new StringBuffer(128);
        HashMap hashMap = new HashMap();
        hashMap.put("query", this.f173b);
        hashMap.put("token", this.f174c);
        hashMap.put("tag", this.f175d);
        hashMap.put("output", "json");
        hashMap.put("page_size", "20");
        hashMap.put("ret_coordtype", "gcj02ll");
        try {
            stringBuffer.append("query=");
            stringBuffer.append(URLEncoder.encode(this.f173b, "UTF-8"));
            stringBuffer.append("&output=");
            stringBuffer.append(URLEncoder.encode("json", "UTF-8"));
            stringBuffer.append("&ret_coordtype=");
            stringBuffer.append(URLEncoder.encode("gcj02ll", "UTF-8"));
            stringBuffer.append("&token=");
            stringBuffer.append(URLEncoder.encode(this.f174c, "UTF-8"));
            stringBuffer.append("&tag=");
            stringBuffer.append(URLEncoder.encode(this.f175d, "UTF-8"));
            stringBuffer.append("&page_size=");
            stringBuffer.append(URLEncoder.encode("20", "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        if (this.f176e) {
            try {
                stringBuffer.append("&location=");
                stringBuffer.append(URLEncoder.encode(this.f177f.getLatitude() + "," + this.f177f.getLongitude(), "UTF-8"));
                stringBuffer.append("&coord_type=");
                stringBuffer.append(URLEncoder.encode(String.valueOf(2), "UTF-8"));
                stringBuffer.append("&radius=");
                stringBuffer.append(URLEncoder.encode(String.valueOf(this.f178r), "UTF-8"));
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
            }
            hashMap.put("location", this.f177f.getLatitude() + "," + this.f177f.getLongitude());
            hashMap.put("coord_type", String.valueOf(2));
            str = String.valueOf(this.f178r);
            str2 = "radius";
        } else {
            stringBuffer.append("&region=");
            try {
                stringBuffer.append(URLEncoder.encode(this.f180t, "UTF-8"));
            } catch (UnsupportedEncodingException e3) {
                e3.printStackTrace();
            }
            str = this.f180t;
            str2 = "region";
        }
        hashMap.put(str2, str);
        String m115a = C0603a.m115a(hashMap, "&");
        stringBuffer.append("&sign=");
        stringBuffer.append(m115a);
        this.f1289h = "https://api.map.baidu.com/sdkproxy/v2/lbs_locsdk/place/v2/search?" + stringBuffer.toString();
    }

    /* renamed from: b */
    public void m134b(String str) {
        this.f173b = str;
    }

    /* renamed from: c */
    public void m135c(String str) {
        this.f175d = str;
    }

    /* renamed from: d */
    public void m136d(String str) {
        this.f180t = str;
    }

    @Override // com.baidu.lbsapi.auth.LBSAuthManagerListener
    public void onAuthResult(int i, String str) {
        GeoFenceListener geoFenceListener;
        if (i != 0 && (geoFenceListener = this.f182v) != null) {
            geoFenceListener.onGeoFenceCreateFinished(null, 11, this.f183w);
        }
        if (str != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("token")) {
                    this.f174c = jSONObject.optString("token");
                    if (C0733o.m1152b() || TextUtils.isEmpty(this.f174c)) {
                        return;
                    }
                    m126a();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}