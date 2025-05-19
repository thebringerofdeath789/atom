package io.reactivex.rxjava3.internal.subscribers;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.internal.fuseable.SimplePlainQueue;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.internal.util.QueueDrain;
import io.reactivex.rxjava3.internal.util.QueueDrainHelper;
import org.reactivestreams.Subscriber;

/* loaded from: classes4.dex */
public abstract class QueueDrainSubscriber<T, U, V> extends QueueDrainSubscriberPad4 implements FlowableSubscriber<T>, QueueDrain<U, V> {
    protected volatile boolean cancelled;
    protected volatile boolean done;
    protected final Subscriber<? super V> downstream;
    protected Throwable error;
    protected final SimplePlainQueue<U> queue;

    public boolean accept(Subscriber<? super V> a, U v) {
        return false;
    }

    public QueueDrainSubscriber(Subscriber<? super V> actual, SimplePlainQueue<U> queue) {
        this.downstream = actual;
        this.queue = queue;
    }

    @Override // io.reactivex.rxjava3.internal.util.QueueDrain
    public final boolean cancelled() {
        return this.cancelled;
    }

    @Override // io.reactivex.rxjava3.internal.util.QueueDrain
    public final boolean done() {
        return this.done;
    }

    @Override // io.reactivex.rxjava3.internal.util.QueueDrain
    public final boolean enter() {
        return this.wip.getAndIncrement() == 0;
    }

    public final boolean fastEnter() {
        return this.wip.get() == 0 && this.wip.compareAndSet(0, 1);
    }

    protected final void fastPathEmitMax(U value, boolean delayError, Disposable dispose) {
        Subscriber<? super V> subscriber = this.downstream;
        SimplePlainQueue<U> simplePlainQueue = this.queue;
        if (fastEnter()) {
            long j = this.requested.get();
            if (j != 0) {
                if (accept(subscriber, value) && j != Long.MAX_VALUE) {
                    produced(1L);
                }
                if (leave(-1) == 0) {
                    return;
                }
            } else {
                dispose.dispose();
                subscriber.onError(new MissingBackpressureException("Could not emit buffer due to lack of requests"));
                return;
            }
        } else {
            simplePlainQueue.offer(value);
            if (!enter()) {
                return;
            }
        }
        QueueDrainHelper.drainMaxLoop(simplePlainQueue, subscriber, delayError, dispose, this);
    }

    protected final void fastPathOrderedEmitMax(U value, boolean delayError, Disposable dispose) {
        Subscriber<? super V> subscriber = this.downstream;
        SimplePlainQueue<U> simplePlainQueue = this.queue;
        if (fastEnter()) {
            long j = this.requested.get();
            if (j != 0) {
                if (simplePlainQueue.isEmpty()) {
                    if (accept(subscriber, value) && j != Long.MAX_VALUE) {
                        produced(1L);
                    }
                    if (leave(-1) == 0) {
                        return;
                    }
                } else {
                    simplePlainQueue.offer(value);
                }
            } else {
                this.cancelled = true;
                dispose.dispose();
                subscriber.onError(new MissingBackpressureException("Could not emit buffer due to lack of requests"));
                return;
            }
        } else {
            simplePlainQueue.offer(value);
            if (!enter()) {
                return;
            }
        }
        QueueDrainHelper.drainMaxLoop(simplePlainQueue, subscriber, delayError, dispose, this);
    }

    @Override // io.reactivex.rxjava3.internal.util.QueueDrain
    public final Throwable error() {
        return this.error;
    }

    @Override // io.reactivex.rxjava3.internal.util.QueueDrain
    public final int leave(int m) {
        return this.wip.addAndGet(m);
    }

    @Override // io.reactivex.rxjava3.internal.util.QueueDrain
    public final long requested() {
        return this.requested.get();
    }

    @Override // io.reactivex.rxjava3.internal.util.QueueDrain
    public final long produced(long n) {
        return this.requested.addAndGet(-n);
    }

    public final void requested(long n) {
        if (SubscriptionHelper.validate(n)) {
            BackpressureHelper.add(this.requested, n);
        }
    }
}
