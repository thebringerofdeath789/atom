package com.baidu.location.f;

import java.util.Locale;

/* loaded from: classes.dex */
public class i {
    public int a = 0;
    public String b = null;
    public String c = null;
    public int d = 0;
    public long e = 0;
    public int f = Integer.MAX_VALUE;
    public int g = Integer.MAX_VALUE;

    public String toString() {
        return String.format(Locale.CHINA, "%d,%s,%s,%d,%d,%d", Integer.valueOf(this.a), this.b, this.c, Integer.valueOf(this.d), Long.valueOf(this.e), Integer.valueOf(this.f));
    }
}
