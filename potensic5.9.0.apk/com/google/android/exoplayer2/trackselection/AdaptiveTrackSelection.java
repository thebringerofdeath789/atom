package com.google.android.exoplayer2.trackselection;

import com.google.android.exoplayer2.C0858C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.chunk.MediaChunk;
import com.google.android.exoplayer2.source.chunk.MediaChunkIterator;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.util.Clock;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Util;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.collect.Multimap;
import com.google.common.collect.MultimapBuilder;
import com.ipotensic.baselib.netty.Constant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/* loaded from: classes.dex */
public class AdaptiveTrackSelection extends BaseTrackSelection {
    public static final float DEFAULT_BANDWIDTH_FRACTION = 0.7f;
    public static final float DEFAULT_BUFFERED_FRACTION_TO_LIVE_EDGE_FOR_QUALITY_INCREASE = 0.75f;
    public static final int DEFAULT_MAX_DURATION_FOR_QUALITY_DECREASE_MS = 25000;
    public static final int DEFAULT_MIN_DURATION_FOR_QUALITY_INCREASE_MS = 10000;
    public static final int DEFAULT_MIN_DURATION_TO_RETAIN_AFTER_DISCARD_MS = 25000;
    private static final long MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS = 1000;
    private static final String TAG = "AdaptiveTrackSelection";
    private final ImmutableList<AdaptationCheckpoint> adaptationCheckpoints;
    private final float bandwidthFraction;
    private final BandwidthMeter bandwidthMeter;
    private final float bufferedFractionToLiveEdgeForQualityIncrease;
    private final Clock clock;
    private MediaChunk lastBufferEvaluationMediaChunk;
    private long lastBufferEvaluationMs;
    private final long maxDurationForQualityDecreaseUs;
    private final long minDurationForQualityIncreaseUs;
    private final long minDurationToRetainAfterDiscardUs;
    private float playbackSpeed;
    private int reason;
    private int selectedIndex;

    protected boolean canSelectFormat(Format format, int i, long j) {
        return ((long) i) <= j;
    }

    @Override // com.google.android.exoplayer2.trackselection.ExoTrackSelection
    public Object getSelectionData() {
        return null;
    }

    public static class Factory implements ExoTrackSelection.Factory {
        private final float bandwidthFraction;
        private final float bufferedFractionToLiveEdgeForQualityIncrease;
        private final Clock clock;
        private final int maxDurationForQualityDecreaseMs;
        private final int minDurationForQualityIncreaseMs;
        private final int minDurationToRetainAfterDiscardMs;

        public Factory() {
            this(10000, 25000, 25000, 0.7f, 0.75f, Clock.DEFAULT);
        }

        public Factory(int i, int i2, int i3, float f) {
            this(i, i2, i3, f, 0.75f, Clock.DEFAULT);
        }

        public Factory(int i, int i2, int i3, float f, float f2, Clock clock) {
            this.minDurationForQualityIncreaseMs = i;
            this.maxDurationForQualityDecreaseMs = i2;
            this.minDurationToRetainAfterDiscardMs = i3;
            this.bandwidthFraction = f;
            this.bufferedFractionToLiveEdgeForQualityIncrease = f2;
            this.clock = clock;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.android.exoplayer2.trackselection.ExoTrackSelection.Factory
        public final ExoTrackSelection[] createTrackSelections(ExoTrackSelection.Definition[] definitionArr, BandwidthMeter bandwidthMeter, MediaSource.MediaPeriodId mediaPeriodId, Timeline timeline) {
            ExoTrackSelection createAdaptiveTrackSelection;
            ImmutableList adaptationCheckpoints = AdaptiveTrackSelection.getAdaptationCheckpoints(definitionArr);
            ExoTrackSelection[] exoTrackSelectionArr = new ExoTrackSelection[definitionArr.length];
            for (int i = 0; i < definitionArr.length; i++) {
                ExoTrackSelection.Definition definition = definitionArr[i];
                if (definition != null && definition.tracks.length != 0) {
                    if (definition.tracks.length == 1) {
                        createAdaptiveTrackSelection = new FixedTrackSelection(definition.group, definition.tracks[0], definition.type);
                    } else {
                        createAdaptiveTrackSelection = createAdaptiveTrackSelection(definition.group, definition.tracks, definition.type, bandwidthMeter, (ImmutableList) adaptationCheckpoints.get(i));
                    }
                    exoTrackSelectionArr[i] = createAdaptiveTrackSelection;
                }
            }
            return exoTrackSelectionArr;
        }

        protected AdaptiveTrackSelection createAdaptiveTrackSelection(TrackGroup trackGroup, int[] iArr, int i, BandwidthMeter bandwidthMeter, ImmutableList<AdaptationCheckpoint> immutableList) {
            return new AdaptiveTrackSelection(trackGroup, iArr, i, bandwidthMeter, this.minDurationForQualityIncreaseMs, this.maxDurationForQualityDecreaseMs, this.minDurationToRetainAfterDiscardMs, this.bandwidthFraction, this.bufferedFractionToLiveEdgeForQualityIncrease, immutableList, this.clock);
        }
    }

    public AdaptiveTrackSelection(TrackGroup trackGroup, int[] iArr, BandwidthMeter bandwidthMeter) {
        this(trackGroup, iArr, 0, bandwidthMeter, Constant.DELAY_MILLIS, 25000L, 25000L, 0.7f, 0.75f, ImmutableList.m1541of(), Clock.DEFAULT);
    }

    protected AdaptiveTrackSelection(TrackGroup trackGroup, int[] iArr, int i, BandwidthMeter bandwidthMeter, long j, long j2, long j3, float f, float f2, List<AdaptationCheckpoint> list, Clock clock) {
        super(trackGroup, iArr, i);
        if (j3 < j) {
            Log.m1501w(TAG, "Adjusting minDurationToRetainAfterDiscardMs to be at least minDurationForQualityIncreaseMs");
            j3 = j;
        }
        this.bandwidthMeter = bandwidthMeter;
        this.minDurationForQualityIncreaseUs = j * 1000;
        this.maxDurationForQualityDecreaseUs = j2 * 1000;
        this.minDurationToRetainAfterDiscardUs = j3 * 1000;
        this.bandwidthFraction = f;
        this.bufferedFractionToLiveEdgeForQualityIncrease = f2;
        this.adaptationCheckpoints = ImmutableList.copyOf((Collection) list);
        this.clock = clock;
        this.playbackSpeed = 1.0f;
        this.reason = 0;
        this.lastBufferEvaluationMs = C0858C.TIME_UNSET;
    }

    @Override // com.google.android.exoplayer2.trackselection.BaseTrackSelection, com.google.android.exoplayer2.trackselection.ExoTrackSelection
    public void enable() {
        this.lastBufferEvaluationMs = C0858C.TIME_UNSET;
        this.lastBufferEvaluationMediaChunk = null;
    }

    @Override // com.google.android.exoplayer2.trackselection.BaseTrackSelection, com.google.android.exoplayer2.trackselection.ExoTrackSelection
    public void disable() {
        this.lastBufferEvaluationMediaChunk = null;
    }

    @Override // com.google.android.exoplayer2.trackselection.BaseTrackSelection, com.google.android.exoplayer2.trackselection.ExoTrackSelection
    public void onPlaybackSpeed(float f) {
        this.playbackSpeed = f;
    }

    @Override // com.google.android.exoplayer2.trackselection.ExoTrackSelection
    public void updateSelectedTrack(long j, long j2, long j3, List<? extends MediaChunk> list, MediaChunkIterator[] mediaChunkIteratorArr) {
        long elapsedRealtime = this.clock.elapsedRealtime();
        long nextChunkDurationUs = getNextChunkDurationUs(mediaChunkIteratorArr, list);
        int i = this.reason;
        if (i == 0) {
            this.reason = 1;
            this.selectedIndex = determineIdealSelectedIndex(elapsedRealtime, nextChunkDurationUs);
            return;
        }
        int i2 = this.selectedIndex;
        int indexOf = list.isEmpty() ? -1 : indexOf(((MediaChunk) Iterables.getLast(list)).trackFormat);
        if (indexOf != -1) {
            i = ((MediaChunk) Iterables.getLast(list)).trackSelectionReason;
            i2 = indexOf;
        }
        int determineIdealSelectedIndex = determineIdealSelectedIndex(elapsedRealtime, nextChunkDurationUs);
        if (!isBlacklisted(i2, elapsedRealtime)) {
            Format format = getFormat(i2);
            Format format2 = getFormat(determineIdealSelectedIndex);
            if ((format2.bitrate > format.bitrate && j2 < minDurationForQualityIncreaseUs(j3)) || (format2.bitrate < format.bitrate && j2 >= this.maxDurationForQualityDecreaseUs)) {
                determineIdealSelectedIndex = i2;
            }
        }
        if (determineIdealSelectedIndex != i2) {
            i = 3;
        }
        this.reason = i;
        this.selectedIndex = determineIdealSelectedIndex;
    }

    @Override // com.google.android.exoplayer2.trackselection.ExoTrackSelection
    public int getSelectedIndex() {
        return this.selectedIndex;
    }

    @Override // com.google.android.exoplayer2.trackselection.ExoTrackSelection
    public int getSelectionReason() {
        return this.reason;
    }

    @Override // com.google.android.exoplayer2.trackselection.BaseTrackSelection, com.google.android.exoplayer2.trackselection.ExoTrackSelection
    public int evaluateQueueSize(long j, List<? extends MediaChunk> list) {
        long elapsedRealtime = this.clock.elapsedRealtime();
        if (!shouldEvaluateQueueSize(elapsedRealtime, list)) {
            return list.size();
        }
        this.lastBufferEvaluationMs = elapsedRealtime;
        this.lastBufferEvaluationMediaChunk = list.isEmpty() ? null : (MediaChunk) Iterables.getLast(list);
        if (list.isEmpty()) {
            return 0;
        }
        int size = list.size();
        long playoutDurationForMediaDuration = Util.getPlayoutDurationForMediaDuration(list.get(size - 1).startTimeUs - j, this.playbackSpeed);
        long minDurationToRetainAfterDiscardUs = getMinDurationToRetainAfterDiscardUs();
        if (playoutDurationForMediaDuration < minDurationToRetainAfterDiscardUs) {
            return size;
        }
        Format format = getFormat(determineIdealSelectedIndex(elapsedRealtime, getLastChunkDurationUs(list)));
        for (int i = 0; i < size; i++) {
            MediaChunk mediaChunk = list.get(i);
            Format format2 = mediaChunk.trackFormat;
            if (Util.getPlayoutDurationForMediaDuration(mediaChunk.startTimeUs - j, this.playbackSpeed) >= minDurationToRetainAfterDiscardUs && format2.bitrate < format.bitrate && format2.height != -1 && format2.height < 720 && format2.width != -1 && format2.width < 1280 && format2.height < format.height) {
                return i;
            }
        }
        return size;
    }

    protected boolean shouldEvaluateQueueSize(long j, List<? extends MediaChunk> list) {
        long j2 = this.lastBufferEvaluationMs;
        return j2 == C0858C.TIME_UNSET || j - j2 >= 1000 || !(list.isEmpty() || ((MediaChunk) Iterables.getLast(list)).equals(this.lastBufferEvaluationMediaChunk));
    }

    protected long getMinDurationToRetainAfterDiscardUs() {
        return this.minDurationToRetainAfterDiscardUs;
    }

    private int determineIdealSelectedIndex(long j, long j2) {
        long allocatedBandwidth = getAllocatedBandwidth(j2);
        int i = 0;
        for (int i2 = 0; i2 < this.length; i2++) {
            if (j == Long.MIN_VALUE || !isBlacklisted(i2, j)) {
                Format format = getFormat(i2);
                if (canSelectFormat(format, format.bitrate, allocatedBandwidth)) {
                    return i2;
                }
                i = i2;
            }
        }
        return i;
    }

    private long minDurationForQualityIncreaseUs(long j) {
        if (j != C0858C.TIME_UNSET && j <= this.minDurationForQualityIncreaseUs) {
            return (long) (j * this.bufferedFractionToLiveEdgeForQualityIncrease);
        }
        return this.minDurationForQualityIncreaseUs;
    }

    private long getNextChunkDurationUs(MediaChunkIterator[] mediaChunkIteratorArr, List<? extends MediaChunk> list) {
        int i = this.selectedIndex;
        if (i < mediaChunkIteratorArr.length && mediaChunkIteratorArr[i].next()) {
            MediaChunkIterator mediaChunkIterator = mediaChunkIteratorArr[this.selectedIndex];
            return mediaChunkIterator.getChunkEndTimeUs() - mediaChunkIterator.getChunkStartTimeUs();
        }
        for (MediaChunkIterator mediaChunkIterator2 : mediaChunkIteratorArr) {
            if (mediaChunkIterator2.next()) {
                return mediaChunkIterator2.getChunkEndTimeUs() - mediaChunkIterator2.getChunkStartTimeUs();
            }
        }
        return getLastChunkDurationUs(list);
    }

    private long getLastChunkDurationUs(List<? extends MediaChunk> list) {
        if (list.isEmpty()) {
            return C0858C.TIME_UNSET;
        }
        MediaChunk mediaChunk = (MediaChunk) Iterables.getLast(list);
        return (mediaChunk.startTimeUs == C0858C.TIME_UNSET || mediaChunk.endTimeUs == C0858C.TIME_UNSET) ? C0858C.TIME_UNSET : mediaChunk.endTimeUs - mediaChunk.startTimeUs;
    }

    private long getAllocatedBandwidth(long j) {
        long totalAllocatableBandwidth = getTotalAllocatableBandwidth(j);
        if (this.adaptationCheckpoints.isEmpty()) {
            return totalAllocatableBandwidth;
        }
        int i = 1;
        while (i < this.adaptationCheckpoints.size() - 1 && this.adaptationCheckpoints.get(i).totalBandwidth < totalAllocatableBandwidth) {
            i++;
        }
        AdaptationCheckpoint adaptationCheckpoint = this.adaptationCheckpoints.get(i - 1);
        AdaptationCheckpoint adaptationCheckpoint2 = this.adaptationCheckpoints.get(i);
        return adaptationCheckpoint.allocatedBandwidth + ((long) (((totalAllocatableBandwidth - adaptationCheckpoint.totalBandwidth) / (adaptationCheckpoint2.totalBandwidth - adaptationCheckpoint.totalBandwidth)) * (adaptationCheckpoint2.allocatedBandwidth - adaptationCheckpoint.allocatedBandwidth)));
    }

    private long getTotalAllocatableBandwidth(long j) {
        long bitrateEstimate = (long) (this.bandwidthMeter.getBitrateEstimate() * this.bandwidthFraction);
        long timeToFirstByteEstimateUs = this.bandwidthMeter.getTimeToFirstByteEstimateUs();
        if (timeToFirstByteEstimateUs == C0858C.TIME_UNSET || j == C0858C.TIME_UNSET) {
            return (long) (bitrateEstimate / this.playbackSpeed);
        }
        float f = j;
        return (long) ((bitrateEstimate * Math.max((f / this.playbackSpeed) - timeToFirstByteEstimateUs, 0.0f)) / f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ImmutableList<ImmutableList<AdaptationCheckpoint>> getAdaptationCheckpoints(ExoTrackSelection.Definition[] definitionArr) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < definitionArr.length; i++) {
            if (definitionArr[i] != null && definitionArr[i].tracks.length > 1) {
                ImmutableList.Builder builder = ImmutableList.builder();
                builder.add((ImmutableList.Builder) new AdaptationCheckpoint(0L, 0L));
                arrayList.add(builder);
            } else {
                arrayList.add(null);
            }
        }
        long[][] sortedTrackBitrates = getSortedTrackBitrates(definitionArr);
        int[] iArr = new int[sortedTrackBitrates.length];
        long[] jArr = new long[sortedTrackBitrates.length];
        for (int i2 = 0; i2 < sortedTrackBitrates.length; i2++) {
            jArr[i2] = sortedTrackBitrates[i2].length == 0 ? 0L : sortedTrackBitrates[i2][0];
        }
        addCheckpoint(arrayList, jArr);
        ImmutableList<Integer> switchOrder = getSwitchOrder(sortedTrackBitrates);
        for (int i3 = 0; i3 < switchOrder.size(); i3++) {
            int intValue = switchOrder.get(i3).intValue();
            int i4 = iArr[intValue] + 1;
            iArr[intValue] = i4;
            jArr[intValue] = sortedTrackBitrates[intValue][i4];
            addCheckpoint(arrayList, jArr);
        }
        for (int i5 = 0; i5 < definitionArr.length; i5++) {
            if (arrayList.get(i5) != null) {
                jArr[i5] = jArr[i5] * 2;
            }
        }
        addCheckpoint(arrayList, jArr);
        ImmutableList.Builder builder2 = ImmutableList.builder();
        for (int i6 = 0; i6 < arrayList.size(); i6++) {
            ImmutableList.Builder builder3 = (ImmutableList.Builder) arrayList.get(i6);
            builder2.add((ImmutableList.Builder) (builder3 == null ? ImmutableList.m1541of() : builder3.build()));
        }
        return builder2.build();
    }

    private static long[][] getSortedTrackBitrates(ExoTrackSelection.Definition[] definitionArr) {
        long[][] jArr = new long[definitionArr.length][];
        for (int i = 0; i < definitionArr.length; i++) {
            ExoTrackSelection.Definition definition = definitionArr[i];
            if (definition == null) {
                jArr[i] = new long[0];
            } else {
                jArr[i] = new long[definition.tracks.length];
                for (int i2 = 0; i2 < definition.tracks.length; i2++) {
                    jArr[i][i2] = definition.group.getFormat(definition.tracks[i2]).bitrate;
                }
                Arrays.sort(jArr[i]);
            }
        }
        return jArr;
    }

    private static ImmutableList<Integer> getSwitchOrder(long[][] jArr) {
        Multimap build = MultimapBuilder.treeKeys().arrayListValues().build();
        for (int i = 0; i < jArr.length; i++) {
            if (jArr[i].length > 1) {
                int length = jArr[i].length;
                double[] dArr = new double[length];
                int i2 = 0;
                while (true) {
                    double d = 0.0d;
                    if (i2 >= jArr[i].length) {
                        break;
                    }
                    if (jArr[i][i2] != -1) {
                        d = Math.log(jArr[i][i2]);
                    }
                    dArr[i2] = d;
                    i2++;
                }
                int i3 = length - 1;
                double d2 = dArr[i3] - dArr[0];
                int i4 = 0;
                while (i4 < i3) {
                    double d3 = dArr[i4];
                    i4++;
                    build.put(Double.valueOf(d2 == 0.0d ? 1.0d : (((d3 + dArr[i4]) * 0.5d) - dArr[0]) / d2), Integer.valueOf(i));
                }
            }
        }
        return ImmutableList.copyOf(build.values());
    }

    private static void addCheckpoint(List<ImmutableList.Builder<AdaptationCheckpoint>> list, long[] jArr) {
        long j = 0;
        for (long j2 : jArr) {
            j += j2;
        }
        for (int i = 0; i < list.size(); i++) {
            ImmutableList.Builder<AdaptationCheckpoint> builder = list.get(i);
            if (builder != null) {
                builder.add((ImmutableList.Builder<AdaptationCheckpoint>) new AdaptationCheckpoint(j, jArr[i]));
            }
        }
    }

    public static final class AdaptationCheckpoint {
        public final long allocatedBandwidth;
        public final long totalBandwidth;

        public AdaptationCheckpoint(long j, long j2) {
            this.totalBandwidth = j;
            this.allocatedBandwidth = j2;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof AdaptationCheckpoint)) {
                return false;
            }
            AdaptationCheckpoint adaptationCheckpoint = (AdaptationCheckpoint) obj;
            return this.totalBandwidth == adaptationCheckpoint.totalBandwidth && this.allocatedBandwidth == adaptationCheckpoint.allocatedBandwidth;
        }

        public int hashCode() {
            return (((int) this.totalBandwidth) * 31) + ((int) this.allocatedBandwidth);
        }
    }
}