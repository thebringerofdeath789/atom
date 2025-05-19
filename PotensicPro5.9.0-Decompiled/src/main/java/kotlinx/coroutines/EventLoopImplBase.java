package kotlinx.coroutines;

import io.netty.handler.codec.rtsp.RtspHeaders;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.Delay;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.internal.ThreadSafeHeap;
import kotlinx.coroutines.internal.ThreadSafeHeapNode;
import org.apache.commons.beanutils.PropertyUtils;

/* compiled from: EventLoop.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b \u0018\u00002\u00020\u00012\u00020\u0002:\u0003123B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0016\u001a\u00020\u0017H\u0002J\u0010\u0010\u0018\u001a\n\u0018\u00010\u0019j\u0004\u0018\u0001`\u001aH\u0002J\u001a\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u001d2\n\u0010\u001e\u001a\u00060\u0019j\u0002`\u001aJ\u0012\u0010\u001f\u001a\u00020\u00172\n\u0010 \u001a\u00060\u0019j\u0002`\u001aJ\u0014\u0010!\u001a\u00020\u000b2\n\u0010 \u001a\u00060\u0019j\u0002`\u001aH\u0002J\b\u0010\"\u001a\u00020\u000fH\u0016J\b\u0010#\u001a\u00020\u0017H\u0002J\b\u0010$\u001a\u00020\u0017H\u0004J\u0015\u0010%\u001a\u00020\u00172\u0006\u0010&\u001a\u00020\u0007H\u0000¢\u0006\u0002\b'J\u0010\u0010(\u001a\u00020)2\u0006\u0010&\u001a\u00020\u0007H\u0002J\u001e\u0010*\u001a\u00020\u00172\u0006\u0010+\u001a\u00020\u000f2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00170-H\u0016J\u0010\u0010.\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u0007H\u0002J\b\u0010/\u001a\u00020\u0017H\u0014J\b\u00100\u001a\u00020\u0017H\u0002R\u001c\u0010\u0004\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00020\u000b8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000f8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0012\u0010\u0012\u001a\u00020\u0013X¤\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u00064"}, d2 = {"Lkotlinx/coroutines/EventLoopImplBase;", "Lkotlinx/coroutines/EventLoop;", "Lkotlinx/coroutines/Delay;", "()V", "_delayed", "Lkotlinx/atomicfu/AtomicRef;", "Lkotlinx/coroutines/internal/ThreadSafeHeap;", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "_queue", "", "isCompleted", "", "isEmpty", "()Z", "nextTime", "", "getNextTime", "()J", "thread", "Ljava/lang/Thread;", "getThread", "()Ljava/lang/Thread;", "closeQueue", "", "dequeue", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "dispatch", "context", "Lkotlin/coroutines/CoroutineContext;", "block", "enqueue", "task", "enqueueImpl", "processNextEvent", "rescheduleAllDelayed", "resetAll", "schedule", "delayedTask", "schedule$kotlinx_coroutines_core", "scheduleImpl", "", "scheduleResumeAfterDelay", "timeMillis", "continuation", "Lkotlinx/coroutines/CancellableContinuation;", "shouldUnpark", "shutdown", "unpark", "DelayedResumeTask", "DelayedRunnableTask", "DelayedTask", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 13})
/* loaded from: classes4.dex */
public abstract class EventLoopImplBase extends EventLoop implements Delay {
    private volatile boolean isCompleted;
    private static final AtomicReferenceFieldUpdater _queue$FU = AtomicReferenceFieldUpdater.newUpdater(EventLoopImplBase.class, Object.class, "_queue");
    private static final AtomicReferenceFieldUpdater _delayed$FU = AtomicReferenceFieldUpdater.newUpdater(EventLoopImplBase.class, Object.class, "_delayed");
    private volatile Object _queue = null;
    private volatile Object _delayed = null;

    protected abstract Thread getThread();

    @Override // kotlinx.coroutines.Delay
    public Object delay(long j, Continuation<? super Unit> continuation) {
        return Delay.DefaultImpls.delay(this, j, continuation);
    }

    public DisposableHandle invokeOnTimeout(long j, Runnable block) {
        Intrinsics.checkParameterIsNotNull(block, "block");
        return Delay.DefaultImpls.invokeOnTimeout(this, j, block);
    }

    @Override // kotlinx.coroutines.EventLoop
    protected boolean isEmpty() {
        Symbol symbol;
        if (!isUnconfinedQueueEmpty()) {
            return false;
        }
        ThreadSafeHeap threadSafeHeap = (ThreadSafeHeap) this._delayed;
        if (threadSafeHeap != null && !threadSafeHeap.isEmpty()) {
            return false;
        }
        Object obj = this._queue;
        if (obj != null) {
            if (obj instanceof LockFreeTaskQueueCore) {
                return ((LockFreeTaskQueueCore) obj).isEmpty();
            }
            symbol = EventLoopKt.CLOSED_EMPTY;
            if (obj != symbol) {
                return false;
            }
        }
        return true;
    }

    @Override // kotlinx.coroutines.EventLoop
    protected long getNextTime() {
        DelayedTask delayedTask;
        Symbol symbol;
        if (super.getNextTime() == 0) {
            return 0L;
        }
        Object obj = this._queue;
        if (obj != null) {
            if (!(obj instanceof LockFreeTaskQueueCore)) {
                symbol = EventLoopKt.CLOSED_EMPTY;
                return obj == symbol ? Long.MAX_VALUE : 0L;
            }
            if (!((LockFreeTaskQueueCore) obj).isEmpty()) {
                return 0L;
            }
        }
        ThreadSafeHeap threadSafeHeap = (ThreadSafeHeap) this._delayed;
        if (threadSafeHeap == null || (delayedTask = (DelayedTask) threadSafeHeap.peek()) == null) {
            return Long.MAX_VALUE;
        }
        return RangesKt.coerceAtLeast(delayedTask.nanoTime - TimeSourceKt.getTimeSource().nanoTime(), 0L);
    }

    private final void unpark() {
        Thread thread = getThread();
        if (Thread.currentThread() != thread) {
            TimeSourceKt.getTimeSource().unpark(thread);
        }
    }

    @Override // kotlinx.coroutines.EventLoop
    protected void shutdown() {
        ThreadLocalEventLoop.INSTANCE.resetEventLoop$kotlinx_coroutines_core();
        this.isCompleted = true;
        closeQueue();
        while (processNextEvent() <= 0) {
        }
        rescheduleAllDelayed();
    }

    @Override // kotlinx.coroutines.Delay
    /* renamed from: scheduleResumeAfterDelay */
    public void mo1372scheduleResumeAfterDelay(long timeMillis, CancellableContinuation<? super Unit> continuation) {
        Intrinsics.checkParameterIsNotNull(continuation, "continuation");
        schedule$kotlinx_coroutines_core(new DelayedResumeTask(this, timeMillis, continuation));
    }

    @Override // kotlinx.coroutines.EventLoop
    public long processNextEvent() {
        Object obj;
        if (processUnconfinedEvent()) {
            return getNextTime();
        }
        ThreadSafeHeap threadSafeHeap = (ThreadSafeHeap) this._delayed;
        if (threadSafeHeap != null && !threadSafeHeap.isEmpty()) {
            long nanoTime = TimeSourceKt.getTimeSource().nanoTime();
            do {
                synchronized (threadSafeHeap) {
                    ThreadSafeHeapNode firstImpl = threadSafeHeap.firstImpl();
                    if (firstImpl != null) {
                        DelayedTask delayedTask = (DelayedTask) firstImpl;
                        obj = delayedTask.timeToExecute(nanoTime) ? enqueueImpl(delayedTask) : false ? threadSafeHeap.removeAtImpl(0) : null;
                    }
                }
            } while (((DelayedTask) obj) != null);
        }
        Runnable dequeue = dequeue();
        if (dequeue != null) {
            dequeue.run();
        }
        return getNextTime();
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    /* renamed from: dispatch */
    public final void mo1371dispatch(CoroutineContext context, Runnable block) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(block, "block");
        enqueue(block);
    }

    public final void enqueue(Runnable task) {
        Intrinsics.checkParameterIsNotNull(task, "task");
        if (enqueueImpl(task)) {
            unpark();
        } else {
            DefaultExecutor.INSTANCE.enqueue(task);
        }
    }

    public final void schedule$kotlinx_coroutines_core(DelayedTask delayedTask) {
        Intrinsics.checkParameterIsNotNull(delayedTask, "delayedTask");
        int scheduleImpl = scheduleImpl(delayedTask);
        if (scheduleImpl == 0) {
            if (shouldUnpark(delayedTask)) {
                unpark();
            }
        } else if (scheduleImpl == 1) {
            DefaultExecutor.INSTANCE.schedule$kotlinx_coroutines_core(delayedTask);
        } else if (scheduleImpl != 2) {
            throw new IllegalStateException("unexpected result".toString());
        }
    }

    private final boolean shouldUnpark(DelayedTask task) {
        ThreadSafeHeap threadSafeHeap = (ThreadSafeHeap) this._delayed;
        return (threadSafeHeap != null ? (DelayedTask) threadSafeHeap.peek() : null) == task;
    }

    private final int scheduleImpl(DelayedTask delayedTask) {
        if (this.isCompleted) {
            return 1;
        }
        ThreadSafeHeap<DelayedTask> threadSafeHeap = (ThreadSafeHeap) this._delayed;
        if (threadSafeHeap == null) {
            EventLoopImplBase eventLoopImplBase = this;
            _delayed$FU.compareAndSet(eventLoopImplBase, null, new ThreadSafeHeap());
            Object obj = eventLoopImplBase._delayed;
            if (obj == null) {
                Intrinsics.throwNpe();
            }
            threadSafeHeap = (ThreadSafeHeap) obj;
        }
        return delayedTask.schedule(threadSafeHeap, this);
    }

    protected final void resetAll() {
        this._queue = null;
        this._delayed = null;
    }

    private final void rescheduleAllDelayed() {
        DelayedTask delayedTask;
        while (true) {
            ThreadSafeHeap threadSafeHeap = (ThreadSafeHeap) this._delayed;
            if (threadSafeHeap == null || (delayedTask = (DelayedTask) threadSafeHeap.removeFirstOrNull()) == null) {
                return;
            } else {
                delayedTask.rescheduleOnShutdown();
            }
        }
    }

    /* compiled from: EventLoop.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b \u0018\u00002\u00060\u0001j\u0002`\u00022\b\u0012\u0004\u0012\u00020\u00000\u00032\u00020\u00042\u00020\u0005B\r\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0011\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u0000H\u0096\u0002J\u0006\u0010\u001b\u001a\u00020\u001cJ\u0006\u0010\u001d\u001a\u00020\u001cJ\u001c\u0010\u001e\u001a\u00020\u00132\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00000\f2\u0006\u0010 \u001a\u00020!J\u000e\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0007J\b\u0010%\u001a\u00020&H\u0016R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R0\u0010\r\u001a\b\u0012\u0002\b\u0003\u0018\u00010\f2\f\u0010\u000b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\f8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0010\u0010\u0018\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "", "Lkotlinx/coroutines/DisposableHandle;", "Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "timeMillis", "", "(J)V", "_heap", "", "value", "Lkotlinx/coroutines/internal/ThreadSafeHeap;", "heap", "getHeap", "()Lkotlinx/coroutines/internal/ThreadSafeHeap;", "setHeap", "(Lkotlinx/coroutines/internal/ThreadSafeHeap;)V", "index", "", "getIndex", "()I", "setIndex", "(I)V", "nanoTime", "compareTo", "other", "dispose", "", "rescheduleOnShutdown", "schedule", "delayed", "eventLoop", "Lkotlinx/coroutines/EventLoopImplBase;", "timeToExecute", "", "now", "toString", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 13})
    public static abstract class DelayedTask implements Runnable, Comparable<DelayedTask>, DisposableHandle, ThreadSafeHeapNode {
        private Object _heap;
        private int index = -1;
        public final long nanoTime;

        public DelayedTask(long j) {
            this.nanoTime = TimeSourceKt.getTimeSource().nanoTime() + EventLoopKt.delayToNanos(j);
        }

        @Override // kotlinx.coroutines.internal.ThreadSafeHeapNode
        public ThreadSafeHeap<?> getHeap() {
            Object obj = this._heap;
            if (!(obj instanceof ThreadSafeHeap)) {
                obj = null;
            }
            return (ThreadSafeHeap) obj;
        }

        @Override // kotlinx.coroutines.internal.ThreadSafeHeapNode
        public void setHeap(ThreadSafeHeap<?> threadSafeHeap) {
            Symbol symbol;
            Object obj = this._heap;
            symbol = EventLoopKt.DISPOSED_TASK;
            if (!(obj != symbol)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            this._heap = threadSafeHeap;
        }

        @Override // kotlinx.coroutines.internal.ThreadSafeHeapNode
        public int getIndex() {
            return this.index;
        }

        @Override // kotlinx.coroutines.internal.ThreadSafeHeapNode
        public void setIndex(int i) {
            this.index = i;
        }

        @Override // java.lang.Comparable
        public int compareTo(DelayedTask other) {
            Intrinsics.checkParameterIsNotNull(other, "other");
            long j = this.nanoTime - other.nanoTime;
            if (j > 0) {
                return 1;
            }
            return j < 0 ? -1 : 0;
        }

        public final boolean timeToExecute(long now) {
            return now - this.nanoTime >= 0;
        }

        public final synchronized int schedule(ThreadSafeHeap<DelayedTask> delayed, EventLoopImplBase eventLoop) {
            Symbol symbol;
            int i;
            Intrinsics.checkParameterIsNotNull(delayed, "delayed");
            Intrinsics.checkParameterIsNotNull(eventLoop, "eventLoop");
            Object obj = this._heap;
            symbol = EventLoopKt.DISPOSED_TASK;
            if (obj == symbol) {
                return 2;
            }
            DelayedTask delayedTask = this;
            synchronized (delayed) {
                if (!eventLoop.isCompleted) {
                    delayed.addImpl(delayedTask);
                    i = 1;
                } else {
                    i = 0;
                }
            }
            return i ^ 1;
        }

        public final void rescheduleOnShutdown() {
            DefaultExecutor.INSTANCE.schedule$kotlinx_coroutines_core(this);
        }

        @Override // kotlinx.coroutines.DisposableHandle
        public final synchronized void dispose() {
            Symbol symbol;
            Symbol symbol2;
            Object obj = this._heap;
            symbol = EventLoopKt.DISPOSED_TASK;
            if (obj == symbol) {
                return;
            }
            if (!(obj instanceof ThreadSafeHeap)) {
                obj = null;
            }
            ThreadSafeHeap threadSafeHeap = (ThreadSafeHeap) obj;
            if (threadSafeHeap != null) {
                threadSafeHeap.remove(this);
            }
            symbol2 = EventLoopKt.DISPOSED_TASK;
            this._heap = symbol2;
        }

        public String toString() {
            return "Delayed[nanos=" + this.nanoTime + PropertyUtils.INDEXED_DELIM2;
        }
    }

    /* compiled from: EventLoop.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0082\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\b\u0010\b\u001a\u00020\u0006H\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lkotlinx/coroutines/EventLoopImplBase$DelayedResumeTask;", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "timeMillis", "", "cont", "Lkotlinx/coroutines/CancellableContinuation;", "", "(Lkotlinx/coroutines/EventLoopImplBase;JLkotlinx/coroutines/CancellableContinuation;)V", "run", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 13})
    private final class DelayedResumeTask extends DelayedTask {
        private final CancellableContinuation<Unit> cont;
        final /* synthetic */ EventLoopImplBase this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public DelayedResumeTask(EventLoopImplBase eventLoopImplBase, long j, CancellableContinuation<? super Unit> cont) {
            super(j);
            Intrinsics.checkParameterIsNotNull(cont, "cont");
            this.this$0 = eventLoopImplBase;
            this.cont = cont;
            CancellableContinuationKt.disposeOnCancellation(cont, this);
        }

        @Override // java.lang.Runnable
        public void run() {
            this.cont.resumeUndispatched(this.this$0, Unit.INSTANCE);
        }
    }

    /* compiled from: EventLoop.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016R\u0012\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lkotlinx/coroutines/EventLoopImplBase$DelayedRunnableTask;", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", RtspHeaders.Values.TIME, "", "block", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "(JLjava/lang/Runnable;)V", "run", "", "toString", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 13})
    public static final class DelayedRunnableTask extends DelayedTask {
        private final Runnable block;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DelayedRunnableTask(long j, Runnable block) {
            super(j);
            Intrinsics.checkParameterIsNotNull(block, "block");
            this.block = block;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.block.run();
        }

        @Override // kotlinx.coroutines.EventLoopImplBase.DelayedTask
        public String toString() {
            return super.toString() + this.block.toString();
        }
    }

    private final boolean enqueueImpl(Runnable task) {
        Symbol symbol;
        while (true) {
            Object obj = this._queue;
            if (this.isCompleted) {
                return false;
            }
            if (obj == null) {
                if (_queue$FU.compareAndSet(this, null, task)) {
                    return true;
                }
            } else if (!(obj instanceof LockFreeTaskQueueCore)) {
                symbol = EventLoopKt.CLOSED_EMPTY;
                if (obj == symbol) {
                    return false;
                }
                LockFreeTaskQueueCore lockFreeTaskQueueCore = new LockFreeTaskQueueCore(8, true);
                if (obj != null) {
                    lockFreeTaskQueueCore.addLast((Runnable) obj);
                    lockFreeTaskQueueCore.addLast(task);
                    if (_queue$FU.compareAndSet(this, obj, lockFreeTaskQueueCore)) {
                        return true;
                    }
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.Runnable /* = java.lang.Runnable */");
                }
            } else if (obj != null) {
                LockFreeTaskQueueCore lockFreeTaskQueueCore2 = (LockFreeTaskQueueCore) obj;
                int addLast = lockFreeTaskQueueCore2.addLast(task);
                if (addLast == 0) {
                    return true;
                }
                if (addLast == 1) {
                    _queue$FU.compareAndSet(this, obj, lockFreeTaskQueueCore2.next());
                } else if (addLast == 2) {
                    return false;
                }
            } else {
                throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.Queue<kotlinx.coroutines.Runnable /* = java.lang.Runnable */> /* = kotlinx.coroutines.internal.LockFreeTaskQueueCore<kotlinx.coroutines.Runnable /* = java.lang.Runnable */> */");
            }
        }
    }

    private final Runnable dequeue() {
        Symbol symbol;
        while (true) {
            Object obj = this._queue;
            if (obj == null) {
                return null;
            }
            if (!(obj instanceof LockFreeTaskQueueCore)) {
                symbol = EventLoopKt.CLOSED_EMPTY;
                if (obj == symbol) {
                    return null;
                }
                if (_queue$FU.compareAndSet(this, obj, null)) {
                    if (obj != null) {
                        return (Runnable) obj;
                    }
                    throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.Runnable /* = java.lang.Runnable */");
                }
            } else if (obj != null) {
                LockFreeTaskQueueCore lockFreeTaskQueueCore = (LockFreeTaskQueueCore) obj;
                Object removeFirstOrNull = lockFreeTaskQueueCore.removeFirstOrNull();
                if (removeFirstOrNull != LockFreeTaskQueueCore.REMOVE_FROZEN) {
                    return (Runnable) removeFirstOrNull;
                }
                _queue$FU.compareAndSet(this, obj, lockFreeTaskQueueCore.next());
            } else {
                throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.Queue<kotlinx.coroutines.Runnable /* = java.lang.Runnable */> /* = kotlinx.coroutines.internal.LockFreeTaskQueueCore<kotlinx.coroutines.Runnable /* = java.lang.Runnable */> */");
            }
        }
    }

    private final void closeQueue() {
        Symbol symbol;
        Symbol symbol2;
        while (true) {
            Object obj = this._queue;
            if (obj == null) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _queue$FU;
                symbol = EventLoopKt.CLOSED_EMPTY;
                if (atomicReferenceFieldUpdater.compareAndSet(this, null, symbol)) {
                    return;
                }
            } else if (!(obj instanceof LockFreeTaskQueueCore)) {
                symbol2 = EventLoopKt.CLOSED_EMPTY;
                if (obj == symbol2) {
                    return;
                }
                LockFreeTaskQueueCore lockFreeTaskQueueCore = new LockFreeTaskQueueCore(8, true);
                if (obj != null) {
                    lockFreeTaskQueueCore.addLast((Runnable) obj);
                    if (_queue$FU.compareAndSet(this, obj, lockFreeTaskQueueCore)) {
                        return;
                    }
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.Runnable /* = java.lang.Runnable */");
                }
            } else {
                ((LockFreeTaskQueueCore) obj).close();
                return;
            }
        }
    }
}
