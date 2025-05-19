package com.baidu.location.e;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.location.Location;
import android.net.wifi.ScanResult;
import android.os.AsyncTask;
import android.os.Handler;
import com.baidu.location.BDLocation;
import com.baidu.location.Jni;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.ipotensic.baselib.netty.Constant;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* loaded from: classes.dex */
public final class a {
    private static a b;
    private static final String l = com.baidu.location.h.n.a;
    private static final String m = com.baidu.location.h.n.a + "/ls.db";
    private String c = null;
    private boolean d = false;
    private boolean e = false;
    private double f = 0.0d;
    private double g = 0.0d;
    private double h = 0.0d;
    private double i = 0.0d;
    private double j = 0.0d;
    private volatile boolean k = false;
    private Handler n = null;
    public boolean a = false;

    /* renamed from: com.baidu.location.e.a$a, reason: collision with other inner class name */
    private class AsyncTaskC0009a extends AsyncTask<Boolean, Void, Boolean> {
        private AsyncTaskC0009a() {
        }

        /* synthetic */ AsyncTaskC0009a(a aVar, com.baidu.location.e.b bVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean doInBackground(Boolean... boolArr) {
            if (boolArr.length != 4) {
                return false;
            }
            SQLiteDatabase sQLiteDatabase = null;
            try {
                sQLiteDatabase = SQLiteDatabase.openOrCreateDatabase(a.m, (SQLiteDatabase.CursorFactory) null);
            } catch (Exception unused) {
            }
            if (sQLiteDatabase == null) {
                return false;
            }
            int currentTimeMillis = (int) (System.currentTimeMillis() >> 28);
            try {
                sQLiteDatabase.beginTransaction();
                if (boolArr[0].booleanValue()) {
                    try {
                        sQLiteDatabase.execSQL("delete from wof where ac < " + (currentTimeMillis - 35));
                    } catch (Exception unused2) {
                    }
                }
                if (boolArr[1].booleanValue()) {
                    try {
                        sQLiteDatabase.execSQL("delete from bdcltb09 where ac is NULL or ac < " + (currentTimeMillis - 130));
                    } catch (Exception unused3) {
                    }
                }
                sQLiteDatabase.setTransactionSuccessful();
                sQLiteDatabase.endTransaction();
                sQLiteDatabase.close();
            } catch (Exception unused4) {
            }
            return true;
        }
    }

    private class b extends AsyncTask<Object, Void, Boolean> {
        private b() {
        }

        /* synthetic */ b(a aVar, com.baidu.location.e.b bVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean doInBackground(Object... objArr) {
            if (objArr.length == 4) {
                SQLiteDatabase sQLiteDatabase = null;
                try {
                    sQLiteDatabase = SQLiteDatabase.openOrCreateDatabase(a.m, (SQLiteDatabase.CursorFactory) null);
                } catch (Exception unused) {
                }
                if (sQLiteDatabase != null) {
                    try {
                        sQLiteDatabase.beginTransaction();
                        a.this.a((String) objArr[0], (com.baidu.location.f.a) objArr[1], sQLiteDatabase);
                        a.this.a((com.baidu.location.f.l) objArr[2], (BDLocation) objArr[3], sQLiteDatabase);
                        sQLiteDatabase.setTransactionSuccessful();
                        sQLiteDatabase.endTransaction();
                        sQLiteDatabase.close();
                    } catch (Exception unused2) {
                    }
                    a.this.k = false;
                    return true;
                }
            }
            a.this.k = false;
            return false;
        }
    }

    private a() {
        b();
    }

    public static synchronized a a() {
        a aVar;
        synchronized (a.class) {
            if (b == null) {
                b = new a();
            }
            aVar = b;
        }
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.location.f.l lVar, BDLocation bDLocation, SQLiteDatabase sQLiteDatabase) {
        Iterator<ScanResult> it;
        int i;
        int i2;
        double d;
        double d2;
        int i3;
        int i4;
        boolean z;
        String str;
        SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
        if (bDLocation == null || bDLocation.getLocType() != 161) {
            return;
        }
        if (("wf".equals(bDLocation.getNetworkLocationType()) || bDLocation.getRadius() < 300.0f) && lVar.a != null) {
            int currentTimeMillis = (int) (System.currentTimeMillis() >> 28);
            System.currentTimeMillis();
            Iterator<ScanResult> it2 = lVar.a.iterator();
            char c = 0;
            int i5 = 0;
            while (it2.hasNext()) {
                ScanResult next = it2.next();
                if (next.level != 0) {
                    int i6 = i5 + 1;
                    if (i6 > 6) {
                        return;
                    }
                    ContentValues contentValues = new ContentValues();
                    String encode2 = Jni.encode2(next.BSSID.replace(":", ""));
                    try {
                        String[] strArr = new String[1];
                        strArr[c] = encode2;
                        Cursor rawQuery = sQLiteDatabase2.rawQuery("select * from wof where id = ?", strArr);
                        d = 0.0d;
                        if (rawQuery == null || !rawQuery.moveToFirst()) {
                            d2 = 0.0d;
                            i3 = 0;
                            i4 = 0;
                            z = false;
                        } else {
                            double d3 = rawQuery.getDouble(1) - 113.2349d;
                            double d4 = rawQuery.getDouble(2) - 432.1238d;
                            i3 = rawQuery.getInt(4);
                            i4 = rawQuery.getInt(5);
                            z = true;
                            d = d4;
                            d2 = d3;
                        }
                        if (rawQuery != null) {
                            rawQuery.close();
                        }
                        it = it2;
                    } catch (Exception unused) {
                        it = it2;
                    }
                    if (!z) {
                        try {
                            contentValues.put("mktime", Double.valueOf(bDLocation.getLongitude() + 113.2349d));
                            contentValues.put(RtspHeaders.Values.TIME, Double.valueOf(bDLocation.getLatitude() + 432.1238d));
                            contentValues.put("bc", (Integer) 1);
                            contentValues.put("cc", (Integer) 1);
                            contentValues.put("ac", Integer.valueOf(currentTimeMillis));
                            contentValues.put(TtmlNode.ATTR_ID, encode2);
                            sQLiteDatabase2.insert("wof", null, contentValues);
                        } catch (Exception unused2) {
                        }
                    } else if (i4 != 0) {
                        i = i6;
                        try {
                            float[] fArr = new float[1];
                            Location.distanceBetween(d, d2, bDLocation.getLatitude(), bDLocation.getLongitude(), fArr);
                            if (fArr[0] > 1500.0f) {
                                int i7 = i4 + 1;
                                if (i7 <= 10 || i7 <= i3 * 3) {
                                    contentValues.put("cc", Integer.valueOf(i7));
                                } else {
                                    contentValues.put("mktime", Double.valueOf(bDLocation.getLongitude() + 113.2349d));
                                    contentValues.put(RtspHeaders.Values.TIME, Double.valueOf(bDLocation.getLatitude() + 432.1238d));
                                    contentValues.put("bc", (Integer) 1);
                                    contentValues.put("cc", (Integer) 1);
                                    contentValues.put("ac", Integer.valueOf(currentTimeMillis));
                                }
                                i2 = currentTimeMillis;
                                str = encode2;
                            } else {
                                str = encode2;
                                double d5 = i3;
                                int i8 = i3 + 1;
                                i2 = currentTimeMillis;
                                double d6 = i8;
                                double longitude = ((d2 * d5) + bDLocation.getLongitude()) / d6;
                                try {
                                    double latitude = ((d * d5) + bDLocation.getLatitude()) / d6;
                                    contentValues.put("mktime", Double.valueOf(longitude + 113.2349d));
                                    contentValues.put(RtspHeaders.Values.TIME, Double.valueOf(latitude + 432.1238d));
                                    contentValues.put("bc", Integer.valueOf(i8));
                                    contentValues.put("ac", Integer.valueOf(i2));
                                } catch (Exception unused3) {
                                    sQLiteDatabase2 = sQLiteDatabase;
                                }
                            }
                            sQLiteDatabase2 = sQLiteDatabase;
                            try {
                                sQLiteDatabase2.update("wof", contentValues, "id = \"" + str + "\"", null);
                            } catch (Exception unused4) {
                            }
                        } catch (Exception unused5) {
                            sQLiteDatabase2 = sQLiteDatabase;
                            i2 = currentTimeMillis;
                        }
                        currentTimeMillis = i2;
                        it2 = it;
                        i5 = i;
                        c = 0;
                    }
                    i2 = currentTimeMillis;
                    i = i6;
                    currentTimeMillis = i2;
                    it2 = it;
                    i5 = i;
                    c = 0;
                }
            }
        }
    }

    private void a(String str, SQLiteDatabase sQLiteDatabase) {
        if (str == null || str.equals(this.c)) {
            return;
        }
        this.d = false;
        Cursor cursor = null;
        try {
            cursor = sQLiteDatabase.rawQuery("select * from bdcltb09 where id = ?", new String[]{str});
            this.c = str;
            if (cursor.moveToFirst()) {
                this.g = cursor.getDouble(1) - 1235.4323d;
                this.f = cursor.getDouble(2) - 4326.0d;
                this.h = cursor.getDouble(3) - 2367.3217d;
                this.d = true;
            }
            if (cursor == null) {
                return;
            }
        } catch (Exception unused) {
            if (cursor == null) {
                return;
            }
        } catch (Throwable th) {
            if (cursor != null) {
                try {
                    cursor.close();
                } catch (Exception unused2) {
                }
            }
            throw th;
        }
        try {
            cursor.close();
        } catch (Exception unused3) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00d2 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00d3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(java.lang.String r20, com.baidu.location.f.a r21, android.database.sqlite.SQLiteDatabase r22) {
        /*
            Method dump skipped, instructions count: 307
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.e.a.a(java.lang.String, com.baidu.location.f.a, android.database.sqlite.SQLiteDatabase):void");
    }

    private void a(String str, List<ScanResult> list) {
        this.d = false;
        this.e = false;
        SQLiteDatabase sQLiteDatabase = null;
        try {
            sQLiteDatabase = SQLiteDatabase.openOrCreateDatabase(m, (SQLiteDatabase.CursorFactory) null);
        } catch (Throwable unused) {
        }
        if (str != null && sQLiteDatabase != null) {
            a(str, sQLiteDatabase);
        }
        if (list != null && sQLiteDatabase != null) {
            a(list, sQLiteDatabase);
        }
        if (sQLiteDatabase == null || !sQLiteDatabase.isOpen()) {
            return;
        }
        sQLiteDatabase.close();
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x0174 A[Catch: all -> 0x018f, Exception -> 0x0196, TryCatch #4 {Exception -> 0x0196, all -> 0x018f, blocks: (B:20:0x005f, B:23:0x008d, B:25:0x0094, B:29:0x00b9, B:33:0x00bf, B:35:0x00c3, B:50:0x00e9, B:38:0x00ed, B:42:0x0174, B:53:0x00fa, B:60:0x0120, B:63:0x0131, B:65:0x014a, B:67:0x0155, B:72:0x015b, B:76:0x0168, B:47:0x017f), top: B:19:0x005f }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0173 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(java.util.List<android.net.wifi.ScanResult> r30, android.database.sqlite.SQLiteDatabase r31) {
        /*
            Method dump skipped, instructions count: 410
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.e.a.a(java.util.List, android.database.sqlite.SQLiteDatabase):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String b(boolean r17) {
        /*
            r16 = this;
            r0 = r16
            boolean r1 = r0.e
            r2 = 0
            r4 = 0
            r5 = 1
            if (r1 == 0) goto L15
            double r2 = r0.i
            double r6 = r0.j
            r8 = 4642873445846928589(0x406ecccccccccccd, double:246.4)
        L13:
            r1 = r5
            goto L23
        L15:
            boolean r1 = r0.d
            if (r1 == 0) goto L20
            double r2 = r0.g
            double r6 = r0.h
            double r8 = r0.f
            goto L13
        L20:
            r6 = r2
            r8 = r6
            r1 = r4
        L23:
            r10 = r1
            java.lang.String r11 = "{\"result\":{\"time\":\""
            if (r1 == 0) goto Laf
            r1 = 3
            r12 = 2
            r13 = 4
            java.lang.String r14 = "\"%f\",\"y\":\"%f\"},\"radius\":\"%f\",\"isCellChanged\":\"%b\"}}"
            java.lang.String r15 = "\",\"error\":\"66\"},\"content\":{\"point\":{\"x\":"
            if (r17 == 0) goto L70
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.StringBuilder r10 = r10.append(r11)
            java.lang.String r11 = com.baidu.location.h.o.a()
            java.lang.StringBuilder r10 = r10.append(r11)
            java.lang.StringBuilder r10 = r10.append(r15)
            java.lang.StringBuilder r10 = r10.append(r14)
            java.lang.String r10 = r10.toString()
            java.util.Locale r11 = java.util.Locale.CHINA
            java.lang.Object[] r13 = new java.lang.Object[r13]
            java.lang.Double r2 = java.lang.Double.valueOf(r2)
            r13[r4] = r2
            java.lang.Double r2 = java.lang.Double.valueOf(r6)
            r13[r5] = r2
            java.lang.Double r2 = java.lang.Double.valueOf(r8)
            r13[r12] = r2
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r5)
            r13[r1] = r2
            java.lang.String r1 = java.lang.String.format(r11, r10, r13)
            goto Lde
        L70:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.StringBuilder r1 = r1.append(r11)
            java.lang.String r11 = com.baidu.location.h.o.a()
            java.lang.StringBuilder r1 = r1.append(r11)
            java.lang.StringBuilder r1 = r1.append(r15)
            java.lang.StringBuilder r1 = r1.append(r14)
            java.lang.String r1 = r1.toString()
            java.util.Locale r11 = java.util.Locale.CHINA
            java.lang.Object[] r13 = new java.lang.Object[r13]
            java.lang.Double r2 = java.lang.Double.valueOf(r2)
            r13[r4] = r2
            java.lang.Double r2 = java.lang.Double.valueOf(r6)
            r13[r5] = r2
            java.lang.Double r2 = java.lang.Double.valueOf(r8)
            r13[r12] = r2
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r10)
            r3 = 3
            r13[r3] = r2
            java.lang.String r1 = java.lang.String.format(r11, r1, r13)
            goto Lde
        Laf:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            if (r17 == 0) goto Lc5
            r1.<init>()
            java.lang.StringBuilder r1 = r1.append(r11)
            java.lang.String r2 = com.baidu.location.h.o.a()
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r2 = "\",\"error\":\"67\"}}"
            goto Ld6
        Lc5:
            r1.<init>()
            java.lang.StringBuilder r1 = r1.append(r11)
            java.lang.String r2 = com.baidu.location.h.o.a()
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r2 = "\",\"error\":\"63\"}}"
        Ld6:
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r1 = r1.toString()
        Lde:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.e.a.b(boolean):java.lang.String");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        SQLiteDatabase sQLiteDatabase;
        com.baidu.location.e.b bVar = null;
        try {
            sQLiteDatabase = SQLiteDatabase.openOrCreateDatabase(m, (SQLiteDatabase.CursorFactory) null);
        } catch (Exception unused) {
            sQLiteDatabase = null;
        }
        if (sQLiteDatabase == null) {
            return;
        }
        try {
            long queryNumEntries = DatabaseUtils.queryNumEntries(sQLiteDatabase, "wof");
            long queryNumEntries2 = DatabaseUtils.queryNumEntries(sQLiteDatabase, "bdcltb09");
            boolean z = queryNumEntries > Constant.DELAY_MILLIS;
            boolean z2 = queryNumEntries2 > Constant.DELAY_MILLIS;
            sQLiteDatabase.close();
            if (z || z2) {
                new AsyncTaskC0009a(this, bVar).execute(Boolean.valueOf(z), Boolean.valueOf(z2));
            }
        } catch (Exception unused2) {
        }
    }

    public BDLocation a(String str, List<ScanResult> list, boolean z) {
        if (!this.a) {
            return new BDLocation("{\"result\":{\"time\":\"" + com.baidu.location.h.o.a() + "\",\"error\":\"67\"}}");
        }
        String str2 = "{\"result\":{\"time\":\"" + com.baidu.location.h.o.a() + "\",\"error\":\"67\"}}";
        try {
            a(str, list);
            String b2 = b(true);
            if (b2 != null) {
                str2 = b2;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return new BDLocation(str2);
    }

    public BDLocation a(boolean z) {
        if (!this.a) {
            return new BDLocation("{\"result\":{\"time\":\"" + com.baidu.location.h.o.a() + "\",\"error\":\"67\"}}");
        }
        com.baidu.location.f.a f = com.baidu.location.f.b.a().f();
        String g = (f == null || !f.e()) ? null : f.g();
        com.baidu.location.f.l p = com.baidu.location.f.m.a().p();
        BDLocation a = p != null ? a(g, p.a, true) : null;
        if (a != null && a.getLocType() == 66) {
            StringBuffer stringBuffer = new StringBuffer(1024);
            stringBuffer.append(String.format(Locale.CHINA, "&ofl=%f|%f|%f", Double.valueOf(a.getLatitude()), Double.valueOf(a.getLongitude()), Float.valueOf(a.getRadius())));
            if (p != null && p.a() > 0) {
                stringBuffer.append("&wf=");
                stringBuffer.append(p.b(15));
            }
            if (f != null) {
                stringBuffer.append(f.i());
            }
            stringBuffer.append("&uptype=oldoff");
            stringBuffer.append(com.baidu.location.h.o.f(com.baidu.location.f.getServiceContext()));
            stringBuffer.append(com.baidu.location.h.b.a().a(false));
            stringBuffer.append(com.baidu.location.b.b.a().d());
            stringBuffer.toString();
        }
        return a;
    }

    public void a(String str, com.baidu.location.f.a aVar, com.baidu.location.f.l lVar, BDLocation bDLocation) {
        if (this.a) {
            boolean z = (aVar.b() && com.baidu.location.b.p.c().i()) ? false : true;
            boolean z2 = bDLocation == null || bDLocation.getLocType() != 161 || (!"wf".equals(bDLocation.getNetworkLocationType()) && bDLocation.getRadius() >= 300.0f);
            if (lVar.a == null) {
                z2 = true;
            }
            if ((z && z2) || this.k) {
                return;
            }
            this.k = true;
            new b(this, null).execute(str, aVar, lVar, bDLocation);
        }
    }

    public void b() {
        try {
            File file = new File(l);
            File file2 = new File(m);
            if (!file.exists()) {
                file.mkdirs();
            }
            if (!file2.exists()) {
                file2.createNewFile();
            }
            if (file2.exists()) {
                SQLiteDatabase openOrCreateDatabase = SQLiteDatabase.openOrCreateDatabase(file2, (SQLiteDatabase.CursorFactory) null);
                openOrCreateDatabase.execSQL("CREATE TABLE IF NOT EXISTS bdcltb09(id CHAR(40) PRIMARY KEY,time DOUBLE,tag DOUBLE, type DOUBLE , ac INT);");
                openOrCreateDatabase.execSQL("CREATE TABLE IF NOT EXISTS wof(id CHAR(15) PRIMARY KEY,mktime DOUBLE,time DOUBLE, ac INT, bc INT, cc INT);");
                openOrCreateDatabase.setVersion(1);
                openOrCreateDatabase.close();
            }
            this.a = true;
        } catch (Throwable unused) {
            this.a = false;
        }
    }

    public void c() {
        if (this.n == null) {
            this.n = new Handler();
        }
        this.n.postDelayed(new com.baidu.location.e.b(this), 3000L);
    }
}
