package kotlinx.coroutines.channels;

import io.netty.handler.codec.rtsp.RtspHeaders;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.AbstractCoroutine;
import kotlinx.coroutines.CompletedExceptionally;
import kotlinx.coroutines.CoroutineExceptionHandlerKt;
import kotlinx.coroutines.selects.SelectClause2;

/* compiled from: Broadcast.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0012\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0012\u0004\u0012\u0002H\u00010\u00042\b\u0012\u0004\u0012\u0002H\u00010\u0005B#\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0012\u0010\u001c\u001a\u00020\n2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u0013\u0010\u001f\u001a\u00020\n2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0096\u0001J.\u0010 \u001a\u00020\u00032#\u0010!\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u001e¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u00030\"H\u0097\u0001J\u0016\u0010%\u001a\u00020\n2\u0006\u0010&\u001a\u00028\u0000H\u0096\u0001¢\u0006\u0002\u0010'J'\u0010(\u001a\u00020\u00032\b\u0010)\u001a\u0004\u0018\u00010*2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\nH\u0010¢\u0006\u0002\b.J\u000f\u0010/\u001a\b\u0012\u0004\u0012\u00028\u000000H\u0096\u0001J\u0019\u00101\u001a\u00020\u00032\u0006\u0010&\u001a\u00028\u0000H\u0096Aø\u0001\u0000¢\u0006\u0002\u00102R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\n8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0010R\u0014\u0010\u0016\u001a\u00020\n8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0010R\u0014\u0010\u0017\u001a\u00020\n8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0010R$\u0010\u0018\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00120\u0019X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b\u0082\u0002\u0004\n\u0002\b\u0019¨\u00063"}, d2 = {"Lkotlinx/coroutines/channels/BroadcastCoroutine;", "E", "Lkotlinx/coroutines/AbstractCoroutine;", "", "Lkotlinx/coroutines/channels/ProducerScope;", "Lkotlinx/coroutines/channels/BroadcastChannel;", "parentContext", "Lkotlin/coroutines/CoroutineContext;", "_channel", "active", "", "(Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/channels/BroadcastChannel;Z)V", "get_channel", "()Lkotlinx/coroutines/channels/BroadcastChannel;", "cancelsParent", "getCancelsParent", "()Z", "channel", "Lkotlinx/coroutines/channels/SendChannel;", "getChannel", "()Lkotlinx/coroutines/channels/SendChannel;", "isActive", "isClosedForSend", "isFull", "onSend", "Lkotlinx/coroutines/selects/SelectClause2;", "getOnSend", "()Lkotlinx/coroutines/selects/SelectClause2;", "cancel", "cause", "", "close", "invokeOnClose", "handler", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "offer", "element", "(Ljava/lang/Object;)Z", "onCompletionInternal", "state", "", RtspHeaders.Values.MODE, "", "suppressed", "onCompletionInternal$kotlinx_coroutines_core", "openSubscription", "Lkotlinx/coroutines/channels/ReceiveChannel;", "send", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 13})
/* loaded from: classes4.dex */
class BroadcastCoroutine<E> extends AbstractCoroutine<Unit> implements ProducerScope<E>, BroadcastChannel<E> {
    private final BroadcastChannel<E> _channel;

    static /* synthetic */ Object send$suspendImpl(BroadcastCoroutine broadcastCoroutine, Object obj, Continuation continuation) {
        return broadcastCoroutine._channel.send(obj, continuation);
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public boolean close(Throwable cause) {
        return this._channel.close(cause);
    }

    @Override // kotlinx.coroutines.JobSupport
    protected boolean getCancelsParent() {
        return true;
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public SelectClause2<E, SendChannel<E>> getOnSend() {
        return this._channel.getOnSend();
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public void invokeOnClose(Function1<? super Throwable, Unit> handler) {
        Intrinsics.checkParameterIsNotNull(handler, "handler");
        this._channel.invokeOnClose(handler);
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public boolean isClosedForSend() {
        return this._channel.isClosedForSend();
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public boolean isFull() {
        return this._channel.isFull();
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public boolean offer(E element) {
        return this._channel.offer(element);
    }

    @Override // kotlinx.coroutines.channels.BroadcastChannel
    public ReceiveChannel<E> openSubscription() {
        return this._channel.openSubscription();
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public Object send(E e, Continuation<? super Unit> continuation) {
        return send$suspendImpl(this, e, continuation);
    }

    protected final BroadcastChannel<E> get_channel() {
        return this._channel;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BroadcastCoroutine(CoroutineContext parentContext, BroadcastChannel<E> _channel, boolean z) {
        super(parentContext, z);
        Intrinsics.checkParameterIsNotNull(parentContext, "parentContext");
        Intrinsics.checkParameterIsNotNull(_channel, "_channel");
        this._channel = _channel;
    }

    @Override // kotlinx.coroutines.AbstractCoroutine, kotlinx.coroutines.JobSupport, kotlinx.coroutines.Job
    public boolean isActive() {
        return super.isActive();
    }

    @Override // kotlinx.coroutines.channels.ProducerScope
    public SendChannel<E> getChannel() {
        return this;
    }

    @Override // kotlinx.coroutines.JobSupport, kotlinx.coroutines.Job
    public boolean cancel(Throwable cause) {
        boolean cancel = this._channel.cancel(cause);
        if (cancel) {
            super.cancel(cause);
        }
        return cancel;
    }

    @Override // kotlinx.coroutines.AbstractCoroutine, kotlinx.coroutines.JobSupport
    public void onCompletionInternal$kotlinx_coroutines_core(Object state, int mode, boolean suppressed) {
        if (!(state instanceof CompletedExceptionally)) {
            state = null;
        }
        CompletedExceptionally completedExceptionally = (CompletedExceptionally) state;
        Throwable th = completedExceptionally != null ? completedExceptionally.cause : null;
        boolean close = this._channel.close(th);
        if (th == null || close || !suppressed) {
            return;
        }
        CoroutineExceptionHandlerKt.handleExceptionViaHandler(get$context(), th);
    }
}
