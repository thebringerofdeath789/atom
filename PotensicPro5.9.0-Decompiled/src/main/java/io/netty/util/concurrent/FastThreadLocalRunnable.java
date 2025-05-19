package io.netty.util.concurrent;

import io.netty.util.internal.ObjectUtil;

/* loaded from: classes4.dex */
final class FastThreadLocalRunnable implements Runnable {
    private final Runnable runnable;

    private FastThreadLocalRunnable(Runnable runnable) {
        this.runnable = (Runnable) ObjectUtil.checkNotNull(runnable, "runnable");
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.runnable.run();
        } finally {
            FastThreadLocal.removeAll();
        }
    }

    static Runnable wrap(Runnable runnable) {
        return runnable instanceof FastThreadLocalRunnable ? runnable : new FastThreadLocalRunnable(runnable);
    }
}
