package com.baidu.location.b;

import android.location.Location;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.location.Jni;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.concurrent.ExecutorService;

/* loaded from: classes.dex */
public abstract class m {
    public static String d;
    public com.baidu.location.f.l a = null;
    public com.baidu.location.f.a b = null;
    public HashSet<String> c = null;
    private boolean f = true;
    private boolean g = true;
    private boolean h = false;
    private long i = 0;
    final Handler e = new a();
    private String j = null;
    private String k = null;
    private boolean l = false;
    private long m = 0;
    private int n = 0;

    public class a extends Handler {
        public a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (com.baidu.location.f.isServing) {
                int i = message.what;
                if (i == 21) {
                    m.this.a(message);
                } else if (i == 62 || i == 63) {
                    m.this.a();
                }
            }
        }
    }

    class b extends com.baidu.location.h.g {
        String a = null;
        String b = null;
        long c = 0;
        long d = 0;

        public b() {
            this.k = new HashMap();
        }

        public void a(String str, long j) {
            this.b = str;
            this.d = System.currentTimeMillis();
            this.c = j;
            ExecutorService b = x.a().b();
            if (com.baidu.location.h.o.b()) {
                a(b, false, null);
            } else if (b != null) {
                a(b, com.baidu.location.h.d.c);
            } else {
                e(com.baidu.location.h.d.c);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:43:0x0124  */
        /* JADX WARN: Removed duplicated region for block: B:46:? A[RETURN, SYNTHETIC] */
        @Override // com.baidu.location.h.g
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void a(boolean r12) {
            /*
                Method dump skipped, instructions count: 298
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.b.m.b.a(boolean):void");
        }

        @Override // com.baidu.location.h.g
        public void b() {
            if ((com.baidu.location.h.o.g || com.baidu.location.h.o.i) && m.this.j != null && m.this.k != null) {
                this.b += String.format(Locale.CHINA, "&ki=%s&sn=%s", m.this.j, m.this.k);
            }
            if (n.a().b()) {
                this.b += "&enc=2";
            }
            String encodeTp4 = Jni.encodeTp4(this.b);
            this.b = null;
            if (this.a == null) {
                this.a = z.b();
            }
            this.k.put("bloc", encodeTp4);
            if (this.a != null) {
                this.k.put("up", this.a);
            }
            this.k.put("trtm", String.format(Locale.CHINA, "%d", Long.valueOf(System.currentTimeMillis())));
        }
    }

    public String a(String str) {
        com.baidu.location.f.l lVar;
        String n;
        if (this.j == null) {
            this.j = com.baidu.location.a.a.b(com.baidu.location.f.getServiceContext());
        }
        if (this.k == null) {
            this.k = com.baidu.location.a.a.c(com.baidu.location.f.getServiceContext());
        }
        com.baidu.location.f.a aVar = this.b;
        if (aVar == null || !aVar.a()) {
            this.b = com.baidu.location.f.b.a().f();
        }
        com.baidu.location.f.l lVar2 = this.a;
        if (lVar2 == null || !lVar2.k()) {
            this.a = com.baidu.location.f.m.a().q();
        }
        Location h = com.baidu.location.f.g.a().k() ? com.baidu.location.f.g.a().h() : null;
        com.baidu.location.f.a aVar2 = this.b;
        if ((aVar2 == null || aVar2.d() || this.b.c()) && (((lVar = this.a) == null || lVar.a() == 0) && h == null)) {
            return null;
        }
        String b2 = b();
        if (l.a().d() == -2) {
            b2 = b2 + "&imo=1";
        }
        int c = com.baidu.location.h.o.c(com.baidu.location.f.getServiceContext());
        if (c >= 0) {
            b2 = b2 + "&lmd=" + c;
            if (Build.VERSION.SDK_INT >= 28 && !this.l) {
                this.l = true;
                try {
                    if (com.baidu.location.f.getServiceContext().getPackageManager().hasSystemFeature("android.hardware.wifi.rtt")) {
                        b2 = b2 + "&rtt=1";
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
        com.baidu.location.f.l lVar3 = this.a;
        if ((lVar3 == null || lVar3.a() == 0) && (n = com.baidu.location.f.m.a().n()) != null) {
            b2 = n + b2;
        }
        if (com.baidu.location.f.m.a().h()) {
            b2 = b2 + "&wf_freq=1";
        }
        String str2 = b2;
        if (!this.g) {
            return com.baidu.location.h.o.a(this.b, this.a, h, str2, 0);
        }
        this.g = false;
        return com.baidu.location.h.o.a(this.b, this.a, h, str2, 0, true);
    }

    public abstract void a();

    public abstract void a(Message message);

    public String b() {
        String d2 = com.baidu.location.b.b.a().d();
        String format = com.baidu.location.f.m.a().k() ? "&cn=32" : String.format(Locale.CHINA, "&cn=%d", Integer.valueOf(com.baidu.location.f.b.a().e()));
        long currentTimeMillis = System.currentTimeMillis() - this.m;
        if (Build.VERSION.SDK_INT >= 18 && currentTimeMillis > 60000) {
            this.m = System.currentTimeMillis();
            String c = com.baidu.location.h.o.c();
            if (!TextUtils.isEmpty(c)) {
                format = format + "&qcip6c=" + c;
            }
        }
        if (this.f) {
            this.f = false;
            int i = Build.VERSION.SDK_INT;
        } else if (!this.h) {
            String e = z.e();
            if (e != null) {
                format = format + e;
            }
            this.h = true;
        }
        return format + d2;
    }
}
