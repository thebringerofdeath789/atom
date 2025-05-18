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
@DebugMetadata(m2346c = "com.ipotensic.kernel.model.KernelViewModel$removeNoFlyZone$1", m2347f = "KernelViewModel.kt", m2348i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, m2349l = {653, 659}, m2350m = "invokeSuspend", m2351n = {"$this$launch", "$this$map$iv", "$this$mapTo$iv$iv", "destination$iv$iv", "item$iv$iv", "noFlyZoneModel", "$this$map$iv", "$this$mapTo$iv$iv", "destination$iv$iv", "item$iv$iv", "subModel", "$this$launch", "$this$map$iv", "$this$mapTo$iv$iv", "destination$iv$iv", "item$iv$iv", "noFlyZoneModel", "$this$map$iv", "$this$mapTo$iv$iv", "destination$iv$iv", "item$iv$iv", "subModel"}, m2352s = {"L$0", "L$1", "L$2", "L$3", "L$5", "L$6", "L$7", "L$8", "L$9", "L$11", "L$12", "L$0", "L$1", "L$2", "L$3", "L$5", "L$6", "L$7", "L$8", "L$9", "L$11", "L$12"})
/* loaded from: classes2.dex */
final class KernelViewModel$removeNoFlyZone$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    Object L$1;
    Object L$10;
    Object L$11;
    Object L$12;
    Object L$13;
    Object L$14;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    Object L$8;
    Object L$9;
    int label;

    /* renamed from: p$ */
    private CoroutineScope f2230p$;
    final /* synthetic */ KernelViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    KernelViewModel$removeNoFlyZone$1(KernelViewModel kernelViewModel, Continuation continuation) {
        super(2, continuation);
        this.this$0 = kernelViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> completion) {
        Intrinsics.checkParameterIsNotNull(completion, "completion");
        KernelViewModel$removeNoFlyZone$1 kernelViewModel$removeNoFlyZone$1 = new KernelViewModel$removeNoFlyZone$1(this.this$0, completion);
        kernelViewModel$removeNoFlyZone$1.f2230p$ = (CoroutineScope) obj;
        return kernelViewModel$removeNoFlyZone$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((KernelViewModel$removeNoFlyZone$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0128 A[Catch: Exception -> 0x0231, TryCatch #0 {Exception -> 0x0231, blocks: (B:7:0x0048, B:9:0x01f2, B:10:0x0122, B:12:0x0128, B:14:0x013f, B:20:0x019f, B:22:0x01ad, B:28:0x01fe, B:29:0x0214, B:30:0x00ec, B:32:0x00f2, B:34:0x00ff, B:36:0x0220, B:42:0x0093, B:46:0x00a2, B:48:0x00ae, B:50:0x00b1), top: B:2:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x01fe A[Catch: Exception -> 0x0231, TryCatch #0 {Exception -> 0x0231, blocks: (B:7:0x0048, B:9:0x01f2, B:10:0x0122, B:12:0x0128, B:14:0x013f, B:20:0x019f, B:22:0x01ad, B:28:0x01fe, B:29:0x0214, B:30:0x00ec, B:32:0x00f2, B:34:0x00ff, B:36:0x0220, B:42:0x0093, B:46:0x00a2, B:48:0x00ae, B:50:0x00b1), top: B:2:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00f2 A[Catch: Exception -> 0x0231, TryCatch #0 {Exception -> 0x0231, blocks: (B:7:0x0048, B:9:0x01f2, B:10:0x0122, B:12:0x0128, B:14:0x013f, B:20:0x019f, B:22:0x01ad, B:28:0x01fe, B:29:0x0214, B:30:0x00ec, B:32:0x00f2, B:34:0x00ff, B:36:0x0220, B:42:0x0093, B:46:0x00a2, B:48:0x00ae, B:50:0x00b1), top: B:2:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0220 A[Catch: Exception -> 0x0231, TRY_LEAVE, TryCatch #0 {Exception -> 0x0231, blocks: (B:7:0x0048, B:9:0x01f2, B:10:0x0122, B:12:0x0128, B:14:0x013f, B:20:0x019f, B:22:0x01ad, B:28:0x01fe, B:29:0x0214, B:30:0x00ec, B:32:0x00f2, B:34:0x00ff, B:36:0x0220, B:42:0x0093, B:46:0x00a2, B:48:0x00ae, B:50:0x00b1), top: B:2:0x000c }] */
    /* JADX WARN: Type inference failed for: r15v10 */
    /* JADX WARN: Type inference failed for: r15v11 */
    /* JADX WARN: Type inference failed for: r15v3, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r15v4 */
    /* JADX WARN: Type inference failed for: r15v7 */
    /* JADX WARN: Type inference failed for: r15v9, types: [java.util.Collection] */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v23 */
    /* JADX WARN: Type inference failed for: r2v25, types: [java.util.Collection] */
    /* JADX WARN: Type inference failed for: r2v28, types: [java.util.Collection] */
    /* JADX WARN: Type inference failed for: r5v11, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v14 */
    /* JADX WARN: Type inference failed for: r5v15 */
    /* JADX WARN: Type inference failed for: r5v20 */
    /* JADX WARN: Type inference failed for: r5v22, types: [java.lang.Iterable] */
    /* JADX WARN: Type inference failed for: r5v23 */
    /* JADX WARN: Type inference failed for: r5v9 */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v14, types: [java.util.Collection] */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v4, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r7v8, types: [java.util.Collection] */
    /* JADX WARN: Type inference failed for: r7v9 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x00ff -> B:10:0x0122). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x020d -> B:28:0x0214). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r24) {
        /*
            Method dump skipped, instructions count: 591
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ipotensic.kernel.model.KernelViewModel$removeNoFlyZone$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}