package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes4.dex */
public final class FlowableBufferBoundary<T, U extends Collection<? super T>, Open, Close> extends AbstractFlowableWithUpstream<T, U> {
    final Function<? super Open, ? extends Publisher<? extends Close>> bufferClose;
    final Publisher<? extends Open> bufferOpen;
    final Supplier<U> bufferSupplier;

    public FlowableBufferBoundary(Flowable<T> source, Publisher<? extends Open> bufferOpen, Function<? super Open, ? extends Publisher<? extends Close>> bufferClose, Supplier<U> bufferSupplier) {
        super(source);
        this.bufferOpen = bufferOpen;
        this.bufferClose = bufferClose;
        this.bufferSupplier = bufferSupplier;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    protected void subscribeActual(Subscriber<? super U> s) {
        BufferBoundarySubscriber bufferBoundarySubscriber = new BufferBoundarySubscriber(s, this.bufferOpen, this.bufferClose, this.bufferSupplier);
        s.onSubscribe(bufferBoundarySubscriber);
        this.source.subscribe((FlowableSubscriber) bufferBoundarySubscriber);
    }

    static final class BufferBoundarySubscriber<T, C extends Collection<? super T>, Open, Close> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = -8466418554264089604L;
        final Function<? super Open, ? extends Publisher<? extends Close>> bufferClose;
        final Publisher<? extends Open> bufferOpen;
        final Supplier<C> bufferSupplier;
        volatile boolean cancelled;
        volatile boolean done;
        final Subscriber<? super C> downstream;
        long emitted;
        long index;
        final SpscLinkedArrayQueue<C> queue = new SpscLinkedArrayQueue<>(Flowable.bufferSize());
        final CompositeDisposable subscribers = new CompositeDisposable();
        final AtomicLong requested = new AtomicLong();
        final AtomicReference<Subscription> upstream = new AtomicReference<>();
        Map<Long, C> buffers = new LinkedHashMap();
        final AtomicThrowable errors = new AtomicThrowable();

        BufferBoundarySubscriber(Subscriber<? super C> actual, Publisher<? extends Open> bufferOpen, Function<? super Open, ? extends Publisher<? extends Close>> bufferClose, Supplier<C> bufferSupplier) {
            this.downstream = actual;
            this.bufferSupplier = bufferSupplier;
            this.bufferOpen = bufferOpen;
            this.bufferClose = bufferClose;
        }

        @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription s) {
            if (SubscriptionHelper.setOnce(this.upstream, s)) {
                BufferOpenSubscriber bufferOpenSubscriber = new BufferOpenSubscriber(this);
                this.subscribers.add(bufferOpenSubscriber);
                this.bufferOpen.subscribe(bufferOpenSubscriber);
                s.request(Long.MAX_VALUE);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            synchronized (this) {
                Map<Long, C> map = this.buffers;
                if (map == null) {
                    return;
                }
                Iterator<C> it = map.values().iterator();
                while (it.hasNext()) {
                    it.next().add(t);
                }
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable t) {
            if (this.errors.tryAddThrowableOrReport(t)) {
                this.subscribers.dispose();
                synchronized (this) {
                    this.buffers = null;
                }
                this.done = true;
                drain();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.subscribers.dispose();
            synchronized (this) {
                Map<Long, C> map = this.buffers;
                if (map == null) {
                    return;
                }
                Iterator<C> it = map.values().iterator();
                while (it.hasNext()) {
                    this.queue.offer(it.next());
                }
                this.buffers = null;
                this.done = true;
                drain();
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long n) {
            BackpressureHelper.add(this.requested, n);
            drain();
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (SubscriptionHelper.cancel(this.upstream)) {
                this.cancelled = true;
                this.subscribers.dispose();
                synchronized (this) {
                    this.buffers = null;
                }
                if (getAndIncrement() != 0) {
                    this.queue.clear();
                }
            }
        }

        void open(Open open) {
            try {
                Collection collection = (Collection) Objects.requireNonNull(this.bufferSupplier.get(), "The bufferSupplier returned a null Collection");
                Publisher publisher = (Publisher) Objects.requireNonNull(this.bufferClose.apply(open), "The bufferClose returned a null Publisher");
                long j = this.index;
                this.index = 1 + j;
                synchronized (this) {
                    Map<Long, C> map = this.buffers;
                    if (map == null) {
                        return;
                    }
                    map.put(Long.valueOf(j), collection);
                    BufferCloseSubscriber bufferCloseSubscriber = new BufferCloseSubscriber(this, j);
                    this.subscribers.add(bufferCloseSubscriber);
                    publisher.subscribe(bufferCloseSubscriber);
                }
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                SubscriptionHelper.cancel(this.upstream);
                onError(th);
            }
        }

        void openComplete(BufferOpenSubscriber<Open> os) {
            this.subscribers.delete(os);
            if (this.subscribers.size() == 0) {
                SubscriptionHelper.cancel(this.upstream);
                this.done = true;
                drain();
            }
        }

        void close(BufferCloseSubscriber<T, C> closer, long idx) {
            boolean z;
            this.subscribers.delete(closer);
            if (this.subscribers.size() == 0) {
                SubscriptionHelper.cancel(this.upstream);
                z = true;
            } else {
                z = false;
            }
            synchronized (this) {
                Map<Long, C> map = this.buffers;
                if (map == null) {
                    return;
                }
                this.queue.offer(map.remove(Long.valueOf(idx)));
                if (z) {
                    this.done = true;
                }
                drain();
            }
        }

        void boundaryError(Disposable subscriber, Throwable ex) {
            SubscriptionHelper.cancel(this.upstream);
            this.subscribers.delete(subscriber);
            onError(ex);
        }

        void drain() {
            if (getAndIncrement() != 0) {
                return;
            }
            long j = this.emitted;
            Subscriber<? super C> subscriber = this.downstream;
            SpscLinkedArrayQueue<C> spscLinkedArrayQueue = this.queue;
            int i = 1;
            do {
                long j2 = this.requested.get();
                while (j != j2) {
                    if (this.cancelled) {
                        spscLinkedArrayQueue.clear();
                        return;
                    }
                    boolean z = this.done;
                    if (z && this.errors.get() != null) {
                        spscLinkedArrayQueue.clear();
                        this.errors.tryTerminateConsumer(subscriber);
                        return;
                    }
                    C poll = spscLinkedArrayQueue.poll();
                    boolean z2 = poll == null;
                    if (z && z2) {
                        subscriber.onComplete();
                        return;
                    } else {
                        if (z2) {
                            break;
                        }
                        subscriber.onNext(poll);
                        j++;
                    }
                }
                if (j == j2) {
                    if (this.cancelled) {
                        spscLinkedArrayQueue.clear();
                        return;
                    }
                    if (this.done) {
                        if (this.errors.get() != null) {
                            spscLinkedArrayQueue.clear();
                            this.errors.tryTerminateConsumer(subscriber);
                            return;
                        } else if (spscLinkedArrayQueue.isEmpty()) {
                            subscriber.onComplete();
                            return;
                        }
                    }
                }
                this.emitted = j;
                i = addAndGet(-i);
            } while (i != 0);
        }

        static final class BufferOpenSubscriber<Open> extends AtomicReference<Subscription> implements FlowableSubscriber<Open>, Disposable {
            private static final long serialVersionUID = -8498650778633225126L;
            final BufferBoundarySubscriber<?, ?, Open, ?> parent;

            BufferOpenSubscriber(BufferBoundarySubscriber<?, ?, Open, ?> parent) {
                this.parent = parent;
            }

            @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
            public void onSubscribe(Subscription s) {
                SubscriptionHelper.setOnce(this, s, Long.MAX_VALUE);
            }

            @Override // org.reactivestreams.Subscriber
            public void onNext(Open t) {
                this.parent.open(t);
            }

            @Override // org.reactivestreams.Subscriber
            public void onError(Throwable t) {
                lazySet(SubscriptionHelper.CANCELLED);
                this.parent.boundaryError(this, t);
            }

            @Override // org.reactivestreams.Subscriber
            public void onComplete() {
                lazySet(SubscriptionHelper.CANCELLED);
                this.parent.openComplete(this);
            }

            @Override // io.reactivex.rxjava3.disposables.Disposable
            public void dispose() {
                SubscriptionHelper.cancel(this);
            }

            @Override // io.reactivex.rxjava3.disposables.Disposable
            public boolean isDisposed() {
                return get() == SubscriptionHelper.CANCELLED;
            }
        }
    }

    static final class BufferCloseSubscriber<T, C extends Collection<? super T>> extends AtomicReference<Subscription> implements FlowableSubscriber<Object>, Disposable {
        private static final long serialVersionUID = -8498650778633225126L;
        final long index;
        final BufferBoundarySubscriber<T, C, ?, ?> parent;

        BufferCloseSubscriber(BufferBoundarySubscriber<T, C, ?, ?> parent, long index) {
            this.parent = parent;
            this.index = index;
        }

        @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription s) {
            SubscriptionHelper.setOnce(this, s, Long.MAX_VALUE);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(Object t) {
            Subscription subscription = get();
            if (subscription != SubscriptionHelper.CANCELLED) {
                lazySet(SubscriptionHelper.CANCELLED);
                subscription.cancel();
                this.parent.close(this, this.index);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable t) {
            if (get() != SubscriptionHelper.CANCELLED) {
                lazySet(SubscriptionHelper.CANCELLED);
                this.parent.boundaryError(this, t);
            } else {
                RxJavaPlugins.onError(t);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (get() != SubscriptionHelper.CANCELLED) {
                lazySet(SubscriptionHelper.CANCELLED);
                this.parent.close(this, this.index);
            }
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            SubscriptionHelper.cancel(this);
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return get() == SubscriptionHelper.CANCELLED;
        }
    }
}
