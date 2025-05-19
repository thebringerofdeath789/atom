package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.fuseable.QueueDisposable;
import io.reactivex.rxjava3.internal.fuseable.SimplePlainQueue;
import io.reactivex.rxjava3.internal.fuseable.SimpleQueue;
import io.reactivex.rxjava3.internal.queue.SpscArrayQueue;
import io.reactivex.rxjava3.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.ArrayDeque;
import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes4.dex */
public final class ObservableFlatMap<T, U> extends AbstractObservableWithUpstream<T, U> {
    final int bufferSize;
    final boolean delayErrors;
    final Function<? super T, ? extends ObservableSource<? extends U>> mapper;
    final int maxConcurrency;

    public ObservableFlatMap(ObservableSource<T> source, Function<? super T, ? extends ObservableSource<? extends U>> mapper, boolean delayErrors, int maxConcurrency, int bufferSize) {
        super(source);
        this.mapper = mapper;
        this.delayErrors = delayErrors;
        this.maxConcurrency = maxConcurrency;
        this.bufferSize = bufferSize;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super U> t) {
        if (ObservableScalarXMap.tryScalarXMapSubscribe(this.source, t, this.mapper)) {
            return;
        }
        this.source.subscribe(new MergeObserver(t, this.mapper, this.delayErrors, this.maxConcurrency, this.bufferSize));
    }

    static final class MergeObserver<T, U> extends AtomicInteger implements Disposable, Observer<T> {
        private static final long serialVersionUID = -2117620485640801370L;
        final int bufferSize;
        final boolean delayErrors;
        volatile boolean disposed;
        volatile boolean done;
        final Observer<? super U> downstream;
        final AtomicThrowable errors = new AtomicThrowable();
        int lastIndex;
        final Function<? super T, ? extends ObservableSource<? extends U>> mapper;
        final int maxConcurrency;
        final AtomicReference<InnerObserver<?, ?>[]> observers;
        volatile SimplePlainQueue<U> queue;
        Queue<ObservableSource<? extends U>> sources;
        long uniqueId;
        Disposable upstream;
        int wip;
        static final InnerObserver<?, ?>[] EMPTY = new InnerObserver[0];
        static final InnerObserver<?, ?>[] CANCELLED = new InnerObserver[0];

        MergeObserver(Observer<? super U> actual, Function<? super T, ? extends ObservableSource<? extends U>> mapper, boolean delayErrors, int maxConcurrency, int bufferSize) {
            this.downstream = actual;
            this.mapper = mapper;
            this.delayErrors = delayErrors;
            this.maxConcurrency = maxConcurrency;
            this.bufferSize = bufferSize;
            if (maxConcurrency != Integer.MAX_VALUE) {
                this.sources = new ArrayDeque(maxConcurrency);
            }
            this.observers = new AtomicReference<>(EMPTY);
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
                ObservableSource<? extends U> observableSource = (ObservableSource) Objects.requireNonNull(this.mapper.apply(t), "The mapper returned a null ObservableSource");
                if (this.maxConcurrency != Integer.MAX_VALUE) {
                    synchronized (this) {
                        int i = this.wip;
                        if (i == this.maxConcurrency) {
                            this.sources.offer(observableSource);
                            return;
                        }
                        this.wip = i + 1;
                    }
                }
                subscribeInner(observableSource);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                this.upstream.dispose();
                onError(th);
            }
        }

        void subscribeInner(ObservableSource<? extends U> p) {
            ObservableSource<? extends U> poll;
            while (p instanceof Supplier) {
                if (!tryEmitScalar((Supplier) p) || this.maxConcurrency == Integer.MAX_VALUE) {
                    return;
                }
                boolean z = false;
                synchronized (this) {
                    poll = this.sources.poll();
                    if (poll == null) {
                        this.wip--;
                        z = true;
                    }
                }
                if (z) {
                    drain();
                    return;
                }
                p = poll;
            }
            long j = this.uniqueId;
            this.uniqueId = 1 + j;
            InnerObserver<T, U> innerObserver = new InnerObserver<>(this, j);
            if (addInner(innerObserver)) {
                p.subscribe(innerObserver);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        boolean addInner(InnerObserver<T, U> inner) {
            InnerObserver<?, ?>[] innerObserverArr;
            InnerObserver[] innerObserverArr2;
            do {
                innerObserverArr = this.observers.get();
                if (innerObserverArr == CANCELLED) {
                    inner.dispose();
                    return false;
                }
                int length = innerObserverArr.length;
                innerObserverArr2 = new InnerObserver[length + 1];
                System.arraycopy(innerObserverArr, 0, innerObserverArr2, 0, length);
                innerObserverArr2[length] = inner;
            } while (!this.observers.compareAndSet(innerObserverArr, innerObserverArr2));
            return true;
        }

        /* JADX WARN: Multi-variable type inference failed */
        void removeInner(InnerObserver<T, U> inner) {
            InnerObserver<?, ?>[] innerObserverArr;
            InnerObserver<?, ?>[] innerObserverArr2;
            do {
                innerObserverArr = this.observers.get();
                int length = innerObserverArr.length;
                int i = -1;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    }
                    if (innerObserverArr[i2] == inner) {
                        i = i2;
                        break;
                    }
                    i2++;
                }
                if (i < 0) {
                    return;
                }
                if (length == 1) {
                    innerObserverArr2 = EMPTY;
                } else {
                    InnerObserver<?, ?>[] innerObserverArr3 = new InnerObserver[length - 1];
                    System.arraycopy(innerObserverArr, 0, innerObserverArr3, 0, i);
                    System.arraycopy(innerObserverArr, i + 1, innerObserverArr3, i, (length - i) - 1);
                    innerObserverArr2 = innerObserverArr3;
                }
            } while (!this.observers.compareAndSet(innerObserverArr, innerObserverArr2));
        }

        boolean tryEmitScalar(Supplier<? extends U> value) {
            try {
                U u = value.get();
                if (u == null) {
                    return true;
                }
                if (get() == 0 && compareAndSet(0, 1)) {
                    this.downstream.onNext(u);
                    if (decrementAndGet() == 0) {
                        return true;
                    }
                } else {
                    SimplePlainQueue<U> simplePlainQueue = this.queue;
                    if (simplePlainQueue == null) {
                        if (this.maxConcurrency == Integer.MAX_VALUE) {
                            simplePlainQueue = new SpscLinkedArrayQueue<>(this.bufferSize);
                        } else {
                            simplePlainQueue = new SpscArrayQueue<>(this.maxConcurrency);
                        }
                        this.queue = simplePlainQueue;
                    }
                    simplePlainQueue.offer(u);
                    if (getAndIncrement() != 0) {
                        return false;
                    }
                }
                drainLoop();
                return true;
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                this.errors.tryAddThrowableOrReport(th);
                drain();
                return true;
            }
        }

        void tryEmit(U value, InnerObserver<T, U> inner) {
            if (get() == 0 && compareAndSet(0, 1)) {
                this.downstream.onNext(value);
                if (decrementAndGet() == 0) {
                    return;
                }
            } else {
                SimpleQueue simpleQueue = inner.queue;
                if (simpleQueue == null) {
                    simpleQueue = new SpscLinkedArrayQueue(this.bufferSize);
                    inner.queue = simpleQueue;
                }
                simpleQueue.offer(value);
                if (getAndIncrement() != 0) {
                    return;
                }
            }
            drainLoop();
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onError(Throwable t) {
            if (this.done) {
                RxJavaPlugins.onError(t);
            } else if (this.errors.tryAddThrowableOrReport(t)) {
                this.done = true;
                drain();
            }
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            drain();
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            this.disposed = true;
            if (disposeAll()) {
                this.errors.tryTerminateAndReport();
            }
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return this.disposed;
        }

        void drain() {
            if (getAndIncrement() == 0) {
                drainLoop();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        void drainLoop() {
            int i;
            int i2;
            Observer<? super U> observer = this.downstream;
            int i3 = 1;
            while (!checkTerminate()) {
                SimplePlainQueue<U> simplePlainQueue = this.queue;
                int i4 = 0;
                if (simplePlainQueue != null) {
                    while (!checkTerminate()) {
                        U poll = simplePlainQueue.poll();
                        if (poll != null) {
                            observer.onNext(poll);
                            i4++;
                        }
                    }
                    return;
                }
                if (i4 != 0) {
                    if (this.maxConcurrency != Integer.MAX_VALUE) {
                        subscribeMore(i4);
                    }
                } else {
                    boolean z = this.done;
                    SimplePlainQueue<U> simplePlainQueue2 = this.queue;
                    InnerObserver<?, ?>[] innerObserverArr = this.observers.get();
                    int length = innerObserverArr.length;
                    if (this.maxConcurrency != Integer.MAX_VALUE) {
                        synchronized (this) {
                            i = this.sources.size();
                        }
                    } else {
                        i = 0;
                    }
                    if (z && ((simplePlainQueue2 == null || simplePlainQueue2.isEmpty()) && length == 0 && i == 0)) {
                        this.errors.tryTerminateConsumer(this.downstream);
                        return;
                    }
                    if (length != 0) {
                        int min = Math.min(length - 1, this.lastIndex);
                        for (0; i2 < length; i2 + 1) {
                            if (checkTerminate()) {
                                return;
                            }
                            InnerObserver<T, U> innerObserver = innerObserverArr[min];
                            SimpleQueue<U> simpleQueue = innerObserver.queue;
                            if (simpleQueue != null) {
                                do {
                                    try {
                                        U poll2 = simpleQueue.poll();
                                        if (poll2 != null) {
                                            observer.onNext(poll2);
                                        }
                                    } catch (Throwable th) {
                                        Exceptions.throwIfFatal(th);
                                        innerObserver.dispose();
                                        this.errors.tryAddThrowableOrReport(th);
                                        if (checkTerminate()) {
                                            return;
                                        }
                                        removeInner(innerObserver);
                                        i4++;
                                        min++;
                                        if (min != length) {
                                        }
                                    }
                                } while (!checkTerminate());
                                return;
                            }
                            boolean z2 = innerObserver.done;
                            SimpleQueue<U> simpleQueue2 = innerObserver.queue;
                            if (z2 && (simpleQueue2 == null || simpleQueue2.isEmpty())) {
                                removeInner(innerObserver);
                                i4++;
                            }
                            min++;
                            i2 = min != length ? i2 + 1 : 0;
                            min = 0;
                        }
                        this.lastIndex = min;
                    }
                    if (i4 != 0) {
                        if (this.maxConcurrency != Integer.MAX_VALUE) {
                            subscribeMore(i4);
                        }
                    } else {
                        i3 = addAndGet(-i3);
                        if (i3 == 0) {
                            return;
                        }
                    }
                }
            }
        }

        void subscribeMore(int innerCompleted) {
            while (true) {
                int i = innerCompleted - 1;
                if (innerCompleted == 0) {
                    return;
                }
                synchronized (this) {
                    ObservableSource<? extends U> poll = this.sources.poll();
                    if (poll == null) {
                        this.wip--;
                    } else {
                        subscribeInner(poll);
                    }
                }
                innerCompleted = i;
            }
        }

        boolean checkTerminate() {
            if (this.disposed) {
                return true;
            }
            Throwable th = this.errors.get();
            if (this.delayErrors || th == null) {
                return false;
            }
            disposeAll();
            this.errors.tryTerminateConsumer(this.downstream);
            return true;
        }

        boolean disposeAll() {
            this.upstream.dispose();
            AtomicReference<InnerObserver<?, ?>[]> atomicReference = this.observers;
            InnerObserver<?, ?>[] innerObserverArr = CANCELLED;
            InnerObserver<?, ?>[] andSet = atomicReference.getAndSet(innerObserverArr);
            if (andSet == innerObserverArr) {
                return false;
            }
            for (InnerObserver<?, ?> innerObserver : andSet) {
                innerObserver.dispose();
            }
            return true;
        }
    }

    static final class InnerObserver<T, U> extends AtomicReference<Disposable> implements Observer<U> {
        private static final long serialVersionUID = -4606175640614850599L;
        volatile boolean done;
        int fusionMode;
        final long id;
        final MergeObserver<T, U> parent;
        volatile SimpleQueue<U> queue;

        InnerObserver(MergeObserver<T, U> parent, long id) {
            this.id = id;
            this.parent = parent;
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onSubscribe(Disposable d) {
            if (DisposableHelper.setOnce(this, d) && (d instanceof QueueDisposable)) {
                QueueDisposable queueDisposable = (QueueDisposable) d;
                int requestFusion = queueDisposable.requestFusion(7);
                if (requestFusion == 1) {
                    this.fusionMode = requestFusion;
                    this.queue = queueDisposable;
                    this.done = true;
                    this.parent.drain();
                    return;
                }
                if (requestFusion == 2) {
                    this.fusionMode = requestFusion;
                    this.queue = queueDisposable;
                }
            }
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onNext(U t) {
            if (this.fusionMode == 0) {
                this.parent.tryEmit(t, this);
            } else {
                this.parent.drain();
            }
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onError(Throwable t) {
            if (this.parent.errors.tryAddThrowableOrReport(t)) {
                if (!this.parent.delayErrors) {
                    this.parent.disposeAll();
                }
                this.done = true;
                this.parent.drain();
            }
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onComplete() {
            this.done = true;
            this.parent.drain();
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }
    }
}
