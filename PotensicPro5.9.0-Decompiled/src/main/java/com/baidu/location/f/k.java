package com.baidu.location.f;

import java.util.Locale;

/* loaded from: classes.dex */
public class k extends i {
    public long h = Long.MAX_VALUE;
    public int i = Integer.MAX_VALUE;
    public int j = Integer.MAX_VALUE;
    public int k = Integer.MAX_VALUE;
    public int l = Integer.MAX_VALUE;
    public int m = Integer.MAX_VALUE;
    public int n = Integer.MAX_VALUE;
    public int o = Integer.MAX_VALUE;
    public int p = Integer.MAX_VALUE;
    public int q = Integer.MAX_VALUE;

    @Override // com.baidu.location.f.i
    public String toString() {
        return String.format(Locale.CHINA, "%d,%s,%s,%d,%d,%d,%d,%d,%d,%d,%d,%d,%d,%d,%d,%d", Integer.valueOf(this.a), this.b, this.c, Integer.valueOf(this.d), Long.valueOf(this.e), Integer.valueOf(this.f), Long.valueOf(this.h), Integer.valueOf(this.i), Integer.valueOf(this.j), Integer.valueOf(this.k), Integer.valueOf(this.l), Integer.valueOf(this.m), Integer.valueOf(this.n), Integer.valueOf(this.o), Integer.valueOf(this.p), Integer.valueOf(this.q));
    }
}
