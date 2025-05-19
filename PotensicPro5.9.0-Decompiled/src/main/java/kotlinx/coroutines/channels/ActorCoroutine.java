package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineExceptionHandlerKt;

/* compiled from: Actor.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\b\u0012\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B#\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0014J\u0012\u0010\u0012\u001a\u00020\u000f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0011H\u0014R\u0014\u0010\u000b\u001a\u00020\t8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u0014"}, d2 = {"Lkotlinx/coroutines/channels/ActorCoroutine;", "E", "Lkotlinx/coroutines/channels/ChannelCoroutine;", "Lkotlinx/coroutines/channels/ActorScope;", "parentContext", "Lkotlin/coroutines/CoroutineContext;", "channel", "Lkotlinx/coroutines/channels/Channel;", "active", "", "(Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/channels/Channel;Z)V", "cancelsParent", "getCancelsParent", "()Z", "handleJobException", "", "exception", "", "onCancellation", "cause", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 13})
/* loaded from: classes4.dex */
class ActorCoroutine<E> extends ChannelCoroutine<E> implements ActorScope<E> {
    @Override // kotlinx.coroutines.channels.ChannelCoroutine, kotlinx.coroutines.JobSupport
    protected boolean getCancelsParent() {
        return true;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ActorCoroutine(CoroutineContext parentContext, Channel<E> channel, boolean z) {
        super(parentContext, channel, z);
        Intrinsics.checkParameterIsNotNull(parentContext, "parentContext");
        Intrinsics.checkParameterIsNotNull(channel, "channel");
    }

    @Override // kotlinx.coroutines.AbstractCoroutine, kotlinx.coroutines.JobSupport
    protected void onCancellation(Throwable cause) {
        get_channel().cancel(cause);
    }

    @Override // kotlinx.coroutines.JobSupport
    protected void handleJobException(Throwable exception) {
        Intrinsics.checkParameterIsNotNull(exception, "exception");
        CoroutineExceptionHandlerKt.handleExceptionViaHandler(this.parentContext, exception);
    }
}
