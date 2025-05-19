package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Iterator;
import java.util.Objects;

/* loaded from: classes4.dex */
public final class ObservableZipIterable<T, U, V> extends Observable<V> {
    final Iterable<U> other;
    final Observable<? extends T> source;
    final BiFunction<? super T, ? super U, ? extends V> zipper;

    public ObservableZipIterable(Observable<? extends T> source, Iterable<U> other, BiFunction<? super T, ? super U, ? extends V> zipper) {
        this.source = source;
        this.other = other;
        this.zipper = zipper;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super V> t) {
        try {
            Iterator it = (Iterator) Objects.requireNonNull(this.other.iterator(), "The iterator returned by other is null");
            try {
                if (!it.hasNext()) {
                    EmptyDisposable.complete(t);
                } else {
                    this.source.subscribe(new ZipIterableObserver(t, it, this.zipper));
                }
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                EmptyDisposable.error(th, t);
            }
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            EmptyDisposable.error(th2, t);
        }
    }

    static final class ZipIterableObserver<T, U, V> implements Observer<T>, Disposable {
        boolean done;
        final Observer<? super V> downstream;
        final Iterator<U> iterator;
        Disposable upstream;
        final BiFunction<? super T, ? super U, ? extends V> zipper;

        ZipIterableObserver(Observer<? super V> actual, Iterator<U> iterator, BiFunction<? super T, ? super U, ? extends V> zipper) {
            this.downstream = actual;
            this.iterator = iterator;
            this.zipper = zipper;
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onSubscribe(Disposable d) {
            if (DisposableHelper.validate(this.upstream, d)) {
                this.upstream = d;
                this.downstream.onSubscribe(this);
            }
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            this.upstream.dispose();
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return this.upstream.isDisposed();
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            try {
                try {
                    this.downstream.onNext(Objects.requireNonNull(this.zipper.apply(t, Objects.requireNonNull(this.iterator.next(), "The iterator returned a null value")), "The zipper function returned a null value"));
                    try {
                        if (this.iterator.hasNext()) {
                            return;
                        }
                        this.done = true;
                        this.upstream.dispose();
                        this.downstream.onComplete();
                    } catch (Throwable th) {
                        Exceptions.throwIfFatal(th);
                        error(th);
                    }
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    error(th2);
                }
            } catch (Throwable th3) {
                Exceptions.throwIfFatal(th3);
                error(th3);
            }
        }

        void error(Throwable e) {
            this.done = true;
            this.upstream.dispose();
            this.downstream.onError(e);
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onError(Throwable t) {
            if (this.done) {
                RxJavaPlugins.onError(t);
            } else {
                this.done = true;
                this.downstream.onError(t);
            }
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            this.downstream.onComplete();
        }
    }
}
