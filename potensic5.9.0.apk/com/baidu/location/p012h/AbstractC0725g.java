package com.baidu.location.p012h;

import java.net.URL;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

/* renamed from: com.baidu.location.h.g */
/* loaded from: classes.dex */
public abstract class AbstractC0725g {

    /* renamed from: h */
    public String f1289h = null;

    /* renamed from: i */
    public int f1290i = 1;

    /* renamed from: j */
    public String f1291j = null;

    /* renamed from: k */
    public Map<String, Object> f1292k = null;

    /* renamed from: l */
    public String f1293l = null;

    /* renamed from: m */
    public byte[] f1294m = null;

    /* renamed from: n */
    public byte[] f1295n = null;

    /* renamed from: o */
    public String f1296o = null;

    /* renamed from: p */
    public boolean f1297p = false;

    /* renamed from: g */
    public static int f1287g = C0719a.f1228f;

    /* renamed from: a */
    private static String f1285a = "10.0.0.172";

    /* renamed from: b */
    private static int f1286b = 80;

    /* renamed from: q */
    protected static int f1288q = 0;

    /* renamed from: com.baidu.location.h.g$a */
    private static class a implements HostnameVerifier {

        /* renamed from: a */
        private URL f1298a;

        public a(URL url) {
            this.f1298a = url;
        }

        @Override // javax.net.ssl.HostnameVerifier
        public boolean verify(String str, SSLSession sSLSession) {
            return this.f1298a.getHost().equals(str);
        }
    }

    /* renamed from: a */
    public void m1128a(ExecutorService executorService) {
        try {
            executorService.execute(new RunnableC0727i(this));
        } catch (Throwable unused) {
            mo122a(false);
        }
    }

    /* renamed from: a */
    public void m1129a(ExecutorService executorService, String str) {
        try {
            executorService.execute(new RunnableC0731m(this, str));
        } catch (Throwable unused) {
            mo122a(false);
        }
    }

    /* renamed from: a */
    public void m1130a(ExecutorService executorService, boolean z, String str) {
        try {
            executorService.execute(new RunnableC0728j(this, str, z));
        } catch (Throwable unused) {
            mo122a(false);
        }
    }

    /* renamed from: a */
    public abstract void mo122a(boolean z);

    /* renamed from: a */
    public void m1131a(boolean z, String str) {
        try {
            new C0729k(this, str, z).start();
        } catch (Throwable unused) {
            mo122a(false);
        }
    }

    /* renamed from: b */
    public abstract void mo123b();

    /* renamed from: b */
    public void m1132b(boolean z) {
        try {
            new C0726h(this, z).start();
        } catch (Throwable unused) {
            mo122a(false);
        }
    }

    /* renamed from: e */
    public void m1133e(String str) {
        try {
            new C0730l(this, str).start();
        } catch (Throwable unused) {
            mo122a(false);
        }
    }
}