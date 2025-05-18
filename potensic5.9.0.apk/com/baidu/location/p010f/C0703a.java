package com.baidu.location.p010f;

import java.util.Locale;

/* renamed from: com.baidu.location.f.a */
/* loaded from: classes.dex */
public class C0703a {

    /* renamed from: a */
    public int f1010a;

    /* renamed from: b */
    public long f1011b;

    /* renamed from: c */
    public int f1012c;

    /* renamed from: d */
    public int f1013d;

    /* renamed from: e */
    public int f1014e;

    /* renamed from: f */
    public int f1015f;

    /* renamed from: g */
    public long f1016g;

    /* renamed from: h */
    public int f1017h;

    /* renamed from: i */
    public char f1018i;

    /* renamed from: j */
    public int f1019j;

    /* renamed from: k */
    public int f1020k;

    /* renamed from: l */
    public int f1021l;

    /* renamed from: m */
    public String f1022m;

    /* renamed from: n */
    public String f1023n;

    /* renamed from: o */
    public String f1024o;

    /* renamed from: p */
    private boolean f1025p;

    public C0703a() {
        this.f1010a = -1;
        this.f1011b = -1L;
        this.f1012c = -1;
        this.f1013d = -1;
        this.f1014e = Integer.MAX_VALUE;
        this.f1015f = Integer.MAX_VALUE;
        this.f1016g = 0L;
        this.f1017h = -1;
        this.f1018i = '0';
        this.f1019j = Integer.MAX_VALUE;
        this.f1020k = 0;
        this.f1021l = 0;
        this.f1022m = null;
        this.f1023n = null;
        this.f1024o = null;
        this.f1025p = false;
        this.f1016g = System.currentTimeMillis();
    }

    public C0703a(int i, long j, int i2, int i3, int i4, char c, int i5) {
        this.f1010a = -1;
        this.f1011b = -1L;
        this.f1012c = -1;
        this.f1013d = -1;
        this.f1014e = Integer.MAX_VALUE;
        this.f1015f = Integer.MAX_VALUE;
        this.f1016g = 0L;
        this.f1017h = -1;
        this.f1018i = '0';
        this.f1019j = Integer.MAX_VALUE;
        this.f1020k = 0;
        this.f1021l = 0;
        this.f1022m = null;
        this.f1023n = null;
        this.f1024o = null;
        this.f1025p = false;
        this.f1010a = i;
        this.f1011b = j;
        this.f1012c = i2;
        this.f1013d = i3;
        this.f1017h = i4;
        this.f1018i = c;
        this.f1016g = System.currentTimeMillis();
        this.f1019j = i5;
    }

    public C0703a(C0703a c0703a) {
        this(c0703a.f1010a, c0703a.f1011b, c0703a.f1012c, c0703a.f1013d, c0703a.f1017h, c0703a.f1018i, c0703a.f1019j);
        this.f1016g = c0703a.f1016g;
        this.f1022m = c0703a.f1022m;
        this.f1020k = c0703a.f1020k;
        this.f1024o = c0703a.f1024o;
        this.f1021l = c0703a.f1021l;
        this.f1023n = c0703a.f1023n;
    }

    /* renamed from: a */
    public boolean m894a() {
        long currentTimeMillis = System.currentTimeMillis();
        long j = this.f1016g;
        return currentTimeMillis - j > 0 && currentTimeMillis - j < 3000;
    }

    /* renamed from: a */
    public boolean m895a(C0703a c0703a) {
        if (this.f1010a != c0703a.f1010a || this.f1011b != c0703a.f1011b || this.f1013d != c0703a.f1013d || this.f1012c != c0703a.f1012c) {
            return false;
        }
        String str = this.f1023n;
        if (str == null || !str.equals(c0703a.f1023n)) {
            return this.f1023n == null && c0703a.f1023n == null;
        }
        return true;
    }

    /* renamed from: b */
    public boolean m896b() {
        return this.f1010a > -1 && this.f1011b > 0;
    }

    /* renamed from: c */
    public boolean m897c() {
        return this.f1010a == -1 && this.f1011b == -1 && this.f1013d == -1 && this.f1012c == -1;
    }

    /* renamed from: d */
    public boolean m898d() {
        return this.f1010a > -1 && this.f1011b > -1 && this.f1013d == -1 && this.f1012c == -1;
    }

    /* renamed from: e */
    public boolean m899e() {
        return this.f1010a > -1 && this.f1011b > -1 && this.f1013d > -1 && this.f1012c > -1;
    }

    /* renamed from: f */
    public void m900f() {
        this.f1025p = true;
    }

    /* renamed from: g */
    public String m901g() {
        StringBuffer stringBuffer = new StringBuffer(128);
        stringBuffer.append(this.f1011b + 23);
        stringBuffer.append("H");
        stringBuffer.append(this.f1010a + 45);
        stringBuffer.append("K");
        stringBuffer.append(this.f1013d + 54);
        stringBuffer.append("Q");
        stringBuffer.append(this.f1012c + 203);
        return stringBuffer.toString();
    }

    /* renamed from: h */
    public String m902h() {
        return String.format(Locale.CHINA, "%d|%d|%d|%d", Integer.valueOf(this.f1012c), Integer.valueOf(this.f1013d), Integer.valueOf(this.f1010a), Long.valueOf(this.f1011b));
    }

    /* renamed from: i */
    public String m903i() {
        StringBuffer stringBuffer = new StringBuffer(128);
        stringBuffer.append("&nw=");
        stringBuffer.append(this.f1018i);
        stringBuffer.append(String.format(Locale.CHINA, "&cl=%d|%d|%d|%d&cl_s=%d&clp=%d", Integer.valueOf(this.f1012c), Integer.valueOf(this.f1013d), Integer.valueOf(this.f1010a), Long.valueOf(this.f1011b), Integer.valueOf(this.f1017h), Integer.valueOf(this.f1020k)));
        stringBuffer.append("&cl_t=");
        stringBuffer.append(this.f1016g);
        if (this.f1019j != Integer.MAX_VALUE) {
            stringBuffer.append("&cl_cs=");
            stringBuffer.append(this.f1019j);
        }
        if (this.f1025p) {
            stringBuffer.append("&newcl=1");
        }
        stringBuffer.append("&cl_api=");
        stringBuffer.append(this.f1021l);
        if (this.f1024o != null) {
            stringBuffer.append("&clnrs=");
            stringBuffer.append(this.f1024o);
        }
        stringBuffer.append("&cl_list=").append(C0704b.m926i());
        return stringBuffer.toString();
    }

    /* renamed from: j */
    public String m904j() {
        StringBuffer stringBuffer = new StringBuffer(128);
        stringBuffer.append("&nw2=");
        stringBuffer.append(this.f1018i);
        stringBuffer.append(String.format(Locale.CHINA, "&cl2=%d|%d|%d|%d&cl_s2=%d&clp2=%d&cl_t2=%d", Integer.valueOf(this.f1012c), Integer.valueOf(this.f1013d), Integer.valueOf(this.f1010a), Long.valueOf(this.f1011b), Integer.valueOf(this.f1017h), Integer.valueOf(this.f1020k), Long.valueOf(this.f1016g)));
        if (this.f1019j != Integer.MAX_VALUE) {
            stringBuffer.append("&cl_cs2=");
            stringBuffer.append(this.f1019j);
        }
        if (this.f1024o != null) {
            stringBuffer.append("&clnrs2=");
            stringBuffer.append(this.f1024o);
        }
        return stringBuffer.toString();
    }
}