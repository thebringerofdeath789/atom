package com.ipotensic.kernel.model;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: KernelViewModel.kt */
@Metadata(m2336bv = {1, 0, 3}, m2337d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, m2338d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, m2339k = 3, m2340mv = {1, 1, 15})
@DebugMetadata(m2346c = "com.ipotensic.kernel.model.KernelViewModel$updateBeginnerMode$1", m2347f = "KernelViewModel.kt", m2348i = {0, 0}, m2349l = {730}, m2350m = "invokeSuspend", m2351n = {"$this$launch", "it"}, m2352s = {"L$0", "I$2"})
/* loaded from: classes2.dex */
final class KernelViewModel$updateBeginnerMode$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int I$0;
    int I$1;
    int I$2;
    Object L$0;
    int label;

    /* renamed from: p$ */
    private CoroutineScope f2231p$;
    final /* synthetic */ KernelViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    KernelViewModel$updateBeginnerMode$1(KernelViewModel kernelViewModel, Continuation continuation) {
        super(2, continuation);
        this.this$0 = kernelViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> completion) {
        Intrinsics.checkParameterIsNotNull(completion, "completion");
        KernelViewModel$updateBeginnerMode$1 kernelViewModel$updateBeginnerMode$1 = new KernelViewModel$updateBeginnerMode$1(this.this$0, completion);
        kernelViewModel$updateBeginnerMode$1.f2231p$ = (CoroutineScope) obj;
        return kernelViewModel$updateBeginnerMode$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((KernelViewModel$updateBeginnerMode$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0097, code lost:
    
        r10.this$0.beginnerModeJob = (kotlinx.coroutines.Job) null;
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x002c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0094 -> B:5:0x0097). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:8:0x003a -> B:5:0x0097). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r10) {
        /*
            r9 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r9.label
            r2 = 1
            if (r1 == 0) goto L21
            if (r1 != r2) goto L19
            int r1 = r9.I$1
            int r3 = r9.I$0
            java.lang.Object r4 = r9.L$0
            kotlinx.coroutines.CoroutineScope r4 = (kotlinx.coroutines.CoroutineScope) r4
            kotlin.ResultKt.throwOnFailure(r10)
            r10 = r9
            goto L97
        L19:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L21:
            kotlin.ResultKt.throwOnFailure(r10)
            kotlinx.coroutines.CoroutineScope r10 = r9.f2231p$
            r1 = 4
            r3 = 0
            r4 = r10
            r10 = r9
        L2a:
            if (r3 >= r1) goto L99
            java.lang.Integer r5 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r3)
            java.lang.Number r5 = (java.lang.Number) r5
            int r5 = r5.intValue()
            boolean r6 = kotlinx.coroutines.CoroutineScopeKt.isActive(r4)
            if (r6 == 0) goto L97
            com.logan.flight.data.FlightRevData r6 = com.logan.flight.data.FlightRevData.get()
            java.lang.String r7 = "FlightRevData.get()"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r6, r7)
            com.logan.flight.data.recv.FlightRevSettingData r6 = r6.getFlightRevSettingData()
            java.lang.String r7 = "FlightRevData.get().flightRevSettingData"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r6, r7)
            boolean r6 = r6.isNewerModeOpen()
            if (r6 == 0) goto L68
            com.ipotensic.kernel.model.KernelViewModel r5 = r10.this$0
            kotlinx.coroutines.Job r5 = com.ipotensic.kernel.model.KernelViewModel.access$getBeginnerModeJob$p(r5)
            r6 = 0
            if (r5 == 0) goto L60
            kotlinx.coroutines.Job.DefaultImpls.cancel$default(r5, r6, r2, r6)
        L60:
            com.ipotensic.kernel.model.KernelViewModel r5 = r10.this$0
            kotlinx.coroutines.Job r6 = (kotlinx.coroutines.Job) r6
            com.ipotensic.kernel.model.KernelViewModel.access$setBeginnerModeJob$p(r5, r6)
            goto L97
        L68:
            com.ipotensic.kernel.model.KernelViewModel r6 = r10.this$0
            com.logan.flight.data.FlightSendData r7 = com.logan.flight.data.FlightSendData.get()
            java.lang.String r8 = "FlightSendData.get()"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r7, r8)
            com.logan.flight.data.send.SendFlightSetData r7 = r7.getSendFlightSetData()
            java.lang.String r8 = "FlightSendData.get().sendFlightSetData"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r7, r8)
            com.ipotensic.kernel.model.KernelViewModel.access$setNewerModeData(r6, r7)
            com.ipotensic.kernel.model.KernelViewModel r6 = r10.this$0
            r6.sendSettings()
            r6 = 500(0x1f4, double:2.47E-321)
            r10.L$0 = r4
            r10.I$0 = r3
            r10.I$1 = r1
            r10.I$2 = r5
            r10.label = r2
            java.lang.Object r5 = kotlinx.coroutines.DelayKt.delay(r6, r10)
            if (r5 != r0) goto L97
            return r0
        L97:
            int r3 = r3 + r2
            goto L2a
        L99:
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ipotensic.kernel.model.KernelViewModel$updateBeginnerMode$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}