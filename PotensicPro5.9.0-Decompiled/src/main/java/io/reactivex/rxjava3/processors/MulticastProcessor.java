package io.reactivex.rxjava3.processors;

import io.reactivex.rxjava3.annotations.BackpressureKind;
import io.reactivex.rxjava3.annotations.BackpressureSupport;
import io.reactivex.rxjava3.annotations.CheckReturnValue;
import io.reactivex.rxjava3.annotations.SchedulerSupport;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.internal.functions.ObjectHelper;
import io.reactivex.rxjava3.internal.fuseable.QueueSubscription;
import io.reactivex.rxjava3.internal.fuseable.SimpleQueue;
import io.reactivex.rxjava3.internal.queue.SpscArrayQueue;
import io.reactivex.rxjava3.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

@BackpressureSupport(BackpressureKind.FULL)
@SchedulerSupport("none")
/* loaded from: classes4.dex */
public final class MulticastProcessor<T> extends FlowableProcessor<T> {
    static final MulticastSubscription[] EMPTY = new MulticastSubscription[0];
    static final MulticastSubscription[] TERMINATED = new MulticastSubscription[0];
    final int bufferSize;
    int consumed;
    volatile boolean done;
    volatile Throwable error;
    int fusionMode;
    final int limit;
    volatile SimpleQueue<T> queue;
    final boolean refcount;
    final AtomicInteger wip = new AtomicInteger();
    final AtomicReference<MulticastSubscription<T>[]> subscribers = new AtomicReference<>(EMPTY);
    final AtomicReference<Subscription> upstream = new AtomicReference<>();

    @CheckReturnValue
    public static <T> MulticastProcessor<T> create() {
        return new MulticastProcessor<>(bufferSize(), false);
    }

    @CheckReturnValue
    public static <T> MulticastProcessor<T> create(boolean refCount) {
        return new MulticastProcessor<>(bufferSize(), refCount);
    }

    @CheckReturnValue
    public static <T> MulticastProcessor<T> create(int bufferSize) {
        ObjectHelper.verifyPositive(bufferSize, "bufferSize");
        return new MulticastProcessor<>(bufferSize, false);
    }

    @CheckReturnValue
    public static <T> MulticastProcessor<T> create(int bufferSize, boolean refCount) {
        ObjectHelper.verifyPositive(bufferSize, "bufferSize");
        return new MulticastProcessor<>(bufferSize, refCount);
    }

    MulticastProcessor(int bufferSize, boolean refCount) {
        this.bufferSize = bufferSize;
        this.limit = bufferSize - (bufferSize >> 2);
        this.refcount = refCount;
    }

    public void start() {
        if (SubscriptionHelper.setOnce(this.upstream, EmptySubscription.INSTANCE)) {
            this.queue = new SpscArrayQueue(this.bufferSize);
        }
    }

    public void startUnbounded() {
        if (SubscriptionHelper.setOnce(this.upstream, EmptySubscription.INSTANCE)) {
            this.queue = new SpscLinkedArrayQueue(this.bufferSize);
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onSubscribe(Subscription s) {
        if (SubscriptionHelper.setOnce(this.upstream, s)) {
            if (s instanceof QueueSubscription) {
                QueueSubscription queueSubscription = (QueueSubscription) s;
                int requestFusion = queueSubscription.requestFusion(3);
                if (requestFusion == 1) {
                    this.fusionMode = requestFusion;
                    this.queue = queueSubscription;
                    this.done = true;
                    drain();
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
    public void onNext(T t) {
        if (this.done) {
            return;
        }
        if (this.fusionMode == 0) {
            ExceptionHelper.nullCheck(t, "onNext called with a null value.");
            if (!this.queue.offer(t)) {
                SubscriptionHelper.cancel(this.upstream);
                onError(new MissingBackpressureException());
                return;
            }
        }
        drain();
    }

    @CheckReturnValue
    public boolean offer(T t) {
        ExceptionHelper.nullCheck(t, "offer called with a null value.");
        if (this.done) {
            return false;
        }
        if (this.fusionMode == 0) {
            if (!this.queue.offer(t)) {
                return false;
            }
            drain();
            return true;
        }
        throw new IllegalStateException("offer() should not be called in fusion mode!");
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable t) {
        ExceptionHelper.nullCheck(t, "onError called with a null Throwable.");
        if (!this.done) {
            this.error = t;
            this.done = true;
            drain();
            return;
        }
        RxJavaPlugins.onError(t);
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        this.done = true;
        drain();
    }

    @Override // io.reactivex.rxjava3.processors.FlowableProcessor
    @CheckReturnValue
    public boolean hasSubscribers() {
        return this.subscribers.get().length != 0;
    }

    @Override // io.reactivex.rxjava3.processors.FlowableProcessor
    @CheckReturnValue
    public boolean hasThrowable() {
        return this.done && this.error != null;
    }

    @Override // io.reactivex.rxjava3.processors.FlowableProcessor
    @CheckReturnValue
    public boolean hasComplete() {
        return this.done && this.error == null;
    }

    @Override // io.reactivex.rxjava3.processors.FlowableProcessor
    @CheckReturnValue
    public Throwable getThrowable() {
        if (this.done) {
            return this.error;
        }
        return null;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    protected void subscribeActual(Subscriber<? super T> s) {
        Throwable th;
        MulticastSubscription<T> multicastSubscription = new MulticastSubscription<>(s, this);
        s.onSubscribe(multicastSubscription);
        if (add(multicastSubscription)) {
            if (multicastSubscription.get() == Long.MIN_VALUE) {
                remove(multicastSubscription);
                return;
            } else {
                drain();
                return;
            }
        }
        if (this.done && (th = this.error) != null) {
            s.onError(th);
        } else {
            s.onComplete();
        }
    }

    boolean add(MulticastSubscription<T> inner) {
        MulticastSubscription<T>[] multicastSubscriptionArr;
        MulticastSubscription<T>[] multicastSubscriptionArr2;
        do {
            multicastSubscriptionArr = this.subscribers.get();
            if (multicastSubscriptionArr == TERMINATED) {
                return false;
            }
            int length = multicastSubscriptionArr.length;
            multicastSubscriptionArr2 = new MulticastSubscription[length + 1];
            System.arraycopy(multicastSubscriptionArr, 0, multicastSubscriptionArr2, 0, length);
            multicastSubscriptionArr2[length] = inner;
        } while (!this.subscribers.compareAndSet(multicastSubscriptionArr, multicastSubscriptionArr2));
        return true;
    }

    void remove(MulticastSubscription<T> inner) {
        while (true) {
            MulticastSubscription<T>[] multicastSubscriptionArr = this.subscribers.get();
            int length = multicastSubscriptionArr.length;
            if (length == 0) {
                return;
            }
            int i = -1;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                }
                if (multicastSubscriptionArr[i2] == inner) {
                    i = i2;
                    break;
                }
                i2++;
            }
            if (i < 0) {
                return;
            }
            if (length == 1) {
                if (this.refcount) {
                    if (this.subscribers.compareAndSet(multicastSubscriptionArr, TERMINATED)) {
                        SubscriptionHelper.cancel(this.upstream);
                        this.done = true;
                        return;
                    }
                } else if (this.subscribers.compareAndSet(multicastSubscriptionArr, EMPTY)) {
                    return;
                }
            } else {
                MulticastSubscription<T>[] multicastSubscriptionArr2 = new MulticastSubscription[length - 1];
                System.arraycopy(multicastSubscriptionArr, 0, multicastSubscriptionArr2, 0, i);
                System.arraycopy(multicastSubscriptionArr, i + 1, multicastSubscriptionArr2, i, (length - i) - 1);
                if (this.subscribers.compareAndSet(multicastSubscriptionArr, multicastSubscriptionArr2)) {
                    return;
                }
            }
        }
    }

    void drain() {
        T t;
        if (this.wip.getAndIncrement() != 0) {
            return;
        }
        AtomicReference<MulticastSubscription<T>[]> atomicReference = this.subscribers;
        int i = this.consumed;
        int i2 = this.limit;
        int i3 = this.fusionMode;
        int i4 = 1;
        while (true) {
            SimpleQueue<T> simpleQueue = this.queue;
            if (simpleQueue != null) {
                MulticastSubscription<T>[] multicastSubscriptionArr = atomicReference.get();
                if (multicastSubscriptionArr.length != 0) {
                    int length = multicastSubscriptionArr.length;
                    long j = -1;
                    long j2 = -1;
                    int i5 = 0;
                    while (i5 < length) {
                        MulticastSubscription<T> multicastSubscription = multicastSubscriptionArr[i5];
                        long j3 = multicastSubscription.get();
                        if (j3 >= 0) {
                            if (j2 == j) {
                                j2 = j3 - multicastSubscription.emitted;
                            } else {
                                j2 = Math.min(j2, j3 - multicastSubscription.emitted);
                            }
                        }
                        i5++;
                        j = -1;
                    }
                    int i6 = i;
                    while (j2 > 0) {
                        MulticastSubscription<T>[] multicastSubscriptionArr2 = atomicReference.get();
                        if (multicastSubscriptionArr2 == TERMINATED) {
                            simpleQueue.clear();
                            return;
                        }
                        if (multicastSubscriptionArr != multicastSubscriptionArr2) {
                            break;
                        }
                        boolean z = this.done;
                        try {
                            t = simpleQueue.poll();
                        } catch (Throwable th) {
                            Exceptions.throwIfFatal(th);
                            SubscriptionHelper.cancel(this.upstream);
                            this.error = th;
                            this.done = true;
                            t = null;
                            z = true;
                        }
                        boolean z2 = t == null;
                        if (z && z2) {
                            Throwable th2 = this.error;
                            if (th2 != null) {
                                for (MulticastSubscription<T> multicastSubscription2 : atomicReference.getAndSet(TERMINATED)) {
                                    multicastSubscription2.onError(th2);
                                }
                                return;
                            }
                            for (MulticastSubscription<T> multicastSubscription3 : atomicReference.getAndSet(TERMINATED)) {
                                multicastSubscription3.onComplete();
                            }
                            return;
                        }
                        if (z2) {
                            break;
                        }
                        for (MulticastSubscription<T> multicastSubscription4 : multicastSubscriptionArr) {
                            multicastSubscription4.onNext(t);
                        }
                        j2--;
                        if (i3 != 1 && (i6 = i6 + 1) == i2) {
                            this.upstream.get().request(i2);
                            i6 = 0;
                        }
                    }
                    if (j2 == 0) {
                        MulticastSubscription<T>[] multicastSubscriptionArr3 = atomicReference.get();
                        MulticastSubscription<T>[] multicastSubscriptionArr4 = TERMINATED;
                        if (multicastSubscriptionArr3 == multicastSubscriptionArr4) {
                            simpleQueue.clear();
                            return;
                        }
                        if (multicastSubscriptionArr != multicastSubscriptionArr3) {
                            i = i6;
                        } else if (this.done && simpleQueue.isEmpty()) {
                            Throwable th3 = this.error;
                            if (th3 != null) {
                                for (MulticastSubscription<T> multicastSubscription5 : atomicReference.getAndSet(multicastSubscriptionArr4)) {
                                    multicastSubscription5.onError(th3);
                                }
                                return;
                            }
                            for (MulticastSubscription<T> multicastSubscription6 : atomicReference.getAndSet(multicastSubscriptionArr4)) {
                                multicastSubscription6.onComplete();
                            }
                            return;
                        }
                    }
                    i = i6;
                }
            }
            this.consumed = i;
            i4 = this.wip.addAndGet(-i4);
            if (i4 == 0) {
                return;
            }
        }
    }

    static final class MulticastSubscription<T> extends AtomicLong implements Subscription {
        private static final long serialVersionUID = -363282618957264509L;
        final Subscriber<? super T> downstream;
        long emitted;
        final MulticastProcessor<T> parent;

        MulticastSubscription(Subscriber<? super T> actual, MulticastProcessor<T> parent) {
            this.downstream = actual;
            this.parent = parent;
        }

        @Override // org.reactivestreams.Subscription
        public void request(long n) {
            if (SubscriptionHelper.validate(n)) {
                long addCancel = BackpressureHelper.addCancel(this, n);
                if (addCancel == Long.MIN_VALUE || addCancel == Long.MAX_VALUE) {
                    return;
                }
                this.parent.drain();
            }
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) {
                this.parent.remove(this);
            }
        }

        void onNext(T t) {
            if (get() != Long.MIN_VALUE) {
                this.emitted++;
                this.downstream.onNext(t);
            }
        }

        void onError(Throwable t) {
            if (get() != Long.MIN_VALUE) {
                this.downstream.onError(t);
            }
        }

        void onComplete() {
            if (get() != Long.MIN_VALUE) {
                this.downstream.onComplete();
            }
        }
    }
}
