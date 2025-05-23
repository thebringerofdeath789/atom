package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.C0858C;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Assertions;
import com.google.common.collect.Multimap;
import com.google.common.collect.MultimapBuilder;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public final class MergingMediaSource extends CompositeMediaSource<Integer> {
    private static final MediaItem EMPTY_MEDIA_ITEM = new MediaItem.Builder().setMediaId("MergingMediaSource").build();
    private static final int PERIOD_COUNT_UNSET = -1;
    private final boolean adjustPeriodTimeOffsets;
    private final boolean clipDurations;
    private final Map<Object, Long> clippedDurationsUs;
    private final Multimap<Object, ClippingMediaPeriod> clippedMediaPeriods;
    private final CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory;
    private final MediaSource[] mediaSources;
    private IllegalMergeException mergeError;
    private final ArrayList<MediaSource> pendingTimelineSources;
    private int periodCount;
    private long[][] periodTimeOffsetsUs;
    private final Timeline[] timelines;

    public static final class IllegalMergeException extends IOException {
        public static final int REASON_PERIOD_COUNT_MISMATCH = 0;
        public final int reason;

        @Documented
        @Retention(RetentionPolicy.SOURCE)
        public @interface Reason {
        }

        public IllegalMergeException(int i) {
            this.reason = i;
        }
    }

    public MergingMediaSource(MediaSource... mediaSourceArr) {
        this(false, mediaSourceArr);
    }

    public MergingMediaSource(boolean z, MediaSource... mediaSourceArr) {
        this(z, false, mediaSourceArr);
    }

    public MergingMediaSource(boolean z, boolean z2, MediaSource... mediaSourceArr) {
        this(z, z2, new DefaultCompositeSequenceableLoaderFactory(), mediaSourceArr);
    }

    public MergingMediaSource(boolean z, boolean z2, CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory, MediaSource... mediaSourceArr) {
        this.adjustPeriodTimeOffsets = z;
        this.clipDurations = z2;
        this.mediaSources = mediaSourceArr;
        this.compositeSequenceableLoaderFactory = compositeSequenceableLoaderFactory;
        this.pendingTimelineSources = new ArrayList<>(Arrays.asList(mediaSourceArr));
        this.periodCount = -1;
        this.timelines = new Timeline[mediaSourceArr.length];
        this.periodTimeOffsetsUs = new long[0][];
        this.clippedDurationsUs = new HashMap();
        this.clippedMediaPeriods = MultimapBuilder.hashKeys().arrayListValues().build();
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    @Deprecated
    public Object getTag() {
        MediaSource[] mediaSourceArr = this.mediaSources;
        if (mediaSourceArr.length > 0) {
            return mediaSourceArr[0].getTag();
        }
        return null;
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public MediaItem getMediaItem() {
        MediaSource[] mediaSourceArr = this.mediaSources;
        return mediaSourceArr.length > 0 ? mediaSourceArr[0].getMediaItem() : EMPTY_MEDIA_ITEM;
    }

    @Override // com.google.android.exoplayer2.source.CompositeMediaSource, com.google.android.exoplayer2.source.BaseMediaSource
    protected void prepareSourceInternal(TransferListener transferListener) {
        super.prepareSourceInternal(transferListener);
        for (int i = 0; i < this.mediaSources.length; i++) {
            prepareChildSource(Integer.valueOf(i), this.mediaSources[i]);
        }
    }

    @Override // com.google.android.exoplayer2.source.CompositeMediaSource, com.google.android.exoplayer2.source.MediaSource
    public void maybeThrowSourceInfoRefreshError() throws IOException {
        IllegalMergeException illegalMergeException = this.mergeError;
        if (illegalMergeException != null) {
            throw illegalMergeException;
        }
        super.maybeThrowSourceInfoRefreshError();
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public MediaPeriod createPeriod(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator, long j) {
        int length = this.mediaSources.length;
        MediaPeriod[] mediaPeriodArr = new MediaPeriod[length];
        int indexOfPeriod = this.timelines[0].getIndexOfPeriod(mediaPeriodId.periodUid);
        for (int i = 0; i < length; i++) {
            mediaPeriodArr[i] = this.mediaSources[i].createPeriod(mediaPeriodId.copyWithPeriodUid(this.timelines[i].getUidOfPeriod(indexOfPeriod)), allocator, j - this.periodTimeOffsetsUs[indexOfPeriod][i]);
        }
        MergingMediaPeriod mergingMediaPeriod = new MergingMediaPeriod(this.compositeSequenceableLoaderFactory, this.periodTimeOffsetsUs[indexOfPeriod], mediaPeriodArr);
        if (!this.clipDurations) {
            return mergingMediaPeriod;
        }
        ClippingMediaPeriod clippingMediaPeriod = new ClippingMediaPeriod(mergingMediaPeriod, true, 0L, ((Long) Assertions.checkNotNull(this.clippedDurationsUs.get(mediaPeriodId.periodUid))).longValue());
        this.clippedMediaPeriods.put(mediaPeriodId.periodUid, clippingMediaPeriod);
        return clippingMediaPeriod;
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void releasePeriod(MediaPeriod mediaPeriod) {
        if (this.clipDurations) {
            ClippingMediaPeriod clippingMediaPeriod = (ClippingMediaPeriod) mediaPeriod;
            Iterator<Map.Entry<Object, ClippingMediaPeriod>> it = this.clippedMediaPeriods.entries().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry<Object, ClippingMediaPeriod> next = it.next();
                if (next.getValue().equals(clippingMediaPeriod)) {
                    this.clippedMediaPeriods.remove(next.getKey(), next.getValue());
                    break;
                }
            }
            mediaPeriod = clippingMediaPeriod.mediaPeriod;
        }
        MergingMediaPeriod mergingMediaPeriod = (MergingMediaPeriod) mediaPeriod;
        int i = 0;
        while (true) {
            MediaSource[] mediaSourceArr = this.mediaSources;
            if (i >= mediaSourceArr.length) {
                return;
            }
            mediaSourceArr[i].releasePeriod(mergingMediaPeriod.getChildPeriod(i));
            i++;
        }
    }

    @Override // com.google.android.exoplayer2.source.CompositeMediaSource, com.google.android.exoplayer2.source.BaseMediaSource
    protected void releaseSourceInternal() {
        super.releaseSourceInternal();
        Arrays.fill(this.timelines, (Object) null);
        this.periodCount = -1;
        this.mergeError = null;
        this.pendingTimelineSources.clear();
        Collections.addAll(this.pendingTimelineSources, this.mediaSources);
    }

    @Override // com.google.android.exoplayer2.source.CompositeMediaSource
    /* renamed from: onChildSourceInfoRefreshed, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    protected void lambda$prepareChildSource$0$CompositeMediaSource(Integer num, MediaSource mediaSource, Timeline timeline) {
        if (this.mergeError != null) {
            return;
        }
        if (this.periodCount == -1) {
            this.periodCount = timeline.getPeriodCount();
        } else if (timeline.getPeriodCount() != this.periodCount) {
            this.mergeError = new IllegalMergeException(0);
            return;
        }
        if (this.periodTimeOffsetsUs.length == 0) {
            this.periodTimeOffsetsUs = (long[][]) Array.newInstance((Class<?>) long.class, this.periodCount, this.timelines.length);
        }
        this.pendingTimelineSources.remove(mediaSource);
        this.timelines[num.intValue()] = timeline;
        if (this.pendingTimelineSources.isEmpty()) {
            if (this.adjustPeriodTimeOffsets) {
                computePeriodTimeOffsets();
            }
            Timeline timeline2 = this.timelines[0];
            if (this.clipDurations) {
                updateClippedDuration();
                timeline2 = new ClippedTimeline(timeline2, this.clippedDurationsUs);
            }
            refreshSourceInfo(timeline2);
        }
    }

    @Override // com.google.android.exoplayer2.source.CompositeMediaSource
    protected MediaSource.MediaPeriodId getMediaPeriodIdForChildMediaPeriodId(Integer num, MediaSource.MediaPeriodId mediaPeriodId) {
        if (num.intValue() == 0) {
            return mediaPeriodId;
        }
        return null;
    }

    private void computePeriodTimeOffsets() {
        Timeline.Period period = new Timeline.Period();
        for (int i = 0; i < this.periodCount; i++) {
            long j = -this.timelines[0].getPeriod(i, period).getPositionInWindowUs();
            int i2 = 1;
            while (true) {
                Timeline[] timelineArr = this.timelines;
                if (i2 < timelineArr.length) {
                    this.periodTimeOffsetsUs[i][i2] = j - (-timelineArr[i2].getPeriod(i, period).getPositionInWindowUs());
                    i2++;
                }
            }
        }
    }

    private void updateClippedDuration() {
        Timeline[] timelineArr;
        Timeline.Period period = new Timeline.Period();
        for (int i = 0; i < this.periodCount; i++) {
            int i2 = 0;
            long j = Long.MIN_VALUE;
            while (true) {
                timelineArr = this.timelines;
                if (i2 >= timelineArr.length) {
                    break;
                }
                long durationUs = timelineArr[i2].getPeriod(i, period).getDurationUs();
                if (durationUs != C0858C.TIME_UNSET) {
                    long j2 = durationUs + this.periodTimeOffsetsUs[i][i2];
                    if (j == Long.MIN_VALUE || j2 < j) {
                        j = j2;
                    }
                }
                i2++;
            }
            Object uidOfPeriod = timelineArr[0].getUidOfPeriod(i);
            this.clippedDurationsUs.put(uidOfPeriod, Long.valueOf(j));
            Iterator<ClippingMediaPeriod> it = this.clippedMediaPeriods.get(uidOfPeriod).iterator();
            while (it.hasNext()) {
                it.next().updateClipping(0L, j);
            }
        }
    }

    private static final class ClippedTimeline extends ForwardingTimeline {
        private final long[] periodDurationsUs;
        private final long[] windowDurationsUs;

        public ClippedTimeline(Timeline timeline, Map<Object, Long> map) {
            super(timeline);
            int windowCount = timeline.getWindowCount();
            this.windowDurationsUs = new long[timeline.getWindowCount()];
            Timeline.Window window = new Timeline.Window();
            for (int i = 0; i < windowCount; i++) {
                this.windowDurationsUs[i] = timeline.getWindow(i, window).durationUs;
            }
            int periodCount = timeline.getPeriodCount();
            this.periodDurationsUs = new long[periodCount];
            Timeline.Period period = new Timeline.Period();
            for (int i2 = 0; i2 < periodCount; i2++) {
                timeline.getPeriod(i2, period, true);
                long longValue = ((Long) Assertions.checkNotNull(map.get(period.uid))).longValue();
                this.periodDurationsUs[i2] = longValue == Long.MIN_VALUE ? period.durationUs : longValue;
                if (period.durationUs != C0858C.TIME_UNSET) {
                    long[] jArr = this.windowDurationsUs;
                    int i3 = period.windowIndex;
                    jArr[i3] = jArr[i3] - (period.durationUs - this.periodDurationsUs[i2]);
                }
            }
        }

        @Override // com.google.android.exoplayer2.source.ForwardingTimeline, com.google.android.exoplayer2.Timeline
        public Timeline.Window getWindow(int i, Timeline.Window window, long j) {
            long j2;
            super.getWindow(i, window, j);
            window.durationUs = this.windowDurationsUs[i];
            if (window.durationUs == C0858C.TIME_UNSET || window.defaultPositionUs == C0858C.TIME_UNSET) {
                j2 = window.defaultPositionUs;
            } else {
                j2 = Math.min(window.defaultPositionUs, window.durationUs);
            }
            window.defaultPositionUs = j2;
            return window;
        }

        @Override // com.google.android.exoplayer2.source.ForwardingTimeline, com.google.android.exoplayer2.Timeline
        public Timeline.Period getPeriod(int i, Timeline.Period period, boolean z) {
            super.getPeriod(i, period, z);
            period.durationUs = this.periodDurationsUs[i];
            return period;
        }
    }
}