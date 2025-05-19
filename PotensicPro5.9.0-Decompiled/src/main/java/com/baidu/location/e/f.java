package com.baidu.location.e;

import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import com.baidu.geofence.GeoFence;
import com.baidu.location.Jni;
import com.google.android.exoplayer2.source.rtsp.RtspMediaSource;
import com.google.android.exoplayer2.source.rtsp.SessionDescription;
import java.io.File;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Locale;
import org.json.JSONObject;

/* loaded from: classes.dex */
final class f {
    private final h a;
    private final SQLiteDatabase b;
    private boolean u = true;
    private long v = RtspMediaSource.DEFAULT_TIMEOUT_MS;
    private long w = 5000;
    private long x = 5000;
    private long y = 5000;
    private long z = 5000;
    private boolean d = false;
    private boolean e = false;
    private boolean f = false;
    private boolean g = false;
    private boolean h = false;
    private boolean j = false;
    private boolean k = false;
    private int l = 6;
    private int m = 30;
    private int n = 30;
    private double o = 0.0d;
    private double p = 0.0d;
    private double q = 0.0d;
    private double r = 0.0d;
    private double s = 0.0d;
    private int t = 8;
    private String[] i = new String[0];
    private final a c = new a();

    /* JADX INFO: Access modifiers changed from: private */
    final class a extends com.baidu.location.h.g {
        private int b;
        private long c;
        private long d;
        private boolean e;
        private final String f;

        private a() {
            this.b = 0;
            this.e = false;
            this.c = -1L;
            this.d = -1L;
            this.k = new HashMap();
            this.f = Jni.encodeOfflineLocationUpdateRequest(String.format(Locale.US, "&ver=%s&cuid=%s&prod=%s:%s&sdk=%.2f&mb=%s&os=A%s", "1", com.baidu.location.h.b.a().c, com.baidu.location.h.b.f, com.baidu.location.h.b.e, Float.valueOf(9.401f), Build.MODEL, Build.VERSION.SDK));
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Removed duplicated region for block: B:86:0x01f6  */
        /* JADX WARN: Removed duplicated region for block: B:88:? A[RETURN, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void a() {
            /*
                Method dump skipped, instructions count: 517
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.e.f.a.a():void");
        }

        private boolean c() {
            if (this.b < 2) {
                return true;
            }
            if (this.c + 86400000 >= System.currentTimeMillis()) {
                return false;
            }
            this.b = 0;
            this.c = -1L;
            return true;
        }

        @Override // com.baidu.location.h.g
        public void a(boolean z) {
            int i;
            int i2;
            String str;
            String str2;
            String str3;
            if (z && this.j != null) {
                try {
                    JSONObject jSONObject = new JSONObject(this.j);
                    long j = jSONObject.has("ofl") ? jSONObject.getLong("ofl") : 0L;
                    String string = jSONObject.has("ver") ? jSONObject.getString("ver") : "1";
                    if ((j & 1) == 1) {
                        f.this.d = true;
                    }
                    if ((j & 2) == 2) {
                        f.this.e = true;
                    }
                    if ((j & 4) == 4) {
                        f.this.f = true;
                    }
                    if ((j & 8) == 8) {
                        f.this.g = true;
                    }
                    if ((j & 16) == 16) {
                        f.this.h = true;
                    }
                    if ((j & 32) == 32) {
                        f.this.j = true;
                    }
                    if ((j & 64) == 64) {
                        f.this.k = true;
                    }
                    JSONObject jSONObject2 = new JSONObject();
                    if (jSONObject.has("cplist")) {
                        f.this.i = jSONObject.getString("cplist").split(";");
                        jSONObject2.put("cplist", jSONObject.getString("cplist"));
                    }
                    if (jSONObject.has("bklist")) {
                        f.this.a(jSONObject.getString("bklist").split(";"));
                    }
                    String str4 = string;
                    if (jSONObject.has("para")) {
                        JSONObject jSONObject3 = jSONObject.getJSONObject("para");
                        if (jSONObject3.has("rgcgp")) {
                            str = "ver";
                            f.this.l = jSONObject3.getInt("rgcgp");
                        } else {
                            str = "ver";
                        }
                        if (jSONObject3.has("addrup")) {
                            f.this.n = jSONObject3.getInt("addrup");
                        }
                        if (jSONObject3.has("poiup")) {
                            f.this.m = jSONObject3.getInt("poiup");
                        }
                        if (jSONObject3.has("oflp")) {
                            JSONObject jSONObject4 = jSONObject3.getJSONObject("oflp");
                            if (jSONObject4.has(SessionDescription.SUPPORTED_SDP_VERSION)) {
                                str2 = "poiup";
                                str3 = "addrup";
                                f.this.o = jSONObject4.getDouble(SessionDescription.SUPPORTED_SDP_VERSION);
                            } else {
                                str2 = "poiup";
                                str3 = "addrup";
                            }
                            if (jSONObject4.has("1")) {
                                f.this.p = jSONObject4.getDouble("1");
                            }
                            if (jSONObject4.has(GeoFence.BUNDLE_KEY_CUSTOMID)) {
                                f.this.q = jSONObject4.getDouble(GeoFence.BUNDLE_KEY_CUSTOMID);
                            }
                            if (jSONObject4.has(GeoFence.BUNDLE_KEY_FENCESTATUS)) {
                                f.this.r = jSONObject4.getDouble(GeoFence.BUNDLE_KEY_FENCESTATUS);
                            }
                            if (jSONObject4.has(GeoFence.BUNDLE_KEY_LOCERRORCODE)) {
                                f.this.s = jSONObject4.getDouble(GeoFence.BUNDLE_KEY_LOCERRORCODE);
                            }
                        } else {
                            str2 = "poiup";
                            str3 = "addrup";
                        }
                        if (jSONObject3.has("onlt")) {
                            JSONObject jSONObject5 = jSONObject3.getJSONObject("onlt");
                            if (jSONObject5.has(SessionDescription.SUPPORTED_SDP_VERSION)) {
                                f.this.z = jSONObject5.getLong(SessionDescription.SUPPORTED_SDP_VERSION);
                            }
                            if (jSONObject5.has("1")) {
                                f.this.y = jSONObject5.getLong("1");
                            }
                            if (jSONObject5.has(GeoFence.BUNDLE_KEY_CUSTOMID)) {
                                f.this.v = jSONObject5.getLong(GeoFence.BUNDLE_KEY_CUSTOMID);
                            }
                            if (jSONObject5.has(GeoFence.BUNDLE_KEY_FENCESTATUS)) {
                                f.this.w = jSONObject5.getLong(GeoFence.BUNDLE_KEY_FENCESTATUS);
                            }
                            if (jSONObject5.has(GeoFence.BUNDLE_KEY_LOCERRORCODE)) {
                                f.this.x = jSONObject5.getLong(GeoFence.BUNDLE_KEY_LOCERRORCODE);
                            }
                        }
                        if (jSONObject3.has("minapn")) {
                            f.this.t = jSONObject3.getInt("minapn");
                        }
                    } else {
                        str = "ver";
                        str2 = "poiup";
                        str3 = "addrup";
                    }
                    jSONObject2.put("ol", f.this.d);
                    jSONObject2.put("olv2", f.this.k);
                    jSONObject2.put("fl", f.this.e);
                    jSONObject2.put("on", f.this.f);
                    jSONObject2.put("wn", f.this.g);
                    jSONObject2.put("oc", f.this.h);
                    long currentTimeMillis = System.currentTimeMillis();
                    this.d = currentTimeMillis;
                    jSONObject2.put("t", currentTimeMillis);
                    jSONObject2.put(str, str4);
                    jSONObject2.put("rgcon", f.this.j);
                    jSONObject2.put("rgcgp", f.this.l);
                    JSONObject jSONObject6 = new JSONObject();
                    jSONObject6.put(SessionDescription.SUPPORTED_SDP_VERSION, f.this.o);
                    jSONObject6.put("1", f.this.p);
                    jSONObject6.put(GeoFence.BUNDLE_KEY_CUSTOMID, f.this.q);
                    jSONObject6.put(GeoFence.BUNDLE_KEY_FENCESTATUS, f.this.r);
                    jSONObject6.put(GeoFence.BUNDLE_KEY_LOCERRORCODE, f.this.s);
                    jSONObject2.put("oflp", jSONObject6);
                    JSONObject jSONObject7 = new JSONObject();
                    jSONObject7.put(SessionDescription.SUPPORTED_SDP_VERSION, f.this.z);
                    jSONObject7.put("1", f.this.y);
                    jSONObject7.put(GeoFence.BUNDLE_KEY_CUSTOMID, f.this.v);
                    jSONObject7.put(GeoFence.BUNDLE_KEY_FENCESTATUS, f.this.w);
                    jSONObject7.put(GeoFence.BUNDLE_KEY_LOCERRORCODE, f.this.x);
                    jSONObject2.put("onlt", jSONObject7);
                    jSONObject2.put(str3, f.this.n);
                    jSONObject2.put(str2, f.this.m);
                    jSONObject2.put("minapn", f.this.t);
                    File file = new File(f.this.a.c(), "ofl.config");
                    if (!file.exists()) {
                        file.createNewFile();
                    }
                    FileWriter fileWriter = new FileWriter(file);
                    fileWriter.write(jSONObject2.toString());
                    fileWriter.close();
                } catch (Exception unused) {
                    i2 = this.b;
                    i = 1;
                }
                this.e = false;
            }
            i = 1;
            i2 = this.b;
            this.b = i2 + i;
            this.c = System.currentTimeMillis();
            this.e = false;
        }

        @Override // com.baidu.location.h.g
        public void b() {
            this.k.clear();
            this.k.put("qt", "conf");
            this.k.put("req", this.f);
            this.h = h.a;
        }
    }

    f(h hVar, SQLiteDatabase sQLiteDatabase) {
        this.a = hVar;
        this.b = sQLiteDatabase;
        if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
            try {
                sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS BLACK (name VARCHAR(100) PRIMARY KEY);");
            } catch (Exception unused) {
            }
        }
        g();
    }

    int a() {
        return this.t;
    }

    long a(String str) {
        if (str.equals("2G")) {
            return this.v;
        }
        if (str.equals("3G")) {
            return this.w;
        }
        if (str.equals("4G")) {
            return this.x;
        }
        if (str.equals("WIFI")) {
            return this.y;
        }
        if (str.equals("unknown")) {
            return this.z;
        }
        return 5000L;
    }

    void a(String[] strArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < strArr.length; i++) {
            if (i > 0) {
                stringBuffer.append(",");
            }
            stringBuffer.append("(\"");
            stringBuffer.append(strArr[i]);
            stringBuffer.append("\")");
        }
        SQLiteDatabase sQLiteDatabase = this.b;
        if (sQLiteDatabase == null || !sQLiteDatabase.isOpen() || stringBuffer.length() <= 0) {
            return;
        }
        try {
            this.b.execSQL(String.format(Locale.US, "INSERT OR IGNORE INTO BLACK VALUES %s;", stringBuffer.toString()));
        } catch (Exception unused) {
        }
    }

    double b() {
        return this.o;
    }

    double c() {
        return this.p;
    }

    double d() {
        return this.q;
    }

    double e() {
        return this.r;
    }

    double f() {
        return this.s;
    }

    void g() {
        a aVar = this.c;
        if (aVar != null) {
            aVar.a();
        }
    }

    boolean h() {
        return this.d;
    }

    boolean i() {
        return this.f;
    }

    boolean j() {
        return this.g;
    }

    boolean k() {
        return this.e;
    }

    boolean l() {
        return this.j;
    }

    boolean m() {
        return this.u;
    }

    int n() {
        return this.l;
    }

    String[] o() {
        return this.i;
    }

    int p() {
        return this.n;
    }

    int q() {
        return this.m;
    }
}
