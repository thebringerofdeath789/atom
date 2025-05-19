package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Exceptions.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0080\b*\n\u0010\u0004\"\u00020\u00052\u00020\u0005¨\u0006\u0006"}, d2 = {"addSuppressedThrowable", "", "", "other", "CancellationException", "Ljava/util/concurrent/CancellationException;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 1, 13})
/* loaded from: classes4.dex */
public final class ExceptionsKt {
    public static final void addSuppressedThrowable(Throwable receiver$0, Throwable other) {
        Intrinsics.checkParameterIsNotNull(receiver$0, "receiver$0");
        Intrinsics.checkParameterIsNotNull(other, "other");
        kotlin.ExceptionsKt.addSuppressed(receiver$0, other);
    }
}
