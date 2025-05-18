package com.mapbox.mapboxsdk.maps.renderer;

import android.content.Context;
import com.mapbox.mapboxsdk.LibraryLoader;
import com.mapbox.mapboxsdk.log.Logger;
import com.mapbox.mapboxsdk.maps.GlyphsRasterizationMode;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* loaded from: classes3.dex */
public abstract class MapRenderer implements MapRendererScheduler {
    private static final String TAG = "Mbgl-MapRenderer";
    private MapboxMap.OnFpsChangedListener onFpsChangedListener;
    private long timeElapsed;
    private long nativePtr = 0;
    private double expectedRenderTime = 0.0d;

    private native void nativeInitialize(MapRenderer mapRenderer, float f, int i, String str);

    private native void nativeOnSurfaceChanged(int i, int i2);

    private native void nativeOnSurfaceCreated();

    private native void nativeOnSurfaceDestroyed();

    private native void nativeRender();

    protected native void finalize() throws Throwable;

    /* JADX INFO: Access modifiers changed from: protected */
    public native void nativeReset();

    public void onDestroy() {
    }

    public void onPause() {
    }

    public void onResume() {
    }

    public void onStart() {
    }

    public void onStop() {
    }

    static {
        LibraryLoader.load();
    }

    public MapRenderer(Context context, GlyphsRasterizationMode glyphsRasterizationMode, String str) {
        nativeInitialize(this, context.getResources().getDisplayMetrics().density, glyphsRasterizationMode.ordinal(), str);
    }

    public void setOnFpsChangedListener(MapboxMap.OnFpsChangedListener onFpsChangedListener) {
        this.onFpsChangedListener = onFpsChangedListener;
    }

    protected void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        nativeOnSurfaceCreated();
    }

    protected void onSurfaceChanged(GL10 gl10, int i, int i2) {
        gl10.glViewport(0, 0, i, i2);
        nativeOnSurfaceChanged(i, i2);
    }

    protected void onSurfaceDestroyed() {
        nativeOnSurfaceDestroyed();
    }

    protected void onDrawFrame(GL10 gl10) {
        long nanoTime = System.nanoTime();
        try {
            nativeRender();
        } catch (Error e) {
            Logger.m1756e(TAG, e.getMessage());
        }
        double nanoTime2 = System.nanoTime() - nanoTime;
        double d = this.expectedRenderTime;
        if (nanoTime2 < d) {
            try {
                Thread.sleep((long) ((d - nanoTime2) / 1000000.0d));
            } catch (InterruptedException e2) {
                Logger.m1756e(TAG, e2.getMessage());
            }
        }
        if (this.onFpsChangedListener != null) {
            updateFps();
        }
    }

    void queueEvent(MapRendererRunnable mapRendererRunnable) {
        queueEvent((Runnable) mapRendererRunnable);
    }

    private void updateFps() {
        long nanoTime = System.nanoTime();
        this.onFpsChangedListener.onFpsChanged(1.0E9d / (nanoTime - this.timeElapsed));
        this.timeElapsed = nanoTime;
    }

    public void setMaximumFps(int i) {
        if (i <= 0) {
            return;
        }
        this.expectedRenderTime = 1.0E9d / i;
    }
}