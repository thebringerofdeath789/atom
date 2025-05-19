package com.logan.nativeapp;

import android.graphics.SurfaceTexture;
import android.opengl.GLSurfaceView;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* loaded from: classes3.dex */
public class SampleGLRenderer implements GLSurfaceView.Renderer {
    private SampleGLES20Video sampleGL20Video;
    private SurfaceTexture surfaceTexture;

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        this.sampleGL20Video = new SampleGLES20Video();
        this.surfaceTexture = null;
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onDrawFrame(GL10 gl10) {
        SurfaceTexture surfaceTexture = this.surfaceTexture;
        if (surfaceTexture != null) {
            surfaceTexture.updateTexImage();
            this.surfaceTexture = null;
        }
        this.sampleGL20Video.draw();
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceChanged(GL10 gl10, int i, int i2) {
        this.sampleGL20Video.setResolution(i, i2);
    }

    public int getTextureHandle() {
        return this.sampleGL20Video.getTextureHandle();
    }

    public void updateTexture(SurfaceTexture surfaceTexture) {
        this.surfaceTexture = surfaceTexture;
    }

    public void screenshot(String str) {
        this.sampleGL20Video.screenshot(str);
    }
}
