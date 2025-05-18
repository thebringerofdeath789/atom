package com.tencent.bugly.proguard;

import android.content.Context;
import android.os.Process;
import com.tencent.bugly.C3329b;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.u */
/* loaded from: classes3.dex */
public final class C3398u {

    /* renamed from: a */
    private static C3398u f3437a;

    /* renamed from: c */
    private final Context f3439c;

    /* renamed from: e */
    private long f3441e;

    /* renamed from: f */
    private long f3442f;

    /* renamed from: d */
    private Map<Integer, Long> f3440d = new HashMap();

    /* renamed from: g */
    private LinkedBlockingQueue<Runnable> f3443g = new LinkedBlockingQueue<>();

    /* renamed from: h */
    private LinkedBlockingQueue<Runnable> f3444h = new LinkedBlockingQueue<>();

    /* renamed from: i */
    private final Object f3445i = new Object();

    /* renamed from: j */
    private int f3446j = 0;

    /* renamed from: b */
    private final C3393p f3438b = C3393p.m2187a();

    /* renamed from: b */
    static /* synthetic */ int m2224b(C3398u c3398u) {
        int i = c3398u.f3446j - 1;
        c3398u.f3446j = i;
        return i;
    }

    private C3398u(Context context) {
        this.f3439c = context;
    }

    /* renamed from: a */
    public static synchronized C3398u m2220a(Context context) {
        C3398u c3398u;
        synchronized (C3398u.class) {
            if (f3437a == null) {
                f3437a = new C3398u(context);
            }
            c3398u = f3437a;
        }
        return c3398u;
    }

    /* renamed from: a */
    public static synchronized C3398u m2219a() {
        C3398u c3398u;
        synchronized (C3398u.class) {
            c3398u = f3437a;
        }
        return c3398u;
    }

    /* renamed from: a */
    public final void m2229a(int i, C3373am c3373am, String str, String str2, InterfaceC3397t interfaceC3397t, long j, boolean z) {
        try {
        } catch (Throwable th) {
            th = th;
        }
        try {
            m2222a(new RunnableC3399v(this.f3439c, i, c3373am.f3295g, C3360a.m2071a((Object) c3373am), str, str2, interfaceC3397t, true, z), true, true, j);
        } catch (Throwable th2) {
            th = th2;
            if (C3401x.m2247a(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    /* renamed from: a */
    public final void m2230a(int i, C3373am c3373am, String str, String str2, InterfaceC3397t interfaceC3397t, boolean z) {
        try {
        } catch (Throwable th) {
            th = th;
        }
        try {
            m2222a(new RunnableC3399v(this.f3439c, i, c3373am.f3295g, C3360a.m2071a((Object) c3373am), str, str2, interfaceC3397t, 0, 0, false, null), z, false, 0L);
        } catch (Throwable th2) {
            th = th2;
            if (C3401x.m2247a(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    /* renamed from: a */
    public final long m2227a(boolean z) {
        long j;
        long m2298b = C3403z.m2298b();
        int i = z ? 5 : 3;
        List<C3395r> m2204a = this.f3438b.m2204a(i);
        if (m2204a != null && m2204a.size() > 0) {
            j = 0;
            try {
                C3395r c3395r = m2204a.get(0);
                if (c3395r.f3431e >= m2298b) {
                    j = C3403z.m2299b(c3395r.f3433g);
                    if (i == 3) {
                        this.f3441e = j;
                    } else {
                        this.f3442f = j;
                    }
                    m2204a.remove(c3395r);
                }
            } catch (Throwable th) {
                C3401x.m2247a(th);
            }
            if (m2204a.size() > 0) {
                this.f3438b.m2206a(m2204a);
            }
        } else {
            j = z ? this.f3442f : this.f3441e;
        }
        C3401x.m2251c("[UploadManager] Local network consume: %d KB", Long.valueOf(j / 1024));
        return j;
    }

    /* renamed from: a */
    protected final synchronized void m2231a(long j, boolean z) {
        int i = z ? 5 : 3;
        C3395r c3395r = new C3395r();
        c3395r.f3428b = i;
        c3395r.f3431e = C3403z.m2298b();
        c3395r.f3429c = "";
        c3395r.f3430d = "";
        c3395r.f3433g = C3403z.m2309c(j);
        this.f3438b.m2209b(i);
        this.f3438b.m2208a(c3395r);
        if (z) {
            this.f3442f = j;
        } else {
            this.f3441e = j;
        }
        C3401x.m2251c("[UploadManager] Network total consume: %d KB", Long.valueOf(j / 1024));
    }

    /* renamed from: a */
    public final synchronized void m2228a(int i, long j) {
        if (i < 0) {
            C3401x.m2253e("[UploadManager] Unknown uploading ID: %d", Integer.valueOf(i));
            return;
        }
        this.f3440d.put(Integer.valueOf(i), Long.valueOf(j));
        C3395r c3395r = new C3395r();
        c3395r.f3428b = i;
        c3395r.f3431e = j;
        c3395r.f3429c = "";
        c3395r.f3430d = "";
        c3395r.f3433g = new byte[0];
        this.f3438b.m2209b(i);
        this.f3438b.m2208a(c3395r);
        C3401x.m2251c("[UploadManager] Uploading(ID:%d) time: %s", Integer.valueOf(i), C3403z.m2278a(j));
    }

    /* renamed from: a */
    public final synchronized long m2226a(int i) {
        long j = 0;
        if (i >= 0) {
            Long l = this.f3440d.get(Integer.valueOf(i));
            if (l != null) {
                return l.longValue();
            }
            List<C3395r> m2204a = this.f3438b.m2204a(i);
            if (m2204a != null && m2204a.size() > 0) {
                if (m2204a.size() > 1) {
                    for (C3395r c3395r : m2204a) {
                        if (c3395r.f3431e > j) {
                            j = c3395r.f3431e;
                        }
                    }
                    this.f3438b.m2209b(i);
                } else {
                    try {
                        j = m2204a.get(0).f3431e;
                    } catch (Throwable th) {
                        C3401x.m2247a(th);
                    }
                }
            }
        } else {
            C3401x.m2253e("[UploadManager] Unknown upload ID: %d", Integer.valueOf(i));
        }
        return j;
    }

    /* renamed from: b */
    public final boolean m2232b(int i) {
        if (C3329b.f2869c) {
            C3401x.m2251c("Uploading frequency will not be checked if SDK is in debug mode.", new Object[0]);
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis() - m2226a(i);
        C3401x.m2251c("[UploadManager] Time interval is %d seconds since last uploading(ID: %d).", Long.valueOf(currentTimeMillis / 1000), Integer.valueOf(i));
        if (currentTimeMillis >= 30000) {
            return true;
        }
        C3401x.m2246a("[UploadManager] Data only be uploaded once in %d seconds.", 30L);
        return false;
    }

    /* renamed from: c */
    private void m2225c(int i) {
        C3400w m2238a = C3400w.m2238a();
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        final LinkedBlockingQueue linkedBlockingQueue2 = new LinkedBlockingQueue();
        synchronized (this.f3445i) {
            C3401x.m2251c("[UploadManager] Try to poll all upload task need and put them into temp queue (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
            int size = this.f3443g.size();
            final int size2 = this.f3444h.size();
            if (size == 0 && size2 == 0) {
                C3401x.m2251c("[UploadManager] There is no upload task in queue.", new Object[0]);
                return;
            }
            if (m2238a == null || !m2238a.m2243c()) {
                size2 = 0;
            }
            for (int i2 = 0; i2 < size; i2++) {
                Runnable peek = this.f3443g.peek();
                if (peek == null) {
                    break;
                }
                try {
                    linkedBlockingQueue.put(peek);
                    this.f3443g.poll();
                } catch (Throwable th) {
                    C3401x.m2253e("[UploadManager] Failed to add upload task to temp urgent queue: %s", th.getMessage());
                }
            }
            for (int i3 = 0; i3 < size2; i3++) {
                Runnable peek2 = this.f3444h.peek();
                if (peek2 == null) {
                    break;
                }
                try {
                    linkedBlockingQueue2.put(peek2);
                    this.f3444h.poll();
                } catch (Throwable th2) {
                    C3401x.m2253e("[UploadManager] Failed to add upload task to temp urgent queue: %s", th2.getMessage());
                }
            }
            if (size > 0) {
                C3401x.m2251c("[UploadManager] Execute urgent upload tasks of queue which has %d tasks (pid=%d | tid=%d)", Integer.valueOf(size), Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
            }
            for (int i4 = 0; i4 < size; i4++) {
                final Runnable runnable = (Runnable) linkedBlockingQueue.poll();
                if (runnable == null) {
                    break;
                }
                synchronized (this.f3445i) {
                    if (this.f3446j >= 2 && m2238a != null) {
                        m2238a.m2240a(runnable);
                    } else {
                        C3401x.m2246a("[UploadManager] Create and start a new thread to execute a upload task: %s", "BUGLY_ASYNC_UPLOAD");
                        if (C3403z.m2285a(new Runnable() { // from class: com.tencent.bugly.proguard.u.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                runnable.run();
                                synchronized (C3398u.this.f3445i) {
                                    C3398u.m2224b(C3398u.this);
                                }
                            }
                        }, "BUGLY_ASYNC_UPLOAD") != null) {
                            synchronized (this.f3445i) {
                                this.f3446j++;
                            }
                        } else {
                            C3401x.m2252d("[UploadManager] Failed to start a thread to execute asynchronous upload task, will try again next time.", new Object[0]);
                            m2223a(runnable, true);
                        }
                    }
                }
            }
            if (size2 > 0) {
                C3401x.m2251c("[UploadManager] Execute upload tasks of queue which has %d tasks (pid=%d | tid=%d)", Integer.valueOf(size2), Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
            }
            if (m2238a != null) {
                m2238a.m2240a(new Runnable(this) { // from class: com.tencent.bugly.proguard.u.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        Runnable runnable2;
                        for (int i5 = 0; i5 < size2 && (runnable2 = (Runnable) linkedBlockingQueue2.poll()) != null; i5++) {
                            runnable2.run();
                        }
                    }
                });
            }
        }
    }

    /* renamed from: a */
    private boolean m2223a(Runnable runnable, boolean z) {
        if (runnable == null) {
            C3401x.m2246a("[UploadManager] Upload task should not be null", new Object[0]);
            return false;
        }
        try {
            C3401x.m2251c("[UploadManager] Add upload task to queue (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
            synchronized (this.f3445i) {
                if (z) {
                    this.f3443g.put(runnable);
                } else {
                    this.f3444h.put(runnable);
                }
            }
            return true;
        } catch (Throwable th) {
            C3401x.m2253e("[UploadManager] Failed to add upload task to queue: %s", th.getMessage());
            return false;
        }
    }

    /* renamed from: a */
    private void m2222a(Runnable runnable, boolean z, boolean z2, long j) {
        if (runnable == null) {
            C3401x.m2252d("[UploadManager] Upload task should not be null", new Object[0]);
        }
        C3401x.m2251c("[UploadManager] Add upload task (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
        if (!z2) {
            m2223a(runnable, z);
            m2225c(0);
            return;
        }
        if (runnable == null) {
            C3401x.m2252d("[UploadManager] Upload task should not be null", new Object[0]);
            return;
        }
        C3401x.m2251c("[UploadManager] Execute synchronized upload task (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
        Thread m2285a = C3403z.m2285a(runnable, "BUGLY_SYNC_UPLOAD");
        if (m2285a == null) {
            C3401x.m2253e("[UploadManager] Failed to start a thread to execute synchronized upload task, add it to queue.", new Object[0]);
            m2223a(runnable, true);
            return;
        }
        try {
            m2285a.join(j);
        } catch (Throwable th) {
            C3401x.m2253e("[UploadManager] Failed to join upload synchronized task with message: %s. Add it to queue.", th.getMessage());
            m2223a(runnable, true);
            m2225c(0);
        }
    }
}