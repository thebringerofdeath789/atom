package io.netty.channel.kqueue;

import com.google.android.exoplayer2.C;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.SelectStrategy;
import io.netty.channel.SingleThreadEventLoop;
import io.netty.channel.kqueue.AbstractKQueueChannel;
import io.netty.channel.unix.FileDescriptor;
import io.netty.channel.unix.IovArray;
import io.netty.util.IntSupplier;
import io.netty.util.concurrent.RejectedExecutionHandler;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.IOException;
import java.util.Queue;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* loaded from: classes3.dex */
final class KQueueEventLoop extends SingleThreadEventLoop {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int KQUEUE_WAKE_UP_IDENT = 0;
    private final boolean allowGrowing;
    private final KQueueEventArray changeList;
    private final KQueueEventArray eventList;
    private volatile int ioRatio;
    private final IovArray iovArray;
    private final NativeLongArray jniChannelPointers;
    private final FileDescriptor kqueueFd;
    private final Callable<Integer> pendingTasksCallable;
    private final IntSupplier selectNowSupplier;
    private final SelectStrategy selectStrategy;
    private volatile int wakenUp;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) KQueueEventLoop.class);
    private static final AtomicIntegerFieldUpdater<KQueueEventLoop> WAKEN_UP_UPDATER = AtomicIntegerFieldUpdater.newUpdater(KQueueEventLoop.class, "wakenUp");

    static {
        KQueue.ensureAvailability();
    }

    KQueueEventLoop(EventLoopGroup eventLoopGroup, Executor executor, int i, SelectStrategy selectStrategy, RejectedExecutionHandler rejectedExecutionHandler) {
        super(eventLoopGroup, executor, false, DEFAULT_MAX_PENDING_TASKS, rejectedExecutionHandler);
        this.iovArray = new IovArray();
        this.selectNowSupplier = new IntSupplier() { // from class: io.netty.channel.kqueue.KQueueEventLoop.1
            @Override // io.netty.util.IntSupplier
            public int get() throws Exception {
                return KQueueEventLoop.this.kqueueWaitNow();
            }
        };
        this.pendingTasksCallable = new Callable<Integer>() { // from class: io.netty.channel.kqueue.KQueueEventLoop.2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public Integer call() throws Exception {
                return Integer.valueOf(KQueueEventLoop.super.pendingTasks());
            }
        };
        this.ioRatio = 50;
        this.selectStrategy = (SelectStrategy) ObjectUtil.checkNotNull(selectStrategy, "strategy");
        FileDescriptor newKQueue = Native.newKQueue();
        this.kqueueFd = newKQueue;
        if (i == 0) {
            this.allowGrowing = true;
            i = 4096;
        } else {
            this.allowGrowing = false;
        }
        this.changeList = new KQueueEventArray(i);
        this.eventList = new KQueueEventArray(i);
        this.jniChannelPointers = new NativeLongArray(4096);
        int keventAddUserEvent = Native.keventAddUserEvent(newKQueue.intValue(), 0);
        if (keventAddUserEvent >= 0) {
            return;
        }
        cleanup();
        throw new IllegalStateException("kevent failed to add user event with errno: " + (-keventAddUserEvent));
    }

    void evSet(AbstractKQueueChannel abstractKQueueChannel, short s, short s2, int i) {
        this.changeList.evSet(abstractKQueueChannel, s, s2, i);
    }

    void remove(AbstractKQueueChannel abstractKQueueChannel) throws IOException {
        if (abstractKQueueChannel.jniSelfPtr == 0) {
            return;
        }
        this.jniChannelPointers.add(abstractKQueueChannel.jniSelfPtr);
        abstractKQueueChannel.jniSelfPtr = 0L;
    }

    IovArray cleanArray() {
        this.iovArray.clear();
        return this.iovArray;
    }

    @Override // io.netty.util.concurrent.SingleThreadEventExecutor
    protected void wakeup(boolean z) {
        if (z || !WAKEN_UP_UPDATER.compareAndSet(this, 0, 1)) {
            return;
        }
        wakeup();
    }

    private void wakeup() {
        Native.keventTriggerUserEvent(this.kqueueFd.intValue(), 0);
    }

    private int kqueueWait(boolean z) throws IOException {
        if (z && hasTasks()) {
            return kqueueWaitNow();
        }
        long delayNanos = delayNanos(System.nanoTime());
        int min = (int) Math.min(delayNanos / C.NANOS_PER_SECOND, 2147483647L);
        return kqueueWait(min, (int) Math.min(delayNanos - (min * C.NANOS_PER_SECOND), 2147483647L));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int kqueueWaitNow() throws IOException {
        return kqueueWait(0, 0);
    }

    private int kqueueWait(int i, int i2) throws IOException {
        deleteJniChannelPointers();
        int keventWait = Native.keventWait(this.kqueueFd.intValue(), this.changeList, this.eventList, i, i2);
        this.changeList.clear();
        return keventWait;
    }

    private void deleteJniChannelPointers() {
        if (this.jniChannelPointers.isEmpty()) {
            return;
        }
        KQueueEventArray.deleteGlobalRefs(this.jniChannelPointers.memoryAddress(), this.jniChannelPointers.memoryAddressEnd());
        this.jniChannelPointers.clear();
    }

    private void processReady(int i) {
        for (int i2 = 0; i2 < i; i2++) {
            short filter = this.eventList.filter(i2);
            short flags = this.eventList.flags(i2);
            if (filter != Native.EVFILT_USER && (Native.EV_ERROR & flags) == 0) {
                AbstractKQueueChannel channel = this.eventList.channel(i2);
                if (channel == null) {
                    logger.warn("events[{}]=[{}, {}] had no channel!", Integer.valueOf(i2), Integer.valueOf(this.eventList.fd(i2)), Short.valueOf(filter));
                } else {
                    AbstractKQueueChannel.AbstractKQueueUnsafe abstractKQueueUnsafe = (AbstractKQueueChannel.AbstractKQueueUnsafe) channel.unsafe();
                    if (filter == Native.EVFILT_WRITE) {
                        abstractKQueueUnsafe.writeReady();
                    } else if (filter == Native.EVFILT_READ) {
                        abstractKQueueUnsafe.readReady(this.eventList.data(i2));
                    } else if (filter == Native.EVFILT_SOCK && (this.eventList.fflags(i2) & Native.NOTE_RDHUP) != 0) {
                        abstractKQueueUnsafe.readEOF();
                    }
                    if ((Native.EV_EOF & flags) != 0) {
                        abstractKQueueUnsafe.readEOF();
                    }
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0084 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0000 A[SYNTHETIC] */
    @Override // io.netty.util.concurrent.SingleThreadEventExecutor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void run() {
        /*
            r7 = this;
        L0:
            io.netty.channel.SelectStrategy r0 = r7.selectStrategy     // Catch: java.lang.Throwable -> L7a
            io.netty.util.IntSupplier r1 = r7.selectNowSupplier     // Catch: java.lang.Throwable -> L7a
            boolean r2 = r7.hasTasks()     // Catch: java.lang.Throwable -> L7a
            int r0 = r0.calculateStrategy(r1, r2)     // Catch: java.lang.Throwable -> L7a
            r1 = -2
            if (r0 == r1) goto L0
            r1 = -1
            r2 = 0
            if (r0 == r1) goto L14
            goto L2b
        L14:
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater<io.netty.channel.kqueue.KQueueEventLoop> r0 = io.netty.channel.kqueue.KQueueEventLoop.WAKEN_UP_UPDATER     // Catch: java.lang.Throwable -> L7a
            int r0 = r0.getAndSet(r7, r2)     // Catch: java.lang.Throwable -> L7a
            r1 = 1
            if (r0 != r1) goto L1f
            r0 = r1
            goto L20
        L1f:
            r0 = r2
        L20:
            int r0 = r7.kqueueWait(r0)     // Catch: java.lang.Throwable -> L7a
            int r3 = r7.wakenUp     // Catch: java.lang.Throwable -> L7a
            if (r3 != r1) goto L2b
            r7.wakeup()     // Catch: java.lang.Throwable -> L7a
        L2b:
            int r1 = r7.ioRatio     // Catch: java.lang.Throwable -> L7a
            r3 = 100
            if (r1 != r3) goto L40
            if (r0 <= 0) goto L3c
            r7.processReady(r0)     // Catch: java.lang.Throwable -> L37
            goto L3c
        L37:
            r0 = move-exception
            r7.runAllTasks()     // Catch: java.lang.Throwable -> L7a
            throw r0     // Catch: java.lang.Throwable -> L7a
        L3c:
            r7.runAllTasks()     // Catch: java.lang.Throwable -> L7a
            goto L68
        L40:
            long r3 = java.lang.System.nanoTime()     // Catch: java.lang.Throwable -> L7a
            if (r0 <= 0) goto L5a
            r7.processReady(r0)     // Catch: java.lang.Throwable -> L4a
            goto L5a
        L4a:
            r0 = move-exception
            long r5 = java.lang.System.nanoTime()     // Catch: java.lang.Throwable -> L7a
            long r5 = r5 - r3
            int r2 = 100 - r1
            long r2 = (long) r2     // Catch: java.lang.Throwable -> L7a
            long r5 = r5 * r2
            long r1 = (long) r1     // Catch: java.lang.Throwable -> L7a
            long r5 = r5 / r1
            r7.runAllTasks(r5)     // Catch: java.lang.Throwable -> L7a
            throw r0     // Catch: java.lang.Throwable -> L7a
        L5a:
            long r5 = java.lang.System.nanoTime()     // Catch: java.lang.Throwable -> L7a
            long r5 = r5 - r3
            int r3 = 100 - r1
            long r3 = (long) r3     // Catch: java.lang.Throwable -> L7a
            long r5 = r5 * r3
            long r3 = (long) r1     // Catch: java.lang.Throwable -> L7a
            long r5 = r5 / r3
            r7.runAllTasks(r5)     // Catch: java.lang.Throwable -> L7a
        L68:
            boolean r1 = r7.allowGrowing     // Catch: java.lang.Throwable -> L7a
            if (r1 == 0) goto L7e
            io.netty.channel.kqueue.KQueueEventArray r1 = r7.eventList     // Catch: java.lang.Throwable -> L7a
            int r1 = r1.capacity()     // Catch: java.lang.Throwable -> L7a
            if (r0 != r1) goto L7e
            io.netty.channel.kqueue.KQueueEventArray r0 = r7.eventList     // Catch: java.lang.Throwable -> L7a
            r0.realloc(r2)     // Catch: java.lang.Throwable -> L7a
            goto L7e
        L7a:
            r0 = move-exception
            handleLoopException(r0)
        L7e:
            boolean r0 = r7.isShuttingDown()     // Catch: java.lang.Throwable -> L8e
            if (r0 == 0) goto L0
            r7.closeAll()     // Catch: java.lang.Throwable -> L8e
            boolean r0 = r7.confirmShutdown()     // Catch: java.lang.Throwable -> L8e
            if (r0 == 0) goto L0
            return
        L8e:
            r0 = move-exception
            handleLoopException(r0)
            goto L0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.channel.kqueue.KQueueEventLoop.run():void");
    }

    @Override // io.netty.util.concurrent.SingleThreadEventExecutor
    protected Queue<Runnable> newTaskQueue(int i) {
        if (i == Integer.MAX_VALUE) {
            return PlatformDependent.newMpscQueue();
        }
        return PlatformDependent.newMpscQueue(i);
    }

    @Override // io.netty.channel.SingleThreadEventLoop, io.netty.util.concurrent.SingleThreadEventExecutor
    public int pendingTasks() {
        return inEventLoop() ? super.pendingTasks() : ((Integer) submit((Callable) this.pendingTasksCallable).syncUninterruptibly().getNow()).intValue();
    }

    public int getIoRatio() {
        return this.ioRatio;
    }

    public void setIoRatio(int i) {
        if (i <= 0 || i > 100) {
            throw new IllegalArgumentException("ioRatio: " + i + " (expected: 0 < ioRatio <= 100)");
        }
        this.ioRatio = i;
    }

    @Override // io.netty.util.concurrent.SingleThreadEventExecutor
    protected void cleanup() {
        try {
            try {
                this.kqueueFd.close();
            } catch (IOException e) {
                logger.warn("Failed to close the kqueue fd.", (Throwable) e);
            }
        } finally {
            deleteJniChannelPointers();
            this.jniChannelPointers.free();
            this.changeList.free();
            this.eventList.free();
        }
    }

    private void closeAll() {
        try {
            kqueueWaitNow();
        } catch (IOException unused) {
        }
    }

    private static void handleLoopException(Throwable th) {
        logger.warn("Unexpected exception in the selector loop.", th);
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException unused) {
        }
    }
}
