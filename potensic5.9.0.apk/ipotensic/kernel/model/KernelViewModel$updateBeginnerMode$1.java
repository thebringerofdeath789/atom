package com.ipotensic.kernel.model;

import com.logan.flight.data.FlightRevData;
import com.logan.flight.data.FlightSendData;
import com.logan.flight.data.recv.FlightRevSettingData;
import com.logan.flight.data.send.SendFlightSetData;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.boxing;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Job;

/* compiled from: KernelViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, 15})
@DebugMetadata(c = "com.ipotensic.kernel.model.KernelViewModel$updateBeginnerMode$1", f = "KernelViewModel.kt", i = {0, 0}, l = {730}, m = "invokeSuspend", n = {"$this$launch", "it"}, s = {"L$0", "I$2"})
/* loaded from: classes2.dex */
final class KernelViewModel$updateBeginnerMode$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int I$0;
    int I$1;
    int I$2;
    Object L$0;
    int label;
    private CoroutineScope p$;
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
        kernelViewModel$updateBeginnerMode$1.p$ = (CoroutineScope) obj;
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
    */
    public final Object invokeSuspend(Object obj) {
        int i;
        int i2;
        CoroutineScope coroutineScope;
        KernelViewModel$updateBeginnerMode$1 kernelViewModel$updateBeginnerMode$1;
        Job job;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            i = 4;
            i2 = 0;
            coroutineScope = this.p$;
            kernelViewModel$updateBeginnerMode$1 = this;
            if (i2 < i) {
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            i = this.I$1;
            i2 = this.I$0;
            coroutineScope = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(obj);
            kernelViewModel$updateBeginnerMode$1 = this;
            i2++;
            if (i2 < i) {
                int intValue = boxing.boxInt(i2).intValue();
                if (CoroutineScopeKt.isActive(coroutineScope)) {
                    FlightRevData flightRevData = FlightRevData.get();
                    Intrinsics.checkExpressionValueIsNotNull(flightRevData, "FlightRevData.get()");
                    FlightRevSettingData flightRevSettingData = flightRevData.getFlightRevSettingData();
                    Intrinsics.checkExpressionValueIsNotNull(flightRevSettingData, "FlightRevData.get().flightRevSettingData");
                    if (flightRevSettingData.isNewerModeOpen()) {
                        job = kernelViewModel$updateBeginnerMode$1.this$0.beginnerModeJob;
                        if (job != null) {
                            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
                        }
                        kernelViewModel$updateBeginnerMode$1.this$0.beginnerModeJob = (Job) null;
                    } else {
                        KernelViewModel kernelViewModel = kernelViewModel$updateBeginnerMode$1.this$0;
                        FlightSendData flightSendData = FlightSendData.get();
                        Intrinsics.checkExpressionValueIsNotNull(flightSendData, "FlightSendData.get()");
                        SendFlightSetData sendFlightSetData = flightSendData.getSendFlightSetData();
                        Intrinsics.checkExpressionValueIsNotNull(sendFlightSetData, "FlightSendData.get().sendFlightSetData");
                        kernelViewModel.setNewerModeData(sendFlightSetData);
                        kernelViewModel$updateBeginnerMode$1.this$0.sendSettings();
                        kernelViewModel$updateBeginnerMode$1.L$0 = coroutineScope;
                        kernelViewModel$updateBeginnerMode$1.I$0 = i2;
                        kernelViewModel$updateBeginnerMode$1.I$1 = i;
                        kernelViewModel$updateBeginnerMode$1.I$2 = intValue;
                        kernelViewModel$updateBeginnerMode$1.label = 1;
                        if (DelayKt.delay(500L, kernelViewModel$updateBeginnerMode$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                }
                i2++;
                if (i2 < i) {
                    return Unit.INSTANCE;
                }
            }
        }
    }
}