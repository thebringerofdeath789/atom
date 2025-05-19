package com.baidu.location.indoor;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.util.Base64;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.ExecutorService;

/* loaded from: classes.dex */
public class a extends com.baidu.location.h.g {
    private static HashMap<String, Long> a = new HashMap<>();
    private static Object w = new Object();
    private static a x = null;
    private Context d;
    private String f;
    private InterfaceC0014a s;
    private Handler u;
    private Runnable v;
    private String b = "https://loc.map.baidu.com/indoorlocbuildinginfo.php";
    private final SimpleDateFormat c = new SimpleDateFormat("yyyyMM");
    private String t = null;
    private HashSet<String> r = new HashSet<>();
    private boolean e = false;

    /* renamed from: com.baidu.location.indoor.a$a, reason: collision with other inner class name */
    public interface InterfaceC0014a {
        void a(boolean z);
    }

    public a(Context context) {
        this.d = context;
        this.k = new HashMap();
        this.u = new Handler();
        this.v = new b(this);
    }

    private String a(Date date) {
        File file = new File(this.d.getCacheDir(), com.baidu.location.h.o.a((this.f + this.c.format(date)).getBytes(), false));
        if (!file.isFile()) {
            return null;
        }
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String str = "";
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                str = str + readLine + "\n";
            }
            bufferedReader.close();
            if (!str.equals("")) {
                return new String(Base64.decode(str.getBytes(), 0));
            }
        } catch (Exception unused) {
        }
        return null;
    }

    private void c(String str) {
        for (String str2 : str.split(",")) {
            this.r.add(str2.toLowerCase());
        }
    }

    private Date d() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(2, -1);
        return calendar.getTime();
    }

    private void d(String str) {
        try {
            FileWriter fileWriter = new FileWriter(new File(this.d.getCacheDir(), com.baidu.location.h.o.a((this.f + this.c.format(new Date())).getBytes(), false)));
            fileWriter.write(new String(Base64.encode(str.getBytes(), 0), "UTF-8"));
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException unused) {
        }
    }

    private void e() {
        try {
            File file = new File(this.d.getCacheDir(), com.baidu.location.h.o.a((this.f + this.c.format(d())).getBytes(), false));
            if (file.isFile()) {
                file.delete();
            }
        } catch (Exception unused) {
        }
    }

    private void f(String str) {
        try {
            FileWriter fileWriter = new FileWriter(new File(this.d.getCacheDir(), "buildings"), true);
            fileWriter.write(str + "\n");
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x005e  */
    @Override // com.baidu.location.h.g
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(boolean r6) {
        /*
            r5 = this;
            java.lang.String r0 = "anchorinfo"
            r1 = 1
            r2 = 0
            if (r6 == 0) goto L42
            java.lang.String r6 = r5.j
            if (r6 == 0) goto L42
            java.lang.String r6 = r5.j     // Catch: java.lang.Exception -> L42
            java.lang.String r3 = new java.lang.String     // Catch: java.lang.Exception -> L42
            byte[] r6 = r6.getBytes()     // Catch: java.lang.Exception -> L42
            byte[] r6 = android.util.Base64.decode(r6, r2)     // Catch: java.lang.Exception -> L42
            r3.<init>(r6)     // Catch: java.lang.Exception -> L42
            org.json.JSONObject r6 = new org.json.JSONObject     // Catch: java.lang.Exception -> L42
            r6.<init>(r3)     // Catch: java.lang.Exception -> L42
            boolean r3 = r6.has(r0)     // Catch: java.lang.Exception -> L42
            if (r3 == 0) goto L42
            java.lang.String r6 = r6.optString(r0)     // Catch: java.lang.Exception -> L42
            if (r6 == 0) goto L42
            java.lang.String r0 = ""
            boolean r0 = r6.equals(r0)     // Catch: java.lang.Exception -> L42
            if (r0 != 0) goto L42
            java.util.HashSet<java.lang.String> r0 = r5.r     // Catch: java.lang.Exception -> L42
            r0.clear()     // Catch: java.lang.Exception -> L42
            r5.c(r6)     // Catch: java.lang.Exception -> L42
            r5.d(r6)     // Catch: java.lang.Exception -> L42
            r5.e()     // Catch: java.lang.Exception -> L40
        L40:
            r6 = r1
            goto L43
        L42:
            r6 = r2
        L43:
            if (r6 != 0) goto L58
            java.lang.String r0 = r5.t
            if (r0 != 0) goto L58
            java.lang.String r0 = r5.f
            r5.t = r0
            android.os.Handler r0 = r5.u
            java.lang.Runnable r1 = r5.v
            r3 = 60000(0xea60, double:2.9644E-319)
            r0.postDelayed(r1, r3)
            goto L79
        L58:
            r0 = 0
            if (r6 == 0) goto L5e
            r5.t = r0
            goto L79
        L5e:
            java.lang.String r3 = r5.t
            r5.f(r3)
            r5.t = r0
            java.util.Date r0 = r5.d()
            java.lang.String r0 = r5.a(r0)
            if (r0 == 0) goto L79
            r5.c(r0)
            com.baidu.location.indoor.a$a r0 = r5.s
            if (r0 == 0) goto L79
            r0.a(r1)
        L79:
            r5.e = r2
            com.baidu.location.indoor.a$a r0 = r5.s
            if (r0 == 0) goto L82
            r0.a(r6)
        L82:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.indoor.a.a(boolean):void");
    }

    public boolean a() {
        HashSet<String> hashSet = this.r;
        return (hashSet == null || hashSet.isEmpty()) ? false : true;
    }

    public boolean a(String str) {
        String str2 = this.f;
        return (str2 == null || !str2.equalsIgnoreCase(str) || this.r.isEmpty()) ? false : true;
    }

    public boolean a(String str, InterfaceC0014a interfaceC0014a) {
        if (!this.e) {
            this.s = interfaceC0014a;
            this.e = true;
            this.f = str;
            try {
                String a2 = a(new Date());
                if (a2 == null) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (a.get(str) == null || currentTimeMillis - a.get(str).longValue() > 86400000) {
                        a.put(str, Long.valueOf(currentTimeMillis));
                        ExecutorService c = com.baidu.location.b.x.a().c();
                        if (c != null) {
                            a(c, this.b);
                        } else {
                            e(this.b);
                        }
                    }
                } else {
                    c(a2);
                    InterfaceC0014a interfaceC0014a2 = this.s;
                    if (interfaceC0014a2 != null) {
                        interfaceC0014a2.a(true);
                    }
                    this.e = false;
                }
            } catch (Exception unused) {
                this.e = false;
            }
        }
        return false;
    }

    @Override // com.baidu.location.h.g
    public void b() {
        this.h = this.b;
        this.k.clear();
        this.k.put("bid", "none");
        this.k.put("bldg", this.f);
        this.k.put("mb", Build.MODEL);
        this.k.put("msdk", "2.0");
        this.k.put("cuid", com.baidu.location.h.b.a().c);
        this.k.put("anchors", "v1");
    }

    public boolean b(String str) {
        HashSet<String> hashSet;
        return (this.f == null || (hashSet = this.r) == null || hashSet.isEmpty() || !this.r.contains(str)) ? false : true;
    }

    public void c() {
        this.f = null;
        this.r.clear();
    }
}
