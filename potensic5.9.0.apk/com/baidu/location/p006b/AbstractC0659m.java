package com.baidu.location.p006b;

import android.location.Location;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.location.Jni;
import com.baidu.location.ServiceC0702f;
import com.baidu.location.p005a.C0643a;
import com.baidu.location.p010f.C0703a;
import com.baidu.location.p010f.C0704b;
import com.baidu.location.p010f.C0709g;
import com.baidu.location.p010f.C0714l;
import com.baidu.location.p010f.C0715m;
import com.baidu.location.p012h.AbstractC0725g;
import com.baidu.location.p012h.C0722d;
import com.baidu.location.p012h.C0733o;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.concurrent.ExecutorService;

/* renamed from: com.baidu.location.b.m */
/* loaded from: classes.dex */
public abstract class AbstractC0659m {

    /* renamed from: d */
    public static String f577d;

    /* renamed from: a */
    public C0714l f578a = null;

    /* renamed from: b */
    public C0703a f579b = null;

    /* renamed from: c */
    public HashSet<String> f580c = null;

    /* renamed from: f */
    private boolean f582f = true;

    /* renamed from: g */
    private boolean f583g = true;

    /* renamed from: h */
    private boolean f584h = false;

    /* renamed from: i */
    private long f585i = 0;

    /* renamed from: e */
    final Handler f581e = new a();

    /* renamed from: j */
    private String f586j = null;

    /* renamed from: k */
    private String f587k = null;

    /* renamed from: l */
    private boolean f588l = false;

    /* renamed from: m */
    private long f589m = 0;

    /* renamed from: n */
    private int f590n = 0;

    /* renamed from: com.baidu.location.b.m$a */
    public class a extends Handler {
        public a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (ServiceC0702f.isServing) {
                int i = message.what;
                if (i == 21) {
                    AbstractC0659m.this.mo464a(message);
                } else if (i == 62 || i == 63) {
                    AbstractC0659m.this.mo463a();
                }
            }
        }
    }

    /* renamed from: com.baidu.location.b.m$b */
    class b extends AbstractC0725g {

        /* renamed from: a */
        String f592a = null;

        /* renamed from: b */
        String f593b = null;

        /* renamed from: c */
        long f594c = 0;

        /* renamed from: d */
        long f595d = 0;

        public b() {
            this.f1292k = new HashMap();
        }

        /* renamed from: a */
        public void m466a(String str, long j) {
            this.f593b = str;
            this.f595d = System.currentTimeMillis();
            this.f594c = j;
            ExecutorService m591b = C0670x.m590a().m591b();
            if (C0733o.m1152b()) {
                m1130a(m591b, false, null);
            } else if (m591b != null) {
                m1129a(m591b, C0722d.f1260c);
            } else {
                m1133e(C0722d.f1260c);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:43:0x0124  */
        /* JADX WARN: Removed duplicated region for block: B:46:? A[RETURN, SYNTHETIC] */
        @Override // com.baidu.location.p012h.AbstractC0725g
        /* renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void mo122a(boolean r12) {
            /*
                Method dump skipped, instructions count: 298
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.p006b.AbstractC0659m.b.mo122a(boolean):void");
        }

        @Override // com.baidu.location.p012h.AbstractC0725g
        /* renamed from: b */
        public void mo123b() {
            if ((C0733o.f1391g || C0733o.f1393i) && AbstractC0659m.this.f586j != null && AbstractC0659m.this.f587k != null) {
                this.f593b += String.format(Locale.CHINA, "&ki=%s&sn=%s", AbstractC0659m.this.f586j, AbstractC0659m.this.f587k);
            }
            if (C0660n.m467a().m470b()) {
                this.f593b += "&enc=2";
            }
            String encodeTp4 = Jni.encodeTp4(this.f593b);
            this.f593b = null;
            if (this.f592a == null) {
                this.f592a = C0672z.m612b();
            }
            this.f1292k.put("bloc", encodeTp4);
            if (this.f592a != null) {
                this.f1292k.put("up", this.f592a);
            }
            this.f1292k.put("trtm", String.format(Locale.CHINA, "%d", Long.valueOf(System.currentTimeMillis())));
        }
    }

    /* renamed from: a */
    public String m462a(String str) {
        C0714l c0714l;
        String m1080n;
        if (this.f586j == null) {
            this.f586j = C0643a.m296b(ServiceC0702f.getServiceContext());
        }
        if (this.f587k == null) {
            this.f587k = C0643a.m297c(ServiceC0702f.getServiceContext());
        }
        C0703a c0703a = this.f579b;
        if (c0703a == null || !c0703a.m894a()) {
            this.f579b = C0704b.m912a().m940f();
        }
        C0714l c0714l2 = this.f578a;
        if (c0714l2 == null || !c0714l2.m1055k()) {
            this.f578a = C0715m.m1058a().m1083q();
        }
        Location m1028h = C0709g.m959a().m1031k() ? C0709g.m959a().m1028h() : null;
        C0703a c0703a2 = this.f579b;
        if ((c0703a2 == null || c0703a2.m898d() || this.f579b.m897c()) && (((c0714l = this.f578a) == null || c0714l.m1037a() == 0) && m1028h == null)) {
            return null;
        }
        String m465b = m465b();
        if (C0658l.m446a().m457d() == -2) {
            m465b = m465b + "&imo=1";
        }
        int m1156c = C0733o.m1156c(ServiceC0702f.getServiceContext());
        if (m1156c >= 0) {
            m465b = m465b + "&lmd=" + m1156c;
            if (Build.VERSION.SDK_INT >= 28 && !this.f588l) {
                this.f588l = true;
                try {
                    if (ServiceC0702f.getServiceContext().getPackageManager().hasSystemFeature("android.hardware.wifi.rtt")) {
                        m465b = m465b + "&rtt=1";
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
        C0714l c0714l3 = this.f578a;
        if ((c0714l3 == null || c0714l3.m1037a() == 0) && (m1080n = C0715m.m1058a().m1080n()) != null) {
            m465b = m1080n + m465b;
        }
        if (C0715m.m1058a().m1074h()) {
            m465b = m465b + "&wf_freq=1";
        }
        String str2 = m465b;
        if (!this.f583g) {
            return C0733o.m1139a(this.f579b, this.f578a, m1028h, str2, 0);
        }
        this.f583g = false;
        return C0733o.m1140a(this.f579b, this.f578a, m1028h, str2, 0, true);
    }

    /* renamed from: a */
    public abstract void mo463a();

    /* renamed from: a */
    public abstract void mo464a(Message message);

    /* renamed from: b */
    public String m465b() {
        String m339d = C0648b.m321a().m339d();
        String format = C0715m.m1058a().m1077k() ? "&cn=32" : String.format(Locale.CHINA, "&cn=%d", Integer.valueOf(C0704b.m912a().m939e()));
        long currentTimeMillis = System.currentTimeMillis() - this.f589m;
        if (Build.VERSION.SDK_INT >= 18 && currentTimeMillis > 60000) {
            this.f589m = System.currentTimeMillis();
            String m1157c = C0733o.m1157c();
            if (!TextUtils.isEmpty(m1157c)) {
                format = format + "&qcip6c=" + m1157c;
            }
        }
        if (this.f582f) {
            this.f582f = false;
            int i = Build.VERSION.SDK_INT;
        } else if (!this.f584h) {
            String m617e = C0672z.m617e();
            if (m617e != null) {
                format = format + m617e;
            }
            this.f584h = true;
        }
        return format + m339d;
    }
}