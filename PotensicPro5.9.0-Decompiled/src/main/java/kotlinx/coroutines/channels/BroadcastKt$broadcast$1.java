package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Add missing generic type declarations: [E] */
/* compiled from: Broadcast.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u008a@ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "E", "Lkotlinx/coroutines/channels/ProducerScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, 13})
@DebugMetadata(c = "kotlinx.coroutines.channels.BroadcastKt$broadcast$1", f = "Broadcast.kt", i = {2}, l = {29, 29, 30}, m = "invokeSuspend", n = {"e"}, s = {"L$1"})
/* loaded from: classes4.dex */
final class BroadcastKt$broadcast$1<E> extends SuspendLambda implements Function2<ProducerScope<? super E>, Continuation<? super Unit>, Object> {
    final /* synthetic */ ReceiveChannel $this_broadcast;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    private ProducerScope p$;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BroadcastKt$broadcast$1(ReceiveChannel receiveChannel, Continuation continuation) {
        super(2, continuation);
        this.$this_broadcast = receiveChannel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> completion) {
        Intrinsics.checkParameterIsNotNull(completion, "completion");
        BroadcastKt$broadcast$1 broadcastKt$broadcast$1 = new BroadcastKt$broadcast$1(this.$this_broadcast, completion);
        broadcastKt$broadcast$1.p$ = (ProducerScope) obj;
        return broadcastKt$broadcast$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Continuation<? super Unit> continuation) {
        return ((BroadcastKt$broadcast$1) create(obj, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0071 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x009b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00a1  */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.lang.Object, kotlinx.coroutines.channels.ProducerScope] */
    /* JADX WARN: Type inference failed for: r6v7 */
    /* JADX WARN: Type inference failed for: r6v9 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x009c -> B:12:0x0065). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) {
        /*
            r8 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r8.label
            r2 = 3
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L57
            if (r1 == r4) goto L41
            if (r1 == r3) goto L2b
            if (r1 != r2) goto L23
            java.lang.Object r1 = r8.L$2
            kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
            java.lang.Object r5 = r8.L$0
            kotlinx.coroutines.channels.ProducerScope r5 = (kotlinx.coroutines.channels.ProducerScope) r5
            boolean r6 = r9 instanceof kotlin.Result.Failure
            if (r6 != 0) goto L1e
            goto L64
        L1e:
            kotlin.Result$Failure r9 = (kotlin.Result.Failure) r9
            java.lang.Throwable r9 = r9.exception
            throw r9
        L23:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L2b:
            java.lang.Object r1 = r8.L$1
            kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
            java.lang.Object r5 = r8.L$0
            kotlinx.coroutines.channels.ProducerScope r5 = (kotlinx.coroutines.channels.ProducerScope) r5
            boolean r6 = r9 instanceof kotlin.Result.Failure
            if (r6 != 0) goto L3c
            r6 = r5
            r5 = r1
            r1 = r0
            r0 = r8
            goto L8d
        L3c:
            kotlin.Result$Failure r9 = (kotlin.Result.Failure) r9
            java.lang.Throwable r9 = r9.exception
            throw r9
        L41:
            java.lang.Object r1 = r8.L$1
            kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
            java.lang.Object r5 = r8.L$0
            kotlinx.coroutines.channels.ProducerScope r5 = (kotlinx.coroutines.channels.ProducerScope) r5
            boolean r6 = r9 instanceof kotlin.Result.Failure
            if (r6 != 0) goto L52
            r6 = r5
            r5 = r1
            r1 = r0
            r0 = r8
            goto L78
        L52:
            kotlin.Result$Failure r9 = (kotlin.Result.Failure) r9
            java.lang.Throwable r9 = r9.exception
            throw r9
        L57:
            boolean r1 = r9 instanceof kotlin.Result.Failure
            if (r1 != 0) goto La4
            kotlinx.coroutines.channels.ProducerScope r9 = r8.p$
            kotlinx.coroutines.channels.ReceiveChannel r1 = r8.$this_broadcast
            kotlinx.coroutines.channels.ChannelIterator r1 = r1.iterator()
            r5 = r9
        L64:
            r9 = r8
        L65:
            r9.L$0 = r5
            r9.L$1 = r1
            r9.label = r4
            java.lang.Object r6 = r1.hasNext(r9)
            if (r6 != r0) goto L72
            return r0
        L72:
            r7 = r0
            r0 = r9
            r9 = r6
            r6 = r5
            r5 = r1
            r1 = r7
        L78:
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            if (r9 == 0) goto La1
            r0.L$0 = r6
            r0.L$1 = r5
            r0.label = r3
            java.lang.Object r9 = r5.next(r0)
            if (r9 != r1) goto L8d
            return r1
        L8d:
            r0.L$0 = r6
            r0.L$1 = r9
            r0.L$2 = r5
            r0.label = r2
            java.lang.Object r9 = r6.send(r9, r0)
            if (r9 != r1) goto L9c
            return r1
        L9c:
            r9 = r0
            r0 = r1
            r1 = r5
            r5 = r6
            goto L65
        La1:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        La4:
            kotlin.Result$Failure r9 = (kotlin.Result.Failure) r9
            java.lang.Throwable r9 = r9.exception
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BroadcastKt$broadcast$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
