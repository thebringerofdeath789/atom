package com.baidu.location.g;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Process;
import android.util.Log;
import com.baidu.lbsapi.auth.LBSAuthManager;
import com.baidu.location.LLSInterface;
import com.baidu.location.b.aa;
import com.baidu.location.b.c;
import com.baidu.location.b.l;
import com.baidu.location.b.p;
import com.baidu.location.b.w;
import com.baidu.location.b.x;
import com.baidu.location.b.z;
import com.baidu.location.c.d;
import com.baidu.location.c.e;
import com.baidu.location.e.h;
import com.baidu.location.f;
import com.baidu.location.f.g;
import com.baidu.location.f.m;
import com.baidu.location.h.o;
import com.baidu.location.indoor.n;
import com.google.android.exoplayer2.offline.DownloadService;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public class a extends Service implements LLSInterface {
    static HandlerC0013a a;
    public static long c;
    private static long g;
    Messenger b = null;
    private Looper d = null;
    private HandlerThread e = null;
    private boolean f = true;
    private int h = 0;
    private boolean i = true;

    /* renamed from: com.baidu.location.g.a$a, reason: collision with other inner class name */
    public static class HandlerC0013a extends Handler {
        private final WeakReference<a> a;

        public HandlerC0013a(Looper looper, a aVar) {
            super(looper);
            this.a = new WeakReference<>(aVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            a aVar = this.a.get();
            if (aVar == null) {
                return;
            }
            if (f.isServing) {
                int i = message.what;
                if (i == 11) {
                    aVar.a(message);
                } else if (i == 12) {
                    aVar.b(message);
                } else if (i == 15) {
                    aVar.c(message);
                } else if (i == 22) {
                    p.c().b(message);
                } else if (i == 28) {
                    p.c().a(true, true);
                } else if (i == 41) {
                    p.c().j();
                } else if (i == 114) {
                    Object obj = message.obj;
                    if (obj != null) {
                        n.a().a((Bundle) obj);
                    }
                } else if (i == 401) {
                    try {
                        message.getData();
                    } catch (Exception unused) {
                    }
                } else if (i == 406) {
                    l.a().e();
                } else if (i != 705) {
                    switch (i) {
                        case 110:
                            n.a().c();
                            break;
                        case 111:
                            n.a().d();
                            break;
                        case 112:
                            n.a().b();
                            break;
                    }
                } else {
                    com.baidu.location.b.b.a().a(message.getData().getBoolean(DownloadService.KEY_FOREGROUND));
                }
            }
            if (message.what == 1) {
                aVar.d();
            }
            if (message.what == 0) {
                aVar.c();
            }
            super.handleMessage(message);
        }
    }

    public static Handler a() {
        return a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Message message) {
        com.baidu.location.b.b.a().a(message);
        h.a();
        e.a().d();
    }

    public static long b() {
        return g;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Message message) {
        com.baidu.location.b.b.a().b(message);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        e.a().b();
        com.baidu.location.h.b.a();
        c.a().a(f.getServiceContext());
        try {
            aa.a().e();
        } catch (Exception unused) {
        }
        l.a().b();
        g.a().b();
        com.baidu.location.f.b.a().b();
        p.c().d();
        com.baidu.location.e.a.a().c();
        d.a().b();
        com.baidu.location.c.g.a().b();
        com.baidu.location.c.a.a().b();
        m.a().c();
        this.h = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Message message) {
        com.baidu.location.b.b.a().c(message);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        g.a().e();
        m.a().e();
        if (this.i) {
            h.a().n();
        }
        aa.a().f();
        e.a().c();
        d.a().c();
        com.baidu.location.c.b.a().c();
        com.baidu.location.c.a.a().c();
        com.baidu.location.b.d.a().b();
        com.baidu.location.f.b.a().c();
        p.c().e();
        n.a().d();
        l.a().c();
        if (this.i) {
            z.d();
        }
        com.baidu.location.b.b.a().b();
        try {
            x.a().d();
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.h = 4;
        if (this.f) {
            return;
        }
        Process.killProcess(Process.myPid());
    }

    @Override // com.baidu.location.LLSInterface
    public double getVersion() {
        return 9.401000022888184d;
    }

    @Override // android.app.Service, com.baidu.location.LLSInterface
    public IBinder onBind(Intent intent) {
        boolean z;
        String str;
        Bundle extras = intent.getExtras();
        if (extras != null) {
            com.baidu.location.h.b.h = extras.getString("key");
            com.baidu.location.h.b.g = extras.getString("sign");
            this.f = extras.getBoolean("kill_process");
            z = extras.getBoolean("cache_exception");
            str = extras.getString("auth_key");
        } else {
            z = false;
            str = null;
        }
        if (str != null) {
            com.baidu.location.a.a.a().a(f.getServiceContext(), str);
        }
        com.baidu.location.a.a.a().a(f.getServiceContext());
        if (!z) {
            Thread.setDefaultUncaughtExceptionHandler(com.baidu.location.c.g.a());
        }
        return this.b.getBinder();
    }

    @Override // com.baidu.location.LLSInterface
    public void onCreate(Context context) {
        LBSAuthManager.getInstance(f.getServiceContext()).setPrivacyMode(true);
        try {
            o.aw = context.getPackageName();
        } catch (Exception unused) {
        }
        g = System.currentTimeMillis();
        HandlerThread a2 = w.a();
        this.e = a2;
        if (a2 != null) {
            this.d = a2.getLooper();
        }
        a = this.d == null ? new HandlerC0013a(Looper.getMainLooper(), this) : new HandlerC0013a(this.d, this);
        c = System.currentTimeMillis();
        this.b = new Messenger(a);
        a.sendEmptyMessage(0);
        this.h = 1;
    }

    @Override // android.app.Service, com.baidu.location.LLSInterface
    public void onDestroy() {
        try {
            a.sendEmptyMessage(1);
        } catch (Exception unused) {
            Log.d("baidu_location_service", "baidu location service stop exception...");
            this.i = false;
            d();
            Process.killProcess(Process.myPid());
        }
        this.h = 3;
        new Handler(Looper.getMainLooper()).postDelayed(new b(this, new WeakReference(this)), 1000L);
    }

    @Override // android.app.Service, com.baidu.location.LLSInterface
    public int onStartCommand(Intent intent, int i, int i2) {
        return 2;
    }

    @Override // android.app.Service, com.baidu.location.LLSInterface
    public void onTaskRemoved(Intent intent) {
        Log.d("baidu_location_service", "baidu location service remove task...");
    }

    @Override // com.baidu.location.LLSInterface
    public boolean onUnBind(Intent intent) {
        return false;
    }
}
