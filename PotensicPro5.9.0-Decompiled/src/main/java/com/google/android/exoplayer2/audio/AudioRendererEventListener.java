package com.google.android.exoplayer2.audio;

import android.os.Handler;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.audio.AudioRendererEventListener;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.decoder.DecoderReuseEvaluation;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;

/* loaded from: classes.dex */
public interface AudioRendererEventListener {
    default void onAudioCodecError(Exception exc) {
    }

    default void onAudioDecoderInitialized(String str, long j, long j2) {
    }

    default void onAudioDecoderReleased(String str) {
    }

    default void onAudioDisabled(DecoderCounters decoderCounters) {
    }

    default void onAudioEnabled(DecoderCounters decoderCounters) {
    }

    @Deprecated
    default void onAudioInputFormatChanged(Format format) {
    }

    default void onAudioInputFormatChanged(Format format, DecoderReuseEvaluation decoderReuseEvaluation) {
    }

    default void onAudioPositionAdvancing(long j) {
    }

    default void onAudioSinkError(Exception exc) {
    }

    default void onAudioUnderrun(int i, long j, long j2) {
    }

    default void onSkipSilenceEnabledChanged(boolean z) {
    }

    public static final class EventDispatcher {
        private final Handler handler;
        private final AudioRendererEventListener listener;

        public EventDispatcher(Handler handler, AudioRendererEventListener audioRendererEventListener) {
            this.handler = audioRendererEventListener != null ? (Handler) Assertions.checkNotNull(handler) : null;
            this.listener = audioRendererEventListener;
        }

        public void enabled(final DecoderCounters decoderCounters) {
            Handler handler = this.handler;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.google.android.exoplayer2.audio.-$$Lambda$AudioRendererEventListener$EventDispatcher$wM6x2yOc7LSRokkOnoNaLS7ezfU
                    @Override // java.lang.Runnable
                    public final void run() {
                        AudioRendererEventListener.EventDispatcher.this.lambda$enabled$0$AudioRendererEventListener$EventDispatcher(decoderCounters);
                    }
                });
            }
        }

        public /* synthetic */ void lambda$enabled$0$AudioRendererEventListener$EventDispatcher(DecoderCounters decoderCounters) {
            ((AudioRendererEventListener) Util.castNonNull(this.listener)).onAudioEnabled(decoderCounters);
        }

        public void decoderInitialized(final String str, final long j, final long j2) {
            Handler handler = this.handler;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.google.android.exoplayer2.audio.-$$Lambda$AudioRendererEventListener$EventDispatcher$q590SjkvmhHa8kO2_7jSOgj6fck
                    @Override // java.lang.Runnable
                    public final void run() {
                        AudioRendererEventListener.EventDispatcher.this.lambda$decoderInitialized$1$AudioRendererEventListener$EventDispatcher(str, j, j2);
                    }
                });
            }
        }

        public /* synthetic */ void lambda$decoderInitialized$1$AudioRendererEventListener$EventDispatcher(String str, long j, long j2) {
            ((AudioRendererEventListener) Util.castNonNull(this.listener)).onAudioDecoderInitialized(str, j, j2);
        }

        public void inputFormatChanged(final Format format, final DecoderReuseEvaluation decoderReuseEvaluation) {
            Handler handler = this.handler;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.google.android.exoplayer2.audio.-$$Lambda$AudioRendererEventListener$EventDispatcher$enhPTF1JVF9YZZj3tQrmMkRorOk
                    @Override // java.lang.Runnable
                    public final void run() {
                        AudioRendererEventListener.EventDispatcher.this.lambda$inputFormatChanged$2$AudioRendererEventListener$EventDispatcher(format, decoderReuseEvaluation);
                    }
                });
            }
        }

        public /* synthetic */ void lambda$inputFormatChanged$2$AudioRendererEventListener$EventDispatcher(Format format, DecoderReuseEvaluation decoderReuseEvaluation) {
            ((AudioRendererEventListener) Util.castNonNull(this.listener)).onAudioInputFormatChanged(format);
            ((AudioRendererEventListener) Util.castNonNull(this.listener)).onAudioInputFormatChanged(format, decoderReuseEvaluation);
        }

        public void positionAdvancing(final long j) {
            Handler handler = this.handler;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.google.android.exoplayer2.audio.-$$Lambda$AudioRendererEventListener$EventDispatcher$rPQMIEv1TAC9H3aCdAImF6IA5GE
                    @Override // java.lang.Runnable
                    public final void run() {
                        AudioRendererEventListener.EventDispatcher.this.lambda$positionAdvancing$3$AudioRendererEventListener$EventDispatcher(j);
                    }
                });
            }
        }

        public /* synthetic */ void lambda$positionAdvancing$3$AudioRendererEventListener$EventDispatcher(long j) {
            ((AudioRendererEventListener) Util.castNonNull(this.listener)).onAudioPositionAdvancing(j);
        }

        public void underrun(final int i, final long j, final long j2) {
            Handler handler = this.handler;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.google.android.exoplayer2.audio.-$$Lambda$AudioRendererEventListener$EventDispatcher$uL_LqpyqiRNhztolJvOX8mV20h4
                    @Override // java.lang.Runnable
                    public final void run() {
                        AudioRendererEventListener.EventDispatcher.this.lambda$underrun$4$AudioRendererEventListener$EventDispatcher(i, j, j2);
                    }
                });
            }
        }

        public /* synthetic */ void lambda$underrun$4$AudioRendererEventListener$EventDispatcher(int i, long j, long j2) {
            ((AudioRendererEventListener) Util.castNonNull(this.listener)).onAudioUnderrun(i, j, j2);
        }

        public void decoderReleased(final String str) {
            Handler handler = this.handler;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.google.android.exoplayer2.audio.-$$Lambda$AudioRendererEventListener$EventDispatcher$qVO9pa_4YLmYUz_tomYMJyAcdFw
                    @Override // java.lang.Runnable
                    public final void run() {
                        AudioRendererEventListener.EventDispatcher.this.lambda$decoderReleased$5$AudioRendererEventListener$EventDispatcher(str);
                    }
                });
            }
        }

        public /* synthetic */ void lambda$decoderReleased$5$AudioRendererEventListener$EventDispatcher(String str) {
            ((AudioRendererEventListener) Util.castNonNull(this.listener)).onAudioDecoderReleased(str);
        }

        public void disabled(final DecoderCounters decoderCounters) {
            decoderCounters.ensureUpdated();
            Handler handler = this.handler;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.google.android.exoplayer2.audio.-$$Lambda$AudioRendererEventListener$EventDispatcher$SvVOQmSfq3q1LJUN9SDh9d7q0YA
                    @Override // java.lang.Runnable
                    public final void run() {
                        AudioRendererEventListener.EventDispatcher.this.lambda$disabled$6$AudioRendererEventListener$EventDispatcher(decoderCounters);
                    }
                });
            }
        }

        public /* synthetic */ void lambda$disabled$6$AudioRendererEventListener$EventDispatcher(DecoderCounters decoderCounters) {
            decoderCounters.ensureUpdated();
            ((AudioRendererEventListener) Util.castNonNull(this.listener)).onAudioDisabled(decoderCounters);
        }

        public void skipSilenceEnabledChanged(final boolean z) {
            Handler handler = this.handler;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.google.android.exoplayer2.audio.-$$Lambda$AudioRendererEventListener$EventDispatcher$4hBzbL1TL33Atjl04akedeXljUY
                    @Override // java.lang.Runnable
                    public final void run() {
                        AudioRendererEventListener.EventDispatcher.this.lambda$skipSilenceEnabledChanged$7$AudioRendererEventListener$EventDispatcher(z);
                    }
                });
            }
        }

        public /* synthetic */ void lambda$skipSilenceEnabledChanged$7$AudioRendererEventListener$EventDispatcher(boolean z) {
            ((AudioRendererEventListener) Util.castNonNull(this.listener)).onSkipSilenceEnabledChanged(z);
        }

        public void audioSinkError(final Exception exc) {
            Handler handler = this.handler;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.google.android.exoplayer2.audio.-$$Lambda$AudioRendererEventListener$EventDispatcher$bleGgwMcLNB0ceG2coTQZmt9LKU
                    @Override // java.lang.Runnable
                    public final void run() {
                        AudioRendererEventListener.EventDispatcher.this.lambda$audioSinkError$8$AudioRendererEventListener$EventDispatcher(exc);
                    }
                });
            }
        }

        public /* synthetic */ void lambda$audioSinkError$8$AudioRendererEventListener$EventDispatcher(Exception exc) {
            ((AudioRendererEventListener) Util.castNonNull(this.listener)).onAudioSinkError(exc);
        }

        public void audioCodecError(final Exception exc) {
            Handler handler = this.handler;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.google.android.exoplayer2.audio.-$$Lambda$AudioRendererEventListener$EventDispatcher$U50ysTRNBEuoHspHobE2jeZXB_I
                    @Override // java.lang.Runnable
                    public final void run() {
                        AudioRendererEventListener.EventDispatcher.this.lambda$audioCodecError$9$AudioRendererEventListener$EventDispatcher(exc);
                    }
                });
            }
        }

        public /* synthetic */ void lambda$audioCodecError$9$AudioRendererEventListener$EventDispatcher(Exception exc) {
            ((AudioRendererEventListener) Util.castNonNull(this.listener)).onAudioCodecError(exc);
        }
    }
}
