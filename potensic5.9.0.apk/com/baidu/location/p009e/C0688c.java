package com.baidu.location.p009e;

import android.database.sqlite.SQLiteDatabase;
import com.baidu.geofence.GeoFence;
import com.baidu.location.BDLocation;
import com.baidu.location.Jni;
import com.baidu.location.p012h.AbstractC0725g;
import com.baidu.location.p012h.C0720b;
import com.google.android.exoplayer2.audio.AacUtil;
import com.google.android.exoplayer2.source.rtsp.SessionDescription;
import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.apache.commons.beanutils.PropertyUtils;
import org.json.JSONObject;

/* renamed from: com.baidu.location.e.c */
/* loaded from: classes.dex */
final class C0688c {

    /* renamed from: a */
    private final C0693h f869a;

    /* renamed from: b */
    private int f870b;

    /* renamed from: c */
    private double f871c;

    /* renamed from: d */
    private double f872d;

    /* renamed from: e */
    private Long f873e;

    /* renamed from: h */
    private final SQLiteDatabase f876h;

    /* renamed from: i */
    private final SQLiteDatabase f877i;

    /* renamed from: p */
    private boolean f884p = false;

    /* renamed from: f */
    private final c f874f = new c(this, true);

    /* renamed from: g */
    private final c f875g = new c(this, false);

    /* renamed from: o */
    private StringBuffer f883o = new StringBuffer();

    /* renamed from: j */
    private StringBuffer f878j = null;

    /* renamed from: k */
    private StringBuffer f879k = null;

    /* renamed from: l */
    private HashSet<Long> f880l = new HashSet<>();

    /* renamed from: m */
    private ConcurrentMap<Long, Integer> f881m = new ConcurrentHashMap();

    /* renamed from: n */
    private ConcurrentMap<Long, String> f882n = new ConcurrentHashMap();

    /* renamed from: com.baidu.location.e.c$a */
    private static final class a {

        /* renamed from: a */
        double f885a;

        /* renamed from: b */
        double f886b;

        /* renamed from: c */
        double f887c;

        private a(double d, double d2, double d3) {
            this.f885a = d;
            this.f886b = d2;
            this.f887c = d3;
        }

        /* synthetic */ a(double d, double d2, double d3, C0689d c0689d) {
            this(d, d2, d3);
        }
    }

    /* renamed from: com.baidu.location.e.c$b */
    private class b extends Thread {

        /* renamed from: a */
        private String f888a;

        /* renamed from: c */
        private Long f890c;

        /* renamed from: d */
        private BDLocation f891d;

        /* renamed from: e */
        private BDLocation f892e;

        /* renamed from: f */
        private BDLocation f893f;

        /* renamed from: g */
        private String f894g;

        /* renamed from: h */
        private LinkedHashMap<String, Integer> f895h;

        private b(String str, Long l, BDLocation bDLocation, BDLocation bDLocation2, BDLocation bDLocation3, String str2, LinkedHashMap<String, Integer> linkedHashMap) {
            this.f888a = str;
            this.f890c = l;
            this.f891d = bDLocation;
            this.f892e = bDLocation2;
            this.f893f = bDLocation3;
            this.f894g = str2;
            this.f895h = linkedHashMap;
        }

        /* synthetic */ b(C0688c c0688c, String str, Long l, BDLocation bDLocation, BDLocation bDLocation2, BDLocation bDLocation3, String str2, LinkedHashMap linkedHashMap, C0689d c0689d) {
            this(str, l, bDLocation, bDLocation2, bDLocation3, str2, linkedHashMap);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                C0688c.this.m734a(this.f888a, this.f890c, this.f891d);
                C0688c.this.f878j = null;
                C0688c.this.f879k = null;
                C0688c.this.m736a(this.f895h);
                C0688c.this.m728a(this.f893f, this.f891d, this.f892e, this.f888a, this.f890c);
                if (this.f894g != null) {
                    C0688c.this.f869a.m846j().m863a(this.f894g);
                }
            } catch (Exception unused) {
            }
            this.f895h = null;
            this.f888a = null;
            this.f894g = null;
            this.f890c = null;
            this.f891d = null;
            this.f892e = null;
            this.f893f = null;
        }
    }

    /* renamed from: com.baidu.location.e.c$c */
    private final class c extends AbstractC0725g {

        /* renamed from: b */
        private String f897b;

        /* renamed from: c */
        private final String f898c;

        /* renamed from: d */
        private String f899d;

        /* renamed from: e */
        private C0688c f900e;

        /* renamed from: f */
        private boolean f901f = false;

        /* renamed from: r */
        private int f902r = 0;

        /* renamed from: s */
        private long f903s = -1;

        /* renamed from: t */
        private long f904t = -1;

        /* renamed from: u */
        private long f905u = -1;

        /* renamed from: v */
        private long f906v = -1;

        c(C0688c c0688c, boolean z) {
            this.f900e = c0688c;
            this.f898c = z ? "load" : "update";
            this.f1292k = new HashMap();
            this.f897b = C0693h.f942a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public void m748a(String str, String str2, String str3) {
            this.f899d = str3;
            this.f897b = String.format("http://%s/%s", str, str2);
            m1131a(false, "ofloc.map.baidu.com");
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: c */
        public void m751c() {
            this.f902r++;
            this.f903s = System.currentTimeMillis();
        }

        /* renamed from: d */
        private boolean m752d() {
            if (this.f902r < 2) {
                return true;
            }
            if (this.f903s + 43200000 >= System.currentTimeMillis()) {
                return false;
            }
            this.f902r = 0;
            this.f903s = -1L;
            return true;
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x005a  */
        /* JADX WARN: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:9:0x002c  */
        /* renamed from: e */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private void m753e() {
            /*
                r9 = this;
                r0 = 0
                r9.f899d = r0
                boolean r0 = r9.m758j()
                r1 = 86400000(0x5265c00, double:4.2687272E-316)
                r3 = -1
                if (r0 == 0) goto L22
                long r5 = r9.f904t
                int r0 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
                if (r0 == 0) goto L1d
                long r5 = r5 + r1
                long r7 = java.lang.System.currentTimeMillis()
                int r0 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
                if (r0 > 0) goto L28
            L1d:
                java.lang.String r0 = r9.m754f()
                goto L26
            L22:
                java.lang.String r0 = r9.m755g()
            L26:
                r9.f899d = r0
            L28:
                java.lang.String r0 = r9.f899d
                if (r0 != 0) goto L56
                long r5 = r9.f905u
                int r0 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
                if (r0 == 0) goto L3b
                long r5 = r5 + r1
                long r0 = java.lang.System.currentTimeMillis()
                int r0 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
                if (r0 > 0) goto L56
            L3b:
                com.baidu.location.e.c r0 = com.baidu.location.p009e.C0688c.this
                com.baidu.location.e.h r0 = com.baidu.location.p009e.C0688c.m726a(r0)
                com.baidu.location.e.l r0 = r0.m847k()
                boolean r0 = r0.m876a()
                if (r0 == 0) goto L50
                java.lang.String r0 = r9.m756h()
                goto L54
            L50:
                java.lang.String r0 = r9.m757i()
            L54:
                r9.f899d = r0
            L56:
                java.lang.String r0 = r9.f899d
                if (r0 == 0) goto L6d
                com.baidu.location.b.x r0 = com.baidu.location.p006b.C0670x.m590a()
                java.util.concurrent.ExecutorService r0 = r0.m592c()
                java.lang.String r1 = "https://ofloc.map.baidu.com/offline_loc"
                if (r0 == 0) goto L6a
                r9.m1129a(r0, r1)
                goto L6d
            L6a:
                r9.m1133e(r1)
            L6d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.p009e.C0688c.c.m753e():void");
        }

        /* renamed from: f */
        private String m754f() {
            JSONObject jSONObject;
            try {
                jSONObject = new JSONObject();
                jSONObject.put("type", SessionDescription.SUPPORTED_SDP_VERSION);
                jSONObject.put("cuid", C0720b.m1100a().f1254c);
                jSONObject.put("ver", "1");
                jSONObject.put("prod", C0720b.f1245f + ":" + C0720b.f1244e);
            } catch (Exception unused) {
                jSONObject = null;
            }
            if (jSONObject != null) {
                return Jni.encodeOfflineLocationUpdateRequest(jSONObject.toString());
            }
            return null;
        }

        /* JADX WARN: Can't wrap try/catch for region: R(7:4|5|(8:(3:86|87|(13:89|(2:92|90)|93|94|8|9|10|11|12|(3:68|69|(4:71|(2:74|72)|75|76))|14|(1:44)|(2:40|41)))|11|12|(0)|14|(0)|44|(0))|7|8|9|10) */
        /* JADX WARN: Code restructure failed: missing block: B:18:0x00f7, code lost:
        
            if (r7 != null) goto L91;
         */
        /* JADX WARN: Code restructure failed: missing block: B:37:0x00f9, code lost:
        
            r7.close();
         */
        /* JADX WARN: Code restructure failed: missing block: B:48:0x0124, code lost:
        
            if (r7 == null) goto L60;
         */
        /* JADX WARN: Code restructure failed: missing block: B:83:0x0106, code lost:
        
            r8 = null;
         */
        /* JADX WARN: Code restructure failed: missing block: B:84:0x0102, code lost:
        
            r0 = th;
         */
        /* JADX WARN: Code restructure failed: missing block: B:85:0x0103, code lost:
        
            r8 = null;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:40:0x00f4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:49:0x0121 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:57:0x0117 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:63:? A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:64:0x0112 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:68:0x008f A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* renamed from: g */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private java.lang.String m755g() {
            /*
                Method dump skipped, instructions count: 356
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.p009e.C0688c.c.m755g():java.lang.String");
        }

        /* renamed from: h */
        private String m756h() {
            JSONObject jSONObject;
            try {
                jSONObject = new JSONObject();
                try {
                    jSONObject.put("type", GeoFence.BUNDLE_KEY_CUSTOMID);
                    jSONObject.put("ver", "1");
                    jSONObject.put("cuid", C0720b.m1100a().f1254c);
                    jSONObject.put("prod", C0720b.f1245f + ":" + C0720b.f1244e);
                    this.f905u = System.currentTimeMillis();
                } catch (Exception unused) {
                }
            } catch (Exception unused2) {
                jSONObject = null;
            }
            if (jSONObject != null) {
                return Jni.encodeOfflineLocationUpdateRequest(jSONObject.toString());
            }
            return null;
        }

        /* JADX WARN: Removed duplicated region for block: B:12:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:9:0x0060  */
        /* renamed from: i */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private java.lang.String m757i() {
            /*
                r6 = this;
                r0 = 0
                com.baidu.location.e.c r1 = com.baidu.location.p009e.C0688c.this     // Catch: java.lang.Exception -> L5d
                com.baidu.location.e.h r1 = com.baidu.location.p009e.C0688c.m726a(r1)     // Catch: java.lang.Exception -> L5d
                com.baidu.location.e.l r1 = r1.m847k()     // Catch: java.lang.Exception -> L5d
                org.json.JSONObject r1 = r1.m878b()     // Catch: java.lang.Exception -> L5d
                if (r1 == 0) goto L5d
                org.json.JSONObject r2 = new org.json.JSONObject     // Catch: java.lang.Exception -> L5d
                r2.<init>()     // Catch: java.lang.Exception -> L5d
                java.lang.String r3 = "type"
                java.lang.String r4 = "3"
                r2.put(r3, r4)     // Catch: java.lang.Exception -> L5e
                java.lang.String r3 = "ver"
                java.lang.String r4 = "1"
                r2.put(r3, r4)     // Catch: java.lang.Exception -> L5e
                java.lang.String r3 = "cuid"
                com.baidu.location.h.b r4 = com.baidu.location.p012h.C0720b.m1100a()     // Catch: java.lang.Exception -> L5e
                java.lang.String r4 = r4.f1254c     // Catch: java.lang.Exception -> L5e
                r2.put(r3, r4)     // Catch: java.lang.Exception -> L5e
                java.lang.String r3 = "prod"
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L5e
                r4.<init>()     // Catch: java.lang.Exception -> L5e
                java.lang.String r5 = com.baidu.location.p012h.C0720b.f1245f     // Catch: java.lang.Exception -> L5e
                java.lang.StringBuilder r4 = r4.append(r5)     // Catch: java.lang.Exception -> L5e
                java.lang.String r5 = ":"
                java.lang.StringBuilder r4 = r4.append(r5)     // Catch: java.lang.Exception -> L5e
                java.lang.String r5 = com.baidu.location.p012h.C0720b.f1244e     // Catch: java.lang.Exception -> L5e
                java.lang.StringBuilder r4 = r4.append(r5)     // Catch: java.lang.Exception -> L5e
                java.lang.String r4 = r4.toString()     // Catch: java.lang.Exception -> L5e
                r2.put(r3, r4)     // Catch: java.lang.Exception -> L5e
                java.lang.String r3 = "rgc"
                r2.put(r3, r1)     // Catch: java.lang.Exception -> L5e
                long r3 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Exception -> L5e
                r6.f905u = r3     // Catch: java.lang.Exception -> L5e
                goto L5e
            L5d:
                r2 = r0
            L5e:
                if (r2 == 0) goto L68
                java.lang.String r0 = r2.toString()
                java.lang.String r0 = com.baidu.location.Jni.encodeOfflineLocationUpdateRequest(r0)
            L68:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.p009e.C0688c.c.m757i():java.lang.String");
        }

        /* JADX WARN: Code restructure failed: missing block: B:15:0x0035, code lost:
        
            if (r0.getInt(0) != 0) goto L15;
         */
        /* renamed from: j */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private boolean m758j() {
            /*
                r6 = this;
                r0 = 0
                r1 = 1
                com.baidu.location.e.c r2 = com.baidu.location.p009e.C0688c.this     // Catch: java.lang.Throwable -> L4d java.lang.Exception -> L5b
                android.database.sqlite.SQLiteDatabase r2 = com.baidu.location.p009e.C0688c.m738b(r2)     // Catch: java.lang.Throwable -> L4d java.lang.Exception -> L5b
                java.lang.String r3 = "SELECT COUNT(*) FROM AP;"
                android.database.Cursor r2 = r2.rawQuery(r3, r0)     // Catch: java.lang.Throwable -> L4d java.lang.Exception -> L5b
                com.baidu.location.e.c r3 = com.baidu.location.p009e.C0688c.this     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L49
                android.database.sqlite.SQLiteDatabase r3 = com.baidu.location.p009e.C0688c.m738b(r3)     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L49
                java.lang.String r4 = "SELECT COUNT(*) FROM CL"
                android.database.Cursor r0 = r3.rawQuery(r4, r0)     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L49
                r3 = 0
                if (r2 == 0) goto L38
                boolean r4 = r2.moveToFirst()     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L49
                if (r4 == 0) goto L38
                if (r0 == 0) goto L38
                boolean r4 = r0.moveToFirst()     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L49
                if (r4 == 0) goto L38
                int r4 = r2.getInt(r3)     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L49
                if (r4 != 0) goto L37
                int r4 = r0.getInt(r3)     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L49
                if (r4 == 0) goto L38
            L37:
                r1 = r3
            L38:
                if (r2 == 0) goto L3d
                r2.close()     // Catch: java.lang.Exception -> L3d
            L3d:
                if (r0 == 0) goto L66
                r0.close()     // Catch: java.lang.Exception -> L66
                goto L66
            L43:
                r1 = move-exception
                r5 = r1
                r1 = r0
                r0 = r2
                r2 = r5
                goto L50
            L49:
                r5 = r2
                r2 = r0
                r0 = r5
                goto L5c
            L4d:
                r1 = move-exception
                r2 = r1
                r1 = r0
            L50:
                if (r0 == 0) goto L55
                r0.close()     // Catch: java.lang.Exception -> L55
            L55:
                if (r1 == 0) goto L5a
                r1.close()     // Catch: java.lang.Exception -> L5a
            L5a:
                throw r2
            L5b:
                r2 = r0
            L5c:
                if (r0 == 0) goto L61
                r0.close()     // Catch: java.lang.Exception -> L61
            L61:
                if (r2 == 0) goto L66
                r2.close()     // Catch: java.lang.Exception -> L66
            L66:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.p009e.C0688c.c.m758j():boolean");
        }

        /* renamed from: a */
        void m759a() {
            if (!m752d() || this.f901f) {
                return;
            }
            C0688c.this.f875g.m753e();
        }

        @Override // com.baidu.location.p012h.AbstractC0725g
        /* renamed from: a */
        public void mo122a(boolean z) {
            if (z && this.f1291j != null) {
                new C0690e(this).start();
            } else {
                this.f901f = false;
                m751c();
            }
        }

        @Override // com.baidu.location.p012h.AbstractC0725g
        /* renamed from: b */
        public void mo123b() {
            this.f901f = true;
            this.f1289h = this.f897b;
            this.f1292k.clear();
            this.f1292k.put("qt", this.f898c);
            this.f1292k.put("req", this.f899d);
        }
    }

    C0688c(C0693h c0693h) {
        SQLiteDatabase sQLiteDatabase;
        this.f869a = c0693h;
        SQLiteDatabase sQLiteDatabase2 = null;
        try {
            File file = new File(c0693h.m839c(), "ofl_location.db");
            if (!file.exists()) {
                file.createNewFile();
            }
            sQLiteDatabase = SQLiteDatabase.openOrCreateDatabase(file, (SQLiteDatabase.CursorFactory) null);
        } catch (Exception unused) {
            sQLiteDatabase = null;
        }
        this.f876h = sQLiteDatabase;
        if (sQLiteDatabase != null) {
            try {
                sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS AP (id LONG PRIMARY KEY,x DOUBLE,y DOUBLE,r INTEGER,cl DOUBLE,timestamp INTEGER, frequency INTEGER DEFAULT 0);");
                sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS CL (id LONG PRIMARY KEY,x DOUBLE,y DOUBLE,r INTEGER,cl DOUBLE,timestamp INTEGER, frequency INTEGER DEFAULT 0);");
            } catch (Exception unused2) {
            }
        }
        try {
            File file2 = new File(this.f869a.m839c(), "ofl_statistics.db");
            if (!file2.exists()) {
                file2.createNewFile();
            }
            sQLiteDatabase2 = SQLiteDatabase.openOrCreateDatabase(file2, (SQLiteDatabase.CursorFactory) null);
        } catch (Exception unused3) {
        }
        this.f877i = sQLiteDatabase2;
        if (sQLiteDatabase2 != null) {
            try {
                sQLiteDatabase2.execSQL("CREATE TABLE IF NOT EXISTS AP (id LONG PRIMARY KEY, originid VARCHAR(15), frequency INTEGER DEFAULT 0);");
                sQLiteDatabase2.execSQL("CREATE TABLE IF NOT EXISTS CL (id LONG PRIMARY KEY, originid VARCHAR(40), frequency INTEGER DEFAULT 0);");
            } catch (Exception unused4) {
            }
        }
    }

    /* renamed from: a */
    private double m722a(double d, double d2, double d3, double d4) {
        double d5 = d4 - d2;
        double d6 = d3 - d;
        double radians = Math.toRadians(d);
        Math.toRadians(d2);
        double radians2 = Math.toRadians(d3);
        Math.toRadians(d4);
        double radians3 = Math.toRadians(d5);
        double radians4 = Math.toRadians(d6) / 2.0d;
        double d7 = radians3 / 2.0d;
        double sin = (Math.sin(radians4) * Math.sin(radians4)) + (Math.cos(radians) * Math.cos(radians2) * Math.sin(d7) * Math.sin(d7));
        return Math.atan2(Math.sqrt(sin), Math.sqrt(1.0d - sin)) * 2.0d * 6378137.0d;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0092 A[LOOP:0: B:6:0x000b->B:32:0x0092, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0091 A[SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int m723a(java.util.ArrayList<com.baidu.location.p009e.C0688c.a> r22, double r23) {
        /*
            r21 = this;
            r0 = r22
            int r1 = r22.size()
            r2 = 0
            if (r1 != 0) goto La
            return r2
        La:
            r1 = r2
        Lb:
            int r3 = r22.size()
            r4 = 3
            if (r3 < r4) goto L8d
            r3 = 0
            r8 = r2
            r6 = r3
        L16:
            int r9 = r22.size()
            if (r8 >= r9) goto L31
            java.lang.Object r9 = r0.get(r8)
            com.baidu.location.e.c$a r9 = (com.baidu.location.p009e.C0688c.a) r9
            double r9 = r9.f885a
            double r3 = r3 + r9
            java.lang.Object r9 = r0.get(r8)
            com.baidu.location.e.c$a r9 = (com.baidu.location.p009e.C0688c.a) r9
            double r9 = r9.f886b
            double r6 = r6 + r9
            int r8 = r8 + 1
            goto L16
        L31:
            int r8 = r22.size()
            double r8 = (double) r8
            double r3 = r3 / r8
            int r8 = r22.size()
            double r8 = (double) r8
            double r6 = r6 / r8
            r8 = -4616189618054758400(0xbff0000000000000, double:-1.0)
            r10 = -1
            r13 = r2
            r15 = r10
        L42:
            int r10 = r22.size()
            if (r13 >= r10) goto L79
            java.lang.Object r10 = r0.get(r13)
            com.baidu.location.e.c$a r10 = (com.baidu.location.p009e.C0688c.a) r10
            double r11 = r10.f886b
            java.lang.Object r10 = r0.get(r13)
            com.baidu.location.e.c$a r10 = (com.baidu.location.p009e.C0688c.a) r10
            r19 = r3
            double r2 = r10.f885a
            r10 = r21
            r16 = r11
            r11 = r6
            r4 = r13
            r13 = r19
            r5 = r15
            r15 = r16
            r17 = r2
            double r2 = r10.m722a(r11, r13, r15, r17)
            int r10 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1))
            if (r10 <= 0) goto L72
            r8 = r2
            r15 = r4
            goto L73
        L72:
            r15 = r5
        L73:
            int r13 = r4 + 1
            r3 = r19
            r2 = 0
            goto L42
        L79:
            r5 = r15
            int r2 = (r8 > r23 ? 1 : (r8 == r23 ? 0 : -1))
            if (r2 <= 0) goto L8d
            if (r5 < 0) goto L8d
            int r2 = r22.size()
            if (r5 >= r2) goto L8d
            int r1 = r1 + 1
            r0.remove(r5)
            r2 = 1
            goto L8e
        L8d:
            r2 = 0
        L8e:
            r3 = 1
            if (r2 == r3) goto L92
            return r1
        L92:
            r2 = 0
            goto Lb
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.p009e.C0688c.m723a(java.util.ArrayList, double):int");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00ba A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00cd A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x00d4  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.baidu.location.BDLocation m724a(java.lang.Long r20) {
        /*
            Method dump skipped, instructions count: 236
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.p009e.C0688c.m724a(java.lang.Long):com.baidu.location.BDLocation");
    }

    /* JADX WARN: Code restructure failed: missing block: B:169:0x02f9, code lost:
    
        if (m722a(r14, r16, r18, r12) <= 10000.0d) goto L128;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:30:0x034d  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0368  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x032b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0346 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0336 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.baidu.location.BDLocation m725a(java.util.LinkedHashMap<java.lang.String, java.lang.Integer> r41, com.baidu.location.BDLocation r42, int r43) {
        /*
            Method dump skipped, instructions count: 875
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.p009e.C0688c.m725a(java.util.LinkedHashMap, com.baidu.location.BDLocation, int):com.baidu.location.BDLocation");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m728a(BDLocation bDLocation, BDLocation bDLocation2, BDLocation bDLocation3, String str, Long l) {
        if (bDLocation == null || bDLocation.getLocType() != 161) {
            return;
        }
        if (bDLocation2 != null && bDLocation.getNetworkLocationType() != null && bDLocation.getNetworkLocationType().equals("cl") && m722a(bDLocation2.getLatitude(), bDLocation2.getLongitude(), bDLocation.getLatitude(), bDLocation.getLongitude()) > 300.0d) {
            String format = String.format(Locale.US, "UPDATE CL SET cl = 0 WHERE id = %d;", l);
            String format2 = String.format(Locale.US, "INSERT OR REPLACE INTO CL VALUES (%d,\"%s\",%d);", l, str, Integer.valueOf(AacUtil.AAC_LC_MAX_RATE_BYTES_PER_SECOND));
            try {
                this.f876h.execSQL(format);
                this.f877i.execSQL(format2);
            } catch (Exception unused) {
            }
        }
        if (bDLocation3 == null || bDLocation.getNetworkLocationType() == null || !bDLocation.getNetworkLocationType().equals("wf") || m722a(bDLocation3.getLatitude(), bDLocation3.getLongitude(), bDLocation.getLatitude(), bDLocation.getLongitude()) <= 100.0d) {
            return;
        }
        try {
            String format3 = String.format("UPDATE AP SET cl = 0 WHERE id In (%s);", this.f878j.toString());
            String format4 = String.format("INSERT OR REPLACE INTO AP VALUES %s;", this.f879k.toString());
            this.f876h.execSQL(format3);
            this.f877i.execSQL(format4);
        } catch (Exception unused2) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m734a(String str, Long l, BDLocation bDLocation) {
        if (str != null) {
            try {
                if (bDLocation != null) {
                    this.f876h.execSQL(String.format(Locale.US, "UPDATE CL SET frequency=frequency+1 WHERE id = %d;", l));
                } else {
                    String format = String.format(Locale.US, "INSERT OR IGNORE INTO CL VALUES (%d,\"%s\",0);", l, str);
                    String format2 = String.format(Locale.US, "UPDATE CL SET frequency=frequency+1 WHERE id = %d;", l);
                    this.f877i.execSQL(format);
                    this.f877i.execSQL(format2);
                }
            } catch (Exception unused) {
            }
            if (this.f884p) {
                try {
                    this.f877i.execSQL(String.format(Locale.US, "INSERT OR IGNORE INTO CL VALUES (%d,\"%s\",%d);", l, str, Integer.valueOf(AacUtil.AAC_LC_MAX_RATE_BYTES_PER_SECOND)));
                } catch (Exception unused2) {
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m735a(String str, String str2, String str3) {
        this.f874f.m748a(str, str2, str3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m736a(LinkedHashMap<String, Integer> linkedHashMap) {
        if (linkedHashMap == null || linkedHashMap.size() <= 0) {
            return;
        }
        this.f878j = new StringBuffer();
        this.f879k = new StringBuffer();
        StringBuffer stringBuffer = new StringBuffer();
        StringBuffer stringBuffer2 = new StringBuffer();
        ConcurrentMap<Long, Integer> concurrentMap = this.f881m;
        if (concurrentMap != null && concurrentMap.keySet() != null) {
            boolean z = true;
            boolean z2 = true;
            for (Long l : this.f881m.keySet()) {
                try {
                    if (this.f880l.contains(l)) {
                        if (z) {
                            z = false;
                        } else {
                            this.f878j.append(',');
                            this.f879k.append(',');
                        }
                        this.f878j.append(l);
                        this.f879k.append(PropertyUtils.MAPPED_DELIM).append(l).append(',').append('\"').append(this.f882n.get(l)).append('\"').append(',').append(AacUtil.AAC_LC_MAX_RATE_BYTES_PER_SECOND).append(PropertyUtils.MAPPED_DELIM2);
                    } else {
                        String str = this.f882n.get(l);
                        if (z2) {
                            z2 = false;
                        } else {
                            stringBuffer.append(',');
                            stringBuffer2.append(',');
                        }
                        stringBuffer.append(l);
                        stringBuffer2.append(PropertyUtils.MAPPED_DELIM).append(l).append(',').append('\"').append(str).append('\"').append(",0)");
                    }
                } catch (Exception unused) {
                }
            }
        }
        try {
            this.f876h.execSQL(String.format(Locale.US, "UPDATE AP SET frequency=frequency+1 WHERE id IN(%s)", this.f878j.toString()));
        } catch (Exception unused2) {
        }
        StringBuffer stringBuffer3 = this.f883o;
        if (stringBuffer3 != null && stringBuffer3.length() > 0) {
            if (stringBuffer2.length() > 0) {
                stringBuffer2.append(",");
            }
            stringBuffer2.append(this.f883o);
        }
        try {
            String format = String.format("INSERT OR IGNORE INTO AP VALUES %s;", stringBuffer2.toString());
            String format2 = String.format("UPDATE AP SET frequency=frequency+1 WHERE id in (%s);", stringBuffer.toString());
            if (stringBuffer2.length() > 0) {
                this.f877i.execSQL(format);
            }
            if (stringBuffer.length() > 0) {
                this.f877i.execSQL(format2);
            }
        } catch (Exception unused3) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m737a(String[] strArr) {
        this.f869a.m848l().m806a(strArr);
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0100, code lost:
    
        if (r7 != null) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x010b, code lost:
    
        r5 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x0109, code lost:
    
        if (r7 != null) goto L55;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    android.database.Cursor m742a(com.baidu.location.p009e.C0695j.a r22) {
        /*
            Method dump skipped, instructions count: 513
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.p009e.C0688c.m742a(com.baidu.location.e.j$a):android.database.Cursor");
    }

    /* renamed from: a */
    SQLiteDatabase m743a() {
        return this.f877i;
    }

    /* renamed from: b */
    void m744b() {
        this.f875g.m759a();
    }
}