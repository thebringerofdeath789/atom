package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.TickerChannelsKt;

/* compiled from: TickerChannels.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00010\u0002H\u008a@ø\u0001\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/channels/ProducerScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, 13})
@DebugMetadata(c = "kotlinx.coroutines.channels.TickerChannelsKt$ticker$3", f = "TickerChannels.kt", i = {}, l = {72, 73}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes4.dex */
final class TickerChannelsKt$ticker$3 extends SuspendLambda implements Function2<ProducerScope<? super Unit>, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $delayMillis;
    final /* synthetic */ long $initialDelayMillis;
    final /* synthetic */ TickerMode $mode;
    int label;
    private ProducerScope p$;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TickerChannelsKt$ticker$3(TickerMode tickerMode, long j, long j2, Continuation continuation) {
        super(2, continuation);
        this.$mode = tickerMode;
        this.$delayMillis = j;
        this.$initialDelayMillis = j2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> completion) {
        Intrinsics.checkParameterIsNotNull(completion, "completion");
        TickerChannelsKt$ticker$3 tickerChannelsKt$ticker$3 = new TickerChannelsKt$ticker$3(this.$mode, this.$delayMillis, this.$initialDelayMillis, completion);
        tickerChannelsKt$ticker$3.p$ = (ProducerScope) obj;
        return tickerChannelsKt$ticker$3;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(ProducerScope<? super Unit> producerScope, Continuation<? super Unit> continuation) {
        return ((TickerChannelsKt$ticker$3) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                if (obj instanceof Result.Failure) {
                    throw ((Result.Failure) obj).exception;
                }
            } else if (obj instanceof Result.Failure) {
                throw ((Result.Failure) obj).exception;
            }
        } else {
            if (obj instanceof Result.Failure) {
                throw ((Result.Failure) obj).exception;
            }
            ProducerScope producerScope = this.p$;
            int i2 = TickerChannelsKt.WhenMappings.$EnumSwitchMapping$0[this.$mode.ordinal()];
            if (i2 == 1) {
                long j = this.$delayMillis;
                long j2 = this.$initialDelayMillis;
                SendChannel channel = producerScope.getChannel();
                this.label = 1;
                if (TickerChannelsKt.fixedPeriodTicker(j, j2, channel, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i2 == 2) {
                long j3 = this.$delayMillis;
                long j4 = this.$initialDelayMillis;
                SendChannel channel2 = producerScope.getChannel();
                this.label = 2;
                if (TickerChannelsKt.fixedDelayTicker(j3, j4, channel2, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        }
        return Unit.INSTANCE;
    }
}
