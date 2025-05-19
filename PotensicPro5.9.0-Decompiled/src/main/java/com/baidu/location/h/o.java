package com.baidu.location.h;

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

/* loaded from: classes.dex */
public class o {
    public static float A = 2.3f;
    public static float B = 3.8f;
    public static int C = 3;
    public static int D = 10;
    public static int E = 2;
    public static int F = 7;
    public static int G = 20;
    public static int H = 70;
    public static int I = 120;
    public static float J = 2.0f;
    public static float K = 10.0f;
    public static float L = 50.0f;
    public static float M = 200.0f;
    public static int N = 16;
    public static int O = 32;
    public static float P = 0.9f;
    public static int Q = 10000;
    public static float R = 0.5f;
    public static float S = 0.0f;
    public static float T = 0.1f;
    public static int U = 30;
    public static int V = 100;
    public static int W = 0;
    public static int X = 0;
    public static int Y = 0;
    public static int Z = 420000;
    public static boolean a = false;
    public static double aA = -0.10000000149011612d;
    public static int aB = 0;
    public static int aC = 0;
    public static int aD = 1;
    public static int aE = 1;
    public static int aF = 0;
    public static float aG = 0.8f;
    public static float aH = 0.2f;
    public static boolean aI = false;
    public static int aJ = -1;
    public static int aK = 10;
    public static int aL = 3;
    public static int aM = 40;
    public static double[] aN = null;
    public static int aO = 1;
    public static int aP = 1;
    public static int aQ = 1;
    public static boolean aa = true;
    public static boolean ab = true;
    public static int ac = 20;
    public static int ad = 300;
    public static int ae = 1000;
    public static int af = Integer.MAX_VALUE;
    public static long ag = 900000;
    public static long ah = 420000;
    public static long ai = 180000;
    public static long aj = 0;
    public static long ak = 15;
    public static long al = 300000;
    public static int am = 1000;
    public static int an = 0;
    public static int ao = 30000;
    public static int ap = 30000;
    public static float aq = 10.0f;
    public static float ar = 6.0f;
    public static float as = 10.0f;
    public static int at = 60;
    public static int au = 70;
    public static int av = 6;
    public static String aw = null;
    public static boolean ax = false;
    public static int ay = 16;
    public static float az = 0.75f;
    public static boolean b = false;
    public static boolean c = false;
    public static int d = 0;
    public static String e = "no";
    public static int f = 4;
    public static boolean g = false;
    public static boolean h = false;
    public static boolean i = false;
    public static boolean j = false;
    public static boolean k = false;
    public static boolean l = false;
    public static String m = "gcj02";
    public static String n = "";
    public static boolean o = true;
    public static int p = 3;
    public static double q = 0.0d;
    public static double r = 0.0d;
    public static double s = 0.0d;
    public static double t = 0.0d;
    public static int u = 0;
    public static byte[] v = null;
    public static boolean w = false;
    public static int x = 0;
    public static float y = 1.1f;
    public static float z = 2.2f;
    private static String aS = Build.MANUFACTURER;
    public static boolean aR = false;

    public static double a(double d2, double d3, double d4, double d5) {
        Location.distanceBetween(d2, d3, d4, d5, new float[1]);
        return r0[0];
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0016 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0017 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int a(android.content.Context r4, java.lang.String r5) {
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
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.h.o.a(android.content.Context, java.lang.String):int");
    }

    public static int a(Object obj, String str) throws Exception {
        Method declaredMethod = obj.getClass().getDeclaredMethod(str, null);
        if (!declaredMethod.isAccessible()) {
            declaredMethod.setAccessible(true);
        }
        return ((Integer) declaredMethod.invoke(obj, null)).intValue();
    }

    public static int a(String str, String str2, String str3) {
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

    public static String a() {
        Calendar calendar = Calendar.getInstance();
        int i2 = calendar.get(5);
        return String.format(Locale.CHINA, "%d-%02d-%02d %02d:%02d:%02d", Integer.valueOf(calendar.get(1)), Integer.valueOf(calendar.get(2) + 1), Integer.valueOf(i2), Integer.valueOf(calendar.get(11)), Integer.valueOf(calendar.get(12)), Integer.valueOf(calendar.get(13)));
    }

    public static String a(com.baidu.location.f.a aVar, com.baidu.location.f.l lVar, Location location, String str, int i2) {
        return a(aVar, lVar, location, str, i2, false);
    }

    public static String a(com.baidu.location.f.a aVar, com.baidu.location.f.l lVar, Location location, String str, int i2, boolean z2) {
        String c2;
        StringBuffer stringBuffer = new StringBuffer(2048);
        if (aVar != null && (c2 = com.baidu.location.f.b.a().c(aVar)) != null) {
            stringBuffer.append(c2);
        }
        if (lVar != null) {
            String b2 = i2 == 0 ? z2 ? lVar.b() : lVar.c() : lVar.d();
            if (b2 != null) {
                stringBuffer.append(b2);
            }
        }
        if (location != null) {
            String b3 = (d == 0 || i2 == 0) ? com.baidu.location.f.g.b(location) : com.baidu.location.f.g.c(location);
            if (b3 != null) {
                stringBuffer.append(b3);
            }
        }
        String a2 = b.a().a(i2 == 0);
        if (a2 != null) {
            stringBuffer.append(a2);
        }
        if (str != null) {
            stringBuffer.append(str);
        }
        String d2 = com.baidu.location.c.d.a().d();
        if (!TextUtils.isEmpty(d2)) {
            stringBuffer.append("&bc=").append(d2);
        }
        stringBuffer.append(com.baidu.location.f.g.a().m());
        String b4 = com.baidu.location.f.b.a().b(aVar);
        if (b4 != null && b4.length() + stringBuffer.length() < 2000) {
            stringBuffer.append(b4);
        }
        String stringBuffer2 = stringBuffer.toString();
        if (location != null && lVar != null) {
            try {
                float speed = location.getSpeed();
                int i3 = d;
                int i4 = lVar.i();
                int a3 = lVar.a();
                boolean j2 = lVar.j();
                if (speed < ar && ((i3 == 1 || i3 == 0) && (i4 < at || j2))) {
                    p = 1;
                } else if (speed < as && ((i3 == 1 || i3 == 0 || i3 == 3) && (i4 < au || a3 > av))) {
                    p = 2;
                }
            } catch (Exception unused) {
                p = 3;
            }
            return stringBuffer2;
        }
        p = 3;
        return stringBuffer2;
    }

    public static String a(String str) {
        return Jni.en1(n + ";" + str);
    }

    public static String a(byte[] bArr, String str, boolean z2) {
        StringBuilder sb = new StringBuilder();
        for (byte b2 : bArr) {
            String hexString = Integer.toHexString(b2 & 255);
            if (z2) {
                hexString = hexString.toUpperCase();
            }
            if (hexString.length() == 1) {
                sb.append(SessionDescription.SUPPORTED_SDP_VERSION);
            }
            sb.append(hexString).append(str);
        }
        return sb.toString();
    }

    public static String a(byte[] bArr, boolean z2) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(bArr);
            return a(messageDigest.digest(), "", z2);
        } catch (NoSuchAlgorithmException e2) {
            throw new RuntimeException(e2);
        }
    }

    public static boolean a(double d2, double d3) {
        return Math.abs(d2 - d3) <= 1.192092896E-7d;
    }

    public static boolean a(float f2, float f3) {
        return Math.abs(f2 - f3) <= 1.1920929E-7f;
    }

    public static boolean a(Context context) {
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

    public static boolean a(Location location) {
        String str;
        if (location == null || (str = aS) == null || !"huawei".equalsIgnoreCase(str)) {
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

    public static boolean a(BDLocation bDLocation) {
        int locType = bDLocation.getLocType();
        return (locType > 100 && locType < 200) || locType == 62;
    }

    public static byte[] a(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static int b(Context context) {
        try {
            if (Build.VERSION.SDK_INT > 17) {
                return Settings.Global.getInt(context.getContentResolver(), "airplane_mode_on", 0);
            }
            return 2;
        } catch (Exception unused) {
            return 2;
        }
    }

    public static Object b(Object obj, String str) throws Exception {
        Field declaredField = obj.getClass().getDeclaredField(str);
        declaredField.setAccessible(true);
        return declaredField.get(obj);
    }

    public static boolean b() {
        return false;
    }

    public static boolean b(Context context, String str) {
        try {
            context.getPackageManager().getPackageInfo(str, 1);
            return true;
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static boolean b(String str) {
        try {
            return Class.forName(str) != null;
        } catch (Throwable unused) {
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0047 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static byte[] b(byte[] r4) {
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
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.h.o.b(byte[]):byte[]");
    }

    public static int c(Context context) {
        if (Build.VERSION.SDK_INT < 19) {
            return -2;
        }
        try {
            return Settings.Secure.getInt(context.getContentResolver(), "location_mode", -1);
        } catch (Exception unused) {
            return -1;
        }
    }

    public static String c() {
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

    public static String c(String str) {
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

    public static long d(String str) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(str).getTime() / 1000;
        } catch (Exception unused) {
            return 0L;
        }
    }

    public static String d() {
        return "https://daup.map.baidu.com/cltr/rcvr";
    }

    public static boolean d(Context context) {
        int i2;
        if (context == null) {
            return true;
        }
        try {
            i2 = a(context, Permission.ACCESS_COARSE_LOCATION);
        } catch (Exception e2) {
            e2.printStackTrace();
            i2 = 1;
        }
        boolean z2 = i2 == 1;
        if (z2 && Build.VERSION.SDK_INT >= 23) {
            try {
                if (Settings.Secure.getInt(context.getContentResolver(), "location_mode", 1) == 0) {
                    return false;
                }
            } catch (Exception unused) {
            }
        }
        return z2;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x003f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String e() {
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
            android.content.Context r1 = com.baidu.location.f.getServiceContext()
            if (r1 == 0) goto L3d
            android.content.Context r0 = com.baidu.location.f.getServiceContext()     // Catch: java.lang.Exception -> L3c
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
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.h.o.e():java.lang.String");
    }

    public static String e(Context context) {
        StringBuilder append;
        int a2 = a(context, Permission.ACCESS_COARSE_LOCATION);
        int a3 = a(context, Permission.ACCESS_FINE_LOCATION);
        int a4 = a(context, Permission.READ_PHONE_STATE);
        if (Build.VERSION.SDK_INT >= 29) {
            append = new StringBuilder().append("&per=").append(a2).append("|").append(a3).append("|").append(a4).append("|").append(a(context, Permission.ACCESS_BACKGROUND_LOCATION));
        } else {
            append = new StringBuilder().append("&per=").append(a2).append("|").append(a3).append("|").append(a4);
        }
        return append.toString();
    }

    public static String f() {
        String e2 = e();
        if (e2 == null) {
            return null;
        }
        return e2 + "/baidu/tempdata";
    }

    public static String f(Context context) {
        int i2 = -1;
        if (context != null) {
            try {
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
                if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                    i2 = activeNetworkInfo.getType();
                }
            } catch (Throwable unused) {
            }
        }
        return "&netc=" + i2;
    }

    public static String g() {
        try {
            File file = new File(com.baidu.location.f.getServiceContext().getFilesDir() + File.separator + "lldt");
            if (!file.exists()) {
                file.mkdirs();
            }
            return file.getAbsolutePath();
        } catch (Exception unused) {
            return null;
        }
    }

    public static String g(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Exception unused) {
            return null;
        }
    }

    public static int h(Context context) {
        int a2 = a(context, Permission.ACCESS_FINE_LOCATION) | a(context, Permission.ACCESS_COARSE_LOCATION);
        if (c(context) != 0 && a2 == 1) {
            return 1;
        }
        if (c(context) == 0 || a2 == 1) {
            return (c(context) >= 1 || a2 != 1) ? 0 : -1;
        }
        return -2;
    }

    public static String h() {
        try {
            File file = new File(com.baidu.location.f.getServiceContext().getFilesDir() + File.separator + "/baidu/tempdata");
            if (!file.exists()) {
                file.mkdirs();
            }
            return com.baidu.location.f.getServiceContext().getFilesDir().getPath();
        } catch (Exception unused) {
            return null;
        }
    }

    public static String i() {
        try {
            File file = new File(com.baidu.location.f.getServiceContext().getFilesDir() + File.separator + "/baidu/tempdata");
            if (!file.exists()) {
                file.mkdirs();
            }
            return com.baidu.location.f.getServiceContext().getFilesDir().getPath() + File.separator + "/baidu/tempdata";
        } catch (Exception unused) {
            return null;
        }
    }

    public static String j() {
        return c("ro.mediatek.platform");
    }

    public static SSLSocketFactory k() throws Exception {
        TrustManager[] trustManagerArr = {new p()};
        SSLContext sSLContext = SSLContext.getInstance(IMAPSClient.DEFAULT_PROTOCOL);
        sSLContext.init(null, trustManagerArr, new SecureRandom());
        return sSLContext.getSocketFactory();
    }

    public static boolean l() {
        if (com.baidu.location.f.getServiceContext() == null) {
            return false;
        }
        return Build.VERSION.SDK_INT >= 31 && a(com.baidu.location.f.getServiceContext(), Permission.ACCESS_FINE_LOCATION) == 0 && a(com.baidu.location.f.getServiceContext(), Permission.ACCESS_COARSE_LOCATION) == 1;
    }
}
