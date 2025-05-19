package com.baidu.location.c;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Message;
import androidx.core.app.NotificationCompat;
import com.baidu.location.b.p;
import com.baidu.location.h.o;
import com.hjq.permissions.Permission;

/* loaded from: classes.dex */
public class b {
    private static b a;
    private boolean b = false;
    private Handler c = null;
    private AlarmManager d = null;
    private a e = null;
    private PendingIntent f = null;
    private long g = 0;

    private class a extends BroadcastReceiver {
        private a() {
        }

        /* synthetic */ a(b bVar, c cVar) {
            this();
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (b.this.b && intent.getAction().equals("com.baidu.location.autonotifyloc_9.4.0.1") && b.this.c != null) {
                b.this.f = null;
                b.this.c.sendEmptyMessage(1);
            }
        }
    }

    private b() {
    }

    public static synchronized b a() {
        b bVar;
        synchronized (b.class) {
            if (a == null) {
                a = new b();
            }
            bVar = a;
        }
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        if (System.currentTimeMillis() - this.g < 1000) {
            return;
        }
        PendingIntent pendingIntent = this.f;
        if (pendingIntent != null) {
            this.d.cancel(pendingIntent);
            this.f = null;
        }
        if (this.f == null) {
            this.f = PendingIntent.getBroadcast(com.baidu.location.f.getServiceContext(), 0, new Intent("com.baidu.location.autonotifyloc_9.4.0.1"), 201326592);
            this.d.set(0, System.currentTimeMillis() + o.W, this.f);
        }
        Message message = new Message();
        message.what = 22;
        if (System.currentTimeMillis() - this.g < o.X) {
            return;
        }
        this.g = System.currentTimeMillis();
        if (com.baidu.location.f.g.a().k()) {
            return;
        }
        p.c().b(message);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        if (this.b) {
            try {
                PendingIntent pendingIntent = this.f;
                if (pendingIntent != null) {
                    this.d.cancel(pendingIntent);
                    this.f = null;
                }
                com.baidu.location.f.getServiceContext().unregisterReceiver(this.e);
            } catch (Exception unused) {
            }
            this.d = null;
            this.e = null;
            this.c = null;
            this.b = false;
        }
    }

    public void b() {
        if (!this.b && o.W >= 10000) {
            if (this.c == null) {
                this.c = new c(this);
            }
            this.d = (AlarmManager) com.baidu.location.f.getServiceContext().getSystemService(NotificationCompat.CATEGORY_ALARM);
            this.e = new a(this, null);
            com.baidu.location.f.getServiceContext().registerReceiver(this.e, new IntentFilter("com.baidu.location.autonotifyloc_9.4.0.1"), Permission.ACCESS_FINE_LOCATION, null);
            this.f = PendingIntent.getBroadcast(com.baidu.location.f.getServiceContext(), 0, new Intent("com.baidu.location.autonotifyloc_9.4.0.1"), 201326592);
            this.d.set(0, System.currentTimeMillis() + o.W, this.f);
            this.b = true;
            this.g = System.currentTimeMillis();
        }
    }

    public void c() {
        Handler handler;
        if (this.b && (handler = this.c) != null) {
            handler.sendEmptyMessage(2);
        }
    }

    public void d() {
        Handler handler;
        if (this.b && (handler = this.c) != null) {
            handler.sendEmptyMessage(1);
        }
    }

    public void e() {
        Handler handler;
        if (this.b && (handler = this.c) != null) {
            handler.sendEmptyMessage(1);
        }
    }
}
