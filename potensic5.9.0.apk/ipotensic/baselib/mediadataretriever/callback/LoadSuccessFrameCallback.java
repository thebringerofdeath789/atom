package com.ipotensic.baselib.mediadataretriever.callback;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.widget.ImageView;
import com.ipotensic.baselib.mediadataretriever.entity.LoadTask;
import com.ipotensic.baselib.mediadataretriever.inter.OnMediaRetrieverLoadListener;

/* loaded from: classes2.dex */
public class LoadSuccessFrameCallback extends BaseLoadCallback {
    private Bitmap bitmap;

    public LoadSuccessFrameCallback(LoadTask loadTask, Bitmap bitmap) {
        super(loadTask);
        this.bitmap = bitmap;
    }

    @Override // com.ipotensic.baselib.mediadataretriever.callback.BaseLoadCallback, java.lang.Runnable
    public void run() {
        View targetView = this.mTask.getTargetView();
        if ((targetView instanceof ImageView) && this.mTask.isLegalTag()) {
            ImageView imageView = (ImageView) targetView;
            imageView.setImageDrawable(new BitmapDrawable(imageView.getContext().getResources(), this.bitmap));
        }
        OnMediaRetrieverLoadListener mediaRetrieverLoadListener = getMediaRetrieverLoadListener();
        if (mediaRetrieverLoadListener != null) {
            mediaRetrieverLoadListener.onFrameGet(this.bitmap);
        }
    }
}