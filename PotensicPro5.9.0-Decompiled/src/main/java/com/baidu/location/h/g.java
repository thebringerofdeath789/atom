package com.baidu.location.h;

import java.net.URL;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

/* loaded from: classes.dex */
public abstract class g {
    public String h = null;
    public int i = 1;
    public String j = null;
    public Map<String, Object> k = null;
    public String l = null;
    public byte[] m = null;
    public byte[] n = null;
    public String o = null;
    public boolean p = false;
    public static int g = com.baidu.location.h.a.f;
    private static String a = "10.0.0.172";
    private static int b = 80;
    protected static int q = 0;

    /* JADX INFO: Access modifiers changed from: private */
    static class a implements HostnameVerifier {
        private URL a;

        public a(URL url) {
            this.a = url;
        }

        @Override // javax.net.ssl.HostnameVerifier
        public boolean verify(String str, SSLSession sSLSession) {
            return this.a.getHost().equals(str);
        }
    }

    public void a(ExecutorService executorService) {
        try {
            executorService.execute(new i(this));
        } catch (Throwable unused) {
            a(false);
        }
    }

    public void a(ExecutorService executorService, String str) {
        try {
            executorService.execute(new m(this, str));
        } catch (Throwable unused) {
            a(false);
        }
    }

    public void a(ExecutorService executorService, boolean z, String str) {
        try {
            executorService.execute(new j(this, str, z));
        } catch (Throwable unused) {
            a(false);
        }
    }

    public abstract void a(boolean z);

    public void a(boolean z, String str) {
        try {
            new k(this, str, z).start();
        } catch (Throwable unused) {
            a(false);
        }
    }

    public abstract void b();

    public void b(boolean z) {
        try {
            new h(this, z).start();
        } catch (Throwable unused) {
            a(false);
        }
    }

    public void e(String str) {
        try {
            new l(this, str).start();
        } catch (Throwable unused) {
            a(false);
        }
    }
}
