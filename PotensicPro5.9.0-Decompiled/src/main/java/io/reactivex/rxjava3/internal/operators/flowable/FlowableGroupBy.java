package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.flowables.GroupedFlowable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.rxjava3.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.internal.util.EmptyComponent;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes4.dex */
public final class FlowableGroupBy<T, K, V> extends AbstractFlowableWithUpstream<T, GroupedFlowable<K, V>> {
    final int bufferSize;
    final boolean delayError;
    final Function<? super T, ? extends K> keySelector;
    final Function<? super Consumer<Object>, ? extends Map<K, Object>> mapFactory;
    final Function<? super T, ? extends V> valueSelector;

    public FlowableGroupBy(Flowable<T> source, Function<? super T, ? extends K> keySelector, Function<? super T, ? extends V> valueSelector, int bufferSize, boolean delayError, Function<? super Consumer<Object>, ? extends Map<K, Object>> mapFactory) {
        super(source);
        this.keySelector = keySelector;
        this.valueSelector = valueSelector;
        this.bufferSize = bufferSize;
        this.delayError = delayError;
        this.mapFactory = mapFactory;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    protected void subscribeActual(Subscriber<? super GroupedFlowable<K, V>> s) {
        ConcurrentLinkedQueue concurrentLinkedQueue;
        Map<K, Object> apply;
        try {
            if (this.mapFactory == null) {
                concurrentLinkedQueue = null;
                apply = new ConcurrentHashMap<>();
            } else {
                concurrentLinkedQueue = new ConcurrentLinkedQueue();
                apply = this.mapFactory.apply(new EvictionAction(concurrentLinkedQueue));
            }
            this.source.subscribe((FlowableSubscriber) new GroupBySubscriber(s, this.keySelector, this.valueSelector, this.bufferSize, this.delayError, apply, concurrentLinkedQueue));
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            s.onSubscribe(EmptyComponent.INSTANCE);
            s.onError(th);
        }
    }

    public static final class GroupBySubscriber<T, K, V> extends AtomicLong implements FlowableSubscriber<T>, Subscription {
        static final Object NULL_KEY = new Object();
        private static final long serialVersionUID = -3688291656102519502L;
        final int bufferSize;
        final boolean delayError;
        boolean done;
        final Subscriber<? super GroupedFlowable<K, V>> downstream;
        long emittedGroups;
        final Queue<GroupedUnicast<K, V>> evictedGroups;
        final Map<Object, GroupedUnicast<K, V>> groups;
        final Function<? super T, ? extends K> keySelector;
        final int limit;
        Subscription upstream;
        final Function<? super T, ? extends V> valueSelector;
        final AtomicBoolean cancelled = new AtomicBoolean();
        final AtomicInteger groupCount = new AtomicInteger(1);
        final AtomicLong groupConsumed = new AtomicLong();

        public GroupBySubscriber(Subscriber<? super GroupedFlowable<K, V>> actual, Function<? super T, ? extends K> keySelector, Function<? super T, ? extends V> valueSelector, int bufferSize, boolean delayError, Map<Object, GroupedUnicast<K, V>> groups, Queue<GroupedUnicast<K, V>> evictedGroups) {
            this.downstream = actual;
            this.keySelector = keySelector;
            this.valueSelector = valueSelector;
            this.bufferSize = bufferSize;
            this.limit = bufferSize - (bufferSize >> 2);
            this.delayError = delayError;
            this.groups = groups;
            this.evictedGroups = evictedGroups;
        }

        @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription s) {
            if (SubscriptionHelper.validate(this.upstream, s)) {
                this.upstream = s;
                this.downstream.onSubscribe(this);
                s.request(this.bufferSize);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            try {
                K apply = this.keySelector.apply(t);
                boolean z = false;
                Object obj = apply != null ? apply : NULL_KEY;
                GroupedUnicast groupedUnicast = this.groups.get(obj);
                if (groupedUnicast == null) {
                    if (this.cancelled.get()) {
                        return;
                    }
                    groupedUnicast = GroupedUnicast.createWith(apply, this.bufferSize, this, this.delayError);
                    this.groups.put(obj, groupedUnicast);
                    this.groupCount.getAndIncrement();
                    z = true;
                }
                try {
                    groupedUnicast.onNext(ExceptionHelper.nullCheck(this.valueSelector.apply(t), "The valueSelector returned a null value."));
                    completeEvictions();
                    if (z) {
                        if (this.emittedGroups != get()) {
                            this.emittedGroups++;
                            this.downstream.onNext(groupedUnicast);
                            if (groupedUnicast.state.tryAbandon()) {
                                cancel(apply);
                                groupedUnicast.onComplete();
                                requestGroup(1L);
                                return;
                            }
                            return;
                        }
                        this.upstream.cancel();
                        onError(new MissingBackpressureException(groupHangWarning(this.emittedGroups)));
                    }
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    this.upstream.cancel();
                    if (z) {
                        if (this.emittedGroups != get()) {
                            this.downstream.onNext(groupedUnicast);
                        } else {
                            MissingBackpressureException missingBackpressureException = new MissingBackpressureException(groupHangWarning(this.emittedGroups));
                            missingBackpressureException.initCause(th);
                            onError(missingBackpressureException);
                            return;
                        }
                    }
                    onError(th);
                }
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                this.upstream.cancel();
                onError(th2);
            }
        }

        static String groupHangWarning(long n) {
            return "Unable to emit a new group (#" + n + ") due to lack of requests. Please make sure the downstream can always accept a new group as well as each group is consumed in order for the whole operator to be able to proceed.";
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable t) {
            if (this.done) {
                RxJavaPlugins.onError(t);
                return;
            }
            this.done = true;
            Iterator<GroupedUnicast<K, V>> it = this.groups.values().iterator();
            while (it.hasNext()) {
                it.next().onError(t);
            }
            this.groups.clear();
            completeEvictions();
            this.downstream.onError(t);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.done) {
                return;
            }
            Iterator<GroupedUnicast<K, V>> it = this.groups.values().iterator();
            while (it.hasNext()) {
                it.next().onComplete();
            }
            this.groups.clear();
            completeEvictions();
            this.done = true;
            this.downstream.onComplete();
        }

        @Override // org.reactivestreams.Subscription
        public void request(long n) {
            if (SubscriptionHelper.validate(n)) {
                BackpressureHelper.add(this, n);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (this.cancelled.compareAndSet(false, true)) {
                completeEvictions();
                if (this.groupCount.decrementAndGet() == 0) {
                    this.upstream.cancel();
                }
            }
        }

        private void completeEvictions() {
            if (this.evictedGroups != null) {
                int i = 0;
                while (true) {
                    GroupedUnicast<K, V> poll = this.evictedGroups.poll();
                    if (poll == null) {
                        break;
                    } else if (poll.state.tryComplete()) {
                        i++;
                    }
                }
                if (i != 0) {
                    this.groupCount.addAndGet(-i);
                }
            }
        }

        public void cancel(K k) {
            if (k == null) {
                k = (K) NULL_KEY;
            }
            if (this.groups.remove(k) == null || this.groupCount.decrementAndGet() != 0) {
                return;
            }
            this.upstream.cancel();
        }

        void requestGroup(long n) {
            long j;
            long addCap;
            AtomicLong atomicLong = this.groupConsumed;
            int i = this.limit;
            do {
                j = atomicLong.get();
                addCap = BackpressureHelper.addCap(j, n);
            } while (!atomicLong.compareAndSet(j, addCap));
            while (true) {
                long j2 = i;
                if (addCap < j2) {
                    return;
                }
                if (atomicLong.compareAndSet(addCap, addCap - j2)) {
                    this.upstream.request(j2);
                }
                addCap = atomicLong.get();
            }
        }
    }

    static final class EvictionAction<K, V> implements Consumer<GroupedUnicast<K, V>> {
        final Queue<GroupedUnicast<K, V>> evictedGroups;

        EvictionAction(Queue<GroupedUnicast<K, V>> evictedGroups) {
            this.evictedGroups = evictedGroups;
        }

        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(GroupedUnicast<K, V> value) {
            this.evictedGroups.offer(value);
        }
    }

    static final class GroupedUnicast<K, T> extends GroupedFlowable<K, T> {
        final State<T, K> state;

        public static <T, K> GroupedUnicast<K, T> createWith(K key, int bufferSize, GroupBySubscriber<?, K, T> parent, boolean delayError) {
            return new GroupedUnicast<>(key, new State(bufferSize, parent, key, delayError));
        }

        protected GroupedUnicast(K key, State<T, K> state) {
            super(key);
            this.state = state;
        }

        @Override // io.reactivex.rxjava3.core.Flowable
        protected void subscribeActual(Subscriber<? super T> s) {
            this.state.subscribe(s);
        }

        public void onNext(T t) {
            this.state.onNext(t);
        }

        public void onError(Throwable e) {
            this.state.onError(e);
        }

        public void onComplete() {
            this.state.onComplete();
        }
    }

    static final class State<T, K> extends BasicIntQueueSubscription<T> implements Publisher<T> {
        static final int ABANDONED = 2;
        static final int ABANDONED_HAS_SUBSCRIBER = 3;
        static final int FRESH = 0;
        static final int HAS_SUBSCRIBER = 1;
        private static final long serialVersionUID = -3852313036005250360L;
        final boolean delayError;
        volatile boolean done;
        Throwable error;
        final K key;
        boolean outputFused;
        final GroupBySubscriber<?, K, T> parent;
        int produced;
        final SpscLinkedArrayQueue<T> queue;
        final AtomicLong requested = new AtomicLong();
        final AtomicBoolean cancelled = new AtomicBoolean();
        final AtomicReference<Subscriber<? super T>> actual = new AtomicReference<>();
        final AtomicInteger once = new AtomicInteger();
        final AtomicBoolean evictOnce = new AtomicBoolean();

        @Override // io.reactivex.rxjava3.internal.fuseable.QueueFuseable
        public int requestFusion(int mode) {
            return 0;
        }

        State(int bufferSize, GroupBySubscriber<?, K, T> parent, K key, boolean delayError) {
            this.queue = new SpscLinkedArrayQueue<>(bufferSize);
            this.parent = parent;
            this.key = key;
            this.delayError = delayError;
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
            if (this.cancelled.compareAndSet(false, true)) {
                cancelParent();
                drain();
            }
        }

        @Override // org.reactivestreams.Publisher
        public void subscribe(Subscriber<? super T> subscriber) {
            int i;
            do {
                i = this.once.get();
                if ((i & 1) == 0) {
                } else {
                    EmptySubscription.error(new IllegalStateException("Only one Subscriber allowed!"), subscriber);
                    return;
                }
            } while (!this.once.compareAndSet(i, i | 1));
            subscriber.onSubscribe(this);
            this.actual.lazySet(subscriber);
            if (this.cancelled.get()) {
                this.actual.lazySet(null);
            } else {
                drain();
            }
        }

        public void onNext(T t) {
            this.queue.offer(t);
            drain();
        }

        public void onError(Throwable e) {
            this.error = e;
            this.done = true;
            drain();
        }

        public void onComplete() {
            this.done = true;
            drain();
        }

        boolean tryComplete() {
            boolean compareAndSet = this.evictOnce.compareAndSet(false, true);
            this.done = true;
            drain();
            return compareAndSet;
        }

        void cancelParent() {
            if ((this.once.get() & 2) == 0 && this.evictOnce.compareAndSet(false, true)) {
                this.parent.cancel(this.key);
            }
        }

        boolean tryAbandon() {
            return this.once.get() == 0 && this.once.compareAndSet(0, 2);
        }

        void drain() {
            if (getAndIncrement() != 0) {
                return;
            }
            if (this.outputFused) {
                drainFused();
            } else {
                drainNormal();
            }
        }

        void drainFused() {
            Throwable th;
            SpscLinkedArrayQueue<T> spscLinkedArrayQueue = this.queue;
            Subscriber<? super T> subscriber = this.actual.get();
            int i = 1;
            while (true) {
                if (subscriber != null) {
                    if (this.cancelled.get()) {
                        return;
                    }
                    boolean z = this.done;
                    if (z && !this.delayError && (th = this.error) != null) {
                        spscLinkedArrayQueue.clear();
                        subscriber.onError(th);
                        return;
                    }
                    subscriber.onNext(null);
                    if (z) {
                        Throwable th2 = this.error;
                        if (th2 != null) {
                            subscriber.onError(th2);
                            return;
                        } else {
                            subscriber.onComplete();
                            return;
                        }
                    }
                }
                i = addAndGet(-i);
                if (i == 0) {
                    return;
                }
                if (subscriber == null) {
                    subscriber = this.actual.get();
                }
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:17:0x0066, code lost:
        
            if (r3 != r16) goto L41;
         */
        /* JADX WARN: Code restructure failed: missing block: B:18:0x0068, code lost:
        
            r21 = r5;
         */
        /* JADX WARN: Code restructure failed: missing block: B:19:0x0079, code lost:
        
            if (checkTerminated(r25.done, r9.isEmpty(), r13, r10, r5, false) == false) goto L42;
         */
        /* JADX WARN: Code restructure failed: missing block: B:21:0x007c, code lost:
        
            r3 = r21;
         */
        /* JADX WARN: Code restructure failed: missing block: B:23:0x0082, code lost:
        
            if (r3 == r23) goto L30;
         */
        /* JADX WARN: Code restructure failed: missing block: B:24:0x0084, code lost:
        
            io.reactivex.rxjava3.internal.util.BackpressureHelper.produced(r25.requested, r3);
            requestParent(r3);
         */
        /* JADX WARN: Code restructure failed: missing block: B:36:0x0012, code lost:
        
            continue;
         */
        /* JADX WARN: Code restructure failed: missing block: B:38:0x007f, code lost:
        
            r3 = r5;
         */
        /* JADX WARN: Code restructure failed: missing block: B:39:0x0012, code lost:
        
            continue;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void drainNormal() {
            /*
                r25 = this;
                r8 = r25
                io.reactivex.rxjava3.internal.queue.SpscLinkedArrayQueue<T> r9 = r8.queue
                boolean r10 = r8.delayError
                java.util.concurrent.atomic.AtomicReference<org.reactivestreams.Subscriber<? super T>> r0 = r8.actual
                java.lang.Object r0 = r0.get()
                org.reactivestreams.Subscriber r0 = (org.reactivestreams.Subscriber) r0
                java.util.concurrent.atomic.AtomicBoolean r11 = r8.cancelled
                r13 = r0
                r14 = 1
            L12:
                boolean r0 = r11.get()
                r15 = 0
                r5 = 0
                if (r0 == 0) goto L20
                r8.cleanupQueue(r5, r15)
                goto L8c
            L20:
                if (r13 == 0) goto L8c
                java.util.concurrent.atomic.AtomicLong r0 = r8.requested
                long r16 = r0.get()
                r3 = r5
            L29:
                int r18 = (r3 > r16 ? 1 : (r3 == r16 ? 0 : -1))
                if (r18 == 0) goto L63
                boolean r1 = r8.done
                java.lang.Object r7 = r9.poll()
                if (r7 != 0) goto L38
                r19 = 1
                goto L3a
            L38:
                r19 = r15
            L3a:
                r20 = r19 ^ 1
                r0 = r25
                r2 = r19
                r21 = r3
                r3 = r13
                r4 = r10
                r23 = r5
                r5 = r21
                r12 = r7
                r7 = r20
                boolean r0 = r0.checkTerminated(r1, r2, r3, r4, r5, r7)
                if (r0 == 0) goto L52
                goto L12
            L52:
                if (r19 == 0) goto L57
                r5 = r21
                goto L66
            L57:
                r13.onNext(r12)
                r0 = 1
                r5 = r21
                long r3 = r5 + r0
                r5 = r23
                goto L29
            L63:
                r23 = r5
                r5 = r3
            L66:
                if (r18 != 0) goto L7f
                boolean r1 = r8.done
                boolean r2 = r9.isEmpty()
                r7 = 0
                r0 = r25
                r3 = r13
                r4 = r10
                r21 = r5
                boolean r0 = r0.checkTerminated(r1, r2, r3, r4, r5, r7)
                if (r0 == 0) goto L7c
                goto L12
            L7c:
                r3 = r21
                goto L80
            L7f:
                r3 = r5
            L80:
                int r0 = (r3 > r23 ? 1 : (r3 == r23 ? 0 : -1))
                if (r0 == 0) goto L8c
                java.util.concurrent.atomic.AtomicLong r0 = r8.requested
                io.reactivex.rxjava3.internal.util.BackpressureHelper.produced(r0, r3)
                r8.requestParent(r3)
            L8c:
                int r0 = -r14
                int r14 = r8.addAndGet(r0)
                if (r14 != 0) goto L94
                return
            L94:
                if (r13 != 0) goto L12
                java.util.concurrent.atomic.AtomicReference<org.reactivestreams.Subscriber<? super T>> r0 = r8.actual
                java.lang.Object r0 = r0.get()
                r13 = r0
                org.reactivestreams.Subscriber r13 = (org.reactivestreams.Subscriber) r13
                goto L12
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.operators.flowable.FlowableGroupBy.State.drainNormal():void");
        }

        void requestParent(long e) {
            if ((this.once.get() & 2) == 0) {
                this.parent.requestGroup(e);
            }
        }

        void cleanupQueue(long emitted, boolean polled) {
            while (this.queue.poll() != null) {
                emitted++;
            }
            replenishParent(emitted, polled);
        }

        void replenishParent(long emitted, boolean polled) {
            if (polled) {
                emitted++;
            }
            if (emitted != 0) {
                requestParent(emitted);
            }
        }

        boolean checkTerminated(boolean d, boolean empty, Subscriber<? super T> a, boolean delayError, long emitted, boolean polled) {
            if (this.cancelled.get()) {
                cleanupQueue(emitted, polled);
                return true;
            }
            if (!d) {
                return false;
            }
            if (delayError) {
                if (!empty) {
                    return false;
                }
                this.cancelled.lazySet(true);
                Throwable th = this.error;
                if (th != null) {
                    a.onError(th);
                } else {
                    a.onComplete();
                    replenishParent(emitted, polled);
                }
                return true;
            }
            Throwable th2 = this.error;
            if (th2 != null) {
                this.queue.clear();
                this.cancelled.lazySet(true);
                a.onError(th2);
                return true;
            }
            if (!empty) {
                return false;
            }
            this.cancelled.lazySet(true);
            a.onComplete();
            replenishParent(emitted, polled);
            return true;
        }

        void tryReplenish() {
            int i = this.produced;
            if (i != 0) {
                this.produced = 0;
                requestParent(i);
            }
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.SimpleQueue
        public T poll() {
            T poll = this.queue.poll();
            if (poll != null) {
                this.produced++;
                return poll;
            }
            tryReplenish();
            return null;
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.SimpleQueue
        public boolean isEmpty() {
            if (this.queue.isEmpty()) {
                tryReplenish();
                return true;
            }
            tryReplenish();
            return false;
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.SimpleQueue
        public void clear() {
            SpscLinkedArrayQueue<T> spscLinkedArrayQueue = this.queue;
            while (spscLinkedArrayQueue.poll() != null) {
                this.produced++;
            }
            tryReplenish();
        }
    }
}
