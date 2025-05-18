package com.baidu.location.p006b;

import com.baidu.location.p012h.C0732n;
import com.baidu.location.p012h.C0733o;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import net.lingala.zip4j.util.InternalZipConstants;

/* renamed from: com.baidu.location.b.k */
/* loaded from: classes.dex */
public class C0657k {

    /* renamed from: a */
    private static C0657k f548a = null;

    /* renamed from: b */
    private static String f549b = "Temp_in.dat";

    /* renamed from: c */
    private static File f550c = new File(C0732n.f1312a, f549b);

    /* renamed from: d */
    private static StringBuffer f551d = null;

    /* renamed from: e */
    private static boolean f552e = true;

    /* renamed from: f */
    private static int f553f = 0;

    /* renamed from: g */
    private static int f554g = 0;

    /* renamed from: h */
    private static long f555h = 0;

    /* renamed from: i */
    private static long f556i = 0;

    /* renamed from: j */
    private static long f557j = 0;

    /* renamed from: k */
    private static double f558k = 0.0d;

    /* renamed from: l */
    private static double f559l = 0.0d;

    /* renamed from: m */
    private static int f560m = 0;

    /* renamed from: n */
    private static int f561n = 0;

    /* renamed from: o */
    private static int f562o = 0;

    /* renamed from: a */
    public static String m441a() {
        RandomAccessFile randomAccessFile;
        int readInt;
        int readInt2;
        int readInt3;
        int i;
        File file = f550c;
        if (file == null || !file.exists()) {
            return null;
        }
        try {
            randomAccessFile = new RandomAccessFile(f550c, InternalZipConstants.WRITE_MODE);
            randomAccessFile.seek(0L);
            readInt = randomAccessFile.readInt();
            readInt2 = randomAccessFile.readInt();
            readInt3 = randomAccessFile.readInt();
        } catch (IOException unused) {
        }
        if (!m442a(readInt, readInt2, readInt3)) {
            randomAccessFile.close();
            m444c();
            return null;
        }
        if (readInt2 != 0 && readInt2 != readInt3) {
            long j = ((readInt2 - 1) * 1024) + 12 + 0;
            randomAccessFile.seek(j);
            int readInt4 = randomAccessFile.readInt();
            byte[] bArr = new byte[readInt4];
            randomAccessFile.seek(j + 4);
            for (int i2 = 0; i2 < readInt4; i2++) {
                bArr[i2] = randomAccessFile.readByte();
            }
            String str = new String(bArr);
            int i3 = 1;
            if (readInt < C0733o.f1364ae) {
                i = readInt2 + 1;
            } else {
                if (readInt2 != C0733o.f1364ae) {
                    i3 = 1 + readInt2;
                }
                i = i3;
            }
            randomAccessFile.seek(4L);
            randomAccessFile.writeInt(i);
            randomAccessFile.close();
            return str;
        }
        randomAccessFile.close();
        return null;
    }

    /* renamed from: a */
    private static boolean m442a(int i, int i2, int i3) {
        int i4;
        return i >= 0 && i <= C0733o.f1364ae && i2 >= 0 && i2 <= (i4 = i + 1) && i3 >= 1 && i3 <= i4 && i3 <= C0733o.f1364ae;
    }

    /* renamed from: b */
    private static void m443b() {
        f552e = true;
        f551d = null;
        f553f = 0;
        f554g = 0;
        f555h = 0L;
        f556i = 0L;
        f557j = 0L;
        f558k = 0.0d;
        f559l = 0.0d;
        f560m = 0;
        f561n = 0;
        f562o = 0;
    }

    /* renamed from: c */
    private static boolean m444c() {
        if (f550c.exists()) {
            f550c.delete();
        }
        if (!f550c.getParentFile().exists()) {
            f550c.getParentFile().mkdirs();
        }
        try {
            f550c.createNewFile();
            RandomAccessFile randomAccessFile = new RandomAccessFile(f550c, InternalZipConstants.WRITE_MODE);
            randomAccessFile.seek(0L);
            randomAccessFile.writeInt(0);
            randomAccessFile.writeInt(0);
            randomAccessFile.writeInt(1);
            randomAccessFile.close();
            m443b();
            return f550c.exists();
        } catch (IOException unused) {
            return false;
        }
    }
}