package com.ipotensic.baselib.mediadataretriever.core;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.ipotensic.baselib.mediadataretriever.cache.CacheManager;
import com.ipotensic.baselib.mediadataretriever.callback.LoadFailureCallback;
import com.ipotensic.baselib.mediadataretriever.callback.LoadStartCallback;
import com.ipotensic.baselib.mediadataretriever.callback.LoadSuccessFrameCallback;
import com.ipotensic.baselib.mediadataretriever.callback.LoadSuccessMetaDataCallback;
import com.ipotensic.baselib.mediadataretriever.core.MediaMetadataRetrieverLoaderManager;
import com.ipotensic.baselib.mediadataretriever.entity.LoadTask;
import com.ipotensic.baselib.mediadataretriever.entity.MediaData;
import com.ipotensic.baselib.mediadataretriever.entity.MetadataKey;
import com.ipotensic.baselib.mediadataretriever.utils.Utils;
import com.p020kk.taurus.threadpool.DefaultThreadManager;
import com.p020kk.taurus.threadpool.ExecutorSetting;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class MediaDataRetrieverTaskLoader {
    private static final int MSG_CODE_CHECK_TASK = 1;
    private static final String TAG = "TaskLoader";
    private static boolean hasInitDispatchThread;
    private static MyHandler mHandler;
    private static Semaphore mThreadSemaphore;
    private static Handler mCallBackHandler = new Handler(Looper.getMainLooper());
    private static int processorsNumber = Runtime.getRuntime().availableProcessors();
    private static LinkedList<LoadTask> mTaskQueue = new LinkedList<>();

    public interface OnInitListener {
        void onInited();
    }

    static {
        ExecutorSetting executorSetting = new ExecutorSetting();
        executorSetting.setCorePoolSize(processorsNumber + 1);
        executorSetting.setMaximumPoolSize(20);
        executorSetting.setKeepAliveTime(30L);
        executorSetting.setUnit(TimeUnit.SECONDS);
        DefaultThreadManager.getInstance(executorSetting);
    }

    public static MediaData loadMediaData(LoadTask loadTask, boolean z, MediaMetadataRetrieverLoaderManager.OnLoadListener onLoadListener) {
        return MediaMetadataRetrieverLoaderManager.get().getMediaData(loadTask.generatorMediaTask(z), onLoadListener);
    }

    public static void load(final LoadTask loadTask) {
        if (mThreadSemaphore == null) {
            mThreadSemaphore = new Semaphore(processorsNumber + 1);
            Log.d(TAG, "ThreadSemaphore **init** availablePermits = " + mThreadSemaphore.availablePermits());
        }
        callBackOnLoadStart(loadTask);
        if (!hasInitDispatchThread) {
            initDispatchThread(new OnInitListener() { // from class: com.ipotensic.baselib.mediadataretriever.core.MediaDataRetrieverTaskLoader.1
                @Override // com.ipotensic.baselib.mediadataretriever.core.MediaDataRetrieverTaskLoader.OnInitListener
                public void onInited() {
                    MediaDataRetrieverTaskLoader.dispatchTaskLogic(LoadTask.this);
                }
            });
        } else {
            dispatchTaskLogic(loadTask);
        }
    }

    private static void notifyPollTask() {
        mHandler.sendEmptyMessage(1);
    }

    private static void addQueue(LoadTask loadTask) {
        mTaskQueue.add(loadTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void dispatchTaskLogic(LoadTask loadTask) {
        Bitmap lruCache = CacheManager.getInstance().getLruCache(loadTask.getDataSource());
        if (lruCache != null) {
            callBackOnFrameGet(loadTask, lruCache);
            loadTask.setNeedLoadFrame(false);
            if (!loadTask.isNeedLoadMetaData()) {
                return;
            }
        }
        addQueue(loadTask);
        notifyPollTask();
    }

    private static void notifyLoad(LoadTask loadTask) {
        semaphoreAcquire();
        DefaultThreadManager.getInstance().execute(new TaskRunnable(loadTask) { // from class: com.ipotensic.baselib.mediadataretriever.core.MediaDataRetrieverTaskLoader.2
            @Override // com.ipotensic.baselib.mediadataretriever.core.MediaDataRetrieverTaskLoader.TaskRunnable, java.lang.Runnable
            public void run() {
                Bitmap diskCache;
                super.run();
                final LoadTask invokeTask = getInvokeTask();
                final String dataSource = invokeTask.getDataSource();
                final int thumbnailType = invokeTask.getThumbnailType();
                if (invokeTask.isNeedLoadFrame() && (diskCache = CacheManager.getInstance().getDiskCache(dataSource)) != null) {
                    Bitmap scaleBitmap = Utils.scaleBitmap(diskCache, thumbnailType);
                    MediaDataRetrieverTaskLoader.callBackOnFrameGet(invokeTask, scaleBitmap);
                    CacheManager.getInstance().putLruCache(dataSource, scaleBitmap);
                    invokeTask.setNeedLoadFrame(false);
                }
                MediaDataRetrieverTaskLoader.loadMediaData(invokeTask, invokeTask.isNeedLoadFrame(), new MediaMetadataRetrieverLoaderManager.OnLoadListener() { // from class: com.ipotensic.baselib.mediadataretriever.core.MediaDataRetrieverTaskLoader.2.1
                    @Override // com.ipotensic.baselib.mediadataretriever.core.MediaMetadataRetrieverLoaderManager.OnLoadListener
                    public void onFrameGet(Bitmap bitmap) {
                        if (bitmap == null) {
                            MediaDataRetrieverTaskLoader.callBackOnLoadFailure(invokeTask, 1, "frame load failure!");
                            return;
                        }
                        Bitmap scaleBitmap2 = Utils.scaleBitmap(bitmap, thumbnailType);
                        MediaDataRetrieverTaskLoader.callBackOnFrameGet(invokeTask, scaleBitmap2);
                        CacheManager.getInstance().putLruCache(dataSource, scaleBitmap2);
                        CacheManager.getInstance().putDiskCache(dataSource, scaleBitmap2);
                    }

                    @Override // com.ipotensic.baselib.mediadataretriever.core.MediaMetadataRetrieverLoaderManager.OnLoadListener
                    public void onMetaDataGet(Map<MetadataKey, String> map) {
                        if (map == null || map.size() <= 0) {
                            MediaDataRetrieverTaskLoader.callBackOnLoadFailure(invokeTask, 2, "meta data load failure!");
                        } else {
                            MediaDataRetrieverTaskLoader.callBackOnMetaDataGet(invokeTask, map);
                        }
                    }
                });
                MediaDataRetrieverTaskLoader.semaphoreRelease();
            }
        });
    }

    private static void semaphoreAcquire() {
        try {
            mThreadSemaphore.acquire();
            Log.d(TAG, "ThreadSemaphore >>acquire<< availablePermits = " + mThreadSemaphore.availablePermits());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void semaphoreRelease() {
        mThreadSemaphore.release();
        Log.d(TAG, "ThreadSemaphore <<release>> availablePermits = " + mThreadSemaphore.availablePermits());
    }

    private static void callBackOnLoadStart(LoadTask loadTask) {
        mCallBackHandler.post(new LoadStartCallback(loadTask));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void callBackOnFrameGet(LoadTask loadTask, Bitmap bitmap) {
        Log.d(TAG, "callback onFrame get : " + loadTask.getDataSource());
        mCallBackHandler.post(new LoadSuccessFrameCallback(loadTask, bitmap));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void callBackOnMetaDataGet(LoadTask loadTask, Map<MetadataKey, String> map) {
        mCallBackHandler.post(new LoadSuccessMetaDataCallback(loadTask, map));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void callBackOnLoadFailure(LoadTask loadTask, int i, String str) {
        mCallBackHandler.post(new LoadFailureCallback(loadTask, i, str));
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [com.ipotensic.baselib.mediadataretriever.core.MediaDataRetrieverTaskLoader$3] */
    private static synchronized void initDispatchThread(final OnInitListener onInitListener) {
        synchronized (MediaDataRetrieverTaskLoader.class) {
            new Thread() { // from class: com.ipotensic.baselib.mediadataretriever.core.MediaDataRetrieverTaskLoader.3
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    super.run();
                    Looper.prepare();
                    MyHandler unused = MediaDataRetrieverTaskLoader.mHandler = new MyHandler() { // from class: com.ipotensic.baselib.mediadataretriever.core.MediaDataRetrieverTaskLoader.3.1
                        @Override // com.ipotensic.baselib.mediadataretriever.core.MediaDataRetrieverTaskLoader.MyHandler, android.os.Handler
                        public void handleMessage(Message message) {
                            super.handleMessage(message);
                            if (message.what != 1) {
                                return;
                            }
                            MediaDataRetrieverTaskLoader.pollTask();
                        }
                    };
                    boolean unused2 = MediaDataRetrieverTaskLoader.hasInitDispatchThread = true;
                    OnInitListener.this.onInited();
                    Looper.loop();
                }
            }.start();
        }
    }

    private static int getAvailablePermits() {
        return mThreadSemaphore.availablePermits();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void pollTask() {
        LoadTask pollFirst;
        synchronized (MediaDataRetrieverTaskLoader.class) {
            Log.d(TAG, "=====TaskQueue size = " + mTaskQueue.size());
            if (getAvailablePermits() <= 0) {
                pollFirst = mTaskQueue.pollLast();
                Log.d(TAG, "---> TaskQueue poll <<LAST>>");
            } else {
                pollFirst = mTaskQueue.pollFirst();
                Log.d(TAG, "---> TaskQueue poll <<FIRST>>");
            }
            if (pollFirst == null) {
                return;
            }
            notifyLoad(pollFirst);
        }
    }

    private static class MyHandler extends Handler {
        private MyHandler() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
        }
    }

    public static class TaskRunnable implements Runnable {
        private LoadTask invokeTask;

        @Override // java.lang.Runnable
        public void run() {
        }

        public TaskRunnable(LoadTask loadTask) {
            this.invokeTask = loadTask;
        }

        public LoadTask getInvokeTask() {
            return this.invokeTask;
        }
    }
}