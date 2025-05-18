package com.ipotensic.kernel.model;

import com.ipotensic.kernel.maps.bean.NoFlyZoneSubModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: KernelViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0005\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "com/ipotensic/kernel/model/KernelViewModel$updateNoFlyZone$1$2$1$3$1", "com/ipotensic/kernel/model/KernelViewModel$updateNoFlyZone$1$$special$$inlined$let$lambda$3", "com/ipotensic/kernel/model/KernelViewModel$updateNoFlyZone$1$$special$$inlined$map$lambda$5"}, k = 3, mv = {1, 1, 15})
/* loaded from: classes2.dex */
final class KernelViewModel$updateNoFlyZone$1$invokeSuspend$$inlined$map$lambda$5 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ NoFlyZoneSubModel $subModel$inlined;
    int label;
    private CoroutineScope p$;
    final /* synthetic */ KernelViewModel$updateNoFlyZone$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    KernelViewModel$updateNoFlyZone$1$invokeSuspend$$inlined$map$lambda$5(Continuation continuation, NoFlyZoneSubModel noFlyZoneSubModel, KernelViewModel$updateNoFlyZone$1 kernelViewModel$updateNoFlyZone$1) {
        super(2, continuation);
        this.$subModel$inlined = noFlyZoneSubModel;
        this.this$0 = kernelViewModel$updateNoFlyZone$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> completion) {
        Intrinsics.checkParameterIsNotNull(completion, "completion");
        KernelViewModel$updateNoFlyZone$1$invokeSuspend$$inlined$map$lambda$5 kernelViewModel$updateNoFlyZone$1$invokeSuspend$$inlined$map$lambda$5 = new KernelViewModel$updateNoFlyZone$1$invokeSuspend$$inlined$map$lambda$5(completion, this.$subModel$inlined, this.this$0);
        kernelViewModel$updateNoFlyZone$1$invokeSuspend$$inlined$map$lambda$5.p$ = (CoroutineScope) obj;
        return kernelViewModel$updateNoFlyZone$1$invokeSuspend$$inlined$map$lambda$5;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((KernelViewModel$updateNoFlyZone$1$invokeSuspend$$inlined$map$lambda$5) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        this.this$0.this$0.getAddNoFlyZoneData().setValue(this.$subModel$inlined);
        return Unit.INSTANCE;
    }
}