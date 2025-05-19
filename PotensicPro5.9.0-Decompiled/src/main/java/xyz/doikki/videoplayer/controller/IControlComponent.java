package xyz.doikki.videoplayer.controller;

import android.view.View;
import android.view.animation.Animation;

/* loaded from: classes6.dex */
public interface IControlComponent {
    void attach(ControlWrapper controlWrapper);

    View getView();

    void onLockStateChanged(boolean z);

    void onPlayStateChanged(int i);

    void onPlayerStateChanged(int i);

    void onVisibilityChanged(boolean z, Animation animation);

    void setProgress(int i, int i2);
}
