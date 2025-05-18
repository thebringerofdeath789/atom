package com.logan.uom;

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
@Metadata(m2336bv = {1, 0, 3}, m2337d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, m2338d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "com/logan/uom/UomHandler$sortiesListener$1$1$1"}, m2339k = 3, m2340mv = {1, 1, 15})
/* loaded from: classes3.dex */
final class UomHandler$sortiesListener$1$$special$$inlined$let$lambda$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    /* renamed from: p$ */
    private CoroutineScope f2665p$;
    final /* synthetic */ UomHandler$sortiesListener$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    UomHandler$sortiesListener$1$$special$$inlined$let$lambda$1(Continuation continuation, UomHandler$sortiesListener$1 uomHandler$sortiesListener$1) {
        super(2, continuation);
        this.this$0 = uomHandler$sortiesListener$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> completion) {
        Intrinsics.checkParameterIsNotNull(completion, "completion");
        UomHandler$sortiesListener$1$$special$$inlined$let$lambda$1 uomHandler$sortiesListener$1$$special$$inlined$let$lambda$1 = new UomHandler$sortiesListener$1$$special$$inlined$let$lambda$1(completion, this.this$0);
        uomHandler$sortiesListener$1$$special$$inlined$let$lambda$1.f2665p$ = (CoroutineScope) obj;
        return uomHandler$sortiesListener$1$$special$$inlined$let$lambda$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((UomHandler$sortiesListener$1$$special$$inlined$let$lambda$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        this.this$0.this$0.saveTaskOnce();
        return Unit.INSTANCE;
    }
}