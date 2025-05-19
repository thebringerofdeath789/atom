package xyz.doikki.videoplayer.player;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import com.google.android.exoplayer2.upstream.RawResourceDataSource;
import com.google.android.material.badge.BadgeDrawable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.commons.text.lookup.StringLookupFactory;
import xyz.doikki.videoplayer.R;
import xyz.doikki.videoplayer.controller.BaseVideoController;
import xyz.doikki.videoplayer.controller.MediaPlayerControl;
import xyz.doikki.videoplayer.player.AbstractPlayer;
import xyz.doikki.videoplayer.render.IRenderView;
import xyz.doikki.videoplayer.render.RenderViewFactory;
import xyz.doikki.videoplayer.util.L;
import xyz.doikki.videoplayer.util.PlayerUtils;

/* loaded from: classes6.dex */
public class VideoView<P extends AbstractPlayer> extends FrameLayout implements MediaPlayerControl, AbstractPlayer.PlayerEventListener {
    public static final int PLAYER_FULL_SCREEN = 11;
    public static final int PLAYER_NORMAL = 10;
    public static final int PLAYER_TINY_SCREEN = 12;
    public static final int SCREEN_SCALE_16_9 = 1;
    public static final int SCREEN_SCALE_4_3 = 2;
    public static final int SCREEN_SCALE_CENTER_CROP = 5;
    public static final int SCREEN_SCALE_DEFAULT = 0;
    public static final int SCREEN_SCALE_MATCH_PARENT = 3;
    public static final int SCREEN_SCALE_ORIGINAL = 4;
    public static final int STATE_BUFFERED = 7;
    public static final int STATE_BUFFERING = 6;
    public static final int STATE_ERROR = -1;
    public static final int STATE_IDLE = 0;
    public static final int STATE_PAUSED = 4;
    public static final int STATE_PLAYBACK_COMPLETED = 5;
    public static final int STATE_PLAYING = 3;
    public static final int STATE_PREPARED = 2;
    public static final int STATE_PREPARING = 1;
    public static final int STATE_START_ABORT = 8;
    protected AssetFileDescriptor mAssetFileDescriptor;
    protected AudioFocusHelper mAudioFocusHelper;
    protected int mCurrentPlayState;
    protected int mCurrentPlayerState;
    protected long mCurrentPosition;
    protected int mCurrentScreenScaleType;
    protected boolean mEnableAudioFocus;
    protected Map<String, String> mHeaders;
    protected boolean mIsFullScreen;
    protected boolean mIsLooping;
    protected boolean mIsMute;
    protected boolean mIsTinyScreen;
    protected P mMediaPlayer;
    protected List<OnStateChangeListener> mOnStateChangeListeners;
    private int mPlayerBackgroundColor;
    protected FrameLayout mPlayerContainer;
    protected PlayerFactory<P> mPlayerFactory;
    protected ProgressManager mProgressManager;
    protected IRenderView mRenderView;
    protected RenderViewFactory mRenderViewFactory;
    protected int[] mTinyScreenSize;
    protected String mUrl;
    protected BaseVideoController mVideoController;
    protected int[] mVideoSize;

    public interface OnStateChangeListener {
        void onPlayStateChanged(int i);

        void onPlayerStateChanged(int i);
    }

    public static class SimpleOnStateChangeListener implements OnStateChangeListener {
        @Override // xyz.doikki.videoplayer.player.VideoView.OnStateChangeListener
        public void onPlayStateChanged(int i) {
        }

        @Override // xyz.doikki.videoplayer.player.VideoView.OnStateChangeListener
        public void onPlayerStateChanged(int i) {
        }
    }

    protected void setInitOptions() {
    }

    public VideoView(Context context) {
        this(context, null);
    }

    public VideoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public VideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mVideoSize = new int[]{0, 0};
        this.mCurrentPlayState = 0;
        this.mCurrentPlayerState = 10;
        this.mTinyScreenSize = new int[]{0, 0};
        VideoViewConfig config = VideoViewManager.getConfig();
        this.mEnableAudioFocus = config.mEnableAudioFocus;
        this.mProgressManager = config.mProgressManager;
        this.mPlayerFactory = config.mPlayerFactory;
        this.mCurrentScreenScaleType = config.mScreenScaleType;
        this.mRenderViewFactory = config.mRenderViewFactory;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.VideoView);
        this.mEnableAudioFocus = obtainStyledAttributes.getBoolean(R.styleable.VideoView_enableAudioFocus, this.mEnableAudioFocus);
        this.mIsLooping = obtainStyledAttributes.getBoolean(R.styleable.VideoView_looping, false);
        this.mCurrentScreenScaleType = obtainStyledAttributes.getInt(R.styleable.VideoView_screenScaleType, this.mCurrentScreenScaleType);
        this.mPlayerBackgroundColor = obtainStyledAttributes.getColor(R.styleable.VideoView_playerBackgroundColor, ViewCompat.MEASURED_STATE_MASK);
        obtainStyledAttributes.recycle();
        initView();
    }

    protected void initView() {
        FrameLayout frameLayout = new FrameLayout(getContext());
        this.mPlayerContainer = frameLayout;
        frameLayout.setBackgroundColor(this.mPlayerBackgroundColor);
        addView(this.mPlayerContainer, new FrameLayout.LayoutParams(-1, -1));
    }

    public void setPlayerBackgroundColor(int i) {
        this.mPlayerContainer.setBackgroundColor(i);
    }

    @Override // xyz.doikki.videoplayer.controller.MediaPlayerControl
    public void start() {
        if (isInIdleState() || isInStartAbortState()) {
            startPlay();
        } else if (isInPlaybackState()) {
            startInPlaybackState();
        }
    }

    protected boolean startPlay() {
        if (showNetWarning()) {
            setPlayState(8);
            return false;
        }
        if (this.mEnableAudioFocus) {
            this.mAudioFocusHelper = new AudioFocusHelper(this);
        }
        ProgressManager progressManager = this.mProgressManager;
        if (progressManager != null) {
            this.mCurrentPosition = progressManager.getSavedProgress(this.mUrl);
        }
        initPlayer();
        addDisplay();
        startPrepare(false);
        return true;
    }

    protected boolean showNetWarning() {
        BaseVideoController baseVideoController;
        return (isLocalDataSource() || (baseVideoController = this.mVideoController) == null || !baseVideoController.showNetWarning()) ? false : true;
    }

    protected boolean isLocalDataSource() {
        if (this.mAssetFileDescriptor != null) {
            return true;
        }
        if (TextUtils.isEmpty(this.mUrl)) {
            return false;
        }
        Uri parse = Uri.parse(this.mUrl);
        return "android.resource".equals(parse.getScheme()) || StringLookupFactory.KEY_FILE.equals(parse.getScheme()) || RawResourceDataSource.RAW_RESOURCE_SCHEME.equals(parse.getScheme());
    }

    protected void initPlayer() {
        P createPlayer = this.mPlayerFactory.createPlayer(getContext());
        this.mMediaPlayer = createPlayer;
        createPlayer.setPlayerEventListener(this);
        setInitOptions();
        this.mMediaPlayer.initPlayer();
        setOptions();
    }

    protected void setOptions() {
        this.mMediaPlayer.setLooping(this.mIsLooping);
        float f = this.mIsMute ? 0.0f : 1.0f;
        this.mMediaPlayer.setVolume(f, f);
    }

    protected void addDisplay() {
        IRenderView iRenderView = this.mRenderView;
        if (iRenderView != null) {
            this.mPlayerContainer.removeView(iRenderView.getView());
            this.mRenderView.release();
        }
        IRenderView createRenderView = this.mRenderViewFactory.createRenderView(getContext());
        this.mRenderView = createRenderView;
        createRenderView.attachToPlayer(this.mMediaPlayer);
        this.mPlayerContainer.addView(this.mRenderView.getView(), 0, new FrameLayout.LayoutParams(-1, -1, 17));
    }

    protected void startPrepare(boolean z) {
        if (z) {
            this.mMediaPlayer.reset();
            setOptions();
        }
        if (prepareDataSource()) {
            this.mMediaPlayer.prepareAsync();
            setPlayState(1);
            setPlayerState(isFullScreen() ? 11 : isTinyScreen() ? 12 : 10);
        }
    }

    protected boolean prepareDataSource() {
        AssetFileDescriptor assetFileDescriptor = this.mAssetFileDescriptor;
        if (assetFileDescriptor != null) {
            this.mMediaPlayer.setDataSource(assetFileDescriptor);
            return true;
        }
        if (TextUtils.isEmpty(this.mUrl)) {
            return false;
        }
        this.mMediaPlayer.setDataSource(this.mUrl, this.mHeaders);
        return true;
    }

    protected void startInPlaybackState() {
        this.mMediaPlayer.start();
        setPlayState(3);
        if (this.mAudioFocusHelper != null && !isMute()) {
            this.mAudioFocusHelper.requestFocus();
        }
        this.mPlayerContainer.setKeepScreenOn(true);
    }

    @Override // xyz.doikki.videoplayer.controller.MediaPlayerControl
    public void pause() {
        if (isInPlaybackState() && this.mMediaPlayer.isPlaying()) {
            this.mMediaPlayer.pause();
            setPlayState(4);
            if (this.mAudioFocusHelper != null && !isMute()) {
                this.mAudioFocusHelper.abandonFocus();
            }
            this.mPlayerContainer.setKeepScreenOn(false);
        }
    }

    public void resume() {
        if (!isInPlaybackState() || this.mMediaPlayer.isPlaying()) {
            return;
        }
        this.mMediaPlayer.start();
        setPlayState(3);
        if (this.mAudioFocusHelper != null && !isMute()) {
            this.mAudioFocusHelper.requestFocus();
        }
        this.mPlayerContainer.setKeepScreenOn(true);
    }

    public void release() {
        if (isInIdleState()) {
            return;
        }
        P p = this.mMediaPlayer;
        if (p != null) {
            p.release();
            this.mMediaPlayer = null;
        }
        IRenderView iRenderView = this.mRenderView;
        if (iRenderView != null) {
            this.mPlayerContainer.removeView(iRenderView.getView());
            this.mRenderView.release();
            this.mRenderView = null;
        }
        AssetFileDescriptor assetFileDescriptor = this.mAssetFileDescriptor;
        if (assetFileDescriptor != null) {
            try {
                assetFileDescriptor.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        AudioFocusHelper audioFocusHelper = this.mAudioFocusHelper;
        if (audioFocusHelper != null) {
            audioFocusHelper.abandonFocus();
            this.mAudioFocusHelper = null;
        }
        this.mPlayerContainer.setKeepScreenOn(false);
        saveProgress();
        this.mCurrentPosition = 0L;
        setPlayState(0);
    }

    protected void saveProgress() {
        if (this.mProgressManager == null || this.mCurrentPosition <= 0) {
            return;
        }
        L.d("saveProgress: " + this.mCurrentPosition);
        this.mProgressManager.saveProgress(this.mUrl, this.mCurrentPosition);
    }

    protected boolean isInPlaybackState() {
        int i;
        return (this.mMediaPlayer == null || (i = this.mCurrentPlayState) == -1 || i == 0 || i == 1 || i == 8 || i == 5) ? false : true;
    }

    protected boolean isInIdleState() {
        return this.mCurrentPlayState == 0;
    }

    private boolean isInStartAbortState() {
        return this.mCurrentPlayState == 8;
    }

    @Override // xyz.doikki.videoplayer.controller.MediaPlayerControl
    public void replay(boolean z) {
        if (z) {
            this.mCurrentPosition = 0L;
        }
        addDisplay();
        startPrepare(true);
    }

    @Override // xyz.doikki.videoplayer.controller.MediaPlayerControl
    public long getDuration() {
        if (isInPlaybackState()) {
            return this.mMediaPlayer.getDuration();
        }
        return 0L;
    }

    @Override // xyz.doikki.videoplayer.controller.MediaPlayerControl
    public long getCurrentPosition() {
        if (!isInPlaybackState()) {
            return 0L;
        }
        long currentPosition = this.mMediaPlayer.getCurrentPosition();
        this.mCurrentPosition = currentPosition;
        return currentPosition;
    }

    @Override // xyz.doikki.videoplayer.controller.MediaPlayerControl
    public void seekTo(long j) {
        if (isInPlaybackState()) {
            this.mMediaPlayer.seekTo(j);
        }
    }

    @Override // xyz.doikki.videoplayer.controller.MediaPlayerControl
    public boolean isPlaying() {
        return isInPlaybackState() && this.mMediaPlayer.isPlaying();
    }

    @Override // xyz.doikki.videoplayer.controller.MediaPlayerControl
    public int getBufferedPercentage() {
        P p = this.mMediaPlayer;
        if (p != null) {
            return p.getBufferedPercentage();
        }
        return 0;
    }

    @Override // xyz.doikki.videoplayer.controller.MediaPlayerControl
    public void setMute(boolean z) {
        this.mIsMute = z;
        P p = this.mMediaPlayer;
        if (p != null) {
            float f = z ? 0.0f : 1.0f;
            p.setVolume(f, f);
        }
    }

    @Override // xyz.doikki.videoplayer.controller.MediaPlayerControl
    public boolean isMute() {
        return this.mIsMute;
    }

    @Override // xyz.doikki.videoplayer.player.AbstractPlayer.PlayerEventListener
    public void onPrepared() {
        AudioFocusHelper audioFocusHelper;
        setPlayState(2);
        if (!isMute() && (audioFocusHelper = this.mAudioFocusHelper) != null) {
            audioFocusHelper.requestFocus();
        }
        long j = this.mCurrentPosition;
        if (j > 0) {
            seekTo(j);
        }
    }

    @Override // xyz.doikki.videoplayer.player.AbstractPlayer.PlayerEventListener
    public void onInfo(int i, int i2) {
        if (i == 3) {
            setPlayState(3);
            this.mPlayerContainer.setKeepScreenOn(true);
            return;
        }
        if (i == 10001) {
            IRenderView iRenderView = this.mRenderView;
            if (iRenderView != null) {
                iRenderView.setVideoRotation(i2);
                return;
            }
            return;
        }
        if (i == 701) {
            setPlayState(6);
        } else {
            if (i != 702) {
                return;
            }
            setPlayState(7);
        }
    }

    @Override // xyz.doikki.videoplayer.player.AbstractPlayer.PlayerEventListener
    public void onError() {
        this.mPlayerContainer.setKeepScreenOn(false);
        setPlayState(-1);
    }

    @Override // xyz.doikki.videoplayer.player.AbstractPlayer.PlayerEventListener
    public void onCompletion() {
        this.mPlayerContainer.setKeepScreenOn(false);
        this.mCurrentPosition = 0L;
        ProgressManager progressManager = this.mProgressManager;
        if (progressManager != null) {
            progressManager.saveProgress(this.mUrl, 0L);
        }
        setPlayState(5);
    }

    public int getCurrentPlayerState() {
        return this.mCurrentPlayerState;
    }

    public int getCurrentPlayState() {
        return this.mCurrentPlayState;
    }

    @Override // xyz.doikki.videoplayer.controller.MediaPlayerControl
    public long getTcpSpeed() {
        P p = this.mMediaPlayer;
        if (p != null) {
            return p.getTcpSpeed();
        }
        return 0L;
    }

    @Override // xyz.doikki.videoplayer.controller.MediaPlayerControl
    public void setSpeed(float f) {
        if (isInPlaybackState()) {
            this.mMediaPlayer.setSpeed(f);
        }
    }

    @Override // xyz.doikki.videoplayer.controller.MediaPlayerControl
    public float getSpeed() {
        if (isInPlaybackState()) {
            return this.mMediaPlayer.getSpeed();
        }
        return 1.0f;
    }

    public void setUrl(String str) {
        setUrl(str, null);
    }

    public void setUrl(String str, Map<String, String> map) {
        this.mAssetFileDescriptor = null;
        this.mUrl = str;
        this.mHeaders = map;
    }

    public void setAssetFileDescriptor(AssetFileDescriptor assetFileDescriptor) {
        this.mUrl = null;
        this.mAssetFileDescriptor = assetFileDescriptor;
    }

    public void skipPositionWhenPlay(int i) {
        this.mCurrentPosition = i;
    }

    public void setVolume(float f, float f2) {
        P p = this.mMediaPlayer;
        if (p != null) {
            p.setVolume(f, f2);
        }
    }

    public void setProgressManager(ProgressManager progressManager) {
        this.mProgressManager = progressManager;
    }

    public void setLooping(boolean z) {
        this.mIsLooping = z;
        P p = this.mMediaPlayer;
        if (p != null) {
            p.setLooping(z);
        }
    }

    public void setEnableAudioFocus(boolean z) {
        this.mEnableAudioFocus = z;
    }

    public void setPlayerFactory(PlayerFactory<P> playerFactory) {
        if (playerFactory == null) {
            throw new IllegalArgumentException("PlayerFactory can not be null!");
        }
        this.mPlayerFactory = playerFactory;
    }

    public void setRenderViewFactory(RenderViewFactory renderViewFactory) {
        if (renderViewFactory == null) {
            throw new IllegalArgumentException("RenderViewFactory can not be null!");
        }
        this.mRenderViewFactory = renderViewFactory;
    }

    @Override // xyz.doikki.videoplayer.controller.MediaPlayerControl
    public void startFullScreen() {
        ViewGroup decorView;
        if (this.mIsFullScreen || (decorView = getDecorView()) == null) {
            return;
        }
        this.mIsFullScreen = true;
        hideSysBar(decorView);
        removeView(this.mPlayerContainer);
        decorView.addView(this.mPlayerContainer);
        setPlayerState(11);
    }

    private void hideSysBar(ViewGroup viewGroup) {
        int systemUiVisibility = viewGroup.getSystemUiVisibility();
        if (Build.VERSION.SDK_INT >= 16) {
            systemUiVisibility |= 2;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            systemUiVisibility |= 4096;
        }
        viewGroup.setSystemUiVisibility(systemUiVisibility);
        getActivity().getWindow().setFlags(1024, 1024);
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z && this.mIsFullScreen) {
            hideSysBar(getDecorView());
        }
    }

    @Override // xyz.doikki.videoplayer.controller.MediaPlayerControl
    public void stopFullScreen() {
        ViewGroup decorView;
        if (this.mIsFullScreen && (decorView = getDecorView()) != null) {
            this.mIsFullScreen = false;
            showSysBar(decorView);
            decorView.removeView(this.mPlayerContainer);
            addView(this.mPlayerContainer);
            setPlayerState(10);
        }
    }

    private void showSysBar(ViewGroup viewGroup) {
        int systemUiVisibility = viewGroup.getSystemUiVisibility();
        if (Build.VERSION.SDK_INT >= 16) {
            systemUiVisibility &= -3;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            systemUiVisibility &= -4097;
        }
        viewGroup.setSystemUiVisibility(systemUiVisibility);
        getActivity().getWindow().clearFlags(1024);
    }

    protected ViewGroup getDecorView() {
        Activity activity = getActivity();
        if (activity == null) {
            return null;
        }
        return (ViewGroup) activity.getWindow().getDecorView();
    }

    protected ViewGroup getContentView() {
        Activity activity = getActivity();
        if (activity == null) {
            return null;
        }
        return (ViewGroup) activity.findViewById(android.R.id.content);
    }

    protected Activity getActivity() {
        BaseVideoController baseVideoController = this.mVideoController;
        if (baseVideoController != null) {
            Activity scanForActivity = PlayerUtils.scanForActivity(baseVideoController.getContext());
            return scanForActivity == null ? PlayerUtils.scanForActivity(getContext()) : scanForActivity;
        }
        return PlayerUtils.scanForActivity(getContext());
    }

    @Override // xyz.doikki.videoplayer.controller.MediaPlayerControl
    public boolean isFullScreen() {
        return this.mIsFullScreen;
    }

    @Override // xyz.doikki.videoplayer.controller.MediaPlayerControl
    public void startTinyScreen() {
        ViewGroup contentView;
        if (this.mIsTinyScreen || (contentView = getContentView()) == null) {
            return;
        }
        removeView(this.mPlayerContainer);
        int i = this.mTinyScreenSize[0];
        if (i <= 0) {
            i = PlayerUtils.getScreenWidth(getContext(), false) / 2;
        }
        int i2 = this.mTinyScreenSize[1];
        if (i2 <= 0) {
            i2 = (i * 9) / 16;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i, i2);
        layoutParams.gravity = BadgeDrawable.BOTTOM_END;
        contentView.addView(this.mPlayerContainer, layoutParams);
        this.mIsTinyScreen = true;
        setPlayerState(12);
    }

    @Override // xyz.doikki.videoplayer.controller.MediaPlayerControl
    public void stopTinyScreen() {
        ViewGroup contentView;
        if (this.mIsTinyScreen && (contentView = getContentView()) != null) {
            contentView.removeView(this.mPlayerContainer);
            addView(this.mPlayerContainer, new FrameLayout.LayoutParams(-1, -1));
            this.mIsTinyScreen = false;
            setPlayerState(10);
        }
    }

    @Override // xyz.doikki.videoplayer.controller.MediaPlayerControl
    public boolean isTinyScreen() {
        return this.mIsTinyScreen;
    }

    @Override // xyz.doikki.videoplayer.player.AbstractPlayer.PlayerEventListener
    public void onVideoSizeChanged(int i, int i2) {
        int[] iArr = this.mVideoSize;
        iArr[0] = i;
        iArr[1] = i2;
        IRenderView iRenderView = this.mRenderView;
        if (iRenderView != null) {
            iRenderView.setScaleType(this.mCurrentScreenScaleType);
            this.mRenderView.setVideoSize(i, i2);
        }
    }

    public void setVideoController(BaseVideoController baseVideoController) {
        this.mPlayerContainer.removeView(this.mVideoController);
        this.mVideoController = baseVideoController;
        if (baseVideoController != null) {
            baseVideoController.setMediaPlayer(this);
            this.mPlayerContainer.addView(this.mVideoController, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    @Override // xyz.doikki.videoplayer.controller.MediaPlayerControl
    public void setScreenScaleType(int i) {
        this.mCurrentScreenScaleType = i;
        IRenderView iRenderView = this.mRenderView;
        if (iRenderView != null) {
            iRenderView.setScaleType(i);
        }
    }

    @Override // xyz.doikki.videoplayer.controller.MediaPlayerControl
    public void setMirrorRotation(boolean z) {
        IRenderView iRenderView = this.mRenderView;
        if (iRenderView != null) {
            iRenderView.getView().setScaleX(z ? -1.0f : 1.0f);
        }
    }

    @Override // xyz.doikki.videoplayer.controller.MediaPlayerControl
    public Bitmap doScreenShot() {
        IRenderView iRenderView = this.mRenderView;
        if (iRenderView != null) {
            return iRenderView.doScreenShot();
        }
        return null;
    }

    @Override // xyz.doikki.videoplayer.controller.MediaPlayerControl
    public int[] getVideoSize() {
        return this.mVideoSize;
    }

    @Override // android.view.View, xyz.doikki.videoplayer.controller.MediaPlayerControl
    public void setRotation(float f) {
        IRenderView iRenderView = this.mRenderView;
        if (iRenderView != null) {
            iRenderView.setVideoRotation((int) f);
        }
    }

    public void setTinyScreenSize(int[] iArr) {
        this.mTinyScreenSize = iArr;
    }

    protected void setPlayState(int i) {
        this.mCurrentPlayState = i;
        BaseVideoController baseVideoController = this.mVideoController;
        if (baseVideoController != null) {
            baseVideoController.setPlayState(i);
        }
        List<OnStateChangeListener> list = this.mOnStateChangeListeners;
        if (list != null) {
            for (OnStateChangeListener onStateChangeListener : PlayerUtils.getSnapshot(list)) {
                if (onStateChangeListener != null) {
                    onStateChangeListener.onPlayStateChanged(i);
                }
            }
        }
    }

    protected void setPlayerState(int i) {
        this.mCurrentPlayerState = i;
        BaseVideoController baseVideoController = this.mVideoController;
        if (baseVideoController != null) {
            baseVideoController.setPlayerState(i);
        }
        List<OnStateChangeListener> list = this.mOnStateChangeListeners;
        if (list != null) {
            for (OnStateChangeListener onStateChangeListener : PlayerUtils.getSnapshot(list)) {
                if (onStateChangeListener != null) {
                    onStateChangeListener.onPlayerStateChanged(i);
                }
            }
        }
    }

    public void addOnStateChangeListener(OnStateChangeListener onStateChangeListener) {
        if (this.mOnStateChangeListeners == null) {
            this.mOnStateChangeListeners = new ArrayList();
        }
        this.mOnStateChangeListeners.add(onStateChangeListener);
    }

    public void removeOnStateChangeListener(OnStateChangeListener onStateChangeListener) {
        List<OnStateChangeListener> list = this.mOnStateChangeListeners;
        if (list != null) {
            list.remove(onStateChangeListener);
        }
    }

    public void setOnStateChangeListener(OnStateChangeListener onStateChangeListener) {
        List<OnStateChangeListener> list = this.mOnStateChangeListeners;
        if (list == null) {
            this.mOnStateChangeListeners = new ArrayList();
        } else {
            list.clear();
        }
        this.mOnStateChangeListeners.add(onStateChangeListener);
    }

    public void clearOnStateChangeListeners() {
        List<OnStateChangeListener> list = this.mOnStateChangeListeners;
        if (list != null) {
            list.clear();
        }
    }

    public boolean onBackPressed() {
        BaseVideoController baseVideoController = this.mVideoController;
        return baseVideoController != null && baseVideoController.onBackPressed();
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        L.d("onSaveInstanceState: " + this.mCurrentPosition);
        saveProgress();
        return super.onSaveInstanceState();
    }
}
