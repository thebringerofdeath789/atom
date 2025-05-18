package com.baidu.location.p012h;

import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.text.TextUtils;
import com.baidu.location.BDLocation;
import com.baidu.location.Jni;
import com.baidu.location.ServiceC0702f;
import com.baidu.location.p007c.C0677d;
import com.baidu.location.p010f.C0703a;
import com.baidu.location.p010f.C0704b;
import com.baidu.location.p010f.C0709g;
import com.baidu.location.p010f.C0714l;
import com.google.android.exoplayer2.source.rtsp.SessionDescription;
import com.hjq.permissions.Permission;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.Locale;
import java.util.zip.GZIPOutputStream;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import org.apache.commons.net.imap.IMAPSClient;

/* renamed from: com.baidu.location.h.o */
/* loaded from: classes.dex */
public class C0733o {

    /* renamed from: A */
    public static float f1314A = 2.3f;

    /* renamed from: B */
    public static float f1315B = 3.8f;

    /* renamed from: C */
    public static int f1316C = 3;

    /* renamed from: D */
    public static int f1317D = 10;

    /* renamed from: E */
    public static int f1318E = 2;

    /* renamed from: F */
    public static int f1319F = 7;

    /* renamed from: G */
    public static int f1320G = 20;

    /* renamed from: H */
    public static int f1321H = 70;

    /* renamed from: I */
    public static int f1322I = 120;

    /* renamed from: J */
    public static float f1323J = 2.0f;

    /* renamed from: K */
    public static float f1324K = 10.0f;

    /* renamed from: L */
    public static float f1325L = 50.0f;

    /* renamed from: M */
    public static float f1326M = 200.0f;

    /* renamed from: N */
    public static int f1327N = 16;

    /* renamed from: O */
    public static int f1328O = 32;

    /* renamed from: P */
    public static float f1329P = 0.9f;

    /* renamed from: Q */
    public static int f1330Q = 10000;

    /* renamed from: R */
    public static float f1331R = 0.5f;

    /* renamed from: S */
    public static float f1332S = 0.0f;

    /* renamed from: T */
    public static float f1333T = 0.1f;

    /* renamed from: U */
    public static int f1334U = 30;

    /* renamed from: V */
    public static int f1335V = 100;

    /* renamed from: W */
    public static int f1336W = 0;

    /* renamed from: X */
    public static int f1337X = 0;

    /* renamed from: Y */
    public static int f1338Y = 0;

    /* renamed from: Z */
    public static int f1339Z = 420000;

    /* renamed from: a */
    public static boolean f1340a = false;

    /* renamed from: aA */
    public static double f1341aA = -0.10000000149011612d;

    /* renamed from: aB */
    public static int f1342aB = 0;

    /* renamed from: aC */
    public static int f1343aC = 0;

    /* renamed from: aD */
    public static int f1344aD = 1;

    /* renamed from: aE */
    public static int f1345aE = 1;

    /* renamed from: aF */
    public static int f1346aF = 0;

    /* renamed from: aG */
    public static float f1347aG = 0.8f;

    /* renamed from: aH */
    public static float f1348aH = 0.2f;

    /* renamed from: aI */
    public static boolean f1349aI = false;

    /* renamed from: aJ */
    public static int f1350aJ = -1;

    /* renamed from: aK */
    public static int f1351aK = 10;

    /* renamed from: aL */
    public static int f1352aL = 3;

    /* renamed from: aM */
    public static int f1353aM = 40;

    /* renamed from: aN */
    public static double[] f1354aN = null;

    /* renamed from: aO */
    public static int f1355aO = 1;

    /* renamed from: aP */
    public static int f1356aP = 1;

    /* renamed from: aQ */
    public static int f1357aQ = 1;

    /* renamed from: aa */
    public static boolean f1360aa = true;

    /* renamed from: ab */
    public static boolean f1361ab = true;

    /* renamed from: ac */
    public static int f1362ac = 20;

    /* renamed from: ad */
    public static int f1363ad = 300;

    /* renamed from: ae */
    public static int f1364ae = 1000;

    /* renamed from: af */
    public static int f1365af = Integer.MAX_VALUE;

    /* renamed from: ag */
    public static long f1366ag = 900000;

    /* renamed from: ah */
    public static long f1367ah = 420000;

    /* renamed from: ai */
    public static long f1368ai = 180000;

    /* renamed from: aj */
    public static long f1369aj = 0;

    /* renamed from: ak */
    public static long f1370ak = 15;

    /* renamed from: al */
    public static long f1371al = 300000;

    /* renamed from: am */
    public static int f1372am = 1000;

    /* renamed from: an */
    public static int f1373an = 0;

    /* renamed from: ao */
    public static int f1374ao = 30000;

    /* renamed from: ap */
    public static int f1375ap = 30000;

    /* renamed from: aq */
    public static float f1376aq = 10.0f;

    /* renamed from: ar */
    public static float f1377ar = 6.0f;

    /* renamed from: as */
    public static float f1378as = 10.0f;

    /* renamed from: at */
    public static int f1379at = 60;

    /* renamed from: au */
    public static int f1380au = 70;

    /* renamed from: av */
    public static int f1381av = 6;

    /* renamed from: aw */
    public static String f1382aw = null;

    /* renamed from: ax */
    public static boolean f1383ax = false;

    /* renamed from: ay */
    public static int f1384ay = 16;

    /* renamed from: az */
    public static float f1385az = 0.75f;

    /* renamed from: b */
    public static boolean f1386b = false;

    /* renamed from: c */
    public static boolean f1387c = false;

    /* renamed from: d */
    public static int f1388d = 0;

    /* renamed from: e */
    public static String f1389e = "no";

    /* renamed from: f */
    public static int f1390f = 4;

    /* renamed from: g */
    public static boolean f1391g = false;

    /* renamed from: h */
    public static boolean f1392h = false;

    /* renamed from: i */
    public static boolean f1393i = false;

    /* renamed from: j */
    public static boolean f1394j = false;

    /* renamed from: k */
    public static boolean f1395k = false;

    /* renamed from: l */
    public static boolean f1396l = false;

    /* renamed from: m */
    public static String f1397m = "gcj02";

    /* renamed from: n */
    public static String f1398n = "";

    /* renamed from: o */
    public static boolean f1399o = true;

    /* renamed from: p */
    public static int f1400p = 3;

    /* renamed from: q */
    public static double f1401q = 0.0d;

    /* renamed from: r */
    public static double f1402r = 0.0d;

    /* renamed from: s */
    public static double f1403s = 0.0d;

    /* renamed from: t */
    public static double f1404t = 0.0d;

    /* renamed from: u */
    public static int f1405u = 0;

    /* renamed from: v */
    public static byte[] f1406v = null;

    /* renamed from: w */
    public static boolean f1407w = false;

    /* renamed from: x */
    public static int f1408x = 0;

    /* renamed from: y */
    public static float f1409y = 1.1f;

    /* renamed from: z */
    public static float f1410z = 2.2f;

    /* renamed from: aS */
    private static String f1359aS = Build.MANUFACTURER;

    /* renamed from: aR */
    public static boolean f1358aR = false;

    /* renamed from: a */
    public static double m1134a(double d, double d2, double d3, double d4) {
        Location.distanceBetween(d, d2, d3, d4, new float[1]);
        return r0[0];
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0016 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0017 A[RETURN] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int m1135a(android.content.Context r4, java.lang.String r5) {
        /*
            r0 = 0
            r1 = 1
            int r2 = android.os.Process.myPid()     // Catch: java.lang.Exception -> L13
            int r3 = android.os.Process.myUid()     // Catch: java.lang.Exception -> L13
            int r4 = r4.checkPermission(r5, r2, r3)     // Catch: java.lang.Exception -> L13
            if (r4 != 0) goto L11
            goto L13
        L11:
            r4 = r0
            goto L14
        L13:
            r4 = r1
        L14:
            if (r4 != 0) goto L17
            return r0
        L17:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.p012h.C0733o.m1135a(android.content.Context, java.lang.String):int");
    }

    /* renamed from: a */
    public static int m1136a(Object obj, String str) throws Exception {
        Method declaredMethod = obj.getClass().getDeclaredMethod(str, null);
        if (!declaredMethod.isAccessible()) {
            declaredMethod.setAccessible(true);
        }
        return ((Integer) declaredMethod.invoke(obj, null)).intValue();
    }

    /* renamed from: a */
    public static int m1137a(String str, String str2, String str3) {
        int indexOf;
        int length;
        int indexOf2;
        String substring;
        if (str != null && !str.equals("") && (indexOf = str.indexOf(str2)) != -1 && (indexOf2 = str.indexOf(str3, (length = indexOf + str2.length()))) != -1 && (substring = str.substring(length, indexOf2)) != null && !substring.equals("")) {
            try {
                return Integer.parseInt(substring);
            } catch (NumberFormatException unused) {
            }
        }
        return Integer.MIN_VALUE;
    }

    /* renamed from: a */
    public static String m1138a() {
        Calendar calendar = Calendar.getInstance();
        int i = calendar.get(5);
        return String.format(Locale.CHINA, "%d-%02d-%02d %02d:%02d:%02d", Integer.valueOf(calendar.get(1)), Integer.valueOf(calendar.get(2) + 1), Integer.valueOf(i), Integer.valueOf(calendar.get(11)), Integer.valueOf(calendar.get(12)), Integer.valueOf(calendar.get(13)));
    }

    /* renamed from: a */
    public static String m1139a(C0703a c0703a, C0714l c0714l, Location location, String str, int i) {
        return m1140a(c0703a, c0714l, location, str, i, false);
    }

    /* renamed from: a */
    public static String m1140a(C0703a c0703a, C0714l c0714l, Location location, String str, int i, boolean z) {
        String m936c;
        StringBuffer stringBuffer = new StringBuffer(2048);
        if (c0703a != null && (m936c = C0704b.m912a().m936c(c0703a)) != null) {
            stringBuffer.append(m936c);
        }
        if (c0714l != null) {
            String m1042b = i == 0 ? z ? c0714l.m1042b() : c0714l.m1045c() : c0714l.m1048d();
            if (m1042b != null) {
                stringBuffer.append(m1042b);
            }
        }
        if (location != null) {
            String m977b = (f1388d == 0 || i == 0) ? C0709g.m977b(location) : C0709g.m988c(location);
            if (m977b != null) {
                stringBuffer.append(m977b);
            }
        }
        String m1101a = C0720b.m1100a().m1101a(i == 0);
        if (m1101a != null) {
            stringBuffer.append(m1101a);
        }
        if (str != null) {
            stringBuffer.append(str);
        }
        String m653d = C0677d.m647a().m653d();
        if (!TextUtils.isEmpty(m653d)) {
            stringBuffer.append("&bc=").append(m653d);
        }
        stringBuffer.append(C0709g.m959a().m1032m());
        String m934b = C0704b.m912a().m934b(c0703a);
        if (m934b != null && m934b.length() + stringBuffer.length() < 2000) {
            stringBuffer.append(m934b);
        }
        String stringBuffer2 = stringBuffer.toString();
        if (location != null && c0714l != null) {
            try {
                float speed = location.getSpeed();
                int i2 = f1388d;
                int m1053i = c0714l.m1053i();
                int m1037a = c0714l.m1037a();
                boolean m1054j = c0714l.m1054j();
                if (speed < f1377ar && ((i2 == 1 || i2 == 0) && (m1053i < f1379at || m1054j))) {
                    f1400p = 1;
                } else if (speed < f1378as && ((i2 == 1 || i2 == 0 || i2 == 3) && (m1053i < f1380au || m1037a > f1381av))) {
                    f1400p = 2;
                }
            } catch (Exception unused) {
                f1400p = 3;
            }
            return stringBuffer2;
        }
        f1400p = 3;
        return stringBuffer2;
    }

    /* renamed from: a */
    public static String m1141a(String str) {
        return Jni.en1(f1398n + ";" + str);
    }

    /* renamed from: a */
    public static String m1142a(byte[] bArr, String str, boolean z) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & 255);
            if (z) {
                hexString = hexString.toUpperCase();
            }
            if (hexString.length() == 1) {
                sb.append(SessionDescription.SUPPORTED_SDP_VERSION);
            }
            sb.append(hexString).append(str);
        }
        return sb.toString();
    }

    /* renamed from: a */
    public static String m1143a(byte[] bArr, boolean z) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(bArr);
            return m1142a(messageDigest.digest(), "", z);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    /* renamed from: a */
    public static boolean m1144a(double d, double d2) {
        return Math.abs(d - d2) <= 1.192092896E-7d;
    }

    /* renamed from: a */
    public static boolean m1145a(float f, float f2) {
        return Math.abs(f - f2) <= 1.1920929E-7f;
    }

    /* renamed from: a */
    public static boolean m1146a(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager != null) {
            NetworkInfo[] networkInfoArr = null;
            try {
                networkInfoArr = connectivityManager.getAllNetworkInfo();
            } catch (Exception unused) {
            }
            if (networkInfoArr != null) {
                for (NetworkInfo networkInfo : networkInfoArr) {
                    if (networkInfo.getState() == NetworkInfo.State.CONNECTED) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /* renamed from: a */
    public static boolean m1147a(Location location) {
        String str;
        if (location == null || (str = f1359aS) == null || !"huawei".equalsIgnoreCase(str)) {
            return false;
        }
        try {
            Bundle extras = location.getExtras();
            if (extras != null) {
                return (extras.getInt("SourceType") & 128) == 128;
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    /* renamed from: a */
    public static boolean m1148a(BDLocation bDLocation) {
        int locType = bDLocation.getLocType();
        return (locType > 100 && locType < 200) || locType == 62;
    }

    /* renamed from: a */
    public static byte[] m1149a(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return byteArrayOutputStream.toByteArray();
    }

    /* renamed from: b */
    public static int m1150b(Context context) {
        try {
            if (Build.VERSION.SDK_INT > 17) {
                return Settings.Global.getInt(context.getContentResolver(), "airplane_mode_on", 0);
            }
            return 2;
        } catch (Exception unused) {
            return 2;
        }
    }

    /* renamed from: b */
    public static Object m1151b(Object obj, String str) throws Exception {
        Field declaredField = obj.getClass().getDeclaredField(str);
        declaredField.setAccessible(true);
        return declaredField.get(obj);
    }

    /* renamed from: b */
    public static boolean m1152b() {
        return false;
    }

    /* renamed from: b */
    public static boolean m1153b(Context context, String str) {
        try {
            context.getPackageManager().getPackageInfo(str, 1);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    /* renamed from: b */
    public static boolean m1154b(String str) {
        try {
            return Class.forName(str) != null;
        } catch (Throwable unused) {
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0047 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static byte[] m1155b(byte[] r4) {
        /*
            r0 = 0
            if (r4 == 0) goto L50
            int r1 = r4.length
            if (r1 != 0) goto L7
            goto L50
        L7:
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream
            r1.<init>()
            java.io.ByteArrayInputStream r2 = new java.io.ByteArrayInputStream
            r2.<init>(r4)
            r4 = 0
            java.util.zip.GZIPInputStream r3 = new java.util.zip.GZIPInputStream     // Catch: java.lang.Throwable -> L2b java.io.IOException -> L2f
            r3.<init>(r2)     // Catch: java.lang.Throwable -> L2b java.io.IOException -> L2f
            r4 = 2048(0x800, float:2.87E-42)
            byte[] r4 = new byte[r4]     // Catch: java.io.IOException -> L29 java.lang.Throwable -> L44
        L1b:
            int r2 = r3.read(r4)     // Catch: java.io.IOException -> L29 java.lang.Throwable -> L44
            if (r2 < 0) goto L25
            r1.write(r4, r0, r2)     // Catch: java.io.IOException -> L29 java.lang.Throwable -> L44
            goto L1b
        L25:
            r3.close()     // Catch: java.io.IOException -> L3b
            goto L3f
        L29:
            r4 = move-exception
            goto L32
        L2b:
            r0 = move-exception
            r3 = r4
            r4 = r0
            goto L45
        L2f:
            r0 = move-exception
            r3 = r4
            r4 = r0
        L32:
            r4.printStackTrace()     // Catch: java.lang.Throwable -> L44
            if (r3 == 0) goto L3f
            r3.close()     // Catch: java.io.IOException -> L3b
            goto L3f
        L3b:
            r4 = move-exception
            r4.printStackTrace()
        L3f:
            byte[] r4 = r1.toByteArray()
            return r4
        L44:
            r4 = move-exception
        L45:
            if (r3 == 0) goto L4f
            r3.close()     // Catch: java.io.IOException -> L4b
            goto L4f
        L4b:
            r0 = move-exception
            r0.printStackTrace()
        L4f:
            throw r4
        L50:
            byte[] r4 = new byte[r0]
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.p012h.C0733o.m1155b(byte[]):byte[]");
    }

    /* renamed from: c */
    public static int m1156c(Context context) {
        if (Build.VERSION.SDK_INT < 19) {
            return -2;
        }
        try {
            return Settings.Secure.getInt(context.getContentResolver(), "location_mode", -1);
        } catch (Exception unused) {
            return -1;
        }
    }

    /* renamed from: c */
    public static String m1157c() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress nextElement = inetAddresses.nextElement();
                    if (!nextElement.isLoopbackAddress() && (nextElement instanceof Inet6Address) && nextElement.getHostAddress() != null && !nextElement.getHostAddress().startsWith("fe80:")) {
                        return nextElement.getHostAddress();
                    }
                }
            }
            return "";
        } catch (Throwable unused) {
            return "";
        }
    }

    /* renamed from: c */
    public static String m1158c(String str) {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop " + str).getInputStream()), 1024);
            try {
                String readLine = bufferedReader.readLine();
                bufferedReader.close();
                try {
                    bufferedReader.close();
                } catch (IOException unused) {
                }
                if (TextUtils.isEmpty(readLine)) {
                    return null;
                }
                return readLine;
            } catch (Exception unused2) {
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException unused3) {
                    }
                }
                return null;
            } catch (Throwable th) {
                th = th;
                bufferedReader2 = bufferedReader;
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (IOException unused4) {
                    }
                }
                throw th;
            }
        } catch (Exception unused5) {
            bufferedReader = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* renamed from: d */
    public static long m1159d(String str) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(str).getTime() / 1000;
        } catch (Exception unused) {
            return 0L;
        }
    }

    /* renamed from: d */
    public static String m1160d() {
        return "https://daup.map.baidu.com/cltr/rcvr";
    }

    /* renamed from: d */
    public static boolean m1161d(Context context) {
        int i;
        if (context == null) {
            return true;
        }
        try {
            i = m1135a(context, Permission.ACCESS_COARSE_LOCATION);
        } catch (Exception e) {
            e.printStackTrace();
            i = 1;
        }
        boolean z = i == 1;
        if (z && Build.VERSION.SDK_INT >= 23) {
            try {
                if (Settings.Secure.getInt(context.getContentResolver(), "location_mode", 1) == 0) {
                    return false;
                }
            } catch (Exception unused) {
            }
        }
        return z;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x003f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String m1162e() {
        /*
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 28
            r2 = 0
            if (r0 > r1) goto L20
            java.lang.String r0 = android.os.Environment.getExternalStorageState()     // Catch: java.lang.Exception -> L1c
            java.lang.String r3 = "mounted"
            boolean r0 = r0.equals(r3)     // Catch: java.lang.Exception -> L1c
            if (r0 == 0) goto L20
            java.io.File r0 = android.os.Environment.getExternalStorageDirectory()     // Catch: java.lang.Exception -> L1c
            java.lang.String r0 = r0.getPath()     // Catch: java.lang.Exception -> L1c
            goto L21
        L1c:
            r0 = move-exception
            r0.printStackTrace()
        L20:
            r0 = r2
        L21:
            if (r0 != 0) goto L3d
            int r3 = android.os.Build.VERSION.SDK_INT
            if (r3 <= r1) goto L3d
            android.content.Context r1 = com.baidu.location.ServiceC0702f.getServiceContext()
            if (r1 == 0) goto L3d
            android.content.Context r0 = com.baidu.location.ServiceC0702f.getServiceContext()     // Catch: java.lang.Exception -> L3c
            java.lang.String r1 = android.os.Environment.DIRECTORY_MOVIES     // Catch: java.lang.Exception -> L3c
            java.io.File r0 = r0.getExternalFilesDir(r1)     // Catch: java.lang.Exception -> L3c
            java.lang.String r0 = r0.getAbsolutePath()     // Catch: java.lang.Exception -> L3c
            goto L3d
        L3c:
            r0 = r2
        L3d:
            if (r0 == 0) goto L66
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L61
            r1.<init>()     // Catch: java.lang.Exception -> L61
            java.lang.StringBuilder r1 = r1.append(r0)     // Catch: java.lang.Exception -> L61
            java.lang.String r3 = "/baidu/tempdata"
            java.lang.StringBuilder r1 = r1.append(r3)     // Catch: java.lang.Exception -> L61
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Exception -> L61
            java.io.File r3 = new java.io.File     // Catch: java.lang.Exception -> L61
            r3.<init>(r1)     // Catch: java.lang.Exception -> L61
            boolean r1 = r3.exists()     // Catch: java.lang.Exception -> L61
            if (r1 != 0) goto L66
            r3.mkdirs()     // Catch: java.lang.Exception -> L61
            goto L66
        L61:
            r0 = move-exception
            r0.printStackTrace()
            goto L67
        L66:
            r2 = r0
        L67:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.p012h.C0733o.m1162e():java.lang.String");
    }

    /* renamed from: e */
    public static String m1163e(Context context) {
        StringBuilder append;
        int m1135a = m1135a(context, Permission.ACCESS_COARSE_LOCATION);
        int m1135a2 = m1135a(context, Permission.ACCESS_FINE_LOCATION);
        int m1135a3 = m1135a(context, Permission.READ_PHONE_STATE);
        if (Build.VERSION.SDK_INT >= 29) {
            append = new StringBuilder().append("&per=").append(m1135a).append("|").append(m1135a2).append("|").append(m1135a3).append("|").append(m1135a(context, Permission.ACCESS_BACKGROUND_LOCATION));
        } else {
            append = new StringBuilder().append("&per=").append(m1135a).append("|").append(m1135a2).append("|").append(m1135a3);
        }
        return append.toString();
    }

    /* renamed from: f */
    public static String m1164f() {
        String m1162e = m1162e();
        if (m1162e == null) {
            return null;
        }
        return m1162e + "/baidu/tempdata";
    }

    /* renamed from: f */
    public static String m1165f(Context context) {
        int i = -1;
        if (context != null) {
            try {
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
                if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                    i = activeNetworkInfo.getType();
                }
            } catch (Throwable unused) {
            }
        }
        return "&netc=" + i;
    }

    /* renamed from: g */
    public static String m1166g() {
        try {
            File file = new File(ServiceC0702f.getServiceContext().getFilesDir() + File.separator + "lldt");
            if (!file.exists()) {
                file.mkdirs();
            }
            return file.getAbsolutePath();
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: g */
    public static String m1167g(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: h */
    public static int m1168h(Context context) {
        int m1135a = m1135a(context, Permission.ACCESS_FINE_LOCATION) | m1135a(context, Permission.ACCESS_COARSE_LOCATION);
        if (m1156c(context) != 0 && m1135a == 1) {
            return 1;
        }
        if (m1156c(context) == 0 || m1135a == 1) {
            return (m1156c(context) >= 1 || m1135a != 1) ? 0 : -1;
        }
        return -2;
    }

    /* renamed from: h */
    public static String m1169h() {
        try {
            File file = new File(ServiceC0702f.getServiceContext().getFilesDir() + File.separator + "/baidu/tempdata");
            if (!file.exists()) {
                file.mkdirs();
            }
            return ServiceC0702f.getServiceContext().getFilesDir().getPath();
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: i */
    public static String m1170i() {
        try {
            File file = new File(ServiceC0702f.getServiceContext().getFilesDir() + File.separator + "/baidu/tempdata");
            if (!file.exists()) {
                file.mkdirs();
            }
            return ServiceC0702f.getServiceContext().getFilesDir().getPath() + File.separator + "/baidu/tempdata";
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: j */
    public static String m1171j() {
        return m1158c("ro.mediatek.platform");
    }

    /* renamed from: k */
    public static SSLSocketFactory m1172k() throws Exception {
        TrustManager[] trustManagerArr = {new C0734p()};
        SSLContext sSLContext = SSLContext.getInstance(IMAPSClient.DEFAULT_PROTOCOL);
        sSLContext.init(null, trustManagerArr, new SecureRandom());
        return sSLContext.getSocketFactory();
    }

    /* renamed from: l */
    public static boolean m1173l() {
        if (ServiceC0702f.getServiceContext() == null) {
            return false;
        }
        return Build.VERSION.SDK_INT >= 31 && m1135a(ServiceC0702f.getServiceContext(), Permission.ACCESS_FINE_LOCATION) == 0 && m1135a(ServiceC0702f.getServiceContext(), Permission.ACCESS_COARSE_LOCATION) == 1;
    }
}