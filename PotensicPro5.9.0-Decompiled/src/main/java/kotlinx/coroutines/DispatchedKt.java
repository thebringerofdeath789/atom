package kotlinx.coroutines;

import io.netty.handler.codec.rtsp.RtspHeaders;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.internal.ThreadContextKt;

/* compiled from: Dispatched.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0003\n\u0002\b\u0006\u001a\u001f\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\tH\u0082\b\u001a\"\u0010\n\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u000b*\b\u0012\u0004\u0012\u0002H\u000b0\f2\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0000\u001a;\u0010\u000f\u001a\u00020\u0010*\u0006\u0012\u0002\b\u00030\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u0014\u001a\u00020\u00102\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\tH\u0082\b\u001a.\u0010\u0015\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u000b*\b\u0012\u0004\u0012\u0002H\u000b0\f2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u00172\u0006\u0010\u0018\u001a\u00020\u000eH\u0000\u001a%\u0010\u0019\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u000b*\b\u0012\u0004\u0012\u0002H\u000b0\u00172\u0006\u0010\u001a\u001a\u0002H\u000bH\u0000¢\u0006\u0002\u0010\u001b\u001a \u0010\u001c\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u000b*\b\u0012\u0004\u0012\u0002H\u000b0\u00172\u0006\u0010\u001d\u001a\u00020\u001eH\u0000\u001a%\u0010\u001f\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u000b*\b\u0012\u0004\u0012\u0002H\u000b0\u00172\u0006\u0010\u001a\u001a\u0002H\u000bH\u0000¢\u0006\u0002\u0010\u001b\u001a \u0010 \u001a\u00020\u0005\"\u0004\b\u0000\u0010\u000b*\b\u0012\u0004\u0012\u0002H\u000b0\u00172\u0006\u0010\u001d\u001a\u00020\u001eH\u0000\u001a\u0010\u0010!\u001a\u00020\u0005*\u0006\u0012\u0002\b\u00030\fH\u0002\u001a\u0019\u0010\"\u001a\u00020\u0005*\u0006\u0012\u0002\b\u00030\u00172\u0006\u0010\u001d\u001a\u00020\u001eH\u0080\b\u001a\u0012\u0010#\u001a\u00020\u0010*\b\u0012\u0004\u0012\u00020\u00050\u0011H\u0000\"\u0016\u0010\u0000\u001a\u00020\u00018\u0002X\u0083\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0002\u0010\u0003¨\u0006$"}, d2 = {"UNDEFINED", "Lkotlinx/coroutines/internal/Symbol;", "UNDEFINED$annotations", "()V", "runUnconfinedEventLoop", "", "eventLoop", "Lkotlinx/coroutines/EventLoop;", "block", "Lkotlin/Function0;", "dispatch", "T", "Lkotlinx/coroutines/DispatchedTask;", RtspHeaders.Values.MODE, "", "executeUnconfined", "", "Lkotlinx/coroutines/DispatchedContinuation;", "contState", "", "doYield", "resume", "delegate", "Lkotlin/coroutines/Continuation;", "useMode", "resumeCancellable", "value", "(Lkotlin/coroutines/Continuation;Ljava/lang/Object;)V", "resumeCancellableWithException", "exception", "", "resumeDirect", "resumeDirectWithException", "resumeUnconfined", "resumeWithStackTrace", "yieldUndispatched", "kotlinx-coroutines-core"}, k = 2, mv = {1, 1, 13})
/* loaded from: classes4.dex */
public final class DispatchedKt {
    private static final Symbol UNDEFINED = new Symbol("UNDEFINED");

    private static /* synthetic */ void UNDEFINED$annotations() {
    }

    private static final boolean executeUnconfined(DispatchedContinuation<?> dispatchedContinuation, Object obj, int i, boolean z, Function0<Unit> function0) {
        EventLoop eventLoop$kotlinx_coroutines_core = ThreadLocalEventLoop.INSTANCE.getEventLoop$kotlinx_coroutines_core();
        if (z && eventLoop$kotlinx_coroutines_core.isUnconfinedQueueEmpty()) {
            return false;
        }
        if (eventLoop$kotlinx_coroutines_core.isUnconfinedLoopActive()) {
            dispatchedContinuation._state = obj;
            dispatchedContinuation.resumeMode = i;
            eventLoop$kotlinx_coroutines_core.dispatchUnconfined(dispatchedContinuation);
            return true;
        }
        eventLoop$kotlinx_coroutines_core.incrementUseCount(true);
        try {
            function0.invoke();
            do {
            } while (eventLoop$kotlinx_coroutines_core.processUnconfinedEvent());
            return false;
        } catch (Throwable th) {
            try {
                throw new DispatchException("Unexpected exception in unconfined event loop", th);
            } finally {
                InlineMarker.finallyStart(1);
                eventLoop$kotlinx_coroutines_core.decrementUseCount(true);
                InlineMarker.finallyEnd(1);
            }
        }
    }

    private static final void resumeUnconfined(DispatchedTask<?> dispatchedTask) {
        EventLoop eventLoop$kotlinx_coroutines_core = ThreadLocalEventLoop.INSTANCE.getEventLoop$kotlinx_coroutines_core();
        if (eventLoop$kotlinx_coroutines_core.isUnconfinedLoopActive()) {
            eventLoop$kotlinx_coroutines_core.dispatchUnconfined(dispatchedTask);
            return;
        }
        eventLoop$kotlinx_coroutines_core.incrementUseCount(true);
        try {
            resume(dispatchedTask, dispatchedTask.getDelegate(), 3);
            do {
            } while (eventLoop$kotlinx_coroutines_core.processUnconfinedEvent());
        } catch (Throwable th) {
            try {
                throw new DispatchException("Unexpected exception in unconfined event loop", th);
            } finally {
                eventLoop$kotlinx_coroutines_core.decrementUseCount(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void runUnconfinedEventLoop(EventLoop eventLoop, Function0<Unit> function0) {
        eventLoop.incrementUseCount(true);
        try {
            function0.invoke();
            do {
            } while (eventLoop.processUnconfinedEvent());
        } finally {
        }
    }

    public static final <T> void resumeCancellable(Continuation<? super T> receiver$0, T t) {
        boolean z;
        Intrinsics.checkParameterIsNotNull(receiver$0, "receiver$0");
        if (!(receiver$0 instanceof DispatchedContinuation)) {
            Result.Companion companion = Result.INSTANCE;
            receiver$0.resumeWith(Result.m51constructorimpl(t));
            return;
        }
        DispatchedContinuation dispatchedContinuation = (DispatchedContinuation) receiver$0;
        if (dispatchedContinuation.dispatcher.isDispatchNeeded(dispatchedContinuation.get$context())) {
            dispatchedContinuation._state = t;
            dispatchedContinuation.resumeMode = 1;
            dispatchedContinuation.dispatcher.mo1371dispatch(dispatchedContinuation.get$context(), dispatchedContinuation);
            return;
        }
        EventLoop eventLoop$kotlinx_coroutines_core = ThreadLocalEventLoop.INSTANCE.getEventLoop$kotlinx_coroutines_core();
        if (eventLoop$kotlinx_coroutines_core.isUnconfinedLoopActive()) {
            dispatchedContinuation._state = t;
            dispatchedContinuation.resumeMode = 1;
            eventLoop$kotlinx_coroutines_core.dispatchUnconfined(dispatchedContinuation);
            return;
        }
        eventLoop$kotlinx_coroutines_core.incrementUseCount(true);
        try {
            Job job = (Job) dispatchedContinuation.get$context().get(Job.INSTANCE);
            if (job == null || job.isActive()) {
                z = false;
            } else {
                CancellationException cancellationException = job.getCancellationException();
                Result.Companion companion2 = Result.INSTANCE;
                dispatchedContinuation.resumeWith(Result.m51constructorimpl(ResultKt.createFailure(cancellationException)));
                z = true;
            }
            if (!z) {
                CoroutineContext coroutineContext = dispatchedContinuation.get$context();
                Object updateThreadContext = ThreadContextKt.updateThreadContext(coroutineContext, dispatchedContinuation.countOrElement);
                try {
                    Continuation<T> continuation = dispatchedContinuation.continuation;
                    Result.Companion companion3 = Result.INSTANCE;
                    continuation.resumeWith(Result.m51constructorimpl(t));
                    Unit unit = Unit.INSTANCE;
                    ThreadContextKt.restoreThreadContext(coroutineContext, updateThreadContext);
                } catch (Throwable th) {
                    ThreadContextKt.restoreThreadContext(coroutineContext, updateThreadContext);
                    throw th;
                }
            }
            while (eventLoop$kotlinx_coroutines_core.processUnconfinedEvent()) {
            }
        } catch (Throwable th2) {
            try {
                throw new DispatchException("Unexpected exception in unconfined event loop", th2);
            } finally {
                eventLoop$kotlinx_coroutines_core.decrementUseCount(true);
            }
        }
    }

    public static final <T> void resumeCancellableWithException(Continuation<? super T> receiver$0, Throwable exception) {
        boolean z;
        Intrinsics.checkParameterIsNotNull(receiver$0, "receiver$0");
        Intrinsics.checkParameterIsNotNull(exception, "exception");
        if (receiver$0 instanceof DispatchedContinuation) {
            DispatchedContinuation dispatchedContinuation = (DispatchedContinuation) receiver$0;
            CoroutineContext coroutineContext = dispatchedContinuation.continuation.get$context();
            CompletedExceptionally completedExceptionally = new CompletedExceptionally(exception);
            if (dispatchedContinuation.dispatcher.isDispatchNeeded(coroutineContext)) {
                dispatchedContinuation._state = new CompletedExceptionally(exception);
                dispatchedContinuation.resumeMode = 1;
                dispatchedContinuation.dispatcher.mo1371dispatch(coroutineContext, dispatchedContinuation);
                return;
            }
            EventLoop eventLoop$kotlinx_coroutines_core = ThreadLocalEventLoop.INSTANCE.getEventLoop$kotlinx_coroutines_core();
            if (eventLoop$kotlinx_coroutines_core.isUnconfinedLoopActive()) {
                dispatchedContinuation._state = completedExceptionally;
                dispatchedContinuation.resumeMode = 1;
                eventLoop$kotlinx_coroutines_core.dispatchUnconfined(dispatchedContinuation);
                return;
            }
            eventLoop$kotlinx_coroutines_core.incrementUseCount(true);
            try {
                Job job = (Job) dispatchedContinuation.get$context().get(Job.INSTANCE);
                if (job == null || job.isActive()) {
                    z = false;
                } else {
                    CancellationException cancellationException = job.getCancellationException();
                    Result.Companion companion = Result.INSTANCE;
                    dispatchedContinuation.resumeWith(Result.m51constructorimpl(ResultKt.createFailure(cancellationException)));
                    z = true;
                }
                if (!z) {
                    CoroutineContext coroutineContext2 = dispatchedContinuation.get$context();
                    Object updateThreadContext = ThreadContextKt.updateThreadContext(coroutineContext2, dispatchedContinuation.countOrElement);
                    try {
                        Continuation<T> continuation = dispatchedContinuation.continuation;
                        Result.Companion companion2 = Result.INSTANCE;
                        continuation.resumeWith(Result.m51constructorimpl(ResultKt.createFailure(StackTraceRecoveryKt.recoverStackTrace(exception, continuation))));
                        Unit unit = Unit.INSTANCE;
                        ThreadContextKt.restoreThreadContext(coroutineContext2, updateThreadContext);
                    } catch (Throwable th) {
                        ThreadContextKt.restoreThreadContext(coroutineContext2, updateThreadContext);
                        throw th;
                    }
                }
                while (eventLoop$kotlinx_coroutines_core.processUnconfinedEvent()) {
                }
                return;
            } catch (Throwable th2) {
                try {
                    throw new DispatchException("Unexpected exception in unconfined event loop", th2);
                } finally {
                    eventLoop$kotlinx_coroutines_core.decrementUseCount(true);
                }
            }
        }
        Result.Companion companion3 = Result.INSTANCE;
        receiver$0.resumeWith(Result.m51constructorimpl(ResultKt.createFailure(StackTraceRecoveryKt.recoverStackTrace(exception, receiver$0))));
    }

    public static final <T> void resumeDirect(Continuation<? super T> receiver$0, T t) {
        Intrinsics.checkParameterIsNotNull(receiver$0, "receiver$0");
        if (!(receiver$0 instanceof DispatchedContinuation)) {
            Result.Companion companion = Result.INSTANCE;
            receiver$0.resumeWith(Result.m51constructorimpl(t));
        } else {
            Continuation<T> continuation = ((DispatchedContinuation) receiver$0).continuation;
            Result.Companion companion2 = Result.INSTANCE;
            continuation.resumeWith(Result.m51constructorimpl(t));
        }
    }

    public static final <T> void resumeDirectWithException(Continuation<? super T> receiver$0, Throwable exception) {
        Intrinsics.checkParameterIsNotNull(receiver$0, "receiver$0");
        Intrinsics.checkParameterIsNotNull(exception, "exception");
        if (receiver$0 instanceof DispatchedContinuation) {
            Continuation<T> continuation = ((DispatchedContinuation) receiver$0).continuation;
            Result.Companion companion = Result.INSTANCE;
            continuation.resumeWith(Result.m51constructorimpl(ResultKt.createFailure(StackTraceRecoveryKt.recoverStackTrace(exception, continuation))));
        } else {
            Result.Companion companion2 = Result.INSTANCE;
            receiver$0.resumeWith(Result.m51constructorimpl(ResultKt.createFailure(StackTraceRecoveryKt.recoverStackTrace(exception, receiver$0))));
        }
    }

    public static final boolean yieldUndispatched(DispatchedContinuation<? super Unit> receiver$0) {
        Intrinsics.checkParameterIsNotNull(receiver$0, "receiver$0");
        Unit unit = Unit.INSTANCE;
        EventLoop eventLoop$kotlinx_coroutines_core = ThreadLocalEventLoop.INSTANCE.getEventLoop$kotlinx_coroutines_core();
        if (eventLoop$kotlinx_coroutines_core.isUnconfinedQueueEmpty()) {
            return false;
        }
        if (eventLoop$kotlinx_coroutines_core.isUnconfinedLoopActive()) {
            receiver$0._state = unit;
            receiver$0.resumeMode = 1;
            eventLoop$kotlinx_coroutines_core.dispatchUnconfined(receiver$0);
            return true;
        }
        eventLoop$kotlinx_coroutines_core.incrementUseCount(true);
        try {
            receiver$0.run();
            do {
            } while (eventLoop$kotlinx_coroutines_core.processUnconfinedEvent());
            return false;
        } catch (Throwable th) {
            try {
                throw new DispatchException("Unexpected exception in unconfined event loop", th);
            } finally {
                eventLoop$kotlinx_coroutines_core.decrementUseCount(true);
            }
        }
    }

    public static /* synthetic */ void dispatch$default(DispatchedTask dispatchedTask, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 1;
        }
        dispatch(dispatchedTask, i);
    }

    public static final <T> void dispatch(DispatchedTask<? super T> receiver$0, int i) {
        Intrinsics.checkParameterIsNotNull(receiver$0, "receiver$0");
        Continuation<? super T> delegate = receiver$0.getDelegate();
        if (ResumeModeKt.isDispatchedMode(i) && (delegate instanceof DispatchedContinuation) && ResumeModeKt.isCancellableMode(i) == ResumeModeKt.isCancellableMode(receiver$0.resumeMode)) {
            CoroutineDispatcher coroutineDispatcher = ((DispatchedContinuation) delegate).dispatcher;
            CoroutineContext coroutineContext = delegate.get$context();
            if (coroutineDispatcher.isDispatchNeeded(coroutineContext)) {
                coroutineDispatcher.mo1371dispatch(coroutineContext, receiver$0);
                return;
            } else {
                resumeUnconfined(receiver$0);
                return;
            }
        }
        resume(receiver$0, delegate, i);
    }

    public static final <T> void resume(DispatchedTask<? super T> receiver$0, Continuation<? super T> delegate, int i) {
        Intrinsics.checkParameterIsNotNull(receiver$0, "receiver$0");
        Intrinsics.checkParameterIsNotNull(delegate, "delegate");
        Object takeState = receiver$0.takeState();
        Throwable exceptionalResult = receiver$0.getExceptionalResult(takeState);
        if (exceptionalResult != null) {
            ResumeModeKt.resumeWithExceptionMode(delegate, exceptionalResult, i);
        } else {
            ResumeModeKt.resumeMode(delegate, receiver$0.getSuccessfulResult(takeState), i);
        }
    }

    public static final void resumeWithStackTrace(Continuation<?> receiver$0, Throwable exception) {
        Intrinsics.checkParameterIsNotNull(receiver$0, "receiver$0");
        Intrinsics.checkParameterIsNotNull(exception, "exception");
        Result.Companion companion = Result.INSTANCE;
        receiver$0.resumeWith(Result.m51constructorimpl(ResultKt.createFailure(StackTraceRecoveryKt.recoverStackTrace(exception, receiver$0))));
    }

    static /* synthetic */ boolean executeUnconfined$default(DispatchedContinuation dispatchedContinuation, Object obj, int i, boolean z, Function0 function0, int i2, Object obj2) {
        if ((i2 & 4) != 0) {
            z = false;
        }
        EventLoop eventLoop$kotlinx_coroutines_core = ThreadLocalEventLoop.INSTANCE.getEventLoop$kotlinx_coroutines_core();
        if (z && eventLoop$kotlinx_coroutines_core.isUnconfinedQueueEmpty()) {
            return false;
        }
        if (eventLoop$kotlinx_coroutines_core.isUnconfinedLoopActive()) {
            dispatchedContinuation._state = obj;
            dispatchedContinuation.resumeMode = i;
            eventLoop$kotlinx_coroutines_core.dispatchUnconfined(dispatchedContinuation);
            return true;
        }
        eventLoop$kotlinx_coroutines_core.incrementUseCount(true);
        try {
            function0.invoke();
            do {
            } while (eventLoop$kotlinx_coroutines_core.processUnconfinedEvent());
            return false;
        } catch (Throwable th) {
            try {
                throw new DispatchException("Unexpected exception in unconfined event loop", th);
            } finally {
                InlineMarker.finallyStart(1);
                eventLoop$kotlinx_coroutines_core.decrementUseCount(true);
                InlineMarker.finallyEnd(1);
            }
        }
    }
}
