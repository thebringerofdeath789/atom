package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: Builders.common.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004H\u0096@ø\u0001\u0000"}, d2 = {"await", "", "T", "continuation", "Lkotlin/coroutines/Continuation;"}, k = 3, mv = {1, 1, 13})
@DebugMetadata(c = "kotlinx.coroutines.DeferredCoroutine", f = "Builders.common.kt", i = {0}, l = {99}, m = "await$suspendImpl", n = {"this"}, s = {"L$0"})
/* loaded from: classes4.dex */
final class DeferredCoroutine$await$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DeferredCoroutine this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DeferredCoroutine$await$1(DeferredCoroutine deferredCoroutine, Continuation continuation) {
        super(continuation);
        this.this$0 = deferredCoroutine;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return DeferredCoroutine.await$suspendImpl(this.this$0, this);
    }
}
