package com.tencent.bugly.proguard;

import com.tencent.bugly.C3329b;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.w */
/* loaded from: classes3.dex */
public final class C3400w {

    /* renamed from: a */
    private static final AtomicInteger f3470a = new AtomicInteger(1);

    /* renamed from: b */
    private static C3400w f3471b;

    /* renamed from: c */
    private ScheduledExecutorService f3472c;

    protected C3400w() {
        this.f3472c = null;
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(3, new ThreadFactory(this) { // from class: com.tencent.bugly.proguard.w.1
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                Thread thread = new Thread(runnable);
                thread.setName("BuglyThread-" + C3400w.f3470a.getAndIncrement());
                return thread;
            }
        });
        this.f3472c = newScheduledThreadPool;
        if (newScheduledThreadPool == null || newScheduledThreadPool.isShutdown()) {
            C3401x.m2252d("[AsyncTaskHandler] ScheduledExecutorService is not valiable!", new Object[0]);
        }
    }

    /* renamed from: a */
    public static synchronized C3400w m2238a() {
        C3400w c3400w;
        synchronized (C3400w.class) {
            if (f3471b == null) {
                f3471b = new C3400w();
            }
            c3400w = f3471b;
        }
        return c3400w;
    }

    /* renamed from: a */
    public final synchronized boolean m2241a(Runnable runnable, long j) {
        if (!m2243c()) {
            C3401x.m2252d("[AsyncTaskHandler] Async handler was closed, should not post task.", new Object[0]);
            return false;
        }
        if (runnable == null) {
            C3401x.m2252d("[AsyncTaskHandler] Task input is null.", new Object[0]);
            return false;
        }
        if (j <= 0) {
            j = 0;
        }
        C3401x.m2251c("[AsyncTaskHandler] Post a delay(time: %dms) task: %s", Long.valueOf(j), runnable.getClass().getName());
        try {
            this.f3472c.schedule(runnable, j, TimeUnit.MILLISECONDS);
            return true;
        } catch (Throwable th) {
            if (C3329b.f2869c) {
                th.printStackTrace();
            }
            return false;
        }
    }

    /* renamed from: a */
    public final synchronized boolean m2240a(Runnable runnable) {
        if (!m2243c()) {
            C3401x.m2252d("[AsyncTaskHandler] Async handler was closed, should not post task.", new Object[0]);
            return false;
        }
        if (runnable == null) {
            C3401x.m2252d("[AsyncTaskHandler] Task input is null.", new Object[0]);
            return false;
        }
        C3401x.m2251c("[AsyncTaskHandler] Post a normal task: %s", runnable.getClass().getName());
        try {
            this.f3472c.execute(runnable);
            return true;
        } catch (Throwable th) {
            if (C3329b.f2869c) {
                th.printStackTrace();
            }
            return false;
        }
    }

    /* renamed from: b */
    public final synchronized void m2242b() {
        ScheduledExecutorService scheduledExecutorService = this.f3472c;
        if (scheduledExecutorService != null && !scheduledExecutorService.isShutdown()) {
            C3401x.m2251c("[AsyncTaskHandler] Close async handler.", new Object[0]);
            this.f3472c.shutdownNow();
        }
    }

    /* renamed from: c */
    public final synchronized boolean m2243c() {
        boolean z;
        ScheduledExecutorService scheduledExecutorService = this.f3472c;
        if (scheduledExecutorService != null) {
            z = scheduledExecutorService.isShutdown() ? false : true;
        }
        return z;
    }
}