package com.baidu.location.c;

import android.net.wifi.WifiConfiguration;
import android.os.Handler;
import android.util.Base64;
import com.baidu.location.Jni;
import com.baidu.location.b.x;
import com.baidu.location.h.o;
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

/* loaded from: classes.dex */
public class h {
    private static Object a = new Object();
    private static h b;
    private Handler c = null;
    private String d = null;
    private int e = 24;
    private a f = null;
    private long g = 0;

    private class a extends com.baidu.location.h.g {
        private boolean b = false;
        private int c = 0;
        private JSONArray d = null;
        private JSONArray e = null;

        a() {
            this.k = new HashMap();
        }

        @Override // com.baidu.location.h.g
        public void a(boolean z) {
            JSONObject jSONObject;
            boolean z2;
            if (z && this.j != null) {
                try {
                    jSONObject = new JSONObject(this.j);
                    z2 = true;
                } catch (Exception unused) {
                    jSONObject = null;
                    z2 = false;
                }
                if (z2 && jSONObject != null) {
                    try {
                        jSONObject.put(TtmlNode.TAG_TT, System.currentTimeMillis());
                        jSONObject.put("data", this.e);
                        try {
                            File file = new File(h.this.d, "wcnf.dat");
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
            this.b = false;
        }

        public void a(boolean z, JSONArray jSONArray, JSONArray jSONArray2) {
            if (this.b) {
                return;
            }
            this.b = true;
            if (z) {
                this.c = 1;
            } else {
                this.c = 0;
            }
            this.d = jSONArray;
            this.e = jSONArray2;
            ExecutorService c = x.a().c();
            if (c != null) {
                a(c, o.d());
            } else {
                e(o.d());
            }
        }

        @Override // com.baidu.location.h.g
        public void b() {
            this.h = o.d();
            this.k.clear();
            this.k.put("qt", "cltrw");
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("data", this.d);
                jSONObject.put("frt", this.c);
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.k.put("cltr[0]", "" + Jni.encodeOfflineLocationUpdateRequest(jSONObject.toString()));
            this.k.put("cfg", 1);
            this.k.put("info", Jni.encode(com.baidu.location.h.b.a().c()));
            this.k.put("trtm", String.format(Locale.CHINA, "%d", Long.valueOf(System.currentTimeMillis())));
        }
    }

    private class b {
        public String a;
        public int b;

        b(String str, int i) {
            this.a = null;
            this.b = 0;
            this.a = str;
            this.b = i;
        }
    }

    public static h a() {
        h hVar;
        synchronized (a) {
            if (b == null) {
                b = new h();
            }
            hVar = b;
        }
        return hVar;
    }

    private List<b> a(List<WifiConfiguration> list) {
        int i;
        if (list == null || list.size() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (WifiConfiguration wifiConfiguration : list) {
            String str = wifiConfiguration.SSID;
            try {
                i = ((Integer) o.b(wifiConfiguration, "numAssociation")).intValue();
            } catch (Throwable unused) {
                i = 0;
            }
            if (i > 0 && str != null) {
                arrayList.add(new b(str, i));
            }
        }
        return arrayList;
    }

    private void a(boolean z, JSONArray jSONArray, JSONArray jSONArray2) {
        if (this.f == null) {
            this.f = new a();
        }
        if (o.b()) {
            return;
        }
        this.f.a(z, jSONArray, jSONArray2);
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
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void d() {
        /*
            Method dump skipped, instructions count: 459
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.c.h.d():void");
    }

    public void b() {
        if (this.c == null) {
            this.c = new i(this);
        }
        this.d = o.f();
    }

    public void c() {
        Handler handler;
        if (System.currentTimeMillis() - this.g <= DateUtils.MILLIS_PER_HOUR || (handler = this.c) == null) {
            return;
        }
        handler.sendEmptyMessage(1);
        this.g = System.currentTimeMillis();
    }
}
