package io.reactivex.rxjava3.internal.operators.parallel;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.internal.fuseable.ConditionalSubscriber;
import io.reactivex.rxjava3.internal.queue.SpscArrayQueue;
import io.reactivex.rxjava3.internal.schedulers.SchedulerMultiWorkerSupport;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.parallel.ParallelFlowable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes4.dex */
public final class ParallelRunOn<T> extends ParallelFlowable<T> {
    final int prefetch;
    final Scheduler scheduler;
    final ParallelFlowable<? extends T> source;

    public ParallelRunOn(ParallelFlowable<? extends T> parent, Scheduler scheduler, int prefetch) {
        this.source = parent;
        this.scheduler = scheduler;
        this.prefetch = prefetch;
    }

    @Override // io.reactivex.rxjava3.parallel.ParallelFlowable
    public void subscribe(final Subscriber<? super T>[] subscribers) {
        if (validate(subscribers)) {
            int length = subscribers.length;
            Subscriber<T>[] subscriberArr = new Subscriber[length];
            Object obj = this.scheduler;
            if (obj instanceof SchedulerMultiWorkerSupport) {
                ((SchedulerMultiWorkerSupport) obj).createWorkers(length, new MultiWorkerCallback(subscribers, subscriberArr));
            } else {
                for (int i = 0; i < length; i++) {
                    createSubscriber(i, subscribers, subscriberArr, this.scheduler.createWorker());
                }
            }
            this.source.subscribe(subscriberArr);
        }
    }

    void createSubscriber(int i, Subscriber<? super T>[] subscribers, Subscriber<T>[] parents, Scheduler.Worker worker) {
        Subscriber<? super T> subscriber = subscribers[i];
        SpscArrayQueue spscArrayQueue = new SpscArrayQueue(this.prefetch);
        if (subscriber instanceof ConditionalSubscriber) {
            parents[i] = new RunOnConditionalSubscriber((ConditionalSubscriber) subscriber, this.prefetch, spscArrayQueue, worker);
        } else {
            parents[i] = new RunOnSubscriber(subscriber, this.prefetch, spscArrayQueue, worker);
        }
    }

    final class MultiWorkerCallback implements SchedulerMultiWorkerSupport.WorkerCallback {
        final Subscriber<T>[] parents;
        final Subscriber<? super T>[] subscribers;

        MultiWorkerCallback(Subscriber<? super T>[] subscribers, Subscriber<T>[] parents) {
            this.subscribers = subscribers;
            this.parents = parents;
        }

        @Override // io.reactivex.rxjava3.internal.schedulers.SchedulerMultiWorkerSupport.WorkerCallback
        public void onWorker(int i, Scheduler.Worker w) {
            ParallelRunOn.this.createSubscriber(i, this.subscribers, this.parents, w);
        }
    }

    @Override // io.reactivex.rxjava3.parallel.ParallelFlowable
    public int parallelism() {
        return this.source.parallelism();
    }

    static abstract class BaseRunOnSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, Subscription, Runnable {
        private static final long serialVersionUID = 9222303586456402150L;
        volatile boolean cancelled;
        int consumed;
        volatile boolean done;
        Throwable error;
        final int limit;
        final int prefetch;
        final SpscArrayQueue<T> queue;
        final AtomicLong requested = new AtomicLong();
        Subscription upstream;
        final Scheduler.Worker worker;

        BaseRunOnSubscriber(int prefetch, SpscArrayQueue<T> queue, Scheduler.Worker worker) {
            this.prefetch = prefetch;
            this.queue = queue;
            this.limit = prefetch - (prefetch >> 2);
            this.worker = worker;
        }

        @Override // org.reactivestreams.Subscriber
        public final void onNext(T t) {
            if (this.done) {
                return;
            }
            if (!this.queue.offer(t)) {
                this.upstream.cancel();
                onError(new MissingBackpressureException("Queue is full?!"));
            } else {
                schedule();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public final void onError(Throwable t) {
            if (this.done) {
                RxJavaPlugins.onError(t);
                return;
            }
            this.error = t;
            this.done = true;
            schedule();
        }

        @Override // org.reactivestreams.Subscriber
        public final void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            schedule();
        }

        @Override // org.reactivestreams.Subscription
        public final void request(long n) {
            if (SubscriptionHelper.validate(n)) {
                BackpressureHelper.add(this.requested, n);
                schedule();
            }
        }

        @Override // org.reactivestreams.Subscription
        public final void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.upstream.cancel();
            this.worker.dispose();
            if (getAndIncrement() == 0) {
                this.queue.clear();
            }
        }

        final void schedule() {
            if (getAndIncrement() == 0) {
                this.worker.schedule(this);
            }
        }
    }

    static final class RunOnSubscriber<T> extends BaseRunOnSubscriber<T> {
        private static final long serialVersionUID = 1075119423897941642L;
        final Subscriber<? super T> downstream;

        RunOnSubscriber(Subscriber<? super T> actual, int prefetch, SpscArrayQueue<T> queue, Scheduler.Worker worker) {
            super(prefetch, queue, worker);
            this.downstream = actual;
        }

        @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription s) {
            if (SubscriptionHelper.validate(this.upstream, s)) {
                this.upstream = s;
                this.downstream.onSubscribe(this);
                s.request(this.prefetch);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Throwable th;
            int i = this.consumed;
            SpscArrayQueue<T> spscArrayQueue = this.queue;
            Subscriber<? super T> subscriber = this.downstream;
            int i2 = this.limit;
            int i3 = 1;
            while (true) {
                long j = this.requested.get();
                long j2 = 0;
                while (j2 != j) {
                    if (this.cancelled) {
                        spscArrayQueue.clear();
                        return;
                    }
                    boolean z = this.done;
                    if (z && (th = this.error) != null) {
                        spscArrayQueue.clear();
                        subscriber.onError(th);
                        this.worker.dispose();
                        return;
                    }
                    T poll = spscArrayQueue.poll();
                    boolean z2 = poll == null;
                    if (z && z2) {
                        subscriber.onComplete();
                        this.worker.dispose();
                        return;
                    } else {
                        if (z2) {
                            break;
                        }
                        subscriber.onNext(poll);
                        j2++;
                        i++;
                        if (i == i2) {
                            this.upstream.request(i);
                            i = 0;
                        }
                    }
                }
                if (j2 == j) {
                    if (this.cancelled) {
                        spscArrayQueue.clear();
                        return;
                    }
                    if (this.done) {
                        Throwable th2 = this.error;
                        if (th2 != null) {
                            spscArrayQueue.clear();
                            subscriber.onError(th2);
                            this.worker.dispose();
                            return;
                        } else if (spscArrayQueue.isEmpty()) {
                            subscriber.onComplete();
                            this.worker.dispose();
                            return;
                        }
                    }
                }
                if (j2 != 0 && j != Long.MAX_VALUE) {
                    this.requested.addAndGet(-j2);
                }
                int i4 = get();
                if (i4 == i3) {
                    this.consumed = i;
                    i3 = addAndGet(-i3);
                    if (i3 == 0) {
                        return;
                    }
                } else {
                    i3 = i4;
                }
            }
        }
    }

    static final class RunOnConditionalSubscriber<T> extends BaseRunOnSubscriber<T> {
        private static final long serialVersionUID = 1075119423897941642L;
        final ConditionalSubscriber<? super T> downstream;

        RunOnConditionalSubscriber(ConditionalSubscriber<? super T> actual, int prefetch, SpscArrayQueue<T> queue, Scheduler.Worker worker) {
            super(prefetch, queue, worker);
            this.downstream = actual;
        }

        @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription s) {
            if (SubscriptionHelper.validate(this.upstream, s)) {
                this.upstream = s;
                this.downstream.onSubscribe(this);
                s.request(this.prefetch);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Throwable th;
            int i = this.consumed;
            SpscArrayQueue<T> spscArrayQueue = this.queue;
            ConditionalSubscriber<? super T> conditionalSubscriber = this.downstream;
            int i2 = this.limit;
            int i3 = 1;
            do {
                long j = this.requested.get();
                long j2 = 0;
                while (j2 != j) {
                    if (this.cancelled) {
                        spscArrayQueue.clear();
                        return;
                    }
                    boolean z = this.done;
                    if (z && (th = this.error) != null) {
                        spscArrayQueue.clear();
                        conditionalSubscriber.onError(th);
                        this.worker.dispose();
                        return;
                    }
                    T poll = spscArrayQueue.poll();
                    boolean z2 = poll == null;
                    if (z && z2) {
                        conditionalSubscriber.onComplete();
                        this.worker.dispose();
                        return;
                    } else {
                        if (z2) {
                            break;
                        }
                        if (conditionalSubscriber.tryOnNext(poll)) {
                            j2++;
                        }
                        i++;
                        if (i == i2) {
                            this.upstream.request(i);
                            i = 0;
                        }
                    }
                }
                if (j2 == j) {
                    if (this.cancelled) {
                        spscArrayQueue.clear();
                        return;
                    }
                    if (this.done) {
                        Throwable th2 = this.error;
                        if (th2 != null) {
                            spscArrayQueue.clear();
                            conditionalSubscriber.onError(th2);
                            this.worker.dispose();
                            return;
                        } else if (spscArrayQueue.isEmpty()) {
                            conditionalSubscriber.onComplete();
                            this.worker.dispose();
                            return;
                        }
                    }
                }
                if (j2 != 0) {
                    BackpressureHelper.produced(this.requested, j2);
                }
                this.consumed = i;
                i3 = addAndGet(-i3);
            } while (i3 != 0);
        }
    }
}
