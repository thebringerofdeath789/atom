package com.tencent.bugly.proguard;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.c */
/* loaded from: classes3.dex */
public class C3380c extends C3360a {

    /* renamed from: d */
    protected HashMap<String, byte[]> f3356d = null;

    /* renamed from: e */
    private HashMap<String, Object> f3357e = new HashMap<>();

    /* renamed from: f */
    private C3386i f3358f = new C3386i();

    @Override // com.tencent.bugly.proguard.C3360a
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo2074a(String str) {
        super.mo2074a(str);
    }

    /* renamed from: c */
    public void mo2100c() {
        this.f3356d = new HashMap<>();
    }

    @Override // com.tencent.bugly.proguard.C3360a
    /* renamed from: a */
    public <T> void mo2075a(String str, T t) {
        if (this.f3356d == null) {
            super.mo2075a(str, (String) t);
            return;
        }
        if (str == null) {
            throw new IllegalArgumentException("put key can not is null");
        }
        if (t == null) {
            throw new IllegalArgumentException("put value can not is null");
        }
        if (t instanceof Set) {
            throw new IllegalArgumentException("can not support Set");
        }
        C3387j c3387j = new C3387j();
        c3387j.m2146a(this.f3230b);
        c3387j.m2152a(t, 0);
        this.f3356d.put(str, C3389l.m2164a(c3387j.m2147a()));
    }

    /* renamed from: b */
    public final <T> T m2099b(String str, T t) throws C3379b {
        HashMap<String, byte[]> hashMap = this.f3356d;
        if (hashMap != null) {
            if (!hashMap.containsKey(str)) {
                return null;
            }
            if (this.f3357e.containsKey(str)) {
                return (T) this.f3357e.get(str);
            }
            try {
                this.f3358f.m2140a(this.f3356d.get(str));
                this.f3358f.m2134a(this.f3230b);
                T t2 = (T) this.f3358f.m2137a((C3386i) t, 0, true);
                if (t2 != null) {
                    this.f3357e.put(str, t2);
                }
                return t2;
            } catch (Exception e) {
                throw new C3379b(e);
            }
        }
        if (!this.f3229a.containsKey(str)) {
            return null;
        }
        if (this.f3357e.containsKey(str)) {
            return (T) this.f3357e.get(str);
        }
        byte[] bArr = new byte[0];
        Iterator<Map.Entry<String, byte[]>> it = this.f3229a.get(str).entrySet().iterator();
        if (it.hasNext()) {
            Map.Entry<String, byte[]> next = it.next();
            next.getKey();
            bArr = next.getValue();
        }
        try {
            this.f3358f.m2140a(bArr);
            this.f3358f.m2134a(this.f3230b);
            T t3 = (T) this.f3358f.m2137a((C3386i) t, 0, true);
            this.f3357e.put(str, t3);
            return t3;
        } catch (Exception e2) {
            throw new C3379b(e2);
        }
    }

    @Override // com.tencent.bugly.proguard.C3360a
    /* renamed from: a */
    public byte[] mo2077a() {
        if (this.f3356d != null) {
            C3387j c3387j = new C3387j(0);
            c3387j.m2146a(this.f3230b);
            c3387j.m2155a((Map) this.f3356d, 0);
            return C3389l.m2164a(c3387j.m2147a());
        }
        return super.mo2077a();
    }

    @Override // com.tencent.bugly.proguard.C3360a
    /* renamed from: a */
    public void mo2076a(byte[] bArr) {
        try {
            super.mo2076a(bArr);
        } catch (Exception unused) {
            this.f3358f.m2140a(bArr);
            this.f3358f.m2134a(this.f3230b);
            HashMap hashMap = new HashMap(1);
            hashMap.put("", new byte[0]);
            this.f3356d = this.f3358f.m2138a((Map) hashMap, 0, false);
        }
    }
}