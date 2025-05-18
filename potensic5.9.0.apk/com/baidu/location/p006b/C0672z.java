package com.baidu.location.p006b;

import android.location.Location;
import android.os.Build;
import com.baidu.location.p010f.C0709g;
import com.baidu.location.p010f.C0714l;
import com.baidu.location.p010f.C0715m;
import com.baidu.location.p012h.AbstractC0725g;
import com.baidu.location.p012h.C0719a;
import com.baidu.location.p012h.C0722d;
import com.baidu.location.p012h.C0732n;
import com.baidu.location.p012h.C0733o;
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

/* renamed from: com.baidu.location.b.z */
/* loaded from: classes.dex */
public class C0672z {

    /* renamed from: B */
    private int f753B;

    /* renamed from: a */
    long f754a = 0;

    /* renamed from: z */
    private a f755z;

    /* renamed from: b */
    private static ArrayList<String> f729b = new ArrayList<>();

    /* renamed from: c */
    private static ArrayList<String> f730c = new ArrayList<>();

    /* renamed from: d */
    private static ArrayList<String> f731d = new ArrayList<>();

    /* renamed from: e */
    private static String f732e = C0732n.f1312a + "/yo.dat";

    /* renamed from: f */
    private static String f733f = C0732n.f1312a + "/yoh.dat";

    /* renamed from: g */
    private static String f734g = C0732n.f1312a + "/yom.dat";

    /* renamed from: h */
    private static String f735h = C0732n.f1312a + "/yol.dat";

    /* renamed from: i */
    private static String f736i = C0732n.f1312a + "/yor.dat";

    /* renamed from: j */
    private static File f737j = null;

    /* renamed from: k */
    private static int f738k = 8;

    /* renamed from: l */
    private static int f739l = 8;

    /* renamed from: m */
    private static int f740m = 16;

    /* renamed from: n */
    private static int f741n = 2048;

    /* renamed from: o */
    private static double f742o = 0.0d;

    /* renamed from: p */
    private static double f743p = 0.1d;

    /* renamed from: q */
    private static double f744q = 30.0d;

    /* renamed from: r */
    private static double f745r = 100.0d;

    /* renamed from: s */
    private static int f746s = 0;

    /* renamed from: t */
    private static int f747t = 64;

    /* renamed from: u */
    private static int f748u = 128;

    /* renamed from: v */
    private static Location f749v = null;

    /* renamed from: w */
    private static Location f750w = null;

    /* renamed from: x */
    private static Location f751x = null;

    /* renamed from: y */
    private static C0714l f752y = null;

    /* renamed from: A */
    private static C0672z f727A = null;

    /* renamed from: C */
    private static long f728C = 0;

    /* renamed from: com.baidu.location.b.z$a */
    private class a extends AbstractC0725g {

        /* renamed from: a */
        boolean f756a = false;

        /* renamed from: b */
        int f757b = 0;

        /* renamed from: c */
        int f758c = 0;

        /* renamed from: e */
        private ArrayList<String> f760e = new ArrayList<>();

        /* renamed from: f */
        private boolean f761f = true;

        public a() {
            this.f1292k = new HashMap();
        }

        /* renamed from: a */
        public synchronized void m621a() {
            ExecutorService m592c;
            String str;
            String str2;
            if (this.f756a) {
                return;
            }
            if (f1288q > 4 && this.f758c < f1288q) {
                this.f758c++;
                return;
            }
            this.f758c = 0;
            this.f756a = true;
            this.f757b = 0;
            try {
                ArrayList<String> arrayList = this.f760e;
                if (arrayList == null || arrayList.size() < 1) {
                    if (this.f760e == null) {
                        this.f760e = new ArrayList<>();
                    }
                    this.f757b = 0;
                    int i = 0;
                    while (true) {
                        String str3 = null;
                        String m612b = this.f757b < 2 ? C0672z.m612b() : null;
                        if (m612b == null && this.f757b != 1 && this.f761f) {
                            this.f757b = 2;
                            try {
                                str3 = C0657k.m441a();
                            } catch (Exception unused) {
                            }
                        } else {
                            this.f757b = 1;
                            str3 = m612b;
                        }
                        if (str3 == null) {
                            break;
                        }
                        if (!str3.contains("err!")) {
                            this.f760e.add(str3);
                            i += str3.length();
                            if (i >= C0719a.f1230h) {
                                break;
                            }
                        }
                    }
                }
                ArrayList<String> arrayList2 = this.f760e;
                if (arrayList2 == null || arrayList2.size() < 1) {
                    ArrayList<String> arrayList3 = this.f760e;
                    if (arrayList3 != null) {
                        arrayList3.clear();
                    }
                    this.f756a = false;
                    return;
                }
                if (this.f757b != 1) {
                    m592c = C0670x.m590a().m592c();
                    if (m592c != null) {
                        str2 = C0733o.m1160d();
                        m1129a(m592c, str2);
                    } else {
                        str = C0733o.m1160d();
                        m1133e(str);
                    }
                } else {
                    m592c = C0670x.m590a().m592c();
                    if (m592c != null) {
                        str2 = C0722d.f1260c;
                        m1129a(m592c, str2);
                    } else {
                        str = C0722d.f1260c;
                        m1133e(str);
                    }
                }
            } catch (Exception unused2) {
                ArrayList<String> arrayList4 = this.f760e;
                if (arrayList4 != null) {
                    arrayList4.clear();
                }
            }
        }

        @Override // com.baidu.location.p012h.AbstractC0725g
        /* renamed from: a */
        public void mo122a(boolean z) {
            if (z && this.f1291j != null) {
                ArrayList<String> arrayList = this.f760e;
                if (arrayList != null) {
                    arrayList.clear();
                }
                try {
                    JSONObject jSONObject = new JSONObject(this.f1291j);
                    if (jSONObject.has("ison") && jSONObject.getInt("ison") == 0) {
                        this.f761f = false;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (this.f1292k != null) {
                this.f1292k.clear();
            }
            this.f756a = false;
        }

        @Override // com.baidu.location.p012h.AbstractC0725g
        /* renamed from: b */
        public void mo123b() {
            Map<String, Object> map;
            StringBuilder sb;
            String str;
            if (this.f757b != 1) {
                this.f1289h = C0733o.m1160d();
            }
            this.f1290i = 2;
            if (this.f760e != null) {
                for (int i = 0; i < this.f760e.size(); i++) {
                    if (this.f757b == 1) {
                        map = this.f1292k;
                        sb = new StringBuilder();
                        str = "cldc[";
                    } else {
                        map = this.f1292k;
                        sb = new StringBuilder();
                        str = "cltr[";
                    }
                    map.put(sb.append(str).append(i).append("]").toString(), this.f760e.get(i));
                }
                this.f1292k.put("trtm", String.format(Locale.CHINA, "%d", Long.valueOf(System.currentTimeMillis())));
                if (this.f757b != 1) {
                    this.f1292k.put("qt", "cltrg");
                }
            }
        }
    }

    private C0672z() {
        String m1170i;
        this.f755z = null;
        this.f753B = 0;
        this.f755z = new a();
        this.f753B = 0;
        if (Build.VERSION.SDK_INT <= 28 || (m1170i = C0733o.m1170i()) == null) {
            return;
        }
        f732e = m1170i + "/yo2.dat";
        f733f = m1170i + "/yoh2.dat";
        f734g = m1170i + "/yom2.dat";
        f735h = m1170i + "/yol2.dat";
        f736i = m1170i + "/yor2.dat";
    }

    /* renamed from: a */
    private static synchronized int m601a(List<String> list, int i) {
        synchronized (C0672z.class) {
            if (list != null && i <= 256) {
                if (i >= 0) {
                    try {
                        if (f737j == null) {
                            File file = new File(f732e);
                            f737j = file;
                            if (!file.exists()) {
                                f737j = null;
                                return -2;
                            }
                        }
                        RandomAccessFile randomAccessFile = new RandomAccessFile(f737j, InternalZipConstants.WRITE_MODE);
                        if (randomAccessFile.length() < 1) {
                            randomAccessFile.close();
                            return -3;
                        }
                        long j = i;
                        randomAccessFile.seek(j);
                        int readInt = randomAccessFile.readInt();
                        int readInt2 = randomAccessFile.readInt();
                        int readInt3 = randomAccessFile.readInt();
                        int readInt4 = randomAccessFile.readInt();
                        long readLong = randomAccessFile.readLong();
                        long j2 = readLong;
                        if (m607a(readInt, readInt2, readInt3, readInt4, readLong)) {
                            int i2 = 1;
                            if (readInt2 >= 1) {
                                byte[] bArr = new byte[f741n];
                                int i3 = f738k;
                                while (i3 > 0 && readInt2 > 0) {
                                    long j3 = (((readInt + readInt2) - i2) % readInt3) * readInt4;
                                    byte[] bArr2 = bArr;
                                    long j4 = j2;
                                    randomAccessFile.seek(j3 + j4);
                                    int readInt5 = randomAccessFile.readInt();
                                    if (readInt5 > 0 && readInt5 < readInt4) {
                                        randomAccessFile.read(bArr2, 0, readInt5);
                                        int i4 = readInt5 - 1;
                                        if (bArr2[i4] == 0) {
                                            list.add(new String(bArr2, 0, i4));
                                        }
                                    }
                                    i3--;
                                    readInt2--;
                                    j2 = j4;
                                    bArr = bArr2;
                                    i2 = 1;
                                }
                                randomAccessFile.seek(j);
                                randomAccessFile.writeInt(readInt);
                                randomAccessFile.writeInt(readInt2);
                                randomAccessFile.writeInt(readInt3);
                                randomAccessFile.writeInt(readInt4);
                                randomAccessFile.writeLong(j2);
                                randomAccessFile.close();
                                return f738k - i3;
                            }
                        }
                        randomAccessFile.close();
                        return -4;
                    } catch (Exception e) {
                        e.printStackTrace();
                        return -5;
                    }
                }
            }
            return -1;
        }
    }

    /* renamed from: a */
    public static synchronized C0672z m602a() {
        C0672z c0672z;
        synchronized (C0672z.class) {
            if (f727A == null) {
                f727A = new C0672z();
            }
            c0672z = f727A;
        }
        return c0672z;
    }

    /* renamed from: a */
    private static String m603a(int i) {
        String str;
        ArrayList<String> arrayList;
        String str2 = null;
        if (i == 1) {
            str = f733f;
            arrayList = f729b;
        } else if (i == 2) {
            str = f734g;
            arrayList = f730c;
        } else {
            if (i == 3) {
                str = f735h;
            } else {
                if (i != 4) {
                    return null;
                }
                str = f736i;
            }
            arrayList = f731d;
        }
        if (arrayList == null) {
            return null;
        }
        if (arrayList.size() < 1) {
            m611a(str, arrayList);
        }
        synchronized (C0672z.class) {
            int size = arrayList.size();
            if (size > 0) {
                int i2 = size - 1;
                try {
                    String str3 = arrayList.get(i2);
                    try {
                        arrayList.remove(i2);
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
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void m604a(int r14, boolean r15) {
        /*
            Method dump skipped, instructions count: 236
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.p006b.C0672z.m604a(int, boolean):void");
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
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void m605a(com.baidu.location.p010f.C0703a r10, com.baidu.location.p010f.C0714l r11, android.location.Location r12, java.lang.String r13, java.lang.String r14) {
        /*
            Method dump skipped, instructions count: 609
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.p006b.C0672z.m605a(com.baidu.location.f.a, com.baidu.location.f.l, android.location.Location, java.lang.String, java.lang.String):void");
    }

    /* renamed from: a */
    private static void m606a(String str) {
        m618e(str);
    }

    /* renamed from: a */
    private static boolean m607a(int i, int i2, int i3, int i4, long j) {
        return i >= 0 && i < i3 && i2 >= 0 && i2 <= i3 && i3 >= 0 && i3 <= 1024 && i4 >= 128 && i4 <= 1024;
    }

    /* renamed from: a */
    private static boolean m608a(Location location) {
        if (location == null) {
            return false;
        }
        Location location2 = f750w;
        if (location2 == null || f749v == null) {
            f750w = location;
            return true;
        }
        double distanceTo = location.distanceTo(location2);
        return ((double) location.distanceTo(f749v)) > (((((double) C0733o.f1332S) * distanceTo) * distanceTo) + (((double) C0733o.f1333T) * distanceTo)) + ((double) C0733o.f1334U);
    }

    /* renamed from: a */
    private static boolean m609a(Location location, C0714l c0714l) {
        boolean z = false;
        if (location != null && c0714l != null && c0714l.f1188a != null && !c0714l.f1188a.isEmpty()) {
            if (c0714l.m1044b(f752y)) {
                return false;
            }
            z = true;
            if (f751x == null) {
                f751x = location;
            }
        }
        return z;
    }

    /* renamed from: a */
    public static boolean m610a(Location location, boolean z) {
        return C0709g.m974a(f749v, location, z);
    }

    /* renamed from: a */
    private static boolean m611a(String str, List<String> list) {
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
            byte[] bArr = new byte[f741n];
            int i = f739l + 1;
            boolean z = false;
            while (i > 0 && readInt2 > 0) {
                if (readInt2 < readInt3) {
                    readInt3 = 0;
                }
                try {
                    randomAccessFile.seek(((readInt2 - 1) * readInt) + 128);
                    int readInt4 = randomAccessFile.readInt();
                    if (readInt4 > 0 && readInt4 < readInt) {
                        randomAccessFile.read(bArr, 0, readInt4);
                        int i2 = readInt4 - 1;
                        if (bArr[i2] == 0) {
                            list.add(0, new String(bArr, 0, i2));
                            z = true;
                        }
                    }
                    i--;
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

    /* renamed from: b */
    public static String m612b() {
        return m619f();
    }

    /* renamed from: b */
    private static void m613b(String str) {
        m618e(str);
    }

    /* renamed from: c */
    private static void m614c(String str) {
        m618e(str);
    }

    /* renamed from: d */
    public static void m615d() {
        f739l = 0;
        m604a(1, false);
        m604a(2, false);
        m604a(3, false);
        f739l = 8;
    }

    /* renamed from: d */
    private static void m616d(String str) {
        try {
            File file = new File(str);
            if (file.exists()) {
                return;
            }
            File file2 = new File(C0732n.f1312a);
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

    /* renamed from: e */
    public static String m617e() {
        File file = new File(f734g);
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
        File file2 = new File(f735h);
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
        File file3 = new File(f736i);
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

    /* renamed from: e */
    private static synchronized void m618e(String str) {
        ArrayList<String> arrayList;
        synchronized (C0672z.class) {
            if (str.contains("err!")) {
                return;
            }
            int i = C0733o.f1400p;
            if (i == 1) {
                arrayList = f729b;
            } else if (i == 2) {
                arrayList = f730c;
            } else if (i != 3) {
                return;
            } else {
                arrayList = f731d;
            }
            if (arrayList == null) {
                return;
            }
            if (arrayList.size() <= f740m) {
                arrayList.add(str);
            }
            if (arrayList.size() >= f740m) {
                m604a(i, false);
            }
            while (arrayList.size() > f740m) {
                arrayList.remove(0);
            }
        }
    }

    /* renamed from: f */
    private static String m619f() {
        String str = null;
        for (int i = 1; i < 5; i++) {
            str = m603a(i);
            if (str != null) {
                return str;
            }
        }
        m601a(f731d, f747t);
        try {
            if (f731d.size() > 0) {
                String str2 = f731d.get(0);
                try {
                    f731d.remove(0);
                } catch (ArrayIndexOutOfBoundsException unused) {
                }
                str = str2;
            }
        } catch (ArrayIndexOutOfBoundsException unused2) {
        }
        if (str != null) {
            return str;
        }
        m601a(f731d, f746s);
        try {
            if (f731d.size() > 0) {
                String str3 = f731d.get(0);
                try {
                    f731d.remove(0);
                } catch (ArrayIndexOutOfBoundsException unused3) {
                }
                str = str3;
            }
        } catch (ArrayIndexOutOfBoundsException unused4) {
        }
        if (str != null) {
            return str;
        }
        m601a(f731d, f748u);
        try {
            if (f731d.size() <= 0) {
                return str;
            }
            String str4 = f731d.get(0);
            try {
                f731d.remove(0);
            } catch (ArrayIndexOutOfBoundsException unused5) {
            }
            return str4;
        } catch (ArrayIndexOutOfBoundsException unused6) {
            return str;
        }
    }

    /* renamed from: c */
    public void m620c() {
        if (C0715m.m1058a().m1077k() && !C0733o.m1152b()) {
            this.f755z.m621a();
        }
    }
}