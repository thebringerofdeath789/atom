package com.ipotensic.baselib.notchtools.helper;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.SystemClock;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/* loaded from: classes2.dex */
public class ThreadUtils {
    private static Handler sLogicThreadHandler;
    private static Handler sMainHandler;
    private static final Object sLock = new Object();
    private static final Object sLogicThreadHandlerLock = new Object();
    private static final Executor EXECUTOR = Executors.newFixedThreadPool(4, new ThreadFactory() { // from class: com.ipotensic.baselib.notchtools.helper.ThreadUtils.2
        private int count = -1;

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            this.count++;
            return new Thread(runnable, "ThreadUtils: " + this.count);
        }
    });

    public interface Consumer<T> {
        void consume(T t);
    }

    public interface Provider<T> {
        T provide();
    }

    private static Handler getUIThreadHandler() {
        Handler handler;
        synchronized (sLock) {
            if (sMainHandler == null) {
                sMainHandler = new Handler(Looper.getMainLooper());
            }
            handler = sMainHandler;
        }
        return handler;
    }

    public static boolean isMainThread() {
        return Thread.currentThread().getId() == Looper.getMainLooper().getThread().getId();
    }

    public static boolean post2UI(Runnable runnable) {
        return getUIThreadHandler().post(runnable);
    }

    public static boolean post2UI(Context context, Runnable runnable) {
        if (context == null) {
            return post2UI(runnable);
        }
        return getUIThreadHandler().postAtTime(runnable, Integer.valueOf(context.hashCode()), SystemClock.uptimeMillis());
    }

    public static boolean postDelayed2UI(Runnable runnable, long j) {
        return getUIThreadHandler().postDelayed(runnable, j);
    }

    public static boolean postDelayed2UI(Context context, Runnable runnable, long j) {
        if (context == null) {
            return postDelayed2UI(runnable, j);
        }
        return getUIThreadHandler().postAtTime(runnable, Integer.valueOf(context.hashCode()), SystemClock.uptimeMillis() + j);
    }

    public static void cancelUITask(Runnable runnable) {
        getUIThreadHandler().removeCallbacks(runnable);
    }

    public static void cancelUITask(Context context) {
        if (context != null) {
            getUIThreadHandler().removeCallbacksAndMessages(Integer.valueOf(context.hashCode()));
        }
    }

    private static boolean runningOnUI() {
        return getUIThreadHandler().getLooper() == Looper.myLooper();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Handler getLogicThreadHandler() {
        Handler handler;
        synchronized (sLogicThreadHandlerLock) {
            if (sLogicThreadHandler == null) {
                HandlerThread handlerThread = new HandlerThread("daemon-handler-thread");
                handlerThread.start();
                sLogicThreadHandler = new Handler(handlerThread.getLooper());
            }
            handler = sLogicThreadHandler;
        }
        return handler;
    }

    public static boolean post2Logic(Runnable runnable) {
        return getLogicThreadHandler().post(runnable);
    }

    public static boolean post2Logic(Context context, Runnable runnable) {
        if (context == null) {
            return post2Logic(runnable);
        }
        return getLogicThreadHandler().postAtTime(runnable, Integer.valueOf(context.hashCode()), SystemClock.uptimeMillis());
    }

    private static boolean postDelayed2Logic(Runnable runnable, long j) {
        return getLogicThreadHandler().postDelayed(runnable, j);
    }

    public static boolean postDelayed2Logic(Context context, Runnable runnable, long j) {
        if (context == null) {
            return postDelayed2Logic(runnable, j);
        }
        return getLogicThreadHandler().postAtTime(runnable, Integer.valueOf(context.hashCode()), SystemClock.uptimeMillis() + j);
    }

    public static void cancelLogicTask(Runnable runnable) {
        getLogicThreadHandler().removeCallbacks(runnable);
    }

    public static void cancelLogicTask(Context context) {
        if (context != null) {
            getLogicThreadHandler().removeCallbacksAndMessages(Integer.valueOf(context.hashCode()));
        }
    }

    public static void delayCancelLogicTask(Context context, long j) {
        if (context != null) {
            final Integer valueOf = Integer.valueOf(context.hashCode());
            postDelayed2Logic(new Runnable() { // from class: com.ipotensic.baselib.notchtools.helper.ThreadUtils.1
                @Override // java.lang.Runnable
                public void run() {
                    ThreadUtils.getLogicThreadHandler().removeCallbacksAndMessages(valueOf);
                }
            }, j);
        }
    }

    public static boolean runningOnLogic() {
        return getLogicThreadHandler().getLooper() == Looper.myLooper();
    }

    public static void safeCheckUIThread(String str) {
        if (!runningOnUI()) {
            throw new RuntimeException("ThreadUtils safeCheck alert " + str);
        }
    }

    public static String getThreadName() {
        return Thread.currentThread().getName() + " : " + Thread.currentThread().getId();
    }

    public static void exec(Runnable runnable) {
        if (runnable != null) {
            try {
                EXECUTOR.execute(runnable);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static <T> void exec(final Provider<T> provider, final Consumer<T> consumer) {
        if (provider == null) {
            return;
        }
        EXECUTOR.execute(new Runnable() { // from class: com.ipotensic.baselib.notchtools.helper.ThreadUtils.3
            @Override // java.lang.Runnable
            public void run() {
                final Object obj;
                try {
                    obj = Provider.this.provide();
                } catch (Throwable th) {
                    th.printStackTrace();
                    obj = null;
                }
                if (consumer == null) {
                    return;
                }
                ThreadUtils.post2UI(new Runnable() { // from class: com.ipotensic.baselib.notchtools.helper.ThreadUtils.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            consumer.consume(obj);
                        } catch (Throwable th2) {
                            th2.printStackTrace();
                        }
                    }
                });
            }
        });
    }
}