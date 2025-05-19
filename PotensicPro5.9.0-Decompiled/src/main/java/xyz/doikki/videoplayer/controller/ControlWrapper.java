package xyz.doikki.videoplayer.controller;

import android.app.Activity;
import android.graphics.Bitmap;

/* loaded from: classes6.dex */
public class ControlWrapper implements MediaPlayerControl, IVideoController {
    private IVideoController mController;
    private MediaPlayerControl mPlayerControl;

    public ControlWrapper(MediaPlayerControl mediaPlayerControl, IVideoController iVideoController) {
        this.mPlayerControl = mediaPlayerControl;
        this.mController = iVideoController;
    }

    @Override // xyz.doikki.videoplayer.controller.MediaPlayerControl
    public void start() {
        this.mPlayerControl.start();
    }

    @Override // xyz.doikki.videoplayer.controller.MediaPlayerControl
    public void pause() {
        this.mPlayerControl.pause();
    }

    @Override // xyz.doikki.videoplayer.controller.MediaPlayerControl
    public long getDuration() {
        return this.mPlayerControl.getDuration();
    }

    @Override // xyz.doikki.videoplayer.controller.MediaPlayerControl
    public long getCurrentPosition() {
        return this.mPlayerControl.getCurrentPosition();
    }

    @Override // xyz.doikki.videoplayer.controller.MediaPlayerControl
    public void seekTo(long j) {
        this.mPlayerControl.seekTo(j);
    }

    @Override // xyz.doikki.videoplayer.controller.MediaPlayerControl
    public boolean isPlaying() {
        return this.mPlayerControl.isPlaying();
    }

    @Override // xyz.doikki.videoplayer.controller.MediaPlayerControl
    public int getBufferedPercentage() {
        return this.mPlayerControl.getBufferedPercentage();
    }

    @Override // xyz.doikki.videoplayer.controller.MediaPlayerControl
    public void startFullScreen() {
        this.mPlayerControl.startFullScreen();
    }

    @Override // xyz.doikki.videoplayer.controller.MediaPlayerControl
    public void stopFullScreen() {
        this.mPlayerControl.stopFullScreen();
    }

    @Override // xyz.doikki.videoplayer.controller.MediaPlayerControl
    public boolean isFullScreen() {
        return this.mPlayerControl.isFullScreen();
    }

    @Override // xyz.doikki.videoplayer.controller.MediaPlayerControl
    public void setMute(boolean z) {
        this.mPlayerControl.setMute(z);
    }

    @Override // xyz.doikki.videoplayer.controller.MediaPlayerControl
    public boolean isMute() {
        return this.mPlayerControl.isMute();
    }

    @Override // xyz.doikki.videoplayer.controller.MediaPlayerControl
    public void setScreenScaleType(int i) {
        this.mPlayerControl.setScreenScaleType(i);
    }

    @Override // xyz.doikki.videoplayer.controller.MediaPlayerControl
    public void setSpeed(float f) {
        this.mPlayerControl.setSpeed(f);
    }

    @Override // xyz.doikki.videoplayer.controller.MediaPlayerControl
    public float getSpeed() {
        return this.mPlayerControl.getSpeed();
    }

    @Override // xyz.doikki.videoplayer.controller.MediaPlayerControl
    public long getTcpSpeed() {
        return this.mPlayerControl.getTcpSpeed();
    }

    @Override // xyz.doikki.videoplayer.controller.MediaPlayerControl
    public void replay(boolean z) {
        this.mPlayerControl.replay(z);
    }

    @Override // xyz.doikki.videoplayer.controller.MediaPlayerControl
    public void setMirrorRotation(boolean z) {
        this.mPlayerControl.setMirrorRotation(z);
    }

    @Override // xyz.doikki.videoplayer.controller.MediaPlayerControl
    public Bitmap doScreenShot() {
        return this.mPlayerControl.doScreenShot();
    }

    @Override // xyz.doikki.videoplayer.controller.MediaPlayerControl
    public int[] getVideoSize() {
        return this.mPlayerControl.getVideoSize();
    }

    @Override // xyz.doikki.videoplayer.controller.MediaPlayerControl
    public void setRotation(float f) {
        this.mPlayerControl.setRotation(f);
    }

    @Override // xyz.doikki.videoplayer.controller.MediaPlayerControl
    public void startTinyScreen() {
        this.mPlayerControl.startTinyScreen();
    }

    @Override // xyz.doikki.videoplayer.controller.MediaPlayerControl
    public void stopTinyScreen() {
        this.mPlayerControl.stopTinyScreen();
    }

    @Override // xyz.doikki.videoplayer.controller.MediaPlayerControl
    public boolean isTinyScreen() {
        return this.mPlayerControl.isTinyScreen();
    }

    public void togglePlay() {
        if (isPlaying()) {
            pause();
        } else {
            start();
        }
    }

    public void toggleFullScreen(Activity activity) {
        if (activity == null || activity.isFinishing()) {
            return;
        }
        if (isFullScreen()) {
            activity.setRequestedOrientation(1);
            stopFullScreen();
        } else {
            activity.setRequestedOrientation(0);
            startFullScreen();
        }
    }

    public void toggleFullScreen() {
        if (isFullScreen()) {
            stopFullScreen();
        } else {
            startFullScreen();
        }
    }

    public void toggleFullScreenByVideoSize(Activity activity) {
        if (activity == null || activity.isFinishing()) {
            return;
        }
        int[] videoSize = getVideoSize();
        int i = videoSize[0];
        int i2 = videoSize[1];
        if (isFullScreen()) {
            stopFullScreen();
            if (i > i2) {
                activity.setRequestedOrientation(1);
                return;
            }
            return;
        }
        startFullScreen();
        if (i > i2) {
            activity.setRequestedOrientation(0);
        }
    }

    @Override // xyz.doikki.videoplayer.controller.IVideoController
    public void startFadeOut() {
        this.mController.startFadeOut();
    }

    @Override // xyz.doikki.videoplayer.controller.IVideoController
    public void stopFadeOut() {
        this.mController.stopFadeOut();
    }

    @Override // xyz.doikki.videoplayer.controller.IVideoController
    public boolean isShowing() {
        return this.mController.isShowing();
    }

    @Override // xyz.doikki.videoplayer.controller.IVideoController
    public void setLocked(boolean z) {
        this.mController.setLocked(z);
    }

    @Override // xyz.doikki.videoplayer.controller.IVideoController
    public boolean isLocked() {
        return this.mController.isLocked();
    }

    @Override // xyz.doikki.videoplayer.controller.IVideoController
    public void startProgress() {
        this.mController.startProgress();
    }

    @Override // xyz.doikki.videoplayer.controller.IVideoController
    public void stopProgress() {
        this.mController.stopProgress();
    }

    @Override // xyz.doikki.videoplayer.controller.IVideoController
    public void hide() {
        this.mController.hide();
    }

    @Override // xyz.doikki.videoplayer.controller.IVideoController
    public void show() {
        this.mController.show();
    }

    @Override // xyz.doikki.videoplayer.controller.IVideoController
    public boolean hasCutout() {
        return this.mController.hasCutout();
    }

    @Override // xyz.doikki.videoplayer.controller.IVideoController
    public int getCutoutHeight() {
        return this.mController.getCutoutHeight();
    }

    public void toggleLockState() {
        setLocked(!isLocked());
    }

    public void toggleShowState() {
        if (isShowing()) {
            hide();
        } else {
            show();
        }
    }
}
