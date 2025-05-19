package io.reactivex.rxjava3.internal.jdk8;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.internal.fuseable.ConditionalSubscriber;
import io.reactivex.rxjava3.internal.fuseable.QueueSubscription;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Stream;
import org.reactivestreams.Subscriber;

/* loaded from: classes4.dex */
public final class FlowableFromStream<T> extends Flowable<T> {
    final Stream<T> stream;

    public FlowableFromStream(Stream<T> stream) {
        this.stream = stream;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    protected void subscribeActual(Subscriber<? super T> s) {
        subscribeStream(s, this.stream);
    }

    public static <T> void subscribeStream(Subscriber<? super T> s, Stream<T> stream) {
        try {
            Iterator<T> it = stream.iterator();
            if (!it.hasNext()) {
                EmptySubscription.complete(s);
                closeSafely(stream);
            } else if (s instanceof ConditionalSubscriber) {
                s.onSubscribe(new StreamConditionalSubscription((ConditionalSubscriber) s, it, stream));
            } else {
                s.onSubscribe(new StreamSubscription(s, it, stream));
            }
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            EmptySubscription.error(th, s);
            closeSafely(stream);
        }
    }

    static void closeSafely(AutoCloseable c) {
        try {
            c.close();
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            RxJavaPlugins.onError(th);
        }
    }

    static abstract class AbstractStreamSubscription<T> extends AtomicLong implements QueueSubscription<T> {
        private static final long serialVersionUID = -9082954702547571853L;
        volatile boolean cancelled;
        AutoCloseable closeable;
        Iterator<T> iterator;
        boolean once;

        abstract void run(long n);

        AbstractStreamSubscription(Iterator<T> iterator, AutoCloseable closeable) {
            this.iterator = iterator;
            this.closeable = closeable;
        }

        @Override // org.reactivestreams.Subscription
        public void request(long n) {
            if (SubscriptionHelper.validate(n) && BackpressureHelper.add(this, n) == 0) {
                run(n);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.cancelled = true;
            request(1L);
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.QueueFuseable
        public int requestFusion(int mode) {
            if ((mode & 1) == 0) {
                return 0;
            }
            lazySet(Long.MAX_VALUE);
            return 1;
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.SimpleQueue
        public boolean offer(T value) {
            throw new UnsupportedOperationException();
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.SimpleQueue
        public boolean offer(T v1, T v2) {
            throw new UnsupportedOperationException();
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.SimpleQueue
        public T poll() {
            Iterator<T> it = this.iterator;
            if (it == null) {
                return null;
            }
            if (!this.once) {
                this.once = true;
            } else if (!it.hasNext()) {
                clear();
                return null;
            }
            return (T) Objects.requireNonNull(this.iterator.next(), "The Stream's Iterator.next() returned a null value");
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.SimpleQueue
        public boolean isEmpty() {
            Iterator<T> it = this.iterator;
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
            AutoCloseable autoCloseable = this.closeable;
            this.closeable = null;
            if (autoCloseable != null) {
                FlowableFromStream.closeSafely(autoCloseable);
            }
        }
    }

    static final class StreamSubscription<T> extends AbstractStreamSubscription<T> {
        private static final long serialVersionUID = -9082954702547571853L;
        final Subscriber<? super T> downstream;

        StreamSubscription(Subscriber<? super T> downstream, Iterator<T> iterator, AutoCloseable closeable) {
            super(iterator, closeable);
            this.downstream = downstream;
        }

        @Override // io.reactivex.rxjava3.internal.jdk8.FlowableFromStream.AbstractStreamSubscription
        public void run(long j) {
            Iterator<T> it = this.iterator;
            Subscriber<? super T> subscriber = this.downstream;
            long j2 = 0;
            while (!this.cancelled) {
                try {
                    subscriber.onNext((Object) Objects.requireNonNull(it.next(), "The Stream's Iterator returned a null value"));
                    if (this.cancelled) {
                        continue;
                    } else {
                        try {
                            if (it.hasNext()) {
                                j2++;
                                if (j2 != j) {
                                    continue;
                                } else {
                                    j = get();
                                    if (j2 != j) {
                                        continue;
                                    } else if (compareAndSet(j, 0L)) {
                                        return;
                                    } else {
                                        j = get();
                                    }
                                }
                            } else {
                                subscriber.onComplete();
                                this.cancelled = true;
                            }
                        } catch (Throwable th) {
                            Exceptions.throwIfFatal(th);
                            subscriber.onError(th);
                            this.cancelled = true;
                        }
                    }
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    subscriber.onError(th2);
                    this.cancelled = true;
                }
            }
            clear();
        }
    }

    static final class StreamConditionalSubscription<T> extends AbstractStreamSubscription<T> {
        private static final long serialVersionUID = -9082954702547571853L;
        final ConditionalSubscriber<? super T> downstream;

        StreamConditionalSubscription(ConditionalSubscriber<? super T> downstream, Iterator<T> iterator, AutoCloseable closeable) {
            super(iterator, closeable);
            this.downstream = downstream;
        }

        @Override // io.reactivex.rxjava3.internal.jdk8.FlowableFromStream.AbstractStreamSubscription
        public void run(long j) {
            Iterator<T> it = this.iterator;
            ConditionalSubscriber<? super T> conditionalSubscriber = this.downstream;
            long j2 = 0;
            while (!this.cancelled) {
                try {
                    if (conditionalSubscriber.tryOnNext((Object) Objects.requireNonNull(it.next(), "The Stream's Iterator returned a null value"))) {
                        j2++;
                    }
                    if (this.cancelled) {
                        continue;
                    } else {
                        try {
                            if (!it.hasNext()) {
                                conditionalSubscriber.onComplete();
                                this.cancelled = true;
                            } else if (j2 != j) {
                                continue;
                            } else {
                                j = get();
                                if (j2 != j) {
                                    continue;
                                } else if (compareAndSet(j, 0L)) {
                                    return;
                                } else {
                                    j = get();
                                }
                            }
                        } catch (Throwable th) {
                            Exceptions.throwIfFatal(th);
                            conditionalSubscriber.onError(th);
                            this.cancelled = true;
                        }
                    }
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    conditionalSubscriber.onError(th2);
                    this.cancelled = true;
                }
            }
            clear();
        }
    }
}
