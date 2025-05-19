package kotlinx.coroutines;

import io.netty.handler.codec.rtsp.RtspHeaders;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;
import kotlinx.coroutines.internal.ThreadContextKt;

/* compiled from: ResumeMode.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0003\n\u0002\b\u0002\u001a-\u0010\u0010\u001a\u00020\u0011\"\u0004\b\u0000\u0010\u0012*\b\u0012\u0004\u0012\u0002H\u00120\u00132\u0006\u0010\u0014\u001a\u0002H\u00122\u0006\u0010\u0015\u001a\u00020\u0001H\u0000¢\u0006\u0002\u0010\u0016\u001a-\u0010\u0017\u001a\u00020\u0011\"\u0004\b\u0000\u0010\u0012*\b\u0012\u0004\u0012\u0002H\u00120\u00132\u0006\u0010\u0014\u001a\u0002H\u00122\u0006\u0010\u0015\u001a\u00020\u0001H\u0000¢\u0006\u0002\u0010\u0016\u001a(\u0010\u0018\u001a\u00020\u0011\"\u0004\b\u0000\u0010\u0012*\b\u0012\u0004\u0012\u0002H\u00120\u00132\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0015\u001a\u00020\u0001H\u0000\u001a(\u0010\u001b\u001a\u00020\u0011\"\u0004\b\u0000\u0010\u0012*\b\u0012\u0004\u0012\u0002H\u00120\u00132\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0015\u001a\u00020\u0001H\u0000\"\u0016\u0010\u0000\u001a\u00020\u00018\u0000X\u0081T¢\u0006\b\n\u0000\u0012\u0004\b\u0002\u0010\u0003\"\u0016\u0010\u0004\u001a\u00020\u00018\u0000X\u0081T¢\u0006\b\n\u0000\u0012\u0004\b\u0005\u0010\u0003\"\u0016\u0010\u0006\u001a\u00020\u00018\u0000X\u0081T¢\u0006\b\n\u0000\u0012\u0004\b\u0007\u0010\u0003\"\u0016\u0010\b\u001a\u00020\u00018\u0000X\u0081T¢\u0006\b\n\u0000\u0012\u0004\b\t\u0010\u0003\"\u0016\u0010\n\u001a\u00020\u00018\u0000X\u0081T¢\u0006\b\n\u0000\u0012\u0004\b\u000b\u0010\u0003\"\u0018\u0010\f\u001a\u00020\r*\u00020\u00018@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\u000e\"\u0018\u0010\u000f\u001a\u00020\r*\u00020\u00018@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u000e¨\u0006\u001c"}, d2 = {"MODE_ATOMIC_DEFAULT", "", "MODE_ATOMIC_DEFAULT$annotations", "()V", "MODE_CANCELLABLE", "MODE_CANCELLABLE$annotations", "MODE_DIRECT", "MODE_DIRECT$annotations", "MODE_IGNORE", "MODE_IGNORE$annotations", "MODE_UNDISPATCHED", "MODE_UNDISPATCHED$annotations", "isCancellableMode", "", "(I)Z", "isDispatchedMode", "resumeMode", "", "T", "Lkotlin/coroutines/Continuation;", "value", RtspHeaders.Values.MODE, "(Lkotlin/coroutines/Continuation;Ljava/lang/Object;I)V", "resumeUninterceptedMode", "resumeUninterceptedWithExceptionMode", "exception", "", "resumeWithExceptionMode", "kotlinx-coroutines-core"}, k = 2, mv = {1, 1, 13})
/* loaded from: classes4.dex */
public final class ResumeModeKt {
    public static final int MODE_ATOMIC_DEFAULT = 0;
    public static final int MODE_CANCELLABLE = 1;
    public static final int MODE_DIRECT = 2;
    public static final int MODE_IGNORE = 4;
    public static final int MODE_UNDISPATCHED = 3;

    public static /* synthetic */ void MODE_ATOMIC_DEFAULT$annotations() {
    }

    public static /* synthetic */ void MODE_CANCELLABLE$annotations() {
    }

    public static /* synthetic */ void MODE_DIRECT$annotations() {
    }

    public static /* synthetic */ void MODE_IGNORE$annotations() {
    }

    public static /* synthetic */ void MODE_UNDISPATCHED$annotations() {
    }

    public static final boolean isCancellableMode(int i) {
        return i == 1;
    }

    public static final boolean isDispatchedMode(int i) {
        return i == 0 || i == 1;
    }

    public static final <T> void resumeMode(Continuation<? super T> receiver$0, T t, int i) {
        Intrinsics.checkParameterIsNotNull(receiver$0, "receiver$0");
        if (i == 0) {
            Result.Companion companion = Result.INSTANCE;
            receiver$0.resumeWith(Result.m51constructorimpl(t));
            return;
        }
        if (i == 1) {
            DispatchedKt.resumeCancellable(receiver$0, t);
            return;
        }
        if (i == 2) {
            DispatchedKt.resumeDirect(receiver$0, t);
            return;
        }
        if (i != 3) {
            if (i != 4) {
                throw new IllegalStateException(("Invalid mode " + i).toString());
            }
            return;
        }
        DispatchedContinuation dispatchedContinuation = (DispatchedContinuation) receiver$0;
        CoroutineContext coroutineContext = dispatchedContinuation.get$context();
        Object updateThreadContext = ThreadContextKt.updateThreadContext(coroutineContext, dispatchedContinuation.countOrElement);
        try {
            Continuation<T> continuation = dispatchedContinuation.continuation;
            Result.Companion companion2 = Result.INSTANCE;
            continuation.resumeWith(Result.m51constructorimpl(t));
            Unit unit = Unit.INSTANCE;
        } finally {
            ThreadContextKt.restoreThreadContext(coroutineContext, updateThreadContext);
        }
    }

    public static final <T> void resumeWithExceptionMode(Continuation<? super T> receiver$0, Throwable exception, int i) {
        Intrinsics.checkParameterIsNotNull(receiver$0, "receiver$0");
        Intrinsics.checkParameterIsNotNull(exception, "exception");
        if (i == 0) {
            Result.Companion companion = Result.INSTANCE;
            receiver$0.resumeWith(Result.m51constructorimpl(ResultKt.createFailure(exception)));
            return;
        }
        if (i == 1) {
            DispatchedKt.resumeCancellableWithException(receiver$0, exception);
            return;
        }
        if (i == 2) {
            DispatchedKt.resumeDirectWithException(receiver$0, exception);
            return;
        }
        if (i != 3) {
            if (i != 4) {
                throw new IllegalStateException(("Invalid mode " + i).toString());
            }
            return;
        }
        DispatchedContinuation dispatchedContinuation = (DispatchedContinuation) receiver$0;
        CoroutineContext coroutineContext = dispatchedContinuation.get$context();
        Object updateThreadContext = ThreadContextKt.updateThreadContext(coroutineContext, dispatchedContinuation.countOrElement);
        try {
            Continuation<T> continuation = dispatchedContinuation.continuation;
            Result.Companion companion2 = Result.INSTANCE;
            continuation.resumeWith(Result.m51constructorimpl(ResultKt.createFailure(StackTraceRecoveryKt.recoverStackTrace(exception, continuation))));
            Unit unit = Unit.INSTANCE;
        } finally {
            ThreadContextKt.restoreThreadContext(coroutineContext, updateThreadContext);
        }
    }

    public static final <T> void resumeUninterceptedMode(Continuation<? super T> receiver$0, T t, int i) {
        Intrinsics.checkParameterIsNotNull(receiver$0, "receiver$0");
        if (i == 0) {
            Continuation intercepted = IntrinsicsKt.intercepted(receiver$0);
            Result.Companion companion = Result.INSTANCE;
            intercepted.resumeWith(Result.m51constructorimpl(t));
            return;
        }
        if (i == 1) {
            DispatchedKt.resumeCancellable(IntrinsicsKt.intercepted(receiver$0), t);
            return;
        }
        if (i == 2) {
            Result.Companion companion2 = Result.INSTANCE;
            receiver$0.resumeWith(Result.m51constructorimpl(t));
            return;
        }
        if (i != 3) {
            if (i != 4) {
                throw new IllegalStateException(("Invalid mode " + i).toString());
            }
            return;
        }
        CoroutineContext coroutineContext = receiver$0.get$context();
        Object updateThreadContext = ThreadContextKt.updateThreadContext(coroutineContext, null);
        try {
            Result.Companion companion3 = Result.INSTANCE;
            receiver$0.resumeWith(Result.m51constructorimpl(t));
            Unit unit = Unit.INSTANCE;
        } finally {
            ThreadContextKt.restoreThreadContext(coroutineContext, updateThreadContext);
        }
    }

    public static final <T> void resumeUninterceptedWithExceptionMode(Continuation<? super T> receiver$0, Throwable exception, int i) {
        Intrinsics.checkParameterIsNotNull(receiver$0, "receiver$0");
        Intrinsics.checkParameterIsNotNull(exception, "exception");
        if (i == 0) {
            Continuation intercepted = IntrinsicsKt.intercepted(receiver$0);
            Result.Companion companion = Result.INSTANCE;
            intercepted.resumeWith(Result.m51constructorimpl(ResultKt.createFailure(exception)));
            return;
        }
        if (i == 1) {
            DispatchedKt.resumeCancellableWithException(IntrinsicsKt.intercepted(receiver$0), exception);
            return;
        }
        if (i == 2) {
            Result.Companion companion2 = Result.INSTANCE;
            receiver$0.resumeWith(Result.m51constructorimpl(ResultKt.createFailure(exception)));
            return;
        }
        if (i != 3) {
            if (i != 4) {
                throw new IllegalStateException(("Invalid mode " + i).toString());
            }
            return;
        }
        CoroutineContext coroutineContext = receiver$0.get$context();
        Object updateThreadContext = ThreadContextKt.updateThreadContext(coroutineContext, null);
        try {
            Result.Companion companion3 = Result.INSTANCE;
            receiver$0.resumeWith(Result.m51constructorimpl(ResultKt.createFailure(exception)));
            Unit unit = Unit.INSTANCE;
        } finally {
            ThreadContextKt.restoreThreadContext(coroutineContext, updateThreadContext);
        }
    }
}
