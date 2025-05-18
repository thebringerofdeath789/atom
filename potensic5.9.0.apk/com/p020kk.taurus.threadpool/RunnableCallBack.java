package com.p020kk.taurus.threadpool;

import java.util.concurrent.ThreadPoolExecutor;

/* loaded from: classes2.dex */
public interface RunnableCallBack<Params, Progress, Result> {
    Result doInBackground(Params... paramsArr);

    void execute(ThreadPoolExecutor threadPoolExecutor, Params... paramsArr);

    void execute(Params... paramsArr);

    void onPostExecute(Result result);

    void onPreExecute();

    void onProgressUpdate(Progress progress);

    void publishProgress(Progress progress);
}