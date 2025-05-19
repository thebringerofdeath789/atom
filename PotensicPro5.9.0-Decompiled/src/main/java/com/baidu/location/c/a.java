package com.baidu.location.c;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Base64;
import com.baidu.location.BDLocation;
import com.baidu.location.Jni;
import com.baidu.location.b.x;
import com.baidu.location.h.o;
import java.io.File;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes.dex */
public class a {
    private static a c;
    private static Object b = new Object();
    private static final String d = o.g() + "/gal.db";
    private static Lock f = new ReentrantLock();
    private SQLiteDatabase e = null;
    private boolean g = false;
    C0007a a = null;
    private Map<String, Integer> h = new HashMap();
    private String i = null;
    private int j = -1;
    private String k = null;
    private double l = Double.MAX_VALUE;
    private double m = Double.MAX_VALUE;

    /* renamed from: com.baidu.location.c.a$a, reason: collision with other inner class name */
    class C0007a extends com.baidu.location.h.g {
        int a;
        int b;
        int c;
        int d;
        double e;

        C0007a() {
            this.k = new HashMap();
        }

        public void a(double d, double d2, double d3) {
            if (a.this.g) {
                return;
            }
            double[] coorEncrypt = Jni.coorEncrypt(d, d2, "gcj2wgs");
            this.a = (int) Math.floor(coorEncrypt[0] * 100.0d);
            this.b = (int) Math.floor(coorEncrypt[1] * 100.0d);
            this.c = (int) Math.floor(d * 100.0d);
            this.d = (int) Math.floor(d2 * 100.0d);
            this.e = d3;
            a.this.g = true;
            if (o.b()) {
                return;
            }
            ExecutorService c = x.a().c();
            if (c != null) {
                a(c, "https://loc.map.baidu.com/gpsz");
            } else {
                e("https://loc.map.baidu.com/gpsz");
            }
        }

        /* JADX WARN: Can't wrap try/catch for region: R(9:18|19|(1:21)(2:33|(1:35)(7:36|(1:38)(1:39)|23|24|25|(2:27|28)(1:30)|29))|22|23|24|25|(0)(0)|29) */
        /* JADX WARN: Removed duplicated region for block: B:27:0x012f A[Catch: Exception -> 0x013b, TRY_LEAVE, TryCatch #0 {Exception -> 0x013b, blocks: (B:25:0x010d, B:27:0x012f), top: B:24:0x010d }] */
        /* JADX WARN: Removed duplicated region for block: B:30:0x013b A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:47:0x0175 A[Catch: Exception -> 0x0241, TryCatch #3 {Exception -> 0x0241, blocks: (B:7:0x0019, B:10:0x0035, B:12:0x003f, B:14:0x0054, B:18:0x0068, B:21:0x008b, B:22:0x0096, B:23:0x00e0, B:33:0x009e, B:35:0x00a6, B:36:0x00b4, B:38:0x00c2, B:39:0x00d2, B:45:0x016f, B:47:0x0175, B:49:0x0181, B:51:0x0194, B:55:0x01a6, B:59:0x01bc, B:60:0x01c0, B:61:0x01d3, B:77:0x01c4), top: B:6:0x0019 }] */
        @Override // com.baidu.location.h.g
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void a(boolean r30) {
            /*
                Method dump skipped, instructions count: 600
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.c.a.C0007a.a(boolean):void");
        }

        @Override // com.baidu.location.h.g
        public void b() {
            Map<String, Object> map;
            String str;
            this.h = "https://loc.map.baidu.com/gpsz";
            String format = String.format(Locale.CHINESE, "&is_vdr=1&x=%d&y=%d%s", Integer.valueOf(this.a), Integer.valueOf(this.b), com.baidu.location.h.b.a().c());
            String encode = Jni.encode(format);
            if (encode.contains("err!")) {
                try {
                    encode = new String(Base64.encode(format.getBytes(), 0), "UTF-8");
                } catch (Exception unused) {
                    encode = "err2!";
                }
                map = this.k;
                str = "gpszb";
            } else {
                map = this.k;
                str = "gpsz";
            }
            map.put(str, encode);
        }
    }

    public static a a() {
        a aVar;
        synchronized (b) {
            if (c == null) {
                c = new a();
            }
            aVar = c;
        }
        return aVar;
    }

    private void a(double d2, double d3, double d4) {
        if (this.a == null) {
            this.a = new C0007a();
        }
        this.a.a(d2, d3, d4);
    }

    public int a(BDLocation bDLocation) {
        double d2;
        float f2;
        if (bDLocation != null) {
            f2 = bDLocation.getRadius();
            d2 = bDLocation.getAltitude();
        } else {
            d2 = 0.0d;
            f2 = 0.0f;
        }
        if (this.e == null || f2 <= 0.0f || d2 <= 0.0d || bDLocation == null) {
            return 0;
        }
        double d3 = a(bDLocation.getLongitude(), bDLocation.getLatitude())[0];
        if (d3 == Double.MAX_VALUE) {
            return 0;
        }
        double gpsSwiftRadius = Jni.getGpsSwiftRadius(f2, d2, d3);
        if (gpsSwiftRadius > 50.0d) {
            return 3;
        }
        return gpsSwiftRadius > 20.0d ? 2 : 1;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(12:22|23|24|25|(3:50|51|(17:53|55|56|57|58|59|60|(1:62)|63|(1:65)|66|67|(1:79)(3:71|72|73)|74|75|(2:37|38)|35))|27|28|29|(1:31)|33|(0)|35) */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0119, code lost:
    
        r1.close();
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0103 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0119 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public double[] a(double r20, double r22) {
        /*
            Method dump skipped, instructions count: 320
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.c.a.a(double, double):double[]");
    }

    public void b() {
        try {
            File file = new File(d);
            if (!file.exists()) {
                file.createNewFile();
            }
            if (file.exists()) {
                SQLiteDatabase openOrCreateDatabase = SQLiteDatabase.openOrCreateDatabase(file, (SQLiteDatabase.CursorFactory) null);
                this.e = openOrCreateDatabase;
                Cursor rawQuery = openOrCreateDatabase.rawQuery("SELECT count(*) FROM sqlite_master WHERE type='table' AND name='galdata'", null);
                if (rawQuery.moveToFirst()) {
                    if (rawQuery.getInt(0) == 0) {
                        this.e.execSQL("CREATE TABLE IF NOT EXISTS galdata_new(id CHAR(40) PRIMARY KEY,aldata DOUBLE, sigma DOUBLE,tt INT);");
                    } else {
                        this.e.execSQL("DROP TABLE galdata");
                        this.e.execSQL("CREATE TABLE galdata_new(id CHAR(40) PRIMARY KEY,aldata DOUBLE, sigma DOUBLE,tt INT);");
                    }
                    this.e.execSQL("CREATE TABLE IF NOT EXISTS locStateData(id CHAR(40) PRIMARY KEY,state INT);");
                }
                this.e.setVersion(1);
                rawQuery.close();
            }
        } catch (Exception unused) {
            this.e = null;
        }
    }

    public void c() {
        SQLiteDatabase sQLiteDatabase = this.e;
        if (sQLiteDatabase != null) {
            try {
                sQLiteDatabase.close();
            } catch (Exception unused) {
            } catch (Throwable th) {
                this.e = null;
                throw th;
            }
            this.e = null;
        }
    }
}
