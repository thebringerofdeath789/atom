package com.p020kk.taurus.threadpool;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.concurrent.ThreadPoolExecutor;

/* loaded from: classes2.dex */
public abstract class TaskCallBack<Params, Progress, Result> implements RunnableCallBack<Params, Progress, Result> {
    private DefaultPoolExecutor mDefaultPoolExecutor;
    private final int MSG_CODE_PROGRESS = 1002;
    private final int MSG_CODE_END = 1003;
    private Handler mHandler = new Handler(Looper.getMainLooper()) { // from class: com.kk.taurus.threadpool.TaskCallBack.1
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            int i = message.what;
            if (i == 1002) {
                TaskCallBack.this.onProgressUpdate(message.obj);
            } else {
                if (i != 1003) {
                    return;
                }
                TaskCallBack.this.onPostExecute(message.obj);
            }
        }
    };

    @Override // com.p020kk.taurus.threadpool.RunnableCallBack
    public void onPostExecute(Result result) {
    }

    @Override // com.p020kk.taurus.threadpool.RunnableCallBack
    public void onPreExecute() {
    }

    @Override // com.p020kk.taurus.threadpool.RunnableCallBack
    public void onProgressUpdate(Progress progress) {
    }

    public TaskCallBack() {
        if (this.mDefaultPoolExecutor == null) {
            this.mDefaultPoolExecutor = DefaultPoolExecutor.getInstance();
        }
    }

    @Override // com.p020kk.taurus.threadpool.RunnableCallBack
    public void execute(final Params... paramsArr) {
        onPreExecute();
        this.mDefaultPoolExecutor.execute(new Runnable() { // from class: com.kk.taurus.threadpool.TaskCallBack.2
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                Object doInBackground = TaskCallBack.this.doInBackground(paramsArr);
                Message obtain = Message.obtain();
                obtain.what = 1003;
                obtain.obj = doInBackground;
                TaskCallBack.this.mHandler.sendMessage(obtain);
            }
        });
    }

    @Override // com.p020kk.taurus.threadpool.RunnableCallBack
    public void execute(ThreadPoolExecutor threadPoolExecutor, final Params... paramsArr) {
        onPreExecute();
        threadPoolExecutor.execute(new Runnable() { // from class: com.kk.taurus.threadpool.TaskCallBack.3
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                Object doInBackground = TaskCallBack.this.doInBackground(paramsArr);
                Message obtain = Message.obtain();
                obtain.what = 1003;
                obtain.obj = doInBackground;
                TaskCallBack.this.mHandler.sendMessage(obtain);
            }
        });
    }

    @Override // com.p020kk.taurus.threadpool.RunnableCallBack
    public void publishProgress(Progress progress) {
        Message obtain = Message.obtain();
        obtain.what = 1002;
        obtain.obj = progress;
        this.mHandler.sendMessage(obtain);
    }
}