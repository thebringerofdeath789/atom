package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import org.apache.commons.beanutils.PropertyUtils;

/* compiled from: AbstractChannel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0000\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00020\u00022\u00020\u00032\b\u0012\u0004\u0012\u0002H\u00010\u0004B\u000f\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0014\u0010\u0017\u001a\u00020\u00182\n\u0010\u0019\u001a\u0006\u0012\u0002\b\u00030\u0000H\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0016J!\u0010\u001c\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u001d\u001a\u00028\u00002\b\u0010\u001e\u001a\u0004\u0018\u00010\u0015H\u0016¢\u0006\u0002\u0010\u001fJ\u0014\u0010 \u001a\u0004\u0018\u00010\u00152\b\u0010\u001e\u001a\u0004\u0018\u00010\u0015H\u0016R\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\nR\u0011\u0010\r\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000f¨\u0006!"}, d2 = {"Lkotlinx/coroutines/channels/Closed;", "E", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/channels/Send;", "Lkotlinx/coroutines/channels/ReceiveOrClosed;", "closeCause", "", "(Ljava/lang/Throwable;)V", "offerResult", "getOfferResult", "()Lkotlinx/coroutines/channels/Closed;", "pollResult", "getPollResult", "receiveException", "getReceiveException", "()Ljava/lang/Throwable;", "sendException", "getSendException", "completeResumeReceive", "", "token", "", "completeResumeSend", "resumeSendClosed", "", "closed", "toString", "", "tryResumeReceive", "value", "idempotent", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "tryResumeSend", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 13})
/* loaded from: classes4.dex */
public final class Closed<E> extends LockFreeLinkedListNode implements Send, ReceiveOrClosed<E> {
    public final Throwable closeCause;

    @Override // kotlinx.coroutines.channels.ReceiveOrClosed
    public Closed<E> getOfferResult() {
        return this;
    }

    @Override // kotlinx.coroutines.channels.Send
    public Closed<E> getPollResult() {
        return this;
    }

    @Override // kotlinx.coroutines.channels.Send
    /* renamed from: resumeSendClosed, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ void mo1369resumeSendClosed(Closed closed) {
        resumeSendClosed((Closed<?>) closed);
    }

    public Closed(Throwable th) {
        this.closeCause = th;
    }

    public final Throwable getSendException() {
        Throwable th = this.closeCause;
        return th != null ? th : new ClosedSendChannelException(ChannelsKt.DEFAULT_CLOSE_MESSAGE);
    }

    public final Throwable getReceiveException() {
        Throwable th = this.closeCause;
        return th != null ? th : new ClosedReceiveChannelException(ChannelsKt.DEFAULT_CLOSE_MESSAGE);
    }

    @Override // kotlinx.coroutines.channels.Send
    public Object tryResumeSend(Object idempotent) {
        return AbstractChannelKt.CLOSE_RESUMED;
    }

    @Override // kotlinx.coroutines.channels.Send
    public void completeResumeSend(Object token) {
        Intrinsics.checkParameterIsNotNull(token, "token");
        if (!(token == AbstractChannelKt.CLOSE_RESUMED)) {
            throw new IllegalStateException("Check failed.".toString());
        }
    }

    @Override // kotlinx.coroutines.channels.ReceiveOrClosed
    public Object tryResumeReceive(E value, Object idempotent) {
        return AbstractChannelKt.CLOSE_RESUMED;
    }

    @Override // kotlinx.coroutines.channels.ReceiveOrClosed
    public void completeResumeReceive(Object token) {
        Intrinsics.checkParameterIsNotNull(token, "token");
        if (!(token == AbstractChannelKt.CLOSE_RESUMED)) {
            throw new IllegalStateException("Check failed.".toString());
        }
    }

    public Void resumeSendClosed(Closed<?> closed) {
        Intrinsics.checkParameterIsNotNull(closed, "closed");
        throw new IllegalStateException("Should be never invoked".toString());
    }

    @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
    public String toString() {
        return "Closed[" + this.closeCause + PropertyUtils.INDEXED_DELIM2;
    }
}
