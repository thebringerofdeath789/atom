package com.baidu.location.e;

import android.content.Context;
import android.content.pm.ProviderInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import com.baidu.location.BDLocation;
import com.google.android.exoplayer2.SimpleExoPlayer;
import java.io.File;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes.dex */
public final class h {
    static final String a = "http://ofloc.map.baidu.com/offline_loc";
    private static Context b;
    private static volatile h c;
    private static Object d = new Object();
    private final File e;
    private final k f;
    private final com.baidu.location.e.c g;
    private final l h;
    private final f i;
    private ExecutorService j = null;

    public enum a {
        NEED_TO_LOG,
        NO_NEED_TO_LOG
    }

    public enum b {
        IS_MIX_MODE,
        IS_NOT_MIX_MODE
    }

    private enum c {
        NETWORK_UNKNOWN,
        NETWORK_WIFI,
        NETWORK_2G,
        NETWORK_3G,
        NETWORK_4G
    }

    private h() {
        File file;
        File file2 = null;
        try {
            file = new File(b.getFilesDir(), "ofld");
            try {
                if (!file.exists()) {
                    file.mkdir();
                }
            } catch (Exception unused) {
                file2 = file;
                file = file2;
                this.e = file;
                com.baidu.location.e.c cVar = new com.baidu.location.e.c(this);
                this.g = cVar;
                this.f = new k(cVar.a());
                f fVar = new f(this, cVar.a());
                this.i = fVar;
                this.h = new l(this, cVar.a(), fVar.n());
            }
        } catch (Exception unused2) {
        }
        this.e = file;
        com.baidu.location.e.c cVar2 = new com.baidu.location.e.c(this);
        this.g = cVar2;
        this.f = new k(cVar2.a());
        f fVar2 = new f(this, cVar2.a());
        this.i = fVar2;
        this.h = new l(this, cVar2.a(), fVar2.n());
    }

    private BDLocation a(String[] strArr) {
        new BDLocation();
        if (this.j == null) {
            this.j = Executors.newSingleThreadExecutor();
        }
        FutureTask futureTask = (FutureTask) this.j.submit(new i(this, strArr));
        try {
            return (BDLocation) futureTask.get(SimpleExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException unused) {
            futureTask.cancel(true);
            return null;
        }
    }

    public static h a() {
        h hVar;
        synchronized (d) {
            if (c == null) {
                if (b == null) {
                    a(com.baidu.location.f.getServiceContext());
                }
                c = new h();
            }
            c.q();
            hVar = c;
        }
        return hVar;
    }

    public static void a(Context context) {
        if (b == null) {
            b = context;
            com.baidu.location.h.b.a().a(b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Uri c(String str) {
        return Uri.parse(String.format("content://%s/", str));
    }

    private void q() {
        this.i.g();
    }

    private boolean r() {
        String packageName = b.getPackageName();
        ProviderInfo providerInfo = null;
        for (String str : this.i.o()) {
            try {
                providerInfo = b.getPackageManager().resolveContentProvider(str, 0);
            } catch (Exception unused) {
                providerInfo = null;
            }
            if (providerInfo != null) {
                break;
            }
        }
        return providerInfo == null || packageName.equals(providerInfo.packageName);
    }

    public long a(String str) {
        return this.i.a(str);
    }

    public BDLocation a(com.baidu.location.f.a aVar, com.baidu.location.f.l lVar, BDLocation bDLocation, b bVar, a aVar2) {
        String d2;
        int i;
        if (bVar == b.IS_MIX_MODE) {
            i = this.i.a();
            d2 = com.baidu.location.h.b.a().d() + "&mixMode=1";
        } else {
            d2 = com.baidu.location.h.b.a().d();
            i = 0;
        }
        String[] a2 = j.a(aVar, lVar, bDLocation, d2, (aVar2 == a.NEED_TO_LOG).booleanValue(), i);
        BDLocation bDLocation2 = null;
        if (a2.length > 0 && (bDLocation2 = a(a2)) != null) {
            bDLocation2.getLocType();
        }
        return bDLocation2;
    }

    public Context b() {
        return b;
    }

    File c() {
        return this.e;
    }

    public boolean d() {
        return this.i.h();
    }

    public boolean e() {
        return this.i.i();
    }

    public boolean f() {
        return this.i.j();
    }

    public boolean g() {
        return this.i.k();
    }

    public boolean h() {
        return this.i.m();
    }

    public void i() {
        if (com.baidu.location.h.o.b()) {
            return;
        }
        this.f.a();
    }

    k j() {
        return this.f;
    }

    l k() {
        return this.h;
    }

    f l() {
        return this.i;
    }

    public void m() {
        if (!r() || com.baidu.location.h.o.b()) {
            return;
        }
        this.g.b();
    }

    public void n() {
    }

    public double o() {
        NetworkInfo networkInfo;
        try {
            networkInfo = ((ConnectivityManager) b.getSystemService("connectivity")).getActiveNetworkInfo();
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
            return this.i.b();
        }
        if (cVar == c.NETWORK_WIFI) {
            return this.i.c();
        }
        if (cVar == c.NETWORK_2G) {
            return this.i.d();
        }
        if (cVar == c.NETWORK_3G) {
            return this.i.e();
        }
        if (cVar == c.NETWORK_4G) {
            return this.i.f();
        }
        return 0.0d;
    }
}
