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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u008a@ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "E", "Lkotlinx/coroutines/channels/ProducerScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, 13})
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$drop$1", f = "Channels.common.kt", i = {0, 1, 2, 3, 4, 4}, l = {592, 592, 597, 597, 598}, m = "invokeSuspend", n = {"remaining", "remaining", "remaining", "remaining", "remaining", "e"}, s = {"I$0", "I$0", "I$0", "I$0", "I$0", "L$1"})
/* loaded from: classes4.dex */
final class ChannelsKt__Channels_commonKt$drop$1<E> extends SuspendLambda implements Function2<ProducerScope<? super E>, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $n;
    final /* synthetic */ ReceiveChannel $this_drop;
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    private ProducerScope p$;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ChannelsKt__Channels_commonKt$drop$1(ReceiveChannel receiveChannel, int i, Continuation continuation) {
        super(2, continuation);
        this.$this_drop = receiveChannel;
        this.$n = i;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> completion) {
        Intrinsics.checkParameterIsNotNull(completion, "completion");
        ChannelsKt__Channels_commonKt$drop$1 channelsKt__Channels_commonKt$drop$1 = new ChannelsKt__Channels_commonKt$drop$1(this.$this_drop, this.$n, completion);
        channelsKt__Channels_commonKt$drop$1.p$ = (ProducerScope) obj;
        return channelsKt__Channels_commonKt$drop$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Continuation<? super Unit> continuation) {
        return ((ChannelsKt__Channels_commonKt$drop$1) create(obj, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:13:0x00f9 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0121 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00b4 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00dd  */
    /* JADX WARN: Type inference failed for: r6v15 */
    /* JADX WARN: Type inference failed for: r6v16 */
    /* JADX WARN: Type inference failed for: r6v2, types: [java.lang.Object, kotlinx.coroutines.channels.ProducerScope] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x011f -> B:11:0x00eb). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:56:0x00d2 -> B:42:0x00d3). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r13) {
        /*
            Method dump skipped, instructions count: 337
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$drop$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
