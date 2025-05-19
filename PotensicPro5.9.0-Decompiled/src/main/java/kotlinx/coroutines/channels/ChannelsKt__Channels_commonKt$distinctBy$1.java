package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Add missing generic type declarations: [E] */
/* compiled from: Channels.common.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u0004H\u008a@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "E", "K", "Lkotlinx/coroutines/channels/ProducerScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, 13})
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$distinctBy$1", f = "Channels.common.kt", i = {0, 1, 2, 2, 3, 3, 3}, l = {1461, 1461, 1462, 1464}, m = "invokeSuspend", n = {"keys", "keys", "keys", "e", "keys", "e", "k"}, s = {"L$1", "L$1", "L$1", "L$2", "L$1", "L$2", "L$4"})
/* loaded from: classes4.dex */
final class ChannelsKt__Channels_commonKt$distinctBy$1<E> extends SuspendLambda implements Function2<ProducerScope<? super E>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2 $selector;
    final /* synthetic */ ReceiveChannel $this_distinctBy;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    private ProducerScope p$;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ChannelsKt__Channels_commonKt$distinctBy$1(ReceiveChannel receiveChannel, Function2 function2, Continuation continuation) {
        super(2, continuation);
        this.$this_distinctBy = receiveChannel;
        this.$selector = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> completion) {
        Intrinsics.checkParameterIsNotNull(completion, "completion");
        ChannelsKt__Channels_commonKt$distinctBy$1 channelsKt__Channels_commonKt$distinctBy$1 = new ChannelsKt__Channels_commonKt$distinctBy$1(this.$this_distinctBy, this.$selector, completion);
        channelsKt__Channels_commonKt$distinctBy$1.p$ = (ProducerScope) obj;
        return channelsKt__Channels_commonKt$distinctBy$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Continuation<? super Unit> continuation) {
        return ((ChannelsKt__Channels_commonKt$distinctBy$1) create(obj, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:14:0x00a5 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00d5 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0101  */
    /* JADX WARN: Type inference failed for: r14v16, types: [java.util.Collection] */
    /* JADX WARN: Type inference failed for: r9v0, types: [java.lang.Object, kotlinx.coroutines.channels.ProducerScope] */
    /* JADX WARN: Type inference failed for: r9v3 */
    /* JADX WARN: Type inference failed for: r9v7 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x00e1 -> B:11:0x00fd). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x00f6 -> B:10:0x00f7). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r14) {
        /*
            Method dump skipped, instructions count: 265
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$distinctBy$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
