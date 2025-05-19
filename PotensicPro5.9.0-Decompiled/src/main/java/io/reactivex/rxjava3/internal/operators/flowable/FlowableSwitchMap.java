package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.fuseable.QueueSubscription;
import io.reactivex.rxjava3.internal.fuseable.SimpleQueue;
import io.reactivex.rxjava3.internal.queue.SpscArrayQueue;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes4.dex */
public final class FlowableSwitchMap<T, R> extends AbstractFlowableWithUpstream<T, R> {
    final int bufferSize;
    final boolean delayErrors;
    final Function<? super T, ? extends Publisher<? extends R>> mapper;

    public FlowableSwitchMap(Flowable<T> source, Function<? super T, ? extends Publisher<? extends R>> mapper, int bufferSize, boolean delayErrors) {
        super(source);
        this.mapper = mapper;
        this.bufferSize = bufferSize;
        this.delayErrors = delayErrors;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    protected void subscribeActual(Subscriber<? super R> s) {
        if (FlowableScalarXMap.tryScalarXMapSubscribe(this.source, s, this.mapper)) {
            return;
        }
        this.source.subscribe((FlowableSubscriber) new SwitchMapSubscriber(s, this.mapper, this.bufferSize, this.delayErrors));
    }

    static final class SwitchMapSubscriber<T, R> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        static final SwitchMapInnerSubscriber<Object, Object> CANCELLED;
        private static final long serialVersionUID = -3491074160481096299L;
        final int bufferSize;
        volatile boolean cancelled;
        final boolean delayErrors;
        volatile boolean done;
        final Subscriber<? super R> downstream;
        final Function<? super T, ? extends Publisher<? extends R>> mapper;
        volatile long unique;
        Subscription upstream;
        final AtomicReference<SwitchMapInnerSubscriber<T, R>> active = new AtomicReference<>();
        final AtomicLong requested = new AtomicLong();
        final AtomicThrowable errors = new AtomicThrowable();

        static {
            SwitchMapInnerSubscriber<Object, Object> switchMapInnerSubscriber = new SwitchMapInnerSubscriber<>(null, -1L, 1);
            CANCELLED = switchMapInnerSubscriber;
            switchMapInnerSubscriber.cancel();
        }

        SwitchMapSubscriber(Subscriber<? super R> actual, Function<? super T, ? extends Publisher<? extends R>> mapper, int bufferSize, boolean delayErrors) {
            this.downstream = actual;
            this.mapper = mapper;
            this.bufferSize = bufferSize;
            this.delayErrors = delayErrors;
        }

        @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription s) {
            if (SubscriptionHelper.validate(this.upstream, s)) {
                this.upstream = s;
                this.downstream.onSubscribe(this);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            SwitchMapInnerSubscriber<T, R> switchMapInnerSubscriber;
            if (this.done) {
                return;
            }
            long j = this.unique + 1;
            this.unique = j;
            SwitchMapInnerSubscriber<T, R> switchMapInnerSubscriber2 = this.active.get();
            if (switchMapInnerSubscriber2 != null) {
                switchMapInnerSubscriber2.cancel();
            }
            try {
                Publisher publisher = (Publisher) Objects.requireNonNull(this.mapper.apply(t), "The publisher returned is null");
                SwitchMapInnerSubscriber<T, R> switchMapInnerSubscriber3 = new SwitchMapInnerSubscriber<>(this, j, this.bufferSize);
                do {
                    switchMapInnerSubscriber = this.active.get();
                    if (switchMapInnerSubscriber == CANCELLED) {
                        return;
                    }
                } while (!this.active.compareAndSet(switchMapInnerSubscriber, switchMapInnerSubscriber3));
                publisher.subscribe(switchMapInnerSubscriber3);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                this.upstream.cancel();
                onError(th);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable t) {
            if (!this.done && this.errors.tryAddThrowable(t)) {
                if (!this.delayErrors) {
                    disposeInner();
                }
                this.done = true;
                drain();
                return;
            }
            RxJavaPlugins.onError(t);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            drain();
        }

        @Override // org.reactivestreams.Subscription
        public void request(long n) {
            if (SubscriptionHelper.validate(n)) {
                BackpressureHelper.add(this.requested, n);
                if (this.unique == 0) {
                    this.upstream.request(Long.MAX_VALUE);
                } else {
                    drain();
                }
            }
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.upstream.cancel();
            disposeInner();
            this.errors.tryTerminateAndReport();
        }

        void disposeInner() {
            AtomicReference<SwitchMapInnerSubscriber<T, R>> atomicReference = this.active;
            SwitchMapInnerSubscriber<Object, Object> switchMapInnerSubscriber = CANCELLED;
            SwitchMapInnerSubscriber<Object, Object> switchMapInnerSubscriber2 = (SwitchMapInnerSubscriber) atomicReference.getAndSet(switchMapInnerSubscriber);
            if (switchMapInnerSubscriber2 == switchMapInnerSubscriber || switchMapInnerSubscriber2 == null) {
                return;
            }
            switchMapInnerSubscriber2.cancel();
        }

        void drain() {
            boolean z;
            Object obj;
            if (getAndIncrement() != 0) {
                return;
            }
            Subscriber<? super R> subscriber = this.downstream;
            int i = 1;
            while (!this.cancelled) {
                if (this.done) {
                    if (this.delayErrors) {
                        if (this.active.get() == null) {
                            this.errors.tryTerminateConsumer(subscriber);
                            return;
                        }
                    } else if (this.errors.get() != null) {
                        disposeInner();
                        this.errors.tryTerminateConsumer(subscriber);
                        return;
                    } else if (this.active.get() == null) {
                        subscriber.onComplete();
                        return;
                    }
                }
                SwitchMapInnerSubscriber<T, R> switchMapInnerSubscriber = this.active.get();
                SimpleQueue<R> simpleQueue = switchMapInnerSubscriber != null ? switchMapInnerSubscriber.queue : null;
                if (simpleQueue != null) {
                    long j = this.requested.get();
                    long j2 = 0;
                    while (j2 != j) {
                        if (!this.cancelled) {
                            boolean z2 = switchMapInnerSubscriber.done;
                            try {
                                obj = simpleQueue.poll();
                            } catch (Throwable th) {
                                Exceptions.throwIfFatal(th);
                                switchMapInnerSubscriber.cancel();
                                this.errors.tryAddThrowableOrReport(th);
                                obj = null;
                                z2 = true;
                            }
                            boolean z3 = obj == null;
                            if (switchMapInnerSubscriber == this.active.get()) {
                                if (z2) {
                                    if (this.delayErrors) {
                                        if (z3) {
                                            this.active.compareAndSet(switchMapInnerSubscriber, null);
                                        }
                                    } else if (this.errors.get() != null) {
                                        this.errors.tryTerminateConsumer(subscriber);
                                        return;
                                    } else if (z3) {
                                        this.active.compareAndSet(switchMapInnerSubscriber, null);
                                    }
                                }
                                if (z3) {
                                    break;
                                }
                                subscriber.onNext(obj);
                                j2++;
                            }
                            z = true;
                            break;
                        }
                        return;
                    }
                    z = false;
                    if (j2 == j && switchMapInnerSubscriber.done) {
                        if (!this.delayErrors) {
                            if (this.errors.get() != null) {
                                disposeInner();
                                this.errors.tryTerminateConsumer(subscriber);
                                return;
                            } else if (simpleQueue.isEmpty()) {
                                this.active.compareAndSet(switchMapInnerSubscriber, null);
                            }
                        } else if (simpleQueue.isEmpty()) {
                            this.active.compareAndSet(switchMapInnerSubscriber, null);
                        }
                    }
                    if (j2 != 0 && !this.cancelled) {
                        if (j != Long.MAX_VALUE) {
                            this.requested.addAndGet(-j2);
                        }
                        switchMapInnerSubscriber.request(j2);
                    }
                    if (z) {
                        continue;
                    }
                }
                i = addAndGet(-i);
                if (i == 0) {
                    return;
                }
            }
        }
    }

    static final class SwitchMapInnerSubscriber<T, R> extends AtomicReference<Subscription> implements FlowableSubscriber<R> {
        private static final long serialVersionUID = 3837284832786408377L;
        final int bufferSize;
        volatile boolean done;
        int fusionMode;
        final long index;
        final SwitchMapSubscriber<T, R> parent;
        volatile SimpleQueue<R> queue;

        SwitchMapInnerSubscriber(SwitchMapSubscriber<T, R> parent, long index, int bufferSize) {
            this.parent = parent;
            this.index = index;
            this.bufferSize = bufferSize;
        }

        @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription s) {
            if (SubscriptionHelper.setOnce(this, s)) {
                if (s instanceof QueueSubscription) {
                    QueueSubscription queueSubscription = (QueueSubscription) s;
                    int requestFusion = queueSubscription.requestFusion(7);
                    if (requestFusion == 1) {
                        this.fusionMode = requestFusion;
                        this.queue = queueSubscription;
                        this.done = true;
                        this.parent.drain();
                        return;
                    }
                    if (requestFusion == 2) {
                        this.fusionMode = requestFusion;
                        this.queue = queueSubscription;
                        s.request(this.bufferSize);
                        return;
                    }
                }
                this.queue = new SpscArrayQueue(this.bufferSize);
                s.request(this.bufferSize);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(R t) {
            SwitchMapSubscriber<T, R> switchMapSubscriber = this.parent;
            if (this.index == switchMapSubscriber.unique) {
                if (this.fusionMode == 0 && !this.queue.offer(t)) {
                    onError(new MissingBackpressureException("Queue full?!"));
                } else {
                    switchMapSubscriber.drain();
                }
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable t) {
            SwitchMapSubscriber<T, R> switchMapSubscriber = this.parent;
            if (this.index == switchMapSubscriber.unique && switchMapSubscriber.errors.tryAddThrowable(t)) {
                if (!switchMapSubscriber.delayErrors) {
                    switchMapSubscriber.upstream.cancel();
                    switchMapSubscriber.done = true;
                }
                this.done = true;
                switchMapSubscriber.drain();
                return;
            }
            RxJavaPlugins.onError(t);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            SwitchMapSubscriber<T, R> switchMapSubscriber = this.parent;
            if (this.index == switchMapSubscriber.unique) {
                this.done = true;
                switchMapSubscriber.drain();
            }
        }

        public void cancel() {
            SubscriptionHelper.cancel(this);
        }

        public void request(long n) {
            if (this.fusionMode != 1) {
                get().request(n);
            }
        }
    }
}
