package com.ipotensic.kernel.fragment;

import android.content.Context;
import android.widget.ExpandableListView;
import android.widget.TextView;
import com.ipotensic.kernel.adapter.UomRecordExpandableAdapter;
import com.ipotensic.kernel.databinding.ViewLayoutUomUploadRecordBinding;
import java.util.ArrayList;
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

/* compiled from: UomUploadRecordFragment.kt */
@Metadata(m2336bv = {1, 0, 3}, m2337d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, m2338d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, m2339k = 3, m2340mv = {1, 1, 15})
@DebugMetadata(m2346c = "com.ipotensic.kernel.fragment.UomUploadRecordFragment$initData$1", m2347f = "UomUploadRecordFragment.kt", m2348i = {0, 0, 1, 1, 1}, m2349l = {62, 79}, m2350m = "invokeSuspend", m2351n = {"$this$launch", "sqlList", "$this$launch", "sqlList", "lastSorties"}, m2352s = {"L$0", "L$1", "L$0", "L$1", "L$2"})
/* loaded from: classes2.dex */
final class UomUploadRecordFragment$initData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* renamed from: p$ */
    private CoroutineScope f2210p$;
    final /* synthetic */ UomUploadRecordFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    UomUploadRecordFragment$initData$1(UomUploadRecordFragment uomUploadRecordFragment, Continuation continuation) {
        super(2, continuation);
        this.this$0 = uomUploadRecordFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> completion) {
        Intrinsics.checkParameterIsNotNull(completion, "completion");
        UomUploadRecordFragment$initData$1 uomUploadRecordFragment$initData$1 = new UomUploadRecordFragment$initData$1(this.this$0, completion);
        uomUploadRecordFragment$initData$1.f2210p$ = (CoroutineScope) obj;
        return uomUploadRecordFragment$initData$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((UomUploadRecordFragment$initData$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x00b6, code lost:
    
        if (r7.intValue() != r8) goto L28;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v7, types: [T, java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r7v5, types: [T, java.lang.Integer] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r10) {
        /*
            Method dump skipped, instructions count: 295
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ipotensic.kernel.fragment.UomUploadRecordFragment$initData$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* compiled from: UomUploadRecordFragment.kt */
    @Metadata(m2336bv = {1, 0, 3}, m2337d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, m2338d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, m2339k = 3, m2340mv = {1, 1, 15})
    @DebugMetadata(m2346c = "com.ipotensic.kernel.fragment.UomUploadRecordFragment$initData$1$1", m2347f = "UomUploadRecordFragment.kt", m2348i = {}, m2349l = {}, m2350m = "invokeSuspend", m2351n = {}, m2352s = {})
    /* renamed from: com.ipotensic.kernel.fragment.UomUploadRecordFragment$initData$1$1 */
    static final class C23371 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        /* renamed from: p$ */
        private CoroutineScope f2211p$;

        C23371(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> completion) {
            Intrinsics.checkParameterIsNotNull(completion, "completion");
            C23371 c23371 = UomUploadRecordFragment$initData$1.this.new C23371(completion);
            c23371.f2211p$ = (CoroutineScope) obj;
            return c23371;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C23371) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            ViewLayoutUomUploadRecordBinding mBind;
            ViewLayoutUomUploadRecordBinding mBind2;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            mBind = UomUploadRecordFragment$initData$1.this.this$0.getMBind();
            TextView textView = mBind.tvNone;
            Intrinsics.checkExpressionValueIsNotNull(textView, "mBind.tvNone");
            textView.setVisibility(0);
            mBind2 = UomUploadRecordFragment$initData$1.this.this$0.getMBind();
            ExpandableListView expandableListView = mBind2.listView;
            Intrinsics.checkExpressionValueIsNotNull(expandableListView, "mBind.listView");
            expandableListView.setVisibility(8);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: UomUploadRecordFragment.kt */
    @Metadata(m2336bv = {1, 0, 3}, m2337d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, m2338d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, m2339k = 3, m2340mv = {1, 1, 15})
    @DebugMetadata(m2346c = "com.ipotensic.kernel.fragment.UomUploadRecordFragment$initData$1$4", m2347f = "UomUploadRecordFragment.kt", m2348i = {}, m2349l = {}, m2350m = "invokeSuspend", m2351n = {}, m2352s = {})
    /* renamed from: com.ipotensic.kernel.fragment.UomUploadRecordFragment$initData$1$4 */
    static final class C23384 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        /* renamed from: p$ */
        private CoroutineScope f2212p$;

        C23384(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> completion) {
            Intrinsics.checkParameterIsNotNull(completion, "completion");
            C23384 c23384 = UomUploadRecordFragment$initData$1.this.new C23384(completion);
            c23384.f2212p$ = (CoroutineScope) obj;
            return c23384;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C23384) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            ViewLayoutUomUploadRecordBinding mBind;
            ViewLayoutUomUploadRecordBinding mBind2;
            ArrayList arrayList;
            ViewLayoutUomUploadRecordBinding mBind3;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            mBind = UomUploadRecordFragment$initData$1.this.this$0.getMBind();
            TextView textView = mBind.tvNone;
            Intrinsics.checkExpressionValueIsNotNull(textView, "mBind.tvNone");
            textView.setVisibility(8);
            mBind2 = UomUploadRecordFragment$initData$1.this.this$0.getMBind();
            ExpandableListView expandableListView = mBind2.listView;
            Intrinsics.checkExpressionValueIsNotNull(expandableListView, "mBind.listView");
            expandableListView.setVisibility(0);
            Context requireContext = UomUploadRecordFragment$initData$1.this.this$0.requireContext();
            Intrinsics.checkExpressionValueIsNotNull(requireContext, "requireContext()");
            arrayList = UomUploadRecordFragment$initData$1.this.this$0.recordList;
            if (arrayList == null) {
                Intrinsics.throwNpe();
            }
            UomRecordExpandableAdapter uomRecordExpandableAdapter = new UomRecordExpandableAdapter(requireContext, arrayList);
            mBind3 = UomUploadRecordFragment$initData$1.this.this$0.getMBind();
            mBind3.listView.setAdapter(uomRecordExpandableAdapter);
            return Unit.INSTANCE;
        }
    }
}