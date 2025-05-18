package com.tencent.bugly.proguard;

import androidx.core.app.NotificationCompat;
import java.util.HashMap;
import java.util.Map;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.f */
/* loaded from: classes3.dex */
public final class C3383f extends AbstractC3388k {

    /* renamed from: k */
    private static byte[] f3363k = null;

    /* renamed from: l */
    private static Map<String, String> f3364l = null;

    /* renamed from: m */
    private static /* synthetic */ boolean f3365m = true;

    /* renamed from: e */
    public byte[] f3370e;

    /* renamed from: i */
    private Map<String, String> f3374i;

    /* renamed from: j */
    private Map<String, String> f3375j;

    /* renamed from: a */
    public short f3366a = 0;

    /* renamed from: f */
    private byte f3371f = 0;

    /* renamed from: g */
    private int f3372g = 0;

    /* renamed from: b */
    public int f3367b = 0;

    /* renamed from: c */
    public String f3368c = null;

    /* renamed from: d */
    public String f3369d = null;

    /* renamed from: h */
    private int f3373h = 0;

    public final boolean equals(Object obj) {
        C3383f c3383f = (C3383f) obj;
        return C3389l.m2160a(1, (int) c3383f.f3366a) && C3389l.m2160a(1, (int) c3383f.f3371f) && C3389l.m2160a(1, c3383f.f3372g) && C3389l.m2160a(1, c3383f.f3367b) && C3389l.m2162a((Object) 1, (Object) c3383f.f3368c) && C3389l.m2162a((Object) 1, (Object) c3383f.f3369d) && C3389l.m2162a((Object) 1, (Object) c3383f.f3370e) && C3389l.m2160a(1, c3383f.f3373h) && C3389l.m2162a((Object) 1, (Object) c3383f.f3374i) && C3389l.m2162a((Object) 1, (Object) c3383f.f3375j);
    }

    public final Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            if (f3365m) {
                return null;
            }
            throw new AssertionError();
        }
    }

    @Override // com.tencent.bugly.proguard.AbstractC3388k
    /* renamed from: a */
    public final void mo2097a(C3387j c3387j) {
        c3387j.m2156a(this.f3366a, 1);
        c3387j.m2148a(this.f3371f, 2);
        c3387j.m2149a(this.f3372g, 3);
        c3387j.m2149a(this.f3367b, 4);
        c3387j.m2153a(this.f3368c, 5);
        c3387j.m2153a(this.f3369d, 6);
        c3387j.m2158a(this.f3370e, 7);
        c3387j.m2149a(this.f3373h, 8);
        c3387j.m2155a((Map) this.f3374i, 9);
        c3387j.m2155a((Map) this.f3375j, 10);
    }

    @Override // com.tencent.bugly.proguard.AbstractC3388k
    /* renamed from: a */
    public final void mo2096a(C3386i c3386i) {
        try {
            this.f3366a = c3386i.m2139a(this.f3366a, 1, true);
            this.f3371f = c3386i.m2132a(this.f3371f, 2, true);
            this.f3372g = c3386i.m2133a(this.f3372g, 3, true);
            this.f3367b = c3386i.m2133a(this.f3367b, 4, true);
            this.f3368c = c3386i.m2142b(5, true);
            this.f3369d = c3386i.m2142b(6, true);
            if (f3363k == null) {
                f3363k = new byte[]{0};
            }
            this.f3370e = c3386i.m2143c(7, true);
            this.f3373h = c3386i.m2133a(this.f3373h, 8, true);
            if (f3364l == null) {
                HashMap hashMap = new HashMap();
                f3364l = hashMap;
                hashMap.put("", "");
            }
            this.f3374i = (Map) c3386i.m2137a((C3386i) f3364l, 9, true);
            if (f3364l == null) {
                HashMap hashMap2 = new HashMap();
                f3364l = hashMap2;
                hashMap2.put("", "");
            }
            this.f3375j = (Map) c3386i.m2137a((C3386i) f3364l, 10, true);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("RequestPacket decode error " + C3382e.m2104a(this.f3370e));
            throw new RuntimeException(e);
        }
    }

    @Override // com.tencent.bugly.proguard.AbstractC3388k
    /* renamed from: a */
    public final void mo2098a(StringBuilder sb, int i) {
        C3385h c3385h = new C3385h(sb, i);
        c3385h.m2114a(this.f3366a, "iVersion");
        c3385h.m2108a(this.f3371f, "cPacketType");
        c3385h.m2109a(this.f3372g, "iMessageType");
        c3385h.m2109a(this.f3367b, "iRequestId");
        c3385h.m2112a(this.f3368c, "sServantName");
        c3385h.m2112a(this.f3369d, "sFuncName");
        c3385h.m2116a(this.f3370e, "sBuffer");
        c3385h.m2109a(this.f3373h, "iTimeout");
        c3385h.m2113a((Map) this.f3374i, "context");
        c3385h.m2113a((Map) this.f3375j, NotificationCompat.CATEGORY_STATUS);
    }
}