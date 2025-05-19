package com.baidu.location.b;

import android.location.GnssNavigationMessage;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* loaded from: classes.dex */
class ab extends Handler {
    final /* synthetic */ aa a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ab(aa aaVar, Looper looper) {
        super(looper);
        this.a = aaVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        com.baidu.location.f.a c;
        com.baidu.location.f.l p;
        Location d;
        String a;
        Handler handler;
        Handler handler2;
        switch (message.what) {
            case 1:
                Bundle data = message.getData();
                try {
                    Location location = (Location) data.getParcelable("loc");
                    data.getInt("satnum");
                    if (location != null) {
                        h.a().a(location);
                        return;
                    }
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            case 2:
                c = v.c();
                p = com.baidu.location.f.m.a().p();
                d = v.d();
                a = v.a();
                break;
            case 3:
                c = v.c();
                p = null;
                d = v.d();
                a = b.a().d();
                break;
            case 4:
                boolean k = com.baidu.location.f.m.a().k();
                boolean z = false;
                if (com.baidu.location.h.o.b()) {
                    k = false;
                }
                if (!k) {
                    z = k;
                } else if (l.a().d() != 1) {
                    z = true;
                }
                if (z) {
                    if (com.baidu.location.c.d.a().e()) {
                        com.baidu.location.e.h.a().m();
                        com.baidu.location.e.h.a().i();
                    }
                    com.baidu.location.c.h.a().c();
                    if (com.baidu.location.c.d.a().e()) {
                        z.a().c();
                    }
                }
                try {
                    handler = this.a.d;
                    if (handler != null) {
                        handler2 = this.a.d;
                        handler2.sendEmptyMessageDelayed(4, com.baidu.location.h.o.Q);
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                y.a().b();
                return;
            case 5:
                com.baidu.location.c.h.a().b();
                return;
            case 6:
            case 10:
            default:
                return;
            case 7:
                z.a().c();
                com.baidu.location.c.h.a().c();
                return;
            case 8:
            case 9:
                message.getData();
                return;
            case 11:
                Bundle data2 = message.getData();
                try {
                    y.a().a((GnssNavigationMessage) data2.getParcelable("gnss_navigation_message"), data2.getLong("gps_time"));
                    return;
                } catch (Exception unused) {
                    return;
                }
        }
        z.a(c, p, d, a, v.e());
    }
}
