package com.baidu.location.p006b;

import android.location.GnssNavigationMessage;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.location.p007c.C0677d;
import com.baidu.location.p007c.C0681h;
import com.baidu.location.p009e.C0693h;
import com.baidu.location.p010f.C0703a;
import com.baidu.location.p010f.C0714l;
import com.baidu.location.p010f.C0715m;
import com.baidu.location.p012h.C0733o;

/* renamed from: com.baidu.location.b.ab */
/* loaded from: classes.dex */
class HandlerC0647ab extends Handler {

    /* renamed from: a */
    final /* synthetic */ C0646aa f422a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HandlerC0647ab(C0646aa c0646aa, Looper looper) {
        super(looper);
        this.f422a = c0646aa;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        C0703a m586c;
        C0714l m1082p;
        Location m587d;
        String m579a;
        Handler handler;
        Handler handler2;
        switch (message.what) {
            case 1:
                Bundle data = message.getData();
                try {
                    Location location = (Location) data.getParcelable("loc");
                    data.getInt("satnum");
                    if (location != null) {
                        C0654h.m411a().m438a(location);
                        return;
                    }
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            case 2:
                m586c = C0668v.m586c();
                m1082p = C0715m.m1058a().m1082p();
                m587d = C0668v.m587d();
                m579a = C0668v.m579a();
                break;
            case 3:
                m586c = C0668v.m586c();
                m1082p = null;
                m587d = C0668v.m587d();
                m579a = C0648b.m321a().m339d();
                break;
            case 4:
                boolean m1077k = C0715m.m1058a().m1077k();
                boolean z = false;
                if (C0733o.m1152b()) {
                    m1077k = false;
                }
                if (!m1077k) {
                    z = m1077k;
                } else if (C0658l.m446a().m457d() != 1) {
                    z = true;
                }
                if (z) {
                    if (C0677d.m647a().m654e()) {
                        C0693h.m828a().m849m();
                        C0693h.m828a().m845i();
                    }
                    C0681h.m682a().m689c();
                    if (C0677d.m647a().m654e()) {
                        C0672z.m602a().m620c();
                    }
                }
                try {
                    handler = this.f422a.f420d;
                    if (handler != null) {
                        handler2 = this.f422a.f420d;
                        handler2.sendEmptyMessageDelayed(4, C0733o.f1330Q);
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                C0671y.m595a().m597b();
                return;
            case 5:
                C0681h.m682a().m688b();
                return;
            case 6:
            case 10:
            default:
                return;
            case 7:
                C0672z.m602a().m620c();
                C0681h.m682a().m689c();
                return;
            case 8:
            case 9:
                message.getData();
                return;
            case 11:
                Bundle data2 = message.getData();
                try {
                    C0671y.m595a().m596a((GnssNavigationMessage) data2.getParcelable("gnss_navigation_message"), data2.getLong("gps_time"));
                    return;
                } catch (Exception unused) {
                    return;
                }
        }
        C0672z.m605a(m586c, m1082p, m587d, m579a, C0668v.m588e());
    }
}