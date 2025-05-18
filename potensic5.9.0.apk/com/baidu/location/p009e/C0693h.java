package com.baidu.location.p009e;

import android.content.Context;
import android.content.pm.ProviderInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import com.baidu.location.BDLocation;
import com.baidu.location.ServiceC0702f;
import com.baidu.location.p010f.C0703a;
import com.baidu.location.p010f.C0714l;
import com.baidu.location.p012h.C0720b;
import com.baidu.location.p012h.C0733o;
import com.google.android.exoplayer2.SimpleExoPlayer;
import java.io.File;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* renamed from: com.baidu.location.e.h */
/* loaded from: classes.dex */
public final class C0693h {

    /* renamed from: a */
    static final String f942a = "http://ofloc.map.baidu.com/offline_loc";

    /* renamed from: b */
    private static Context f943b;

    /* renamed from: c */
    private static volatile C0693h f944c;

    /* renamed from: d */
    private static Object f945d = new Object();

    /* renamed from: e */
    private final File f946e;

    /* renamed from: f */
    private final C0696k f947f;

    /* renamed from: g */
    private final C0688c f948g;

    /* renamed from: h */
    private final C0697l f949h;

    /* renamed from: i */
    private final C0691f f950i;

    /* renamed from: j */
    private ExecutorService f951j = null;

    /* renamed from: com.baidu.location.e.h$a */
    public enum a {
        NEED_TO_LOG,
        NO_NEED_TO_LOG
    }

    /* renamed from: com.baidu.location.e.h$b */
    public enum b {
        IS_MIX_MODE,
        IS_NOT_MIX_MODE
    }

    /* renamed from: com.baidu.location.e.h$c */
    private enum c {
        NETWORK_UNKNOWN,
        NETWORK_WIFI,
        NETWORK_2G,
        NETWORK_3G,
        NETWORK_4G
    }

    private C0693h() {
        File file;
        File file2 = null;
        try {
            file = new File(f943b.getFilesDir(), "ofld");
            try {
                if (!file.exists()) {
                    file.mkdir();
                }
            } catch (Exception unused) {
                file2 = file;
                file = file2;
                this.f946e = file;
                C0688c c0688c = new C0688c(this);
                this.f948g = c0688c;
                this.f947f = new C0696k(c0688c.m743a());
                C0691f c0691f = new C0691f(this, c0688c.m743a());
                this.f950i = c0691f;
                this.f949h = new C0697l(this, c0688c.m743a(), c0691f.m819n());
            }
        } catch (Exception unused2) {
        }
        this.f946e = file;
        C0688c c0688c2 = new C0688c(this);
        this.f948g = c0688c2;
        this.f947f = new C0696k(c0688c2.m743a());
        C0691f c0691f2 = new C0691f(this, c0688c2.m743a());
        this.f950i = c0691f2;
        this.f949h = new C0697l(this, c0688c2.m743a(), c0691f2.m819n());
    }

    /* renamed from: a */
    private BDLocation m826a(String[] strArr) {
        new BDLocation();
        if (this.f951j == null) {
            this.f951j = Executors.newSingleThreadExecutor();
        }
        FutureTask futureTask = (FutureTask) this.f951j.submit(new CallableC0694i(this, strArr));
        try {
            return (BDLocation) futureTask.get(SimpleExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException unused) {
            futureTask.cancel(true);
            return null;
        }
    }

    /* renamed from: a */
    public static C0693h m828a() {
        C0693h c0693h;
        synchronized (f945d) {
            if (f944c == null) {
                if (f943b == null) {
                    m829a(ServiceC0702f.getServiceContext());
                }
                f944c = new C0693h();
            }
            f944c.m834q();
            c0693h = f944c;
        }
        return c0693h;
    }

    /* renamed from: a */
    public static void m829a(Context context) {
        if (f943b == null) {
            f943b = context;
            C0720b.m1100a().m1103a(f943b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public static final Uri m832c(String str) {
        return Uri.parse(String.format("content://%s/", str));
    }

    /* renamed from: q */
    private void m834q() {
        this.f950i.m812g();
    }

    /* renamed from: r */
    private boolean m835r() {
        String packageName = f943b.getPackageName();
        ProviderInfo providerInfo = null;
        for (String str : this.f950i.m820o()) {
            try {
                providerInfo = f943b.getPackageManager().resolveContentProvider(str, 0);
            } catch (Exception unused) {
                providerInfo = null;
            }
            if (providerInfo != null) {
                break;
            }
        }
        return providerInfo == null || packageName.equals(providerInfo.packageName);
    }

    /* renamed from: a */
    public long m836a(String str) {
        return this.f950i.m805a(str);
    }

    /* renamed from: a */
    public BDLocation m837a(C0703a c0703a, C0714l c0714l, BDLocation bDLocation, b bVar, a aVar) {
        String m1107d;
        int i;
        if (bVar == b.IS_MIX_MODE) {
            i = this.f950i.m804a();
            m1107d = C0720b.m1100a().m1107d() + "&mixMode=1";
        } else {
            m1107d = C0720b.m1100a().m1107d();
            i = 0;
        }
        String[] m857a = C0695j.m857a(c0703a, c0714l, bDLocation, m1107d, (aVar == a.NEED_TO_LOG).booleanValue(), i);
        BDLocation bDLocation2 = null;
        if (m857a.length > 0 && (bDLocation2 = m826a(m857a)) != null) {
            bDLocation2.getLocType();
        }
        return bDLocation2;
    }

    /* renamed from: b */
    public Context m838b() {
        return f943b;
    }

    /* renamed from: c */
    File m839c() {
        return this.f946e;
    }

    /* renamed from: d */
    public boolean m840d() {
        return this.f950i.m813h();
    }

    /* renamed from: e */
    public boolean m841e() {
        return this.f950i.m814i();
    }

    /* renamed from: f */
    public boolean m842f() {
        return this.f950i.m815j();
    }

    /* renamed from: g */
    public boolean m843g() {
        return this.f950i.m816k();
    }

    /* renamed from: h */
    public boolean m844h() {
        return this.f950i.m818m();
    }

    /* renamed from: i */
    public void m845i() {
        if (C0733o.m1152b()) {
            return;
        }
        this.f947f.m862a();
    }

    /* renamed from: j */
    C0696k m846j() {
        return this.f947f;
    }

    /* renamed from: k */
    C0697l m847k() {
        return this.f949h;
    }

    /* renamed from: l */
    C0691f m848l() {
        return this.f950i;
    }

    /* renamed from: m */
    public void m849m() {
        if (!m835r() || C0733o.m1152b()) {
            return;
        }
        this.f948g.m744b();
    }

    /* renamed from: n */
    public void m850n() {
    }

    /* renamed from: o */
    public double m851o() {
        NetworkInfo networkInfo;
        try {
            networkInfo = ((ConnectivityManager) f943b.getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Throwable th) {
            th.printStackTrace();
            networkInfo = null;
        }
        c cVar = c.NETWORK_UNKNOWN;
        if (networkInfo != null && networkInfo.isConnected()) {
            if (networkInfo.getType() == 1) {
                cVar = c.NETWORK_WIFI;
            }
            if (networkInfo.getType() == 0) {
                int subtype = networkInfo.getSubtype();
                if (subtype == 1 || subtype == 2 || subtype == 4 || subtype == 7 || subtype == 11) {
                    cVar = c.NETWORK_2G;
                } else if (subtype == 3 || subtype == 5 || subtype == 6 || subtype == 8 || subtype == 9 || subtype == 10 || subtype == 12 || subtype == 14 || subtype == 15) {
                    cVar = c.NETWORK_3G;
                } else if (subtype == 13) {
                    cVar = c.NETWORK_4G;
                }
            }
        }
        if (cVar == c.NETWORK_UNKNOWN) {
            return this.f950i.m807b();
        }
        if (cVar == c.NETWORK_WIFI) {
            return this.f950i.m808c();
        }
        if (cVar == c.NETWORK_2G) {
            return this.f950i.m809d();
        }
        if (cVar == c.NETWORK_3G) {
            return this.f950i.m810e();
        }
        if (cVar == c.NETWORK_4G) {
            return this.f950i.m811f();
        }
        return 0.0d;
    }
}