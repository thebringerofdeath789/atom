package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.fuseable.SimpleQueue;
import io.reactivex.rxjava3.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.rxjava3.internal.subscribers.InnerQueuedSubscriber;
import io.reactivex.rxjava3.internal.subscribers.InnerQueuedSubscriberSupport;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.internal.util.ErrorMode;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes4.dex */
public final class FlowableConcatMapEager<T, R> extends AbstractFlowableWithUpstream<T, R> {
    final ErrorMode errorMode;
    final Function<? super T, ? extends Publisher<? extends R>> mapper;
    final int maxConcurrency;
    final int prefetch;

    public FlowableConcatMapEager(Flowable<T> source, Function<? super T, ? extends Publisher<? extends R>> mapper, int maxConcurrency, int prefetch, ErrorMode errorMode) {
        super(source);
        this.mapper = mapper;
        this.maxConcurrency = maxConcurrency;
        this.prefetch = prefetch;
        this.errorMode = errorMode;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    protected void subscribeActual(Subscriber<? super R> s) {
        this.source.subscribe((FlowableSubscriber) new ConcatMapEagerDelayErrorSubscriber(s, this.mapper, this.maxConcurrency, this.prefetch, this.errorMode));
    }

    static final class ConcatMapEagerDelayErrorSubscriber<T, R> extends AtomicInteger implements FlowableSubscriber<T>, Subscription, InnerQueuedSubscriberSupport<R> {
        private static final long serialVersionUID = -4255299542215038287L;
        volatile boolean cancelled;
        volatile InnerQueuedSubscriber<R> current;
        volatile boolean done;
        final Subscriber<? super R> downstream;
        final ErrorMode errorMode;
        final Function<? super T, ? extends Publisher<? extends R>> mapper;
        final int maxConcurrency;
        final int prefetch;
        final SpscLinkedArrayQueue<InnerQueuedSubscriber<R>> subscribers;
        Subscription upstream;
        final AtomicThrowable errors = new AtomicThrowable();
        final AtomicLong requested = new AtomicLong();

        ConcatMapEagerDelayErrorSubscriber(Subscriber<? super R> actual, Function<? super T, ? extends Publisher<? extends R>> mapper, int maxConcurrency, int prefetch, ErrorMode errorMode) {
            this.downstream = actual;
            this.mapper = mapper;
            this.maxConcurrency = maxConcurrency;
            this.prefetch = prefetch;
            this.errorMode = errorMode;
            this.subscribers = new SpscLinkedArrayQueue<>(Math.min(prefetch, maxConcurrency));
        }

        @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription s) {
            if (SubscriptionHelper.validate(this.upstream, s)) {
                this.upstream = s;
                this.downstream.onSubscribe(this);
                int i = this.maxConcurrency;
                s.request(i == Integer.MAX_VALUE ? Long.MAX_VALUE : i);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            try {
                Publisher publisher = (Publisher) Objects.requireNonNull(this.mapper.apply(t), "The mapper returned a null Publisher");
                InnerQueuedSubscriber<R> innerQueuedSubscriber = new InnerQueuedSubscriber<>(this, this.prefetch);
                if (this.cancelled) {
                    return;
                }
                this.subscribers.offer(innerQueuedSubscriber);
                publisher.subscribe(innerQueuedSubscriber);
                if (this.cancelled) {
                    innerQueuedSubscriber.cancel();
                    drainAndCancel();
                }
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                this.upstream.cancel();
                onError(th);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable t) {
            if (this.errors.tryAddThrowableOrReport(t)) {
                this.done = true;
                drain();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.done = true;
            drain();
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.upstream.cancel();
            this.errors.tryTerminateAndReport();
            drainAndCancel();
        }

        void drainAndCancel() {
            if (getAndIncrement() == 0) {
                do {
                    cancelAll();
                } while (decrementAndGet() != 0);
            }
        }

        void cancelAll() {
            InnerQueuedSubscriber<R> innerQueuedSubscriber = this.current;
            this.current = null;
            if (innerQueuedSubscriber != null) {
                innerQueuedSubscriber.cancel();
            }
            while (true) {
                InnerQueuedSubscriber<R> poll = this.subscribers.poll();
                if (poll == null) {
                    return;
                } else {
                    poll.cancel();
                }
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long n) {
            if (SubscriptionHelper.validate(n)) {
                BackpressureHelper.add(this.requested, n);
                drain();
            }
        }

        @Override // io.reactivex.rxjava3.internal.subscribers.InnerQueuedSubscriberSupport
        public void innerNext(InnerQueuedSubscriber<R> inner, R value) {
            if (inner.queue().offer(value)) {
                drain();
            } else {
                inner.cancel();
                innerError(inner, new MissingBackpressureException());
            }
        }

        @Override // io.reactivex.rxjava3.internal.subscribers.InnerQueuedSubscriberSupport
        public void innerError(InnerQueuedSubscriber<R> inner, Throwable e) {
            if (this.errors.tryAddThrowableOrReport(e)) {
                inner.setDone();
                if (this.errorMode != ErrorMode.END) {
                    this.upstream.cancel();
                }
                drain();
            }
        }

        @Override // io.reactivex.rxjava3.internal.subscribers.InnerQueuedSubscriberSupport
        public void innerComplete(InnerQueuedSubscriber<R> inner) {
            inner.setDone();
            drain();
        }

        @Override // io.reactivex.rxjava3.internal.subscribers.InnerQueuedSubscriberSupport
        public void drain() {
            InnerQueuedSubscriber<R> innerQueuedSubscriber;
            int i;
            boolean z;
            long j;
            long j2;
            SimpleQueue<R> queue;
            if (getAndIncrement() != 0) {
                return;
            }
            InnerQueuedSubscriber<R> innerQueuedSubscriber2 = this.current;
            Subscriber<? super R> subscriber = this.downstream;
            ErrorMode errorMode = this.errorMode;
            int i2 = 1;
            while (true) {
                long j3 = this.requested.get();
                if (innerQueuedSubscriber2 != null) {
                    innerQueuedSubscriber = innerQueuedSubscriber2;
                } else {
                    if (errorMode != ErrorMode.END && this.errors.get() != null) {
                        cancelAll();
                        this.errors.tryTerminateConsumer(this.downstream);
                        return;
                    }
                    boolean z2 = this.done;
                    innerQueuedSubscriber = this.subscribers.poll();
                    if (z2 && innerQueuedSubscriber == null) {
                        this.errors.tryTerminateConsumer(this.downstream);
                        return;
                    } else if (innerQueuedSubscriber != null) {
                        this.current = innerQueuedSubscriber;
                    }
                }
                if (innerQueuedSubscriber == null || (queue = innerQueuedSubscriber.queue()) == null) {
                    i = i2;
                    z = false;
                    j = 0;
                    j2 = 0;
                } else {
                    j2 = 0;
                    while (true) {
                        i = i2;
                        if (j2 == j3) {
                            break;
                        }
                        if (this.cancelled) {
                            cancelAll();
                            return;
                        }
                        if (errorMode == ErrorMode.IMMEDIATE && this.errors.get() != null) {
                            this.current = null;
                            innerQueuedSubscriber.cancel();
                            cancelAll();
                            this.errors.tryTerminateConsumer(this.downstream);
                            return;
                        }
                        boolean isDone = innerQueuedSubscriber.isDone();
                        try {
                            R poll = queue.poll();
                            boolean z3 = poll == null;
                            if (isDone && z3) {
                                this.current = null;
                                this.upstream.request(1L);
                                innerQueuedSubscriber = null;
                                z = true;
                                break;
                            }
                            if (z3) {
                                break;
                            }
                            subscriber.onNext(poll);
                            j2++;
                            innerQueuedSubscriber.request(1L);
                            i2 = i;
                        } catch (Throwable th) {
                            Exceptions.throwIfFatal(th);
                            this.current = null;
                            innerQueuedSubscriber.cancel();
                            cancelAll();
                            subscriber.onError(th);
                            return;
                        }
                    }
                    z = false;
                    if (j2 == j3) {
                        if (this.cancelled) {
                            cancelAll();
                            return;
                        }
                        if (errorMode == ErrorMode.IMMEDIATE && this.errors.get() != null) {
                            this.current = null;
                            innerQueuedSubscriber.cancel();
                            cancelAll();
                            this.errors.tryTerminateConsumer(this.downstream);
                            return;
                        }
                        boolean isDone2 = innerQueuedSubscriber.isDone();
                        boolean isEmpty = queue.isEmpty();
                        if (isDone2 && isEmpty) {
                            this.current = null;
                            this.upstream.request(1L);
                            innerQueuedSubscriber = null;
                            z = true;
                        }
                    }
                    j = 0;
                }
                if (j2 != j && j3 != Long.MAX_VALUE) {
                    this.requested.addAndGet(-j2);
                }
                if (z) {
                    innerQueuedSubscriber2 = innerQueuedSubscriber;
                    i2 = i;
                } else {
                    i2 = addAndGet(-i);
                    if (i2 == 0) {
                        return;
                    } else {
                        innerQueuedSubscriber2 = innerQueuedSubscriber;
                    }
                }
            }
        }
    }
}
