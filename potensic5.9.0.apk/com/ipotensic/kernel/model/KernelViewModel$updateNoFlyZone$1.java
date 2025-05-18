package com.ipotensic.kernel.model;

import android.content.Context;
import com.ipotensic.kernel.controllers.MapVideoController;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import tv.danmaku.ijk.media.player.IjkMediaCodecInfo;

/* compiled from: KernelViewModel.kt */
@Metadata(m2336bv = {1, 0, 3}, m2337d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, m2338d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, m2339k = 3, m2340mv = {1, 1, 15})
@DebugMetadata(m2346c = "com.ipotensic.kernel.model.KernelViewModel$updateNoFlyZone$1", m2347f = "KernelViewModel.kt", m2348i = {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 9, 10, 11, 11, 12, 12}, m2349l = {551, 565, 569, 579, 583, 596, IjkMediaCodecInfo.RANK_LAST_CHANCE, 609, 613, 626, 627, 633, 634}, m2350m = "invokeSuspend", m2351n = {"$this$launch", "$this$launch", "$this$map$iv", "$this$mapTo$iv$iv", "destination$iv$iv", "item$iv$iv", "noFlyZoneModel", "$this$map$iv", "$this$mapTo$iv$iv", "destination$iv$iv", "item$iv$iv", "subModel", "it", "$this$launch", "$this$map$iv", "$this$mapTo$iv$iv", "destination$iv$iv", "item$iv$iv", "noFlyZoneModel", "$this$map$iv", "$this$mapTo$iv$iv", "destination$iv$iv", "item$iv$iv", "subModel", "it", "$this$launch", "$this$map$iv", "$this$mapTo$iv$iv", "destination$iv$iv", "item$iv$iv", "noFlyZoneModel", "$this$map$iv", "$this$mapTo$iv$iv", "destination$iv$iv", "item$iv$iv", "subModel", "$this$launch", "$this$map$iv", "$this$mapTo$iv$iv", "destination$iv$iv", "item$iv$iv", "noFlyZoneModel", "$this$map$iv", "$this$mapTo$iv$iv", "destination$iv$iv", "item$iv$iv", "subModel", "$this$launch", "$this$map$iv", "$this$mapTo$iv$iv", "destination$iv$iv", "item$iv$iv", "noFlyZoneModel", "$this$map$iv", "$this$mapTo$iv$iv", "destination$iv$iv", "item$iv$iv", "subModel", "it", "$this$launch", "$this$map$iv", "$this$mapTo$iv$iv", "destination$iv$iv", "item$iv$iv", "noFlyZoneModel", "$this$map$iv", "$this$mapTo$iv$iv", "destination$iv$iv", "item$iv$iv", "subModel", "it", "$this$launch", "$this$map$iv", "$this$mapTo$iv$iv", "destination$iv$iv", "item$iv$iv", "noFlyZoneModel", "$this$map$iv", "$this$mapTo$iv$iv", "destination$iv$iv", "item$iv$iv", "subModel", "$this$launch", "$this$map$iv", "$this$mapTo$iv$iv", "destination$iv$iv", "item$iv$iv", "noFlyZoneModel", "$this$map$iv", "$this$mapTo$iv$iv", "destination$iv$iv", "item$iv$iv", "subModel", "$this$launch", "$this$launch", "$this$launch", "e", "$this$launch", "e"}, m2352s = {"L$0", "L$0", "L$1", "L$2", "L$3", "L$5", "L$6", "L$7", "L$8", "L$9", "L$11", "L$12", "L$14", "L$0", "L$1", "L$2", "L$3", "L$5", "L$6", "L$7", "L$8", "L$9", "L$11", "L$12", "L$14", "L$0", "L$1", "L$2", "L$3", "L$5", "L$6", "L$7", "L$8", "L$9", "L$11", "L$12", "L$0", "L$1", "L$2", "L$3", "L$5", "L$6", "L$7", "L$8", "L$9", "L$11", "L$12", "L$0", "L$1", "L$2", "L$3", "L$5", "L$6", "L$7", "L$8", "L$9", "L$11", "L$12", "L$14", "L$0", "L$1", "L$2", "L$3", "L$5", "L$6", "L$7", "L$8", "L$9", "L$11", "L$12", "L$14", "L$0", "L$1", "L$2", "L$3", "L$5", "L$6", "L$7", "L$8", "L$9", "L$11", "L$12", "L$0", "L$1", "L$2", "L$3", "L$5", "L$6", "L$7", "L$8", "L$9", "L$11", "L$12", "L$0", "L$0", "L$0", "L$1", "L$0", "L$1"})
/* loaded from: classes2.dex */
final class KernelViewModel$updateNoFlyZone$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ MapVideoController $controller;
    final /* synthetic */ boolean $isAdd;
    Object L$0;
    Object L$1;
    Object L$10;
    Object L$11;
    Object L$12;
    Object L$13;
    Object L$14;
    Object L$15;
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
    private CoroutineScope f2232p$;
    final /* synthetic */ KernelViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    KernelViewModel$updateNoFlyZone$1(KernelViewModel kernelViewModel, boolean z, Context context, MapVideoController mapVideoController, Continuation continuation) {
        super(2, continuation);
        this.this$0 = kernelViewModel;
        this.$isAdd = z;
        this.$context = context;
        this.$controller = mapVideoController;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> completion) {
        Intrinsics.checkParameterIsNotNull(completion, "completion");
        KernelViewModel$updateNoFlyZone$1 kernelViewModel$updateNoFlyZone$1 = new KernelViewModel$updateNoFlyZone$1(this.this$0, this.$isAdd, this.$context, this.$controller, completion);
        kernelViewModel$updateNoFlyZone$1.f2232p$ = (CoroutineScope) obj;
        return kernelViewModel$updateNoFlyZone$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((KernelViewModel$updateNoFlyZone$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /*  JADX ERROR: Types fix failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:96)
        */
    /* JADX WARN: Not initialized variable reg: 15, insn: 0x0242: MOVE (r3 I:??[OBJECT, ARRAY]) = (r15 I:??[OBJECT, ARRAY]), block:B:214:0x0241 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:115:0x06ad -> B:34:0x06b3). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:141:0x06da -> B:39:0x06e4). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:155:0x02f6 -> B:42:0x0309). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:156:0x0711 -> B:148:0x0713). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:61:0x04f0 -> B:38:0x0503). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final java.lang.Object invokeSuspend(java.lang.Object r27) {
        /*
            Method dump skipped, instructions count: 1990
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ipotensic.kernel.model.KernelViewModel$updateNoFlyZone$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* compiled from: KernelViewModel.kt */
    @Metadata(m2336bv = {1, 0, 3}, m2337d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, m2338d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, m2339k = 3, m2340mv = {1, 1, 15})
    @DebugMetadata(m2346c = "com.ipotensic.kernel.model.KernelViewModel$updateNoFlyZone$1$1", m2347f = "KernelViewModel.kt", m2348i = {}, m2349l = {}, m2350m = "invokeSuspend", m2351n = {}, m2352s = {})
    /* renamed from: com.ipotensic.kernel.model.KernelViewModel$updateNoFlyZone$1$1 */
    static final class C24041 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        /* renamed from: p$ */
        private CoroutineScope f2233p$;

        C24041(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> completion) {
            Intrinsics.checkParameterIsNotNull(completion, "completion");
            C24041 c24041 = KernelViewModel$updateNoFlyZone$1.this.new C24041(completion);
            c24041.f2233p$ = (CoroutineScope) obj;
            return c24041;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C24041) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            KernelViewModel$updateNoFlyZone$1.this.this$0.isLoadNoFlyZone().setValue(Boxing.boxBoolean(true));
            return Unit.INSTANCE;
        }
    }

    /* compiled from: KernelViewModel.kt */
    @Metadata(m2336bv = {1, 0, 3}, m2337d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, m2338d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, m2339k = 3, m2340mv = {1, 1, 15})
    @DebugMetadata(m2346c = "com.ipotensic.kernel.model.KernelViewModel$updateNoFlyZone$1$3", m2347f = "KernelViewModel.kt", m2348i = {}, m2349l = {}, m2350m = "invokeSuspend", m2351n = {}, m2352s = {})
    /* renamed from: com.ipotensic.kernel.model.KernelViewModel$updateNoFlyZone$1$3 */
    static final class C24053 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        /* renamed from: p$ */
        private CoroutineScope f2234p$;

        C24053(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> completion) {
            Intrinsics.checkParameterIsNotNull(completion, "completion");
            C24053 c24053 = KernelViewModel$updateNoFlyZone$1.this.new C24053(completion);
            c24053.f2234p$ = (CoroutineScope) obj;
            return c24053;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C24053) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            KernelViewModel$updateNoFlyZone$1.this.this$0.isLoadNoFlyZone().setValue(Boxing.boxBoolean(false));
            return Unit.INSTANCE;
        }
    }

    /* compiled from: KernelViewModel.kt */
    @Metadata(m2336bv = {1, 0, 3}, m2337d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, m2338d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, m2339k = 3, m2340mv = {1, 1, 15})
    @DebugMetadata(m2346c = "com.ipotensic.kernel.model.KernelViewModel$updateNoFlyZone$1$4", m2347f = "KernelViewModel.kt", m2348i = {}, m2349l = {}, m2350m = "invokeSuspend", m2351n = {}, m2352s = {})
    /* renamed from: com.ipotensic.kernel.model.KernelViewModel$updateNoFlyZone$1$4 */
    static final class C24064 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        /* renamed from: p$ */
        private CoroutineScope f2235p$;

        C24064(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> completion) {
            Intrinsics.checkParameterIsNotNull(completion, "completion");
            C24064 c24064 = KernelViewModel$updateNoFlyZone$1.this.new C24064(completion);
            c24064.f2235p$ = (CoroutineScope) obj;
            return c24064;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C24064) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            KernelViewModel$updateNoFlyZone$1.this.this$0.isLoadNoFlyZone().setValue(Boxing.boxBoolean(false));
            return Unit.INSTANCE;
        }
    }
}