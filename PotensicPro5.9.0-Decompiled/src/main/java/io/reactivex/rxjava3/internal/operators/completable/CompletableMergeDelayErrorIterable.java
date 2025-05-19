package io.reactivex.rxjava3.internal.operators.completable;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.internal.operators.completable.CompletableMergeArrayDelayError;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes4.dex */
public final class CompletableMergeDelayErrorIterable extends Completable {
    final Iterable<? extends CompletableSource> sources;

    public CompletableMergeDelayErrorIterable(Iterable<? extends CompletableSource> sources) {
        this.sources = sources;
    }

    @Override // io.reactivex.rxjava3.core.Completable
    public void subscribeActual(final CompletableObserver observer) {
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        observer.onSubscribe(compositeDisposable);
        try {
            Iterator it = (Iterator) Objects.requireNonNull(this.sources.iterator(), "The source iterator returned is null");
            AtomicInteger atomicInteger = new AtomicInteger(1);
            AtomicThrowable atomicThrowable = new AtomicThrowable();
            compositeDisposable.add(new CompletableMergeArrayDelayError.TryTerminateAndReportDisposable(atomicThrowable));
            while (!compositeDisposable.isDisposed()) {
                try {
                    if (it.hasNext()) {
                        if (compositeDisposable.isDisposed()) {
                            return;
                        }
                        try {
                            CompletableSource completableSource = (CompletableSource) Objects.requireNonNull(it.next(), "The iterator returned a null CompletableSource");
                            if (compositeDisposable.isDisposed()) {
                                return;
                            }
                            atomicInteger.getAndIncrement();
                            completableSource.subscribe(new CompletableMergeArrayDelayError.MergeInnerCompletableObserver(observer, compositeDisposable, atomicThrowable, atomicInteger));
                        } catch (Throwable th) {
                            Exceptions.throwIfFatal(th);
                            atomicThrowable.tryAddThrowableOrReport(th);
                        }
                    }
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    atomicThrowable.tryAddThrowableOrReport(th2);
                }
                if (atomicInteger.decrementAndGet() == 0) {
                    atomicThrowable.tryTerminateConsumer(observer);
                    return;
                }
                return;
            }
        } catch (Throwable th3) {
            Exceptions.throwIfFatal(th3);
            observer.onError(th3);
        }
    }
}
