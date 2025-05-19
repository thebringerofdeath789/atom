package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.flowables.ConnectableFlowable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.fuseable.HasUpstreamPublisher;
import io.reactivex.rxjava3.internal.subscribers.SubscriberResourceWrapper;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.internal.util.NotificationLite;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import io.reactivex.rxjava3.schedulers.Timed;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes4.dex */
public final class FlowableReplay<T> extends ConnectableFlowable<T> implements HasUpstreamPublisher<T> {
    static final Supplier DEFAULT_UNBOUNDED_FACTORY = new DefaultUnboundedFactory();
    final Supplier<? extends ReplayBuffer<T>> bufferFactory;
    final AtomicReference<ReplaySubscriber<T>> current;
    final Publisher<T> onSubscribe;
    final Flowable<T> source;

    interface ReplayBuffer<T> {
        void complete();

        void error(Throwable e);

        void next(T value);

        void replay(InnerSubscription<T> output);
    }

    public static <U, R> Flowable<R> multicastSelector(final Supplier<? extends ConnectableFlowable<U>> connectableFactory, final Function<? super Flowable<U>, ? extends Publisher<R>> selector) {
        return new MulticastFlowable(connectableFactory, selector);
    }

    public static <T> ConnectableFlowable<T> createFrom(Flowable<? extends T> source) {
        return create(source, DEFAULT_UNBOUNDED_FACTORY);
    }

    public static <T> ConnectableFlowable<T> create(Flowable<T> source, final int bufferSize, boolean eagerTruncate) {
        if (bufferSize == Integer.MAX_VALUE) {
            return createFrom(source);
        }
        return create(source, new ReplayBufferSupplier(bufferSize, eagerTruncate));
    }

    public static <T> ConnectableFlowable<T> create(Flowable<T> source, long maxAge, TimeUnit unit, Scheduler scheduler, boolean eagerTruncate) {
        return create(source, maxAge, unit, scheduler, Integer.MAX_VALUE, eagerTruncate);
    }

    public static <T> ConnectableFlowable<T> create(Flowable<T> source, final long maxAge, final TimeUnit unit, final Scheduler scheduler, final int bufferSize, boolean eagerTruncate) {
        return create(source, new ScheduledReplayBufferSupplier(bufferSize, maxAge, unit, scheduler, eagerTruncate));
    }

    static <T> ConnectableFlowable<T> create(Flowable<T> source, final Supplier<? extends ReplayBuffer<T>> bufferFactory) {
        AtomicReference atomicReference = new AtomicReference();
        return RxJavaPlugins.onAssembly((ConnectableFlowable) new FlowableReplay(new ReplayPublisher(atomicReference, bufferFactory), source, atomicReference, bufferFactory));
    }

    private FlowableReplay(Publisher<T> onSubscribe, Flowable<T> source, final AtomicReference<ReplaySubscriber<T>> current, final Supplier<? extends ReplayBuffer<T>> bufferFactory) {
        this.onSubscribe = onSubscribe;
        this.source = source;
        this.current = current;
        this.bufferFactory = bufferFactory;
    }

    @Override // io.reactivex.rxjava3.internal.fuseable.HasUpstreamPublisher
    public Publisher<T> source() {
        return this.source;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    protected void subscribeActual(Subscriber<? super T> s) {
        this.onSubscribe.subscribe(s);
    }

    @Override // io.reactivex.rxjava3.flowables.ConnectableFlowable
    public void reset() {
        ReplaySubscriber<T> replaySubscriber = this.current.get();
        if (replaySubscriber == null || !replaySubscriber.isDisposed()) {
            return;
        }
        this.current.compareAndSet(replaySubscriber, null);
    }

    @Override // io.reactivex.rxjava3.flowables.ConnectableFlowable
    public void connect(Consumer<? super Disposable> connection) {
        ReplaySubscriber<T> replaySubscriber;
        while (true) {
            replaySubscriber = this.current.get();
            if (replaySubscriber != null && !replaySubscriber.isDisposed()) {
                break;
            }
            try {
                ReplaySubscriber<T> replaySubscriber2 = new ReplaySubscriber<>(this.bufferFactory.get(), this.current);
                if (this.current.compareAndSet(replaySubscriber, replaySubscriber2)) {
                    replaySubscriber = replaySubscriber2;
                    break;
                }
            } finally {
                Exceptions.throwIfFatal(th);
                RuntimeException wrapOrThrow = ExceptionHelper.wrapOrThrow(th);
            }
        }
        boolean z = !replaySubscriber.shouldConnect.get() && replaySubscriber.shouldConnect.compareAndSet(false, true);
        try {
            connection.accept(replaySubscriber);
            if (z) {
                this.source.subscribe((FlowableSubscriber) replaySubscriber);
            }
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            if (z) {
                replaySubscriber.shouldConnect.compareAndSet(true, false);
            }
            throw ExceptionHelper.wrapOrThrow(th);
        }
    }

    static final class ReplaySubscriber<T> extends AtomicReference<Subscription> implements FlowableSubscriber<T>, Disposable {
        static final InnerSubscription[] EMPTY = new InnerSubscription[0];
        static final InnerSubscription[] TERMINATED = new InnerSubscription[0];
        private static final long serialVersionUID = 7224554242710036740L;
        final ReplayBuffer<T> buffer;
        final AtomicReference<ReplaySubscriber<T>> current;
        boolean done;
        long requestedFromUpstream;
        final AtomicInteger management = new AtomicInteger();
        final AtomicReference<InnerSubscription<T>[]> subscribers = new AtomicReference<>(EMPTY);
        final AtomicBoolean shouldConnect = new AtomicBoolean();

        ReplaySubscriber(ReplayBuffer<T> buffer, AtomicReference<ReplaySubscriber<T>> current) {
            this.buffer = buffer;
            this.current = current;
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return this.subscribers.get() == TERMINATED;
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            this.subscribers.set(TERMINATED);
            this.current.compareAndSet(this, null);
            SubscriptionHelper.cancel(this);
        }

        boolean add(InnerSubscription<T> producer) {
            InnerSubscription<T>[] innerSubscriptionArr;
            InnerSubscription<T>[] innerSubscriptionArr2;
            do {
                innerSubscriptionArr = this.subscribers.get();
                if (innerSubscriptionArr == TERMINATED) {
                    return false;
                }
                int length = innerSubscriptionArr.length;
                innerSubscriptionArr2 = new InnerSubscription[length + 1];
                System.arraycopy(innerSubscriptionArr, 0, innerSubscriptionArr2, 0, length);
                innerSubscriptionArr2[length] = producer;
            } while (!this.subscribers.compareAndSet(innerSubscriptionArr, innerSubscriptionArr2));
            return true;
        }

        void remove(InnerSubscription<T> p) {
            InnerSubscription<T>[] innerSubscriptionArr;
            InnerSubscription<T>[] innerSubscriptionArr2;
            do {
                innerSubscriptionArr = this.subscribers.get();
                int length = innerSubscriptionArr.length;
                if (length == 0) {
                    return;
                }
                int i = -1;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    }
                    if (innerSubscriptionArr[i2].equals(p)) {
                        i = i2;
                        break;
                    }
                    i2++;
                }
                if (i < 0) {
                    return;
                }
                if (length == 1) {
                    innerSubscriptionArr2 = EMPTY;
                } else {
                    InnerSubscription<T>[] innerSubscriptionArr3 = new InnerSubscription[length - 1];
                    System.arraycopy(innerSubscriptionArr, 0, innerSubscriptionArr3, 0, i);
                    System.arraycopy(innerSubscriptionArr, i + 1, innerSubscriptionArr3, i, (length - i) - 1);
                    innerSubscriptionArr2 = innerSubscriptionArr3;
                }
            } while (!this.subscribers.compareAndSet(innerSubscriptionArr, innerSubscriptionArr2));
        }

        @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription p) {
            if (SubscriptionHelper.setOnce(this, p)) {
                manageRequests();
                for (InnerSubscription<T> innerSubscription : this.subscribers.get()) {
                    this.buffer.replay(innerSubscription);
                }
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            this.buffer.next(t);
            for (InnerSubscription<T> innerSubscription : this.subscribers.get()) {
                this.buffer.replay(innerSubscription);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable e) {
            if (!this.done) {
                this.done = true;
                this.buffer.error(e);
                for (InnerSubscription<T> innerSubscription : this.subscribers.getAndSet(TERMINATED)) {
                    this.buffer.replay(innerSubscription);
                }
                return;
            }
            RxJavaPlugins.onError(e);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            this.buffer.complete();
            for (InnerSubscription<T> innerSubscription : this.subscribers.getAndSet(TERMINATED)) {
                this.buffer.replay(innerSubscription);
            }
        }

        void manageRequests() {
            AtomicInteger atomicInteger = this.management;
            if (atomicInteger.getAndIncrement() != 0) {
                return;
            }
            int i = 1;
            while (!isDisposed()) {
                Subscription subscription = get();
                if (subscription != null) {
                    long j = this.requestedFromUpstream;
                    long j2 = j;
                    for (InnerSubscription<T> innerSubscription : this.subscribers.get()) {
                        j2 = Math.max(j2, innerSubscription.totalRequested.get());
                    }
                    long j3 = j2 - j;
                    if (j3 != 0) {
                        this.requestedFromUpstream = j2;
                        subscription.request(j3);
                    }
                }
                i = atomicInteger.addAndGet(-i);
                if (i == 0) {
                    return;
                }
            }
        }
    }

    static final class InnerSubscription<T> extends AtomicLong implements Subscription, Disposable {
        static final long CANCELLED = Long.MIN_VALUE;
        private static final long serialVersionUID = -4453897557930727610L;
        final Subscriber<? super T> child;
        boolean emitting;
        Object index;
        boolean missed;
        final ReplaySubscriber<T> parent;
        final AtomicLong totalRequested = new AtomicLong();

        InnerSubscription(ReplaySubscriber<T> parent, Subscriber<? super T> child) {
            this.parent = parent;
            this.child = child;
        }

        @Override // org.reactivestreams.Subscription
        public void request(long n) {
            if (!SubscriptionHelper.validate(n) || BackpressureHelper.addCancel(this, n) == Long.MIN_VALUE) {
                return;
            }
            BackpressureHelper.add(this.totalRequested, n);
            this.parent.manageRequests();
            this.parent.buffer.replay(this);
        }

        public long produced(long n) {
            return BackpressureHelper.producedCancel(this, n);
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return get() == Long.MIN_VALUE;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            dispose();
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            if (getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) {
                this.parent.remove(this);
                this.parent.manageRequests();
                this.index = null;
            }
        }

        <U> U index() {
            return (U) this.index;
        }
    }

    static final class UnboundedReplayBuffer<T> extends ArrayList<Object> implements ReplayBuffer<T> {
        private static final long serialVersionUID = 7063189396499112664L;
        volatile int size;

        UnboundedReplayBuffer(int capacityHint) {
            super(capacityHint);
        }

        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay.ReplayBuffer
        public void next(T value) {
            add(NotificationLite.next(value));
            this.size++;
        }

        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay.ReplayBuffer
        public void error(Throwable e) {
            add(NotificationLite.error(e));
            this.size++;
        }

        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay.ReplayBuffer
        public void complete() {
            add(NotificationLite.complete());
            this.size++;
        }

        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay.ReplayBuffer
        public void replay(InnerSubscription<T> output) {
            synchronized (output) {
                if (output.emitting) {
                    output.missed = true;
                    return;
                }
                output.emitting = true;
                Subscriber<? super T> subscriber = output.child;
                while (!output.isDisposed()) {
                    int i = this.size;
                    Integer num = (Integer) output.index();
                    int intValue = num != null ? num.intValue() : 0;
                    long j = output.get();
                    long j2 = j;
                    long j3 = 0;
                    while (j2 != 0 && intValue < i) {
                        Object obj = get(intValue);
                        try {
                            if (NotificationLite.accept(obj, subscriber) || output.isDisposed()) {
                                return;
                            }
                            intValue++;
                            j2--;
                            j3++;
                        } catch (Throwable th) {
                            Exceptions.throwIfFatal(th);
                            output.dispose();
                            if (!NotificationLite.isError(obj) && !NotificationLite.isComplete(obj)) {
                                subscriber.onError(th);
                                return;
                            } else {
                                RxJavaPlugins.onError(th);
                                return;
                            }
                        }
                    }
                    if (j3 != 0) {
                        output.index = Integer.valueOf(intValue);
                        if (j != Long.MAX_VALUE) {
                            output.produced(j3);
                        }
                    }
                    synchronized (output) {
                        if (!output.missed) {
                            output.emitting = false;
                            return;
                        }
                        output.missed = false;
                    }
                }
            }
        }
    }

    static final class Node extends AtomicReference<Node> {
        private static final long serialVersionUID = 245354315435971818L;
        final long index;
        final Object value;

        Node(Object value, long index) {
            this.value = value;
            this.index = index;
        }
    }

    static abstract class BoundedReplayBuffer<T> extends AtomicReference<Node> implements ReplayBuffer<T> {
        private static final long serialVersionUID = 2346567790059478686L;
        final boolean eagerTruncate;
        long index;
        int size;
        Node tail;

        Object enterTransform(Object value, boolean terminal) {
            return value;
        }

        Object leaveTransform(Object value) {
            return value;
        }

        abstract void truncate();

        BoundedReplayBuffer(boolean eagerTruncate) {
            this.eagerTruncate = eagerTruncate;
            Node node = new Node(null, 0L);
            this.tail = node;
            set(node);
        }

        final void addLast(Node n) {
            this.tail.set(n);
            this.tail = n;
            this.size++;
        }

        final void removeFirst() {
            Node node = get().get();
            if (node == null) {
                throw new IllegalStateException("Empty list!");
            }
            this.size--;
            setFirst(node);
        }

        final void removeSome(int n) {
            Node node = get();
            while (n > 0) {
                node = node.get();
                n--;
                this.size--;
            }
            setFirst(node);
            Node node2 = get();
            if (node2.get() == null) {
                this.tail = node2;
            }
        }

        final void setFirst(Node n) {
            if (this.eagerTruncate) {
                Node node = new Node(null, n.index);
                node.lazySet(n.get());
                n = node;
            }
            set(n);
        }

        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay.ReplayBuffer
        public final void next(T value) {
            Object enterTransform = enterTransform(NotificationLite.next(value), false);
            long j = this.index + 1;
            this.index = j;
            addLast(new Node(enterTransform, j));
            truncate();
        }

        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay.ReplayBuffer
        public final void error(Throwable e) {
            Object enterTransform = enterTransform(NotificationLite.error(e), true);
            long j = this.index + 1;
            this.index = j;
            addLast(new Node(enterTransform, j));
            truncateFinal();
        }

        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay.ReplayBuffer
        public final void complete() {
            Object enterTransform = enterTransform(NotificationLite.complete(), true);
            long j = this.index + 1;
            this.index = j;
            addLast(new Node(enterTransform, j));
            truncateFinal();
        }

        final void trimHead() {
            Node node = get();
            if (node.value != null) {
                Node node2 = new Node(null, 0L);
                node2.lazySet(node.get());
                set(node2);
            }
        }

        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay.ReplayBuffer
        public final void replay(InnerSubscription<T> output) {
            synchronized (output) {
                if (output.emitting) {
                    output.missed = true;
                    return;
                }
                output.emitting = true;
                while (true) {
                    long j = output.get();
                    boolean z = j == Long.MAX_VALUE;
                    Node node = (Node) output.index();
                    if (node == null) {
                        node = getHead();
                        output.index = node;
                        BackpressureHelper.add(output.totalRequested, node.index);
                    }
                    long j2 = 0;
                    while (j != 0) {
                        if (output.isDisposed()) {
                            output.index = null;
                            return;
                        }
                        Node node2 = node.get();
                        if (node2 == null) {
                            break;
                        }
                        Object leaveTransform = leaveTransform(node2.value);
                        try {
                            if (NotificationLite.accept(leaveTransform, output.child)) {
                                output.index = null;
                                return;
                            } else {
                                j2++;
                                j--;
                                node = node2;
                            }
                        } catch (Throwable th) {
                            Exceptions.throwIfFatal(th);
                            output.index = null;
                            output.dispose();
                            if (!NotificationLite.isError(leaveTransform) && !NotificationLite.isComplete(leaveTransform)) {
                                output.child.onError(th);
                                return;
                            } else {
                                RxJavaPlugins.onError(th);
                                return;
                            }
                        }
                    }
                    if (j == 0 && output.isDisposed()) {
                        output.index = null;
                        return;
                    }
                    if (j2 != 0) {
                        output.index = node;
                        if (!z) {
                            output.produced(j2);
                        }
                    }
                    synchronized (output) {
                        if (!output.missed) {
                            output.emitting = false;
                            return;
                        }
                        output.missed = false;
                    }
                }
            }
        }

        void truncateFinal() {
            trimHead();
        }

        final void collect(Collection<? super T> collection) {
            Node head = getHead();
            while (true) {
                head = head.get();
                if (head == null) {
                    return;
                }
                Object leaveTransform = leaveTransform(head.value);
                if (NotificationLite.isComplete(leaveTransform) || NotificationLite.isError(leaveTransform)) {
                    return;
                } else {
                    collection.add((Object) NotificationLite.getValue(leaveTransform));
                }
            }
        }

        boolean hasError() {
            return this.tail.value != null && NotificationLite.isError(leaveTransform(this.tail.value));
        }

        boolean hasCompleted() {
            return this.tail.value != null && NotificationLite.isComplete(leaveTransform(this.tail.value));
        }

        Node getHead() {
            return get();
        }
    }

    static final class SizeBoundReplayBuffer<T> extends BoundedReplayBuffer<T> {
        private static final long serialVersionUID = -5898283885385201806L;
        final int limit;

        SizeBoundReplayBuffer(int limit, boolean eagerTruncate) {
            super(eagerTruncate);
            this.limit = limit;
        }

        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay.BoundedReplayBuffer
        void truncate() {
            if (this.size > this.limit) {
                removeFirst();
            }
        }
    }

    static final class SizeAndTimeBoundReplayBuffer<T> extends BoundedReplayBuffer<T> {
        private static final long serialVersionUID = 3457957419649567404L;
        final int limit;
        final long maxAge;
        final Scheduler scheduler;
        final TimeUnit unit;

        SizeAndTimeBoundReplayBuffer(int limit, long maxAge, TimeUnit unit, Scheduler scheduler, boolean eagerTruncate) {
            super(eagerTruncate);
            this.scheduler = scheduler;
            this.limit = limit;
            this.maxAge = maxAge;
            this.unit = unit;
        }

        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay.BoundedReplayBuffer
        Object enterTransform(Object value, boolean terminal) {
            return new Timed(value, terminal ? Long.MAX_VALUE : this.scheduler.now(this.unit), this.unit);
        }

        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay.BoundedReplayBuffer
        Object leaveTransform(Object value) {
            return ((Timed) value).value();
        }

        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay.BoundedReplayBuffer
        void truncate() {
            Node node;
            long now = this.scheduler.now(this.unit) - this.maxAge;
            Node node2 = (Node) get();
            Node node3 = node2.get();
            int i = 0;
            while (true) {
                Node node4 = node3;
                node = node2;
                node2 = node4;
                if (this.size > 1) {
                    if (this.size <= this.limit) {
                        if (((Timed) node2.value).time() > now) {
                            break;
                        }
                        i++;
                        this.size--;
                        node3 = node2.get();
                    } else {
                        i++;
                        this.size--;
                        node3 = node2.get();
                    }
                } else {
                    break;
                }
            }
            if (i != 0) {
                setFirst(node);
            }
        }

        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay.BoundedReplayBuffer
        void truncateFinal() {
            Node node;
            long now = this.scheduler.now(this.unit) - this.maxAge;
            Node node2 = (Node) get();
            Node node3 = node2.get();
            int i = 0;
            while (true) {
                Node node4 = node3;
                node = node2;
                node2 = node4;
                if (this.size <= 1 || ((Timed) node2.value).time() > now) {
                    break;
                }
                i++;
                this.size--;
                node3 = node2.get();
            }
            if (i != 0) {
                setFirst(node);
            }
        }

        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay.BoundedReplayBuffer
        Node getHead() {
            Node node;
            long now = this.scheduler.now(this.unit) - this.maxAge;
            Node node2 = (Node) get();
            Node node3 = node2.get();
            while (true) {
                Node node4 = node3;
                node = node2;
                node2 = node4;
                if (node2 != null) {
                    Timed timed = (Timed) node2.value;
                    if (NotificationLite.isComplete(timed.value()) || NotificationLite.isError(timed.value()) || timed.time() > now) {
                        break;
                    }
                    node3 = node2.get();
                } else {
                    break;
                }
            }
            return node;
        }
    }

    static final class MulticastFlowable<R, U> extends Flowable<R> {
        private final Supplier<? extends ConnectableFlowable<U>> connectableFactory;
        private final Function<? super Flowable<U>, ? extends Publisher<R>> selector;

        MulticastFlowable(Supplier<? extends ConnectableFlowable<U>> connectableFactory, Function<? super Flowable<U>, ? extends Publisher<R>> selector) {
            this.connectableFactory = connectableFactory;
            this.selector = selector;
        }

        @Override // io.reactivex.rxjava3.core.Flowable
        protected void subscribeActual(Subscriber<? super R> child) {
            try {
                ConnectableFlowable connectableFlowable = (ConnectableFlowable) ExceptionHelper.nullCheck(this.connectableFactory.get(), "The connectableFactory returned a null ConnectableFlowable.");
                try {
                    Publisher publisher = (Publisher) ExceptionHelper.nullCheck(this.selector.apply(connectableFlowable), "The selector returned a null Publisher.");
                    SubscriberResourceWrapper subscriberResourceWrapper = new SubscriberResourceWrapper(child);
                    publisher.subscribe(subscriberResourceWrapper);
                    connectableFlowable.connect(new DisposableConsumer(subscriberResourceWrapper));
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    EmptySubscription.error(th, child);
                }
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                EmptySubscription.error(th2, child);
            }
        }

        final class DisposableConsumer implements Consumer<Disposable> {
            private final SubscriberResourceWrapper<R> srw;

            DisposableConsumer(SubscriberResourceWrapper<R> srw) {
                this.srw = srw;
            }

            @Override // io.reactivex.rxjava3.functions.Consumer
            public void accept(Disposable r) {
                this.srw.setResource(r);
            }
        }
    }

    static final class ReplayBufferSupplier<T> implements Supplier<ReplayBuffer<T>> {
        final int bufferSize;
        final boolean eagerTruncate;

        ReplayBufferSupplier(int bufferSize, boolean eagerTruncate) {
            this.bufferSize = bufferSize;
            this.eagerTruncate = eagerTruncate;
        }

        @Override // io.reactivex.rxjava3.functions.Supplier
        public ReplayBuffer<T> get() {
            return new SizeBoundReplayBuffer(this.bufferSize, this.eagerTruncate);
        }
    }

    static final class ScheduledReplayBufferSupplier<T> implements Supplier<ReplayBuffer<T>> {
        private final int bufferSize;
        final boolean eagerTruncate;
        private final long maxAge;
        private final Scheduler scheduler;
        private final TimeUnit unit;

        ScheduledReplayBufferSupplier(int bufferSize, long maxAge, TimeUnit unit, Scheduler scheduler, boolean eagerTruncate) {
            this.bufferSize = bufferSize;
            this.maxAge = maxAge;
            this.unit = unit;
            this.scheduler = scheduler;
            this.eagerTruncate = eagerTruncate;
        }

        @Override // io.reactivex.rxjava3.functions.Supplier
        public ReplayBuffer<T> get() {
            return new SizeAndTimeBoundReplayBuffer(this.bufferSize, this.maxAge, this.unit, this.scheduler, this.eagerTruncate);
        }
    }

    static final class ReplayPublisher<T> implements Publisher<T> {
        private final Supplier<? extends ReplayBuffer<T>> bufferFactory;
        private final AtomicReference<ReplaySubscriber<T>> curr;

        ReplayPublisher(AtomicReference<ReplaySubscriber<T>> curr, Supplier<? extends ReplayBuffer<T>> bufferFactory) {
            this.curr = curr;
            this.bufferFactory = bufferFactory;
        }

        @Override // org.reactivestreams.Publisher
        public void subscribe(Subscriber<? super T> child) {
            ReplaySubscriber<T> replaySubscriber;
            while (true) {
                replaySubscriber = this.curr.get();
                if (replaySubscriber != null) {
                    break;
                }
                try {
                    ReplaySubscriber<T> replaySubscriber2 = new ReplaySubscriber<>(this.bufferFactory.get(), this.curr);
                    if (this.curr.compareAndSet(null, replaySubscriber2)) {
                        replaySubscriber = replaySubscriber2;
                        break;
                    }
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    EmptySubscription.error(th, child);
                    return;
                }
            }
            InnerSubscription<T> innerSubscription = new InnerSubscription<>(replaySubscriber, child);
            child.onSubscribe(innerSubscription);
            replaySubscriber.add(innerSubscription);
            if (innerSubscription.isDisposed()) {
                replaySubscriber.remove(innerSubscription);
            } else {
                replaySubscriber.manageRequests();
                replaySubscriber.buffer.replay(innerSubscription);
            }
        }
    }

    static final class DefaultUnboundedFactory implements Supplier<Object> {
        DefaultUnboundedFactory() {
        }

        @Override // io.reactivex.rxjava3.functions.Supplier
        public Object get() {
            return new UnboundedReplayBuffer(16);
        }
    }
}
