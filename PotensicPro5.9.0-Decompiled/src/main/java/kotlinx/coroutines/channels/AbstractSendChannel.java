package kotlinx.coroutines.channels;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CancellableContinuationKt;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.internal.LockFreeLinkedListHead;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;
import kotlinx.coroutines.intrinsics.UndispatchedKt;
import kotlinx.coroutines.selects.SelectClause2;
import kotlinx.coroutines.selects.SelectInstance;
import kotlinx.coroutines.selects.SelectKt;
import org.apache.commons.beanutils.PropertyUtils;

/* compiled from: AbstractChannel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b \u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u0006VWXYZ[B\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010!\u001a\u00020\u000f2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\u0010\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0004J\b\u0010(\u001a\u00020)H\u0002J!\u0010*\u001a\u000e\u0012\u0002\b\u00030+j\u0006\u0012\u0002\b\u0003`,2\u0006\u0010-\u001a\u00028\u0000H\u0004¢\u0006\u0002\u0010.J!\u0010/\u001a\u000e\u0012\u0002\b\u00030+j\u0006\u0012\u0002\b\u0003`,2\u0006\u0010-\u001a\u00028\u0000H\u0004¢\u0006\u0002\u0010.J\u001b\u00100\u001a\b\u0012\u0004\u0012\u00028\u0000012\u0006\u0010-\u001a\u00028\u0000H\u0004¢\u0006\u0002\u00102J\u0012\u00103\u001a\u0004\u0018\u00010\u00162\u0006\u00104\u001a\u000205H\u0002J\u0014\u00106\u001a\u00020%2\n\u00107\u001a\u0006\u0012\u0002\b\u00030\tH\u0002J\"\u00108\u001a\u00020%2\u0018\u00109\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010#\u0012\u0004\u0012\u00020%0:j\u0002`;H\u0016J\u0012\u0010<\u001a\u00020%2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0002J\u0013\u0010=\u001a\u00020\u000f2\u0006\u0010-\u001a\u00028\u0000¢\u0006\u0002\u0010>J\u0015\u0010?\u001a\u00020\u00162\u0006\u0010-\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010@J!\u0010A\u001a\u00020\u00162\u0006\u0010-\u001a\u00028\u00002\n\u0010B\u001a\u0006\u0012\u0002\b\u00030CH\u0014¢\u0006\u0002\u0010DJ\u0010\u0010E\u001a\u00020%2\u0006\u00107\u001a\u00020'H\u0014JV\u0010F\u001a\u00020%\"\u0004\b\u0001\u0010G2\f\u0010B\u001a\b\u0012\u0004\u0012\u0002HG0C2\u0006\u0010-\u001a\u00028\u00002(\u0010H\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002HG0J\u0012\u0006\u0012\u0004\u0018\u00010\u00160IH\u0002ø\u0001\u0000¢\u0006\u0002\u0010KJ\u0019\u00104\u001a\u00020%2\u0006\u0010-\u001a\u00028\u0000H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010LJ\u001b\u0010M\u001a\b\u0012\u0002\b\u0003\u0018\u00010N2\u0006\u0010-\u001a\u00028\u0000H\u0004¢\u0006\u0002\u0010OJ\u001b\u0010P\u001a\b\u0012\u0002\b\u0003\u0018\u00010N2\u0006\u0010-\u001a\u00028\u0000H\u0004¢\u0006\u0002\u0010OJ\u0019\u0010Q\u001a\u00020%2\u0006\u0010-\u001a\u00028\u0000H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010LJ\u0010\u0010R\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010NH\u0014J\n\u0010S\u001a\u0004\u0018\u00010TH\u0004J\b\u0010U\u001a\u00020\u0005H\u0016R\u0014\u0010\u0004\u001a\u00020\u00058TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\t8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\b\u0012\u0002\b\u0003\u0018\u00010\t8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000bR\u0012\u0010\u000e\u001a\u00020\u000fX¤\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0010R\u0012\u0010\u0011\u001a\u00020\u000fX¤\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0012\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\u0013\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0010R\u0016\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R#\u0010\u0017\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u00188F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\u00020\u001cX\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0014\u0010\u001f\u001a\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b \u0010\u0007\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\\"}, d2 = {"Lkotlinx/coroutines/channels/AbstractSendChannel;", "E", "Lkotlinx/coroutines/channels/SendChannel;", "()V", "bufferDebugString", "", "getBufferDebugString", "()Ljava/lang/String;", "closedForReceive", "Lkotlinx/coroutines/channels/Closed;", "getClosedForReceive", "()Lkotlinx/coroutines/channels/Closed;", "closedForSend", "getClosedForSend", "isBufferAlwaysFull", "", "()Z", "isBufferFull", "isClosedForSend", "isFull", "onCloseHandler", "Lkotlinx/atomicfu/AtomicRef;", "", "onSend", "Lkotlinx/coroutines/selects/SelectClause2;", "getOnSend", "()Lkotlinx/coroutines/selects/SelectClause2;", "queue", "Lkotlinx/coroutines/internal/LockFreeLinkedListHead;", "getQueue", "()Lkotlinx/coroutines/internal/LockFreeLinkedListHead;", "queueDebugStateString", "getQueueDebugStateString", "close", "cause", "", "conflatePreviousSendBuffered", "", "node", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "countQueueSize", "", "describeSendBuffered", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$AddLastDesc;", "Lkotlinx/coroutines/internal/AddLastDesc;", "element", "(Ljava/lang/Object;)Lkotlinx/coroutines/internal/LockFreeLinkedListNode$AddLastDesc;", "describeSendConflated", "describeTryOffer", "Lkotlinx/coroutines/channels/AbstractSendChannel$TryOfferDesc;", "(Ljava/lang/Object;)Lkotlinx/coroutines/channels/AbstractSendChannel$TryOfferDesc;", "enqueueSend", "send", "Lkotlinx/coroutines/channels/SendElement;", "helpClose", "closed", "invokeOnClose", "handler", "Lkotlin/Function1;", "Lkotlinx/coroutines/channels/Handler;", "invokeOnCloseHandler", "offer", "(Ljava/lang/Object;)Z", "offerInternal", "(Ljava/lang/Object;)Ljava/lang/Object;", "offerSelectInternal", "select", "Lkotlinx/coroutines/selects/SelectInstance;", "(Ljava/lang/Object;Lkotlinx/coroutines/selects/SelectInstance;)Ljava/lang/Object;", "onClosedIdempotent", "registerSelectSend", "R", "block", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendBuffered", "Lkotlinx/coroutines/channels/ReceiveOrClosed;", "(Ljava/lang/Object;)Lkotlinx/coroutines/channels/ReceiveOrClosed;", "sendConflated", "sendSuspend", "takeFirstReceiveOrPeekClosed", "takeFirstSendOrPeekClosed", "Lkotlinx/coroutines/channels/Send;", "toString", "SendBuffered", "SendBufferedDesc", "SendConflatedDesc", "SendSelect", "TryEnqueueSendDesc", "TryOfferDesc", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 13})
/* loaded from: classes4.dex */
public abstract class AbstractSendChannel<E> implements SendChannel<E> {
    private static final AtomicReferenceFieldUpdater onCloseHandler$FU = AtomicReferenceFieldUpdater.newUpdater(AbstractSendChannel.class, Object.class, "onCloseHandler");
    private final LockFreeLinkedListHead queue = new LockFreeLinkedListHead();
    private volatile Object onCloseHandler = null;

    protected String getBufferDebugString() {
        return "";
    }

    protected abstract boolean isBufferAlwaysFull();

    protected abstract boolean isBufferFull();

    protected void onClosedIdempotent(LockFreeLinkedListNode closed) {
        Intrinsics.checkParameterIsNotNull(closed, "closed");
    }

    protected final LockFreeLinkedListHead getQueue() {
        return this.queue;
    }

    protected Object offerInternal(E element) {
        ReceiveOrClosed<E> takeFirstReceiveOrPeekClosed;
        Object tryResumeReceive;
        do {
            takeFirstReceiveOrPeekClosed = takeFirstReceiveOrPeekClosed();
            if (takeFirstReceiveOrPeekClosed == null) {
                return AbstractChannelKt.OFFER_FAILED;
            }
            tryResumeReceive = takeFirstReceiveOrPeekClosed.tryResumeReceive(element, null);
        } while (tryResumeReceive == null);
        takeFirstReceiveOrPeekClosed.completeResumeReceive(tryResumeReceive);
        return takeFirstReceiveOrPeekClosed.getOfferResult();
    }

    protected Object offerSelectInternal(E element, SelectInstance<?> select) {
        Intrinsics.checkParameterIsNotNull(select, "select");
        TryOfferDesc<E> describeTryOffer = describeTryOffer(element);
        Object performAtomicTrySelect = select.performAtomicTrySelect(describeTryOffer);
        if (performAtomicTrySelect != null) {
            return performAtomicTrySelect;
        }
        ReceiveOrClosed<? super E> result = describeTryOffer.getResult();
        Object obj = describeTryOffer.resumeToken;
        if (obj == null) {
            Intrinsics.throwNpe();
        }
        result.completeResumeReceive(obj);
        return result.getOfferResult();
    }

    protected final Closed<?> getClosedForSend() {
        LockFreeLinkedListNode prevNode = this.queue.getPrevNode();
        if (!(prevNode instanceof Closed)) {
            prevNode = null;
        }
        Closed<?> closed = (Closed) prevNode;
        if (closed == null) {
            return null;
        }
        helpClose(closed);
        return closed;
    }

    protected final Closed<?> getClosedForReceive() {
        LockFreeLinkedListNode nextNode = this.queue.getNextNode();
        if (!(nextNode instanceof Closed)) {
            nextNode = null;
        }
        Closed<?> closed = (Closed) nextNode;
        if (closed == null) {
            return null;
        }
        helpClose(closed);
        return closed;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [kotlinx.coroutines.internal.LockFreeLinkedListNode] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4 */
    protected final Send takeFirstSendOrPeekClosed() {
        ?? r1;
        LockFreeLinkedListHead lockFreeLinkedListHead = this.queue;
        while (true) {
            Object next = lockFreeLinkedListHead.getNext();
            if (next == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
            }
            r1 = (LockFreeLinkedListNode) next;
            if (r1 != lockFreeLinkedListHead && (r1 instanceof Send)) {
                if ((((Send) r1) instanceof Closed) || r1.remove()) {
                    break;
                }
                r1.helpDelete();
            }
        }
        r1 = 0;
        return (Send) r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected final ReceiveOrClosed<?> sendBuffered(E element) {
        LockFreeLinkedListNode lockFreeLinkedListNode;
        LockFreeLinkedListHead lockFreeLinkedListHead = this.queue;
        SendBuffered sendBuffered = new SendBuffered(element);
        do {
            Object prev = lockFreeLinkedListHead.getPrev();
            if (prev != null) {
                lockFreeLinkedListNode = (LockFreeLinkedListNode) prev;
                if (lockFreeLinkedListNode instanceof ReceiveOrClosed) {
                    return (ReceiveOrClosed) lockFreeLinkedListNode;
                }
            } else {
                throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
            }
        } while (!lockFreeLinkedListNode.addNext(sendBuffered, lockFreeLinkedListHead));
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected final ReceiveOrClosed<?> sendConflated(E element) {
        LockFreeLinkedListNode lockFreeLinkedListNode;
        SendBuffered sendBuffered = new SendBuffered(element);
        LockFreeLinkedListHead lockFreeLinkedListHead = this.queue;
        do {
            Object prev = lockFreeLinkedListHead.getPrev();
            if (prev != null) {
                lockFreeLinkedListNode = (LockFreeLinkedListNode) prev;
                if (lockFreeLinkedListNode instanceof ReceiveOrClosed) {
                    return (ReceiveOrClosed) lockFreeLinkedListNode;
                }
            } else {
                throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
            }
        } while (!lockFreeLinkedListNode.addNext(sendBuffered, lockFreeLinkedListHead));
        conflatePreviousSendBuffered(sendBuffered);
        return null;
    }

    protected final void conflatePreviousSendBuffered(LockFreeLinkedListNode node) {
        Intrinsics.checkParameterIsNotNull(node, "node");
        for (LockFreeLinkedListNode prevNode = node.getPrevNode(); prevNode instanceof SendBuffered; prevNode = prevNode.getPrevNode()) {
            if (!prevNode.remove()) {
                prevNode.helpRemove();
            }
        }
    }

    protected final LockFreeLinkedListNode.AddLastDesc<?> describeSendBuffered(E element) {
        return new SendBufferedDesc(this.queue, element);
    }

    /* compiled from: AbstractChannel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0012\u0018\u0000*\u0004\b\u0001\u0010\u00012\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00030\u0002j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u0003`\u0004B\u0015\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00028\u0001¢\u0006\u0002\u0010\bJ\u001a\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\nH\u0014¨\u0006\u000e"}, d2 = {"Lkotlinx/coroutines/channels/AbstractSendChannel$SendBufferedDesc;", "E", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$AddLastDesc;", "Lkotlinx/coroutines/channels/AbstractSendChannel$SendBuffered;", "Lkotlinx/coroutines/internal/AddLastDesc;", "queue", "Lkotlinx/coroutines/internal/LockFreeLinkedListHead;", "element", "(Lkotlinx/coroutines/internal/LockFreeLinkedListHead;Ljava/lang/Object;)V", "failure", "", "affected", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "next", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 13})
    private static class SendBufferedDesc<E> extends LockFreeLinkedListNode.AddLastDesc<SendBuffered<? extends E>> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SendBufferedDesc(LockFreeLinkedListHead queue, E e) {
            super(queue, new SendBuffered(e));
            Intrinsics.checkParameterIsNotNull(queue, "queue");
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        protected Object failure(LockFreeLinkedListNode affected, Object next) {
            Intrinsics.checkParameterIsNotNull(affected, "affected");
            Intrinsics.checkParameterIsNotNull(next, "next");
            if (affected instanceof ReceiveOrClosed) {
                return AbstractChannelKt.OFFER_FAILED;
            }
            return null;
        }
    }

    protected final LockFreeLinkedListNode.AddLastDesc<?> describeSendConflated(E element) {
        return new SendConflatedDesc(this.queue, element);
    }

    /* compiled from: AbstractChannel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00028\u0001¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0014¨\u0006\f"}, d2 = {"Lkotlinx/coroutines/channels/AbstractSendChannel$SendConflatedDesc;", "E", "Lkotlinx/coroutines/channels/AbstractSendChannel$SendBufferedDesc;", "queue", "Lkotlinx/coroutines/internal/LockFreeLinkedListHead;", "element", "(Lkotlinx/coroutines/internal/LockFreeLinkedListHead;Ljava/lang/Object;)V", "finishOnSuccess", "", "affected", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "next", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 13})
    private static final class SendConflatedDesc<E> extends SendBufferedDesc<E> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SendConflatedDesc(LockFreeLinkedListHead queue, E e) {
            super(queue, e);
            Intrinsics.checkParameterIsNotNull(queue, "queue");
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AddLastDesc, kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        protected void finishOnSuccess(LockFreeLinkedListNode affected, LockFreeLinkedListNode next) {
            Intrinsics.checkParameterIsNotNull(affected, "affected");
            Intrinsics.checkParameterIsNotNull(next, "next");
            super.finishOnSuccess(affected, next);
            if (!(affected instanceof SendBuffered)) {
                affected = null;
            }
            SendBuffered sendBuffered = (SendBuffered) affected;
            if (sendBuffered != null) {
                sendBuffered.remove();
            }
        }
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public final boolean isClosedForSend() {
        return getClosedForSend() != null;
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public final boolean isFull() {
        return !(this.queue.getNextNode() instanceof ReceiveOrClosed) && isBufferFull();
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public final Object send(E e, Continuation<? super Unit> continuation) {
        return offer(e) ? Unit.INSTANCE : sendSuspend(e, continuation);
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public final boolean offer(E element) {
        Throwable sendException;
        Throwable recoverStackTrace;
        Object offerInternal = offerInternal(element);
        if (offerInternal == AbstractChannelKt.OFFER_SUCCESS) {
            return true;
        }
        if (offerInternal != AbstractChannelKt.OFFER_FAILED) {
            if (offerInternal instanceof Closed) {
                throw StackTraceRecoveryKt.recoverStackTrace(((Closed) offerInternal).getSendException());
            }
            throw new IllegalStateException(("offerInternal returned " + offerInternal).toString());
        }
        Closed<?> closedForSend = getClosedForSend();
        if (closedForSend == null || (sendException = closedForSend.getSendException()) == null || (recoverStackTrace = StackTraceRecoveryKt.recoverStackTrace(sendException)) == null) {
            return false;
        }
        throw recoverStackTrace;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x004b, code lost:
    
        if (r4 != false) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x004f, code lost:
    
        return kotlinx.coroutines.channels.AbstractChannelKt.ENQUEUE_FAILED;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0050, code lost:
    
        return null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object enqueueSend(kotlinx.coroutines.channels.SendElement r6) {
        /*
            r5 = this;
            boolean r0 = r5.isBufferAlwaysFull()
        */
        //  java.lang.String r1 = "null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */"
        /*
            if (r0 == 0) goto L27
            kotlinx.coroutines.internal.LockFreeLinkedListHead r0 = r5.queue
        La:
            java.lang.Object r2 = r0.getPrev()
            if (r2 == 0) goto L21
            kotlinx.coroutines.internal.LockFreeLinkedListNode r2 = (kotlinx.coroutines.internal.LockFreeLinkedListNode) r2
            boolean r3 = r2 instanceof kotlinx.coroutines.channels.ReceiveOrClosed
            if (r3 == 0) goto L17
            return r2
        L17:
            r3 = r6
            kotlinx.coroutines.internal.LockFreeLinkedListNode r3 = (kotlinx.coroutines.internal.LockFreeLinkedListNode) r3
            boolean r2 = r2.addNext(r3, r0)
            if (r2 == 0) goto La
            goto L50
        L21:
            kotlin.TypeCastException r6 = new kotlin.TypeCastException
            r6.<init>(r1)
            throw r6
        L27:
            kotlinx.coroutines.internal.LockFreeLinkedListHead r0 = r5.queue
            kotlinx.coroutines.channels.AbstractSendChannel$enqueueSend$$inlined$addLastIfPrevAndIf$1 r2 = new kotlinx.coroutines.channels.AbstractSendChannel$enqueueSend$$inlined$addLastIfPrevAndIf$1
            kotlinx.coroutines.internal.LockFreeLinkedListNode r6 = (kotlinx.coroutines.internal.LockFreeLinkedListNode) r6
            r2.<init>(r6)
            kotlinx.coroutines.internal.LockFreeLinkedListNode$CondAddOp r2 = (kotlinx.coroutines.internal.LockFreeLinkedListNode.CondAddOp) r2
        L32:
            java.lang.Object r3 = r0.getPrev()
            if (r3 == 0) goto L52
            kotlinx.coroutines.internal.LockFreeLinkedListNode r3 = (kotlinx.coroutines.internal.LockFreeLinkedListNode) r3
            boolean r4 = r3 instanceof kotlinx.coroutines.channels.ReceiveOrClosed
            if (r4 == 0) goto L3f
            return r3
        L3f:
            int r3 = r3.tryCondAddNext(r6, r0, r2)
            r4 = 1
            if (r3 == r4) goto L4b
            r4 = 2
            if (r3 == r4) goto L4a
            goto L32
        L4a:
            r4 = 0
        L4b:
            if (r4 != 0) goto L50
            java.lang.Object r6 = kotlinx.coroutines.channels.AbstractChannelKt.ENQUEUE_FAILED
            return r6
        L50:
            r6 = 0
            return r6
        L52:
            kotlin.TypeCastException r6 = new kotlin.TypeCastException
            r6.<init>(r1)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.AbstractSendChannel.enqueueSend(kotlinx.coroutines.channels.SendElement):java.lang.Object");
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public boolean close(Throwable cause) {
        boolean z;
        Closed<?> closed = new Closed<>(cause);
        LockFreeLinkedListHead lockFreeLinkedListHead = this.queue;
        while (true) {
            Object prev = lockFreeLinkedListHead.getPrev();
            if (prev != null) {
                LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) prev;
                if (!(!(lockFreeLinkedListNode instanceof Closed))) {
                    z = false;
                    break;
                }
                if (lockFreeLinkedListNode.addNext(closed, lockFreeLinkedListHead)) {
                    z = true;
                    break;
                }
            } else {
                throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
            }
        }
        if (!z) {
            LockFreeLinkedListNode prevNode = this.queue.getPrevNode();
            if (prevNode == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.channels.Closed<*>");
            }
            helpClose((Closed) prevNode);
            return false;
        }
        helpClose(closed);
        invokeOnCloseHandler(cause);
        return true;
    }

    private final void invokeOnCloseHandler(Throwable cause) {
        Object obj = this.onCloseHandler;
        if (obj == null || obj == AbstractChannelKt.HANDLER_INVOKED || !onCloseHandler$FU.compareAndSet(this, obj, AbstractChannelKt.HANDLER_INVOKED)) {
            return;
        }
        ((Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(obj, 1)).invoke(cause);
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public void invokeOnClose(Function1<? super Throwable, Unit> handler) {
        Intrinsics.checkParameterIsNotNull(handler, "handler");
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = onCloseHandler$FU;
        if (!atomicReferenceFieldUpdater.compareAndSet(this, null, handler)) {
            Object obj = this.onCloseHandler;
            if (obj == AbstractChannelKt.HANDLER_INVOKED) {
                throw new IllegalStateException("Another handler was already registered and successfully invoked");
            }
            throw new IllegalStateException("Another handler was already registered: " + obj);
        }
        Closed<?> closedForSend = getClosedForSend();
        if (closedForSend == null || !atomicReferenceFieldUpdater.compareAndSet(this, handler, AbstractChannelKt.HANDLER_INVOKED)) {
            return;
        }
        handler.invoke(closedForSend.closeCause);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void helpClose(Closed<?> closed) {
        while (true) {
            LockFreeLinkedListNode prevNode = closed.getPrevNode();
            if ((prevNode instanceof LockFreeLinkedListHead) || !(prevNode instanceof Receive)) {
                break;
            } else if (!prevNode.remove()) {
                prevNode.helpRemove();
            } else {
                ((Receive) prevNode).resumeReceiveClosed(closed);
            }
        }
        onClosedIdempotent(closed);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [kotlinx.coroutines.internal.LockFreeLinkedListNode] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4 */
    protected ReceiveOrClosed<E> takeFirstReceiveOrPeekClosed() {
        ?? r1;
        LockFreeLinkedListHead lockFreeLinkedListHead = this.queue;
        while (true) {
            Object next = lockFreeLinkedListHead.getNext();
            if (next == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
            }
            r1 = (LockFreeLinkedListNode) next;
            if (r1 != lockFreeLinkedListHead && (r1 instanceof ReceiveOrClosed)) {
                if ((((ReceiveOrClosed) r1) instanceof Closed) || r1.remove()) {
                    break;
                }
                r1.helpDelete();
            }
        }
        r1 = 0;
        return (ReceiveOrClosed) r1;
    }

    protected final TryOfferDesc<E> describeTryOffer(E element) {
        return new TryOfferDesc<>(element, this.queue);
    }

    /* compiled from: AbstractChannel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0004\u0018\u0000*\u0004\b\u0001\u0010\u00012\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00030\u0002j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u0003`\u0004B\u0015\u0012\u0006\u0010\u0005\u001a\u00028\u0001\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u001a\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000bH\u0014J\u0016\u0010\u0010\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00010\u0003H\u0014R\u0012\u0010\u0005\u001a\u00028\u00018\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\tR\u0014\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lkotlinx/coroutines/channels/AbstractSendChannel$TryOfferDesc;", "E", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$RemoveFirstDesc;", "Lkotlinx/coroutines/channels/ReceiveOrClosed;", "Lkotlinx/coroutines/internal/RemoveFirstDesc;", "element", "queue", "Lkotlinx/coroutines/internal/LockFreeLinkedListHead;", "(Ljava/lang/Object;Lkotlinx/coroutines/internal/LockFreeLinkedListHead;)V", "Ljava/lang/Object;", "resumeToken", "", "failure", "affected", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "next", "validatePrepared", "", "node", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 13})
    protected static final class TryOfferDesc<E> extends LockFreeLinkedListNode.RemoveFirstDesc<ReceiveOrClosed<? super E>> {
        public final E element;
        public Object resumeToken;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TryOfferDesc(E e, LockFreeLinkedListHead queue) {
            super(queue);
            Intrinsics.checkParameterIsNotNull(queue, "queue");
            this.element = e;
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.RemoveFirstDesc, kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        protected Object failure(LockFreeLinkedListNode affected, Object next) {
            Intrinsics.checkParameterIsNotNull(affected, "affected");
            Intrinsics.checkParameterIsNotNull(next, "next");
            if (!(affected instanceof ReceiveOrClosed)) {
                return AbstractChannelKt.OFFER_FAILED;
            }
            if (affected instanceof Closed) {
                return affected;
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.RemoveFirstDesc
        public boolean validatePrepared(ReceiveOrClosed<? super E> node) {
            Intrinsics.checkParameterIsNotNull(node, "node");
            Object tryResumeReceive = node.tryResumeReceive(this.element, this);
            if (tryResumeReceive == null) {
                return false;
            }
            this.resumeToken = tryResumeReceive;
            return true;
        }
    }

    /* compiled from: AbstractChannel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0082\u0004\u0018\u0000*\u0004\b\u0001\u0010\u00012*\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H\u00010\u00030\u0002j\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H\u00010\u0003`\u0004BH\u0012\u0006\u0010\u0005\u001a\u00028\u0000\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\u0007\u0012(\u0010\b\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\n\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\tø\u0001\u0000¢\u0006\u0002\u0010\rJ\u001a\u0010\u000e\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\fH\u0014J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0014J\u001a\u0010\u0014\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0014\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0015"}, d2 = {"Lkotlinx/coroutines/channels/AbstractSendChannel$TryEnqueueSendDesc;", "R", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$AddLastDesc;", "Lkotlinx/coroutines/channels/AbstractSendChannel$SendSelect;", "Lkotlinx/coroutines/internal/AddLastDesc;", "element", "select", "Lkotlinx/coroutines/selects/SelectInstance;", "block", "Lkotlin/Function2;", "Lkotlinx/coroutines/channels/SendChannel;", "Lkotlin/coroutines/Continuation;", "", "(Lkotlinx/coroutines/channels/AbstractSendChannel;Ljava/lang/Object;Lkotlinx/coroutines/selects/SelectInstance;Lkotlin/jvm/functions/Function2;)V", "failure", "affected", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "next", "finishOnSuccess", "", "onPrepare", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 13})
    private final class TryEnqueueSendDesc<R> extends LockFreeLinkedListNode.AddLastDesc<SendSelect<E, R>> {
        final /* synthetic */ AbstractSendChannel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TryEnqueueSendDesc(AbstractSendChannel abstractSendChannel, E e, SelectInstance<? super R> select, Function2<? super SendChannel<? super E>, ? super Continuation<? super R>, ? extends Object> block) {
            super(abstractSendChannel.getQueue(), new SendSelect(e, abstractSendChannel, select, block));
            Intrinsics.checkParameterIsNotNull(select, "select");
            Intrinsics.checkParameterIsNotNull(block, "block");
            this.this$0 = abstractSendChannel;
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        protected Object failure(LockFreeLinkedListNode affected, Object next) {
            Intrinsics.checkParameterIsNotNull(affected, "affected");
            Intrinsics.checkParameterIsNotNull(next, "next");
            if (!(affected instanceof ReceiveOrClosed)) {
                return null;
            }
            if (!(affected instanceof Closed)) {
                affected = null;
            }
            Closed closed = (Closed) affected;
            return closed != null ? closed : AbstractChannelKt.ENQUEUE_FAILED;
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AddLastDesc, kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        protected Object onPrepare(LockFreeLinkedListNode affected, LockFreeLinkedListNode next) {
            Intrinsics.checkParameterIsNotNull(affected, "affected");
            Intrinsics.checkParameterIsNotNull(next, "next");
            return !this.this$0.isBufferFull() ? AbstractChannelKt.ENQUEUE_FAILED : super.onPrepare(affected, next);
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AddLastDesc, kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        protected void finishOnSuccess(LockFreeLinkedListNode affected, LockFreeLinkedListNode next) {
            Intrinsics.checkParameterIsNotNull(affected, "affected");
            Intrinsics.checkParameterIsNotNull(next, "next");
            super.finishOnSuccess(affected, next);
            ((SendSelect) this.node).disposeOnSelect();
        }
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public final SelectClause2<E, SendChannel<E>> getOnSend() {
        return new SelectClause2<E, SendChannel<? super E>>() { // from class: kotlinx.coroutines.channels.AbstractSendChannel$onSend$1
            @Override // kotlinx.coroutines.selects.SelectClause2
            public <R> void registerSelectClause2(SelectInstance<? super R> select, E param, Function2<? super SendChannel<? super E>, ? super Continuation<? super R>, ? extends Object> block) {
                Intrinsics.checkParameterIsNotNull(select, "select");
                Intrinsics.checkParameterIsNotNull(block, "block");
                AbstractSendChannel.this.registerSelectSend(select, param, block);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final <R> void registerSelectSend(SelectInstance<? super R> select, E element, Function2<? super SendChannel<? super E>, ? super Continuation<? super R>, ? extends Object> block) {
        while (!select.isSelected()) {
            if (isFull()) {
                Object performAtomicIfNotSelected = select.performAtomicIfNotSelected(new TryEnqueueSendDesc(this, element, select, block));
                if (performAtomicIfNotSelected == null || performAtomicIfNotSelected == SelectKt.getALREADY_SELECTED()) {
                    return;
                }
                if (performAtomicIfNotSelected != AbstractChannelKt.ENQUEUE_FAILED) {
                    if (!(performAtomicIfNotSelected instanceof Closed)) {
                        throw new IllegalStateException(("performAtomicIfNotSelected(TryEnqueueSendDesc) returned " + performAtomicIfNotSelected).toString());
                    }
                    throw StackTraceRecoveryKt.recoverStackTrace(((Closed) performAtomicIfNotSelected).getSendException());
                }
            } else {
                Object offerSelectInternal = offerSelectInternal(element, select);
                if (offerSelectInternal == SelectKt.getALREADY_SELECTED()) {
                    return;
                }
                if (offerSelectInternal != AbstractChannelKt.OFFER_FAILED) {
                    if (offerSelectInternal == AbstractChannelKt.OFFER_SUCCESS) {
                        UndispatchedKt.startCoroutineUnintercepted(block, this, select.getCompletion());
                        return;
                    } else {
                        if (!(offerSelectInternal instanceof Closed)) {
                            throw new IllegalStateException(("offerSelectInternal returned " + offerSelectInternal).toString());
                        }
                        throw StackTraceRecoveryKt.recoverStackTrace(((Closed) offerSelectInternal).getSendException());
                    }
                }
            }
        }
    }

    public String toString() {
        return DebugKt.getClassSimpleName(this) + '@' + DebugKt.getHexAddress(this) + '{' + getQueueDebugStateString() + '}' + getBufferDebugString();
    }

    private final String getQueueDebugStateString() {
        String str;
        LockFreeLinkedListNode nextNode = this.queue.getNextNode();
        if (nextNode == this.queue) {
            return "EmptyQueue";
        }
        if (nextNode instanceof Closed) {
            str = nextNode.toString();
        } else if (nextNode instanceof Receive) {
            str = "ReceiveQueued";
        } else {
            str = nextNode instanceof Send ? "SendQueued" : "UNEXPECTED:" + nextNode;
        }
        LockFreeLinkedListNode prevNode = this.queue.getPrevNode();
        if (prevNode == nextNode) {
            return str;
        }
        String str2 = str + ",queueSize=" + countQueueSize();
        return prevNode instanceof Closed ? str2 + ",closedForSend=" + prevNode : str2;
    }

    private final int countQueueSize() {
        Object next = this.queue.getNext();
        if (next == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
        }
        int i = 0;
        for (LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) next; !Intrinsics.areEqual(lockFreeLinkedListNode, r0); lockFreeLinkedListNode = lockFreeLinkedListNode.getNextNode()) {
            if (lockFreeLinkedListNode instanceof LockFreeLinkedListNode) {
                i++;
            }
        }
        return i;
    }

    /* compiled from: AbstractChannel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u0001*\u0004\b\u0002\u0010\u00022\u00020\u00032\u00020\u00042\u00020\u0005BX\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00010\t\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00020\u000b\u0012(\u0010\f\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\t\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00070\rø\u0001\u0000¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0007H\u0016J\b\u0010\u0016\u001a\u00020\u0014H\u0016J\u0006\u0010\u0017\u001a\u00020\u0014J\u0014\u0010\u0018\u001a\u00020\u00142\n\u0010\u0019\u001a\u0006\u0012\u0002\b\u00030\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\u0014\u0010\u001d\u001a\u0004\u0018\u00010\u00072\b\u0010\u001e\u001a\u0004\u0018\u00010\u0007H\u0016R7\u0010\f\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\t\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00070\r8\u0006X\u0087\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0010R\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00010\t8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00020\u000b8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001f"}, d2 = {"Lkotlinx/coroutines/channels/AbstractSendChannel$SendSelect;", "E", "R", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/channels/Send;", "Lkotlinx/coroutines/DisposableHandle;", "pollResult", "", "channel", "Lkotlinx/coroutines/channels/SendChannel;", "select", "Lkotlinx/coroutines/selects/SelectInstance;", "block", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "(Ljava/lang/Object;Lkotlinx/coroutines/channels/SendChannel;Lkotlinx/coroutines/selects/SelectInstance;Lkotlin/jvm/functions/Function2;)V", "Lkotlin/jvm/functions/Function2;", "getPollResult", "()Ljava/lang/Object;", "completeResumeSend", "", "token", "dispose", "disposeOnSelect", "resumeSendClosed", "closed", "Lkotlinx/coroutines/channels/Closed;", "toString", "", "tryResumeSend", "idempotent", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 13})
    private static final class SendSelect<E, R> extends LockFreeLinkedListNode implements Send, DisposableHandle {
        public final Function2<SendChannel<? super E>, Continuation<? super R>, Object> block;
        public final SendChannel<E> channel;
        private final Object pollResult;
        public final SelectInstance<R> select;

        @Override // kotlinx.coroutines.channels.Send
        public Object getPollResult() {
            return this.pollResult;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public SendSelect(Object obj, SendChannel<? super E> channel, SelectInstance<? super R> select, Function2<? super SendChannel<? super E>, ? super Continuation<? super R>, ? extends Object> block) {
            Intrinsics.checkParameterIsNotNull(channel, "channel");
            Intrinsics.checkParameterIsNotNull(select, "select");
            Intrinsics.checkParameterIsNotNull(block, "block");
            this.pollResult = obj;
            this.channel = channel;
            this.select = select;
            this.block = block;
        }

        @Override // kotlinx.coroutines.channels.Send
        public Object tryResumeSend(Object idempotent) {
            if (this.select.trySelect(idempotent)) {
                return AbstractChannelKt.SELECT_STARTED;
            }
            return null;
        }

        @Override // kotlinx.coroutines.channels.Send
        public void completeResumeSend(Object token) {
            Intrinsics.checkParameterIsNotNull(token, "token");
            if (!(token == AbstractChannelKt.SELECT_STARTED)) {
                throw new IllegalStateException("Check failed.".toString());
            }
            ContinuationKt.startCoroutine(this.block, this.channel, this.select.getCompletion());
        }

        public final void disposeOnSelect() {
            this.select.disposeOnSelect(this);
        }

        @Override // kotlinx.coroutines.DisposableHandle
        public void dispose() {
            remove();
        }

        @Override // kotlinx.coroutines.channels.Send
        /* renamed from: resumeSendClosed */
        public void mo1369resumeSendClosed(Closed<?> closed) {
            Intrinsics.checkParameterIsNotNull(closed, "closed");
            if (this.select.trySelect(null)) {
                this.select.resumeSelectCancellableWithException(closed.getSendException());
            }
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
        public String toString() {
            return "SendSelect(" + getPollResult() + ")[" + this.channel + ", " + this.select + PropertyUtils.INDEXED_DELIM2;
        }
    }

    /* compiled from: AbstractChannel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u0000*\u0006\b\u0001\u0010\u0001 \u00012\u00020\u00022\u00020\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00028\u0001¢\u0006\u0002\u0010\u0005J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\bH\u0016J\u0014\u0010\u000e\u001a\u00020\f2\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u0010H\u0016J\u0014\u0010\u0011\u001a\u0004\u0018\u00010\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\bH\u0016R\u0012\u0010\u0004\u001a\u00028\u00018\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0013"}, d2 = {"Lkotlinx/coroutines/channels/AbstractSendChannel$SendBuffered;", "E", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/channels/Send;", "element", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "pollResult", "", "getPollResult", "()Ljava/lang/Object;", "completeResumeSend", "", "token", "resumeSendClosed", "closed", "Lkotlinx/coroutines/channels/Closed;", "tryResumeSend", "idempotent", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 13})
    private static final class SendBuffered<E> extends LockFreeLinkedListNode implements Send {
        public final E element;

        @Override // kotlinx.coroutines.channels.Send
        /* renamed from: resumeSendClosed */
        public void mo1369resumeSendClosed(Closed<?> closed) {
            Intrinsics.checkParameterIsNotNull(closed, "closed");
        }

        public SendBuffered(E e) {
            this.element = e;
        }

        @Override // kotlinx.coroutines.channels.Send
        public Object getPollResult() {
            return this.element;
        }

        @Override // kotlinx.coroutines.channels.Send
        public Object tryResumeSend(Object idempotent) {
            return AbstractChannelKt.SEND_RESUMED;
        }

        @Override // kotlinx.coroutines.channels.Send
        public void completeResumeSend(Object token) {
            Intrinsics.checkParameterIsNotNull(token, "token");
            if (!(token == AbstractChannelKt.SEND_RESUMED)) {
                throw new IllegalStateException("Check failed.".toString());
            }
        }
    }

    final /* synthetic */ Object sendSuspend(E e, Continuation<? super Unit> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 0);
        CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        SendElement sendElement = new SendElement(e, cancellableContinuationImpl2);
        while (true) {
            Object enqueueSend = enqueueSend(sendElement);
            if (enqueueSend == null) {
                CancellableContinuationKt.removeOnCancellation(cancellableContinuationImpl2, sendElement);
                break;
            }
            if (enqueueSend instanceof Closed) {
                Closed closed = (Closed) enqueueSend;
                helpClose(closed);
                Throwable sendException = closed.getSendException();
                Result.Companion companion = Result.INSTANCE;
                cancellableContinuationImpl2.resumeWith(Result.m51constructorimpl(ResultKt.createFailure(sendException)));
                break;
            }
            Object offerInternal = offerInternal(e);
            if (offerInternal == AbstractChannelKt.OFFER_SUCCESS) {
                Unit unit = Unit.INSTANCE;
                Result.Companion companion2 = Result.INSTANCE;
                cancellableContinuationImpl2.resumeWith(Result.m51constructorimpl(unit));
                break;
            }
            if (offerInternal != AbstractChannelKt.OFFER_FAILED) {
                if (offerInternal instanceof Closed) {
                    Closed closed2 = (Closed) offerInternal;
                    helpClose(closed2);
                    Throwable sendException2 = closed2.getSendException();
                    Result.Companion companion3 = Result.INSTANCE;
                    cancellableContinuationImpl2.resumeWith(Result.m51constructorimpl(ResultKt.createFailure(sendException2)));
                } else {
                    throw new IllegalStateException(("offerInternal returned " + offerInternal).toString());
                }
            }
        }
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }
}
