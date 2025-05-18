package com.ipotensic.baselib.mediadataretriever.callback;

import android.view.View;
import android.widget.ImageView;
import com.ipotensic.baselib.mediadataretriever.entity.LoadTask;
import com.ipotensic.baselib.mediadataretriever.inter.OnMediaRetrieverLoadListener;

/* loaded from: classes2.dex */
public class LoadFailureCallback extends BaseLoadCallback {
    private int code;
    private String message;

    public LoadFailureCallback(LoadTask loadTask, int i, String str) {
        super(loadTask);
        this.code = i;
        this.message = str;
    }

    @Override // com.ipotensic.baselib.mediadataretriever.callback.BaseLoadCallback, java.lang.Runnable
    public void run() {
        super.run();
        View targetView = this.mTask.getTargetView();
        if (targetView != null && this.mTask.getErrorHolder() > 0 && this.mTask.isLegalTag() && (targetView instanceof ImageView)) {
            ImageView imageView = (ImageView) targetView;
            imageView.setImageDrawable(targetView.getResources().getDrawable(this.mTask.getErrorHolder()));
            imageView.refreshDrawableState();
        }
        OnMediaRetrieverLoadListener mediaRetrieverLoadListener = getMediaRetrieverLoadListener();
        if (mediaRetrieverLoadListener == null) {
            return;
        }
        mediaRetrieverLoadListener.onLoadFailure(this.code, this.message);
    }
}