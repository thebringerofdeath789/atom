package com.kk.taurus.threadpool;

import android.os.AsyncTask;
import android.os.Build;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
public class TaskExecutor {
    private static final int CORE_POOL_SIZE = 18;
    private static final int KEEP_ALIVE = 1;
    private static final int MAXIMUM_POOL_SIZE = 128;
    private static final TimeUnit TIME_UNIT;
    private static final ThreadPoolExecutor concurrentExecutor;
    private static final BlockingQueue<Runnable> concurrentPoolWorkQueue;
    private static final ThreadFactory concurrentThreadFactory;

    private TaskExecutor() {
    }

    static {
        TimeUnit timeUnit = TimeUnit.SECONDS;
        TIME_UNIT = timeUnit;
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue(10);
        concurrentPoolWorkQueue = linkedBlockingQueue;
        AsyncTaskThreadFactory asyncTaskThreadFactory = new AsyncTaskThreadFactory();
        concurrentThreadFactory = asyncTaskThreadFactory;
        concurrentExecutor = new ThreadPoolExecutor(18, 128, 1, timeUnit, linkedBlockingQueue, asyncTaskThreadFactory);
    }

    public static <Params, Progress, Result> AsyncTask<Params, Progress, Result> executeConcurrently(AsyncTask<Params, Progress, Result> asyncTask, Params... paramsArr) {
        if (Build.VERSION.SDK_INT >= 11) {
            asyncTask.executeOnExecutor(concurrentExecutor, paramsArr);
        } else {
            asyncTask.execute(paramsArr);
        }
        return asyncTask;
    }

    private static class AsyncTaskThreadFactory implements ThreadFactory {
        private final AtomicInteger count;

        private AsyncTaskThreadFactory() {
            this.count = new AtomicInteger(1);
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "AsyncTask #" + this.count.getAndIncrement());
        }
    }
}
