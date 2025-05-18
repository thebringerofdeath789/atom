package com.ipotensic.kernel.model;

import com.ipotensic.baselib.DDLog;
import com.ipotensic.kernel.maps.bean.NoFlyZoneModel;
import com.ipotensic.kernel.maps.bean.NoFlyZoneSubModel;
import com.ipotensic.kernel.maps.enums.NoFlyZoneShape;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* compiled from: KernelViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, 15})
@DebugMetadata(c = "com.ipotensic.kernel.model.KernelViewModel$removeNoFlyZone$1", f = "KernelViewModel.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {653, 659}, m = "invokeSuspend", n = {"$this$launch", "$this$map$iv", "$this$mapTo$iv$iv", "destination$iv$iv", "item$iv$iv", "noFlyZoneModel", "$this$map$iv", "$this$mapTo$iv$iv", "destination$iv$iv", "item$iv$iv", "subModel", "$this$launch", "$this$map$iv", "$this$mapTo$iv$iv", "destination$iv$iv", "item$iv$iv", "noFlyZoneModel", "$this$map$iv", "$this$mapTo$iv$iv", "destination$iv$iv", "item$iv$iv", "subModel"}, s = {"L$0", "L$1", "L$2", "L$3", "L$5", "L$6", "L$7", "L$8", "L$9", "L$11", "L$12", "L$0", "L$1", "L$2", "L$3", "L$5", "L$6", "L$7", "L$8", "L$9", "L$11", "L$12"})
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
    private CoroutineScope p$;
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
        kernelViewModel$removeNoFlyZone$1.p$ = (CoroutineScope) obj;
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
    */
    public final Object invokeSuspend(Object obj) {
        CoroutineScope coroutineScope;
        ArrayList<NoFlyZoneModel> noFlyZoneData;
        KernelViewModel$removeNoFlyZone$1 kernelViewModel$removeNoFlyZone$1;
        Iterator it;
        ArrayList arrayList;
        Object obj2;
        CoroutineScope coroutineScope2;
        ArrayList<NoFlyZoneSubModel> arrayList2;
        Iterator it2;
        List arrayList3;
        NoFlyZoneModel noFlyZoneModel;
        Iterable iterable;
        Object obj3;
        Object obj4;
        KernelViewModel$removeNoFlyZone$1 kernelViewModel$removeNoFlyZone$12;
        Iterator it3;
        Object obj5;
        ?? r15;
        ?? r2;
        Collection collection;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        int i2 = 10;
        try {
        } catch (Exception e) {
            DDLog.e("\u7981\u98de\u533a\u8c03\u8bd5 \u5220\u9664\u7981\u98de\u533a\u5f02\u5e38 e:" + e.getMessage());
        }
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            coroutineScope = this.p$;
            if (this.this$0.getNoFlyZoneData().isEmpty()) {
                return Unit.INSTANCE;
            }
            DDLog.e("\u7981\u98de\u533a\u8c03\u8bd5 \u5f00\u59cb\u5220\u9664\u7981\u98de\u533a\u6570\u636e size:" + this.this$0.getNoFlyZoneData().size());
            noFlyZoneData = this.this$0.getNoFlyZoneData();
            ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(noFlyZoneData, 10));
            kernelViewModel$removeNoFlyZone$1 = this;
            it = noFlyZoneData.iterator();
            arrayList = arrayList4;
            obj2 = noFlyZoneData;
            if (it.hasNext()) {
            }
        } else {
            if (i == 1) {
                r2 = (Collection) this.L$14;
                Collection collection2 = (Collection) this.L$13;
                Iterator it4 = (Iterator) this.L$10;
                Collection collection3 = (Collection) this.L$9;
                Iterable iterable2 = (Iterable) this.L$8;
                Iterable iterable3 = (Iterable) this.L$7;
                NoFlyZoneModel noFlyZoneModel2 = (NoFlyZoneModel) this.L$6;
                Object obj6 = this.L$5;
                Iterator it5 = (Iterator) this.L$4;
                Collection collection4 = (Collection) this.L$3;
                Object obj7 = (Iterable) this.L$2;
                Iterable iterable4 = (Iterable) this.L$1;
                CoroutineScope coroutineScope3 = (CoroutineScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                r15 = collection4;
                noFlyZoneModel = noFlyZoneModel2;
                kernelViewModel$removeNoFlyZone$12 = this;
                collection = collection3;
                coroutineScope2 = coroutineScope3;
                arrayList3 = collection2;
                obj4 = obj7;
                obj5 = obj6;
                iterable = iterable2;
                it3 = it4;
                obj3 = iterable4;
                it2 = it5;
                arrayList2 = iterable3;
            } else {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                r2 = (Collection) this.L$14;
                arrayList3 = (Collection) this.L$13;
                it3 = (Iterator) this.L$10;
                Collection collection5 = (Collection) this.L$9;
                iterable = (Iterable) this.L$8;
                arrayList2 = (Iterable) this.L$7;
                noFlyZoneModel = (NoFlyZoneModel) this.L$6;
                obj5 = this.L$5;
                it2 = (Iterator) this.L$4;
                r15 = (Collection) this.L$3;
                obj4 = (Iterable) this.L$2;
                obj3 = (Iterable) this.L$1;
                coroutineScope2 = (CoroutineScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                kernelViewModel$removeNoFlyZone$12 = this;
                collection = collection5;
            }
            arrayList3.add(Unit.INSTANCE);
            arrayList3 = collection;
            ArrayList arrayList5 = r2;
            obj3 = obj3;
            r15 = r15;
            if (it3.hasNext()) {
                Object next = it3.next();
                NoFlyZoneSubModel noFlyZoneSubModel = (NoFlyZoneSubModel) next;
                Object obj8 = coroutine_suspended;
                int shape = noFlyZoneSubModel.getShape();
                ArrayList arrayList6 = arrayList5;
                if (shape == NoFlyZoneShape.CIRCLE.getValue()) {
                    MainCoroutineDispatcher main = Dispatchers.getMain();
                    KernelViewModel$removeNoFlyZone$1$invokeSuspend$$inlined$map$lambda$1 kernelViewModel$removeNoFlyZone$1$invokeSuspend$$inlined$map$lambda$1 = new KernelViewModel$removeNoFlyZone$1$invokeSuspend$$inlined$map$lambda$1(noFlyZoneSubModel, null, kernelViewModel$removeNoFlyZone$12);
                    kernelViewModel$removeNoFlyZone$12.L$0 = coroutineScope2;
                    kernelViewModel$removeNoFlyZone$12.L$1 = obj3;
                    kernelViewModel$removeNoFlyZone$12.L$2 = obj4;
                    kernelViewModel$removeNoFlyZone$12.L$3 = r15;
                    kernelViewModel$removeNoFlyZone$12.L$4 = it2;
                    kernelViewModel$removeNoFlyZone$12.L$5 = obj5;
                    kernelViewModel$removeNoFlyZone$12.L$6 = noFlyZoneModel;
                    kernelViewModel$removeNoFlyZone$12.L$7 = arrayList2;
                    kernelViewModel$removeNoFlyZone$12.L$8 = iterable;
                    kernelViewModel$removeNoFlyZone$12.L$9 = arrayList3;
                    kernelViewModel$removeNoFlyZone$12.L$10 = it3;
                    kernelViewModel$removeNoFlyZone$12.L$11 = next;
                    kernelViewModel$removeNoFlyZone$12.L$12 = noFlyZoneSubModel;
                    kernelViewModel$removeNoFlyZone$12.L$13 = arrayList3;
                    kernelViewModel$removeNoFlyZone$12.L$14 = arrayList6;
                    kernelViewModel$removeNoFlyZone$12.label = 1;
                    if (BuildersKt.withContext(main, kernelViewModel$removeNoFlyZone$1$invokeSuspend$$inlined$map$lambda$1, kernelViewModel$removeNoFlyZone$12) == obj8) {
                        return obj8;
                    }
                    r2 = arrayList6;
                    coroutine_suspended = obj8;
                    CoroutineScope coroutineScope4 = coroutineScope2;
                    Collection collection6 = arrayList3;
                    collection = collection6;
                    coroutineScope2 = coroutineScope4;
                    arrayList3 = collection6;
                    obj4 = obj4;
                    obj5 = obj5;
                    iterable = iterable;
                    it3 = it3;
                    obj3 = obj3;
                    it2 = it2;
                    arrayList2 = arrayList2;
                } else if (shape == NoFlyZoneShape.POLYGON.getValue()) {
                    MainCoroutineDispatcher main2 = Dispatchers.getMain();
                    KernelViewModel$removeNoFlyZone$1$invokeSuspend$$inlined$map$lambda$2 kernelViewModel$removeNoFlyZone$1$invokeSuspend$$inlined$map$lambda$2 = new KernelViewModel$removeNoFlyZone$1$invokeSuspend$$inlined$map$lambda$2(noFlyZoneSubModel, null, kernelViewModel$removeNoFlyZone$12);
                    kernelViewModel$removeNoFlyZone$12.L$0 = coroutineScope2;
                    kernelViewModel$removeNoFlyZone$12.L$1 = obj3;
                    kernelViewModel$removeNoFlyZone$12.L$2 = obj4;
                    kernelViewModel$removeNoFlyZone$12.L$3 = r15;
                    kernelViewModel$removeNoFlyZone$12.L$4 = it2;
                    kernelViewModel$removeNoFlyZone$12.L$5 = obj5;
                    kernelViewModel$removeNoFlyZone$12.L$6 = noFlyZoneModel;
                    kernelViewModel$removeNoFlyZone$12.L$7 = arrayList2;
                    kernelViewModel$removeNoFlyZone$12.L$8 = iterable;
                    kernelViewModel$removeNoFlyZone$12.L$9 = arrayList3;
                    kernelViewModel$removeNoFlyZone$12.L$10 = it3;
                    kernelViewModel$removeNoFlyZone$12.L$11 = next;
                    kernelViewModel$removeNoFlyZone$12.L$12 = noFlyZoneSubModel;
                    kernelViewModel$removeNoFlyZone$12.L$13 = arrayList3;
                    kernelViewModel$removeNoFlyZone$12.L$14 = arrayList6;
                    kernelViewModel$removeNoFlyZone$12.label = 2;
                    if (BuildersKt.withContext(main2, kernelViewModel$removeNoFlyZone$1$invokeSuspend$$inlined$map$lambda$2, kernelViewModel$removeNoFlyZone$12) == obj8) {
                        return obj8;
                    }
                    coroutine_suspended = obj8;
                    r2 = arrayList6;
                    collection = arrayList3;
                } else {
                    coroutine_suspended = obj8;
                    r2 = arrayList6;
                    collection = arrayList3;
                }
                arrayList3.add(Unit.INSTANCE);
                arrayList3 = collection;
                ArrayList arrayList52 = r2;
                obj3 = obj3;
                r15 = r15;
                if (it3.hasNext()) {
                    ArrayList arrayList7 = arrayList52;
                    Object obj9 = coroutine_suspended;
                    List list = arrayList3;
                    kernelViewModel$removeNoFlyZone$1 = kernelViewModel$removeNoFlyZone$12;
                    it = it2;
                    ArrayList<NoFlyZoneModel> arrayList8 = obj3;
                    obj2 = obj4;
                    noFlyZoneData = arrayList8;
                    ArrayList arrayList9 = r15;
                    arrayList7.add(list);
                    coroutine_suspended = obj9;
                    coroutineScope = coroutineScope2;
                    arrayList = arrayList9;
                    i2 = 10;
                    if (it.hasNext()) {
                        Object next2 = it.next();
                        NoFlyZoneModel noFlyZoneModel3 = (NoFlyZoneModel) next2;
                        ArrayList<NoFlyZoneSubModel> sub_areas = noFlyZoneModel3.getSub_areas();
                        if (sub_areas == null) {
                            arrayList7 = arrayList;
                            arrayList9 = arrayList7;
                            coroutineScope2 = coroutineScope;
                            obj9 = coroutine_suspended;
                            list = null;
                            arrayList7.add(list);
                            coroutine_suspended = obj9;
                            coroutineScope = coroutineScope2;
                            arrayList = arrayList9;
                            i2 = 10;
                            if (it.hasNext()) {
                            }
                        } else {
                            arrayList2 = sub_areas;
                            ArrayList arrayList10 = arrayList;
                            it2 = it;
                            arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, i2));
                            coroutineScope2 = coroutineScope;
                            arrayList52 = arrayList10;
                            noFlyZoneModel = noFlyZoneModel3;
                            iterable = arrayList2;
                            Object obj10 = obj2;
                            obj3 = noFlyZoneData;
                            obj4 = obj10;
                            kernelViewModel$removeNoFlyZone$12 = kernelViewModel$removeNoFlyZone$1;
                            it3 = arrayList2.iterator();
                            obj5 = next2;
                            r15 = arrayList10;
                            if (it3.hasNext()) {
                            }
                        }
                    } else {
                        ArrayList arrayList11 = arrayList;
                        kernelViewModel$removeNoFlyZone$1.this$0.getNoFlyZoneData().clear();
                        DDLog.e("\u7981\u98de\u533a\u8c03\u8bd5 \u5220\u9664\u7981\u98de\u533a\u5b8c\u6210");
                        return Unit.INSTANCE;
                    }
                }
            }
        }
    }
}