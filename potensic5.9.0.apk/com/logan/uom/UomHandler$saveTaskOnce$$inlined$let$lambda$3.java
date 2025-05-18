package com.logan.uom;

import com.logan.uom.enums.UomState;
import com.logan.uom.listeners.OnUomHandleListener;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: UomHandler.kt */
@Metadata(m2336bv = {1, 0, 3}, m2337d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, m2338d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "com/logan/uom/UomHandler$saveTaskOnce$4$1"}, m2339k = 3, m2340mv = {1, 1, 15})
/* loaded from: classes3.dex */
final class UomHandler$saveTaskOnce$$inlined$let$lambda$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ UomState $it;
    int label;

    /* renamed from: p$ */
    private CoroutineScope f2664p$;
    final /* synthetic */ UomHandler this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    UomHandler$saveTaskOnce$$inlined$let$lambda$3(UomState uomState, Continuation continuation, UomHandler uomHandler) {
        super(2, continuation);
        this.$it = uomState;
        this.this$0 = uomHandler;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> completion) {
        Intrinsics.checkParameterIsNotNull(completion, "completion");
        UomHandler$saveTaskOnce$$inlined$let$lambda$3 uomHandler$saveTaskOnce$$inlined$let$lambda$3 = new UomHandler$saveTaskOnce$$inlined$let$lambda$3(this.$it, completion, this.this$0);
        uomHandler$saveTaskOnce$$inlined$let$lambda$3.f2664p$ = (CoroutineScope) obj;
        return uomHandler$saveTaskOnce$$inlined$let$lambda$3;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((UomHandler$saveTaskOnce$$inlined$let$lambda$3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        OnUomHandleListener uomHandleListener = this.this$0.getUomHandleListener();
        if (uomHandleListener != null) {
            uomHandleListener.onUomStateCallback(this.$it);
        }
        return Unit.INSTANCE;
    }
}