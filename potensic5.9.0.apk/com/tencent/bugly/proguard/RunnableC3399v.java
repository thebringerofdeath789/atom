package com.tencent.bugly.proguard;

import android.content.Context;
import com.tencent.bugly.BuglyStrategy;
import com.tencent.bugly.crashreport.common.info.C3337a;
import com.tencent.bugly.crashreport.common.strategy.C3340a;
import java.util.Map;
import java.util.UUID;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.v */
/* loaded from: classes3.dex */
public final class RunnableC3399v implements Runnable {

    /* renamed from: a */
    private int f3451a;

    /* renamed from: b */
    private int f3452b;

    /* renamed from: c */
    private final Context f3453c;

    /* renamed from: d */
    private final int f3454d;

    /* renamed from: e */
    private final byte[] f3455e;

    /* renamed from: f */
    private final C3337a f3456f;

    /* renamed from: g */
    private final C3340a f3457g;

    /* renamed from: h */
    private final C3396s f3458h;

    /* renamed from: i */
    private final C3398u f3459i;

    /* renamed from: j */
    private final int f3460j;

    /* renamed from: k */
    private final InterfaceC3397t f3461k;

    /* renamed from: l */
    private final InterfaceC3397t f3462l;

    /* renamed from: m */
    private String f3463m;

    /* renamed from: n */
    private final String f3464n;

    /* renamed from: o */
    private final Map<String, String> f3465o;

    /* renamed from: p */
    private int f3466p;

    /* renamed from: q */
    private long f3467q;

    /* renamed from: r */
    private long f3468r;

    /* renamed from: s */
    private boolean f3469s;

    public RunnableC3399v(Context context, int i, int i2, byte[] bArr, String str, String str2, InterfaceC3397t interfaceC3397t, boolean z, boolean z2) {
        this(context, i, i2, bArr, str, str2, interfaceC3397t, 2, BuglyStrategy.C3327a.MAX_USERDATA_VALUE_LENGTH, z2, null);
    }

    public RunnableC3399v(Context context, int i, int i2, byte[] bArr, String str, String str2, InterfaceC3397t interfaceC3397t, int i3, int i4, boolean z, Map<String, String> map) {
        this.f3451a = 2;
        this.f3452b = BuglyStrategy.C3327a.MAX_USERDATA_VALUE_LENGTH;
        this.f3463m = null;
        this.f3466p = 0;
        this.f3467q = 0L;
        this.f3468r = 0L;
        this.f3469s = false;
        this.f3453c = context;
        this.f3456f = C3337a.m1854a(context);
        this.f3455e = bArr;
        this.f3457g = C3340a.m1927a();
        this.f3458h = C3396s.m2213a(context);
        this.f3459i = C3398u.m2219a();
        this.f3460j = i;
        this.f3463m = str;
        this.f3464n = str2;
        this.f3461k = interfaceC3397t;
        this.f3462l = null;
        this.f3454d = i2;
        if (i3 > 0) {
            this.f3451a = i3;
        }
        if (i4 > 0) {
            this.f3452b = i4;
        }
        this.f3469s = z;
        this.f3465o = map;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0020  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x002a  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m2234a(com.tencent.bugly.proguard.C3374an r4, boolean r5, int r6, java.lang.String r7) {
        /*
            r3 = this;
            int r4 = r3.f3454d
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
            com.tencent.bugly.proguard.C3401x.m2246a(r4, r6)
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
            com.tencent.bugly.proguard.C3401x.m2253e(r4, r2)
        L3d:
            long r6 = r3.f3467q
            long r0 = r3.f3468r
            long r6 = r6 + r0
            r0 = 0
            int r4 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
            if (r4 <= 0) goto L5d
            com.tencent.bugly.proguard.u r4 = r3.f3459i
            boolean r6 = r3.f3469s
            long r6 = r4.m2227a(r6)
            long r0 = r3.f3467q
            long r6 = r6 + r0
            long r0 = r3.f3468r
            long r6 = r6 + r0
            com.tencent.bugly.proguard.u r4 = r3.f3459i
            boolean r0 = r3.f3469s
            r4.m2231a(r6, r0)
        L5d:
            com.tencent.bugly.proguard.t r4 = r3.f3461k
            if (r4 == 0) goto L64
            r4.mo1823a(r5)
        L64:
            com.tencent.bugly.proguard.t r4 = r3.f3462l
            if (r4 == 0) goto L6b
            r4.mo1823a(r5)
        L6b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.RunnableC3399v.m2234a(com.tencent.bugly.proguard.an, boolean, int, java.lang.String):void");
    }

    /* renamed from: a */
    private static boolean m2235a(C3374an c3374an, C3337a c3337a, C3340a c3340a) {
        if (c3374an == null) {
            C3401x.m2252d("resp == null!", new Object[0]);
            return false;
        }
        if (c3374an.f3315a != 0) {
            C3401x.m2253e("resp result error %d", Byte.valueOf(c3374an.f3315a));
            return false;
        }
        try {
            if (!C3403z.m2294a(c3374an.f3319e) && !C3337a.m1855b().m1881i().equals(c3374an.f3319e)) {
                C3393p.m2187a().m2207a(C3340a.f3018a, "device", c3374an.f3319e.getBytes("UTF-8"), (InterfaceC3392o) null, true);
                c3337a.m1875e(c3374an.f3319e);
            }
        } catch (Throwable th) {
            C3401x.m2247a(th);
        }
        c3337a.f2976j = c3374an.f3318d;
        if (c3374an.f3316b == 510) {
            if (c3374an.f3317c == null) {
                C3401x.m2253e("[Upload] Strategy data is null. Response cmd: %d", Integer.valueOf(c3374an.f3316b));
                return false;
            }
            C3376ap c3376ap = (C3376ap) C3360a.m2065a(c3374an.f3317c, C3376ap.class);
            if (c3376ap == null) {
                C3401x.m2253e("[Upload] Failed to decode strategy from server. Response cmd: %d", Integer.valueOf(c3374an.f3316b));
                return false;
            }
            c3340a.m1935a(c3376ap);
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
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.RunnableC3399v.run():void");
    }

    /* renamed from: a */
    public final void m2236a(long j) {
        this.f3466p++;
        this.f3467q += j;
    }

    /* renamed from: b */
    public final void m2237b(long j) {
        this.f3468r += j;
    }

    /* renamed from: a */
    private static String m2233a(String str) {
        if (C3403z.m2294a(str)) {
            return str;
        }
        try {
            return String.format("%s?aid=%s", str, UUID.randomUUID().toString());
        } catch (Throwable th) {
            C3401x.m2247a(th);
            return str;
        }
    }
}