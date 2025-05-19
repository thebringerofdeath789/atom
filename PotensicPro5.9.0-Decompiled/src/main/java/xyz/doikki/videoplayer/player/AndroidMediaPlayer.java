package xyz.doikki.videoplayer.player;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.view.Surface;
import android.view.SurfaceHolder;
import java.util.Map;

/* loaded from: classes6.dex */
public class AndroidMediaPlayer extends AbstractPlayer implements MediaPlayer.OnErrorListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnInfoListener, MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnVideoSizeChangedListener {
    private Context mAppContext;
    private int mBufferedPercent;
    private boolean mIsPreparing;
    protected MediaPlayer mMediaPlayer;

    @Override // xyz.doikki.videoplayer.player.AbstractPlayer
    public long getTcpSpeed() {
        return 0L;
    }

    @Override // xyz.doikki.videoplayer.player.AbstractPlayer
    public void setOptions() {
    }

    public AndroidMediaPlayer(Context context) {
        this.mAppContext = context.getApplicationContext();
    }

    @Override // xyz.doikki.videoplayer.player.AbstractPlayer
    public void initPlayer() {
        this.mMediaPlayer = new MediaPlayer();
        setOptions();
        this.mMediaPlayer.setAudioStreamType(3);
        this.mMediaPlayer.setOnErrorListener(this);
        this.mMediaPlayer.setOnCompletionListener(this);
        this.mMediaPlayer.setOnInfoListener(this);
        this.mMediaPlayer.setOnBufferingUpdateListener(this);
        this.mMediaPlayer.setOnPreparedListener(this);
        this.mMediaPlayer.setOnVideoSizeChangedListener(this);
    }

    @Override // xyz.doikki.videoplayer.player.AbstractPlayer
    public void setDataSource(String str, Map<String, String> map) {
        try {
            this.mMediaPlayer.setDataSource(this.mAppContext, Uri.parse(str), map);
        } catch (Exception unused) {
            this.mPlayerEventListener.onError();
        }
    }

    @Override // xyz.doikki.videoplayer.player.AbstractPlayer
    public void setDataSource(AssetFileDescriptor assetFileDescriptor) {
        try {
            this.mMediaPlayer.setDataSource(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength());
        } catch (Exception unused) {
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
    public void pause() {
        try {
            this.mMediaPlayer.pause();
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
            this.mIsPreparing = true;
            this.mMediaPlayer.prepareAsync();
        } catch (IllegalStateException unused) {
            this.mPlayerEventListener.onError();
        }
    }

    @Override // xyz.doikki.videoplayer.player.AbstractPlayer
    public void reset() {
        stop();
        this.mMediaPlayer.reset();
        this.mMediaPlayer.setSurface(null);
        this.mMediaPlayer.setDisplay(null);
        this.mMediaPlayer.setVolume(1.0f, 1.0f);
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

    /* JADX WARN: Type inference failed for: r1v1, types: [xyz.doikki.videoplayer.player.AndroidMediaPlayer$1] */
    @Override // xyz.doikki.videoplayer.player.AbstractPlayer
    public void release() {
        this.mMediaPlayer.setOnErrorListener(null);
        this.mMediaPlayer.setOnCompletionListener(null);
        this.mMediaPlayer.setOnInfoListener(null);
        this.mMediaPlayer.setOnBufferingUpdateListener(null);
        this.mMediaPlayer.setOnPreparedListener(null);
        this.mMediaPlayer.setOnVideoSizeChangedListener(null);
        stop();
        final MediaPlayer mediaPlayer = this.mMediaPlayer;
        this.mMediaPlayer = null;
        new Thread() { // from class: xyz.doikki.videoplayer.player.AndroidMediaPlayer.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                try {
                    mediaPlayer.release();
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
        try {
            this.mMediaPlayer.setSurface(surface);
        } catch (Exception unused) {
            this.mPlayerEventListener.onError();
        }
    }

    @Override // xyz.doikki.videoplayer.player.AbstractPlayer
    public void setDisplay(SurfaceHolder surfaceHolder) {
        try {
            this.mMediaPlayer.setDisplay(surfaceHolder);
        } catch (Exception unused) {
            this.mPlayerEventListener.onError();
        }
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
        if (Build.VERSION.SDK_INT >= 23) {
            try {
                MediaPlayer mediaPlayer = this.mMediaPlayer;
                mediaPlayer.setPlaybackParams(mediaPlayer.getPlaybackParams().setSpeed(f));
            } catch (Exception unused) {
                this.mPlayerEventListener.onError();
            }
        }
    }

    @Override // xyz.doikki.videoplayer.player.AbstractPlayer
    public float getSpeed() {
        if (Build.VERSION.SDK_INT < 23) {
            return 1.0f;
        }
        try {
            return this.mMediaPlayer.getPlaybackParams().getSpeed();
        } catch (Exception unused) {
            this.mPlayerEventListener.onError();
            return 1.0f;
        }
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        this.mPlayerEventListener.onError();
        return true;
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        this.mPlayerEventListener.onCompletion();
    }

    @Override // android.media.MediaPlayer.OnInfoListener
    public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
        if (i == 3) {
            if (!this.mIsPreparing) {
                return true;
            }
            this.mPlayerEventListener.onInfo(i, i2);
            this.mIsPreparing = false;
            return true;
        }
        this.mPlayerEventListener.onInfo(i, i2);
        return true;
    }

    @Override // android.media.MediaPlayer.OnBufferingUpdateListener
    public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
        this.mBufferedPercent = i;
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public void onPrepared(MediaPlayer mediaPlayer) {
        this.mPlayerEventListener.onPrepared();
        start();
        if (isVideo()) {
            return;
        }
        this.mPlayerEventListener.onInfo(3, 0);
    }

    private boolean isVideo() {
        try {
            for (MediaPlayer.TrackInfo trackInfo : this.mMediaPlayer.getTrackInfo()) {
                if (trackInfo.getTrackType() == 1) {
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
    public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
        int videoWidth = mediaPlayer.getVideoWidth();
        int videoHeight = mediaPlayer.getVideoHeight();
        if (videoWidth == 0 || videoHeight == 0) {
            return;
        }
        this.mPlayerEventListener.onVideoSizeChanged(videoWidth, videoHeight);
    }
}
