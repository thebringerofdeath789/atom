package com.tencent.bugly.proguard;

import android.content.Context;
import android.os.Process;
import com.tencent.bugly.crashreport.common.info.C3337a;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.apache.commons.lang3.StringUtils;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.y */
/* loaded from: classes3.dex */
public final class C3402y {

    /* renamed from: a */
    public static boolean f3476a = true;

    /* renamed from: b */
    private static boolean f3477b = true;

    /* renamed from: c */
    private static SimpleDateFormat f3478c = null;

    /* renamed from: d */
    private static int f3479d = 30720;

    /* renamed from: e */
    private static StringBuilder f3480e = null;

    /* renamed from: f */
    private static StringBuilder f3481f = null;

    /* renamed from: g */
    private static boolean f3482g = false;

    /* renamed from: h */
    private static a f3483h = null;

    /* renamed from: i */
    private static String f3484i = null;

    /* renamed from: j */
    private static String f3485j = null;

    /* renamed from: k */
    private static Context f3486k = null;

    /* renamed from: l */
    private static String f3487l = null;

    /* renamed from: m */
    private static boolean f3488m = false;

    /* renamed from: n */
    private static boolean f3489n = false;

    /* renamed from: o */
    private static ExecutorService f3490o;

    /* renamed from: p */
    private static int f3491p;

    /* renamed from: q */
    private static final Object f3492q = new Object();

    static {
        try {
            f3478c = new SimpleDateFormat("MM-dd HH:mm:ss");
        } catch (Throwable th) {
            C3401x.m2250b(th.getCause());
        }
    }

    /* renamed from: a */
    public static synchronized void m2256a(Context context) {
        synchronized (C3402y.class) {
            if (f3488m || context == null || !f3476a) {
                return;
            }
            try {
                f3490o = Executors.newSingleThreadExecutor();
                f3481f = new StringBuilder(0);
                f3480e = new StringBuilder(0);
                f3486k = context;
                C3337a m1854a = C3337a.m1854a(context);
                f3484i = m1854a.f2970d;
                m1854a.getClass();
                f3485j = "";
                f3487l = f3486k.getFilesDir().getPath() + "/buglylog_" + f3484i + "_" + f3485j + ".txt";
                f3491p = Process.myPid();
            } catch (Throwable unused) {
            }
            f3488m = true;
        }
    }

    /* renamed from: a */
    public static void m2255a(int i) {
        synchronized (f3492q) {
            f3479d = i;
            if (i < 0) {
                f3479d = 0;
            } else if (i > 30720) {
                f3479d = 30720;
            }
        }
    }

    /* renamed from: a */
    public static void m2258a(String str, String str2, Throwable th) {
        if (th == null) {
            return;
        }
        String message = th.getMessage();
        if (message == null) {
            message = "";
        }
        m2257a(str, str2, message + '\n' + C3403z.m2301b(th));
    }

    /* renamed from: a */
    public static synchronized void m2257a(final String str, final String str2, final String str3) {
        synchronized (C3402y.class) {
            if (f3488m && f3476a) {
                try {
                    f3490o.execute(new Runnable() { // from class: com.tencent.bugly.proguard.y.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            C3402y.m2262c(str, str2, str3);
                        }
                    });
                } catch (Exception e) {
                    C3401x.m2250b(e);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public static synchronized void m2262c(String str, String str2, String str3) {
        synchronized (C3402y.class) {
            if (f3477b) {
                m2263d(str, str2, str3);
            } else {
                m2264e(str, str2, str3);
            }
        }
    }

    /* renamed from: d */
    private static synchronized void m2263d(String str, String str2, String str3) {
        synchronized (C3402y.class) {
            String m2254a = m2254a(str, str2, str3, Process.myTid());
            synchronized (f3492q) {
                try {
                    f3481f.append(m2254a);
                    if (f3481f.length() >= f3479d) {
                        StringBuilder sb = f3481f;
                        f3481f = sb.delete(0, sb.indexOf("\u0001\r\n") + 1);
                    }
                } finally {
                }
            }
        }
    }

    /* renamed from: e */
    private static synchronized void m2264e(String str, String str2, String str3) {
        synchronized (C3402y.class) {
            String m2254a = m2254a(str, str2, str3, Process.myTid());
            synchronized (f3492q) {
                try {
                    f3481f.append(m2254a);
                } catch (Throwable unused) {
                }
                if (f3481f.length() <= f3479d) {
                    return;
                }
                if (f3482g) {
                    return;
                }
                f3482g = true;
                a aVar = f3483h;
                if (aVar == null) {
                    f3483h = new a(f3487l);
                } else if (aVar.f3497b == null || f3483h.f3497b.length() + f3481f.length() > f3483h.f3500e) {
                    f3483h.m2266a();
                }
                if (f3483h.m2270a(f3481f.toString())) {
                    f3481f.setLength(0);
                    f3482g = false;
                }
            }
        }
    }

    /* renamed from: a */
    private static String m2254a(String str, String str2, String str3, long j) {
        String date;
        f3480e.setLength(0);
        if (str3.length() > 30720) {
            str3 = str3.substring(str3.length() - 30720, str3.length() - 1);
        }
        Date date2 = new Date();
        SimpleDateFormat simpleDateFormat = f3478c;
        if (simpleDateFormat != null) {
            date = simpleDateFormat.format(date2);
        } else {
            date = date2.toString();
        }
        f3480e.append(date).append(StringUtils.SPACE).append(f3491p).append(StringUtils.SPACE).append(j).append(StringUtils.SPACE).append(str).append(StringUtils.SPACE).append(str2).append(": ").append(str3).append("\u0001\r\n");
        return f3480e.toString();
    }

    /* renamed from: a */
    public static byte[] m2259a() {
        if (f3477b) {
            if (f3476a) {
                return C3403z.m2296a((File) null, f3481f.toString(), "BuglyLog.txt");
            }
            return null;
        }
        return m2261b();
    }

    /* renamed from: b */
    private static byte[] m2261b() {
        if (!f3476a) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        synchronized (f3492q) {
            a aVar = f3483h;
            if (aVar != null && aVar.f3496a && f3483h.f3497b != null && f3483h.f3497b.length() > 0) {
                sb.append(C3403z.m2281a(f3483h.f3497b, 30720, true));
            }
            StringBuilder sb2 = f3481f;
            if (sb2 != null && sb2.length() > 0) {
                sb.append(f3481f.toString());
            }
        }
        return C3403z.m2296a((File) null, sb.toString(), "BuglyLog.txt");
    }

    /* compiled from: BUGLY */
    /* renamed from: com.tencent.bugly.proguard.y$a */
    public static class a {

        /* renamed from: a */
        private boolean f3496a;

        /* renamed from: b */
        private File f3497b;

        /* renamed from: c */
        private String f3498c;

        /* renamed from: d */
        private long f3499d;

        /* renamed from: e */
        private long f3500e = 30720;

        public a(String str) {
            if (str == null || str.equals("")) {
                return;
            }
            this.f3498c = str;
            this.f3496a = m2266a();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public boolean m2266a() {
            try {
                File file = new File(this.f3498c);
                this.f3497b = file;
                if (file.exists() && !this.f3497b.delete()) {
                    this.f3496a = false;
                    return false;
                }
                if (this.f3497b.createNewFile()) {
                    return true;
                }
                this.f3496a = false;
                return false;
            } catch (Throwable th) {
                C3401x.m2247a(th);
                this.f3496a = false;
                return false;
            }
        }

        /* renamed from: a */
        public final boolean m2270a(String str) {
            FileOutputStream fileOutputStream;
            if (!this.f3496a) {
                return false;
            }
            FileOutputStream fileOutputStream2 = null;
            try {
                fileOutputStream = new FileOutputStream(this.f3497b, true);
            } catch (Throwable th) {
                th = th;
            }
            try {
                fileOutputStream.write(str.getBytes("UTF-8"));
                fileOutputStream.flush();
                fileOutputStream.close();
                this.f3499d += r10.length;
                this.f3496a = true;
                try {
                    fileOutputStream.close();
                } catch (IOException unused) {
                }
                return true;
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream2 = fileOutputStream;
                try {
                    C3401x.m2247a(th);
                    this.f3496a = false;
                    if (fileOutputStream2 != null) {
                        try {
                            fileOutputStream2.close();
                        } catch (IOException unused2) {
                        }
                    }
                    return false;
                } catch (Throwable th3) {
                    if (fileOutputStream2 != null) {
                        try {
                            fileOutputStream2.close();
                        } catch (IOException unused3) {
                        }
                    }
                    throw th3;
                }
            }
        }
    }
}