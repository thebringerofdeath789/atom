package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.selects.SelectInstance;
import kotlinx.coroutines.selects.SelectKt;

/* compiled from: ConflatedChannel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0015\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010\rJ!\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00028\u00002\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u0010H\u0014¢\u0006\u0002\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0014R\u0014\u0010\u0004\u001a\u00020\u00058DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00058DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00058DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u00058DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0006¨\u0006\u0016"}, d2 = {"Lkotlinx/coroutines/channels/ConflatedChannel;", "E", "Lkotlinx/coroutines/channels/AbstractChannel;", "()V", "isBufferAlwaysEmpty", "", "()Z", "isBufferAlwaysFull", "isBufferEmpty", "isBufferFull", "offerInternal", "", "element", "(Ljava/lang/Object;)Ljava/lang/Object;", "offerSelectInternal", "select", "Lkotlinx/coroutines/selects/SelectInstance;", "(Ljava/lang/Object;Lkotlinx/coroutines/selects/SelectInstance;)Ljava/lang/Object;", "onClosedIdempotent", "", "closed", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 13})
/* loaded from: classes4.dex */
public class ConflatedChannel<E> extends AbstractChannel<E> {
    @Override // kotlinx.coroutines.channels.AbstractChannel
    protected final boolean isBufferAlwaysEmpty() {
        return true;
    }

    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    protected final boolean isBufferAlwaysFull() {
        return false;
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel
    protected final boolean isBufferEmpty() {
        return true;
    }

    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    protected final boolean isBufferFull() {
        return false;
    }

    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    protected void onClosedIdempotent(LockFreeLinkedListNode closed) {
        Intrinsics.checkParameterIsNotNull(closed, "closed");
        conflatePreviousSendBuffered(closed);
    }

    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    protected Object offerInternal(E element) {
        Object sendConflated;
        do {
            Object offerInternal = super.offerInternal(element);
            if (offerInternal == AbstractChannelKt.OFFER_SUCCESS) {
                return AbstractChannelKt.OFFER_SUCCESS;
            }
            if (offerInternal == AbstractChannelKt.OFFER_FAILED) {
                sendConflated = sendConflated(element);
                if (sendConflated == null) {
                    return AbstractChannelKt.OFFER_SUCCESS;
                }
            } else {
                if (offerInternal instanceof Closed) {
                    conflatePreviousSendBuffered((LockFreeLinkedListNode) offerInternal);
                    return offerInternal;
                }
                throw new IllegalStateException(("Invalid offerInternal result " + offerInternal).toString());
            }
        } while (!(sendConflated instanceof Closed));
        conflatePreviousSendBuffered((LockFreeLinkedListNode) sendConflated);
        return sendConflated;
    }

    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    protected Object offerSelectInternal(E element, SelectInstance<?> select) {
        Object performAtomicTrySelect;
        Intrinsics.checkParameterIsNotNull(select, "select");
        do {
            if (getHasReceiveOrClosed()) {
                performAtomicTrySelect = super.offerSelectInternal(element, select);
            } else {
                performAtomicTrySelect = select.performAtomicTrySelect(describeSendConflated(element));
                if (performAtomicTrySelect == null) {
                    performAtomicTrySelect = AbstractChannelKt.OFFER_SUCCESS;
                }
            }
            if (performAtomicTrySelect == SelectKt.getALREADY_SELECTED()) {
                return SelectKt.getALREADY_SELECTED();
            }
            if (performAtomicTrySelect == AbstractChannelKt.OFFER_SUCCESS) {
                return AbstractChannelKt.OFFER_SUCCESS;
            }
        } while (performAtomicTrySelect == AbstractChannelKt.OFFER_FAILED);
        if (performAtomicTrySelect instanceof Closed) {
            conflatePreviousSendBuffered((LockFreeLinkedListNode) performAtomicTrySelect);
            return performAtomicTrySelect;
        }
        throw new IllegalStateException(("Invalid result " + performAtomicTrySelect).toString());
    }
}
