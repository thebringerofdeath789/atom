package com.google.android.exoplayer2.video;

import android.os.Handler;
import android.os.SystemClock;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.decoder.DecoderReuseEvaluation;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.VideoRendererEventListener;

/* loaded from: classes.dex */
public interface VideoRendererEventListener {
    default void onDroppedFrames(int i, long j) {
    }

    default void onRenderedFirstFrame(Object obj, long j) {
    }

    default void onVideoCodecError(Exception exc) {
    }

    default void onVideoDecoderInitialized(String str, long j, long j2) {
    }

    default void onVideoDecoderReleased(String str) {
    }

    default void onVideoDisabled(DecoderCounters decoderCounters) {
    }

    default void onVideoEnabled(DecoderCounters decoderCounters) {
    }

    default void onVideoFrameProcessingOffset(long j, int i) {
    }

    @Deprecated
    default void onVideoInputFormatChanged(Format format) {
    }

    default void onVideoInputFormatChanged(Format format, DecoderReuseEvaluation decoderReuseEvaluation) {
    }

    default void onVideoSizeChanged(VideoSize videoSize) {
    }

    public static final class EventDispatcher {
        private final Handler handler;
        private final VideoRendererEventListener listener;

        public EventDispatcher(Handler handler, VideoRendererEventListener videoRendererEventListener) {
            this.handler = videoRendererEventListener != null ? (Handler) Assertions.checkNotNull(handler) : null;
            this.listener = videoRendererEventListener;
        }

        public void enabled(final DecoderCounters decoderCounters) {
            Handler handler = this.handler;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.google.android.exoplayer2.video.-$$Lambda$VideoRendererEventListener$EventDispatcher$RxBEN-RwvFErOnQM84ZS2H2saCQ
                    @Override // java.lang.Runnable
                    public final void run() {
                        VideoRendererEventListener.EventDispatcher.this.lambda$enabled$0$VideoRendererEventListener$EventDispatcher(decoderCounters);
                    }
                });
            }
        }

        public /* synthetic */ void lambda$enabled$0$VideoRendererEventListener$EventDispatcher(DecoderCounters decoderCounters) {
            ((VideoRendererEventListener) Util.castNonNull(this.listener)).onVideoEnabled(decoderCounters);
        }

        public void decoderInitialized(final String str, final long j, final long j2) {
            Handler handler = this.handler;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.google.android.exoplayer2.video.-$$Lambda$VideoRendererEventListener$EventDispatcher$c5PVgyPI6cEJjS0i6dHp--T5aag
                    @Override // java.lang.Runnable
                    public final void run() {
                        VideoRendererEventListener.EventDispatcher.this.lambda$decoderInitialized$1$VideoRendererEventListener$EventDispatcher(str, j, j2);
                    }
                });
            }
        }

        public /* synthetic */ void lambda$decoderInitialized$1$VideoRendererEventListener$EventDispatcher(String str, long j, long j2) {
            ((VideoRendererEventListener) Util.castNonNull(this.listener)).onVideoDecoderInitialized(str, j, j2);
        }

        public void inputFormatChanged(final Format format, final DecoderReuseEvaluation decoderReuseEvaluation) {
            Handler handler = this.handler;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.google.android.exoplayer2.video.-$$Lambda$VideoRendererEventListener$EventDispatcher$lRgnwRtINjNzTNR52Sx12shHxOA
                    @Override // java.lang.Runnable
                    public final void run() {
                        VideoRendererEventListener.EventDispatcher.this.lambda$inputFormatChanged$2$VideoRendererEventListener$EventDispatcher(format, decoderReuseEvaluation);
                    }
                });
            }
        }

        public /* synthetic */ void lambda$inputFormatChanged$2$VideoRendererEventListener$EventDispatcher(Format format, DecoderReuseEvaluation decoderReuseEvaluation) {
            ((VideoRendererEventListener) Util.castNonNull(this.listener)).onVideoInputFormatChanged(format);
            ((VideoRendererEventListener) Util.castNonNull(this.listener)).onVideoInputFormatChanged(format, decoderReuseEvaluation);
        }

        public void droppedFrames(final int i, final long j) {
            Handler handler = this.handler;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.google.android.exoplayer2.video.-$$Lambda$VideoRendererEventListener$EventDispatcher$b2kGnP5SrIEYRC-Qyhf39twFppI
                    @Override // java.lang.Runnable
                    public final void run() {
                        VideoRendererEventListener.EventDispatcher.this.lambda$droppedFrames$3$VideoRendererEventListener$EventDispatcher(i, j);
                    }
                });
            }
        }

        public /* synthetic */ void lambda$droppedFrames$3$VideoRendererEventListener$EventDispatcher(int i, long j) {
            ((VideoRendererEventListener) Util.castNonNull(this.listener)).onDroppedFrames(i, j);
        }

        public void reportVideoFrameProcessingOffset(final long j, final int i) {
            Handler handler = this.handler;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.google.android.exoplayer2.video.-$$Lambda$VideoRendererEventListener$EventDispatcher$xM5AhFhvkfHyYQYOC6q5mc-L8jg
                    @Override // java.lang.Runnable
                    public final void run() {
                        VideoRendererEventListener.EventDispatcher.this.lambda$reportVideoFrameProcessingOffset$4$VideoRendererEventListener$EventDispatcher(j, i);
                    }
                });
            }
        }

        public /* synthetic */ void lambda$reportVideoFrameProcessingOffset$4$VideoRendererEventListener$EventDispatcher(long j, int i) {
            ((VideoRendererEventListener) Util.castNonNull(this.listener)).onVideoFrameProcessingOffset(j, i);
        }

        public void videoSizeChanged(final VideoSize videoSize) {
            Handler handler = this.handler;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.google.android.exoplayer2.video.-$$Lambda$VideoRendererEventListener$EventDispatcher$i04wPF7sqeF517haiQJIb2PRkco
                    @Override // java.lang.Runnable
                    public final void run() {
                        VideoRendererEventListener.EventDispatcher.this.lambda$videoSizeChanged$5$VideoRendererEventListener$EventDispatcher(videoSize);
                    }
                });
            }
        }

        public /* synthetic */ void lambda$videoSizeChanged$5$VideoRendererEventListener$EventDispatcher(VideoSize videoSize) {
            ((VideoRendererEventListener) Util.castNonNull(this.listener)).onVideoSizeChanged(videoSize);
        }

        public void renderedFirstFrame(final Object obj) {
            if (this.handler != null) {
                final long elapsedRealtime = SystemClock.elapsedRealtime();
                this.handler.post(new Runnable() { // from class: com.google.android.exoplayer2.video.-$$Lambda$VideoRendererEventListener$EventDispatcher$azlRGoldwqUJKmR-1C6fL_uzVUo
                    @Override // java.lang.Runnable
                    public final void run() {
                        VideoRendererEventListener.EventDispatcher.this.lambda$renderedFirstFrame$6$VideoRendererEventListener$EventDispatcher(obj, elapsedRealtime);
                    }
                });
            }
        }

        public /* synthetic */ void lambda$renderedFirstFrame$6$VideoRendererEventListener$EventDispatcher(Object obj, long j) {
            ((VideoRendererEventListener) Util.castNonNull(this.listener)).onRenderedFirstFrame(obj, j);
        }

        public void decoderReleased(final String str) {
            Handler handler = this.handler;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.google.android.exoplayer2.video.-$$Lambda$VideoRendererEventListener$EventDispatcher$EnBzaqjI2qZeskK6CNmjQNAFjM8
                    @Override // java.lang.Runnable
                    public final void run() {
                        VideoRendererEventListener.EventDispatcher.this.lambda$decoderReleased$7$VideoRendererEventListener$EventDispatcher(str);
                    }
                });
            }
        }

        public /* synthetic */ void lambda$decoderReleased$7$VideoRendererEventListener$EventDispatcher(String str) {
            ((VideoRendererEventListener) Util.castNonNull(this.listener)).onVideoDecoderReleased(str);
        }

        public void disabled(final DecoderCounters decoderCounters) {
            decoderCounters.ensureUpdated();
            Handler handler = this.handler;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.google.android.exoplayer2.video.-$$Lambda$VideoRendererEventListener$EventDispatcher$0wEcYr7ztj3ofEMIi0XdztgAhbs
                    @Override // java.lang.Runnable
                    public final void run() {
                        VideoRendererEventListener.EventDispatcher.this.lambda$disabled$8$VideoRendererEventListener$EventDispatcher(decoderCounters);
                    }
                });
            }
        }

        public /* synthetic */ void lambda$disabled$8$VideoRendererEventListener$EventDispatcher(DecoderCounters decoderCounters) {
            decoderCounters.ensureUpdated();
            ((VideoRendererEventListener) Util.castNonNull(this.listener)).onVideoDisabled(decoderCounters);
        }

        public void videoCodecError(final Exception exc) {
            Handler handler = this.handler;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.google.android.exoplayer2.video.-$$Lambda$VideoRendererEventListener$EventDispatcher$Qg02B3kmpoAXTvNOHrUNrrSZ9Nc
                    @Override // java.lang.Runnable
                    public final void run() {
                        VideoRendererEventListener.EventDispatcher.this.lambda$videoCodecError$9$VideoRendererEventListener$EventDispatcher(exc);
                    }
                });
            }
        }

        public /* synthetic */ void lambda$videoCodecError$9$VideoRendererEventListener$EventDispatcher(Exception exc) {
            ((VideoRendererEventListener) Util.castNonNull(this.listener)).onVideoCodecError(exc);
        }
    }
}
