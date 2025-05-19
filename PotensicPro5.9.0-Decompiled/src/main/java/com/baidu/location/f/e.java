package com.baidu.location.f;

import android.location.Location;
import android.os.Build;
import com.baidu.location.b.r;
import com.baidu.location.h.o;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: classes.dex */
public class e {
    public b a = null;
    public Location b = null;
    public Location c = null;
    public long d = 0;
    public long e = 0;
    private Timer f = null;
    private TimerTask g = null;

    private static class a {
        private static e a = new e();
    }

    private class b implements r.c {
        private b() {
        }

        /* synthetic */ b(e eVar, f fVar) {
            this();
        }

        @Override // com.baidu.location.b.r.c
        public void a(Location location) {
            if (location == null) {
                return;
            }
            e.this.b = location;
            e.this.e = System.currentTimeMillis();
        }
    }

    public static e a() {
        return a.a;
    }

    private synchronized void e() {
        TimerTask timerTask = this.g;
        if (timerTask != null) {
            timerTask.cancel();
            this.g = null;
        }
        Timer timer = this.f;
        if (timer != null) {
            timer.cancel();
            this.f.purge();
            this.f = null;
        }
    }

    public void a(Location location) {
        this.c = location;
        this.d = System.currentTimeMillis();
    }

    public boolean a(Location location, Location location2) {
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

    public String b(Location location) {
        if (location != null) {
            return String.format(Locale.CHINA, "&ll=%.5f|%.5f&s=%.1f&d=%.1f&ll_n=%d&ll_t=%d&ll_r=%d", Double.valueOf(location.getLongitude()), Double.valueOf(location.getLatitude()), Float.valueOf((float) (location.getSpeed() * 3.6d)), Float.valueOf(location.getBearing()), 0, Long.valueOf(location.getTime() / 1000), Integer.valueOf((int) (location.hasAccuracy() ? location.getAccuracy() : -1.0f)));
        }
        return null;
    }

    public void b() {
        if (Build.VERSION.SDK_INT >= 31 && o.aE != 0) {
            if (!o.l()) {
                c();
                return;
            }
            e();
            if (this.f == null && this.g == null) {
                this.f = new Timer();
                f fVar = new f(this);
                this.g = fVar;
                this.f.schedule(fVar, 60000L);
            }
            if (this.a == null) {
                this.a = new b(this, null);
                r.a().a(this.a);
            }
        }
    }

    public synchronized void c() {
        if (this.a != null) {
            r.a().b(this.a);
            this.a = null;
        }
        e();
    }

    public Location d() {
        return System.currentTimeMillis() - this.d < 30000 ? this.c : System.currentTimeMillis() - this.e < 30000 ? this.b : null;
    }
}
