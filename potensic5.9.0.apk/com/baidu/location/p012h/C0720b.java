package com.baidu.location.p012h;

import android.content.Context;
import android.os.Build;
import com.baidu.lbsapi.auth.LBSAuthManager;
import com.baidu.location.ServiceC0702f;

/* renamed from: com.baidu.location.h.b */
/* loaded from: classes.dex */
public class C0720b {

    /* renamed from: e */
    public static String f1244e = null;

    /* renamed from: f */
    public static String f1245f = null;

    /* renamed from: g */
    public static String f1246g = null;

    /* renamed from: h */
    public static String f1247h = null;

    /* renamed from: i */
    public static String f1248i = null;

    /* renamed from: j */
    public static int f1249j = 0;

    /* renamed from: k */
    public static int f1250k = -2;

    /* renamed from: l */
    public static long f1251l = -1;

    /* renamed from: a */
    public String f1252a;

    /* renamed from: b */
    public String f1253b;

    /* renamed from: c */
    public String f1254c;

    /* renamed from: d */
    public String f1255d;

    /* renamed from: m */
    private boolean f1256m;

    /* renamed from: com.baidu.location.h.b$a */
    private static class a {

        /* renamed from: a */
        public static final C0720b f1257a = new C0720b();
    }

    private C0720b() {
        this.f1252a = null;
        this.f1253b = null;
        this.f1254c = null;
        this.f1255d = null;
        this.f1256m = false;
        if (ServiceC0702f.getServiceContext() != null) {
            m1103a(ServiceC0702f.getServiceContext());
        }
    }

    /* renamed from: a */
    public static C0720b m1100a() {
        return a.f1257a;
    }

    /* renamed from: a */
    public String m1101a(boolean z) {
        return m1102a(z, (String) null);
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x010a  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String m1102a(boolean r4, java.lang.String r5) {
        /*
            Method dump skipped, instructions count: 295
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.p012h.C0720b.m1102a(boolean, java.lang.String):java.lang.String");
    }

    /* renamed from: a */
    public void m1103a(Context context) {
        if (context == null || this.f1256m) {
            return;
        }
        try {
            this.f1254c = LBSAuthManager.getInstance(context).getCUID();
        } catch (Exception unused) {
            this.f1254c = null;
        }
        try {
            f1244e = context.getPackageName();
        } catch (Exception unused2) {
            f1244e = null;
        }
        try {
            f1248i = C0733o.m1167g(context);
        } catch (Exception unused3) {
            f1248i = null;
        }
        C0733o.f1398n = "" + this.f1254c;
        this.f1256m = true;
    }

    /* renamed from: a */
    public void m1104a(String str, String str2) {
        f1245f = str;
        f1244e = str2;
    }

    /* renamed from: b */
    public String m1105b() {
        StringBuilder append;
        String str;
        if (this.f1254c != null) {
            append = new StringBuilder().append("v9.401|");
            str = this.f1254c;
        } else {
            append = new StringBuilder().append("v9.401|");
            str = this.f1252a;
        }
        return append.append(str).append("|").append(Build.MODEL).toString();
    }

    /* renamed from: c */
    public String m1106c() {
        String str;
        StringBuffer stringBuffer = new StringBuffer(200);
        if (this.f1254c != null) {
            stringBuffer.append("&cu=");
            str = this.f1254c;
        } else {
            stringBuffer.append("&im=");
            str = this.f1252a;
        }
        stringBuffer.append(str);
        try {
            stringBuffer.append("&mb=");
            stringBuffer.append(Build.MODEL);
        } catch (Exception unused) {
        }
        stringBuffer.append("&pack=");
        try {
            stringBuffer.append(f1244e);
        } catch (Exception unused2) {
        }
        stringBuffer.append("&sdk=");
        stringBuffer.append(9.401f);
        return stringBuffer.toString();
    }

    /* renamed from: d */
    public String m1107d() {
        String str;
        StringBuffer stringBuffer = new StringBuffer();
        if (this.f1254c == null) {
            stringBuffer.append("&im=");
            str = this.f1252a;
        } else {
            stringBuffer.append("&cu=");
            str = this.f1254c;
        }
        stringBuffer.append(str);
        stringBuffer.append("&sdk=");
        stringBuffer.append(9.401f);
        stringBuffer.append("&mb=");
        stringBuffer.append(Build.MODEL);
        stringBuffer.append("&stp=1");
        stringBuffer.append("&os=A");
        stringBuffer.append(Build.VERSION.SDK);
        stringBuffer.append("&prod=");
        stringBuffer.append(f1245f + ":" + f1244e);
        stringBuffer.append(C0733o.m1165f(ServiceC0702f.getServiceContext()));
        stringBuffer.append("&resid=");
        stringBuffer.append("12");
        return stringBuffer.toString();
    }
}