package com.baidu.location.b;

import android.location.GnssNavigationMessage;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;

/* loaded from: classes.dex */
public class aa {
    private static Object a = new Object();
    private static aa b;
    private HandlerThread c;
    private Handler d;
    private boolean e = false;

    aa() {
    }

    public static aa a() {
        aa aaVar;
        synchronized (a) {
            if (b == null) {
                b = new aa();
            }
            aaVar = b;
        }
        return aaVar;
    }

    public void a(GnssNavigationMessage gnssNavigationMessage, long j) {
        if (!this.e || gnssNavigationMessage == null) {
            return;
        }
        try {
            Handler handler = this.d;
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

    public void a(Location location, int i) {
        if (!this.e || location == null) {
            return;
        }
        try {
            Handler handler = this.d;
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

    public void b() {
        if (this.e) {
            try {
                Handler handler = this.d;
                if (handler != null) {
                    handler.obtainMessage(3).sendToTarget();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void c() {
        if (this.e) {
            try {
                Handler handler = this.d;
                if (handler != null) {
                    handler.obtainMessage(2).sendToTarget();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void d() {
        if (this.e) {
            try {
                Handler handler = this.d;
                if (handler != null) {
                    handler.obtainMessage(7).sendToTarget();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void e() {
        if (this.e) {
            return;
        }
        this.e = true;
        if (this.c == null) {
            HandlerThread handlerThread = new HandlerThread("LocUploadThreadManager");
            this.c = handlerThread;
            handlerThread.start();
            if (this.c != null) {
                this.d = new ab(this, this.c.getLooper());
            }
        }
        try {
            Handler handler = this.d;
            if (handler != null) {
                handler.obtainMessage(5).sendToTarget();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            Handler handler2 = this.d;
            if (handler2 != null) {
                handler2.sendEmptyMessageDelayed(4, com.baidu.location.h.o.Q);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void f() {
        if (this.e) {
            h.a().b();
            try {
                Handler handler = this.d;
                if (handler != null) {
                    handler.removeCallbacksAndMessages(null);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.d = null;
            try {
                HandlerThread handlerThread = this.c;
                if (handlerThread != null) {
                    handlerThread.quit();
                    this.c.interrupt();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            this.c = null;
            this.e = false;
        }
    }
}
