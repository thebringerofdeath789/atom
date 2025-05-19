package com.mapbox.mapboxsdk.maps.renderer.glsurfaceview;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.mapbox.mapboxsdk.maps.renderer.egl.EGLLogWrapper;
import java.io.Writer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL;

/* loaded from: classes3.dex */
public class MapboxGLSurfaceView extends SurfaceView implements SurfaceHolder.Callback2 {
    private static final String TAG = "GLSurfaceView";
    private static final GLThreadManager glThreadManager = new GLThreadManager();
    private boolean detached;
    private OnGLSurfaceViewDetachedListener detachedListener;
    private GLSurfaceView.EGLConfigChooser eglConfigChooser;
    private GLSurfaceView.EGLContextFactory eglContextFactory;
    private GLSurfaceView.EGLWindowSurfaceFactory eglWindowSurfaceFactory;
    private GLThread glThread;
    private boolean preserveEGLContextOnPause;
    private GLSurfaceView.Renderer renderer;
    private final WeakReference<MapboxGLSurfaceView> viewWeakReference;

    public interface OnGLSurfaceViewDetachedListener {
        void onGLSurfaceViewDetached();
    }

    @Override // android.view.SurfaceHolder.Callback2
    @Deprecated
    public void surfaceRedrawNeeded(SurfaceHolder surfaceHolder) {
    }

    public MapboxGLSurfaceView(Context context) {
        super(context);
        this.viewWeakReference = new WeakReference<>(this);
        init();
    }

    public MapboxGLSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.viewWeakReference = new WeakReference<>(this);
        init();
    }

    private void init() {
        getHolder().addCallback(this);
    }

    protected void finalize() throws Throwable {
        try {
            GLThread gLThread = this.glThread;
            if (gLThread != null) {
                gLThread.requestExitAndWait();
            }
        } finally {
            super.finalize();
        }
    }

    public void setDetachedListener(OnGLSurfaceViewDetachedListener onGLSurfaceViewDetachedListener) {
        if (this.detachedListener != null) {
            throw new IllegalArgumentException("Detached from window listener has been already set.");
        }
        this.detachedListener = onGLSurfaceViewDetachedListener;
    }

    public void setPreserveEGLContextOnPause(boolean z) {
        this.preserveEGLContextOnPause = z;
    }

    public boolean getPreserveEGLContextOnPause() {
        return this.preserveEGLContextOnPause;
    }

    public void setRenderer(GLSurfaceView.Renderer renderer) {
        checkRenderThreadState();
        if (this.eglConfigChooser == null) {
            throw new IllegalStateException("No eglConfigChooser provided");
        }
        if (this.eglContextFactory == null) {
            throw new IllegalStateException("No eglContextFactory provided");
        }
        if (this.eglWindowSurfaceFactory == null) {
            throw new IllegalStateException("No eglWindowSurfaceFactory provided");
        }
        this.renderer = renderer;
        GLThread gLThread = new GLThread(this.viewWeakReference);
        this.glThread = gLThread;
        gLThread.start();
    }

    public void setEGLContextFactory(GLSurfaceView.EGLContextFactory eGLContextFactory) {
        checkRenderThreadState();
        this.eglContextFactory = eGLContextFactory;
    }

    public void setEGLWindowSurfaceFactory(GLSurfaceView.EGLWindowSurfaceFactory eGLWindowSurfaceFactory) {
        checkRenderThreadState();
        this.eglWindowSurfaceFactory = eGLWindowSurfaceFactory;
    }

    public void setEGLConfigChooser(GLSurfaceView.EGLConfigChooser eGLConfigChooser) {
        checkRenderThreadState();
        this.eglConfigChooser = eGLConfigChooser;
    }

    public void setRenderMode(int i) {
        this.glThread.setRenderMode(i);
    }

    public int getRenderMode() {
        return this.glThread.getRenderMode();
    }

    public void requestRender() {
        this.glThread.requestRender();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.glThread.surfaceCreated();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.glThread.surfaceDestroyed();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        this.glThread.onWindowResize(i2, i3);
    }

    @Override // android.view.SurfaceHolder.Callback2
    public void surfaceRedrawNeededAsync(SurfaceHolder surfaceHolder, Runnable runnable) {
        GLThread gLThread = this.glThread;
        if (gLThread != null) {
            gLThread.requestRenderAndNotify(runnable);
        }
    }

    public void onPause() {
        this.glThread.onPause();
    }

    public void onResume() {
        this.glThread.onResume();
    }

    public void queueEvent(Runnable runnable) {
        this.glThread.queueEvent(runnable);
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.detached && this.renderer != null) {
            GLThread gLThread = this.glThread;
            int renderMode = gLThread != null ? gLThread.getRenderMode() : 1;
            GLThread gLThread2 = new GLThread(this.viewWeakReference);
            this.glThread = gLThread2;
            if (renderMode != 1) {
                gLThread2.setRenderMode(renderMode);
            }
            this.glThread.start();
        }
        this.detached = false;
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onDetachedFromWindow() {
        OnGLSurfaceViewDetachedListener onGLSurfaceViewDetachedListener = this.detachedListener;
        if (onGLSurfaceViewDetachedListener != null) {
            onGLSurfaceViewDetachedListener.onGLSurfaceViewDetached();
        }
        GLThread gLThread = this.glThread;
        if (gLThread != null) {
            gLThread.requestExitAndWait();
        }
        this.detached = true;
        super.onDetachedFromWindow();
    }

    private static class EglHelper {
        EGL10 mEgl;
        EGLConfig mEglConfig;
        EGLContext mEglContext;
        EGLDisplay mEglDisplay;
        EGLSurface mEglSurface;
        private WeakReference<MapboxGLSurfaceView> mGLSurfaceViewWeakRef;

        private EglHelper(WeakReference<MapboxGLSurfaceView> weakReference) {
            this.mGLSurfaceViewWeakRef = weakReference;
        }

        public void start() {
            EGLDisplay eglGetDisplay;
            try {
                EGL10 egl10 = (EGL10) EGLContext.getEGL();
                this.mEgl = egl10;
                eglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
                this.mEglDisplay = eglGetDisplay;
            } catch (Exception e) {
                Log.e(MapboxGLSurfaceView.TAG, "createContext failed: ", e);
            }
            if (eglGetDisplay == EGL10.EGL_NO_DISPLAY) {
                Log.e(MapboxGLSurfaceView.TAG, "eglGetDisplay failed");
                return;
            }
            if (!this.mEgl.eglInitialize(this.mEglDisplay, new int[2])) {
                Log.e(MapboxGLSurfaceView.TAG, "eglInitialize failed");
                return;
            }
            MapboxGLSurfaceView mapboxGLSurfaceView = this.mGLSurfaceViewWeakRef.get();
            if (mapboxGLSurfaceView != null) {
                this.mEglConfig = mapboxGLSurfaceView.eglConfigChooser.chooseConfig(this.mEgl, this.mEglDisplay);
                this.mEglContext = mapboxGLSurfaceView.eglContextFactory.createContext(this.mEgl, this.mEglDisplay, this.mEglConfig);
            } else {
                this.mEglConfig = null;
                this.mEglContext = null;
            }
            EGLContext eGLContext = this.mEglContext;
            if (eGLContext == null || eGLContext == EGL10.EGL_NO_CONTEXT) {
                this.mEglContext = null;
                Log.e(MapboxGLSurfaceView.TAG, "createContext failed");
                return;
            }
            this.mEglSurface = null;
        }

        boolean createSurface() {
            if (this.mEgl == null) {
                Log.e(MapboxGLSurfaceView.TAG, "egl not initialized");
                return false;
            }
            if (this.mEglDisplay == null) {
                Log.e(MapboxGLSurfaceView.TAG, "eglDisplay not initialized");
                return false;
            }
            if (this.mEglConfig == null) {
                Log.e(MapboxGLSurfaceView.TAG, "mEglConfig not initialized");
                return false;
            }
            destroySurfaceImp();
            MapboxGLSurfaceView mapboxGLSurfaceView = this.mGLSurfaceViewWeakRef.get();
            if (mapboxGLSurfaceView != null) {
                this.mEglSurface = mapboxGLSurfaceView.eglWindowSurfaceFactory.createWindowSurface(this.mEgl, this.mEglDisplay, this.mEglConfig, mapboxGLSurfaceView.getHolder());
            } else {
                this.mEglSurface = null;
            }
            EGLSurface eGLSurface = this.mEglSurface;
            if (eGLSurface == null || eGLSurface == EGL10.EGL_NO_SURFACE) {
                if (this.mEgl.eglGetError() == 12299) {
                    Log.e(MapboxGLSurfaceView.TAG, "createWindowSurface returned EGL_BAD_NATIVE_WINDOW.");
                }
                return false;
            }
            EGL10 egl10 = this.mEgl;
            EGLDisplay eGLDisplay = this.mEglDisplay;
            EGLSurface eGLSurface2 = this.mEglSurface;
            if (egl10.eglMakeCurrent(eGLDisplay, eGLSurface2, eGLSurface2, this.mEglContext)) {
                return true;
            }
            logEglErrorAsWarning(MapboxGLSurfaceView.TAG, "eglMakeCurrent", this.mEgl.eglGetError());
            return false;
        }

        GL createGL() {
            return this.mEglContext.getGL();
        }

        public int swap() {
            if (this.mEgl.eglSwapBuffers(this.mEglDisplay, this.mEglSurface)) {
                return 12288;
            }
            return this.mEgl.eglGetError();
        }

        void destroySurface() {
            destroySurfaceImp();
        }

        private void destroySurfaceImp() {
            EGLSurface eGLSurface = this.mEglSurface;
            if (eGLSurface == null || eGLSurface == EGL10.EGL_NO_SURFACE) {
                return;
            }
            this.mEgl.eglMakeCurrent(this.mEglDisplay, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
            MapboxGLSurfaceView mapboxGLSurfaceView = this.mGLSurfaceViewWeakRef.get();
            if (mapboxGLSurfaceView != null) {
                mapboxGLSurfaceView.eglWindowSurfaceFactory.destroySurface(this.mEgl, this.mEglDisplay, this.mEglSurface);
            }
            this.mEglSurface = null;
        }

        public void finish() {
            if (this.mEglContext != null) {
                MapboxGLSurfaceView mapboxGLSurfaceView = this.mGLSurfaceViewWeakRef.get();
                if (mapboxGLSurfaceView != null) {
                    mapboxGLSurfaceView.eglContextFactory.destroyContext(this.mEgl, this.mEglDisplay, this.mEglContext);
                }
                this.mEglContext = null;
            }
            EGLDisplay eGLDisplay = this.mEglDisplay;
            if (eGLDisplay != null) {
                this.mEgl.eglTerminate(eGLDisplay);
                this.mEglDisplay = null;
            }
        }

        static void logEglErrorAsWarning(String str, String str2, int i) {
            Log.w(str, formatEglError(str2, i));
        }

        static String formatEglError(String str, int i) {
            return str + " failed: " + EGLLogWrapper.getErrorString(i);
        }
    }

    static class GLThread extends Thread {
        private EglHelper eglHelper;
        private boolean exited;
        private boolean finishedCreatingEglSurface;
        private boolean hasSurface;
        private boolean haveEglContext;
        private boolean haveEglSurface;
        private WeakReference<MapboxGLSurfaceView> mGLSurfaceViewWeakRef;
        private boolean paused;
        private boolean renderComplete;
        private boolean requestPaused;
        private boolean shouldExit;
        private boolean shouldReleaseEglContext;
        private boolean surfaceIsBad;
        private boolean waitingForSurface;
        private ArrayList<Runnable> eventQueue = new ArrayList<>();
        private boolean sizeChanged = true;
        private Runnable finishDrawingRunnable = null;
        private int width = 0;
        private int height = 0;
        private boolean requestRender = true;
        private int renderMode = 1;
        private boolean wantRenderNotification = false;

        GLThread(WeakReference<MapboxGLSurfaceView> weakReference) {
            this.mGLSurfaceViewWeakRef = weakReference;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            setName("GLThread " + getId());
            try {
                guardedRun();
            } catch (InterruptedException unused) {
            } catch (Throwable th) {
                MapboxGLSurfaceView.glThreadManager.threadExiting(this);
                throw th;
            }
            MapboxGLSurfaceView.glThreadManager.threadExiting(this);
        }

        private void stopEglSurfaceLocked() {
            if (this.haveEglSurface) {
                this.haveEglSurface = false;
                this.eglHelper.destroySurface();
            }
        }

        private void stopEglContextLocked() {
            if (this.haveEglContext) {
                this.eglHelper.finish();
                this.haveEglContext = false;
                MapboxGLSurfaceView.glThreadManager.releaseEglContextLocked(this);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:132:0x0211  */
        /* JADX WARN: Removed duplicated region for block: B:191:0x0237 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private void guardedRun() throws java.lang.InterruptedException {
            /*
                Method dump skipped, instructions count: 578
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mapbox.mapboxsdk.maps.renderer.glsurfaceview.MapboxGLSurfaceView.GLThread.guardedRun():void");
        }

        public boolean ableToDraw() {
            return this.haveEglContext && this.haveEglSurface && readyToDraw();
        }

        private boolean readyToDraw() {
            return !this.paused && this.hasSurface && !this.surfaceIsBad && this.width > 0 && this.height > 0 && (this.requestRender || this.renderMode == 1);
        }

        public void setRenderMode(int i) {
            synchronized (MapboxGLSurfaceView.glThreadManager) {
                this.renderMode = i;
                MapboxGLSurfaceView.glThreadManager.notifyAll();
            }
        }

        public int getRenderMode() {
            int i;
            synchronized (MapboxGLSurfaceView.glThreadManager) {
                i = this.renderMode;
            }
            return i;
        }

        public void requestRender() {
            synchronized (MapboxGLSurfaceView.glThreadManager) {
                this.requestRender = true;
                MapboxGLSurfaceView.glThreadManager.notifyAll();
            }
        }

        public void requestRenderAndNotify(Runnable runnable) {
            synchronized (MapboxGLSurfaceView.glThreadManager) {
                if (Thread.currentThread() == this) {
                    return;
                }
                this.wantRenderNotification = true;
                this.requestRender = true;
                this.renderComplete = false;
                this.finishDrawingRunnable = runnable;
                MapboxGLSurfaceView.glThreadManager.notifyAll();
            }
        }

        public void surfaceCreated() {
            synchronized (MapboxGLSurfaceView.glThreadManager) {
                this.hasSurface = true;
                this.finishedCreatingEglSurface = false;
                MapboxGLSurfaceView.glThreadManager.notifyAll();
                while (this.waitingForSurface && !this.finishedCreatingEglSurface && !this.exited) {
                    try {
                        MapboxGLSurfaceView.glThreadManager.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void surfaceDestroyed() {
            synchronized (MapboxGLSurfaceView.glThreadManager) {
                this.hasSurface = false;
                MapboxGLSurfaceView.glThreadManager.notifyAll();
                while (!this.waitingForSurface && !this.exited) {
                    try {
                        MapboxGLSurfaceView.glThreadManager.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void onPause() {
            synchronized (MapboxGLSurfaceView.glThreadManager) {
                this.requestPaused = true;
                MapboxGLSurfaceView.glThreadManager.notifyAll();
                while (!this.exited && !this.paused) {
                    try {
                        MapboxGLSurfaceView.glThreadManager.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void onResume() {
            synchronized (MapboxGLSurfaceView.glThreadManager) {
                this.requestPaused = false;
                this.requestRender = true;
                this.renderComplete = false;
                MapboxGLSurfaceView.glThreadManager.notifyAll();
                while (!this.exited && this.paused && !this.renderComplete) {
                    try {
                        MapboxGLSurfaceView.glThreadManager.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void onWindowResize(int i, int i2) {
            synchronized (MapboxGLSurfaceView.glThreadManager) {
                this.width = i;
                this.height = i2;
                this.sizeChanged = true;
                this.requestRender = true;
                this.renderComplete = false;
                if (Thread.currentThread() == this) {
                    return;
                }
                MapboxGLSurfaceView.glThreadManager.notifyAll();
                while (!this.exited && !this.paused && !this.renderComplete && ableToDraw()) {
                    try {
                        MapboxGLSurfaceView.glThreadManager.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void requestExitAndWait() {
            synchronized (MapboxGLSurfaceView.glThreadManager) {
                this.shouldExit = true;
                MapboxGLSurfaceView.glThreadManager.notifyAll();
                while (!this.exited) {
                    try {
                        MapboxGLSurfaceView.glThreadManager.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void requestReleaseEglContextLocked() {
            this.shouldReleaseEglContext = true;
            MapboxGLSurfaceView.glThreadManager.notifyAll();
        }

        public void queueEvent(Runnable runnable) {
            synchronized (MapboxGLSurfaceView.glThreadManager) {
                this.eventQueue.add(runnable);
                MapboxGLSurfaceView.glThreadManager.notifyAll();
            }
        }
    }

    static class LogWriter extends Writer {
        private StringBuilder mBuilder = new StringBuilder();

        LogWriter() {
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            flushBuilder();
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() {
            flushBuilder();
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int i, int i2) {
            for (int i3 = 0; i3 < i2; i3++) {
                char c = cArr[i + i3];
                if (c == '\n') {
                    flushBuilder();
                } else {
                    this.mBuilder.append(c);
                }
            }
        }

        private void flushBuilder() {
            if (this.mBuilder.length() > 0) {
                Log.v(MapboxGLSurfaceView.TAG, this.mBuilder.toString());
                StringBuilder sb = this.mBuilder;
                sb.delete(0, sb.length());
            }
        }
    }

    private void checkRenderThreadState() {
        if (this.glThread != null) {
            throw new IllegalStateException("setRenderer has already been called for this instance.");
        }
    }

    private static class GLThreadManager {
        private GLThreadManager() {
        }

        synchronized void threadExiting(GLThread gLThread) {
            gLThread.exited = true;
            notifyAll();
        }

        void releaseEglContextLocked(GLThread gLThread) {
            notifyAll();
        }
    }
}
