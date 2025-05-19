package io.netty.util.concurrent;

import io.netty.util.internal.ObjectUtil;

/* loaded from: classes4.dex */
public final class PromiseCombiner {
    private Promise<Void> aggregatePromise;
    private Throwable cause;
    private boolean doneAdding;
    private int doneCount;
    private int expectedCount;
    private final GenericFutureListener<Future<?>> listener = new GenericFutureListener<Future<?>>() { // from class: io.netty.util.concurrent.PromiseCombiner.1
        @Override // io.netty.util.concurrent.GenericFutureListener
        public void operationComplete(Future<?> future) throws Exception {
            PromiseCombiner.access$004(PromiseCombiner.this);
            if (!future.isSuccess() && PromiseCombiner.this.cause == null) {
                PromiseCombiner.this.cause = future.cause();
            }
            if (PromiseCombiner.this.doneCount == PromiseCombiner.this.expectedCount && PromiseCombiner.this.doneAdding) {
                PromiseCombiner.this.tryPromise();
            }
        }
    };

    static /* synthetic */ int access$004(PromiseCombiner promiseCombiner) {
        int i = promiseCombiner.doneCount + 1;
        promiseCombiner.doneCount = i;
        return i;
    }

    @Deprecated
    public void add(Promise promise) {
        add((Future) promise);
    }

    public void add(Future future) {
        checkAddAllowed();
        this.expectedCount++;
        future.addListener(this.listener);
    }

    @Deprecated
    public void addAll(Promise... promiseArr) {
        addAll((Future[]) promiseArr);
    }

    public void addAll(Future... futureArr) {
        for (Future future : futureArr) {
            add(future);
        }
    }

    public void finish(Promise<Void> promise) {
        if (this.doneAdding) {
            throw new IllegalStateException("Already finished");
        }
        this.doneAdding = true;
        this.aggregatePromise = (Promise) ObjectUtil.checkNotNull(promise, "aggregatePromise");
        if (this.doneCount == this.expectedCount) {
            tryPromise();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean tryPromise() {
        Throwable th = this.cause;
        return th == null ? this.aggregatePromise.trySuccess(null) : this.aggregatePromise.tryFailure(th);
    }

    private void checkAddAllowed() {
        if (this.doneAdding) {
            throw new IllegalStateException("Adding promises is not allowed after finished adding");
        }
    }
}
