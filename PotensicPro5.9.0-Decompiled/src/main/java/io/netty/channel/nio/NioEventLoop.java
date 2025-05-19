package io.netty.channel.nio;

import io.netty.channel.ChannelException;
import io.netty.channel.EventLoopException;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.SelectStrategy;
import io.netty.channel.SingleThreadEventLoop;
import io.netty.channel.nio.AbstractNioChannel;
import io.netty.util.IntSupplier;
import io.netty.util.concurrent.RejectedExecutionHandler;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.ReflectionUtil;
import io.netty.util.internal.SystemPropertyUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.channels.CancelledKeyException;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.spi.AbstractSelector;
import java.nio.channels.spi.SelectorProvider;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import org.apache.commons.beanutils.PropertyUtils;

/* loaded from: classes3.dex */
public final class NioEventLoop extends SingleThreadEventLoop {
    private static final int CLEANUP_INTERVAL = 256;
    private static final int MIN_PREMATURE_SELECTOR_RETURNS = 3;
    private static final int SELECTOR_AUTO_REBUILD_THRESHOLD;
    private int cancelledKeys;
    private volatile int ioRatio;
    private boolean needsToSelectAgain;
    private final Callable<Integer> pendingTasksCallable;
    private final SelectorProvider provider;
    private final IntSupplier selectNowSupplier;
    private final SelectStrategy selectStrategy;
    private SelectedSelectionKeySet selectedKeys;
    private Selector selector;
    private Selector unwrappedSelector;
    private final AtomicBoolean wakenUp;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) NioEventLoop.class);
    private static final boolean DISABLE_KEYSET_OPTIMIZATION = SystemPropertyUtil.getBoolean("io.netty.noKeySetOptimization", false);

    static {
        if (SystemPropertyUtil.get("sun.nio.ch.bugLevel") == null) {
            try {
                AccessController.doPrivileged(new PrivilegedAction<Void>() { // from class: io.netty.channel.nio.NioEventLoop.3
                    @Override // java.security.PrivilegedAction
                    public Void run() {
                        System.setProperty("sun.nio.ch.bugLevel", "");
                        return null;
                    }
                });
            } catch (SecurityException e) {
                logger.debug("Unable to get/set System Property: sun.nio.ch.bugLevel", (Throwable) e);
            }
        }
        int i = SystemPropertyUtil.getInt("io.netty.selectorAutoRebuildThreshold", 512);
        int i2 = i >= 3 ? i : 0;
        SELECTOR_AUTO_REBUILD_THRESHOLD = i2;
        InternalLogger internalLogger = logger;
        if (internalLogger.isDebugEnabled()) {
            internalLogger.debug("-Dio.netty.noKeySetOptimization: {}", Boolean.valueOf(DISABLE_KEYSET_OPTIMIZATION));
            internalLogger.debug("-Dio.netty.selectorAutoRebuildThreshold: {}", Integer.valueOf(i2));
        }
    }

    NioEventLoop(NioEventLoopGroup nioEventLoopGroup, Executor executor, SelectorProvider selectorProvider, SelectStrategy selectStrategy, RejectedExecutionHandler rejectedExecutionHandler) {
        super((EventLoopGroup) nioEventLoopGroup, executor, false, DEFAULT_MAX_PENDING_TASKS, rejectedExecutionHandler);
        this.selectNowSupplier = new IntSupplier() { // from class: io.netty.channel.nio.NioEventLoop.1
            @Override // io.netty.util.IntSupplier
            public int get() throws Exception {
                return NioEventLoop.this.selectNow();
            }
        };
        this.pendingTasksCallable = new Callable<Integer>() { // from class: io.netty.channel.nio.NioEventLoop.2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public Integer call() throws Exception {
                return Integer.valueOf(NioEventLoop.super.pendingTasks());
            }
        };
        this.wakenUp = new AtomicBoolean();
        this.ioRatio = 50;
        Objects.requireNonNull(selectorProvider, "selectorProvider");
        Objects.requireNonNull(selectStrategy, "selectStrategy");
        this.provider = selectorProvider;
        SelectorTuple openSelector = openSelector();
        this.selector = openSelector.selector;
        this.unwrappedSelector = openSelector.unwrappedSelector;
        this.selectStrategy = selectStrategy;
    }

    private static final class SelectorTuple {
        final Selector selector;
        final Selector unwrappedSelector;

        SelectorTuple(Selector selector) {
            this.unwrappedSelector = selector;
            this.selector = selector;
        }

        SelectorTuple(Selector selector, Selector selector2) {
            this.unwrappedSelector = selector;
            this.selector = selector2;
        }
    }

    private SelectorTuple openSelector() {
        try {
            final AbstractSelector openSelector = this.provider.openSelector();
            if (DISABLE_KEYSET_OPTIMIZATION) {
                return new SelectorTuple(openSelector);
            }
            final SelectedSelectionKeySet selectedSelectionKeySet = new SelectedSelectionKeySet();
            Object doPrivileged = AccessController.doPrivileged(new PrivilegedAction<Object>() { // from class: io.netty.channel.nio.NioEventLoop.4
                @Override // java.security.PrivilegedAction
                public Object run() {
                    try {
                        return Class.forName("sun.nio.ch.SelectorImpl", false, PlatformDependent.getSystemClassLoader());
                    } catch (Throwable th) {
                        return th;
                    }
                }
            });
            if (doPrivileged instanceof Class) {
                final Class cls = (Class) doPrivileged;
                if (cls.isAssignableFrom(openSelector.getClass())) {
                    Object doPrivileged2 = AccessController.doPrivileged(new PrivilegedAction<Object>() { // from class: io.netty.channel.nio.NioEventLoop.5
                        @Override // java.security.PrivilegedAction
                        public Object run() {
                            try {
                                Field declaredField = cls.getDeclaredField("selectedKeys");
                                Field declaredField2 = cls.getDeclaredField("publicSelectedKeys");
                                Throwable trySetAccessible = ReflectionUtil.trySetAccessible(declaredField);
                                if (trySetAccessible != null) {
                                    return trySetAccessible;
                                }
                                Throwable trySetAccessible2 = ReflectionUtil.trySetAccessible(declaredField2);
                                if (trySetAccessible2 != null) {
                                    return trySetAccessible2;
                                }
                                declaredField.set(openSelector, selectedSelectionKeySet);
                                declaredField2.set(openSelector, selectedSelectionKeySet);
                                return null;
                            } catch (IllegalAccessException e) {
                                return e;
                            } catch (NoSuchFieldException e2) {
                                return e2;
                            }
                        }
                    });
                    if (doPrivileged2 instanceof Exception) {
                        this.selectedKeys = null;
                        logger.trace("failed to instrument a special java.util.Set into: {}", openSelector, (Exception) doPrivileged2);
                        return new SelectorTuple(openSelector);
                    }
                    this.selectedKeys = selectedSelectionKeySet;
                    logger.trace("instrumented a special java.util.Set into: {}", openSelector);
                    return new SelectorTuple(openSelector, new SelectedSelectionKeySetSelector(openSelector, selectedSelectionKeySet));
                }
            }
            if (doPrivileged instanceof Throwable) {
                logger.trace("failed to instrument a special java.util.Set into: {}", openSelector, (Throwable) doPrivileged);
            }
            return new SelectorTuple(openSelector);
        } catch (IOException e) {
            throw new ChannelException("failed to open a new selector", e);
        }
    }

    public SelectorProvider selectorProvider() {
        return this.provider;
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

    public void register(SelectableChannel selectableChannel, int i, NioTask<?> nioTask) {
        Objects.requireNonNull(selectableChannel, "ch");
        if (i == 0) {
            throw new IllegalArgumentException("interestOps must be non-zero.");
        }
        if (((~selectableChannel.validOps()) & i) != 0) {
            throw new IllegalArgumentException("invalid interestOps: " + i + "(validOps: " + selectableChannel.validOps() + PropertyUtils.MAPPED_DELIM2);
        }
        Objects.requireNonNull(nioTask, "task");
        if (isShutdown()) {
            throw new IllegalStateException("event loop shut down");
        }
        try {
            selectableChannel.register(this.selector, i, nioTask);
        } catch (Exception e) {
            throw new EventLoopException("failed to register a channel", e);
        }
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

    public void rebuildSelector() {
        if (!inEventLoop()) {
            execute(new Runnable() { // from class: io.netty.channel.nio.NioEventLoop.6
                @Override // java.lang.Runnable
                public void run() {
                    NioEventLoop.this.rebuildSelector0();
                }
            });
        } else {
            rebuildSelector0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rebuildSelector0() {
        Selector selector = this.selector;
        if (selector == null) {
            return;
        }
        try {
            SelectorTuple openSelector = openSelector();
            int i = 0;
            for (SelectionKey selectionKey : selector.keys()) {
                Object attachment = selectionKey.attachment();
                try {
                    if (selectionKey.isValid() && selectionKey.channel().keyFor(openSelector.unwrappedSelector) == null) {
                        int interestOps = selectionKey.interestOps();
                        selectionKey.cancel();
                        SelectionKey register = selectionKey.channel().register(openSelector.unwrappedSelector, interestOps, attachment);
                        if (attachment instanceof AbstractNioChannel) {
                            ((AbstractNioChannel) attachment).selectionKey = register;
                        }
                        i++;
                    }
                } catch (Exception e) {
                    logger.warn("Failed to re-register a Channel to the new Selector.", (Throwable) e);
                    if (attachment instanceof AbstractNioChannel) {
                        AbstractNioChannel abstractNioChannel = (AbstractNioChannel) attachment;
                        abstractNioChannel.unsafe().close(abstractNioChannel.unsafe().voidPromise());
                    } else {
                        invokeChannelUnregistered((NioTask) attachment, selectionKey, e);
                    }
                }
            }
            this.selector = openSelector.selector;
            this.unwrappedSelector = openSelector.unwrappedSelector;
            try {
                selector.close();
            } catch (Throwable th) {
                if (logger.isWarnEnabled()) {
                    logger.warn("Failed to close the old Selector.", th);
                }
            }
            logger.info("Migrated " + i + " channel(s) to the new Selector.");
        } catch (Exception e2) {
            logger.warn("Failed to create a new Selector.", (Throwable) e2);
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(13:4|5|(1:7)(2:43|(1:45))|8|9|(8:36|37|38|15|16|18|(3:20|21|(2:23|24)(1:26))(1:28)|27)(9:11|12|13|14|15|16|18|(0)(0)|27)|47|48|15|16|18|(0)(0)|27) */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x007a, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x007b, code lost:
    
        handleLoopException(r0);
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0070 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0000 A[SYNTHETIC] */
    @Override // io.netty.util.concurrent.SingleThreadEventExecutor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void run() {
        /*
            r6 = this;
        L0:
            io.netty.channel.SelectStrategy r0 = r6.selectStrategy     // Catch: java.lang.Throwable -> L66
            io.netty.util.IntSupplier r1 = r6.selectNowSupplier     // Catch: java.lang.Throwable -> L66
            boolean r2 = r6.hasTasks()     // Catch: java.lang.Throwable -> L66
            int r0 = r0.calculateStrategy(r1, r2)     // Catch: java.lang.Throwable -> L66
            r1 = -2
            if (r0 == r1) goto L0
            r1 = -1
            r2 = 0
            if (r0 == r1) goto L14
            goto L2a
        L14:
            java.util.concurrent.atomic.AtomicBoolean r0 = r6.wakenUp     // Catch: java.lang.Throwable -> L66
            boolean r0 = r0.getAndSet(r2)     // Catch: java.lang.Throwable -> L66
            r6.select(r0)     // Catch: java.lang.Throwable -> L66
            java.util.concurrent.atomic.AtomicBoolean r0 = r6.wakenUp     // Catch: java.lang.Throwable -> L66
            boolean r0 = r0.get()     // Catch: java.lang.Throwable -> L66
            if (r0 == 0) goto L2a
            java.nio.channels.Selector r0 = r6.selector     // Catch: java.lang.Throwable -> L66
            r0.wakeup()     // Catch: java.lang.Throwable -> L66
        L2a:
            r6.cancelledKeys = r2     // Catch: java.lang.Throwable -> L66
            r6.needsToSelectAgain = r2     // Catch: java.lang.Throwable -> L66
            int r0 = r6.ioRatio     // Catch: java.lang.Throwable -> L66
            r1 = 100
            if (r0 != r1) goto L40
            r6.processSelectedKeys()     // Catch: java.lang.Throwable -> L3b
            r6.runAllTasks()     // Catch: java.lang.Throwable -> L66
            goto L6a
        L3b:
            r0 = move-exception
            r6.runAllTasks()     // Catch: java.lang.Throwable -> L66
            throw r0     // Catch: java.lang.Throwable -> L66
        L40:
            long r1 = java.lang.System.nanoTime()     // Catch: java.lang.Throwable -> L66
            r6.processSelectedKeys()     // Catch: java.lang.Throwable -> L56
            long r3 = java.lang.System.nanoTime()     // Catch: java.lang.Throwable -> L66
            long r3 = r3 - r1
            int r1 = 100 - r0
            long r1 = (long) r1     // Catch: java.lang.Throwable -> L66
            long r3 = r3 * r1
            long r0 = (long) r0     // Catch: java.lang.Throwable -> L66
            long r3 = r3 / r0
            r6.runAllTasks(r3)     // Catch: java.lang.Throwable -> L66
            goto L6a
        L56:
            r3 = move-exception
            long r4 = java.lang.System.nanoTime()     // Catch: java.lang.Throwable -> L66
            long r4 = r4 - r1
            int r1 = 100 - r0
            long r1 = (long) r1     // Catch: java.lang.Throwable -> L66
            long r4 = r4 * r1
            long r0 = (long) r0     // Catch: java.lang.Throwable -> L66
            long r4 = r4 / r0
            r6.runAllTasks(r4)     // Catch: java.lang.Throwable -> L66
            throw r3     // Catch: java.lang.Throwable -> L66
        L66:
            r0 = move-exception
            handleLoopException(r0)
        L6a:
            boolean r0 = r6.isShuttingDown()     // Catch: java.lang.Throwable -> L7a
            if (r0 == 0) goto L0
            r6.closeAll()     // Catch: java.lang.Throwable -> L7a
            boolean r0 = r6.confirmShutdown()     // Catch: java.lang.Throwable -> L7a
            if (r0 == 0) goto L0
            return
        L7a:
            r0 = move-exception
            handleLoopException(r0)
            goto L0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.channel.nio.NioEventLoop.run():void");
    }

    private static void handleLoopException(Throwable th) {
        logger.warn("Unexpected exception in the selector loop.", th);
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException unused) {
        }
    }

    private void processSelectedKeys() {
        if (this.selectedKeys != null) {
            processSelectedKeysOptimized();
        } else {
            processSelectedKeysPlain(this.selector.selectedKeys());
        }
    }

    @Override // io.netty.util.concurrent.SingleThreadEventExecutor
    protected void cleanup() {
        try {
            this.selector.close();
        } catch (IOException e) {
            logger.warn("Failed to close a selector.", (Throwable) e);
        }
    }

    void cancel(SelectionKey selectionKey) {
        selectionKey.cancel();
        int i = this.cancelledKeys + 1;
        this.cancelledKeys = i;
        if (i >= 256) {
            this.cancelledKeys = 0;
            this.needsToSelectAgain = true;
        }
    }

    @Override // io.netty.util.concurrent.SingleThreadEventExecutor
    protected Runnable pollTask() {
        Runnable pollTask = super.pollTask();
        if (this.needsToSelectAgain) {
            selectAgain();
        }
        return pollTask;
    }

    private void processSelectedKeysPlain(Set<SelectionKey> set) {
        if (set.isEmpty()) {
            return;
        }
        Iterator<SelectionKey> it = set.iterator();
        while (true) {
            SelectionKey next = it.next();
            Object attachment = next.attachment();
            it.remove();
            if (attachment instanceof AbstractNioChannel) {
                processSelectedKey(next, (AbstractNioChannel) attachment);
            } else {
                processSelectedKey(next, (NioTask<SelectableChannel>) attachment);
            }
            if (!it.hasNext()) {
                return;
            }
            if (this.needsToSelectAgain) {
                selectAgain();
                Set<SelectionKey> selectedKeys = this.selector.selectedKeys();
                if (selectedKeys.isEmpty()) {
                    return;
                } else {
                    it = selectedKeys.iterator();
                }
            }
        }
    }

    private void processSelectedKeysOptimized() {
        int i = 0;
        while (i < this.selectedKeys.size) {
            SelectionKey selectionKey = this.selectedKeys.keys[i];
            this.selectedKeys.keys[i] = null;
            Object attachment = selectionKey.attachment();
            if (attachment instanceof AbstractNioChannel) {
                processSelectedKey(selectionKey, (AbstractNioChannel) attachment);
            } else {
                processSelectedKey(selectionKey, (NioTask<SelectableChannel>) attachment);
            }
            if (this.needsToSelectAgain) {
                this.selectedKeys.reset(i + 1);
                selectAgain();
                i = -1;
            }
            i++;
        }
    }

    private void processSelectedKey(SelectionKey selectionKey, AbstractNioChannel abstractNioChannel) {
        AbstractNioChannel.NioUnsafe unsafe = abstractNioChannel.unsafe();
        if (!selectionKey.isValid()) {
            try {
                NioEventLoop eventLoop = abstractNioChannel.eventLoop();
                if (eventLoop != this || eventLoop == null) {
                    return;
                }
                unsafe.close(unsafe.voidPromise());
                return;
            } catch (Throwable unused) {
                return;
            }
        }
        try {
            int readyOps = selectionKey.readyOps();
            if ((readyOps & 8) != 0) {
                selectionKey.interestOps(selectionKey.interestOps() & (-9));
                unsafe.finishConnect();
            }
            if ((readyOps & 4) != 0) {
                abstractNioChannel.unsafe().forceFlush();
            }
            if ((readyOps & 17) != 0 || readyOps == 0) {
                unsafe.read();
            }
        } catch (CancelledKeyException unused2) {
            unsafe.close(unsafe.voidPromise());
        }
    }

    private static void processSelectedKey(SelectionKey selectionKey, NioTask<SelectableChannel> nioTask) {
        try {
            try {
                nioTask.channelReady(selectionKey.channel(), selectionKey);
                if (!selectionKey.isValid()) {
                    invokeChannelUnregistered(nioTask, selectionKey, null);
                }
            } catch (Exception e) {
                selectionKey.cancel();
                invokeChannelUnregistered(nioTask, selectionKey, e);
            }
        } catch (Throwable th) {
            selectionKey.cancel();
            invokeChannelUnregistered(nioTask, selectionKey, null);
            throw th;
        }
    }

    private void closeAll() {
        selectAgain();
        Set<SelectionKey> keys = this.selector.keys();
        ArrayList<AbstractNioChannel> arrayList = new ArrayList(keys.size());
        for (SelectionKey selectionKey : keys) {
            Object attachment = selectionKey.attachment();
            if (attachment instanceof AbstractNioChannel) {
                arrayList.add((AbstractNioChannel) attachment);
            } else {
                selectionKey.cancel();
                invokeChannelUnregistered((NioTask) attachment, selectionKey, null);
            }
        }
        for (AbstractNioChannel abstractNioChannel : arrayList) {
            abstractNioChannel.unsafe().close(abstractNioChannel.unsafe().voidPromise());
        }
    }

    private static void invokeChannelUnregistered(NioTask<SelectableChannel> nioTask, SelectionKey selectionKey, Throwable th) {
        try {
            nioTask.channelUnregistered(selectionKey.channel(), th);
        } catch (Exception e) {
            logger.warn("Unexpected exception while running NioTask.channelUnregistered()", (Throwable) e);
        }
    }

    @Override // io.netty.util.concurrent.SingleThreadEventExecutor
    protected void wakeup(boolean z) {
        if (z || !this.wakenUp.compareAndSet(false, true)) {
            return;
        }
        this.selector.wakeup();
    }

    Selector unwrappedSelector() {
        return this.unwrappedSelector;
    }

    int selectNow() throws IOException {
        try {
            return this.selector.selectNow();
        } finally {
            if (this.wakenUp.get()) {
                this.selector.wakeup();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0023, code lost:
    
        r6 = 1;
     */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:64:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void select(boolean r14) throws java.io.IOException {
        /*
            r13 = this;
            java.nio.channels.Selector r0 = r13.selector
            long r1 = java.lang.System.nanoTime()     // Catch: java.nio.channels.CancelledKeyException -> Lb0
            long r3 = r13.delayNanos(r1)     // Catch: java.nio.channels.CancelledKeyException -> Lb0
            long r3 = r3 + r1
            r5 = 0
            r6 = r5
        Ld:
            long r7 = r3 - r1
            r9 = 500000(0x7a120, double:2.47033E-318)
            long r7 = r7 + r9
            r9 = 1000000(0xf4240, double:4.940656E-318)
            long r7 = r7 / r9
            r9 = 0
            int r9 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            r10 = 1
            if (r9 > 0) goto L26
            if (r6 != 0) goto L9a
            r0.selectNow()     // Catch: java.nio.channels.CancelledKeyException -> Lb0
        L23:
            r6 = r10
            goto L9a
        L26:
            boolean r9 = r13.hasTasks()     // Catch: java.nio.channels.CancelledKeyException -> Lb0
            if (r9 == 0) goto L38
            java.util.concurrent.atomic.AtomicBoolean r9 = r13.wakenUp     // Catch: java.nio.channels.CancelledKeyException -> Lb0
            boolean r9 = r9.compareAndSet(r5, r10)     // Catch: java.nio.channels.CancelledKeyException -> Lb0
            if (r9 == 0) goto L38
            r0.selectNow()     // Catch: java.nio.channels.CancelledKeyException -> Lb0
            goto L23
        L38:
            int r9 = r0.select(r7)     // Catch: java.nio.channels.CancelledKeyException -> Lb0
            int r6 = r6 + 1
            if (r9 != 0) goto L9a
            if (r14 != 0) goto L9a
            java.util.concurrent.atomic.AtomicBoolean r9 = r13.wakenUp     // Catch: java.nio.channels.CancelledKeyException -> Lb0
            boolean r9 = r9.get()     // Catch: java.nio.channels.CancelledKeyException -> Lb0
            if (r9 != 0) goto L9a
            boolean r9 = r13.hasTasks()     // Catch: java.nio.channels.CancelledKeyException -> Lb0
            if (r9 != 0) goto L9a
            boolean r9 = r13.hasScheduledTasks()     // Catch: java.nio.channels.CancelledKeyException -> Lb0
            if (r9 == 0) goto L57
            goto L9a
        L57:
            boolean r9 = java.lang.Thread.interrupted()     // Catch: java.nio.channels.CancelledKeyException -> Lb0
            if (r9 == 0) goto L6b
            io.netty.util.internal.logging.InternalLogger r14 = io.netty.channel.nio.NioEventLoop.logger     // Catch: java.nio.channels.CancelledKeyException -> Lb0
            boolean r1 = r14.isDebugEnabled()     // Catch: java.nio.channels.CancelledKeyException -> Lb0
            if (r1 == 0) goto L23
            java.lang.String r1 = "Selector.select() returned prematurely because Thread.currentThread().interrupt() was called. Use NioEventLoop.shutdownGracefully() to shutdown the NioEventLoop."
            r14.debug(r1)     // Catch: java.nio.channels.CancelledKeyException -> Lb0
            goto L23
        L6b:
            long r11 = java.lang.System.nanoTime()     // Catch: java.nio.channels.CancelledKeyException -> Lb0
            java.util.concurrent.TimeUnit r9 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch: java.nio.channels.CancelledKeyException -> Lb0
            long r7 = r9.toNanos(r7)     // Catch: java.nio.channels.CancelledKeyException -> Lb0
            long r7 = r11 - r7
            int r1 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            if (r1 < 0) goto L7d
            r6 = r10
            goto L97
        L7d:
            int r1 = io.netty.channel.nio.NioEventLoop.SELECTOR_AUTO_REBUILD_THRESHOLD     // Catch: java.nio.channels.CancelledKeyException -> Lb0
            if (r1 <= 0) goto L97
            if (r6 < r1) goto L97
            io.netty.util.internal.logging.InternalLogger r14 = io.netty.channel.nio.NioEventLoop.logger     // Catch: java.nio.channels.CancelledKeyException -> Lb0
            java.lang.String r1 = "Selector.select() returned prematurely {} times in a row; rebuilding Selector {}."
            java.lang.Integer r2 = java.lang.Integer.valueOf(r6)     // Catch: java.nio.channels.CancelledKeyException -> Lb0
            r14.warn(r1, r2, r0)     // Catch: java.nio.channels.CancelledKeyException -> Lb0
            r13.rebuildSelector()     // Catch: java.nio.channels.CancelledKeyException -> Lb0
            java.nio.channels.Selector r0 = r13.selector     // Catch: java.nio.channels.CancelledKeyException -> Lb0
            r0.selectNow()     // Catch: java.nio.channels.CancelledKeyException -> Lb0
            goto L23
        L97:
            r1 = r11
            goto Ld
        L9a:
            r14 = 3
            if (r6 <= r14) goto Ld5
            io.netty.util.internal.logging.InternalLogger r14 = io.netty.channel.nio.NioEventLoop.logger     // Catch: java.nio.channels.CancelledKeyException -> Lb0
            boolean r1 = r14.isDebugEnabled()     // Catch: java.nio.channels.CancelledKeyException -> Lb0
            if (r1 == 0) goto Ld5
            java.lang.String r1 = "Selector.select() returned prematurely {} times in a row for Selector {}."
            int r6 = r6 - r10
            java.lang.Integer r2 = java.lang.Integer.valueOf(r6)     // Catch: java.nio.channels.CancelledKeyException -> Lb0
            r14.debug(r1, r2, r0)     // Catch: java.nio.channels.CancelledKeyException -> Lb0
            goto Ld5
        Lb0:
            r14 = move-exception
            io.netty.util.internal.logging.InternalLogger r1 = io.netty.channel.nio.NioEventLoop.logger
            boolean r2 = r1.isDebugEnabled()
            if (r2 == 0) goto Ld5
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.Class<java.nio.channels.CancelledKeyException> r3 = java.nio.channels.CancelledKeyException.class
            java.lang.String r3 = r3.getSimpleName()
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r3 = " raised by a Selector {} - JDK bug?"
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.debug(r2, r0, r14)
        Ld5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.channel.nio.NioEventLoop.select(boolean):void");
    }

    private void selectAgain() {
        this.needsToSelectAgain = false;
        try {
            this.selector.selectNow();
        } catch (Throwable th) {
            logger.warn("Failed to update SelectionKeys.", th);
        }
    }
}
