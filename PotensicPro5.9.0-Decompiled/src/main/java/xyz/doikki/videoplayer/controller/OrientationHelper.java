package xyz.doikki.videoplayer.controller;

import android.content.Context;
import android.view.OrientationEventListener;

/* loaded from: classes6.dex */
public class OrientationHelper extends OrientationEventListener {
    private long mLastTime;
    private OnOrientationChangeListener mOnOrientationChangeListener;

    public interface OnOrientationChangeListener {
        void onOrientationChanged(int i);
    }

    public OrientationHelper(Context context) {
        super(context);
    }

    @Override // android.view.OrientationEventListener
    public void onOrientationChanged(int i) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.mLastTime < 300) {
            return;
        }
        OnOrientationChangeListener onOrientationChangeListener = this.mOnOrientationChangeListener;
        if (onOrientationChangeListener != null) {
            onOrientationChangeListener.onOrientationChanged(i);
        }
        this.mLastTime = currentTimeMillis;
    }

    public void setOnOrientationChangeListener(OnOrientationChangeListener onOrientationChangeListener) {
        this.mOnOrientationChangeListener = onOrientationChangeListener;
    }
}
