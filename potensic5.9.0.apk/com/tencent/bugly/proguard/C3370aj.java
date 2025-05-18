package com.tencent.bugly.proguard;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.aj */
/* loaded from: classes3.dex */
public final class C3370aj extends AbstractC3388k implements Cloneable {

    /* renamed from: d */
    private static byte[] f3252d;

    /* renamed from: a */
    private byte f3253a;

    /* renamed from: b */
    private String f3254b;

    /* renamed from: c */
    private byte[] f3255c;

    @Override // com.tencent.bugly.proguard.AbstractC3388k
    /* renamed from: a */
    public final void mo2098a(StringBuilder sb, int i) {
    }

    public C3370aj() {
        this.f3253a = (byte) 0;
        this.f3254b = "";
        this.f3255c = null;
    }

    public C3370aj(byte b, String str, byte[] bArr) {
        this.f3253a = (byte) 0;
        this.f3254b = "";
        this.f3255c = null;
        this.f3253a = b;
        this.f3254b = str;
        this.f3255c = bArr;
    }

    @Override // com.tencent.bugly.proguard.AbstractC3388k
    /* renamed from: a */
    public final void mo2097a(C3387j c3387j) {
        c3387j.m2148a(this.f3253a, 0);
        c3387j.m2153a(this.f3254b, 1);
        byte[] bArr = this.f3255c;
        if (bArr != null) {
            c3387j.m2158a(bArr, 2);
        }
    }

    @Override // com.tencent.bugly.proguard.AbstractC3388k
    /* renamed from: a */
    public final void mo2096a(C3386i c3386i) {
        this.f3253a = c3386i.m2132a(this.f3253a, 0, true);
        this.f3254b = c3386i.m2142b(1, true);
        if (f3252d == null) {
            f3252d = new byte[]{0};
        }
        this.f3255c = c3386i.m2143c(2, false);
    }
}