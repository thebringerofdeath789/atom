package com.baidu.location.b;

import java.util.concurrent.ExecutorService;

/* loaded from: classes.dex */
public class x {
    private ExecutorService a;
    private ExecutorService b;

    private static class a {
        private static x a = new x();
    }

    private x() {
        this.a = null;
        this.b = null;
    }

    public static x a() {
        return a.a;
    }

    public synchronized ExecutorService b() {
        return this.a;
    }

    public synchronized ExecutorService c() {
        return this.b;
    }

    public void d() {
        ExecutorService executorService = this.a;
        if (executorService != null) {
            executorService.shutdown();
        }
        ExecutorService executorService2 = this.b;
        if (executorService2 != null) {
            executorService2.shutdown();
        }
    }
}
