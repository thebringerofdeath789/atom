package com.baidu.location.p007c;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Message;
import androidx.core.app.NotificationCompat;
import com.baidu.location.ServiceC0702f;
import com.baidu.location.p006b.C0662p;
import com.baidu.location.p010f.C0709g;
import com.baidu.location.p012h.C0733o;
import com.hjq.permissions.Permission;

/* renamed from: com.baidu.location.c.b */
/* loaded from: classes.dex */
public class C0675b {

    /* renamed from: a */
    private static C0675b f782a;

    /* renamed from: b */
    private boolean f783b = false;

    /* renamed from: c */
    private Handler f784c = null;

    /* renamed from: d */
    private AlarmManager f785d = null;

    /* renamed from: e */
    private a f786e = null;

    /* renamed from: f */
    private PendingIntent f787f = null;

    /* renamed from: g */
    private long f788g = 0;

    /* renamed from: com.baidu.location.c.b$a */
    private class a extends BroadcastReceiver {
        private a() {
        }

        /* synthetic */ a(C0675b c0675b, HandlerC0676c handlerC0676c) {
            this();
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (C0675b.this.f783b && intent.getAction().equals("com.baidu.location.autonotifyloc_9.4.0.1") && C0675b.this.f784c != null) {
                C0675b.this.f787f = null;
                C0675b.this.f784c.sendEmptyMessage(1);
            }
        }
    }

    private C0675b() {
    }

    /* renamed from: a */
    public static synchronized C0675b m634a() {
        C0675b c0675b;
        synchronized (C0675b.class) {
            if (f782a == null) {
                f782a = new C0675b();
            }
            c0675b = f782a;
        }
        return c0675b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public void m639f() {
        if (System.currentTimeMillis() - this.f788g < 1000) {
            return;
        }
        PendingIntent pendingIntent = this.f787f;
        if (pendingIntent != null) {
            this.f785d.cancel(pendingIntent);
            this.f787f = null;
        }
        if (this.f787f == null) {
            this.f787f = PendingIntent.getBroadcast(ServiceC0702f.getServiceContext(), 0, new Intent("com.baidu.location.autonotifyloc_9.4.0.1"), 201326592);
            this.f785d.set(0, System.currentTimeMillis() + C0733o.f1336W, this.f787f);
        }
        Message message = new Message();
        message.what = 22;
        if (System.currentTimeMillis() - this.f788g < C0733o.f1337X) {
            return;
        }
        this.f788g = System.currentTimeMillis();
        if (C0709g.m959a().m1031k()) {
            return;
        }
        C0662p.m509c().m527b(message);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public void m640g() {
        if (this.f783b) {
            try {
                PendingIntent pendingIntent = this.f787f;
                if (pendingIntent != null) {
                    this.f785d.cancel(pendingIntent);
                    this.f787f = null;
                }
                ServiceC0702f.getServiceContext().unregisterReceiver(this.f786e);
            } catch (Exception unused) {
            }
            this.f785d = null;
            this.f786e = null;
            this.f784c = null;
            this.f783b = false;
        }
    }

    /* renamed from: b */
    public void m641b() {
        if (!this.f783b && C0733o.f1336W >= 10000) {
            if (this.f784c == null) {
                this.f784c = new HandlerC0676c(this);
            }
            this.f785d = (AlarmManager) ServiceC0702f.getServiceContext().getSystemService(NotificationCompat.CATEGORY_ALARM);
            this.f786e = new a(this, null);
            ServiceC0702f.getServiceContext().registerReceiver(this.f786e, new IntentFilter("com.baidu.location.autonotifyloc_9.4.0.1"), Permission.ACCESS_FINE_LOCATION, null);
            this.f787f = PendingIntent.getBroadcast(ServiceC0702f.getServiceContext(), 0, new Intent("com.baidu.location.autonotifyloc_9.4.0.1"), 201326592);
            this.f785d.set(0, System.currentTimeMillis() + C0733o.f1336W, this.f787f);
            this.f783b = true;
            this.f788g = System.currentTimeMillis();
        }
    }

    /* renamed from: c */
    public void m642c() {
        Handler handler;
        if (this.f783b && (handler = this.f784c) != null) {
            handler.sendEmptyMessage(2);
        }
    }

    /* renamed from: d */
    public void m643d() {
        Handler handler;
        if (this.f783b && (handler = this.f784c) != null) {
            handler.sendEmptyMessage(1);
        }
    }

    /* renamed from: e */
    public void m644e() {
        Handler handler;
        if (this.f783b && (handler = this.f784c) != null) {
            handler.sendEmptyMessage(1);
        }
    }
}