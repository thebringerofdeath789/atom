package com.ipotensic.kernel.fragment;

import android.content.Context;
import android.widget.ExpandableListView;
import android.widget.TextView;
import com.ipotensic.kernel.adapter.UomRecordExpandableAdapter;
import com.ipotensic.kernel.databinding.ViewLayoutUomUploadRecordBinding;
import com.logan.uom.UomHandler;
import com.logan.uom.bean.UomRecord;
import java.util.ArrayList;
import java.util.Comparator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.boxing;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import org.litepal.LitePal;

/* compiled from: UomUploadRecordFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, 15})
@DebugMetadata(c = "com.ipotensic.kernel.fragment.UomUploadRecordFragment$initData$1", f = "UomUploadRecordFragment.kt", i = {0, 0, 1, 1, 1}, l = {62, 79}, m = "invokeSuspend", n = {"$this$launch", "sqlList", "$this$launch", "sqlList", "lastSorties"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2"})
/* loaded from: classes2.dex */
final class UomUploadRecordFragment$initData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    private CoroutineScope p$;
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
        uomUploadRecordFragment$initData$1.p$ = (CoroutineScope) obj;
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
    */
    public final Object invokeSuspend(Object obj) {
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        ArrayList arrayList4;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
            ResultKt.throwOnFailure(obj);
        } else {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = this.p$;
            UomHandler.INSTANCE.getInstance().deleteThreeDaysAgoRecordsIfExist();
            ArrayList<UomRecord> arrayList5 = new ArrayList(LitePal.findAll(UomRecord.class, new long[0]));
            if (arrayList5.isEmpty()) {
                MainCoroutineDispatcher main = Dispatchers.getMain();
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(null);
                this.L$0 = coroutineScope;
                this.L$1 = arrayList5;
                this.label = 1;
                if (BuildersKt.withContext(main, anonymousClass1, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                ArrayList arrayList6 = arrayList5;
                if (arrayList6.size() > 1) {
                    CollectionsKt.sortWith(arrayList6, new Comparator<T>() { // from class: com.ipotensic.kernel.fragment.UomUploadRecordFragment$initData$1$invokeSuspend$$inlined$sortBy$1
                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // java.util.Comparator
                        public final int compare(T t, T t2) {
                            return ComparisonsKt.compareValues(Long.valueOf(((UomRecord) t).getUomStateChangedTime()), Long.valueOf(((UomRecord) t2).getUomStateChangedTime()));
                        }
                    });
                }
                Ref.ObjectRef objectRef = new Ref.ObjectRef();
                objectRef.element = (Integer) 0;
                this.this$0.recordList = new ArrayList();
                for (UomRecord uomRecord : arrayList5) {
                    if (((Integer) objectRef.element) != null) {
                        Integer num = (Integer) objectRef.element;
                        int sorties = uomRecord.getSorties();
                        if (num != null) {
                        }
                    }
                    arrayList2 = this.this$0.recordList;
                    if (arrayList2 == null) {
                        Intrinsics.throwNpe();
                    }
                    arrayList2.add(new ArrayList());
                    objectRef.element = boxing.boxInt(uomRecord.getSorties());
                    arrayList3 = this.this$0.recordList;
                    if (arrayList3 == null) {
                        Intrinsics.throwNpe();
                    }
                    arrayList4 = this.this$0.recordList;
                    if (arrayList4 == null) {
                        Intrinsics.throwNpe();
                    }
                    ((ArrayList) arrayList3.get(CollectionsKt.getLastIndex(arrayList4))).add(uomRecord);
                }
                arrayList = this.this$0.recordList;
                if (arrayList != null) {
                    CollectionsKt.reverse(arrayList);
                }
                MainCoroutineDispatcher main2 = Dispatchers.getMain();
                AnonymousClass4 anonymousClass4 = new AnonymousClass4(null);
                this.L$0 = coroutineScope;
                this.L$1 = arrayList5;
                this.L$2 = objectRef;
                this.label = 2;
                if (BuildersKt.withContext(main2, anonymousClass4, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        }
        return Unit.INSTANCE;
    }

    /* compiled from: UomUploadRecordFragment.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, 15})
    @DebugMetadata(c = "com.ipotensic.kernel.fragment.UomUploadRecordFragment$initData$1$1", f = "UomUploadRecordFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.ipotensic.kernel.fragment.UomUploadRecordFragment$initData$1$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        private CoroutineScope p$;

        AnonymousClass1(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> completion) {
            Intrinsics.checkParameterIsNotNull(completion, "completion");
            AnonymousClass1 anonymousClass1 = UomUploadRecordFragment$initData$1.this.new AnonymousClass1(completion);
            anonymousClass1.p$ = (CoroutineScope) obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, 15})
    @DebugMetadata(c = "com.ipotensic.kernel.fragment.UomUploadRecordFragment$initData$1$4", f = "UomUploadRecordFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.ipotensic.kernel.fragment.UomUploadRecordFragment$initData$1$4, reason: invalid class name */
    static final class AnonymousClass4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        private CoroutineScope p$;

        AnonymousClass4(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> completion) {
            Intrinsics.checkParameterIsNotNull(completion, "completion");
            AnonymousClass4 anonymousClass4 = UomUploadRecordFragment$initData$1.this.new AnonymousClass4(completion);
            anonymousClass4.p$ = (CoroutineScope) obj;
            return anonymousClass4;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass4) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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