package xyz.doikki.videoplayer.controller;

/* loaded from: classes6.dex */
public interface IVideoController {
    int getCutoutHeight();

    boolean hasCutout();

    void hide();

    boolean isLocked();

    boolean isShowing();

    void setLocked(boolean z);

    void show();

    void startFadeOut();

    void startProgress();

    void stopFadeOut();

    void stopProgress();
}
