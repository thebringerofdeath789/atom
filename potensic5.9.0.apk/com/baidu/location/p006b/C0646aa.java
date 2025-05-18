package com.baidu.location.p006b;

import android.location.GnssNavigationMessage;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.baidu.location.p012h.C0733o;

/* renamed from: com.baidu.location.b.aa */
/* loaded from: classes.dex */
public class C0646aa {

    /* renamed from: a */
    private static Object f417a = new Object();

    /* renamed from: b */
    private static C0646aa f418b;

    /* renamed from: c */
    private HandlerThread f419c;

    /* renamed from: d */
    private Handler f420d;

    /* renamed from: e */
    private boolean f421e = false;

    C0646aa() {
    }

    /* renamed from: a */
    public static C0646aa m312a() {
        C0646aa c0646aa;
        synchronized (f417a) {
            if (f418b == null) {
                f418b = new C0646aa();
            }
            c0646aa = f418b;
        }
        return c0646aa;
    }

    /* renamed from: a */
    public void m313a(GnssNavigationMessage gnssNavigationMessage, long j) {
        if (!this.f421e || gnssNavigationMessage == null) {
            return;
        }
        try {
            Handler handler = this.f420d;
            if (handler != null) {
                Message obtainMessage = handler.obtainMessage(11);
                Bundle bundle = new Bundle();
                bundle.putParcelable("gnss_navigation_message", gnssNavigationMessage);
                bundle.putLong("gps_time", j);
                obtainMessage.setData(bundle);
                obtainMessage.sendToTarget();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public void m314a(Location location, int i) {
        if (!this.f421e || location == null) {
            return;
        }
        try {
            Handler handler = this.f420d;
            if (handler != null) {
                Message obtainMessage = handler.obtainMessage(1);
                Bundle bundle = new Bundle();
                bundle.putParcelable("loc", new Location(location));
                bundle.putInt("satnum", i);
                obtainMessage.setData(bundle);
                obtainMessage.sendToTarget();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: b */
    public void m315b() {
        if (this.f421e) {
            try {
                Handler handler = this.f420d;
                if (handler != null) {
                    handler.obtainMessage(3).sendToTarget();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: c */
    public void m316c() {
        if (this.f421e) {
            try {
                Handler handler = this.f420d;
                if (handler != null) {
                    handler.obtainMessage(2).sendToTarget();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: d */
    public void m317d() {
        if (this.f421e) {
            try {
                Handler handler = this.f420d;
                if (handler != null) {
                    handler.obtainMessage(7).sendToTarget();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: e */
    public void m318e() {
        if (this.f421e) {
            return;
        }
        this.f421e = true;
        if (this.f419c == null) {
            HandlerThread handlerThread = new HandlerThread("LocUploadThreadManager");
            this.f419c = handlerThread;
            handlerThread.start();
            if (this.f419c != null) {
                this.f420d = new HandlerC0647ab(this, this.f419c.getLooper());
            }
        }
        try {
            Handler handler = this.f420d;
            if (handler != null) {
                handler.obtainMessage(5).sendToTarget();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            Handler handler2 = this.f420d;
            if (handler2 != null) {
                handler2.sendEmptyMessageDelayed(4, C0733o.f1330Q);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* renamed from: f */
    public void m319f() {
        if (this.f421e) {
            C0654h.m411a().m439b();
            try {
                Handler handler = this.f420d;
                if (handler != null) {
                    handler.removeCallbacksAndMessages(null);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.f420d = null;
            try {
                HandlerThread handlerThread = this.f419c;
                if (handlerThread != null) {
                    handlerThread.quit();
                    this.f419c.interrupt();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            this.f419c = null;
            this.f421e = false;
        }
    }
}