package com.baidu.location.e;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.mapbox.api.geocoding.v5.GeocodingCriteria;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.json.JSONObject;

/* loaded from: classes.dex */
final class l {
    private static final double[] b = {45.0d, 135.0d, 225.0d, 315.0d};
    private final h a;
    private final int c;
    private final SQLiteDatabase d;
    private int e = -1;
    private int f = -1;

    private static final class a {
        private double a;
        private double b;

        private a(double d, double d2) {
            this.a = d;
            this.b = d2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    static abstract class b {
        public static final b a;
        public static final b b;
        public static final b c;
        public static final b d;
        private static final /* synthetic */ b[] j;
        private final int e;
        private final String f;
        private final String g;
        private final String h;
        private final int i;

        static {
            m mVar = new m("AREA", 0, "RGCAREA", "area", "addrv", 0, 1000);
            a = mVar;
            n nVar = new n("ROAD", 1, "RGCROAD", "road", "addrv", 1000, 10000);
            b = nVar;
            o oVar = new o("SITE", 2, "RGCSITE", "site", "addrv", 100, 50000);
            c = oVar;
            p pVar = new p("POI", 3, "RGCPOI", GeocodingCriteria.TYPE_POI, "poiv", 1000, 5000);
            d = pVar;
            j = new b[]{mVar, nVar, oVar, pVar};
        }

        private b(String str, int i, String str2, String str3, String str4, int i2, int i3) {
            this.f = str2;
            this.g = str3;
            this.h = str4;
            this.e = i2;
            this.i = i3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String a(int i, double d2, double d3) {
            HashSet hashSet = new HashSet();
            hashSet.add(l.b(i, d2, d3));
            int i2 = this.e;
            double d4 = i2 * 1.414d;
            if (i2 > 0) {
                for (int i3 = 0; i3 < l.b.length; i3++) {
                    double[] b2 = l.b(d3, d2, d4, l.b[i3]);
                    hashSet.add(l.b(i, b2[1], b2[0]));
                }
            }
            StringBuffer stringBuffer = new StringBuffer();
            Iterator it = hashSet.iterator();
            boolean z = true;
            while (it.hasNext()) {
                String str = (String) it.next();
                if (z) {
                    z = false;
                } else {
                    stringBuffer.append(',');
                }
                stringBuffer.append("\"").append(str).append("\"");
            }
            return String.format("SELECT * FROM %s WHERE gridkey IN (%s);", this.f, stringBuffer.toString());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String a(JSONObject jSONObject) {
            Iterator<String> keys = jSONObject.keys();
            StringBuffer stringBuffer = new StringBuffer();
            while (keys.hasNext()) {
                String next = keys.next();
                if (stringBuffer.length() != 0) {
                    stringBuffer.append(",");
                }
                stringBuffer.append("\"").append(next).append("\"");
            }
            return String.format(Locale.US, "DELETE FROM %s WHERE gridkey IN (%s)", this.f, stringBuffer);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void b(StringBuffer stringBuffer, String str, String str2, int i) {
            if (stringBuffer.length() > 0) {
                stringBuffer.append(",");
            }
            stringBuffer.append("(\"").append(str).append("\",\"").append(str2).append("\",").append(i).append(",").append(System.currentTimeMillis() / 86400000).append(")");
        }

        public static b valueOf(String str) {
            return (b) Enum.valueOf(b.class, str);
        }

        public static b[] values() {
            return (b[]) j.clone();
        }

        abstract List<String> a(JSONObject jSONObject, String str, int i);
    }

    l(h hVar, SQLiteDatabase sQLiteDatabase, int i) {
        this.a = hVar;
        this.d = sQLiteDatabase;
        this.c = i;
        if (sQLiteDatabase == null || !sQLiteDatabase.isOpen()) {
            return;
        }
        try {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS RGCAREA(gridkey VARCHAR(10) PRIMARY KEY, country VARCHAR(100),countrycode VARCHAR(100), province VARCHAR(100), city VARCHAR(100), citycode VARCHAR(100), district VARCHAR(100), timestamp INTEGER, version VARCHAR(50))");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS RGCROAD(_id INTEGER PRIMARY KEY AUTOINCREMENT, gridkey VARCHAR(10), street VARCHAR(100), x1 DOUBLE, y1 DOUBLE, x2 DOUBLE, y2 DOUBLE)");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS RGCSITE(_id INTEGER PRIMARY KEY AUTOINCREMENT, gridkey VARCHAR(10), street VARCHAR(100), streetnumber VARCHAR(100), x DOUBLE, y DOUBLE)");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS RGCPOI(pid VARCHAR(50) PRIMARY KEY , gridkey VARCHAR(10), name VARCHAR(100), type VARCHAR(50), x DOUBLE, y DOUBLE, rank INTEGER)");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS RGCUPDATE(gridkey VARCHAR(10), version VARCHAR(50), type INTEGER, timestamp INTEGER, PRIMARY KEY(gridkey, type))");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private double a(double d, double d2, double d3, double d4, double d5, double d6) {
        double d7 = d5 - d3;
        double d8 = d - d3;
        double d9 = d6 - d4;
        double d10 = d2 - d4;
        double d11 = (d7 * d8) + (d9 * d10);
        if (d11 <= 0.0d) {
            return Math.sqrt((d8 * d8) + (d10 * d10));
        }
        double d12 = (d7 * d7) + (d9 * d9);
        if (d11 >= d12) {
            double d13 = d - d5;
            double d14 = d2 - d6;
            return Math.sqrt((d13 * d13) + (d14 * d14));
        }
        double d15 = d11 / d12;
        double d16 = d - (d3 + (d7 * d15));
        double d17 = (d4 + (d9 * d15)) - d2;
        return Math.sqrt((d16 * d16) + (d17 * d17));
    }

    private static int a(int i, int i2) {
        double d;
        int i3;
        if (100 > i2) {
            d = -0.1d;
            i3 = 60000;
        } else if (500 > i2) {
            d = -0.75d;
            i3 = 55500;
        } else {
            d = -0.5d;
            i3 = 0;
        }
        return ((int) ((d * i2) + i3)) + i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String b(int i, double d, double d2) {
        double d3;
        a aVar;
        int i2 = i * 5;
        char[] cArr = new char[i + 1];
        a aVar2 = new a(90.0d, -90.0d);
        a aVar3 = new a(180.0d, -180.0d);
        int i3 = 1;
        boolean z = true;
        int i4 = 0;
        for (int i5 = 1; i5 <= i2; i5++) {
            if (z) {
                d3 = d;
                aVar = aVar3;
            } else {
                d3 = d2;
                aVar = aVar2;
            }
            double d4 = (aVar.b + aVar.a) / 2.0d;
            i4 <<= i3;
            if (((int) (d3 * 1000000.0d)) > ((int) (d4 * 1000000.0d))) {
                aVar.b = d4;
                i4 |= 1;
            } else {
                aVar.a = d4;
            }
            if (i5 % 5 == 0) {
                i3 = 1;
                cArr[(i5 / 5) - 1] = "0123456789bcdefghjkmnpqrstuvwxyz".charAt(i4);
                i4 = 0;
            } else {
                i3 = 1;
            }
            z = !z;
        }
        cArr[i] = 0;
        StringBuffer stringBuffer = new StringBuffer();
        for (int i6 = 0; i6 < i; i6++) {
            stringBuffer.append(cArr[i6]);
        }
        return stringBuffer.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static double[] b(double d, double d2, double d3, double d4) {
        double radians = Math.toRadians(d);
        double radians2 = Math.toRadians(d2);
        double radians3 = Math.toRadians(d4);
        double d5 = d3 / 6378137.0d;
        double asin = Math.asin((Math.sin(radians) * Math.cos(d5)) + (Math.cos(radians) * Math.sin(d5) * Math.cos(radians3)));
        return new double[]{Math.toDegrees(asin), Math.toDegrees(radians2 + Math.atan2(Math.sin(radians3) * Math.sin(d5) * Math.cos(radians), Math.cos(d5) - (Math.sin(radians) * Math.sin(asin))))};
    }

    private double c(double d, double d2, double d3, double d4) {
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

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:112:0x00a2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x009c A[Catch: Exception -> 0x009f, TRY_ENTER, TRY_LEAVE, TryCatch #5 {Exception -> 0x009f, blocks: (B:24:0x009c, B:173:0x007f), top: B:2:0x000f }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0176 A[Catch: all -> 0x01ce, Exception -> 0x01d0, TryCatch #11 {Exception -> 0x01d0, blocks: (B:35:0x0170, B:37:0x0176, B:39:0x017c), top: B:34:0x0170 }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01ed  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0200  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0210  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0220  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0230  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0240  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0250  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0262  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0270  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x025e  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01fd  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01c9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x01e6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r15v0 */
    /* JADX WARN: Type inference failed for: r15v1 */
    /* JADX WARN: Type inference failed for: r15v10 */
    /* JADX WARN: Type inference failed for: r15v11 */
    /* JADX WARN: Type inference failed for: r15v12 */
    /* JADX WARN: Type inference failed for: r15v15 */
    /* JADX WARN: Type inference failed for: r15v2, types: [java.lang.String[]] */
    /* JADX WARN: Type inference failed for: r15v20 */
    /* JADX WARN: Type inference failed for: r15v25 */
    /* JADX WARN: Type inference failed for: r15v26 */
    /* JADX WARN: Type inference failed for: r15v27 */
    /* JADX WARN: Type inference failed for: r1v12, types: [android.database.sqlite.SQLiteDatabase] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    com.baidu.location.Address a(double r35, double r37) {
        /*
            Method dump skipped, instructions count: 668
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.e.l.a(double, double):com.baidu.location.Address");
    }

    void a(JSONObject jSONObject) {
        SQLiteDatabase sQLiteDatabase = this.d;
        if (sQLiteDatabase == null || !sQLiteDatabase.isOpen()) {
            return;
        }
        try {
            this.d.beginTransaction();
            for (b bVar : b.values()) {
                if (jSONObject.has(bVar.g)) {
                    String string = jSONObject.has(bVar.h) ? jSONObject.getString(bVar.h) : "";
                    ArrayList arrayList = new ArrayList();
                    JSONObject jSONObject2 = jSONObject.getJSONObject(bVar.g);
                    arrayList.add(bVar.a(jSONObject2));
                    arrayList.addAll(bVar.a(jSONObject2, string, bVar.i));
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        this.d.execSQL((String) it.next());
                    }
                }
            }
            this.d.setTransactionSuccessful();
            this.e = -1;
            this.f = -1;
        } catch (Exception unused) {
        } catch (Throwable th) {
            try {
                this.d.endTransaction();
            } catch (Exception unused2) {
            }
            throw th;
        }
        try {
            this.d.endTransaction();
        } catch (Exception unused3) {
        }
    }

    boolean a() {
        SQLiteDatabase sQLiteDatabase;
        Throwable th;
        Cursor cursor;
        Cursor cursor2;
        if (this.a.l().l() && this.f == -1 && this.e == -1 && (sQLiteDatabase = this.d) != null && sQLiteDatabase.isOpen()) {
            Cursor cursor3 = null;
            try {
                try {
                    Cursor rawQuery = this.d.rawQuery("SELECT COUNT(*) FROM RGCSITE;", null);
                    try {
                        rawQuery.moveToFirst();
                        this.f = rawQuery.getInt(0);
                        cursor3 = this.d.rawQuery("SELECT COUNT(*) FROM RGCAREA;", null);
                        cursor3.moveToFirst();
                        this.e = cursor3.getInt(0);
                        if (rawQuery != null) {
                            try {
                                rawQuery.close();
                            } catch (Exception unused) {
                            }
                        }
                    } catch (Exception unused2) {
                        cursor2 = cursor3;
                        cursor3 = rawQuery;
                        if (cursor3 != null) {
                            try {
                                cursor3.close();
                            } catch (Exception unused3) {
                            }
                        }
                        if (cursor2 != null) {
                            cursor2.close();
                        }
                        if (this.f != 0) {
                        }
                    } catch (Throwable th2) {
                        cursor = cursor3;
                        cursor3 = rawQuery;
                        th = th2;
                        if (cursor3 != null) {
                            try {
                                cursor3.close();
                            } catch (Exception unused4) {
                            }
                        }
                        if (cursor == null) {
                            throw th;
                        }
                        try {
                            cursor.close();
                            throw th;
                        } catch (Exception unused5) {
                            throw th;
                        }
                    }
                } catch (Exception unused6) {
                    cursor2 = null;
                } catch (Throwable th3) {
                    th = th3;
                    cursor = null;
                }
                if (cursor3 != null) {
                    cursor3.close();
                }
            } catch (Exception unused7) {
            }
        }
        return this.f != 0 && this.e == 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00b3  */
    /* JADX WARN: Type inference failed for: r3v6, types: [com.baidu.location.Poi] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    java.util.List<com.baidu.location.Poi> b(double r26, double r28) {
        /*
            r25 = this;
            r10 = r25
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            com.baidu.location.e.l$b r1 = com.baidu.location.e.l.b.d
            int r2 = r10.c
            r3 = r26
            r5 = r28
            java.lang.String r1 = com.baidu.location.e.l.b.a(r1, r2, r3, r5)
            r2 = 0
            android.database.sqlite.SQLiteDatabase r3 = r10.d     // Catch: java.lang.Throwable -> La3 java.lang.Exception -> Laa
            android.database.Cursor r11 = r3.rawQuery(r1, r2)     // Catch: java.lang.Throwable -> La3 java.lang.Exception -> Laa
            boolean r1 = r11.moveToFirst()     // Catch: java.lang.Throwable -> L9d java.lang.Exception -> La0
            if (r1 == 0) goto L97
            r12 = 0
            r13 = r2
            r14 = r12
        L23:
            boolean r1 = r11.isAfterLast()     // Catch: java.lang.Throwable -> L9d java.lang.Exception -> La1
            if (r1 != 0) goto L96
            java.lang.String r15 = r11.getString(r12)     // Catch: java.lang.Throwable -> L9d java.lang.Exception -> La1
            r1 = 2
            java.lang.String r16 = r11.getString(r1)     // Catch: java.lang.Throwable -> L9d java.lang.Exception -> La1
            r1 = 4
            double r8 = r11.getDouble(r1)     // Catch: java.lang.Throwable -> L9d java.lang.Exception -> La1
            r1 = 5
            double r6 = r11.getDouble(r1)     // Catch: java.lang.Throwable -> L9d java.lang.Exception -> La1
            r1 = 6
            int r4 = r11.getInt(r1)     // Catch: java.lang.Throwable -> L9d java.lang.Exception -> La1
            r1 = r25
            r2 = r28
            r17 = r4
            r4 = r26
            double r1 = r1.c(r2, r4, r6, r8)     // Catch: java.lang.Throwable -> L9d java.lang.Exception -> La1
            com.baidu.location.e.l$b r3 = com.baidu.location.e.l.b.d     // Catch: java.lang.Throwable -> L9d java.lang.Exception -> La1
            int r3 = com.baidu.location.e.l.b.d(r3)     // Catch: java.lang.Throwable -> L9d java.lang.Exception -> La1
            double r3 = (double) r3     // Catch: java.lang.Throwable -> L9d java.lang.Exception -> La1
            int r3 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r3 >= 0) goto L92
            com.baidu.location.Poi r3 = new com.baidu.location.Poi     // Catch: java.lang.Throwable -> L9d java.lang.Exception -> La1
            java.lang.String r4 = new java.lang.String     // Catch: java.lang.Throwable -> L9d java.lang.Exception -> La1
            byte[] r5 = r15.getBytes()     // Catch: java.lang.Throwable -> L9d java.lang.Exception -> La1
            byte[] r5 = android.util.Base64.decode(r5, r12)     // Catch: java.lang.Throwable -> L9d java.lang.Exception -> La1
            r4.<init>(r5)     // Catch: java.lang.Throwable -> L9d java.lang.Exception -> La1
            java.lang.String r5 = new java.lang.String     // Catch: java.lang.Throwable -> L9d java.lang.Exception -> La1
            byte[] r6 = r16.getBytes()     // Catch: java.lang.Throwable -> L9d java.lang.Exception -> La1
            byte[] r6 = android.util.Base64.decode(r6, r12)     // Catch: java.lang.Throwable -> L9d java.lang.Exception -> La1
            r5.<init>(r6)     // Catch: java.lang.Throwable -> L9d java.lang.Exception -> La1
            r21 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            java.lang.String r23 = ""
            java.lang.String r24 = ""
            r18 = r3
            r19 = r4
            r20 = r5
            r18.<init>(r19, r20, r21, r23, r24)     // Catch: java.lang.Throwable -> L9d java.lang.Exception -> La1
            float r1 = (float) r1     // Catch: java.lang.Throwable -> L9d java.lang.Exception -> La1
            int r1 = java.lang.Math.round(r1)     // Catch: java.lang.Throwable -> L9d java.lang.Exception -> La1
            r2 = r17
            int r1 = a(r2, r1)     // Catch: java.lang.Throwable -> L9d java.lang.Exception -> La1
            if (r1 <= r14) goto L92
            r14 = r1
            r13 = r3
        L92:
            r11.moveToNext()     // Catch: java.lang.Throwable -> L9d java.lang.Exception -> La1
            goto L23
        L96:
            r2 = r13
        L97:
            if (r11 == 0) goto Lb1
            r11.close()     // Catch: java.lang.Exception -> Lb1
            goto Lb1
        L9d:
            r0 = move-exception
            r2 = r11
            goto La4
        La0:
            r13 = r2
        La1:
            r2 = r11
            goto Lab
        La3:
            r0 = move-exception
        La4:
            if (r2 == 0) goto La9
            r2.close()     // Catch: java.lang.Exception -> La9
        La9:
            throw r0
        Laa:
            r13 = r2
        Lab:
            if (r2 == 0) goto Lb0
            r2.close()     // Catch: java.lang.Exception -> Lb0
        Lb0:
            r2 = r13
        Lb1:
            if (r2 == 0) goto Lb6
            r0.add(r2)
        Lb6:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.e.l.b(double, double):java.util.List");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(16:0|1|(3:2|3|4)|(3:70|71|(26:73|74|75|76|77|78|(5:80|(7:83|84|85|86|(2:88|89)(1:91)|90|81)|93|94|(2:96|97))(1:132)|98|99|(6:101|(4:104|(2:106|107)(1:109)|108|102)|110|111|(2:113|114)|115)|116|117|(1:119)|121|(3:123|124|125)(1:129)|126|7|8|9|(5:11|12|13|14|(1:16))(1:66)|17|(2:19|(1:21))|(2:36|37)|(2:25|26)|28|(1:34)(1:32)))|6|7|8|9|(0)(0)|17|(0)|(0)|(0)|28|(2:30|34)(1:35)|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x01f6, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Removed duplicated region for block: B:11:0x01a2 A[Catch: all -> 0x01f6, Exception -> 0x01fb, TRY_ENTER, TRY_LEAVE, TryCatch #15 {Exception -> 0x01fb, all -> 0x01f6, blocks: (B:8:0x019a, B:11:0x01a2), top: B:7:0x019a }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x01cb A[Catch: all -> 0x01f4, Exception -> 0x01fd, TryCatch #16 {Exception -> 0x01fd, all -> 0x01f4, blocks: (B:14:0x01bb, B:16:0x01bf, B:17:0x01c5, B:19:0x01cb, B:21:0x01e6), top: B:13:0x01bb }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x01f0 A[Catch: Exception -> 0x021c, TRY_ENTER, TRY_LEAVE, TryCatch #13 {Exception -> 0x021c, blocks: (B:45:0x0219, B:25:0x01f0), top: B:2:0x0020 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0222  */
    /* JADX WARN: Removed duplicated region for block: B:35:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x01eb A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0219 A[Catch: Exception -> 0x021c, TRY_ENTER, TRY_LEAVE, TryCatch #13 {Exception -> 0x021c, blocks: (B:45:0x0219, B:25:0x01f0), top: B:2:0x0020 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0214 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x020b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:60:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0206 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01c3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    org.json.JSONObject b() {
        /*
            Method dump skipped, instructions count: 554
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.e.l.b():org.json.JSONObject");
    }
}
