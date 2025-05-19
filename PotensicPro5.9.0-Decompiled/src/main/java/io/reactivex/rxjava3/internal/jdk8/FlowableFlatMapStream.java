package io.reactivex.rxjava3.internal.jdk8;

import defpackage.C$r8$backportedMethods$utility$String$2$joinArray;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.fuseable.QueueSubscription;
import io.reactivex.rxjava3.internal.fuseable.SimpleQueue;
import io.reactivex.rxjava3.internal.queue.SpscArrayQueue;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Stream;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes4.dex */
public final class FlowableFlatMapStream<T, R> extends Flowable<R> {
    final Function<? super T, ? extends Stream<? extends R>> mapper;
    final int prefetch;
    final Flowable<T> source;

    public FlowableFlatMapStream(Flowable<T> source, Function<? super T, ? extends Stream<? extends R>> mapper, int prefetch) {
        this.source = source;
        this.mapper = mapper;
        this.prefetch = prefetch;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    protected void subscribeActual(Subscriber<? super R> subscriber) {
        Flowable<T> flowable = this.source;
        if (flowable instanceof Supplier) {
            try {
                Object obj = ((Supplier) flowable).get();
                Stream stream = obj != null ? (Stream) Objects.requireNonNull(this.mapper.apply(obj), "The mapper returned a null Stream") : null;
                if (stream != null) {
                    FlowableFromStream.subscribeStream(subscriber, stream);
                    return;
                } else {
                    EmptySubscription.complete(subscriber);
                    return;
                }
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                EmptySubscription.error(th, subscriber);
                return;
            }
        }
        flowable.subscribe(subscribe(subscriber, this.mapper, this.prefetch));
    }

    public static <T, R> Subscriber<T> subscribe(Subscriber<? super R> downstream, Function<? super T, ? extends Stream<? extends R>> mapper, int prefetch) {
        return new FlatMapStreamSubscriber(downstream, mapper, prefetch);
    }

    static final class FlatMapStreamSubscriber<T, R> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = -5127032662980523968L;
        volatile boolean cancelled;
        int consumed;
        AutoCloseable currentCloseable;
        Iterator<? extends R> currentIterator;
        final Subscriber<? super R> downstream;
        long emitted;
        final Function<? super T, ? extends Stream<? extends R>> mapper;
        final int prefetch;
        SimpleQueue<T> queue;
        int sourceMode;
        Subscription upstream;
        volatile boolean upstreamDone;
        final AtomicLong requested = new AtomicLong();
        final AtomicThrowable error = new AtomicThrowable();

        FlatMapStreamSubscriber(Subscriber<? super R> downstream, Function<? super T, ? extends Stream<? extends R>> mapper, int prefetch) {
            this.downstream = downstream;
            this.mapper = mapper;
            this.prefetch = prefetch;
        }

        @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription s) {
            if (SubscriptionHelper.validate(this.upstream, s)) {
                this.upstream = s;
                if (s instanceof QueueSubscription) {
                    QueueSubscription queueSubscription = (QueueSubscription) s;
                    int requestFusion = queueSubscription.requestFusion(7);
                    if (requestFusion == 1) {
                        this.sourceMode = requestFusion;
                        this.queue = queueSubscription;
                        this.upstreamDone = true;
                        this.downstream.onSubscribe(this);
                        return;
                    }
                    if (requestFusion == 2) {
                        this.sourceMode = requestFusion;
                        this.queue = queueSubscription;
                        this.downstream.onSubscribe(this);
                        s.request(this.prefetch);
                        return;
                    }
                }
                this.queue = new SpscArrayQueue(this.prefetch);
                this.downstream.onSubscribe(this);
                s.request(this.prefetch);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (this.sourceMode != 2 && !this.queue.offer(t)) {
                this.upstream.cancel();
                onError(new MissingBackpressureException("Queue full?!"));
            } else {
                drain();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable t) {
            if (this.error.compareAndSet(null, t)) {
                this.upstreamDone = true;
                drain();
            } else {
                RxJavaPlugins.onError(t);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.upstreamDone = true;
            drain();
        }

        @Override // org.reactivestreams.Subscription
        public void request(long n) {
            if (SubscriptionHelper.validate(n)) {
                BackpressureHelper.add(this.requested, n);
                drain();
            }
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.cancelled = true;
            this.upstream.cancel();
            drain();
        }

        /* JADX WARN: Type inference failed for: r12v0 */
        /* JADX WARN: Type inference failed for: r12v1, types: [boolean, int] */
        /* JADX WARN: Type inference failed for: r12v2 */
        void drain() {
            if (getAndIncrement() != 0) {
                return;
            }
            Subscriber<? super R> subscriber = this.downstream;
            SimpleQueue<T> simpleQueue = this.queue;
            AtomicThrowable atomicThrowable = this.error;
            Iterator<? extends R> it = this.currentIterator;
            long j = this.requested.get();
            long j2 = this.emitted;
            int i = this.prefetch;
            int i2 = i - (i >> 2);
            int i3 = 0;
            ?? r12 = 1;
            boolean z = this.sourceMode != 1;
            long j3 = j2;
            int i4 = 1;
            long j4 = j;
            Iterator<? extends R> it2 = it;
            while (true) {
                if (this.cancelled) {
                    simpleQueue.clear();
                    clearCurrentSuppressCloseError();
                } else {
                    boolean z2 = this.upstreamDone;
                    if (atomicThrowable.get() != null) {
                        subscriber.onError(atomicThrowable.get());
                        this.cancelled = r12;
                    } else {
                        if (it2 == null) {
                            try {
                                T poll = simpleQueue.poll();
                                int i5 = poll == null ? r12 : i3;
                                if (z2 && i5 != 0) {
                                    subscriber.onComplete();
                                    this.cancelled = r12;
                                } else if (i5 == 0) {
                                    if (z) {
                                        int i6 = this.consumed + r12;
                                        this.consumed = i6;
                                        if (i6 == i2) {
                                            this.consumed = i3;
                                            this.upstream.request(i2);
                                        }
                                    }
                                    try {
                                        Stream stream = (Stream) Objects.requireNonNull(this.mapper.apply(poll), "The mapper returned a null Stream");
                                        it2 = stream.iterator();
                                        if (it2.hasNext()) {
                                            this.currentIterator = it2;
                                            this.currentCloseable = stream;
                                        }
                                        it2 = null;
                                    } catch (Throwable th) {
                                        Exceptions.throwIfFatal(th);
                                        trySignalError(subscriber, th);
                                    }
                                }
                            } catch (Throwable th2) {
                                Exceptions.throwIfFatal(th2);
                                trySignalError(subscriber, th2);
                            }
                        }
                        if (it2 != null && j3 != j4) {
                            try {
                                C$r8$backportedMethods$utility$String$2$joinArray c$r8$backportedMethods$utility$String$2$joinArray = (Object) Objects.requireNonNull(it2.next(), "The Stream.Iterator returned a null value");
                                if (!this.cancelled) {
                                    subscriber.onNext(c$r8$backportedMethods$utility$String$2$joinArray);
                                    j3++;
                                    if (!this.cancelled) {
                                        try {
                                            if (!it2.hasNext()) {
                                                try {
                                                    clearCurrentRethrowCloseError();
                                                    it2 = null;
                                                } catch (Throwable th3) {
                                                    th = th3;
                                                    it2 = null;
                                                    Exceptions.throwIfFatal(th);
                                                    trySignalError(subscriber, th);
                                                    i3 = 0;
                                                    r12 = 1;
                                                }
                                            }
                                        } catch (Throwable th4) {
                                            th = th4;
                                        }
                                    }
                                }
                            } catch (Throwable th5) {
                                Exceptions.throwIfFatal(th5);
                                trySignalError(subscriber, th5);
                            }
                        }
                    }
                    i3 = 0;
                    r12 = 1;
                }
                this.emitted = j3;
                i4 = addAndGet(-i4);
                if (i4 == 0) {
                    return;
                }
                j4 = this.requested.get();
                i3 = 0;
                r12 = 1;
            }
        }

        void clearCurrentRethrowCloseError() throws Throwable {
            this.currentIterator = null;
            AutoCloseable autoCloseable = this.currentCloseable;
            this.currentCloseable = null;
            if (autoCloseable != null) {
                autoCloseable.close();
            }
        }

        void clearCurrentSuppressCloseError() {
            try {
                clearCurrentRethrowCloseError();
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                RxJavaPlugins.onError(th);
            }
        }

        void trySignalError(Subscriber<?> downstream, Throwable ex) {
            if (this.error.compareAndSet(null, ex)) {
                this.upstream.cancel();
                this.cancelled = true;
                downstream.onError(ex);
                return;
            }
            RxJavaPlugins.onError(ex);
        }
    }
}
