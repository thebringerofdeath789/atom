package kotlinx.coroutines;

import kotlin.Metadata;

/* compiled from: Await.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0002\u001a=\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u001e\u0010\u0003\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00050\u0004\"\b\u0012\u0004\u0012\u0002H\u00020\u0005H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u001a%\u0010\u0007\u001a\u00020\b2\u0012\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0\u0004\"\u00020\nH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u000b\u001a-\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00050\fH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\r\u001a\u001b\u0010\u0007\u001a\u00020\b*\b\u0012\u0004\u0012\u00020\n0\fH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\r\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000e"}, d2 = {"awaitAll", "", "T", "deferreds", "", "Lkotlinx/coroutines/Deferred;", "([Lkotlinx/coroutines/Deferred;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "joinAll", "", "jobs", "Lkotlinx/coroutines/Job;", "([Lkotlinx/coroutines/Job;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "(Ljava/util/Collection;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 1, 13})
/* loaded from: classes4.dex */
public final class AwaitKt {
    /* JADX WARN: Removed duplicated region for block: B:18:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <T> java.lang.Object awaitAll(kotlinx.coroutines.Deferred<? extends T>[] r4, kotlin.coroutines.Continuation<? super java.util.List<? extends T>> r5) {
        /*
            boolean r0 = r5 instanceof kotlinx.coroutines.AwaitKt$awaitAll$1
            if (r0 == 0) goto L14
            r0 = r5
            kotlinx.coroutines.AwaitKt$awaitAll$1 r0 = (kotlinx.coroutines.AwaitKt$awaitAll$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r5 = r0.label
            int r5 = r5 - r2
            r0.label = r5
            goto L19
        L14:
            kotlinx.coroutines.AwaitKt$awaitAll$1 r0 = new kotlinx.coroutines.AwaitKt$awaitAll$1
            r0.<init>(r5)
        L19:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3c
            if (r2 != r3) goto L34
            java.lang.Object r4 = r0.L$0
            kotlinx.coroutines.Deferred[] r4 = (kotlinx.coroutines.Deferred[]) r4
            boolean r4 = r5 instanceof kotlin.Result.Failure
            if (r4 != 0) goto L2f
            goto L5d
        L2f:
            kotlin.Result$Failure r5 = (kotlin.Result.Failure) r5
            java.lang.Throwable r4 = r5.exception
            throw r4
        L34:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L3c:
            boolean r2 = r5 instanceof kotlin.Result.Failure
            if (r2 != 0) goto L61
            int r5 = r4.length
            if (r5 != 0) goto L45
            r5 = r3
            goto L46
        L45:
            r5 = 0
        L46:
            if (r5 == 0) goto L4d
            java.util.List r4 = kotlin.collections.CollectionsKt.emptyList()
            goto L60
        L4d:
            kotlinx.coroutines.AwaitAll r5 = new kotlinx.coroutines.AwaitAll
            r5.<init>(r4)
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r5 = r5.await(r0)
            if (r5 != r1) goto L5d
            return r1
        L5d:
            r4 = r5
            java.util.List r4 = (java.util.List) r4
        L60:
            return r4
        L61:
            kotlin.Result$Failure r5 = (kotlin.Result.Failure) r5
            java.lang.Throwable r4 = r5.exception
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.AwaitKt.awaitAll(kotlinx.coroutines.Deferred[], kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <T> java.lang.Object awaitAll(java.util.Collection<? extends kotlinx.coroutines.Deferred<? extends T>> r4, kotlin.coroutines.Continuation<? super java.util.List<? extends T>> r5) {
        /*
            boolean r0 = r5 instanceof kotlinx.coroutines.AwaitKt$awaitAll$2
            if (r0 == 0) goto L14
            r0 = r5
            kotlinx.coroutines.AwaitKt$awaitAll$2 r0 = (kotlinx.coroutines.AwaitKt$awaitAll$2) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r5 = r0.label
            int r5 = r5 - r2
            r0.label = r5
            goto L19
        L14:
            kotlinx.coroutines.AwaitKt$awaitAll$2 r0 = new kotlinx.coroutines.AwaitKt$awaitAll$2
            r0.<init>(r5)
        L19:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3c
            if (r2 != r3) goto L34
            java.lang.Object r4 = r0.L$0
            java.util.Collection r4 = (java.util.Collection) r4
            boolean r4 = r5 instanceof kotlin.Result.Failure
            if (r4 != 0) goto L2f
            goto L68
        L2f:
            kotlin.Result$Failure r5 = (kotlin.Result.Failure) r5
            java.lang.Throwable r4 = r5.exception
            throw r4
        L34:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L3c:
            boolean r2 = r5 instanceof kotlin.Result.Failure
            if (r2 != 0) goto L7c
            boolean r5 = r4.isEmpty()
            if (r5 == 0) goto L4b
            java.util.List r4 = kotlin.collections.CollectionsKt.emptyList()
            goto L6b
        L4b:
            if (r4 == 0) goto L74
            r5 = 0
            kotlinx.coroutines.Deferred[] r5 = new kotlinx.coroutines.Deferred[r5]
            java.lang.Object[] r5 = r4.toArray(r5)
            if (r5 == 0) goto L6c
            kotlinx.coroutines.Deferred[] r5 = (kotlinx.coroutines.Deferred[]) r5
            kotlinx.coroutines.AwaitAll r2 = new kotlinx.coroutines.AwaitAll
            r2.<init>(r5)
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r5 = r2.await(r0)
            if (r5 != r1) goto L68
            return r1
        L68:
            r4 = r5
            java.util.List r4 = (java.util.List) r4
        L6b:
            return r4
        L6c:
            kotlin.TypeCastException r4 = new kotlin.TypeCastException
            java.lang.String r5 = "null cannot be cast to non-null type kotlin.Array<T>"
            r4.<init>(r5)
            throw r4
        L74:
            kotlin.TypeCastException r4 = new kotlin.TypeCastException
            java.lang.String r5 = "null cannot be cast to non-null type java.util.Collection<T>"
            r4.<init>(r5)
            throw r4
        L7c:
            kotlin.Result$Failure r5 = (kotlin.Result.Failure) r5
            java.lang.Throwable r4 = r5.exception
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.AwaitKt.awaitAll(java.util.Collection, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x007b -> B:12:0x007e). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object joinAll(kotlinx.coroutines.Job[] r8, kotlin.coroutines.Continuation<? super kotlin.Unit> r9) {
        /*
            boolean r0 = r9 instanceof kotlinx.coroutines.AwaitKt$joinAll$1
            if (r0 == 0) goto L14
            r0 = r9
            kotlinx.coroutines.AwaitKt$joinAll$1 r0 = (kotlinx.coroutines.AwaitKt$joinAll$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L19
        L14:
            kotlinx.coroutines.AwaitKt$joinAll$1 r0 = new kotlinx.coroutines.AwaitKt$joinAll$1
            r0.<init>(r9)
        L19:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L56
            if (r2 != r3) goto L4e
            java.lang.Object r8 = r0.L$4
            kotlinx.coroutines.Job r8 = (kotlinx.coroutines.Job) r8
            java.lang.Object r8 = r0.L$3
            kotlinx.coroutines.Job r8 = (kotlinx.coroutines.Job) r8
            int r8 = r0.I$1
            int r2 = r0.I$0
            java.lang.Object r4 = r0.L$2
            kotlinx.coroutines.Job[] r4 = (kotlinx.coroutines.Job[]) r4
            java.lang.Object r5 = r0.L$1
            kotlinx.coroutines.Job[] r5 = (kotlinx.coroutines.Job[]) r5
            java.lang.Object r6 = r0.L$0
            kotlinx.coroutines.Job[] r6 = (kotlinx.coroutines.Job[]) r6
            boolean r7 = r9 instanceof kotlin.Result.Failure
            if (r7 != 0) goto L49
            r9 = r4
            r4 = r1
            r1 = r5
            r5 = r2
            r2 = r0
            r0 = r6
            goto L7e
        L49:
            kotlin.Result$Failure r9 = (kotlin.Result.Failure) r9
            java.lang.Throwable r8 = r9.exception
            throw r8
        L4e:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L56:
            boolean r2 = r9 instanceof kotlin.Result.Failure
            if (r2 != 0) goto L83
            int r9 = r8.length
            r2 = 0
            r5 = r9
            r4 = r1
            r9 = r8
            r1 = r9
            r8 = r2
            r2 = r0
            r0 = r1
        L63:
            if (r8 >= r5) goto L80
            r6 = r9[r8]
            r2.L$0 = r0
            r2.L$1 = r1
            r2.L$2 = r9
            r2.I$0 = r5
            r2.I$1 = r8
            r2.L$3 = r6
            r2.L$4 = r6
            r2.label = r3
            java.lang.Object r6 = r6.join(r2)
            if (r6 != r4) goto L7e
            return r4
        L7e:
            int r8 = r8 + r3
            goto L63
        L80:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        L83:
            kotlin.Result$Failure r9 = (kotlin.Result.Failure) r9
            java.lang.Throwable r8 = r9.exception
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.AwaitKt.joinAll(kotlinx.coroutines.Job[], kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object joinAll(java.util.Collection<? extends kotlinx.coroutines.Job> r7, kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            boolean r0 = r8 instanceof kotlinx.coroutines.AwaitKt$joinAll$3
            if (r0 == 0) goto L14
            r0 = r8
            kotlinx.coroutines.AwaitKt$joinAll$3 r0 = (kotlinx.coroutines.AwaitKt$joinAll$3) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L19
        L14:
            kotlinx.coroutines.AwaitKt$joinAll$3 r0 = new kotlinx.coroutines.AwaitKt$joinAll$3
            r0.<init>(r8)
        L19:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L4b
            if (r2 != r3) goto L43
            java.lang.Object r7 = r0.L$4
            kotlinx.coroutines.Job r7 = (kotlinx.coroutines.Job) r7
            java.lang.Object r7 = r0.L$3
            java.lang.Object r7 = r0.L$2
            java.util.Iterator r7 = (java.util.Iterator) r7
            java.lang.Object r2 = r0.L$1
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.lang.Object r4 = r0.L$0
            java.util.Collection r4 = (java.util.Collection) r4
            boolean r5 = r8 instanceof kotlin.Result.Failure
            if (r5 != 0) goto L3e
            r8 = r4
            goto L5a
        L3e:
            kotlin.Result$Failure r8 = (kotlin.Result.Failure) r8
            java.lang.Throwable r7 = r8.exception
            throw r7
        L43:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L4b:
            boolean r2 = r8 instanceof kotlin.Result.Failure
            if (r2 != 0) goto L7d
            r8 = r7
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            java.util.Iterator r2 = r8.iterator()
            r6 = r8
            r8 = r7
            r7 = r2
            r2 = r6
        L5a:
            boolean r4 = r7.hasNext()
            if (r4 == 0) goto L7a
            java.lang.Object r4 = r7.next()
            r5 = r4
            kotlinx.coroutines.Job r5 = (kotlinx.coroutines.Job) r5
            r0.L$0 = r8
            r0.L$1 = r2
            r0.L$2 = r7
            r0.L$3 = r4
            r0.L$4 = r5
            r0.label = r3
            java.lang.Object r4 = r5.join(r0)
            if (r4 != r1) goto L5a
            return r1
        L7a:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        L7d:
            kotlin.Result$Failure r8 = (kotlin.Result.Failure) r8
            java.lang.Throwable r7 = r8.exception
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.AwaitKt.joinAll(java.util.Collection, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
