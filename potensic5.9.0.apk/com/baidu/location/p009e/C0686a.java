package com.baidu.location.p009e;

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
import com.baidu.location.ServiceC0702f;
import com.baidu.location.p006b.C0648b;
import com.baidu.location.p006b.C0662p;
import com.baidu.location.p010f.C0703a;
import com.baidu.location.p010f.C0704b;
import com.baidu.location.p010f.C0714l;
import com.baidu.location.p010f.C0715m;
import com.baidu.location.p012h.C0720b;
import com.baidu.location.p012h.C0732n;
import com.baidu.location.p012h.C0733o;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.ipotensic.baselib.netty.Constant;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* renamed from: com.baidu.location.e.a */
/* loaded from: classes.dex */
public final class C0686a {

    /* renamed from: b */
    private static C0686a f852b;

    /* renamed from: l */
    private static final String f853l = C0732n.f1312a;

    /* renamed from: m */
    private static final String f854m = C0732n.f1312a + "/ls.db";

    /* renamed from: c */
    private String f856c = null;

    /* renamed from: d */
    private boolean f857d = false;

    /* renamed from: e */
    private boolean f858e = false;

    /* renamed from: f */
    private double f859f = 0.0d;

    /* renamed from: g */
    private double f860g = 0.0d;

    /* renamed from: h */
    private double f861h = 0.0d;

    /* renamed from: i */
    private double f862i = 0.0d;

    /* renamed from: j */
    private double f863j = 0.0d;

    /* renamed from: k */
    private volatile boolean f864k = false;

    /* renamed from: n */
    private Handler f865n = null;

    /* renamed from: a */
    public boolean f855a = false;

    /* renamed from: com.baidu.location.e.a$a */
    private class a extends AsyncTask<Boolean, Void, Boolean> {
        private a() {
        }

        /* synthetic */ a(C0686a c0686a, RunnableC0687b runnableC0687b) {
            this();
        }

        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        protected Boolean doInBackground(Boolean... boolArr) {
            if (boolArr.length != 4) {
                return false;
            }
            SQLiteDatabase sQLiteDatabase = null;
            try {
                sQLiteDatabase = SQLiteDatabase.openOrCreateDatabase(C0686a.f854m, (SQLiteDatabase.CursorFactory) null);
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

    /* renamed from: com.baidu.location.e.a$b */
    private class b extends AsyncTask<Object, Void, Boolean> {
        private b() {
        }

        /* synthetic */ b(C0686a c0686a, RunnableC0687b runnableC0687b) {
            this();
        }

        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        protected Boolean doInBackground(Object... objArr) {
            if (objArr.length == 4) {
                SQLiteDatabase sQLiteDatabase = null;
                try {
                    sQLiteDatabase = SQLiteDatabase.openOrCreateDatabase(C0686a.f854m, (SQLiteDatabase.CursorFactory) null);
                } catch (Exception unused) {
                }
                if (sQLiteDatabase != null) {
                    try {
                        sQLiteDatabase.beginTransaction();
                        C0686a.this.m708a((String) objArr[0], (C0703a) objArr[1], sQLiteDatabase);
                        C0686a.this.m706a((C0714l) objArr[2], (BDLocation) objArr[3], sQLiteDatabase);
                        sQLiteDatabase.setTransactionSuccessful();
                        sQLiteDatabase.endTransaction();
                        sQLiteDatabase.close();
                    } catch (Exception unused2) {
                    }
                    C0686a.this.f864k = false;
                    return true;
                }
            }
            C0686a.this.f864k = false;
            return false;
        }
    }

    private C0686a() {
        m718b();
    }

    /* renamed from: a */
    public static synchronized C0686a m702a() {
        C0686a c0686a;
        synchronized (C0686a.class) {
            if (f852b == null) {
                f852b = new C0686a();
            }
            c0686a = f852b;
        }
        return c0686a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m706a(C0714l c0714l, BDLocation bDLocation, SQLiteDatabase sQLiteDatabase) {
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
        if (("wf".equals(bDLocation.getNetworkLocationType()) || bDLocation.getRadius() < 300.0f) && c0714l.f1188a != null) {
            int currentTimeMillis = (int) (System.currentTimeMillis() >> 28);
            System.currentTimeMillis();
            Iterator<ScanResult> it2 = c0714l.f1188a.iterator();
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

    /* renamed from: a */
    private void m707a(String str, SQLiteDatabase sQLiteDatabase) {
        if (str == null || str.equals(this.f856c)) {
            return;
        }
        this.f857d = false;
        Cursor cursor = null;
        try {
            cursor = sQLiteDatabase.rawQuery("select * from bdcltb09 where id = ?", new String[]{str});
            this.f856c = str;
            if (cursor.moveToFirst()) {
                this.f860g = cursor.getDouble(1) - 1235.4323d;
                this.f859f = cursor.getDouble(2) - 4326.0d;
                this.f861h = cursor.getDouble(3) - 2367.3217d;
                this.f857d = true;
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
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m708a(java.lang.String r20, com.baidu.location.p010f.C0703a r21, android.database.sqlite.SQLiteDatabase r22) {
        /*
            Method dump skipped, instructions count: 307
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.p009e.C0686a.m708a(java.lang.String, com.baidu.location.f.a, android.database.sqlite.SQLiteDatabase):void");
    }

    /* renamed from: a */
    private void m709a(String str, List<ScanResult> list) {
        this.f857d = false;
        this.f858e = false;
        SQLiteDatabase sQLiteDatabase = null;
        try {
            sQLiteDatabase = SQLiteDatabase.openOrCreateDatabase(f854m, (SQLiteDatabase.CursorFactory) null);
        } catch (Throwable unused) {
        }
        if (str != null && sQLiteDatabase != null) {
            m707a(str, sQLiteDatabase);
        }
        if (list != null && sQLiteDatabase != null) {
            m710a(list, sQLiteDatabase);
        }
        if (sQLiteDatabase == null || !sQLiteDatabase.isOpen()) {
            return;
        }
        sQLiteDatabase.close();
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x0174 A[Catch: all -> 0x018f, Exception -> 0x0196, TryCatch #4 {Exception -> 0x0196, all -> 0x018f, blocks: (B:20:0x005f, B:23:0x008d, B:25:0x0094, B:29:0x00b9, B:33:0x00bf, B:35:0x00c3, B:50:0x00e9, B:38:0x00ed, B:42:0x0174, B:53:0x00fa, B:60:0x0120, B:63:0x0131, B:65:0x014a, B:67:0x0155, B:72:0x015b, B:76:0x0168, B:47:0x017f), top: B:19:0x005f }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0173 A[SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m710a(java.util.List<android.net.wifi.ScanResult> r30, android.database.sqlite.SQLiteDatabase r31) {
        /*
            Method dump skipped, instructions count: 410
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.p009e.C0686a.m710a(java.util.List, android.database.sqlite.SQLiteDatabase):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0029  */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String m712b(boolean r17) {
        /*
            r16 = this;
            r0 = r16
            boolean r1 = r0.f858e
            r2 = 0
            r4 = 0
            r5 = 1
            if (r1 == 0) goto L15
            double r2 = r0.f862i
            double r6 = r0.f863j
            r8 = 4642873445846928589(0x406ecccccccccccd, double:246.4)
        L13:
            r1 = r5
            goto L23
        L15:
            boolean r1 = r0.f857d
            if (r1 == 0) goto L20
            double r2 = r0.f860g
            double r6 = r0.f861h
            double r8 = r0.f859f
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
            java.lang.String r11 = com.baidu.location.p012h.C0733o.m1138a()
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
            java.lang.String r11 = com.baidu.location.p012h.C0733o.m1138a()
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
            java.lang.String r2 = com.baidu.location.p012h.C0733o.m1138a()
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r2 = "\",\"error\":\"67\"}}"
            goto Ld6
        Lc5:
            r1.<init>()
            java.lang.StringBuilder r1 = r1.append(r11)
            java.lang.String r2 = com.baidu.location.p012h.C0733o.m1138a()
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r2 = "\",\"error\":\"63\"}}"
        Ld6:
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r1 = r1.toString()
        Lde:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.p009e.C0686a.m712b(boolean):java.lang.String");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m714e() {
        SQLiteDatabase sQLiteDatabase;
        RunnableC0687b runnableC0687b = null;
        try {
            sQLiteDatabase = SQLiteDatabase.openOrCreateDatabase(f854m, (SQLiteDatabase.CursorFactory) null);
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
                new a(this, runnableC0687b).execute(Boolean.valueOf(z), Boolean.valueOf(z2));
            }
        } catch (Exception unused2) {
        }
    }

    /* renamed from: a */
    public BDLocation m715a(String str, List<ScanResult> list, boolean z) {
        if (!this.f855a) {
            return new BDLocation("{\"result\":{\"time\":\"" + C0733o.m1138a() + "\",\"error\":\"67\"}}");
        }
        String str2 = "{\"result\":{\"time\":\"" + C0733o.m1138a() + "\",\"error\":\"67\"}}";
        try {
            m709a(str, list);
            String m712b = m712b(true);
            if (m712b != null) {
                str2 = m712b;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return new BDLocation(str2);
    }

    /* renamed from: a */
    public BDLocation m716a(boolean z) {
        if (!this.f855a) {
            return new BDLocation("{\"result\":{\"time\":\"" + C0733o.m1138a() + "\",\"error\":\"67\"}}");
        }
        C0703a m940f = C0704b.m912a().m940f();
        String m901g = (m940f == null || !m940f.m899e()) ? null : m940f.m901g();
        C0714l m1082p = C0715m.m1058a().m1082p();
        BDLocation m715a = m1082p != null ? m715a(m901g, m1082p.f1188a, true) : null;
        if (m715a != null && m715a.getLocType() == 66) {
            StringBuffer stringBuffer = new StringBuffer(1024);
            stringBuffer.append(String.format(Locale.CHINA, "&ofl=%f|%f|%f", Double.valueOf(m715a.getLatitude()), Double.valueOf(m715a.getLongitude()), Float.valueOf(m715a.getRadius())));
            if (m1082p != null && m1082p.m1037a() > 0) {
                stringBuffer.append("&wf=");
                stringBuffer.append(m1082p.m1043b(15));
            }
            if (m940f != null) {
                stringBuffer.append(m940f.m903i());
            }
            stringBuffer.append("&uptype=oldoff");
            stringBuffer.append(C0733o.m1165f(ServiceC0702f.getServiceContext()));
            stringBuffer.append(C0720b.m1100a().m1101a(false));
            stringBuffer.append(C0648b.m321a().m339d());
            stringBuffer.toString();
        }
        return m715a;
    }

    /* renamed from: a */
    public void m717a(String str, C0703a c0703a, C0714l c0714l, BDLocation bDLocation) {
        if (this.f855a) {
            boolean z = (c0703a.m896b() && C0662p.m509c().m535i()) ? false : true;
            boolean z2 = bDLocation == null || bDLocation.getLocType() != 161 || (!"wf".equals(bDLocation.getNetworkLocationType()) && bDLocation.getRadius() >= 300.0f);
            if (c0714l.f1188a == null) {
                z2 = true;
            }
            if ((z && z2) || this.f864k) {
                return;
            }
            this.f864k = true;
            new b(this, null).execute(str, c0703a, c0714l, bDLocation);
        }
    }

    /* renamed from: b */
    public void m718b() {
        try {
            File file = new File(f853l);
            File file2 = new File(f854m);
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
            this.f855a = true;
        } catch (Throwable unused) {
            this.f855a = false;
        }
    }

    /* renamed from: c */
    public void m719c() {
        if (this.f865n == null) {
            this.f865n = new Handler();
        }
        this.f865n.postDelayed(new RunnableC0687b(this), 3000L);
    }
}