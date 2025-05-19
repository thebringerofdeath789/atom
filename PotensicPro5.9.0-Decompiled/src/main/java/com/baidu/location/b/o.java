package com.baidu.location.b;

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

/* loaded from: classes.dex */
public class o {
    private static long j = 12000;
    public e a;
    private Context b;
    private WebView c;
    private LocationClient d;
    private a e;
    private List<b> f;
    private boolean g;
    private long h;
    private BDLocation i;
    private f k;
    private boolean l;

    private class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        private String a(BDLocation bDLocation) {
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

        private void a(String str) {
            if (o.this.l) {
                o.this.e.removeCallbacks(o.this.k);
                o.this.l = false;
            }
            if (o.this.f == null || o.this.f.size() <= 0) {
                return;
            }
            Iterator it = o.this.f.iterator();
            while (it.hasNext()) {
                try {
                    b bVar = (b) it.next();
                    if (bVar.b() != null) {
                        o.this.c.loadUrl("javascript:" + bVar.b() + "('" + str + "')");
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
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.b.o.a.handleMessage(android.os.Message):void");
        }
    }

    private class b {
        private String b;
        private String c;
        private long d;

        b(String str) {
            this.b = null;
            this.c = null;
            this.d = 0L;
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("action")) {
                    this.b = jSONObject.getString("action");
                }
                if (jSONObject.has("callback")) {
                    this.c = jSONObject.getString("callback");
                }
                if (jSONObject.has(RtspHeaders.Values.TIMEOUT)) {
                    long j = jSONObject.getLong(RtspHeaders.Values.TIMEOUT);
                    if (j >= 1000) {
                        long unused = o.j = j;
                    }
                }
                this.d = System.currentTimeMillis();
            } catch (Exception unused2) {
                this.b = null;
                this.c = null;
            }
        }

        public String a() {
            return this.b;
        }

        public String b() {
            return this.c;
        }
    }

    private static final class c {
        private static final o a = new o();
    }

    private class d {
        private d() {
        }

        @JavascriptInterface
        public void sendMessage(String str) {
            if (str == null || !o.this.g) {
                return;
            }
            b bVar = o.this.new b(str);
            if (bVar.a() == null || !bVar.a().equals("requestLoc") || o.this.e == null) {
                return;
            }
            Message obtainMessage = o.this.e.obtainMessage(1);
            obtainMessage.obj = bVar;
            obtainMessage.sendToTarget();
        }

        @JavascriptInterface
        public void showLog(String str) {
        }
    }

    public class e extends BDAbstractLocationListener {
        public e() {
        }

        @Override // com.baidu.location.BDAbstractLocationListener
        public void onReceiveLocation(BDLocation bDLocation) {
            Message obtainMessage;
            String str;
            if (!o.this.g || bDLocation == null) {
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
                o.this.h = System.currentTimeMillis();
                o.this.i = new BDLocation(bDLocation2);
                obtainMessage = o.this.e.obtainMessage(2);
                obtainMessage.obj = bDLocation2;
            } else {
                obtainMessage = o.this.e.obtainMessage(5);
            }
            obtainMessage.sendToTarget();
        }
    }

    private class f implements Runnable {
        private f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            o.this.l = false;
            o.this.e.obtainMessage(6).sendToTarget();
        }
    }

    private o() {
        this.b = null;
        this.d = null;
        this.a = new e();
        this.e = null;
        this.f = null;
        this.g = false;
        this.h = 0L;
        this.i = null;
        this.k = null;
        this.l = false;
    }

    public static o a() {
        return c.a;
    }

    private void a(WebView webView) {
        webView.addJavascriptInterface(new d(), "BaiduLocAssistant");
    }

    public void a(Context context, WebView webView, LocationClient locationClient) {
        if (!this.g && Integer.valueOf(Build.VERSION.SDK_INT).intValue() >= 17) {
            this.b = context;
            this.c = webView;
            this.d = locationClient;
            a aVar = new a(Looper.getMainLooper());
            this.e = aVar;
            aVar.obtainMessage(3).sendToTarget();
            WebSettings settings = webView.getSettings();
            settings.setJavaScriptEnabled(true);
            settings.setAllowFileAccess(false);
            settings.setSavePassword(false);
            this.c.removeJavascriptInterface("searchBoxJavaBridge_");
            this.c.removeJavascriptInterface("accessibility");
            this.c.removeJavascriptInterface("accessibilityTraversal");
            a(this.c);
            this.g = true;
        }
    }

    public void b() {
        if (this.g) {
            this.e.obtainMessage(4).sendToTarget();
            this.g = false;
        }
    }
}
