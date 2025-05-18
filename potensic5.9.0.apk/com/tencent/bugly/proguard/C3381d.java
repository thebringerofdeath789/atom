package com.tencent.bugly.proguard;

import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.d */
/* loaded from: classes3.dex */
public final class C3381d extends C3380c {

    /* renamed from: f */
    private static HashMap<String, byte[]> f3359f;

    /* renamed from: g */
    private static HashMap<String, HashMap<String, byte[]>> f3360g;

    /* renamed from: e */
    private C3383f f3361e;

    public C3381d() {
        C3383f c3383f = new C3383f();
        this.f3361e = c3383f;
        c3383f.f3366a = (short) 2;
    }

    @Override // com.tencent.bugly.proguard.C3380c, com.tencent.bugly.proguard.C3360a
    /* renamed from: a */
    public final <T> void mo2075a(String str, T t) {
        if (str.startsWith(".")) {
            throw new IllegalArgumentException("put name can not startwith . , now is " + str);
        }
        super.mo2075a(str, (String) t);
    }

    @Override // com.tencent.bugly.proguard.C3380c
    /* renamed from: c */
    public final void mo2100c() {
        super.mo2100c();
        this.f3361e.f3366a = (short) 3;
    }

    @Override // com.tencent.bugly.proguard.C3380c, com.tencent.bugly.proguard.C3360a
    /* renamed from: a */
    public final byte[] mo2077a() {
        if (this.f3361e.f3366a == 2) {
            if (this.f3361e.f3368c.equals("")) {
                throw new IllegalArgumentException("servantName can not is null");
            }
            if (this.f3361e.f3369d.equals("")) {
                throw new IllegalArgumentException("funcName can not is null");
            }
        } else {
            if (this.f3361e.f3368c == null) {
                this.f3361e.f3368c = "";
            }
            if (this.f3361e.f3369d == null) {
                this.f3361e.f3369d = "";
            }
        }
        C3387j c3387j = new C3387j(0);
        c3387j.m2146a(this.f3230b);
        if (this.f3361e.f3366a == 2) {
            c3387j.m2155a((Map) this.f3229a, 0);
        } else {
            c3387j.m2155a((Map) this.f3356d, 0);
        }
        this.f3361e.f3370e = C3389l.m2164a(c3387j.m2147a());
        C3387j c3387j2 = new C3387j(0);
        c3387j2.m2146a(this.f3230b);
        this.f3361e.mo2097a(c3387j2);
        byte[] m2164a = C3389l.m2164a(c3387j2.m2147a());
        int length = m2164a.length + 4;
        ByteBuffer allocate = ByteBuffer.allocate(length);
        allocate.putInt(length).put(m2164a).flip();
        return allocate.array();
    }

    @Override // com.tencent.bugly.proguard.C3380c, com.tencent.bugly.proguard.C3360a
    /* renamed from: a */
    public final void mo2076a(byte[] bArr) {
        if (bArr.length < 4) {
            throw new IllegalArgumentException("decode package must include size head");
        }
        try {
            C3386i c3386i = new C3386i(bArr, 4);
            c3386i.m2134a(this.f3230b);
            this.f3361e.mo2096a(c3386i);
            if (this.f3361e.f3366a == 3) {
                C3386i c3386i2 = new C3386i(this.f3361e.f3370e);
                c3386i2.m2134a(this.f3230b);
                if (f3359f == null) {
                    HashMap<String, byte[]> hashMap = new HashMap<>();
                    f3359f = hashMap;
                    hashMap.put("", new byte[0]);
                }
                this.f3356d = c3386i2.m2138a((Map) f3359f, 0, false);
                return;
            }
            C3386i c3386i3 = new C3386i(this.f3361e.f3370e);
            c3386i3.m2134a(this.f3230b);
            if (f3360g == null) {
                f3360g = new HashMap<>();
                HashMap<String, byte[]> hashMap2 = new HashMap<>();
                hashMap2.put("", new byte[0]);
                f3360g.put("", hashMap2);
            }
            this.f3229a = c3386i3.m2138a((Map) f3360g, 0, false);
            new HashMap();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /* renamed from: b */
    public final void m2102b(String str) {
        this.f3361e.f3368c = str;
    }

    /* renamed from: c */
    public final void m2103c(String str) {
        this.f3361e.f3369d = str;
    }

    /* renamed from: a */
    public final void m2101a(int i) {
        this.f3361e.f3367b = 1;
    }
}