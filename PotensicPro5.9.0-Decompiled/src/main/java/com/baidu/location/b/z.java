package com.baidu.location.b;

import android.location.Location;
import android.os.Build;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import net.lingala.zip4j.util.InternalZipConstants;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class z {
    private int B;
    long a = 0;
    private a z;
    private static ArrayList<String> b = new ArrayList<>();
    private static ArrayList<String> c = new ArrayList<>();
    private static ArrayList<String> d = new ArrayList<>();
    private static String e = com.baidu.location.h.n.a + "/yo.dat";
    private static String f = com.baidu.location.h.n.a + "/yoh.dat";
    private static String g = com.baidu.location.h.n.a + "/yom.dat";
    private static String h = com.baidu.location.h.n.a + "/yol.dat";
    private static String i = com.baidu.location.h.n.a + "/yor.dat";
    private static File j = null;
    private static int k = 8;
    private static int l = 8;
    private static int m = 16;
    private static int n = 2048;
    private static double o = 0.0d;
    private static double p = 0.1d;
    private static double q = 30.0d;
    private static double r = 100.0d;
    private static int s = 0;
    private static int t = 64;
    private static int u = 128;
    private static Location v = null;
    private static Location w = null;
    private static Location x = null;
    private static com.baidu.location.f.l y = null;
    private static z A = null;
    private static long C = 0;

    private class a extends com.baidu.location.h.g {
        boolean a = false;
        int b = 0;
        int c = 0;
        private ArrayList<String> e = new ArrayList<>();
        private boolean f = true;

        public a() {
            this.k = new HashMap();
        }

        public synchronized void a() {
            ExecutorService c;
            String str;
            String str2;
            if (this.a) {
                return;
            }
            if (q > 4 && this.c < q) {
                this.c++;
                return;
            }
            this.c = 0;
            this.a = true;
            this.b = 0;
            try {
                ArrayList<String> arrayList = this.e;
                if (arrayList == null || arrayList.size() < 1) {
                    if (this.e == null) {
                        this.e = new ArrayList<>();
                    }
                    this.b = 0;
                    int i = 0;
                    while (true) {
                        String str3 = null;
                        String b = this.b < 2 ? z.b() : null;
                        if (b == null && this.b != 1 && this.f) {
                            this.b = 2;
                            try {
                                str3 = k.a();
                            } catch (Exception unused) {
                            }
                        } else {
                            this.b = 1;
                            str3 = b;
                        }
                        if (str3 == null) {
                            break;
                        }
                        if (!str3.contains("err!")) {
                            this.e.add(str3);
                            i += str3.length();
                            if (i >= com.baidu.location.h.a.h) {
                                break;
                            }
                        }
                    }
                }
                ArrayList<String> arrayList2 = this.e;
                if (arrayList2 == null || arrayList2.size() < 1) {
                    ArrayList<String> arrayList3 = this.e;
                    if (arrayList3 != null) {
                        arrayList3.clear();
                    }
                    this.a = false;
                    return;
                }
                if (this.b != 1) {
                    c = x.a().c();
                    if (c != null) {
                        str2 = com.baidu.location.h.o.d();
                        a(c, str2);
                    } else {
                        str = com.baidu.location.h.o.d();
                        e(str);
                    }
                } else {
                    c = x.a().c();
                    if (c != null) {
                        str2 = com.baidu.location.h.d.c;
                        a(c, str2);
                    } else {
                        str = com.baidu.location.h.d.c;
                        e(str);
                    }
                }
            } catch (Exception unused2) {
                ArrayList<String> arrayList4 = this.e;
                if (arrayList4 != null) {
                    arrayList4.clear();
                }
            }
        }

        @Override // com.baidu.location.h.g
        public void a(boolean z) {
            if (z && this.j != null) {
                ArrayList<String> arrayList = this.e;
                if (arrayList != null) {
                    arrayList.clear();
                }
                try {
                    JSONObject jSONObject = new JSONObject(this.j);
                    if (jSONObject.has("ison") && jSONObject.getInt("ison") == 0) {
                        this.f = false;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (this.k != null) {
                this.k.clear();
            }
            this.a = false;
        }

        @Override // com.baidu.location.h.g
        public void b() {
            Map<String, Object> map;
            StringBuilder sb;
            String str;
            if (this.b != 1) {
                this.h = com.baidu.location.h.o.d();
            }
            this.i = 2;
            if (this.e != null) {
                for (int i = 0; i < this.e.size(); i++) {
                    if (this.b == 1) {
                        map = this.k;
                        sb = new StringBuilder();
                        str = "cldc[";
                    } else {
                        map = this.k;
                        sb = new StringBuilder();
                        str = "cltr[";
                    }
                    map.put(sb.append(str).append(i).append("]").toString(), this.e.get(i));
                }
                this.k.put("trtm", String.format(Locale.CHINA, "%d", Long.valueOf(System.currentTimeMillis())));
                if (this.b != 1) {
                    this.k.put("qt", "cltrg");
                }
            }
        }
    }

    private z() {
        String i2;
        this.z = null;
        this.B = 0;
        this.z = new a();
        this.B = 0;
        if (Build.VERSION.SDK_INT <= 28 || (i2 = com.baidu.location.h.o.i()) == null) {
            return;
        }
        e = i2 + "/yo2.dat";
        f = i2 + "/yoh2.dat";
        g = i2 + "/yom2.dat";
        h = i2 + "/yol2.dat";
        i = i2 + "/yor2.dat";
    }

    private static synchronized int a(List<String> list, int i2) {
        synchronized (z.class) {
            if (list != null && i2 <= 256) {
                if (i2 >= 0) {
                    try {
                        if (j == null) {
                            File file = new File(e);
                            j = file;
                            if (!file.exists()) {
                                j = null;
                                return -2;
                            }
                        }
                        RandomAccessFile randomAccessFile = new RandomAccessFile(j, InternalZipConstants.WRITE_MODE);
                        if (randomAccessFile.length() < 1) {
                            randomAccessFile.close();
                            return -3;
                        }
                        long j2 = i2;
                        randomAccessFile.seek(j2);
                        int readInt = randomAccessFile.readInt();
                        int readInt2 = randomAccessFile.readInt();
                        int readInt3 = randomAccessFile.readInt();
                        int readInt4 = randomAccessFile.readInt();
                        long readLong = randomAccessFile.readLong();
                        long j3 = readLong;
                        if (a(readInt, readInt2, readInt3, readInt4, readLong)) {
                            int i3 = 1;
                            if (readInt2 >= 1) {
                                byte[] bArr = new byte[n];
                                int i4 = k;
                                while (i4 > 0 && readInt2 > 0) {
                                    long j4 = (((readInt + readInt2) - i3) % readInt3) * readInt4;
                                    byte[] bArr2 = bArr;
                                    long j5 = j3;
                                    randomAccessFile.seek(j4 + j5);
                                    int readInt5 = randomAccessFile.readInt();
                                    if (readInt5 > 0 && readInt5 < readInt4) {
                                        randomAccessFile.read(bArr2, 0, readInt5);
                                        int i5 = readInt5 - 1;
                                        if (bArr2[i5] == 0) {
                                            list.add(new String(bArr2, 0, i5));
                                        }
                                    }
                                    i4--;
                                    readInt2--;
                                    j3 = j5;
                                    bArr = bArr2;
                                    i3 = 1;
                                }
                                randomAccessFile.seek(j2);
                                randomAccessFile.writeInt(readInt);
                                randomAccessFile.writeInt(readInt2);
                                randomAccessFile.writeInt(readInt3);
                                randomAccessFile.writeInt(readInt4);
                                randomAccessFile.writeLong(j3);
                                randomAccessFile.close();
                                return k - i4;
                            }
                        }
                        randomAccessFile.close();
                        return -4;
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        return -5;
                    }
                }
            }
            return -1;
        }
    }

    public static synchronized z a() {
        z zVar;
        synchronized (z.class) {
            if (A == null) {
                A = new z();
            }
            zVar = A;
        }
        return zVar;
    }

    private static String a(int i2) {
        String str;
        ArrayList<String> arrayList;
        String str2 = null;
        if (i2 == 1) {
            str = f;
            arrayList = b;
        } else if (i2 == 2) {
            str = g;
            arrayList = c;
        } else {
            if (i2 == 3) {
                str = h;
            } else {
                if (i2 != 4) {
                    return null;
                }
                str = i;
            }
            arrayList = d;
        }
        if (arrayList == null) {
            return null;
        }
        if (arrayList.size() < 1) {
            a(str, arrayList);
        }
        synchronized (z.class) {
            int size = arrayList.size();
            if (size > 0) {
                int i3 = size - 1;
                try {
                    String str3 = arrayList.get(i3);
                    try {
                        arrayList.remove(i3);
                    } catch (Exception unused) {
                    }
                    str2 = str3;
                } catch (Exception unused2) {
                }
            }
        }
        return str2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x0011, code lost:
    
        if (r15 != false) goto L7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x001c, code lost:
    
        if (r15 != false) goto L13;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00e5 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:37:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00d2 A[EDGE_INSN: B:38:0x00d2->B:30:0x00d2 BREAK  A[LOOP:0: B:13:0x005b->B:20:0x00ce], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(int r14, boolean r15) {
        /*
            Method dump skipped, instructions count: 236
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.b.z.a(int, boolean):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0220  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0223 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0240  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x025e  */
    /* JADX WARN: Removed duplicated region for block: B:115:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0245  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0210  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:85:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(com.baidu.location.f.a r10, com.baidu.location.f.l r11, android.location.Location r12, java.lang.String r13, java.lang.String r14) {
        /*
            Method dump skipped, instructions count: 609
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.b.z.a(com.baidu.location.f.a, com.baidu.location.f.l, android.location.Location, java.lang.String, java.lang.String):void");
    }

    private static void a(String str) {
        e(str);
    }

    private static boolean a(int i2, int i3, int i4, int i5, long j2) {
        return i2 >= 0 && i2 < i4 && i3 >= 0 && i3 <= i4 && i4 >= 0 && i4 <= 1024 && i5 >= 128 && i5 <= 1024;
    }

    private static boolean a(Location location) {
        if (location == null) {
            return false;
        }
        Location location2 = w;
        if (location2 == null || v == null) {
            w = location;
            return true;
        }
        double distanceTo = location.distanceTo(location2);
        return ((double) location.distanceTo(v)) > (((((double) com.baidu.location.h.o.S) * distanceTo) * distanceTo) + (((double) com.baidu.location.h.o.T) * distanceTo)) + ((double) com.baidu.location.h.o.U);
    }

    private static boolean a(Location location, com.baidu.location.f.l lVar) {
        boolean z = false;
        if (location != null && lVar != null && lVar.a != null && !lVar.a.isEmpty()) {
            if (lVar.b(y)) {
                return false;
            }
            z = true;
            if (x == null) {
                x = location;
            }
        }
        return z;
    }

    public static boolean a(Location location, boolean z) {
        return com.baidu.location.f.g.a(v, location, z);
    }

    private static boolean a(String str, List<String> list) {
        File file = new File(str);
        if (!file.exists()) {
            return false;
        }
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, InternalZipConstants.WRITE_MODE);
            randomAccessFile.seek(8L);
            int readInt = randomAccessFile.readInt();
            int readInt2 = randomAccessFile.readInt();
            int readInt3 = randomAccessFile.readInt();
            byte[] bArr = new byte[n];
            int i2 = l + 1;
            boolean z = false;
            while (i2 > 0 && readInt2 > 0) {
                if (readInt2 < readInt3) {
                    readInt3 = 0;
                }
                try {
                    randomAccessFile.seek(((readInt2 - 1) * readInt) + 128);
                    int readInt4 = randomAccessFile.readInt();
                    if (readInt4 > 0 && readInt4 < readInt) {
                        randomAccessFile.read(bArr, 0, readInt4);
                        int i3 = readInt4 - 1;
                        if (bArr[i3] == 0) {
                            list.add(0, new String(bArr, 0, i3));
                            z = true;
                        }
                    }
                    i2--;
                    readInt2--;
                } catch (Exception unused) {
                    return z;
                }
            }
            randomAccessFile.seek(12L);
            randomAccessFile.writeInt(readInt2);
            randomAccessFile.writeInt(readInt3);
            randomAccessFile.close();
            return z;
        } catch (Exception unused2) {
            return false;
        }
    }

    public static String b() {
        return f();
    }

    private static void b(String str) {
        e(str);
    }

    private static void c(String str) {
        e(str);
    }

    public static void d() {
        l = 0;
        a(1, false);
        a(2, false);
        a(3, false);
        l = 8;
    }

    private static void d(String str) {
        try {
            File file = new File(str);
            if (file.exists()) {
                return;
            }
            File file2 = new File(com.baidu.location.h.n.a);
            if (!file2.exists()) {
                file2.mkdirs();
            }
            if (!file.createNewFile()) {
                file = null;
            }
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, InternalZipConstants.WRITE_MODE);
            randomAccessFile.seek(0L);
            randomAccessFile.writeInt(32);
            randomAccessFile.writeInt(2048);
            randomAccessFile.writeInt(5120);
            randomAccessFile.writeInt(0);
            randomAccessFile.writeInt(0);
            randomAccessFile.writeInt(0);
            randomAccessFile.close();
        } catch (Exception unused) {
        }
    }

    public static String e() {
        File file = new File(g);
        String str = null;
        if (file.exists()) {
            try {
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, InternalZipConstants.WRITE_MODE);
                randomAccessFile.seek(20L);
                int readInt = randomAccessFile.readInt();
                if (readInt > 128) {
                    String str2 = "&p1=" + readInt;
                    try {
                        randomAccessFile.seek(20L);
                        randomAccessFile.writeInt(0);
                        randomAccessFile.close();
                        return str2;
                    } catch (Exception unused) {
                        str = str2;
                    }
                } else {
                    randomAccessFile.close();
                }
            } catch (Exception unused2) {
            }
        }
        File file2 = new File(h);
        if (file2.exists()) {
            try {
                RandomAccessFile randomAccessFile2 = new RandomAccessFile(file2, InternalZipConstants.WRITE_MODE);
                randomAccessFile2.seek(20L);
                int readInt2 = randomAccessFile2.readInt();
                if (readInt2 > 256) {
                    String str3 = "&p2=" + readInt2;
                    try {
                        randomAccessFile2.seek(20L);
                        randomAccessFile2.writeInt(0);
                        randomAccessFile2.close();
                        return str3;
                    } catch (Exception unused3) {
                        str = str3;
                    }
                } else {
                    randomAccessFile2.close();
                }
            } catch (Exception unused4) {
            }
        }
        File file3 = new File(i);
        if (file3.exists()) {
            try {
                RandomAccessFile randomAccessFile3 = new RandomAccessFile(file3, InternalZipConstants.WRITE_MODE);
                randomAccessFile3.seek(20L);
                int readInt3 = randomAccessFile3.readInt();
                if (readInt3 > 512) {
                    String str4 = "&p3=" + readInt3;
                    try {
                        randomAccessFile3.seek(20L);
                        randomAccessFile3.writeInt(0);
                        randomAccessFile3.close();
                        return str4;
                    } catch (Exception unused5) {
                        str = str4;
                    }
                } else {
                    randomAccessFile3.close();
                }
            } catch (Exception unused6) {
            }
        }
        return str;
    }

    private static synchronized void e(String str) {
        ArrayList<String> arrayList;
        synchronized (z.class) {
            if (str.contains("err!")) {
                return;
            }
            int i2 = com.baidu.location.h.o.p;
            if (i2 == 1) {
                arrayList = b;
            } else if (i2 == 2) {
                arrayList = c;
            } else if (i2 != 3) {
                return;
            } else {
                arrayList = d;
            }
            if (arrayList == null) {
                return;
            }
            if (arrayList.size() <= m) {
                arrayList.add(str);
            }
            if (arrayList.size() >= m) {
                a(i2, false);
            }
            while (arrayList.size() > m) {
                arrayList.remove(0);
            }
        }
    }

    private static String f() {
        String str = null;
        for (int i2 = 1; i2 < 5; i2++) {
            str = a(i2);
            if (str != null) {
                return str;
            }
        }
        a(d, t);
        try {
            if (d.size() > 0) {
                String str2 = d.get(0);
                try {
                    d.remove(0);
                } catch (ArrayIndexOutOfBoundsException unused) {
                }
                str = str2;
            }
        } catch (ArrayIndexOutOfBoundsException unused2) {
        }
        if (str != null) {
            return str;
        }
        a(d, s);
        try {
            if (d.size() > 0) {
                String str3 = d.get(0);
                try {
                    d.remove(0);
                } catch (ArrayIndexOutOfBoundsException unused3) {
                }
                str = str3;
            }
        } catch (ArrayIndexOutOfBoundsException unused4) {
        }
        if (str != null) {
            return str;
        }
        a(d, u);
        try {
            if (d.size() <= 0) {
                return str;
            }
            String str4 = d.get(0);
            try {
                d.remove(0);
            } catch (ArrayIndexOutOfBoundsException unused5) {
            }
            return str4;
        } catch (ArrayIndexOutOfBoundsException unused6) {
            return str;
        }
    }

    public void c() {
        if (com.baidu.location.f.m.a().k() && !com.baidu.location.h.o.b()) {
            this.z.a();
        }
    }
}
