package com.tencent.bugly.crashreport.crash.jni;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.bugly.crashreport.common.info.C3337a;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.proguard.C3401x;
import com.tencent.bugly.proguard.C3403z;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import org.apache.commons.lang3.BooleanUtils;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.crashreport.crash.jni.b */
/* loaded from: classes3.dex */
public final class C3358b {

    /* renamed from: a */
    private static List<File> f3227a = new ArrayList();

    /* renamed from: d */
    private static Map<String, Integer> m2061d(String str) {
        if (str == null) {
            return null;
        }
        try {
            HashMap hashMap = new HashMap();
            for (String str2 : str.split(",")) {
                String[] split = str2.split(":");
                if (split.length != 2) {
                    C3401x.m2253e("error format at %s", str2);
                    return null;
                }
                hashMap.put(split[0], Integer.valueOf(Integer.parseInt(split[1])));
            }
            return hashMap;
        } catch (Exception e) {
            C3401x.m2253e("error format intStateStr %s", str);
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    protected static String m2053a(String str) {
        if (str == null) {
            return "";
        }
        String[] split = str.split("\n");
        if (split == null || split.length == 0) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        for (String str2 : split) {
            if (!str2.contains("java.lang.Thread.getStackTrace(")) {
                sb.append(str2).append("\n");
            }
        }
        return sb.toString();
    }

    /* renamed from: a */
    private static CrashDetailBean m2051a(Context context, Map<String, String> map, NativeExceptionHandler nativeExceptionHandler) {
        String str;
        String str2;
        HashMap hashMap;
        if (map == null) {
            return null;
        }
        if (C3337a.m1854a(context) == null) {
            C3401x.m2253e("abnormal com info not created", new Object[0]);
            return null;
        }
        String str3 = map.get("intStateStr");
        if (str3 == null || str3.trim().length() <= 0) {
            C3401x.m2253e("no intStateStr", new Object[0]);
            return null;
        }
        Map<String, Integer> m2061d = m2061d(str3);
        if (m2061d == null) {
            C3401x.m2253e("parse intSateMap fail", Integer.valueOf(map.size()));
            return null;
        }
        try {
            m2061d.get("sino").intValue();
            m2061d.get("sud").intValue();
            String str4 = map.get("soVersion");
            if (TextUtils.isEmpty(str4)) {
                C3401x.m2253e("error format at version", new Object[0]);
                return null;
            }
            String str5 = map.get("errorAddr");
            String str6 = "unknown";
            String str7 = str5 == null ? "unknown" : str5;
            String str8 = map.get("codeMsg");
            if (str8 == null) {
                str8 = "unknown";
            }
            String str9 = map.get("tombPath");
            String str10 = str9 == null ? "unknown" : str9;
            String str11 = map.get("signalName");
            if (str11 == null) {
                str11 = "unknown";
            }
            map.get("errnoMsg");
            String str12 = map.get("stack");
            if (str12 == null) {
                str12 = "unknown";
            }
            String str13 = map.get("jstack");
            if (str13 != null) {
                str12 = str12 + "java:\n" + str13;
            }
            Integer num = m2061d.get("sico");
            if (num == null || num.intValue() <= 0) {
                str = str8;
                str2 = str11;
            } else {
                str2 = str11 + "(" + str8 + ")";
                str = "KERNEL";
            }
            String str14 = map.get("nativeLog");
            byte[] m2296a = (str14 == null || str14.isEmpty()) ? null : C3403z.m2296a((File) null, str14, "BuglyNativeLog.txt");
            String str15 = map.get("sendingProcess");
            if (str15 == null) {
                str15 = "unknown";
            }
            Integer num2 = m2061d.get("spd");
            if (num2 != null) {
                str15 = str15 + "(" + num2 + ")";
            }
            String str16 = str15;
            String str17 = map.get("threadName");
            if (str17 == null) {
                str17 = "unknown";
            }
            Integer num3 = m2061d.get("et");
            if (num3 != null) {
                str17 = str17 + "(" + num3 + ")";
            }
            String str18 = str17;
            String str19 = map.get("processName");
            if (str19 != null) {
                str6 = str19;
            }
            Integer num4 = m2061d.get("ep");
            if (num4 != null) {
                str6 = str6 + "(" + num4 + ")";
            }
            String str20 = str6;
            String str21 = map.get("key-value");
            if (str21 != null) {
                HashMap hashMap2 = new HashMap();
                String[] split = str21.split("\n");
                int length = split.length;
                int i = 0;
                while (i < length) {
                    String[] split2 = split[i].split("=");
                    String[] strArr = split;
                    if (split2.length == 2) {
                        hashMap2.put(split2[0], split2[1]);
                    }
                    i++;
                    split = strArr;
                }
                hashMap = hashMap2;
            } else {
                hashMap = null;
            }
            CrashDetailBean packageCrashDatas = nativeExceptionHandler.packageCrashDatas(str20, str18, (m2061d.get("etms").intValue() / 1000) + (m2061d.get("ets").intValue() * 1000), str2, str7, m2053a(str12), str, str16, str10, map.get("sysLogPath"), map.get("jniLogPath"), str4, m2296a, hashMap, false, false);
            if (packageCrashDatas != null) {
                String str22 = map.get("userId");
                if (str22 != null) {
                    C3401x.m2251c("[Native record info] userId: %s", str22);
                    packageCrashDatas.f3070m = str22;
                }
                String str23 = map.get("sysLog");
                if (str23 != null) {
                    packageCrashDatas.f3080w = str23;
                }
                String str24 = map.get("appVersion");
                if (str24 != null) {
                    C3401x.m2251c("[Native record info] appVersion: %s", str24);
                    packageCrashDatas.f3063f = str24;
                }
                String str25 = map.get("isAppForeground");
                if (str25 != null) {
                    C3401x.m2251c("[Native record info] isAppForeground: %s", str25);
                    packageCrashDatas.f3047N = str25.equalsIgnoreCase(BooleanUtils.TRUE);
                }
                String str26 = map.get("launchTime");
                if (str26 != null) {
                    C3401x.m2251c("[Native record info] launchTime: %s", str26);
                    try {
                        packageCrashDatas.f3046M = Long.parseLong(str26);
                    } catch (NumberFormatException e) {
                        if (!C3401x.m2247a(e)) {
                            e.printStackTrace();
                        }
                    }
                }
                packageCrashDatas.f3083z = null;
                packageCrashDatas.f3068k = true;
            }
            return packageCrashDatas;
        } catch (Throwable th) {
            C3401x.m2253e("error format", new Object[0]);
            th.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    private static String m2052a(BufferedInputStream bufferedInputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream;
        if (bufferedInputStream == null) {
            return null;
        }
        try {
            byteArrayOutputStream = new ByteArrayOutputStream(1024);
            while (true) {
                try {
                    int read = bufferedInputStream.read();
                    if (read == -1) {
                        byteArrayOutputStream.close();
                        break;
                    }
                    if (read == 0) {
                        String str = new String(byteArrayOutputStream.toByteArray(), "UTf-8");
                        byteArrayOutputStream.close();
                        return str;
                    }
                    byteArrayOutputStream.write(read);
                } catch (Throwable th) {
                    th = th;
                    try {
                        C3401x.m2247a(th);
                        return null;
                    } finally {
                        if (byteArrayOutputStream != null) {
                            byteArrayOutputStream.close();
                        }
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
            byteArrayOutputStream = null;
        }
    }

    /* JADX WARN: Type inference failed for: r7v3, types: [boolean] */
    /* renamed from: a */
    public static CrashDetailBean m2050a(Context context, String str, NativeExceptionHandler nativeExceptionHandler) {
        BufferedInputStream bufferedInputStream;
        String str2;
        String m2052a;
        BufferedInputStream bufferedInputStream2 = null;
        if (context == null || str == null || nativeExceptionHandler == null) {
            C3401x.m2253e("get eup record file args error", new Object[0]);
            return null;
        }
        File file = new File(str, "rqd_record.eup");
        if (file.exists()) {
            ?? canRead = file.canRead();
            try {
                if (canRead != 0) {
                    try {
                        bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                    } catch (IOException e) {
                        e = e;
                        bufferedInputStream = null;
                    } catch (Throwable th) {
                        th = th;
                        if (bufferedInputStream2 != null) {
                            try {
                                bufferedInputStream2.close();
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                        }
                        throw th;
                    }
                    try {
                        String m2052a2 = m2052a(bufferedInputStream);
                        if (m2052a2 != null && m2052a2.equals("NATIVE_RQD_REPORT")) {
                            HashMap hashMap = new HashMap();
                            loop0: while (true) {
                                str2 = null;
                                while (true) {
                                    m2052a = m2052a(bufferedInputStream);
                                    if (m2052a == null) {
                                        break loop0;
                                    }
                                    if (str2 == null) {
                                        str2 = m2052a;
                                    }
                                }
                                hashMap.put(str2, m2052a);
                            }
                            if (str2 != null) {
                                C3401x.m2253e("record not pair! drop! %s", str2);
                                try {
                                    bufferedInputStream.close();
                                } catch (IOException e3) {
                                    e3.printStackTrace();
                                }
                                return null;
                            }
                            CrashDetailBean m2051a = m2051a(context, hashMap, nativeExceptionHandler);
                            try {
                                bufferedInputStream.close();
                            } catch (IOException e4) {
                                e4.printStackTrace();
                            }
                            return m2051a;
                        }
                        C3401x.m2253e("record read fail! %s", m2052a2);
                        try {
                            bufferedInputStream.close();
                        } catch (IOException e5) {
                            e5.printStackTrace();
                        }
                        return null;
                    } catch (IOException e6) {
                        e = e6;
                        e.printStackTrace();
                        if (bufferedInputStream != null) {
                            try {
                                bufferedInputStream.close();
                            } catch (IOException e7) {
                                e7.printStackTrace();
                            }
                        }
                        return null;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                bufferedInputStream2 = canRead;
            }
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x006b, code lost:
    
        r9.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x006f, code lost:
    
        r9 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0070, code lost:
    
        com.tencent.bugly.proguard.C3401x.m2247a(r9);
     */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String m2058b(java.lang.String r9, java.lang.String r10) {
        /*
            java.lang.String r0 = "reg_record.txt"
            java.io.BufferedReader r9 = com.tencent.bugly.proguard.C3403z.m2274a(r9, r0)
            r0 = 0
            if (r9 != 0) goto La
            return r0
        La:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L74
            r1.<init>()     // Catch: java.lang.Throwable -> L74
            java.lang.String r2 = r9.readLine()     // Catch: java.lang.Throwable -> L74
            if (r2 == 0) goto L69
            boolean r10 = r2.startsWith(r10)     // Catch: java.lang.Throwable -> L74
            if (r10 != 0) goto L1c
            goto L69
        L1c:
            java.lang.String r10 = "                "
            r2 = 18
            r3 = 0
            r4 = r3
            r5 = r4
        L23:
            java.lang.String r6 = r9.readLine()     // Catch: java.lang.Throwable -> L74
            java.lang.String r7 = "\n"
            if (r6 == 0) goto L57
            int r8 = r4 % 4
            if (r8 != 0) goto L3a
            if (r4 <= 0) goto L34
            r1.append(r7)     // Catch: java.lang.Throwable -> L74
        L34:
            java.lang.String r5 = "  "
            r1.append(r5)     // Catch: java.lang.Throwable -> L74
            goto L4d
        L3a:
            int r7 = r6.length()     // Catch: java.lang.Throwable -> L74
            r8 = 16
            if (r7 <= r8) goto L44
            r2 = 28
        L44:
            int r5 = r2 - r5
            java.lang.String r5 = r10.substring(r3, r5)     // Catch: java.lang.Throwable -> L74
            r1.append(r5)     // Catch: java.lang.Throwable -> L74
        L4d:
            int r5 = r6.length()     // Catch: java.lang.Throwable -> L74
            r1.append(r6)     // Catch: java.lang.Throwable -> L74
            int r4 = r4 + 1
            goto L23
        L57:
            r1.append(r7)     // Catch: java.lang.Throwable -> L74
            java.lang.String r10 = r1.toString()     // Catch: java.lang.Throwable -> L74
            if (r9 == 0) goto L68
            r9.close()     // Catch: java.lang.Exception -> L64
            goto L68
        L64:
            r9 = move-exception
            com.tencent.bugly.proguard.C3401x.m2247a(r9)
        L68:
            return r10
        L69:
            if (r9 == 0) goto L73
            r9.close()     // Catch: java.lang.Exception -> L6f
            goto L73
        L6f:
            r9 = move-exception
            com.tencent.bugly.proguard.C3401x.m2247a(r9)
        L73:
            return r0
        L74:
            r10 = move-exception
            com.tencent.bugly.proguard.C3401x.m2247a(r10)     // Catch: java.lang.Throwable -> L83
            if (r9 == 0) goto L82
            r9.close()     // Catch: java.lang.Exception -> L7e
            goto L82
        L7e:
            r9 = move-exception
            com.tencent.bugly.proguard.C3401x.m2247a(r9)
        L82:
            return r0
        L83:
            r10 = move-exception
            if (r9 == 0) goto L8e
            r9.close()     // Catch: java.lang.Exception -> L8a
            goto L8e
        L8a:
            r9 = move-exception
            com.tencent.bugly.proguard.C3401x.m2247a(r9)
        L8e:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.crash.jni.C3358b.m2058b(java.lang.String, java.lang.String):java.lang.String");
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0041, code lost:
    
        r3.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0045, code lost:
    
        r3 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0046, code lost:
    
        com.tencent.bugly.proguard.C3401x.m2247a(r3);
     */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String m2059c(java.lang.String r3, java.lang.String r4) {
        /*
            java.lang.String r0 = "map_record.txt"
            java.io.BufferedReader r3 = com.tencent.bugly.proguard.C3403z.m2274a(r3, r0)
            r0 = 0
            if (r3 != 0) goto La
            return r0
        La:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L4a
            r1.<init>()     // Catch: java.lang.Throwable -> L4a
            java.lang.String r2 = r3.readLine()     // Catch: java.lang.Throwable -> L4a
            if (r2 == 0) goto L3f
            boolean r4 = r2.startsWith(r4)     // Catch: java.lang.Throwable -> L4a
            if (r4 != 0) goto L1c
            goto L3f
        L1c:
            java.lang.String r4 = r3.readLine()     // Catch: java.lang.Throwable -> L4a
            if (r4 == 0) goto L30
            java.lang.String r2 = "  "
            r1.append(r2)     // Catch: java.lang.Throwable -> L4a
            r1.append(r4)     // Catch: java.lang.Throwable -> L4a
            java.lang.String r4 = "\n"
            r1.append(r4)     // Catch: java.lang.Throwable -> L4a
            goto L1c
        L30:
            java.lang.String r4 = r1.toString()     // Catch: java.lang.Throwable -> L4a
            if (r3 == 0) goto L3e
            r3.close()     // Catch: java.lang.Exception -> L3a
            goto L3e
        L3a:
            r3 = move-exception
            com.tencent.bugly.proguard.C3401x.m2247a(r3)
        L3e:
            return r4
        L3f:
            if (r3 == 0) goto L49
            r3.close()     // Catch: java.lang.Exception -> L45
            goto L49
        L45:
            r3 = move-exception
            com.tencent.bugly.proguard.C3401x.m2247a(r3)
        L49:
            return r0
        L4a:
            r4 = move-exception
            com.tencent.bugly.proguard.C3401x.m2247a(r4)     // Catch: java.lang.Throwable -> L59
            if (r3 == 0) goto L58
            r3.close()     // Catch: java.lang.Exception -> L54
            goto L58
        L54:
            r3 = move-exception
            com.tencent.bugly.proguard.C3401x.m2247a(r3)
        L58:
            return r0
        L59:
            r4 = move-exception
            if (r3 == 0) goto L64
            r3.close()     // Catch: java.lang.Exception -> L60
            goto L64
        L60:
            r3 = move-exception
            com.tencent.bugly.proguard.C3401x.m2247a(r3)
        L64:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.crash.jni.C3358b.m2059c(java.lang.String, java.lang.String):java.lang.String");
    }

    /* renamed from: a */
    public static String m2055a(String str, String str2) {
        if (str == null || str2 == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        String m2058b = m2058b(str, str2);
        if (m2058b != null && !m2058b.isEmpty()) {
            sb.append("Register infos:\n");
            sb.append(m2058b);
        }
        String m2059c = m2059c(str, str2);
        if (m2059c != null && !m2059c.isEmpty()) {
            if (sb.length() > 0) {
                sb.append("\n");
            }
            sb.append("System SO infos:\n");
            sb.append(m2059c);
        }
        return sb.toString();
    }

    /* renamed from: b */
    public static String m2057b(String str) {
        if (str == null) {
            return null;
        }
        File file = new File(str, "backup_record.txt");
        if (file.exists()) {
            return file.getAbsolutePath();
        }
        return null;
    }

    /* renamed from: c */
    public static void m2060c(String str) {
        File[] listFiles;
        if (str == null) {
            return;
        }
        try {
            File file = new File(str);
            if (file.canRead() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
                for (File file2 : listFiles) {
                    if (file2.canRead() && file2.canWrite() && file2.length() == 0) {
                        file2.delete();
                        C3401x.m2251c("Delete empty record file %s", file2.getAbsoluteFile());
                    }
                }
            }
        } catch (Throwable th) {
            C3401x.m2247a(th);
        }
    }

    /* renamed from: a */
    public static void m2056a(boolean z, String str) {
        if (str != null) {
            f3227a.add(new File(str, "rqd_record.eup"));
            f3227a.add(new File(str, "reg_record.txt"));
            f3227a.add(new File(str, "map_record.txt"));
            f3227a.add(new File(str, "backup_record.txt"));
            if (z) {
                m2060c(str);
            }
        }
        List<File> list = f3227a;
        if (list == null || list.size() <= 0) {
            return;
        }
        for (File file : f3227a) {
            if (file.exists() && file.canWrite()) {
                file.delete();
                C3401x.m2251c("Delete record file %s", file.getAbsoluteFile());
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v1, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v12 */
    /* JADX WARN: Type inference failed for: r6v7, types: [java.lang.String] */
    /* renamed from: a */
    public static String m2054a(String str, int i, String str2, boolean z) {
        BufferedReader bufferedReader = null;
        if (str != null && i > 0) {
            File file = new File(str);
            if (file.exists() && file.canRead()) {
                C3401x.m2246a("Read system log from native record file(length: %s bytes): %s", Long.valueOf(file.length()), file.getAbsolutePath());
                f3227a.add(file);
                C3401x.m2251c("Add this record file to list for cleaning lastly.", new Object[0]);
                if (str2 == null) {
                    return C3403z.m2281a(new File(str), i, z);
                }
                String sb = new StringBuilder();
                try {
                    try {
                        BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(new FileInputStream(file), "utf-8"));
                        while (true) {
                            try {
                                String readLine = bufferedReader2.readLine();
                                if (readLine == null) {
                                    break;
                                }
                                if (Pattern.compile(str2 + "[ ]*:").matcher(readLine).find()) {
                                    sb.append(readLine).append("\n");
                                }
                                if (i > 0 && sb.length() > i) {
                                    if (z) {
                                        sb.delete(i, sb.length());
                                        break;
                                    }
                                    sb.delete(0, sb.length() - i);
                                }
                            } catch (Throwable th) {
                                th = th;
                                bufferedReader = bufferedReader2;
                                try {
                                    C3401x.m2247a(th);
                                    String sb2 = sb.append("\n[error:" + th.toString() + "]").toString();
                                    if (bufferedReader == null) {
                                        return sb2;
                                    }
                                    bufferedReader.close();
                                    sb = sb2;
                                    return sb;
                                } catch (Throwable th2) {
                                    if (bufferedReader != null) {
                                        try {
                                            bufferedReader.close();
                                        } catch (Exception e) {
                                            C3401x.m2247a(e);
                                        }
                                    }
                                    throw th2;
                                }
                            }
                        }
                        String sb3 = sb.toString();
                        bufferedReader2.close();
                        sb = sb3;
                    } catch (Throwable th3) {
                        th = th3;
                    }
                    return sb;
                } catch (Exception e2) {
                    C3401x.m2247a(e2);
                    return sb;
                }
            }
        }
        return null;
    }
}