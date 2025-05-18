package com.logan.uom;

import androidx.lifecycle.Observer;
import com.ipotensic.baselib.livedata.DataChangedLiveData;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: UomHandler.kt */
@Metadata(m2336bv = {1, 0, 3}, m2337d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, m2338d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, m2339k = 3, m2340mv = {1, 1, 15})
@DebugMetadata(m2346c = "com.logan.uom.UomHandler$init$1", m2347f = "UomHandler.kt", m2348i = {}, m2349l = {}, m2350m = "invokeSuspend", m2351n = {}, m2352s = {})
/* loaded from: classes3.dex */
final class UomHandler$init$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    /* renamed from: p$ */
    private CoroutineScope f2666p$;
    final /* synthetic */ UomHandler this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    UomHandler$init$1(UomHandler uomHandler, Continuation continuation) {
        super(2, continuation);
        this.this$0 = uomHandler;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> completion) {
        Intrinsics.checkParameterIsNotNull(completion, "completion");
        UomHandler$init$1 uomHandler$init$1 = new UomHandler$init$1(this.this$0, completion);
        uomHandler$init$1.f2666p$ = (CoroutineScope) obj;
        return uomHandler$init$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((UomHandler$init$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        DataChangedLiveData dataChangedLiveData;
        Observer observer;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        dataChangedLiveData = this.this$0.sorties;
        observer = this.this$0.sortiesListener;
        dataChangedLiveData.observeForever(observer);
        return Unit.INSTANCE;
    }
}