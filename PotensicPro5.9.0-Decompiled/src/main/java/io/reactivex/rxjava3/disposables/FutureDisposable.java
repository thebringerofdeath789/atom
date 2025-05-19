package io.reactivex.rxjava3.disposables;

import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes4.dex */
final class FutureDisposable extends AtomicReference<Future<?>> implements Disposable {
    private static final long serialVersionUID = 6545242830671168775L;
    private final boolean allowInterrupt;

    FutureDisposable(Future<?> run, boolean allowInterrupt) {
        super(run);
        this.allowInterrupt = allowInterrupt;
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public boolean isDisposed() {
        Future<?> future = get();
        return future == null || future.isDone();
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public void dispose() {
        Future<?> andSet = getAndSet(null);
        if (andSet != null) {
            andSet.cancel(this.allowInterrupt);
        }
    }
}
