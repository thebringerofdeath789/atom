package com.google.android.exoplayer2.source.dash.offline;

import android.net.Uri;
import com.google.android.exoplayer2.C0858C;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.extractor.ChunkIndex;
import com.google.android.exoplayer2.offline.DownloadException;
import com.google.android.exoplayer2.offline.SegmentDownloader;
import com.google.android.exoplayer2.offline.StreamKey;
import com.google.android.exoplayer2.source.dash.DashSegmentIndex;
import com.google.android.exoplayer2.source.dash.DashUtil;
import com.google.android.exoplayer2.source.dash.DashWrappingSegmentIndex;
import com.google.android.exoplayer2.source.dash.manifest.AdaptationSet;
import com.google.android.exoplayer2.source.dash.manifest.DashManifest;
import com.google.android.exoplayer2.source.dash.manifest.DashManifestParser;
import com.google.android.exoplayer2.source.dash.manifest.Period;
import com.google.android.exoplayer2.source.dash.manifest.RangedUri;
import com.google.android.exoplayer2.source.dash.manifest.Representation;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.ParsingLoadable;
import com.google.android.exoplayer2.upstream.cache.CacheDataSource;
import com.google.android.exoplayer2.util.RunnableFutureTask;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class DashDownloader extends SegmentDownloader<DashManifest> {
    @Deprecated
    public DashDownloader(Uri uri, List<StreamKey> list, CacheDataSource.Factory factory) {
        this(uri, list, factory, $$Lambda$PNiE7SuEFxRjAZH7pJpZIFOFjWg.INSTANCE);
    }

    public DashDownloader(MediaItem mediaItem, CacheDataSource.Factory factory) {
        this(mediaItem, factory, $$Lambda$PNiE7SuEFxRjAZH7pJpZIFOFjWg.INSTANCE);
    }

    @Deprecated
    public DashDownloader(Uri uri, List<StreamKey> list, CacheDataSource.Factory factory, Executor executor) {
        this(new MediaItem.Builder().setUri(uri).setStreamKeys(list).build(), factory, executor);
    }

    public DashDownloader(MediaItem mediaItem, CacheDataSource.Factory factory, Executor executor) {
        this(mediaItem, new DashManifestParser(), factory, executor);
    }

    public DashDownloader(MediaItem mediaItem, ParsingLoadable.Parser<DashManifest> parser, CacheDataSource.Factory factory, Executor executor) {
        super(mediaItem, parser, factory, executor);
    }

    @Override // com.google.android.exoplayer2.offline.SegmentDownloader
    protected List<SegmentDownloader.Segment> getSegments(DataSource dataSource, DashManifest dashManifest, boolean z) throws IOException, InterruptedException {
        ArrayList<SegmentDownloader.Segment> arrayList = new ArrayList<>();
        for (int i = 0; i < dashManifest.getPeriodCount(); i++) {
            Period period = dashManifest.getPeriod(i);
            long msToUs = C0858C.msToUs(period.startMs);
            long periodDurationUs = dashManifest.getPeriodDurationUs(i);
            int i2 = 0;
            for (List<AdaptationSet> list = period.adaptationSets; i2 < list.size(); list = list) {
                addSegmentsForAdaptationSet(dataSource, list.get(i2), msToUs, periodDurationUs, z, arrayList);
                i2++;
            }
        }
        return arrayList;
    }

    private void addSegmentsForAdaptationSet(DataSource dataSource, AdaptationSet adaptationSet, long j, long j2, boolean z, ArrayList<SegmentDownloader.Segment> arrayList) throws IOException, InterruptedException {
        DashSegmentIndex segmentIndex;
        AdaptationSet adaptationSet2 = adaptationSet;
        int i = 0;
        while (i < adaptationSet2.representations.size()) {
            Representation representation = adaptationSet2.representations.get(i);
            try {
                segmentIndex = getSegmentIndex(dataSource, adaptationSet2.type, representation, z);
            } catch (IOException e) {
                e = e;
            }
            if (segmentIndex == null) {
                try {
                    throw new DownloadException("Missing segment index");
                } catch (IOException e2) {
                    e = e2;
                    if (!z) {
                        throw e;
                    }
                    i++;
                    adaptationSet2 = adaptationSet;
                }
            } else {
                long segmentCount = segmentIndex.getSegmentCount(j2);
                if (segmentCount == -1) {
                    throw new DownloadException("Unbounded segment index");
                }
                String str = representation.baseUrl;
                RangedUri initializationUri = representation.getInitializationUri();
                if (initializationUri != null) {
                    addSegment(j, str, initializationUri, arrayList);
                }
                RangedUri indexUri = representation.getIndexUri();
                if (indexUri != null) {
                    addSegment(j, str, indexUri, arrayList);
                }
                long firstSegmentNum = segmentIndex.getFirstSegmentNum();
                long j3 = (segmentCount + firstSegmentNum) - 1;
                for (long j4 = firstSegmentNum; j4 <= j3; j4++) {
                    addSegment(j + segmentIndex.getTimeUs(j4), str, segmentIndex.getSegmentUrl(j4), arrayList);
                }
                i++;
                adaptationSet2 = adaptationSet;
            }
        }
    }

    private static void addSegment(long j, String str, RangedUri rangedUri, ArrayList<SegmentDownloader.Segment> arrayList) {
        arrayList.add(new SegmentDownloader.Segment(j, new DataSpec(rangedUri.resolveUri(str), rangedUri.start, rangedUri.length)));
    }

    private DashSegmentIndex getSegmentIndex(final DataSource dataSource, final int i, final Representation representation, boolean z) throws IOException, InterruptedException {
        DashSegmentIndex index = representation.getIndex();
        if (index != null) {
            return index;
        }
        ChunkIndex chunkIndex = (ChunkIndex) execute(new RunnableFutureTask<ChunkIndex, IOException>(this) { // from class: com.google.android.exoplayer2.source.dash.offline.DashDownloader.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.android.exoplayer2.util.RunnableFutureTask
            protected ChunkIndex doWork() throws IOException {
                return DashUtil.loadChunkIndex(dataSource, i, representation);
            }
        }, z);
        if (chunkIndex == null) {
            return null;
        }
        return new DashWrappingSegmentIndex(chunkIndex, representation.presentationTimeOffsetUs);
    }
}