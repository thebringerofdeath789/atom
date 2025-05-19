package io.reactivex.rxjava3.internal.jdk8;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

/* loaded from: classes4.dex */
public final class ObservableFlatMapStream<T, R> extends Observable<R> {
    final Function<? super T, ? extends Stream<? extends R>> mapper;
    final Observable<T> source;

    public ObservableFlatMapStream(Observable<T> source, Function<? super T, ? extends Stream<? extends R>> mapper) {
        this.source = source;
        this.mapper = mapper;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    protected void subscribeActual(Observer<? super R> observer) {
        Observable<T> observable = this.source;
        if (observable instanceof Supplier) {
            try {
                Object obj = ((Supplier) observable).get();
                Stream stream = obj != null ? (Stream) Objects.requireNonNull(this.mapper.apply(obj), "The mapper returned a null Stream") : null;
                if (stream != null) {
                    ObservableFromStream.subscribeStream(observer, stream);
                    return;
                } else {
                    EmptyDisposable.complete(observer);
                    return;
                }
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                EmptyDisposable.error(th, observer);
                return;
            }
        }
        observable.subscribe(new FlatMapStreamObserver(observer, this.mapper));
    }

    static final class FlatMapStreamObserver<T, R> extends AtomicInteger implements Observer<T>, Disposable {
        private static final long serialVersionUID = -5127032662980523968L;
        volatile boolean disposed;
        boolean done;
        final Observer<? super R> downstream;
        final Function<? super T, ? extends Stream<? extends R>> mapper;
        Disposable upstream;

        FlatMapStreamObserver(Observer<? super R> downstream, Function<? super T, ? extends Stream<? extends R>> mapper) {
            this.downstream = downstream;
            this.mapper = mapper;
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onSubscribe(Disposable d) {
            if (DisposableHelper.validate(this.upstream, d)) {
                this.upstream = d;
                this.downstream.onSubscribe(this);
            }
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            try {
                Stream stream = (Stream) Objects.requireNonNull(this.mapper.apply(t), "The mapper returned a null Stream");
                try {
                    Iterator<T> it = stream.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        if (this.disposed) {
                            this.done = true;
                            break;
                        }
                        Object requireNonNull = Objects.requireNonNull(it.next(), "The Stream's Iterator.next returned a null value");
                        if (this.disposed) {
                            this.done = true;
                            break;
                        }
                        this.downstream.onNext(requireNonNull);
                        if (this.disposed) {
                            this.done = true;
                            break;
                        }
                    }
                    if (stream != null) {
                        stream.close();
                    }
                } finally {
                }
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                this.upstream.dispose();
                onError(th);
            }
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onError(Throwable e) {
            if (this.done) {
                RxJavaPlugins.onError(e);
            } else {
                this.done = true;
                this.downstream.onError(e);
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

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            this.disposed = true;
            this.upstream.dispose();
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return this.disposed;
        }
    }
}
