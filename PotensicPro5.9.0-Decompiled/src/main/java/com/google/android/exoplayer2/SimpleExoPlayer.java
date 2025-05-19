package com.google.android.exoplayer2;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.media.AudioTrack;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.Looper;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import com.google.android.exoplayer2.AudioBecomingNoisyManager;
import com.google.android.exoplayer2.AudioFocusManager;
import com.google.android.exoplayer2.DefaultLivePlaybackSpeedControl;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.PlayerMessage;
import com.google.android.exoplayer2.StreamVolumeManager;
import com.google.android.exoplayer2.analytics.AnalyticsCollector;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.audio.AudioAttributes;
import com.google.android.exoplayer2.audio.AudioListener;
import com.google.android.exoplayer2.audio.AudioRendererEventListener;
import com.google.android.exoplayer2.audio.AuxEffectInfo;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.decoder.DecoderReuseEvaluation;
import com.google.android.exoplayer2.device.DeviceInfo;
import com.google.android.exoplayer2.device.DeviceListener;
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.MetadataOutput;
import com.google.android.exoplayer2.source.DefaultMediaSourceFactory;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.MediaSourceFactory;
import com.google.android.exoplayer2.source.ShuffleOrder;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.TextOutput;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Clock;
import com.google.android.exoplayer2.util.ConditionVariable;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.PriorityTaskManager;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.VideoDecoderOutputBufferRenderer;
import com.google.android.exoplayer2.video.VideoFrameMetadataListener;
import com.google.android.exoplayer2.video.VideoListener;
import com.google.android.exoplayer2.video.VideoRendererEventListener;
import com.google.android.exoplayer2.video.VideoSize;
import com.google.android.exoplayer2.video.spherical.CameraMotionListener;
import com.google.android.exoplayer2.video.spherical.SphericalGLSurfaceView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.TimeoutException;

/* loaded from: classes.dex */
public class SimpleExoPlayer extends BasePlayer implements ExoPlayer, ExoPlayer.AudioComponent, ExoPlayer.VideoComponent, ExoPlayer.TextComponent, ExoPlayer.MetadataComponent, ExoPlayer.DeviceComponent {
    public static final long DEFAULT_DETACH_SURFACE_TIMEOUT_MS = 2000;
    private static final String TAG = "SimpleExoPlayer";
    private final AnalyticsCollector analyticsCollector;
    private final Context applicationContext;
    private AudioAttributes audioAttributes;
    private final AudioBecomingNoisyManager audioBecomingNoisyManager;
    private DecoderCounters audioDecoderCounters;
    private final AudioFocusManager audioFocusManager;
    private Format audioFormat;
    private final CopyOnWriteArraySet<AudioListener> audioListeners;
    private int audioSessionId;
    private float audioVolume;
    private CameraMotionListener cameraMotionListener;
    private final ComponentListener componentListener;
    private final ConditionVariable constructorFinished;
    private List<Cue> currentCues;
    private final long detachSurfaceTimeoutMs;
    private DeviceInfo deviceInfo;
    private final CopyOnWriteArraySet<DeviceListener> deviceListeners;
    private final FrameMetadataListener frameMetadataListener;
    private boolean hasNotifiedFullWrongThreadWarning;
    private boolean isPriorityTaskManagerRegistered;
    private AudioTrack keepSessionIdAudioTrack;
    private final CopyOnWriteArraySet<MetadataOutput> metadataOutputs;
    private Surface ownedSurface;
    private final ExoPlayerImpl player;
    private boolean playerReleased;
    private PriorityTaskManager priorityTaskManager;
    protected final Renderer[] renderers;
    private boolean skipSilenceEnabled;
    private SphericalGLSurfaceView sphericalGLSurfaceView;
    private final StreamVolumeManager streamVolumeManager;
    private int surfaceHeight;
    private SurfaceHolder surfaceHolder;
    private boolean surfaceHolderSurfaceIsVideoOutput;
    private int surfaceWidth;
    private final CopyOnWriteArraySet<TextOutput> textOutputs;
    private TextureView textureView;
    private boolean throwsWhenUsingWrongThread;
    private DecoderCounters videoDecoderCounters;
    private Format videoFormat;
    private VideoFrameMetadataListener videoFrameMetadataListener;
    private final CopyOnWriteArraySet<VideoListener> videoListeners;
    private Object videoOutput;
    private int videoScalingMode;
    private VideoSize videoSize;
    private final WakeLockManager wakeLockManager;
    private final WifiLockManager wifiLockManager;

    /* JADX INFO: Access modifiers changed from: private */
    public static int getPlayWhenReadyChangeReason(boolean z, int i) {
        return (!z || i == 1) ? 1 : 2;
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public ExoPlayer.AudioComponent getAudioComponent() {
        return this;
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public ExoPlayer.DeviceComponent getDeviceComponent() {
        return this;
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public ExoPlayer.MetadataComponent getMetadataComponent() {
        return this;
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public ExoPlayer.TextComponent getTextComponent() {
        return this;
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public ExoPlayer.VideoComponent getVideoComponent() {
        return this;
    }

    public static final class Builder {
        private AnalyticsCollector analyticsCollector;
        private AudioAttributes audioAttributes;
        private BandwidthMeter bandwidthMeter;
        private boolean buildCalled;
        private Clock clock;
        private final Context context;
        private long detachSurfaceTimeoutMs;
        private long foregroundModeTimeoutMs;
        private boolean handleAudioBecomingNoisy;
        private boolean handleAudioFocus;
        private LivePlaybackSpeedControl livePlaybackSpeedControl;
        private LoadControl loadControl;
        private Looper looper;
        private MediaSourceFactory mediaSourceFactory;
        private boolean pauseAtEndOfMediaItems;
        private PriorityTaskManager priorityTaskManager;
        private long releaseTimeoutMs;
        private final RenderersFactory renderersFactory;
        private SeekParameters seekParameters;
        private boolean skipSilenceEnabled;
        private TrackSelector trackSelector;
        private boolean useLazyPreparation;
        private int videoScalingMode;
        private int wakeMode;

        public Builder(Context context) {
            this(context, new DefaultRenderersFactory(context), new DefaultExtractorsFactory());
        }

        public Builder(Context context, RenderersFactory renderersFactory) {
            this(context, renderersFactory, new DefaultExtractorsFactory());
        }

        public Builder(Context context, ExtractorsFactory extractorsFactory) {
            this(context, new DefaultRenderersFactory(context), extractorsFactory);
        }

        public Builder(Context context, RenderersFactory renderersFactory, ExtractorsFactory extractorsFactory) {
            this(context, renderersFactory, new DefaultTrackSelector(context), new DefaultMediaSourceFactory(context, extractorsFactory), new DefaultLoadControl(), DefaultBandwidthMeter.getSingletonInstance(context), new AnalyticsCollector(Clock.DEFAULT));
        }

        public Builder(Context context, RenderersFactory renderersFactory, TrackSelector trackSelector, MediaSourceFactory mediaSourceFactory, LoadControl loadControl, BandwidthMeter bandwidthMeter, AnalyticsCollector analyticsCollector) {
            this.context = context;
            this.renderersFactory = renderersFactory;
            this.trackSelector = trackSelector;
            this.mediaSourceFactory = mediaSourceFactory;
            this.loadControl = loadControl;
            this.bandwidthMeter = bandwidthMeter;
            this.analyticsCollector = analyticsCollector;
            this.looper = Util.getCurrentOrMainLooper();
            this.audioAttributes = AudioAttributes.DEFAULT;
            this.wakeMode = 0;
            this.videoScalingMode = 1;
            this.useLazyPreparation = true;
            this.seekParameters = SeekParameters.DEFAULT;
            this.livePlaybackSpeedControl = new DefaultLivePlaybackSpeedControl.Builder().build();
            this.clock = Clock.DEFAULT;
            this.releaseTimeoutMs = 500L;
            this.detachSurfaceTimeoutMs = SimpleExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS;
        }

        public Builder experimentalSetForegroundModeTimeoutMs(long j) {
            Assertions.checkState(!this.buildCalled);
            this.foregroundModeTimeoutMs = j;
            return this;
        }

        public Builder setTrackSelector(TrackSelector trackSelector) {
            Assertions.checkState(!this.buildCalled);
            this.trackSelector = trackSelector;
            return this;
        }

        public Builder setMediaSourceFactory(MediaSourceFactory mediaSourceFactory) {
            Assertions.checkState(!this.buildCalled);
            this.mediaSourceFactory = mediaSourceFactory;
            return this;
        }

        public Builder setLoadControl(LoadControl loadControl) {
            Assertions.checkState(!this.buildCalled);
            this.loadControl = loadControl;
            return this;
        }

        public Builder setBandwidthMeter(BandwidthMeter bandwidthMeter) {
            Assertions.checkState(!this.buildCalled);
            this.bandwidthMeter = bandwidthMeter;
            return this;
        }

        public Builder setLooper(Looper looper) {
            Assertions.checkState(!this.buildCalled);
            this.looper = looper;
            return this;
        }

        public Builder setAnalyticsCollector(AnalyticsCollector analyticsCollector) {
            Assertions.checkState(!this.buildCalled);
            this.analyticsCollector = analyticsCollector;
            return this;
        }

        public Builder setPriorityTaskManager(PriorityTaskManager priorityTaskManager) {
            Assertions.checkState(!this.buildCalled);
            this.priorityTaskManager = priorityTaskManager;
            return this;
        }

        public Builder setAudioAttributes(AudioAttributes audioAttributes, boolean z) {
            Assertions.checkState(!this.buildCalled);
            this.audioAttributes = audioAttributes;
            this.handleAudioFocus = z;
            return this;
        }

        public Builder setWakeMode(int i) {
            Assertions.checkState(!this.buildCalled);
            this.wakeMode = i;
            return this;
        }

        public Builder setHandleAudioBecomingNoisy(boolean z) {
            Assertions.checkState(!this.buildCalled);
            this.handleAudioBecomingNoisy = z;
            return this;
        }

        public Builder setSkipSilenceEnabled(boolean z) {
            Assertions.checkState(!this.buildCalled);
            this.skipSilenceEnabled = z;
            return this;
        }

        public Builder setVideoScalingMode(int i) {
            Assertions.checkState(!this.buildCalled);
            this.videoScalingMode = i;
            return this;
        }

        public Builder setUseLazyPreparation(boolean z) {
            Assertions.checkState(!this.buildCalled);
            this.useLazyPreparation = z;
            return this;
        }

        public Builder setSeekParameters(SeekParameters seekParameters) {
            Assertions.checkState(!this.buildCalled);
            this.seekParameters = seekParameters;
            return this;
        }

        public Builder setReleaseTimeoutMs(long j) {
            Assertions.checkState(!this.buildCalled);
            this.releaseTimeoutMs = j;
            return this;
        }

        public Builder setDetachSurfaceTimeoutMs(long j) {
            Assertions.checkState(!this.buildCalled);
            this.detachSurfaceTimeoutMs = j;
            return this;
        }

        public Builder setPauseAtEndOfMediaItems(boolean z) {
            Assertions.checkState(!this.buildCalled);
            this.pauseAtEndOfMediaItems = z;
            return this;
        }

        public Builder setLivePlaybackSpeedControl(LivePlaybackSpeedControl livePlaybackSpeedControl) {
            Assertions.checkState(!this.buildCalled);
            this.livePlaybackSpeedControl = livePlaybackSpeedControl;
            return this;
        }

        public Builder setClock(Clock clock) {
            Assertions.checkState(!this.buildCalled);
            this.clock = clock;
            return this;
        }

        public SimpleExoPlayer build() {
            Assertions.checkState(!this.buildCalled);
            this.buildCalled = true;
            return new SimpleExoPlayer(this);
        }
    }

    @Deprecated
    protected SimpleExoPlayer(Context context, RenderersFactory renderersFactory, TrackSelector trackSelector, MediaSourceFactory mediaSourceFactory, LoadControl loadControl, BandwidthMeter bandwidthMeter, AnalyticsCollector analyticsCollector, boolean z, Clock clock, Looper looper) {
        this(new Builder(context, renderersFactory).setTrackSelector(trackSelector).setMediaSourceFactory(mediaSourceFactory).setLoadControl(loadControl).setBandwidthMeter(bandwidthMeter).setAnalyticsCollector(analyticsCollector).setUseLazyPreparation(z).setClock(clock).setLooper(looper));
    }

    protected SimpleExoPlayer(Builder builder) {
        SimpleExoPlayer simpleExoPlayer;
        ExoPlayerImpl exoPlayerImpl;
        ConditionVariable conditionVariable = new ConditionVariable();
        this.constructorFinished = conditionVariable;
        try {
            Context applicationContext = builder.context.getApplicationContext();
            this.applicationContext = applicationContext;
            AnalyticsCollector analyticsCollector = builder.analyticsCollector;
            this.analyticsCollector = analyticsCollector;
            this.priorityTaskManager = builder.priorityTaskManager;
            this.audioAttributes = builder.audioAttributes;
            this.videoScalingMode = builder.videoScalingMode;
            this.skipSilenceEnabled = builder.skipSilenceEnabled;
            this.detachSurfaceTimeoutMs = builder.detachSurfaceTimeoutMs;
            ComponentListener componentListener = new ComponentListener();
            this.componentListener = componentListener;
            FrameMetadataListener frameMetadataListener = new FrameMetadataListener();
            this.frameMetadataListener = frameMetadataListener;
            this.videoListeners = new CopyOnWriteArraySet<>();
            this.audioListeners = new CopyOnWriteArraySet<>();
            this.textOutputs = new CopyOnWriteArraySet<>();
            this.metadataOutputs = new CopyOnWriteArraySet<>();
            this.deviceListeners = new CopyOnWriteArraySet<>();
            Handler handler = new Handler(builder.looper);
            Renderer[] createRenderers = builder.renderersFactory.createRenderers(handler, componentListener, componentListener, componentListener, componentListener);
            this.renderers = createRenderers;
            this.audioVolume = 1.0f;
            if (Util.SDK_INT < 21) {
                this.audioSessionId = initializeKeepSessionIdAudioTrack(0);
            } else {
                this.audioSessionId = C.generateAudioSessionIdV21(applicationContext);
            }
            this.currentCues = Collections.emptyList();
            this.throwsWhenUsingWrongThread = true;
            try {
                exoPlayerImpl = new ExoPlayerImpl(createRenderers, builder.trackSelector, builder.mediaSourceFactory, builder.loadControl, builder.bandwidthMeter, analyticsCollector, builder.useLazyPreparation, builder.seekParameters, builder.livePlaybackSpeedControl, builder.releaseTimeoutMs, builder.pauseAtEndOfMediaItems, builder.clock, builder.looper, this, new Player.Commands.Builder().addAll(15, 16, 17, 18, 19, 20, 21, 22).build());
                simpleExoPlayer = this;
            } catch (Throwable th) {
                th = th;
                simpleExoPlayer = this;
            }
            try {
                simpleExoPlayer.player = exoPlayerImpl;
                exoPlayerImpl.addListener(componentListener);
                exoPlayerImpl.addAudioOffloadListener(componentListener);
                if (builder.foregroundModeTimeoutMs > 0) {
                    exoPlayerImpl.experimentalSetForegroundModeTimeoutMs(builder.foregroundModeTimeoutMs);
                }
                AudioBecomingNoisyManager audioBecomingNoisyManager = new AudioBecomingNoisyManager(builder.context, handler, componentListener);
                simpleExoPlayer.audioBecomingNoisyManager = audioBecomingNoisyManager;
                audioBecomingNoisyManager.setEnabled(builder.handleAudioBecomingNoisy);
                AudioFocusManager audioFocusManager = new AudioFocusManager(builder.context, handler, componentListener);
                simpleExoPlayer.audioFocusManager = audioFocusManager;
                audioFocusManager.setAudioAttributes(builder.handleAudioFocus ? simpleExoPlayer.audioAttributes : null);
                StreamVolumeManager streamVolumeManager = new StreamVolumeManager(builder.context, handler, componentListener);
                simpleExoPlayer.streamVolumeManager = streamVolumeManager;
                streamVolumeManager.setStreamType(Util.getStreamTypeForAudioUsage(simpleExoPlayer.audioAttributes.usage));
                WakeLockManager wakeLockManager = new WakeLockManager(builder.context);
                simpleExoPlayer.wakeLockManager = wakeLockManager;
                wakeLockManager.setEnabled(builder.wakeMode != 0);
                WifiLockManager wifiLockManager = new WifiLockManager(builder.context);
                simpleExoPlayer.wifiLockManager = wifiLockManager;
                wifiLockManager.setEnabled(builder.wakeMode == 2);
                simpleExoPlayer.deviceInfo = createDeviceInfo(streamVolumeManager);
                simpleExoPlayer.videoSize = VideoSize.UNKNOWN;
                simpleExoPlayer.sendRendererMessage(1, 102, Integer.valueOf(simpleExoPlayer.audioSessionId));
                simpleExoPlayer.sendRendererMessage(2, 102, Integer.valueOf(simpleExoPlayer.audioSessionId));
                simpleExoPlayer.sendRendererMessage(1, 3, simpleExoPlayer.audioAttributes);
                simpleExoPlayer.sendRendererMessage(2, 4, Integer.valueOf(simpleExoPlayer.videoScalingMode));
                simpleExoPlayer.sendRendererMessage(1, 101, Boolean.valueOf(simpleExoPlayer.skipSilenceEnabled));
                simpleExoPlayer.sendRendererMessage(2, 6, frameMetadataListener);
                simpleExoPlayer.sendRendererMessage(6, 7, frameMetadataListener);
                conditionVariable.open();
            } catch (Throwable th2) {
                th = th2;
                simpleExoPlayer.constructorFinished.open();
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            simpleExoPlayer = this;
        }
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void experimentalSetOffloadSchedulingEnabled(boolean z) {
        verifyApplicationThread();
        this.player.experimentalSetOffloadSchedulingEnabled(z);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public boolean experimentalIsSleepingForOffload() {
        verifyApplicationThread();
        return this.player.experimentalIsSleepingForOffload();
    }

    @Override // com.google.android.exoplayer2.ExoPlayer.VideoComponent
    public void setVideoScalingMode(int i) {
        verifyApplicationThread();
        this.videoScalingMode = i;
        sendRendererMessage(2, 4, Integer.valueOf(i));
    }

    @Override // com.google.android.exoplayer2.ExoPlayer.VideoComponent
    public int getVideoScalingMode() {
        return this.videoScalingMode;
    }

    @Override // com.google.android.exoplayer2.Player
    public VideoSize getVideoSize() {
        return this.videoSize;
    }

    @Override // com.google.android.exoplayer2.Player
    public void clearVideoSurface() {
        verifyApplicationThread();
        removeSurfaceCallbacks();
        setVideoOutputInternal(null);
        maybeNotifySurfaceSizeChanged(0, 0);
    }

    @Override // com.google.android.exoplayer2.Player
    public void clearVideoSurface(Surface surface) {
        verifyApplicationThread();
        if (surface == null || surface != this.videoOutput) {
            return;
        }
        clearVideoSurface();
    }

    @Override // com.google.android.exoplayer2.Player
    public void setVideoSurface(Surface surface) {
        verifyApplicationThread();
        removeSurfaceCallbacks();
        setVideoOutputInternal(surface);
        int i = surface == null ? 0 : -1;
        maybeNotifySurfaceSizeChanged(i, i);
    }

    @Override // com.google.android.exoplayer2.Player
    public void setVideoSurfaceHolder(SurfaceHolder surfaceHolder) {
        verifyApplicationThread();
        if (surfaceHolder == null) {
            clearVideoSurface();
            return;
        }
        removeSurfaceCallbacks();
        this.surfaceHolderSurfaceIsVideoOutput = true;
        this.surfaceHolder = surfaceHolder;
        surfaceHolder.addCallback(this.componentListener);
        Surface surface = surfaceHolder.getSurface();
        if (surface != null && surface.isValid()) {
            setVideoOutputInternal(surface);
            Rect surfaceFrame = surfaceHolder.getSurfaceFrame();
            maybeNotifySurfaceSizeChanged(surfaceFrame.width(), surfaceFrame.height());
        } else {
            setVideoOutputInternal(null);
            maybeNotifySurfaceSizeChanged(0, 0);
        }
    }

    @Override // com.google.android.exoplayer2.Player
    public void clearVideoSurfaceHolder(SurfaceHolder surfaceHolder) {
        verifyApplicationThread();
        if (surfaceHolder == null || surfaceHolder != this.surfaceHolder) {
            return;
        }
        clearVideoSurface();
    }

    @Override // com.google.android.exoplayer2.Player
    public void setVideoSurfaceView(SurfaceView surfaceView) {
        verifyApplicationThread();
        if (surfaceView instanceof VideoDecoderOutputBufferRenderer) {
            removeSurfaceCallbacks();
            setVideoOutputInternal(surfaceView);
            setNonVideoOutputSurfaceHolderInternal(surfaceView.getHolder());
        } else {
            if (surfaceView instanceof SphericalGLSurfaceView) {
                removeSurfaceCallbacks();
                this.sphericalGLSurfaceView = (SphericalGLSurfaceView) surfaceView;
                this.player.createMessage(this.frameMetadataListener).setType(10000).setPayload(this.sphericalGLSurfaceView).send();
                this.sphericalGLSurfaceView.addVideoSurfaceListener(this.componentListener);
                setVideoOutputInternal(this.sphericalGLSurfaceView.getVideoSurface());
                setNonVideoOutputSurfaceHolderInternal(surfaceView.getHolder());
                return;
            }
            setVideoSurfaceHolder(surfaceView == null ? null : surfaceView.getHolder());
        }
    }

    @Override // com.google.android.exoplayer2.Player
    public void clearVideoSurfaceView(SurfaceView surfaceView) {
        verifyApplicationThread();
        clearVideoSurfaceHolder(surfaceView == null ? null : surfaceView.getHolder());
    }

    @Override // com.google.android.exoplayer2.Player
    public void setVideoTextureView(TextureView textureView) {
        verifyApplicationThread();
        if (textureView == null) {
            clearVideoSurface();
            return;
        }
        removeSurfaceCallbacks();
        this.textureView = textureView;
        if (textureView.getSurfaceTextureListener() != null) {
            Log.w(TAG, "Replacing existing SurfaceTextureListener.");
        }
        textureView.setSurfaceTextureListener(this.componentListener);
        SurfaceTexture surfaceTexture = textureView.isAvailable() ? textureView.getSurfaceTexture() : null;
        if (surfaceTexture == null) {
            setVideoOutputInternal(null);
            maybeNotifySurfaceSizeChanged(0, 0);
        } else {
            setSurfaceTextureInternal(surfaceTexture);
            maybeNotifySurfaceSizeChanged(textureView.getWidth(), textureView.getHeight());
        }
    }

    @Override // com.google.android.exoplayer2.Player
    public void clearVideoTextureView(TextureView textureView) {
        verifyApplicationThread();
        if (textureView == null || textureView != this.textureView) {
            return;
        }
        clearVideoSurface();
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void addAudioOffloadListener(ExoPlayer.AudioOffloadListener audioOffloadListener) {
        this.player.addAudioOffloadListener(audioOffloadListener);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void removeAudioOffloadListener(ExoPlayer.AudioOffloadListener audioOffloadListener) {
        this.player.removeAudioOffloadListener(audioOffloadListener);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer.AudioComponent
    @Deprecated
    public void addAudioListener(AudioListener audioListener) {
        Assertions.checkNotNull(audioListener);
        this.audioListeners.add(audioListener);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer.AudioComponent
    @Deprecated
    public void removeAudioListener(AudioListener audioListener) {
        this.audioListeners.remove(audioListener);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer.AudioComponent
    public void setAudioAttributes(AudioAttributes audioAttributes, boolean z) {
        verifyApplicationThread();
        if (this.playerReleased) {
            return;
        }
        if (!Util.areEqual(this.audioAttributes, audioAttributes)) {
            this.audioAttributes = audioAttributes;
            sendRendererMessage(1, 3, audioAttributes);
            this.streamVolumeManager.setStreamType(Util.getStreamTypeForAudioUsage(audioAttributes.usage));
            this.analyticsCollector.onAudioAttributesChanged(audioAttributes);
            Iterator<AudioListener> it = this.audioListeners.iterator();
            while (it.hasNext()) {
                it.next().onAudioAttributesChanged(audioAttributes);
            }
        }
        AudioFocusManager audioFocusManager = this.audioFocusManager;
        if (!z) {
            audioAttributes = null;
        }
        audioFocusManager.setAudioAttributes(audioAttributes);
        boolean playWhenReady = getPlayWhenReady();
        int updateAudioFocus = this.audioFocusManager.updateAudioFocus(playWhenReady, getPlaybackState());
        updatePlayWhenReady(playWhenReady, updateAudioFocus, getPlayWhenReadyChangeReason(playWhenReady, updateAudioFocus));
    }

    @Override // com.google.android.exoplayer2.Player
    public AudioAttributes getAudioAttributes() {
        return this.audioAttributes;
    }

    @Override // com.google.android.exoplayer2.ExoPlayer.AudioComponent
    public void setAudioSessionId(int i) {
        verifyApplicationThread();
        if (this.audioSessionId == i) {
            return;
        }
        if (i == 0) {
            if (Util.SDK_INT < 21) {
                i = initializeKeepSessionIdAudioTrack(0);
            } else {
                i = C.generateAudioSessionIdV21(this.applicationContext);
            }
        } else if (Util.SDK_INT < 21) {
            initializeKeepSessionIdAudioTrack(i);
        }
        this.audioSessionId = i;
        sendRendererMessage(1, 102, Integer.valueOf(i));
        sendRendererMessage(2, 102, Integer.valueOf(i));
        this.analyticsCollector.onAudioSessionIdChanged(i);
        Iterator<AudioListener> it = this.audioListeners.iterator();
        while (it.hasNext()) {
            it.next().onAudioSessionIdChanged(i);
        }
    }

    @Override // com.google.android.exoplayer2.ExoPlayer.AudioComponent
    public int getAudioSessionId() {
        return this.audioSessionId;
    }

    @Override // com.google.android.exoplayer2.ExoPlayer.AudioComponent
    public void setAuxEffectInfo(AuxEffectInfo auxEffectInfo) {
        verifyApplicationThread();
        sendRendererMessage(1, 5, auxEffectInfo);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer.AudioComponent
    public void clearAuxEffectInfo() {
        setAuxEffectInfo(new AuxEffectInfo(0, 0.0f));
    }

    @Override // com.google.android.exoplayer2.Player
    public void setVolume(float f) {
        verifyApplicationThread();
        float constrainValue = Util.constrainValue(f, 0.0f, 1.0f);
        if (this.audioVolume == constrainValue) {
            return;
        }
        this.audioVolume = constrainValue;
        sendVolumeToRenderers();
        this.analyticsCollector.onVolumeChanged(constrainValue);
        Iterator<AudioListener> it = this.audioListeners.iterator();
        while (it.hasNext()) {
            it.next().onVolumeChanged(constrainValue);
        }
    }

    @Override // com.google.android.exoplayer2.Player
    public float getVolume() {
        return this.audioVolume;
    }

    @Override // com.google.android.exoplayer2.ExoPlayer.AudioComponent
    public boolean getSkipSilenceEnabled() {
        return this.skipSilenceEnabled;
    }

    @Override // com.google.android.exoplayer2.ExoPlayer.AudioComponent
    public void setSkipSilenceEnabled(boolean z) {
        verifyApplicationThread();
        if (this.skipSilenceEnabled == z) {
            return;
        }
        this.skipSilenceEnabled = z;
        sendRendererMessage(1, 101, Boolean.valueOf(z));
        notifySkipSilenceEnabledChanged();
    }

    public AnalyticsCollector getAnalyticsCollector() {
        return this.analyticsCollector;
    }

    public void addAnalyticsListener(AnalyticsListener analyticsListener) {
        Assertions.checkNotNull(analyticsListener);
        this.analyticsCollector.addListener(analyticsListener);
    }

    public void removeAnalyticsListener(AnalyticsListener analyticsListener) {
        this.analyticsCollector.removeListener(analyticsListener);
    }

    public void setHandleAudioBecomingNoisy(boolean z) {
        verifyApplicationThread();
        if (this.playerReleased) {
            return;
        }
        this.audioBecomingNoisyManager.setEnabled(z);
    }

    public void setPriorityTaskManager(PriorityTaskManager priorityTaskManager) {
        verifyApplicationThread();
        if (Util.areEqual(this.priorityTaskManager, priorityTaskManager)) {
            return;
        }
        if (this.isPriorityTaskManagerRegistered) {
            ((PriorityTaskManager) Assertions.checkNotNull(this.priorityTaskManager)).remove(0);
        }
        if (priorityTaskManager != null && isLoading()) {
            priorityTaskManager.add(0);
            this.isPriorityTaskManagerRegistered = true;
        } else {
            this.isPriorityTaskManagerRegistered = false;
        }
        this.priorityTaskManager = priorityTaskManager;
    }

    public Format getVideoFormat() {
        return this.videoFormat;
    }

    public Format getAudioFormat() {
        return this.audioFormat;
    }

    public DecoderCounters getVideoDecoderCounters() {
        return this.videoDecoderCounters;
    }

    public DecoderCounters getAudioDecoderCounters() {
        return this.audioDecoderCounters;
    }

    @Override // com.google.android.exoplayer2.ExoPlayer.VideoComponent
    @Deprecated
    public void addVideoListener(VideoListener videoListener) {
        Assertions.checkNotNull(videoListener);
        this.videoListeners.add(videoListener);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer.VideoComponent
    @Deprecated
    public void removeVideoListener(VideoListener videoListener) {
        this.videoListeners.remove(videoListener);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer.VideoComponent
    public void setVideoFrameMetadataListener(VideoFrameMetadataListener videoFrameMetadataListener) {
        verifyApplicationThread();
        this.videoFrameMetadataListener = videoFrameMetadataListener;
        this.player.createMessage(this.frameMetadataListener).setType(6).setPayload(videoFrameMetadataListener).send();
    }

    @Override // com.google.android.exoplayer2.ExoPlayer.VideoComponent
    public void clearVideoFrameMetadataListener(VideoFrameMetadataListener videoFrameMetadataListener) {
        verifyApplicationThread();
        if (this.videoFrameMetadataListener != videoFrameMetadataListener) {
            return;
        }
        this.player.createMessage(this.frameMetadataListener).setType(6).setPayload(null).send();
    }

    @Override // com.google.android.exoplayer2.ExoPlayer.VideoComponent
    public void setCameraMotionListener(CameraMotionListener cameraMotionListener) {
        verifyApplicationThread();
        this.cameraMotionListener = cameraMotionListener;
        this.player.createMessage(this.frameMetadataListener).setType(7).setPayload(cameraMotionListener).send();
    }

    @Override // com.google.android.exoplayer2.ExoPlayer.VideoComponent
    public void clearCameraMotionListener(CameraMotionListener cameraMotionListener) {
        verifyApplicationThread();
        if (this.cameraMotionListener != cameraMotionListener) {
            return;
        }
        this.player.createMessage(this.frameMetadataListener).setType(7).setPayload(null).send();
    }

    @Override // com.google.android.exoplayer2.ExoPlayer.TextComponent
    @Deprecated
    public void addTextOutput(TextOutput textOutput) {
        Assertions.checkNotNull(textOutput);
        this.textOutputs.add(textOutput);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer.TextComponent
    @Deprecated
    public void removeTextOutput(TextOutput textOutput) {
        this.textOutputs.remove(textOutput);
    }

    @Override // com.google.android.exoplayer2.Player
    public List<Cue> getCurrentCues() {
        verifyApplicationThread();
        return this.currentCues;
    }

    @Override // com.google.android.exoplayer2.ExoPlayer.MetadataComponent
    @Deprecated
    public void addMetadataOutput(MetadataOutput metadataOutput) {
        Assertions.checkNotNull(metadataOutput);
        this.metadataOutputs.add(metadataOutput);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer.MetadataComponent
    @Deprecated
    public void removeMetadataOutput(MetadataOutput metadataOutput) {
        this.metadataOutputs.remove(metadataOutput);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public Looper getPlaybackLooper() {
        return this.player.getPlaybackLooper();
    }

    @Override // com.google.android.exoplayer2.Player
    public Looper getApplicationLooper() {
        return this.player.getApplicationLooper();
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public Clock getClock() {
        return this.player.getClock();
    }

    @Override // com.google.android.exoplayer2.Player
    public void addListener(Player.Listener listener) {
        Assertions.checkNotNull(listener);
        addAudioListener(listener);
        addVideoListener(listener);
        addTextOutput(listener);
        addMetadataOutput(listener);
        addDeviceListener(listener);
        addListener((Player.EventListener) listener);
    }

    @Override // com.google.android.exoplayer2.Player
    @Deprecated
    public void addListener(Player.EventListener eventListener) {
        Assertions.checkNotNull(eventListener);
        this.player.addListener(eventListener);
    }

    @Override // com.google.android.exoplayer2.Player
    public void removeListener(Player.Listener listener) {
        Assertions.checkNotNull(listener);
        removeAudioListener(listener);
        removeVideoListener(listener);
        removeTextOutput(listener);
        removeMetadataOutput(listener);
        removeDeviceListener(listener);
        removeListener((Player.EventListener) listener);
    }

    @Override // com.google.android.exoplayer2.Player
    @Deprecated
    public void removeListener(Player.EventListener eventListener) {
        this.player.removeListener(eventListener);
    }

    @Override // com.google.android.exoplayer2.Player
    public int getPlaybackState() {
        verifyApplicationThread();
        return this.player.getPlaybackState();
    }

    @Override // com.google.android.exoplayer2.Player
    public int getPlaybackSuppressionReason() {
        verifyApplicationThread();
        return this.player.getPlaybackSuppressionReason();
    }

    @Override // com.google.android.exoplayer2.Player
    public ExoPlaybackException getPlayerError() {
        verifyApplicationThread();
        return this.player.getPlayerError();
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    @Deprecated
    public void retry() {
        verifyApplicationThread();
        prepare();
    }

    @Override // com.google.android.exoplayer2.Player
    public Player.Commands getAvailableCommands() {
        verifyApplicationThread();
        return this.player.getAvailableCommands();
    }

    @Override // com.google.android.exoplayer2.Player
    public void prepare() {
        verifyApplicationThread();
        boolean playWhenReady = getPlayWhenReady();
        int updateAudioFocus = this.audioFocusManager.updateAudioFocus(playWhenReady, 2);
        updatePlayWhenReady(playWhenReady, updateAudioFocus, getPlayWhenReadyChangeReason(playWhenReady, updateAudioFocus));
        this.player.prepare();
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    @Deprecated
    public void prepare(MediaSource mediaSource) {
        prepare(mediaSource, true, true);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    @Deprecated
    public void prepare(MediaSource mediaSource, boolean z, boolean z2) {
        verifyApplicationThread();
        setMediaSources(Collections.singletonList(mediaSource), z);
        prepare();
    }

    @Override // com.google.android.exoplayer2.Player
    public void setMediaItems(List<MediaItem> list, boolean z) {
        verifyApplicationThread();
        this.player.setMediaItems(list, z);
    }

    @Override // com.google.android.exoplayer2.Player
    public void setMediaItems(List<MediaItem> list, int i, long j) {
        verifyApplicationThread();
        this.player.setMediaItems(list, i, j);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void setMediaSources(List<MediaSource> list) {
        verifyApplicationThread();
        this.player.setMediaSources(list);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void setMediaSources(List<MediaSource> list, boolean z) {
        verifyApplicationThread();
        this.player.setMediaSources(list, z);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void setMediaSources(List<MediaSource> list, int i, long j) {
        verifyApplicationThread();
        this.player.setMediaSources(list, i, j);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void setMediaSource(MediaSource mediaSource) {
        verifyApplicationThread();
        this.player.setMediaSource(mediaSource);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void setMediaSource(MediaSource mediaSource, boolean z) {
        verifyApplicationThread();
        this.player.setMediaSource(mediaSource, z);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void setMediaSource(MediaSource mediaSource, long j) {
        verifyApplicationThread();
        this.player.setMediaSource(mediaSource, j);
    }

    @Override // com.google.android.exoplayer2.Player
    public void addMediaItems(int i, List<MediaItem> list) {
        verifyApplicationThread();
        this.player.addMediaItems(i, list);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void addMediaSource(MediaSource mediaSource) {
        verifyApplicationThread();
        this.player.addMediaSource(mediaSource);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void addMediaSource(int i, MediaSource mediaSource) {
        verifyApplicationThread();
        this.player.addMediaSource(i, mediaSource);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void addMediaSources(List<MediaSource> list) {
        verifyApplicationThread();
        this.player.addMediaSources(list);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void addMediaSources(int i, List<MediaSource> list) {
        verifyApplicationThread();
        this.player.addMediaSources(i, list);
    }

    @Override // com.google.android.exoplayer2.Player
    public void moveMediaItems(int i, int i2, int i3) {
        verifyApplicationThread();
        this.player.moveMediaItems(i, i2, i3);
    }

    @Override // com.google.android.exoplayer2.Player
    public void removeMediaItems(int i, int i2) {
        verifyApplicationThread();
        this.player.removeMediaItems(i, i2);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void setShuffleOrder(ShuffleOrder shuffleOrder) {
        verifyApplicationThread();
        this.player.setShuffleOrder(shuffleOrder);
    }

    @Override // com.google.android.exoplayer2.Player
    public void setPlayWhenReady(boolean z) {
        verifyApplicationThread();
        int updateAudioFocus = this.audioFocusManager.updateAudioFocus(z, getPlaybackState());
        updatePlayWhenReady(z, updateAudioFocus, getPlayWhenReadyChangeReason(z, updateAudioFocus));
    }

    @Override // com.google.android.exoplayer2.Player
    public boolean getPlayWhenReady() {
        verifyApplicationThread();
        return this.player.getPlayWhenReady();
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void setPauseAtEndOfMediaItems(boolean z) {
        verifyApplicationThread();
        this.player.setPauseAtEndOfMediaItems(z);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public boolean getPauseAtEndOfMediaItems() {
        verifyApplicationThread();
        return this.player.getPauseAtEndOfMediaItems();
    }

    @Override // com.google.android.exoplayer2.Player
    public int getRepeatMode() {
        verifyApplicationThread();
        return this.player.getRepeatMode();
    }

    @Override // com.google.android.exoplayer2.Player
    public void setRepeatMode(int i) {
        verifyApplicationThread();
        this.player.setRepeatMode(i);
    }

    @Override // com.google.android.exoplayer2.Player
    public void setShuffleModeEnabled(boolean z) {
        verifyApplicationThread();
        this.player.setShuffleModeEnabled(z);
    }

    @Override // com.google.android.exoplayer2.Player
    public boolean getShuffleModeEnabled() {
        verifyApplicationThread();
        return this.player.getShuffleModeEnabled();
    }

    @Override // com.google.android.exoplayer2.Player
    public boolean isLoading() {
        verifyApplicationThread();
        return this.player.isLoading();
    }

    @Override // com.google.android.exoplayer2.Player
    public void seekTo(int i, long j) {
        verifyApplicationThread();
        this.analyticsCollector.notifySeekStarted();
        this.player.seekTo(i, j);
    }

    @Override // com.google.android.exoplayer2.Player
    public void setPlaybackParameters(PlaybackParameters playbackParameters) {
        verifyApplicationThread();
        this.player.setPlaybackParameters(playbackParameters);
    }

    @Override // com.google.android.exoplayer2.Player
    public PlaybackParameters getPlaybackParameters() {
        verifyApplicationThread();
        return this.player.getPlaybackParameters();
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void setSeekParameters(SeekParameters seekParameters) {
        verifyApplicationThread();
        this.player.setSeekParameters(seekParameters);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public SeekParameters getSeekParameters() {
        verifyApplicationThread();
        return this.player.getSeekParameters();
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void setForegroundMode(boolean z) {
        verifyApplicationThread();
        this.player.setForegroundMode(z);
    }

    @Override // com.google.android.exoplayer2.Player
    @Deprecated
    public void stop(boolean z) {
        verifyApplicationThread();
        this.audioFocusManager.updateAudioFocus(getPlayWhenReady(), 1);
        this.player.stop(z);
        this.currentCues = Collections.emptyList();
    }

    @Override // com.google.android.exoplayer2.Player
    public void release() {
        AudioTrack audioTrack;
        verifyApplicationThread();
        if (Util.SDK_INT < 21 && (audioTrack = this.keepSessionIdAudioTrack) != null) {
            audioTrack.release();
            this.keepSessionIdAudioTrack = null;
        }
        this.audioBecomingNoisyManager.setEnabled(false);
        this.streamVolumeManager.release();
        this.wakeLockManager.setStayAwake(false);
        this.wifiLockManager.setStayAwake(false);
        this.audioFocusManager.release();
        this.player.release();
        this.analyticsCollector.release();
        removeSurfaceCallbacks();
        Surface surface = this.ownedSurface;
        if (surface != null) {
            surface.release();
            this.ownedSurface = null;
        }
        if (this.isPriorityTaskManagerRegistered) {
            ((PriorityTaskManager) Assertions.checkNotNull(this.priorityTaskManager)).remove(0);
            this.isPriorityTaskManagerRegistered = false;
        }
        this.currentCues = Collections.emptyList();
        this.playerReleased = true;
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public PlayerMessage createMessage(PlayerMessage.Target target) {
        verifyApplicationThread();
        return this.player.createMessage(target);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public int getRendererCount() {
        verifyApplicationThread();
        return this.player.getRendererCount();
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public int getRendererType(int i) {
        verifyApplicationThread();
        return this.player.getRendererType(i);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public TrackSelector getTrackSelector() {
        verifyApplicationThread();
        return this.player.getTrackSelector();
    }

    @Override // com.google.android.exoplayer2.Player
    public TrackGroupArray getCurrentTrackGroups() {
        verifyApplicationThread();
        return this.player.getCurrentTrackGroups();
    }

    @Override // com.google.android.exoplayer2.Player
    public TrackSelectionArray getCurrentTrackSelections() {
        verifyApplicationThread();
        return this.player.getCurrentTrackSelections();
    }

    @Override // com.google.android.exoplayer2.Player
    public List<Metadata> getCurrentStaticMetadata() {
        verifyApplicationThread();
        return this.player.getCurrentStaticMetadata();
    }

    @Override // com.google.android.exoplayer2.Player
    public MediaMetadata getMediaMetadata() {
        return this.player.getMediaMetadata();
    }

    @Override // com.google.android.exoplayer2.Player
    public Timeline getCurrentTimeline() {
        verifyApplicationThread();
        return this.player.getCurrentTimeline();
    }

    @Override // com.google.android.exoplayer2.Player
    public int getCurrentPeriodIndex() {
        verifyApplicationThread();
        return this.player.getCurrentPeriodIndex();
    }

    @Override // com.google.android.exoplayer2.Player
    public int getCurrentWindowIndex() {
        verifyApplicationThread();
        return this.player.getCurrentWindowIndex();
    }

    @Override // com.google.android.exoplayer2.Player
    public long getDuration() {
        verifyApplicationThread();
        return this.player.getDuration();
    }

    @Override // com.google.android.exoplayer2.Player
    public long getCurrentPosition() {
        verifyApplicationThread();
        return this.player.getCurrentPosition();
    }

    @Override // com.google.android.exoplayer2.Player
    public long getBufferedPosition() {
        verifyApplicationThread();
        return this.player.getBufferedPosition();
    }

    @Override // com.google.android.exoplayer2.Player
    public long getTotalBufferedDuration() {
        verifyApplicationThread();
        return this.player.getTotalBufferedDuration();
    }

    @Override // com.google.android.exoplayer2.Player
    public boolean isPlayingAd() {
        verifyApplicationThread();
        return this.player.isPlayingAd();
    }

    @Override // com.google.android.exoplayer2.Player
    public int getCurrentAdGroupIndex() {
        verifyApplicationThread();
        return this.player.getCurrentAdGroupIndex();
    }

    @Override // com.google.android.exoplayer2.Player
    public int getCurrentAdIndexInAdGroup() {
        verifyApplicationThread();
        return this.player.getCurrentAdIndexInAdGroup();
    }

    @Override // com.google.android.exoplayer2.Player
    public long getContentPosition() {
        verifyApplicationThread();
        return this.player.getContentPosition();
    }

    @Override // com.google.android.exoplayer2.Player
    public long getContentBufferedPosition() {
        verifyApplicationThread();
        return this.player.getContentBufferedPosition();
    }

    @Deprecated
    public void setHandleWakeLock(boolean z) {
        setWakeMode(z ? 1 : 0);
    }

    public void setWakeMode(int i) {
        verifyApplicationThread();
        if (i == 0) {
            this.wakeLockManager.setEnabled(false);
            this.wifiLockManager.setEnabled(false);
        } else if (i == 1) {
            this.wakeLockManager.setEnabled(true);
            this.wifiLockManager.setEnabled(false);
        } else {
            if (i != 2) {
                return;
            }
            this.wakeLockManager.setEnabled(true);
            this.wifiLockManager.setEnabled(true);
        }
    }

    @Override // com.google.android.exoplayer2.ExoPlayer.DeviceComponent
    @Deprecated
    public void addDeviceListener(DeviceListener deviceListener) {
        Assertions.checkNotNull(deviceListener);
        this.deviceListeners.add(deviceListener);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer.DeviceComponent
    @Deprecated
    public void removeDeviceListener(DeviceListener deviceListener) {
        this.deviceListeners.remove(deviceListener);
    }

    @Override // com.google.android.exoplayer2.Player
    public DeviceInfo getDeviceInfo() {
        verifyApplicationThread();
        return this.deviceInfo;
    }

    @Override // com.google.android.exoplayer2.Player
    public int getDeviceVolume() {
        verifyApplicationThread();
        return this.streamVolumeManager.getVolume();
    }

    @Override // com.google.android.exoplayer2.Player
    public boolean isDeviceMuted() {
        verifyApplicationThread();
        return this.streamVolumeManager.isMuted();
    }

    @Override // com.google.android.exoplayer2.Player
    public void setDeviceVolume(int i) {
        verifyApplicationThread();
        this.streamVolumeManager.setVolume(i);
    }

    @Override // com.google.android.exoplayer2.Player
    public void increaseDeviceVolume() {
        verifyApplicationThread();
        this.streamVolumeManager.increaseVolume();
    }

    @Override // com.google.android.exoplayer2.Player
    public void decreaseDeviceVolume() {
        verifyApplicationThread();
        this.streamVolumeManager.decreaseVolume();
    }

    @Override // com.google.android.exoplayer2.Player
    public void setDeviceMuted(boolean z) {
        verifyApplicationThread();
        this.streamVolumeManager.setMuted(z);
    }

    @Deprecated
    public void setThrowsWhenUsingWrongThread(boolean z) {
        this.throwsWhenUsingWrongThread = z;
    }

    private void removeSurfaceCallbacks() {
        if (this.sphericalGLSurfaceView != null) {
            this.player.createMessage(this.frameMetadataListener).setType(10000).setPayload(null).send();
            this.sphericalGLSurfaceView.removeVideoSurfaceListener(this.componentListener);
            this.sphericalGLSurfaceView = null;
        }
        TextureView textureView = this.textureView;
        if (textureView != null) {
            if (textureView.getSurfaceTextureListener() != this.componentListener) {
                Log.w(TAG, "SurfaceTextureListener already unset or replaced.");
            } else {
                this.textureView.setSurfaceTextureListener(null);
            }
            this.textureView = null;
        }
        SurfaceHolder surfaceHolder = this.surfaceHolder;
        if (surfaceHolder != null) {
            surfaceHolder.removeCallback(this.componentListener);
            this.surfaceHolder = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSurfaceTextureInternal(SurfaceTexture surfaceTexture) {
        Surface surface = new Surface(surfaceTexture);
        setVideoOutputInternal(surface);
        this.ownedSurface = surface;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVideoOutputInternal(Object obj) {
        ArrayList arrayList = new ArrayList();
        for (Renderer renderer : this.renderers) {
            if (renderer.getTrackType() == 2) {
                arrayList.add(this.player.createMessage(renderer).setType(1).setPayload(obj).send());
            }
        }
        Object obj2 = this.videoOutput;
        if (obj2 != null && obj2 != obj) {
            try {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((PlayerMessage) it.next()).blockUntilDelivered(this.detachSurfaceTimeoutMs);
                }
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            } catch (TimeoutException unused2) {
                this.player.stop(false, ExoPlaybackException.createForRenderer(new ExoTimeoutException(3)));
            }
            Object obj3 = this.videoOutput;
            Surface surface = this.ownedSurface;
            if (obj3 == surface) {
                surface.release();
                this.ownedSurface = null;
            }
        }
        this.videoOutput = obj;
    }

    private void setNonVideoOutputSurfaceHolderInternal(SurfaceHolder surfaceHolder) {
        this.surfaceHolderSurfaceIsVideoOutput = false;
        this.surfaceHolder = surfaceHolder;
        surfaceHolder.addCallback(this.componentListener);
        Surface surface = this.surfaceHolder.getSurface();
        if (surface != null && surface.isValid()) {
            Rect surfaceFrame = this.surfaceHolder.getSurfaceFrame();
            maybeNotifySurfaceSizeChanged(surfaceFrame.width(), surfaceFrame.height());
        } else {
            maybeNotifySurfaceSizeChanged(0, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void maybeNotifySurfaceSizeChanged(int i, int i2) {
        if (i == this.surfaceWidth && i2 == this.surfaceHeight) {
            return;
        }
        this.surfaceWidth = i;
        this.surfaceHeight = i2;
        this.analyticsCollector.onSurfaceSizeChanged(i, i2);
        Iterator<VideoListener> it = this.videoListeners.iterator();
        while (it.hasNext()) {
            it.next().onSurfaceSizeChanged(i, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendVolumeToRenderers() {
        sendRendererMessage(1, 2, Float.valueOf(this.audioVolume * this.audioFocusManager.getVolumeMultiplier()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifySkipSilenceEnabledChanged() {
        this.analyticsCollector.onSkipSilenceEnabledChanged(this.skipSilenceEnabled);
        Iterator<AudioListener> it = this.audioListeners.iterator();
        while (it.hasNext()) {
            it.next().onSkipSilenceEnabledChanged(this.skipSilenceEnabled);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updatePlayWhenReady(boolean z, int i, int i2) {
        int i3 = 0;
        boolean z2 = z && i != -1;
        if (z2 && i != 1) {
            i3 = 1;
        }
        this.player.setPlayWhenReady(z2, i3, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateWakeAndWifiLock() {
        int playbackState = getPlaybackState();
        if (playbackState != 1) {
            if (playbackState == 2 || playbackState == 3) {
                this.wakeLockManager.setStayAwake(getPlayWhenReady() && !experimentalIsSleepingForOffload());
                this.wifiLockManager.setStayAwake(getPlayWhenReady());
                return;
            } else if (playbackState != 4) {
                throw new IllegalStateException();
            }
        }
        this.wakeLockManager.setStayAwake(false);
        this.wifiLockManager.setStayAwake(false);
    }

    private void verifyApplicationThread() {
        this.constructorFinished.blockUninterruptible();
        if (Thread.currentThread() != getApplicationLooper().getThread()) {
            String formatInvariant = Util.formatInvariant("Player is accessed on the wrong thread.\nCurrent thread: '%s'\nExpected thread: '%s'\nSee https://exoplayer.dev/issues/player-accessed-on-wrong-thread", Thread.currentThread().getName(), getApplicationLooper().getThread().getName());
            if (this.throwsWhenUsingWrongThread) {
                throw new IllegalStateException(formatInvariant);
            }
            Log.w(TAG, formatInvariant, this.hasNotifiedFullWrongThreadWarning ? null : new IllegalStateException());
            this.hasNotifiedFullWrongThreadWarning = true;
        }
    }

    private void sendRendererMessage(int i, int i2, Object obj) {
        for (Renderer renderer : this.renderers) {
            if (renderer.getTrackType() == i) {
                this.player.createMessage(renderer).setType(i2).setPayload(obj).send();
            }
        }
    }

    private int initializeKeepSessionIdAudioTrack(int i) {
        AudioTrack audioTrack = this.keepSessionIdAudioTrack;
        if (audioTrack != null && audioTrack.getAudioSessionId() != i) {
            this.keepSessionIdAudioTrack.release();
            this.keepSessionIdAudioTrack = null;
        }
        if (this.keepSessionIdAudioTrack == null) {
            this.keepSessionIdAudioTrack = new AudioTrack(3, 4000, 4, 2, 2, 0, i);
        }
        return this.keepSessionIdAudioTrack.getAudioSessionId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static DeviceInfo createDeviceInfo(StreamVolumeManager streamVolumeManager) {
        return new DeviceInfo(0, streamVolumeManager.getMinVolume(), streamVolumeManager.getMaxVolume());
    }

    private final class ComponentListener implements VideoRendererEventListener, AudioRendererEventListener, TextOutput, MetadataOutput, SurfaceHolder.Callback, TextureView.SurfaceTextureListener, SphericalGLSurfaceView.VideoSurfaceListener, AudioFocusManager.PlayerControl, AudioBecomingNoisyManager.EventListener, StreamVolumeManager.Listener, Player.EventListener, ExoPlayer.AudioOffloadListener {
        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }

        private ComponentListener() {
        }

        @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
        public void onVideoEnabled(DecoderCounters decoderCounters) {
            SimpleExoPlayer.this.videoDecoderCounters = decoderCounters;
            SimpleExoPlayer.this.analyticsCollector.onVideoEnabled(decoderCounters);
        }

        @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
        public void onVideoDecoderInitialized(String str, long j, long j2) {
            SimpleExoPlayer.this.analyticsCollector.onVideoDecoderInitialized(str, j, j2);
        }

        @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
        public void onVideoInputFormatChanged(Format format, DecoderReuseEvaluation decoderReuseEvaluation) {
            SimpleExoPlayer.this.videoFormat = format;
            SimpleExoPlayer.this.analyticsCollector.onVideoInputFormatChanged(format, decoderReuseEvaluation);
        }

        @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
        public void onDroppedFrames(int i, long j) {
            SimpleExoPlayer.this.analyticsCollector.onDroppedFrames(i, j);
        }

        @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
        public void onVideoSizeChanged(VideoSize videoSize) {
            SimpleExoPlayer.this.videoSize = videoSize;
            SimpleExoPlayer.this.analyticsCollector.onVideoSizeChanged(videoSize);
            Iterator it = SimpleExoPlayer.this.videoListeners.iterator();
            while (it.hasNext()) {
                VideoListener videoListener = (VideoListener) it.next();
                videoListener.onVideoSizeChanged(videoSize);
                videoListener.onVideoSizeChanged(videoSize.width, videoSize.height, videoSize.unappliedRotationDegrees, videoSize.pixelWidthHeightRatio);
            }
        }

        @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
        public void onRenderedFirstFrame(Object obj, long j) {
            SimpleExoPlayer.this.analyticsCollector.onRenderedFirstFrame(obj, j);
            if (SimpleExoPlayer.this.videoOutput == obj) {
                Iterator it = SimpleExoPlayer.this.videoListeners.iterator();
                while (it.hasNext()) {
                    ((VideoListener) it.next()).onRenderedFirstFrame();
                }
            }
        }

        @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
        public void onVideoDecoderReleased(String str) {
            SimpleExoPlayer.this.analyticsCollector.onVideoDecoderReleased(str);
        }

        @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
        public void onVideoDisabled(DecoderCounters decoderCounters) {
            SimpleExoPlayer.this.analyticsCollector.onVideoDisabled(decoderCounters);
            SimpleExoPlayer.this.videoFormat = null;
            SimpleExoPlayer.this.videoDecoderCounters = null;
        }

        @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
        public void onVideoFrameProcessingOffset(long j, int i) {
            SimpleExoPlayer.this.analyticsCollector.onVideoFrameProcessingOffset(j, i);
        }

        @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
        public void onVideoCodecError(Exception exc) {
            SimpleExoPlayer.this.analyticsCollector.onVideoCodecError(exc);
        }

        @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
        public void onAudioEnabled(DecoderCounters decoderCounters) {
            SimpleExoPlayer.this.audioDecoderCounters = decoderCounters;
            SimpleExoPlayer.this.analyticsCollector.onAudioEnabled(decoderCounters);
        }

        @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
        public void onAudioDecoderInitialized(String str, long j, long j2) {
            SimpleExoPlayer.this.analyticsCollector.onAudioDecoderInitialized(str, j, j2);
        }

        @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
        public void onAudioInputFormatChanged(Format format, DecoderReuseEvaluation decoderReuseEvaluation) {
            SimpleExoPlayer.this.audioFormat = format;
            SimpleExoPlayer.this.analyticsCollector.onAudioInputFormatChanged(format, decoderReuseEvaluation);
        }

        @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
        public void onAudioPositionAdvancing(long j) {
            SimpleExoPlayer.this.analyticsCollector.onAudioPositionAdvancing(j);
        }

        @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
        public void onAudioUnderrun(int i, long j, long j2) {
            SimpleExoPlayer.this.analyticsCollector.onAudioUnderrun(i, j, j2);
        }

        @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
        public void onAudioDecoderReleased(String str) {
            SimpleExoPlayer.this.analyticsCollector.onAudioDecoderReleased(str);
        }

        @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
        public void onAudioDisabled(DecoderCounters decoderCounters) {
            SimpleExoPlayer.this.analyticsCollector.onAudioDisabled(decoderCounters);
            SimpleExoPlayer.this.audioFormat = null;
            SimpleExoPlayer.this.audioDecoderCounters = null;
        }

        @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
        public void onSkipSilenceEnabledChanged(boolean z) {
            if (SimpleExoPlayer.this.skipSilenceEnabled == z) {
                return;
            }
            SimpleExoPlayer.this.skipSilenceEnabled = z;
            SimpleExoPlayer.this.notifySkipSilenceEnabledChanged();
        }

        @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
        public void onAudioSinkError(Exception exc) {
            SimpleExoPlayer.this.analyticsCollector.onAudioSinkError(exc);
        }

        @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
        public void onAudioCodecError(Exception exc) {
            SimpleExoPlayer.this.analyticsCollector.onAudioCodecError(exc);
        }

        @Override // com.google.android.exoplayer2.text.TextOutput
        public void onCues(List<Cue> list) {
            SimpleExoPlayer.this.currentCues = list;
            Iterator it = SimpleExoPlayer.this.textOutputs.iterator();
            while (it.hasNext()) {
                ((TextOutput) it.next()).onCues(list);
            }
        }

        @Override // com.google.android.exoplayer2.metadata.MetadataOutput
        public void onMetadata(Metadata metadata) {
            SimpleExoPlayer.this.analyticsCollector.onMetadata(metadata);
            SimpleExoPlayer.this.player.onMetadata(metadata);
            Iterator it = SimpleExoPlayer.this.metadataOutputs.iterator();
            while (it.hasNext()) {
                ((MetadataOutput) it.next()).onMetadata(metadata);
            }
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            if (SimpleExoPlayer.this.surfaceHolderSurfaceIsVideoOutput) {
                SimpleExoPlayer.this.setVideoOutputInternal(surfaceHolder.getSurface());
            }
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            SimpleExoPlayer.this.maybeNotifySurfaceSizeChanged(i2, i3);
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            if (SimpleExoPlayer.this.surfaceHolderSurfaceIsVideoOutput) {
                SimpleExoPlayer.this.setVideoOutputInternal(null);
            }
            SimpleExoPlayer.this.maybeNotifySurfaceSizeChanged(0, 0);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            SimpleExoPlayer.this.setSurfaceTextureInternal(surfaceTexture);
            SimpleExoPlayer.this.maybeNotifySurfaceSizeChanged(i, i2);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            SimpleExoPlayer.this.maybeNotifySurfaceSizeChanged(i, i2);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            SimpleExoPlayer.this.setVideoOutputInternal(null);
            SimpleExoPlayer.this.maybeNotifySurfaceSizeChanged(0, 0);
            return true;
        }

        @Override // com.google.android.exoplayer2.video.spherical.SphericalGLSurfaceView.VideoSurfaceListener
        public void onVideoSurfaceCreated(Surface surface) {
            SimpleExoPlayer.this.setVideoOutputInternal(surface);
        }

        @Override // com.google.android.exoplayer2.video.spherical.SphericalGLSurfaceView.VideoSurfaceListener
        public void onVideoSurfaceDestroyed(Surface surface) {
            SimpleExoPlayer.this.setVideoOutputInternal(null);
        }

        @Override // com.google.android.exoplayer2.AudioFocusManager.PlayerControl
        public void setVolumeMultiplier(float f) {
            SimpleExoPlayer.this.sendVolumeToRenderers();
        }

        @Override // com.google.android.exoplayer2.AudioFocusManager.PlayerControl
        public void executePlayerCommand(int i) {
            boolean playWhenReady = SimpleExoPlayer.this.getPlayWhenReady();
            SimpleExoPlayer.this.updatePlayWhenReady(playWhenReady, i, SimpleExoPlayer.getPlayWhenReadyChangeReason(playWhenReady, i));
        }

        @Override // com.google.android.exoplayer2.AudioBecomingNoisyManager.EventListener
        public void onAudioBecomingNoisy() {
            SimpleExoPlayer.this.updatePlayWhenReady(false, -1, 3);
        }

        @Override // com.google.android.exoplayer2.StreamVolumeManager.Listener
        public void onStreamTypeChanged(int i) {
            DeviceInfo createDeviceInfo = SimpleExoPlayer.createDeviceInfo(SimpleExoPlayer.this.streamVolumeManager);
            if (createDeviceInfo.equals(SimpleExoPlayer.this.deviceInfo)) {
                return;
            }
            SimpleExoPlayer.this.deviceInfo = createDeviceInfo;
            Iterator it = SimpleExoPlayer.this.deviceListeners.iterator();
            while (it.hasNext()) {
                ((DeviceListener) it.next()).onDeviceInfoChanged(createDeviceInfo);
            }
        }

        @Override // com.google.android.exoplayer2.StreamVolumeManager.Listener
        public void onStreamVolumeChanged(int i, boolean z) {
            Iterator it = SimpleExoPlayer.this.deviceListeners.iterator();
            while (it.hasNext()) {
                ((DeviceListener) it.next()).onDeviceVolumeChanged(i, z);
            }
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public void onIsLoadingChanged(boolean z) {
            if (SimpleExoPlayer.this.priorityTaskManager != null) {
                if (!z || SimpleExoPlayer.this.isPriorityTaskManagerRegistered) {
                    if (z || !SimpleExoPlayer.this.isPriorityTaskManagerRegistered) {
                        return;
                    }
                    SimpleExoPlayer.this.priorityTaskManager.remove(0);
                    SimpleExoPlayer.this.isPriorityTaskManagerRegistered = false;
                    return;
                }
                SimpleExoPlayer.this.priorityTaskManager.add(0);
                SimpleExoPlayer.this.isPriorityTaskManagerRegistered = true;
            }
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public void onPlaybackStateChanged(int i) {
            SimpleExoPlayer.this.updateWakeAndWifiLock();
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public void onPlayWhenReadyChanged(boolean z, int i) {
            SimpleExoPlayer.this.updateWakeAndWifiLock();
        }

        @Override // com.google.android.exoplayer2.ExoPlayer.AudioOffloadListener
        public void onExperimentalSleepingForOffloadChanged(boolean z) {
            SimpleExoPlayer.this.updateWakeAndWifiLock();
        }
    }

    private static final class FrameMetadataListener implements VideoFrameMetadataListener, CameraMotionListener, PlayerMessage.Target {
        public static final int MSG_SET_CAMERA_MOTION_LISTENER = 7;
        public static final int MSG_SET_SPHERICAL_SURFACE_VIEW = 10000;
        public static final int MSG_SET_VIDEO_FRAME_METADATA_LISTENER = 6;
        private CameraMotionListener cameraMotionListener;
        private CameraMotionListener internalCameraMotionListener;
        private VideoFrameMetadataListener internalVideoFrameMetadataListener;
        private VideoFrameMetadataListener videoFrameMetadataListener;

        private FrameMetadataListener() {
        }

        @Override // com.google.android.exoplayer2.PlayerMessage.Target
        public void handleMessage(int i, Object obj) {
            if (i == 6) {
                this.videoFrameMetadataListener = (VideoFrameMetadataListener) obj;
                return;
            }
            if (i == 7) {
                this.cameraMotionListener = (CameraMotionListener) obj;
                return;
            }
            if (i != 10000) {
                return;
            }
            SphericalGLSurfaceView sphericalGLSurfaceView = (SphericalGLSurfaceView) obj;
            if (sphericalGLSurfaceView == null) {
                this.internalVideoFrameMetadataListener = null;
                this.internalCameraMotionListener = null;
            } else {
                this.internalVideoFrameMetadataListener = sphericalGLSurfaceView.getVideoFrameMetadataListener();
                this.internalCameraMotionListener = sphericalGLSurfaceView.getCameraMotionListener();
            }
        }

        @Override // com.google.android.exoplayer2.video.VideoFrameMetadataListener
        public void onVideoFrameAboutToBeRendered(long j, long j2, Format format, MediaFormat mediaFormat) {
            VideoFrameMetadataListener videoFrameMetadataListener = this.internalVideoFrameMetadataListener;
            if (videoFrameMetadataListener != null) {
                videoFrameMetadataListener.onVideoFrameAboutToBeRendered(j, j2, format, mediaFormat);
            }
            VideoFrameMetadataListener videoFrameMetadataListener2 = this.videoFrameMetadataListener;
            if (videoFrameMetadataListener2 != null) {
                videoFrameMetadataListener2.onVideoFrameAboutToBeRendered(j, j2, format, mediaFormat);
            }
        }

        @Override // com.google.android.exoplayer2.video.spherical.CameraMotionListener
        public void onCameraMotion(long j, float[] fArr) {
            CameraMotionListener cameraMotionListener = this.internalCameraMotionListener;
            if (cameraMotionListener != null) {
                cameraMotionListener.onCameraMotion(j, fArr);
            }
            CameraMotionListener cameraMotionListener2 = this.cameraMotionListener;
            if (cameraMotionListener2 != null) {
                cameraMotionListener2.onCameraMotion(j, fArr);
            }
        }

        @Override // com.google.android.exoplayer2.video.spherical.CameraMotionListener
        public void onCameraMotionReset() {
            CameraMotionListener cameraMotionListener = this.internalCameraMotionListener;
            if (cameraMotionListener != null) {
                cameraMotionListener.onCameraMotionReset();
            }
            CameraMotionListener cameraMotionListener2 = this.cameraMotionListener;
            if (cameraMotionListener2 != null) {
                cameraMotionListener2.onCameraMotionReset();
            }
        }
    }
}
