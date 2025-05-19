package io.netty.util.concurrent;

import io.netty.util.internal.DefaultPriorityQueue;
import io.netty.util.internal.PriorityQueueNode;
import java.util.concurrent.Callable;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import org.apache.commons.beanutils.PropertyUtils;

/* loaded from: classes4.dex */
final class ScheduledFutureTask<V> extends PromiseTask<V> implements ScheduledFuture<V>, PriorityQueueNode {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private long deadlineNanos;
    private final long id;
    private final long periodNanos;
    private int queueIndex;
    private static final AtomicLong nextTaskId = new AtomicLong();
    private static final long START_TIME = System.nanoTime();

    static long nanoTime() {
        return System.nanoTime() - START_TIME;
    }

    static long deadlineNanos(long j) {
        return nanoTime() + j;
    }

    ScheduledFutureTask(AbstractScheduledEventExecutor abstractScheduledEventExecutor, Runnable runnable, V v, long j) {
        this(abstractScheduledEventExecutor, toCallable(runnable, v), j);
    }

    ScheduledFutureTask(AbstractScheduledEventExecutor abstractScheduledEventExecutor, Callable<V> callable, long j, long j2) {
        super(abstractScheduledEventExecutor, callable);
        this.id = nextTaskId.getAndIncrement();
        this.queueIndex = -1;
        if (j2 == 0) {
            throw new IllegalArgumentException("period: 0 (expected: != 0)");
        }
        this.deadlineNanos = j;
        this.periodNanos = j2;
    }

    ScheduledFutureTask(AbstractScheduledEventExecutor abstractScheduledEventExecutor, Callable<V> callable, long j) {
        super(abstractScheduledEventExecutor, callable);
        this.id = nextTaskId.getAndIncrement();
        this.queueIndex = -1;
        this.deadlineNanos = j;
        this.periodNanos = 0L;
    }

    @Override // io.netty.util.concurrent.DefaultPromise
    protected EventExecutor executor() {
        return super.executor();
    }

    public long deadlineNanos() {
        return this.deadlineNanos;
    }

    public long delayNanos() {
        return Math.max(0L, deadlineNanos() - nanoTime());
    }

    public long delayNanos(long j) {
        return Math.max(0L, deadlineNanos() - (j - START_TIME));
    }

    @Override // java.util.concurrent.Delayed
    public long getDelay(TimeUnit timeUnit) {
        return timeUnit.convert(delayNanos(), TimeUnit.NANOSECONDS);
    }

    @Override // java.lang.Comparable
    public int compareTo(Delayed delayed) {
        if (this == delayed) {
            return 0;
        }
        ScheduledFutureTask scheduledFutureTask = (ScheduledFutureTask) delayed;
        long deadlineNanos = deadlineNanos() - scheduledFutureTask.deadlineNanos();
        if (deadlineNanos < 0) {
            return -1;
        }
        if (deadlineNanos > 0) {
            return 1;
        }
        long j = this.id;
        long j2 = scheduledFutureTask.id;
        if (j < j2) {
            return -1;
        }
        if (j != j2) {
            return 1;
        }
        throw new Error();
    }

    @Override // io.netty.util.concurrent.PromiseTask, java.util.concurrent.RunnableFuture, java.lang.Runnable
    public void run() {
        try {
            if (this.periodNanos == 0) {
                if (setUncancellableInternal()) {
                    setSuccessInternal(this.task.call());
                }
            } else {
                if (isCancelled()) {
                    return;
                }
                this.task.call();
                if (executor().isShutdown()) {
                    return;
                }
                long j = this.periodNanos;
                if (j > 0) {
                    this.deadlineNanos += j;
                } else {
                    this.deadlineNanos = nanoTime() - j;
                }
                if (isCancelled()) {
                    return;
                }
                ((AbstractScheduledEventExecutor) executor()).scheduledTaskQueue.add(this);
            }
        } catch (Throwable th) {
            setFailureInternal(th);
        }
    }

    @Override // io.netty.util.concurrent.DefaultPromise, io.netty.util.concurrent.Future, java.util.concurrent.Future
    public boolean cancel(boolean z) {
        boolean cancel = super.cancel(z);
        if (cancel) {
            ((AbstractScheduledEventExecutor) executor()).removeScheduled(this);
        }
        return cancel;
    }

    boolean cancelWithoutRemove(boolean z) {
        return super.cancel(z);
    }

    @Override // io.netty.util.concurrent.PromiseTask, io.netty.util.concurrent.DefaultPromise
    protected StringBuilder toStringBuilder() {
        StringBuilder stringBuilder = super.toStringBuilder();
        stringBuilder.setCharAt(stringBuilder.length() - 1, ',');
        return stringBuilder.append(" id: ").append(this.id).append(", deadline: ").append(this.deadlineNanos).append(", period: ").append(this.periodNanos).append(PropertyUtils.MAPPED_DELIM2);
    }

    @Override // io.netty.util.internal.PriorityQueueNode
    public int priorityQueueIndex(DefaultPriorityQueue<?> defaultPriorityQueue) {
        return this.queueIndex;
    }

    @Override // io.netty.util.internal.PriorityQueueNode
    public void priorityQueueIndex(DefaultPriorityQueue<?> defaultPriorityQueue, int i) {
        this.queueIndex = i;
    }
}
