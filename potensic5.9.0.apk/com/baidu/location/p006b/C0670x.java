package com.baidu.location.p006b;

import java.util.concurrent.ExecutorService;

/* renamed from: com.baidu.location.b.x */
/* loaded from: classes.dex */
public class C0670x {

    /* renamed from: a */
    private ExecutorService f715a;

    /* renamed from: b */
    private ExecutorService f716b;

    /* renamed from: com.baidu.location.b.x$a */
    private static class a {

        /* renamed from: a */
        private static C0670x f717a = new C0670x();
    }

    private C0670x() {
        this.f715a = null;
        this.f716b = null;
    }

    /* renamed from: a */
    public static C0670x m590a() {
        return a.f717a;
    }

    /* renamed from: b */
    public synchronized ExecutorService m591b() {
        return this.f715a;
    }

    /* renamed from: c */
    public synchronized ExecutorService m592c() {
        return this.f716b;
    }

    /* renamed from: d */
    public void m593d() {
        ExecutorService executorService = this.f715a;
        if (executorService != null) {
            executorService.shutdown();
        }
        ExecutorService executorService2 = this.f716b;
        if (executorService2 != null) {
            executorService2.shutdown();
        }
    }
}