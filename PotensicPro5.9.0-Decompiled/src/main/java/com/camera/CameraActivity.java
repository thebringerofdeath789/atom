package com.camera;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import com.camera.cameralibrary.R;
import com.camera.listener.ClickListener;
import com.camera.listener.ErrorListener;
import com.camera.listener.JCameraListener;
import com.camera.util.DeviceUtil;
import com.camera.util.FileUtil;
import com.ipotensic.baselib.base.BaseActivity;
import java.io.File;

/* loaded from: classes.dex */
public class CameraActivity extends BaseActivity {
    public static final int ONLY_RECORD_VIDEO = 2;
    public static final int ONLY_TAKE_PICTURE = 1;
    public static final int TAKE_PIC_AND_RECORD_VIDEO = 0;
    public static final String TYPE = "type";
    private JCameraView jCameraView;
    private int type;

    @Override // com.ipotensic.baselib.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent != null) {
            this.type = intent.getIntExtra("type", 0);
        }
        getWindow().setFlags(1024, 1024);
        setRequestedOrientation(1);
        setContentView(R.layout.activity_camera);
        JCameraView jCameraView = (JCameraView) findViewById(R.id.jcameraview);
        this.jCameraView = jCameraView;
        jCameraView.setSaveVideoPath(getCacheDir().getPath() + File.separator + "JCamera");
        int i = this.type;
        if (i == 0) {
            this.jCameraView.setFeatures(JCameraView.BUTTON_STATE_BOTH);
        } else if (i == 1) {
            this.jCameraView.setFeatures(257);
        } else if (i == 2) {
            this.jCameraView.setFeatures(JCameraView.BUTTON_STATE_ONLY_RECORDER);
        }
        this.jCameraView.setMediaQuality(JCameraView.MEDIA_QUALITY_HIGH);
        this.jCameraView.setErrorLisenter(new ErrorListener() { // from class: com.camera.CameraActivity.1
            @Override // com.camera.listener.ErrorListener
            public void AudioPermissionError() {
            }

            @Override // com.camera.listener.ErrorListener
            public void onError() {
                Log.i("CJT", "camera error");
                CameraActivity.this.setResult(103, new Intent());
                CameraActivity.this.finish();
            }
        });
        this.jCameraView.setJCameraLisenter(new JCameraListener() { // from class: com.camera.CameraActivity.2
            @Override // com.camera.listener.JCameraListener
            public void captureSuccess(Bitmap bitmap) {
                FileUtil.saveBitmap("JCamera", bitmap, new FileUtil.OnWriteCompleteListener() { // from class: com.camera.CameraActivity.2.1
                    @Override // com.camera.util.FileUtil.OnWriteCompleteListener
                    public void getStoragePath(String str) {
                        Intent intent2 = new Intent();
                        intent2.putExtra("path", str);
                        CameraActivity.this.setResult(100, intent2);
                        CameraActivity.this.finish();
                    }
                });
            }

            @Override // com.camera.listener.JCameraListener
            public void recordSuccess(final String str, Bitmap bitmap) {
                FileUtil.saveBitmap("JCamera", bitmap, new FileUtil.OnWriteCompleteListener() { // from class: com.camera.CameraActivity.2.2
                    @Override // com.camera.util.FileUtil.OnWriteCompleteListener
                    public void getStoragePath(String str2) {
                        Log.i("CJT", "url = " + str + ", Bitmap = " + str2);
                        Intent intent2 = new Intent();
                        intent2.putExtra("firstFrame", str2);
                        intent2.putExtra("videoPath", str);
                        CameraActivity.this.setResult(101, intent2);
                        CameraActivity.this.finish();
                    }
                });
            }
        });
        this.jCameraView.setLeftClickListener(new ClickListener() { // from class: com.camera.CameraActivity.3
            @Override // com.camera.listener.ClickListener
            public void onClick() {
                CameraActivity.this.finish();
            }
        });
        this.jCameraView.setRightClickListener(new ClickListener() { // from class: com.camera.CameraActivity.4
            @Override // com.camera.listener.ClickListener
            public void onClick() {
                Toast.makeText(CameraActivity.this, "Right", 0).show();
            }
        });
        Log.i("CJT", DeviceUtil.getDeviceModel());
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        super.onStart();
        if (Build.VERSION.SDK_INT >= 19) {
            getWindow().getDecorView().setSystemUiVisibility(5894);
        } else {
            getWindow().getDecorView().setSystemUiVisibility(4);
        }
    }

    @Override // com.ipotensic.baselib.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        this.jCameraView.onResume();
    }

    @Override // com.ipotensic.baselib.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        this.jCameraView.onPause();
    }
}
