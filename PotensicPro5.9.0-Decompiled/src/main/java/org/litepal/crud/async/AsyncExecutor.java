package org.litepal.crud.async;

/* loaded from: classes5.dex */
public abstract class AsyncExecutor {
    private Runnable pendingTask;

    public void submit(Runnable runnable) {
        this.pendingTask = runnable;
    }

    void execute() {
        if (this.pendingTask != null) {
            new Thread(this.pendingTask).start();
        }
    }
}
