package com.camera;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.YuvImage;
import android.hardware.Camera;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaRecorder;
import android.os.Build;
import android.os.Environment;
import android.os.Looper;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.widget.ImageView;
import com.camera.listener.ErrorListener;
import com.camera.util.AngleUtil;
import com.camera.util.CameraParamUtil;
import com.camera.util.CheckPermission;
import com.camera.util.DeviceUtil;
import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.configs.PhoneConfig;
import com.ipotensic.baselib.utils.ScreenUtils;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.poi.ss.util.CellUtil;
import tv.danmaku.ijk.media.player.IjkMediaCodecInfo;

/* loaded from: classes.dex */
public class CameraInterface implements Camera.PreviewCallback {
    private static final String TAG = "ddlog";
    public static final int TYPE_CAPTURE = 145;
    public static final int TYPE_RECORDER = 144;
    private static volatile CameraInterface mCameraInterface;
    private int SELECTED_CAMERA;
    private ErrorListener errorLisenter;
    private byte[] firstFrame_data;
    private boolean isSupportAudio;
    private Camera mCamera;
    private ImageView mFlashLamp;
    private Camera.Parameters mParams;
    private ImageView mSwitchView;
    private MediaRecorder mediaRecorder;
    private int nowAngle;
    private int preview_height;
    private int preview_width;
    private String saveVideoPath;
    private String videoFileAbsPath;
    private String videoFileName;
    private boolean isPreviewing = false;
    private int CAMERA_POST_POSITION = -1;
    private int CAMERA_FRONT_POSITION = -1;
    private SurfaceHolder mHolder = null;
    private float screenProp = -1.0f;
    private boolean isRecorder = false;
    private Bitmap videoFirstFrame = null;
    private int angle = 0;
    private int cameraAngle = 90;
    private int rotation = 0;
    private int nowScaleRate = 0;
    private int recordScleRate = 0;
    private int mediaQuality = JCameraView.MEDIA_QUALITY_MIDDLE;
    private SensorManager sm = null;
    private SensorEventListener sensorEventListener = new SensorEventListener() { // from class: com.camera.CameraInterface.1
        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i) {
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            if (1 != sensorEvent.sensor.getType()) {
                return;
            }
            float[] fArr = sensorEvent.values;
            CameraInterface.this.angle = AngleUtil.getSensorAngle(fArr[0], fArr[1]);
            CameraInterface.this.rotationAnimation();
        }
    };
    int handlerTime = 0;

    public interface CameraOpenOverCallback {
        void cameraHasOpened();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public interface ErrorCallback {
        void onError();
    }

    public interface FocusCallback {
        void focusSuccess();
    }

    public interface StopRecordCallback {
        void recordResult(String str, Bitmap bitmap);
    }

    public interface TakePictureCallback {
        void captureResult(Bitmap bitmap, boolean z);
    }

    private static int clamp(int i, int i2, int i3) {
        return i > i3 ? i3 : i < i2 ? i2 : i;
    }

    public static void destroyCameraInterface() {
        if (mCameraInterface != null) {
            mCameraInterface = null;
        }
    }

    public static synchronized CameraInterface getInstance() {
        CameraInterface cameraInterface;
        synchronized (CameraInterface.class) {
            if (mCameraInterface == null) {
                synchronized (CameraInterface.class) {
                    if (mCameraInterface == null) {
                        mCameraInterface = new CameraInterface();
                    }
                }
            }
            cameraInterface = mCameraInterface;
        }
        return cameraInterface;
    }

    public void setSwitchView(ImageView imageView, ImageView imageView2) {
        this.mSwitchView = imageView;
        this.mFlashLamp = imageView2;
        if (imageView != null) {
            this.cameraAngle = CameraParamUtil.getInstance().getCameraDisplayOrientation(imageView.getContext(), this.SELECTED_CAMERA);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rotationAnimation() {
        int i;
        int i2;
        ImageView imageView = this.mSwitchView;
        if (imageView == null || (i = this.rotation) == (i2 = this.angle)) {
            return;
        }
        int i3 = 180;
        if (i == 0) {
            i3 = i2 != 90 ? i2 != 270 ? 0 : 90 : -90;
            r3 = 0;
        } else if (i == 90) {
            if (i2 != 0 && i2 == 180) {
                i3 = -180;
            }
            i3 = 0;
        } else if (i == 180) {
            r3 = 180;
            i3 = i2 != 90 ? i2 != 270 ? 0 : 90 : 270;
        } else if (i != 270) {
            r3 = 0;
            i3 = 0;
        } else if (i2 == 0 || i2 != 180) {
            r3 = 90;
            i3 = 0;
        } else {
            r3 = 90;
        }
        float f = r3;
        float f2 = i3;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageView, CellUtil.ROTATION, f, f2);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.mFlashLamp, CellUtil.ROTATION, f, f2);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ofFloat, ofFloat2);
        animatorSet.setDuration(500L);
        animatorSet.start();
        this.rotation = this.angle;
    }

    void setSaveVideoPath(String str) {
        this.saveVideoPath = str;
        File file = new File(str);
        if (file.exists()) {
            return;
        }
        file.mkdirs();
    }

    public void setZoom(float f, int i) {
        int i2;
        Camera camera = this.mCamera;
        if (camera == null) {
            return;
        }
        if (this.mParams == null) {
            this.mParams = camera.getParameters();
        }
        if (this.mParams.isZoomSupported() && this.mParams.isSmoothZoomSupported()) {
            if (i == 144) {
                if (this.isRecorder && f >= 0.0f && (i2 = (int) (f / 40.0f)) <= this.mParams.getMaxZoom() && i2 >= this.nowScaleRate && this.recordScleRate != i2) {
                    this.mParams.setZoom(i2);
                    this.mCamera.setParameters(this.mParams);
                    this.recordScleRate = i2;
                    return;
                }
                return;
            }
            if (i == 145 && !this.isRecorder) {
                int i3 = (int) (f / 50.0f);
                if (i3 < this.mParams.getMaxZoom()) {
                    int i4 = this.nowScaleRate + i3;
                    this.nowScaleRate = i4;
                    if (i4 < 0) {
                        this.nowScaleRate = 0;
                    } else if (i4 > this.mParams.getMaxZoom()) {
                        this.nowScaleRate = this.mParams.getMaxZoom();
                    }
                    this.mParams.setZoom(this.nowScaleRate);
                    this.mCamera.setParameters(this.mParams);
                }
                DDLog.i("setZoom = " + this.nowScaleRate);
            }
        }
    }

    void setMediaQuality(int i) {
        this.mediaQuality = i;
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, Camera camera) {
        this.firstFrame_data = bArr;
    }

    public void setFlashMode(String str) {
        Camera camera = this.mCamera;
        if (camera == null) {
            return;
        }
        Camera.Parameters parameters = camera.getParameters();
        parameters.setFlashMode(str);
        this.mCamera.setParameters(parameters);
    }

    private CameraInterface() {
        this.SELECTED_CAMERA = -1;
        this.isSupportAudio = false;
        findAvailableCameras();
        this.SELECTED_CAMERA = this.CAMERA_POST_POSITION;
        this.saveVideoPath = "";
        this.isSupportAudio = CheckPermission.getRecordState() == 1;
    }

    void doOpenCamera(CameraOpenOverCallback cameraOpenOverCallback) {
        ErrorListener errorListener;
        if (Build.VERSION.SDK_INT < 23 && !CheckPermission.isCameraUseable(this.SELECTED_CAMERA) && (errorListener = this.errorLisenter) != null) {
            errorListener.onError();
            return;
        }
        if (this.mCamera == null) {
            openCamera(this.SELECTED_CAMERA);
        }
        cameraOpenOverCallback.cameraHasOpened();
    }

    private void setFlashModel() {
        Camera.Parameters parameters = this.mCamera.getParameters();
        this.mParams = parameters;
        parameters.setFlashMode("torch");
        this.mCamera.setParameters(this.mParams);
    }

    private synchronized void openCamera(int i) {
        Camera camera;
        try {
            this.mCamera = Camera.open(i);
        } catch (Exception e) {
            e.printStackTrace();
            ErrorListener errorListener = this.errorLisenter;
            if (errorListener != null) {
                errorListener.onError();
            }
        }
        if (Build.VERSION.SDK_INT > 17 && (camera = this.mCamera) != null) {
            try {
                camera.enableShutterSound(false);
            } catch (Exception e2) {
                e2.printStackTrace();
                Log.e("CJT", "enable shutter sound faild");
            }
        }
    }

    public synchronized void switchCamera(SurfaceHolder surfaceHolder, float f) {
        Camera camera;
        int i = this.SELECTED_CAMERA;
        int i2 = this.CAMERA_POST_POSITION;
        if (i == i2) {
            this.SELECTED_CAMERA = this.CAMERA_FRONT_POSITION;
        } else {
            this.SELECTED_CAMERA = i2;
        }
        doDestroyCamera();
        DDLog.i("open start");
        openCamera(this.SELECTED_CAMERA);
        if (Build.VERSION.SDK_INT > 17 && (camera = this.mCamera) != null) {
            try {
                camera.enableShutterSound(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        DDLog.i("open end");
        doStartPreview(surfaceHolder, f);
    }

    public void doStartPreview(SurfaceHolder surfaceHolder, float f) {
        if (this.isPreviewing) {
            DDLog.i("doStartPreview isPreviewing");
        }
        if (this.screenProp < 0.0f) {
            this.screenProp = f;
        }
        if (surfaceHolder == null) {
            return;
        }
        this.mHolder = surfaceHolder;
        Camera camera = this.mCamera;
        if (camera != null) {
            try {
                this.mParams = camera.getParameters();
                Camera.Size previewSize = CameraParamUtil.getInstance().getPreviewSize(this.mParams.getSupportedPreviewSizes(), 1000, f);
                Camera.Size pictureSize = CameraParamUtil.getInstance().getPictureSize(this.mParams.getSupportedPictureSizes(), 1200, f);
                this.mParams.setPreviewSize(previewSize.width, previewSize.height);
                this.preview_width = previewSize.width;
                this.preview_height = previewSize.height;
                DDLog.e("previewSize width:" + this.preview_width);
                DDLog.e("previewSize height:" + this.preview_height);
                this.mParams.setPictureSize(pictureSize.width, pictureSize.height);
                if (CameraParamUtil.getInstance().isSupportedFocusMode(this.mParams.getSupportedFocusModes(), "auto")) {
                    this.mParams.setFocusMode("auto");
                }
                if (CameraParamUtil.getInstance().isSupportedPictureFormats(this.mParams.getSupportedPictureFormats(), 256)) {
                    this.mParams.setPictureFormat(256);
                    this.mParams.setJpegQuality(100);
                }
                this.mCamera.setParameters(this.mParams);
                this.mParams = this.mCamera.getParameters();
                this.mCamera.setPreviewDisplay(surfaceHolder);
                this.mCamera.setDisplayOrientation(this.cameraAngle);
                this.mCamera.setPreviewCallback(this);
                this.mCamera.startPreview();
                this.isPreviewing = true;
                Log.i(TAG, "=== Start Preview ===");
            } catch (Exception e) {
                DDLog.e("开启预览报错:" + e.getMessage());
            }
        }
    }

    public void doStopPreview() {
        Camera camera = this.mCamera;
        if (camera != null) {
            try {
                camera.setPreviewCallback(null);
                this.mCamera.stopPreview();
                try {
                    this.mCamera.setPreviewDisplay(null);
                } catch (Exception e) {
                    DDLog.e("停止预览报错:" + e.getMessage());
                }
                this.isPreviewing = false;
                Log.i(TAG, "=== Stop Preview ===");
            } catch (Exception e2) {
                DDLog.e("停止预览报错1:" + e2.getMessage());
            }
        }
    }

    void doDestroyCamera() {
        this.errorLisenter = null;
        Camera camera = this.mCamera;
        if (camera != null) {
            try {
                camera.setPreviewCallback(null);
                this.mSwitchView = null;
                this.mFlashLamp = null;
                this.mCamera.stopPreview();
                try {
                    this.mCamera.setPreviewDisplay(null);
                } catch (Exception unused) {
                }
                this.mHolder = null;
                this.isPreviewing = false;
                this.mCamera.release();
                this.mCamera = null;
                Log.i(TAG, "=== Destroy Camera ===");
                return;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        Log.i(TAG, "=== Camera  Null===");
    }

    public void takePicture(final TakePictureCallback takePictureCallback) {
        if (this.mCamera == null) {
            return;
        }
        int i = this.cameraAngle;
        if (i == 90) {
            this.nowAngle = Math.abs(this.angle + i) % 360;
        } else if (i == 270) {
            this.nowAngle = Math.abs(i - this.angle);
        }
        Log.i("CJT", this.angle + " = " + this.cameraAngle + " = " + this.nowAngle);
        try {
            if (this.isPreviewing) {
                this.mCamera.takePicture(null, null, new Camera.PictureCallback() { // from class: com.camera.CameraInterface.2
                    @Override // android.hardware.Camera.PictureCallback
                    public void onPictureTaken(byte[] bArr, Camera camera) {
                        Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
                        Matrix matrix = new Matrix();
                        if (CameraInterface.this.SELECTED_CAMERA == CameraInterface.this.CAMERA_POST_POSITION) {
                            matrix.setRotate(CameraInterface.this.nowAngle);
                        } else if (CameraInterface.this.SELECTED_CAMERA == CameraInterface.this.CAMERA_FRONT_POSITION) {
                            matrix.setRotate(360 - CameraInterface.this.nowAngle);
                            matrix.postScale(-1.0f, 1.0f);
                        }
                        Bitmap createBitmap = Bitmap.createBitmap(decodeByteArray, 0, 0, decodeByteArray.getWidth(), decodeByteArray.getHeight(), matrix, true);
                        if (takePictureCallback != null) {
                            if (CameraInterface.this.nowAngle == 90 || CameraInterface.this.nowAngle == 270) {
                                takePictureCallback.captureResult(createBitmap, true);
                            } else {
                                takePictureCallback.captureResult(createBitmap, false);
                            }
                        }
                    }
                });
            }
        } catch (Exception e) {
            DDLog.e("拍照报错:" + e.getMessage());
        }
    }

    public void startRecord(Surface surface, float f, ErrorCallback errorCallback) {
        Camera.Size previewSize;
        this.mCamera.setPreviewCallback(null);
        int i = (this.angle + 90) % 360;
        Camera.Parameters parameters = this.mCamera.getParameters();
        int i2 = parameters.getPreviewSize().width;
        int i3 = parameters.getPreviewSize().height;
        YuvImage yuvImage = new YuvImage(this.firstFrame_data, parameters.getPreviewFormat(), i2, i3, null);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        yuvImage.compressToJpeg(new Rect(0, 0, i2, i3), 50, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        this.videoFirstFrame = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
        Matrix matrix = new Matrix();
        int i4 = this.SELECTED_CAMERA;
        if (i4 == this.CAMERA_POST_POSITION) {
            matrix.setRotate(i);
        } else if (i4 == this.CAMERA_FRONT_POSITION) {
            matrix.setRotate(270.0f);
        }
        Bitmap bitmap = this.videoFirstFrame;
        this.videoFirstFrame = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), this.videoFirstFrame.getHeight(), matrix, true);
        if (this.isRecorder) {
            return;
        }
        if (this.mCamera == null) {
            openCamera(this.SELECTED_CAMERA);
        }
        if (this.mediaRecorder == null) {
            this.mediaRecorder = new MediaRecorder();
        }
        if (this.mParams == null) {
            this.mParams = this.mCamera.getParameters();
        }
        if (this.mParams.getSupportedFocusModes().contains("continuous-video")) {
            this.mParams.setFocusMode("continuous-video");
        }
        this.mCamera.setParameters(this.mParams);
        this.mCamera.unlock();
        this.mediaRecorder.reset();
        this.mediaRecorder.setCamera(this.mCamera);
        this.mediaRecorder.setVideoSource(1);
        if (this.isSupportAudio) {
            this.mediaRecorder.setAudioSource(1);
        }
        this.mediaRecorder.setOutputFormat(2);
        this.mediaRecorder.setVideoEncoder(2);
        if (this.isSupportAudio) {
            this.mediaRecorder.setAudioEncoder(3);
        }
        if (this.mParams.getSupportedVideoSizes() == null) {
            previewSize = CameraParamUtil.getInstance().getPreviewSize(this.mParams.getSupportedPreviewSizes(), IjkMediaCodecInfo.RANK_LAST_CHANCE, f);
        } else {
            previewSize = CameraParamUtil.getInstance().getPreviewSize(this.mParams.getSupportedVideoSizes(), IjkMediaCodecInfo.RANK_LAST_CHANCE, f);
        }
        Log.i(TAG, "setVideoSize    width = " + previewSize.width + "  height = " + previewSize.height);
        if (previewSize.width == previewSize.height) {
            this.mediaRecorder.setVideoSize(this.preview_width, this.preview_height);
        } else {
            this.mediaRecorder.setVideoSize(previewSize.width, previewSize.height);
        }
        if (this.SELECTED_CAMERA == this.CAMERA_FRONT_POSITION) {
            if (this.cameraAngle == 270) {
                if (i == 0) {
                    this.mediaRecorder.setOrientationHint(180);
                } else if (i == 270) {
                    this.mediaRecorder.setOrientationHint(270);
                } else {
                    this.mediaRecorder.setOrientationHint(90);
                }
            } else if (i == 90) {
                this.mediaRecorder.setOrientationHint(270);
            } else if (i == 270) {
                this.mediaRecorder.setOrientationHint(90);
            } else {
                this.mediaRecorder.setOrientationHint(i);
            }
        } else {
            this.mediaRecorder.setOrientationHint(i);
        }
        if (DeviceUtil.isHuaWeiRongyao()) {
            this.mediaRecorder.setVideoEncodingBitRate(JCameraView.MEDIA_QUALITY_FUNNY);
        } else {
            this.mediaRecorder.setVideoEncodingBitRate(this.mediaQuality);
        }
        this.mediaRecorder.setPreviewDisplay(surface);
        this.videoFileName = "video_" + System.currentTimeMillis() + ".mp4";
        if (this.saveVideoPath.equals("")) {
            this.saveVideoPath = Environment.getExternalStorageDirectory().getPath();
        }
        String str = this.saveVideoPath + File.separator + this.videoFileName;
        this.videoFileAbsPath = str;
        this.mediaRecorder.setOutputFile(str);
        try {
            this.mediaRecorder.prepare();
            this.mediaRecorder.start();
            this.isRecorder = true;
        } catch (IOException e) {
            e.printStackTrace();
            Log.i("CJT", "startRecord IOException");
            ErrorListener errorListener = this.errorLisenter;
            if (errorListener != null) {
                errorListener.onError();
            }
        } catch (IllegalStateException e2) {
            e2.printStackTrace();
            Log.i("CJT", "startRecord IllegalStateException");
            ErrorListener errorListener2 = this.errorLisenter;
            if (errorListener2 != null) {
                errorListener2.onError();
            }
        } catch (RuntimeException unused) {
            Log.i("CJT", "startRecord RuntimeException");
        }
    }

    public void stopRecord(final boolean z, final StopRecordCallback stopRecordCallback) {
        if (this.isRecorder) {
            DDLog.e("录像 当前线程：" + (Looper.getMainLooper() == Looper.myLooper()));
            MediaRecorder mediaRecorder = this.mediaRecorder;
            if (mediaRecorder != null) {
                mediaRecorder.setOnErrorListener(null);
                this.mediaRecorder.setOnInfoListener(null);
                this.mediaRecorder.setPreviewDisplay(null);
                PhoneConfig.threadPool.execute(new Runnable() { // from class: com.camera.CameraInterface.3
                    /* JADX WARN: Code restructure failed: missing block: B:11:0x0081, code lost:
                    
                        if (com.camera.util.FileUtil.deleteFile(r7.this$0.videoFileAbsPath) == false) goto L31;
                     */
                    /* JADX WARN: Code restructure failed: missing block: B:12:0x0083, code lost:
                    
                        r3.recordResult(null, null);
                     */
                    /* JADX WARN: Code restructure failed: missing block: B:13:0x0088, code lost:
                    
                        return;
                     */
                    /* JADX WARN: Code restructure failed: missing block: B:15:?, code lost:
                    
                        return;
                     */
                    /* JADX WARN: Code restructure failed: missing block: B:16:0x0089, code lost:
                    
                        r7.this$0.doStopPreview();
                        r3.recordResult(r7.this$0.saveVideoPath + java.io.File.separator + r7.this$0.videoFileName, r7.this$0.videoFirstFrame);
                     */
                    /* JADX WARN: Code restructure failed: missing block: B:17:0x00bc, code lost:
                    
                        return;
                     */
                    /* JADX WARN: Code restructure failed: missing block: B:22:0x0070, code lost:
                    
                        if (r7.this$0.mediaRecorder == null) goto L7;
                     */
                    /* JADX WARN: Code restructure failed: missing block: B:5:0x001d, code lost:
                    
                        if (r7.this$0.mediaRecorder != null) goto L6;
                     */
                    /* JADX WARN: Code restructure failed: missing block: B:6:0x001f, code lost:
                    
                        com.ipotensic.baselib.DDLog.e("录制停止2");
                        r7.this$0.mediaRecorder.release();
                        com.ipotensic.baselib.DDLog.e("录制停止3");
                     */
                    /* JADX WARN: Code restructure failed: missing block: B:7:0x002e, code lost:
                    
                        r7.this$0.mediaRecorder = null;
                        r7.this$0.isRecorder = false;
                     */
                    /* JADX WARN: Code restructure failed: missing block: B:9:0x0075, code lost:
                    
                        if (r2 == false) goto L21;
                     */
                    /* JADX WARN: Finally extract failed */
                    @Override // java.lang.Runnable
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct code enable 'Show inconsistent code' option in preferences
                    */
                    public void run() {
                        /*
                            r7 = this;
                            java.lang.String r0 = "录制停止3"
                            java.lang.String r1 = "录制停止2"
                            r2 = 0
                            r3 = 0
                            java.lang.String r4 = "录制停止1"
                            com.ipotensic.baselib.DDLog.e(r4)     // Catch: java.lang.Throwable -> L39 java.lang.Exception -> L3c
                            com.camera.CameraInterface r4 = com.camera.CameraInterface.this     // Catch: java.lang.Throwable -> L39 java.lang.Exception -> L3c
                            android.media.MediaRecorder r4 = com.camera.CameraInterface.access$600(r4)     // Catch: java.lang.Throwable -> L39 java.lang.Exception -> L3c
                            r4.stop()     // Catch: java.lang.Throwable -> L39 java.lang.Exception -> L3c
                            com.camera.CameraInterface r4 = com.camera.CameraInterface.this
                            android.media.MediaRecorder r4 = com.camera.CameraInterface.access$600(r4)
                            if (r4 == 0) goto L2e
                        L1f:
                            com.ipotensic.baselib.DDLog.e(r1)
                            com.camera.CameraInterface r1 = com.camera.CameraInterface.this
                            android.media.MediaRecorder r1 = com.camera.CameraInterface.access$600(r1)
                            r1.release()
                            com.ipotensic.baselib.DDLog.e(r0)
                        L2e:
                            com.camera.CameraInterface r0 = com.camera.CameraInterface.this
                            com.camera.CameraInterface.access$602(r0, r3)
                            com.camera.CameraInterface r0 = com.camera.CameraInterface.this
                            com.camera.CameraInterface.access$702(r0, r2)
                            goto L73
                        L39:
                            r4 = move-exception
                            goto Lbd
                        L3c:
                            r4 = move-exception
                            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L39
                            r5.<init>()     // Catch: java.lang.Throwable -> L39
                            java.lang.String r6 = "录制停止失败:"
                            java.lang.StringBuilder r5 = r5.append(r6)     // Catch: java.lang.Throwable -> L39
                            java.lang.String r6 = r4.getMessage()     // Catch: java.lang.Throwable -> L39
                            java.lang.StringBuilder r5 = r5.append(r6)     // Catch: java.lang.Throwable -> L39
                            java.lang.String r5 = r5.toString()     // Catch: java.lang.Throwable -> L39
                            com.ipotensic.baselib.DDLog.e(r5)     // Catch: java.lang.Throwable -> L39
                            r4.printStackTrace()     // Catch: java.lang.Throwable -> L39
                            com.camera.CameraInterface r4 = com.camera.CameraInterface.this     // Catch: java.lang.Throwable -> L39
                            com.camera.CameraInterface.access$602(r4, r3)     // Catch: java.lang.Throwable -> L39
                            com.camera.CameraInterface r4 = com.camera.CameraInterface.this     // Catch: java.lang.Throwable -> L39
                            android.media.MediaRecorder r5 = new android.media.MediaRecorder     // Catch: java.lang.Throwable -> L39
                            r5.<init>()     // Catch: java.lang.Throwable -> L39
                            com.camera.CameraInterface.access$602(r4, r5)     // Catch: java.lang.Throwable -> L39
                            com.camera.CameraInterface r4 = com.camera.CameraInterface.this
                            android.media.MediaRecorder r4 = com.camera.CameraInterface.access$600(r4)
                            if (r4 == 0) goto L2e
                            goto L1f
                        L73:
                            boolean r0 = r2
                            if (r0 == 0) goto L89
                            com.camera.CameraInterface r0 = com.camera.CameraInterface.this
                            java.lang.String r0 = com.camera.CameraInterface.access$800(r0)
                            boolean r0 = com.camera.util.FileUtil.deleteFile(r0)
                            if (r0 == 0) goto L88
                            com.camera.CameraInterface$StopRecordCallback r0 = r3
                            r0.recordResult(r3, r3)
                        L88:
                            return
                        L89:
                            com.camera.CameraInterface r0 = com.camera.CameraInterface.this
                            r0.doStopPreview()
                            java.lang.StringBuilder r0 = new java.lang.StringBuilder
                            r0.<init>()
                            com.camera.CameraInterface r1 = com.camera.CameraInterface.this
                            java.lang.String r1 = com.camera.CameraInterface.access$900(r1)
                            java.lang.StringBuilder r0 = r0.append(r1)
                            java.lang.String r1 = java.io.File.separator
                            java.lang.StringBuilder r0 = r0.append(r1)
                            com.camera.CameraInterface r1 = com.camera.CameraInterface.this
                            java.lang.String r1 = com.camera.CameraInterface.access$1000(r1)
                            java.lang.StringBuilder r0 = r0.append(r1)
                            java.lang.String r0 = r0.toString()
                            com.camera.CameraInterface$StopRecordCallback r1 = r3
                            com.camera.CameraInterface r2 = com.camera.CameraInterface.this
                            android.graphics.Bitmap r2 = com.camera.CameraInterface.access$1100(r2)
                            r1.recordResult(r0, r2)
                            return
                        Lbd:
                            com.camera.CameraInterface r5 = com.camera.CameraInterface.this
                            android.media.MediaRecorder r5 = com.camera.CameraInterface.access$600(r5)
                            if (r5 == 0) goto Ld4
                            com.ipotensic.baselib.DDLog.e(r1)
                            com.camera.CameraInterface r1 = com.camera.CameraInterface.this
                            android.media.MediaRecorder r1 = com.camera.CameraInterface.access$600(r1)
                            r1.release()
                            com.ipotensic.baselib.DDLog.e(r0)
                        Ld4:
                            com.camera.CameraInterface r0 = com.camera.CameraInterface.this
                            com.camera.CameraInterface.access$602(r0, r3)
                            com.camera.CameraInterface r0 = com.camera.CameraInterface.this
                            com.camera.CameraInterface.access$702(r0, r2)
                            throw r4
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.camera.CameraInterface.AnonymousClass3.run():void");
                    }
                });
            }
        }
    }

    private void findAvailableCameras() {
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        int numberOfCameras = Camera.getNumberOfCameras();
        for (int i = 0; i < numberOfCameras; i++) {
            Camera.getCameraInfo(i, cameraInfo);
            int i2 = cameraInfo.facing;
            if (i2 == 0) {
                this.CAMERA_POST_POSITION = cameraInfo.facing;
            } else if (i2 == 1) {
                this.CAMERA_FRONT_POSITION = cameraInfo.facing;
            }
        }
    }

    public void handleFocus(final Context context, final float f, final float f2, final FocusCallback focusCallback) {
        Camera camera = this.mCamera;
        if (camera == null) {
            return;
        }
        Camera.Parameters parameters = camera.getParameters();
        Rect calculateTapArea = calculateTapArea(f, f2, 1.0f, context);
        this.mCamera.cancelAutoFocus();
        if (parameters.getMaxNumFocusAreas() > 0) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new Camera.Area(calculateTapArea, 800));
            parameters.setFocusAreas(arrayList);
            final String focusMode = parameters.getFocusMode();
            try {
                parameters.setFocusMode("auto");
                this.mCamera.setParameters(parameters);
                this.mCamera.autoFocus(new Camera.AutoFocusCallback() { // from class: com.camera.CameraInterface.4
                    @Override // android.hardware.Camera.AutoFocusCallback
                    public void onAutoFocus(boolean z, Camera camera2) {
                        if (z || CameraInterface.this.handlerTime > 10) {
                            Camera.Parameters parameters2 = camera2.getParameters();
                            parameters2.setFocusMode(focusMode);
                            camera2.setParameters(parameters2);
                            CameraInterface.this.handlerTime = 0;
                            focusCallback.focusSuccess();
                            return;
                        }
                        CameraInterface.this.handlerTime++;
                        CameraInterface.this.handleFocus(context, f, f2, focusCallback);
                    }
                });
                return;
            } catch (Exception unused) {
                Log.e(TAG, "autoFocus failer");
                return;
            }
        }
        Log.i(TAG, "focus areas not supported");
        focusCallback.focusSuccess();
    }

    private static Rect calculateTapArea(float f, float f2, float f3, Context context) {
        int screenWidth = (int) (((f / ScreenUtils.getScreenWidth(context)) * 2000.0f) - 1000.0f);
        int screenHeight = (int) (((f2 / ScreenUtils.getScreenHeight(context)) * 2000.0f) - 1000.0f);
        int intValue = Float.valueOf(f3 * 300.0f).intValue() / 2;
        RectF rectF = new RectF(clamp(screenWidth - intValue, -1000, 1000), clamp(screenHeight - intValue, -1000, 1000), r2 + r4, r3 + r4);
        return new Rect(Math.round(rectF.left), Math.round(rectF.top), Math.round(rectF.right), Math.round(rectF.bottom));
    }

    void setErrorLinsenter(ErrorListener errorListener) {
        this.errorLisenter = errorListener;
    }

    void registerSensorManager(Context context) {
        if (this.sm == null) {
            this.sm = (SensorManager) context.getSystemService("sensor");
        }
        SensorManager sensorManager = this.sm;
        sensorManager.registerListener(this.sensorEventListener, sensorManager.getDefaultSensor(1), 3);
    }

    void unregisterSensorManager(Context context) {
        if (this.sm == null) {
            this.sm = (SensorManager) context.getSystemService("sensor");
        }
        this.sm.unregisterListener(this.sensorEventListener);
    }

    void isPreview(boolean z) {
        this.isPreviewing = z;
    }
}
