package io.netty.util.concurrent;

import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.SystemPropertyUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* loaded from: classes4.dex */
public abstract class SingleThreadEventExecutor extends AbstractScheduledEventExecutor implements OrderedEventExecutor {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int ST_NOT_STARTED = 1;
    private static final int ST_SHUTDOWN = 4;
    private static final int ST_SHUTTING_DOWN = 3;
    private static final int ST_STARTED = 2;
    private static final int ST_TERMINATED = 5;
    private final boolean addTaskWakesUp;
    private final Executor executor;
    private volatile long gracefulShutdownQuietPeriod;
    private long gracefulShutdownStartTime;
    private volatile long gracefulShutdownTimeout;
    private volatile boolean interrupted;
    private long lastExecutionTime;
    private final int maxPendingTasks;
    private final RejectedExecutionHandler rejectedExecutionHandler;
    private final Set<Runnable> shutdownHooks;
    private volatile int state;
    private final Queue<Runnable> taskQueue;
    private final Promise<?> terminationFuture;
    private volatile Thread thread;
    private final Semaphore threadLock;
    private volatile ThreadProperties threadProperties;
    static final int DEFAULT_MAX_PENDING_EXECUTOR_TASKS = Math.max(16, SystemPropertyUtil.getInt("io.netty.eventexecutor.maxPendingTasks", Integer.MAX_VALUE));
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) SingleThreadEventExecutor.class);
    private static final Runnable WAKEUP_TASK = new Runnable() { // from class: io.netty.util.concurrent.SingleThreadEventExecutor.1
        @Override // java.lang.Runnable
        public void run() {
        }
    };
    private static final Runnable NOOP_TASK = new Runnable() { // from class: io.netty.util.concurrent.SingleThreadEventExecutor.2
        @Override // java.lang.Runnable
        public void run() {
        }
    };
    private static final AtomicIntegerFieldUpdater<SingleThreadEventExecutor> STATE_UPDATER = AtomicIntegerFieldUpdater.newUpdater(SingleThreadEventExecutor.class, "state");
    private static final AtomicReferenceFieldUpdater<SingleThreadEventExecutor, ThreadProperties> PROPERTIES_UPDATER = AtomicReferenceFieldUpdater.newUpdater(SingleThreadEventExecutor.class, ThreadProperties.class, "threadProperties");
    private static final long SCHEDULE_PURGE_INTERVAL = TimeUnit.SECONDS.toNanos(1);

    protected void afterRunningAllTasks() {
    }

    protected void cleanup() {
    }

    protected abstract void run();

    protected boolean wakesUpForTask(Runnable runnable) {
        return true;
    }

    protected SingleThreadEventExecutor(EventExecutorGroup eventExecutorGroup, ThreadFactory threadFactory, boolean z) {
        this(eventExecutorGroup, new ThreadPerTaskExecutor(threadFactory), z);
    }

    protected SingleThreadEventExecutor(EventExecutorGroup eventExecutorGroup, ThreadFactory threadFactory, boolean z, int i, RejectedExecutionHandler rejectedExecutionHandler) {
        this(eventExecutorGroup, new ThreadPerTaskExecutor(threadFactory), z, i, rejectedExecutionHandler);
    }

    protected SingleThreadEventExecutor(EventExecutorGroup eventExecutorGroup, Executor executor, boolean z) {
        this(eventExecutorGroup, executor, z, DEFAULT_MAX_PENDING_EXECUTOR_TASKS, RejectedExecutionHandlers.reject());
    }

    protected SingleThreadEventExecutor(EventExecutorGroup eventExecutorGroup, Executor executor, boolean z, int i, RejectedExecutionHandler rejectedExecutionHandler) {
        super(eventExecutorGroup);
        this.threadLock = new Semaphore(0);
        this.shutdownHooks = new LinkedHashSet();
        this.state = 1;
        this.terminationFuture = new DefaultPromise(GlobalEventExecutor.INSTANCE);
        this.addTaskWakesUp = z;
        int max = Math.max(16, i);
        this.maxPendingTasks = max;
        this.executor = (Executor) ObjectUtil.checkNotNull(executor, "executor");
        this.taskQueue = newTaskQueue(max);
        this.rejectedExecutionHandler = (RejectedExecutionHandler) ObjectUtil.checkNotNull(rejectedExecutionHandler, "rejectedHandler");
    }

    @Deprecated
    protected Queue<Runnable> newTaskQueue() {
        return newTaskQueue(this.maxPendingTasks);
    }

    protected Queue<Runnable> newTaskQueue(int i) {
        return new LinkedBlockingQueue(i);
    }

    protected void interruptThread() {
        Thread thread = this.thread;
        if (thread == null) {
            this.interrupted = true;
        } else {
            thread.interrupt();
        }
    }

    protected Runnable pollTask() {
        return pollTaskFrom(this.taskQueue);
    }

    protected static Runnable pollTaskFrom(Queue<Runnable> queue) {
        Runnable poll;
        do {
            poll = queue.poll();
        } while (poll == WAKEUP_TASK);
        return poll;
    }

    protected Runnable takeTask() {
        Runnable runnable;
        Queue<Runnable> queue = this.taskQueue;
        if (!(queue instanceof BlockingQueue)) {
            throw new UnsupportedOperationException();
        }
        BlockingQueue blockingQueue = (BlockingQueue) queue;
        do {
            ScheduledFutureTask<?> peekScheduledTask = peekScheduledTask();
            runnable = null;
            if (peekScheduledTask == null) {
                try {
                    Runnable runnable2 = (Runnable) blockingQueue.take();
                    try {
                        if (runnable2 == WAKEUP_TASK) {
                            return null;
                        }
                    } catch (InterruptedException unused) {
                    }
                    return runnable2;
                } catch (InterruptedException unused2) {
                    return null;
                }
            }
            long delayNanos = peekScheduledTask.delayNanos();
            if (delayNanos > 0) {
                try {
                    runnable = (Runnable) blockingQueue.poll(delayNanos, TimeUnit.NANOSECONDS);
                } catch (InterruptedException unused3) {
                    return null;
                }
            }
            if (runnable == null) {
                fetchFromScheduledTaskQueue();
                runnable = (Runnable) blockingQueue.poll();
            }
        } while (runnable == null);
        return runnable;
    }

    private boolean fetchFromScheduledTaskQueue() {
        long nanoTime = AbstractScheduledEventExecutor.nanoTime();
        Runnable pollScheduledTask = pollScheduledTask(nanoTime);
        while (pollScheduledTask != null) {
            if (!this.taskQueue.offer(pollScheduledTask)) {
                scheduledTaskQueue().add((ScheduledFutureTask) pollScheduledTask);
                return false;
            }
            pollScheduledTask = pollScheduledTask(nanoTime);
        }
        return true;
    }

    protected Runnable peekTask() {
        return this.taskQueue.peek();
    }

    protected boolean hasTasks() {
        return !this.taskQueue.isEmpty();
    }

    public int pendingTasks() {
        return this.taskQueue.size();
    }

    protected void addTask(Runnable runnable) {
        Objects.requireNonNull(runnable, "task");
        if (offerTask(runnable)) {
            return;
        }
        reject(runnable);
    }

    final boolean offerTask(Runnable runnable) {
        if (isShutdown()) {
            reject();
        }
        return this.taskQueue.offer(runnable);
    }

    protected boolean removeTask(Runnable runnable) {
        Objects.requireNonNull(runnable, "task");
        return this.taskQueue.remove(runnable);
    }

    protected boolean runAllTasks() {
        boolean fetchFromScheduledTaskQueue;
        boolean z = false;
        do {
            fetchFromScheduledTaskQueue = fetchFromScheduledTaskQueue();
            if (runAllTasksFrom(this.taskQueue)) {
                z = true;
            }
        } while (!fetchFromScheduledTaskQueue);
        if (z) {
            this.lastExecutionTime = ScheduledFutureTask.nanoTime();
        }
        afterRunningAllTasks();
        return z;
    }

    protected final boolean runAllTasksFrom(Queue<Runnable> queue) {
        Runnable pollTaskFrom = pollTaskFrom(queue);
        if (pollTaskFrom == null) {
            return false;
        }
        do {
            safeExecute(pollTaskFrom);
            pollTaskFrom = pollTaskFrom(queue);
        } while (pollTaskFrom != null);
        return true;
    }

    protected boolean runAllTasks(long j) {
        long nanoTime;
        fetchFromScheduledTaskQueue();
        Runnable pollTask = pollTask();
        if (pollTask == null) {
            afterRunningAllTasks();
            return false;
        }
        long nanoTime2 = ScheduledFutureTask.nanoTime() + j;
        long j2 = 0;
        while (true) {
            safeExecute(pollTask);
            j2++;
            if ((63 & j2) == 0) {
                nanoTime = ScheduledFutureTask.nanoTime();
                if (nanoTime >= nanoTime2) {
                    break;
                }
            }
            pollTask = pollTask();
            if (pollTask == null) {
                nanoTime = ScheduledFutureTask.nanoTime();
                break;
            }
        }
        afterRunningAllTasks();
        this.lastExecutionTime = nanoTime;
        return true;
    }

    protected long delayNanos(long j) {
        ScheduledFutureTask<?> peekScheduledTask = peekScheduledTask();
        if (peekScheduledTask == null) {
            return SCHEDULE_PURGE_INTERVAL;
        }
        return peekScheduledTask.delayNanos(j);
    }

    protected void updateLastExecutionTime() {
        this.lastExecutionTime = ScheduledFutureTask.nanoTime();
    }

    protected void wakeup(boolean z) {
        if (!z || this.state == 3) {
            this.taskQueue.offer(WAKEUP_TASK);
        }
    }

    @Override // io.netty.util.concurrent.EventExecutor
    public boolean inEventLoop(Thread thread) {
        return thread == this.thread;
    }

    public void addShutdownHook(final Runnable runnable) {
        if (inEventLoop()) {
            this.shutdownHooks.add(runnable);
        } else {
            execute(new Runnable() { // from class: io.netty.util.concurrent.SingleThreadEventExecutor.3
                @Override // java.lang.Runnable
                public void run() {
                    SingleThreadEventExecutor.this.shutdownHooks.add(runnable);
                }
            });
        }
    }

    public void removeShutdownHook(final Runnable runnable) {
        if (inEventLoop()) {
            this.shutdownHooks.remove(runnable);
        } else {
            execute(new Runnable() { // from class: io.netty.util.concurrent.SingleThreadEventExecutor.4
                @Override // java.lang.Runnable
                public void run() {
                    SingleThreadEventExecutor.this.shutdownHooks.remove(runnable);
                }
            });
        }
    }

    private boolean runShutdownHooks() {
        boolean z = false;
        while (!this.shutdownHooks.isEmpty()) {
            ArrayList arrayList = new ArrayList(this.shutdownHooks);
            this.shutdownHooks.clear();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                try {
                    ((Runnable) it.next()).run();
                } finally {
                    z = true;
                }
                z = true;
            }
        }
        if (z) {
            this.lastExecutionTime = ScheduledFutureTask.nanoTime();
        }
        return z;
    }

    @Override // io.netty.util.concurrent.EventExecutorGroup
    public Future<?> shutdownGracefully(long j, long j2, TimeUnit timeUnit) {
        boolean z;
        if (j < 0) {
            throw new IllegalArgumentException("quietPeriod: " + j + " (expected >= 0)");
        }
        if (j2 < j) {
            throw new IllegalArgumentException("timeout: " + j2 + " (expected >= quietPeriod (" + j + "))");
        }
        Objects.requireNonNull(timeUnit, "unit");
        if (isShuttingDown()) {
            return terminationFuture();
        }
        boolean inEventLoop = inEventLoop();
        while (!isShuttingDown()) {
            int i = this.state;
            int i2 = 3;
            if (inEventLoop || i == 1 || i == 2) {
                z = true;
            } else {
                z = false;
                i2 = i;
            }
            if (STATE_UPDATER.compareAndSet(this, i, i2)) {
                this.gracefulShutdownQuietPeriod = timeUnit.toNanos(j);
                this.gracefulShutdownTimeout = timeUnit.toNanos(j2);
                if (i == 1) {
                    try {
                        doStartThread();
                    } catch (Throwable th) {
                        STATE_UPDATER.set(this, 5);
                        this.terminationFuture.tryFailure(th);
                        if (!(th instanceof Exception)) {
                            PlatformDependent.throwException(th);
                        }
                        return this.terminationFuture;
                    }
                }
                if (z) {
                    wakeup(inEventLoop);
                }
                return terminationFuture();
            }
        }
        return terminationFuture();
    }

    @Override // io.netty.util.concurrent.EventExecutorGroup
    public Future<?> terminationFuture() {
        return this.terminationFuture;
    }

    @Override // io.netty.util.concurrent.AbstractEventExecutor, java.util.concurrent.ExecutorService, io.netty.util.concurrent.EventExecutorGroup
    @Deprecated
    public void shutdown() {
        boolean z;
        if (isShutdown()) {
            return;
        }
        boolean inEventLoop = inEventLoop();
        while (!isShuttingDown()) {
            int i = this.state;
            int i2 = 4;
            if (inEventLoop || i == 1 || i == 2 || i == 3) {
                z = true;
            } else {
                z = false;
                i2 = i;
            }
            if (STATE_UPDATER.compareAndSet(this, i, i2)) {
                if (i == 1) {
                    try {
                        doStartThread();
                    } catch (Throwable th) {
                        STATE_UPDATER.set(this, 5);
                        this.terminationFuture.tryFailure(th);
                        if (th instanceof Exception) {
                            return;
                        }
                        PlatformDependent.throwException(th);
                        return;
                    }
                }
                if (z) {
                    wakeup(inEventLoop);
                    return;
                }
                return;
            }
        }
    }

    @Override // io.netty.util.concurrent.EventExecutorGroup
    public boolean isShuttingDown() {
        return this.state >= 3;
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isShutdown() {
        return this.state >= 4;
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isTerminated() {
        return this.state == 5;
    }

    protected boolean confirmShutdown() {
        if (!isShuttingDown()) {
            return false;
        }
        if (!inEventLoop()) {
            throw new IllegalStateException("must be invoked from an event loop");
        }
        cancelScheduledTasks();
        if (this.gracefulShutdownStartTime == 0) {
            this.gracefulShutdownStartTime = ScheduledFutureTask.nanoTime();
        }
        if (runAllTasks() || runShutdownHooks()) {
            if (isShutdown() || this.gracefulShutdownQuietPeriod == 0) {
                return true;
            }
            wakeup(true);
            return false;
        }
        long nanoTime = ScheduledFutureTask.nanoTime();
        if (isShutdown() || nanoTime - this.gracefulShutdownStartTime > this.gracefulShutdownTimeout || nanoTime - this.lastExecutionTime > this.gracefulShutdownQuietPeriod) {
            return true;
        }
        wakeup(true);
        try {
            Thread.sleep(100L);
        } catch (InterruptedException unused) {
        }
        return false;
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean awaitTermination(long j, TimeUnit timeUnit) throws InterruptedException {
        Objects.requireNonNull(timeUnit, "unit");
        if (inEventLoop()) {
            throw new IllegalStateException("cannot await termination of the current thread");
        }
        if (this.threadLock.tryAcquire(j, timeUnit)) {
            this.threadLock.release();
        }
        return isTerminated();
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        Objects.requireNonNull(runnable, "task");
        boolean inEventLoop = inEventLoop();
        if (inEventLoop) {
            addTask(runnable);
        } else {
            startThread();
            addTask(runnable);
            if (isShutdown() && removeTask(runnable)) {
                reject();
            }
        }
        if (this.addTaskWakesUp || !wakesUpForTask(runnable)) {
            return;
        }
        wakeup(inEventLoop);
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public <T> T invokeAny(Collection<? extends Callable<T>> collection) throws InterruptedException, ExecutionException {
        throwIfInEventLoop("invokeAny");
        return (T) super.invokeAny(collection);
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public <T> T invokeAny(Collection<? extends Callable<T>> collection, long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        throwIfInEventLoop("invokeAny");
        return (T) super.invokeAny(collection, j, timeUnit);
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public <T> List<java.util.concurrent.Future<T>> invokeAll(Collection<? extends Callable<T>> collection) throws InterruptedException {
        throwIfInEventLoop("invokeAll");
        return super.invokeAll(collection);
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public <T> List<java.util.concurrent.Future<T>> invokeAll(Collection<? extends Callable<T>> collection, long j, TimeUnit timeUnit) throws InterruptedException {
        throwIfInEventLoop("invokeAll");
        return super.invokeAll(collection, j, timeUnit);
    }

    private void throwIfInEventLoop(String str) {
        if (inEventLoop()) {
            throw new RejectedExecutionException("Calling " + str + " from within the EventLoop is not allowed");
        }
    }

    public final ThreadProperties threadProperties() {
        ThreadProperties threadProperties = this.threadProperties;
        if (threadProperties != null) {
            return threadProperties;
        }
        Thread thread = this.thread;
        if (thread == null) {
            submit(NOOP_TASK).syncUninterruptibly();
            thread = this.thread;
        }
        DefaultThreadProperties defaultThreadProperties = new DefaultThreadProperties(thread);
        return !PROPERTIES_UPDATER.compareAndSet(this, null, defaultThreadProperties) ? this.threadProperties : defaultThreadProperties;
    }

    protected static void reject() {
        throw new RejectedExecutionException("event executor terminated");
    }

    protected final void reject(Runnable runnable) {
        this.rejectedExecutionHandler.rejected(runnable, this);
    }

    private void startThread() {
        if (this.state == 1 && STATE_UPDATER.compareAndSet(this, 1, 2)) {
            try {
                doStartThread();
            } catch (Throwable th) {
                STATE_UPDATER.set(this, 1);
                PlatformDependent.throwException(th);
            }
        }
    }

    private void doStartThread() {
        this.executor.execute(new Runnable() { // from class: io.netty.util.concurrent.SingleThreadEventExecutor.5
            /* JADX WARN: Code restructure failed: missing block: B:115:0x0386, code lost:
            
                r1 = move-exception;
             */
            /* JADX WARN: Code restructure failed: missing block: B:116:0x0387, code lost:
            
                io.netty.util.concurrent.SingleThreadEventExecutor.STATE_UPDATER.set(r9.this$0, 5);
                r9.this$0.threadLock.release();
             */
            /* JADX WARN: Code restructure failed: missing block: B:117:0x03a3, code lost:
            
                if (r9.this$0.taskQueue.isEmpty() == false) goto L89;
             */
            /* JADX WARN: Code restructure failed: missing block: B:118:0x03a5, code lost:
            
                io.netty.util.concurrent.SingleThreadEventExecutor.logger.warn("An event executor terminated with non-empty task queue (" + r9.this$0.taskQueue.size() + org.apache.commons.beanutils.PropertyUtils.MAPPED_DELIM2);
             */
            /* JADX WARN: Code restructure failed: missing block: B:119:0x03cb, code lost:
            
                r9.this$0.terminationFuture.setSuccess(null);
             */
            /* JADX WARN: Code restructure failed: missing block: B:120:0x03d4, code lost:
            
                throw r1;
             */
            /* JADX WARN: Code restructure failed: missing block: B:29:0x00dd, code lost:
            
                r1 = move-exception;
             */
            /* JADX WARN: Code restructure failed: missing block: B:34:0x012b, code lost:
            
                throw r1;
             */
            /* JADX WARN: Code restructure failed: missing block: B:73:0x0224, code lost:
            
                r1 = move-exception;
             */
            /* JADX WARN: Code restructure failed: missing block: B:74:0x0225, code lost:
            
                io.netty.util.concurrent.SingleThreadEventExecutor.STATE_UPDATER.set(r9.this$0, 5);
                r9.this$0.threadLock.release();
             */
            /* JADX WARN: Code restructure failed: missing block: B:75:0x0241, code lost:
            
                if (r9.this$0.taskQueue.isEmpty() == false) goto L57;
             */
            /* JADX WARN: Code restructure failed: missing block: B:76:0x0243, code lost:
            
                io.netty.util.concurrent.SingleThreadEventExecutor.logger.warn("An event executor terminated with non-empty task queue (" + r9.this$0.taskQueue.size() + org.apache.commons.beanutils.PropertyUtils.MAPPED_DELIM2);
             */
            /* JADX WARN: Code restructure failed: missing block: B:77:0x0269, code lost:
            
                r9.this$0.terminationFuture.setSuccess(null);
             */
            /* JADX WARN: Code restructure failed: missing block: B:78:0x0272, code lost:
            
                throw r1;
             */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void run() {
                /*
                    Method dump skipped, instructions count: 1144
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: io.netty.util.concurrent.SingleThreadEventExecutor.AnonymousClass5.run():void");
            }
        });
    }

    private static final class DefaultThreadProperties implements ThreadProperties {
        private final Thread t;

        DefaultThreadProperties(Thread thread) {
            this.t = thread;
        }

        @Override // io.netty.util.concurrent.ThreadProperties
        public Thread.State state() {
            return this.t.getState();
        }

        @Override // io.netty.util.concurrent.ThreadProperties
        public int priority() {
            return this.t.getPriority();
        }

        @Override // io.netty.util.concurrent.ThreadProperties
        public boolean isInterrupted() {
            return this.t.isInterrupted();
        }

        @Override // io.netty.util.concurrent.ThreadProperties
        public boolean isDaemon() {
            return this.t.isDaemon();
        }

        @Override // io.netty.util.concurrent.ThreadProperties
        public String name() {
            return this.t.getName();
        }

        @Override // io.netty.util.concurrent.ThreadProperties
        public long id() {
            return this.t.getId();
        }

        @Override // io.netty.util.concurrent.ThreadProperties
        public StackTraceElement[] stackTrace() {
            return this.t.getStackTrace();
        }

        @Override // io.netty.util.concurrent.ThreadProperties
        public boolean isAlive() {
            return this.t.isAlive();
        }
    }
}
