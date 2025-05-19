package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CompletedExceptionally.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\"\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0000ø\u0001\u0000¢\u0006\u0002\u0010\u0004\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0005"}, d2 = {"toState", "", "T", "Lkotlin/Result;", "(Ljava/lang/Object;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 1, 13})
/* loaded from: classes4.dex */
public final class CompletedExceptionallyKt {
    public static final <T> Object toState(Object obj) {
        if (Result.m58isSuccessimpl(obj)) {
            ResultKt.throwOnFailure(obj);
            return obj;
        }
        Throwable m54exceptionOrNullimpl = Result.m54exceptionOrNullimpl(obj);
        if (m54exceptionOrNullimpl == null) {
            Intrinsics.throwNpe();
        }
        return new CompletedExceptionally(m54exceptionOrNullimpl);
    }
}
