package com.kk.taurus.threadpool;

import android.util.Log;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class DefaultPoolExecutor extends ThreadPoolExecutor {
    private static final int CPU_COUNT;
    public static final int INIT_THREAD_COUNT;
    public static final int MAX_THREAD_COUNT = 20;
    public static final long SURPLUS_THREAD_LIFE = 30;
    private static final String TAG = "_DefaultPoolExecutor";
    private static DefaultPoolExecutor instance;

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        CPU_COUNT = availableProcessors;
        INIT_THREAD_COUNT = availableProcessors + 1;
    }

    public static DefaultPoolExecutor getInstance() {
        if (instance == null) {
            synchronized (DefaultPoolExecutor.class) {
                if (instance == null) {
                    instance = new DefaultPoolExecutor(INIT_THREAD_COUNT, 20, 30L, TimeUnit.SECONDS, new SynchronousQueue(), new DefaultThreadFactory());
                }
            }
        }
        return instance;
    }

    public static DefaultPoolExecutor getInstance(int i, int i2, long j, TimeUnit timeUnit) {
        if (instance == null) {
            synchronized (DefaultPoolExecutor.class) {
                if (instance == null) {
                    instance = new DefaultPoolExecutor(i, i2, j, timeUnit, new SynchronousQueue(), new DefaultThreadFactory());
                }
            }
        }
        return instance;
    }

    private DefaultPoolExecutor(int i, int i2, long j, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory) {
        super(i, i2, j, timeUnit, blockingQueue, threadFactory);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    protected void afterExecute(Runnable runnable, Throwable th) {
        super.afterExecute(runnable, th);
        if (th == null && (runnable instanceof Future)) {
            try {
                ((Future) runnable).get();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            } catch (CancellationException e) {
                th = e;
            } catch (ExecutionException e2) {
                th = e2.getCause();
            }
        }
        if (th != null) {
            Log.w(TAG, "Running task appeared exception! Thread [" + Thread.currentThread().getName() + "], because [" + th.getMessage() + "]\n" + TextUtils.formatStackTrace(th.getStackTrace()));
        }
    }
}
