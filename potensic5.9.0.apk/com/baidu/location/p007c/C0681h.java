package com.baidu.location.p007c;

import android.net.wifi.WifiConfiguration;
import android.os.Handler;
import android.util.Base64;
import com.baidu.location.Jni;
import com.baidu.location.p006b.C0670x;
import com.baidu.location.p012h.AbstractC0725g;
import com.baidu.location.p012h.C0720b;
import com.baidu.location.p012h.C0733o;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import org.apache.commons.lang3.time.DateUtils;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.baidu.location.c.h */
/* loaded from: classes.dex */
public class C0681h {

    /* renamed from: a */
    private static Object f820a = new Object();

    /* renamed from: b */
    private static C0681h f821b;

    /* renamed from: c */
    private Handler f822c = null;

    /* renamed from: d */
    private String f823d = null;

    /* renamed from: e */
    private int f824e = 24;

    /* renamed from: f */
    private a f825f = null;

    /* renamed from: g */
    private long f826g = 0;

    /* renamed from: com.baidu.location.c.h$a */
    private class a extends AbstractC0725g {

        /* renamed from: b */
        private boolean f828b = false;

        /* renamed from: c */
        private int f829c = 0;

        /* renamed from: d */
        private JSONArray f830d = null;

        /* renamed from: e */
        private JSONArray f831e = null;

        a() {
            this.f1292k = new HashMap();
        }

        @Override // com.baidu.location.p012h.AbstractC0725g
        /* renamed from: a */
        public void mo122a(boolean z) {
            JSONObject jSONObject;
            boolean z2;
            if (z && this.f1291j != null) {
                try {
                    jSONObject = new JSONObject(this.f1291j);
                    z2 = true;
                } catch (Exception unused) {
                    jSONObject = null;
                    z2 = false;
                }
                if (z2 && jSONObject != null) {
                    try {
                        jSONObject.put(TtmlNode.TAG_TT, System.currentTimeMillis());
                        jSONObject.put("data", this.f831e);
                        try {
                            File file = new File(C0681h.this.f823d, "wcnf.dat");
                            if (!file.exists()) {
                                file.createNewFile();
                            }
                            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, false));
                            bufferedWriter.write(new String(Base64.encode(jSONObject.toString().getBytes(), 0), "UTF-8"));
                            bufferedWriter.flush();
                            bufferedWriter.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } catch (Exception unused2) {
                    }
                }
            }
            this.f828b = false;
        }

        /* renamed from: a */
        public void m690a(boolean z, JSONArray jSONArray, JSONArray jSONArray2) {
            if (this.f828b) {
                return;
            }
            this.f828b = true;
            if (z) {
                this.f829c = 1;
            } else {
                this.f829c = 0;
            }
            this.f830d = jSONArray;
            this.f831e = jSONArray2;
            ExecutorService m592c = C0670x.m590a().m592c();
            if (m592c != null) {
                m1129a(m592c, C0733o.m1160d());
            } else {
                m1133e(C0733o.m1160d());
            }
        }

        @Override // com.baidu.location.p012h.AbstractC0725g
        /* renamed from: b */
        public void mo123b() {
            this.f1289h = C0733o.m1160d();
            this.f1292k.clear();
            this.f1292k.put("qt", "cltrw");
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("data", this.f830d);
                jSONObject.put("frt", this.f829c);
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.f1292k.put("cltr[0]", "" + Jni.encodeOfflineLocationUpdateRequest(jSONObject.toString()));
            this.f1292k.put("cfg", 1);
            this.f1292k.put("info", Jni.encode(C0720b.m1100a().m1106c()));
            this.f1292k.put("trtm", String.format(Locale.CHINA, "%d", Long.valueOf(System.currentTimeMillis())));
        }
    }

    /* renamed from: com.baidu.location.c.h$b */
    private class b {

        /* renamed from: a */
        public String f832a;

        /* renamed from: b */
        public int f833b;

        b(String str, int i) {
            this.f832a = null;
            this.f833b = 0;
            this.f832a = str;
            this.f833b = i;
        }
    }

    /* renamed from: a */
    public static C0681h m682a() {
        C0681h c0681h;
        synchronized (f820a) {
            if (f821b == null) {
                f821b = new C0681h();
            }
            c0681h = f821b;
        }
        return c0681h;
    }

    /* renamed from: a */
    private List<b> m683a(List<WifiConfiguration> list) {
        int i;
        if (list == null || list.size() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (WifiConfiguration wifiConfiguration : list) {
            String str = wifiConfiguration.SSID;
            try {
                i = ((Integer) C0733o.m1151b(wifiConfiguration, "numAssociation")).intValue();
            } catch (Throwable unused) {
                i = 0;
            }
            if (i > 0 && str != null) {
                arrayList.add(new b(str, i));
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    private void m685a(boolean z, JSONArray jSONArray, JSONArray jSONArray2) {
        if (this.f825f == null) {
            this.f825f = new a();
        }
        if (C0733o.m1152b()) {
            return;
        }
        this.f825f.m690a(z, jSONArray, jSONArray2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(13:71|(2:73|(11:75|76|77|(2:79|(1:81))|82|(1:84)|85|(5:87|88|89|(3:91|(2:95|96)|97)|101)(1:105)|(1:10)|11|(6:13|(1:(5:18|(2:21|19)|22|23|(1:30)(2:26|28)))(1:(5:38|(6:42|(6:45|(3:50|(1:58)(4:52|(1:54)|55|56)|57)|59|(0)(0)|57|43)|60|61|34|(1:30)(1:31))|33|34|(0)(0)))|32|33|34|(0)(0))(1:62)))|109|76|77|(0)|82|(0)|85|(0)(0)|(0)|11|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x00d2, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x00d3, code lost:
    
        r2 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:105:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x00e1 A[Catch: Exception -> 0x01c6, TryCatch #1 {Exception -> 0x01c6, blocks: (B:4:0x0011, B:10:0x00e1, B:11:0x00e7, B:13:0x00f9, B:16:0x010b, B:18:0x0111, B:19:0x011f, B:21:0x0125, B:26:0x01c2, B:36:0x0147, B:38:0x014d, B:40:0x0154, B:42:0x015a, B:43:0x0160, B:45:0x0166, B:47:0x0186, B:54:0x019c, B:55:0x01a1, B:103:0x00d8), top: B:3:0x0011 }] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x00f9 A[Catch: Exception -> 0x01c6, TryCatch #1 {Exception -> 0x01c6, blocks: (B:4:0x0011, B:10:0x00e1, B:11:0x00e7, B:13:0x00f9, B:16:0x010b, B:18:0x0111, B:19:0x011f, B:21:0x0125, B:26:0x01c2, B:36:0x0147, B:38:0x014d, B:40:0x0154, B:42:0x015a, B:43:0x0160, B:45:0x0166, B:47:0x0186, B:54:0x019c, B:55:0x01a1, B:103:0x00d8), top: B:3:0x0011 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x01c0 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:31:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x019a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0160 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:62:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0076 A[Catch: Exception -> 0x00d2, TryCatch #3 {Exception -> 0x00d2, blocks: (B:77:0x0070, B:79:0x0076, B:81:0x0080, B:82:0x0086, B:84:0x008c, B:85:0x0090, B:87:0x0096), top: B:76:0x0070 }] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x008c A[Catch: Exception -> 0x00d2, TryCatch #3 {Exception -> 0x00d2, blocks: (B:77:0x0070, B:79:0x0076, B:81:0x0080, B:82:0x0086, B:84:0x008c, B:85:0x0090, B:87:0x0096), top: B:76:0x0070 }] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0096 A[Catch: Exception -> 0x00d2, TRY_LEAVE, TryCatch #3 {Exception -> 0x00d2, blocks: (B:77:0x0070, B:79:0x0076, B:81:0x0080, B:82:0x0086, B:84:0x008c, B:85:0x0090, B:87:0x0096), top: B:76:0x0070 }] */
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m687d() {
        /*
            Method dump skipped, instructions count: 459
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.p007c.C0681h.m687d():void");
    }

    /* renamed from: b */
    public void m688b() {
        if (this.f822c == null) {
            this.f822c = new HandlerC0682i(this);
        }
        this.f823d = C0733o.m1164f();
    }

    /* renamed from: c */
    public void m689c() {
        Handler handler;
        if (System.currentTimeMillis() - this.f826g <= DateUtils.MILLIS_PER_HOUR || (handler = this.f822c) == null) {
            return;
        }
        handler.sendEmptyMessage(1);
        this.f826g = System.currentTimeMillis();
    }
}