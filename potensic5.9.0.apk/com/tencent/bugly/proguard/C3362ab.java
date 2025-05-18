package com.tencent.bugly.proguard;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.google.android.exoplayer2.SimpleExoPlayer;
import java.util.ArrayList;
import java.util.List;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.ab */
/* loaded from: classes3.dex */
public final class C3362ab extends Thread {

    /* renamed from: a */
    private boolean f3239a = false;

    /* renamed from: b */
    private boolean f3240b = false;

    /* renamed from: c */
    private List<RunnableC3361aa> f3241c = new ArrayList();

    /* renamed from: d */
    private List<InterfaceC3363ac> f3242d = new ArrayList();

    /* renamed from: e */
    private ArrayList<RunnableC3361aa> f3243e = new ArrayList<>();

    /* renamed from: a */
    public final void m2086a() {
        m2084a(new Handler(Looper.getMainLooper()), 5000L);
    }

    /* renamed from: b */
    public final void m2089b() {
        for (int i = 0; i < this.f3241c.size(); i++) {
            try {
                if (this.f3241c.get(i).m2082d().equals(Looper.getMainLooper().getThread().getName())) {
                    C3401x.m2251c("remove handler::%s", this.f3241c.get(i));
                    this.f3241c.remove(i);
                }
            } catch (Exception e) {
                C3401x.m2250b(e);
                return;
            }
        }
    }

    /* renamed from: a */
    private void m2084a(Handler handler, long j) {
        if (handler == null) {
            C3401x.m2253e("addThread handler should not be null", new Object[0]);
            return;
        }
        String name = handler.getLooper().getThread().getName();
        for (int i = 0; i < this.f3241c.size(); i++) {
            try {
                if (this.f3241c.get(i).m2082d().equals(handler.getLooper().getThread().getName())) {
                    C3401x.m2253e("addThread fail ,this thread has been added in monitor queue", new Object[0]);
                    return;
                }
            } catch (Exception e) {
                C3401x.m2250b(e);
            }
        }
        this.f3241c.add(new RunnableC3361aa(handler, name, 5000L));
    }

    /* renamed from: c */
    public final boolean m2091c() {
        this.f3239a = true;
        if (!isAlive()) {
            return false;
        }
        try {
            interrupt();
        } catch (Exception e) {
            C3401x.m2250b(e);
        }
        return true;
    }

    /* renamed from: d */
    public final boolean m2092d() {
        if (isAlive()) {
            return false;
        }
        try {
            start();
            return true;
        } catch (Exception e) {
            C3401x.m2250b(e);
            return false;
        }
    }

    /* renamed from: e */
    private int m2085e() {
        int i = 0;
        for (int i2 = 0; i2 < this.f3241c.size(); i2++) {
            try {
                i = Math.max(i, this.f3241c.get(i2).m2081c());
            } catch (Exception e) {
                C3401x.m2250b(e);
            }
        }
        return i;
    }

    /* renamed from: a */
    public final void m2087a(InterfaceC3363ac interfaceC3363ac) {
        if (this.f3242d.contains(interfaceC3363ac)) {
            C3401x.m2251c("addThreadMonitorListeners fail ,this threadMonitorListener has been added in monitor queue", new Object[0]);
        } else {
            this.f3242d.add(interfaceC3363ac);
        }
    }

    /* renamed from: b */
    public final void m2090b(InterfaceC3363ac interfaceC3363ac) {
        this.f3242d.remove(interfaceC3363ac);
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        while (!this.f3239a) {
            for (int i = 0; i < this.f3241c.size(); i++) {
                try {
                    this.f3241c.get(i).m2078a();
                } catch (Exception e) {
                    C3401x.m2250b(e);
                } catch (OutOfMemoryError e2) {
                    C3401x.m2250b(e2);
                }
            }
            long uptimeMillis = SystemClock.uptimeMillis();
            for (long j = 2000; j > 0 && !isInterrupted(); j = SimpleExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS - (SystemClock.uptimeMillis() - uptimeMillis)) {
                sleep(j);
            }
            int m2085e = m2085e();
            if (m2085e != 0 && m2085e != 1) {
                this.f3243e.clear();
                for (int i2 = 0; i2 < this.f3241c.size(); i2++) {
                    RunnableC3361aa runnableC3361aa = this.f3241c.get(i2);
                    if (runnableC3361aa.m2080b()) {
                        this.f3243e.add(runnableC3361aa);
                        runnableC3361aa.m2079a(Long.MAX_VALUE);
                    }
                }
                int i3 = 0;
                while (true) {
                    if (this.f3240b) {
                        break;
                    }
                    C3401x.m2251c("do not enable anr continue check", new Object[0]);
                    sleep(SimpleExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
                    i3++;
                    if (i3 == 15) {
                        this.f3243e.clear();
                        break;
                    }
                }
                for (int i4 = 0; i4 < this.f3243e.size(); i4++) {
                    RunnableC3361aa runnableC3361aa2 = this.f3243e.get(i4);
                    for (int i5 = 0; i5 < this.f3242d.size(); i5++) {
                        C3401x.m2253e("main thread blocked,now begin to upload anr stack", new Object[0]);
                        this.f3242d.get(i5).mo1966a(runnableC3361aa2);
                        this.f3240b = false;
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public final void m2088a(boolean z) {
        this.f3240b = true;
    }
}