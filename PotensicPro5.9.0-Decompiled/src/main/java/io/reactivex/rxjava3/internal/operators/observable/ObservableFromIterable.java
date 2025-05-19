package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.internal.observers.BasicQueueDisposable;
import java.util.Iterator;
import java.util.Objects;

/* loaded from: classes4.dex */
public final class ObservableFromIterable<T> extends Observable<T> {
    final Iterable<? extends T> source;

    public ObservableFromIterable(Iterable<? extends T> source) {
        this.source = source;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super T> observer) {
        try {
            Iterator<? extends T> it = this.source.iterator();
            try {
                if (!it.hasNext()) {
                    EmptyDisposable.complete(observer);
                    return;
                }
                FromIterableDisposable fromIterableDisposable = new FromIterableDisposable(observer, it);
                observer.onSubscribe(fromIterableDisposable);
                if (fromIterableDisposable.fusionMode) {
                    return;
                }
                fromIterableDisposable.run();
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                EmptyDisposable.error(th, observer);
            }
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            EmptyDisposable.error(th2, observer);
        }
    }

    static final class FromIterableDisposable<T> extends BasicQueueDisposable<T> {
        boolean checkNext;
        volatile boolean disposed;
        boolean done;
        final Observer<? super T> downstream;
        boolean fusionMode;
        final Iterator<? extends T> it;

        FromIterableDisposable(Observer<? super T> actual, Iterator<? extends T> it) {
            this.downstream = actual;
            this.it = it;
        }

        void run() {
            while (!isDisposed()) {
                try {
                    this.downstream.onNext(Objects.requireNonNull(this.it.next(), "The iterator returned a null value"));
                    if (isDisposed()) {
                        return;
                    }
                    try {
                        if (!this.it.hasNext()) {
                            if (isDisposed()) {
                                return;
                            }
                            this.downstream.onComplete();
                            return;
                        }
                    } catch (Throwable th) {
                        Exceptions.throwIfFatal(th);
                        this.downstream.onError(th);
                        return;
                    }
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    this.downstream.onError(th2);
                    return;
                }
            }
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.QueueFuseable
        public int requestFusion(int mode) {
            if ((mode & 1) == 0) {
                return 0;
            }
            this.fusionMode = true;
            return 1;
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.SimpleQueue
        public T poll() {
            if (this.done) {
                return null;
            }
            if (this.checkNext) {
                if (!this.it.hasNext()) {
                    this.done = true;
                    return null;
                }
            } else {
                this.checkNext = true;
            }
            return (T) Objects.requireNonNull(this.it.next(), "The iterator returned a null value");
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.SimpleQueue
        public boolean isEmpty() {
            return this.done;
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.SimpleQueue
        public void clear() {
            this.done = true;
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            this.disposed = true;
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return this.disposed;
        }
    }
}
