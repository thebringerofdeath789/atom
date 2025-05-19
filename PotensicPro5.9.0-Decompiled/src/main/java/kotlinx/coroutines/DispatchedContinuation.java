package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.internal.ThreadContextKt;
import org.apache.commons.beanutils.PropertyUtils;

/* compiled from: Dispatched.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00060\u0003j\u0002`\u00042\b\u0012\u0004\u0012\u0002H\u00010\u0005B\u001b\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0002\u0010\tJ\u0017\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00028\u0000H\u0000¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\n\u0018\u00010\u001fj\u0004\u0018\u0001` H\u0016J\u0016\u0010!\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00028\u0000H\u0086\b¢\u0006\u0002\u0010\u001dJ\u0011\u0010\"\u001a\u00020\u001a2\u0006\u0010#\u001a\u00020$H\u0086\bJ\t\u0010%\u001a\u00020&H\u0086\bJ\u0016\u0010'\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00028\u0000H\u0086\b¢\u0006\u0002\u0010\u001dJ\u0011\u0010(\u001a\u00020\u001a2\u0006\u0010#\u001a\u00020$H\u0086\bJ\u001e\u0010)\u001a\u00020\u001a2\f\u0010*\u001a\b\u0012\u0004\u0012\u00028\u00000+H\u0016ø\u0001\u0000¢\u0006\u0002\u0010\u001dJ\n\u0010,\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010-\u001a\u00020.H\u0016R\u001a\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0000@\u0000X\u0081\u000e¢\u0006\b\n\u0000\u0012\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0012\u0010\u0011\u001a\u00020\u0012X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u00020\u000b8\u0000X\u0081\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0010\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006/"}, d2 = {"Lkotlinx/coroutines/DispatchedContinuation;", "T", "Lkotlinx/coroutines/DispatchedTask;", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "Lkotlinx/coroutines/internal/CoroutineStackFrame;", "Lkotlin/coroutines/Continuation;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "continuation", "(Lkotlinx/coroutines/CoroutineDispatcher;Lkotlin/coroutines/Continuation;)V", "_state", "", "_state$annotations", "()V", "callerFrame", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "context", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "countOrElement", "delegate", "getDelegate", "()Lkotlin/coroutines/Continuation;", "dispatchYield", "", "value", "dispatchYield$kotlinx_coroutines_core", "(Ljava/lang/Object;)V", "getStackTraceElement", "Ljava/lang/StackTraceElement;", "Lkotlinx/coroutines/internal/StackTraceElement;", "resumeCancellable", "resumeCancellableWithException", "exception", "", "resumeCancelled", "", "resumeUndispatched", "resumeUndispatchedWithException", "resumeWith", "result", "Lkotlin/Result;", "takeState", "toString", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 13})
/* loaded from: classes4.dex */
public final class DispatchedContinuation<T> extends DispatchedTask<T> implements CoroutineStackFrame, Continuation<T> {
    public Object _state;
    private final CoroutineStackFrame callerFrame;
    public final Continuation<T> continuation;
    public final Object countOrElement;
    public final CoroutineDispatcher dispatcher;

    public static /* synthetic */ void _state$annotations() {
    }

    @Override // kotlin.coroutines.Continuation
    /* renamed from: getContext */
    public CoroutineContext get$context() {
        return this.continuation.get$context();
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public DispatchedContinuation(CoroutineDispatcher dispatcher, Continuation<? super T> continuation) {
        super(0);
        Symbol symbol;
        Intrinsics.checkParameterIsNotNull(dispatcher, "dispatcher");
        Intrinsics.checkParameterIsNotNull(continuation, "continuation");
        this.dispatcher = dispatcher;
        this.continuation = continuation;
        symbol = DispatchedKt.UNDEFINED;
        this._state = symbol;
        this.callerFrame = continuation instanceof CoroutineStackFrame ? continuation : (Continuation<? super T>) null;
        this.countOrElement = ThreadContextKt.threadContextElements(get$context());
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public CoroutineStackFrame getCallerFrame() {
        return this.callerFrame;
    }

    @Override // kotlinx.coroutines.DispatchedTask
    public Object takeState() {
        Symbol symbol;
        Symbol symbol2;
        Object obj = this._state;
        symbol = DispatchedKt.UNDEFINED;
        if (obj != symbol) {
            symbol2 = DispatchedKt.UNDEFINED;
            this._state = symbol2;
            return obj;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    @Override // kotlinx.coroutines.DispatchedTask
    public Continuation<T> getDelegate() {
        return this;
    }

    @Override // kotlin.coroutines.Continuation
    public void resumeWith(Object result) {
        CoroutineContext coroutineContext = this.continuation.get$context();
        Object state = CompletedExceptionallyKt.toState(result);
        if (this.dispatcher.isDispatchNeeded(coroutineContext)) {
            this._state = state;
            this.resumeMode = 0;
            this.dispatcher.mo1371dispatch(coroutineContext, this);
            return;
        }
        EventLoop eventLoop$kotlinx_coroutines_core = ThreadLocalEventLoop.INSTANCE.getEventLoop$kotlinx_coroutines_core();
        if (eventLoop$kotlinx_coroutines_core.isUnconfinedLoopActive()) {
            this._state = state;
            this.resumeMode = 0;
            eventLoop$kotlinx_coroutines_core.dispatchUnconfined(this);
            return;
        }
        eventLoop$kotlinx_coroutines_core.incrementUseCount(true);
        try {
            CoroutineContext coroutineContext2 = get$context();
            Object updateThreadContext = ThreadContextKt.updateThreadContext(coroutineContext2, this.countOrElement);
            try {
                this.continuation.resumeWith(result);
                Unit unit = Unit.INSTANCE;
                while (eventLoop$kotlinx_coroutines_core.processUnconfinedEvent()) {
                }
            } finally {
                ThreadContextKt.restoreThreadContext(coroutineContext2, updateThreadContext);
            }
        } catch (Throwable th) {
            try {
                throw new DispatchException("Unexpected exception in unconfined event loop", th);
            } finally {
                eventLoop$kotlinx_coroutines_core.decrementUseCount(true);
            }
        }
    }

    public final void resumeCancellable(T value) {
        boolean z;
        if (this.dispatcher.isDispatchNeeded(get$context())) {
            this._state = value;
            this.resumeMode = 1;
            this.dispatcher.mo1371dispatch(get$context(), this);
            return;
        }
        EventLoop eventLoop$kotlinx_coroutines_core = ThreadLocalEventLoop.INSTANCE.getEventLoop$kotlinx_coroutines_core();
        if (eventLoop$kotlinx_coroutines_core.isUnconfinedLoopActive()) {
            this._state = value;
            this.resumeMode = 1;
            eventLoop$kotlinx_coroutines_core.dispatchUnconfined(this);
            return;
        }
        eventLoop$kotlinx_coroutines_core.incrementUseCount(true);
        try {
            Job job = (Job) get$context().get(Job.INSTANCE);
            if (job == null || job.isActive()) {
                z = false;
            } else {
                CancellationException cancellationException = job.getCancellationException();
                Result.Companion companion = Result.INSTANCE;
                resumeWith(Result.m51constructorimpl(ResultKt.createFailure(cancellationException)));
                z = true;
            }
            if (!z) {
                CoroutineContext coroutineContext = get$context();
                Object updateThreadContext = ThreadContextKt.updateThreadContext(coroutineContext, this.countOrElement);
                try {
                    Continuation<T> continuation = this.continuation;
                    Result.Companion companion2 = Result.INSTANCE;
                    continuation.resumeWith(Result.m51constructorimpl(value));
                    Unit unit = Unit.INSTANCE;
                    InlineMarker.finallyStart(1);
                    ThreadContextKt.restoreThreadContext(coroutineContext, updateThreadContext);
                    InlineMarker.finallyEnd(1);
                } catch (Throwable th) {
                    InlineMarker.finallyStart(1);
                    ThreadContextKt.restoreThreadContext(coroutineContext, updateThreadContext);
                    InlineMarker.finallyEnd(1);
                    throw th;
                }
            }
            while (eventLoop$kotlinx_coroutines_core.processUnconfinedEvent()) {
            }
        } catch (Throwable th2) {
            try {
                throw new DispatchException("Unexpected exception in unconfined event loop", th2);
            } finally {
                InlineMarker.finallyStart(1);
                eventLoop$kotlinx_coroutines_core.decrementUseCount(true);
                InlineMarker.finallyEnd(1);
            }
        }
    }

    public final void resumeCancellableWithException(Throwable exception) {
        boolean z;
        Intrinsics.checkParameterIsNotNull(exception, "exception");
        CoroutineContext coroutineContext = this.continuation.get$context();
        CompletedExceptionally completedExceptionally = new CompletedExceptionally(exception);
        if (this.dispatcher.isDispatchNeeded(coroutineContext)) {
            this._state = new CompletedExceptionally(exception);
            this.resumeMode = 1;
            this.dispatcher.mo1371dispatch(coroutineContext, this);
            return;
        }
        EventLoop eventLoop$kotlinx_coroutines_core = ThreadLocalEventLoop.INSTANCE.getEventLoop$kotlinx_coroutines_core();
        if (eventLoop$kotlinx_coroutines_core.isUnconfinedLoopActive()) {
            this._state = completedExceptionally;
            this.resumeMode = 1;
            eventLoop$kotlinx_coroutines_core.dispatchUnconfined(this);
            return;
        }
        eventLoop$kotlinx_coroutines_core.incrementUseCount(true);
        try {
            Job job = (Job) get$context().get(Job.INSTANCE);
            if (job == null || job.isActive()) {
                z = false;
            } else {
                CancellationException cancellationException = job.getCancellationException();
                Result.Companion companion = Result.INSTANCE;
                resumeWith(Result.m51constructorimpl(ResultKt.createFailure(cancellationException)));
                z = true;
            }
            if (!z) {
                CoroutineContext coroutineContext2 = get$context();
                Object updateThreadContext = ThreadContextKt.updateThreadContext(coroutineContext2, this.countOrElement);
                try {
                    Continuation<T> continuation = this.continuation;
                    Result.Companion companion2 = Result.INSTANCE;
                    continuation.resumeWith(Result.m51constructorimpl(ResultKt.createFailure(StackTraceRecoveryKt.recoverStackTrace(exception, continuation))));
                    Unit unit = Unit.INSTANCE;
                    InlineMarker.finallyStart(1);
                    ThreadContextKt.restoreThreadContext(coroutineContext2, updateThreadContext);
                    InlineMarker.finallyEnd(1);
                } catch (Throwable th) {
                    InlineMarker.finallyStart(1);
                    ThreadContextKt.restoreThreadContext(coroutineContext2, updateThreadContext);
                    InlineMarker.finallyEnd(1);
                    throw th;
                }
            }
            while (eventLoop$kotlinx_coroutines_core.processUnconfinedEvent()) {
            }
        } catch (Throwable th2) {
            try {
                throw new DispatchException("Unexpected exception in unconfined event loop", th2);
            } finally {
                InlineMarker.finallyStart(1);
                eventLoop$kotlinx_coroutines_core.decrementUseCount(true);
                InlineMarker.finallyEnd(1);
            }
        }
    }

    public final boolean resumeCancelled() {
        Job job = (Job) get$context().get(Job.INSTANCE);
        if (job == null || job.isActive()) {
            return false;
        }
        CancellationException cancellationException = job.getCancellationException();
        Result.Companion companion = Result.INSTANCE;
        resumeWith(Result.m51constructorimpl(ResultKt.createFailure(cancellationException)));
        return true;
    }

    public final void resumeUndispatched(T value) {
        CoroutineContext coroutineContext = get$context();
        Object updateThreadContext = ThreadContextKt.updateThreadContext(coroutineContext, this.countOrElement);
        try {
            Continuation<T> continuation = this.continuation;
            Result.Companion companion = Result.INSTANCE;
            continuation.resumeWith(Result.m51constructorimpl(value));
            Unit unit = Unit.INSTANCE;
        } finally {
            InlineMarker.finallyStart(1);
            ThreadContextKt.restoreThreadContext(coroutineContext, updateThreadContext);
            InlineMarker.finallyEnd(1);
        }
    }

    public final void resumeUndispatchedWithException(Throwable exception) {
        Intrinsics.checkParameterIsNotNull(exception, "exception");
        CoroutineContext coroutineContext = get$context();
        Object updateThreadContext = ThreadContextKt.updateThreadContext(coroutineContext, this.countOrElement);
        try {
            Continuation<T> continuation = this.continuation;
            Result.Companion companion = Result.INSTANCE;
            continuation.resumeWith(Result.m51constructorimpl(ResultKt.createFailure(StackTraceRecoveryKt.recoverStackTrace(exception, continuation))));
            Unit unit = Unit.INSTANCE;
        } finally {
            InlineMarker.finallyStart(1);
            ThreadContextKt.restoreThreadContext(coroutineContext, updateThreadContext);
            InlineMarker.finallyEnd(1);
        }
    }

    public final void dispatchYield$kotlinx_coroutines_core(T value) {
        CoroutineContext coroutineContext = this.continuation.get$context();
        this._state = value;
        this.resumeMode = 1;
        this.dispatcher.dispatchYield(coroutineContext, this);
    }

    public String toString() {
        return "DispatchedContinuation[" + this.dispatcher + ", " + DebugKt.toDebugString(this.continuation) + PropertyUtils.INDEXED_DELIM2;
    }
}
