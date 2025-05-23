package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequenceScope;
import org.apache.xmlbeans.XmlErrorCodes;

/* compiled from: JobSupport.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u008a@ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "Lkotlin/sequences/SequenceScope;", "Lkotlinx/coroutines/ChildJob;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, 13})
@DebugMetadata(c = "kotlinx.coroutines.JobSupport$children$1", f = "JobSupport.kt", i = {0, 1, 1, 1, 1, 1}, l = {848, 850}, m = "invokeSuspend", n = {"state", "state", XmlErrorCodes.LIST, "this_$iv", "cur$iv", "it"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5"})
/* loaded from: classes4.dex */
final class JobSupport$children$1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super ChildJob>, Continuation<? super Unit>, Object> {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    private SequenceScope p$;
    final /* synthetic */ JobSupport this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    JobSupport$children$1(JobSupport jobSupport, Continuation continuation) {
        super(2, continuation);
        this.this$0 = jobSupport;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> completion) {
        Intrinsics.checkParameterIsNotNull(completion, "completion");
        JobSupport$children$1 jobSupport$children$1 = new JobSupport$children$1(this.this$0, completion);
        jobSupport$children$1.p$ = (SequenceScope) obj;
        return jobSupport$children$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(SequenceScope<? super ChildJob> sequenceScope, Continuation<? super Unit> continuation) {
        return ((JobSupport$children$1) create(sequenceScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0087  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x0089 -> B:8:0x00a5). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x00a2 -> B:8:0x00a5). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r11) {
        /*
            r10 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r10.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L43
            if (r1 == r3) goto L38
            if (r1 != r2) goto L30
            java.lang.Object r1 = r10.L$5
            kotlinx.coroutines.ChildHandleNode r1 = (kotlinx.coroutines.ChildHandleNode) r1
            java.lang.Object r1 = r10.L$4
            kotlinx.coroutines.internal.LockFreeLinkedListNode r1 = (kotlinx.coroutines.internal.LockFreeLinkedListNode) r1
            java.lang.Object r4 = r10.L$3
            kotlinx.coroutines.NodeList r4 = (kotlinx.coroutines.NodeList) r4
            java.lang.Object r5 = r10.L$2
            kotlinx.coroutines.NodeList r5 = (kotlinx.coroutines.NodeList) r5
            java.lang.Object r6 = r10.L$1
            java.lang.Object r7 = r10.L$0
            kotlin.sequences.SequenceScope r7 = (kotlin.sequences.SequenceScope) r7
            boolean r8 = r11 instanceof kotlin.Result.Failure
            if (r8 != 0) goto L2b
            r11 = r10
            goto La5
        L2b:
            kotlin.Result$Failure r11 = (kotlin.Result.Failure) r11
            java.lang.Throwable r11 = r11.exception
            throw r11
        L30:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L38:
            boolean r0 = r11 instanceof kotlin.Result.Failure
            if (r0 != 0) goto L3e
            goto Lb2
        L3e:
            kotlin.Result$Failure r11 = (kotlin.Result.Failure) r11
            java.lang.Throwable r11 = r11.exception
            throw r11
        L43:
            boolean r1 = r11 instanceof kotlin.Result.Failure
            if (r1 != 0) goto Lb5
            kotlin.sequences.SequenceScope r11 = r10.p$
            kotlinx.coroutines.JobSupport r1 = r10.this$0
            java.lang.Object r1 = r1.getState$kotlinx_coroutines_core()
            boolean r4 = r1 instanceof kotlinx.coroutines.ChildHandleNode
            if (r4 == 0) goto L63
            r2 = r1
            kotlinx.coroutines.ChildHandleNode r2 = (kotlinx.coroutines.ChildHandleNode) r2
            kotlinx.coroutines.ChildJob r2 = r2.childJob
            r10.L$0 = r1
            r10.label = r3
            java.lang.Object r11 = r11.yield(r2, r10)
            if (r11 != r0) goto Lb2
            return r0
        L63:
            boolean r4 = r1 instanceof kotlinx.coroutines.Incomplete
            if (r4 == 0) goto Lb2
            r4 = r1
            kotlinx.coroutines.Incomplete r4 = (kotlinx.coroutines.Incomplete) r4
            kotlinx.coroutines.NodeList r4 = r4.getList()
            if (r4 == 0) goto Lb2
            java.lang.Object r5 = r4.getNext()
            if (r5 == 0) goto Laa
            kotlinx.coroutines.internal.LockFreeLinkedListNode r5 = (kotlinx.coroutines.internal.LockFreeLinkedListNode) r5
            r7 = r11
            r6 = r1
            r1 = r5
            r11 = r10
            r5 = r4
        L7d:
            r8 = r4
            kotlinx.coroutines.internal.LockFreeLinkedListHead r8 = (kotlinx.coroutines.internal.LockFreeLinkedListHead) r8
            boolean r8 = kotlin.jvm.internal.Intrinsics.areEqual(r1, r8)
            r8 = r8 ^ r3
            if (r8 == 0) goto Lb2
            boolean r8 = r1 instanceof kotlinx.coroutines.ChildHandleNode
            if (r8 == 0) goto La5
            r8 = r1
            kotlinx.coroutines.ChildHandleNode r8 = (kotlinx.coroutines.ChildHandleNode) r8
            kotlinx.coroutines.ChildJob r9 = r8.childJob
            r11.L$0 = r7
            r11.L$1 = r6
            r11.L$2 = r5
            r11.L$3 = r4
            r11.L$4 = r1
            r11.L$5 = r8
            r11.label = r2
            java.lang.Object r8 = r7.yield(r9, r11)
            if (r8 != r0) goto La5
            return r0
        La5:
            kotlinx.coroutines.internal.LockFreeLinkedListNode r1 = r1.getNextNode()
            goto L7d
        Laa:
            kotlin.TypeCastException r11 = new kotlin.TypeCastException
        */
        //  java.lang.String r0 = "null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */"
        /*
            r11.<init>(r0)
            throw r11
        Lb2:
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        Lb5:
            kotlin.Result$Failure r11 = (kotlin.Result.Failure) r11
            java.lang.Throwable r11 = r11.exception
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.JobSupport$children$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
