package com.ipotensic.baselib.mediadataretriever.callback;

import android.view.View;
import android.widget.ImageView;
import com.ipotensic.baselib.mediadataretriever.entity.LoadTask;
import com.ipotensic.baselib.mediadataretriever.inter.OnMediaRetrieverLoadListener;

/* loaded from: classes2.dex */
public class LoadStartCallback extends BaseLoadCallback {
    public LoadStartCallback(LoadTask loadTask) {
        super(loadTask);
    }

    @Override // com.ipotensic.baselib.mediadataretriever.callback.BaseLoadCallback, java.lang.Runnable
    public void run() {
        super.run();
        View targetView = this.mTask.getTargetView();
        if (targetView != null && this.mTask.getPlaceHolder() > 0 && this.mTask.isLegalTag() && (targetView instanceof ImageView)) {
            ImageView imageView = (ImageView) targetView;
            imageView.setImageDrawable(targetView.getResources().getDrawable(this.mTask.getPlaceHolder()));
            imageView.refreshDrawableState();
        }
        OnMediaRetrieverLoadListener mediaRetrieverLoadListener = getMediaRetrieverLoadListener();
        if (mediaRetrieverLoadListener == null) {
            return;
        }
        mediaRetrieverLoadListener.onLoadStart();
    }
}