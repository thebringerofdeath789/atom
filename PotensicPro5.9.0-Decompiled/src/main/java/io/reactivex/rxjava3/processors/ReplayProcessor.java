package io.reactivex.rxjava3.processors;

import io.reactivex.rxjava3.annotations.CheckReturnValue;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.internal.functions.ObjectHelper;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes4.dex */
public final class ReplayProcessor<T> extends FlowableProcessor<T> {
    final ReplayBuffer<T> buffer;
    boolean done;
    final AtomicReference<ReplaySubscription<T>[]> subscribers = new AtomicReference<>(EMPTY);
    private static final Object[] EMPTY_ARRAY = new Object[0];
    static final ReplaySubscription[] EMPTY = new ReplaySubscription[0];
    static final ReplaySubscription[] TERMINATED = new ReplaySubscription[0];

    interface ReplayBuffer<T> {
        void complete();

        void error(Throwable ex);

        Throwable getError();

        T getValue();

        T[] getValues(T[] array);

        boolean isDone();

        void next(T value);

        void replay(ReplaySubscription<T> rs);

        int size();

        void trimHead();
    }

    @CheckReturnValue
    public static <T> ReplayProcessor<T> create() {
        return new ReplayProcessor<>(new UnboundedReplayBuffer(16));
    }

    @CheckReturnValue
    public static <T> ReplayProcessor<T> create(int capacityHint) {
        ObjectHelper.verifyPositive(capacityHint, "capacityHint");
        return new ReplayProcessor<>(new UnboundedReplayBuffer(capacityHint));
    }

    @CheckReturnValue
    public static <T> ReplayProcessor<T> createWithSize(int maxSize) {
        ObjectHelper.verifyPositive(maxSize, "maxSize");
        return new ReplayProcessor<>(new SizeBoundReplayBuffer(maxSize));
    }

    @CheckReturnValue
    static <T> ReplayProcessor<T> createUnbounded() {
        return new ReplayProcessor<>(new SizeBoundReplayBuffer(Integer.MAX_VALUE));
    }

    @CheckReturnValue
    public static <T> ReplayProcessor<T> createWithTime(long maxAge, TimeUnit unit, Scheduler scheduler) {
        ObjectHelper.verifyPositive(maxAge, "maxAge");
        Objects.requireNonNull(unit, "unit is null");
        Objects.requireNonNull(scheduler, "scheduler is null");
        return new ReplayProcessor<>(new SizeAndTimeBoundReplayBuffer(Integer.MAX_VALUE, maxAge, unit, scheduler));
    }

    @CheckReturnValue
    public static <T> ReplayProcessor<T> createWithTimeAndSize(long maxAge, TimeUnit unit, Scheduler scheduler, int maxSize) {
        ObjectHelper.verifyPositive(maxSize, "maxSize");
        ObjectHelper.verifyPositive(maxAge, "maxAge");
        Objects.requireNonNull(unit, "unit is null");
        Objects.requireNonNull(scheduler, "scheduler is null");
        return new ReplayProcessor<>(new SizeAndTimeBoundReplayBuffer(maxSize, maxAge, unit, scheduler));
    }

    ReplayProcessor(ReplayBuffer<T> buffer) {
        this.buffer = buffer;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    protected void subscribeActual(Subscriber<? super T> s) {
        ReplaySubscription<T> replaySubscription = new ReplaySubscription<>(s, this);
        s.onSubscribe(replaySubscription);
        if (add(replaySubscription) && replaySubscription.cancelled) {
            remove(replaySubscription);
        } else {
            this.buffer.replay(replaySubscription);
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onSubscribe(Subscription s) {
        if (this.done) {
            s.cancel();
        } else {
            s.request(Long.MAX_VALUE);
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T t) {
        ExceptionHelper.nullCheck(t, "onNext called with a null value.");
        if (this.done) {
            return;
        }
        ReplayBuffer<T> replayBuffer = this.buffer;
        replayBuffer.next(t);
        for (ReplaySubscription<T> replaySubscription : this.subscribers.get()) {
            replayBuffer.replay(replaySubscription);
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable t) {
        ExceptionHelper.nullCheck(t, "onError called with a null Throwable.");
        if (this.done) {
            RxJavaPlugins.onError(t);
            return;
        }
        this.done = true;
        ReplayBuffer<T> replayBuffer = this.buffer;
        replayBuffer.error(t);
        for (ReplaySubscription<T> replaySubscription : this.subscribers.getAndSet(TERMINATED)) {
            replayBuffer.replay(replaySubscription);
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        if (this.done) {
            return;
        }
        this.done = true;
        ReplayBuffer<T> replayBuffer = this.buffer;
        replayBuffer.complete();
        for (ReplaySubscription<T> replaySubscription : this.subscribers.getAndSet(TERMINATED)) {
            replayBuffer.replay(replaySubscription);
        }
    }

    @Override // io.reactivex.rxjava3.processors.FlowableProcessor
    @CheckReturnValue
    public boolean hasSubscribers() {
        return this.subscribers.get().length != 0;
    }

    @CheckReturnValue
    int subscriberCount() {
        return this.subscribers.get().length;
    }

    @Override // io.reactivex.rxjava3.processors.FlowableProcessor
    @CheckReturnValue
    public Throwable getThrowable() {
        ReplayBuffer<T> replayBuffer = this.buffer;
        if (replayBuffer.isDone()) {
            return replayBuffer.getError();
        }
        return null;
    }

    public void cleanupBuffer() {
        this.buffer.trimHead();
    }

    @CheckReturnValue
    public T getValue() {
        return this.buffer.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @CheckReturnValue
    public Object[] getValues() {
        Object[] objArr = EMPTY_ARRAY;
        Object[] values = getValues(objArr);
        return values == objArr ? new Object[0] : values;
    }

    @CheckReturnValue
    public T[] getValues(T[] array) {
        return this.buffer.getValues(array);
    }

    @Override // io.reactivex.rxjava3.processors.FlowableProcessor
    @CheckReturnValue
    public boolean hasComplete() {
        ReplayBuffer<T> replayBuffer = this.buffer;
        return replayBuffer.isDone() && replayBuffer.getError() == null;
    }

    @Override // io.reactivex.rxjava3.processors.FlowableProcessor
    @CheckReturnValue
    public boolean hasThrowable() {
        ReplayBuffer<T> replayBuffer = this.buffer;
        return replayBuffer.isDone() && replayBuffer.getError() != null;
    }

    @CheckReturnValue
    public boolean hasValue() {
        return this.buffer.size() != 0;
    }

    @CheckReturnValue
    int size() {
        return this.buffer.size();
    }

    boolean add(ReplaySubscription<T> rs) {
        ReplaySubscription<T>[] replaySubscriptionArr;
        ReplaySubscription<T>[] replaySubscriptionArr2;
        do {
            replaySubscriptionArr = this.subscribers.get();
            if (replaySubscriptionArr == TERMINATED) {
                return false;
            }
            int length = replaySubscriptionArr.length;
            replaySubscriptionArr2 = new ReplaySubscription[length + 1];
            System.arraycopy(replaySubscriptionArr, 0, replaySubscriptionArr2, 0, length);
            replaySubscriptionArr2[length] = rs;
        } while (!this.subscribers.compareAndSet(replaySubscriptionArr, replaySubscriptionArr2));
        return true;
    }

    void remove(ReplaySubscription<T> rs) {
        ReplaySubscription<T>[] replaySubscriptionArr;
        ReplaySubscription<T>[] replaySubscriptionArr2;
        do {
            replaySubscriptionArr = this.subscribers.get();
            if (replaySubscriptionArr == TERMINATED || replaySubscriptionArr == EMPTY) {
                return;
            }
            int length = replaySubscriptionArr.length;
            int i = -1;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                }
                if (replaySubscriptionArr[i2] == rs) {
                    i = i2;
                    break;
                }
                i2++;
            }
            if (i < 0) {
                return;
            }
            if (length == 1) {
                replaySubscriptionArr2 = EMPTY;
            } else {
                ReplaySubscription<T>[] replaySubscriptionArr3 = new ReplaySubscription[length - 1];
                System.arraycopy(replaySubscriptionArr, 0, replaySubscriptionArr3, 0, i);
                System.arraycopy(replaySubscriptionArr, i + 1, replaySubscriptionArr3, i, (length - i) - 1);
                replaySubscriptionArr2 = replaySubscriptionArr3;
            }
        } while (!this.subscribers.compareAndSet(replaySubscriptionArr, replaySubscriptionArr2));
    }

    static final class ReplaySubscription<T> extends AtomicInteger implements Subscription {
        private static final long serialVersionUID = 466549804534799122L;
        volatile boolean cancelled;
        final Subscriber<? super T> downstream;
        long emitted;
        Object index;
        final AtomicLong requested = new AtomicLong();
        final ReplayProcessor<T> state;

        ReplaySubscription(Subscriber<? super T> actual, ReplayProcessor<T> state) {
            this.downstream = actual;
            this.state = state;
        }

        @Override // org.reactivestreams.Subscription
        public void request(long n) {
            if (SubscriptionHelper.validate(n)) {
                BackpressureHelper.add(this.requested, n);
                this.state.buffer.replay(this);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.state.remove(this);
        }
    }

    static final class UnboundedReplayBuffer<T> implements ReplayBuffer<T> {
        final List<T> buffer;
        volatile boolean done;
        Throwable error;
        volatile int size;

        @Override // io.reactivex.rxjava3.processors.ReplayProcessor.ReplayBuffer
        public void trimHead() {
        }

        UnboundedReplayBuffer(int capacityHint) {
            this.buffer = new ArrayList(capacityHint);
        }

        @Override // io.reactivex.rxjava3.processors.ReplayProcessor.ReplayBuffer
        public void next(T value) {
            this.buffer.add(value);
            this.size++;
        }

        @Override // io.reactivex.rxjava3.processors.ReplayProcessor.ReplayBuffer
        public void error(Throwable ex) {
            this.error = ex;
            this.done = true;
        }

        @Override // io.reactivex.rxjava3.processors.ReplayProcessor.ReplayBuffer
        public void complete() {
            this.done = true;
        }

        @Override // io.reactivex.rxjava3.processors.ReplayProcessor.ReplayBuffer
        public T getValue() {
            int i = this.size;
            if (i == 0) {
                return null;
            }
            return this.buffer.get(i - 1);
        }

        @Override // io.reactivex.rxjava3.processors.ReplayProcessor.ReplayBuffer
        public T[] getValues(T[] tArr) {
            int i = this.size;
            if (i == 0) {
                if (tArr.length != 0) {
                    tArr[0] = null;
                }
                return tArr;
            }
            List<T> list = this.buffer;
            if (tArr.length < i) {
                tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), i));
            }
            for (int i2 = 0; i2 < i; i2++) {
                tArr[i2] = list.get(i2);
            }
            if (tArr.length > i) {
                tArr[i] = null;
            }
            return tArr;
        }

        @Override // io.reactivex.rxjava3.processors.ReplayProcessor.ReplayBuffer
        public void replay(ReplaySubscription<T> rs) {
            if (rs.getAndIncrement() != 0) {
                return;
            }
            List<T> list = this.buffer;
            Subscriber<? super T> subscriber = rs.downstream;
            Integer num = (Integer) rs.index;
            int i = 0;
            if (num != null) {
                i = num.intValue();
            } else {
                rs.index = 0;
            }
            long j = rs.emitted;
            int i2 = 1;
            do {
                long j2 = rs.requested.get();
                while (j != j2) {
                    if (rs.cancelled) {
                        rs.index = null;
                        return;
                    }
                    boolean z = this.done;
                    int i3 = this.size;
                    if (z && i == i3) {
                        rs.index = null;
                        rs.cancelled = true;
                        Throwable th = this.error;
                        if (th == null) {
                            subscriber.onComplete();
                            return;
                        } else {
                            subscriber.onError(th);
                            return;
                        }
                    }
                    if (i == i3) {
                        break;
                    }
                    subscriber.onNext(list.get(i));
                    i++;
                    j++;
                }
                if (j == j2) {
                    if (rs.cancelled) {
                        rs.index = null;
                        return;
                    }
                    boolean z2 = this.done;
                    int i4 = this.size;
                    if (z2 && i == i4) {
                        rs.index = null;
                        rs.cancelled = true;
                        Throwable th2 = this.error;
                        if (th2 == null) {
                            subscriber.onComplete();
                            return;
                        } else {
                            subscriber.onError(th2);
                            return;
                        }
                    }
                }
                rs.index = Integer.valueOf(i);
                rs.emitted = j;
                i2 = rs.addAndGet(-i2);
            } while (i2 != 0);
        }

        @Override // io.reactivex.rxjava3.processors.ReplayProcessor.ReplayBuffer
        public int size() {
            return this.size;
        }

        @Override // io.reactivex.rxjava3.processors.ReplayProcessor.ReplayBuffer
        public boolean isDone() {
            return this.done;
        }

        @Override // io.reactivex.rxjava3.processors.ReplayProcessor.ReplayBuffer
        public Throwable getError() {
            return this.error;
        }
    }

    static final class Node<T> extends AtomicReference<Node<T>> {
        private static final long serialVersionUID = 6404226426336033100L;
        final T value;

        Node(T value) {
            this.value = value;
        }
    }

    static final class TimedNode<T> extends AtomicReference<TimedNode<T>> {
        private static final long serialVersionUID = 6404226426336033100L;
        final long time;
        final T value;

        TimedNode(T value, long time) {
            this.value = value;
            this.time = time;
        }
    }

    static final class SizeBoundReplayBuffer<T> implements ReplayBuffer<T> {
        volatile boolean done;
        Throwable error;
        volatile Node<T> head;
        final int maxSize;
        int size;
        Node<T> tail;

        SizeBoundReplayBuffer(int maxSize) {
            this.maxSize = maxSize;
            Node<T> node = new Node<>(null);
            this.tail = node;
            this.head = node;
        }

        void trim() {
            int i = this.size;
            if (i > this.maxSize) {
                this.size = i - 1;
                this.head = this.head.get();
            }
        }

        @Override // io.reactivex.rxjava3.processors.ReplayProcessor.ReplayBuffer
        public void next(T value) {
            Node<T> node = new Node<>(value);
            Node<T> node2 = this.tail;
            this.tail = node;
            this.size++;
            node2.set(node);
            trim();
        }

        @Override // io.reactivex.rxjava3.processors.ReplayProcessor.ReplayBuffer
        public void error(Throwable ex) {
            this.error = ex;
            trimHead();
            this.done = true;
        }

        @Override // io.reactivex.rxjava3.processors.ReplayProcessor.ReplayBuffer
        public void complete() {
            trimHead();
            this.done = true;
        }

        @Override // io.reactivex.rxjava3.processors.ReplayProcessor.ReplayBuffer
        public void trimHead() {
            if (this.head.value != null) {
                Node<T> node = new Node<>(null);
                node.lazySet(this.head.get());
                this.head = node;
            }
        }

        @Override // io.reactivex.rxjava3.processors.ReplayProcessor.ReplayBuffer
        public boolean isDone() {
            return this.done;
        }

        @Override // io.reactivex.rxjava3.processors.ReplayProcessor.ReplayBuffer
        public Throwable getError() {
            return this.error;
        }

        @Override // io.reactivex.rxjava3.processors.ReplayProcessor.ReplayBuffer
        public T getValue() {
            Node<T> node = this.head;
            while (true) {
                Node<T> node2 = node.get();
                if (node2 == null) {
                    return node.value;
                }
                node = node2;
            }
        }

        @Override // io.reactivex.rxjava3.processors.ReplayProcessor.ReplayBuffer
        public T[] getValues(T[] tArr) {
            Node<T> node = this.head;
            Node<T> node2 = node;
            int i = 0;
            while (true) {
                node2 = node2.get();
                if (node2 == null) {
                    break;
                }
                i++;
            }
            if (tArr.length < i) {
                tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), i));
            }
            for (int i2 = 0; i2 < i; i2++) {
                node = node.get();
                tArr[i2] = node.value;
            }
            if (tArr.length > i) {
                tArr[i] = null;
            }
            return tArr;
        }

        @Override // io.reactivex.rxjava3.processors.ReplayProcessor.ReplayBuffer
        public void replay(ReplaySubscription<T> replaySubscription) {
            if (replaySubscription.getAndIncrement() != 0) {
                return;
            }
            Subscriber<? super T> subscriber = replaySubscription.downstream;
            Node<T> node = (Node) replaySubscription.index;
            if (node == null) {
                node = this.head;
            }
            long j = replaySubscription.emitted;
            int i = 1;
            do {
                long j2 = replaySubscription.requested.get();
                while (j != j2) {
                    if (replaySubscription.cancelled) {
                        replaySubscription.index = null;
                        return;
                    }
                    boolean z = this.done;
                    Node<T> node2 = node.get();
                    boolean z2 = node2 == null;
                    if (z && z2) {
                        replaySubscription.index = null;
                        replaySubscription.cancelled = true;
                        Throwable th = this.error;
                        if (th == null) {
                            subscriber.onComplete();
                            return;
                        } else {
                            subscriber.onError(th);
                            return;
                        }
                    }
                    if (z2) {
                        break;
                    }
                    subscriber.onNext(node2.value);
                    j++;
                    node = node2;
                }
                if (j == j2) {
                    if (replaySubscription.cancelled) {
                        replaySubscription.index = null;
                        return;
                    }
                    if (this.done && node.get() == null) {
                        replaySubscription.index = null;
                        replaySubscription.cancelled = true;
                        Throwable th2 = this.error;
                        if (th2 == null) {
                            subscriber.onComplete();
                            return;
                        } else {
                            subscriber.onError(th2);
                            return;
                        }
                    }
                }
                replaySubscription.index = node;
                replaySubscription.emitted = j;
                i = replaySubscription.addAndGet(-i);
            } while (i != 0);
        }

        @Override // io.reactivex.rxjava3.processors.ReplayProcessor.ReplayBuffer
        public int size() {
            Node<T> node = this.head;
            int i = 0;
            while (i != Integer.MAX_VALUE && (node = node.get()) != null) {
                i++;
            }
            return i;
        }
    }

    static final class SizeAndTimeBoundReplayBuffer<T> implements ReplayBuffer<T> {
        volatile boolean done;
        Throwable error;
        volatile TimedNode<T> head;
        final long maxAge;
        final int maxSize;
        final Scheduler scheduler;
        int size;
        TimedNode<T> tail;
        final TimeUnit unit;

        SizeAndTimeBoundReplayBuffer(int maxSize, long maxAge, TimeUnit unit, Scheduler scheduler) {
            this.maxSize = maxSize;
            this.maxAge = maxAge;
            this.unit = unit;
            this.scheduler = scheduler;
            TimedNode<T> timedNode = new TimedNode<>(null, 0L);
            this.tail = timedNode;
            this.head = timedNode;
        }

        void trim() {
            int i = this.size;
            if (i > this.maxSize) {
                this.size = i - 1;
                this.head = this.head.get();
            }
            long now = this.scheduler.now(this.unit) - this.maxAge;
            TimedNode<T> timedNode = this.head;
            while (this.size > 1) {
                TimedNode<T> timedNode2 = timedNode.get();
                if (timedNode2.time > now) {
                    this.head = timedNode;
                    return;
                } else {
                    this.size--;
                    timedNode = timedNode2;
                }
            }
            this.head = timedNode;
        }

        void trimFinal() {
            long now = this.scheduler.now(this.unit) - this.maxAge;
            TimedNode<T> timedNode = this.head;
            while (true) {
                TimedNode<T> timedNode2 = timedNode.get();
                if (timedNode2 == null) {
                    if (timedNode.value != null) {
                        this.head = new TimedNode<>(null, 0L);
                        return;
                    } else {
                        this.head = timedNode;
                        return;
                    }
                }
                if (timedNode2.time > now) {
                    if (timedNode.value != null) {
                        TimedNode<T> timedNode3 = new TimedNode<>(null, 0L);
                        timedNode3.lazySet(timedNode.get());
                        this.head = timedNode3;
                        return;
                    }
                    this.head = timedNode;
                    return;
                }
                timedNode = timedNode2;
            }
        }

        @Override // io.reactivex.rxjava3.processors.ReplayProcessor.ReplayBuffer
        public void trimHead() {
            if (this.head.value != null) {
                TimedNode<T> timedNode = new TimedNode<>(null, 0L);
                timedNode.lazySet(this.head.get());
                this.head = timedNode;
            }
        }

        @Override // io.reactivex.rxjava3.processors.ReplayProcessor.ReplayBuffer
        public void next(T value) {
            TimedNode<T> timedNode = new TimedNode<>(value, this.scheduler.now(this.unit));
            TimedNode<T> timedNode2 = this.tail;
            this.tail = timedNode;
            this.size++;
            timedNode2.set(timedNode);
            trim();
        }

        @Override // io.reactivex.rxjava3.processors.ReplayProcessor.ReplayBuffer
        public void error(Throwable ex) {
            trimFinal();
            this.error = ex;
            this.done = true;
        }

        @Override // io.reactivex.rxjava3.processors.ReplayProcessor.ReplayBuffer
        public void complete() {
            trimFinal();
            this.done = true;
        }

        @Override // io.reactivex.rxjava3.processors.ReplayProcessor.ReplayBuffer
        public T getValue() {
            TimedNode<T> timedNode = this.head;
            while (true) {
                TimedNode<T> timedNode2 = timedNode.get();
                if (timedNode2 == null) {
                    break;
                }
                timedNode = timedNode2;
            }
            if (timedNode.time < this.scheduler.now(this.unit) - this.maxAge) {
                return null;
            }
            return timedNode.value;
        }

        @Override // io.reactivex.rxjava3.processors.ReplayProcessor.ReplayBuffer
        public T[] getValues(T[] tArr) {
            TimedNode<T> head = getHead();
            int size = size(head);
            if (size == 0) {
                if (tArr.length != 0) {
                    tArr[0] = null;
                }
            } else {
                if (tArr.length < size) {
                    tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), size));
                }
                for (int i = 0; i != size; i++) {
                    head = head.get();
                    tArr[i] = head.value;
                }
                if (tArr.length > size) {
                    tArr[size] = null;
                }
            }
            return tArr;
        }

        TimedNode<T> getHead() {
            TimedNode<T> timedNode;
            TimedNode<T> timedNode2 = this.head;
            long now = this.scheduler.now(this.unit) - this.maxAge;
            TimedNode<T> timedNode3 = timedNode2.get();
            while (true) {
                TimedNode<T> timedNode4 = timedNode3;
                timedNode = timedNode2;
                timedNode2 = timedNode4;
                if (timedNode2 == null || timedNode2.time > now) {
                    break;
                }
                timedNode3 = timedNode2.get();
            }
            return timedNode;
        }

        @Override // io.reactivex.rxjava3.processors.ReplayProcessor.ReplayBuffer
        public void replay(ReplaySubscription<T> replaySubscription) {
            if (replaySubscription.getAndIncrement() != 0) {
                return;
            }
            Subscriber<? super T> subscriber = replaySubscription.downstream;
            TimedNode<T> timedNode = (TimedNode) replaySubscription.index;
            if (timedNode == null) {
                timedNode = getHead();
            }
            long j = replaySubscription.emitted;
            int i = 1;
            do {
                long j2 = replaySubscription.requested.get();
                while (j != j2) {
                    if (replaySubscription.cancelled) {
                        replaySubscription.index = null;
                        return;
                    }
                    boolean z = this.done;
                    TimedNode<T> timedNode2 = timedNode.get();
                    boolean z2 = timedNode2 == null;
                    if (z && z2) {
                        replaySubscription.index = null;
                        replaySubscription.cancelled = true;
                        Throwable th = this.error;
                        if (th == null) {
                            subscriber.onComplete();
                            return;
                        } else {
                            subscriber.onError(th);
                            return;
                        }
                    }
                    if (z2) {
                        break;
                    }
                    subscriber.onNext(timedNode2.value);
                    j++;
                    timedNode = timedNode2;
                }
                if (j == j2) {
                    if (replaySubscription.cancelled) {
                        replaySubscription.index = null;
                        return;
                    }
                    if (this.done && timedNode.get() == null) {
                        replaySubscription.index = null;
                        replaySubscription.cancelled = true;
                        Throwable th2 = this.error;
                        if (th2 == null) {
                            subscriber.onComplete();
                            return;
                        } else {
                            subscriber.onError(th2);
                            return;
                        }
                    }
                }
                replaySubscription.index = timedNode;
                replaySubscription.emitted = j;
                i = replaySubscription.addAndGet(-i);
            } while (i != 0);
        }

        @Override // io.reactivex.rxjava3.processors.ReplayProcessor.ReplayBuffer
        public int size() {
            return size(getHead());
        }

        int size(TimedNode<T> h) {
            int i = 0;
            while (i != Integer.MAX_VALUE && (h = h.get()) != null) {
                i++;
            }
            return i;
        }

        @Override // io.reactivex.rxjava3.processors.ReplayProcessor.ReplayBuffer
        public Throwable getError() {
            return this.error;
        }

        @Override // io.reactivex.rxjava3.processors.ReplayProcessor.ReplayBuffer
        public boolean isDone() {
            return this.done;
        }
    }
}
