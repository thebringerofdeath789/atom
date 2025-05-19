package kotlinx.coroutines.channels;

import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.internal.ConcurrentKt;
import kotlinx.coroutines.selects.SelectInstance;
import kotlinx.coroutines.selects.SelectKt;
import org.apache.commons.beanutils.PropertyUtils;

/* compiled from: ArrayBroadcastChannel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u00016B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0012\u0010 \u001a\u00020\u00172\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\b\u0010#\u001a\u00020$H\u0002J\u0012\u0010%\u001a\u00020\u00172\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\b\u0010&\u001a\u00020\u0015H\u0002J\u0015\u0010'\u001a\u00028\u00002\u0006\u0010(\u001a\u00020\u0015H\u0002¢\u0006\u0002\u0010)J\u0015\u0010*\u001a\u00020\t2\u0006\u0010+\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010,J!\u0010-\u001a\u00020\t2\u0006\u0010+\u001a\u00028\u00002\n\u0010.\u001a\u0006\u0012\u0002\b\u00030/H\u0014¢\u0006\u0002\u00100J\u000e\u00101\u001a\b\u0012\u0004\u0012\u00028\u000002H\u0016J-\u00103\u001a\u00020$2\u0010\b\u0002\u00104\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u001d2\u0010\b\u0002\u00105\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u001dH\u0082\u0010R\u0018\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\nR\u0014\u0010\u000b\u001a\u00020\f8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0012\u0010\u000f\u001a\u00060\u0010j\u0002`\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\u00020\u00178TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u00178TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0018R\u000e\u0010\u001a\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R*\u0010\u001b\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u001d0\u001cj\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u001d`\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00067"}, d2 = {"Lkotlinx/coroutines/channels/ArrayBroadcastChannel;", "E", "Lkotlinx/coroutines/channels/AbstractSendChannel;", "Lkotlinx/coroutines/channels/BroadcastChannel;", "capacity", "", "(I)V", "buffer", "", "", "[Ljava/lang/Object;", "bufferDebugString", "", "getBufferDebugString", "()Ljava/lang/String;", "bufferLock", "Ljava/util/concurrent/locks/ReentrantLock;", "Lkotlinx/coroutines/internal/ReentrantLock;", "getCapacity", "()I", TtmlNode.TAG_HEAD, "", "isBufferAlwaysFull", "", "()Z", "isBufferFull", "size", "subscribers", "", "Lkotlinx/coroutines/channels/ArrayBroadcastChannel$Subscriber;", "Lkotlinx/coroutines/internal/SubscribersList;", "tail", "cancel", "cause", "", "checkSubOffers", "", "close", "computeMinHead", "elementAt", "index", "(J)Ljava/lang/Object;", "offerInternal", "element", "(Ljava/lang/Object;)Ljava/lang/Object;", "offerSelectInternal", "select", "Lkotlinx/coroutines/selects/SelectInstance;", "(Ljava/lang/Object;Lkotlinx/coroutines/selects/SelectInstance;)Ljava/lang/Object;", "openSubscription", "Lkotlinx/coroutines/channels/ReceiveChannel;", "updateHead", "addSub", "removeSub", "Subscriber", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 13})
/* loaded from: classes4.dex */
public final class ArrayBroadcastChannel<E> extends AbstractSendChannel<E> implements BroadcastChannel<E> {
    private final Object[] buffer;
    private final ReentrantLock bufferLock;
    private final int capacity;
    private volatile long head;
    private volatile int size;
    private final List<Subscriber<E>> subscribers;
    private volatile long tail;

    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    protected boolean isBufferAlwaysFull() {
        return false;
    }

    public final int getCapacity() {
        return this.capacity;
    }

    public ArrayBroadcastChannel(int i) {
        this.capacity = i;
        if (!(i >= 1)) {
            throw new IllegalArgumentException(("ArrayBroadcastChannel capacity must be at least 1, but " + i + " was specified").toString());
        }
        this.bufferLock = new ReentrantLock();
        this.buffer = new Object[i];
        this.subscribers = ConcurrentKt.subscriberList();
    }

    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    protected boolean isBufferFull() {
        return this.size >= this.capacity;
    }

    @Override // kotlinx.coroutines.channels.BroadcastChannel
    public ReceiveChannel<E> openSubscription() {
        Subscriber subscriber = new Subscriber(this);
        updateHead$default(this, subscriber, null, 2, null);
        return subscriber;
    }

    @Override // kotlinx.coroutines.channels.AbstractSendChannel, kotlinx.coroutines.channels.SendChannel
    public boolean close(Throwable cause) {
        if (!super.close(cause)) {
            return false;
        }
        checkSubOffers();
        return true;
    }

    @Override // kotlinx.coroutines.channels.BroadcastChannel
    public boolean cancel(Throwable cause) {
        boolean close = close(cause);
        Iterator<Subscriber<E>> it = this.subscribers.iterator();
        while (it.hasNext()) {
            it.next().cancel(cause);
        }
        return close;
    }

    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    protected Object offerInternal(E element) {
        ReentrantLock reentrantLock = this.bufferLock;
        reentrantLock.lock();
        try {
            Closed<?> closedForSend = getClosedForSend();
            if (closedForSend != null) {
                return closedForSend;
            }
            int i = this.size;
            if (i >= this.capacity) {
                return AbstractChannelKt.OFFER_FAILED;
            }
            long j = this.tail;
            this.buffer[(int) (j % this.capacity)] = element;
            this.size = i + 1;
            this.tail = j + 1;
            Unit unit = Unit.INSTANCE;
            reentrantLock.unlock();
            checkSubOffers();
            return AbstractChannelKt.OFFER_SUCCESS;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    protected Object offerSelectInternal(E element, SelectInstance<?> select) {
        Intrinsics.checkParameterIsNotNull(select, "select");
        ReentrantLock reentrantLock = this.bufferLock;
        reentrantLock.lock();
        try {
            Closed<?> closedForSend = getClosedForSend();
            if (closedForSend != null) {
                return closedForSend;
            }
            int i = this.size;
            if (i >= this.capacity) {
                return AbstractChannelKt.OFFER_FAILED;
            }
            if (!select.trySelect(null)) {
                return SelectKt.getALREADY_SELECTED();
            }
            long j = this.tail;
            this.buffer[(int) (j % this.capacity)] = element;
            this.size = i + 1;
            this.tail = j + 1;
            Unit unit = Unit.INSTANCE;
            reentrantLock.unlock();
            checkSubOffers();
            return AbstractChannelKt.OFFER_SUCCESS;
        } finally {
            reentrantLock.unlock();
        }
    }

    private final void checkSubOffers() {
        Iterator<Subscriber<E>> it = this.subscribers.iterator();
        boolean z = false;
        boolean z2 = false;
        while (it.hasNext()) {
            if (it.next().checkOffer()) {
                z = true;
            }
            z2 = true;
        }
        if (z || !z2) {
            updateHead$default(this, null, null, 3, null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void updateHead$default(ArrayBroadcastChannel arrayBroadcastChannel, Subscriber subscriber, Subscriber subscriber2, int i, Object obj) {
        if ((i & 1) != 0) {
            subscriber = (Subscriber) null;
        }
        if ((i & 2) != 0) {
            subscriber2 = (Subscriber) null;
        }
        arrayBroadcastChannel.updateHead(subscriber, subscriber2);
    }

    private final void updateHead(Subscriber<E> addSub, Subscriber<E> removeSub) {
        Send takeFirstSendOrPeekClosed;
        Object tryResumeSend;
        while (true) {
            ReentrantLock reentrantLock = this.bufferLock;
            reentrantLock.lock();
            if (addSub != null) {
                try {
                    addSub.subHead = this.tail;
                    boolean isEmpty = this.subscribers.isEmpty();
                    this.subscribers.add(addSub);
                    if (!isEmpty) {
                        return;
                    }
                } finally {
                    reentrantLock.unlock();
                }
            }
            if (removeSub != null) {
                this.subscribers.remove(removeSub);
                if (this.head != removeSub.subHead) {
                    return;
                }
            }
            long computeMinHead = computeMinHead();
            long j = this.tail;
            long j2 = this.head;
            long coerceAtMost = RangesKt.coerceAtMost(computeMinHead, j);
            if (coerceAtMost <= j2) {
                return;
            }
            int i = this.size;
            while (j2 < coerceAtMost) {
                Object[] objArr = this.buffer;
                int i2 = this.capacity;
                objArr[(int) (j2 % i2)] = null;
                boolean z = i >= i2;
                j2++;
                this.head = j2;
                i--;
                this.size = i;
                if (z) {
                    do {
                        takeFirstSendOrPeekClosed = takeFirstSendOrPeekClosed();
                        if (takeFirstSendOrPeekClosed != null && !(takeFirstSendOrPeekClosed instanceof Closed)) {
                            if (takeFirstSendOrPeekClosed == null) {
                                Intrinsics.throwNpe();
                            }
                            tryResumeSend = takeFirstSendOrPeekClosed.tryResumeSend(null);
                        }
                    } while (tryResumeSend == null);
                    Object[] objArr2 = this.buffer;
                    int i3 = (int) (j % this.capacity);
                    if (takeFirstSendOrPeekClosed == null) {
                        throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.channels.Send");
                    }
                    objArr2[i3] = takeFirstSendOrPeekClosed.getPollResult();
                    this.size = i + 1;
                    this.tail = j + 1;
                    Unit unit = Unit.INSTANCE;
                    reentrantLock.unlock();
                    if (takeFirstSendOrPeekClosed == null) {
                        Intrinsics.throwNpe();
                    }
                    takeFirstSendOrPeekClosed.completeResumeSend(tryResumeSend);
                    checkSubOffers();
                    addSub = null;
                    removeSub = null;
                }
            }
            return;
        }
    }

    private final long computeMinHead() {
        Iterator<Subscriber<E>> it = this.subscribers.iterator();
        long j = Long.MAX_VALUE;
        while (it.hasNext()) {
            j = RangesKt.coerceAtMost(j, it.next().subHead);
        }
        return j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final E elementAt(long index) {
        return (E) this.buffer[(int) (index % this.capacity)];
    }

    /* compiled from: ArrayBroadcastChannel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0013\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0012\u0010\u0012\u001a\u00020\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u0006\u0010\u0015\u001a\u00020\bJ\b\u0010\u0016\u001a\u00020\u0017H\u0002J\b\u0010\u0018\u001a\u00020\bH\u0002J\n\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0002J\n\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0014J\u0016\u0010\u001c\u001a\u0004\u0018\u00010\u001a2\n\u0010\u001d\u001a\u0006\u0012\u0002\b\u00030\u001eH\u0014R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\b8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\tR\u0014\u0010\n\u001a\u00020\b8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\tR\u0014\u0010\u000b\u001a\u00020\b8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\tR\u0014\u0010\f\u001a\u00020\b8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\tR\u0012\u0010\r\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u00060\u0010j\u0002`\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lkotlinx/coroutines/channels/ArrayBroadcastChannel$Subscriber;", "E", "Lkotlinx/coroutines/channels/AbstractChannel;", "Lkotlinx/coroutines/channels/ReceiveChannel;", "broadcastChannel", "Lkotlinx/coroutines/channels/ArrayBroadcastChannel;", "(Lkotlinx/coroutines/channels/ArrayBroadcastChannel;)V", "isBufferAlwaysEmpty", "", "()Z", "isBufferAlwaysFull", "isBufferEmpty", "isBufferFull", "subHead", "", "subLock", "Ljava/util/concurrent/locks/ReentrantLock;", "Lkotlinx/coroutines/internal/ReentrantLock;", "cancel", "cause", "", "checkOffer", "clearBuffer", "", "needsToCheckOfferWithoutLock", "peekUnderLock", "", "pollInternal", "pollSelectInternal", "select", "Lkotlinx/coroutines/selects/SelectInstance;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 13})
    private static final class Subscriber<E> extends AbstractChannel<E> implements ReceiveChannel<E> {
        private final ArrayBroadcastChannel<E> broadcastChannel;
        public volatile long subHead;
        private final ReentrantLock subLock;

        @Override // kotlinx.coroutines.channels.AbstractChannel
        protected boolean isBufferAlwaysEmpty() {
            return false;
        }

        public Subscriber(ArrayBroadcastChannel<E> broadcastChannel) {
            Intrinsics.checkParameterIsNotNull(broadcastChannel, "broadcastChannel");
            this.broadcastChannel = broadcastChannel;
            this.subLock = new ReentrantLock();
        }

        @Override // kotlinx.coroutines.channels.AbstractChannel
        protected boolean isBufferEmpty() {
            return this.subHead >= ((ArrayBroadcastChannel) this.broadcastChannel).tail;
        }

        @Override // kotlinx.coroutines.channels.AbstractSendChannel
        protected boolean isBufferAlwaysFull() {
            throw new IllegalStateException("Should not be used".toString());
        }

        @Override // kotlinx.coroutines.channels.AbstractSendChannel
        protected boolean isBufferFull() {
            throw new IllegalStateException("Should not be used".toString());
        }

        @Override // kotlinx.coroutines.channels.AbstractChannel, kotlinx.coroutines.channels.ReceiveChannel
        public boolean cancel(Throwable cause) {
            boolean close = close(cause);
            if (close) {
                ArrayBroadcastChannel.updateHead$default(this.broadcastChannel, null, this, 1, null);
            }
            clearBuffer();
            return close;
        }

        private final void clearBuffer() {
            ReentrantLock reentrantLock = this.subLock;
            reentrantLock.lock();
            try {
                this.subHead = ((ArrayBroadcastChannel) this.broadcastChannel).tail;
                Unit unit = Unit.INSTANCE;
            } finally {
                reentrantLock.unlock();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final boolean checkOffer() {
            Closed closed = (Closed) null;
            boolean z = false;
            while (needsToCheckOfferWithoutLock() && this.subLock.tryLock()) {
                try {
                    Object peekUnderLock = peekUnderLock();
                    if (peekUnderLock != AbstractChannelKt.POLL_FAILED) {
                        if (peekUnderLock instanceof Closed) {
                            closed = (Closed) peekUnderLock;
                        } else {
                            ReceiveOrClosed<E> takeFirstReceiveOrPeekClosed = takeFirstReceiveOrPeekClosed();
                            if (takeFirstReceiveOrPeekClosed != 0 && !(takeFirstReceiveOrPeekClosed instanceof Closed)) {
                                Object tryResumeReceive = takeFirstReceiveOrPeekClosed.tryResumeReceive(peekUnderLock, null);
                                if (tryResumeReceive != null) {
                                    this.subHead++;
                                    z = true;
                                    this.subLock.unlock();
                                    if (takeFirstReceiveOrPeekClosed == 0) {
                                        Intrinsics.throwNpe();
                                    }
                                    takeFirstReceiveOrPeekClosed.completeResumeReceive(tryResumeReceive);
                                }
                            }
                        }
                        break;
                    }
                } finally {
                    this.subLock.unlock();
                }
            }
            if (closed != null) {
                close(closed.closeCause);
            }
            return z;
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x002e  */
        /* JADX WARN: Removed duplicated region for block: B:15:0x003a  */
        /* JADX WARN: Removed duplicated region for block: B:17:0x003d  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x0029  */
        /* JADX WARN: Removed duplicated region for block: B:9:0x0027  */
        @Override // kotlinx.coroutines.channels.AbstractChannel
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        protected java.lang.Object pollInternal() {
            /*
                r8 = this;
                java.util.concurrent.locks.ReentrantLock r0 = r8.subLock
                java.util.concurrent.locks.Lock r0 = (java.util.concurrent.locks.Lock) r0
                r0.lock()
                java.lang.Object r1 = r8.peekUnderLock()     // Catch: java.lang.Throwable -> L44
                boolean r2 = r1 instanceof kotlinx.coroutines.channels.Closed     // Catch: java.lang.Throwable -> L44
                r3 = 1
                if (r2 == 0) goto L11
                goto L15
            L11:
                java.lang.Object r2 = kotlinx.coroutines.channels.AbstractChannelKt.POLL_FAILED     // Catch: java.lang.Throwable -> L44
                if (r1 != r2) goto L17
            L15:
                r2 = 0
                goto L1f
            L17:
                long r4 = r8.subHead     // Catch: java.lang.Throwable -> L44
                r6 = 1
                long r4 = r4 + r6
                r8.subHead = r4     // Catch: java.lang.Throwable -> L44
                r2 = r3
            L1f:
                r0.unlock()
                boolean r0 = r1 instanceof kotlinx.coroutines.channels.Closed
                r4 = 0
                if (r0 != 0) goto L29
                r0 = r4
                goto L2a
            L29:
                r0 = r1
            L2a:
                kotlinx.coroutines.channels.Closed r0 = (kotlinx.coroutines.channels.Closed) r0
                if (r0 == 0) goto L33
                java.lang.Throwable r0 = r0.closeCause
                r8.close(r0)
            L33:
                boolean r0 = r8.checkOffer()
                if (r0 == 0) goto L3a
                goto L3b
            L3a:
                r3 = r2
            L3b:
                if (r3 == 0) goto L43
                kotlinx.coroutines.channels.ArrayBroadcastChannel<E> r0 = r8.broadcastChannel
                r2 = 3
                kotlinx.coroutines.channels.ArrayBroadcastChannel.updateHead$default(r0, r4, r4, r2, r4)
            L43:
                return r1
            L44:
                r1 = move-exception
                r0.unlock()
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ArrayBroadcastChannel.Subscriber.pollInternal():java.lang.Object");
        }

        @Override // kotlinx.coroutines.channels.AbstractChannel
        protected Object pollSelectInternal(SelectInstance<?> select) {
            Intrinsics.checkParameterIsNotNull(select, "select");
            ReentrantLock reentrantLock = this.subLock;
            reentrantLock.lock();
            try {
                Object peekUnderLock = peekUnderLock();
                boolean z = false;
                if (!(peekUnderLock instanceof Closed) && peekUnderLock != AbstractChannelKt.POLL_FAILED) {
                    if (!select.trySelect(null)) {
                        peekUnderLock = SelectKt.getALREADY_SELECTED();
                    } else {
                        this.subHead++;
                        z = true;
                    }
                }
                reentrantLock.unlock();
                Closed closed = (Closed) (!(peekUnderLock instanceof Closed) ? null : peekUnderLock);
                if (closed != null) {
                    close(closed.closeCause);
                }
                if (checkOffer() ? true : z) {
                    ArrayBroadcastChannel.updateHead$default(this.broadcastChannel, null, null, 3, null);
                }
                return peekUnderLock;
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        }

        private final boolean needsToCheckOfferWithoutLock() {
            if (getClosedForReceive() != null) {
                return false;
            }
            return (isBufferEmpty() && this.broadcastChannel.getClosedForReceive() == null) ? false : true;
        }

        private final Object peekUnderLock() {
            long j = this.subHead;
            Closed<?> closedForReceive = this.broadcastChannel.getClosedForReceive();
            if (j >= ((ArrayBroadcastChannel) this.broadcastChannel).tail) {
                if (closedForReceive == null) {
                    closedForReceive = getClosedForReceive();
                }
                return closedForReceive != null ? closedForReceive : AbstractChannelKt.POLL_FAILED;
            }
            Object elementAt = this.broadcastChannel.elementAt(j);
            Closed<?> closedForReceive2 = getClosedForReceive();
            return closedForReceive2 != null ? closedForReceive2 : elementAt;
        }
    }

    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    protected String getBufferDebugString() {
        return "(buffer:capacity=" + this.buffer.length + ",size=" + this.size + PropertyUtils.MAPPED_DELIM2;
    }
}
