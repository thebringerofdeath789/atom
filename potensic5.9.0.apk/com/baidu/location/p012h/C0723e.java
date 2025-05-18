package com.baidu.location.p012h;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import net.lingala.zip4j.util.InternalZipConstants;

/* renamed from: com.baidu.location.h.e */
/* loaded from: classes.dex */
public class C0723e {

    /* renamed from: c */
    static C0723e f1266c;

    /* renamed from: a */
    String f1267a = "firll.dat";

    /* renamed from: b */
    int f1268b = 3164;

    /* renamed from: d */
    int f1269d = 0;

    /* renamed from: e */
    int f1270e = 20;

    /* renamed from: f */
    int f1271f = 40;

    /* renamed from: g */
    int f1272g = 60;

    /* renamed from: h */
    int f1273h = 80;

    /* renamed from: i */
    int f1274i = 100;

    /* renamed from: a */
    private long m1116a(int i) {
        RandomAccessFile randomAccessFile;
        int readInt;
        long readLong;
        String m1166g = C0733o.m1166g();
        if (m1166g == null) {
            return -1L;
        }
        RandomAccessFile randomAccessFile2 = null;
        try {
            try {
                randomAccessFile = new RandomAccessFile(m1166g + File.separator + this.f1267a, InternalZipConstants.WRITE_MODE);
                try {
                    randomAccessFile.seek(i);
                    readInt = randomAccessFile.readInt();
                    readLong = randomAccessFile.readLong();
                } catch (Exception unused) {
                    randomAccessFile2 = randomAccessFile;
                    if (randomAccessFile2 != null) {
                        randomAccessFile2.close();
                    }
                    return -1L;
                } catch (Throwable th) {
                    th = th;
                    randomAccessFile2 = randomAccessFile;
                    if (randomAccessFile2 != null) {
                        try {
                            randomAccessFile2.close();
                        } catch (IOException unused2) {
                        }
                    }
                    throw th;
                }
            } catch (Exception unused3) {
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException unused4) {
        }
        if (readInt == randomAccessFile.readInt()) {
            try {
                randomAccessFile.close();
            } catch (IOException unused5) {
            }
            return readLong;
        }
        randomAccessFile.close();
        return -1L;
    }

    /* renamed from: a */
    public static C0723e m1117a() {
        if (f1266c == null) {
            f1266c = new C0723e();
        }
        return f1266c;
    }

    /* renamed from: a */
    private void m1118a(int i, long j) {
        String m1166g = C0733o.m1166g();
        if (m1166g == null) {
            return;
        }
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(m1166g + File.separator + this.f1267a, InternalZipConstants.WRITE_MODE);
            randomAccessFile.seek(i);
            randomAccessFile.writeInt(this.f1268b);
            randomAccessFile.writeLong(j);
            randomAccessFile.writeInt(this.f1268b);
            randomAccessFile.close();
        } catch (Exception unused) {
        }
    }

    /* renamed from: a */
    public void m1119a(long j) {
        m1118a(this.f1270e, j);
    }

    /* renamed from: b */
    public long m1120b() {
        return m1116a(this.f1270e);
    }

    /* renamed from: b */
    public void m1121b(long j) {
        m1118a(this.f1272g, j);
    }

    /* renamed from: c */
    public long m1122c() {
        return m1116a(this.f1272g);
    }
}