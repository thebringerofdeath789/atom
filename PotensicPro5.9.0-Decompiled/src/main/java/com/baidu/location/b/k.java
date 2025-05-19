package com.baidu.location.b;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import net.lingala.zip4j.util.InternalZipConstants;

/* loaded from: classes.dex */
public class k {
    private static k a = null;
    private static String b = "Temp_in.dat";
    private static File c = new File(com.baidu.location.h.n.a, b);
    private static StringBuffer d = null;
    private static boolean e = true;
    private static int f = 0;
    private static int g = 0;
    private static long h = 0;
    private static long i = 0;
    private static long j = 0;
    private static double k = 0.0d;
    private static double l = 0.0d;
    private static int m = 0;
    private static int n = 0;
    private static int o = 0;

    public static String a() {
        RandomAccessFile randomAccessFile;
        int readInt;
        int readInt2;
        int readInt3;
        int i2;
        File file = c;
        if (file == null || !file.exists()) {
            return null;
        }
        try {
            randomAccessFile = new RandomAccessFile(c, InternalZipConstants.WRITE_MODE);
            randomAccessFile.seek(0L);
            readInt = randomAccessFile.readInt();
            readInt2 = randomAccessFile.readInt();
            readInt3 = randomAccessFile.readInt();
        } catch (IOException unused) {
        }
        if (!a(readInt, readInt2, readInt3)) {
            randomAccessFile.close();
            c();
            return null;
        }
        if (readInt2 != 0 && readInt2 != readInt3) {
            long j2 = ((readInt2 - 1) * 1024) + 12 + 0;
            randomAccessFile.seek(j2);
            int readInt4 = randomAccessFile.readInt();
            byte[] bArr = new byte[readInt4];
            randomAccessFile.seek(j2 + 4);
            for (int i3 = 0; i3 < readInt4; i3++) {
                bArr[i3] = randomAccessFile.readByte();
            }
            String str = new String(bArr);
            int i4 = 1;
            if (readInt < com.baidu.location.h.o.ae) {
                i2 = readInt2 + 1;
            } else {
                if (readInt2 != com.baidu.location.h.o.ae) {
                    i4 = 1 + readInt2;
                }
                i2 = i4;
            }
            randomAccessFile.seek(4L);
            randomAccessFile.writeInt(i2);
            randomAccessFile.close();
            return str;
        }
        randomAccessFile.close();
        return null;
    }

    private static boolean a(int i2, int i3, int i4) {
        int i5;
        return i2 >= 0 && i2 <= com.baidu.location.h.o.ae && i3 >= 0 && i3 <= (i5 = i2 + 1) && i4 >= 1 && i4 <= i5 && i4 <= com.baidu.location.h.o.ae;
    }

    private static void b() {
        e = true;
        d = null;
        f = 0;
        g = 0;
        h = 0L;
        i = 0L;
        j = 0L;
        k = 0.0d;
        l = 0.0d;
        m = 0;
        n = 0;
        o = 0;
    }

    private static boolean c() {
        if (c.exists()) {
            c.delete();
        }
        if (!c.getParentFile().exists()) {
            c.getParentFile().mkdirs();
        }
        try {
            c.createNewFile();
            RandomAccessFile randomAccessFile = new RandomAccessFile(c, InternalZipConstants.WRITE_MODE);
            randomAccessFile.seek(0L);
            randomAccessFile.writeInt(0);
            randomAccessFile.writeInt(0);
            randomAccessFile.writeInt(1);
            randomAccessFile.close();
            b();
            return c.exists();
        } catch (IOException unused) {
            return false;
        }
    }
}
