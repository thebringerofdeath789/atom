package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CoroutineExceptionHandler.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a%\u0010\u0000\u001a\u00020\u00012\u001a\b\u0004\u0010\u0002\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0003H\u0086\b\u001a$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0007\u001a\u0018\u0010\f\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0005H\u0007\u001a\u0018\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0005H\u0000¨\u0006\u0010"}, d2 = {"CoroutineExceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "handler", "Lkotlin/Function2;", "Lkotlin/coroutines/CoroutineContext;", "", "", "handleCoroutineException", "context", "exception", "caller", "Lkotlinx/coroutines/Job;", "handleExceptionViaHandler", "handlerException", "originalException", "thrownException", "kotlinx-coroutines-core"}, k = 2, mv = {1, 1, 13})
/* loaded from: classes4.dex */
public final class CoroutineExceptionHandlerKt {
    public static /* synthetic */ void handleCoroutineException$default(CoroutineContext coroutineContext, Throwable th, Job job, int i, Object obj) {
        if ((i & 4) != 0) {
            job = (Job) null;
        }
        handleCoroutineException(coroutineContext, th, job);
    }

    public static final void handleCoroutineException(CoroutineContext context, Throwable exception, Job job) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(exception, "exception");
        if (exception instanceof CancellationException) {
            return;
        }
        Job job2 = (Job) context.get(Job.INSTANCE);
        if (job2 == null || job2 == job || !job2.cancel(exception)) {
            handleExceptionViaHandler(context, exception);
        }
    }

    public static final void handleExceptionViaHandler(CoroutineContext context, Throwable exception) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(exception, "exception");
        try {
            CoroutineExceptionHandler coroutineExceptionHandler = (CoroutineExceptionHandler) context.get(CoroutineExceptionHandler.INSTANCE);
            if (coroutineExceptionHandler != null) {
                coroutineExceptionHandler.handleException(context, exception);
            } else {
                CoroutineExceptionHandlerImplKt.handleCoroutineExceptionImpl(context, exception);
            }
        } catch (Throwable th) {
            CoroutineExceptionHandlerImplKt.handleCoroutineExceptionImpl(context, handlerException(exception, th));
        }
    }

    public static final Throwable handlerException(Throwable originalException, Throwable thrownException) {
        Intrinsics.checkParameterIsNotNull(originalException, "originalException");
        Intrinsics.checkParameterIsNotNull(thrownException, "thrownException");
        if (originalException == thrownException) {
            return originalException;
        }
        RuntimeException runtimeException = new RuntimeException("Exception while trying to handle coroutine exception", thrownException);
        kotlin.ExceptionsKt.addSuppressed(runtimeException, originalException);
        return runtimeException;
    }

    public static final CoroutineExceptionHandler CoroutineExceptionHandler(Function2<? super CoroutineContext, ? super Throwable, Unit> handler) {
        Intrinsics.checkParameterIsNotNull(handler, "handler");
        return new CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1(handler, CoroutineExceptionHandler.INSTANCE);
    }
}
