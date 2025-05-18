package com.baidu.location;

/* loaded from: classes.dex */
public class Jni {

    /* renamed from: a */
    private static int f322a = 0;

    /* renamed from: b */
    private static int f323b = 1;

    /* renamed from: c */
    private static int f324c = 2;

    /* renamed from: d */
    private static int f325d = 11;

    /* renamed from: e */
    private static int f326e = 12;

    /* renamed from: f */
    private static int f327f = 13;

    /* renamed from: g */
    private static int f328g = 14;

    /* renamed from: h */
    private static int f329h = 15;

    /* renamed from: i */
    private static int f330i = 1024;

    /* renamed from: j */
    private static boolean f331j = false;

    static {
        try {
            System.loadLibrary("locSDK8b");
        } catch (UnsatisfiedLinkError e) {
            e.printStackTrace();
            f331j = true;
        }
    }

    /* renamed from: a */
    private static native String m222a(byte[] bArr, int i);

    /* renamed from: b */
    private static native String m223b(double d, double d2, int i, int i2);

    /* renamed from: c */
    private static native String m224c(byte[] bArr, int i);

    public static double[] coorEncrypt(double d, double d2, String str) {
        double[] dArr = {0.0d, 0.0d};
        if (f331j) {
            return dArr;
        }
        int i = -1;
        if (str.equals("bd09")) {
            i = f322a;
        } else if (str.equals("bd09ll")) {
            i = f323b;
        } else if (str.equals("gcj02")) {
            i = f324c;
        } else if (str.equals(BDLocation.BDLOCATION_WGS84_TO_GCJ02)) {
            i = f325d;
        } else if (str.equals(BDLocation.BDLOCATION_BD09_TO_GCJ02)) {
            i = f326e;
        } else if (str.equals(BDLocation.BDLOCATION_BD09LL_TO_GCJ02)) {
            i = f327f;
        } else if (str.equals("wgs842mc")) {
            i = f329h;
        }
        if (str.equals("gcj2wgs")) {
            i = 16;
        }
        try {
            String[] split = m223b(d, d2, i, 132456).split(":");
            dArr[0] = Double.parseDouble(split[0]);
            dArr[1] = Double.parseDouble(split[1]);
        } catch (Throwable unused) {
            dArr[0] = 0.0d;
            dArr[1] = 0.0d;
        }
        return dArr;
    }

    /* renamed from: ee */
    private static native String m225ee(String str, int i);

    public static String en1(String str) {
        if (f331j) {
            return "err!";
        }
        if (str == null) {
            return "null";
        }
        byte[] bytes = str.getBytes();
        byte[] bArr = new byte[f330i];
        int length = bytes.length;
        if (length > 740) {
            length = 740;
        }
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            if (bytes[i2] != 0) {
                bArr[i] = bytes[i2];
                i++;
            }
        }
        try {
            return m222a(bArr, 132456);
        } catch (UnsatisfiedLinkError e) {
            e.printStackTrace();
            return "err!";
        }
    }

    public static String encode(String str) {
        return f331j ? "err!" : en1(str) + "|tp=3";
    }

    public static String encode2(String str) {
        if (f331j) {
            return "err!";
        }
        if (str == null) {
            return "null";
        }
        try {
            return m224c(str.getBytes(), 132456);
        } catch (UnsatisfiedLinkError e) {
            e.printStackTrace();
            return "err!";
        }
    }

    public static Long encode3(String str) {
        String str2;
        if (f331j) {
            return null;
        }
        try {
            str2 = new String(str.getBytes(), "UTF-8");
        } catch (Exception unused) {
            str2 = "";
        }
        try {
            return Long.valueOf(murmur(str2));
        } catch (UnsatisfiedLinkError e) {
            e.printStackTrace();
            return null;
        }
    }

    private static native String encodeNotLimit(String str, int i);

    public static String encodeOfflineLocationUpdateRequest(String str) {
        String str2;
        String str3 = "err!";
        if (f331j) {
            return "err!";
        }
        try {
            str2 = new String(str.getBytes(), "UTF-8");
        } catch (Exception unused) {
            str2 = "";
        }
        try {
            str3 = encodeNotLimit(str2, 132456);
        } catch (UnsatisfiedLinkError e) {
            e.printStackTrace();
        }
        return str3 + "|tp=3";
    }

    public static String encodeTp4(String str) {
        String str2;
        String str3 = "err!";
        if (f331j) {
            return "err!";
        }
        try {
            str2 = new String(str.getBytes(), "UTF-8");
        } catch (Exception unused) {
            str2 = "";
        }
        try {
            str3 = m225ee(str2, 132456);
        } catch (UnsatisfiedLinkError e) {
            e.printStackTrace();
        }
        return str3 + "|tp=4";
    }

    public static String encodeTp4NoTag(String str) {
        String str2;
        if (f331j) {
            return "err!";
        }
        try {
            str2 = new String(str.getBytes(), "UTF-8");
        } catch (Exception unused) {
            str2 = "";
        }
        try {
            return m225ee(str2, 132456);
        } catch (UnsatisfiedLinkError e) {
            e.printStackTrace();
            return "err!";
        }
    }

    public static double getGpsSwiftRadius(float f, double d, double d2) {
        if (f331j) {
            return 0.0d;
        }
        try {
            return gsr(f, d, d2);
        } catch (UnsatisfiedLinkError unused) {
            return 0.0d;
        }
    }

    public static String getldkaiv() {
        if (f331j) {
            return null;
        }
        try {
            return ldkaiv();
        } catch (UnsatisfiedLinkError e) {
            e.printStackTrace();
            return null;
        }
    }

    private static native double gsr(float f, double d, double d2);

    private static native String ldkaiv();

    private static native long murmur(String str);
}