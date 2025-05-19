package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.observers.BasicQueueDisposable;
import java.util.Iterator;
import java.util.Objects;

/* loaded from: classes4.dex */
public final class MaybeFlatMapIterableObservable<T, R> extends Observable<R> {
    final Function<? super T, ? extends Iterable<? extends R>> mapper;
    final MaybeSource<T> source;

    public MaybeFlatMapIterableObservable(MaybeSource<T> source, Function<? super T, ? extends Iterable<? extends R>> mapper) {
        this.source = source;
        this.mapper = mapper;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    protected void subscribeActual(Observer<? super R> observer) {
        this.source.subscribe(new FlatMapIterableObserver(observer, this.mapper));
    }

    static final class FlatMapIterableObserver<T, R> extends BasicQueueDisposable<R> implements MaybeObserver<T> {
        volatile boolean cancelled;
        final Observer<? super R> downstream;
        volatile Iterator<? extends R> it;
        final Function<? super T, ? extends Iterable<? extends R>> mapper;
        boolean outputFused;
        Disposable upstream;

        FlatMapIterableObserver(Observer<? super R> actual, Function<? super T, ? extends Iterable<? extends R>> mapper) {
            this.downstream = actual;
            this.mapper = mapper;
        }

        @Override // io.reactivex.rxjava3.core.MaybeObserver, io.reactivex.rxjava3.core.SingleObserver, io.reactivex.rxjava3.core.CompletableObserver
        public void onSubscribe(Disposable d) {
            if (DisposableHelper.validate(this.upstream, d)) {
                this.upstream = d;
                this.downstream.onSubscribe(this);
            }
        }

        @Override // io.reactivex.rxjava3.core.MaybeObserver, io.reactivex.rxjava3.core.SingleObserver
        public void onSuccess(T t) {
            Observer<? super R> observer = this.downstream;
            try {
                Iterator<? extends R> it = this.mapper.apply(t).iterator();
                if (!it.hasNext()) {
                    observer.onComplete();
                    return;
                }
                this.it = it;
                if (this.outputFused) {
                    observer.onNext(null);
                    observer.onComplete();
                    return;
                }
                while (!this.cancelled) {
                    try {
                        observer.onNext(it.next());
                        if (this.cancelled) {
                            return;
                        }
                        try {
                            if (!it.hasNext()) {
                                observer.onComplete();
                                return;
                            }
                        } catch (Throwable th) {
                            Exceptions.throwIfFatal(th);
                            observer.onError(th);
                            return;
                        }
                    } catch (Throwable th2) {
                        Exceptions.throwIfFatal(th2);
                        observer.onError(th2);
                        return;
                    }
                }
            } catch (Throwable th3) {
                Exceptions.throwIfFatal(th3);
                observer.onError(th3);
            }
        }

        @Override // io.reactivex.rxjava3.core.MaybeObserver, io.reactivex.rxjava3.core.SingleObserver, io.reactivex.rxjava3.core.CompletableObserver
        public void onError(Throwable e) {
            this.upstream = DisposableHelper.DISPOSED;
            this.downstream.onError(e);
        }

        @Override // io.reactivex.rxjava3.core.MaybeObserver, io.reactivex.rxjava3.core.CompletableObserver
        public void onComplete() {
            this.downstream.onComplete();
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            this.cancelled = true;
            this.upstream.dispose();
            this.upstream = DisposableHelper.DISPOSED;
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.QueueFuseable
        public int requestFusion(int mode) {
            if ((mode & 2) == 0) {
                return 0;
            }
            this.outputFused = true;
            return 2;
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.SimpleQueue
        public void clear() {
            this.it = null;
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.SimpleQueue
        public boolean isEmpty() {
            return this.it == null;
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.SimpleQueue
        public R poll() {
            Iterator<? extends R> it = this.it;
            if (it == null) {
                return null;
            }
            R r = (R) Objects.requireNonNull(it.next(), "The iterator returned a null value");
            if (!it.hasNext()) {
                this.it = null;
            }
            return r;
        }
    }
}
