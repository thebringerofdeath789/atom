package io.netty.util.concurrent;

import io.netty.util.internal.DefaultPriorityQueue;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PriorityQueue;
import java.util.Comparator;
import java.util.Queue;
import java.util.concurrent.Callable;
import java.util.concurrent.Delayed;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/* loaded from: classes4.dex */
public abstract class AbstractScheduledEventExecutor extends AbstractEventExecutor {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final Comparator<ScheduledFutureTask<?>> SCHEDULED_FUTURE_TASK_COMPARATOR = new Comparator<ScheduledFutureTask<?>>() { // from class: io.netty.util.concurrent.AbstractScheduledEventExecutor.1
        @Override // java.util.Comparator
        public int compare(ScheduledFutureTask<?> scheduledFutureTask, ScheduledFutureTask<?> scheduledFutureTask2) {
            return scheduledFutureTask.compareTo((Delayed) scheduledFutureTask2);
        }
    };
    PriorityQueue<ScheduledFutureTask<?>> scheduledTaskQueue;

    protected AbstractScheduledEventExecutor() {
    }

    protected AbstractScheduledEventExecutor(EventExecutorGroup eventExecutorGroup) {
        super(eventExecutorGroup);
    }

    protected static long nanoTime() {
        return ScheduledFutureTask.nanoTime();
    }

    PriorityQueue<ScheduledFutureTask<?>> scheduledTaskQueue() {
        if (this.scheduledTaskQueue == null) {
            this.scheduledTaskQueue = new DefaultPriorityQueue(SCHEDULED_FUTURE_TASK_COMPARATOR, 11);
        }
        return this.scheduledTaskQueue;
    }

    private static boolean isNullOrEmpty(Queue<ScheduledFutureTask<?>> queue) {
        return queue == null || queue.isEmpty();
    }

    protected void cancelScheduledTasks() {
        PriorityQueue<ScheduledFutureTask<?>> priorityQueue = this.scheduledTaskQueue;
        if (isNullOrEmpty(priorityQueue)) {
            return;
        }
        for (ScheduledFutureTask scheduledFutureTask : (ScheduledFutureTask[]) priorityQueue.toArray(new ScheduledFutureTask[priorityQueue.size()])) {
            scheduledFutureTask.cancelWithoutRemove(false);
        }
        priorityQueue.clearIgnoringIndexes();
    }

    protected final Runnable pollScheduledTask() {
        return pollScheduledTask(nanoTime());
    }

    protected final Runnable pollScheduledTask(long j) {
        PriorityQueue<ScheduledFutureTask<?>> priorityQueue = this.scheduledTaskQueue;
        ScheduledFutureTask<?> peek = priorityQueue == null ? null : priorityQueue.peek();
        if (peek == null || peek.deadlineNanos() > j) {
            return null;
        }
        priorityQueue.remove();
        return peek;
    }

    protected final long nextScheduledTaskNano() {
        PriorityQueue<ScheduledFutureTask<?>> priorityQueue = this.scheduledTaskQueue;
        ScheduledFutureTask<?> peek = priorityQueue == null ? null : priorityQueue.peek();
        if (peek == null) {
            return -1L;
        }
        return Math.max(0L, peek.deadlineNanos() - nanoTime());
    }

    final ScheduledFutureTask<?> peekScheduledTask() {
        PriorityQueue<ScheduledFutureTask<?>> priorityQueue = this.scheduledTaskQueue;
        if (priorityQueue == null) {
            return null;
        }
        return priorityQueue.peek();
    }

    protected final boolean hasScheduledTasks() {
        PriorityQueue<ScheduledFutureTask<?>> priorityQueue = this.scheduledTaskQueue;
        ScheduledFutureTask<?> peek = priorityQueue == null ? null : priorityQueue.peek();
        return peek != null && peek.deadlineNanos() <= nanoTime();
    }

    @Override // io.netty.util.concurrent.AbstractEventExecutor, java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture<?> schedule(Runnable runnable, long j, TimeUnit timeUnit) {
        ObjectUtil.checkNotNull(runnable, "command");
        ObjectUtil.checkNotNull(timeUnit, "unit");
        if (j < 0) {
            j = 0;
        }
        return schedule(new ScheduledFutureTask(this, runnable, (Object) null, ScheduledFutureTask.deadlineNanos(timeUnit.toNanos(j))));
    }

    @Override // io.netty.util.concurrent.AbstractEventExecutor, java.util.concurrent.ScheduledExecutorService
    public <V> ScheduledFuture<V> schedule(Callable<V> callable, long j, TimeUnit timeUnit) {
        ObjectUtil.checkNotNull(callable, "callable");
        ObjectUtil.checkNotNull(timeUnit, "unit");
        if (j < 0) {
            j = 0;
        }
        return schedule(new ScheduledFutureTask<>(this, callable, ScheduledFutureTask.deadlineNanos(timeUnit.toNanos(j))));
    }

    @Override // io.netty.util.concurrent.AbstractEventExecutor, java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture<?> scheduleAtFixedRate(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        ObjectUtil.checkNotNull(runnable, "command");
        ObjectUtil.checkNotNull(timeUnit, "unit");
        if (j < 0) {
            throw new IllegalArgumentException(String.format("initialDelay: %d (expected: >= 0)", Long.valueOf(j)));
        }
        if (j2 <= 0) {
            throw new IllegalArgumentException(String.format("period: %d (expected: > 0)", Long.valueOf(j2)));
        }
        return schedule(new ScheduledFutureTask(this, Executors.callable(runnable, null), ScheduledFutureTask.deadlineNanos(timeUnit.toNanos(j)), timeUnit.toNanos(j2)));
    }

    @Override // io.netty.util.concurrent.AbstractEventExecutor, java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture<?> scheduleWithFixedDelay(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        ObjectUtil.checkNotNull(runnable, "command");
        ObjectUtil.checkNotNull(timeUnit, "unit");
        if (j < 0) {
            throw new IllegalArgumentException(String.format("initialDelay: %d (expected: >= 0)", Long.valueOf(j)));
        }
        if (j2 <= 0) {
            throw new IllegalArgumentException(String.format("delay: %d (expected: > 0)", Long.valueOf(j2)));
        }
        return schedule(new ScheduledFutureTask(this, Executors.callable(runnable, null), ScheduledFutureTask.deadlineNanos(timeUnit.toNanos(j)), -timeUnit.toNanos(j2)));
    }

    <V> ScheduledFuture<V> schedule(final ScheduledFutureTask<V> scheduledFutureTask) {
        if (inEventLoop()) {
            scheduledTaskQueue().add(scheduledFutureTask);
        } else {
            execute(new Runnable() { // from class: io.netty.util.concurrent.AbstractScheduledEventExecutor.2
                @Override // java.lang.Runnable
                public void run() {
                    AbstractScheduledEventExecutor.this.scheduledTaskQueue().add(scheduledFutureTask);
                }
            });
        }
        return scheduledFutureTask;
    }

    final void removeScheduled(final ScheduledFutureTask<?> scheduledFutureTask) {
        if (inEventLoop()) {
            scheduledTaskQueue().removeTyped(scheduledFutureTask);
        } else {
            execute(new Runnable() { // from class: io.netty.util.concurrent.AbstractScheduledEventExecutor.3
                @Override // java.lang.Runnable
                public void run() {
                    AbstractScheduledEventExecutor.this.removeScheduled(scheduledFutureTask);
                }
            });
        }
    }
}
