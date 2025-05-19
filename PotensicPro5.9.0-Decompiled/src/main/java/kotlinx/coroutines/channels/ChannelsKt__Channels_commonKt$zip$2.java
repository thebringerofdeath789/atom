package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Add missing generic type declarations: [V] */
/* compiled from: Channels.common.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u0005H\u008a@ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "", "E", "R", "V", "Lkotlinx/coroutines/channels/ProducerScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, 13})
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$zip$2", f = "Channels.common.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4}, l = {1900, 1900, 1888, 1889, 1890}, m = "invokeSuspend", n = {"otherIterator", "$receiver$iv", "$receiver$iv$iv", "cause$iv$iv", "$receiver$iv", "otherIterator", "$receiver$iv", "$receiver$iv$iv", "cause$iv$iv", "$receiver$iv", "otherIterator", "$receiver$iv", "$receiver$iv$iv", "cause$iv$iv", "$receiver$iv", "e$iv", "element1", "otherIterator", "$receiver$iv", "$receiver$iv$iv", "cause$iv$iv", "$receiver$iv", "e$iv", "element1", "otherIterator", "$receiver$iv", "$receiver$iv$iv", "cause$iv$iv", "$receiver$iv", "e$iv", "element1", "element2"}, s = {"L$1", "L$2", "L$4", "L$5", "L$6", "L$1", "L$2", "L$4", "L$5", "L$6", "L$1", "L$2", "L$4", "L$5", "L$6", "L$8", "L$9", "L$1", "L$2", "L$4", "L$5", "L$6", "L$8", "L$9", "L$1", "L$2", "L$4", "L$5", "L$6", "L$8", "L$9", "L$10"})
/* loaded from: classes4.dex */
final class ChannelsKt__Channels_commonKt$zip$2<V> extends SuspendLambda implements Function2<ProducerScope<? super V>, Continuation<? super Unit>, Object> {
    final /* synthetic */ ReceiveChannel $other;
    final /* synthetic */ ReceiveChannel $this_zip;
    final /* synthetic */ Function2 $transform;
    Object L$0;
    Object L$1;
    Object L$10;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    Object L$8;
    Object L$9;
    int label;
    private ProducerScope p$;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ChannelsKt__Channels_commonKt$zip$2(ReceiveChannel receiveChannel, ReceiveChannel receiveChannel2, Function2 function2, Continuation continuation) {
        super(2, continuation);
        this.$this_zip = receiveChannel;
        this.$other = receiveChannel2;
        this.$transform = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> completion) {
        Intrinsics.checkParameterIsNotNull(completion, "completion");
        ChannelsKt__Channels_commonKt$zip$2 channelsKt__Channels_commonKt$zip$2 = new ChannelsKt__Channels_commonKt$zip$2(this.$this_zip, this.$other, this.$transform, completion);
        channelsKt__Channels_commonKt$zip$2.p$ = (ProducerScope) obj;
        return channelsKt__Channels_commonKt$zip$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Continuation<? super Unit> continuation) {
        return ((ChannelsKt__Channels_commonKt$zip$2) create(obj, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0178 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x018f A[Catch: all -> 0x0090, TRY_LEAVE, TryCatch #0 {all -> 0x0090, blocks: (B:20:0x0187, B:22:0x018f, B:30:0x01d7, B:33:0x01e7, B:40:0x0249, B:49:0x0078, B:52:0x008b, B:53:0x008f), top: B:48:0x0078 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x01cd A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x01ce  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x01e7 A[Catch: all -> 0x0090, TRY_LEAVE, TryCatch #0 {all -> 0x0090, blocks: (B:20:0x0187, B:22:0x018f, B:30:0x01d7, B:33:0x01e7, B:40:0x0249, B:49:0x0078, B:52:0x008b, B:53:0x008f), top: B:48:0x0078 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0235 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0249 A[Catch: all -> 0x0090, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x0090, blocks: (B:20:0x0187, B:22:0x018f, B:30:0x01d7, B:33:0x01e7, B:40:0x0249, B:49:0x0078, B:52:0x008b, B:53:0x008f), top: B:48:0x0078 }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x01df -> B:14:0x023f). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x0233 -> B:13:0x0236). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r19) {
        /*
            Method dump skipped, instructions count: 605
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$zip$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
