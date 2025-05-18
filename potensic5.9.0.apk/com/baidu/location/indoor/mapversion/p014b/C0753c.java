package com.baidu.location.indoor.mapversion.p014b;

import android.content.Context;
import java.io.File;
import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.baidu.location.indoor.mapversion.b.c */
/* loaded from: classes.dex */
public class C0753c {

    /* renamed from: a */
    private static C0753c f1585a;

    /* renamed from: f */
    private String f1590f;

    /* renamed from: b */
    private a f1586b = null;

    /* renamed from: c */
    private String f1587c = null;

    /* renamed from: d */
    private boolean f1588d = false;

    /* renamed from: e */
    private boolean f1589e = false;

    /* renamed from: g */
    private String f1591g = "";

    /* renamed from: h */
    private double f1592h = 7.0d;

    /* renamed from: i */
    private Map<String, b> f1593i = Collections.synchronizedMap(new HashMap());

    /* renamed from: com.baidu.location.indoor.mapversion.b.c$a */
    public interface a {
    }

    /* renamed from: com.baidu.location.indoor.mapversion.b.c$b */
    public static class b implements Serializable {

        /* renamed from: a */
        public String f1594a;

        /* renamed from: b */
        public String f1595b;

        /* renamed from: c */
        public double f1596c;

        /* renamed from: d */
        public double f1597d;

        /* renamed from: e */
        public double f1598e;

        /* renamed from: f */
        public double f1599f;

        /* renamed from: g */
        public String f1600g;
    }

    private C0753c(Context context) {
        this.f1590f = "slr";
        this.f1590f = new File(context.getCacheDir(), this.f1590f).getAbsolutePath();
    }

    /* renamed from: a */
    public static synchronized C0753c m1313a() {
        C0753c c0753c;
        synchronized (C0753c.class) {
            c0753c = f1585a;
        }
        return c0753c;
    }

    /* renamed from: a */
    public static C0753c m1314a(Context context) {
        if (f1585a == null) {
            f1585a = new C0753c(context);
        }
        return f1585a;
    }

    /* renamed from: b */
    public boolean m1315b() {
        return this.f1589e;
    }

    /* renamed from: c */
    public boolean m1316c() {
        return this.f1591g.equals("on");
    }

    /* renamed from: d */
    public Map<String, b> m1317d() {
        return this.f1593i;
    }
}