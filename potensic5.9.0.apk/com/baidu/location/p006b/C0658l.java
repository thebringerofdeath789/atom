package com.baidu.location.p006b;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import com.baidu.location.Jni;
import com.baidu.location.p012h.AbstractC0725g;
import com.baidu.location.p012h.C0722d;
import com.baidu.location.p012h.C0733o;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.io.File;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import org.json.JSONObject;

/* renamed from: com.baidu.location.b.l */
/* loaded from: classes.dex */
public class C0658l {

    /* renamed from: d */
    private static C0658l f564d;

    /* renamed from: c */
    private static Object f563c = new Object();

    /* renamed from: e */
    private static final String f565e = C0733o.m1166g() + "/hst.db";

    /* renamed from: f */
    private SQLiteDatabase f568f = null;

    /* renamed from: g */
    private boolean f569g = false;

    /* renamed from: a */
    a f566a = null;

    /* renamed from: b */
    a f567b = null;

    /* renamed from: h */
    private String f570h = null;

    /* renamed from: i */
    private int f571i = -2;

    /* renamed from: com.baidu.location.b.l$a */
    class a extends AbstractC0725g {

        /* renamed from: b */
        private String f573b = null;

        /* renamed from: c */
        private String f574c = null;

        /* renamed from: d */
        private boolean f575d = true;

        /* renamed from: e */
        private boolean f576e = false;

        a() {
            this.f1292k = new HashMap();
        }

        /* renamed from: a */
        public void m459a(String str, String str2) {
            if (C0658l.this.f569g) {
                return;
            }
            C0658l.this.f569g = true;
            this.f573b = str;
            this.f574c = str2;
            ExecutorService m592c = C0670x.m590a().m592c();
            if (m592c != null) {
                m1129a(m592c, C0722d.f1260c);
            } else {
                m1133e(C0722d.f1260c);
            }
        }

        @Override // com.baidu.location.p012h.AbstractC0725g
        /* renamed from: a */
        public void mo122a(boolean z) {
            if (z && this.f1291j != null) {
                try {
                    String str = this.f1291j;
                    if (this.f575d) {
                        JSONObject jSONObject = new JSONObject(str);
                        JSONObject jSONObject2 = jSONObject.has("content") ? jSONObject.getJSONObject("content") : null;
                        if (jSONObject2 != null && jSONObject2.has("imo")) {
                            Long valueOf = Long.valueOf(jSONObject2.getJSONObject("imo").getString("mac"));
                            int i = jSONObject2.getJSONObject("imo").getInt("mv");
                            if (Jni.encode3(this.f573b).longValue() == valueOf.longValue()) {
                                ContentValues contentValues = new ContentValues();
                                contentValues.put(TtmlNode.TAG_TT, Integer.valueOf((int) (System.currentTimeMillis() / 1000)));
                                contentValues.put("hst", Integer.valueOf(i));
                                try {
                                    if (C0658l.this.f568f.update("hstdata", contentValues, "id = \"" + valueOf + "\"", null) <= 0) {
                                        contentValues.put(TtmlNode.ATTR_ID, valueOf);
                                        C0658l.this.f568f.insert("hstdata", null, contentValues);
                                    }
                                } catch (Exception unused) {
                                }
                                Bundle bundle = new Bundle();
                                bundle.putByteArray("mac", this.f573b.getBytes());
                                bundle.putInt("hotspot", i);
                                C0658l.this.m448a(bundle);
                            }
                        }
                    }
                } catch (Exception unused2) {
                }
            } else if (this.f575d) {
                C0658l.this.m453f();
            }
            if (this.f1292k != null) {
                this.f1292k.clear();
            }
            C0658l.this.f569g = false;
        }

        @Override // com.baidu.location.p012h.AbstractC0725g
        /* renamed from: b */
        public void mo123b() {
            this.f1290i = 1;
            String encodeTp4 = Jni.encodeTp4(this.f574c);
            this.f574c = null;
            this.f1292k.put("bloc", encodeTp4);
        }
    }

    /* renamed from: a */
    public static C0658l m446a() {
        C0658l c0658l;
        synchronized (f563c) {
            if (f564d == null) {
                f564d = new C0658l();
            }
            c0658l = f564d;
        }
        return c0658l;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0094  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String m447a(boolean r5) {
        /*
            r4 = this;
            com.baidu.location.f.b r0 = com.baidu.location.p010f.C0704b.m912a()
            com.baidu.location.f.a r0 = r0.m940f()
            com.baidu.location.f.m r1 = com.baidu.location.p010f.C0715m.m1058a()
            com.baidu.location.f.l r1 = r1.m1083q()
            java.lang.StringBuffer r2 = new java.lang.StringBuffer
            r3 = 1024(0x400, float:1.435E-42)
            r2.<init>(r3)
            if (r0 == 0) goto L26
            boolean r3 = r0.m896b()
            if (r3 == 0) goto L26
            java.lang.String r0 = r0.m903i()
            r2.append(r0)
        L26:
            if (r1 == 0) goto L36
            int r0 = r1.m1037a()
            r3 = 1
            if (r0 <= r3) goto L36
            r0 = 15
            java.lang.String r0 = r1.m1038a(r0)
            goto L48
        L36:
            com.baidu.location.f.m r0 = com.baidu.location.p010f.C0715m.m1058a()
            java.lang.String r0 = r0.m1080n()
            if (r0 == 0) goto L4b
            com.baidu.location.f.m r0 = com.baidu.location.p010f.C0715m.m1058a()
            java.lang.String r0 = r0.m1080n()
        L48:
            r2.append(r0)
        L4b:
            if (r5 == 0) goto L52
            java.lang.String r5 = "&imo=1"
            r2.append(r5)
        L52:
            com.baidu.location.f.g r5 = com.baidu.location.p010f.C0709g.m959a()
            java.lang.String r5 = r5.m1032m()
            r2.append(r5)
            com.baidu.location.h.b r5 = com.baidu.location.p012h.C0720b.m1100a()
            r0 = 0
            java.lang.String r5 = r5.m1101a(r0)
            r2.append(r5)
            com.baidu.location.b.b r5 = com.baidu.location.p006b.C0648b.m321a()
            java.lang.String r5 = r5.m339d()
            r2.append(r5)
            com.baidu.location.b.c r5 = com.baidu.location.p006b.C0649c.m358a()
            java.lang.String r5 = r5.m369c()
            r2.append(r5)
            android.content.Context r5 = com.baidu.location.ServiceC0702f.getServiceContext()
            java.lang.String r5 = com.baidu.location.p012h.C0733o.m1163e(r5)
            r2.append(r5)
            android.content.Context r5 = com.baidu.location.ServiceC0702f.getServiceContext()
            int r5 = com.baidu.location.p012h.C0733o.m1156c(r5)
            if (r5 < 0) goto L9d
            java.lang.String r0 = "&lmd="
            java.lang.StringBuffer r0 = r2.append(r0)
            r0.append(r5)
        L9d:
            java.lang.String r5 = r2.toString()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.p006b.C0658l.m447a(boolean):java.lang.String");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m448a(Bundle bundle) {
        C0648b.m321a().m328a(bundle, 406);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public void m453f() {
        Bundle bundle = new Bundle();
        bundle.putInt("hotspot", -1);
        m448a(bundle);
    }

    /* renamed from: a */
    public void m454a(String str) {
        if (this.f569g) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject jSONObject2 = jSONObject.has("content") ? jSONObject.getJSONObject("content") : null;
            if (jSONObject2 == null || !jSONObject2.has("imo")) {
                return;
            }
            Long valueOf = Long.valueOf(jSONObject2.getJSONObject("imo").getString("mac"));
            int i = jSONObject2.getJSONObject("imo").getInt("mv");
            ContentValues contentValues = new ContentValues();
            contentValues.put(TtmlNode.TAG_TT, Integer.valueOf((int) (System.currentTimeMillis() / 1000)));
            contentValues.put("hst", Integer.valueOf(i));
            if (this.f568f.update("hstdata", contentValues, "id = \"" + valueOf + "\"", null) <= 0) {
                contentValues.put(TtmlNode.ATTR_ID, valueOf);
                this.f568f.insert("hstdata", null, contentValues);
            }
        } catch (Exception unused) {
        }
    }

    /* renamed from: b */
    public void m455b() {
        try {
            File file = new File(f565e);
            if (!file.exists()) {
                file.createNewFile();
            }
            if (file.exists()) {
                SQLiteDatabase openOrCreateDatabase = SQLiteDatabase.openOrCreateDatabase(file, (SQLiteDatabase.CursorFactory) null);
                this.f568f = openOrCreateDatabase;
                openOrCreateDatabase.execSQL("CREATE TABLE IF NOT EXISTS hstdata(id Long PRIMARY KEY,hst INT,tt INT);");
                this.f568f.setVersion(1);
            }
        } catch (Exception unused) {
            this.f568f = null;
        }
    }

    /* renamed from: c */
    public void m456c() {
        SQLiteDatabase sQLiteDatabase = this.f568f;
        if (sQLiteDatabase != null) {
            try {
                sQLiteDatabase.close();
            } catch (Exception unused) {
            } catch (Throwable th) {
                this.f568f = null;
                throw th;
            }
            this.f568f = null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x006c, code lost:
    
        if (r3 != null) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x006e, code lost:
    
        r3.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0079, code lost:
    
        if (r3 != null) goto L32;
     */
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized int m457d() {
        /*
            r10 = this;
            monitor-enter(r10)
            r0 = -3
            boolean r1 = r10.f569g     // Catch: java.lang.Throwable -> L80
            if (r1 == 0) goto L8
            monitor-exit(r10)
            return r0
        L8:
            com.baidu.location.f.m r1 = com.baidu.location.p010f.C0715m.m1058a()     // Catch: java.lang.Exception -> L7c java.lang.Throwable -> L80
            boolean r1 = r1.m1077k()     // Catch: java.lang.Exception -> L7c java.lang.Throwable -> L80
            if (r1 == 0) goto L7c
            android.database.sqlite.SQLiteDatabase r1 = r10.f568f     // Catch: java.lang.Exception -> L7c java.lang.Throwable -> L80
            if (r1 == 0) goto L7c
            com.baidu.location.f.m r1 = com.baidu.location.p010f.C0715m.m1058a()     // Catch: java.lang.Exception -> L7c java.lang.Throwable -> L80
            android.net.wifi.WifiInfo r1 = r1.m1079m()     // Catch: java.lang.Exception -> L7c java.lang.Throwable -> L80
            if (r1 == 0) goto L7c
            java.lang.String r2 = r1.getBSSID()     // Catch: java.lang.Exception -> L7c java.lang.Throwable -> L80
            if (r2 == 0) goto L7c
            java.lang.String r1 = r1.getBSSID()     // Catch: java.lang.Exception -> L7c java.lang.Throwable -> L80
            java.lang.String r2 = ":"
            java.lang.String r3 = ""
            java.lang.String r1 = r1.replace(r2, r3)     // Catch: java.lang.Exception -> L7c java.lang.Throwable -> L80
            java.lang.Long r2 = com.baidu.location.Jni.encode3(r1)     // Catch: java.lang.Exception -> L7c java.lang.Throwable -> L80
            java.lang.String r3 = r10.f570h     // Catch: java.lang.Exception -> L7c java.lang.Throwable -> L80
            r4 = -2
            if (r3 == 0) goto L47
            boolean r3 = r1.equals(r3)     // Catch: java.lang.Exception -> L7c java.lang.Throwable -> L80
            if (r3 == 0) goto L47
            int r3 = r10.f571i     // Catch: java.lang.Exception -> L7c java.lang.Throwable -> L80
            if (r3 <= r4) goto L47
            r0 = r3
            goto L7c
        L47:
            r3 = 0
            android.database.sqlite.SQLiteDatabase r5 = r10.f568f     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L79
            java.lang.String r6 = "select * from hstdata where id = ?"
            r7 = 1
            java.lang.String[] r8 = new java.lang.String[r7]     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L79
            r9 = 0
            java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L79
            r8[r9] = r2     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L79
            android.database.Cursor r3 = r5.rawQuery(r6, r8)     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L79
            if (r3 == 0) goto L6b
            boolean r2 = r3.moveToFirst()     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L79
            if (r2 == 0) goto L6b
            int r0 = r3.getInt(r7)     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L79
            r10.f570h = r1     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L79
            r10.f571i = r0     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L79
            goto L6c
        L6b:
            r0 = r4
        L6c:
            if (r3 == 0) goto L7c
        L6e:
            r3.close()     // Catch: java.lang.Exception -> L7c java.lang.Throwable -> L80
            goto L7c
        L72:
            r1 = move-exception
            if (r3 == 0) goto L78
            r3.close()     // Catch: java.lang.Exception -> L78 java.lang.Throwable -> L80
        L78:
            throw r1     // Catch: java.lang.Exception -> L7c java.lang.Throwable -> L80
        L79:
            if (r3 == 0) goto L7c
            goto L6e
        L7c:
            r10.f571i = r0     // Catch: java.lang.Throwable -> L80
            monitor-exit(r10)
            return r0
        L80:
            r0 = move-exception
            monitor-exit(r10)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.p006b.C0658l.m457d():int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0080, code lost:
    
        if (r2 == null) goto L34;
     */
    /* renamed from: e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m458e() {
        /*
            r10 = this;
            boolean r0 = r10.f569g
            if (r0 == 0) goto L5
            return
        L5:
            com.baidu.location.f.m r0 = com.baidu.location.p010f.C0715m.m1058a()     // Catch: java.lang.Exception -> Lac
            boolean r0 = r0.m1077k()     // Catch: java.lang.Exception -> Lac
            if (r0 == 0) goto La9
            android.database.sqlite.SQLiteDatabase r0 = r10.f568f     // Catch: java.lang.Exception -> Lac
            if (r0 == 0) goto La9
            com.baidu.location.f.m r0 = com.baidu.location.p010f.C0715m.m1058a()     // Catch: java.lang.Exception -> Lac
            android.net.wifi.WifiInfo r0 = r0.m1079m()     // Catch: java.lang.Exception -> Lac
            if (r0 == 0) goto La9
            java.lang.String r1 = r0.getBSSID()     // Catch: java.lang.Exception -> Lac
            if (r1 == 0) goto La9
            java.lang.String r0 = r0.getBSSID()     // Catch: java.lang.Exception -> Lac
            java.lang.String r1 = ":"
            java.lang.String r2 = ""
            java.lang.String r0 = r0.replace(r1, r2)     // Catch: java.lang.Exception -> Lac
            java.lang.Long r1 = com.baidu.location.Jni.encode3(r0)     // Catch: java.lang.Exception -> Lac
            r2 = 0
            r3 = 0
            r4 = 1
            android.database.sqlite.SQLiteDatabase r5 = r10.f568f     // Catch: java.lang.Throwable -> L86 java.lang.Exception -> L8d
            java.lang.String r6 = "select * from hstdata where id = ?"
            java.lang.String[] r7 = new java.lang.String[r4]     // Catch: java.lang.Throwable -> L86 java.lang.Exception -> L8d
            java.lang.String r1 = java.lang.String.valueOf(r1)     // Catch: java.lang.Throwable -> L86 java.lang.Exception -> L8d
            r7[r3] = r1     // Catch: java.lang.Throwable -> L86 java.lang.Exception -> L8d
            android.database.Cursor r2 = r5.rawQuery(r6, r7)     // Catch: java.lang.Throwable -> L86 java.lang.Exception -> L8d
            if (r2 == 0) goto L7f
            boolean r1 = r2.moveToFirst()     // Catch: java.lang.Throwable -> L86 java.lang.Exception -> L8d
            if (r1 == 0) goto L7f
            int r1 = r2.getInt(r4)     // Catch: java.lang.Throwable -> L86 java.lang.Exception -> L8d
            r5 = 2
            int r5 = r2.getInt(r5)     // Catch: java.lang.Throwable -> L86 java.lang.Exception -> L8d
            long r6 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L86 java.lang.Exception -> L8d
            r8 = 1000(0x3e8, double:4.94E-321)
            long r6 = r6 / r8
            long r8 = (long) r5     // Catch: java.lang.Throwable -> L86 java.lang.Exception -> L8d
            long r6 = r6 - r8
            r8 = 259200(0x3f480, double:1.28062E-318)
            int r5 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r5 <= 0) goto L68
            goto L7f
        L68:
            android.os.Bundle r5 = new android.os.Bundle     // Catch: java.lang.Throwable -> L86 java.lang.Exception -> L8d
            r5.<init>()     // Catch: java.lang.Throwable -> L86 java.lang.Exception -> L8d
            java.lang.String r6 = "mac"
            byte[] r7 = r0.getBytes()     // Catch: java.lang.Throwable -> L86 java.lang.Exception -> L8d
            r5.putByteArray(r6, r7)     // Catch: java.lang.Throwable -> L86 java.lang.Exception -> L8d
            java.lang.String r6 = "hotspot"
            r5.putInt(r6, r1)     // Catch: java.lang.Throwable -> L86 java.lang.Exception -> L8d
            r10.m448a(r5)     // Catch: java.lang.Throwable -> L86 java.lang.Exception -> L8d
            goto L80
        L7f:
            r3 = r4
        L80:
            if (r2 == 0) goto L90
        L82:
            r2.close()     // Catch: java.lang.Exception -> L90
            goto L90
        L86:
            r0 = move-exception
            if (r2 == 0) goto L8c
            r2.close()     // Catch: java.lang.Exception -> L8c
        L8c:
            throw r0     // Catch: java.lang.Exception -> Lac
        L8d:
            if (r2 == 0) goto L90
            goto L82
        L90:
            if (r3 == 0) goto Lac
            com.baidu.location.b.l$a r1 = r10.f566a     // Catch: java.lang.Exception -> Lac
            if (r1 != 0) goto L9d
            com.baidu.location.b.l$a r1 = new com.baidu.location.b.l$a     // Catch: java.lang.Exception -> Lac
            r1.<init>()     // Catch: java.lang.Exception -> Lac
            r10.f566a = r1     // Catch: java.lang.Exception -> Lac
        L9d:
            com.baidu.location.b.l$a r1 = r10.f566a     // Catch: java.lang.Exception -> Lac
            if (r1 == 0) goto Lac
            java.lang.String r2 = r10.m447a(r4)     // Catch: java.lang.Exception -> Lac
            r1.m459a(r0, r2)     // Catch: java.lang.Exception -> Lac
            goto Lac
        La9:
            r10.m453f()     // Catch: java.lang.Exception -> Lac
        Lac:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.p006b.C0658l.m458e():void");
    }
}