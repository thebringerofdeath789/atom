package androidx.lifecycle;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;

/* compiled from: PausingDispatcher.kt */
@Metadata(m2336bv = {1, 0, 3}, m2337d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\n\u0010\t\u001a\u00060\nj\u0002`\u000bH\u0017R\u0010\u0010\u0003\u001a\u00020\u00048\u0000X\u0081\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, m2338d2 = {"Landroidx/lifecycle/PausingDispatcher;", "Lkotlinx/coroutines/CoroutineDispatcher;", "()V", "dispatchQueue", "Landroidx/lifecycle/DispatchQueue;", "dispatch", "", "context", "Lkotlin/coroutines/CoroutineContext;", "block", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "lifecycle-runtime-ktx_release"}, m2339k = 1, m2340mv = {1, 1, 15})
/* loaded from: classes.dex */
public final class PausingDispatcher extends CoroutineDispatcher {
    public final DispatchQueue dispatchQueue = new DispatchQueue();

    @Override // kotlinx.coroutines.CoroutineDispatcher
    /* renamed from: dispatch */
    public void mo3981dispatch(CoroutineContext context, Runnable block) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(block, "block");
        this.dispatchQueue.runOrEnqueue(block);
    }
}