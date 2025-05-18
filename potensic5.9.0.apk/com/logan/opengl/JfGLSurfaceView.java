package com.logan.opengl;

import android.content.Context;
import android.graphics.Bitmap;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;

/* loaded from: classes3.dex */
public class JfGLSurfaceView extends GLSurfaceView {
    private static final String TAG = "JfGLSurfaceView";
    private boolean isUserPause;
    private JfRender jfRender;
    private onYuvFrameReceiver yuvFrameReceiver;

    public interface onYuvFrameReceiver {
        void receiveYuv();
    }

    public JfGLSurfaceView(Context context) {
        this(context, null);
    }

    public JfGLSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isUserPause = false;
        setEGLContextClientVersion(2);
        JfRender jfRender = new JfRender(context, this);
        this.jfRender = jfRender;
        setRenderer(jfRender);
        setRenderMode(0);
    }

    public void setYUVData(int i, int i2, byte[] bArr, byte[] bArr2, byte[] bArr3) {
        if (this.isUserPause || this.jfRender == null) {
            return;
        }
        onYuvFrameReceiver onyuvframereceiver = this.yuvFrameReceiver;
        if (onyuvframereceiver != null) {
            onyuvframereceiver.receiveYuv();
        }
        this.jfRender.setYUVRenderData(i, i2, bArr, bArr2, bArr3);
        requestRender();
    }

    public void setScale(float f) {
        JfRender jfRender = this.jfRender;
        if (jfRender != null) {
            jfRender.scale(f);
        }
    }

    public void setRotate(int i) {
        JfRender jfRender = this.jfRender;
        if (jfRender != null) {
            jfRender.rotate(i);
        }
    }

    public void setAnimating(boolean z) {
        JfRender jfRender = this.jfRender;
        if (jfRender != null) {
            jfRender.setAnimating(z);
        }
    }

    public Bitmap getBitmap() {
        JfRender jfRender = this.jfRender;
        if (jfRender != null) {
            return jfRender.getBitmap();
        }
        return null;
    }

    public void pause() {
        this.isUserPause = true;
    }

    public void resume() {
        this.isUserPause = false;
    }

    public void setYuvFrameReceiver(onYuvFrameReceiver onyuvframereceiver) {
        this.yuvFrameReceiver = onyuvframereceiver;
    }
}