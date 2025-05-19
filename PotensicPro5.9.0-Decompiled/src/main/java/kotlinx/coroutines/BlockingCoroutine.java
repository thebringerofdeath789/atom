package kotlinx.coroutines;

import io.netty.handler.codec.rtsp.RtspHeaders;
import java.util.concurrent.locks.LockSupport;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Builders.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u000b\u0010\n\u001a\u00028\u0000¢\u0006\u0002\u0010\u000bJ'\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0010¢\u0006\u0002\b\u0014R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lkotlinx/coroutines/BlockingCoroutine;", "T", "Lkotlinx/coroutines/AbstractCoroutine;", "parentContext", "Lkotlin/coroutines/CoroutineContext;", "blockedThread", "Ljava/lang/Thread;", "eventLoop", "Lkotlinx/coroutines/EventLoop;", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Thread;Lkotlinx/coroutines/EventLoop;)V", "joinBlocking", "()Ljava/lang/Object;", "onCompletionInternal", "", "state", "", RtspHeaders.Values.MODE, "", "suppressed", "", "onCompletionInternal$kotlinx_coroutines_core", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 13})
/* loaded from: classes4.dex */
final class BlockingCoroutine<T> extends AbstractCoroutine<T> {
    private final Thread blockedThread;
    private final EventLoop eventLoop;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BlockingCoroutine(CoroutineContext parentContext, Thread blockedThread, EventLoop eventLoop) {
        super(parentContext, true);
        Intrinsics.checkParameterIsNotNull(parentContext, "parentContext");
        Intrinsics.checkParameterIsNotNull(blockedThread, "blockedThread");
        this.blockedThread = blockedThread;
        this.eventLoop = eventLoop;
    }

    @Override // kotlinx.coroutines.AbstractCoroutine, kotlinx.coroutines.JobSupport
    public void onCompletionInternal$kotlinx_coroutines_core(Object state, int mode, boolean suppressed) {
        if (!Intrinsics.areEqual(Thread.currentThread(), this.blockedThread)) {
            LockSupport.unpark(this.blockedThread);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final T joinBlocking() {
        TimeSourceKt.getTimeSource().registerTimeLoopThread();
        try {
            EventLoop eventLoop = this.eventLoop;
            if (eventLoop != null) {
                EventLoop.incrementUseCount$default(eventLoop, false, 1, null);
            }
            while (!Thread.interrupted()) {
                try {
                    EventLoop eventLoop2 = this.eventLoop;
                    long processNextEvent = eventLoop2 != null ? eventLoop2.processNextEvent() : Long.MAX_VALUE;
                    if (!isCompleted()) {
                        TimeSourceKt.getTimeSource().parkNanos(this, processNextEvent);
                    } else {
                        TimeSourceKt.getTimeSource().unregisterTimeLoopThread();
                        T t = (T) JobSupportKt.unboxState(getState$kotlinx_coroutines_core());
                        CompletedExceptionally completedExceptionally = t instanceof CompletedExceptionally ? t : null;
                        if (completedExceptionally == null) {
                            return t;
                        }
                        throw completedExceptionally.cause;
                    }
                } finally {
                    EventLoop eventLoop3 = this.eventLoop;
                    if (eventLoop3 != null) {
                        EventLoop.decrementUseCount$default(eventLoop3, false, 1, null);
                    }
                }
            }
            InterruptedException interruptedException = new InterruptedException();
            cancel(interruptedException);
            throw interruptedException;
        } catch (Throwable th) {
            TimeSourceKt.getTimeSource().unregisterTimeLoopThread();
            throw th;
        }
    }
}
