package com.journeyapps.barcodescanner.camera;

import android.content.Context;
import android.os.Handler;
import android.util.Log;
import android.view.SurfaceHolder;
import com.google.zxing.client.android.C1783R;
import com.journeyapps.barcodescanner.Size;
import com.journeyapps.barcodescanner.Util;

/* loaded from: classes2.dex */
public class CameraInstance {
    private static final String TAG = "CameraInstance";
    private CameraManager cameraManager;
    private CameraThread cameraThread;
    private DisplayConfiguration displayConfiguration;
    private Handler mainHandler;
    private Handler readyHandler;
    private CameraSurface surface;
    private boolean open = false;
    private boolean cameraClosed = true;
    private CameraSettings cameraSettings = new CameraSettings();
    private Runnable opener = new Runnable() { // from class: com.journeyapps.barcodescanner.camera.CameraInstance.1
        @Override // java.lang.Runnable
        public void run() {
            try {
                Log.d(CameraInstance.TAG, "Opening camera");
                CameraInstance.this.cameraManager.open();
            } catch (Exception e) {
                CameraInstance.this.notifyError(e);
                Log.e(CameraInstance.TAG, "Failed to open camera", e);
            }
        }
    };
    private Runnable configure = new Runnable() { // from class: com.journeyapps.barcodescanner.camera.CameraInstance.2
        @Override // java.lang.Runnable
        public void run() {
            try {
                Log.d(CameraInstance.TAG, "Configuring camera");
                CameraInstance.this.cameraManager.configure();
                if (CameraInstance.this.readyHandler != null) {
                    CameraInstance.this.readyHandler.obtainMessage(C1783R.id.zxing_prewiew_size_ready, CameraInstance.this.getPreviewSize()).sendToTarget();
                }
            } catch (Exception e) {
                CameraInstance.this.notifyError(e);
                Log.e(CameraInstance.TAG, "Failed to configure camera", e);
            }
        }
    };
    private Runnable previewStarter = new Runnable() { // from class: com.journeyapps.barcodescanner.camera.CameraInstance.3
        @Override // java.lang.Runnable
        public void run() {
            try {
                Log.d(CameraInstance.TAG, "Starting preview");
                CameraInstance.this.cameraManager.setPreviewDisplay(CameraInstance.this.surface);
                CameraInstance.this.cameraManager.startPreview();
            } catch (Exception e) {
                CameraInstance.this.notifyError(e);
                Log.e(CameraInstance.TAG, "Failed to start preview", e);
            }
        }
    };
    private Runnable closer = new Runnable() { // from class: com.journeyapps.barcodescanner.camera.CameraInstance.4
        @Override // java.lang.Runnable
        public void run() {
            try {
                Log.d(CameraInstance.TAG, "Closing camera");
                CameraInstance.this.cameraManager.stopPreview();
                CameraInstance.this.cameraManager.close();
            } catch (Exception e) {
                Log.e(CameraInstance.TAG, "Failed to close camera", e);
            }
            CameraInstance.this.cameraClosed = true;
            CameraInstance.this.readyHandler.sendEmptyMessage(C1783R.id.zxing_camera_closed);
            CameraInstance.this.cameraThread.decrementInstances();
        }
    };

    public CameraInstance(Context context) {
        Util.validateMainThread();
        this.cameraThread = CameraThread.getInstance();
        CameraManager cameraManager = new CameraManager(context);
        this.cameraManager = cameraManager;
        cameraManager.setCameraSettings(this.cameraSettings);
        this.mainHandler = new Handler();
    }

    public CameraInstance(CameraManager cameraManager) {
        Util.validateMainThread();
        this.cameraManager = cameraManager;
    }

    public void setDisplayConfiguration(DisplayConfiguration displayConfiguration) {
        this.displayConfiguration = displayConfiguration;
        this.cameraManager.setDisplayConfiguration(displayConfiguration);
    }

    public DisplayConfiguration getDisplayConfiguration() {
        return this.displayConfiguration;
    }

    public void setReadyHandler(Handler handler) {
        this.readyHandler = handler;
    }

    public void setSurfaceHolder(SurfaceHolder surfaceHolder) {
        setSurface(new CameraSurface(surfaceHolder));
    }

    public void setSurface(CameraSurface cameraSurface) {
        this.surface = cameraSurface;
    }

    public CameraSettings getCameraSettings() {
        return this.cameraSettings;
    }

    public void setCameraSettings(CameraSettings cameraSettings) {
        if (this.open) {
            return;
        }
        this.cameraSettings = cameraSettings;
        this.cameraManager.setCameraSettings(cameraSettings);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Size getPreviewSize() {
        return this.cameraManager.getPreviewSize();
    }

    public int getCameraRotation() {
        return this.cameraManager.getCameraRotation();
    }

    public void open() {
        Util.validateMainThread();
        this.open = true;
        this.cameraClosed = false;
        this.cameraThread.incrementAndEnqueue(this.opener);
    }

    public void configureCamera() {
        Util.validateMainThread();
        validateOpen();
        this.cameraThread.enqueue(this.configure);
    }

    public void startPreview() {
        Util.validateMainThread();
        validateOpen();
        this.cameraThread.enqueue(this.previewStarter);
    }

    public void setTorch(final boolean z) {
        Util.validateMainThread();
        if (this.open) {
            this.cameraThread.enqueue(new Runnable() { // from class: com.journeyapps.barcodescanner.camera.-$$Lambda$CameraInstance$iIFQHNTErRGFvNrZAXXr4yeDft8
                @Override // java.lang.Runnable
                public final void run() {
                    CameraInstance.this.lambda$setTorch$0$CameraInstance(z);
                }
            });
        }
    }

    public /* synthetic */ void lambda$setTorch$0$CameraInstance(boolean z) {
        this.cameraManager.setTorch(z);
    }

    public void changeCameraParameters(final CameraParametersCallback cameraParametersCallback) {
        Util.validateMainThread();
        if (this.open) {
            this.cameraThread.enqueue(new Runnable() { // from class: com.journeyapps.barcodescanner.camera.-$$Lambda$CameraInstance$Rt7HjZfyvX3XxHPg0_TGp_KTl2E
                @Override // java.lang.Runnable
                public final void run() {
                    CameraInstance.this.lambda$changeCameraParameters$1$CameraInstance(cameraParametersCallback);
                }
            });
        }
    }

    public /* synthetic */ void lambda$changeCameraParameters$1$CameraInstance(CameraParametersCallback cameraParametersCallback) {
        this.cameraManager.changeCameraParameters(cameraParametersCallback);
    }

    public void close() {
        Util.validateMainThread();
        if (this.open) {
            this.cameraThread.enqueue(this.closer);
        } else {
            this.cameraClosed = true;
        }
        this.open = false;
    }

    public boolean isOpen() {
        return this.open;
    }

    public boolean isCameraClosed() {
        return this.cameraClosed;
    }

    public void requestPreview(final PreviewCallback previewCallback) {
        this.mainHandler.post(new Runnable() { // from class: com.journeyapps.barcodescanner.camera.-$$Lambda$CameraInstance$llOHFA7BHxLmt5nvifLpg_kMqa4
            @Override // java.lang.Runnable
            public final void run() {
                CameraInstance.this.lambda$requestPreview$3$CameraInstance(previewCallback);
            }
        });
    }

    public /* synthetic */ void lambda$requestPreview$3$CameraInstance(final PreviewCallback previewCallback) {
        if (!this.open) {
            Log.d(TAG, "Camera is closed, not requesting preview");
        } else {
            this.cameraThread.enqueue(new Runnable() { // from class: com.journeyapps.barcodescanner.camera.-$$Lambda$CameraInstance$hnEVUVS5rjVYPYuraFerid4QSdo
                @Override // java.lang.Runnable
                public final void run() {
                    CameraInstance.this.lambda$null$2$CameraInstance(previewCallback);
                }
            });
        }
    }

    public /* synthetic */ void lambda$null$2$CameraInstance(PreviewCallback previewCallback) {
        this.cameraManager.requestPreviewFrame(previewCallback);
    }

    private void validateOpen() {
        if (!this.open) {
            throw new IllegalStateException("CameraInstance is not open");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyError(Exception exc) {
        Handler handler = this.readyHandler;
        if (handler != null) {
            handler.obtainMessage(C1783R.id.zxing_camera_error, exc).sendToTarget();
        }
    }

    protected CameraManager getCameraManager() {
        return this.cameraManager;
    }

    protected CameraThread getCameraThread() {
        return this.cameraThread;
    }

    protected CameraSurface getSurface() {
        return this.surface;
    }
}