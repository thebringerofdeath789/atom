package com.ipotensic.baselib.mediadataretriever.callback;

import com.ipotensic.baselib.mediadataretriever.entity.LoadTask;
import com.ipotensic.baselib.mediadataretriever.inter.OnMediaRetrieverLoadListener;

/* loaded from: classes2.dex */
public class BaseLoadCallback implements Runnable {
    protected LoadTask mTask;

    @Override // java.lang.Runnable
    public void run() {
    }

    public BaseLoadCallback(LoadTask loadTask) {
        this.mTask = loadTask;
    }

    protected OnMediaRetrieverLoadListener getMediaRetrieverLoadListener() {
        return this.mTask.getOnMediaRetrieverLoadListener();
    }
}