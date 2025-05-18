package com.tencent.bugly.crashreport.common.info;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import android.provider.Settings;
import com.tencent.bugly.proguard.C3401x;
import com.tencent.bugly.proguard.C3403z;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import net.lingala.zip4j.util.InternalZipConstants;
import org.apache.commons.lang3.StringUtils;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.crashreport.common.info.b */
/* loaded from: classes3.dex */
public class C3338b {

    /* renamed from: a */
    private static final String[] f2993a = {"/su", "/su/bin/su", "/sbin/su", "/data/local/xbin/su", "/data/local/bin/su", "/data/local/su", "/system/xbin/su", "/system/bin/su", "/system/sd/xbin/su", "/system/bin/failsafe/su", "/system/bin/cufsdosck", "/system/xbin/cufsdosck", "/system/bin/cufsmgr", "/system/xbin/cufsmgr", "/system/bin/cufaevdd", "/system/xbin/cufaevdd", "/system/bin/conbb", "/system/xbin/conbb"};

    /* renamed from: b */
    private static final String[] f2994b = {"com.ami.duosupdater.ui", "com.ami.launchmetro", "com.ami.syncduosservices", "com.bluestacks.home", "com.bluestacks.windowsfilemanager", "com.bluestacks.settings", "com.bluestacks.bluestackslocationprovider", "com.bluestacks.appsettings", "com.bluestacks.bstfolder", "com.bluestacks.BstCommandProcessor", "com.bluestacks.s2p", "com.bluestacks.setup", "com.kaopu001.tiantianserver", "com.kpzs.helpercenter", "com.kaopu001.tiantianime", "com.android.development_settings", "com.android.development", "com.android.customlocale2", "com.genymotion.superuser", "com.genymotion.clipboardproxy", "com.uc.xxzs.keyboard", "com.uc.xxzs", "com.blue.huang17.agent", "com.blue.huang17.launcher", "com.blue.huang17.ime", "com.microvirt.guide", "com.microvirt.market", "com.microvirt.memuime", "cn.itools.vm.launcher", "cn.itools.vm.proxy", "cn.itools.vm.softkeyboard", "cn.itools.avdmarket", "com.syd.IME", "com.bignox.app.store.hd", "com.bignox.launcher", "com.bignox.app.phone", "com.bignox.app.noxservice", "com.android.noxpush", "com.haimawan.push", "me.haima.helpcenter", "com.windroy.launcher", "com.windroy.superuser", "com.windroy.launcher", "com.windroy.ime", "com.android.flysilkworm", "com.android.emu.inputservice", "com.tiantian.ime", "com.microvirt.launcher", "me.le8.androidassist", "com.vphone.helper", "com.vphone.launcher", "com.duoyi.giftcenter.giftcenter"};

    /* renamed from: c */
    private static final String[] f2995c = {"/sys/devices/system/cpu/cpu0/cpufreq/scaling_cur_freq", "/system/lib/libc_malloc_debug_qemu.so", "/sys/qemu_trace", "/system/bin/qemu-props", "/dev/socket/qemud", "/dev/qemu_pipe", "/dev/socket/baseband_genyd", "/dev/socket/genyd"};

    /* renamed from: j */
    public static String m1917j() {
        return "";
    }

    /* renamed from: a */
    public static String m1899a() {
        try {
            return Build.MODEL;
        } catch (Throwable th) {
            if (C3401x.m2247a(th)) {
                return "fail";
            }
            th.printStackTrace();
            return "fail";
        }
    }

    /* renamed from: b */
    public static String m1902b() {
        try {
            return Build.VERSION.RELEASE;
        } catch (Throwable th) {
            if (C3401x.m2247a(th)) {
                return "fail";
            }
            th.printStackTrace();
            return "fail";
        }
    }

    /* renamed from: c */
    public static int m1904c() {
        try {
            return Build.VERSION.SDK_INT;
        } catch (Throwable th) {
            if (C3401x.m2247a(th)) {
                return -1;
            }
            th.printStackTrace();
            return -1;
        }
    }

    /* renamed from: a */
    public static String m1900a(Context context) {
        String str = "fail";
        if (context == null) {
            return "fail";
        }
        try {
            str = Settings.Secure.getString(context.getContentResolver(), "android_id");
            return str == null ? "null" : str.toLowerCase();
        } catch (Throwable th) {
            if (!C3401x.m2247a(th)) {
                C3401x.m2246a("Failed to get Android ID.", new Object[0]);
            }
            return str;
        }
    }

    /* renamed from: n */
    private static boolean m1921n() {
        try {
            return Environment.getExternalStorageState().equals("mounted");
        } catch (Throwable th) {
            if (C3401x.m2247a(th)) {
                return false;
            }
            th.printStackTrace();
            return false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x004e, code lost:
    
        r0 = java.lang.System.getProperty("os.arch");
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String m1901a(android.content.Context r4, boolean r5) {
        /*
            r0 = 0
            java.lang.String r1 = "fail"
            if (r5 == 0) goto L4c
            java.lang.String r5 = "ro.product.cpu.abilist"
            java.lang.String r5 = com.tencent.bugly.proguard.C3403z.m2280a(r4, r5)     // Catch: java.lang.Throwable -> L4a
            boolean r2 = com.tencent.bugly.proguard.C3403z.m2294a(r5)     // Catch: java.lang.Throwable -> L4a
            if (r2 != 0) goto L17
            boolean r2 = r5.equals(r1)     // Catch: java.lang.Throwable -> L4a
            if (r2 == 0) goto L1d
        L17:
            java.lang.String r5 = "ro.product.cpu.abi"
            java.lang.String r5 = com.tencent.bugly.proguard.C3403z.m2280a(r4, r5)     // Catch: java.lang.Throwable -> L4a
        L1d:
            boolean r4 = com.tencent.bugly.proguard.C3403z.m2294a(r5)     // Catch: java.lang.Throwable -> L4a
            if (r4 != 0) goto L4c
            boolean r4 = r5.equals(r1)     // Catch: java.lang.Throwable -> L4a
            if (r4 == 0) goto L2a
            goto L4c
        L2a:
            java.lang.Class<com.tencent.bugly.crashreport.common.info.b> r4 = com.tencent.bugly.crashreport.common.info.C3338b.class
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L4a
            java.lang.String r2 = "ABI list: "
            r0.<init>(r2)     // Catch: java.lang.Throwable -> L4a
            java.lang.StringBuilder r0 = r0.append(r5)     // Catch: java.lang.Throwable -> L4a
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L4a
            r2 = 0
            java.lang.Object[] r3 = new java.lang.Object[r2]     // Catch: java.lang.Throwable -> L4a
            com.tencent.bugly.proguard.C3401x.m2248b(r4, r0, r3)     // Catch: java.lang.Throwable -> L4a
            java.lang.String r4 = ","
            java.lang.String[] r4 = r5.split(r4)     // Catch: java.lang.Throwable -> L4a
            r0 = r4[r2]     // Catch: java.lang.Throwable -> L4a
            goto L4c
        L4a:
            r4 = move-exception
            goto L62
        L4c:
            if (r0 != 0) goto L54
            java.lang.String r4 = "os.arch"
            java.lang.String r0 = java.lang.System.getProperty(r4)     // Catch: java.lang.Throwable -> L4a
        L54:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L4a
            r4.<init>()     // Catch: java.lang.Throwable -> L4a
            java.lang.StringBuilder r4 = r4.append(r0)     // Catch: java.lang.Throwable -> L4a
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> L4a
            return r4
        L62:
            boolean r5 = com.tencent.bugly.proguard.C3401x.m2247a(r4)
            if (r5 != 0) goto L6b
            r4.printStackTrace()
        L6b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.common.info.C3338b.m1901a(android.content.Context, boolean):java.lang.String");
    }

    /* renamed from: d */
    public static long m1906d() {
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            return statFs.getBlockCount() * statFs.getBlockSize();
        } catch (Throwable th) {
            if (!C3401x.m2247a(th)) {
                th.printStackTrace();
            }
            return -1L;
        }
    }

    /* renamed from: e */
    public static long m1908e() {
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            return statFs.getAvailableBlocks() * statFs.getBlockSize();
        } catch (Throwable th) {
            if (!C3401x.m2247a(th)) {
                th.printStackTrace();
            }
            return -1L;
        }
    }

    /* renamed from: f */
    public static long m1910f() {
        FileReader fileReader;
        Throwable th;
        BufferedReader bufferedReader;
        try {
            fileReader = new FileReader("/proc/meminfo");
            try {
                bufferedReader = new BufferedReader(fileReader, 2048);
            } catch (Throwable th2) {
                th = th2;
                bufferedReader = null;
            }
        } catch (Throwable th3) {
            fileReader = null;
            th = th3;
            bufferedReader = null;
        }
        try {
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                long parseLong = Long.parseLong(readLine.split(":\\s+", 2)[1].toLowerCase().replace("kb", "").trim()) << 10;
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    if (!C3401x.m2247a(e)) {
                        e.printStackTrace();
                    }
                }
                try {
                    fileReader.close();
                } catch (IOException e2) {
                    if (!C3401x.m2247a(e2)) {
                        e2.printStackTrace();
                    }
                }
                return parseLong;
            }
            try {
                bufferedReader.close();
            } catch (IOException e3) {
                if (!C3401x.m2247a(e3)) {
                    e3.printStackTrace();
                }
            }
            try {
                fileReader.close();
                return -1L;
            } catch (IOException e4) {
                if (C3401x.m2247a(e4)) {
                    return -1L;
                }
                e4.printStackTrace();
                return -1L;
            }
        } catch (Throwable th4) {
            th = th4;
            try {
                if (!C3401x.m2247a(th)) {
                    th.printStackTrace();
                }
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e5) {
                        if (!C3401x.m2247a(e5)) {
                            e5.printStackTrace();
                        }
                    }
                }
                if (fileReader == null) {
                    return -2L;
                }
                try {
                    fileReader.close();
                    return -2L;
                } catch (IOException e6) {
                    if (C3401x.m2247a(e6)) {
                        return -2L;
                    }
                    e6.printStackTrace();
                    return -2L;
                }
            } catch (Throwable th5) {
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e7) {
                        if (!C3401x.m2247a(e7)) {
                            e7.printStackTrace();
                        }
                    }
                }
                if (fileReader != null) {
                    try {
                        fileReader.close();
                    } catch (IOException e8) {
                        if (!C3401x.m2247a(e8)) {
                            e8.printStackTrace();
                        }
                    }
                }
                throw th5;
            }
        }
    }

    /* renamed from: g */
    public static long m1912g() {
        FileReader fileReader;
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        try {
            fileReader = new FileReader("/proc/meminfo");
            try {
                bufferedReader = new BufferedReader(fileReader, 2048);
            } catch (Throwable th) {
                th = th;
            }
        } catch (Throwable th2) {
            th = th2;
            fileReader = null;
        }
        try {
            bufferedReader.readLine();
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    if (!C3401x.m2247a(e)) {
                        e.printStackTrace();
                    }
                }
                try {
                    fileReader.close();
                } catch (IOException e2) {
                    if (!C3401x.m2247a(e2)) {
                        e2.printStackTrace();
                    }
                }
                return -1L;
            }
            long parseLong = (Long.parseLong(readLine.split(":\\s+", 2)[1].toLowerCase().replace("kb", "").trim()) << 10) + 0;
            String readLine2 = bufferedReader.readLine();
            if (readLine2 == null) {
                try {
                    bufferedReader.close();
                } catch (IOException e3) {
                    if (!C3401x.m2247a(e3)) {
                        e3.printStackTrace();
                    }
                }
                try {
                    fileReader.close();
                } catch (IOException e4) {
                    if (!C3401x.m2247a(e4)) {
                        e4.printStackTrace();
                    }
                }
                return -1L;
            }
            long parseLong2 = parseLong + (Long.parseLong(readLine2.split(":\\s+", 2)[1].toLowerCase().replace("kb", "").trim()) << 10);
            String readLine3 = bufferedReader.readLine();
            if (readLine3 == null) {
                try {
                    bufferedReader.close();
                } catch (IOException e5) {
                    if (!C3401x.m2247a(e5)) {
                        e5.printStackTrace();
                    }
                }
                try {
                    fileReader.close();
                } catch (IOException e6) {
                    if (!C3401x.m2247a(e6)) {
                        e6.printStackTrace();
                    }
                }
                return -1L;
            }
            long parseLong3 = parseLong2 + (Long.parseLong(readLine3.split(":\\s+", 2)[1].toLowerCase().replace("kb", "").trim()) << 10);
            try {
                bufferedReader.close();
            } catch (IOException e7) {
                if (!C3401x.m2247a(e7)) {
                    e7.printStackTrace();
                }
            }
            try {
                fileReader.close();
            } catch (IOException e8) {
                if (!C3401x.m2247a(e8)) {
                    e8.printStackTrace();
                }
            }
            return parseLong3;
        } catch (Throwable th3) {
            th = th3;
            bufferedReader2 = bufferedReader;
            try {
                if (!C3401x.m2247a(th)) {
                    th.printStackTrace();
                }
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (IOException e9) {
                        if (!C3401x.m2247a(e9)) {
                            e9.printStackTrace();
                        }
                    }
                }
                if (fileReader == null) {
                    return -2L;
                }
                try {
                    fileReader.close();
                    return -2L;
                } catch (IOException e10) {
                    if (C3401x.m2247a(e10)) {
                        return -2L;
                    }
                    e10.printStackTrace();
                    return -2L;
                }
            } catch (Throwable th4) {
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (IOException e11) {
                        if (!C3401x.m2247a(e11)) {
                            e11.printStackTrace();
                        }
                    }
                }
                if (fileReader != null) {
                    try {
                        fileReader.close();
                    } catch (IOException e12) {
                        if (!C3401x.m2247a(e12)) {
                            e12.printStackTrace();
                        }
                    }
                }
                throw th4;
            }
        }
    }

    /* renamed from: h */
    public static long m1915h() {
        if (!m1921n()) {
            return 0L;
        }
        try {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            return statFs.getBlockCount() * statFs.getBlockSize();
        } catch (Throwable th) {
            if (C3401x.m2247a(th)) {
                return -2L;
            }
            th.printStackTrace();
            return -2L;
        }
    }

    /* renamed from: i */
    public static long m1916i() {
        if (!m1921n()) {
            return 0L;
        }
        try {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            return statFs.getAvailableBlocks() * statFs.getBlockSize();
        } catch (Throwable th) {
            if (C3401x.m2247a(th)) {
                return -2L;
            }
            th.printStackTrace();
            return -2L;
        }
    }

    /* renamed from: k */
    public static String m1918k() {
        try {
            return Build.BRAND;
        } catch (Throwable th) {
            if (!C3401x.m2247a(th)) {
                th.printStackTrace();
            }
            return "fail";
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:57:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:59:? A[RETURN, SYNTHETIC] */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String m1903b(android.content.Context r4) {
        /*
            java.lang.String r0 = "unknown"
            java.lang.String r1 = "connectivity"
            java.lang.Object r1 = r4.getSystemService(r1)     // Catch: java.lang.Exception -> L79
            android.net.ConnectivityManager r1 = (android.net.ConnectivityManager) r1     // Catch: java.lang.Exception -> L79
            android.net.NetworkInfo r1 = r1.getActiveNetworkInfo()     // Catch: java.lang.Exception -> L79
            if (r1 != 0) goto L12
            r4 = 0
            return r4
        L12:
            int r2 = r1.getType()     // Catch: java.lang.Exception -> L79
            r3 = 1
            if (r2 != r3) goto L1d
            java.lang.String r0 = "WIFI"
            goto L83
        L1d:
            int r1 = r1.getType()     // Catch: java.lang.Exception -> L79
            if (r1 != 0) goto L83
            java.lang.String r1 = "phone"
            java.lang.Object r4 = r4.getSystemService(r1)     // Catch: java.lang.Exception -> L79
            android.telephony.TelephonyManager r4 = (android.telephony.TelephonyManager) r4     // Catch: java.lang.Exception -> L79
            if (r4 == 0) goto L83
            int r4 = r4.getNetworkType()     // Catch: java.lang.Exception -> L79
            switch(r4) {
                case 1: goto L61;
                case 2: goto L5e;
                case 3: goto L5b;
                case 4: goto L58;
                case 5: goto L55;
                case 6: goto L52;
                case 7: goto L4f;
                case 8: goto L4c;
                case 9: goto L49;
                case 10: goto L46;
                case 11: goto L43;
                case 12: goto L40;
                case 13: goto L3d;
                case 14: goto L3a;
                case 15: goto L37;
                default: goto L34;
            }     // Catch: java.lang.Exception -> L79
        L34:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L79
            goto L64
        L37:
            java.lang.String r0 = "HSPA+"
            goto L83
        L3a:
            java.lang.String r0 = "eHRPD"
            goto L83
        L3d:
            java.lang.String r0 = "LTE"
            goto L83
        L40:
            java.lang.String r0 = "EVDO_B"
            goto L83
        L43:
            java.lang.String r0 = "iDen"
            goto L83
        L46:
            java.lang.String r0 = "HSPA"
            goto L83
        L49:
            java.lang.String r0 = "HSUPA"
            goto L83
        L4c:
            java.lang.String r0 = "HSDPA"
            goto L83
        L4f:
            java.lang.String r0 = "1xRTT"
            goto L83
        L52:
            java.lang.String r0 = "EVDO_A"
            goto L83
        L55:
            java.lang.String r0 = "EVDO_0"
            goto L83
        L58:
            java.lang.String r0 = "CDMA"
            goto L83
        L5b:
            java.lang.String r0 = "UMTS"
            goto L83
        L5e:
            java.lang.String r0 = "EDGE"
            goto L83
        L61:
            java.lang.String r0 = "GPRS"
            goto L83
        L64:
            java.lang.String r2 = "MOBILE("
            r1.<init>(r2)     // Catch: java.lang.Exception -> L79
            java.lang.StringBuilder r4 = r1.append(r4)     // Catch: java.lang.Exception -> L79
            java.lang.String r1 = ")"
            java.lang.StringBuilder r4 = r4.append(r1)     // Catch: java.lang.Exception -> L79
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Exception -> L79
            r0 = r4
            goto L83
        L79:
            r4 = move-exception
            boolean r1 = com.tencent.bugly.proguard.C3401x.m2247a(r4)
            if (r1 != 0) goto L83
            r4.printStackTrace()
        L83:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.common.info.C3338b.m1903b(android.content.Context):java.lang.String");
    }

    /* renamed from: c */
    public static String m1905c(Context context) {
        String m2280a = C3403z.m2280a(context, "ro.miui.ui.version.name");
        if (!C3403z.m2294a(m2280a) && !m2280a.equals("fail")) {
            return "XiaoMi/MIUI/" + m2280a;
        }
        String m2280a2 = C3403z.m2280a(context, "ro.build.version.emui");
        if (!C3403z.m2294a(m2280a2) && !m2280a2.equals("fail")) {
            return "HuaWei/EMOTION/" + m2280a2;
        }
        String m2280a3 = C3403z.m2280a(context, "ro.lenovo.series");
        if (!C3403z.m2294a(m2280a3) && !m2280a3.equals("fail")) {
            return "Lenovo/VIBE/" + C3403z.m2280a(context, "ro.build.version.incremental");
        }
        String m2280a4 = C3403z.m2280a(context, "ro.build.nubia.rom.name");
        if (!C3403z.m2294a(m2280a4) && !m2280a4.equals("fail")) {
            return "Zte/NUBIA/" + m2280a4 + "_" + C3403z.m2280a(context, "ro.build.nubia.rom.code");
        }
        String m2280a5 = C3403z.m2280a(context, "ro.meizu.product.model");
        if (!C3403z.m2294a(m2280a5) && !m2280a5.equals("fail")) {
            return "Meizu/FLYME/" + C3403z.m2280a(context, "ro.build.display.id");
        }
        String m2280a6 = C3403z.m2280a(context, "ro.build.version.opporom");
        if (!C3403z.m2294a(m2280a6) && !m2280a6.equals("fail")) {
            return "Oppo/COLOROS/" + m2280a6;
        }
        String m2280a7 = C3403z.m2280a(context, "ro.vivo.os.build.display.id");
        if (!C3403z.m2294a(m2280a7) && !m2280a7.equals("fail")) {
            return "vivo/FUNTOUCH/" + m2280a7;
        }
        String m2280a8 = C3403z.m2280a(context, "ro.aa.romver");
        if (!C3403z.m2294a(m2280a8) && !m2280a8.equals("fail")) {
            return "htc/" + m2280a8 + InternalZipConstants.ZIP_FILE_SEPARATOR + C3403z.m2280a(context, "ro.build.description");
        }
        String m2280a9 = C3403z.m2280a(context, "ro.lewa.version");
        if (!C3403z.m2294a(m2280a9) && !m2280a9.equals("fail")) {
            return "tcl/" + m2280a9 + InternalZipConstants.ZIP_FILE_SEPARATOR + C3403z.m2280a(context, "ro.build.display.id");
        }
        String m2280a10 = C3403z.m2280a(context, "ro.gn.gnromvernumber");
        if (!C3403z.m2294a(m2280a10) && !m2280a10.equals("fail")) {
            return "amigo/" + m2280a10 + InternalZipConstants.ZIP_FILE_SEPARATOR + C3403z.m2280a(context, "ro.build.display.id");
        }
        String m2280a11 = C3403z.m2280a(context, "ro.build.tyd.kbstyle_version");
        if (!C3403z.m2294a(m2280a11) && !m2280a11.equals("fail")) {
            return "dido/" + m2280a11;
        }
        return C3403z.m2280a(context, "ro.build.fingerprint") + InternalZipConstants.ZIP_FILE_SEPARATOR + C3403z.m2280a(context, "ro.build.rom.id");
    }

    /* renamed from: d */
    public static String m1907d(Context context) {
        return C3403z.m2280a(context, "ro.board.platform");
    }

    /* renamed from: l */
    public static boolean m1919l() {
        boolean z;
        String[] strArr = f2993a;
        int length = strArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                z = false;
                break;
            }
            if (new File(strArr[i]).exists()) {
                z = true;
                break;
            }
            i++;
        }
        return (Build.TAGS != null && Build.TAGS.contains("test-keys")) || z;
    }

    /* renamed from: e */
    public static boolean m1909e(Context context) {
        if (m1913g(context) != null) {
            return true;
        }
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            String[] strArr = f2995c;
            if (i >= strArr.length) {
                break;
            }
            if (i == 0) {
                if (new File(strArr[i]).exists()) {
                    i++;
                }
                arrayList.add(Integer.valueOf(i));
                i++;
            } else {
                if (!new File(strArr[i]).exists()) {
                    i++;
                }
                arrayList.add(Integer.valueOf(i));
                i++;
            }
        }
        return (arrayList.isEmpty() ? null : arrayList.toString()) != null;
    }

    /* renamed from: g */
    private static String m1913g(Context context) {
        PackageManager packageManager = context.getPackageManager();
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            String[] strArr = f2994b;
            if (i >= strArr.length) {
                break;
            }
            try {
                packageManager.getPackageInfo(strArr[i], 1);
                arrayList.add(Integer.valueOf(i));
            } catch (PackageManager.NameNotFoundException unused) {
            }
            i++;
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return arrayList.toString();
    }

    /* renamed from: f */
    public static boolean m1911f(Context context) {
        return (((m1914h(context) | m1923p()) | m1924q()) | m1922o()) > 0;
    }

    /* renamed from: o */
    private static int m1922o() {
        try {
            Method method = Class.forName("android.app.ActivityManagerNative").getMethod("getDefault", new Class[0]);
            method.setAccessible(true);
            return method.invoke(null, new Object[0]).getClass().getName().startsWith("$Proxy") ? 256 : 0;
        } catch (Exception unused) {
            return 256;
        }
    }

    /* renamed from: h */
    private static int m1914h(Context context) {
        int i;
        PackageManager packageManager = context.getPackageManager();
        try {
            packageManager.getInstallerPackageName("de.robv.android.xposed.installer");
            i = 1;
        } catch (Exception unused) {
            i = 0;
        }
        try {
            packageManager.getInstallerPackageName("com.saurik.substrate");
            return i | 2;
        } catch (Exception unused2) {
            return i;
        }
    }

    /* renamed from: p */
    private static int m1923p() {
        try {
            throw new Exception("detect hook");
        } catch (Exception e) {
            int i = 0;
            int i2 = 0;
            for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                if (stackTraceElement.getClassName().equals("de.robv.android.xposed.XposedBridge") && stackTraceElement.getMethodName().equals("main")) {
                    i |= 4;
                }
                if (stackTraceElement.getClassName().equals("de.robv.android.xposed.XposedBridge") && stackTraceElement.getMethodName().equals("handleHookedMethod")) {
                    i |= 8;
                }
                if (stackTraceElement.getClassName().equals("com.saurik.substrate.MS$2") && stackTraceElement.getMethodName().equals("invoked")) {
                    i |= 16;
                }
                if (stackTraceElement.getClassName().equals("com.android.internal.os.ZygoteInit") && (i2 = i2 + 1) == 2) {
                    i |= 32;
                }
            }
            return i;
        }
    }

    /* JADX WARN: Not initialized variable reg: 3, insn: 0x00b9: MOVE (r1 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]), block:B:69:0x00b9 */
    /* renamed from: q */
    private static int m1924q() {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2;
        IOException e;
        UnsupportedEncodingException e2;
        FileNotFoundException e3;
        int i = 0;
        BufferedReader bufferedReader3 = null;
        try {
            try {
                try {
                    HashSet hashSet = new HashSet();
                    bufferedReader2 = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + Process.myPid() + "/maps"), "utf-8"));
                    while (true) {
                        try {
                            String readLine = bufferedReader2.readLine();
                            if (readLine == null) {
                                break;
                            }
                            if (readLine.endsWith(".so") || readLine.endsWith(".jar")) {
                                hashSet.add(readLine.substring(readLine.lastIndexOf(StringUtils.SPACE) + 1));
                            }
                        } catch (FileNotFoundException e4) {
                            e3 = e4;
                            e3.printStackTrace();
                            if (bufferedReader2 != null) {
                                bufferedReader2.close();
                            }
                            return i;
                        } catch (UnsupportedEncodingException e5) {
                            e2 = e5;
                            e2.printStackTrace();
                            if (bufferedReader2 != null) {
                                bufferedReader2.close();
                            }
                            return i;
                        } catch (IOException e6) {
                            e = e6;
                            e.printStackTrace();
                            if (bufferedReader2 != null) {
                                bufferedReader2.close();
                            }
                            return i;
                        }
                    }
                    Iterator it = hashSet.iterator();
                    while (it.hasNext()) {
                        Object next = it.next();
                        if (((String) next).toLowerCase().contains("xposed")) {
                            i |= 64;
                        }
                        if (((String) next).contains("com.saurik.substrate")) {
                            i |= 128;
                        }
                    }
                    bufferedReader2.close();
                } catch (FileNotFoundException e7) {
                    bufferedReader2 = null;
                    e3 = e7;
                } catch (UnsupportedEncodingException e8) {
                    bufferedReader2 = null;
                    e2 = e8;
                } catch (IOException e9) {
                    bufferedReader2 = null;
                    e = e9;
                } catch (Throwable th) {
                    th = th;
                    if (bufferedReader3 != null) {
                        try {
                            bufferedReader3.close();
                        } catch (IOException e10) {
                            e10.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (IOException e11) {
                e11.printStackTrace();
            }
            return i;
        } catch (Throwable th2) {
            th = th2;
            bufferedReader3 = bufferedReader;
        }
    }

    /* renamed from: m */
    public static boolean m1920m() {
        float maxMemory = (float) (Runtime.getRuntime().maxMemory() / 1048576.0d);
        float f = (float) (Runtime.getRuntime().totalMemory() / 1048576.0d);
        float f2 = maxMemory - f;
        C3401x.m2251c("maxMemory : %f", Float.valueOf(maxMemory));
        C3401x.m2251c("totalMemory : %f", Float.valueOf(f));
        C3401x.m2251c("freeMemory : %f", Float.valueOf(f2));
        return f2 < 10.0f;
    }
}