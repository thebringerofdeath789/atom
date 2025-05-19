package xyz.doikki.videoplayer.render;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import xyz.doikki.videoplayer.player.AbstractPlayer;

/* loaded from: classes6.dex */
public class TextureRenderView extends TextureView implements IRenderView, TextureView.SurfaceTextureListener {
    private MeasureHelper mMeasureHelper;
    private AbstractPlayer mMediaPlayer;
    private Surface mSurface;
    private SurfaceTexture mSurfaceTexture;

    @Override // xyz.doikki.videoplayer.render.IRenderView
    public View getView() {
        return this;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        return false;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    public TextureRenderView(Context context) {
        super(context);
        this.mMeasureHelper = new MeasureHelper();
        setSurfaceTextureListener(this);
    }

    @Override // xyz.doikki.videoplayer.render.IRenderView
    public void attachToPlayer(AbstractPlayer abstractPlayer) {
        this.mMediaPlayer = abstractPlayer;
    }

    @Override // xyz.doikki.videoplayer.render.IRenderView
    public void setVideoSize(int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            return;
        }
        this.mMeasureHelper.setVideoSize(i, i2);
        requestLayout();
    }

    @Override // xyz.doikki.videoplayer.render.IRenderView
    public void setVideoRotation(int i) {
        this.mMeasureHelper.setVideoRotation(i);
        setRotation(i);
    }

    @Override // xyz.doikki.videoplayer.render.IRenderView
    public void setScaleType(int i) {
        this.mMeasureHelper.setScreenScale(i);
        requestLayout();
    }

    @Override // xyz.doikki.videoplayer.render.IRenderView
    public Bitmap doScreenShot() {
        return getBitmap();
    }

    @Override // xyz.doikki.videoplayer.render.IRenderView
    public void release() {
        Surface surface = this.mSurface;
        if (surface != null) {
            surface.release();
        }
        SurfaceTexture surfaceTexture = this.mSurfaceTexture;
        if (surfaceTexture != null) {
            surfaceTexture.release();
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int[] doMeasure = this.mMeasureHelper.doMeasure(i, i2);
        setMeasuredDimension(doMeasure[0], doMeasure[1]);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        SurfaceTexture surfaceTexture2 = this.mSurfaceTexture;
        if (surfaceTexture2 != null) {
            setSurfaceTexture(surfaceTexture2);
            return;
        }
        this.mSurfaceTexture = surfaceTexture;
        Surface surface = new Surface(surfaceTexture);
        this.mSurface = surface;
        AbstractPlayer abstractPlayer = this.mMediaPlayer;
        if (abstractPlayer != null) {
            abstractPlayer.setSurface(surface);
        }
    }
}
