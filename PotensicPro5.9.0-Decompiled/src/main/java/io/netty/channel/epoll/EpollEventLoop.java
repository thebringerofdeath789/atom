package io.netty.channel.epoll;

import com.google.android.exoplayer2.C;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.SelectStrategy;
import io.netty.channel.SingleThreadEventLoop;
import io.netty.channel.epoll.AbstractEpollChannel;
import io.netty.channel.unix.FileDescriptor;
import io.netty.channel.unix.IovArray;
import io.netty.util.IntSupplier;
import io.netty.util.collection.IntObjectHashMap;
import io.netty.util.collection.IntObjectMap;
import io.netty.util.concurrent.RejectedExecutionHandler;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* loaded from: classes3.dex */
final class EpollEventLoop extends SingleThreadEventLoop {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final boolean allowGrowing;
    private final IntObjectMap<AbstractEpollChannel> channels;
    private final FileDescriptor epollFd;
    private final FileDescriptor eventFd;
    private final EpollEventArray events;
    private volatile int ioRatio;
    private final IovArray iovArray;
    private final Callable<Integer> pendingTasksCallable;
    private final IntSupplier selectNowSupplier;
    private final SelectStrategy selectStrategy;
    private final FileDescriptor timerFd;
    private volatile int wakenUp;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) EpollEventLoop.class);
    private static final AtomicIntegerFieldUpdater<EpollEventLoop> WAKEN_UP_UPDATER = AtomicIntegerFieldUpdater.newUpdater(EpollEventLoop.class, "wakenUp");

    static {
        Epoll.ensureAvailability();
    }

    EpollEventLoop(EventLoopGroup eventLoopGroup, Executor executor, int i, SelectStrategy selectStrategy, RejectedExecutionHandler rejectedExecutionHandler) {
        super(eventLoopGroup, executor, false, DEFAULT_MAX_PENDING_TASKS, rejectedExecutionHandler);
        FileDescriptor fileDescriptor;
        FileDescriptor fileDescriptor2;
        FileDescriptor newEpollCreate;
        this.channels = new IntObjectHashMap(4096);
        this.iovArray = new IovArray();
        this.selectNowSupplier = new IntSupplier() { // from class: io.netty.channel.epoll.EpollEventLoop.1
            @Override // io.netty.util.IntSupplier
            public int get() throws Exception {
                return EpollEventLoop.this.epollWaitNow();
            }
        };
        this.pendingTasksCallable = new Callable<Integer>() { // from class: io.netty.channel.epoll.EpollEventLoop.2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public Integer call() throws Exception {
                return Integer.valueOf(EpollEventLoop.super.pendingTasks());
            }
        };
        this.ioRatio = 50;
        this.selectStrategy = (SelectStrategy) ObjectUtil.checkNotNull(selectStrategy, "strategy");
        if (i == 0) {
            this.allowGrowing = true;
            this.events = new EpollEventArray(4096);
        } else {
            this.allowGrowing = false;
            this.events = new EpollEventArray(i);
        }
        FileDescriptor fileDescriptor3 = null;
        try {
            newEpollCreate = Native.newEpollCreate();
            try {
                this.epollFd = newEpollCreate;
                fileDescriptor2 = Native.newEventFd();
            } catch (Throwable th) {
                th = th;
                fileDescriptor2 = null;
                fileDescriptor3 = newEpollCreate;
                fileDescriptor = null;
            }
        } catch (Throwable th2) {
            th = th2;
            fileDescriptor = null;
            fileDescriptor2 = null;
        }
        try {
            this.eventFd = fileDescriptor2;
            try {
                Native.epollCtlAdd(newEpollCreate.intValue(), fileDescriptor2.intValue(), Native.EPOLLIN);
                fileDescriptor3 = Native.newTimerFd();
                this.timerFd = fileDescriptor3;
                try {
                    Native.epollCtlAdd(newEpollCreate.intValue(), fileDescriptor3.intValue(), Native.EPOLLIN | Native.EPOLLET);
                } catch (IOException e) {
                    throw new IllegalStateException("Unable to add timerFd filedescriptor to epoll", e);
                }
            } catch (IOException e2) {
                throw new IllegalStateException("Unable to add eventFd filedescriptor to epoll", e2);
            }
        } catch (Throwable th3) {
            th = th3;
            fileDescriptor = fileDescriptor3;
            fileDescriptor3 = newEpollCreate;
            if (fileDescriptor3 != null) {
                try {
                    fileDescriptor3.close();
                } catch (Exception unused) {
                }
            }
            if (fileDescriptor2 != null) {
                try {
                    fileDescriptor2.close();
                } catch (Exception unused2) {
                }
            }
            if (fileDescriptor != null) {
                try {
                    fileDescriptor.close();
                    throw th;
                } catch (Exception unused3) {
                    throw th;
                }
            }
            throw th;
        }
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
        Native.eventFdWrite(this.eventFd.intValue(), 1L);
    }

    void add(AbstractEpollChannel abstractEpollChannel) throws IOException {
        int intValue = abstractEpollChannel.socket.intValue();
        Native.epollCtlAdd(this.epollFd.intValue(), intValue, abstractEpollChannel.flags);
        this.channels.put(intValue, (int) abstractEpollChannel);
    }

    void modify(AbstractEpollChannel abstractEpollChannel) throws IOException {
        Native.epollCtlMod(this.epollFd.intValue(), abstractEpollChannel.socket.intValue(), abstractEpollChannel.flags);
    }

    void remove(AbstractEpollChannel abstractEpollChannel) throws IOException {
        if (abstractEpollChannel.isOpen()) {
            if (this.channels.remove(abstractEpollChannel.socket.intValue()) != null) {
                Native.epollCtlDel(this.epollFd.intValue(), abstractEpollChannel.fd().intValue());
            }
        }
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
        if (inEventLoop()) {
            return super.pendingTasks();
        }
        return ((Integer) submit((Callable) this.pendingTasksCallable).syncUninterruptibly().getNow()).intValue();
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

    private int epollWait(boolean z) throws IOException {
        if (z && hasTasks()) {
            return epollWaitNow();
        }
        long delayNanos = delayNanos(System.nanoTime());
        int min = (int) Math.min(delayNanos / C.NANOS_PER_SECOND, 2147483647L);
        return Native.epollWait(this.epollFd, this.events, this.timerFd, min, (int) Math.min(delayNanos - (min * C.NANOS_PER_SECOND), 2147483647L));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int epollWaitNow() throws IOException {
        return Native.epollWait(this.epollFd, this.events, this.timerFd, 0, 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x008e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0000 A[SYNTHETIC] */
    @Override // io.netty.util.concurrent.SingleThreadEventExecutor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void run() {
        /*
            r6 = this;
        L0:
            io.netty.channel.SelectStrategy r0 = r6.selectStrategy     // Catch: java.lang.Throwable -> L84
            io.netty.util.IntSupplier r1 = r6.selectNowSupplier     // Catch: java.lang.Throwable -> L84
            boolean r2 = r6.hasTasks()     // Catch: java.lang.Throwable -> L84
            int r0 = r0.calculateStrategy(r1, r2)     // Catch: java.lang.Throwable -> L84
            r1 = -2
            if (r0 == r1) goto L0
            r1 = -1
            if (r0 == r1) goto L13
            goto L31
        L13:
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater<io.netty.channel.epoll.EpollEventLoop> r0 = io.netty.channel.epoll.EpollEventLoop.WAKEN_UP_UPDATER     // Catch: java.lang.Throwable -> L84
            r1 = 0
            int r0 = r0.getAndSet(r6, r1)     // Catch: java.lang.Throwable -> L84
            r2 = 1
            if (r0 != r2) goto L1e
            r1 = r2
        L1e:
            int r0 = r6.epollWait(r1)     // Catch: java.lang.Throwable -> L84
            int r1 = r6.wakenUp     // Catch: java.lang.Throwable -> L84
            if (r1 != r2) goto L31
            io.netty.channel.unix.FileDescriptor r1 = r6.eventFd     // Catch: java.lang.Throwable -> L84
            int r1 = r1.intValue()     // Catch: java.lang.Throwable -> L84
            r2 = 1
            io.netty.channel.epoll.Native.eventFdWrite(r1, r2)     // Catch: java.lang.Throwable -> L84
        L31:
            int r1 = r6.ioRatio     // Catch: java.lang.Throwable -> L84
            r2 = 100
            if (r1 != r2) goto L48
            if (r0 <= 0) goto L44
            io.netty.channel.epoll.EpollEventArray r1 = r6.events     // Catch: java.lang.Throwable -> L3f
            r6.processReady(r1, r0)     // Catch: java.lang.Throwable -> L3f
            goto L44
        L3f:
            r0 = move-exception
            r6.runAllTasks()     // Catch: java.lang.Throwable -> L84
            throw r0     // Catch: java.lang.Throwable -> L84
        L44:
            r6.runAllTasks()     // Catch: java.lang.Throwable -> L84
            goto L72
        L48:
            long r2 = java.lang.System.nanoTime()     // Catch: java.lang.Throwable -> L84
            if (r0 <= 0) goto L64
            io.netty.channel.epoll.EpollEventArray r4 = r6.events     // Catch: java.lang.Throwable -> L54
            r6.processReady(r4, r0)     // Catch: java.lang.Throwable -> L54
            goto L64
        L54:
            r0 = move-exception
            long r4 = java.lang.System.nanoTime()     // Catch: java.lang.Throwable -> L84
            long r4 = r4 - r2
            int r2 = 100 - r1
            long r2 = (long) r2     // Catch: java.lang.Throwable -> L84
            long r4 = r4 * r2
            long r1 = (long) r1     // Catch: java.lang.Throwable -> L84
            long r4 = r4 / r1
            r6.runAllTasks(r4)     // Catch: java.lang.Throwable -> L84
            throw r0     // Catch: java.lang.Throwable -> L84
        L64:
            long r4 = java.lang.System.nanoTime()     // Catch: java.lang.Throwable -> L84
            long r4 = r4 - r2
            int r2 = 100 - r1
            long r2 = (long) r2     // Catch: java.lang.Throwable -> L84
            long r4 = r4 * r2
            long r1 = (long) r1     // Catch: java.lang.Throwable -> L84
            long r4 = r4 / r1
            r6.runAllTasks(r4)     // Catch: java.lang.Throwable -> L84
        L72:
            boolean r1 = r6.allowGrowing     // Catch: java.lang.Throwable -> L84
            if (r1 == 0) goto L88
            io.netty.channel.epoll.EpollEventArray r1 = r6.events     // Catch: java.lang.Throwable -> L84
            int r1 = r1.length()     // Catch: java.lang.Throwable -> L84
            if (r0 != r1) goto L88
            io.netty.channel.epoll.EpollEventArray r0 = r6.events     // Catch: java.lang.Throwable -> L84
            r0.increase()     // Catch: java.lang.Throwable -> L84
            goto L88
        L84:
            r0 = move-exception
            handleLoopException(r0)
        L88:
            boolean r0 = r6.isShuttingDown()     // Catch: java.lang.Throwable -> L98
            if (r0 == 0) goto L0
            r6.closeAll()     // Catch: java.lang.Throwable -> L98
            boolean r0 = r6.confirmShutdown()     // Catch: java.lang.Throwable -> L98
            if (r0 == 0) goto L0
            return
        L98:
            r0 = move-exception
            handleLoopException(r0)
            goto L0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.channel.epoll.EpollEventLoop.run():void");
    }

    private static void handleLoopException(Throwable th) {
        logger.warn("Unexpected exception in the selector loop.", th);
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException unused) {
        }
    }

    private void closeAll() {
        try {
            epollWaitNow();
        } catch (IOException unused) {
        }
        ArrayList<AbstractEpollChannel> arrayList = new ArrayList(this.channels.size());
        Iterator<AbstractEpollChannel> it = this.channels.values().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        for (AbstractEpollChannel abstractEpollChannel : arrayList) {
            abstractEpollChannel.unsafe().close(abstractEpollChannel.unsafe().voidPromise());
        }
    }

    private void processReady(EpollEventArray epollEventArray, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            int fd = epollEventArray.fd(i2);
            if (fd == this.eventFd.intValue()) {
                Native.eventFdRead(fd);
            } else if (fd == this.timerFd.intValue()) {
                Native.timerFdRead(fd);
            } else {
                long events = epollEventArray.events(i2);
                AbstractEpollChannel abstractEpollChannel = this.channels.get(fd);
                if (abstractEpollChannel != null) {
                    AbstractEpollChannel.AbstractEpollUnsafe abstractEpollUnsafe = (AbstractEpollChannel.AbstractEpollUnsafe) abstractEpollChannel.unsafe();
                    if (((Native.EPOLLERR | Native.EPOLLOUT) & events) != 0) {
                        abstractEpollUnsafe.epollOutReady();
                    }
                    if (((Native.EPOLLERR | Native.EPOLLIN) & events) != 0) {
                        abstractEpollUnsafe.epollInReady();
                    }
                    if ((events & Native.EPOLLRDHUP) != 0) {
                        abstractEpollUnsafe.epollRdHupReady();
                    }
                } else {
                    try {
                        Native.epollCtlDel(this.epollFd.intValue(), fd);
                    } catch (IOException unused) {
                    }
                }
            }
        }
    }

    @Override // io.netty.util.concurrent.SingleThreadEventExecutor
    protected void cleanup() {
        try {
            try {
                this.epollFd.close();
            } catch (IOException e) {
                logger.warn("Failed to close the epoll fd.", (Throwable) e);
            }
            try {
                this.eventFd.close();
            } catch (IOException e2) {
                logger.warn("Failed to close the event fd.", (Throwable) e2);
            }
            try {
                this.timerFd.close();
            } catch (IOException e3) {
                logger.warn("Failed to close the timer fd.", (Throwable) e3);
            }
        } finally {
            this.iovArray.release();
            this.events.free();
        }
    }
}
