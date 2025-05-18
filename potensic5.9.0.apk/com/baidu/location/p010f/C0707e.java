package com.baidu.location.p010f;

import android.location.Location;
import android.os.Build;
import com.baidu.location.p006b.C0664r;
import com.baidu.location.p012h.C0733o;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

/* renamed from: com.baidu.location.f.e */
/* loaded from: classes.dex */
public class C0707e {

    /* renamed from: a */
    public b f1059a = null;

    /* renamed from: b */
    public Location f1060b = null;

    /* renamed from: c */
    public Location f1061c = null;

    /* renamed from: d */
    public long f1062d = 0;

    /* renamed from: e */
    public long f1063e = 0;

    /* renamed from: f */
    private Timer f1064f = null;

    /* renamed from: g */
    private TimerTask f1065g = null;

    /* renamed from: com.baidu.location.f.e$a */
    private static class a {

        /* renamed from: a */
        private static C0707e f1066a = new C0707e();
    }

    /* renamed from: com.baidu.location.f.e$b */
    private class b implements C0664r.c {
        private b() {
        }

        /* synthetic */ b(C0707e c0707e, C0708f c0708f) {
            this();
        }

        @Override // com.baidu.location.p006b.C0664r.c
        /* renamed from: a */
        public void mo545a(Location location) {
            if (location == null) {
                return;
            }
            C0707e.this.f1060b = location;
            C0707e.this.f1063e = System.currentTimeMillis();
        }
    }

    /* renamed from: a */
    public static C0707e m946a() {
        return a.f1066a;
    }

    /* renamed from: e */
    private synchronized void m947e() {
        TimerTask timerTask = this.f1065g;
        if (timerTask != null) {
            timerTask.cancel();
            this.f1065g = null;
        }
        Timer timer = this.f1064f;
        if (timer != null) {
            timer.cancel();
            this.f1064f.purge();
            this.f1064f = null;
        }
    }

    /* renamed from: a */
    public void m948a(Location location) {
        this.f1061c = location;
        this.f1062d = System.currentTimeMillis();
    }

    /* renamed from: a */
    public boolean m949a(Location location, Location location2) {
        float[] fArr;
        if (location2 == null) {
            return false;
        }
        if (location == null) {
            return true;
        }
        try {
            fArr = new float[2];
            Location.distanceBetween(location.getLatitude(), location.getLongitude(), location2.getLatitude(), location2.getLongitude(), fArr);
        } catch (Exception unused) {
        }
        return fArr[0] >= 100.0f;
    }

    /* renamed from: b */
    public String m950b(Location location) {
        if (location != null) {
            return String.format(Locale.CHINA, "&ll=%.5f|%.5f&s=%.1f&d=%.1f&ll_n=%d&ll_t=%d&ll_r=%d", Double.valueOf(location.getLongitude()), Double.valueOf(location.getLatitude()), Float.valueOf((float) (location.getSpeed() * 3.6d)), Float.valueOf(location.getBearing()), 0, Long.valueOf(location.getTime() / 1000), Integer.valueOf((int) (location.hasAccuracy() ? location.getAccuracy() : -1.0f)));
        }
        return null;
    }

    /* renamed from: b */
    public void m951b() {
        if (Build.VERSION.SDK_INT >= 31 && C0733o.f1345aE != 0) {
            if (!C0733o.m1173l()) {
                m952c();
                return;
            }
            m947e();
            if (this.f1064f == null && this.f1065g == null) {
                this.f1064f = new Timer();
                C0708f c0708f = new C0708f(this);
                this.f1065g = c0708f;
                this.f1064f.schedule(c0708f, 60000L);
            }
            if (this.f1059a == null) {
                this.f1059a = new b(this, null);
                C0664r.m539a().m540a(this.f1059a);
            }
        }
    }

    /* renamed from: c */
    public synchronized void m952c() {
        if (this.f1059a != null) {
            C0664r.m539a().m542b(this.f1059a);
            this.f1059a = null;
        }
        m947e();
    }

    /* renamed from: d */
    public Location m953d() {
        return System.currentTimeMillis() - this.f1062d < 30000 ? this.f1061c : System.currentTimeMillis() - this.f1063e < 30000 ? this.f1060b : null;
    }
}