package com.baidu.location.b;

import android.location.GnssNavigationMessage;
import android.text.TextUtils;
import com.google.android.exoplayer2.audio.SilenceSkippingAudioProcessor;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class y {
    private b a;
    private long b = 0;
    private long c = 0;

    private static class a {
        private static y a = new y();
    }

    class b extends com.baidu.location.h.g {
        private boolean d = false;
        private String e = null;
        public boolean a = false;
        public long b = 0;

        public b() {
            this.k = new HashMap();
        }

        public void a(String str, long j) {
            if (this.d) {
                return;
            }
            this.d = true;
            this.e = str;
            this.b = j;
            ExecutorService c = x.a().c();
            if (c != null) {
                a(c, "https://ofloc.map.baidu.com/locnu");
            } else {
                e("https://ofloc.map.baidu.com/locnu");
            }
        }

        @Override // com.baidu.location.h.g
        public void a(boolean z) {
            if (z && this.j != null) {
                try {
                    new JSONObject(this.j);
                    this.a = true;
                } catch (Throwable unused) {
                }
            }
            if (this.k != null) {
                this.k.clear();
            }
            this.d = false;
        }

        public boolean a() {
            return this.d;
        }

        @Override // com.baidu.location.h.g
        public void b() {
            String c = com.baidu.location.h.b.a().c();
            if (c != null) {
                c = c + "&gnsst=" + this.b;
            }
            String a = n.a().a(c);
            String replaceAll = !TextUtils.isEmpty(a) ? a.trim().replaceAll("\r|\n", "") : "null";
            String a2 = n.a().a(this.e);
            String replaceAll2 = TextUtils.isEmpty(a2) ? "null" : a2.trim().replaceAll("\r|\n", "");
            try {
                this.k.put("info", URLEncoder.encode(replaceAll, "utf-8"));
                this.k.put("enl", URLEncoder.encode(replaceAll2, "utf-8"));
            } catch (Exception unused) {
            }
        }
    }

    public static y a() {
        return a.a;
    }

    public void a(GnssNavigationMessage gnssNavigationMessage, long j) {
        t.a().a(gnssNavigationMessage, j);
        this.b = System.currentTimeMillis();
        this.c = j;
    }

    public void b() {
        ArrayList<String> b2;
        if (this.b == 0 || Math.abs(System.currentTimeMillis() - this.b) >= SilenceSkippingAudioProcessor.DEFAULT_PADDING_SILENCE_US) {
            return;
        }
        if (this.a == null) {
            this.a = new b();
        }
        b bVar = this.a;
        if (bVar == null || bVar.a() || (b2 = t.a().b()) == null || b2.size() <= 0) {
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        int i = 0;
        Iterator<String> it = b2.iterator();
        while (it.hasNext()) {
            stringBuffer.append(it.next());
            i++;
            if (i != b2.size()) {
                stringBuffer.append(";");
            }
        }
        this.a.a(stringBuffer.toString(), this.c);
    }
}
