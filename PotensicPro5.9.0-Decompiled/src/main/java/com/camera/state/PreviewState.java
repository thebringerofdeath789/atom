package com.camera.state;

import android.graphics.Bitmap;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.camera.CameraInterface;
import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.configs.PhoneConfig;

/* loaded from: classes.dex */
class PreviewState implements State {
    public static final String TAG = "PreviewState";
    private CameraMachine machine;

    @Override // com.camera.state.State
    public void restart() {
    }

    PreviewState(CameraMachine cameraMachine) {
        this.machine = cameraMachine;
    }

    @Override // com.camera.state.State
    public void start(SurfaceHolder surfaceHolder, float f) {
        CameraInterface.getInstance().doStartPreview(surfaceHolder, f);
    }

    @Override // com.camera.state.State
    public void stop() {
        CameraInterface.getInstance().doStopPreview();
    }

    @Override // com.camera.state.State
    public void foucs(float f, float f2, CameraInterface.FocusCallback focusCallback) {
        DDLog.i("preview state foucs");
        if (this.machine.getView().handlerFoucs(f, f2)) {
            CameraInterface.getInstance().handleFocus(this.machine.getContext(), f, f2, focusCallback);
        }
    }

    @Override // com.camera.state.State
    public void swtich(SurfaceHolder surfaceHolder, float f) {
        CameraInterface.getInstance().switchCamera(surfaceHolder, f);
    }

    @Override // com.camera.state.State
    public void capture() {
        CameraInterface.getInstance().takePicture(new CameraInterface.TakePictureCallback() { // from class: com.camera.state.PreviewState.1
            @Override // com.camera.CameraInterface.TakePictureCallback
            public void captureResult(Bitmap bitmap, boolean z) {
                PreviewState.this.machine.getView().showPicture(bitmap, z);
                PreviewState.this.machine.setState(PreviewState.this.machine.getBorrowPictureState());
                DDLog.i("capture");
            }
        });
    }

    @Override // com.camera.state.State
    public void record(Surface surface, float f) {
        CameraInterface.getInstance().startRecord(surface, f, null);
    }

    @Override // com.camera.state.State
    public void stopRecord(final boolean z, long j) {
        CameraInterface.getInstance().stopRecord(z, new CameraInterface.StopRecordCallback() { // from class: com.camera.state.PreviewState.2
            @Override // com.camera.CameraInterface.StopRecordCallback
            public void recordResult(final String str, final Bitmap bitmap) {
                PhoneConfig.mainHandler.post(new Runnable() { // from class: com.camera.state.PreviewState.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            if (z) {
                                PreviewState.this.machine.getView().resetState(3);
                            } else {
                                PreviewState.this.machine.getView().playVideo(bitmap, str);
                                PreviewState.this.machine.setState(PreviewState.this.machine.getBorrowVideoState());
                            }
                        } catch (Exception unused) {
                        }
                    }
                });
            }
        });
    }

    @Override // com.camera.state.State
    public void cancle(SurfaceHolder surfaceHolder, float f) {
        DDLog.i("浏览状态下,没有 cancle 事件");
    }

    @Override // com.camera.state.State
    public void confirm() {
        DDLog.i("浏览状态下,没有 confirm 事件");
    }

    @Override // com.camera.state.State
    public void zoom(float f, int i) {
        DDLog.i(TAG, "zoom");
        CameraInterface.getInstance().setZoom(f, i);
    }

    @Override // com.camera.state.State
    public void flash(String str) {
        CameraInterface.getInstance().setFlashMode(str);
    }
}
