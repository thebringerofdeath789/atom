package com.baidu.location.p007c;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Base64;
import com.baidu.location.BDLocation;
import com.baidu.location.Jni;
import com.baidu.location.p006b.C0670x;
import com.baidu.location.p012h.AbstractC0725g;
import com.baidu.location.p012h.C0720b;
import com.baidu.location.p012h.C0733o;
import java.io.File;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* renamed from: com.baidu.location.c.a */
/* loaded from: classes.dex */
public class C0674a {

    /* renamed from: c */
    private static C0674a f764c;

    /* renamed from: b */
    private static Object f763b = new Object();

    /* renamed from: d */
    private static final String f765d = C0733o.m1166g() + "/gal.db";

    /* renamed from: f */
    private static Lock f766f = new ReentrantLock();

    /* renamed from: e */
    private SQLiteDatabase f768e = null;

    /* renamed from: g */
    private boolean f769g = false;

    /* renamed from: a */
    a f767a = null;

    /* renamed from: h */
    private Map<String, Integer> f770h = new HashMap();

    /* renamed from: i */
    private String f771i = null;

    /* renamed from: j */
    private int f772j = -1;

    /* renamed from: k */
    private String f773k = null;

    /* renamed from: l */
    private double f774l = Double.MAX_VALUE;

    /* renamed from: m */
    private double f775m = Double.MAX_VALUE;

    /* renamed from: com.baidu.location.c.a$a */
    class a extends AbstractC0725g {

        /* renamed from: a */
        int f776a;

        /* renamed from: b */
        int f777b;

        /* renamed from: c */
        int f778c;

        /* renamed from: d */
        int f779d;

        /* renamed from: e */
        double f780e;

        a() {
            this.f1292k = new HashMap();
        }

        /* renamed from: a */
        public void m632a(double d, double d2, double d3) {
            if (C0674a.this.f769g) {
                return;
            }
            double[] coorEncrypt = Jni.coorEncrypt(d, d2, "gcj2wgs");
            this.f776a = (int) Math.floor(coorEncrypt[0] * 100.0d);
            this.f777b = (int) Math.floor(coorEncrypt[1] * 100.0d);
            this.f778c = (int) Math.floor(d * 100.0d);
            this.f779d = (int) Math.floor(d2 * 100.0d);
            this.f780e = d3;
            C0674a.this.f769g = true;
            if (C0733o.m1152b()) {
                return;
            }
            ExecutorService m592c = C0670x.m590a().m592c();
            if (m592c != null) {
                m1129a(m592c, "https://loc.map.baidu.com/gpsz");
            } else {
                m1133e("https://loc.map.baidu.com/gpsz");
            }
        }

        /* JADX WARN: Can't wrap try/catch for region: R(9:18|19|(1:21)(2:33|(1:35)(7:36|(1:38)(1:39)|23|24|25|(2:27|28)(1:30)|29))|22|23|24|25|(0)(0)|29) */
        /* JADX WARN: Removed duplicated region for block: B:27:0x012f A[Catch: Exception -> 0x013b, TRY_LEAVE, TryCatch #0 {Exception -> 0x013b, blocks: (B:25:0x010d, B:27:0x012f), top: B:24:0x010d }] */
        /* JADX WARN: Removed duplicated region for block: B:30:0x013b A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:47:0x0175 A[Catch: Exception -> 0x0241, TryCatch #3 {Exception -> 0x0241, blocks: (B:7:0x0019, B:10:0x0035, B:12:0x003f, B:14:0x0054, B:18:0x0068, B:21:0x008b, B:22:0x0096, B:23:0x00e0, B:33:0x009e, B:35:0x00a6, B:36:0x00b4, B:38:0x00c2, B:39:0x00d2, B:45:0x016f, B:47:0x0175, B:49:0x0181, B:51:0x0194, B:55:0x01a6, B:59:0x01bc, B:60:0x01c0, B:61:0x01d3, B:77:0x01c4), top: B:6:0x0019 }] */
        @Override // com.baidu.location.p012h.AbstractC0725g
        /* renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void mo122a(boolean r30) {
            /*
                Method dump skipped, instructions count: 600
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.p007c.C0674a.a.mo122a(boolean):void");
        }

        @Override // com.baidu.location.p012h.AbstractC0725g
        /* renamed from: b */
        public void mo123b() {
            Map<String, Object> map;
            String str;
            this.f1289h = "https://loc.map.baidu.com/gpsz";
            String format = String.format(Locale.CHINESE, "&is_vdr=1&x=%d&y=%d%s", Integer.valueOf(this.f776a), Integer.valueOf(this.f777b), C0720b.m1100a().m1106c());
            String encode = Jni.encode(format);
            if (encode.contains("err!")) {
                try {
                    encode = new String(Base64.encode(format.getBytes(), 0), "UTF-8");
                } catch (Exception unused) {
                    encode = "err2!";
                }
                map = this.f1292k;
                str = "gpszb";
            } else {
                map = this.f1292k;
                str = "gpsz";
            }
            map.put(str, encode);
        }
    }

    /* renamed from: a */
    public static C0674a m623a() {
        C0674a c0674a;
        synchronized (f763b) {
            if (f764c == null) {
                f764c = new C0674a();
            }
            c0674a = f764c;
        }
        return c0674a;
    }

    /* renamed from: a */
    private void m624a(double d, double d2, double d3) {
        if (this.f767a == null) {
            this.f767a = new a();
        }
        this.f767a.m632a(d, d2, d3);
    }

    /* renamed from: a */
    public int m628a(BDLocation bDLocation) {
        double d;
        float f;
        if (bDLocation != null) {
            f = bDLocation.getRadius();
            d = bDLocation.getAltitude();
        } else {
            d = 0.0d;
            f = 0.0f;
        }
        if (this.f768e == null || f <= 0.0f || d <= 0.0d || bDLocation == null) {
            return 0;
        }
        double d2 = m629a(bDLocation.getLongitude(), bDLocation.getLatitude())[0];
        if (d2 == Double.MAX_VALUE) {
            return 0;
        }
        double gpsSwiftRadius = Jni.getGpsSwiftRadius(f, d, d2);
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
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public double[] m629a(double r20, double r22) {
        /*
            Method dump skipped, instructions count: 320
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.p007c.C0674a.m629a(double, double):double[]");
    }

    /* renamed from: b */
    public void m630b() {
        try {
            File file = new File(f765d);
            if (!file.exists()) {
                file.createNewFile();
            }
            if (file.exists()) {
                SQLiteDatabase openOrCreateDatabase = SQLiteDatabase.openOrCreateDatabase(file, (SQLiteDatabase.CursorFactory) null);
                this.f768e = openOrCreateDatabase;
                Cursor rawQuery = openOrCreateDatabase.rawQuery("SELECT count(*) FROM sqlite_master WHERE type='table' AND name='galdata'", null);
                if (rawQuery.moveToFirst()) {
                    if (rawQuery.getInt(0) == 0) {
                        this.f768e.execSQL("CREATE TABLE IF NOT EXISTS galdata_new(id CHAR(40) PRIMARY KEY,aldata DOUBLE, sigma DOUBLE,tt INT);");
                    } else {
                        this.f768e.execSQL("DROP TABLE galdata");
                        this.f768e.execSQL("CREATE TABLE galdata_new(id CHAR(40) PRIMARY KEY,aldata DOUBLE, sigma DOUBLE,tt INT);");
                    }
                    this.f768e.execSQL("CREATE TABLE IF NOT EXISTS locStateData(id CHAR(40) PRIMARY KEY,state INT);");
                }
                this.f768e.setVersion(1);
                rawQuery.close();
            }
        } catch (Exception unused) {
            this.f768e = null;
        }
    }

    /* renamed from: c */
    public void m631c() {
        SQLiteDatabase sQLiteDatabase = this.f768e;
        if (sQLiteDatabase != null) {
            try {
                sQLiteDatabase.close();
            } catch (Exception unused) {
            } catch (Throwable th) {
                this.f768e = null;
                throw th;
            }
            this.f768e = null;
        }
    }
}