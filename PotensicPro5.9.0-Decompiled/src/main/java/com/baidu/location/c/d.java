package com.baidu.location.c;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;

/* loaded from: classes.dex */
public class d {
    private static d d;
    private boolean a = false;
    private String b = null;
    private b c = null;
    private int e = -1;
    private a f;

    public interface a {
        void a(boolean z);
    }

    public class b extends BroadcastReceiver {
        public b() {
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x005e  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x007e A[Catch: Exception -> 0x008e, TRY_LEAVE, TryCatch #0 {Exception -> 0x008e, blocks: (B:3:0x0005, B:5:0x000d, B:8:0x0031, B:15:0x0048, B:20:0x0076, B:22:0x007e, B:27:0x0061, B:28:0x0068, B:29:0x006e, B:30:0x004e, B:31:0x0052, B:32:0x0056, B:33:0x003a), top: B:2:0x0005 }] */
        /* JADX WARN: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:29:0x006e A[Catch: Exception -> 0x008e, TryCatch #0 {Exception -> 0x008e, blocks: (B:3:0x0005, B:5:0x000d, B:8:0x0031, B:15:0x0048, B:20:0x0076, B:22:0x007e, B:27:0x0061, B:28:0x0068, B:29:0x006e, B:30:0x004e, B:31:0x0052, B:32:0x0056, B:33:0x003a), top: B:2:0x0005 }] */
        @Override // android.content.BroadcastReceiver
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void onReceive(android.content.Context r6, android.content.Intent r7) {
            /*
                r5 = this;
                java.lang.String r6 = r7.getAction()
                r0 = 0
                java.lang.String r1 = "android.intent.action.BATTERY_CHANGED"
                boolean r6 = r6.equals(r1)     // Catch: java.lang.Exception -> L8e
                if (r6 == 0) goto L93
                com.baidu.location.c.d r6 = com.baidu.location.c.d.this     // Catch: java.lang.Exception -> L8e
                r1 = 0
                com.baidu.location.c.d.a(r6, r1)     // Catch: java.lang.Exception -> L8e
                java.lang.String r6 = "status"
                int r6 = r7.getIntExtra(r6, r1)     // Catch: java.lang.Exception -> L8e
                java.lang.String r2 = "plugged"
                int r1 = r7.getIntExtra(r2, r1)     // Catch: java.lang.Exception -> L8e
                java.lang.String r2 = "level"
                r3 = -1
                int r2 = r7.getIntExtra(r2, r3)     // Catch: java.lang.Exception -> L8e
                java.lang.String r4 = "scale"
                int r7 = r7.getIntExtra(r4, r3)     // Catch: java.lang.Exception -> L8e
                if (r2 <= 0) goto L3a
                if (r7 <= 0) goto L3a
                com.baidu.location.c.d r3 = com.baidu.location.c.d.this     // Catch: java.lang.Exception -> L8e
                int r2 = r2 * 100
                int r2 = r2 / r7
                com.baidu.location.c.d.a(r3, r2)     // Catch: java.lang.Exception -> L8e
                goto L3f
            L3a:
                com.baidu.location.c.d r7 = com.baidu.location.c.d.this     // Catch: java.lang.Exception -> L8e
                com.baidu.location.c.d.a(r7, r3)     // Catch: java.lang.Exception -> L8e
            L3f:
                r7 = 2
                if (r6 == r7) goto L56
                r2 = 3
                if (r6 == r2) goto L4e
                r2 = 4
                if (r6 == r2) goto L4e
                com.baidu.location.c.d r6 = com.baidu.location.c.d.this     // Catch: java.lang.Exception -> L8e
                com.baidu.location.c.d.a(r6, r0)     // Catch: java.lang.Exception -> L8e
                goto L5b
            L4e:
                com.baidu.location.c.d r6 = com.baidu.location.c.d.this     // Catch: java.lang.Exception -> L8e
                java.lang.String r2 = "3"
            L52:
                com.baidu.location.c.d.a(r6, r2)     // Catch: java.lang.Exception -> L8e
                goto L5b
            L56:
                com.baidu.location.c.d r6 = com.baidu.location.c.d.this     // Catch: java.lang.Exception -> L8e
                java.lang.String r2 = "4"
                goto L52
            L5b:
                r6 = 1
                if (r1 == r6) goto L6e
                if (r1 == r7) goto L61
                goto L76
            L61:
                com.baidu.location.c.d r7 = com.baidu.location.c.d.this     // Catch: java.lang.Exception -> L8e
                java.lang.String r1 = "5"
                com.baidu.location.c.d.a(r7, r1)     // Catch: java.lang.Exception -> L8e
            L68:
                com.baidu.location.c.d r7 = com.baidu.location.c.d.this     // Catch: java.lang.Exception -> L8e
                com.baidu.location.c.d.a(r7, r6)     // Catch: java.lang.Exception -> L8e
                goto L76
            L6e:
                com.baidu.location.c.d r7 = com.baidu.location.c.d.this     // Catch: java.lang.Exception -> L8e
                java.lang.String r1 = "6"
                com.baidu.location.c.d.a(r7, r1)     // Catch: java.lang.Exception -> L8e
                goto L68
            L76:
                com.baidu.location.c.d r6 = com.baidu.location.c.d.this     // Catch: java.lang.Exception -> L8e
                com.baidu.location.c.d$a r6 = com.baidu.location.c.d.a(r6)     // Catch: java.lang.Exception -> L8e
                if (r6 == 0) goto L93
                com.baidu.location.c.d r6 = com.baidu.location.c.d.this     // Catch: java.lang.Exception -> L8e
                com.baidu.location.c.d$a r6 = com.baidu.location.c.d.a(r6)     // Catch: java.lang.Exception -> L8e
                com.baidu.location.c.d r7 = com.baidu.location.c.d.this     // Catch: java.lang.Exception -> L8e
                boolean r7 = com.baidu.location.c.d.b(r7)     // Catch: java.lang.Exception -> L8e
                r6.a(r7)     // Catch: java.lang.Exception -> L8e
                goto L93
            L8e:
                com.baidu.location.c.d r6 = com.baidu.location.c.d.this
                com.baidu.location.c.d.a(r6, r0)
            L93:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.c.d.b.onReceive(android.content.Context, android.content.Intent):void");
        }
    }

    private d() {
    }

    public static synchronized d a() {
        d dVar;
        synchronized (d.class) {
            if (d == null) {
                d = new d();
            }
            dVar = d;
        }
        return dVar;
    }

    public void b() {
        this.c = new b();
        try {
            com.baidu.location.f.getServiceContext().registerReceiver(this.c, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        } catch (Exception unused) {
        }
    }

    public void c() {
        if (this.c != null) {
            try {
                com.baidu.location.f.getServiceContext().unregisterReceiver(this.c);
            } catch (Exception unused) {
            }
        }
        this.c = null;
        this.f = null;
    }

    public String d() {
        return this.b;
    }

    public boolean e() {
        return this.a;
    }

    public int f() {
        return this.e;
    }
}
