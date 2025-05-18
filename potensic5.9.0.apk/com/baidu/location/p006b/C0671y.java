package com.baidu.location.p006b;

import android.location.GnssNavigationMessage;
import android.text.TextUtils;
import com.baidu.location.p012h.AbstractC0725g;
import com.baidu.location.p012h.C0720b;
import com.google.android.exoplayer2.audio.SilenceSkippingAudioProcessor;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import org.json.JSONObject;

/* renamed from: com.baidu.location.b.y */
/* loaded from: classes.dex */
public class C0671y {

    /* renamed from: a */
    private b f718a;

    /* renamed from: b */
    private long f719b = 0;

    /* renamed from: c */
    private long f720c = 0;

    /* renamed from: com.baidu.location.b.y$a */
    private static class a {

        /* renamed from: a */
        private static C0671y f721a = new C0671y();
    }

    /* renamed from: com.baidu.location.b.y$b */
    class b extends AbstractC0725g {

        /* renamed from: d */
        private boolean f725d = false;

        /* renamed from: e */
        private String f726e = null;

        /* renamed from: a */
        public boolean f722a = false;

        /* renamed from: b */
        public long f723b = 0;

        public b() {
            this.f1292k = new HashMap();
        }

        /* renamed from: a */
        public void m599a(String str, long j) {
            if (this.f725d) {
                return;
            }
            this.f725d = true;
            this.f726e = str;
            this.f723b = j;
            ExecutorService m592c = C0670x.m590a().m592c();
            if (m592c != null) {
                m1129a(m592c, "https://ofloc.map.baidu.com/locnu");
            } else {
                m1133e("https://ofloc.map.baidu.com/locnu");
            }
        }

        @Override // com.baidu.location.p012h.AbstractC0725g
        /* renamed from: a */
        public void mo122a(boolean z) {
            if (z && this.f1291j != null) {
                try {
                    new JSONObject(this.f1291j);
                    this.f722a = true;
                } catch (Throwable unused) {
                }
            }
            if (this.f1292k != null) {
                this.f1292k.clear();
            }
            this.f725d = false;
        }

        /* renamed from: a */
        public boolean m600a() {
            return this.f725d;
        }

        @Override // com.baidu.location.p012h.AbstractC0725g
        /* renamed from: b */
        public void mo123b() {
            String m1106c = C0720b.m1100a().m1106c();
            if (m1106c != null) {
                m1106c = m1106c + "&gnsst=" + this.f723b;
            }
            String m468a = C0660n.m467a().m468a(m1106c);
            String replaceAll = !TextUtils.isEmpty(m468a) ? m468a.trim().replaceAll("\r|\n", "") : "null";
            String m468a2 = C0660n.m467a().m468a(this.f726e);
            String replaceAll2 = TextUtils.isEmpty(m468a2) ? "null" : m468a2.trim().replaceAll("\r|\n", "");
            try {
                this.f1292k.put("info", URLEncoder.encode(replaceAll, "utf-8"));
                this.f1292k.put("enl", URLEncoder.encode(replaceAll2, "utf-8"));
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: a */
    public static C0671y m595a() {
        return a.f721a;
    }

    /* renamed from: a */
    public void m596a(GnssNavigationMessage gnssNavigationMessage, long j) {
        C0666t.m549a().m551a(gnssNavigationMessage, j);
        this.f719b = System.currentTimeMillis();
        this.f720c = j;
    }

    /* renamed from: b */
    public void m597b() {
        ArrayList<String> m552b;
        if (this.f719b == 0 || Math.abs(System.currentTimeMillis() - this.f719b) >= SilenceSkippingAudioProcessor.DEFAULT_PADDING_SILENCE_US) {
            return;
        }
        if (this.f718a == null) {
            this.f718a = new b();
        }
        b bVar = this.f718a;
        if (bVar == null || bVar.m600a() || (m552b = C0666t.m549a().m552b()) == null || m552b.size() <= 0) {
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        int i = 0;
        Iterator<String> it = m552b.iterator();
        while (it.hasNext()) {
            stringBuffer.append(it.next());
            i++;
            if (i != m552b.size()) {
                stringBuffer.append(";");
            }
        }
        this.f718a.m599a(stringBuffer.toString(), this.f720c);
    }
}