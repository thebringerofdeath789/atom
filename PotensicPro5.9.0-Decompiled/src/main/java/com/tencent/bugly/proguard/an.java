package com.tencent.bugly.proguard;

import java.util.HashMap;
import java.util.Map;

/* compiled from: BUGLY */
/* loaded from: classes3.dex */
public final class an extends k {
    private static byte[] i = {0};
    private static Map<String, String> j;
    public byte a = 0;
    public int b = 0;
    public byte[] c = null;
    private String f = "";
    public long d = 0;
    private String g = "";
    public String e = "";
    private Map<String, String> h = null;

    @Override // com.tencent.bugly.proguard.k
    public final void a(j jVar) {
        jVar.a(this.a, 0);
        jVar.a(this.b, 1);
        byte[] bArr = this.c;
        if (bArr != null) {
            jVar.a(bArr, 2);
        }
        String str = this.f;
        if (str != null) {
            jVar.a(str, 3);
        }
        jVar.a(this.d, 4);
        String str2 = this.g;
        if (str2 != null) {
            jVar.a(str2, 5);
        }
        String str3 = this.e;
        if (str3 != null) {
            jVar.a(str3, 6);
        }
        Map<String, String> map = this.h;
        if (map != null) {
            jVar.a((Map) map, 7);
        }
    }

    static {
        HashMap hashMap = new HashMap();
        j = hashMap;
        hashMap.put("", "");
    }

    @Override // com.tencent.bugly.proguard.k
    public final void a(i iVar) {
        this.a = iVar.a(this.a, 0, true);
        this.b = iVar.a(this.b, 1, true);
        this.c = iVar.c(2, false);
        this.f = iVar.b(3, false);
        this.d = iVar.a(this.d, 4, false);
        this.g = iVar.b(5, false);
        this.e = iVar.b(6, false);
        this.h = (Map) iVar.a((i) j, 7, false);
    }
}
