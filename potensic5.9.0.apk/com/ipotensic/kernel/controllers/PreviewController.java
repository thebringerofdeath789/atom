package com.ipotensic.kernel.controllers;

import android.app.Activity;
import android.graphics.Bitmap;
import android.util.Size;
import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.configs.PhoneConfig;
import com.ipotensic.baselib.configs.UsbConfig;
import com.ipotensic.baselib.dispatcher.EventDispatcher;
import com.ipotensic.baselib.dispatcher.EventID;
import com.ipotensic.baselib.utils.CancelRunnable;
import com.ipotensic.baselib.utils.YuvTransformer;
import com.ipotensic.kernel.utils.NV21ToBitmapHelper;
import com.logan.camera.CameraConstants;
import com.logan.h264.H264Player;
import com.logan.opengl.JfGLSurfaceView;
import com.logan.rtsp.FFmpeg;
import com.logan.rtsp.OnYuvListener;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class PreviewController {
    private onFrameCaptureListener frameCaptureListener;
    private JfGLSurfaceView glSurfaceView;
    private NV21ToBitmapHelper nv21ToBitmapHelper;
    private CancelRunnable playRunnable;
    private boolean isVideoPreparing = false;
    private boolean isPause = false;
    private OnYuvListener yuvCallback = new OnYuvListener() { // from class: com.ipotensic.kernel.controllers.PreviewController.2
        @Override // com.logan.rtsp.OnYuvListener
        public void onYuv(int i, int i2, byte[] bArr, byte[] bArr2, byte[] bArr3) {
            if (PhoneConfig.previewSize == null || PhoneConfig.previewSize.getWidth() != i || PhoneConfig.previewSize.getHeight() != i2) {
                PhoneConfig.previewSize = new Size(i, i2);
                EventDispatcher.get().sendEvent(EventID.EVENT_PREVIEW_SIZE_CHANGED);
            }
            if (PreviewController.this.frameCaptureListener != null) {
                Bitmap nv21ToBitmap = YuvTransformer.nv21ToBitmap(YuvTransformer.getNv21(bArr, bArr2, bArr3, i, i2), i, i2);
                if (nv21ToBitmap != null) {
                    PreviewController.this.frameCaptureListener.onFrame(nv21ToBitmap);
                }
                PreviewController.this.frameCaptureListener = null;
            }
            if (PreviewController.this.glSurfaceView == null || PreviewController.this.isPause) {
                return;
            }
            PreviewController.this.glSurfaceView.setYUVData(i, i2, bArr, bArr2, bArr3);
        }
    };

    public interface onFrameCaptureListener {
        void onFrame(Bitmap bitmap);
    }

    public PreviewController(JfGLSurfaceView jfGLSurfaceView) {
        this.glSurfaceView = jfGLSurfaceView;
        this.nv21ToBitmapHelper = new NV21ToBitmapHelper(jfGLSurfaceView.getContext());
        initPreview();
        H264Player.addYuvListener(this.yuvCallback);
    }

    private void initPreview() {
        if (this.playRunnable == null) {
            CancelRunnable cancelRunnable = new CancelRunnable() { // from class: com.ipotensic.kernel.controllers.PreviewController.1
                @Override // com.ipotensic.baselib.utils.CancelRunnable, java.lang.Runnable
                public void run() {
                    if (((Activity) PreviewController.this.glSurfaceView.getContext()).isFinishing()) {
                        return;
                    }
                    try {
                        if (!PhoneConfig.isConnectFlightWifi() || PreviewController.this.isPause || PreviewController.this.isVideoPreparing || UsbConfig.isUsbConnected) {
                            return;
                        }
                        DDLog.m1687i("surface 开始播放");
                        PreviewController.this.isVideoPreparing = true;
                        FFmpeg.startPlay(CameraConstants.URL_PREVIEW, PreviewController.this.yuvCallback);
                        PreviewController.this.isVideoPreparing = false;
                        DDLog.m1687i("surface 播放完成");
                    } catch (Exception e) {
                        DDLog.m1684e("surface 播放错误：" + e.getMessage());
                    }
                }
            };
            this.playRunnable = cancelRunnable;
            cancelRunnable.setFuture(PhoneConfig.schedule.scheduleWithFixedDelay(this.playRunnable, 0L, 1000L, TimeUnit.MILLISECONDS));
        }
    }

    public void onPause() {
        H264Player.pause();
        this.isPause = true;
        stopPlay();
    }

    public void onResume() {
        this.isPause = false;
        H264Player.resume();
    }

    public void onDestroy() {
        NV21ToBitmapHelper nV21ToBitmapHelper = this.nv21ToBitmapHelper;
        if (nV21ToBitmapHelper != null) {
            nV21ToBitmapHelper.release();
            this.nv21ToBitmapHelper = null;
        }
        CancelRunnable cancelRunnable = this.playRunnable;
        if (cancelRunnable != null && cancelRunnable.getFuture() != null) {
            this.playRunnable.getFuture().cancel(true);
            this.playRunnable = null;
        }
        H264Player.clearCallbacks();
    }

    public void stopPlay() {
        FFmpeg.stop();
    }

    public void releasePlayer() {
        FFmpeg.stop();
    }

    public void setHardDecode() {
        stopPlay();
    }

    public void setSoftDecode() {
        stopPlay();
    }

    public void captureFrame(onFrameCaptureListener onframecapturelistener) {
        this.frameCaptureListener = onframecapturelistener;
    }
}