package com.google.android.exoplayer2.analytics;

import android.os.Looper;
import android.util.SparseArray;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.MediaMetadata;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.audio.AudioAttributes;
import com.google.android.exoplayer2.audio.AudioRendererEventListener;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.decoder.DecoderReuseEvaluation;
import com.google.android.exoplayer2.drm.DrmSessionEventListener;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.source.LoadEventInfo;
import com.google.android.exoplayer2.source.MediaLoadData;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Clock;
import com.google.android.exoplayer2.util.ExoFlags;
import com.google.android.exoplayer2.util.ListenerSet;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.VideoRendererEventListener;
import com.google.android.exoplayer2.video.VideoSize;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Iterables;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* loaded from: classes.dex */
public class AnalyticsCollector implements Player.Listener, AudioRendererEventListener, VideoRendererEventListener, MediaSourceEventListener, BandwidthMeter.EventListener, DrmSessionEventListener {
    private final Clock clock;
    private final SparseArray<AnalyticsListener.EventTime> eventTimes;
    private boolean isSeeking;
    private ListenerSet<AnalyticsListener> listeners;
    private final MediaPeriodQueueTracker mediaPeriodQueueTracker;
    private final Timeline.Period period;
    private Player player;
    private final Timeline.Window window;

    static /* synthetic */ void lambda$new$0(AnalyticsListener analyticsListener, ExoFlags exoFlags) {
    }

    public AnalyticsCollector(Clock clock) {
        this.clock = (Clock) Assertions.checkNotNull(clock);
        this.listeners = new ListenerSet<>(Util.getCurrentOrMainLooper(), clock, new ListenerSet.IterationFinishedEvent() { // from class: com.google.android.exoplayer2.analytics.-$$Lambda$AnalyticsCollector$V0bPQ2vMpj3Bkxt4vtI31G3kWlc
            @Override // com.google.android.exoplayer2.util.ListenerSet.IterationFinishedEvent
            public final void invoke(Object obj, ExoFlags exoFlags) {
                AnalyticsCollector.lambda$new$0((AnalyticsListener) obj, exoFlags);
            }
        });
        Timeline.Period period = new Timeline.Period();
        this.period = period;
        this.window = new Timeline.Window();
        this.mediaPeriodQueueTracker = new MediaPeriodQueueTracker(period);
        this.eventTimes = new SparseArray<>();
    }

    public void addListener(AnalyticsListener analyticsListener) {
        Assertions.checkNotNull(analyticsListener);
        this.listeners.add(analyticsListener);
    }

    public void removeListener(AnalyticsListener analyticsListener) {
        this.listeners.remove(analyticsListener);
    }

    public void setPlayer(final Player player, Looper looper) {
        Assertions.checkState(this.player == null || this.mediaPeriodQueueTracker.mediaPeriodQueue.isEmpty());
        this.player = (Player) Assertions.checkNotNull(player);
        this.listeners = this.listeners.copy(looper, new ListenerSet.IterationFinishedEvent() { // from class: com.google.android.exoplayer2.analytics.-$$Lambda$AnalyticsCollector$4Pupd4CGdtbqprZwT2MGLeu1J-0
            @Override // com.google.android.exoplayer2.util.ListenerSet.IterationFinishedEvent
            public final void invoke(Object obj, ExoFlags exoFlags) {
                AnalyticsCollector.this.lambda$setPlayer$1$AnalyticsCollector(player, (AnalyticsListener) obj, exoFlags);
            }
        });
    }

    public /* synthetic */ void lambda$setPlayer$1$AnalyticsCollector(Player player, AnalyticsListener analyticsListener, ExoFlags exoFlags) {
        analyticsListener.onEvents(player, new AnalyticsListener.Events(exoFlags, this.eventTimes));
    }

    public void release() {
        final AnalyticsListener.EventTime generateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        this.eventTimes.put(AnalyticsListener.EVENT_PLAYER_RELEASED, generateCurrentPlayerMediaPeriodEventTime);
        this.listeners.lazyRelease(AnalyticsListener.EVENT_PLAYER_RELEASED, new ListenerSet.Event() { // from class: com.google.android.exoplayer2.analytics.-$$Lambda$AnalyticsCollector$O3MKeYFfsUjfWNPuO4cWltocMtg
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).onPlayerReleased(AnalyticsListener.EventTime.this);
            }
        });
    }

    public final void updateMediaPeriodQueueInfo(List<MediaSource.MediaPeriodId> list, MediaSource.MediaPeriodId mediaPeriodId) {
        this.mediaPeriodQueueTracker.onQueueUpdated(list, mediaPeriodId, (Player) Assertions.checkNotNull(this.player));
    }

    public final void notifySeekStarted() {
        if (this.isSeeking) {
            return;
        }
        final AnalyticsListener.EventTime generateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        this.isSeeking = true;
        sendEvent(generateCurrentPlayerMediaPeriodEventTime, -1, new ListenerSet.Event() { // from class: com.google.android.exoplayer2.analytics.-$$Lambda$AnalyticsCollector$nh58LK0EEawk99IMUjpiJsXtodM
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).onSeekStarted(AnalyticsListener.EventTime.this);
            }
        });
    }

    @Override // com.google.android.exoplayer2.Player.Listener, com.google.android.exoplayer2.metadata.MetadataOutput
    public final void onMetadata(final Metadata metadata) {
        final AnalyticsListener.EventTime generateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(generateCurrentPlayerMediaPeriodEventTime, 1007, new ListenerSet.Event() { // from class: com.google.android.exoplayer2.analytics.-$$Lambda$AnalyticsCollector$6HA_2xMM0uTPLNNSHWF2rG4O67s
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).onMetadata(AnalyticsListener.EventTime.this, metadata);
            }
        });
    }

    @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
    public final void onAudioEnabled(final DecoderCounters decoderCounters) {
        final AnalyticsListener.EventTime generateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        sendEvent(generateReadingMediaPeriodEventTime, 1008, new ListenerSet.Event() { // from class: com.google.android.exoplayer2.analytics.-$$Lambda$AnalyticsCollector$ESOikSv-4l28pZFpZjQsh38AwRo
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                AnalyticsCollector.lambda$onAudioEnabled$5(AnalyticsListener.EventTime.this, decoderCounters, (AnalyticsListener) obj);
            }
        });
    }

    static /* synthetic */ void lambda$onAudioEnabled$5(AnalyticsListener.EventTime eventTime, DecoderCounters decoderCounters, AnalyticsListener analyticsListener) {
        analyticsListener.onAudioEnabled(eventTime, decoderCounters);
        analyticsListener.onDecoderEnabled(eventTime, 1, decoderCounters);
    }

    @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
    public final void onAudioDecoderInitialized(final String str, final long j, final long j2) {
        final AnalyticsListener.EventTime generateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        sendEvent(generateReadingMediaPeriodEventTime, 1009, new ListenerSet.Event() { // from class: com.google.android.exoplayer2.analytics.-$$Lambda$AnalyticsCollector$bAwJlPXiH1-UKDpW-uH4l8TF2ew
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                AnalyticsCollector.lambda$onAudioDecoderInitialized$6(AnalyticsListener.EventTime.this, str, j2, j, (AnalyticsListener) obj);
            }
        });
    }

    static /* synthetic */ void lambda$onAudioDecoderInitialized$6(AnalyticsListener.EventTime eventTime, String str, long j, long j2, AnalyticsListener analyticsListener) {
        analyticsListener.onAudioDecoderInitialized(eventTime, str, j);
        analyticsListener.onAudioDecoderInitialized(eventTime, str, j2, j);
        analyticsListener.onDecoderInitialized(eventTime, 1, str, j);
    }

    @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
    public final void onAudioInputFormatChanged(final Format format, final DecoderReuseEvaluation decoderReuseEvaluation) {
        final AnalyticsListener.EventTime generateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        sendEvent(generateReadingMediaPeriodEventTime, 1010, new ListenerSet.Event() { // from class: com.google.android.exoplayer2.analytics.-$$Lambda$AnalyticsCollector$aRZtv1yuNCkkzxKdXdNx8ju2Zq4
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                AnalyticsCollector.lambda$onAudioInputFormatChanged$7(AnalyticsListener.EventTime.this, format, decoderReuseEvaluation, (AnalyticsListener) obj);
            }
        });
    }

    static /* synthetic */ void lambda$onAudioInputFormatChanged$7(AnalyticsListener.EventTime eventTime, Format format, DecoderReuseEvaluation decoderReuseEvaluation, AnalyticsListener analyticsListener) {
        analyticsListener.onAudioInputFormatChanged(eventTime, format);
        analyticsListener.onAudioInputFormatChanged(eventTime, format, decoderReuseEvaluation);
        analyticsListener.onDecoderInputFormatChanged(eventTime, 1, format);
    }

    @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
    public final void onAudioPositionAdvancing(final long j) {
        final AnalyticsListener.EventTime generateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        sendEvent(generateReadingMediaPeriodEventTime, 1011, new ListenerSet.Event() { // from class: com.google.android.exoplayer2.analytics.-$$Lambda$AnalyticsCollector$t1Cci-uo7NAc29bUCrDvCvk5gTE
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).onAudioPositionAdvancing(AnalyticsListener.EventTime.this, j);
            }
        });
    }

    @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
    public final void onAudioUnderrun(final int i, final long j, final long j2) {
        final AnalyticsListener.EventTime generateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        sendEvent(generateReadingMediaPeriodEventTime, 1012, new ListenerSet.Event() { // from class: com.google.android.exoplayer2.analytics.-$$Lambda$AnalyticsCollector$uRtkIyv-LxPnbYGAn26p4R5w35Q
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).onAudioUnderrun(AnalyticsListener.EventTime.this, i, j, j2);
            }
        });
    }

    @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
    public final void onAudioDecoderReleased(final String str) {
        final AnalyticsListener.EventTime generateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        sendEvent(generateReadingMediaPeriodEventTime, 1013, new ListenerSet.Event() { // from class: com.google.android.exoplayer2.analytics.-$$Lambda$AnalyticsCollector$6_k6tQWOlSDPe1x_NgfxKd0Jbu4
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).onAudioDecoderReleased(AnalyticsListener.EventTime.this, str);
            }
        });
    }

    @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
    public final void onAudioDisabled(final DecoderCounters decoderCounters) {
        final AnalyticsListener.EventTime generatePlayingMediaPeriodEventTime = generatePlayingMediaPeriodEventTime();
        sendEvent(generatePlayingMediaPeriodEventTime, 1014, new ListenerSet.Event() { // from class: com.google.android.exoplayer2.analytics.-$$Lambda$AnalyticsCollector$HPj9qTuiG2Yxk6iOF8cldXIHAw0
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                AnalyticsCollector.lambda$onAudioDisabled$11(AnalyticsListener.EventTime.this, decoderCounters, (AnalyticsListener) obj);
            }
        });
    }

    static /* synthetic */ void lambda$onAudioDisabled$11(AnalyticsListener.EventTime eventTime, DecoderCounters decoderCounters, AnalyticsListener analyticsListener) {
        analyticsListener.onAudioDisabled(eventTime, decoderCounters);
        analyticsListener.onDecoderDisabled(eventTime, 1, decoderCounters);
    }

    @Override // com.google.android.exoplayer2.Player.Listener, com.google.android.exoplayer2.audio.AudioListener
    public final void onSkipSilenceEnabledChanged(final boolean z) {
        final AnalyticsListener.EventTime generateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        sendEvent(generateReadingMediaPeriodEventTime, 1017, new ListenerSet.Event() { // from class: com.google.android.exoplayer2.analytics.-$$Lambda$AnalyticsCollector$YuwsoCokrccRk2n8wFb_M5MaBhM
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).onSkipSilenceEnabledChanged(AnalyticsListener.EventTime.this, z);
            }
        });
    }

    @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
    public final void onAudioSinkError(final Exception exc) {
        final AnalyticsListener.EventTime generateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        sendEvent(generateReadingMediaPeriodEventTime, 1018, new ListenerSet.Event() { // from class: com.google.android.exoplayer2.analytics.-$$Lambda$AnalyticsCollector$790wimxgFXramU8o9ajyc9NO3A8
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).onAudioSinkError(AnalyticsListener.EventTime.this, exc);
            }
        });
    }

    @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
    public final void onAudioCodecError(final Exception exc) {
        final AnalyticsListener.EventTime generateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        sendEvent(generateReadingMediaPeriodEventTime, AnalyticsListener.EVENT_AUDIO_CODEC_ERROR, new ListenerSet.Event() { // from class: com.google.android.exoplayer2.analytics.-$$Lambda$AnalyticsCollector$uJzFgBZw0DngfaqYsknmu4mvxsA
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).onAudioCodecError(AnalyticsListener.EventTime.this, exc);
            }
        });
    }

    @Override // com.google.android.exoplayer2.Player.Listener, com.google.android.exoplayer2.audio.AudioListener
    public final void onAudioSessionIdChanged(final int i) {
        final AnalyticsListener.EventTime generateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        sendEvent(generateReadingMediaPeriodEventTime, 1015, new ListenerSet.Event() { // from class: com.google.android.exoplayer2.analytics.-$$Lambda$AnalyticsCollector$YHGB7taAxlAnYa6KunBxM9YiQnw
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).onAudioSessionIdChanged(AnalyticsListener.EventTime.this, i);
            }
        });
    }

    @Override // com.google.android.exoplayer2.Player.Listener, com.google.android.exoplayer2.audio.AudioListener
    public final void onAudioAttributesChanged(final AudioAttributes audioAttributes) {
        final AnalyticsListener.EventTime generateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        sendEvent(generateReadingMediaPeriodEventTime, 1016, new ListenerSet.Event() { // from class: com.google.android.exoplayer2.analytics.-$$Lambda$AnalyticsCollector$ylYJnipi9FWsMB71CFRB6FVp_lc
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).onAudioAttributesChanged(AnalyticsListener.EventTime.this, audioAttributes);
            }
        });
    }

    @Override // com.google.android.exoplayer2.Player.Listener, com.google.android.exoplayer2.audio.AudioListener
    public final void onVolumeChanged(final float f) {
        final AnalyticsListener.EventTime generateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        sendEvent(generateReadingMediaPeriodEventTime, 1019, new ListenerSet.Event() { // from class: com.google.android.exoplayer2.analytics.-$$Lambda$AnalyticsCollector$vywCeA0KvOveoxHJINlsz7F-adM
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).onVolumeChanged(AnalyticsListener.EventTime.this, f);
            }
        });
    }

    @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
    public final void onVideoEnabled(final DecoderCounters decoderCounters) {
        final AnalyticsListener.EventTime generateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        sendEvent(generateReadingMediaPeriodEventTime, 1020, new ListenerSet.Event() { // from class: com.google.android.exoplayer2.analytics.-$$Lambda$AnalyticsCollector$ALRHvtDz3QFXjLNQQwIlzIR_wDo
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                AnalyticsCollector.lambda$onVideoEnabled$18(AnalyticsListener.EventTime.this, decoderCounters, (AnalyticsListener) obj);
            }
        });
    }

    static /* synthetic */ void lambda$onVideoEnabled$18(AnalyticsListener.EventTime eventTime, DecoderCounters decoderCounters, AnalyticsListener analyticsListener) {
        analyticsListener.onVideoEnabled(eventTime, decoderCounters);
        analyticsListener.onDecoderEnabled(eventTime, 2, decoderCounters);
    }

    @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
    public final void onVideoDecoderInitialized(final String str, final long j, final long j2) {
        final AnalyticsListener.EventTime generateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        sendEvent(generateReadingMediaPeriodEventTime, 1021, new ListenerSet.Event() { // from class: com.google.android.exoplayer2.analytics.-$$Lambda$AnalyticsCollector$2gVR_3RTMhcTr22LQDgkxN0X8nI
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                AnalyticsCollector.lambda$onVideoDecoderInitialized$19(AnalyticsListener.EventTime.this, str, j2, j, (AnalyticsListener) obj);
            }
        });
    }

    static /* synthetic */ void lambda$onVideoDecoderInitialized$19(AnalyticsListener.EventTime eventTime, String str, long j, long j2, AnalyticsListener analyticsListener) {
        analyticsListener.onVideoDecoderInitialized(eventTime, str, j);
        analyticsListener.onVideoDecoderInitialized(eventTime, str, j2, j);
        analyticsListener.onDecoderInitialized(eventTime, 2, str, j);
    }

    @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
    public final void onVideoInputFormatChanged(final Format format, final DecoderReuseEvaluation decoderReuseEvaluation) {
        final AnalyticsListener.EventTime generateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        sendEvent(generateReadingMediaPeriodEventTime, AnalyticsListener.EVENT_VIDEO_INPUT_FORMAT_CHANGED, new ListenerSet.Event() { // from class: com.google.android.exoplayer2.analytics.-$$Lambda$AnalyticsCollector$nTYP9LlxpUtAQQDQ7HpqDx5kXHw
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                AnalyticsCollector.lambda$onVideoInputFormatChanged$20(AnalyticsListener.EventTime.this, format, decoderReuseEvaluation, (AnalyticsListener) obj);
            }
        });
    }

    static /* synthetic */ void lambda$onVideoInputFormatChanged$20(AnalyticsListener.EventTime eventTime, Format format, DecoderReuseEvaluation decoderReuseEvaluation, AnalyticsListener analyticsListener) {
        analyticsListener.onVideoInputFormatChanged(eventTime, format);
        analyticsListener.onVideoInputFormatChanged(eventTime, format, decoderReuseEvaluation);
        analyticsListener.onDecoderInputFormatChanged(eventTime, 2, format);
    }

    @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
    public final void onDroppedFrames(final int i, final long j) {
        final AnalyticsListener.EventTime generatePlayingMediaPeriodEventTime = generatePlayingMediaPeriodEventTime();
        sendEvent(generatePlayingMediaPeriodEventTime, 1023, new ListenerSet.Event() { // from class: com.google.android.exoplayer2.analytics.-$$Lambda$AnalyticsCollector$QutCPTURIqp4ygAfRhKE9LgNfiY
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).onDroppedVideoFrames(AnalyticsListener.EventTime.this, i, j);
            }
        });
    }

    @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
    public final void onVideoDecoderReleased(final String str) {
        final AnalyticsListener.EventTime generateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        sendEvent(generateReadingMediaPeriodEventTime, 1024, new ListenerSet.Event() { // from class: com.google.android.exoplayer2.analytics.-$$Lambda$AnalyticsCollector$imOYoHpGSi4UkahY8rP7bGhE5Oo
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).onVideoDecoderReleased(AnalyticsListener.EventTime.this, str);
            }
        });
    }

    @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
    public final void onVideoDisabled(final DecoderCounters decoderCounters) {
        final AnalyticsListener.EventTime generatePlayingMediaPeriodEventTime = generatePlayingMediaPeriodEventTime();
        sendEvent(generatePlayingMediaPeriodEventTime, 1025, new ListenerSet.Event() { // from class: com.google.android.exoplayer2.analytics.-$$Lambda$AnalyticsCollector$jX3FMAOgFPVoy5djIND7VGzWJJI
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                AnalyticsCollector.lambda$onVideoDisabled$23(AnalyticsListener.EventTime.this, decoderCounters, (AnalyticsListener) obj);
            }
        });
    }

    static /* synthetic */ void lambda$onVideoDisabled$23(AnalyticsListener.EventTime eventTime, DecoderCounters decoderCounters, AnalyticsListener analyticsListener) {
        analyticsListener.onVideoDisabled(eventTime, decoderCounters);
        analyticsListener.onDecoderDisabled(eventTime, 2, decoderCounters);
    }

    @Override // com.google.android.exoplayer2.Player.Listener, com.google.android.exoplayer2.video.VideoListener
    public final void onVideoSizeChanged(final VideoSize videoSize) {
        final AnalyticsListener.EventTime generateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        sendEvent(generateReadingMediaPeriodEventTime, AnalyticsListener.EVENT_VIDEO_SIZE_CHANGED, new ListenerSet.Event() { // from class: com.google.android.exoplayer2.analytics.-$$Lambda$AnalyticsCollector$zY2BbEL_ogba6u5r7BMp6NSFTzA
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                AnalyticsCollector.lambda$onVideoSizeChanged$24(AnalyticsListener.EventTime.this, videoSize, (AnalyticsListener) obj);
            }
        });
    }

    static /* synthetic */ void lambda$onVideoSizeChanged$24(AnalyticsListener.EventTime eventTime, VideoSize videoSize, AnalyticsListener analyticsListener) {
        analyticsListener.onVideoSizeChanged(eventTime, videoSize);
        analyticsListener.onVideoSizeChanged(eventTime, videoSize.width, videoSize.height, videoSize.unappliedRotationDegrees, videoSize.pixelWidthHeightRatio);
    }

    @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
    public final void onRenderedFirstFrame(final Object obj, final long j) {
        final AnalyticsListener.EventTime generateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        sendEvent(generateReadingMediaPeriodEventTime, AnalyticsListener.EVENT_RENDERED_FIRST_FRAME, new ListenerSet.Event() { // from class: com.google.android.exoplayer2.analytics.-$$Lambda$AnalyticsCollector$e3vH_RbBN_uMJV4qBGUxb0Mpps8
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj2) {
                ((AnalyticsListener) obj2).onRenderedFirstFrame(AnalyticsListener.EventTime.this, obj, j);
            }
        });
    }

    @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
    public final void onVideoFrameProcessingOffset(final long j, final int i) {
        final AnalyticsListener.EventTime generatePlayingMediaPeriodEventTime = generatePlayingMediaPeriodEventTime();
        sendEvent(generatePlayingMediaPeriodEventTime, AnalyticsListener.EVENT_VIDEO_FRAME_PROCESSING_OFFSET, new ListenerSet.Event() { // from class: com.google.android.exoplayer2.analytics.-$$Lambda$AnalyticsCollector$tXEVrk9gyimgdijo60B7JgmBCPQ
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).onVideoFrameProcessingOffset(AnalyticsListener.EventTime.this, j, i);
            }
        });
    }

    @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
    public final void onVideoCodecError(final Exception exc) {
        final AnalyticsListener.EventTime generateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        sendEvent(generateReadingMediaPeriodEventTime, AnalyticsListener.EVENT_VIDEO_CODEC_ERROR, new ListenerSet.Event() { // from class: com.google.android.exoplayer2.analytics.-$$Lambda$AnalyticsCollector$5xDvdAe0w1a5iUCwt_ZszidaPfk
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).onVideoCodecError(AnalyticsListener.EventTime.this, exc);
            }
        });
    }

    @Override // com.google.android.exoplayer2.Player.Listener, com.google.android.exoplayer2.video.VideoListener
    public void onSurfaceSizeChanged(final int i, final int i2) {
        final AnalyticsListener.EventTime generateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        sendEvent(generateReadingMediaPeriodEventTime, AnalyticsListener.EVENT_SURFACE_SIZE_CHANGED, new ListenerSet.Event() { // from class: com.google.android.exoplayer2.analytics.-$$Lambda$AnalyticsCollector$89xwc-5crrjwBNPksICHi-4rX2U
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).onSurfaceSizeChanged(AnalyticsListener.EventTime.this, i, i2);
            }
        });
    }

    @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
    public final void onLoadStarted(int i, MediaSource.MediaPeriodId mediaPeriodId, final LoadEventInfo loadEventInfo, final MediaLoadData mediaLoadData) {
        final AnalyticsListener.EventTime generateMediaPeriodEventTime = generateMediaPeriodEventTime(i, mediaPeriodId);
        sendEvent(generateMediaPeriodEventTime, 1000, new ListenerSet.Event() { // from class: com.google.android.exoplayer2.analytics.-$$Lambda$AnalyticsCollector$J_V3OaEGnKnO1aGmM8lXU-DZIiw
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).onLoadStarted(AnalyticsListener.EventTime.this, loadEventInfo, mediaLoadData);
            }
        });
    }

    @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
    public final void onLoadCompleted(int i, MediaSource.MediaPeriodId mediaPeriodId, final LoadEventInfo loadEventInfo, final MediaLoadData mediaLoadData) {
        final AnalyticsListener.EventTime generateMediaPeriodEventTime = generateMediaPeriodEventTime(i, mediaPeriodId);
        sendEvent(generateMediaPeriodEventTime, 1001, new ListenerSet.Event() { // from class: com.google.android.exoplayer2.analytics.-$$Lambda$AnalyticsCollector$EDn-m7ac5r3EM_N1_3A7cbB6h3o
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).onLoadCompleted(AnalyticsListener.EventTime.this, loadEventInfo, mediaLoadData);
            }
        });
    }

    @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
    public final void onLoadCanceled(int i, MediaSource.MediaPeriodId mediaPeriodId, final LoadEventInfo loadEventInfo, final MediaLoadData mediaLoadData) {
        final AnalyticsListener.EventTime generateMediaPeriodEventTime = generateMediaPeriodEventTime(i, mediaPeriodId);
        sendEvent(generateMediaPeriodEventTime, 1002, new ListenerSet.Event() { // from class: com.google.android.exoplayer2.analytics.-$$Lambda$AnalyticsCollector$kLq_aL7cVJ1u_hBnRFj_fC11GI4
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).onLoadCanceled(AnalyticsListener.EventTime.this, loadEventInfo, mediaLoadData);
            }
        });
    }

    @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
    public final void onLoadError(int i, MediaSource.MediaPeriodId mediaPeriodId, final LoadEventInfo loadEventInfo, final MediaLoadData mediaLoadData, final IOException iOException, final boolean z) {
        final AnalyticsListener.EventTime generateMediaPeriodEventTime = generateMediaPeriodEventTime(i, mediaPeriodId);
        sendEvent(generateMediaPeriodEventTime, 1003, new ListenerSet.Event() { // from class: com.google.android.exoplayer2.analytics.-$$Lambda$AnalyticsCollector$BTHbunRO7EU4X7N19iLm_2uFeR0
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).onLoadError(AnalyticsListener.EventTime.this, loadEventInfo, mediaLoadData, iOException, z);
            }
        });
    }

    @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
    public final void onUpstreamDiscarded(int i, MediaSource.MediaPeriodId mediaPeriodId, final MediaLoadData mediaLoadData) {
        final AnalyticsListener.EventTime generateMediaPeriodEventTime = generateMediaPeriodEventTime(i, mediaPeriodId);
        sendEvent(generateMediaPeriodEventTime, 1005, new ListenerSet.Event() { // from class: com.google.android.exoplayer2.analytics.-$$Lambda$AnalyticsCollector$qzRzHbtWr9EFWMFaA8dmap9aAAk
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).onUpstreamDiscarded(AnalyticsListener.EventTime.this, mediaLoadData);
            }
        });
    }

    @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
    public final void onDownstreamFormatChanged(int i, MediaSource.MediaPeriodId mediaPeriodId, final MediaLoadData mediaLoadData) {
        final AnalyticsListener.EventTime generateMediaPeriodEventTime = generateMediaPeriodEventTime(i, mediaPeriodId);
        sendEvent(generateMediaPeriodEventTime, 1004, new ListenerSet.Event() { // from class: com.google.android.exoplayer2.analytics.-$$Lambda$AnalyticsCollector$vtdDB3-Nr-rrk4AM6RePHGY3ISs
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).onDownstreamFormatChanged(AnalyticsListener.EventTime.this, mediaLoadData);
            }
        });
    }

    @Override // com.google.android.exoplayer2.Player.Listener, com.google.android.exoplayer2.Player.EventListener
    public final void onTimelineChanged(Timeline timeline, final int i) {
        this.mediaPeriodQueueTracker.onTimelineChanged((Player) Assertions.checkNotNull(this.player));
        final AnalyticsListener.EventTime generateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(generateCurrentPlayerMediaPeriodEventTime, 0, new ListenerSet.Event() { // from class: com.google.android.exoplayer2.analytics.-$$Lambda$AnalyticsCollector$omGKHxfBLK5sEUkTijKO9rXy4AM
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).onTimelineChanged(AnalyticsListener.EventTime.this, i);
            }
        });
    }

    @Override // com.google.android.exoplayer2.Player.Listener, com.google.android.exoplayer2.Player.EventListener
    public final void onMediaItemTransition(final MediaItem mediaItem, final int i) {
        final AnalyticsListener.EventTime generateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(generateCurrentPlayerMediaPeriodEventTime, 1, new ListenerSet.Event() { // from class: com.google.android.exoplayer2.analytics.-$$Lambda$AnalyticsCollector$q0xRgAyqV7QTV1zvDQgoycudAlA
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).onMediaItemTransition(AnalyticsListener.EventTime.this, mediaItem, i);
            }
        });
    }

    @Override // com.google.android.exoplayer2.Player.Listener, com.google.android.exoplayer2.Player.EventListener
    public final void onTracksChanged(final TrackGroupArray trackGroupArray, final TrackSelectionArray trackSelectionArray) {
        final AnalyticsListener.EventTime generateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(generateCurrentPlayerMediaPeriodEventTime, 2, new ListenerSet.Event() { // from class: com.google.android.exoplayer2.analytics.-$$Lambda$AnalyticsCollector$aTVYLfilZOP2VdswqUqkqxZmwO8
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).onTracksChanged(AnalyticsListener.EventTime.this, trackGroupArray, trackSelectionArray);
            }
        });
    }

    @Override // com.google.android.exoplayer2.Player.Listener, com.google.android.exoplayer2.Player.EventListener
    public final void onStaticMetadataChanged(final List<Metadata> list) {
        final AnalyticsListener.EventTime generateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(generateCurrentPlayerMediaPeriodEventTime, 3, new ListenerSet.Event() { // from class: com.google.android.exoplayer2.analytics.-$$Lambda$AnalyticsCollector$LGPiAhAqJ5Elw37zL9zAiw3vdnI
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).onStaticMetadataChanged(AnalyticsListener.EventTime.this, list);
            }
        });
    }

    @Override // com.google.android.exoplayer2.Player.Listener, com.google.android.exoplayer2.Player.EventListener
    public final void onIsLoadingChanged(final boolean z) {
        final AnalyticsListener.EventTime generateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(generateCurrentPlayerMediaPeriodEventTime, 4, new ListenerSet.Event() { // from class: com.google.android.exoplayer2.analytics.-$$Lambda$AnalyticsCollector$A____YZhNPiehwYsIWEJAvAiwoA
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                AnalyticsCollector.lambda$onIsLoadingChanged$39(AnalyticsListener.EventTime.this, z, (AnalyticsListener) obj);
            }
        });
    }

    static /* synthetic */ void lambda$onIsLoadingChanged$39(AnalyticsListener.EventTime eventTime, boolean z, AnalyticsListener analyticsListener) {
        analyticsListener.onLoadingChanged(eventTime, z);
        analyticsListener.onIsLoadingChanged(eventTime, z);
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public final void onPlayerStateChanged(final boolean z, final int i) {
        final AnalyticsListener.EventTime generateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(generateCurrentPlayerMediaPeriodEventTime, -1, new ListenerSet.Event() { // from class: com.google.android.exoplayer2.analytics.-$$Lambda$AnalyticsCollector$6U-WSxLsv-bjrjxBDK0faVRmTVk
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).onPlayerStateChanged(AnalyticsListener.EventTime.this, z, i);
            }
        });
    }

    @Override // com.google.android.exoplayer2.Player.Listener, com.google.android.exoplayer2.Player.EventListener
    public final void onPlaybackStateChanged(final int i) {
        final AnalyticsListener.EventTime generateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(generateCurrentPlayerMediaPeriodEventTime, 5, new ListenerSet.Event() { // from class: com.google.android.exoplayer2.analytics.-$$Lambda$AnalyticsCollector$MawSgcc9Lec8ZRbCWhF0vXRp2vg
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).onPlaybackStateChanged(AnalyticsListener.EventTime.this, i);
            }
        });
    }

    @Override // com.google.android.exoplayer2.Player.Listener, com.google.android.exoplayer2.Player.EventListener
    public final void onPlayWhenReadyChanged(final boolean z, final int i) {
        final AnalyticsListener.EventTime generateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(generateCurrentPlayerMediaPeriodEventTime, 6, new ListenerSet.Event() { // from class: com.google.android.exoplayer2.analytics.-$$Lambda$AnalyticsCollector$-spiTSXk6CavYoJcqiBsZi_4AAE
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).onPlayWhenReadyChanged(AnalyticsListener.EventTime.this, z, i);
            }
        });
    }

    @Override // com.google.android.exoplayer2.Player.Listener, com.google.android.exoplayer2.Player.EventListener
    public final void onPlaybackSuppressionReasonChanged(final int i) {
        final AnalyticsListener.EventTime generateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(generateCurrentPlayerMediaPeriodEventTime, 7, new ListenerSet.Event() { // from class: com.google.android.exoplayer2.analytics.-$$Lambda$AnalyticsCollector$H9i9V8ccVvj9btzfIKCfPxoA_00
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).onPlaybackSuppressionReasonChanged(AnalyticsListener.EventTime.this, i);
            }
        });
    }

    @Override // com.google.android.exoplayer2.Player.Listener, com.google.android.exoplayer2.Player.EventListener
    public void onIsPlayingChanged(final boolean z) {
        final AnalyticsListener.EventTime generateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(generateCurrentPlayerMediaPeriodEventTime, 8, new ListenerSet.Event() { // from class: com.google.android.exoplayer2.analytics.-$$Lambda$AnalyticsCollector$Vvt6R9hokjHQjE1wvnOn_6mNh3A
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).onIsPlayingChanged(AnalyticsListener.EventTime.this, z);
            }
        });
    }

    @Override // com.google.android.exoplayer2.Player.Listener, com.google.android.exoplayer2.Player.EventListener
    public final void onRepeatModeChanged(final int i) {
        final AnalyticsListener.EventTime generateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(generateCurrentPlayerMediaPeriodEventTime, 9, new ListenerSet.Event() { // from class: com.google.android.exoplayer2.analytics.-$$Lambda$AnalyticsCollector$xYBBC_jgX8k_hvGSUL4pw50bgK8
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).onRepeatModeChanged(AnalyticsListener.EventTime.this, i);
            }
        });
    }

    @Override // com.google.android.exoplayer2.Player.Listener, com.google.android.exoplayer2.Player.EventListener
    public final void onShuffleModeEnabledChanged(final boolean z) {
        final AnalyticsListener.EventTime generateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(generateCurrentPlayerMediaPeriodEventTime, 10, new ListenerSet.Event() { // from class: com.google.android.exoplayer2.analytics.-$$Lambda$AnalyticsCollector$vu5Wg3sk7TNX3Su0oOBIgq_R1r0
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).onShuffleModeChanged(AnalyticsListener.EventTime.this, z);
            }
        });
    }

    @Override // com.google.android.exoplayer2.Player.Listener, com.google.android.exoplayer2.Player.EventListener
    public final void onPlayerError(final ExoPlaybackException exoPlaybackException) {
        final AnalyticsListener.EventTime generateCurrentPlayerMediaPeriodEventTime;
        if (exoPlaybackException.mediaPeriodId != null) {
            generateCurrentPlayerMediaPeriodEventTime = generateEventTime(new MediaSource.MediaPeriodId(exoPlaybackException.mediaPeriodId));
        } else {
            generateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        }
        sendEvent(generateCurrentPlayerMediaPeriodEventTime, 11, new ListenerSet.Event() { // from class: com.google.android.exoplayer2.analytics.-$$Lambda$AnalyticsCollector$3b00CPBhzTSDrG1qhQlqDHxjgaQ
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).onPlayerError(AnalyticsListener.EventTime.this, exoPlaybackException);
            }
        });
    }

    @Override // com.google.android.exoplayer2.Player.Listener, com.google.android.exoplayer2.Player.EventListener
    public final void onPositionDiscontinuity(final Player.PositionInfo positionInfo, final Player.PositionInfo positionInfo2, final int i) {
        if (i == 1) {
            this.isSeeking = false;
        }
        this.mediaPeriodQueueTracker.onPositionDiscontinuity((Player) Assertions.checkNotNull(this.player));
        final AnalyticsListener.EventTime generateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(generateCurrentPlayerMediaPeriodEventTime, 12, new ListenerSet.Event() { // from class: com.google.android.exoplayer2.analytics.-$$Lambda$AnalyticsCollector$_oDn6GyfnW_6YrYWLXWzf3moqGc
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                AnalyticsCollector.lambda$onPositionDiscontinuity$48(AnalyticsListener.EventTime.this, i, positionInfo, positionInfo2, (AnalyticsListener) obj);
            }
        });
    }

    static /* synthetic */ void lambda$onPositionDiscontinuity$48(AnalyticsListener.EventTime eventTime, int i, Player.PositionInfo positionInfo, Player.PositionInfo positionInfo2, AnalyticsListener analyticsListener) {
        analyticsListener.onPositionDiscontinuity(eventTime, i);
        analyticsListener.onPositionDiscontinuity(eventTime, positionInfo, positionInfo2, i);
    }

    @Override // com.google.android.exoplayer2.Player.Listener, com.google.android.exoplayer2.Player.EventListener
    public final void onPlaybackParametersChanged(final PlaybackParameters playbackParameters) {
        final AnalyticsListener.EventTime generateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(generateCurrentPlayerMediaPeriodEventTime, 13, new ListenerSet.Event() { // from class: com.google.android.exoplayer2.analytics.-$$Lambda$AnalyticsCollector$0Hh1SuXH47FW49od8YzQn20BKPg
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).onPlaybackParametersChanged(AnalyticsListener.EventTime.this, playbackParameters);
            }
        });
    }

    @Override // com.google.android.exoplayer2.Player.Listener, com.google.android.exoplayer2.Player.EventListener
    public void onMediaMetadataChanged(final MediaMetadata mediaMetadata) {
        final AnalyticsListener.EventTime generateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(generateCurrentPlayerMediaPeriodEventTime, 15, new ListenerSet.Event() { // from class: com.google.android.exoplayer2.analytics.-$$Lambda$AnalyticsCollector$JKIt_Jq2_b34DQ7Ssa39Y6q42tg
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).onMediaMetadataChanged(AnalyticsListener.EventTime.this, mediaMetadata);
            }
        });
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public final void onSeekProcessed() {
        final AnalyticsListener.EventTime generateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(generateCurrentPlayerMediaPeriodEventTime, -1, new ListenerSet.Event() { // from class: com.google.android.exoplayer2.analytics.-$$Lambda$AnalyticsCollector$JhcmYUvoO6T3Fb-Iv4Adv0nJEug
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).onSeekProcessed(AnalyticsListener.EventTime.this);
            }
        });
    }

    @Override // com.google.android.exoplayer2.upstream.BandwidthMeter.EventListener
    public final void onBandwidthSample(final int i, final long j, final long j2) {
        final AnalyticsListener.EventTime generateLoadingMediaPeriodEventTime = generateLoadingMediaPeriodEventTime();
        sendEvent(generateLoadingMediaPeriodEventTime, 1006, new ListenerSet.Event() { // from class: com.google.android.exoplayer2.analytics.-$$Lambda$AnalyticsCollector$UkTUBuVnrjoA_DtDST3KsQOKJR0
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).onBandwidthEstimate(AnalyticsListener.EventTime.this, i, j, j2);
            }
        });
    }

    @Override // com.google.android.exoplayer2.drm.DrmSessionEventListener
    public final void onDrmSessionAcquired(int i, MediaSource.MediaPeriodId mediaPeriodId, final int i2) {
        final AnalyticsListener.EventTime generateMediaPeriodEventTime = generateMediaPeriodEventTime(i, mediaPeriodId);
        sendEvent(generateMediaPeriodEventTime, AnalyticsListener.EVENT_DRM_SESSION_ACQUIRED, new ListenerSet.Event() { // from class: com.google.android.exoplayer2.analytics.-$$Lambda$AnalyticsCollector$PRae0lW_PdCvi6Fcrr35ze2g1lo
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                AnalyticsCollector.lambda$onDrmSessionAcquired$53(AnalyticsListener.EventTime.this, i2, (AnalyticsListener) obj);
            }
        });
    }

    static /* synthetic */ void lambda$onDrmSessionAcquired$53(AnalyticsListener.EventTime eventTime, int i, AnalyticsListener analyticsListener) {
        analyticsListener.onDrmSessionAcquired(eventTime);
        analyticsListener.onDrmSessionAcquired(eventTime, i);
    }

    @Override // com.google.android.exoplayer2.drm.DrmSessionEventListener
    public final void onDrmKeysLoaded(int i, MediaSource.MediaPeriodId mediaPeriodId) {
        final AnalyticsListener.EventTime generateMediaPeriodEventTime = generateMediaPeriodEventTime(i, mediaPeriodId);
        sendEvent(generateMediaPeriodEventTime, AnalyticsListener.EVENT_DRM_KEYS_LOADED, new ListenerSet.Event() { // from class: com.google.android.exoplayer2.analytics.-$$Lambda$AnalyticsCollector$4NQvvKIuvU4iCFLYor53UcMjcqM
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).onDrmKeysLoaded(AnalyticsListener.EventTime.this);
            }
        });
    }

    @Override // com.google.android.exoplayer2.drm.DrmSessionEventListener
    public final void onDrmSessionManagerError(int i, MediaSource.MediaPeriodId mediaPeriodId, final Exception exc) {
        final AnalyticsListener.EventTime generateMediaPeriodEventTime = generateMediaPeriodEventTime(i, mediaPeriodId);
        sendEvent(generateMediaPeriodEventTime, AnalyticsListener.EVENT_DRM_SESSION_MANAGER_ERROR, new ListenerSet.Event() { // from class: com.google.android.exoplayer2.analytics.-$$Lambda$AnalyticsCollector$BJdPZqypcoLvsy8pZCJS2TflrAY
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).onDrmSessionManagerError(AnalyticsListener.EventTime.this, exc);
            }
        });
    }

    @Override // com.google.android.exoplayer2.drm.DrmSessionEventListener
    public final void onDrmKeysRestored(int i, MediaSource.MediaPeriodId mediaPeriodId) {
        final AnalyticsListener.EventTime generateMediaPeriodEventTime = generateMediaPeriodEventTime(i, mediaPeriodId);
        sendEvent(generateMediaPeriodEventTime, AnalyticsListener.EVENT_DRM_KEYS_RESTORED, new ListenerSet.Event() { // from class: com.google.android.exoplayer2.analytics.-$$Lambda$AnalyticsCollector$I6kwJghS1aVIcswgsz45nuKvKlU
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).onDrmKeysRestored(AnalyticsListener.EventTime.this);
            }
        });
    }

    @Override // com.google.android.exoplayer2.drm.DrmSessionEventListener
    public final void onDrmKeysRemoved(int i, MediaSource.MediaPeriodId mediaPeriodId) {
        final AnalyticsListener.EventTime generateMediaPeriodEventTime = generateMediaPeriodEventTime(i, mediaPeriodId);
        sendEvent(generateMediaPeriodEventTime, AnalyticsListener.EVENT_DRM_KEYS_REMOVED, new ListenerSet.Event() { // from class: com.google.android.exoplayer2.analytics.-$$Lambda$AnalyticsCollector$m3QgAf68omlJLaOFqA5ZgDdQU1M
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).onDrmKeysRemoved(AnalyticsListener.EventTime.this);
            }
        });
    }

    @Override // com.google.android.exoplayer2.drm.DrmSessionEventListener
    public final void onDrmSessionReleased(int i, MediaSource.MediaPeriodId mediaPeriodId) {
        final AnalyticsListener.EventTime generateMediaPeriodEventTime = generateMediaPeriodEventTime(i, mediaPeriodId);
        sendEvent(generateMediaPeriodEventTime, AnalyticsListener.EVENT_DRM_SESSION_RELEASED, new ListenerSet.Event() { // from class: com.google.android.exoplayer2.analytics.-$$Lambda$AnalyticsCollector$gGNi6rtH6GH0OGRl3unTM0dU7UM
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).onDrmSessionReleased(AnalyticsListener.EventTime.this);
            }
        });
    }

    protected final void sendEvent(AnalyticsListener.EventTime eventTime, int i, ListenerSet.Event<AnalyticsListener> event) {
        this.eventTimes.put(i, eventTime);
        this.listeners.sendEvent(i, event);
    }

    protected final AnalyticsListener.EventTime generateCurrentPlayerMediaPeriodEventTime() {
        return generateEventTime(this.mediaPeriodQueueTracker.getCurrentPlayerMediaPeriod());
    }

    @RequiresNonNull({"player"})
    protected final AnalyticsListener.EventTime generateEventTime(Timeline timeline, int i, MediaSource.MediaPeriodId mediaPeriodId) {
        long contentPosition;
        MediaSource.MediaPeriodId mediaPeriodId2 = timeline.isEmpty() ? null : mediaPeriodId;
        long elapsedRealtime = this.clock.elapsedRealtime();
        boolean z = timeline.equals(this.player.getCurrentTimeline()) && i == this.player.getCurrentWindowIndex();
        long j = 0;
        if (mediaPeriodId2 != null && mediaPeriodId2.isAd()) {
            if (z && this.player.getCurrentAdGroupIndex() == mediaPeriodId2.adGroupIndex && this.player.getCurrentAdIndexInAdGroup() == mediaPeriodId2.adIndexInAdGroup) {
                j = this.player.getCurrentPosition();
            }
        } else {
            if (z) {
                contentPosition = this.player.getContentPosition();
                return new AnalyticsListener.EventTime(elapsedRealtime, timeline, i, mediaPeriodId2, contentPosition, this.player.getCurrentTimeline(), this.player.getCurrentWindowIndex(), this.mediaPeriodQueueTracker.getCurrentPlayerMediaPeriod(), this.player.getCurrentPosition(), this.player.getTotalBufferedDuration());
            }
            if (!timeline.isEmpty()) {
                j = timeline.getWindow(i, this.window).getDefaultPositionMs();
            }
        }
        contentPosition = j;
        return new AnalyticsListener.EventTime(elapsedRealtime, timeline, i, mediaPeriodId2, contentPosition, this.player.getCurrentTimeline(), this.player.getCurrentWindowIndex(), this.mediaPeriodQueueTracker.getCurrentPlayerMediaPeriod(), this.player.getCurrentPosition(), this.player.getTotalBufferedDuration());
    }

    private AnalyticsListener.EventTime generateEventTime(MediaSource.MediaPeriodId mediaPeriodId) {
        Assertions.checkNotNull(this.player);
        Timeline mediaPeriodIdTimeline = mediaPeriodId == null ? null : this.mediaPeriodQueueTracker.getMediaPeriodIdTimeline(mediaPeriodId);
        if (mediaPeriodId == null || mediaPeriodIdTimeline == null) {
            int currentWindowIndex = this.player.getCurrentWindowIndex();
            Timeline currentTimeline = this.player.getCurrentTimeline();
            if (!(currentWindowIndex < currentTimeline.getWindowCount())) {
                currentTimeline = Timeline.EMPTY;
            }
            return generateEventTime(currentTimeline, currentWindowIndex, null);
        }
        return generateEventTime(mediaPeriodIdTimeline, mediaPeriodIdTimeline.getPeriodByUid(mediaPeriodId.periodUid, this.period).windowIndex, mediaPeriodId);
    }

    private AnalyticsListener.EventTime generatePlayingMediaPeriodEventTime() {
        return generateEventTime(this.mediaPeriodQueueTracker.getPlayingMediaPeriod());
    }

    private AnalyticsListener.EventTime generateReadingMediaPeriodEventTime() {
        return generateEventTime(this.mediaPeriodQueueTracker.getReadingMediaPeriod());
    }

    private AnalyticsListener.EventTime generateLoadingMediaPeriodEventTime() {
        return generateEventTime(this.mediaPeriodQueueTracker.getLoadingMediaPeriod());
    }

    private AnalyticsListener.EventTime generateMediaPeriodEventTime(int i, MediaSource.MediaPeriodId mediaPeriodId) {
        Assertions.checkNotNull(this.player);
        if (mediaPeriodId != null) {
            if (this.mediaPeriodQueueTracker.getMediaPeriodIdTimeline(mediaPeriodId) != null) {
                return generateEventTime(mediaPeriodId);
            }
            return generateEventTime(Timeline.EMPTY, i, mediaPeriodId);
        }
        Timeline currentTimeline = this.player.getCurrentTimeline();
        if (!(i < currentTimeline.getWindowCount())) {
            currentTimeline = Timeline.EMPTY;
        }
        return generateEventTime(currentTimeline, i, null);
    }

    private static final class MediaPeriodQueueTracker {
        private MediaSource.MediaPeriodId currentPlayerMediaPeriod;
        private ImmutableList<MediaSource.MediaPeriodId> mediaPeriodQueue = ImmutableList.of();
        private ImmutableMap<MediaSource.MediaPeriodId, Timeline> mediaPeriodTimelines = ImmutableMap.of();
        private final Timeline.Period period;
        private MediaSource.MediaPeriodId playingMediaPeriod;
        private MediaSource.MediaPeriodId readingMediaPeriod;

        public MediaPeriodQueueTracker(Timeline.Period period) {
            this.period = period;
        }

        public MediaSource.MediaPeriodId getCurrentPlayerMediaPeriod() {
            return this.currentPlayerMediaPeriod;
        }

        public MediaSource.MediaPeriodId getPlayingMediaPeriod() {
            return this.playingMediaPeriod;
        }

        public MediaSource.MediaPeriodId getReadingMediaPeriod() {
            return this.readingMediaPeriod;
        }

        public MediaSource.MediaPeriodId getLoadingMediaPeriod() {
            if (this.mediaPeriodQueue.isEmpty()) {
                return null;
            }
            return (MediaSource.MediaPeriodId) Iterables.getLast(this.mediaPeriodQueue);
        }

        public Timeline getMediaPeriodIdTimeline(MediaSource.MediaPeriodId mediaPeriodId) {
            return this.mediaPeriodTimelines.get(mediaPeriodId);
        }

        public void onPositionDiscontinuity(Player player) {
            this.currentPlayerMediaPeriod = findCurrentPlayerMediaPeriodInQueue(player, this.mediaPeriodQueue, this.playingMediaPeriod, this.period);
        }

        public void onTimelineChanged(Player player) {
            this.currentPlayerMediaPeriod = findCurrentPlayerMediaPeriodInQueue(player, this.mediaPeriodQueue, this.playingMediaPeriod, this.period);
            updateMediaPeriodTimelines(player.getCurrentTimeline());
        }

        public void onQueueUpdated(List<MediaSource.MediaPeriodId> list, MediaSource.MediaPeriodId mediaPeriodId, Player player) {
            this.mediaPeriodQueue = ImmutableList.copyOf((Collection) list);
            if (!list.isEmpty()) {
                this.playingMediaPeriod = list.get(0);
                this.readingMediaPeriod = (MediaSource.MediaPeriodId) Assertions.checkNotNull(mediaPeriodId);
            }
            if (this.currentPlayerMediaPeriod == null) {
                this.currentPlayerMediaPeriod = findCurrentPlayerMediaPeriodInQueue(player, this.mediaPeriodQueue, this.playingMediaPeriod, this.period);
            }
            updateMediaPeriodTimelines(player.getCurrentTimeline());
        }

        private void updateMediaPeriodTimelines(Timeline timeline) {
            ImmutableMap.Builder<MediaSource.MediaPeriodId, Timeline> builder = ImmutableMap.builder();
            if (this.mediaPeriodQueue.isEmpty()) {
                addTimelineForMediaPeriodId(builder, this.playingMediaPeriod, timeline);
                if (!Objects.equal(this.readingMediaPeriod, this.playingMediaPeriod)) {
                    addTimelineForMediaPeriodId(builder, this.readingMediaPeriod, timeline);
                }
                if (!Objects.equal(this.currentPlayerMediaPeriod, this.playingMediaPeriod) && !Objects.equal(this.currentPlayerMediaPeriod, this.readingMediaPeriod)) {
                    addTimelineForMediaPeriodId(builder, this.currentPlayerMediaPeriod, timeline);
                }
            } else {
                for (int i = 0; i < this.mediaPeriodQueue.size(); i++) {
                    addTimelineForMediaPeriodId(builder, this.mediaPeriodQueue.get(i), timeline);
                }
                if (!this.mediaPeriodQueue.contains(this.currentPlayerMediaPeriod)) {
                    addTimelineForMediaPeriodId(builder, this.currentPlayerMediaPeriod, timeline);
                }
            }
            this.mediaPeriodTimelines = builder.build();
        }

        private void addTimelineForMediaPeriodId(ImmutableMap.Builder<MediaSource.MediaPeriodId, Timeline> builder, MediaSource.MediaPeriodId mediaPeriodId, Timeline timeline) {
            if (mediaPeriodId == null) {
                return;
            }
            if (timeline.getIndexOfPeriod(mediaPeriodId.periodUid) != -1) {
                builder.put(mediaPeriodId, timeline);
                return;
            }
            Timeline timeline2 = this.mediaPeriodTimelines.get(mediaPeriodId);
            if (timeline2 != null) {
                builder.put(mediaPeriodId, timeline2);
            }
        }

        private static MediaSource.MediaPeriodId findCurrentPlayerMediaPeriodInQueue(Player player, ImmutableList<MediaSource.MediaPeriodId> immutableList, MediaSource.MediaPeriodId mediaPeriodId, Timeline.Period period) {
            Timeline currentTimeline = player.getCurrentTimeline();
            int currentPeriodIndex = player.getCurrentPeriodIndex();
            Object uidOfPeriod = currentTimeline.isEmpty() ? null : currentTimeline.getUidOfPeriod(currentPeriodIndex);
            int adGroupIndexAfterPositionUs = (player.isPlayingAd() || currentTimeline.isEmpty()) ? -1 : currentTimeline.getPeriod(currentPeriodIndex, period).getAdGroupIndexAfterPositionUs(C.msToUs(player.getCurrentPosition()) - period.getPositionInWindowUs());
            for (int i = 0; i < immutableList.size(); i++) {
                MediaSource.MediaPeriodId mediaPeriodId2 = immutableList.get(i);
                if (isMatchingMediaPeriod(mediaPeriodId2, uidOfPeriod, player.isPlayingAd(), player.getCurrentAdGroupIndex(), player.getCurrentAdIndexInAdGroup(), adGroupIndexAfterPositionUs)) {
                    return mediaPeriodId2;
                }
            }
            if (immutableList.isEmpty() && mediaPeriodId != null) {
                if (isMatchingMediaPeriod(mediaPeriodId, uidOfPeriod, player.isPlayingAd(), player.getCurrentAdGroupIndex(), player.getCurrentAdIndexInAdGroup(), adGroupIndexAfterPositionUs)) {
                    return mediaPeriodId;
                }
            }
            return null;
        }

        private static boolean isMatchingMediaPeriod(MediaSource.MediaPeriodId mediaPeriodId, Object obj, boolean z, int i, int i2, int i3) {
            if (mediaPeriodId.periodUid.equals(obj)) {
                return (z && mediaPeriodId.adGroupIndex == i && mediaPeriodId.adIndexInAdGroup == i2) || (!z && mediaPeriodId.adGroupIndex == -1 && mediaPeriodId.nextAdGroupIndex == i3);
            }
            return false;
        }
    }
}
