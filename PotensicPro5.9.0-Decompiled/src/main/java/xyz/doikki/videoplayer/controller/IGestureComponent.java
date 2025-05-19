package xyz.doikki.videoplayer.controller;

/* loaded from: classes6.dex */
public interface IGestureComponent extends IControlComponent {
    void onBrightnessChange(int i);

    void onPositionChange(int i, int i2, int i3);

    void onStartSlide();

    void onStopSlide();

    void onVolumeChange(int i);
}
