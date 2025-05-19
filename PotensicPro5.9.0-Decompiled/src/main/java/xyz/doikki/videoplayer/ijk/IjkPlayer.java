package xyz.doikki.videoplayer.ijk;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Surface;
import android.view.SurfaceHolder;
import java.util.Map;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;
import tv.danmaku.ijk.media.player.misc.IjkTrackInfo;
import xyz.doikki.videoplayer.player.AbstractPlayer;
import xyz.doikki.videoplayer.player.VideoViewManager;

/* loaded from: classes6.dex */
public class IjkPlayer extends AbstractPlayer implements IMediaPlayer.OnErrorListener, IMediaPlayer.OnCompletionListener, IMediaPlayer.OnInfoListener, IMediaPlayer.OnBufferingUpdateListener, IMediaPlayer.OnPreparedListener, IMediaPlayer.OnVideoSizeChangedListener, IjkMediaPlayer.OnNativeInvokeListener {
    private final Context mAppContext;
    private int mBufferedPercent;
    protected IjkMediaPlayer mMediaPlayer;

    @Override // tv.danmaku.ijk.media.player.IjkMediaPlayer.OnNativeInvokeListener
    public boolean onNativeInvoke(int i, Bundle bundle) {
        return true;
    }

    @Override // xyz.doikki.videoplayer.player.AbstractPlayer
    public void setOptions() {
    }

    public IjkPlayer(Context context) {
        this.mAppContext = context;
    }

    @Override // xyz.doikki.videoplayer.player.AbstractPlayer
    public void initPlayer() {
        this.mMediaPlayer = new IjkMediaPlayer();
        IjkMediaPlayer.native_setLogLevel(VideoViewManager.getConfig().mIsEnableLog ? 4 : 8);
        setOptions();
        this.mMediaPlayer.setOnErrorListener(this);
        this.mMediaPlayer.setOnCompletionListener(this);
        this.mMediaPlayer.setOnInfoListener(this);
        this.mMediaPlayer.setOnBufferingUpdateListener(this);
        this.mMediaPlayer.setOnPreparedListener(this);
        this.mMediaPlayer.setOnVideoSizeChangedListener(this);
        this.mMediaPlayer.setOnNativeInvokeListener(this);
    }

    @Override // xyz.doikki.videoplayer.player.AbstractPlayer
    public void setDataSource(String str, Map<String, String> map) {
        try {
            Uri parse = Uri.parse(str);
            if ("android.resource".equals(parse.getScheme())) {
                this.mMediaPlayer.setDataSource(RawDataSourceProvider.create(this.mAppContext, parse));
                return;
            }
            if (map != null) {
                String str2 = map.get("User-Agent");
                if (!TextUtils.isEmpty(str2)) {
                    this.mMediaPlayer.setOption(1, "user_agent", str2);
                    map.remove("User-Agent");
                }
            }
            this.mMediaPlayer.setDataSource(this.mAppContext, parse, map);
        } catch (Exception unused) {
            this.mPlayerEventListener.onError();
        }
    }

    @Override // xyz.doikki.videoplayer.player.AbstractPlayer
    public void setDataSource(AssetFileDescriptor assetFileDescriptor) {
        try {
            this.mMediaPlayer.setDataSource(new RawDataSourceProvider(assetFileDescriptor));
        } catch (Exception unused) {
            this.mPlayerEventListener.onError();
        }
    }

    @Override // xyz.doikki.videoplayer.player.AbstractPlayer
    public void pause() {
        try {
            this.mMediaPlayer.pause();
        } catch (IllegalStateException unused) {
            this.mPlayerEventListener.onError();
        }
    }

    @Override // xyz.doikki.videoplayer.player.AbstractPlayer
    public void start() {
        try {
            this.mMediaPlayer.start();
        } catch (IllegalStateException unused) {
            this.mPlayerEventListener.onError();
        }
    }

    @Override // xyz.doikki.videoplayer.player.AbstractPlayer
    public void stop() {
        try {
            this.mMediaPlayer.stop();
        } catch (IllegalStateException unused) {
            this.mPlayerEventListener.onError();
        }
    }

    @Override // xyz.doikki.videoplayer.player.AbstractPlayer
    public void prepareAsync() {
        try {
            this.mMediaPlayer.prepareAsync();
        } catch (IllegalStateException unused) {
            this.mPlayerEventListener.onError();
        }
    }

    @Override // xyz.doikki.videoplayer.player.AbstractPlayer
    public void reset() {
        this.mMediaPlayer.reset();
        this.mMediaPlayer.setOnVideoSizeChangedListener(this);
        setOptions();
    }

    @Override // xyz.doikki.videoplayer.player.AbstractPlayer
    public boolean isPlaying() {
        return this.mMediaPlayer.isPlaying();
    }

    @Override // xyz.doikki.videoplayer.player.AbstractPlayer
    public void seekTo(long j) {
        try {
            this.mMediaPlayer.seekTo((int) j);
        } catch (IllegalStateException unused) {
            this.mPlayerEventListener.onError();
        }
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [xyz.doikki.videoplayer.ijk.IjkPlayer$1] */
    @Override // xyz.doikki.videoplayer.player.AbstractPlayer
    public void release() {
        this.mMediaPlayer.setOnErrorListener(null);
        this.mMediaPlayer.setOnCompletionListener(null);
        this.mMediaPlayer.setOnInfoListener(null);
        this.mMediaPlayer.setOnBufferingUpdateListener(null);
        this.mMediaPlayer.setOnPreparedListener(null);
        this.mMediaPlayer.setOnVideoSizeChangedListener(null);
        new Thread() { // from class: xyz.doikki.videoplayer.ijk.IjkPlayer.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                try {
                    IjkPlayer.this.mMediaPlayer.release();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }

    @Override // xyz.doikki.videoplayer.player.AbstractPlayer
    public long getCurrentPosition() {
        return this.mMediaPlayer.getCurrentPosition();
    }

    @Override // xyz.doikki.videoplayer.player.AbstractPlayer
    public long getDuration() {
        return this.mMediaPlayer.getDuration();
    }

    @Override // xyz.doikki.videoplayer.player.AbstractPlayer
    public int getBufferedPercentage() {
        return this.mBufferedPercent;
    }

    @Override // xyz.doikki.videoplayer.player.AbstractPlayer
    public void setSurface(Surface surface) {
        this.mMediaPlayer.setSurface(surface);
    }

    @Override // xyz.doikki.videoplayer.player.AbstractPlayer
    public void setDisplay(SurfaceHolder surfaceHolder) {
        this.mMediaPlayer.setDisplay(surfaceHolder);
    }

    @Override // xyz.doikki.videoplayer.player.AbstractPlayer
    public void setVolume(float f, float f2) {
        this.mMediaPlayer.setVolume(f, f2);
    }

    @Override // xyz.doikki.videoplayer.player.AbstractPlayer
    public void setLooping(boolean z) {
        this.mMediaPlayer.setLooping(z);
    }

    @Override // xyz.doikki.videoplayer.player.AbstractPlayer
    public void setSpeed(float f) {
        this.mMediaPlayer.setSpeed(f);
    }

    @Override // xyz.doikki.videoplayer.player.AbstractPlayer
    public float getSpeed() {
        return this.mMediaPlayer.getSpeed(0.0f);
    }

    @Override // xyz.doikki.videoplayer.player.AbstractPlayer
    public long getTcpSpeed() {
        return this.mMediaPlayer.getTcpSpeed();
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnErrorListener
    public boolean onError(IMediaPlayer iMediaPlayer, int i, int i2) {
        this.mPlayerEventListener.onError();
        return true;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnCompletionListener
    public void onCompletion(IMediaPlayer iMediaPlayer) {
        this.mPlayerEventListener.onCompletion();
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnInfoListener
    public boolean onInfo(IMediaPlayer iMediaPlayer, int i, int i2) {
        this.mPlayerEventListener.onInfo(i, i2);
        return true;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnBufferingUpdateListener
    public void onBufferingUpdate(IMediaPlayer iMediaPlayer, int i) {
        this.mBufferedPercent = i;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnPreparedListener
    public void onPrepared(IMediaPlayer iMediaPlayer) {
        this.mPlayerEventListener.onPrepared();
        if (isVideo()) {
            return;
        }
        this.mPlayerEventListener.onInfo(3, 0);
    }

    private boolean isVideo() {
        IjkTrackInfo[] trackInfo = this.mMediaPlayer.getTrackInfo();
        if (trackInfo == null) {
            return false;
        }
        for (IjkTrackInfo ijkTrackInfo : trackInfo) {
            if (ijkTrackInfo.getTrackType() == 1) {
                return true;
            }
        }
        return false;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnVideoSizeChangedListener
    public void onVideoSizeChanged(IMediaPlayer iMediaPlayer, int i, int i2, int i3, int i4) {
        int videoWidth = iMediaPlayer.getVideoWidth();
        int videoHeight = iMediaPlayer.getVideoHeight();
        if (videoWidth == 0 || videoHeight == 0) {
            return;
        }
        this.mPlayerEventListener.onVideoSizeChanged(videoWidth, videoHeight);
    }
}
