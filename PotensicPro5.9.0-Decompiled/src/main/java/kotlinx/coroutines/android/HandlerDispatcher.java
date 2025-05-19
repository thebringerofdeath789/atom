package kotlinx.coroutines.android;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Delay;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* compiled from: HandlerDispatcher.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\b\u0002¢\u0006\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u00008&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0003\u001a\u0004\b\u0006\u0010\u0007\u0082\u0001\u0001\b¨\u0006\t"}, d2 = {"Lkotlinx/coroutines/android/HandlerDispatcher;", "Lkotlinx/coroutines/MainCoroutineDispatcher;", "Lkotlinx/coroutines/Delay;", "()V", "immediate", "immediate$annotations", "getImmediate", "()Lkotlinx/coroutines/android/HandlerDispatcher;", "Lkotlinx/coroutines/android/HandlerContext;", "kotlinx-coroutines-android"}, k = 1, mv = {1, 1, 13})
/* loaded from: classes4.dex */
public abstract class HandlerDispatcher extends MainCoroutineDispatcher implements Delay {
    public static /* synthetic */ void immediate$annotations() {
    }

    @Override // kotlinx.coroutines.MainCoroutineDispatcher
    public abstract HandlerDispatcher getImmediate();

    private HandlerDispatcher() {
    }

    public /* synthetic */ HandlerDispatcher(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Override // kotlinx.coroutines.Delay
    public Object delay(long j, Continuation<? super Unit> continuation) {
        return Delay.DefaultImpls.delay(this, j, continuation);
    }

    public DisposableHandle invokeOnTimeout(long j, Runnable block) {
        Intrinsics.checkParameterIsNotNull(block, "block");
        return Delay.DefaultImpls.invokeOnTimeout(this, j, block);
    }
}
