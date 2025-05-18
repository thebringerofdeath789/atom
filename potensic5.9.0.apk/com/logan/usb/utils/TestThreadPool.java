package com.logan.usb.utils;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public class TestThreadPool {
    private static final int KEEP_ALIVE = 10;
    private static int MAX_POOL_SIZE;
    private static TestThreadPool mInstance;
    private ThreadPoolExecutor mThreadPoolExec;
    BlockingQueue<Runnable> workQueue = new LinkedBlockingQueue();

    public static synchronized void initTestThreadPool() {
        synchronized (TestThreadPool.class) {
            if (mInstance == null) {
                mInstance = new TestThreadPool();
            }
        }
    }

    public static Future<byte[]> post(Callable<byte[]> callable) {
        return mInstance.mThreadPoolExec.submit(callable);
    }

    private TestThreadPool() {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        System.out.println("cpu核心数=" + availableProcessors);
        MAX_POOL_SIZE = availableProcessors + 1;
        this.mThreadPoolExec = new ThreadPoolExecutor(availableProcessors, MAX_POOL_SIZE, 10L, TimeUnit.SECONDS, this.workQueue);
    }

    public static void finish() {
        mInstance.mThreadPoolExec.shutdown();
    }
}