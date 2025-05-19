package io.netty.util.concurrent;

import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.util.ArrayDeque;
import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

/* loaded from: classes4.dex */
public final class ImmediateEventExecutor extends AbstractEventExecutor {
    private final Future<?> terminationFuture = new FailedFuture(GlobalEventExecutor.INSTANCE, new UnsupportedOperationException());
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) ImmediateEventExecutor.class);
    public static final ImmediateEventExecutor INSTANCE = new ImmediateEventExecutor();
    private static final FastThreadLocal<Queue<Runnable>> DELAYED_RUNNABLES = new FastThreadLocal<Queue<Runnable>>() { // from class: io.netty.util.concurrent.ImmediateEventExecutor.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // io.netty.util.concurrent.FastThreadLocal
        public Queue<Runnable> initialValue() throws Exception {
            return new ArrayDeque();
        }
    };
    private static final FastThreadLocal<Boolean> RUNNING = new FastThreadLocal<Boolean>() { // from class: io.netty.util.concurrent.ImmediateEventExecutor.2
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.netty.util.concurrent.FastThreadLocal
        public Boolean initialValue() throws Exception {
            return false;
        }
    };

    @Override // java.util.concurrent.ExecutorService
    public boolean awaitTermination(long j, TimeUnit timeUnit) {
        return false;
    }

    @Override // io.netty.util.concurrent.AbstractEventExecutor, io.netty.util.concurrent.EventExecutor
    public boolean inEventLoop() {
        return true;
    }

    @Override // io.netty.util.concurrent.EventExecutor
    public boolean inEventLoop(Thread thread) {
        return true;
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isShutdown() {
        return false;
    }

    @Override // io.netty.util.concurrent.EventExecutorGroup
    public boolean isShuttingDown() {
        return false;
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isTerminated() {
        return false;
    }

    @Override // io.netty.util.concurrent.AbstractEventExecutor, java.util.concurrent.ExecutorService, io.netty.util.concurrent.EventExecutorGroup
    @Deprecated
    public void shutdown() {
    }

    private ImmediateEventExecutor() {
    }

    @Override // io.netty.util.concurrent.EventExecutorGroup
    public Future<?> shutdownGracefully(long j, long j2, TimeUnit timeUnit) {
        return terminationFuture();
    }

    @Override // io.netty.util.concurrent.EventExecutorGroup
    public Future<?> terminationFuture() {
        return this.terminationFuture;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        Runnable poll;
        Objects.requireNonNull(runnable, "command");
        FastThreadLocal<Boolean> fastThreadLocal = RUNNING;
        if (!fastThreadLocal.get().booleanValue()) {
            fastThreadLocal.set(true);
            try {
                runnable.run();
                while (true) {
                    if (poll == null) {
                        break;
                    }
                }
            } catch (Throwable th) {
                try {
                    logger.info("Throwable caught while executing Runnable {}", runnable, th);
                    Queue<Runnable> queue = DELAYED_RUNNABLES.get();
                    while (true) {
                        Runnable poll2 = queue.poll();
                        if (poll2 == null) {
                            break;
                        }
                        try {
                            poll2.run();
                        } catch (Throwable th2) {
                            logger.info("Throwable caught while executing Runnable {}", poll2, th2);
                        }
                    }
                } finally {
                    Queue<Runnable> queue2 = DELAYED_RUNNABLES.get();
                    while (true) {
                        poll = queue2.poll();
                        if (poll != null) {
                            try {
                                poll.run();
                            } catch (Throwable th3) {
                                logger.info("Throwable caught while executing Runnable {}", poll, th3);
                            }
                        } else {
                            RUNNING.set(false);
                        }
                    }
                }
            }
            return;
        }
        DELAYED_RUNNABLES.get().add(runnable);
    }

    @Override // io.netty.util.concurrent.AbstractEventExecutor, io.netty.util.concurrent.EventExecutor
    public <V> Promise<V> newPromise() {
        return new ImmediatePromise(this);
    }

    @Override // io.netty.util.concurrent.AbstractEventExecutor, io.netty.util.concurrent.EventExecutor
    public <V> ProgressivePromise<V> newProgressivePromise() {
        return new ImmediateProgressivePromise(this);
    }

    static class ImmediatePromise<V> extends DefaultPromise<V> {
        @Override // io.netty.util.concurrent.DefaultPromise
        protected void checkDeadLock() {
        }

        ImmediatePromise(EventExecutor eventExecutor) {
            super(eventExecutor);
        }
    }

    static class ImmediateProgressivePromise<V> extends DefaultProgressivePromise<V> {
        @Override // io.netty.util.concurrent.DefaultPromise
        protected void checkDeadLock() {
        }

        ImmediateProgressivePromise(EventExecutor eventExecutor) {
            super(eventExecutor);
        }
    }
}
