package com.ipotensic.kernel.view;

import com.ipotensic.kernel.activitys.GalleryActivity;

/* loaded from: classes2.dex */
public abstract class NoShakeListener implements GalleryActivity.OnItemClickListener {
    private long mLastClickTime = 0;

    protected void onFastClick(int i) {
    }

    protected abstract void onSingleClick(int i);

    private boolean isFastDoubleClick() {
        long currentTimeMillis = System.currentTimeMillis();
        if (Math.abs(currentTimeMillis - this.mLastClickTime) < 1000) {
            return true;
        }
        this.mLastClickTime = currentTimeMillis;
        return false;
    }

    @Override // com.ipotensic.kernel.activitys.GalleryActivity.OnItemClickListener
    public void onItemClicked(int i) {
        if (isFastDoubleClick()) {
            onFastClick(i);
        } else {
            onSingleClick(i);
        }
    }
}