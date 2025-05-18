package com.baidu.location.p009e;

import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import com.baidu.geofence.GeoFence;
import com.baidu.location.Jni;
import com.baidu.location.p012h.AbstractC0725g;
import com.baidu.location.p012h.C0720b;
import com.google.android.exoplayer2.source.rtsp.RtspMediaSource;
import com.google.android.exoplayer2.source.rtsp.SessionDescription;
import java.io.File;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Locale;
import org.json.JSONObject;

/* renamed from: com.baidu.location.e.f */
/* loaded from: classes.dex */
final class C0691f {

    /* renamed from: a */
    private final C0693h f909a;

    /* renamed from: b */
    private final SQLiteDatabase f910b;

    /* renamed from: u */
    private boolean f929u = true;

    /* renamed from: v */
    private long f930v = RtspMediaSource.DEFAULT_TIMEOUT_MS;

    /* renamed from: w */
    private long f931w = 5000;

    /* renamed from: x */
    private long f932x = 5000;

    /* renamed from: y */
    private long f933y = 5000;

    /* renamed from: z */
    private long f934z = 5000;

    /* renamed from: d */
    private boolean f912d = false;

    /* renamed from: e */
    private boolean f913e = false;

    /* renamed from: f */
    private boolean f914f = false;

    /* renamed from: g */
    private boolean f915g = false;

    /* renamed from: h */
    private boolean f916h = false;

    /* renamed from: j */
    private boolean f918j = false;

    /* renamed from: k */
    private boolean f919k = false;

    /* renamed from: l */
    private int f920l = 6;

    /* renamed from: m */
    private int f921m = 30;

    /* renamed from: n */
    private int f922n = 30;

    /* renamed from: o */
    private double f923o = 0.0d;

    /* renamed from: p */
    private double f924p = 0.0d;

    /* renamed from: q */
    private double f925q = 0.0d;

    /* renamed from: r */
    private double f926r = 0.0d;

    /* renamed from: s */
    private double f927s = 0.0d;

    /* renamed from: t */
    private int f928t = 8;

    /* renamed from: i */
    private String[] f917i = new String[0];

    /* renamed from: c */
    private final a f911c = new a();

    /* renamed from: com.baidu.location.e.f$a */
    private final class a extends AbstractC0725g {

        /* renamed from: b */
        private int f936b;

        /* renamed from: c */
        private long f937c;

        /* renamed from: d */
        private long f938d;

        /* renamed from: e */
        private boolean f939e;

        /* renamed from: f */
        private final String f940f;

        private a() {
            this.f936b = 0;
            this.f939e = false;
            this.f937c = -1L;
            this.f938d = -1L;
            this.f1292k = new HashMap();
            this.f940f = Jni.encodeOfflineLocationUpdateRequest(String.format(Locale.US, "&ver=%s&cuid=%s&prod=%s:%s&sdk=%.2f&mb=%s&os=A%s", "1", C0720b.m1100a().f1254c, C0720b.f1245f, C0720b.f1244e, Float.valueOf(9.401f), Build.MODEL, Build.VERSION.SDK));
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Removed duplicated region for block: B:86:0x01f6  */
        /* JADX WARN: Removed duplicated region for block: B:88:? A[RETURN, SYNTHETIC] */
        /* renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void m823a() {
            /*
                Method dump skipped, instructions count: 517
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.p009e.C0691f.a.m823a():void");
        }

        /* renamed from: c */
        private boolean m825c() {
            if (this.f936b < 2) {
                return true;
            }
            if (this.f937c + 86400000 >= System.currentTimeMillis()) {
                return false;
            }
            this.f936b = 0;
            this.f937c = -1L;
            return true;
        }

        @Override // com.baidu.location.p012h.AbstractC0725g
        /* renamed from: a */
        public void mo122a(boolean z) {
            int i;
            int i2;
            String str;
            String str2;
            String str3;
            if (z && this.f1291j != null) {
                try {
                    JSONObject jSONObject = new JSONObject(this.f1291j);
                    long j = jSONObject.has("ofl") ? jSONObject.getLong("ofl") : 0L;
                    String string = jSONObject.has("ver") ? jSONObject.getString("ver") : "1";
                    if ((j & 1) == 1) {
                        C0691f.this.f912d = true;
                    }
                    if ((j & 2) == 2) {
                        C0691f.this.f913e = true;
                    }
                    if ((j & 4) == 4) {
                        C0691f.this.f914f = true;
                    }
                    if ((j & 8) == 8) {
                        C0691f.this.f915g = true;
                    }
                    if ((j & 16) == 16) {
                        C0691f.this.f916h = true;
                    }
                    if ((j & 32) == 32) {
                        C0691f.this.f918j = true;
                    }
                    if ((j & 64) == 64) {
                        C0691f.this.f919k = true;
                    }
                    JSONObject jSONObject2 = new JSONObject();
                    if (jSONObject.has("cplist")) {
                        C0691f.this.f917i = jSONObject.getString("cplist").split(";");
                        jSONObject2.put("cplist", jSONObject.getString("cplist"));
                    }
                    if (jSONObject.has("bklist")) {
                        C0691f.this.m806a(jSONObject.getString("bklist").split(";"));
                    }
                    String str4 = string;
                    if (jSONObject.has("para")) {
                        JSONObject jSONObject3 = jSONObject.getJSONObject("para");
                        if (jSONObject3.has("rgcgp")) {
                            str = "ver";
                            C0691f.this.f920l = jSONObject3.getInt("rgcgp");
                        } else {
                            str = "ver";
                        }
                        if (jSONObject3.has("addrup")) {
                            C0691f.this.f922n = jSONObject3.getInt("addrup");
                        }
                        if (jSONObject3.has("poiup")) {
                            C0691f.this.f921m = jSONObject3.getInt("poiup");
                        }
                        if (jSONObject3.has("oflp")) {
                            JSONObject jSONObject4 = jSONObject3.getJSONObject("oflp");
                            if (jSONObject4.has(SessionDescription.SUPPORTED_SDP_VERSION)) {
                                str2 = "poiup";
                                str3 = "addrup";
                                C0691f.this.f923o = jSONObject4.getDouble(SessionDescription.SUPPORTED_SDP_VERSION);
                            } else {
                                str2 = "poiup";
                                str3 = "addrup";
                            }
                            if (jSONObject4.has("1")) {
                                C0691f.this.f924p = jSONObject4.getDouble("1");
                            }
                            if (jSONObject4.has(GeoFence.BUNDLE_KEY_CUSTOMID)) {
                                C0691f.this.f925q = jSONObject4.getDouble(GeoFence.BUNDLE_KEY_CUSTOMID);
                            }
                            if (jSONObject4.has(GeoFence.BUNDLE_KEY_FENCESTATUS)) {
                                C0691f.this.f926r = jSONObject4.getDouble(GeoFence.BUNDLE_KEY_FENCESTATUS);
                            }
                            if (jSONObject4.has(GeoFence.BUNDLE_KEY_LOCERRORCODE)) {
                                C0691f.this.f927s = jSONObject4.getDouble(GeoFence.BUNDLE_KEY_LOCERRORCODE);
                            }
                        } else {
                            str2 = "poiup";
                            str3 = "addrup";
                        }
                        if (jSONObject3.has("onlt")) {
                            JSONObject jSONObject5 = jSONObject3.getJSONObject("onlt");
                            if (jSONObject5.has(SessionDescription.SUPPORTED_SDP_VERSION)) {
                                C0691f.this.f934z = jSONObject5.getLong(SessionDescription.SUPPORTED_SDP_VERSION);
                            }
                            if (jSONObject5.has("1")) {
                                C0691f.this.f933y = jSONObject5.getLong("1");
                            }
                            if (jSONObject5.has(GeoFence.BUNDLE_KEY_CUSTOMID)) {
                                C0691f.this.f930v = jSONObject5.getLong(GeoFence.BUNDLE_KEY_CUSTOMID);
                            }
                            if (jSONObject5.has(GeoFence.BUNDLE_KEY_FENCESTATUS)) {
                                C0691f.this.f931w = jSONObject5.getLong(GeoFence.BUNDLE_KEY_FENCESTATUS);
                            }
                            if (jSONObject5.has(GeoFence.BUNDLE_KEY_LOCERRORCODE)) {
                                C0691f.this.f932x = jSONObject5.getLong(GeoFence.BUNDLE_KEY_LOCERRORCODE);
                            }
                        }
                        if (jSONObject3.has("minapn")) {
                            C0691f.this.f928t = jSONObject3.getInt("minapn");
                        }
                    } else {
                        str = "ver";
                        str2 = "poiup";
                        str3 = "addrup";
                    }
                    jSONObject2.put("ol", C0691f.this.f912d);
                    jSONObject2.put("olv2", C0691f.this.f919k);
                    jSONObject2.put("fl", C0691f.this.f913e);
                    jSONObject2.put("on", C0691f.this.f914f);
                    jSONObject2.put("wn", C0691f.this.f915g);
                    jSONObject2.put("oc", C0691f.this.f916h);
                    long currentTimeMillis = System.currentTimeMillis();
                    this.f938d = currentTimeMillis;
                    jSONObject2.put("t", currentTimeMillis);
                    jSONObject2.put(str, str4);
                    jSONObject2.put("rgcon", C0691f.this.f918j);
                    jSONObject2.put("rgcgp", C0691f.this.f920l);
                    JSONObject jSONObject6 = new JSONObject();
                    jSONObject6.put(SessionDescription.SUPPORTED_SDP_VERSION, C0691f.this.f923o);
                    jSONObject6.put("1", C0691f.this.f924p);
                    jSONObject6.put(GeoFence.BUNDLE_KEY_CUSTOMID, C0691f.this.f925q);
                    jSONObject6.put(GeoFence.BUNDLE_KEY_FENCESTATUS, C0691f.this.f926r);
                    jSONObject6.put(GeoFence.BUNDLE_KEY_LOCERRORCODE, C0691f.this.f927s);
                    jSONObject2.put("oflp", jSONObject6);
                    JSONObject jSONObject7 = new JSONObject();
                    jSONObject7.put(SessionDescription.SUPPORTED_SDP_VERSION, C0691f.this.f934z);
                    jSONObject7.put("1", C0691f.this.f933y);
                    jSONObject7.put(GeoFence.BUNDLE_KEY_CUSTOMID, C0691f.this.f930v);
                    jSONObject7.put(GeoFence.BUNDLE_KEY_FENCESTATUS, C0691f.this.f931w);
                    jSONObject7.put(GeoFence.BUNDLE_KEY_LOCERRORCODE, C0691f.this.f932x);
                    jSONObject2.put("onlt", jSONObject7);
                    jSONObject2.put(str3, C0691f.this.f922n);
                    jSONObject2.put(str2, C0691f.this.f921m);
                    jSONObject2.put("minapn", C0691f.this.f928t);
                    File file = new File(C0691f.this.f909a.m839c(), "ofl.config");
                    if (!file.exists()) {
                        file.createNewFile();
                    }
                    FileWriter fileWriter = new FileWriter(file);
                    fileWriter.write(jSONObject2.toString());
                    fileWriter.close();
                } catch (Exception unused) {
                    i2 = this.f936b;
                    i = 1;
                }
                this.f939e = false;
            }
            i = 1;
            i2 = this.f936b;
            this.f936b = i2 + i;
            this.f937c = System.currentTimeMillis();
            this.f939e = false;
        }

        @Override // com.baidu.location.p012h.AbstractC0725g
        /* renamed from: b */
        public void mo123b() {
            this.f1292k.clear();
            this.f1292k.put("qt", "conf");
            this.f1292k.put("req", this.f940f);
            this.f1289h = C0693h.f942a;
        }
    }

    C0691f(C0693h c0693h, SQLiteDatabase sQLiteDatabase) {
        this.f909a = c0693h;
        this.f910b = sQLiteDatabase;
        if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
            try {
                sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS BLACK (name VARCHAR(100) PRIMARY KEY);");
            } catch (Exception unused) {
            }
        }
        m812g();
    }

    /* renamed from: a */
    int m804a() {
        return this.f928t;
    }

    /* renamed from: a */
    long m805a(String str) {
        if (str.equals("2G")) {
            return this.f930v;
        }
        if (str.equals("3G")) {
            return this.f931w;
        }
        if (str.equals("4G")) {
            return this.f932x;
        }
        if (str.equals("WIFI")) {
            return this.f933y;
        }
        if (str.equals("unknown")) {
            return this.f934z;
        }
        return 5000L;
    }

    /* renamed from: a */
    void m806a(String[] strArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < strArr.length; i++) {
            if (i > 0) {
                stringBuffer.append(",");
            }
            stringBuffer.append("(\"");
            stringBuffer.append(strArr[i]);
            stringBuffer.append("\")");
        }
        SQLiteDatabase sQLiteDatabase = this.f910b;
        if (sQLiteDatabase == null || !sQLiteDatabase.isOpen() || stringBuffer.length() <= 0) {
            return;
        }
        try {
            this.f910b.execSQL(String.format(Locale.US, "INSERT OR IGNORE INTO BLACK VALUES %s;", stringBuffer.toString()));
        } catch (Exception unused) {
        }
    }

    /* renamed from: b */
    double m807b() {
        return this.f923o;
    }

    /* renamed from: c */
    double m808c() {
        return this.f924p;
    }

    /* renamed from: d */
    double m809d() {
        return this.f925q;
    }

    /* renamed from: e */
    double m810e() {
        return this.f926r;
    }

    /* renamed from: f */
    double m811f() {
        return this.f927s;
    }

    /* renamed from: g */
    void m812g() {
        a aVar = this.f911c;
        if (aVar != null) {
            aVar.m823a();
        }
    }

    /* renamed from: h */
    boolean m813h() {
        return this.f912d;
    }

    /* renamed from: i */
    boolean m814i() {
        return this.f914f;
    }

    /* renamed from: j */
    boolean m815j() {
        return this.f915g;
    }

    /* renamed from: k */
    boolean m816k() {
        return this.f913e;
    }

    /* renamed from: l */
    boolean m817l() {
        return this.f918j;
    }

    /* renamed from: m */
    boolean m818m() {
        return this.f929u;
    }

    /* renamed from: n */
    int m819n() {
        return this.f920l;
    }

    /* renamed from: o */
    String[] m820o() {
        return this.f917i;
    }

    /* renamed from: p */
    int m821p() {
        return this.f922n;
    }

    /* renamed from: q */
    int m822q() {
        return this.f921m;
    }
}