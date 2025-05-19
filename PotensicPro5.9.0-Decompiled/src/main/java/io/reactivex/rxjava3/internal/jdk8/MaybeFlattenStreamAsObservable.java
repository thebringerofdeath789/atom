package io.reactivex.rxjava3.internal.jdk8;

import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.observers.BasicIntQueueDisposable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Iterator;
import java.util.Objects;
import java.util.stream.Stream;

/* loaded from: classes4.dex */
public final class MaybeFlattenStreamAsObservable<T, R> extends Observable<R> {
    final Function<? super T, ? extends Stream<? extends R>> mapper;
    final Maybe<T> source;

    public MaybeFlattenStreamAsObservable(Maybe<T> source, Function<? super T, ? extends Stream<? extends R>> mapper) {
        this.source = source;
        this.mapper = mapper;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    protected void subscribeActual(Observer<? super R> s) {
        this.source.subscribe(new FlattenStreamMultiObserver(s, this.mapper));
    }

    static final class FlattenStreamMultiObserver<T, R> extends BasicIntQueueDisposable<R> implements MaybeObserver<T>, SingleObserver<T> {
        private static final long serialVersionUID = 7363336003027148283L;
        AutoCloseable close;
        volatile boolean disposed;
        final Observer<? super R> downstream;
        volatile Iterator<? extends R> iterator;
        final Function<? super T, ? extends Stream<? extends R>> mapper;
        boolean once;
        boolean outputFused;
        Disposable upstream;

        FlattenStreamMultiObserver(Observer<? super R> downstream, Function<? super T, ? extends Stream<? extends R>> mapper) {
            this.downstream = downstream;
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
            try {
                Stream stream = (Stream) Objects.requireNonNull(this.mapper.apply(t), "The mapper returned a null Stream");
                Iterator<? extends R> it = stream.iterator();
                if (!it.hasNext()) {
                    this.downstream.onComplete();
                    close(stream);
                } else {
                    this.iterator = it;
                    this.close = stream;
                    drain();
                }
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                this.downstream.onError(th);
            }
        }

        @Override // io.reactivex.rxjava3.core.MaybeObserver, io.reactivex.rxjava3.core.SingleObserver, io.reactivex.rxjava3.core.CompletableObserver
        public void onError(Throwable e) {
            this.downstream.onError(e);
        }

        @Override // io.reactivex.rxjava3.core.MaybeObserver, io.reactivex.rxjava3.core.CompletableObserver
        public void onComplete() {
            this.downstream.onComplete();
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            this.disposed = true;
            this.upstream.dispose();
            if (this.outputFused) {
                return;
            }
            drain();
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return this.disposed;
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
        public R poll() throws Throwable {
            Iterator<? extends R> it = this.iterator;
            if (it == null) {
                return null;
            }
            if (this.once) {
                if (!it.hasNext()) {
                    clear();
                    return null;
                }
            } else {
                this.once = true;
            }
            return it.next();
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.SimpleQueue
        public boolean isEmpty() {
            Iterator<? extends R> it = this.iterator;
            if (it == null) {
                return true;
            }
            if (!this.once || it.hasNext()) {
                return false;
            }
            clear();
            return true;
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.SimpleQueue
        public void clear() {
            this.iterator = null;
            AutoCloseable autoCloseable = this.close;
            this.close = null;
            close(autoCloseable);
        }

        void close(AutoCloseable c) {
            if (c != null) {
                try {
                    c.close();
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    RxJavaPlugins.onError(th);
                }
            }
        }

        void drain() {
            if (getAndIncrement() != 0) {
                return;
            }
            Observer<? super R> observer = this.downstream;
            Iterator<? extends R> it = this.iterator;
            int i = 1;
            while (true) {
                if (this.disposed) {
                    clear();
                } else if (this.outputFused) {
                    observer.onNext(null);
                    observer.onComplete();
                } else {
                    try {
                        R next = it.next();
                        if (!this.disposed) {
                            observer.onNext(next);
                            if (!this.disposed) {
                                try {
                                    boolean hasNext = it.hasNext();
                                    if (!this.disposed && !hasNext) {
                                        observer.onComplete();
                                        this.disposed = true;
                                    }
                                } catch (Throwable th) {
                                    Exceptions.throwIfFatal(th);
                                    observer.onError(th);
                                    this.disposed = true;
                                }
                            }
                        }
                    } catch (Throwable th2) {
                        Exceptions.throwIfFatal(th2);
                        observer.onError(th2);
                        this.disposed = true;
                    }
                }
                i = addAndGet(-i);
                if (i == 0) {
                    return;
                }
            }
        }
    }
}
