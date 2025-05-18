package com.baidu.location.p011g;

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
import com.baidu.location.ServiceC0702f;
import com.baidu.location.indoor.C0755n;
import com.baidu.location.p005a.C0643a;
import com.baidu.location.p006b.C0646aa;
import com.baidu.location.p006b.C0648b;
import com.baidu.location.p006b.C0649c;
import com.baidu.location.p006b.C0650d;
import com.baidu.location.p006b.C0658l;
import com.baidu.location.p006b.C0662p;
import com.baidu.location.p006b.C0669w;
import com.baidu.location.p006b.C0670x;
import com.baidu.location.p006b.C0672z;
import com.baidu.location.p007c.C0674a;
import com.baidu.location.p007c.C0675b;
import com.baidu.location.p007c.C0677d;
import com.baidu.location.p007c.C0678e;
import com.baidu.location.p007c.C0680g;
import com.baidu.location.p009e.C0686a;
import com.baidu.location.p009e.C0693h;
import com.baidu.location.p010f.C0704b;
import com.baidu.location.p010f.C0709g;
import com.baidu.location.p010f.C0715m;
import com.baidu.location.p012h.C0720b;
import com.baidu.location.p012h.C0733o;
import com.google.android.exoplayer2.offline.DownloadService;
import java.lang.ref.WeakReference;

/* renamed from: com.baidu.location.g.a */
/* loaded from: classes.dex */
public class ServiceC0717a extends Service implements LLSInterface {

    /* renamed from: a */
    static a f1211a;

    /* renamed from: c */
    public static long f1212c;

    /* renamed from: g */
    private static long f1213g;

    /* renamed from: b */
    Messenger f1214b = null;

    /* renamed from: d */
    private Looper f1215d = null;

    /* renamed from: e */
    private HandlerThread f1216e = null;

    /* renamed from: f */
    private boolean f1217f = true;

    /* renamed from: h */
    private int f1218h = 0;

    /* renamed from: i */
    private boolean f1219i = true;

    /* renamed from: com.baidu.location.g.a$a */
    public static class a extends Handler {

        /* renamed from: a */
        private final WeakReference<ServiceC0717a> f1220a;

        public a(Looper looper, ServiceC0717a serviceC0717a) {
            super(looper);
            this.f1220a = new WeakReference<>(serviceC0717a);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            ServiceC0717a serviceC0717a = this.f1220a.get();
            if (serviceC0717a == null) {
                return;
            }
            if (ServiceC0702f.isServing) {
                int i = message.what;
                if (i == 11) {
                    serviceC0717a.m1088a(message);
                } else if (i == 12) {
                    serviceC0717a.m1092b(message);
                } else if (i == 15) {
                    serviceC0717a.m1096c(message);
                } else if (i == 22) {
                    C0662p.m509c().m527b(message);
                } else if (i == 28) {
                    C0662p.m509c().m526a(true, true);
                } else if (i == 41) {
                    C0662p.m509c().m536j();
                } else if (i == 114) {
                    Object obj = message.obj;
                    if (obj != null) {
                        C0755n.m1327a().m1383a((Bundle) obj);
                    }
                } else if (i == 401) {
                    try {
                        message.getData();
                    } catch (Exception unused) {
                    }
                } else if (i == 406) {
                    C0658l.m446a().m458e();
                } else if (i != 705) {
                    switch (i) {
                        case 110:
                            C0755n.m1327a().m1385c();
                            break;
                        case 111:
                            C0755n.m1327a().m1386d();
                            break;
                        case 112:
                            C0755n.m1327a().m1384b();
                            break;
                    }
                } else {
                    C0648b.m321a().m331a(message.getData().getBoolean(DownloadService.KEY_FOREGROUND));
                }
            }
            if (message.what == 1) {
                serviceC0717a.m1099d();
            }
            if (message.what == 0) {
                serviceC0717a.m1095c();
            }
            super.handleMessage(message);
        }
    }

    /* renamed from: a */
    public static Handler m1087a() {
        return f1211a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m1088a(Message message) {
        C0648b.m321a().m329a(message);
        C0693h.m828a();
        C0678e.m657a().m675d();
    }

    /* renamed from: b */
    public static long m1091b() {
        return f1213g;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m1092b(Message message) {
        C0648b.m321a().m333b(message);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m1095c() {
        C0678e.m657a().m673b();
        C0720b.m1100a();
        C0649c.m358a().m366a(ServiceC0702f.getServiceContext());
        try {
            C0646aa.m312a().m318e();
        } catch (Exception unused) {
        }
        C0658l.m446a().m455b();
        C0709g.m959a().m1022b();
        C0704b.m912a().m935b();
        C0662p.m509c().m530d();
        C0686a.m702a().m719c();
        C0677d.m647a().m651b();
        C0680g.m677a().m681b();
        C0674a.m623a().m630b();
        C0715m.m1058a().m1069c();
        this.f1218h = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m1096c(Message message) {
        C0648b.m321a().m337c(message);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m1099d() {
        C0709g.m959a().m1025e();
        C0715m.m1058a().m1071e();
        if (this.f1219i) {
            C0693h.m828a().m850n();
        }
        C0646aa.m312a().m319f();
        C0678e.m657a().m674c();
        C0677d.m647a().m652c();
        C0675b.m634a().m642c();
        C0674a.m623a().m631c();
        C0650d.m371a().m373b();
        C0704b.m912a().m937c();
        C0662p.m509c().m531e();
        C0755n.m1327a().m1386d();
        C0658l.m446a().m456c();
        if (this.f1219i) {
            C0672z.m615d();
        }
        C0648b.m321a().m332b();
        try {
            C0670x.m590a().m593d();
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.f1218h = 4;
        if (this.f1217f) {
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
            C0720b.f1247h = extras.getString("key");
            C0720b.f1246g = extras.getString("sign");
            this.f1217f = extras.getBoolean("kill_process");
            z = extras.getBoolean("cache_exception");
            str = extras.getString("auth_key");
        } else {
            z = false;
            str = null;
        }
        if (str != null) {
            C0643a.m295a().m299a(ServiceC0702f.getServiceContext(), str);
        }
        C0643a.m295a().m298a(ServiceC0702f.getServiceContext());
        if (!z) {
            Thread.setDefaultUncaughtExceptionHandler(C0680g.m677a());
        }
        return this.f1214b.getBinder();
    }

    @Override // com.baidu.location.LLSInterface
    public void onCreate(Context context) {
        LBSAuthManager.getInstance(ServiceC0702f.getServiceContext()).setPrivacyMode(true);
        try {
            C0733o.f1382aw = context.getPackageName();
        } catch (Exception unused) {
        }
        f1213g = System.currentTimeMillis();
        HandlerThread m589a = C0669w.m589a();
        this.f1216e = m589a;
        if (m589a != null) {
            this.f1215d = m589a.getLooper();
        }
        f1211a = this.f1215d == null ? new a(Looper.getMainLooper(), this) : new a(this.f1215d, this);
        f1212c = System.currentTimeMillis();
        this.f1214b = new Messenger(f1211a);
        f1211a.sendEmptyMessage(0);
        this.f1218h = 1;
    }

    @Override // android.app.Service, com.baidu.location.LLSInterface
    public void onDestroy() {
        try {
            f1211a.sendEmptyMessage(1);
        } catch (Exception unused) {
            Log.d("baidu_location_service", "baidu location service stop exception...");
            this.f1219i = false;
            m1099d();
            Process.killProcess(Process.myPid());
        }
        this.f1218h = 3;
        new Handler(Looper.getMainLooper()).postDelayed(new RunnableC0718b(this, new WeakReference(this)), 1000L);
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