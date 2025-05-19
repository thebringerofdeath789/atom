package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.internal.fuseable.ConditionalSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.BasicQueueSubscription;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import java.util.Iterator;
import java.util.Objects;
import org.reactivestreams.Subscriber;

/* loaded from: classes4.dex */
public final class FlowableFromIterable<T> extends Flowable<T> {
    final Iterable<? extends T> source;

    public FlowableFromIterable(Iterable<? extends T> source) {
        this.source = source;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super T> s) {
        try {
            subscribe(s, this.source.iterator());
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            EmptySubscription.error(th, s);
        }
    }

    public static <T> void subscribe(Subscriber<? super T> s, Iterator<? extends T> it) {
        try {
            if (!it.hasNext()) {
                EmptySubscription.complete(s);
            } else if (s instanceof ConditionalSubscriber) {
                s.onSubscribe(new IteratorConditionalSubscription((ConditionalSubscriber) s, it));
            } else {
                s.onSubscribe(new IteratorSubscription(s, it));
            }
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            EmptySubscription.error(th, s);
        }
    }

    static abstract class BaseRangeSubscription<T> extends BasicQueueSubscription<T> {
        private static final long serialVersionUID = -2252972430506210021L;
        volatile boolean cancelled;
        Iterator<? extends T> iterator;
        boolean once;

        abstract void fastPath();

        @Override // io.reactivex.rxjava3.internal.fuseable.QueueFuseable
        public final int requestFusion(int mode) {
            return mode & 1;
        }

        abstract void slowPath(long r);

        BaseRangeSubscription(Iterator<? extends T> it) {
            this.iterator = it;
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.SimpleQueue
        public final T poll() {
            Iterator<? extends T> it = this.iterator;
            if (it == null) {
                return null;
            }
            if (!this.once) {
                this.once = true;
            } else if (!it.hasNext()) {
                return null;
            }
            return (T) Objects.requireNonNull(this.iterator.next(), "Iterator.next() returned a null value");
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.SimpleQueue
        public final boolean isEmpty() {
            Iterator<? extends T> it = this.iterator;
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
        public final void clear() {
            this.iterator = null;
        }

        @Override // org.reactivestreams.Subscription
        public final void request(long n) {
            if (SubscriptionHelper.validate(n) && BackpressureHelper.add(this, n) == 0) {
                if (n == Long.MAX_VALUE) {
                    fastPath();
                } else {
                    slowPath(n);
                }
            }
        }

        @Override // org.reactivestreams.Subscription
        public final void cancel() {
            this.cancelled = true;
        }
    }

    static final class IteratorSubscription<T> extends BaseRangeSubscription<T> {
        private static final long serialVersionUID = -6022804456014692607L;
        final Subscriber<? super T> downstream;

        IteratorSubscription(Subscriber<? super T> actual, Iterator<? extends T> it) {
            super(it);
            this.downstream = actual;
        }

        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableFromIterable.BaseRangeSubscription
        void fastPath() {
            Iterator<? extends T> it = this.iterator;
            Subscriber<? super T> subscriber = this.downstream;
            while (!this.cancelled) {
                try {
                    T next = it.next();
                    if (this.cancelled) {
                        return;
                    }
                    if (next == null) {
                        subscriber.onError(new NullPointerException("Iterator.next() returned a null value"));
                        return;
                    }
                    subscriber.onNext(next);
                    if (this.cancelled) {
                        return;
                    }
                    try {
                        if (!it.hasNext()) {
                            if (this.cancelled) {
                                return;
                            }
                            subscriber.onComplete();
                            return;
                        }
                    } catch (Throwable th) {
                        Exceptions.throwIfFatal(th);
                        subscriber.onError(th);
                        return;
                    }
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    subscriber.onError(th2);
                    return;
                }
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:9:0x0058, code lost:
        
            r9 = addAndGet(-r4);
         */
        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableFromIterable.BaseRangeSubscription
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void slowPath(long r9) {
            /*
                r8 = this;
                java.util.Iterator<? extends T> r0 = r8.iterator
                org.reactivestreams.Subscriber<? super T> r1 = r8.downstream
                r2 = 0
            L6:
                r4 = r2
            L7:
                int r6 = (r4 > r9 ? 1 : (r4 == r9 ? 0 : -1))
                if (r6 == 0) goto L50
                boolean r6 = r8.cancelled
                if (r6 == 0) goto L10
                return
            L10:
                java.lang.Object r6 = r0.next()     // Catch: java.lang.Throwable -> L48
                boolean r7 = r8.cancelled
                if (r7 == 0) goto L19
                return
            L19:
                if (r6 != 0) goto L26
                java.lang.NullPointerException r9 = new java.lang.NullPointerException
                java.lang.String r10 = "Iterator.next() returned a null value"
                r9.<init>(r10)
                r1.onError(r9)
                return
            L26:
                r1.onNext(r6)
                boolean r6 = r8.cancelled
                if (r6 == 0) goto L2e
                return
            L2e:
                boolean r6 = r0.hasNext()     // Catch: java.lang.Throwable -> L40
                if (r6 != 0) goto L3c
                boolean r9 = r8.cancelled
                if (r9 != 0) goto L3b
                r1.onComplete()
            L3b:
                return
            L3c:
                r6 = 1
                long r4 = r4 + r6
                goto L7
            L40:
                r9 = move-exception
                io.reactivex.rxjava3.exceptions.Exceptions.throwIfFatal(r9)
                r1.onError(r9)
                return
            L48:
                r9 = move-exception
                io.reactivex.rxjava3.exceptions.Exceptions.throwIfFatal(r9)
                r1.onError(r9)
                return
            L50:
                long r9 = r8.get()
                int r6 = (r4 > r9 ? 1 : (r4 == r9 ? 0 : -1))
                if (r6 != 0) goto L7
                long r9 = -r4
                long r9 = r8.addAndGet(r9)
                int r4 = (r9 > r2 ? 1 : (r9 == r2 ? 0 : -1))
                if (r4 != 0) goto L6
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.operators.flowable.FlowableFromIterable.IteratorSubscription.slowPath(long):void");
        }
    }

    static final class IteratorConditionalSubscription<T> extends BaseRangeSubscription<T> {
        private static final long serialVersionUID = -6022804456014692607L;
        final ConditionalSubscriber<? super T> downstream;

        IteratorConditionalSubscription(ConditionalSubscriber<? super T> actual, Iterator<? extends T> it) {
            super(it);
            this.downstream = actual;
        }

        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableFromIterable.BaseRangeSubscription
        void fastPath() {
            Iterator<? extends T> it = this.iterator;
            ConditionalSubscriber<? super T> conditionalSubscriber = this.downstream;
            while (!this.cancelled) {
                try {
                    T next = it.next();
                    if (this.cancelled) {
                        return;
                    }
                    if (next == null) {
                        conditionalSubscriber.onError(new NullPointerException("Iterator.next() returned a null value"));
                        return;
                    }
                    conditionalSubscriber.tryOnNext(next);
                    if (this.cancelled) {
                        return;
                    }
                    try {
                        if (!it.hasNext()) {
                            if (this.cancelled) {
                                return;
                            }
                            conditionalSubscriber.onComplete();
                            return;
                        }
                    } catch (Throwable th) {
                        Exceptions.throwIfFatal(th);
                        conditionalSubscriber.onError(th);
                        return;
                    }
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    conditionalSubscriber.onError(th2);
                    return;
                }
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:9:0x005b, code lost:
        
            r9 = addAndGet(-r4);
         */
        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableFromIterable.BaseRangeSubscription
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void slowPath(long r9) {
            /*
                r8 = this;
                java.util.Iterator<? extends T> r0 = r8.iterator
                io.reactivex.rxjava3.internal.fuseable.ConditionalSubscriber<? super T> r1 = r8.downstream
                r2 = 0
            L6:
                r4 = r2
            L7:
                int r6 = (r4 > r9 ? 1 : (r4 == r9 ? 0 : -1))
                if (r6 == 0) goto L53
                boolean r6 = r8.cancelled
                if (r6 == 0) goto L10
                return
            L10:
                java.lang.Object r6 = r0.next()     // Catch: java.lang.Throwable -> L4b
                boolean r7 = r8.cancelled
                if (r7 == 0) goto L19
                return
            L19:
                if (r6 != 0) goto L26
                java.lang.NullPointerException r9 = new java.lang.NullPointerException
                java.lang.String r10 = "Iterator.next() returned a null value"
                r9.<init>(r10)
                r1.onError(r9)
                return
            L26:
                boolean r6 = r1.tryOnNext(r6)
                boolean r7 = r8.cancelled
                if (r7 == 0) goto L2f
                return
            L2f:
                boolean r7 = r0.hasNext()     // Catch: java.lang.Throwable -> L43
                if (r7 != 0) goto L3d
                boolean r9 = r8.cancelled
                if (r9 != 0) goto L3c
                r1.onComplete()
            L3c:
                return
            L3d:
                if (r6 == 0) goto L7
                r6 = 1
                long r4 = r4 + r6
                goto L7
            L43:
                r9 = move-exception
                io.reactivex.rxjava3.exceptions.Exceptions.throwIfFatal(r9)
                r1.onError(r9)
                return
            L4b:
                r9 = move-exception
                io.reactivex.rxjava3.exceptions.Exceptions.throwIfFatal(r9)
                r1.onError(r9)
                return
            L53:
                long r9 = r8.get()
                int r6 = (r4 > r9 ? 1 : (r4 == r9 ? 0 : -1))
                if (r6 != 0) goto L7
                long r9 = -r4
                long r9 = r8.addAndGet(r9)
                int r4 = (r9 > r2 ? 1 : (r9 == r2 ? 0 : -1))
                if (r4 != 0) goto L6
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.operators.flowable.FlowableFromIterable.IteratorConditionalSubscription.slowPath(long):void");
        }
    }
}
