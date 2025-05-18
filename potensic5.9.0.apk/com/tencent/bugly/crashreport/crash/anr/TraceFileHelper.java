package com.tencent.bugly.crashreport.crash.anr;

import com.tencent.bugly.proguard.C3401x;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang3.StringUtils;

/* compiled from: BUGLY */
/* loaded from: classes3.dex */
public class TraceFileHelper {

    /* compiled from: BUGLY */
    /* renamed from: com.tencent.bugly.crashreport.crash.anr.TraceFileHelper$a */
    public static class C3346a {

        /* renamed from: a */
        public long f3095a;

        /* renamed from: b */
        public String f3096b;

        /* renamed from: c */
        public long f3097c;

        /* renamed from: d */
        public Map<String, String[]> f3098d;
    }

    /* compiled from: BUGLY */
    /* renamed from: com.tencent.bugly.crashreport.crash.anr.TraceFileHelper$b */
    public interface InterfaceC3347b {
        /* renamed from: a */
        boolean mo1945a(long j);

        /* renamed from: a */
        boolean mo1946a(long j, long j2, String str);

        /* renamed from: a */
        boolean mo1947a(String str, int i, String str2, String str3);
    }

    public static C3346a readTargetDumpInfo(final String str, String str2, final boolean z) {
        if (str != null && str2 != null) {
            final C3346a c3346a = new C3346a();
            readTraceFile(str2, new InterfaceC3347b() { // from class: com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.1
                @Override // com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.InterfaceC3347b
                /* renamed from: a */
                public final boolean mo1947a(String str3, int i, String str4, String str5) {
                    C3401x.m2251c("new thread %s", str3);
                    if (C3346a.this.f3095a > 0 && C3346a.this.f3097c > 0 && C3346a.this.f3096b != null) {
                        if (C3346a.this.f3098d == null) {
                            C3346a.this.f3098d = new HashMap();
                        }
                        C3346a.this.f3098d.put(str3, new String[]{str4, str5, new StringBuilder().append(i).toString()});
                    }
                    return true;
                }

                @Override // com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.InterfaceC3347b
                /* renamed from: a */
                public final boolean mo1946a(long j, long j2, String str3) {
                    C3401x.m2251c("new process %s", str3);
                    if (!str3.equals(str)) {
                        return true;
                    }
                    C3346a.this.f3095a = j;
                    C3346a.this.f3096b = str3;
                    C3346a.this.f3097c = j2;
                    return z;
                }

                @Override // com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.InterfaceC3347b
                /* renamed from: a */
                public final boolean mo1945a(long j) {
                    C3401x.m2251c("process end %d", Long.valueOf(j));
                    return C3346a.this.f3095a <= 0 || C3346a.this.f3097c <= 0 || C3346a.this.f3096b == null;
                }
            });
            if (c3346a.f3095a > 0 && c3346a.f3097c > 0 && c3346a.f3096b != null) {
                return c3346a;
            }
        }
        return null;
    }

    public static C3346a readFirstDumpInfo(String str, final boolean z) {
        if (str == null) {
            C3401x.m2253e("path:%s", str);
            return null;
        }
        final C3346a c3346a = new C3346a();
        readTraceFile(str, new InterfaceC3347b() { // from class: com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.2
            @Override // com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.InterfaceC3347b
            /* renamed from: a */
            public final boolean mo1947a(String str2, int i, String str3, String str4) {
                C3401x.m2251c("new thread %s", str2);
                if (C3346a.this.f3098d == null) {
                    C3346a.this.f3098d = new HashMap();
                }
                C3346a.this.f3098d.put(str2, new String[]{str3, str4, new StringBuilder().append(i).toString()});
                return true;
            }

            @Override // com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.InterfaceC3347b
            /* renamed from: a */
            public final boolean mo1946a(long j, long j2, String str2) {
                C3401x.m2251c("new process %s", str2);
                C3346a.this.f3095a = j;
                C3346a.this.f3096b = str2;
                C3346a.this.f3097c = j2;
                return z;
            }

            @Override // com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.InterfaceC3347b
            /* renamed from: a */
            public final boolean mo1945a(long j) {
                C3401x.m2251c("process end %d", Long.valueOf(j));
                return false;
            }
        });
        if (c3346a.f3095a > 0 && c3346a.f3097c > 0 && c3346a.f3096b != null) {
            return c3346a;
        }
        C3401x.m2253e("first dump error %s", c3346a.f3095a + StringUtils.SPACE + c3346a.f3097c + StringUtils.SPACE + c3346a.f3096b);
        return null;
    }

    public static void readTraceFile(String str, InterfaceC3347b interfaceC3347b) {
        Throwable th;
        if (str == null || interfaceC3347b == null) {
            return;
        }
        File file = new File(str);
        if (!file.exists()) {
            return;
        }
        file.lastModified();
        file.length();
        BufferedReader bufferedReader = null;
        try {
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new FileReader(file));
                try {
                    Pattern compile = Pattern.compile("-{5}\\spid\\s\\d+\\sat\\s\\d+-\\d+-\\d+\\s\\d{2}:\\d{2}:\\d{2}\\s-{5}");
                    Pattern compile2 = Pattern.compile("-{5}\\send\\s\\d+\\s-{5}");
                    Pattern compile3 = Pattern.compile("Cmd\\sline:\\s(\\S+)");
                    Pattern compile4 = Pattern.compile("\".+\"\\s(daemon\\s){0,1}prio=\\d+\\stid=\\d+\\s.*");
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
                    while (true) {
                        Object[] m1943a = m1943a(bufferedReader2, compile);
                        if (m1943a == null) {
                            try {
                                bufferedReader2.close();
                                return;
                            } catch (IOException e) {
                                if (C3401x.m2247a(e)) {
                                    return;
                                }
                                e.printStackTrace();
                                return;
                            }
                        }
                        String[] split = m1943a[1].toString().split("\\s");
                        long parseLong = Long.parseLong(split[2]);
                        long time = simpleDateFormat.parse(split[4] + StringUtils.SPACE + split[5]).getTime();
                        Object[] m1943a2 = m1943a(bufferedReader2, compile3);
                        if (m1943a2 == null) {
                            try {
                                bufferedReader2.close();
                                return;
                            } catch (IOException e2) {
                                if (C3401x.m2247a(e2)) {
                                    return;
                                }
                                e2.printStackTrace();
                                return;
                            }
                        }
                        Matcher matcher = compile3.matcher(m1943a2[1].toString());
                        matcher.find();
                        matcher.group(1);
                        SimpleDateFormat simpleDateFormat2 = simpleDateFormat;
                        if (!interfaceC3347b.mo1946a(parseLong, time, matcher.group(1))) {
                            try {
                                bufferedReader2.close();
                                return;
                            } catch (IOException e3) {
                                if (C3401x.m2247a(e3)) {
                                    return;
                                }
                                e3.printStackTrace();
                                return;
                            }
                        }
                        while (true) {
                            Object[] m1943a3 = m1943a(bufferedReader2, compile4, compile2);
                            if (m1943a3 == null) {
                                break;
                            }
                            if (m1943a3[0] == compile4) {
                                String obj = m1943a3[1].toString();
                                Matcher matcher2 = Pattern.compile("\".+\"").matcher(obj);
                                matcher2.find();
                                String group = matcher2.group();
                                String substring = group.substring(1, group.length() - 1);
                                obj.contains("NATIVE");
                                Matcher matcher3 = Pattern.compile("tid=\\d+").matcher(obj);
                                matcher3.find();
                                String group2 = matcher3.group();
                                interfaceC3347b.mo1947a(substring, Integer.parseInt(group2.substring(group2.indexOf("=") + 1)), m1942a(bufferedReader2), m1944b(bufferedReader2));
                            } else if (!interfaceC3347b.mo1945a(Long.parseLong(m1943a3[1].toString().split("\\s")[2]))) {
                                try {
                                    bufferedReader2.close();
                                    return;
                                } catch (IOException e4) {
                                    if (C3401x.m2247a(e4)) {
                                        return;
                                    }
                                    e4.printStackTrace();
                                    return;
                                }
                            }
                        }
                        simpleDateFormat = simpleDateFormat2;
                    }
                } catch (Exception e5) {
                    e = e5;
                    bufferedReader = bufferedReader2;
                    if (!C3401x.m2247a(e)) {
                        e.printStackTrace();
                    }
                    C3401x.m2252d("trace open fail:%s : %s", e.getClass().getName(), e.getMessage());
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e6) {
                            if (C3401x.m2247a(e6)) {
                                return;
                            }
                            e6.printStackTrace();
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    bufferedReader = bufferedReader2;
                    if (bufferedReader == null) {
                        throw th;
                    }
                    try {
                        bufferedReader.close();
                        throw th;
                    } catch (IOException e7) {
                        if (C3401x.m2247a(e7)) {
                            throw th;
                        }
                        e7.printStackTrace();
                        throw th;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Exception e8) {
            e = e8;
        }
    }

    /* renamed from: a */
    private static Object[] m1943a(BufferedReader bufferedReader, Pattern... patternArr) throws IOException {
        if (bufferedReader != null && patternArr != null) {
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                for (Pattern pattern : patternArr) {
                    if (pattern.matcher(readLine).matches()) {
                        return new Object[]{pattern, readLine};
                    }
                }
            }
        }
        return null;
    }

    /* renamed from: a */
    private static String m1942a(BufferedReader bufferedReader) throws IOException {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < 3; i++) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                return null;
            }
            stringBuffer.append(readLine + "\n");
        }
        return stringBuffer.toString();
    }

    /* renamed from: b */
    private static String m1944b(BufferedReader bufferedReader) throws IOException {
        StringBuffer stringBuffer = new StringBuffer();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null || readLine.trim().length() <= 0) {
                break;
            }
            stringBuffer.append(readLine + "\n");
        }
        return stringBuffer.toString();
    }
}