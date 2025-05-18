package com.baidu.location.indoor;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.util.Base64;
import com.baidu.location.p006b.C0670x;
import com.baidu.location.p012h.AbstractC0725g;
import com.baidu.location.p012h.C0720b;
import com.baidu.location.p012h.C0733o;
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

/* renamed from: com.baidu.location.indoor.a */
/* loaded from: classes.dex */
public class C0735a extends AbstractC0725g {

    /* renamed from: a */
    private static HashMap<String, Long> f1411a = new HashMap<>();

    /* renamed from: w */
    private static Object f1412w = new Object();

    /* renamed from: x */
    private static C0735a f1413x = null;

    /* renamed from: d */
    private Context f1416d;

    /* renamed from: f */
    private String f1418f;

    /* renamed from: s */
    private a f1420s;

    /* renamed from: u */
    private Handler f1422u;

    /* renamed from: v */
    private Runnable f1423v;

    /* renamed from: b */
    private String f1414b = "https://loc.map.baidu.com/indoorlocbuildinginfo.php";

    /* renamed from: c */
    private final SimpleDateFormat f1415c = new SimpleDateFormat("yyyyMM");

    /* renamed from: t */
    private String f1421t = null;

    /* renamed from: r */
    private HashSet<String> f1419r = new HashSet<>();

    /* renamed from: e */
    private boolean f1417e = false;

    /* renamed from: com.baidu.location.indoor.a$a */
    public interface a {
        /* renamed from: a */
        void m1188a(boolean z);
    }

    public C0735a(Context context) {
        this.f1416d = context;
        this.f1292k = new HashMap();
        this.f1422u = new Handler();
        this.f1423v = new RunnableC0737b(this);
    }

    /* renamed from: a */
    private String m1176a(Date date) {
        File file = new File(this.f1416d.getCacheDir(), C0733o.m1143a((this.f1418f + this.f1415c.format(date)).getBytes(), false));
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

    /* renamed from: c */
    private void m1178c(String str) {
        for (String str2 : str.split(",")) {
            this.f1419r.add(str2.toLowerCase());
        }
    }

    /* renamed from: d */
    private Date m1179d() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(2, -1);
        return calendar.getTime();
    }

    /* renamed from: d */
    private void m1180d(String str) {
        try {
            FileWriter fileWriter = new FileWriter(new File(this.f1416d.getCacheDir(), C0733o.m1143a((this.f1418f + this.f1415c.format(new Date())).getBytes(), false)));
            fileWriter.write(new String(Base64.encode(str.getBytes(), 0), "UTF-8"));
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException unused) {
        }
    }

    /* renamed from: e */
    private void m1181e() {
        try {
            File file = new File(this.f1416d.getCacheDir(), C0733o.m1143a((this.f1418f + this.f1415c.format(m1179d())).getBytes(), false));
            if (file.isFile()) {
                file.delete();
            }
        } catch (Exception unused) {
        }
    }

    /* renamed from: f */
    private void m1182f(String str) {
        try {
            FileWriter fileWriter = new FileWriter(new File(this.f1416d.getCacheDir(), "buildings"), true);
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
    @Override // com.baidu.location.p012h.AbstractC0725g
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void mo122a(boolean r6) {
        /*
            r5 = this;
            java.lang.String r0 = "anchorinfo"
            r1 = 1
            r2 = 0
            if (r6 == 0) goto L42
            java.lang.String r6 = r5.f1291j
            if (r6 == 0) goto L42
            java.lang.String r6 = r5.f1291j     // Catch: java.lang.Exception -> L42
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
            java.util.HashSet<java.lang.String> r0 = r5.f1419r     // Catch: java.lang.Exception -> L42
            r0.clear()     // Catch: java.lang.Exception -> L42
            r5.m1178c(r6)     // Catch: java.lang.Exception -> L42
            r5.m1180d(r6)     // Catch: java.lang.Exception -> L42
            r5.m1181e()     // Catch: java.lang.Exception -> L40
        L40:
            r6 = r1
            goto L43
        L42:
            r6 = r2
        L43:
            if (r6 != 0) goto L58
            java.lang.String r0 = r5.f1421t
            if (r0 != 0) goto L58
            java.lang.String r0 = r5.f1418f
            r5.f1421t = r0
            android.os.Handler r0 = r5.f1422u
            java.lang.Runnable r1 = r5.f1423v
            r3 = 60000(0xea60, double:2.9644E-319)
            r0.postDelayed(r1, r3)
            goto L79
        L58:
            r0 = 0
            if (r6 == 0) goto L5e
            r5.f1421t = r0
            goto L79
        L5e:
            java.lang.String r3 = r5.f1421t
            r5.m1182f(r3)
            r5.f1421t = r0
            java.util.Date r0 = r5.m1179d()
            java.lang.String r0 = r5.m1176a(r0)
            if (r0 == 0) goto L79
            r5.m1178c(r0)
            com.baidu.location.indoor.a$a r0 = r5.f1420s
            if (r0 == 0) goto L79
            r0.m1188a(r1)
        L79:
            r5.f1417e = r2
            com.baidu.location.indoor.a$a r0 = r5.f1420s
            if (r0 == 0) goto L82
            r0.m1188a(r6)
        L82:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.indoor.C0735a.mo122a(boolean):void");
    }

    /* renamed from: a */
    public boolean m1183a() {
        HashSet<String> hashSet = this.f1419r;
        return (hashSet == null || hashSet.isEmpty()) ? false : true;
    }

    /* renamed from: a */
    public boolean m1184a(String str) {
        String str2 = this.f1418f;
        return (str2 == null || !str2.equalsIgnoreCase(str) || this.f1419r.isEmpty()) ? false : true;
    }

    /* renamed from: a */
    public boolean m1185a(String str, a aVar) {
        if (!this.f1417e) {
            this.f1420s = aVar;
            this.f1417e = true;
            this.f1418f = str;
            try {
                String m1176a = m1176a(new Date());
                if (m1176a == null) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (f1411a.get(str) == null || currentTimeMillis - f1411a.get(str).longValue() > 86400000) {
                        f1411a.put(str, Long.valueOf(currentTimeMillis));
                        ExecutorService m592c = C0670x.m590a().m592c();
                        if (m592c != null) {
                            m1129a(m592c, this.f1414b);
                        } else {
                            m1133e(this.f1414b);
                        }
                    }
                } else {
                    m1178c(m1176a);
                    a aVar2 = this.f1420s;
                    if (aVar2 != null) {
                        aVar2.m1188a(true);
                    }
                    this.f1417e = false;
                }
            } catch (Exception unused) {
                this.f1417e = false;
            }
        }
        return false;
    }

    @Override // com.baidu.location.p012h.AbstractC0725g
    /* renamed from: b */
    public void mo123b() {
        this.f1289h = this.f1414b;
        this.f1292k.clear();
        this.f1292k.put("bid", "none");
        this.f1292k.put("bldg", this.f1418f);
        this.f1292k.put("mb", Build.MODEL);
        this.f1292k.put("msdk", "2.0");
        this.f1292k.put("cuid", C0720b.m1100a().f1254c);
        this.f1292k.put("anchors", "v1");
    }

    /* renamed from: b */
    public boolean m1186b(String str) {
        HashSet<String> hashSet;
        return (this.f1418f == null || (hashSet = this.f1419r) == null || hashSet.isEmpty() || !this.f1419r.contains(str)) ? false : true;
    }

    /* renamed from: c */
    public void m1187c() {
        this.f1418f = null;
        this.f1419r.clear();
    }
}