package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;
import kotlinx.coroutines.internal.ThreadContextKt;
import kotlinx.coroutines.scheduling.Task;
import kotlinx.coroutines.scheduling.TaskContext;

/* compiled from: Dispatched.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b \u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00060\u0002j\u0002`\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eJ\u001d\u0010\u000f\u001a\u0002H\u0001\"\u0004\b\u0001\u0010\u00012\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0002\u0010\u0010J\u0006\u0010\u0011\u001a\u00020\u0012J\n\u0010\u0013\u001a\u0004\u0018\u00010\u000eH&R\u0018\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lkotlinx/coroutines/DispatchedTask;", "T", "Lkotlinx/coroutines/scheduling/Task;", "Lkotlinx/coroutines/SchedulerTask;", "resumeMode", "", "(I)V", "delegate", "Lkotlin/coroutines/Continuation;", "getDelegate", "()Lkotlin/coroutines/Continuation;", "getExceptionalResult", "", "state", "", "getSuccessfulResult", "(Ljava/lang/Object;)Ljava/lang/Object;", "run", "", "takeState", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 13})
/* loaded from: classes4.dex */
public abstract class DispatchedTask<T> extends Task {
    public int resumeMode;

    public abstract Continuation<T> getDelegate();

    /* JADX WARN: Multi-variable type inference failed */
    public <T> T getSuccessfulResult(Object state) {
        return state;
    }

    public abstract Object takeState();

    public DispatchedTask(int i) {
        this.resumeMode = i;
    }

    public final Throwable getExceptionalResult(Object state) {
        if (!(state instanceof CompletedExceptionally)) {
            state = null;
        }
        CompletedExceptionally completedExceptionally = (CompletedExceptionally) state;
        if (completedExceptionally != null) {
            return completedExceptionally.cause;
        }
        return null;
    }

    @Override // java.lang.Runnable
    public final void run() {
        TaskContext taskContext = this.taskContext;
        try {
            Continuation<T> delegate = getDelegate();
            if (delegate == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.DispatchedContinuation<T>");
            }
            DispatchedContinuation dispatchedContinuation = (DispatchedContinuation) delegate;
            Continuation<T> continuation = dispatchedContinuation.continuation;
            CoroutineContext coroutineContext = continuation.get$context();
            Job job = ResumeModeKt.isCancellableMode(this.resumeMode) ? (Job) coroutineContext.get(Job.INSTANCE) : null;
            Object takeState = takeState();
            Object updateThreadContext = ThreadContextKt.updateThreadContext(coroutineContext, dispatchedContinuation.countOrElement);
            if (job != null) {
                try {
                    if (!job.isActive()) {
                        CancellationException cancellationException = job.getCancellationException();
                        Result.Companion companion = Result.INSTANCE;
                        continuation.resumeWith(Result.m51constructorimpl(ResultKt.createFailure(cancellationException)));
                        Unit unit = Unit.INSTANCE;
                    }
                } finally {
                    ThreadContextKt.restoreThreadContext(coroutineContext, updateThreadContext);
                }
            }
            Throwable exceptionalResult = getExceptionalResult(takeState);
            if (exceptionalResult == null) {
                T successfulResult = getSuccessfulResult(takeState);
                Result.Companion companion2 = Result.INSTANCE;
                continuation.resumeWith(Result.m51constructorimpl(successfulResult));
            } else {
                Result.Companion companion3 = Result.INSTANCE;
                continuation.resumeWith(Result.m51constructorimpl(ResultKt.createFailure(StackTraceRecoveryKt.recoverStackTrace(exceptionalResult, continuation))));
            }
            Unit unit2 = Unit.INSTANCE;
        } finally {
        }
    }
}
