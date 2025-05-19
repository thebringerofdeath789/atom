package com.baidu.location.b;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import com.baidu.location.Jni;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.io.File;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class l {
    private static l d;
    private static Object c = new Object();
    private static final String e = com.baidu.location.h.o.g() + "/hst.db";
    private SQLiteDatabase f = null;
    private boolean g = false;
    a a = null;
    a b = null;
    private String h = null;
    private int i = -2;

    class a extends com.baidu.location.h.g {
        private String b = null;
        private String c = null;
        private boolean d = true;
        private boolean e = false;

        a() {
            this.k = new HashMap();
        }

        public void a(String str, String str2) {
            if (l.this.g) {
                return;
            }
            l.this.g = true;
            this.b = str;
            this.c = str2;
            ExecutorService c = x.a().c();
            if (c != null) {
                a(c, com.baidu.location.h.d.c);
            } else {
                e(com.baidu.location.h.d.c);
            }
        }

        @Override // com.baidu.location.h.g
        public void a(boolean z) {
            if (z && this.j != null) {
                try {
                    String str = this.j;
                    if (this.d) {
                        JSONObject jSONObject = new JSONObject(str);
                        JSONObject jSONObject2 = jSONObject.has("content") ? jSONObject.getJSONObject("content") : null;
                        if (jSONObject2 != null && jSONObject2.has("imo")) {
                            Long valueOf = Long.valueOf(jSONObject2.getJSONObject("imo").getString("mac"));
                            int i = jSONObject2.getJSONObject("imo").getInt("mv");
                            if (Jni.encode3(this.b).longValue() == valueOf.longValue()) {
                                ContentValues contentValues = new ContentValues();
                                contentValues.put(TtmlNode.TAG_TT, Integer.valueOf((int) (System.currentTimeMillis() / 1000)));
                                contentValues.put("hst", Integer.valueOf(i));
                                try {
                                    if (l.this.f.update("hstdata", contentValues, "id = \"" + valueOf + "\"", null) <= 0) {
                                        contentValues.put(TtmlNode.ATTR_ID, valueOf);
                                        l.this.f.insert("hstdata", null, contentValues);
                                    }
                                } catch (Exception unused) {
                                }
                                Bundle bundle = new Bundle();
                                bundle.putByteArray("mac", this.b.getBytes());
                                bundle.putInt("hotspot", i);
                                l.this.a(bundle);
                            }
                        }
                    }
                } catch (Exception unused2) {
                }
            } else if (this.d) {
                l.this.f();
            }
            if (this.k != null) {
                this.k.clear();
            }
            l.this.g = false;
        }

        @Override // com.baidu.location.h.g
        public void b() {
            this.i = 1;
            String encodeTp4 = Jni.encodeTp4(this.c);
            this.c = null;
            this.k.put("bloc", encodeTp4);
        }
    }

    public static l a() {
        l lVar;
        synchronized (c) {
            if (d == null) {
                d = new l();
            }
            lVar = d;
        }
        return lVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0094  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String a(boolean r5) {
        /*
            r4 = this;
            com.baidu.location.f.b r0 = com.baidu.location.f.b.a()
            com.baidu.location.f.a r0 = r0.f()
            com.baidu.location.f.m r1 = com.baidu.location.f.m.a()
            com.baidu.location.f.l r1 = r1.q()
            java.lang.StringBuffer r2 = new java.lang.StringBuffer
            r3 = 1024(0x400, float:1.435E-42)
            r2.<init>(r3)
            if (r0 == 0) goto L26
            boolean r3 = r0.b()
            if (r3 == 0) goto L26
            java.lang.String r0 = r0.i()
            r2.append(r0)
        L26:
            if (r1 == 0) goto L36
            int r0 = r1.a()
            r3 = 1
            if (r0 <= r3) goto L36
            r0 = 15
            java.lang.String r0 = r1.a(r0)
            goto L48
        L36:
            com.baidu.location.f.m r0 = com.baidu.location.f.m.a()
            java.lang.String r0 = r0.n()
            if (r0 == 0) goto L4b
            com.baidu.location.f.m r0 = com.baidu.location.f.m.a()
            java.lang.String r0 = r0.n()
        L48:
            r2.append(r0)
        L4b:
            if (r5 == 0) goto L52
            java.lang.String r5 = "&imo=1"
            r2.append(r5)
        L52:
            com.baidu.location.f.g r5 = com.baidu.location.f.g.a()
            java.lang.String r5 = r5.m()
            r2.append(r5)
            com.baidu.location.h.b r5 = com.baidu.location.h.b.a()
            r0 = 0
            java.lang.String r5 = r5.a(r0)
            r2.append(r5)
            com.baidu.location.b.b r5 = com.baidu.location.b.b.a()
            java.lang.String r5 = r5.d()
            r2.append(r5)
            com.baidu.location.b.c r5 = com.baidu.location.b.c.a()
            java.lang.String r5 = r5.c()
            r2.append(r5)
            android.content.Context r5 = com.baidu.location.f.getServiceContext()
            java.lang.String r5 = com.baidu.location.h.o.e(r5)
            r2.append(r5)
            android.content.Context r5 = com.baidu.location.f.getServiceContext()
            int r5 = com.baidu.location.h.o.c(r5)
            if (r5 < 0) goto L9d
            java.lang.String r0 = "&lmd="
            java.lang.StringBuffer r0 = r2.append(r0)
            r0.append(r5)
        L9d:
            java.lang.String r5 = r2.toString()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.b.l.a(boolean):java.lang.String");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Bundle bundle) {
        b.a().a(bundle, 406);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        Bundle bundle = new Bundle();
        bundle.putInt("hotspot", -1);
        a(bundle);
    }

    public void a(String str) {
        if (this.g) {
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
            if (this.f.update("hstdata", contentValues, "id = \"" + valueOf + "\"", null) <= 0) {
                contentValues.put(TtmlNode.ATTR_ID, valueOf);
                this.f.insert("hstdata", null, contentValues);
            }
        } catch (Exception unused) {
        }
    }

    public void b() {
        try {
            File file = new File(e);
            if (!file.exists()) {
                file.createNewFile();
            }
            if (file.exists()) {
                SQLiteDatabase openOrCreateDatabase = SQLiteDatabase.openOrCreateDatabase(file, (SQLiteDatabase.CursorFactory) null);
                this.f = openOrCreateDatabase;
                openOrCreateDatabase.execSQL("CREATE TABLE IF NOT EXISTS hstdata(id Long PRIMARY KEY,hst INT,tt INT);");
                this.f.setVersion(1);
            }
        } catch (Exception unused) {
            this.f = null;
        }
    }

    public void c() {
        SQLiteDatabase sQLiteDatabase = this.f;
        if (sQLiteDatabase != null) {
            try {
                sQLiteDatabase.close();
            } catch (Exception unused) {
            } catch (Throwable th) {
                this.f = null;
                throw th;
            }
            this.f = null;
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
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized int d() {
        /*
            r10 = this;
            monitor-enter(r10)
            r0 = -3
            boolean r1 = r10.g     // Catch: java.lang.Throwable -> L80
            if (r1 == 0) goto L8
            monitor-exit(r10)
            return r0
        L8:
            com.baidu.location.f.m r1 = com.baidu.location.f.m.a()     // Catch: java.lang.Exception -> L7c java.lang.Throwable -> L80
            boolean r1 = r1.k()     // Catch: java.lang.Exception -> L7c java.lang.Throwable -> L80
            if (r1 == 0) goto L7c
            android.database.sqlite.SQLiteDatabase r1 = r10.f     // Catch: java.lang.Exception -> L7c java.lang.Throwable -> L80
            if (r1 == 0) goto L7c
            com.baidu.location.f.m r1 = com.baidu.location.f.m.a()     // Catch: java.lang.Exception -> L7c java.lang.Throwable -> L80
            android.net.wifi.WifiInfo r1 = r1.m()     // Catch: java.lang.Exception -> L7c java.lang.Throwable -> L80
            if (r1 == 0) goto L7c
            java.lang.String r2 = r1.getBSSID()     // Catch: java.lang.Exception -> L7c java.lang.Throwable -> L80
            if (r2 == 0) goto L7c
            java.lang.String r1 = r1.getBSSID()     // Catch: java.lang.Exception -> L7c java.lang.Throwable -> L80
            java.lang.String r2 = ":"
            java.lang.String r3 = ""
            java.lang.String r1 = r1.replace(r2, r3)     // Catch: java.lang.Exception -> L7c java.lang.Throwable -> L80
            java.lang.Long r2 = com.baidu.location.Jni.encode3(r1)     // Catch: java.lang.Exception -> L7c java.lang.Throwable -> L80
            java.lang.String r3 = r10.h     // Catch: java.lang.Exception -> L7c java.lang.Throwable -> L80
            r4 = -2
            if (r3 == 0) goto L47
            boolean r3 = r1.equals(r3)     // Catch: java.lang.Exception -> L7c java.lang.Throwable -> L80
            if (r3 == 0) goto L47
            int r3 = r10.i     // Catch: java.lang.Exception -> L7c java.lang.Throwable -> L80
            if (r3 <= r4) goto L47
            r0 = r3
            goto L7c
        L47:
            r3 = 0
            android.database.sqlite.SQLiteDatabase r5 = r10.f     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L79
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
            r10.h = r1     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L79
            r10.i = r0     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L79
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
            r10.i = r0     // Catch: java.lang.Throwable -> L80
            monitor-exit(r10)
            return r0
        L80:
            r0 = move-exception
            monitor-exit(r10)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.b.l.d():int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0080, code lost:
    
        if (r2 == null) goto L34;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void e() {
        /*
            r10 = this;
            boolean r0 = r10.g
            if (r0 == 0) goto L5
            return
        L5:
            com.baidu.location.f.m r0 = com.baidu.location.f.m.a()     // Catch: java.lang.Exception -> Lac
            boolean r0 = r0.k()     // Catch: java.lang.Exception -> Lac
            if (r0 == 0) goto La9
            android.database.sqlite.SQLiteDatabase r0 = r10.f     // Catch: java.lang.Exception -> Lac
            if (r0 == 0) goto La9
            com.baidu.location.f.m r0 = com.baidu.location.f.m.a()     // Catch: java.lang.Exception -> Lac
            android.net.wifi.WifiInfo r0 = r0.m()     // Catch: java.lang.Exception -> Lac
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
            android.database.sqlite.SQLiteDatabase r5 = r10.f     // Catch: java.lang.Throwable -> L86 java.lang.Exception -> L8d
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
            r10.a(r5)     // Catch: java.lang.Throwable -> L86 java.lang.Exception -> L8d
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
            com.baidu.location.b.l$a r1 = r10.a     // Catch: java.lang.Exception -> Lac
            if (r1 != 0) goto L9d
            com.baidu.location.b.l$a r1 = new com.baidu.location.b.l$a     // Catch: java.lang.Exception -> Lac
            r1.<init>()     // Catch: java.lang.Exception -> Lac
            r10.a = r1     // Catch: java.lang.Exception -> Lac
        L9d:
            com.baidu.location.b.l$a r1 = r10.a     // Catch: java.lang.Exception -> Lac
            if (r1 == 0) goto Lac
            java.lang.String r2 = r10.a(r4)     // Catch: java.lang.Exception -> Lac
            r1.a(r0, r2)     // Catch: java.lang.Exception -> Lac
            goto Lac
        La9:
            r10.f()     // Catch: java.lang.Exception -> Lac
        Lac:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.b.l.e():void");
    }
}
