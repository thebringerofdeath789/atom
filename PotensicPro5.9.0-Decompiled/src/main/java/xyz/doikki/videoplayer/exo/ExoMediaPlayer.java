package xyz.doikki.videoplayer.exo;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.google.android.exoplayer2.DefaultLoadControl;
import com.google.android.exoplayer2.DefaultRenderersFactory;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.LoadControl;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.RenderersFactory;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.analytics.AnalyticsCollector;
import com.google.android.exoplayer2.source.DefaultMediaSourceFactory;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.MappingTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;
import com.google.android.exoplayer2.util.Clock;
import com.google.android.exoplayer2.util.EventLogger;
import com.google.android.exoplayer2.video.VideoSize;
import java.util.Map;
import xyz.doikki.videoplayer.player.AbstractPlayer;
import xyz.doikki.videoplayer.player.VideoViewManager;

/* loaded from: classes6.dex */
public class ExoMediaPlayer extends AbstractPlayer implements Player.Listener {
    protected Context mAppContext;
    protected SimpleExoPlayer mInternalPlayer;
    private boolean mIsPreparing;
    private LoadControl mLoadControl;
    protected MediaSource mMediaSource;
    protected ExoMediaSourceHelper mMediaSourceHelper;
    private RenderersFactory mRenderersFactory;
    private PlaybackParameters mSpeedPlaybackParameters;
    private TrackSelector mTrackSelector;

    @Override // xyz.doikki.videoplayer.player.AbstractPlayer
    public long getTcpSpeed() {
        return 0L;
    }

    @Override // xyz.doikki.videoplayer.player.AbstractPlayer
    public void setDataSource(AssetFileDescriptor assetFileDescriptor) {
    }

    public ExoMediaPlayer(Context context) {
        this.mAppContext = context.getApplicationContext();
        this.mMediaSourceHelper = ExoMediaSourceHelper.getInstance(context);
    }

    @Override // xyz.doikki.videoplayer.player.AbstractPlayer
    public void initPlayer() {
        Context context = this.mAppContext;
        RenderersFactory renderersFactory = this.mRenderersFactory;
        if (renderersFactory == null) {
            renderersFactory = new DefaultRenderersFactory(this.mAppContext);
            this.mRenderersFactory = renderersFactory;
        }
        RenderersFactory renderersFactory2 = renderersFactory;
        TrackSelector trackSelector = this.mTrackSelector;
        if (trackSelector == null) {
            trackSelector = new DefaultTrackSelector(this.mAppContext);
            this.mTrackSelector = trackSelector;
        }
        TrackSelector trackSelector2 = trackSelector;
        DefaultMediaSourceFactory defaultMediaSourceFactory = new DefaultMediaSourceFactory(this.mAppContext);
        LoadControl loadControl = this.mLoadControl;
        if (loadControl == null) {
            loadControl = new DefaultLoadControl();
            this.mLoadControl = loadControl;
        }
        this.mInternalPlayer = new SimpleExoPlayer.Builder(context, renderersFactory2, trackSelector2, defaultMediaSourceFactory, loadControl, DefaultBandwidthMeter.getSingletonInstance(this.mAppContext), new AnalyticsCollector(Clock.DEFAULT)).build();
        setOptions();
        if (VideoViewManager.getConfig().mIsEnableLog && (this.mTrackSelector instanceof MappingTrackSelector)) {
            this.mInternalPlayer.addAnalyticsListener(new EventLogger((MappingTrackSelector) this.mTrackSelector, "ExoPlayer"));
        }
        this.mInternalPlayer.addListener((Player.Listener) this);
    }

    public void setTrackSelector(TrackSelector trackSelector) {
        this.mTrackSelector = trackSelector;
    }

    public void setRenderersFactory(RenderersFactory renderersFactory) {
        this.mRenderersFactory = renderersFactory;
    }

    public void setLoadControl(LoadControl loadControl) {
        this.mLoadControl = loadControl;
    }

    @Override // xyz.doikki.videoplayer.player.AbstractPlayer
    public void setDataSource(String str, Map<String, String> map) {
        this.mMediaSource = this.mMediaSourceHelper.getMediaSource(str, map);
    }

    @Override // xyz.doikki.videoplayer.player.AbstractPlayer
    public void start() {
        SimpleExoPlayer simpleExoPlayer = this.mInternalPlayer;
        if (simpleExoPlayer == null) {
            return;
        }
        simpleExoPlayer.setPlayWhenReady(true);
    }

    @Override // xyz.doikki.videoplayer.player.AbstractPlayer
    public void pause() {
        SimpleExoPlayer simpleExoPlayer = this.mInternalPlayer;
        if (simpleExoPlayer == null) {
            return;
        }
        simpleExoPlayer.setPlayWhenReady(false);
    }

    @Override // xyz.doikki.videoplayer.player.AbstractPlayer
    public void stop() {
        SimpleExoPlayer simpleExoPlayer = this.mInternalPlayer;
        if (simpleExoPlayer == null) {
            return;
        }
        simpleExoPlayer.stop();
    }

    @Override // xyz.doikki.videoplayer.player.AbstractPlayer
    public void prepareAsync() {
        SimpleExoPlayer simpleExoPlayer = this.mInternalPlayer;
        if (simpleExoPlayer == null || this.mMediaSource == null) {
            return;
        }
        PlaybackParameters playbackParameters = this.mSpeedPlaybackParameters;
        if (playbackParameters != null) {
            simpleExoPlayer.setPlaybackParameters(playbackParameters);
        }
        this.mIsPreparing = true;
        this.mInternalPlayer.setMediaSource(this.mMediaSource);
        this.mInternalPlayer.prepare();
    }

    @Override // xyz.doikki.videoplayer.player.AbstractPlayer
    public void reset() {
        SimpleExoPlayer simpleExoPlayer = this.mInternalPlayer;
        if (simpleExoPlayer != null) {
            simpleExoPlayer.stop();
            this.mInternalPlayer.clearMediaItems();
            this.mInternalPlayer.setVideoSurface(null);
            this.mIsPreparing = false;
        }
    }

    @Override // xyz.doikki.videoplayer.player.AbstractPlayer
    public boolean isPlaying() {
        SimpleExoPlayer simpleExoPlayer = this.mInternalPlayer;
        if (simpleExoPlayer == null) {
            return false;
        }
        int playbackState = simpleExoPlayer.getPlaybackState();
        if (playbackState == 2 || playbackState == 3) {
            return this.mInternalPlayer.getPlayWhenReady();
        }
        return false;
    }

    @Override // xyz.doikki.videoplayer.player.AbstractPlayer
    public void seekTo(long j) {
        SimpleExoPlayer simpleExoPlayer = this.mInternalPlayer;
        if (simpleExoPlayer == null) {
            return;
        }
        simpleExoPlayer.seekTo(j);
    }

    @Override // xyz.doikki.videoplayer.player.AbstractPlayer
    public void release() {
        SimpleExoPlayer simpleExoPlayer = this.mInternalPlayer;
        if (simpleExoPlayer != null) {
            simpleExoPlayer.removeListener((Player.Listener) this);
            this.mInternalPlayer.release();
            this.mInternalPlayer = null;
        }
        this.mIsPreparing = false;
        this.mSpeedPlaybackParameters = null;
    }

    @Override // xyz.doikki.videoplayer.player.AbstractPlayer
    public long getCurrentPosition() {
        SimpleExoPlayer simpleExoPlayer = this.mInternalPlayer;
        if (simpleExoPlayer == null) {
            return 0L;
        }
        return simpleExoPlayer.getCurrentPosition();
    }

    @Override // xyz.doikki.videoplayer.player.AbstractPlayer
    public long getDuration() {
        SimpleExoPlayer simpleExoPlayer = this.mInternalPlayer;
        if (simpleExoPlayer == null) {
            return 0L;
        }
        return simpleExoPlayer.getDuration();
    }

    @Override // xyz.doikki.videoplayer.player.AbstractPlayer
    public int getBufferedPercentage() {
        SimpleExoPlayer simpleExoPlayer = this.mInternalPlayer;
        if (simpleExoPlayer == null) {
            return 0;
        }
        return simpleExoPlayer.getBufferedPercentage();
    }

    @Override // xyz.doikki.videoplayer.player.AbstractPlayer
    public void setSurface(Surface surface) {
        SimpleExoPlayer simpleExoPlayer = this.mInternalPlayer;
        if (simpleExoPlayer != null) {
            simpleExoPlayer.setVideoSurface(surface);
        }
    }

    @Override // xyz.doikki.videoplayer.player.AbstractPlayer
    public void setDisplay(SurfaceHolder surfaceHolder) {
        if (surfaceHolder == null) {
            setSurface(null);
        } else {
            setSurface(surfaceHolder.getSurface());
        }
    }

    @Override // xyz.doikki.videoplayer.player.AbstractPlayer
    public void setVolume(float f, float f2) {
        SimpleExoPlayer simpleExoPlayer = this.mInternalPlayer;
        if (simpleExoPlayer != null) {
            simpleExoPlayer.setVolume((f + f2) / 2.0f);
        }
    }

    @Override // xyz.doikki.videoplayer.player.AbstractPlayer
    public void setLooping(boolean z) {
        SimpleExoPlayer simpleExoPlayer = this.mInternalPlayer;
        if (simpleExoPlayer != null) {
            simpleExoPlayer.setRepeatMode(z ? 2 : 0);
        }
    }

    @Override // xyz.doikki.videoplayer.player.AbstractPlayer
    public void setOptions() {
        this.mInternalPlayer.setPlayWhenReady(true);
    }

    @Override // xyz.doikki.videoplayer.player.AbstractPlayer
    public void setSpeed(float f) {
        PlaybackParameters playbackParameters = new PlaybackParameters(f);
        this.mSpeedPlaybackParameters = playbackParameters;
        SimpleExoPlayer simpleExoPlayer = this.mInternalPlayer;
        if (simpleExoPlayer != null) {
            simpleExoPlayer.setPlaybackParameters(playbackParameters);
        }
    }

    @Override // xyz.doikki.videoplayer.player.AbstractPlayer
    public float getSpeed() {
        PlaybackParameters playbackParameters = this.mSpeedPlaybackParameters;
        if (playbackParameters != null) {
            return playbackParameters.speed;
        }
        return 1.0f;
    }

    @Override // com.google.android.exoplayer2.Player.Listener, com.google.android.exoplayer2.Player.EventListener
    public void onPlaybackStateChanged(int i) {
        if (this.mPlayerEventListener == null) {
            return;
        }
        if (this.mIsPreparing) {
            if (i == 3) {
                this.mPlayerEventListener.onPrepared();
                this.mPlayerEventListener.onInfo(3, 0);
                this.mIsPreparing = false;
                return;
            }
            return;
        }
        if (i == 2) {
            this.mPlayerEventListener.onInfo(701, getBufferedPercentage());
        } else if (i == 3) {
            this.mPlayerEventListener.onInfo(702, getBufferedPercentage());
        } else {
            if (i != 4) {
                return;
            }
            this.mPlayerEventListener.onCompletion();
        }
    }

    @Override // com.google.android.exoplayer2.Player.Listener, com.google.android.exoplayer2.Player.EventListener
    public void onPlayerError(ExoPlaybackException exoPlaybackException) {
        if (this.mPlayerEventListener != null) {
            this.mPlayerEventListener.onError();
        }
    }

    @Override // com.google.android.exoplayer2.Player.Listener, com.google.android.exoplayer2.video.VideoListener
    public void onVideoSizeChanged(VideoSize videoSize) {
        if (this.mPlayerEventListener != null) {
            this.mPlayerEventListener.onVideoSizeChanged(videoSize.width, videoSize.height);
            if (videoSize.unappliedRotationDegrees > 0) {
                this.mPlayerEventListener.onInfo(10001, videoSize.unappliedRotationDegrees);
            }
        }
    }
}
