package com.baidu.location.h;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import net.lingala.zip4j.util.InternalZipConstants;

/* loaded from: classes.dex */
public class e {
    static e c;
    String a = "firll.dat";
    int b = 3164;
    int d = 0;
    int e = 20;
    int f = 40;
    int g = 60;
    int h = 80;
    int i = 100;

    private long a(int i) {
        RandomAccessFile randomAccessFile;
        int readInt;
        long readLong;
        String g = o.g();
        if (g == null) {
            return -1L;
        }
        RandomAccessFile randomAccessFile2 = null;
        try {
            try {
                randomAccessFile = new RandomAccessFile(g + File.separator + this.a, InternalZipConstants.WRITE_MODE);
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

    public static e a() {
        if (c == null) {
            c = new e();
        }
        return c;
    }

    private void a(int i, long j) {
        String g = o.g();
        if (g == null) {
            return;
        }
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(g + File.separator + this.a, InternalZipConstants.WRITE_MODE);
            randomAccessFile.seek(i);
            randomAccessFile.writeInt(this.b);
            randomAccessFile.writeLong(j);
            randomAccessFile.writeInt(this.b);
            randomAccessFile.close();
        } catch (Exception unused) {
        }
    }

    public void a(long j) {
        a(this.e, j);
    }

    public long b() {
        return a(this.e);
    }

    public void b(long j) {
        a(this.g, j);
    }

    public long c() {
        return a(this.g);
    }
}
