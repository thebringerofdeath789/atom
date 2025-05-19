package com.google.android.exoplayer2;

import com.google.android.exoplayer2.Timeline;
import io.netty.handler.traffic.AbstractTrafficShapingHandler;

/* loaded from: classes.dex */
public class DefaultControlDispatcher implements ControlDispatcher {
    public static final int DEFAULT_FAST_FORWARD_MS = 15000;
    public static final int DEFAULT_REWIND_MS = 5000;
    private static final int MAX_POSITION_FOR_SEEK_TO_PREVIOUS = 3000;
    private long fastForwardIncrementMs;
    private long rewindIncrementMs;
    private final Timeline.Window window;

    public DefaultControlDispatcher() {
        this(AbstractTrafficShapingHandler.DEFAULT_MAX_TIME, 5000L);
    }

    public DefaultControlDispatcher(long j, long j2) {
        this.fastForwardIncrementMs = j;
        this.rewindIncrementMs = j2;
        this.window = new Timeline.Window();
    }

    @Override // com.google.android.exoplayer2.ControlDispatcher
    public boolean dispatchPrepare(Player player) {
        player.prepare();
        return true;
    }

    @Override // com.google.android.exoplayer2.ControlDispatcher
    public boolean dispatchSetPlayWhenReady(Player player, boolean z) {
        player.setPlayWhenReady(z);
        return true;
    }

    @Override // com.google.android.exoplayer2.ControlDispatcher
    public boolean dispatchSeekTo(Player player, int i, long j) {
        player.seekTo(i, j);
        return true;
    }

    @Override // com.google.android.exoplayer2.ControlDispatcher
    public boolean dispatchPrevious(Player player) {
        Timeline currentTimeline = player.getCurrentTimeline();
        if (!currentTimeline.isEmpty() && !player.isPlayingAd()) {
            int currentWindowIndex = player.getCurrentWindowIndex();
            currentTimeline.getWindow(currentWindowIndex, this.window);
            int previousWindowIndex = player.getPreviousWindowIndex();
            boolean z = this.window.isLive() && !this.window.isSeekable;
            if (previousWindowIndex != -1 && (player.getCurrentPosition() <= 3000 || z)) {
                player.seekTo(previousWindowIndex, C.TIME_UNSET);
            } else if (!z) {
                player.seekTo(currentWindowIndex, 0L);
            }
        }
        return true;
    }

    @Override // com.google.android.exoplayer2.ControlDispatcher
    public boolean dispatchNext(Player player) {
        Timeline currentTimeline = player.getCurrentTimeline();
        if (!currentTimeline.isEmpty() && !player.isPlayingAd()) {
            int currentWindowIndex = player.getCurrentWindowIndex();
            currentTimeline.getWindow(currentWindowIndex, this.window);
            int nextWindowIndex = player.getNextWindowIndex();
            if (nextWindowIndex != -1) {
                player.seekTo(nextWindowIndex, C.TIME_UNSET);
            } else if (this.window.isLive() && this.window.isDynamic) {
                player.seekTo(currentWindowIndex, C.TIME_UNSET);
            }
        }
        return true;
    }

    @Override // com.google.android.exoplayer2.ControlDispatcher
    public boolean dispatchRewind(Player player) {
        if (!isRewindEnabled() || !player.isCurrentWindowSeekable()) {
            return true;
        }
        seekToOffset(player, -this.rewindIncrementMs);
        return true;
    }

    @Override // com.google.android.exoplayer2.ControlDispatcher
    public boolean dispatchFastForward(Player player) {
        if (!isFastForwardEnabled() || !player.isCurrentWindowSeekable()) {
            return true;
        }
        seekToOffset(player, this.fastForwardIncrementMs);
        return true;
    }

    @Override // com.google.android.exoplayer2.ControlDispatcher
    public boolean dispatchSetRepeatMode(Player player, int i) {
        player.setRepeatMode(i);
        return true;
    }

    @Override // com.google.android.exoplayer2.ControlDispatcher
    public boolean dispatchSetShuffleModeEnabled(Player player, boolean z) {
        player.setShuffleModeEnabled(z);
        return true;
    }

    @Override // com.google.android.exoplayer2.ControlDispatcher
    public boolean dispatchStop(Player player, boolean z) {
        player.stop(z);
        return true;
    }

    @Override // com.google.android.exoplayer2.ControlDispatcher
    public boolean dispatchSetPlaybackParameters(Player player, PlaybackParameters playbackParameters) {
        player.setPlaybackParameters(playbackParameters);
        return true;
    }

    @Override // com.google.android.exoplayer2.ControlDispatcher
    public boolean isRewindEnabled() {
        return this.rewindIncrementMs > 0;
    }

    @Override // com.google.android.exoplayer2.ControlDispatcher
    public boolean isFastForwardEnabled() {
        return this.fastForwardIncrementMs > 0;
    }

    public long getRewindIncrementMs() {
        return this.rewindIncrementMs;
    }

    public long getFastForwardIncrementMs() {
        return this.fastForwardIncrementMs;
    }

    @Deprecated
    public void setRewindIncrementMs(long j) {
        this.rewindIncrementMs = j;
    }

    @Deprecated
    public void setFastForwardIncrementMs(long j) {
        this.fastForwardIncrementMs = j;
    }

    private static void seekToOffset(Player player, long j) {
        long currentPosition = player.getCurrentPosition() + j;
        long duration = player.getDuration();
        if (duration != C.TIME_UNSET) {
            currentPosition = Math.min(currentPosition, duration);
        }
        player.seekTo(player.getCurrentWindowIndex(), Math.max(currentPosition, 0L));
    }
}
