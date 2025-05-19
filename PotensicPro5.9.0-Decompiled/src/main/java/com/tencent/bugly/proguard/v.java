package com.tencent.bugly.proguard;

import android.content.Context;
import com.tencent.bugly.BuglyStrategy;
import java.util.Map;
import java.util.UUID;

/* compiled from: BUGLY */
/* loaded from: classes3.dex */
public final class v implements Runnable {
    private int a;
    private int b;
    private final Context c;
    private final int d;
    private final byte[] e;
    private final com.tencent.bugly.crashreport.common.info.a f;
    private final com.tencent.bugly.crashreport.common.strategy.a g;
    private final s h;
    private final u i;
    private final int j;
    private final t k;
    private final t l;
    private String m;
    private final String n;
    private final Map<String, String> o;
    private int p;
    private long q;
    private long r;
    private boolean s;

    public v(Context context, int i, int i2, byte[] bArr, String str, String str2, t tVar, boolean z, boolean z2) {
        this(context, i, i2, bArr, str, str2, tVar, 2, BuglyStrategy.a.MAX_USERDATA_VALUE_LENGTH, z2, null);
    }

    public v(Context context, int i, int i2, byte[] bArr, String str, String str2, t tVar, int i3, int i4, boolean z, Map<String, String> map) {
        this.a = 2;
        this.b = BuglyStrategy.a.MAX_USERDATA_VALUE_LENGTH;
        this.m = null;
        this.p = 0;
        this.q = 0L;
        this.r = 0L;
        this.s = false;
        this.c = context;
        this.f = com.tencent.bugly.crashreport.common.info.a.a(context);
        this.e = bArr;
        this.g = com.tencent.bugly.crashreport.common.strategy.a.a();
        this.h = s.a(context);
        this.i = u.a();
        this.j = i;
        this.m = str;
        this.n = str2;
        this.k = tVar;
        this.l = null;
        this.d = i2;
        if (i3 > 0) {
            this.a = i3;
        }
        if (i4 > 0) {
            this.b = i4;
        }
        this.s = z;
        this.o = map;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0020  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(com.tencent.bugly.proguard.an r4, boolean r5, int r6, java.lang.String r7) {
        /*
            r3 = this;
            int r4 = r3.d
            r0 = 630(0x276, float:8.83E-43)
            if (r4 == r0) goto L1a
            r0 = 640(0x280, float:8.97E-43)
            if (r4 == r0) goto L17
            r0 = 830(0x33e, float:1.163E-42)
            if (r4 == r0) goto L1a
            r0 = 840(0x348, float:1.177E-42)
            if (r4 == r0) goto L17
            java.lang.String r4 = java.lang.String.valueOf(r4)
            goto L1c
        L17:
            java.lang.String r4 = "userinfo"
            goto L1c
        L1a:
            java.lang.String r4 = "crash"
        L1c:
            r0 = 1
            r1 = 0
            if (r5 == 0) goto L2a
            java.lang.Object[] r6 = new java.lang.Object[r0]
            r6[r1] = r4
            java.lang.String r4 = "[Upload] Success: %s"
            com.tencent.bugly.proguard.x.a(r4, r6)
            goto L3d
        L2a:
            r2 = 3
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            r2[r1] = r6
            r2[r0] = r4
            r4 = 2
            r2[r4] = r7
            java.lang.String r4 = "[Upload] Failed to upload(%d) %s: %s"
            com.tencent.bugly.proguard.x.e(r4, r2)
        L3d:
            long r6 = r3.q
            long r0 = r3.r
            long r6 = r6 + r0
            r0 = 0
            int r4 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
            if (r4 <= 0) goto L5d
            com.tencent.bugly.proguard.u r4 = r3.i
            boolean r6 = r3.s
            long r6 = r4.a(r6)
            long r0 = r3.q
            long r6 = r6 + r0
            long r0 = r3.r
            long r6 = r6 + r0
            com.tencent.bugly.proguard.u r4 = r3.i
            boolean r0 = r3.s
            r4.a(r6, r0)
        L5d:
            com.tencent.bugly.proguard.t r4 = r3.k
            if (r4 == 0) goto L64
            r4.a(r5)
        L64:
            com.tencent.bugly.proguard.t r4 = r3.l
            if (r4 == 0) goto L6b
            r4.a(r5)
        L6b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.v.a(com.tencent.bugly.proguard.an, boolean, int, java.lang.String):void");
    }

    private static boolean a(an anVar, com.tencent.bugly.crashreport.common.info.a aVar, com.tencent.bugly.crashreport.common.strategy.a aVar2) {
        if (anVar == null) {
            x.d("resp == null!", new Object[0]);
            return false;
        }
        if (anVar.a != 0) {
            x.e("resp result error %d", Byte.valueOf(anVar.a));
            return false;
        }
        try {
            if (!z.a(anVar.e) && !com.tencent.bugly.crashreport.common.info.a.b().i().equals(anVar.e)) {
                p.a().a(com.tencent.bugly.crashreport.common.strategy.a.a, "device", anVar.e.getBytes("UTF-8"), (o) null, true);
                aVar.e(anVar.e);
            }
        } catch (Throwable th) {
            x.a(th);
        }
        aVar.j = anVar.d;
        if (anVar.b == 510) {
            if (anVar.c == null) {
                x.e("[Upload] Strategy data is null. Response cmd: %d", Integer.valueOf(anVar.b));
                return false;
            }
            ap apVar = (ap) a.a(anVar.c, ap.class);
            if (apVar == null) {
                x.e("[Upload] Failed to decode strategy from server. Response cmd: %d", Integer.valueOf(anVar.b));
                return false;
            }
            aVar2.a(apVar);
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:59:0x01ba A[Catch: all -> 0x0338, TryCatch #0 {all -> 0x0338, blocks: (B:3:0x0007, B:5:0x001a, B:9:0x0022, B:12:0x0027, B:14:0x003b, B:16:0x003f, B:18:0x0043, B:21:0x0049, B:23:0x004f, B:25:0x0055, B:27:0x0082, B:28:0x0085, B:30:0x00b4, B:33:0x00bc, B:35:0x00c2, B:36:0x00d6, B:39:0x00de, B:41:0x00f5, B:42:0x0102, B:122:0x0145, B:46:0x0158, B:49:0x0160, B:52:0x0167, B:55:0x016f, B:59:0x01ba, B:61:0x01e6, B:62:0x01ee, B:64:0x01f4, B:66:0x0215, B:78:0x0250, B:80:0x0264, B:82:0x0275, B:83:0x027d, B:85:0x0283, B:87:0x029e, B:90:0x02a7, B:92:0x02ae, B:95:0x02b6, B:97:0x02bc, B:99:0x02c3, B:102:0x02d9, B:104:0x02ec, B:106:0x02f3, B:108:0x02d6, B:110:0x02fb, B:113:0x0179, B:115:0x017f, B:116:0x0187, B:118:0x0195, B:119:0x01a1, B:120:0x01ae, B:125:0x0323, B:127:0x032a, B:129:0x0331), top: B:2:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0221 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void run() {
        /*
            Method dump skipped, instructions count: 835
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.v.run():void");
    }

    public final void a(long j) {
        this.p++;
        this.q += j;
    }

    public final void b(long j) {
        this.r += j;
    }

    private static String a(String str) {
        if (z.a(str)) {
            return str;
        }
        try {
            return String.format("%s?aid=%s", str, UUID.randomUUID().toString());
        } catch (Throwable th) {
            x.a(th);
            return str;
        }
    }
}
