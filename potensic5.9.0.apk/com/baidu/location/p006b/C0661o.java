package com.baidu.location.p006b;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.baidu.location.BDAbstractLocationListener;
import com.baidu.location.BDLocation;
import com.baidu.location.LocationClient;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* renamed from: com.baidu.location.b.o */
/* loaded from: classes.dex */
public class C0661o {

    /* renamed from: j */
    private static long f600j = 12000;

    /* renamed from: a */
    public e f601a;

    /* renamed from: b */
    private Context f602b;

    /* renamed from: c */
    private WebView f603c;

    /* renamed from: d */
    private LocationClient f604d;

    /* renamed from: e */
    private a f605e;

    /* renamed from: f */
    private List<b> f606f;

    /* renamed from: g */
    private boolean f607g;

    /* renamed from: h */
    private long f608h;

    /* renamed from: i */
    private BDLocation f609i;

    /* renamed from: k */
    private f f610k;

    /* renamed from: l */
    private boolean f611l;

    /* renamed from: com.baidu.location.b.o$a */
    private class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        /* renamed from: a */
        private String m492a(BDLocation bDLocation) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("latitude", bDLocation.getLatitude());
                jSONObject.put("longitude", bDLocation.getLongitude());
                jSONObject.put("radius", bDLocation.getRadius());
                jSONObject.put("errorcode", 1);
                if (bDLocation.hasAltitude()) {
                    jSONObject.put("altitude", bDLocation.getAltitude());
                }
                if (bDLocation.hasSpeed()) {
                    jSONObject.put("speed", bDLocation.getSpeed() / 3.6f);
                }
                if (bDLocation.getLocType() == 61) {
                    jSONObject.put("direction", bDLocation.getDirection());
                }
                if (bDLocation.getBuildingName() != null) {
                    jSONObject.put("buildingname", bDLocation.getBuildingName());
                }
                if (bDLocation.getBuildingID() != null) {
                    jSONObject.put("buildingid", bDLocation.getBuildingID());
                }
                if (bDLocation.getFloor() != null) {
                    jSONObject.put("floor", bDLocation.getFloor());
                }
                return jSONObject.toString();
            } catch (Exception unused) {
                return null;
            }
        }

        /* renamed from: a */
        private void m493a(String str) {
            if (C0661o.this.f611l) {
                C0661o.this.f605e.removeCallbacks(C0661o.this.f610k);
                C0661o.this.f611l = false;
            }
            if (C0661o.this.f606f == null || C0661o.this.f606f.size() <= 0) {
                return;
            }
            Iterator it = C0661o.this.f606f.iterator();
            while (it.hasNext()) {
                try {
                    b bVar = (b) it.next();
                    if (bVar.m495b() != null) {
                        C0661o.this.f603c.loadUrl("javascript:" + bVar.m495b() + "('" + str + "')");
                    }
                    it.remove();
                } catch (Exception unused) {
                    return;
                }
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:35:0x0123  */
        /* JADX WARN: Removed duplicated region for block: B:43:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Type inference failed for: r4v0, types: [com.baidu.location.b.o$1] */
        /* JADX WARN: Type inference failed for: r4v7, types: [java.lang.String] */
        @Override // android.os.Handler
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void handleMessage(android.os.Message r10) {
            /*
                Method dump skipped, instructions count: 380
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.p006b.C0661o.a.handleMessage(android.os.Message):void");
        }
    }

    /* renamed from: com.baidu.location.b.o$b */
    private class b {

        /* renamed from: b */
        private String f614b;

        /* renamed from: c */
        private String f615c;

        /* renamed from: d */
        private long f616d;

        b(String str) {
            this.f614b = null;
            this.f615c = null;
            this.f616d = 0L;
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("action")) {
                    this.f614b = jSONObject.getString("action");
                }
                if (jSONObject.has("callback")) {
                    this.f615c = jSONObject.getString("callback");
                }
                if (jSONObject.has(RtspHeaders.Values.TIMEOUT)) {
                    long j = jSONObject.getLong(RtspHeaders.Values.TIMEOUT);
                    if (j >= 1000) {
                        long unused = C0661o.f600j = j;
                    }
                }
                this.f616d = System.currentTimeMillis();
            } catch (Exception unused2) {
                this.f614b = null;
                this.f615c = null;
            }
        }

        /* renamed from: a */
        public String m494a() {
            return this.f614b;
        }

        /* renamed from: b */
        public String m495b() {
            return this.f615c;
        }
    }

    /* renamed from: com.baidu.location.b.o$c */
    private static final class c {

        /* renamed from: a */
        private static final C0661o f617a = new C0661o();
    }

    /* renamed from: com.baidu.location.b.o$d */
    private class d {
        private d() {
        }

        @JavascriptInterface
        public void sendMessage(String str) {
            if (str == null || !C0661o.this.f607g) {
                return;
            }
            b bVar = C0661o.this.new b(str);
            if (bVar.m494a() == null || !bVar.m494a().equals("requestLoc") || C0661o.this.f605e == null) {
                return;
            }
            Message obtainMessage = C0661o.this.f605e.obtainMessage(1);
            obtainMessage.obj = bVar;
            obtainMessage.sendToTarget();
        }

        @JavascriptInterface
        public void showLog(String str) {
        }
    }

    /* renamed from: com.baidu.location.b.o$e */
    public class e extends BDAbstractLocationListener {
        public e() {
        }

        @Override // com.baidu.location.BDAbstractLocationListener
        public void onReceiveLocation(BDLocation bDLocation) {
            Message obtainMessage;
            String str;
            if (!C0661o.this.f607g || bDLocation == null) {
                return;
            }
            BDLocation bDLocation2 = new BDLocation(bDLocation);
            int locType = bDLocation2.getLocType();
            String coorType = bDLocation2.getCoorType();
            if (locType == 61 || locType == 161 || locType == 66) {
                if (coorType != null) {
                    if (coorType.equals("gcj02")) {
                        bDLocation2 = LocationClient.getBDLocationInCoorType(bDLocation2, "gcj2wgs");
                    } else {
                        if (coorType.equals("bd09")) {
                            str = BDLocation.BDLOCATION_BD09_TO_GCJ02;
                        } else if (coorType.equals("bd09ll")) {
                            str = BDLocation.BDLOCATION_BD09LL_TO_GCJ02;
                        }
                        bDLocation2 = LocationClient.getBDLocationInCoorType(LocationClient.getBDLocationInCoorType(bDLocation2, str), "gcj2wgs");
                    }
                }
                C0661o.this.f608h = System.currentTimeMillis();
                C0661o.this.f609i = new BDLocation(bDLocation2);
                obtainMessage = C0661o.this.f605e.obtainMessage(2);
                obtainMessage.obj = bDLocation2;
            } else {
                obtainMessage = C0661o.this.f605e.obtainMessage(5);
            }
            obtainMessage.sendToTarget();
        }
    }

    /* renamed from: com.baidu.location.b.o$f */
    private class f implements Runnable {
        private f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            C0661o.this.f611l = false;
            C0661o.this.f605e.obtainMessage(6).sendToTarget();
        }
    }

    private C0661o() {
        this.f602b = null;
        this.f604d = null;
        this.f601a = new e();
        this.f605e = null;
        this.f606f = null;
        this.f607g = false;
        this.f608h = 0L;
        this.f609i = null;
        this.f610k = null;
        this.f611l = false;
    }

    /* renamed from: a */
    public static C0661o m476a() {
        return c.f617a;
    }

    /* renamed from: a */
    private void m478a(WebView webView) {
        webView.addJavascriptInterface(new d(), "BaiduLocAssistant");
    }

    /* renamed from: a */
    public void m490a(Context context, WebView webView, LocationClient locationClient) {
        if (!this.f607g && Integer.valueOf(Build.VERSION.SDK_INT).intValue() >= 17) {
            this.f602b = context;
            this.f603c = webView;
            this.f604d = locationClient;
            a aVar = new a(Looper.getMainLooper());
            this.f605e = aVar;
            aVar.obtainMessage(3).sendToTarget();
            WebSettings settings = webView.getSettings();
            settings.setJavaScriptEnabled(true);
            settings.setAllowFileAccess(false);
            settings.setSavePassword(false);
            this.f603c.removeJavascriptInterface("searchBoxJavaBridge_");
            this.f603c.removeJavascriptInterface("accessibility");
            this.f603c.removeJavascriptInterface("accessibilityTraversal");
            m478a(this.f603c);
            this.f607g = true;
        }
    }

    /* renamed from: b */
    public void m491b() {
        if (this.f607g) {
            this.f605e.obtainMessage(4).sendToTarget();
            this.f607g = false;
        }
    }
}